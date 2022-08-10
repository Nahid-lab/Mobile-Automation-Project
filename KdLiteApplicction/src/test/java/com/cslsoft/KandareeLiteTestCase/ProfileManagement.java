package com.cslsoft.KandareeLiteTestCase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class ProfileManagement extends BaseClass {
	
	@Test (priority = 0)
	public void Navigate() throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
	
	    driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
	    System.out.println("Navigate Hamburgare to View Profile!");
	   	    
	    
	}
	
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
			
		}catch(Exception e) {
			Thread.sleep(1000);
			driver.quit();
			capabilities();
			Thread.sleep(2000);
			Navigate();
	}


	}
	
	public void FullName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void ShortName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void MobileNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void Gender(String text, int x) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userGender").click();
		driver.findElementByXPath("//android.widget.TextView[@text=\""+text+"\"]").click();
		if(x==1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if(x==2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	}
	public void Department(String text, int x) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\""+text+"\"]").click();
		if(x==1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if(x==2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		List<AndroidElement> xyz=driver.findElementsByClassName("android.widget.TextView");
		for(int j=0;j<xyz.size();j++)
		{
			if(xyz.get(j).getText().contains("Warning"))
			{
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;				
			}
						
		}

	}
	
	public void Designation(String text, int x) {
		CallingMethods M=new CallingMethods(driver);
		
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDesignation").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\""+text+"\"]").click();
		if(x==1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if(x==2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public void ReportingPerson(String text, int x) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\""+text+"\"]").click();
		if(x==1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if(x==2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		List<AndroidElement> xyz=driver.findElementsByClassName("android.widget.TextView");
		for(int j=0;j<xyz.size();j++)
		{
			if(xyz.get(j).getText().contains("Warning"))
			{
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;				
			}
						
		}

	}	
	
	
	//Update Profile Picture	
	//@Test (priority = 1)
	public void updateProfilePicture() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("upload ProfilePicture Executed!");
		try {
			
			 driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[2]").click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 driver.findElementByXPath("//android.widget.TextView[@text='Choose from Gallery']").click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
			// driver.findElementById("android:id/button_once").click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 driver.findElementByXPath("//android.widget.TextView[@text='Downloads']").click();	
			 driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Button\"])[2]/android.widget.ImageView").click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 //driver.findElementByXPath("//com.sec.samsung.gallery.glview.composeView.PositionControllerBase.ThumbObject[3]").click();
			 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(5000);
			 //Title & Massage
			 String title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
			 String mass=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvMessage")).getText();
			 
			 SA.assertEquals(title,M.getstring("Automation Test Data",32,3),"Title doesn't Match");
			 SA.assertEquals(mass,M.getstring("Automation Test Data",32,2),"Massage doesn't Match");
			// Thread.sleep(1000);
			 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			 try {
				SA.assertAll();	
				M.ScreenShots("Screenshot/Passed","update ProfilePicture");
				M.setStrData("As Expected","Profile", 1, 7);
				M.setStrData("Pass","Profile", 1, 8);

			 }catch(AssertionError e)
			 {
				 throw new Exception(e);

			 }
			 
			 
				
		}catch(Exception e ){
			M.ScreenShots("Screenshot/Failed","update ProfilePicture");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 1, 7);
			M.setStrData("Fail","Profile", 1, 8);
			ReStart();			
			
			
		}
		
		 
		
		
	}

	
	
	//Update Profile Info Invalid Input Values
	//@Test (priority = 2)
	public void UpdateProfileInvalidData() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		 System.out.println("Update Profile Info Invalid Input Values Executed!");
		 int count=0;
		 String str="";
		 String ChangeButton = "Change";
		try {		

			for(int i=0;i<=4;i++)
			{
				int j=29;
				
				// All Invalid Data
				if(i==0)
				{
					FullName(M.getstring("Automation Test Data", 30, 1));
					
					ShortName(M.getstring("Automation Test Data", 30, 2));
					
					MobileNumber(M.getstring("Automation Test Data", 30, 5));
					
					M.ScrollByText(ChangeButton);

										
				}	
				// Only mobile field invalid
				else if (i==1)
				{
					FullName(M.getstring("Automation Test Data", j, 1));

					ShortName(M.getstring("Automation Test Data", j, 2));
					
					M.ScrollByText(ChangeButton);
					
					
					

				}
				// Name & short Name Invalid
				else if(i==2)
				{
					FullName(M.getstring("Automation Test Data", j+1, 1));

					ShortName(M.getstring("Automation Test Data",j+1, 2));

					MobileNumber(M.getstring("Automation Test Data", j, 5));
					M.ScrollByText(ChangeButton);

									
				}
				// only Name invalid and all valid
				else if(i==3)
				{
					FullName(M.getstring("Automation Test Data",j+1, 1));

					ShortName(M.getstring("Automation Test Data",j, 2));
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					
					M.ScrollByText(ChangeButton);
	
				}
				
				//only Short Name Ivalid and all valid.
				else
				{
					FullName(M.getstring("Automation Test Data",j, 1));

					ShortName(M.getstring("Automation Test Data",j+1, 2));
					
					M.ScrollByText(ChangeButton);
	
				}
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnChange").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				String title=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvTitle")).getText();
				SA.assertEquals(title,M.getstring("Automation Test Data",32,5),"Update Title doesn't valid");
				String mass=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvMessage")).getText();
				SA.assertEquals(mass,M.getstring("Automation Test Data",32,4),"Update Confirmation Massage doesn't valid");
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					title=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvTitle")).getText();
					SA.assertEquals(title,M.getstring("Automation Test Data",33,7),"Fail Title doesn't valid");
				}catch(Exception x)
				{
					str=str+"\n"+i+": Fail Title Not Found";
					count++;
				}
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				mass=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvMessage")).getText();
				
				if(mass.equals(M.getstring("Automation Test Data",32,2))) {
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					if(i==2)
						str=str+"\n"+"Full & Short Name Field Accept invalid Data";
					else if(i==3)
						str=str+"\n"+"Full Name Field Accept invalid Data";
					else if(i==4)
						str=str+"\n"+"Short Name Field Accept invalid Data";
					

				}
				else
				{
					 
					 if(i<2)
					 {
						 SA.assertEquals(mass,M.getstring("Automation Test Data",33,2),"Phone Number Massage doesn't valid");
					 }
					 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				}
				try {
					
					SA.assertAll();	
					
				 }catch(AssertionError e)
				 {
					 //throw new Exception(e);
					 count++;
					 str=str+"\n"+e;
					 
				 }

				Thread.sleep(5000);
				M.Scroll(2);	

			}
			if(count>0)
			{
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","UpdateProfileInvaliData");	  
			M.setStrData("As Expected","Profile", 10, 7);
			M.setStrData("Pass","Profile", 10, 8);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}catch(Exception e){
			M.ScreenShots("Screenshot/Failed","UpdateProfileInvaliData");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 10, 7);
			M.setStrData("Fail","Profile", 10, 8);
			ReStart();
			
		}
		
		 
	}

	//Mobile Number Verification
	//@Test (priority = 3)
	public void MobileNumberVerification() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		int count=0;
		String str="";
		System.out.println("Mobile Number Verification Executed!");
		try {
			for (int i = 1; i < 5; i++) {
				
				MobileNumber(M.getstring("Automation Test Data", 38, i));
			
				Thread.sleep(100);
				M.ScrollByText("Change");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnChange").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					String title=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvTitle")).getText();
					SA.assertEquals(title,M.getstring("Automation Test Data",33,7),title+"- Title doesn't valid");
				}catch(Exception e) {
					count++;
					str=str+"\n After input:"+M.getstring("Automation Test Data", 38, i)+": Title Body Not Found";
				}
				
				try {
					String mass = driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvMessage")).getText();	
					SA.assertEquals(mass, M.getstring("Automation Test Data", 33, i+2),mass+"- Message doesn't valid");
				}catch(Exception e) {
					count++;
					str=str+"\n After input:"+M.getstring("Automation Test Data", 38, i)+": Message Body Not Found";
				}
				
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				try {
					
				SA.assertAll();
				
				} catch (AssertionError e) {
					str=str+"\n"+e;
					count++;
				}
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
				
			M.ScreenShots("Screenshot/Passed","CheckMobileField");
			M.setStrData("As Expected","Profile",40, 7);
			M.setStrData("Pass","Profile", 40, 8);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","UpdateProfileInvaliData");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 40, 7);
			M.setStrData("Fail","Profile", 40, 8);
			ReStart();
			
		}
		

	}
	
	//Verify Cancel & Change Button Disabled (Default state without edit)
	//@Test (priority = 4)
	public void VarifyDisableDefault() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Cancel & Change Button Disabled Executed!");
		try {
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    Thread.sleep(1000);
		    driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    Thread.sleep(1000);
		    driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
			int change=0;
			int cancel=0;
			String str="";
			Thread.sleep(5000);
			M.ScrollByText("Change");
			boolean tr;
			tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnChange").isEnabled();
			if(tr==true)
			{
				change++;
				str="Change Button Doesn't Disable ";
			}

			tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancel").isEnabled();
			if(tr==false)
			{
				cancel++;
				str=str+"\n "+"Cancel Button Doesn't Enable";
			}
			if(change==1 || cancel==1)
			{
				throw new Exception(str);	
			}
			M.ScreenShots("Screenshot/Passed","VarifyDisableDefault");
			M.setStrData("As Expected","Profile",51, 7);
			M.setStrData("Pass","Profile", 51, 8);
			

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","VarifyDisableDefault");
			String ErMass=e.toString();//.substring(0, 123)
			M.setStrData(ErMass, "Profile", 51, 7);
			M.setStrData("Fail","Profile", 51, 8);
			ReStart();				
		}
		
		
	}

	//Verify Cancel & Change Button Disable/Enable (With Blank Field)
	//@Test (priority = 5)
	public void BlankFieldVerifyButton() throws Exception {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Blank Field Verify Button Executed!");
		int count=0;
		String str="";

		try {
			for(int i=1;i<=3;i++)
			{
				Thread.sleep(5000);
				M.Scroll(1);
				if(i==1)
				{
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").clear();
					driver.hideKeyboard();
				}else if(i==2)
				{
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").setValue(M.getstring("Automation Test Data", 29, 1));
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").clear();
					driver.hideKeyboard();

				}else
				{
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").setValue(M.getstring("Automation Test Data", 29, 2));
					
					M.ScrollByText("Change");
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").clear();
					driver.hideKeyboard();

				}

				M.ScrollByText("Change");
				boolean tr;
				tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnChange").isEnabled();
				if(tr==true)
				{
					count++;
					str=str+"\n "+i+" Change Button Doesn't Disable ";
				}

				tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancel").isEnabled();
				if(tr==false)
				{
					count++;
					str=str+"\n "+i+" Cancel Button Doesn't Enable";
				}
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			   
			    driver.findElementByXPath("//android.widget.TextView[@text='Home']").click(); 
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			    
			    if(i==1) {
			    	try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					} catch (Exception e) {
						count++;
						str = str + "\n" + "After Edit profile and when go to another page no warning message found.";
					}
			    	
			    }
			    
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			    driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
			    Thread.sleep(2000);	
				
			}
			if(count>0)
			{
				throw new Exception(str);	
			}

			
			M.ScreenShots("Screenshot/Passed","BlankFieldVerifyButton");
			M.setStrData("As Expected","Profile",58, 7);
			M.setStrData("Pass","Profile", 58, 8);
			

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","BlankFieldVerifyButton");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 58, 7);
			M.setStrData("Fail","Profile", 58, 8);
				
		}
		ReStart();
		
		
	}

	//Varify Change & Cancel Button (Disable To Enable)	
	//@Test (priority = 6)
	public void VarifyDisableToEnable() throws Exception {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Varify Disable To Enable Executed!");
		int count=0;
		String str="";
		String text="";
		try {
			for(int i=1;i<=7;i++)
			{
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			   
			    driver.findElementByXPath("//android.widget.TextView[@text='Home']").click(); 
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			    
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			    driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
			    Thread.sleep(2000);		
				
				if(i==1)
				{
					FullName(M.getstring("Automation Test Data", 29, 1));
					text=" After Edit FullName";
					M.ScrollByText("Change");
				}
				if(i==2)
				{
					ShortName(M.getstring("Automation Test Data", 29, 2));
					text=" After Edit ShortName";
					M.ScrollByText("Change");
				}
				if(i==3)
				{
					MobileNumber(M.getstring("Automation Test Data", 29, 5));
					text=" After Edit MobileNumber";
					M.ScrollByText("Change");
				}
				if(i==4)
				{
					Gender(M.getstring("Automation Test Data", 29, 3),1);
					text=" After Edit Gender";
					M.ScrollByText("Change");
				}
				if(i==5)
				{
					M.ScrollByText("Change");
					Department(M.getstring("Automation Test Data", 29, 6),1);
					text=" After Edit Department";
					
				}
				if(i==6)
				{
					M.ScrollByText("Change");
					Designation(M.getstring("Automation Test Data", 29, 7),1);
					text=" After Edit Designation";
					
				}
				if(i==7)
				{
					M.ScrollByText("Change");
					ReportingPerson(M.getstring("Automation Test Data", 29, 8),1);
					text=" After Edit Reporting Person";
					
				}
				
				boolean tr;
				tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnChange").isEnabled();
				if(tr==false)
				{
					count++;
					str=str+"\n "+i +text+" Change Button Doesn't Enable ";
				}

				tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancel").isEnabled();
				if(tr==false)
				{
					count++;
					str=str+"\n "+i +text+" Cancel Button Doesn't Enable";
				}

			}		

			if(count>0)
			{
				throw new Exception(str);	
			}
			M.ScreenShots("Screenshot/Passed","VarifyDisableToEnable");
			M.setStrData("As Expected","Profile",73, 7);
			M.setStrData("Pass","Profile", 73, 8);
			

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","VarifyDisableToEnable");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 73, 7);
			M.setStrData("Fail","Profile", 73, 8);
			ReStart();				
		}
		
	}

	//Dismiss Selected Value From Dropdown
	//@Test (priority = 7)
	public void DismissSelectedValueFromDropdown() throws Exception {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown Executed!");
		int i=29;
		int dept=0;
		int Report=0;
		String testdata;
		String testdata1;
		
		try {
			Thread.sleep(2000);
			M.Scroll(2);
			//Gender
			Gender(M.getstring("Automation Test Data", 30, 3),2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtGender").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 3), "Gender value selected from Dropdown After cancel");

			M.ScrollByText("Change");
			//Department
			Department(M.getstring("Automation Test Data", 30, 6),2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 6), "Department value selected from Dropdown After cancel");
			
			//Department
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
			M.ScrollByText(M.getstring("Automation Test Data", 30, 10));
			driver.findElementByXPath("//android.widget.TextView[@text=\""+M.getstring("Automation Test Data", 30, 10)+"\"]").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			
			Thread.sleep(1000);
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
			
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains("Warning")) {
					dept++;
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					testdata1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
					SA.assertEquals(testdata1, testdata, "Department value selected from Dropdown After click NO");

					break;
				}

			}
			if (dept == 0) {
				testdata1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
				SA.assertEquals(testdata1, testdata, "Department Warning Message Missing so that input value except.");
			}

			//Designation
			Designation(M.getstring("Automation Test Data", 30, 7), 2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdDesignation").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 7),"Designation value selected from Dropdown After cancel");

			//ReportingPerson
			ReportingPerson(M.getstring("Automation Test Data", 30, 8),2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 8),"Reporting Person value selected from Dropdown After cancel");
			
			//ReportingPerson
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
			M.ScrollByText(M.getstring("Automation Test Data", 30, 9));
			driver.findElementByXPath("//android.widget.TextView[@text=\""+M.getstring("Automation Test Data", 30, 9)+"\"]").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			Thread.sleep(1000);
			List<AndroidElement> xyz1 = driver.findElementsByClassName("android.widget.TextView");
			
			for (int j = 0; j < xyz1.size(); j++) {
				if (xyz1.get(j).getText().contains("Warning")) {
					Report++;
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					testdata1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();

					SA.assertEquals(testdata1, testdata, "Reporting Person value selected from Dropdown After click NO");
					break;
				}

			}
			if (Report == 0)
			{
				testdata1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
				SA.assertEquals(testdata1, testdata, "Reporting Person Warning Message Missing so that input value except.");
			}
				
			

			try {
				SA.assertAll();
			} catch (AssertionError e) {
				throw new Exception(e);
			}

			M.ScreenShots("Screenshot/Passed", "DismissSelectedValueFromDropdown");
			M.setStrData("As Expected", "Profile", 129, 7);
			M.setStrData("Pass", "Profile", 129, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "DismissSelectedValueFromDropdown");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Profile", 129, 7);
			M.setStrData("Fail", "Profile", 129, 8);
			ReStart();
		}

	}
	
	
	public void UpdateProfileData(int i) throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		
		Thread.sleep(5000);
		M.Scroll(1);
		Thread.sleep(1000);

		FullName(M.getstring("Automation Test Data", i, 1));
		
		ShortName(M.getstring("Automation Test Data", i, 2));
		
		MobileNumber(M.getstring("Automation Test Data", i, 5));
		
		Gender(M.getstring("Automation Test Data", i, 3),1);
		
		M.ScrollByText("Change");
		Department(M.getstring("Automation Test Data", i, 6),1);
		
		Designation(M.getstring("Automation Test Data", i, 7),1);
		
		ReportingPerson(M.getstring("Automation Test Data", i, 8),1);

	}
	
	//Update Profile Info Valid Input Values
	//@Test (priority = 8)
	public void UpdateProfileValidData() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update Profile Valid Data Executed!");
		int i=29;
		String title="";
		String message="";
		int count = 0;
		String str = "";
		try {
			Thread.sleep(2000);
			M.Scroll(2);
			Thread.sleep(3000);
			UpdateProfileData(i);
			
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnChange").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
			try {
				title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				SA.assertEquals(title, M.getstring("Automation Test Data", 32, 5), "Update Title Doesn't Match");
			}catch(Exception e) {
				count++;
				str=str+"\n"+": Confirmation Title Body Not Found";
			}
			
			try {
				message=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				SA.assertEquals(message, M.getstring("Automation Test Data", 32, 4), "Update Message Doesn't Match");	
			}catch(Exception e) {
				count++;
				str=str+"\n"+i+": Confirmation Message Body Not Found";
			}		
			
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
			try {
				title=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvTitle")).getText();
				SA.assertEquals(title,M.getstring("Automation Test Data",33,7),title+"- Title doesn't valid");
			}catch(Exception e) {
				count++;
				str=str+"\n"+": Success Title Body Not Found";
				
			}
			
			try {
				String mass = driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/tvMessage")).getText();	
				SA.assertEquals(mass, M.getstring("Automation Test Data", 33, i+2),mass+"- Message doesn't valid");
			}catch(Exception e) {
				count++;
				str=str+"\n"+": Success Message Body Not Found";
			}

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if(count>0)
			{
				throw new Exception(str);
				
			}
			
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				throw new Exception(e);
			}
			
			 M.ScreenShots("Screenshot/Passed","Update ProfileInfo");
			 M.setStrData("As Expected","Profile", 154, 7);
			 M.setStrData("Pass","Profile", 154, 8);
			
			
		}catch(Exception e){
			M.ScreenShots("Screenshot/Failed","Update ProfileInfo");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Profile", 154, 7);
			M.setStrData("Fail","Profile", 154, 8);
			ReStart();
		}
		
		
		//driver.quit();
	}
	
	
	public void VarifyProfileData(int i) throws IOException, InterruptedException {
		SoftAssert SA = new SoftAssert();
		CallingMethods M = new CallingMethods(driver);

		String testdata;
		Thread.sleep(5000);
		M.Scroll(1);
		

		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 1), "FullName  Doesn't Match");

		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 2), "ShortName Doesn't Match");

		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtGender").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 3), "Gender Doesn't Match");

		M.ScrollByText("Change");
		
		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSignUpUserEmail").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 4), "SignUp User Email Doesn't Match");

		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 5), "Phone Number Doesn't Match");

		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 6), "Department Doesn't Match");

		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdDesignation").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 7), "Department Doesn't Match");

		testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
		SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 8), "Department Doesn't Match");

		SA.assertAll();
		// driver.quit();
	}

	//Verify Updated Profile Data
	//@Test (priority = 9)
	public void VerifyUpdatedProfileData() throws IOException, InterruptedException {
		SoftAssert SA=new SoftAssert();
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Verify Updated Profile Data Executed!");
		try {
			Thread.sleep(2000);
			M.Scroll(2);
			
			VarifyProfileData(29);
			M.ScreenShots("Screenshot/Passed", "Update ProfileInfo");
			M.setStrData("As Expected", "Profile",184, 7);
			M.setStrData("Pass", "Profile", 184, 8);

		} catch (AssertionError e) {
			M.ScreenShots("Screenshot/Failed","Update ProfileInfo");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 184, 7);
			M.setStrData("Fail","Profile",184, 8);
			ReStart();
		}
		
		
		//driver.quit();
	}
	
	//Decline Update Request
	//@Test (priority = 10)
	public void DeclineUpdateRequest() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Decline Update Request Executed!");
		String PageTitle="";
		String str="";
		int count=0;
		try {
			Thread.sleep(2000);
			M.Scroll(2);
			
			UpdateProfileData(36);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnChange").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try {
				PageTitle=driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
				assertEquals(PageTitle, M.getstring("Automation Test Data", 28, 5), "Profile Page Not Found After update warning message No");
				Thread.sleep(2000);
				M.Scroll(2);
				VarifyProfileData(36);

			} catch (AssertionError e) {
				count++;
				str=str+"\n "+e;
			}
			
			try {
				// Navigate
				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(2000);
								
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
				} catch (Exception y) {
					;
				}
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				PageTitle=driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
				assertEquals(PageTitle, M.getstring("Automation Test Data", 28, 5), "Profile Page Not Found");
				
				VarifyProfileData(29);

			}catch (AssertionError e) {
				count++;
				str=str+"\n "+e;
			}
			
			if (count>0)
				throw new Exception(str);		
					
			M.ScreenShots("Screenshot/Passed", "SaveButtonDenieAfterchange");
			M.setStrData("As Expected", "Profile", 196, 7);
			M.setStrData("Pass", "Profile", 196, 8);

		}catch(Exception e){
			M.ScreenShots("Screenshot/Failed","SaveButtonDenieAfterchange");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 196, 7);
			M.setStrData("Fail","Profile", 196, 8);
			
		}
		ReStart();
		
		//driver.quit();
	}
	
	//Decline Cancel Request
	//@Test (priority = 11)
	public void DeclineCancelRequest() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Decline Cancel Request Executed!");
		String PageTitle="";
		String str="";
		int count=0;
		Thread.sleep(2000);
		M.Scroll(2);
		try {
			UpdateProfileData(36);
			Thread.sleep(2000);
			
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancel").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 34, 5), M.getstring("Automation Test Data", 34, 4));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}

			try {
				PageTitle = driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
				assertEquals(PageTitle, M.getstring("Automation Test Data", 28, 5),"Profile Page Not Found After click No");

				VarifyProfileData(36);

			} catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			try {
				// Navigate
				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(2000);
				
				
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
				} catch (Exception y) {
					;
				}

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				PageTitle = driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
				assertEquals(PageTitle, M.getstring("Automation Test Data", 28, 5), "Profile Page Not Found");

				VarifyProfileData(29);

			} catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			if (count > 0)
				throw new Exception(str);

			M.ScreenShots("Screenshot/Passed", "CancelDenieAfterchange");
			M.setStrData("As Expected", "Profile", 211, 7);
			M.setStrData("Pass", "Profile", 211, 8);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CancelDenieAfterchange");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Profile", 211, 7);
			M.setStrData("Fail","Profile", 211, 8);
			
		}
		ReStart();
		
		//driver.quit();
	}
	
	
	//Dismiss Unsaved Data In Default & All Fields
	//@Test (priority = 12)
	public void DismissUnsavedDataInDefaultAllFields() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Data Dismiss Warning Mass Executed!");
		String title="";
		String str="";
		int count=0;
		String title1="";
		String message="";
		try {
			Thread.sleep(5000);
			M.BackFun(1);
			
			try {
				title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_companyName").getText();
				assertEquals(title, M.getstring("Automation Test Data", 28, 6), "Home Page Doesn't Found");	
			}catch (Exception e) {
				count++;
				str = str + "\n " + e;
			}
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();	
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();

		    Thread.sleep(2000);
			UpdateProfileData(36);
			for(int i=1;i<=2;i++)
			{
				Thread.sleep(5000);
				M.BackFun(1);
				
				try {
					title1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(title1, M.getstring("Automation Test Data", 34, 5), "Warning Title Doesn't Match");
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Warning Title Body Not Found";
				}

				try {
					message=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					SA.assertEquals(message, M.getstring("Automation Test Data", 34, 4), "Warning Message Doesn't Match");	
					if(i==1) 
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();	
					else {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						
						Thread.sleep(2000);		
						title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_companyName").getText();
						assertEquals(title, M.getstring("Automation Test Data", 28, 6), "After click warning message Yes, Home Page Doesn't Found");	
					    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();	
					    Thread.sleep(2000);	
					    driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
					    Thread.sleep(5000);	
					}
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				}catch(Exception e) {
					Thread.sleep(2000);		
					title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_companyName").getText();
					assertEquals(title, M.getstring("Automation Test Data", 28, 6), "After click warning message Yes, Home Page Doesn't Found");	
				    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();	
				    Thread.sleep(1000);	
				    driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
				    Thread.sleep(5000);	
					count++;
					str=str+"\n"+"Warning Message Body Not Found";
					i++;
				}
				if(i==1)
					try {
						title=driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
						assertEquals(title, M.getstring("Automation Test Data", 28, 5), "Profile Page Not Found After click No");
						VarifyProfileData(36);
					}catch (AssertionError e) {
						count++;
						str = str + "\n " + e;
					}							
			}
			
			try {
				title=driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
				assertEquals(title, M.getstring("Automation Test Data", 28, 5), "Profile Page Not Found After click No");
				VarifyProfileData(29);
			}catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			try {
				SA.assertAll();
			}catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			if(count>0)
				throw new Exception(str);
			

			M.ScreenShots("Screenshot/Passed", "BackButtonWarningMass");
			M.setStrData("As Expected", "Profile", 228, 7);
			M.setStrData("Pass", "Profile", 228, 8);

	
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","BackButtonWarningMass");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 228, 7);
			M.setStrData("Fail","Profile", 228, 8);

		}
		ReStart();

	}
	
	
	
	//Dismiss Unsaved Data For Each Field
	@Test (priority = 13)
	public void DismissUnsavedDataForEachField() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Unsaved Data For Each Field Executed!");
		String title="";
		String str="";
		String testdata="";
		int count=0;
		String title1="";
		String message="";
		//Thread.sleep(5000);
		try {

			for(int i=1;i<=7;i++)
			{
				Thread.sleep(5000);
				M.Scroll(1);
				
				if(i==1)
					FullName(M.getstring("Automation Test Data", 36, 1));
				else if(i==2)
					ShortName(M.getstring("Automation Test Data", 36, 2));
				else if(i==3)
					Gender(M.getstring("Automation Test Data", 36, 3), 1);
				else if(i==4)
					MobileNumber(M.getstring("Automation Test Data", 36, 5));				
				else if (i==5) {
					Thread.sleep(2000);
					M.ScrollDwon(1);
					Department(M.getstring("Automation Test Data", 36, 6), 1);
				}					
				else if(i==6){
					Thread.sleep(2000);
					M.ScrollDwon(1);
					Designation(M.getstring("Automation Test Data", 36, 7), 1);
				}
					
				else{
					Thread.sleep(2000);
					M.ScrollDwon(1);
					ReportingPerson(M.getstring("Automation Test Data", 36, 8), 1);
				}			
								
				Thread.sleep(5000);
				M.BackFun(1);
				
				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 34, 5), M.getstring("Automation Test Data", 34, 4));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",36, i)+ confirmation;
				}	
				
				
				
				
				//Verify Add Bank Asset page is present 
				Thread.sleep(2000);
				try {
					String gettext= driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
					
					if(i==1) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data", 36, 1), "FullName  Doesn't Match");
					}
					if(i==2) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data", 36, 2), "ShortName Doesn't Match");
					}
					if(i==3) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtGender").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data", 36, 3), "Gender Doesn't Match");
					}
					if(i==4) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSignUpUserEmail").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data", 36, 4), "SignUp User Email Doesn't Match");
					}
					if(i==5) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data", 36, 5), "Phone Number Doesn't Match");
					}
					Thread.sleep(2000);
					M.ScrollByText("Change");
					if(i==6) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data", 36, 6), "Department Doesn't Match");
					}
					if(i==7) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdDesignation").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data", 36, 7), "Department Doesn't Match");
					}
					
					if(i==8) {
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
						SA.assertEquals(testdata, M.getstring("Automation Test Data",36, 8), "Department Doesn't Match");
					}
					
					
					// Back Button!!
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(2000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.TextView[@text='View Profile']").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

						String PageTitle = driver.findElementByXPath("//android.widget.TextView[@text='Profile']").getText();
					}catch (Exception e) {
						count++;
						str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
						throw new Exception(str);
					}
					

				} catch (Exception e) {	
					Thread.sleep(1000);
					str = str + "\n" + " After click Back button and warning message no, Page Redirect to home page";
					throw new Exception(str);
				}

			}
			try {
				SA.assertAll();
			}catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			if(count>0)
				throw new Exception(str);
			

			M.ScreenShots("Screenshot/Passed", "BackButtonWarningMass");
			M.setStrData("As Expected", "Profile", 245, 7);
			M.setStrData("Pass", "Profile", 245, 8);

	
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","BackButtonWarningMass");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 245, 7);
			M.setStrData("Fail","Profile", 245, 8);

		}
		ReStart();

	}
	
	
	//Verify Changing Department & Reporting Person Conditions
	//@Test (priority = 14)
	public void VerifyChangingDepartmentReportingPerson() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Changing Department & Reporting Person Conditions Executed!");
		String title="";
		String str="";
		String testdata="";
		int count=0;
		int k=40;
		String title1="";
		String message="";
		
		try{
			for(int i=1;i<=7;i++)
			{
				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				if(i==1){
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==2) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==3) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==4) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==5) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==6) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				
				//
				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(title1, M.getstring("Automation Test Data", 61, 2), "Warning Title Doesn't Match");
					if(i==4||i==7)
					{
						str = str + "\n" +i+ "Department & Reporting person are same but found warnning Title";
					}
				} catch (Exception e) {
					
					if(i!=4) {
						if(i!=7)
						{
							count++;
							str = str + "\n" +i+ "Warning Title Body Not Found";
						}else
						{
							System.out.println("Department & Reporting person are same department");
						}
						
					}else
					{
						System.out.println("Department & Reporting person are same department");
					}
				}

				try {
					message=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					SA.assertEquals(message, M.getstring("Automation Test Data", 61, 3), "Warning Message Doesn't Match");	
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					if(i==4||i==754)
					{
						str = str + "\n" +i+ "Department & Reporting person are same but found warnning Message";
					}
				} catch (Exception e) {
					
					if(i!=4) {
						if(i!=754)
						{
							count++;
							str = str + "\n" +i+ "Warning Message Body Not Found";
						}else
						{
							System.out.println("Department & Reporting person are same department");
						}
						
					}else
					{
						System.out.println("Department & Reporting person are same department");
					}
					
				}


			}
			
			try {
				SA.assertAll();
			}catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			if(count>0)
				throw new Exception(str);
			
			M.ScreenShots("Screenshot/Passed", "BackButtonWarningMass");
			M.setStrData("As Expected", "Profile", 312, 7);
			M.setStrData("Pass", "Profile", 312, 8);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","BackButtonWarningMass");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Profile", 312, 7);
			M.setStrData("Fail","Profile", 312, 8);

		}
		ReStart();

	}
		
	
	
	
}
	
	
		
