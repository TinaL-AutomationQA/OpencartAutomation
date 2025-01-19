package testCases.cart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_ATC_001_AddProductToCartFromProductPage extends BaseClass {
	@Test(groups= {"Regression","Master"},description = "Validate adding the product to Cart from 'Product Display' Page") 
	public void AddProductToCartFromProductPage() {
		logger.info("*****Starting TC_ATC_001_AddProductToCartFromProductPage*****");
		try {
			//Step1:Open Home page, Enter product name 'iphone' into the 'Search' text box field 
			logger.info("**Step1:Open Home page, Enter product name 'iphone' into the 'Search' text box field and click search**");
			HomePage hp=new HomePage(driver);
			hp.inputProduct();
			hp.clickSearch();
			
			logger.info("**Step2:Validate the Search Result page title**");
			hp.validatePageTitle("Search - iphone");
			
			logger.info("**Step3:Click on the Product displayed in the Search results**");
			SearchResultPage sr=new SearchResultPage(driver);
		    sr.clickIphone();
		    
		    logger.info("**Validate the Search Result page title**");
		    sr.validatePageTitle("iPhone");
		    
		    logger.info("**Step4:Click Add To Cart in the product display page**");
		    ProductDisplayPage pd=new ProductDisplayPage(driver);
		    pd.clickAddToCart();
		    
		    logger.info("**Step5:Click Shopping Cart link in the displayed success message **");
		    pd.clickShoppingCart();
		    pd.validatePageTitle("Shopping Cart");
		    logger.info("Validated Shopping Cart page title successfully");
		    
		    logger.info("**Step5:Validated add the product to Shopping Cart**");
		    ShoppingCartPage sp=new ShoppingCartPage(driver);
		    sp.verifyProductName("iPhone");
		    sp.verifyProductModel("product 11");
		    sp.verifyProductQuantity("1");
		    
		    
		    } 
		    catch (Exception e) {
	        logger.error("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Test case failed due to exception: " + e.getMessage());
	    }
		logger.info("*****Finish TC_ATC_001_AddProductToCartFromProductPage*****");
	}
	
	}