package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testBase.BaseClass;

public class ForgotPasswordPage extends BasePage {
	public ForgotPasswordPage(WebDriver driver)
    {
   	 super(driver);
    }

	@FindBy(xpath="//input[@id='input-email']") WebElement txtInputEmail;
	@FindBy(xpath="//input[@value='Continue']") WebElement bntContinue;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement msgEmaiNotFound;
	
	
	
	public void inputEmail()
    {
		String email = BaseClass.p.getProperty("email");
		enterText(txtInputEmail, email, "InputEmail");
    }
	
	public void inputNon_registeredEmail(String email)
    {
		enterText(txtInputEmail, email, "InputEmail");
    }
	public void clickContinue() {
        clickElement(bntContinue, "Continue");
    }
	
	public void validateEmailNotFoundMsg(String expectedMsg) {
		waitForElementVisible(msgEmaiNotFound);
    	String actualMsg =msgEmaiNotFound.getText();
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
}
