package com.gcr.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.or.WebShopHomePage;
import com.gcr.reuse.BusinessFunctions;

public class TC5 extends StartBrowser{
	@Test
	public void LoginLogout_WebShop_Excel() throws Exception{
		BusinessFunctions bfs = new BusinessFunctions();
		ActionDriver ad = new ActionDriver();
		Fillo f = new Fillo();
		Connection con = f.getConnection("TestData/Data.xlsx");
		String query = "select * from webshop";
		Recordset rs =con.executeQuery(query);
		while (rs.next()) {
			bfs.loginWebShop(rs.getField("UserName"), rs.getField("Password"));
		}
		String actualText= ad.getText(WebShopHomePage.lnkLogOut, "Logout link");
		String expText="Log out";
		//StartBrowser.childTest = StartBrowser.parentTest.createNode("Verify Title");
		try {
			Assert.assertEquals(actualText, expText);
			StartBrowser.childTest.pass("Login verification Successful");
		} catch (AssertionError e) {
			StartBrowser.childTest.fail("Login verification Not Successful");
			throw e;
		}
		//Thread.sleep(2000);
		bfs.logoutWebShop();
	}
}
