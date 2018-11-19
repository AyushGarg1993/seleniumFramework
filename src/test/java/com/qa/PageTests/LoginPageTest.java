package com.qa.PageTests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Pages.LoginPage;
import com.qa.baseclass.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends BaseClass{
	
	
	LoginPage loginpage;
//	
	public  LoginPageTest() throws Throwable
	{
		super();
	}
//	
	

	
	
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		String url = prop.getProperty("url");
		
		System.out.println("TURLLLLLLLLLLL IS ********** " + url ); 
		
		System.out.println("dkbciueuige iyewg &&&&&&&&&&&&&&&&& hbijdee ");
		initialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() throws IOException{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		
//		takeScreenshotAtEndOfTest();
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
//	
//	
}
