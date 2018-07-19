package com.qa.Crmproject.PagesCrm;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Crmproject.TestBase.TestBase;

public class LoginPage extends TestBase{
	

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginBtn;
	
	@FindBy(className = "img-responsive")
	WebElement image;
	
	// Page Factory Constructor
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Action on Webelement
	
	public String loginTitle()
	{
		return driver.getTitle();
	}

	public boolean imageverify()
	{
		return image.isDisplayed();
	}
	
	public HomepageCrm LoginVerify(String un, String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		
		return new HomepageCrm();
	}

	


}
