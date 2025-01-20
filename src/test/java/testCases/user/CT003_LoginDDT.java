package testCases.user;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class CT003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = utilities.DataProviders.class, groups="DataDriven")//名字和dataprovider class里的名字一样.dataProviderClass当dataprovider不和test case在同一个class的时候需要加这个参数
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("*****Starting CT003_LoginDDT*****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("*****Clicked on Login Link*****");
	
		LoginPage lg=new LoginPage(driver);
		lg.inputEmail(email);
		lg.inputPassword(pwd);
		lg.clickLoginInloginPage();;
		logger.info("*****Login MyAccount*****");
		
		MyAccountPage ac=new MyAccountPage(driver);
		boolean targetPage=ac.isMyAccountPageExists();
	 
		/*Data is valid -login success-test pass-logout
		                 login failed-test fail
		  Data in invalid-login success-test fail-logout
		                 login failed-test pass
		 */
	
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				ac.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				ac.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished CT003_LoginDDT*****");
	}
}
