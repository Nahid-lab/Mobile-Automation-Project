package com.cslsoft.KandareeLiteTestCase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.touch.offset.PointOption;

public class LibraryManagement extends BaseClass  {
	
	@Test (priority = 0)
	public void nevigate() throws IOException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Library']").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("Navigate Hamburgare to Library!");
		
		}
	public void Createlibrary(String text) {
		
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").setValue(text);
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		//Successful Added Message
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();


	}
	
	public void GoToEntity(int row, int col, int j, int i) throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		String EntityType;
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_libraryDepartment").click();
		EntityType=M.getstring("Automation Test Data", row, col+j);
		Thread.sleep(1000);
		M.ScrollByText(EntityType);
		//System.out.println(EntityType);
		Thread.sleep(2000);
		M.ClickOn(EntityType);
		//driver.findElementByXPath("//android.widget.TextView[@text=[@text=\"" + EntityType+ "\"]]").click();
		if(i==1)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		if(i==0)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		

	}
	
	private void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Library Values']").getText();
			Assert.assertEquals(text,"Library Values");
		}catch(Exception x) {
			Thread.sleep(1000);
			driver.quit();
			capabilities();
			Thread.sleep(2000);
			nevigate();
	}


	}
	
	
	//@Test (priority = 1)
	public void Demo()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Create Attribute and CheckEnttity Executed!");
		int count=0;
		String str="";
		try {
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 445, 6);
			M.setStrData("Pass","Automation Testcase", 445, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 445, 6);
			M.setStrData("Fail","Automation Testcase", 445, 7);
			
			ReStart();
		}
		GoToEntity(69,1,0,1);
		
		
		
	}
	
	
	
	//@Test (priority = 1)
	public void C()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Create Attribute and CheckEnttity Executed!");
		int count=0;
		String str="";
		int j=0;
		int k=0;
		String data=M.getstring("Automation Test Data", 71, 1);
		try {
			
			try {
				String PageTitle=driver.findElementByXPath("//android.widget.TextView[@text=\""+data+"\"]").getText();
				Assert.assertEquals(PageTitle, data, "\n Page Title Doesn't Match");
			}catch(Exception e) {
				count++;
				str=str+e;
			}
			
			try {
				data=M.getstring("Automation Test Data", 71, 2);
				String Title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvLibrary").getText();
				Assert.assertEquals(Title, data, "\n Selected Library Entite Doesn't Match");
			}catch(Exception e) {
				count++;
				str=str+e;
			}
			
			GoToEntity(69,12,0,1);
			
			M.ScrollByText("Female");
			
			Point p2=driver.findElementByXPath("//android.widget.TextView[@text='Female']").getLocation();
			Point p1=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_libraryImage").getLocation();
			
			Thread.sleep(2000);
			M.Swipping(p1,p2);
			Thread.sleep(2000);
			
			List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains("Edit")) {
					count++;
					str=str+"\n System value show edit option";
				}
				else if(xyz.get(i).getText().contains("Delete")) {
					count++;
					str=str+"\n System value show Delete option";
				}
				else if(xyz.get(i).getText().contains("Disable")) {
					j++;
				}
				else if(xyz.get(i).getText().contains("Enable")) {
					if(j>0)
					{
						count++;
						str=str+"\n Disable & Enable Button show ";
					}
					driver.findElementByXPath("//android.widget.TextView[@text='Enable']").click();
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					}catch(Exception e) {
						count++;
						str=str+"\n Enable sucessfully message body not found";
					}
					j++;
					
					Thread.sleep(2000);
					M.ScrollByText("Female");
					
					Thread.sleep(2000);
					M.Swipping(p1,p2);
					Thread.sleep(2000);
					
				}else
					;
			
			}
			
			if(j>0) {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_disableMain").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				}catch(Exception e) {
					count++;
					str=str+"\n Disable sucessfully message body not found ";
				}
				
			}
			
			Thread.sleep(2000);
			M.SwipBytext("Female");
			Thread.sleep(2000);
			List<AndroidElement> xyz1 = driver.findElementsByXPath("//android.widget.TextView");
			for (int i = 0; i < xyz1.size(); i++) {
				if(xyz1.get(i).getText().contains("Enable")) {
					k++;
					driver.findElementByXPath("//android.widget.TextView[@text='Enable']").click();
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					}catch(Exception e) {
						count++;
						str=str+"\n Enable sucessfully message body not found ";
					}
				}
					
			}
			if(k==0)
			{
				count++;
				str=str+"\n Enable Button not found";
			}

			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 445, 6);
			M.setStrData("Pass","Automation Testcase", 445, 7);
			Thread.sleep(1000);
			GoToEntity(69,1,0,1);
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 445, 6);
			M.setStrData("Fail","Automation Testcase", 445, 7);
			
			ReStart();
		}
		
		
		
		
	}
	
	
	//@Test (priority = 2)
	public void CreateAttributeNCheckEnttity()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Create Attribute and CheckEnttity Executed!");
		try {
			
			String EntityType="";
			String data="";
			String title="";
			String mess="";
			String str="";
			int count=0;
			int row=69;
			int col=30;
			int fail=0;
			Thread.sleep(10000);
			for(int i=1;i<=col;i++) {
				EntityType=M.getstring("Automation Test Data", row, i);
				data="Create Library value For "+EntityType;
				int k=0;
				int create=0;
				try{
					
					Thread.sleep(2000);
					List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
					for (int j = 0; j < xyz.size(); j++) {
						//System.out.println(xyz.get(j).getText());
						if(xyz.get(j).getText().contains(data)) {
							create++;
						}
						
					}
					
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
					} catch (Exception e) {
						
						fail=1;
						throw new Exception (e);
					}
					
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").setValue(data);
					driver.hideKeyboard();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
					
					Thread.sleep(2000);
					List<AndroidElement> xyz1 = driver.findElementsByXPath("//android.widget.TextView");
					for (int j = 0; j < xyz1.size(); j++) {
						//System.out.println(xyz.get(j).getText());
						if(xyz1.get(j).getText().contains(data)) {
							k++;
						}						
					}
					if(k>create) {
						count++;
						str=str+"\n After cancel Library value="+data+" create in entity page";	
						create=k;
						k=0;
					}
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").setValue(data);
					driver.hideKeyboard();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
					
					
					//Successful Added Message
					
					try {
						title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// System.out.println(title);
						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 75, 2),"\n- Successfull Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Title Body Not Found";
					}

					try {
						mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						try {
							Assert.assertEquals(mess, M.getstring("Automation Test Data", 75, 3),"\n- Successfull Message doesn't valid");

						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Message Body Not Found";
					}
					
					Thread.sleep(2000);
					List<AndroidElement> xyz2 = driver.findElementsByXPath("//android.widget.TextView");
					for (int j = 0; j < xyz2.size(); j++) {
						if(xyz2.get(j).getText().contains(data)) {
							k++;						
						}						
					}
					if(k<=create)
					{
						count++;
						str = str + "\n" +EntityType+ "New Library value doesn't Create";
					}
					
					
					
					//System.out.println(i);
				}catch(Exception e) {
					if(fail==1) {
						count++;
						str=str+"\n"+EntityType+" \'+\' button Not Found";
					}
					else
						throw new Exception (e);
					
				}	
				
				  if(i!=col) {
					  GoToEntity(row,i,1,0);
					  Thread.sleep(2000);
					  String entity=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvLibrary").getText(); 
					  //System.out.println(entity);
					  try {
						  Assert.assertEquals(entity,EntityType,"\n "+EntityType+" = After cancel to select entity Type But it selected ");
				  }catch (AssertionError e) { 
					  count++; 
					  str = str + e; 
					  }
				  
				  GoToEntity(row,i,1,1); 
				  Thread.sleep(2000);
				  entity=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvLibrary").getText();
				  
				  if(entity.contentEquals(EntityType)) 
				  {
					  count++; 
					  str=str+"\n "+EntityType+" = Selected Library Entite Type Doesn't Match with = "+entity;
					  
				  }
				  
				  
				  }
				 
				
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 445, 6);
			M.setStrData("Pass","Automation Testcase", 445, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 445, 6);
			M.setStrData("Fail","Automation Testcase", 445, 7);
			
			ReStart();
		}
		GoToEntity(69,1,0,1);
		
		
		
	}
	

	//@Test (priority = 3)
	public void UpdateAttribute()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Update Attribute Executed!");
		try {
			
			String EntityType;
			String Entityvalue="";
			String data="";
			String title="";
			String mess="";
			String str="";
			int count=0;
			int row=69;
			int col=30;
			
			Thread.sleep(10000);
			for(int i=1;i<=col;i++) {
				EntityType=M.getstring("Automation Test Data", row, i);
				Entityvalue="Create Library value For "+EntityType;
				data="Update Library value For "+EntityType;
				int k=0;
				int create=0;
				
				Thread.sleep(2000);
				List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
				for (int j = 0; j < xyz.size(); j++) {
					//System.out.println(xyz.get(j).getText());
					if(xyz.get(j).getText().contains(data)) {
						create++;
					}
					
				}

				try{
					Thread.sleep(5000);
					M.ScrollByText(Entityvalue);
					Thread.sleep(2000);
					//Update-cancel
					M.SwipBytext(Entityvalue);
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_editMain").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").setValue(data);
					driver.hideKeyboard();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
					
					
					Point p1=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_disableMain").getLocation();
					Point p2=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_deleteMain").getLocation();
					
					Thread.sleep(2000);
					M.Swipping(p1,p2);
					Thread.sleep(5000);
					List<AndroidElement> xyz1 = driver.findElementsByXPath("//android.widget.TextView");
					for (int j = 0; j < xyz1.size(); j++) {
						//System.out.println(xyz.get(j).getText());
						if(xyz1.get(j).getText().contains(data)) {
							k++;
						}						
					}
					if(k>create) {
						count++;
						str=str+"\n After cancel Library value="+data+" create in entity page";	
						create=k;
						k=0;
					}
					Thread.sleep(5000);
					//Update-done
					M.ScrollByText(Entityvalue);
					Thread.sleep(2000);
					M.SwipBytext(Entityvalue);
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_editMain").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").setValue(data);
					driver.hideKeyboard();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
					try {
						title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// System.out.println(title);
						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 76, 2),"\n- Successfull Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Title Body Not Found";
					}

					try {
						mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						try {
							Assert.assertEquals(mess, M.getstring("Automation Test Data", 76, 3),"\n- Successfull Message doesn't valid");

						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Message Body Not Found";
					}
					
					Thread.sleep(2000);
					List<AndroidElement> xyz2 = driver.findElementsByXPath("//android.widget.TextView");
					for (int j = 0; j < xyz2.size(); j++) {
						if(xyz2.get(j).getText().contains(data)) {
							k++;						
						}						
					}
					if(k<=create)
					{
						count++;
						str = str + "\n" +EntityType+ " Value doesn't Update";
					}

	
					
					
					Thread.sleep(1000);
					
					  if(i!=col) { 
						  GoToEntity(row,i,1,1); 
						  }
					 
					
					System.out.println(i);
				}catch(Exception e) {
					
					try {
						String t=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").getText();
						count++;
						str=str+"\n"+" No Library Values Found in "+EntityType;
					}catch(Exception x) {
						;
						
					}
					
					if(i!=col)
					{
						GoToEntity(row,i,1,1);
					}
				}
				
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 454, 6);
			M.setStrData("Pass","Automation Testcase", 454, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 454, 6);
			M.setStrData("Fail","Automation Testcase", 454, 7);
			
			ReStart();
		}
		GoToEntity(69,1,0,1);
		
		
		
	}
	
	//@Test (priority = 4)
	public void DiableAttribute()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Diable Attribute Executed!");
		try {
			
			String EntityType;
			String Entityvalue="";
			String title="";
			String mess="";
			String str="";
			int count=0;
			int row=69;
			int col=30;
			for(int i=1;i<=col;i++) {
				EntityType=M.getstring("Automation Test Data", row, i);
				Entityvalue="Update Library value For "+EntityType;
				int k=0;
				
				try{					
					Thread.sleep(5000);
					M.ScrollByText(Entityvalue);
					Thread.sleep(2000);
					M.SwipBytext(Entityvalue);
					Thread.sleep(2000);
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_disableMain").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//Successful Added Message
					try {
						title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// System.out.println(title);
						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 76, 2),"\n- Successfull Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Title Body Not Found";
					}

					try {
						mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						try {
							Assert.assertEquals(mess, M.getstring("Automation Test Data", 76, 3),"\n- Successfull Message doesn't valid");

						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Message Body Not Found";
					}
					
					Thread.sleep(5000);
					M.ScrollByText(Entityvalue);
					Thread.sleep(2000);
					M.SwipBytext(Entityvalue);
					Thread.sleep(2000);
					
					List<AndroidElement> xyz1 = driver.findElementsByXPath("//android.widget.TextView");
					for (int J = 0; J < xyz1.size(); J++) {
						if(xyz1.get(J).getText().contains("Enable")) {
							k++;
						}
					}
					
					if(k==0) {
						count++;
						str = str + "\n" + "Disable Button doesn't Work";
					}
					
					Thread.sleep(1000);
					if(i!=col)
					{
						GoToEntity(row,i,1,1);
					}
					
					System.out.println(i);
				}catch(Exception e) {
					try {
						String t=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").getText();
						count++;
						str=str+"\n"+" No Library Values Found in "+EntityType;
					}catch(Exception x) {
						;
						
					}
					if(i!=col)
					{
						GoToEntity(row,i,1,1);
					}
				}			
				
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 463, 6);
			M.setStrData("Pass","Automation Testcase", 463, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 463, 6);
			M.setStrData("Fail","Automation Testcase", 463, 7);
			
			ReStart();
		}
		GoToEntity(69,1,0,1);
		
		
		
	}
	
	
	//@Test (priority = 5)
	public void EnableAttribute()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Enable Attribute Executed!");
		try {
			
			String EntityType;
			String Entityvalue="";
			String title="";
			String mess="";
			String str="";
			int count=0;
			int row=69;
			int col=15;
			
			for(int i=1;i<=col;i++) {
				EntityType=M.getstring("Automation Test Data", row, i);
				Entityvalue="Update Library value For "+EntityType;
				int k=0;
				
				try{					
					Thread.sleep(5000);
					M.ScrollByText(Entityvalue);
					Thread.sleep(2000);
					M.SwipBytext(Entityvalue);
					Thread.sleep(2000);
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_enableMain").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//Successful Added Message
					try {
						title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// System.out.println(title);
						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 76, 2),"\n- Successfull Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Title Body Not Found";
					}

					try {
						mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						try {
							Assert.assertEquals(mess, M.getstring("Automation Test Data", 76, 3),"\n- Successfull Message doesn't valid");

						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Message Body Not Found";
					}
					
					Thread.sleep(5000);
					M.ScrollByText(Entityvalue);
					Thread.sleep(2000);
					M.SwipBytext(Entityvalue);
					Thread.sleep(2000);
					
					List<AndroidElement> xyz1 = driver.findElementsByXPath("//android.widget.TextView");
					for (int J = 0; J < xyz1.size(); J++) {
						if(xyz1.get(J).getText().contains("Disable")) {
							k++;
						}
					}
					
					if(k==0) {
						count++;
						str = str + "\n" + "Enable Button doesn't Work";
					}
					
					Thread.sleep(1000);
					if(i!=col)
					{
						GoToEntity(row,i,1,1);
					}
					
					System.out.println(i);
				}catch(Exception e) {
					try {
						String t=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").getText();
						count++;
						str=str+"\n"+" No Library Values Found in "+EntityType;
					}catch(Exception x) {
						;
						
					}
					if(i!=col)
					{
						GoToEntity(row,i,1,1);
					}
				}			
				
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 472, 6);
			M.setStrData("Pass","Automation Testcase", 472, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 472, 6);
			M.setStrData("Fail","Automation Testcase", 472, 7);
			
			ReStart();
		}
		GoToEntity(69,1,0,1);	
		
	}
	
	
	//@Test (priority = 6)
	public void DeleteAttribute()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Delete Attribute Executed!");
		try {
			
			String EntityType;
			String Entityvalue="";
			//String data="";
			String title="";
			String mess="";
			String str="";
			int count=0;
			int row=69;
			int col=30;
			
			Thread.sleep(10000);
			for(int i=1;i<=col;i++) {
				
				EntityType=M.getstring("Automation Test Data", row, i);
				Entityvalue="Update Library value For "+EntityType;
				int k=0;
				int create=0;
				
				Thread.sleep(2000);
				List<AndroidElement> xyz =  driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/img_libraryImage");
				create=xyz.size();
				//System.out.println(create);

				try{
					Thread.sleep(2000);
					M.ScrollByText(Entityvalue);
					Thread.sleep(2000);
					//Update-cancel
					M.SwipBytext(Entityvalue);
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_deleteMain").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

					//Confirmation Title & Message
					
					try {
						title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// System.out.println(title);
						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 77, 2),"Confirmation Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + "\n" + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Confirmation Title Body Not Found";
					}

					try {
						mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
						try {
							Assert.assertEquals(mess, M.getstring("Automation Test Data", 77, 3)," Confirmation Message doesn't valid");

						} catch (AssertionError e) {
							count++;
							str = str + "\n" + e;
						}
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Confirmation Message Body Not Found";
					}
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_deleteMain").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					}catch(Exception e) {
						Thread.sleep(2000);
						List<AndroidElement> xyz1 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/img_libraryImage");
						k=xyz1.size();
						if(k<create)
						{
							count++;
							str = str + "\n" + "Library value Delecte After click NO in warring message";
							create=k;
						}
						//System.out.println(k);	
						
					}					
					
					//Sucessful Title & Message
					
					try {
						title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// System.out.println(title);
						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 78, 2),"\n- Successfull Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Title Body Not Found";
					}

					try {
						mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						try {
							Assert.assertEquals(mess, M.getstring("Automation Test Data", 78, 3),"\n- Successfull Message doesn't valid");

						} catch (AssertionError e) {
							count++;
							str = str + e;
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Successfull Message Body Not Found";
					}
					
					List<AndroidElement> xyz2= driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/img_libraryImage");
					k=xyz2.size();
					//System.out.println("K="+k);	
					if(k==create)
					{
						count++;
						str = str + "\n" + "Library value doesn't Delete";
					}

					
					Thread.sleep(1000);
					if(i!=col)
					{
						GoToEntity(row,i,1,1);
					}
					
					System.out.println(i);
				}catch(Exception e) {
					try {
						String t=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").getText();
						count++;
						str=str+"\n"+" No Library Values Found in "+EntityType;
					}catch(Exception x) {
						;						
					}
					if(i!=col)
					{
						GoToEntity(row,i,1,1);
					}
				}			
				
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 481, 6);
			M.setStrData("Pass","Automation Testcase", 481, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 481, 6);
			M.setStrData("Fail","Automation Testcase", 481, 7);
			
			ReStart();
		}
		GoToEntity(69,1,0,1);
	
	}
	
	//@Test (priority = 7)
	public void librarySearch() throws IOException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Search library Executed!");
		String str="";
		String title="";
		int count=0;
		int sercout=0;
		int sercout1=0;
		int cross=0;
		
		
		try {
			
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_search").click();
			driver.hideKeyboard();
			
			try {
				try {
					String search = driver.findElementById("android:id/search_src_text").getText();
					driver.hideKeyboard();
					Assert.assertEquals(search,"search","\n- Search text place holder doesn't match");

				} catch (AssertionError x) {
					count++;
					str=str+x;
				}
				
				
			}catch (Exception e) {
				title=driver.findElementByXPath("//android.widget.TextView[@text='Library Values']").getText();
				count++;
				str=str+"\n No Search textfield Found After click search icon ";
			}
			//Search value
			
			for(int j=1;j<=3;j++)
			{	String data=M.getstring("Automation Test Data", 72, j);
				sercout=0;
				sercout1=0;
				List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(data)) {
						sercout++;						
					}
				}
				
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("android:id/search_src_text").setValue(data);
				
				Thread.sleep(2000);
				List<AndroidElement> xyz1 = driver.findElementsByXPath("//android.widget.TextView");
				for (int i = 0; i < xyz1.size(); i++) {
					if (xyz1.get(i).getText().contains(data)) {
						sercout1++;						
					}
				}
				
				if(sercout!=sercout1) {
					count++;
					str=str + "\n" +data+ "- This search result does not match";
				}

				//Cross icon
				try {
					driver.findElementById("android:id/search_close_btn").click();
				}catch (Exception e) {
					count++;
					if(cross>0)
						str=str + "\n Cross icon not found in search bar";	
					cross++;
				}
				
			}
			
			
			
			
			
			//search field blank
			try {
				String search = driver.findElementById("android:id/search_src_text").getText();
				driver.hideKeyboard();
				Assert.assertEquals(search,"search","\n- Search TextField not blank After click cross icon");

			} catch (AssertionError x) {
				count++;
				str=str+x;
			}
			
			//back icon
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
			}catch (Exception e) {
				count++;
				str=str + "\n Back button not found in search bar";	
			}
			
			try {
				title=driver.findElementByXPath("//android.widget.TextView[@text='Library Values']").getText();
			}catch (Exception e) {
				count++;
				str=str + "\n After click back icon page title not found ";	
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed", "Search library");

			M.setStrData("As Expected", "Automation Testcase", 490, 6);
			M.setStrData("Pass", "Automation Testcase", 490, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Search library");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 490, 6);
			M.setStrData("Fail", "Automation Testcase", 490, 7);
		}
	
		
		
		
		
	}
	

	
	//@Test (priority =8 )
	public void CreateByInvalidData() throws IOException { 
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Create By InvalidData Executed!");
		
		int sercout=0;
		
		try {
			Createlibrary("@#$%^&");
			
			List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains("@#$%^&")) {
					sercout++;						
				}
			}
			if(sercout>0)
				throw new Exception("Library value create with invalid data");
			
			M.ScreenShots("Screenshot/Passed", "Add New Library");

			M.setStrData("As Expected", "Automation Testcase", 497, 6);
			M.setStrData("Pass", "Automation Testcase", 497, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Add New Library");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 497, 6);
			M.setStrData("Fail", "Automation Testcase", 497, 7);
		}
		
	
	}
	
		
	@Test (priority = 9)
	public void EditWithInvalidData() throws InterruptedException, IOException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Edit With InvalidData Executed!");
		
		int sercout=0;
		String EditCart = "Create Asset Type Library";
		try {
			Createlibrary(EditCart);
			Thread.sleep(1000);
			M.ScrollByText(EditCart);
			Thread.sleep(1000);
			M.SwipBytext(EditCart);
			
			//Swipe to Left Code 
			
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_editMain").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").setValue("@#$%^++&");
			driver.hideKeyboard();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			//Successful Edited Message
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
	
			List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains("@#$%^++&")) {
					sercout++;						
				}
			}
			if(sercout>0)
				throw new Exception("Library value Edit with invalid data");
			
			
			M.ScreenShots("Screenshot/Passed", "Add New Library");
			M.setStrData("As Expected", "Automation Testcase", 506, 6);
			M.setStrData("Pass", "Automation Testcase", 506, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Add New Library");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 506, 6);
			M.setStrData("Fail", "Automation Testcase", 506, 7);
		}
		
	}
	
	


	

}
