package com.cslsoft.CoopersApps_Smoketesting;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.testng.ITestResult;

import java.sql.*; 
public class LogInWithOTP extends BaseClass{
	

	int C_AppCrash=0;
	int O_AppCrash=0;
	int R_AppCrash=0;
	
	//Customer App
	//@Test(priority = 0)
	public void Installation_LocationAccess() throws IOException{
		Capabilities_Customer();
		CallingMethods M=new CallingMethods(driver);
		
		System.out.println("Verify Installation & Location Access!");
		
		try {
			  driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			//Allow Location Access button
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Allow Location Access").click();
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Allow Location Access").click(); 
				  }catch(Exception b){
					  System.out.println("After install, App may be crush. Allow location Access button not found");
					  throw new Exception(b);
				  }
			  }
			 //Don't allow button
			  try {
				  Thread.sleep(5000);
				  driver.findElementById("com.android.permissioncontroller:id/permission_deny_button").click(); 
				  
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementById("com.android.permissioncontroller:id/permission_deny_button").click(); 
					  
				  }catch(Exception b){
					  System.out.println("After click on Allow location access but app doesn't found 'Don't allow' text button");
					  throw new Exception(b);
				  }
			  }
			  
			//Allow Location Access button after back by don't allow
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Allow Location Access").click();
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Allow Location Access").click(); 
				  }catch(Exception b){
					  System.out.println("After back by don't allow. Allow location Access button not found");
					  throw new Exception(b);
				  }
			  }
			  
			  //While using the app text button
			  try {
				  Thread.sleep(5000);
				  driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click(); 
				  
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click(); 
					  
				  }catch(Exception b){
					  System.out.println("after click on Allow location access but app doesn't found 'While using the app' text button");
					  throw new Exception(b);
				  }
			  }
			  //Home page.
			  try {
				  Thread.sleep(5000);
				  driver.findElement(By.className("android.widget.EditText")).getText();
			  }catch(Exception c){
				  try {
					  Thread.sleep(5000);
					  driver.findElement(By.className("android.widget.EditText")).getText(); 
				  }catch(Exception d){
					  System.out.println("After install and select 'while using the app' for location. Home page not found");
					  throw new Exception(d);
				  }
			  }
			  Thread.sleep(5000);
			  driver.quit();
			  Thread.sleep(5000);
			  Capabilities_Customer();

			//Allow Location Access button
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Allow Location Access").click();
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Allow Location Access").click(); 
				  }catch(Exception b){
					  System.out.println("After install, App may be crush. Allow location Access button not found in second time");
					  throw new Exception(b);
				  }
			  }
			  
			  //Allow_One_time text button
			  try {
				  Thread.sleep(5000);
				  driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button").click(); 
				  
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button").click(); 
					  
				  }catch(Exception b){
					  System.out.println("after click on Allow location access but app doesn't found 'Allow_One_time' text button");
					  throw new Exception(b);
				  }
			  }
			  //Home page.
			  try {
				  Thread.sleep(5000);
				  driver.findElement(By.className("android.widget.EditText")).getText();
			  }catch(Exception c){
				  try {
					  Thread.sleep(5000);
					  driver.findElement(By.className("android.widget.EditText")).getText();
				  }catch(Exception d){
					  System.out.println("After install and select 'Allow_One_time' for location. Home page not found");
					  throw new Exception(d);
				  }
			  }
			  
			  /*			  
			  
			  M.ScreenShots("Screenshot/Passed","Recieved And Enter CorrectOTP");
			  
			  M.setStrData("As Expected","Login", 10, 7);
			  M.setStrData("Pass","Login", 10, 8);
			  */
		}catch(Exception e){
			/*
			M.ScreenShots("Screenshot/Failed","Recieved And Enter CorrectOTP");
			String ErMass=e.toString().substring(0, 123);
			M.setStrData(ErMass, "Login", 10, 7);
			M.setStrData("Fail","Login", 10, 8);
			*/
			C_AppCrash=1;
			
			System.out.println(" Test case Fail: Verify Installation & Location Access");
		}
		
			 
	}
	
	//Customer App
	//@Test(priority = 1)
	public void VerifyLoginToLogout() throws Exception {
		
		System.out.println("Verify Login To Logout Executed!!");
		//CallingMethods M = new CallingMethods(driver);
		
		if(C_AppCrash==1)
		{
			Capabilities_Customer();
			CallingMethods TM = new CallingMethods(driver);
			TM.AllowLocationAccess();			 
		}
		
		CallingMethods M = new CallingMethods(driver);
		try {
			//Login with valid number
			try {
				
				 //Click on profile icon & login button
				 try {
					  Thread.sleep(2000);
					  driver.findElementByAccessibilityId("Tab 4 of 4").click();
					  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  
					  Thread.sleep(2000);
					  driver.findElementByAccessibilityId("Login").click();
					  
				 }catch(Exception a){
					 System.out.println("Profile icon not found when try to login");
					  throw new Exception(a);
				 }
				 

				//Enter mobile number
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElement(By.className("android.widget.EditText")).click();
					 driver.findElement(By.className("android.widget.EditText")).sendKeys("01670979797");
					  
				 }catch(Exception a){
					 System.out.println("Mobile number input field not found");
					 throw new Exception(a);
				 }

				//click on continue button
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Continue").click();
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  
				 }catch(Exception a){
					 System.out.println("Continue button not found");
					 throw new Exception(a);
				 }
				 
				//Check OTP & Resend button
				 try {
					 Thread.sleep(5000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 
					//New OTPCode collect from database
					 ResultSet rs=M.Databaseconnection("select OTPCode from OTPLog order by OTPLogId desc limit 1");
					 
					 rs.next();
					 String newcode=rs.getString("OTPCode");
					 M.DatabaseConnectinOff();
					 String resendcode;
					 //Click On Resent button
					 try {
						 Thread.sleep(62000);
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 driver.findElementByAccessibilityId("Resend").click();
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						  
						 //Resend OTP code collect from database
						 ResultSet rs1=M.Databaseconnection("select OTPCode from OTPLog order by OTPLogId desc limit 1");
						 rs1.next();
						 resendcode=rs1.getString("OTPCode");
						 //System.out.println(newcode+""+resendcode);
						 M.DatabaseConnectinOff();
						 if(newcode.equals(resendcode)) {
							 //System.out.println("why");
							 throw new Exception("Resend OTP code not found");
						 }
						 
					 }catch(Exception c){
						 System.out.println("Resend button doesn't work");
						 throw new Exception(c);
					 }
					 
					 
					 //convert string to char array.
					 char[] ch = new char[resendcode.length()];
					 
					 for (int i = 0; i < resendcode.length(); i++) {
				            ch[i] = resendcode.charAt(i);
				            char OTP=ch[i];
				            
				            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				            driver.findElementsByClassName("android.widget.EditText").get(i).click();
				            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				            driver.findElementsByClassName("android.widget.EditText").get(i).setValue(Character.toString(OTP));
				        }
					 
				 }catch(Exception a){
					 System.out.println("Something is wrong in OTP & Resend button");
					 throw new Exception(a);
				 }				 
				 
				//click on OTP Submit button
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Submit").click();
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  
				 }catch(Exception a){
					 System.out.println("Continue button not found");
					 throw new Exception(a);
				 }
				 
				  //Home page.
				  try {
					  Thread.sleep(2000);
					  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  driver.findElement(By.className("android.widget.EditText")).getText();
				  }catch(Exception c){
					  try {
						  Thread.sleep(5000);
						  driver.findElement(By.className("android.widget.EditText")).getText();
					  }catch(Exception d){
						  System.out.println("After login, Home page not found");
						  throw new Exception(d);
					  }
				  }

			}catch(Exception b){
				  System.out.println("Login fail");
				  throw new Exception(b);
			  }
		 			 
			//Logout button
			 try {
				 //click on profile
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Tab 4 of 4").click();

				 Thread.sleep(5000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 //System.out.println("ok");
				 M.ScrollDown(1);
				 //System.out.println("ok1");
				//click on logout text button
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Logout").click();
				 
				 //check & verify cancel button
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Cancel").click();
					 
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Profile").getText();
					 
					
					 					 
				  }catch(Exception d){
					  System.out.println("Logout cancel button does not work...");
				  }
				 
				 
				
				
				 //Verify Logout button & Home page.
				  try {
					  
					   //click on logout text button
					   Thread.sleep(2000);
					   M.ScrollDown(1);
					   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					   driver.findElementByAccessibilityId("Logout").click();
					   
					   //click on log out button
					   Thread.sleep(2000);
					   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					   driver.findElementByAccessibilityId("Log out").click();
					  
					   //Verify Home page
					   Thread.sleep(5000);
					   driver.findElement(By.className("android.widget.EditText")).getText();
				  }catch(Exception c){
					  try {
						  Thread.sleep(5000);
						  driver.findElement(By.className("android.widget.EditText")).getText();
					  }catch(Exception d){
						  System.out.println("After click on logout button, Home page not found");
						  throw new Exception(d);
					  }
				  }
				   
			 }catch(Exception a){
				 System.out.println(a);
				 throw new Exception(a);
			 }
			 
			 

		} catch (Exception e) {
			
			System.out.println(" Test case Fail:Verify Login to Lo Interface");
		}
		
		driver.quit();
	}

