package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testBase.BaseClass;

public class HomePage extends BasePage{
	
     public HomePage(WebDriver driver)
     {
    	 super(driver);
     }
     @FindBy(xpath="//input[@placeholder='Search']") WebElement txtInputSearch;
     @FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement bntSearch;
     @FindBy(xpath="//a[normalize-space()='iPhone']") WebElement msgProduct;
     
     
     
     public void inputProduct()
     {
 		String product = BaseClass.p.getProperty("searchProductName");
 		txtInputSearch.sendKeys(product);
     }
     public void clickSearch()
 	{
    	 bntSearch.click();
 	}
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
     
     
     
     
     
}
