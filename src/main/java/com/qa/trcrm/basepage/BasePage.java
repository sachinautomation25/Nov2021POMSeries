package com.qa.trcrm.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	OptionsManager optionManager;
	
	


	/**
	 * This method used to initialize the webdriver on the basis of browser name
	 * 
	 * @param browserName
	 * @return this method will return driver instance
	 */
	public WebDriver init_driver(Properties prop, String browserName) {
		// String browserName = prop.getProperty("browser");

		String headless = prop.getProperty("headless");
		Boolean headLess = Boolean.parseBoolean(headless);
		optionManager = new OptionsManager(prop);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			if (headLess) {
//				ChromeOptions co = new ChromeOptions();
//				co.addArguments("--headless");
//				driver = new ChromeDriver(co);
//			} else {
//				driver = new ChromeDriver();
//			}
			System.out.println("hurry ");
			driver = new ChromeDriver(optionManager.getChromeOptions());
			System.out.println("getChromeOptions executed");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			if (headLess) {
//				FirefoxOptions fo = new FirefoxOptions();
//				fo.addArguments("--headless");
//				driver = new FirefoxDriver(fo);
//			} else {
//
//				driver = new FirefoxDriver();
//			}
			driver = new FirefoxDriver(optionManager.getFirefoxOptions());

		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println(browserName + " not found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	public WebDriver init_driver2(Properties prop) {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println(browserName + " not found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	/**
	 * This method returns properties prop available in config.properties file
	 * 
	 * @return
	 */
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(".\\src\\main\\java\\com\\qa\\trcrm\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public String getScreenshot() {
		System.out.println("getScreenshot");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("getScreenshot2");
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
}
