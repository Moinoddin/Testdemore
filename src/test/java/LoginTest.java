
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Crmproject.PagesCrm.HomepageCrm;
import com.qa.Crmproject.PagesCrm.LoginPage;
import com.qa.Crmproject.TestBase.TestBase;

/*
 * 
 * 
 * 
 * 19/07/2018 update
 * 
 * 
 * 
 */




public class LoginTest extends TestBase 
{
	
	LoginPage loginpage;
	HomepageCrm homepage;
	
	public LoginTest() 
	{
		
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		loginpage = new LoginPage();

	}
	
	@Test(priority=1)
	public void loginTitleTest()
	{
		String title = loginpage.loginTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void loginPageImageTest()
	{
		 boolean img = loginpage.imageverify();
		 Assert.assertEquals(img ,true);
	}
	
	@Test(priority = 3)
	public void loginTestCrm()
	{
		homepage = loginpage.LoginVerify(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
