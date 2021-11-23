package com.qa.trcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.trcrm.basepage.BasePage;
import com.qa.trcrm.utils.AppConstants;
import com.qa.trcrm.utils.ElementActions;
import com.qa.trcrm.utils.JavaScriptUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	JavaScriptUtil js;

	By homePageHeader = By.xpath("//span[text()='Homepage']");
	By loggedInUserName = By.xpath("//span[text()=' sachin sharma']");
	By contacts = By.xpath("//li[@id='contactMenuLi']/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		 elementActions=new ElementActions(driver);
		 js=new JavaScriptUtil(driver);
	}

	public String getHomePageTitle() {
		return elementActions.doGetPageTitle(AppConstants.HOME_PAGE_TITLE);
	}

	public String isHomePageHeaderExist() {
		if (elementActions.isDisplayed(homePageHeader)) {
			return elementActions.doGetText(homePageHeader);
		}
		return null;
	}

	public String isLoggedInUser() {
		return elementActions.doGetText(loggedInUserName);
	}

	public ContactsPage clickOnContacts() {
		elementActions.waitForElementVisible(contacts);
		System.out.println("hy");
		WebElement element = elementActions.getElement(contacts);
		js.flash(element);
		js.clickElementByJS(element);
		
		System.out.println("clicked");

		return new ContactsPage(driver);
	}
}
