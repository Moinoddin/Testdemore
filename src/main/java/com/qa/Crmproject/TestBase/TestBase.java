package com.qa.Crmproject.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.Crmproject.UtilCrm.UtilCrm;
import com.qa.Crmproject.WebEventListner.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Mainuddin\\eclipse-workspace\\CrmProject\\src\\main\\java\\com\\qa\\Crmproject\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) 
		{ e.printStackTrace();}
		catch (IOException e) 
		{e.printStackTrace();}
	}
	
	public void intialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Mozilla FireFox"))
		{
			System.setProperty("WebDriver.FirefoxDriver.geckodriver", "C:\\Users\\Mainuddin\\eclipse-workspace\\geckodriver-master\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilCrm.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilCrm.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
}
