package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addingtowishlistpage {
public WebDriver driver;

	//By wishlist_btn= By.xpath("//span[contains(text(),'Wish List')]");
By wishlist_btn= By.xpath("//a[@id='wishlist-total']/span");

	By Searchbox_wishlist = By.xpath("//input[@name='search']");
	By wishlisticon = By.xpath("//button[@data-original-title='Add to Wish List']");
	By suc_msg=By.xpath("//div[@class='alert alert-success alert-dismissible']");
	By wishlist_continue=By.xpath("//a[contains(text(),'Continue')]");
	By wishlisttable=By.xpath("//div[@class='table-responsive']");
	By addtocart_wishlst = By.xpath("//button[@data-original-title='Add to Cart']");


public Addingtowishlistpage(WebDriver driver) {
	this.driver=driver;
}


public WebElement getsearchbox_wishlist() {
	
	return driver.findElement(Searchbox_wishlist);
}

public WebElement getwishlisticon() {
	
	return driver.findElement(wishlisticon);
}



public WebElement getwishlist_btn() {
	
	return driver.findElement(wishlist_btn);
}	

public WebElement getwishlist_continue() {
	
	return driver.findElement(wishlist_continue);
}
public WebElement getsuc_msg() {
	
	return driver.findElement(suc_msg);
}

 public WebElement getwishlisttable() {
	 return driver.findElement(wishlisttable);
 }

 
 public WebElement getaddtocart_wishlist() {
	 
	 return driver.findElement(addtocart_wishlst);
 }
}
