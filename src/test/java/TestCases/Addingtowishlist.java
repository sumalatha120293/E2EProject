package TestCases;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Addingtowishlistpage;
import pageObjects.LoginPage;
import pageObjects.Searchpage;
import resources.base;

public class Addingtowishlist  extends base{
	
public WebDriver driver;


	
	public static Logger log =LogManager.getLogger(Registration.class.getName());
@BeforeMethod

public void initialize() throws IOException
{
	
	 driver =initializeDriver();
		
}

@Test(enabled = false)
public void wishlistpage() {
	
	driver.get(prop.getProperty("url"));
	Addingtowishlistpage wp =  new Addingtowishlistpage(driver);

	wp.getwishlist_btn().click();
	String wishlisttitle = driver.getTitle();
	if (wishlisttitle.equals("Account Login")) {
		
		LoginPage lp_wl =  new LoginPage(driver);
		lp_wl.getEmail().sendKeys(prop.getProperty("username"));
		lp_wl.getPassword().sendKeys(prop.getProperty("password"));
		lp_wl.getLogin().click();
		Assert.assertEquals(driver.getTitle(), "My Wish List");
		//wp.getwishlist_continue().click();
		
	}
	
	else {
		//wp.getwishlist_continue().click();
		Assert.assertEquals(driver.getTitle(), "My Wish List");

		
	}
	
	
	}

@DataProvider
public Iterator<Object[]> gettestdata_wishlistdata() {
	ArrayList<Object[]> testdata_wishlistdata =  utilities.testutil.getdatafromexcel_wishlistdata();
	return testdata_wishlistdata.iterator();
}

@Test(dataProvider = "gettestdata_wishlistdata",enabled = false)
public void search_addtowishlist(String Productname,String wishproduct,String Addtocartfromwishlist,String Removefromwishlist) {
	Addingtowishlistpage wp =  new Addingtowishlistpage(driver);

	wishlistpage();
	
	Searchpage sp_wl =  new Searchpage(driver);
	sp_wl.getsearchbox().clear();
	
	sp_wl.getsearchbox().sendKeys(Productname);
	sp_wl.getsearchclick().click();	
	List<WebElement> search_result =  driver.findElements(By.xpath("//div[@class='row']//a/img"));
	//List<WebElement> search_result =  driver.findElements(By.xpath("//div[@class='row']//a[contains(text(),'"+wishproduct+"')]"));
	List<WebElement> wishlist_icon = driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));

	int searchres_count  = search_result.size();
	System.out.println(searchres_count);
	for (int i = 0; i < searchres_count; i++) {
		try {	
		String serachres_text = search_result.get(i).getAttribute("title");
		System.out.println(serachres_text);
	
	  if (serachres_text.equals(wishproduct)) {
		  
			//wp.getwishlisticon().click();
		  wishlist_icon.get(i).click();
	  		String wishlistmsg =  wp.getsuc_msg().getText();
	  		System.out.println(wishlistmsg);
	  		Assert.assertEquals(wishlistmsg, "Success: You have added " + wishproduct + " to your wish list" + "!" + "\n" + "×");
			
			 
		  }
	 
	
	}
	
		catch(StaleElementReferenceException e) {
        }
	
	
}
	


}

	
	 @Test(dataProvider = "gettestdata_wishlistdata") 
	 public void wishlistitems(String Productname,String wishproduct,String Addtocartfromwishlist,String Removefromwishlist) {
	  
	  wishlistpage(); Addingtowishlistpage wp = new Addingtowishlistpage(driver);
	  
	  
	  if (wp.getwishlisttable().isDisplayed()) {
	 
	  List<WebElement> wishlistprosucts = driver.findElements(By.xpath("//div[@class='table-responsive']//table/tbody/tr")); 
	 // List<WebElement> addtocart_items = driver.findElements(By.xpath("//button[@data-original-title='Add to Cart']"));
	  //List<WebElement> addtocart_items = driver.findElements(By.xpath("//div[@class='table-responsive']//table/tbody/tr/td"));
	  List<WebElement> wishlistporducttext_table = driver.findElements(By.xpath("//div[@class='table-responsive']//table/tbody/tr/td/a"));
	  int wishlistproductsno = wishlistprosucts.size(); 
	 // int addtocartitems_iconno = addtocart_items.size();
	  int wishlistporducttext_table_count = wishlistporducttext_table.size();
	//  System.out.println(addtocartitems_iconno);
	  System.out.println(wishlistproductsno);
	 for (int i = 0; i < wishlistproductsno; i++) {
	 
	 String wishlistporducttext = driver.findElement(By.xpath("//div[@class='table-responsive']//table/tbody/tr["+(i+1)+"]/td[@class='text-left']/a")).getText();
	 
	System.out.println(wishlistporducttext);
	 if (wishlistporducttext.equals(wishproduct))
	 {
		
		 if (Addtocartfromwishlist.equals("Yes")) 
		 	{
			 System.out.println("need to add to cart");
			 //wp.getaddtocart_wishlist().click(); 
			 	//addtocart_items.get(i).click();
			 driver.findElement(By.xpath("//div[@class='table-responsive']//table/tbody/tr["+(i+1)+"]/td[6]/button")).click();
			 
		 	}
	 }
		
	 }
	  
	  }
	//  }
	  
	 
	  } 
	  
	 
	 
	 

@AfterMethod
public void close() {
	driver.close();
}
		
}
