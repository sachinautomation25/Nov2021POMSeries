package com.qa.trcrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.trcrm.basepage.BasePage;
import com.qa.trcrm.pages.HomePage;
import com.qa.trcrm.pages.LoginPage;
import com.qa.trcrm.utils.AppConstants;

public class HomePageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_prop();
		driver=basePage.init_driver2(prop);
		lp=new LoginPage(driver);
		hp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test
	public void getHomePageTitleTest()
	{
		Assert.assertEquals(hp.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE);
	}
	@Test
	public void getHomePageHeaderTest()
	{
		Assert.assertEquals(hp.isHomePageHeaderExist(), AppConstants.HOME_PAGE_HEADER);
	}
	@Test
	public void isUserLoggedInTest()
	{
		Assert.assertEquals(hp.isLoggedInUser(), prop.getProperty("accountname"));
	}
//	@AfterTest
//	public void tearDown()
//	{
//		driver.quit();
//	}
}
