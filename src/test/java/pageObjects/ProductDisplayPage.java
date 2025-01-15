package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testBase.BaseClass;

public class ProductDisplayPage extends BasePage {
	public ProductDisplayPage(WebDriver driver)
    {
   	 super(driver);
    }
	@FindBy(xpath="//button[@id='button-cart']") WebElement bntAddToCart;
	@FindBy(xpath="//a[normalize-space()='shopping cart']") WebElement bntShoppingCart;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement altAddToCart;
	
	public void clickAddToCart()
 	{
		bntAddToCart.click();
 	}
	
	public void clickShoppingCart()
 	{
		waitForElementVisible(altAddToCart);
		bntShoppingCart.click();
 	}
	
	public void validateSuccessAddToCartMsg(String expectedMsg) {
		waitForElementVisible(altAddToCart);
    	String actualMsg =altAddToCart.getText();
    	if(actualMsg.equals(expectedMsg))
    	{
    		BaseClass.logger.info("Warning massaage is correct: "+actualMsg);
    	}
    	else
    	{
    		BaseClass.logger.error("Warning massaage mismatch.Expected"+expectedMsg);
    		Assert.fail("Warning massaage failed.");
    	}
    }

	
}