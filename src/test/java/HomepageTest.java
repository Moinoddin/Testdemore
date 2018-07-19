


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Crmproject.PagesCrm.ContactsPage;
import com.qa.Crmproject.PagesCrm.HomepageCrm;
import com.qa.Crmproject.PagesCrm.LoginPage;
import com.qa.Crmproject.TestBase.TestBase;
import com.qa.Crmproject.UtilCrm.UtilCrm;

	

	public class HomepageTest extends TestBase {
		LoginPage loginPage;
		HomepageCrm homePage;
		UtilCrm testUtil;
		ContactsPage contactsPage;

		public HomepageTest() {
			super();
		}

		//test cases should be separated -- independent with each other
		//before each test case -- launch the browser and login
		//@test -- execute test case
		//after each test case -- close the browser
		
		@BeforeMethod
		public void setUp() {
			intialization();
			testUtil = new UtilCrm();
			contactsPage = new ContactsPage();
			loginPage = new LoginPage();
			homePage = loginPage.LoginVerify(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		
		@Test(priority=1)
		public void verifyHomePageTitleTest(){
			String homePageTitle = homePage.verifyHomePageTitle();
			Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
		}
		
		@Test(priority=2)
		public void verifyUserNameTest(){
			testUtil.switchToFrame();
			Assert.assertTrue(homePage.verifyCorrectUserName());
		}
		
		@Test(priority=3)
		public void verifyContactsLinkTest(){
			testUtil.switchToFrame();
			contactsPage = homePage.clickOnContactsLink();
		}
		
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		

	}
