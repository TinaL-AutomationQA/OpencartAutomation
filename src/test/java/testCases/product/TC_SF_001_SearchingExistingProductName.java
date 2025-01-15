package testCases.product;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC_SF_001_SearchingExistingProductName extends BaseClass {
	@Test(groups= {"Regression","Master"},description = "Validate searching with an existing Product Name") 
	public void SearchingExistingProduct() {
		logger.info("*****Starting TC_SF_001_SearchingExistingProductName*****");
		try {
			//Step1:Open Home page, Enter product name 'iphone' into the 'Search' text box field 
			logger.info("**Step1:Open Home page, Enter product name 'iphone' into the 'Search' text box field**");
			HomePage hp=new HomePage(driver);
			hp.inputProduct();
			
			logger.info("**Step2:Click Search**");
			hp.clickSearch();
			
			logger.info("**Step3:Validate the Search Result page title**");
			hp.validatePageTitle("Search - iphone");
			
			logger.info("**Step4:Validate the search result**");
			SearchResultPage sr=new SearchResultPage(driver);
		    sr.validateProduct("iPhone");
		    logger.info("Product validated successfully");
		    
		    } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish TC_SF_001_SearchingExistingProductName*****");
	}
	
	}

