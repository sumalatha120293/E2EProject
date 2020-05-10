package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.RegistrationPage;
import pageObjects.LoginPage;
import resources.base;

public class Login extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	public void Login(String Username,String Password) {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getMyaccount().click();
		lp.getLoginbtn().click();
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		
	}
	
	@DataProvider
	public Object[][] positiveData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] positivedata=new Object[2][2];
		//0th row
		positivedata[0][0]="vsl@gmail.com";
		positivedata[0][1]="Lp@absms4";
		//1st row
		positivedata[1][0]="qw1@yahoo.com";
		positivedata[1][1]="qw2020@may";
		
		return positivedata;
	
		
	}
	@Test(dataProvider="positiveData",priority = 1)
	
	public void Login_positve(String Username,String Password) throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
		Login(Username, Password);
		
		String myact = driver.getTitle();
		Assert.assertEquals(myact, "My Account");
		
		
		
		}
	
	@DataProvider
	public Object[][] NegativeData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][2];
		//0th row
		data[0][0]="vsl@gmail.com";
		data[0][1]="Lp@absms43";
		
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		
		
		return data;
		
		}
	
@Test(dataProvider="NegativeData",priority = 2)
	
	public void Login_negative(String Username,String Password) throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
	Login(Username, Password);

		//String myact = driver.getTitle();
		//Assert.assertEquals(myact, "My Account");
		String invalidlogin_text =  driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(invalidlogin_text, "Warning: No match for E-Mail Address and/or Password.");
		
		
		}

	@AfterMethod
	public void teardown()
	{
		
		driver.close();
	
		
	}

	

	
}
