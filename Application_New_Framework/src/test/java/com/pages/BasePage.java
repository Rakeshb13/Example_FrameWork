package com.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.setup.DriverSetup;
import com.utility.DataUtility;
import com.utility.FrameworkConstants;

public class BasePage {
	
	public DataUtility data_Utility = new DataUtility();
	DriverSetup driver_Setup = new DriverSetup();
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	Select select;
	Actions action;

	@BeforeSuite
	public void setUpReport() {
		driver_Setup.configureReport();
	}
	
	@Parameters("browserName")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		driver=driver_Setup.invokeBrowser(browserName);
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver_Setup.quitBrowser();
	}
	
	
	@AfterSuite
	public void tearDownReport() {
		driver_Setup.finalizeReport();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void selectDropDownByValue(WebElement dropdown, String value) {
		select = new Select(dropdown);
		select.selectByValue(value);
	}

	public void selectDropDownByVisibleText(WebElement dropdown, String visibleText) {
		select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}

	
	public boolean verifyIsDropDownIsMultiSelect(WebElement dropDown) {
		select = new Select(dropDown);
		return select.isMultiple();
	}

	
	public void deselectAllOptionsFromDropDown(WebElement dropDown) {
		if (verifyIsDropDownIsMultiSelect(dropDown)) {
			select = new Select(dropDown);
			select.deselectAll();
		} else
			System.out.println("Can't De-select Options from an Single Select Dropdown");
	}

	
	public void deselectDropDownByValue(WebElement dropdown, String value) {
		select = new Select(dropdown);
		select.deselectByVisibleText(value);
	}

	
	public void deselectDropDownByVisibleText(WebElement dropdown, String visibleText) {
		select = new Select(dropdown);
		select.deselectByVisibleText(visibleText);
	}

	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	
	public void passValueToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	
	public void switchtoFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	
	public void switchToWindow(WebDriver driver, String pageTitle) {

		Set<String> all_Session_Ids = driver.getWindowHandles();

		for (String session_Id : all_Session_Ids) {
			driver.switchTo().window(session_Id);
			if (driver.getTitle().equals(pageTitle)) {
				break;
			}
		}
	}

	
	public void captureScreenshot(WebDriver driver, String screenshotTitle) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(FrameworkConstants.SCREENSHOT_PATH + screenshotTitle + ".png");
		FileHandler.copy(src, trg);
	}
	
	
	public String captureScreenshotForReport(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	
	
	public void waitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void waitUntilInVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitUntilPresenceOfElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public void mouseHoverOnElement(WebDriver driver,WebElement targetElement) {
		action = new Actions(driver);
		action.moveToElement(targetElement).perform();
	}
	
	
	public void clickOnElement(WebDriver driver, WebElement targetElement) {
		action = new Actions(driver);
		action.click(targetElement).perform();
	}
	
	public void actionsScrollTillElement(WebDriver driver, WebElement targetElement) {
		action = new Actions(driver);
		action.scrollToElement(targetElement).perform();
	}
	
}
