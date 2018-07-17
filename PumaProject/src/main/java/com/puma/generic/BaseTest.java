package com.puma.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(CustomListener.class)
public class BaseTest implements AutoConstant
{
	public WebDriver driver;
	ExtentReports extent;
	 
	//Opening Application
	
	@BeforeSuite
	public void setUp(){
		extent = new ExtentReports(System.getProperty("user.dir") +"\\reports\\er.html",true);
	}
	@BeforeMethod
	public void openApp()
	{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver=new FirefoxDriver();
		driver.get("https://in.puma.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	//Closing Application
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void tearDown(){
		extent.flush();
	    extent.close();
	}
	
}
