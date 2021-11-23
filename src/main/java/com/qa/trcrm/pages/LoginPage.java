package com.qa.trcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.trcrm.basepage.BasePage;
import com.qa.trcrm.utils.AppConstants;
import com.qa.trcrm.utils.ElementActions;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementActions elementActions;

	// By locators-Page Object
	By _username = By.id("_username");
	By _password = By.id("_password");
	By loginBtn = By.xpath("//input[@type='submit']");
	By signUpNow = By.xpath("//a[text()='Sign Up Now2']");
	By signUpNow2 = By.xpath("//a[text()='Sign Up Now2']"); 
	
	//constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementActions=new ElementActions(driver);
		
	}
	
	//page actions
	public String getPageTitle() {
		//return driver.getTitle();
		return elementActions.doGetPageTitle(AppConstants.LOGIN_PAGE_TITLE);
	}
	public boolean verifySignUPLink() {
		//return driver.findElement(signUpNow).isDisplayed();
		return elementActions.isDisplayed(signUpNow);
	}
	public HomePage doLogin(String username,String password)
	{
//		driver.findElement(_username).sendKeys(username);
//		driver.findElement(_password).sendKeys(password);
//		driver.findElement(loginBtn).click();
		
		elementActions.doSendKeys(_username, username);
		elementActions.doSendKeys(_password, password);
		elementActions.doClick(loginBtn);
		
		return new HomePage(driver);
	}
	
}
