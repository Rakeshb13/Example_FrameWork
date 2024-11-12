package com.testcases;

import org.testng.annotations.Test;

import com.pages.BasePage;
import com.setup.BaseTest;

public class Books extends BaseTest{
	
	@Test(priority = 1)
	public void verify_Books_Page_Is_Displayed() throws InterruptedException {
		report.createTest("verify_Books_Page_Is_Displayed");
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
	}
	
	@Test(priority = 2)
	public void demo() throws InterruptedException {
		report.createTest("demo");
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
	}

}
