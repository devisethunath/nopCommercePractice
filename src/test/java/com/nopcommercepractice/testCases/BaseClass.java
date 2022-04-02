package com.nopcommercepractice.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommercepractice.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig= new ReadConfig();
	public String baseURL= readconfig.getApplicationURL();//"https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public String username=readconfig.getUseremail();//"admin@yourstore.com";
	public String password=readconfig.getPassword();//"admin";


	public static WebDriver driver;
	public static Logger logger;



	@BeforeClass
	@Parameters("browser")
	
	public void setup(String br){

		logger=Logger.getLogger("nopEcommerce");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		//WebDriverManager.
		driver= new ChromeDriver();}

		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver= new FirefoxDriver();} 
	}



	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}


}
