package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class RegistrationPage {

	
	public WebDriver driver;
	
	By MyAccount=By.xpath("//span[@class='caret']");
	By register=By.xpath("//a[contains(text(),'Register')]");
	By Firstname=By.xpath("//input[@name='firstname']");
	By Lastname=By.xpath("//input[@name='lastname']");
	By email=By.xpath("//input[@name='email']");
	By phone=By.xpath("//input[@name='telephone']");
	By password=By.xpath("//input[@name='password']");
	By confirmpwd=By.xpath("//input[@name='confirm']");
	By subscribe_yes=By.xpath("//input[@name='newsletter' and @value='1']");
	By agreecb=By.xpath("//input[@name='agree' and @value='1']");
	By continuebtn=By.xpath("//input[@value='Continue']");
	By registersucecess=By.xpath("//div[@id='content']//p[1]");
	
	
	
	public RegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}



	public WebElement MyAccount()
	{
		return driver.findElement(MyAccount);
	}
	public WebElement register()
	{
		return driver.findElement(register);
	}
	public WebElement Firstname()
	{
		return driver.findElement(Firstname);
	}
	public WebElement Lastname()
	{
		return driver.findElement(Lastname);
	}
	public WebElement email()
	{
		return driver.findElement(email);
	}
	public WebElement phone()
	{
		return driver.findElement(phone);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement confirmpwd()
	{
		return driver.findElement(confirmpwd);
	}
	public WebElement agreecb()
	{
		return driver.findElement(agreecb);
	}
	public WebElement continuebtn()
	{
		return driver.findElement(continuebtn);
	}
	public WebElement subscribe_yes()
	{
		return driver.findElement(subscribe_yes);
	}
	
	public WebElement registersucecess() 
	{
	return driver.findElement(registersucecess);	
	}
	
}
