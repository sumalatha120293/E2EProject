package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
//Adding logs 
//Generating html reports
//Screenshots on failure
//JEnkins integration
public class Registration extends base{
	public WebDriver driver;

	
	public static Logger log =LogManager.getLogger(Registration.class.getName());
@BeforeMethod

public void initialize() throws IOException
{
	
	 driver =initializeDriver();
		
	driver.get(prop.getProperty("url"));
}
	
public void registration(String Firstname,String Lastname,String email,String phone,String password,String confirmpassword) {
	RegistrationPage rp = new RegistrationPage(driver);

	rp.MyAccount().click();
	rp.register().click();
	rp.Firstname().sendKeys(Firstname);
	rp.Lastname().sendKeys(Lastname);
	rp.email().sendKeys(email);
	rp.phone().sendKeys(phone);
	rp.password().sendKeys(password);
	rp.confirmpwd().sendKeys(confirmpassword);
	rp.subscribe_yes().click();
	rp.agreecb().click();
	rp.continuebtn().click();
	
}
@DataProvider
public Iterator<Object[]> gettestdata_Regdata() {
	ArrayList<Object[]> testdata_Regdata =  utilities.testutil.getdatafromexcel_Regdata();
	return testdata_Regdata.iterator();
}
	@Test(dataProvider = "gettestdata_Regdata",priority = 1)
	public void registration_withuniquemail(String Firstname,String Lastname,String email,String phone,String password,String confirmpassword) {
		RegistrationPage rp = new RegistrationPage(driver);

		registration(Firstname, Lastname, email, phone, password, confirmpassword);

		String regsucsmsg = rp.registersucecess().getText();
		
		Assert.assertEquals(regsucsmsg, "Congratulations! Your new account has been successfully created!");
		log.info("Registration tested sucessfully");

		}
	
@Test(dataProvider = "gettestdata_Regdata",priority = 2)
	
	public void registration_withdupliacteemail(String Firstname,String Lastname,String email,String phone,String password,String confirmpassword) {
		
		
	registration(Firstname, Lastname, email, phone, password, confirmpassword);
		
	String email_exists =  driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	
	Assert.assertEquals(email_exists, "Warning: E-Mail Address is already registered!");
}
	
	
	  @AfterMethod
	  
	  public void teardown() {
	  
	  driver.close();
	 
	  
	  }
	 
	
}
