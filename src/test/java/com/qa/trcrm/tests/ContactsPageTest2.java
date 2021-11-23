package com.qa.trcrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.trcrm.basepage.BasePage;
import com.qa.trcrm.pages.ContactsPage;
import com.qa.trcrm.pages.HomePage;
import com.qa.trcrm.pages.LoginPage;
import com.qa.trcrm.utils.AppConstants;
import com.qa.trcrm.utils.ExcelUtil;

public class ContactsPageTest2 {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeTest
	public void setUp() {
		
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver2(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login");
		contactsPage = homePage.clickOnContacts();
		System.out.println(contactsPage);

	}

	@Test(priority = 1,enabled = true)
	public void verifyContactsPageHeader() {
		String contactPageHeaderVal = contactsPage.getContactsPageHeader();

		Assert.assertEquals(contactPageHeaderVal, AppConstants.CONTACTS_PAGE_HEADER);
	}

//	@DataProvider
//	public Object[][] getContactData() {
//		Object data[][]=ExcelUtil.getTestData(AppConstants.CONTACTS_SHEET_NAME);
//	
//		return data;
//	}
//	@Test(priority = 2,enabled = true, dataProvider ="getContactData")
//	public void verifyDoAddPerson(String Name,String Email) throws InterruptedException {
//		homePage.clickOnContacts();
//		String personAddedVal = contactsPage.doAddPerson(Name, Email);
//		Assert.assertEquals(personAddedVal, AppConstants.CONTACTS_PERSON_ADDED);
//
//	}
	
	@Test
	public void verifyDoAddPerson() throws InterruptedException
	{
		contactsPage.doAddPerson("naveen", "naveen@gmail.com");
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
}
