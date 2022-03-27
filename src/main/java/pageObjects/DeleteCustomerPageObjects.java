package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPageObjects {
public WebDriver driver;
	
	public DeleteCustomerPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='cusid']")
	WebElement custId;
	
	@FindBy(css="input[type='submit']")
	WebElement submit;
	
	public WebElement CustID(){
		return custId;
	}
	
	public WebElement Submit(){
		return submit;
	}

}
