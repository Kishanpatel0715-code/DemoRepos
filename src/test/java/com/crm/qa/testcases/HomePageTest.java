package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomepageTitleTest() {
		String homePagetitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePagetitle, "CRMPRO", "Home page title is not matched");	
	}
 	
	@Test(priority=2)
	public void validateCorrectUserTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.validateCorrectUsername());
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
