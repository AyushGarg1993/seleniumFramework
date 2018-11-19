package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class LoginPage extends BaseClass{

	//Page Factory - OR:
			@FindBy(name="username")
			WebElement username;
			
			@FindBy(name="password")
			WebElement password;
			
			@FindBy(xpath="//input[@type='submit']")
			WebElement loginBtn;
			
			@FindBy(xpath="//button[contains(text(),'Sign Up')]")
			WebElement signUpBtn;
			
			@FindBy(xpath="//img[contains(@class,'img-responsive')]")
			WebElement crmLogo;
			
			//Initializing the Page Objects:
			public LoginPage() throws Throwable{
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
			public String validateLoginPageTitle(){
				return driver.getTitle();
			}
			
			public boolean validateCRMImage(){
				return crmLogo.isDisplayed();
			}
	
}
