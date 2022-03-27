package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceInquiryPageObjects {
	
public WebDriver driver;
	
	public BalanceInquiryPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='accountno']")
	WebElement accNo;
	
	@FindBy(css="input[name='AccSubmit']")
	WebElement accSubmit;
	
	@FindBy(css="p[class='heading3']")
	WebElement tableTitle;
	
	public WebElement AccNo(){
		return accNo;
	}
	
	public WebElement AccSubmit(){
		return accSubmit;
	}
	
	public WebElement TableTitle(){
		return tableTitle;
	}

}
