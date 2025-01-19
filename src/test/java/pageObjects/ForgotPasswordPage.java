package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class ForgotPasswordPage extends BasePage {
	public ForgotPasswordPage(WebDriver driver)
    {
   	 super(driver);
    }

	@FindBy(xpath="//input[@id='input-email']") WebElement txtInputEmail;
	@FindBy(xpath="//input[@value='Continue']") WebElement bntContinue;
	
	
	
	public void inputEmail()
    {
		String email = BaseClass.p.getProperty("email");
		enterText(txtInputEmail, email, "InputEmail");
    }
	
	public void clickContinue() {
        clickElement(bntContinue, "Continue");
    }
}
