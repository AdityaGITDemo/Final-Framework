package com.testcases2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.DeleteCustomerPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;

public class DeleteCustomerPage extends Base {
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
	public void verifyDeleteCustPageTitle() throws Exception{
		
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(prop.getProperty("username"));
		l.Password().sendKeys(prop.getProperty("password"));
		l.LogIn().click();
		
        HomePageObjects h=new HomePageObjects(driver);
        h.DeleteCustomer().click();
		
        String expected="Guru99 Bank Delete Customer Page";
        //Assert.assertEquals(driver.getTitle(), expected);
		if(!(driver.getTitle().equals(expected)))
			throw new Exception("Delete customer page not opened successfully.");
		else
			System.out.println("Delete customer page opened successfully!");
	}
	
	@Test(enabled=false)
	public void verifyDeleteForInvalidCustID() throws Exception{
		
		LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(prop.getProperty("username"));
		l.Password().sendKeys(prop.getProperty("password"));
		l.LogIn().click();
		
        HomePageObjects h=new HomePageObjects(driver);
        h.DeleteCustomer().click();
		
        DeleteCustomerPageObjects d=new DeleteCustomerPageObjects(driver);
        d.CustID().sendKeys(prop.getProperty("invalidCustID"));
        d.Submit().click();
        
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		wait.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert text: "+driver.switchTo().alert().getText());
		
		String alertMsg=driver.switchTo().alert().getText();
		//Assert.assertEquals(alertMsg, "You are not authorize to delete this customer!!");
		if(!(alertMsg.contains("You are not authorize to delete this customer!!")))
				throw new Exception("Alert msg not displayed!");
		else{
			System.out.println("Msg displayed!");
			driver.switchTo().alert().accept();
		}
		
		h.logoutButton().click();		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void deleteCustomer(){
		 Assert.assertEquals("Aditya", "Abc");

	}
	

}
