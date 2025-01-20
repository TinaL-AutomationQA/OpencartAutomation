package testCases.order;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.OrderHistory;
import testBase.BaseClass;

public class TC_OH_007_ValidateContinueButtonInOrderHistory extends BaseClass{
	@Test(groups= {"Regression","Master"},description = "Validate Continue button in the 'Order History' page") 
	public void ValidateContinueButtonInOrderHistory() {
		logger.info("*****Starting TC_OH_007_ValidateContinueButtonInOrderHistory*****");
		try {
			//Step1:Open Home page->My Account->Login,navigate to Account Login page 
			logger.info("**Step1:Open Home page->My Account->Login,navigate to Account Login page**");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			hp.validatePageTitle("Account Login");
			logger.info("**Validate the Account Login page title**");
		    
			//Step2:Click Login, navigate to My Account page 
			logger.info("**Step2:Click Login, navigate to My Account page**");
			LoginPage lg=new LoginPage(driver);
			lg.LoginAccout();
			lg.validatePageTitle("My Account");
			logger.info("**Validate the My Account page title**");
			
			//Step3:Click Order History, navigate to Order History page
			logger.info("**Step3:Click Order History, navigate to Order History page**");
			MyAccountPage mg=new MyAccountPage(driver);
			mg.clickMyAccount();
			mg.clickOrderHistory();
			mg.validatePageTitle("Order History");
			logger.info("**Validate the Order History page title**");
			
			//Step4:Click Continue, navigate to My Account page
			logger.info("**Step4:Click Continue, navigate to My Account page**");
			OrderHistory oh=new OrderHistory(driver);
			oh.clickContinue();
			oh.validatePageTitle("My Account");
			logger.info("**Validate the My Account page title**");
			
		    } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish TC_OH_007_ValidateContinueButtonInOrderHistory*****");
	}
	
}
