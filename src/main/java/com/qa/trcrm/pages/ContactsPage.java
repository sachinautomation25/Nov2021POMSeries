package com.qa.trcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.trcrm.basepage.BasePage;
import com.qa.trcrm.utils.ElementActions;
import com.qa.trcrm.utils.JavaScriptUtil;

public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	JavaScriptUtil js;

	By createContactButton = By.xpath("/*[@id=\"contactMenuLi\"]/a/span");

	By firstName = By.xpath("//input[@name='name']");
	By lastName = By.xpath("//input[@name='surname']");

	By contactsHeader = By.xpath("(//li/a)[2]/span");
	By addPersonButton = By.xpath("/html/body/section/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/button[4]");
	By name = By.xpath("//input[@name='name']");
	By saveButton = By.xpath("//*[@id=\"personForm\"]/div[2]/div/div[2]/div/div/button[1]");
	By personAdded = By.xpath("//span[text()='Person added.']");
	By email = By.id("email0");

	public ContactsPage(WebDriver driver) {

		this.driver = driver;
		elementActions = new ElementActions(driver);
		js = new JavaScriptUtil(driver);

	}

	public String getContactsPageHeader() {
		return elementActions.doGetText(contactsHeader);
	}

	public void doAddPersonButtonClick() {
		elementActions.doClick(addPersonButton);
	}

	public String doAddPerson(String nameVal, String emailVal) throws InterruptedException {

		
		elementActions.waitForElementPresence(addPersonButton);
		elementActions.doClick(addPersonButton);
//		elementActions.doSendKeys(name, "deepak");
//		elementActions.doSendKeys(email, "deepak@gmail.com");
		elementActions.waitForElementPresence(firstName);
		elementActions.doSendKeys(name, nameVal);
		elementActions.doSendKeys(email, emailVal);
		elementActions.doClick(saveButton);
		elementActions.waitForElementPresence(personAdded);

		return elementActions.doGetText(personAdded);

	}

}
