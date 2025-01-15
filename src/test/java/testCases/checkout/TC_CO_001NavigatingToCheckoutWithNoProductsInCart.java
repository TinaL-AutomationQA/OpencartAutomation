package testCases.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_CO_001NavigatingToCheckoutWithNoProductsInCart extends BaseClass {
	@Test(groups= {"Regression","Master"},description = "Validate navigating to Checkout page when there are no products added to the Shopping Cart") 
	public void NavigatingToCheckoutWithNoProductsInCart() {
		logger.info("*****Starting TC_CO_001NavigatingToCheckoutWithNoProductsInCart*****");
		try {
			//Step1:Open Home page, Click Checkout 
			logger.info("**Step1:Open Home page, Click Checkout**");
			HomePage hp=new HomePage(driver);
			hp.clickCheckout();
			hp.validatePageTitle("Shopping Cart");
			logger.info("**Validate the Shopping Cart page title**");
		    
		    } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish TC_ATC_001_AddProductToCartFromProductPage*****");
	}
	
	
	

}
