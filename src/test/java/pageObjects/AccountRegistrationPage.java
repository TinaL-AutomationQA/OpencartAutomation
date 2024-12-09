package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_inputFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_inputLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_inputEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_inputTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_inputPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_inputConfirm;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_Agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_Continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	
	
	
	  public void inputFirstName(String fname)
	     {
		  txt_inputFirstName.sendKeys(fname);
	     }
	  
	  public void inputLastName(String lname)
	     {
		  txt_inputLastName.sendKeys(lname);
	     }
	  public void inputEmail(String email)
	     {
		  txt_inputEmail.sendKeys(email);
	     }
	  public void inputTelephone(String telephone)
	     {
		  txt_inputTelephone.sendKeys(telephone);
	     }
	  public void inputPassword(String password)
	  {
		  txt_inputPassword.sendKeys(password);
	  }
	  public void inputConfirm(String confirm)
	  {
		  txt_inputConfirm.sendKeys(confirm);
	  }
	  public void Agree()
	  {
		  chk_Agree.click();
	  }
	  public void Continue()
	  {
		  btn_Continue.click();
	  }
	  
	  public String gerConfirmationMsg() {
	  try{
		  return(msgConfirmation.getText());
		  
	  }catch(Exception e) {
		  return(e.getMessage());
	  }
	
	
	
	
	  }
}
