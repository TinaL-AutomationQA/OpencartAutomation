package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistory extends BasePage {
	public OrderHistory(WebDriver driver)
    {
   	 super(driver);
    }
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement bntContinue;
	
	public void clickContinue()
 	{
		clickElement(bntContinue, "Continue");
		
 	}
	
}
