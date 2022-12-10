package com.gcr.scripts;

import org.testng.annotations.Test;

import com.gcr.config.StartBrowser;
import com.gcr.reuse.BusinessFunctions;

public class TC4 extends StartBrowser{
  @Test
  public void LoginLogout_WebShop() throws Exception{
	  BusinessFunctions bfs = new BusinessFunctions();
	  bfs.loginWebShop();
  }
}