/*	
	//DataBase connection support.
	public void DataBaseConnectionSupport() throws IOException, SQLException {
		CallingMethods M=new CallingMethods(driver);
		Capabilities_Customer();
		try {
			ResultSet Countrs=M.Databaseconnection("SELECT COUNT(OTPLogId) as count FROM OTPLog");
			Countrs.next();
			int i=Countrs.getInt("count");
			System.out.println(i);

			ResultSet rs=M.Databaseconnection("select OTPCode from OTPLog");
			String[] a= new String[i];
			int j=0;
			while(rs.next()) 
			  {
				
				a[j]=rs.getString("OTPCode");
				 
				  j++;

			  }
			//System.out.println(i);

			for(int k=0;i>k;k++) {
				 System.out.println(a[k]); 
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("IncorrertEmailCorrertCode Executed!!");
		
		//driver.quit();

	}
*/
	
	//Outlet App
	//@Test(priority = 2)
	public void VerifyInstallation_LoginToLogout_OutletApp() throws IOException, SQLException {
		
		Capabilities_Outlet();		
		CallingMethods M = new CallingMethods(driver);
		try {
			//Login with valid number
			try {
				
				//Enter mobile number
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElement(By.className("android.widget.EditText")).click();
					 driver.findElement(By.className("android.widget.EditText")).sendKeys("01100220007");
					  
				 }catch(Exception a){
					 System.out.println("Mobile number input field not found");
					 throw new Exception(a);
				 }

				//click on continue button
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Continue").click();
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  
				 }catch(Exception a){
					 System.out.println("Continue button not found");
					 throw new Exception(a);
				 }
				 
				//Check OTP & Resend button
				 try {
					 Thread.sleep(5000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 
					//New OTPCode collect from database
					 ResultSet rs=M.Databaseconnection("select OTPCode from OTPLog order by OTPLogId desc limit 1");
					 
					 rs.next();
					 String newcode=rs.getString("OTPCode");
					 M.DatabaseConnectinOff();
					 String resendcode;
					 //Click On Resent button
					 try {
						 Thread.sleep(62000);
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 driver.findElementByAccessibilityId("Resend").click();
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						  
						 //Resend OTP code collect from database
						 ResultSet rs1=M.Databaseconnection("select OTPCode from OTPLog order by OTPLogId desc limit 1");
						 rs1.next();
						 resendcode=rs1.getString("OTPCode");
						 M.DatabaseConnectinOff();
						 //System.out.println(newcode+""+resendcode);
						 if(newcode.equals(resendcode)) {
							 //System.out.println("why");
							 throw new Exception("Resend OTP code not found");
						 }
						 
					 }catch(Exception c){
						 System.out.println("Resend button doesn't work");
						 throw new Exception(c);
					 }
					 
					 
					 //convert string to char array.
					 char[] ch = new char[resendcode.length()];
					 
					 for (int i = 0; i < resendcode.length(); i++) {
				            ch[i] = resendcode.charAt(i);
				            char OTP=ch[i];
				            
				            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				            driver.findElementsByClassName("android.widget.EditText").get(i).click();
				            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				            driver.findElementsByClassName("android.widget.EditText").get(i).setValue(Character.toString(OTP));
				        }
					 
				 }catch(Exception a){
					 System.out.println("Something is wrong in OTP & Resend button");
					 throw new Exception(a);
				 }				 
				 
				//click on OTP Submit button
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Submit").click();
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  
				 }catch(Exception a){
					 System.out.println("Continue button not found");
					 throw new Exception(a);
				 }
				 
				  //Dashboard page.
				  try {
					  Thread.sleep(2000);
					  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  String d=driver.findElementsByClassName("android.view.View").get(0).getText();
					  System.out.println(d);
					  
				  }catch(Exception c){
					  try {
						  Thread.sleep(5000);
						  String d=driver.findElementsByClassName("android.view.View").get(0).getText();
					  }catch(Exception d){
						  System.out.println("After login, Dashboard page not found");
						  throw new Exception(d);
					  }
				  }

			}catch(Exception b){
				  System.out.println("Login fail");
				  throw new Exception(b);
			  }
		 			 
			//Logout button
			 try {
				 //click on profile
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Tab 6 of 6").click();

				 Thread.sleep(5000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Logout").click();
				 
				 //check & verify cancel button
				 try {
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Cancel").click();
					 
					 Thread.sleep(2000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Profile").getText();
					 
					
					 					 
				  }catch(Exception d){
					  System.out.println("Logout cancel button does not work...");
				  }
				 
				 
				
				
				 //Verify Logout button & Home page.
				  try {
					  
					   //click on logout text button
					   Thread.sleep(2000);
					   //M.ScrollDown(1);
					   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					   driver.findElementByAccessibilityId("Logout").click();
					   
					   //click on log out button
					   Thread.sleep(2000);
					   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					   driver.findElementByAccessibilityId("Log out").click();
					  
					   //Verify Login page
					   Thread.sleep(5000);
					   driver.findElementByAccessibilityId("Continue").getText();
				  }catch(Exception c){
					  try {
						  Thread.sleep(5000);
						  driver.findElementByAccessibilityId("Continue").getText();
					  }catch(Exception d){
						  System.out.println("After click on logout button, Login page not found");
						  throw new Exception(d);
					  }
				  }
				   
			 }catch(Exception a){
				 System.out.println(a);
				 throw new Exception(a);
			 }
			 
			 

		} catch (Exception e) {
			
			System.out.println(" Test case Fail: VerifyInstallation_LoginToLogout_OutletApp");
		}
		
		driver.quit();		 
		 
		 
		 
		 
	}
	
	//Rider App
	//@Test(priority = 3)
	public void Installation_LocationAccess_RiderApp() throws IOException {
		
		Capabilities_Rider();
		CallingMethods M=new CallingMethods(driver);
		
		System.out.println("Verify Installation_LocationAccess_RiderApp!");
		
		try {
			  driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			//Allow Location Access button
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Allow Location Access").click();
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Allow Location Access").click(); 
				  }catch(Exception b){
					  System.out.println("After install, App may be crush. Allow location Access button not found");
					  throw new Exception(b);
				  }
			  }
			 //Don't allow button
			  try {
				  Thread.sleep(5000);
				  driver.findElementById("com.android.permissioncontroller:id/permission_deny_button").click(); 
				  
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementById("com.android.permissioncontroller:id/permission_deny_button").click(); 
					  
				  }catch(Exception b){
					  System.out.println("After click on Allow location access but app doesn't found 'Don't allow' text button");
					  throw new Exception(b);
				  }
			  }
			  
			//Allow Location Access button after back by don't allow
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Allow Location Access").click();
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Allow Location Access").click(); 
				  }catch(Exception b){
					  System.out.println("After back by don't allow. Allow location Access button not found");
					  throw new Exception(b);
				  }
			  }
			  
			  //While using the app text button
			  try {
				  Thread.sleep(5000);
				  driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click(); 
				  
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click(); 
					  
				  }catch(Exception b){
					  System.out.println("after click on Allow location access but app doesn't found 'While using the app' text button");
					  throw new Exception(b);
				  }
			  }
			  //Home page.
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Continue").getText();
			  }catch(Exception c){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Continue").getText(); 
				  }catch(Exception d){
					  System.out.println("After install and select 'while using the app' for location. login page not found");
					  throw new Exception(d);
				  }
			  }
			  Thread.sleep(5000);
			  driver.quit();
			  Thread.sleep(5000);
			  Capabilities_Rider();

			//Allow Location Access button
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Allow Location Access").click();
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Allow Location Access").click(); 
				  }catch(Exception b){
					  System.out.println("After install, App may be crush. Allow location Access button not found in second time");
					  throw new Exception(b);
				  }
			  }
			  
			  //Allow_One_time text button
			  try {
				  Thread.sleep(5000);
				  driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button").click(); 
				  
			  }catch(Exception a){
				  try {
					  Thread.sleep(5000);
					  driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button").click(); 
					  
				  }catch(Exception b){
					  System.out.println("after click on Allow location access but app doesn't found 'Allow_One_time' text button");
					  throw new Exception(b);
				  }
			  }
			  //login page.
			  try {
				  Thread.sleep(5000);
				  driver.findElementByAccessibilityId("Continue").getText();
			  }catch(Exception c){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Continue").getText();
				  }catch(Exception d){
					  System.out.println("After install and select 'Allow_One_time' for location. Home page not found");
					  throw new Exception(d);
				  }
			  }

		} catch (Exception e) {
			R_AppCrash=1;
			System.out.println(e);
			System.out.println("Test case Fail:Installation_LocationAccess_RiderApp");
		}

		

	}

	
	//Rider App
	//@Test(priority = 4)
	public void VerifyInstallation_LoginToLogout_RiderApp() throws Exception {
		
		System.out.println("Verify Installation_LoginToLogout_RiderApp Executed!!");
		//CallingMethods M = new CallingMethods(driver);
		
		if(R_AppCrash==1)
		{
			Capabilities_Rider();
			CallingMethods TM = new CallingMethods(driver);
			TM.AllowLocationAccess();			 
		}
		
		CallingMethods M = new CallingMethods(driver);
		//Login with valid number
		try {
			
			//Enter mobile number
			 try {
				 Thread.sleep(5000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElement(By.className("android.widget.EditText")).click();
				 driver.findElement(By.className("android.widget.EditText")).sendKeys("01100110062");
				  
			 }catch(Exception a){
				 System.out.println("Mobile number input field not found");
				 throw new Exception(a);
			 }

			//click on continue button
			 try {
				 Thread.sleep(2000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Continue").click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  
			 }catch(Exception a){
				 System.out.println("Continue button not found");
				 throw new Exception(a);
			 }
			 
			//Check OTP & Resend button
			 try {
				 Thread.sleep(5000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 
				//New OTPCode collect from database
				 ResultSet rs=M.Databaseconnection("select OTPCode from OTPLog order by OTPLogId desc limit 1");
				 
				 rs.next();
				 String newcode=rs.getString("OTPCode");
				 M.DatabaseConnectinOff();
				 String resendcode;
				 //Click On Resent button
				 try {
					 Thread.sleep(65000);
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 driver.findElementByAccessibilityId("Resend").click();
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  
					 //Resend OTP code collect from database
					 ResultSet rs1=M.Databaseconnection("select OTPCode from OTPLog order by OTPLogId desc limit 1");
					 rs1.next();
					 resendcode=rs1.getString("OTPCode");
					 M.DatabaseConnectinOff();
					//System.out.println("why");
					 //System.out.println(newcode+""+resendcode);
					 if(newcode.equals(resendcode)) {
						 //System.out.println("why");
						 throw new Exception("Resend OTP code not found");
					 }
					 
				 }catch(Exception c){
					 System.out.println("Resend button doesn't work");
					 throw new Exception(c);
				 }
				 
				 
				 //convert string to char array.
				 char[] ch = new char[resendcode.length()];
				 
				 for (int i = 0; i < resendcode.length(); i++) {
			            ch[i] = resendcode.charAt(i);
			            char OTP=ch[i];
			            
			            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			            driver.findElementsByClassName("android.widget.EditText").get(i).click();
			            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			            driver.findElementsByClassName("android.widget.EditText").get(i).setValue(Character.toString(OTP));
			        }
				 
			 }catch(Exception a){
				 System.out.println("Something is wrong in OTP & Resend button");
				 throw new Exception(a);
			 }				 
			 
			//click on OTP Submit button
			 try {
				 Thread.sleep(2000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Submit").click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  
			 }catch(Exception a){
				 System.out.println("Continue button not found");
				 throw new Exception(a);
			 }
			 
			  //Dashboard page.
			  try {
				  Thread.sleep(2000);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  String d=driver.findElementsByClassName("android.view.View").get(0).getText();
				  System.out.println(d);
				  
			  }catch(Exception c){
				  try {
					  Thread.sleep(5000);
					  String d=driver.findElementsByClassName("android.view.View").get(0).getText();
				  }catch(Exception d){
					  System.out.println("After login, Dashboard page not found");
					  throw new Exception(d);
				  }
			  }

		}catch(Exception b){
			  System.out.println("Login fail");
			  throw new Exception(b);
		  }
	 			 
		//Logout button-
		 try {
			 //click on profile
			 Thread.sleep(5000);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElementByAccessibilityId("Tab 4 of 4").click();

			 Thread.sleep(5000);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElementByAccessibilityId("Logout").click();
			 
			 //check & verify cancel button
			 try {
				 Thread.sleep(2000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Cancel").click();
				 
				 Thread.sleep(2000);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElementByAccessibilityId("Profile").getText();
				 
				
				 					 
			  }catch(Exception d){
				  System.out.println("Logout cancel button does not work...");
			  }
			 
			 
			
			
			 //Verify Logout button & Home page.
			  try {
				  
				   //click on logout text button
				   Thread.sleep(2000);
				   //M.ScrollDown(1);
				   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				   driver.findElementByAccessibilityId("Logout").click();
				   
				   //click on log out button
				   Thread.sleep(2000);
				   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				   driver.findElementByAccessibilityId("Log out").click();
				  
				   //Verify Login page
				   Thread.sleep(5000);
				   driver.findElementByAccessibilityId("Continue").getText();
			  }catch(Exception c){
				  try {
					  Thread.sleep(5000);
					  driver.findElementByAccessibilityId("Continue").getText();
				  }catch(Exception d){
					  System.out.println("After click on logout button, Login page not found");
					  throw new Exception(d);
				  }
			  }	 

		} catch (Exception e) {
			R_AppCrash=1;
			System.out.println(" Test case Fail:Verify Login To Logout_RiderApp");
		}
		
		driver.quit();
	}

	
	@Test(priority = 5)
	public void Verify_Product_Availablity_Quantity() throws IOException {
		Capabilities_Customer();
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify product availablity & Quantity Executed!!");
		try {
			try {
				M.AllowLocationAccess();
				Thread.sleep(5000);
				/*
				//Click on profile tab
				driver.findElementByAccessibilityId("Tab 4 of 4").click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				//Click on login
				Thread.sleep(2000);
				driver.findElementByAccessibilityId("Login").click();
				Thread.sleep(2000);
				
				M.Login("01670979086");
				Thread.sleep(2000);
				try {
					  Thread.sleep(5000);
					  driver.findElement(By.className("android.widget.EditText")).getText();
				  }catch(Exception d){
					  System.out.println("After login, Home page not found");
					  throw new Exception(d);
				  }
			*/	
			}catch(Exception e) {
				throw new Exception(e);
			}
			
			//Add location
			/*
			//Click on Location
			driver.findElementsByClassName("android.view.View").get(0).click();
			Thread.sleep(2000);
			driver.longPressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
			driver.findElementsByClassName("android.view.View").get(0).click();
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//Click on Location
			driver.findElementsByClassName("android.view.View").get(2).click();
			Thread.sleep(2000);
			//Click on Location
			driver.findElementsByClassName("android.widget.EditText").get(1).click();
			
			driver.findElementsByClassName("android.widget.EditText").get(1).clear();
			
			driver.findElementsByClassName("android.widget.EditText").get(1).sendKeys("Lake Drive Road, Dhaka, Bangladesh");
			
			driver.longPressKey(new KeyEvent(AndroidKey.ENTER));
			Thread.sleep(2000);
			//driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
			
			driver.longPressKey(new KeyEvent(AndroidKey.ENTER));
			Thread.sleep(2000);
			*/
			
			 //Database connection
			 ResultSet rs=M.Databaseconnection("Select DISTINCT COUNT(pm.ProductId) as count from ProductMaster as pm\r\n"
			 		+ "inner join OutletProductChild as oc on pm.ProductId= oc.ProductId\r\n"
			 		+ "inner join ProductPriceListMaster as plm  \r\n"
			 		+ "inner join ProductPriceListChild as plc on plm.PriceListMasterId=plc.PriceListMasterId\r\n"
			 		+ "where pm.IsDeleted=0 and pm.Status=43 and \r\n"
			 		+ " oc.IsDeleted=0 and oc.OutletId=6 and\r\n"
			 		+ " plm.IsDeleted=0 and plm.IsActive=1 and \r\n"
			 		+ " plm.PriceListMasterId=37 and plc.IsDeleted=0");
			 
			 rs.next();
			 int productQuntity=rs.getInt("count");
			 M.DatabaseConnectinOff();
			 
			 //int appProduct=driver.findElementsByClassName("android.widget.ImageView").size();
			 int appProduct=driver.findElementsById("android.widget.ImageView").size();
			System.out.println(appProduct);
			
/*
			M.ScreenShots("Screenshot/Passed", "CorrectEmailBlankCode");
			M.setStrData("As Expected", "Login", 46, 7);
			M.setStrData("Pass", "Login", 46, 8);
*/
		} catch (Exception e) {
			
			/*
			M.ScreenShots("Screenshot/Failed", "CorrectEmailBlankCode");

			String ErMass = e.toString().substring(0, 123);
			M.setStrData(ErMass, "Login", 46, 7);

			M.setStrData("Fail", "Login", 46, 8);
			*/
			System.out.println("Test case Fail:CorrectEmailBlankCode");
		}

	}

	
	//@Test(priority = 7)
	public void BlankEmailBlankCode() throws IOException {
		Capabilities_Customer();
		int count=0;
		String str = "";
		CallingMethods M = new CallingMethods(driver);
		System.out.println("BlankEmailBlankCode Executed!!");
		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			for (int i = 8; i <= 9; i++) {

				//driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").click();
				//driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").click();

				boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").isEnabled();

				if (tr == true) {
					count++;
					str = str + "\n" +"Without input value Continue Button Enable";
				}

				if (count > 0) {
					throw new Exception(str);
				}

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			}
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			M.ScreenShots("Screenshot/Passed", "BlankEmailBlankCode");
			M.setStrData("As Expected", "Login", 51, 7);
			M.setStrData("Pass", "Login", 51, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "BlankEmailBlankCode");

			String ErMass = e.toString().substring(0, 123);
			M.setStrData(ErMass, "Login", 51, 7);

			M.setStrData("Fail", "Login", 51, 8);

		}

		driver.quit();

	}

	
	//@Test(priority = 8)
	public void ResendOTP() throws IOException {
		Capabilities_Customer();
		CallingMethods M = new CallingMethods(driver);
		System.out.println("ResendOTP Executed!!");

		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String email = M.getstring("Automation Test Data", 2, 1);

			int Intcode = M.getinteger("Automation Test Data", 2, 2);
			String strcode = Integer.toString(Intcode);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();

			Thread.sleep(60000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tv_resend_code").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_log_in").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			M.ScreenShots("Screenshot/Passed", "Recieved And Enter CorrectOTP");
			M.setStrData("As Expected", "Login", 55, 7);
			M.setStrData("Pass", "Login", 55, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Recieved And Enter CorrectOTP");
			String ErMass = e.toString().substring(0, 123);
			M.setStrData(ErMass, "Login", 55, 7);
			M.setStrData("Fail", "Login", 55, 8);

		}

		driver.quit();

	}

	
	//@Test(priority = 9)
	public void ExpiredOTP() throws IOException {
		Capabilities_Customer();
		CallingMethods M = new CallingMethods(driver);
		System.out.println("ExpiredOTP Executed!!");
		int count=0;
		String str = "";
		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String email = M.getstring("Automation Test Data", 2, 1);

			int Intcode = M.getinteger("Automation Test Data", 2, 2);
			String strcode = Integer.toString(Intcode);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();

			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String otp = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_six_digit_pin").getText();
			
			Thread.sleep(60000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tv_resend_code").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_six_digit_pin").clear();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_six_digit_pin").sendKeys(otp);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_log_in").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


			//Error Message..								
			Thread.sleep(2000);
			String Error = M.Error_Message(M.getstring("Automation Test Data", 20, 2), M.getstring("Automation Test Data", 20, 3));
			
			if(Error.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After input Expired OTP :"+ Error;
			}
		
		
			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Failed", "ExpiredOTP");
			M.setStrData("As Expected", "Login", 67, 7);
			M.setStrData("Pass", "Login", 67, 8);
			
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "ExpiredOTP");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Login", 67, 7);
			M.setStrData("Fail", "Login", 67, 8);

		}

		driver.quit();

	}

	
	//@Test(priority = 10)
	public void InvalidOTP() throws IOException {
		Capabilities_Customer();
		CallingMethods M = new CallingMethods(driver);
		int intcode;
		String strcode;
		int count=0;
		String str = "";
		System.out.println("InvalidOTP Executed!!");
		try {

			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String email = M.getstring("Automation Test Data", 2, 1);

			intcode = M.getinteger("Automation Test Data", 2, 2);
			strcode = Integer.toString(intcode);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			for (int i = 1; i <= 5; i++) {

				try {
					intcode = M.getinteger("Automation Test Data", 17, i);
					strcode = Integer.toString(intcode);
				} catch (Exception e) {
					strcode = M.getstring("Automation Test Data", 17, i);
				}

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_six_digit_pin").sendKeys(strcode);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_log_in").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Error Message..								
				Thread.sleep(2000);
				String Error = M.Error_Message(M.getstring("Automation Test Data", 20, 2), M.getstring("Automation Test Data", 20, 3));
				
				if(Error.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"After input Invalid OTP :"+ Error;
				}
			
			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "InvalidOTP");
			M.setStrData("As Expected", "Login", 87, 7);
			M.setStrData("Pass", "Login", 87, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "InvalidOTP");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Login", 87, 7);
			M.setStrData("Fail", "Login", 87, 8);

			System.out.println(" Test case Fail:InvalidOTP");
		}

	}

}
