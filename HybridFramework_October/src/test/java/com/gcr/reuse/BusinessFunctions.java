package com.gcr.reuse;

import org.openqa.selenium.WebDriver;
import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.or.WebShopHomePage;
import com.gcr.or.WebShopLoginPage;

public class BusinessFunctions {
	public WebDriver driver;
	public ActionDriver ad;
	
	public BusinessFunctions()
	{
		driver = StartBrowser.driver;
		ad = new ActionDriver();
	}

public void loginWebShop() throws Exception
{
	StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to WebShop application");
	ad.navigateToApplication("https://demowebshop.tricentis.com/");
	ad.click(WebShopHomePage.lnklogin, "Login Link");
	ad.type(WebShopLoginPage.txtEmail, "vindhya1.tech@gmail.com", "Email Text box");
	ad.type(WebShopLoginPage.txtPassword, "Sample@1234567", "Password Textbox");
	ad.click(WebShopLoginPage.btnLogin, "Login Button");
}
public void loginWebShop(String username, String password) throws Exception
{
	StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to WebShop application using arguments");
	ad.navigateToApplication("https://demowebshop.tricentis.com/");
	ad.click(WebShopHomePage.lnklogin, "Login Link");
	ad.type(WebShopLoginPage.txtEmail, username, "Email Text box");
	ad.type(WebShopLoginPage.txtPassword, password, "Password Textbox");
	ad.click(WebShopLoginPage.btnLogin, "Login Button");
}
public void logoutWebShop() throws Exception
{
	StartBrowser.childTest = StartBrowser.parentTest.createNode("LogOut from WebShop application");
	ad.click(WebShopHomePage.lnkLogOut, "LogOut Link");
}
}