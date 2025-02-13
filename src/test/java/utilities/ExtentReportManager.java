package utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    
	String repName;
	public void onStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName ="Test-Report-"+timeStamp+".html";
        sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
        
        sparkReporter.config().setDocumentTitle("opencart Automation Report");//title of the report
        sparkReporter.config().setReportName("opencart Functional Testing");//name of the report
        sparkReporter.config().setTheme(Theme.DARK);
	
        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        
        String os=testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);
        String browser=testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);
        
        List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty())
        {
        	extent.setSystemInfo("Groups", includedGroups.toString());
        	}
        }
	    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()+" - " + result.getMethod().getMethodName());
        String testDescription = result.getMethod().getDescription();
        if (testDescription != null && !testDescription.isEmpty()) {
            test.log(Status.INFO, "Test Description: " + testDescription);
        }

        test.assignCategory(result.getMethod().getGroups());
    }
	
        public void onTestSuccess(ITestResult result)
        {
        	test.assignCategory(result.getMethod().getGroups());
        	test.log(Status.PASS,"Test Case: " + result.getName()+"executed successfully!");
        	
        }
        
        public void onTestFailure(ITestResult result)
        {
        	test.assignCategory(result.getMethod().getGroups());
        	test.log(Status.FAIL,"Test Case: " + result.getName()+"failed");
        	test.log(Status.INFO,"Error Message: "+result.getThrowable().getMessage());
        	
        	try {
        		String imgPath=new BaseClass().captureScreen(result.getName());
        		test.addScreenCaptureFromPath(imgPath);
        	}catch(IOException e1)
        	{
        		e1.printStackTrace();
        	}
        }
        
	    public void onTestSkipped(ITestResult result) {
        	test.assignCategory(result.getMethod().getGroups());
        	test.log(Status.SKIP, "Test Case: " +result.getName()+"was skipped");
        	test.log(Status.INFO,"Error Message: "+result.getThrowable().getMessage());
	    }
	    
	    public void onFinish(ITestContext testContext) {
	        extent.flush();
	        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
	        File extentReport = new File(pathOfExtentReport);
	        try {
	            Desktop.getDesktop().browse(extentReport.toURI());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
            //send the report email
           /* try {
            	URL url=new URL("file///"+System.getProperty("user.dir")+"\\reports\\+repName");
            	//create the email massgge
            	ImageHtmlEmail email=new ImageHtmlEmail();
            	email.setDataSourceResolver(new DataSourceUrlResolver(url));
            	email.setHostName("smtp.goolemail.com");//支持gmail
            	email.setSmtpPort(465);
            	email.setAuthenticator(new DefaultAuthenticator("liut44194@gmail.com","password"));
            	email.setSSLOnConnect(true);
            	email.setFrom("liut44194@gamil.com");//sender
            	email.setSubject("Test Results");
            	email.setMsg("Please find Attached Report.....");
            	email.addTo("test.qagroup@gmail.com");//receiver can add the qa group
            	email.attach(url, "extent report", "please check report");
            	email.send();//send the email
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }*/
        
	    }
	