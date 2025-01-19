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
	
	public void inputFirstName (String fname) {
        enterText(txt_inputFirstName, fname, "FirstName");
    }
	
	public void inputLastName (String lname) {
        enterText(txt_inputLastName, lname, "LastName");
    }
	
	public void inputEmail (String email) {
        enterText(txt_inputEmail, email, "Email");
    }
	
	public void inputTelephone (String telephone) {
        enterText(txt_inputTelephone, telephone, "Telephone");
    }
	
	public void inputPassword (String password) {
        enterText(txt_inputPassword, password, "Password");
    }
	 
    public void inputConfirm(String confirm)
	{
	    enterText(txt_inputConfirm,confirm,"Confirm");
	}
    
	  
    public void Agree() {
        clickElement(chk_Agree, "Agree");
    }
    
    public void Continue() {
        clickElement(btn_Continue, "Agree");
    }
    
	 
	public String gerConfirmationMsg() {
	    return getText(msgConfirmation, "ConfirmationMsg");
	    }
	
	  }

