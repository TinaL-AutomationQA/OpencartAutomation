package testCases;

import java.util.ArrayList;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Test1 {
public static void main(String[] args) {
	WebDriver driver=new EdgeDriver();
	driver.get("http://localhost/opencart/upload/");
	WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search']"));
	search.sendKeys("iphone");
	WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	button.click();
	WebElement product=driver.findElement(By.xpath("//a[normalize-space()='iPhone']"));
    String p=product.getText();
    System.out.println(p);
    
    ArrayList <Integer>a=new ArrayList<Integer>();
    a.add(1); 
    a.add(2);
    Vector b=new Vector();
    b.add(1);
    
    


}
}
