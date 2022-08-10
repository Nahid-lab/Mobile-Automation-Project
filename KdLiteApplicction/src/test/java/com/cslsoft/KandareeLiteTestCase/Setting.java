package com.cslsoft.KandareeLiteTestCase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Setting extends BaseClass {

	
	@Test(priority = 0)
	public void Nevigate() {
			    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tv_view_profile_edit").click(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Navigate Hamburgare to Setting");

	}
	@Test(priority = 1)
	public void Logout(){
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/rlLogout").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
		System.out.println("Logout From Apps");

	}
}
