package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public NewContactPageTest() {
		super();
	}
	
	String sheetName1 = "contact1";
	
	@BeforeMethod
	public void setUp() {
		initilization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactsPage = homePage.clickOnContactLink();
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName1);
		return data;
	}
	
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstname, String lastname, String company) {
		homePage.clickOnNewContactLink();
		//contactsPage.verifyNewContactLink("Mr.", "kishan", "patel", "google");
		contactsPage.verifyNewContactLink(title, firstname, lastname, company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
