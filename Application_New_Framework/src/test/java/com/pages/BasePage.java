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
}
