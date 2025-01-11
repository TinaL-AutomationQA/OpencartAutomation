package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
    {
   	 super(driver);
    }
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtInputEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtInputPassword;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement bntContinue;
	@FindBy(xpath="//input[@value='Login']") WebElement bntLogin;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertWarning;
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']") WebElement bntForgottenPassword;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertEmailSuccess;
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']") WebElement bntLogin1;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']") WebElement bntRegisterRight;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Forgotten Password']") WebElement bntForgottenPassword1;
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
	
	public void inputEmail(String email)
    {
		txtInputEmail.sendKeys(email);
    }
	
	public void inputPassword(String password)
    {
		txtInputPassword.sendKeys(password);
    }
	
	public void clickContinue()
	{
		bntContinue.click();
	}
	
	public void clickLoginInloginPage()
	{
		bntLogin.click();
	}
	 
	public void clickRegisterOptionFromRight()
	{
		bntRegisterRight.click();
	}
	
	public String gerWarningMsg() {
		  try{
			  return(alertWarning.getText());
			  
		  }catch(Exception e) {
			  return(e.getMessage());
		  }
	}
	public void validateWarningMsg(String expectedMsg) {
		waitForElementVisible(alertWarning);
    	String actualMsg =alertWarning.getText();
    	if(actualMsg.equals(expectedMsg))
    	{
    		BaseClass.logger.info("Warning massaage is correct: "+actualMsg);
    	}
    	else
    	{
    		BaseClass.logger.error("Warning massaage mismatch.Expected"+expectedMsg);
    		Assert.fail("Warning massaage failed.");
    	}
    }
	
	public void LoginAccout()
	{
		String email = BaseClass.p.getProperty("email");
		String password=BaseClass.p.getProperty("password");
		inputEmail(email);
		inputPassword(password);
		clickLoginInloginPage();
	}
	
	public void clickForgottenPassworde()
	{
		bntForgottenPassword.click();
	}
	
	
	public void validateEmailSuccessMsg(String expectedEmailMsg) {
		waitForElementVisible(alertEmailSuccess);
    	String actualEmailMsg =alertEmailSuccess.getText();
    	if(actualEmailMsg.equals(expectedEmailMsg))
    	{
    		BaseClass.logger.info("Email massaage is correct: "+actualEmailMsg);
    	}
    	else
    	{
    		BaseClass.logger.error("Email massaage mismatch.Expected"+expectedEmailMsg);
    		Assert.fail("Email massaage failed.");
    	}
    }
	
	
	
	
	
	
	
	
}
	

	
	
	
	
	
	
	

