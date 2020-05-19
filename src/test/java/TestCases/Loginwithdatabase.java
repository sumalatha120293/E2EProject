package TestCases;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LoginPage;
import resources.base;


public class Loginwithdatabase extends base {
	public WebDriver driver;
	private static String url = "jdbc:mysql://localhost:3306/seleniumtesting";    
	private static String driverName = "com.mysql.jdbc.Driver";   
	private static String username = "root";   
	private static String password = "root";
	private static Connection con;
	private String[][] inputArr;

	@BeforeMethod
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	
	

	public String[][]  readDB() {
		
		
		try {
			Class.forName(driverName);
			try {
				//Create a connection to DB by passing Url,Username,Password as parameters
				con = DriverManager.getConnection(url, username, password);
				Statement stmt=con.createStatement();
				
				//Executing the Queries
				//stmt.executeUpdate("INSERT INTO testDB.employee VALUES ('john',2000)");
				//stmt.executeUpdate("truncate table testDB.employee");
				ResultSet rs = stmt.executeQuery("SELECT * FROM credentials");
				rs.last();
				int rows = rs.getRow();
				 
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				int cols = rsmd.getColumnCount();
				System.out.println(rows +"--" + cols);
				inputArr= new String[rows][cols];

				int i =0;
				rs.beforeFirst();
				//Iterating the data in the Table
				while (rs.next())
				{
					for(int j=0;j<cols;j++)
					{
						inputArr[i][j]=rs.getString(j+1);
						System.out.print("values:: " + inputArr[i][j] +":::"+i +":::"+j); 

					}
					System.out.println();
					i++;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("Failed to create the database connection."); 
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Driver not found."); 
		}
		return inputArr;

	}

	@DataProvider(name="DP")
	public String[][] feedDP()
	{
		String data[][]=readDB();
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
		 
				System.out.println("in for :: " + data[i][j]);
				 
			}
		}
		
		return data;
	}
	@Test(dataProvider="DP")
	public void login(String uname,String pword)
	{
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getMyaccount().click();
		lp.getLoginbtn().click();
		lp.getEmail().sendKeys(uname);
		lp.getPassword().sendKeys(pword);
		lp.getLogin().click();
		String MyAccount =driver.getTitle();
		Assert.assertEquals(MyAccount, "My Account");
	}
	
 
	@AfterMethod
	public void close() {
		driver.close();
	}
}