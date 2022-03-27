package com.testcases2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BalanceInquiryPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;

public class BalanceInquiryPage extends Base {
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
	
	@Test(enabled=true)
	public void verifyBalanceInquiryPageTitle() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(prop.getProperty("username"));
		l.Password().sendKeys(prop.getProperty("password"));
		l.LogIn().click();
		
        HomePageObjects h=new HomePageObjects(driver);
        h.BalanceEnquiry().click();
		
        String expected="Guru99 Bank Balance Enquiry Page";
        //Assert.assertEquals(driver.getTitle(), expected);
		if(!(driver.getTitle().equals(expected)))
			throw new Exception("Balance Inquiry page not opened successfully.");
		else
			System.out.println("Balance Inquiry page opened successfully!");
	}
	
	@Test(enabled=false)
	public void verifyBalanceInfoTable() throws Exception{
		
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(prop.getProperty("username"));
		l.Password().sendKeys(prop.getProperty("password"));
		l.LogIn().click();
		
        HomePageObjects h=new HomePageObjects(driver);
        h.BalanceEnquiry().click();
		
        String expected="Guru99 Bank Balance Enquiry Page";
        //Assert.assertEquals(driver.getTitle(), expected);
		if(!(driver.getTitle().equals(expected)))
			throw new Exception("Balance Inquiry page not opened successfully.");
		else
			System.out.println("Balance Inquiry page opened successfully!");
		
		BalanceInquiryPageObjects b=new BalanceInquiryPageObjects(driver);
		b.AccNo().sendKeys(prop.getProperty("accNo"));
		b.AccSubmit().click();

		String expected2="Balance Details for Account 97768";
		//Assert.assertEquals(b.TableTitle().getText(), expected2);
		if(!(b.TableTitle().getText().contains(expected2)))
			throw new Exception("Balance Info table not opened successfully.");
		else
			System.out.println("Balance Info table opened successfully!");

	}

}
