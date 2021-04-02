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

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
	}
	
	@Test(priority=1)
	public void verifyContactLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contactsLable is not showing");
		
	}
	
	@Test(priority=2)
	public void selectContactsNameTest() throws InterruptedException {
		contactsPage.selectContactsByName("Roy Min");
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void validateCreateNewContactTest() {
		homePage.clickOnContactLink();
		contactsPage.verifyNewContactLink("Mr.", "kishan", "patel", "google");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
