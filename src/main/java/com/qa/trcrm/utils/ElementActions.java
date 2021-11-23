package com.qa.trcrm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, AppConstants.DEFAULT_EXPLICT_TIME_OUT);
		action = new Actions(driver);
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occured while creating element " + locator);
		}
		return element;
	}

	public void doClick(By locator) {
		getElement(locator).click();
		
	}

	public void doSendKeys(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public void waitForElementPresence(By locator) {

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementVisible(By locator) {

		wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public String doGetPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public void doActionClick(By locator) {
		action.click(getElement(locator)).build().perform();

	}

	public void doActionSendKeys(By locator, String value) {
		action.sendKeys(getElement(locator), value).build().perform();
	}
}
