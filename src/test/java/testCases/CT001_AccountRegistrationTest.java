package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class CT001_AccountRegistrationTest extends BaseClass{
	//可能会在很多test case都重复使用的代码则可以移到BaseClass里面
	/*WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/");
	    driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}*/
	@Test(groups={"Regression","Master"})
	public void testRegistration()
	{
		logger.info("*****Starting CT001_AccountRegistrationTest*****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*****Clicked on MyAccount Link*****");
		
		hp.clickRegister();
		logger.info("*****Clicked on Register Link*****");
		AccountRegistrationPage ar=new AccountRegistrationPage(driver);
		//因为注册页面，使用重复的邮箱无法再注册，导致test case会失败，所以需要随机的input data
		
		logger.info("*****Providing customer details*****");
		ar.inputFirstName(randomeString().toUpperCase());
		ar.inputLastName(randomeString().toUpperCase());
		ar.inputEmail(randomeString()+"@gmail.com");
		ar.inputTelephone(randomeNumber());
		//因为password是随机生成，不能直接调用随机method，要不然confirm password会和输入的password不一样，所以先把password存在一个string里
		String password=randomeAlphaNumber();
		ar.inputPassword(password);
		ar.inputConfirm(password);
		ar.Agree();
		ar.Continue();
		
		logger.info("*****Validating expected message*****");
		String msg=ar.gerConfirmationMsg();
		String expectedMessage = "Your Account Has Been Created!！";
		Assert.assertEquals(msg, expectedMessage);
		
	    } catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish CT001_AccountRegistrationTest*****");
	}
	
	//在pom.xml文件中加入依赖org.apache.commons
	//创建生成随机字母的method，因为在同一个class，可以直接调用
	//可能会在很多test case都重复使用的代码则可以移到BaseClass里面
	/*public String randomeString()
{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
        return generatedstring;
}
	//生成随机数字
	public String randomeNumber()
	{
			String generatednumber=RandomStringUtils.randomNumeric(10);
	        return generatednumber;
	}
	//生成随机字母数字组合
	public String randomeAlphaNumber()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
	        return (generatedstring+generatednumber);
	}*/
}
