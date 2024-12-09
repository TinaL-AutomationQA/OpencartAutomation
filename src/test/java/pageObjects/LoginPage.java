package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
    {
   	 super(driver);
    }
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtInputEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtInputPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement bntLogin;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement bntContinue;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']") WebElement bntLogin1;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']") WebElement bntRegister;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Forgotten Password']") WebElement bntForgottenPassword;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='My Account']") WebElement bntMyAccount;
	@FindBy(xpath="//a[normalize-space()='Address Book']") WebElement bntAddressBook;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Wish List']") WebElement bntWishList;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Order History']") WebElement bntOrderHistory;
	@FindBy(xpath="//a[normalize-space()='Downloads']") WebElement bntDownloads;
	@FindBy(xpath="//a[normalize-space()='Recurring payments']") WebElement bntRecurringpayments;
	@FindBy(xpath="//a[normalize-space()='Reward Points']") WebElement bntRewardPoints;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Returns']") WebElement bntReturns;
	@FindBy(xpath="//a[normalize-space()='Transactions']") WebElement bntTransactions;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']") WebElement bntNewsletter;
	
	public void InputEmail(String email)
    {
		txtInputEmail.sendKeys(email);
    }
	
	public void InputPassword(String password)
    {
		txtInputPassword.sendKeys(password);
    }
	
	 public void ClickLogin()
	  {
		 bntLogin.click();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
