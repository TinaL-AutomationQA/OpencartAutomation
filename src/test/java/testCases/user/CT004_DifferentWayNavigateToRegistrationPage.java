package testCases.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class CT004_DifferentWayNavigateToRegistrationPage extends BaseClass {
	@Test(groups= {"Sanity","Master"},description = "Verify user can navigate to the registration page from multiple paths") 
	public void NavigateToRegistrationPage() {
		logger.info("*****Starting CT004_DifferentWayNavigateToRegistrationPage*****");
		try {
			//Step1:Open Home page, click MyAccount->Register (ER: Navigate to Register page)
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			logger.info("**Step1:Clicked on Homepage-MyAccount-Register**");
		    hp.validatePageTitle("Register Account");
		    
		   //Step2:Open Registration Page, click MyAccount->Login (ER: Navigate to Login page)
		    AccountRegistrationPage ar=new AccountRegistrationPage(driver);
		    ar.clickMyAccount();
		    ar.clickLogin();
		    logger.info("**Step2:Clicked on Registerpage-MyAccount-login**");
		    ar.validatePageTitle("Account Login");
		    logger.info("Page title validated successfully: Account Login");
		    
		    //Step3:Open Login page, click Continue (ER: Navigate to Register page)
			LoginPage lg=new LoginPage(driver);
			lg.clickContinue();
			logger.info("**Step3:Clicked on Loginpage-Continue**");
			lg.validatePageTitle("Register Account");
			logger.info("Page title validated successfully: Register Account");
			
			//Step4:Repeat step 2 (ER: Navigate to Login page)
			ar.clickMyAccount();
		    ar.clickLogin();
		    logger.info("**Step4:Clicked on Registerpage-MyAccount-login**");
			 
		    //Step5:Click 'Register' option from the Right (ER: Navigate to Register page)
		    lg.clickRegisterOptionFromRight();
		    logger.info("**Step5:Clicked on Loginpage-'Register' option from the Right**");
			lg.validatePageTitle("Register Account");
			logger.info("Page title validated successfully: Register Account");
		    } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish CT004_DifferentWayNavigateToRegistrationPage*****");
	}
	
	}


