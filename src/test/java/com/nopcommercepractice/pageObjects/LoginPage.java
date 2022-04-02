package com.nopcommercepractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="Email")
	@CacheLookup
	WebElement txtEmail;


	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassword;


	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath="//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement lnkLogout;

	public void setUsername(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{txtPassword.clear();
	txtPassword.sendKeys(pwd);
	}


	public void clickLogin()
	{
		btnLogin.click();	
	}
	public void clickLogout()
	{lnkLogout.click();
	}
}
