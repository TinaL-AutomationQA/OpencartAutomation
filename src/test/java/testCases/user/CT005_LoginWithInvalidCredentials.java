package testCases.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class CT005_LoginWithInvalidCredentials extends BaseClass {
	@Test(groups= {"Regression","Master"},description = "Validate login into the Application using invalid credentials") 
	public void LoginWithInvalidCredentials() {
		logger.info("*****Starting CT005_LoginWithInvalidCredentials*****");
		try {
			//Step1:Open Home page, click MyAccount->Login (ER: Navigate to Login page)
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("**Step1:Clicked on Homepage-MyAccount-Login**");
		    hp.validatePageTitle("Account Login");
		    
		   //Step2:Enter invalid email address and password into the 'E-Mail Address' field 
		    LoginPage lg=new LoginPage(driver);
		    lg.inputEmail("xzabc123@gmail.com");
		    lg.inputPassword("xyzabc123");
		    logger.info("**Step2:Enter invalid email address and password into the 'E-Mail Address' field **");
		    
		    lg.clickLoginInloginPage();
		    logger.info("**Step3: Click login button **");
		    lg.validateWarningMsg("Warning: No match for E-Mail Address and/or Password.");
		    logger.info("**Step4: Validate the warning massage **");
		} 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish CT005_LoginWithInvalidCredentials*****");
	}
	}




