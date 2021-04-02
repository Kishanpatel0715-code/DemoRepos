package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//page factory or Page repository
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//Initialization of page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCorrectUsername() {
		return UserNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactLink() {
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContactLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}
}
