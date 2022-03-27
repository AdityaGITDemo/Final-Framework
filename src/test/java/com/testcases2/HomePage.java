package com.testcases2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;

public class HomePage extends Base{
	
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
	
//	@Test
//	public void verifyUserLogout() throws Exception{
//		
//		LoginPageObjects l=new LoginPageObjects(driver);
//		l.EmailId().sendKeys(prop.getProperty("username"));
//		l.Password().sendKeys(prop.getProperty("password"));
//		l.LogIn().click();
//		
//        HomePageObjects h=new HomePageObjects(driver);
//        h.logoutButton().click(); 
//        
//		System.out.println("Alert text: "+driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//		
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.titleContains("Guru99 Bank Home Page"));
//		
//		String expected1="Guru99 Bank Home Page";
//		//Assert.assertEquals(driver.getTitle(), expected1);
//		if(!(driver.getTitle().equals(expected1)))
//			throw new Exception("Home page not opened successfully.");
//		else
//			System.out.println("Logged out and Returned to login page successfully!");
//	}
//	
//	@Test
//	public void verifyWelcomeMessage() throws Exception{
//		
//		LoginPageObjects l=new LoginPageObjects(driver);
//		l.EmailId().sendKeys(prop.getProperty("username"));
//		l.Password().sendKeys(prop.getProperty("password"));
//		l.LogIn().click();
//		
//        HomePageObjects h=new HomePageObjects(driver);
//		
//        boolean elePresent = h.WelcomeMsg().isDisplayed();
//        //Assert.assertEquals(elePresent, true);
//		if(!(elePresent))
//			throw new Exception("Welcome message is not displayed!");
//		else
//			System.out.println("Welcome message is displayed!");
//        h.logoutButton().click();
//        driver.switchTo().alert().accept();  
//		
//	}
	
	@Test
	public void assertion(){
		 Assert.assertEquals("Aditya", "Abc");

	}
}
