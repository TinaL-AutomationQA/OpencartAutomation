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

    // get URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // check element exist
    public boolean isElementPresent(WebElement element) {
        try {
            waitForElementVisible(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // validate page title
    public void validatePageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            BaseClass.logger.info("Page title is correct: " + actualTitle);
        } else {
            BaseClass.logger.error("Page title mismatch. Expected: " + expectedTitle + " | Actual: " + actualTitle);
            Assert.fail("Page title validation failed.");
        }
    }

    // click：My Account
    public void clickMyAccount() {
        try {
            waitForElementVisible(lnkMyaccount);
            lnkMyaccount.click();
        } catch (Exception e) {
            BaseClass.logger.error("Failed to click 'My Account' link: " + e.getMessage());
            Assert.fail("Unable to click 'My Account' link.");
        }
    }

    // click：Register
    public void clickRegister() {
        try {
            waitForElementVisible(lnkRegister);
            lnkRegister.click();
        } catch (Exception e) {
            BaseClass.logger.error("Failed to click 'Register' link: " + e.getMessage());
            Assert.fail("Unable to click 'Register' link.");
        }
    }

    // click：Login
    public void clickLogin() {
        try {
            waitForElementVisible(lnklogin);
            lnklogin.click();
        } catch (Exception e) {
            BaseClass.logger.error("Failed to click 'Login' link: " + e.getMessage());
            Assert.fail("Unable to click 'Login' link.");
        }
    }

    // element locator
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement lnklogin;
}
