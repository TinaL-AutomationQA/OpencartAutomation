package testCases.other;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_CU_001_NavigatingContactUsFromHeader0ptions extends BaseClass{
	
	@Test(groups= {"Regression","Master"},description = "Validate Continue button in the 'Order History' page") 
	public void NavigatingContactUsFromHeader0ptions() {
		logger.info("*****Starting TC_CU_001_NavigatingContactUsFromHeader0ptions*****");
		try {
			//Step1:Open Home page->Phone icon->navigate to Contact Us page 
			logger.info("**Step1:Open Home page->Phone icon->navigate to Contact Us page**");
			HomePage hp=new HomePage(driver);
			hp.clickContactUs();
			hp.validatePageTitle("Contact Us");
			logger.info("**Validate the Contact Us page title**");
		    
		    } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish TC_CU_001_NavigatingContactUsFromHeader0ptionsy*****");
	}

}
