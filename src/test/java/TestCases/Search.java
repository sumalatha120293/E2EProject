package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Searchpage;
import resources.base;

public class Search extends base {
	
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
		@BeforeMethod
		public void initialize() throws IOException
		{
		
			 driver =initializeDriver();
				
		}
		@DataProvider
		public Iterator<Object[]> gettestdata_Searchdata() {
			ArrayList<Object[]> testdata_Searchdata =  utilities.testutil.getdatafromexcel_Searchdata();
			return testdata_Searchdata.iterator();
		}
		
		@Test(dataProvider = "gettestdata_Searchdata")
		public void search(String searchuname,String searchpwd,String Searchtext,String product)  throws IOException, InterruptedException  {
			Searchpage sp =  new Searchpage(driver);
			driver.get(prop.getProperty("url"));
			LoginPage lp = new LoginPage(driver);
			lp.getMyaccount().click();
			lp.getLoginbtn().click();
			lp.getEmail().sendKeys(searchuname);
			lp.getPassword().sendKeys(searchpwd);
			lp.getLogin().click();
			

		//	lp_search.initializeDriver();
			sp.getsearchbox().sendKeys(Searchtext);
			log.info("entered the text in search box");
			sp.getsearchclick().click();
			//List<WebElement> search_result =  driver.findElements(By.xpath("//div[@class='row']//a/img"));
			List<WebElement> search_result =  driver.findElements(By.xpath("//div[@class='row']//a[contains(text(),'"+product+"')]"));
			int searchres_count  = search_result.size();
			System.out.println(searchres_count);
			for (int i = 0; i < searchres_count; i++) {
				try {	
				String serachres_text = search_result.get(i).getAttribute("title");
				System.out.println(serachres_text);
			
			  if (serachres_text.equals(product)) { 
					
					 WebDriverWait wait = new WebDriverWait(driver, 60);
					 wait.until(ExpectedConditions.elementToBeClickable(search_result.get(i)));
					 
					 
				  //Thread.sleep(2000);
				  search_result.get(i).click(); 
				  String searchpage = driver.getTitle(); 
				  Assert.assertEquals(searchpage, product); 
				  }
			 
			  	
			}
			
				catch(StaleElementReferenceException e) {
		        }
			
			
		}
			

		}
		
		
		
		
		@AfterMethod
		
		public void close() {
			driver.close();
		}
}
