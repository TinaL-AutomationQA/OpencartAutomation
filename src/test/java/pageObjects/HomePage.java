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
     
     
     
     
     public void inputProduct()
     {
 		String product = BaseClass.p.getProperty("searchProductName");
 		txtInputSearch.sendKeys(product);
     }
     public void clickSearch()
 	{
    	 bntSearch.click();
 	}
    
     }
     
     
     
     
     

