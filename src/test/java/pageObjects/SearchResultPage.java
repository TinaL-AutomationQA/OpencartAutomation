package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testBase.BaseClass;

public class SearchResultPage extends BasePage {
	public SearchResultPage(WebDriver driver)
    {
   	 super(driver);
    }
	@FindBy(xpath="//a[normalize-space()='iPhone']") WebElement msgProduct;
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]") WebElement bntAddToCart;
	@FindBy(xpath="//img[@title='iPhone']") WebElement imgIphone;

	 public void validateProduct(String expectedProduct) {
	 		waitForElementVisible(msgProduct);
	     	String actualProduct =msgProduct.getText();
	     	if(actualProduct.equals(expectedProduct))
	     	{
	     		BaseClass.logger.info("Product is correct: "+actualProduct);
	     	}
	     	else
	     	{
	     		BaseClass.logger.error("Product mismatch.Expected"+actualProduct);
	     		Assert.fail("Product search failed.");
	     	}
	     	}
	 
	 public void clickAddToCart()
	 	{
		 clickElement(bntAddToCart, "Add To Cart");
	 	}
	 
	 public void clickIphone()
	 	{
		 msgProduct.click();
		 clickElement(msgProduct, "Iphone");
	 	}
	 



}







