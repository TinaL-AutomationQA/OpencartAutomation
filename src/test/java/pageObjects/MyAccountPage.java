package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement bntLogout;//add at step 6
	@FindBy(linkText="Login") WebElement login;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Order History']") WebElement bntOrderHistory;
	
	
	
	public boolean isMyAccountPageExists()
	{
		try {
			
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickLogout()
	{
		clickElement(bntLogout, "Logout");
	}
	
	public void clickOrderHistory()
	{
		clickElement(bntOrderHistory, "Order History");
	}
	
	
	
}
