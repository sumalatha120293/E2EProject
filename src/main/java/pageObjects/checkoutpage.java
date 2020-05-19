package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutpage {
	public WebDriver driver;

	
	By Shoppingcart=By.xpath("//span[contains(text(),'Shopping Cart')]");
	

	public checkoutpage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getShoppingcart() {
		
		return driver.findElement(Shoppingcart);
	}

	}
