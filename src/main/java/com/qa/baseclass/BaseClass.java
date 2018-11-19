package com.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
//	public static Properties prop;
	public static Properties prop = new Properties();
//	InputStream ip = null;
	
	
	public BaseClass(){
		
		System.out.println("********* Random LOGGGG    ######################");
		try {
			prop = new Properties();
			FileInputStream	 ip = new FileInputStream("/Users/apple/Desktop/com.qa.seleniumframework/src/main/java/com/qa/ConfigFile/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		
	} 
	
	public static void initialization(){
		
	
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");

		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");	
			driver = new ChromeDriver(); 
			driver.get(url);
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
//			driver = new FirefoxDriver(); 
		}

}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("/Users/apple/eclipse-workspace/com.qa.seleniumframework");
//		/Users/apple/eclipse-workspace/com.qa.seleniumframework/Screenshots
		
		FileUtils.copyFile(scrFile, new File("/Users/apple/eclipse-workspace/com.qa.seleniumframework/Screenshots/" + ".png"));
	}

	
	
}
