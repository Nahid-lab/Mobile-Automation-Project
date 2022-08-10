package com.cslsoft.KandareeLiteTestCase;

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
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.testng.ITestResult;

public class LogInWithOTP extends BaseClass{
	
	
	//@Test(priority = 0)
	public void RecievedAndEnterCorrectOTP() throws IOException{
		CallingMethods M=new CallingMethods(driver);
		
		System.out.println("RecievedAndEnterCorrectOTP Executed!!");
		
		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			  String email=M.getstring("Automation Test Data",2,1);
			
			  int Intcode=M.getinteger("Automation Test Data",2, 2); 
			  String strcode =Integer.toString(Intcode);
			
			  driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);
			  
			  driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);
			  
			  driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();
			  
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  
			  driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_log_in").click();
			  Thread.sleep(5000);
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  M.ScreenShots("Screenshot/Passed","Recieved And Enter CorrectOTP");
			  
			  M.setStrData("As Expected","Login", 10, 7);
			  M.setStrData("Pass","Login", 10, 8);
			  
		}catch(Exception e){
			M.ScreenShots("Screenshot/Failed","Recieved And Enter CorrectOTP");
			String ErMass=e.toString().substring(0, 123);
			M.setStrData(ErMass, "Login", 10, 7);
			M.setStrData("Fail","Login", 10, 8);
			
			System.out.println(" Test case Fail:Recieved And EnterCorrectOTP");
		}
		
		driver.quit();
			 
	}
	
	
	//@Test(priority = 1)
	public void CorrectEmailIncorrertCode() throws IOException {
		
		capabilities();
		CallingMethods M = new CallingMethods(driver);
		System.out.println("CorrectEmailIncorrertCode Executed!!");
		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String email = M.getstring("Automation Test Data", 4, 1);
			int Intcode;
			int count=0;
			String strcode;
			String str = "";
			
			for (int i = 2; i <= 8;i++) {
				try {
					Intcode = M.getinteger("Automation Test Data", 4, i);
					strcode = Integer.toString(Intcode);
				} catch (Exception e) {
					strcode = M.getstring("Automation Test Data", 4, i);
				}


				try {
					if(i==2)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();

					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					
					//Error Message..								
					Thread.sleep(2000);
					String Error = M.Error_Message(M.getstring("Automation Test Data", 19, 2), M.getstring("Automation Test Data", 19, 3));
					
					if(Error.isBlank())
					{
						;
					}else
					{
						count++;
						str = str + "\n" +"After input :"+email + "&" + strcode + Error;
					}
	

				}catch (Exception e) {
					str = str + "\n" + e.toString().substring(0, 123);
					throw new Exception(str);

				}

			}
			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Failed", "CorrectEmailIncorrertCode");
			M.setStrData("As Expected", "Login", 19, 7);
			M.setStrData("Pass", "Login", 19, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CorrectEmailIncorrertCode");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Login", 19, 7);
			
			M.setStrData("Fail", "Login", 19, 8);

			System.out.println(" Test case Fail:CorrectEmailIncorrertCode");
		}
		
		driver.quit();

	}

	
	//@Test(priority = 2)
	public void IncorrertEmailCorrertCode() throws IOException {

		capabilities();
		CallingMethods M = new CallingMethods(driver);
		
		try {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			int Intcode = M.getinteger("Automation Test Data", 6, 6);
			String strcode = Integer.toString(Intcode);
			String email;
			int count=0;
			String str = "";
			for (int i = 1; i <= 5; i++) {

				try {
					email = M.getstring("Automation Test Data", 6, i);
					//System.out.println(" Test:"+email);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);

					if(i==1)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();

					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					
				}catch (Exception e) {
					str = str + "\n" + e;
					throw new Exception(str);

				}
				
				
				//Error Message..								
				Thread.sleep(2000);
				String Error = M.Error_Message(M.getstring("Automation Test Data", 19, 2), M.getstring("Automation Test Data", 19, 3));
				
				if(Error.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"After input :"+email + "&" + strcode + Error;
				}

			}
			

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Failed", "IncorrertEmailCorrertCode");
			M.setStrData("As Expected", "Login", 27, 7);
			M.setStrData("Pass", "Login", 27, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "IncorrertEmailCorrertCode");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Login", 27, 7);
			M.setStrData("Fail", "Login", 27, 8);
			System.out.println(" Test case Fail:IncorrertEmailCorrertCode");
		}

		System.out.println("IncorrertEmailCorrertCode Executed!!");
		driver.quit();

	}

	
	//@Test(priority = 3)
	public void IncorrectEmailIncorrertCode() throws IOException {
		capabilities();
		CallingMethods M = new CallingMethods(driver);
		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String email;
			int Intcode;
			String strcode;
			int count=0;
			String str = "";
			System.out.println("IncorrectEmailIncorrertCode Executed!!");
			for (int i = 8; i <= 13; i++) {
				

				try {
				
					try {
						Intcode = M.getinteger("Automation Test Data", i, 2);
						strcode = Integer.toString(Intcode);
					} catch (Exception e) {
						strcode = M.getstring("Automation Test Data", i, 2);
					}
					email = M.getstring("Automation Test Data", i, 1);
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);

					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();

					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					
					
					//Error Message..								
					Thread.sleep(2000);
					String Error = M.Error_Message(M.getstring("Automation Test Data", 19, 2), M.getstring("Automation Test Data", 19, 3));
					
					if(Error.isBlank())
					{
						;
					}else
					{
						count++;
						str = str + "\n" +"After input :"+email + "&" + strcode + Error;
					}
					
				}catch (Exception e) {
					str = str + "\n" + e.toString().substring(0, 123);
					throw new Exception(str);

				}
				

			}
			
			if (count > 0) {
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Failed", "IncorrectEmailIncorrertCode");
			M.setStrData("As Expected", "Login", 34, 7);
			M.setStrData("Pass", "Login", 34, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "IncorrectEmailIncorrertCode");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Login", 34, 7);

			M.setStrData("Fail", "Login", 34, 8);

			System.out.println("Test case Fail:IncorrectEmailIncorrertCode");
		}

		driver.quit();

	}

	
	//@Test(priority = 4)
	public void BlankEmailCorrectCode() throws IOException {
		capabilities();
		CallingMethods M = new CallingMethods(driver);
		System.out.println("BlankEmailCorrectCode Executed!!");
		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			int count=0;
			String str = "";
			int Intcode;
			String strcode;
			for (int i = 8; i <= 14; i++) {
				try {
					Intcode = M.getinteger("Automation Test Data", i, 2);
					strcode = Integer.toString(Intcode);
				} catch (Exception e) {
					strcode = M.getstring("Automation Test Data", i, 2);
				}

				//driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue(strcode);
				boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").isEnabled();

				if (tr == true) {
					count++;
					str = str + "\n" +"After input :"+ strcode + "Continue Button Enable";
				}
			
			
				if (count > 0) {
					throw new Exception(str);
				}

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			}

			M.ScreenShots("Screenshot/Passed", "BlankEmailCorrectCode");
			M.setStrData("As Expected", "Login", 41, 7);
			M.setStrData("Pass", "Login", 41, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "BlankEmailCorrectCode");

			String ErMass = e.toString();
			M.setStrData(ErMass, "Login", 41, 7);

			M.setStrData("Fail", "Login", 41, 8);

			System.out.println("Test case Fail:BlankEmailCorrectCode");
		}

		driver.quit();

	}

	
	//@Test(priority = 5)
	public void CorrectEmailBlankCode() throws IOException {
		capabilities();
		CallingMethods M = new CallingMethods(driver);
		System.out.println("CorrectEmailBlankCode Executed!!");
		try {
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

			String email;
			int count=0;
			String str = "";
			for (int i = 8; i <= 14; i++) {

				email = M.getstring("Automation Test Data", i, 1);

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue(email);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").click();

				boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").isEnabled();

				if (tr == true) {
					count++;
					str = str + "\n" +"After input :"+ email + "Continue Button Enable";
				}

				if (count > 0) {
					throw new Exception(str);
				}

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			}

			M.ScreenShots("Screenshot/Passed", "CorrectEmailBlankCode");
			M.setStrData("As Expected", "Login", 46, 7);
			M.setStrData("Pass", "Login", 46, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CorrectEmailBlankCode");

			String ErMass = e.toString().substring(0, 123);
			M.setStrData(ErMass, "Login", 46, 7);

			M.setStrData("Fail", "Login", 46, 8);

			System.out.println("Test case Fail:CorrectEmailBlankCode");
		}

		driver.quit();
	}

	
	//@Test(priority = 7)
	public void BlankEmailBlankCode() throws IOException {
		capabilities();
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
		capabilities();
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
		capabilities();
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
		capabilities();
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
