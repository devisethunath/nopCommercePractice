package com.nopcommercepractice.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommercepractice.pageObjects.LoginPage;
import com.nopcommercepractice.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	
	public void loginTest(String user ,String pwd) throws InterruptedException
	{

		driver.get(baseURL);
		driver.manage().window().maximize();

		logger.info("URL is open");


		LoginPage lp = new LoginPage(driver);
		//lp.setUsername(user);

		logger.info("user is provided");
		//lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickLogin();

		Thread.sleep(2000);

		if 

		(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			System.out.println(driver.getTitle());
			lp.clickLogout();
			logger.info("login passed");
		}
		else
		{
			//captureScreen(driver,"loginTest"); //since data driven test no need of this
			Assert.assertTrue(false);
			logger.info("login failed");
		}
		
	}

	
	@DataProvider(name="LoginData")
	
	public String [][]getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\nopcommercepractice\\testData\\LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
				
				String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}

