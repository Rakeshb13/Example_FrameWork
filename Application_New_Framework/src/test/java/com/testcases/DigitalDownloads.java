package com.testcases;

import org.testng.annotations.Test;

import com.pages.BasePage;

public class DigitalDownloads extends BasePage{

	@Test(priority = 1)
	public void verify_Books_Page_Is_Displayed() throws InterruptedException {
		
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
	}
	
	@Test(priority = 2)
	public void demo() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
	}
	
}
