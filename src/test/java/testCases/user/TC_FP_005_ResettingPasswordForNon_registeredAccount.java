package testCases.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_005_ResettingPasswordForNon_registeredAccount extends BaseClass {
	@Test(groups= {"Regression","Master"},description = "Validate an email is sent with the proper details on resetting the password") 
	public void EmailIsSentResetingPassword() {
		logger.info("*****Starting TC_FP_005_ResettingPasswordForNon_registeredAccount*****");
		try {
			//Step1:Open Home page, click MyAccount->Login (ER: Navigate to Login page)
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("**Step1:Clicked on Homepage-MyAccount-Login**");
		    hp.validatePageTitle("Account Login");
		    logger.info("Page title validated successfully: Account Login");
		    
		    //Step2:Open Login page,click forgotten password (ER: Navigate to Register page)
			LoginPage lg=new LoginPage(driver);
			lg.clickForgottenPassworde();;
			logger.info("**Step2:Clicked on Forgotten Password**");
			lg.validatePageTitle("Forgot Your Password?");
			logger.info("Page title validated successfully: Forgot Your Password?");
			
			//Step3:Input Non_registered Email in forgot password page and click continue (ER: A massage show up )
			ForgotPasswordPage fg=new ForgotPasswordPage(driver);
			fg.inputNon_registeredEmail(randomeString()+"@gmail.com");
			fg.clickContinue();
		    logger.info("**Step3:Input Non_registered Email in forgot password page and click continue **");
		    fg.validateEmailNotFoundMsg("Warning: The E-Mail Address was not found in our records, please try again!");;
			logger.info("The E-Mail Address was not found massage validated successfully");
		    } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish TC_FP_005_ResettingPasswordForNon_registeredAccount*****");
	}
	
	}
