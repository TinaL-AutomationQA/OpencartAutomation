package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//可能会在很多test case都重复使用的代码则可以移到BaseClass里面
public class BaseClass {
	public static WebDriver driver;//add static in step 8
	public Logger logger;//创建对象用来生成log
	public Properties p;//reading common value from the properties file
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browsers"})
	public void setUp(String os,String br) throws IOException
	{
		//reading common value from the properties file
		FileReader file=new FileReader("./src//test//resources/config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());//运行test class生成log，需要在test case里调用log info
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else 
			{
				System.out.println("No matching os");
			return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case"chrome":capabilities.setBrowserName("chrome");break;
			case"edge":capabilities.setBrowserName("MicrosoftEdge");break;
			case"firefox":capabilities.setBrowserName("Firefox");break;
			default:System.out.println("No matcing browser");
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			default:System.out.println("Invalid browser name ");return;//当浏览器不对时，程序终止，无需执行后续code
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL1"));//reading url from properties file
	    driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})  
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString()
	{
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
	        return generatedstring;
	}
		//生成随机数字
		public String randomeNumber()
		{
				String generatednumber=RandomStringUtils.randomNumeric(10);
		        return generatednumber;
		}
		//生成随机字母数字组合
		public String randomeAlphaNumber()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(3);
			String generatednumber=RandomStringUtils.randomNumeric(3);
		        return (generatedstring+generatednumber);
		}
		
		public String captureScreen(String tname) throws IOException
		{
			String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		    TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		    File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		    
		    String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		    File targetFile=new File(targetFilePath);
		    
		    sourceFile.renameTo(targetFile);
		    return targetFilePath;
		}
}