package com.qa.trcrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.trcrm.basepage.BasePage;
import com.qa.trcrm.pages.HomePage;
import com.qa.trcrm.pages.LoginPage;
import com.qa.trcrm.utils.AppConstants;

public class LoginPageTest {

	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage lp;
	HomePage hp;

	@BeforeTest()
	@Parameters({"browser"})
	public void setUp(String browser) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop,browser);
		lp = new LoginPage(driver);
	

	}

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		Assert.assertEquals(lp.getPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 1)
	public void verifySignUpLinkTest()
	{
		Assert.assertTrue(lp.verifySignUPLink());
	}
	@Test(priority = 3)
	public void loginTest() {
		hp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(hp.isLoggedInUser(), prop.getProperty("accountname"));
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}
