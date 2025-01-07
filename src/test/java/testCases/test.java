package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/opencart/upload/index.php?route=account/login");
		WebElement username=driver.findElement(By.xpath("//input[@id='input-email']"));
		username.sendKeys("123");
		WebElement password=driver.findElement(By.xpath("//input[@value='Login']"));
		password.click();
		String s=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println(s);

	}

}
