package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Searchpage {

	public WebDriver driver;

	
	By Searchbox = By.xpath("//input[@name='search']");
	By searchclick = By.xpath("//button[@class='btn btn-default btn-lg']");
	


public Searchpage(WebDriver driver) {
	this.driver=driver;
}


public WebElement getsearchbox() {
	
	return driver.findElement(Searchbox);
}



public WebElement getsearchclick() {
	// TODO Auto-generated method stub
	return driver.findElement(searchclick);
}
}