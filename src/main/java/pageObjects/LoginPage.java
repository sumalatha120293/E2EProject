package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class LoginPage {

	
	public WebDriver driver;
	
	By MyAccount=By.xpath("//span[@class='caret']");
	By Login_btn=By.xpath("//div[@id='top-links']//ul//li/a[contains(text(),'Login')]");
	By email=By.xpath("//input[@name='email']");
	By password=By.xpath("//input[@name='password']");
	By login=By.xpath("//input[@value='Login']");
	
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	public WebElement getMyaccount()
	{
		return driver.findElement(MyAccount);
	}
	
	public WebElement getLoginbtn()
	{
		return driver.findElement(Login_btn);
	}

	

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	
}
