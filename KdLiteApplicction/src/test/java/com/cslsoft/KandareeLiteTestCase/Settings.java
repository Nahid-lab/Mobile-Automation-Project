package com.cslsoft.KandareeLiteTestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Settings extends BaseClass{
	
	@Test(priority = 0)
	public void Nevigate() throws InterruptedException, IOException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tv_view_profile_edit").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Navigate Hamburgare to Settings!");

	}
	

	//Verify Setting View
	//@Test (priority = 1)
	public void VerifySettingView()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Setting View Executed!");
		int count=0;
		String str="";
		try {

			//Page Title
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/settings_Id").getText();
				
				if(gettext.contentEquals("Settings")) {
					;
				}else {
					count++;
					str = str + "\n" + "Settings Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Settings Title doesn't found";
			}
			
			//Language
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/language_txt_Id").getText();
				
				if(gettext.contentEquals("Language")) {
					// Language icon
					try {
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/language_icon_Id").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "Language Icon doesn't display";
							//System.out.println(str);
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" +"Language Icon doesn't found";
					}

					//Select language field
					try {
						
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_default_language").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "Select language field doesn't display";
							//System.out.println(str);
						}
						
					} catch (Exception e) {
						count++;
						str = str + "\n" +e+ "Select language field doesn't found";
					}


				}else {
					count++;
					str = str + "\n" + "Language text label doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Language text label doesn't found";
			}
			
			//Clear Cache
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/clear_cache_txt_Id").getText();
				
				if(gettext.contentEquals("Clear Cache")) {
					// Language icon
					try {
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/clear_cache_icon_Id").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "Clear Cache Icon doesn't display";
							//System.out.println(str);
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" +"Clear Cache Icon doesn't found";
					}

					//System text
					try {
						
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/default_clear_cache").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "System text field doesn't display";
							//System.out.println(str);
						}
						
					} catch (Exception e) {
						count++;
						str = str + "\n" +e+ "System text field doesn't found";
					}


				}else {
					count++;
					str = str + "\n" + "Clear Cache text label doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Clear Cache text label doesn't found";
			}
			
			
			//Logout
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/logout_txt_Id").getText();
				
				if(gettext.contentEquals("Logout")) {
					//Logout icon
					try {
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/logout_icon_Id").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "Logout Icon doesn't display";
							//System.out.println(str);
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" +"Logout Icon doesn't found";
					}
				
					
				}else {
					count++;
					str = str + "\n" + "Logout text label doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Logout text label doesn't found";
			}
			
			
			
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Setting View"); 
		    M.setStrData("As Expected","Automation Testcase", 950, 6);
			M.setStrData("Pass","Automation Testcase", 950, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Setting View");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 950, 6);
			M.setStrData("Fail","Automation Testcase", 950, 7);

		}
		
		
	}

	
	
	
	
	//Verify Logout and Back Button
	@Test (priority = 2)
	public void VerifyLogoutAndBackButton()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Logout and Back Button Executed!");
		int count=0;
		String str="";
		try {
			
			//Back Button
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Back Button doesn't found";
			}
			//Page Title
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/settings_Id").getText();
				
				if(gettext.contentEquals("Settings")) {
					count++;
					str = str + "\n" + "Back Button doesn't working";
				}
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tv_view_profile_edit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

			
			//Logout			
			try {
				
				//Click logout
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/logout_txt_Id").click();
				
				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 432, 2), M.getstring("Automation Test Data", 432, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"After Press Logout Button "+ confirmation;
				}
				
				//Click logout
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/logout_txt_Id").click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
				Thread.sleep(5000);
				try {
					Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_login").isDisplayed();
					if(tr==false) {
						count++;
						str = str + "\n" + "Logout button doesn't work properly";
						//System.out.println(str);
					}
				} catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				;
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Logout and Back Button"); 
			M.setStrData("As Expected","Automation Testcase", 951, 6);
			M.setStrData("Pass","Automation Testcase", 951, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Logout and Back Button");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 951, 6);
			M.setStrData("Fail","Automation Testcase", 951, 7);
			
		}
		
		
	}
	
	
	

	

}
