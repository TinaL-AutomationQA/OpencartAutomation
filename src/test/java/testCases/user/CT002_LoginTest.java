package testCases.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class CT002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void testLogin()
	{
		logger.info("*****Starting CT002_LoginTest*****");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();;
			logger.info("*****Clicked on Login Link*****");
		
			LoginPage lg=new LoginPage(driver);
			lg.inputEmail(p.getProperty("email"));
			lg.inputPassword(p.getProperty("password"));
			lg.clickLoginInloginPage();
			logger.info("*****Login MyAccount*****");
			
			MyAccountPage ac=new MyAccountPage(driver);
			boolean targetPage=ac.isMyAccountPageExists();
			Assert.assertTrue(targetPage);
			 } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish CT002_LoginTest*****");
	}
	

}
