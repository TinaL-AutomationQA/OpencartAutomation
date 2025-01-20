package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 默认超时10秒，可从配置文件读取
        PageFactory.initElements(driver, this);
    }

    // wait for element visible
    protected void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // wait for element Clickable
    protected void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    // click
    protected void clickElement(WebElement element, String elementName) {
        try {
            element.click();
            BaseClass.logger.info("Clicked on '" + elementName + "' successfully.");
        } catch (Exception e) {
            BaseClass.logger.error("Failed to click '" + elementName + "': " + e.getMessage());
            Assert.fail("Unable to click '" + elementName + "'.");
        }
    }

 // Send keys
    protected void enterText(WebElement element, String text, String elementName) {
        try {
            element.sendKeys(text);
            BaseClass.logger.info("Entered text '" + text + "' into '" + elementName + "' successfully.");
        } catch (Exception e) {
            BaseClass.logger.error("Failed to enter text into '" + elementName + "': " + e.getMessage());
            Assert.fail("Unable to enter text into '" + elementName + "'.");
        }
    }
 // Get Text
    protected String getText(WebElement element, String elementName) {
        try {
            String text = element.getText(); 
            BaseClass.logger.info("Retrieved text from '" + elementName + "': " + text);
            return text; 
        } catch (Exception e) {
            BaseClass.logger.error("Failed to retrieve text from '" + elementName + "': " + e.getMessage());
            Assert.fail("Unable to retrieve text from '" + elementName + "'.");
            return null; 
        }
    }
    
    // Get URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Check element present
    public boolean isElementPresent(WebElement element) {
        try {
            waitForElementVisible(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Validate title
    public void validatePageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            BaseClass.logger.info("Page title is correct: " + actualTitle);
        } else {
            BaseClass.logger.error("Page title mismatch. Expected: " + expectedTitle + " | Actual: " + actualTitle);
            Assert.fail("Page title validation failed.");
        }
    }
    
    // Click my Account
    public void clickMyAccount() {
        clickElement(lnkMyaccount, "My Account");
    }

    // Click register
    public void clickRegister() {
        clickElement(lnkRegister, "Register");
    }

    // Click login
    public void clickLogin() {
        clickElement(lnklogin, "Login");
    }

    // Click checkout
    public void clickCheckout() {
        clickElement(bntCheckout, "Checkout");
    }
    
   // Click Contact Us
    public void clickContactUs() {
        clickElement(bntContactUs, "ContactUs");
    }
  // Click Log Out
    public void clickLogOut() {
        clickElement(bntLogOut, "Log Out");
    }
    
    

    // Located element
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement lnklogin;

    @FindBy(xpath = "//span[normalize-space()='Checkout']")
    WebElement bntCheckout;

    @FindBy(xpath = "//i[@class='fa fa-phone']")
    WebElement bntContactUs;
    
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
    WebElement bntLogOut;
}

