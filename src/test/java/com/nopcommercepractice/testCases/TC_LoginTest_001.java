package com.nopcommercepractice.testCases;


import java.io.IOException;

//port org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommercepractice.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test

	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("urli is open");

		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username given");

		lp.setPassword(password);

		logger.info("password given");

		lp.clickLogin();
		Thread.sleep(5000);
		logger.info("login button clicked");

		if(driver.getTitle().equals("Dashboard / nopCommerce administration123"))
		{

			lp.clickLogout();
			logger.info("logout button clicked");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
		}
	}


}
