package testCases.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LG_002_LogOutFromRightColumnOptions extends BaseClass{
	@Test(groups= {"Regression","Master"},description = "Validate Logging out by selecting Logout option from 'My Account' dropmenu") 
	public void LogOutFromMyAccount() {
		logger.info("*****Starting TC_LG_002_LogOutFromRightColumnOptions*****");
		try {
			//Step1:Login account 
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();;
			logger.info("*****Clicked on Login Link*****");
		    LoginPage lg=new LoginPage(driver);
		    lg.LoginAccout();
		    logger.info("**Step1:Login account **");
		    //Step2:Logout account
		    MyAccountPage ma=new MyAccountPage(driver);
		    ma.clickMyAccount();
		    ma.clickLogout();
		    logger.info("**Step2: Click Logout button on the right**");
		    //Step3:Validate Logout page title
		    ma.validatePageTitle("Account Logout");
		    logger.info("**Step3: Validate the Logout page title **");
		    //Step4:Click continue
		    AccountLogOutPage al=new AccountLogOutPage(driver);
		    al.clickContinue();
		    al.validatePageTitle("Your Store");
		    logger.info("**Step4: Validate the Home page title **");
		    
		} 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish TC_LG_002_LogOutFromRightColumnOptions*****");
	}
	}



