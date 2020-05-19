package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	
	public WebDriver driver;

	
By Shoppingcart=By.xpath("//span[contains(text(),'Shopping Cart')]");
By shoppingproduct_name=By.xpath("//div[@class='table-responsive']//table//tr/td[2]/a");
By quantity=By.xpath("//div[@class='input-group btn-block']//input");
By update=By.xpath("//i[@class='fa fa-refresh']");
By remove= By.xpath("//i[@class='fa fa-times-circle']");
By usecouponcodelick=By.xpath("//a[contains(text(),'Use Coupon Code ')]");
By coupon=By.xpath("//input[@id='input-coupon']");
By shippinglick =By.xpath("//a[contains(text(),'Estimate Shipping & Taxes ')]");
By country_drdn=By.xpath("//select[@id='input-country']");
By Region_drdn=By.xpath("//select[@id='input-zone']");
By postcode=By.xpath("//input[@id='input-postcode']");
By getquotes=By.xpath("//button[contains(text(),'Get Quotes')]");
By giftcertificatelink=By.xpath("//a[contains(text(),'Use Gift Certificate ')]");
By giftcode= By.xpath("//input[@id='input-voucher']");
By applygift_cert=By.xpath("//input[@id='button-voucher']");
By checkout=By.xpath("//a[contains(text(),'Checkout')]");
By itmes_click=By.xpath("//button[@data-toggle='dropdown']/i[@class='fa fa-shopping-cart']");
By viewcart=By.xpath("//p[@class='text-right']/a[1]");
By checkout_items=By.xpath("//strong[contains(text(),' Checkout')]");
By flatrate=By.xpath("//input[@name='shipping_method']");
By applyshipping=By.xpath("//input[@id='button-shipping']");

public ShoppingCartPage(WebDriver driver) {
	this.driver=driver;
}


public WebElement getShoppingcart() {
	
	return driver.findElement(Shoppingcart);
}

public WebElement getshoppingproduct_name() {
	
	return driver.findElement(shoppingproduct_name);
}

public WebElement getquantity() {
	
	return driver.findElement(quantity);
}

public WebElement getusecouponcodelick() {
	
	return driver.findElement(usecouponcodelick);
}	

public WebElement getcoupon() {

return driver.findElement(coupon);

}
public WebElement getupdate() {
	
	return driver.findElement(update);
}
public WebElement getremove() {
	
	return driver.findElement(remove);
}

public WebElement getshippinglick() {
	
	return driver.findElement(shippinglick);
}

public WebElement getcountry_drdn() {
	
	return driver.findElement(country_drdn);
}
public WebElement getRegion_drdn() {
	
	return driver.findElement(Region_drdn);
}
public WebElement getpostcodes() {
	
	return driver.findElement(postcode);
}

public WebElement getquotes() {
	
	return driver.findElement(getquotes);
}

public WebElement getgiftcertificatelink() {
	
	return driver.findElement(giftcertificatelink);
}

public WebElement getgiftcode() {
	
	return driver.findElement(giftcode);
}

public WebElement getapplygift_cert() {
	
	return driver.findElement(applygift_cert);
}

public WebElement getcheckout() {
	
	return driver.findElement(checkout);
}

public WebElement getitmes_click() {
	
	return driver.findElement(itmes_click);
}
public WebElement getviewcart() {
	
	return driver.findElement(viewcart);
}

public WebElement getcheckout_items() {
	
	return driver.findElement(checkout_items);
}

public WebElement getflatrate() {
	
	return driver.findElement(flatrate);
}

public WebElement getapplyshipping() {
	
	return driver.findElement(applyshipping);
}
}
