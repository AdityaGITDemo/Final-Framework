package com.testcases2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;
import resources.ExcelUtils;

public class LoginPage extends Base {	
	
	public static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void openBrowser() throws IOException{
		
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to login page");
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(){
		driver.close();
	}
	
	@Test(enabled=false)
	public void verifyValidUserLogin() throws Exception{
		
		String expected1="Guru99 Bank Home Page";
		Assert.assertEquals(driver.getTitle(), expected1);
//		if(!(driver.getTitle().equals(expected1)))
//			throw new Exception("Login page not opened successfully.");
//		else
//			System.out.println("Login page opened successfully!");
		
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(prop.getProperty("username"));
		l.Password().sendKeys(prop.getProperty("password"));
		l.LogIn().click();
			
		String expected2="Guru99 Bank Manager HomePage";
		Assert.assertEquals(driver.getTitle(), expected2);
//		if(!(driver.getTitle().equals(expected2)))
//			throw new Exception("Home page not opened successfully.");
//		else
//			System.out.println("Login done and home page opened successfully!");
		log.info("User login verified successfully!");
		HomePageObjects h=new HomePageObjects(driver);
		h.logoutButton().click();
	        driver.switchTo().alert().accept();
	        
	}
	
	@Test(dataProvider="getData",enabled=false)
	public void verifyInvalidUserLogin(String usr,String pwd) throws Exception{
	
		String expected1="Guru99 Bank Home Page";
		//Assert.assertEquals(driver.getTitle(), expected1);
		if(!(driver.getTitle().equals(expected1)))
			throw new Exception("Login page not opened successfully.");
		else
			System.out.println("Login page opened successfully!");
		
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(usr);
		l.Password().sendKeys(pwd);
		l.LogIn().click();
		
		System.out.println("Alert text: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Guru99 Bank Home Page"));
		
		//Assert.assertEquals(driver.getTitle(), expected1);
		String expected2="Guru99 Bank Home Page";
		if(!(driver.getTitle().equals(expected2)))
			throw new Exception("Couldn't return to login page successfully.");
		else
			System.out.println("Invalid username/password message displayed and returned back to login page successfully!");
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Workspace1\\FinalFramework\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		Object[][] data=new Object[3][2];
		data[0][0]=prop.getProperty("username");
		data[0][1]=prop.getProperty("invalidPassword");
		data[1][0]=prop.getProperty("invalidUsername");
		data[1][1]=prop.getProperty("password");
		data[2][0]=prop.getProperty("invalidUsername");
		data[2][1]=prop.getProperty("invalidPassword");
		return data;
	}
	
	@DataProvider
    public Object[][] LoginCred() throws Exception{
         String path=".\\TestData\\LoginData.xlsx";
         ExcelUtils ex=new ExcelUtils(path);
         
         int totalRows=ex.getRowCount("Sheet1");
         int totalCols=ex.getCellCount("Sheet1", 1);
         
         String loginData [][]=new String[totalRows][totalCols];
         
         for(int i=1;i<=totalRows;i++){
        	 for(int j=0;j<totalCols;j++){
        		 loginData[i-1][j]=ex.getCellData("Sheet1", i, j);
        	 }
         }
         return loginData;
		}
	
	@Test(dataProvider="LoginCred",enabled=true)
	public void check2ndDataProvider(String usr,String pwd) throws Exception{
	
		System.out.println("Username: "+usr+" Password: "+pwd);
	}
	
}
