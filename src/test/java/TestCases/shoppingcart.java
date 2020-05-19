package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Searchpage;
import pageObjects.ShoppingCartPage;
import resources.base;

public class shoppingcart extends base {

public WebDriver driver;


	
	public static Logger log =LogManager.getLogger(Registration.class.getName());
@BeforeMethod

public void initialize() throws IOException
{
	
	 driver =initializeDriver();
		
}

@Test(enabled = false)
public void shoppingcartpagetitle() {
	
	driver.get(prop.getProperty("url"));
	ShoppingCartPage scp =  new ShoppingCartPage(driver);
	scp.getShoppingcart().click();
	String shoppingcartpage_title=driver.getTitle();
	Assert.assertEquals(shoppingcartpage_title, "Shopping Cart");

}

@DataProvider
public Iterator<Object[]> gettestdata_wishlistdata() {
	ArrayList<Object[]> testdata_wishlistdata =  utilities.testutil.getdatafromexcel_wishlistdata();
	return testdata_wishlistdata.iterator();
}
@Test(dataProvider = "gettestdata_wishlistdata",enabled=false)
public void Items_addingtocart(String Productname,String wishproduct,String Addtocartfromwishlist,String Removefromwishlist,String Quanity,String couponcode,String country,String state,String postcode,
		String giftcer) throws InterruptedException {
	
	shoppingcartpagetitle();
	
	driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	Searchpage sp =  new Searchpage(driver);
	sp.getsearchbox().sendKeys(Productname);
	sp.getsearchclick().click();
	List<WebElement> search_result =  driver.findElements(By.xpath("//div[@class='row']//a/img"));
	List<WebElement> addtocart_icon = driver.findElements(By.xpath("//div[@class='button-group']//button//span"));
	
	int searchres_count  = search_result.size();
	System.out.println(searchres_count);
	for (int i = 0; i < searchres_count; i++) {
		try {	
		String serachres_text = search_result.get(i).getAttribute("title");
		System.out.println(serachres_text);
	
	  if (serachres_text.equals(wishproduct)) { 
			
			 WebDriverWait wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(search_result.get(i)));
			 
			 
		  Thread.sleep(2000);
		  //search_result.get(i).click(); 
			 
			 
			addtocart_icon.get(i).click(); 
	  		String addtocartmsg =  driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
	  		Assert.assertEquals(addtocartmsg, "Success: You have added " + wishproduct + " to your shopping cart" + "!" + "\n" + "×");
		  }
	 
	  	
	}
	
		catch(StaleElementReferenceException e) {
        }
	
	
}
	

}


	
	/*
	 * @AfterMethod public void teardown() {
	 * 
	 * driver.close(); }
	 */
	 


}

