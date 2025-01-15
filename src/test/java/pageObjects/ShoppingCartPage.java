package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(WebDriver driver)
    {
   	 super(driver);
    }
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]") WebElement txtProductName;
	@FindBy(xpath="//td[normalize-space()='product 11']") WebElement txtProductModel;
	@FindBy(css="input[value='1']") WebElement txtProductQuantity;

	  public void verifyProductName(String expectedName) {
	        String actualName = txtProductName.getText();
	        Assert.assertEquals(actualName, expectedName, "Product name is incorrect!");
	    }
    
	  public void verifyProductModel(String expectedModel) {
	        String actualModel = txtProductModel.getText();
	        Assert.assertEquals(actualModel, expectedModel, "Product model is incorrect!");
	    }
	
	  public void verifyProductQuantity(String expectedQuantity) {
	        String actualQuantity = txtProductQuantity.getAttribute("value");
	        Assert.assertEquals(actualQuantity, expectedQuantity, "Product quantity is incorrect!");
	    }


	
	
}
