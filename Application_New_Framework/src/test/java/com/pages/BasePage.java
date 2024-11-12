package com.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	Select select;
	Actions action;
	JavascriptExecutor javaScript;
	
	public void selectDropDownByValue(WebElement dropdown, String value) {
		select = new Select(dropdown);
		select.selectByValue(value);
	}

	public void selectDropDownByVisibleText(WebElement dropdown, String visibleText) {
		select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void waitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilPresenceOfElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitUntilElementIsClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
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
	
	
	public void jsClick(WebDriver driver, WebElement element) {
		javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("arguments[0].click();", element);
	}
	
	public void jsScrollIntoView(WebDriver driver, boolean bool, WebElement element) {
		javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("arguments[0].scrollIntoView(" + bool + ")", element);
	}
	
	
}
