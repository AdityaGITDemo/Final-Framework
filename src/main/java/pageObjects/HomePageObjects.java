package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
public WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logOut;
	
	@FindBy(css="marquee[behavior='alternate']")
	WebElement welcomeMsg;
	
	@FindBy(css="a[href*='DeleteCustomer']")
	WebElement deleteCust;
	
	@FindBy(css="a[href*='addcustomer']")
	WebElement newCust;
	
	@FindBy(css="a[href*='BalEn']")
	WebElement balanceInqu;
	
	public WebElement logoutButton(){
		return logOut;
	}
	
	public WebElement WelcomeMsg(){
		return welcomeMsg;
	}
	
	public WebElement DeleteCustomer(){
		return deleteCust;
	}
	
	public WebElement NewCustomer(){
		return newCust;
	}
	
	public WebElement BalanceEnquiry(){
		return balanceInqu;
	}
	

}
