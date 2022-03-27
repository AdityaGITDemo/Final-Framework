package com.testcases2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.NewCustomerPageObjects;
import resources.Base;

public class NewCustomerPage extends Base {
	public WebDriver driver;
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
	public void verifyNewCustPageTitle() throws Exception{
		
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(prop.getProperty("username"));
		l.Password().sendKeys(prop.getProperty("password"));
		l.LogIn().click();
		
        HomePageObjects h=new HomePageObjects(driver);	
		h.NewCustomer().click();

		String expected="Guru99 Bank New Customer Entry Page";
		//Assert.assertEquals(driver.getTitle(), expected);
		if(!(driver.getTitle().equals(expected)))
			throw new Exception("New Customer Entry Page not opened successfully.");
		else
			System.out.println("New Customer Entry Page opened successfully!");
		
	}
	
	@Test(enabled=false)
	public void verifyInvalidCustNameMsg() throws Exception{
		
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(prop.getProperty("username"));
		l.Password().sendKeys(prop.getProperty("password"));
		l.LogIn().click();
		
        HomePageObjects h=new HomePageObjects(driver);	
		h.NewCustomer().click();
		
		NewCustomerPageObjects n=new NewCustomerPageObjects(driver);
		n.CustName().sendKeys("@");
		//Assert.assertTrue(n.InvalidCustNameMsg().isDisplayed());
		if(!(n.InvalidCustNameMsg().isDisplayed()))
			throw new Exception("Msg for invalid cust name not displayed!");
		else
			System.out.println("Msg displayed!");
		
		h.logoutButton().click();		
		driver.switchTo().alert().accept();
		
	}
	
	@Test
	public void assertion(){
		 Assert.assertEquals("Aditya", "Abc");

	}
	

}
