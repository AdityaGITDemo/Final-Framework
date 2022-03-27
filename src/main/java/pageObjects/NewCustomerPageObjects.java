package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPageObjects {
	public WebDriver driver;
	public NewCustomerPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='name']")
	WebElement custName;
	
	@FindBy(css="label[id='message']")
	WebElement invalidCustNameMsg;
	
	public WebElement CustName(){
		return custName;
	}
	
	public WebElement InvalidCustNameMsg(){
		return invalidCustNameMsg;
	}

}
