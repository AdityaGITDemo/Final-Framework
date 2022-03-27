package stepDefinitions;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;

public class StepDefination extends Base {
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
		driver.manage().window().maximize();
    }
	
	@Given("^navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
		String expected1="Guru99 Bank Home Page";
		if(!(driver.getTitle().equals(expected1)))
			throw new Exception("Login page not opened successfully.");
		else
			System.out.println("Login page opened successfully!");
    }

    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and log in$")
    public void user_enters_something_and_something_and_log_in(String strArg1, String strArg2) throws Throwable {
    	LoginPageObjects l=new LoginPageObjects(driver);
		l.EmailId().sendKeys(strArg1);
		l.Password().sendKeys(strArg2);
		l.LogIn().click();
    }

    @Then("^verified that user has successfully logged in and then log out and close the browser$")
    public void verified_that_user_has_successfully_logged_in_and_then_log_out_and_close_the_browser() throws Throwable {
    	String expected2="Guru99 Bank Manager HomePage";
		if(!(driver.getTitle().equals(expected2)))
			throw new Exception("Home page not opened successfully.");
		else
			System.out.println("Login done and home page opened successfully!");
		HomePageObjects h=new HomePageObjects(driver);
		h.logoutButton().click();
	        driver.switchTo().alert().accept();
	        driver.close();
    }
    
    }
    
    
