package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(css="input[name=btnLogin]")
	WebElement login;
	
	public WebElement EmailId(){
		return userName;
	}
	
	public WebElement Password(){
		return passWord;
	}
	
	public WebElement LogIn(){
		return login;
	}

}
