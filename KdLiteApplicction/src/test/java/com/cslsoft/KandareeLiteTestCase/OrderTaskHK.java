package com.cslsoft.KandareeLiteTestCase;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class OrderTaskHK extends BaseClass {
	
	
	@Test(priority = 0)
	public void Nevigate() throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(2000);
		M.Scroll(5);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").click(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 System.out.println("Navigate Hamburgare to Order Task HK!");
		 

	}
	
	
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();

		}catch(Exception x) {
			Thread.sleep(1000);
			driver.quit();
			capabilities();
			Thread.sleep(2000);
			CallingMethods M=new CallingMethods(driver);
			M.LoginMethods();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(2000);
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		    
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		    
		    driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
	}
	private void DataUp(String data) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
		for (j = 0; j < xyz.size(); j++) {
			if (xyz.get(j).getText().contains(data)) {
				if (j >= 6) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
				}

			}
		}

	}
	
	public int counting(String data, String data1,String data2) throws InterruptedException, IOException{
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		
		List<AndroidElement> xyz = driver.findElementsById(data1);
		int item = xyz.size();
		int editId = driver.findElementsById(data2).size();
		
		if (item == editId || item > editId) {
			for (i = 0; i < item; i++) {
				if (xyz.get(i).getText().contains(data)) {
					j = i + 1;
					// M.SwipBytext(data);
					// System.out.println("item="+item);
					break;
				}
			}
		} else {

			for (i = 0; i < item; i++) {

				if (xyz.get(i).getText().contains(data)) {
					j = i + 2;

					// System.out.println("item=="+item);
					break;
				}

			}
		}
		return j;

		
	}
	
	
	public String PageVerification(String text) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		String str="";
		try {
			Thread.sleep(100);
			String user = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
			// Assert.assertEquals(user,"Order Task Hks");

		} catch (Exception e) {
			try {
				
				Thread.sleep(1000);
				String user = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").getText();
				if (user.contentEquals(text)) {
					Thread.sleep(5000);
					M.BackFun(1);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
					} catch (Exception y) {
						// count++;
						// str = str + "\n" + "After press back button warring message not found";
						;
					}

				}

			} catch (Exception z) {
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					str = str + "\n" + "Unwanted Message show......";
					
				} catch (Exception y) {
					
					str = str + "\n" + "Apps May be crush pls check Manually...";
					
				}
			}
		}
		return str;

	}


	//Task Description
	public void TaskDescription(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	//TaskCategory
	public void TaskCategory(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llTaskCategory").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	//TaskTypeDropDown
	public void TaskTypeDropDown(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llOrderTaskTypeDropDown").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	//EventMileStone
	public void EventMileStone(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llEventMileStone").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	//CriticalTaskIcon
	public void CriticalTaskIcon(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCriticalTaskIcon").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	//TaskHkIccon
	public void TaskHkIccon(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectOrderTaskHkIccon").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void DataFillUp(int i,int j,int k) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if(i==1)
			TaskDescription(M.getstring("Automation Test Data", j, k));
		if(i==2)
			TaskCategory(M.getstring("Automation Test Data", j, k),1);
		if(i==3)
			TaskTypeDropDown(M.getstring("Automation Test Data", j, k),1);
		if(i==4)
			EventMileStone(M.getstring("Automation Test Data", j, k),1);
		if(i==5)
			CriticalTaskIcon(M.getstring("Automation Test Data", j, k),1);
		if(i==6)
			TaskHkIccon(M.getstring("Automation Test Data", j, k),1);
		
	}
	
	public String VerifyText(int i,int j,int k) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String str = "";
		Thread.sleep(2000);

		if(i==1) {
			//Task Description
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Task Description Doesn't Match");
		}
		if(i==2) {
			//Category
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCategory").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Task Category Doesn't Match");
		}
		if(i==3) {
			//OrderTaskType
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderTaskType").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Order TaskType Doesn't Match");
		}
		if(i==4) {
			//EventMilestone
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtEventMilestone").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "EventMilestone Doesn't Match");
		}
		if(i==5) {
			//CriticalTask
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCriticalTask").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Critical Task Doesn't Match");
		}
		if(i==6) {
			//TaskHKIcon
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderTaskHKIcon").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "TaskHKIcon Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}
	
	
	// Verify Place holder Text
	//////@Test(priority = 1)
	public void VerifyPlaceholderText() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Place holder Text Executed!");
		int count=0;
		String str="";
		String gettext="";
		try {
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			try {
				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 253, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			Thread.sleep(2000);
			M.ScrollByText("Create Task HK");
			
			//Login user is CreateBy user name.
			try {
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
				// M.setStrData(gettext, "Automation Test Data", i, 1);
				Assert.assertEquals(gettext, M.getstring("Automation Test Data", 253, 7), "CreatedBy Name Doesn't Match");
			}catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			try {
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").getText();
				// M.setStrData(gettext, "Automation Test Data", i, 1);
				Assert.assertEquals(gettext, M.getstring("Automation Test Data", 253, 8), "CreateAssignTask Doesn't Match");
			}catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			

			Thread.sleep(5000);
			M.BackFun(1);
			
			String result=PageVerification("New Order Task HK");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}

			M.ScreenShots("Screenshot/Passed", "VerifyPlaceholderText");
			M.setStrData("As Expected", "Automation Testcase", 655, 6);
			M.setStrData("Pass", "Automation Testcase", 655, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "VerifyPlaceholderText");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 655, 6);
			M.setStrData("Fail", "Automation Testcase", 655, 7);
		}
		ReStart();
	}
	
	
	

	//Verify Disabled Create Button (With Blank Field )
	//@Test(priority = 2)
	public void VerifyCreateButtonDisableWhenFieldBlank() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Create Button Disable When Field Blank Executed!");
		try {
			String str = "";
			int count = 0;
			int k = 255;
			for (int i = 0; i <= 6; i++) {
				boolean tr;
				String testdata;
				Thread.sleep(1000);
				String text = "Create Task HK";
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				// Full Field Blank
				if (i == 0) {
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Create Task Hk Button is Enable";

					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;

				}
				
				//TaskDescription
				if (i != 1) {
					TaskDescription(M.getstring("Automation Test Data",k,1));
				}
				
				//TaskCategory
				if (i != 2) {
					TaskCategory(M.getstring("Automation Test Data",k,2),1);
				}
				
				//TaskTypeDropDown
				if (i != 3) {
					TaskTypeDropDown(M.getstring("Automation Test Data",k,3),1);
				}
				
				//EventMileStone
				if (i != 4) {
					EventMileStone(M.getstring("Automation Test Data",k,4),1);
				}
				if (i != 5) {
					CriticalTaskIcon(M.getstring("Automation Test Data",k,5),1);
						
				}
				if (i != 6) {
					TaskHkIccon(M.getstring("Automation Test Data",k,6),1);
				}

				
				Thread.sleep(2000);
				M.ScrollByText("Create Task HK");

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Task Description Field is Blank But Create Task HK Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Task Category Field is Blank But Create Task HK Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Task TypeDropDown Field is Blank But Create Task HK Button is Enable";
					else if (i == 4)
						str = str + "\n" + "EventMile Stone Field is Blank But Create Task HK Button is Enable";
					else if (i == 5)
						str = str + "\n" + "CriticalTaskIcon Field is Blank But Create Task HK Button is Enable";
					else if (i == 6)
						str = str + "\n" + "TaskHkIccon Field is Blank But Create Task HK Button is Enable";
					

				}
				if (i != 7) {
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.BackFun(1);
					Thread.sleep(100);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					} catch (Exception e) {
						// System.out.println("Warning Message Not Found");
					}

				}
				String result=PageVerification("New Order Task HK");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
				}
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Create Button (With Blank Field )");
			M.setStrData("As Expected", "Automation Testcase", 656, 6);
			M.setStrData("Pass", "Automation Testcase", 656, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Create Button (With Blank Field )");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 656, 6);
			M.setStrData("Fail", "Automation Testcase", 656, 7);

		}
		ReStart();

	}


	 
	 
	//Dismiss Unsaved Data-New Order Task HK (Default & All fields together)
	////@Test(priority = 3)
	public void DismissUnsavedDataDefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (Default & All fields together) Executed!");
		int count = 0;
		String str = "";

		try {
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
				
			}
			Thread.sleep(2000);
			
			//verify Order task HK page 
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
					count++;
					str = str + "\n" + "After click back button show warnning messsage with-out input data";
					
				}catch (Exception x) {
					count++;
					str = str + "\n" + "After press back button, Apps may be Crush.";
					throw new Exception(str);
				}

			}
			
			
			//After input data
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,255,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 271, 2), M.getstring("Automation Test Data", 271, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify New Order Task HK is present 
			Thread.sleep(2000);
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='New Order Task HK']").getText();
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 255, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,255,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Order Task HK page";
				throw new Exception(str);
				
			}
				
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-New Order Task HK");
			M.setStrData("As Expected", "Automation Testcase", 657, 6);
			M.setStrData("Pass", "Automation Testcase", 657, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-New Order Task HK");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 657, 6);
			M.setStrData("Fail", "Automation Testcase", 657, 7);

		}
		ReStart();

	}
	 

	
	
	
	//Dismiss Unsaved Data-New Order Task HK  (For Each Field)
	//////@Test(priority = 4)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		
		try {
			
			for(int i=1;i<=6;i++){
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				
				//data fill up
				try {
					DataFillUp(i,255,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				}catch (Exception e) {
					count++;
					if(back==0)
						str = str + "\n" + "Back button doesn't found";
					Thread.sleep(5000);
					M.BackFun(1);
					back++;
				}
								
				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 271, 2), M.getstring("Automation Test Data", 271, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"After Press Back Button "+ confirmation;
				}				
				
				//Verify New Order Task HK is present 
				Thread.sleep(2000);				
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='New Order Task HK']").getText();
					
					try {
						String result= VerifyText(i, 255, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
					
					str = str + "\n" + "After click Back button and warning message no, Page Redirect to Order Task HK page";
					throw new Exception(str);
					
				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);

				}
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']")
							.getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 658, 6);
			M.setStrData("Pass", "Automation Testcase", 658, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 658, 6);
			M.setStrData("Fail", "Automation Testcase", 658, 7);

		}
		ReStart();
		
	}
	
	
	
	
	// Dismiss Selected Value From Dropdown (New Order Task HK)
	//////@Test(priority = 5)
	public void DismissSelectedValueFromDropdown_OrderTaskHK() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (New Order Task HK) Executed!");
		int count = 0;
		String str = "";
		int i = 255;
		
		try {
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}

			// Verrify Task Category
			TaskCategory(M.getstring("Automation Test Data", i, 2),2);			
			String result = VerifyText(2, 253, 2);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// TaskTypeDropDown
			TaskTypeDropDown(M.getstring("Automation Test Data", i, 3),2);
			result = VerifyText(3, 253, 3);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// EventMileStone
			EventMileStone(M.getstring("Automation Test Data", i, 4),2);
			result = VerifyText(4, 253, 4);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// CriticalTaskIcon
			CriticalTaskIcon(M.getstring("Automation Test Data", i, 5),2);
			result = VerifyText(5, 253, 5);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// TaskHkIccon
			TaskHkIccon(M.getstring("Automation Test Data", i, 6),2);
			result = VerifyText(6, 253, 6);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}

			

			// back to Order Task Hk
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception m) {

				Thread.sleep(5000);
				M.BackFun(1);
			}
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception m) {
				
				;
			}

			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Dismiss Selected Value From Dropdown_Cancellation");
			M.setStrData("As Expected", "Automation Testcase", 659, 6);
			M.setStrData("Pass", "Automation Testcase", 659, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Selected Value From Dropdown_Cancellation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 659, 6);
			M.setStrData("Fail", "Automation Testcase", 659, 7);
		}

	}
	
	
	
	
	// Create Order Task Hk
	////@Test (priority = 6)
	public void CreateOrderTaskHk()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Order Task Hk Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		String text = "Create Task HK";
		
		try {
			
			//Go to create page.
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			
			// Data input
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,255,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			Thread.sleep(2000);
			M.ScrollByText(text);
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Task Hk button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 273, 2), M.getstring("Automation Test Data", 273, 3));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}

			
			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message, Order Task HK page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='New Order Task HK']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
							
						}catch (Exception z) {
							count++;
							str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
							Thread.sleep(5000);
							
						}
						
					}
					
				} catch (Exception x) {
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						str = str + "\n" + "Unwanted Message show, After click Sucessful Message";
						
					} catch (Exception y) {
						
						str = str + "\n" + "Apps May be crush pls check Manually...";
						
					}

				}
				
			}
			
			//check create field is blank or not
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			try {
				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 253, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create task HK, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("New Order Task HK");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Create Order Task Hk"); 
		    M.setStrData("As Expected","Automation Testcase", 660, 6);
			M.setStrData("Pass","Automation Testcase", 660, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Order Task Hk");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 660, 6);
			M.setStrData("Fail","Automation Testcase", 660, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
	
	// Verify Create Order & Data 
	////@Test (priority = 7)
	public void VerifyCreateOrderTaskHk_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Create Order & Data Executed!");
		String order ="";
		String str ="";
		int count=0;
		int j=0;

		try {
					
			order = M.getstring("Automation Test Data",255, 1);
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(order)) {
					pass++;
					Thread.sleep(5000);
					j=counting(order, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(order)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order task icon does not display";
					}
					
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order task User icon does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 255, 2), "Task Category Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Category does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 255, 4), "Event Milestone Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Event Milestone does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 255, 3), "Order Task Type Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order Task Type does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, "Critical", "Critical task Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Critical task does not display";
					}
					
					
					
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Order Task HK didn't create");
			
			
			
			try {
				
				Thread.sleep(5000);
				String page=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				if(page.contains("Order Task HK Detail")) {
					;
				}	
				else{
					count++;
					str = str + "\n" + "Order Task HK Detail page not found check manually what happend";
					throw new Exception(str);
				}

				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 255, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 253, 7),
							"CreatedBy Name Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 255, 8),
							"Save Changes button Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}

			Thread.sleep(5000);
			M.BackFun(1);
			
			String result=PageVerification("Order Task HK Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			if (count > 0) {
				System.out.println(str);
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Verify Create Order & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 661, 6);
			M.setStrData("Pass","Automation Testcase", 661, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Create Order & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 661, 6);
			M.setStrData("Fail","Automation Testcase", 661, 7);
	
		}
		ReStart();
	}
	
	
	
	
	//Verify Order List View
	////@Test (priority = 8)
	public void VerifyOrderListView()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Order List View Executed!");
		int count=0;
		String str="";
		try {
			
			try {
				String gettext=driver.findElementByXPath("//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("Order Task HK")) {
					;
				}else {
					count++;
					str = str + "\n" + "Order Task HK Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Order Task HK Title doesn't found";
			}
			
			
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_search").isDisplayed();
				if(tr==false) {
					count++;
					str = str + "\n" + "Search Icon doesn't display";
					//System.out.println(str);
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Search Icon doesn't found";
			}
			
			
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_filter").isDisplayed();
				if(tr==false) {
					count++;
					str = str + "\n" + "Sort Icon doesn't display";
					//System.out.println(str);
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Sort Icon doesn't found";
			}
			
			
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
				if(tr==false) {
					count++;
					str = str + "\n" + "Create Icon doesn't display";
					//System.out.println(str);
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Create Icon doesn't found";
			}
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Order List View"); 
		    M.setStrData("As Expected","Automation Testcase", 662, 6);
			M.setStrData("Pass","Automation Testcase", 662, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Order List View");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 662, 6);
			M.setStrData("Fail","Automation Testcase", 662, 7);

		}
		ReStart();
	}

	
	
	//Verify Save Changes Button Disabled (Default & With Blank Field)
	/////@Test (priority = 9)
	public void VerifySaveChangesButtonDisabled_Default_Blank()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled (Default & With Blank Field) Executed!");
		int count=0;
		String str="";
		try {
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data",255, 1));
			Thread.sleep(5000);
			M.ScrollByText("Save Changes");
			
			//check default
			Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
			if(tr==true) {
				count++;
				str = str + "\n" + "With-out input by default Save Change button is Enable.";
			}
			
			//back
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			//go again order task HK details
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data",255, 1));
			Thread.sleep(5000);
			
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").clear();
			driver.hideKeyboard();
			
			Thread.sleep(1000);
			M.ScrollByText("Save Changes");
			
			//check when Description value Blank
			tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
			if(tr==true) {
				count++;
				str = str + "\n" + "Description field is Blank but Save Change button is enable";
			}
			
			
			//back
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			//warning 
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			} catch (Exception e) {
				;
			}
			
			String result=PageVerification("Order Task HK Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Save Changes Button Disabled (Default & With Blank Field)"); 
		    M.setStrData("As Expected","Automation Testcase", 663, 6);
			M.setStrData("Pass","Automation Testcase", 663, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Save Changes Button Disabled (Default & With Blank Field)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 663, 6);
			M.setStrData("Fail","Automation Testcase", 663, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	//Verify Save Changes Button Disabled/Enabled (For Each Field)
	////@Test(priority = 10)
	public void VerifySaveChangesButtonDisabledEnabled() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled/Enabled (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		
		try {
			
			for(int i=1;i<=6;i++){
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",255, 1));
				Thread.sleep(5000);
				
				//data fill up
				try {
					DataFillUp(i,257,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
				if(tr==false) {
					count++;
					if(i==1)
						str = str + "\n" + "Description field is modify but Save Change button is disable";
					if(i==2)
						str = str + "\n" + "Task Category field is modify but Save Change button is disable";
					if(i==3)
						str = str + "\n" + "Order Task Type field is modify but Save Change button is disable";
					if(i==4)
						str = str + "\n" + "Event Milestone field is modify but Save Change button is disable";
					if(i==5)
						str = str + "\n" + "Critical Task field is modify but Save Change button is disable";
					if(i==6)
						str = str + "\n" + "Task HK Icon field is modify but Save Change button is disable";
				}

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				}catch (Exception e) {
					
					Thread.sleep(5000);
					M.BackFun(1);
					back++;
				}
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				} catch (Exception e) {
					;
				}			
				
				String result=PageVerification("Order Task HK Detail");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Save Changes Button Disabled/Enabled (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 664, 6);
			M.setStrData("Pass", "Automation Testcase", 664, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Save Changes Button Disabled/Enabled(For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 664, 6);
			M.setStrData("Fail", "Automation Testcase", 664, 7);

		}
		ReStart();
		
	}
	
	


	 
	 
	//Dismiss Unsaved Data In Existing Order Task HK (Default & All fields together)
	//////@Test(priority = 11)
	public void DismissUnsavedDataInExistingOrderTaskHKDefault() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data In Existing Order Task HK(Default & All fields together) Executed!");
		int count = 0;
		int error = 0;
		String str = "";
		String title="";
		String mess="";
		try {
			
			//Default dismiss
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",255, 1));
				Thread.sleep(5000);
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Task description doesn't found";
			}
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
				
			}
			Thread.sleep(2000);
			
			//verify Order task HK page 
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
					count++;
					str = str + "\n" + "After click back button show warnning messsage with-out input data";
					
				}catch (Exception x) {
					count++;
					str = str + "\n" + "After press back button, Apps may be Crush.";
					throw new Exception(str);
				}

			}
			
			
			//After input data
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",255, 1));
				Thread.sleep(5000);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Task description doesn't found";
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,257,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 271, 2), M.getstring("Automation Test Data", 271, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify New Order Task HK is present 
			Thread.sleep(2000);
			
			try {
				Thread.sleep(5000);
				String page=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				if(page.contains("Order Task HK Detail")) {
					;
				}	
				else{
					count++;
					str = str + "\n" + "After warning message No, Order Task HK Detail page not found check manually what happend";
					throw new Exception(str);
				}
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 257, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,255,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Order Task HK page";
				throw new Exception(str);
				
			}
				
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			

			if (error > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data In Existing Order Task HK");
			M.setStrData("As Expected", "Automation Testcase", 665, 6);
			M.setStrData("Pass", "Automation Testcase", 665, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data In Existing Order Task HK");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 665, 6);
			M.setStrData("Fail", "Automation Testcase", 665, 7);

		}
		ReStart();

	}
	 

	
	
	
	//Dismiss Unsaved Data In Existing Order Task HK  (For Each Field)
	//////@Test(priority = 12)
	public void DismissUnsavedDataInExistingOrderTaskHKForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data In Existing Order Task HK  (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";		
		try {
			
			for(int i=1;i<=6;i++){
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",255, 1));
				Thread.sleep(5000);
				
				//data fill up
				try {
					DataFillUp(i,257,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				}catch (Exception e) {
					count++;
					if(back==0)
						str = str + "\n" + "Back button doesn't found";
					Thread.sleep(5000);
					M.BackFun(1);
					back++;
				}
								
				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 271, 2), M.getstring("Automation Test Data", 271, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"After Press Back Button "+ confirmation;
				}				
				
				//Verify New Order Task HK is present 
				Thread.sleep(2000);				
				try {
					Thread.sleep(5000);
					String page=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					if(page.contains("Order Task HK Detail")) {
						;
					}	
					else{
						count++;
						str = str + "\n" +i+ " = After warning message No, Order Task HK Detail page not found check manually what happend";
						throw new Exception(str);
					}
					
					try {
						String result= VerifyText(i, 257, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
					
					str = str + "\n" +i+ " = After click Back button and warning message no, Page Redirect to Order Task HK page";
					throw new Exception(str);
					
				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);

				}
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']")
							.getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 666, 6);
			M.setStrData("Pass", "Automation Testcase", 666, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 666, 6);
			M.setStrData("Fail", "Automation Testcase", 666, 7);

		}
		ReStart();
		
	}
	
	
	


	
	// Update Order Task Hk
	//////@Test (priority = 13)
	public void UpdateOrderTaskHk()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update Order Task Hk Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		String text = "Save Changes";
		
		try {
			
			//Go to create page.
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",257, 1));
				Thread.sleep(5000);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Task doesn't found";
				throw new Exception(str);
			}
			
			// Data input
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,257,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			Thread.sleep(2000);
			M.ScrollByText(text);
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Save Changes button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 273, 4), M.getstring("Automation Test Data", 273, 5));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}

			try {
				String page=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				if(page.contains("Order Task HK Detail")) {
					;
				}	
				else{
					
					throw new Exception(str);
				}
				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(3000);
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
					
				} catch (Exception y) {
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						count++;
						str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
						Thread.sleep(3000);
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();
						
					}catch (Exception z) {
						count++;
						str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
						Thread.sleep(5000);
						
					}
					
				}
				

			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message OK, Order Task HK Details page not found";
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").getText();

				} catch (Exception x) {
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						str = str + "\n" + "Unwanted Message show, After click Sucessful Message";
						
					} catch (Exception y) {
						
						str = str + "\n" + "Apps May be crush pls check Manually...";
						
					}

				}
				
			}
			
			//check create field is blank or not
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			try {
				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 253, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create task HK, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				count++;
				str = str + "\n" + "After update task and go to create page then press back show warning message.";
			} catch (Exception e) {
				;
			}
			
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Create Order Task Hk"); 
		    M.setStrData("As Expected","Automation Testcase", 667, 6);
			M.setStrData("Pass","Automation Testcase", 667, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Order Task Hk");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 667, 6);
			M.setStrData("Fail","Automation Testcase", 667, 7);
			
			
		}
		
		
		ReStart();
	}
	


	
	
	// Verify Update Order & Data 
	// ////@Test (priority = 14)
	public void VerifyUpdateOrderTaskHk_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Order & Data Executed!");
		String order ="";
		String str ="";
		int count=0;
		int j=0;

		try {
					
			order = M.getstring("Automation Test Data",257, 1);
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(order)) {
					pass++;
					Thread.sleep(5000);
					j=counting(order, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(order)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order task icon does not display";
					}
					
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order task User icon does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 257, 2), "Task Category Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Category does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 257, 4), "Event Milestone Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Event Milestone does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 257, 3), "Order Task Type Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order Task Type does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, "Non-Critical", "Critical task Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Event Milestone does not display";
					}
					
					
					
					//click on order task hk
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Order Task HK didn't create");
			
			
			
			try {
				
				Thread.sleep(5000);
				String page=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				if(page.contains("Order Task HK Detail")) {
					;
				}	
				else{
					count++;
					str = str + "\n" + "Order Task HK Detail page not found check manually what happend";
					throw new Exception(str);
				}

				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 257, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 253, 7),
							"CreatedBy Name Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 255, 8),
							"Save Changes button Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}

			Thread.sleep(5000);
			M.BackFun(1);
			
			String result=PageVerification("Order Task HK Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			if (count > 0) {
				System.out.println(str);
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Verify Create Order & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 668, 6);
			M.setStrData("Pass","Automation Testcase", 668, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Create Order & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 668, 6);
			M.setStrData("Fail","Automation Testcase", 668, 7);
	
		}
		ReStart();
	}
	
	
	
	
	
	
	//Verify Disable Order Task Hk (Without Existing Transaction)
	////@Test (priority = 15)
	public void DisableOrderTaskHkWithoutExistingTransaction()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Disable Order Task Hk Without Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 257, 1);
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
	
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
				}
			}
			
			Thread.sleep(2000);
			M.SwipBytext(data);
			
			try {
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				//Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 275, 2),M.getstring("Automation Test Data", 275, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}
				
				
				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					//System.out.println(gettext);
					if(gettext.contains("Enable")) {
						//System.out.println(gettext);
						count++;
						str = str + "\n" +"After click warning message No,Disable button change to Enable";
						//System.out.println(gettext);
					}	
				}catch(Exception e) {
					
					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					DataUp(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j=counting(data, str1, str2);
					try {
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contains("Enable")) {
						count++;
						str = str + "\n" +"After click warning message No,Disable button change to Enable";
					}
					
					
				}
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				
				//warnign message yes
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}catch(Exception e) {
					;
				}
				
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 275, 4), M.getstring("Automation Test Data", 275, 5));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				
				int fail=0;
				try {
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					count++;
					str = str + "\n" +"After click Disable button and sucessful ok button, Order Task HK card doesn't close";
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, Order Task HK doesn't Disable";
						fail++;
					}	
				}catch(Exception e) {
					
					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					DataUp(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j=counting(data, str1, str2);
					
					try {
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, Order Task HK doesn't Disable";
						fail++;
					}
					
					//Page Refresh
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						 
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 
						 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 
						 driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}catch(Exception x) {
						;
					}
					if(fail>0) {
						
						Thread.sleep(5000);
						M.ScrollByText(data);
						Thread.sleep(3000);
						DataUp(data);
						
						Thread.sleep(3000);
						M.SwipBytext(data);
						Thread.sleep(3000);

						j=counting(data, str1, str2);
						
						try {
							gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
							if(gettext.contentEquals(data)) {
								;
							}else {
								j++;
							}
						}catch(Exception x) {
							j++;
						}
						
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						if(gettext.contains("Disable")) {
							count++;
							str = str + "\n" +"After click Disable button yes message and reload page, Order Task HK doesn't Disable .";
						}else if(gettext.contentEquals(gettext)){
							count++;
							str = str + "\n" +"After click Disable button, yes message and after reload page, Order Task HK Enable.";
						}
					}

					 
					
				}
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Disable Button doesn't Work";
				
			}
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Disable Order Task Hk Without Existing Transaction"); 
		    M.setStrData("As Expected","Automation Testcase", 669, 6);
			M.setStrData("Pass","Automation Testcase", 669, 7);
			
		
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Disable Order Task Hk Without Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 669,6);
			M.setStrData("Fail","Automation Testcase", 669, 7);
						
		}
		
		
		ReStart();
	}
	
	
	

	
	//Verify Enable Order Task Hk (Without Existing Transaction)
	////@Test (priority = 16)
	public void EnableOrderTaskHkWithoutExistingTransaction()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Enable Order Task Hk Without Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 257, 1);
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
					
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
				}
			}
			
			Thread.sleep(2000);
			M.SwipBytext(data);
			
			try {
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				//Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 276, 2),M.getstring("Automation Test Data", 276, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}
				
				
				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					//System.out.println(gettext);
					if(gettext.contains("Disable")) {
						//System.out.println(gettext);
						count++;
						str = str + "\n" +"After click warning message No,Enable button change to Disable";
						//System.out.println(gettext);
					}	
				}catch(Exception e) {
					
					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					DataUp(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);
					
					j=counting(data, str1, str2);
					try {
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click warning message No,Enable button change to Disable";
					}
					
					
				}
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				
				//warnign message yes
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}catch(Exception e) {
					;
				}
				
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 276, 4), M.getstring("Automation Test Data", 276, 5));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				
				int fail=0;
				try {
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					count++;
					str = str + "\n" +"After click Enable button and sucessful ok button, Order Task HK card doesn't close";
					if(gettext.contains("Enable")) {
						count++;
						str = str + "\n" +"After click Enable button yes, Order Task HK doesn't Enable";
						fail++;
					}	
				}catch(Exception e) {
					
					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					DataUp(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);
					
					j=counting(data, str1, str2);
					
					try {
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contains("Enable")) {
						count++;
						str = str + "\n" +"After click Enable button yes, Order Task HK doesn't Enable";
						fail++;
					}
					
					//Page Refresh
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}catch(Exception x) {
						;
					}
					if(fail>0) {
						
						Thread.sleep(5000);
						M.ScrollByText(data);
						Thread.sleep(3000);
						DataUp(data);
						
						Thread.sleep(3000);
						M.SwipBytext(data);
						Thread.sleep(3000);
						
						j=counting(data, str1, str2);
						
						try {
							gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
							if(gettext.contentEquals(data)) {
								;
							}else {
								j++;
							}
						}catch(Exception x) {
							j++;
						}
						
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						if(gettext.contains("Disable")) {
							count++;
							str = str + "\n" +"After click Enable button yes message and reload page, Order Task HK doesn't Enable .";
						}else if(gettext.contentEquals(gettext)){
							count++;
							str = str + "\n" +"After click Enable button, yes message and after reload page, Order Task HK Enable.";
						}
					}
					
					
					
				}
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Enablee Button doesn't Work";
				
			}
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Enable Order Task HK Without Existing Transaction"); 
			M.setStrData("As Expected","Automation Testcase", 670, 6);
			M.setStrData("Pass","Automation Testcase", 670, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Enable Order Task HK Without Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 670,6);
			M.setStrData("Fail","Automation Testcase", 670, 7);
			
		}
		
		
		ReStart();
	}
	
	
	
	


	// Verify Delete Order Task Hk (Without Existing Transaction)
	////@Test(priority = 17)
	public void DeleteOrderTaskHkWithoutExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete Order Task Hk Without Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 257, 1);
		try {
			//sortdown
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_filter").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/rbTaskDescription").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDescendingBg").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnApplyALl").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch(Exception e) {
				;
			}
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
	
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
				}
			}
			
			Thread.sleep(2000);
			M.SwipBytext(data);
			
			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 278, 2),M.getstring("Automation Test Data", 278, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				try {
					Thread.sleep(2000);
					String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
					// System.out.println(gettext);
					count++;
					str = str + "\n" + "After Delete Warning message no, Order task HK card doesn't close";

				} catch (Exception e) {
					try {
						Thread.sleep(5000);
						M.ScrollByText(data);
						Thread.sleep(3000);
						DataUp(data);
						
						Thread.sleep(3000);
						M.SwipBytext(data);
						Thread.sleep(3000);
						
						j=counting(data, str1, str2);
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
							if(gettext.contentEquals(data)) {
								;
							}else {
								j++;
							}
						}catch(Exception x) {
							j++;
						}
					} catch (Exception x) {
						count++;
						str = str + "\n" + "After click Delete warning message No,Order Task Hk Id Delete ";
						throw new Exception(str);
					}

				}

				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				//warnign message yes
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}catch(Exception e) {
					;
				}
				
				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 278, 4),M.getstring("Automation Test Data", 278, 5));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				try {
					Thread.sleep(5000);
					M.ScrollByText(data);
					count++;
					str = str + "\n" + "After Sucessfully Delete, Order Task Hk card doesn't Delete ";
					throw new Exception(str);

				} catch (Exception x) {
					;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Delete Button doesn't Work";

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Delete Order Task Hk Without Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 670, 6);
			M.setStrData("Pass", "Automation Testcase", 670, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Order Task Hk Without Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 670, 6);
			M.setStrData("Fail", "Automation Testcase", 670, 7);

		}

		ReStart();
	}
	
	
	
	
	// Verify Disable Order Task Hk (With Existing Transaction)
	//////@Test (priority = 18)
	public void DisableOrderTaskHkWithExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Disable Order Task Hk With Existing Transaction Executed!");
		int count = 0;
		int j = 0;
		String str = "";
		String data = M.getstring("Automation Test Data", 255, 1);
		try {
			//create task HK
			Thread.sleep(5000);
			CreateOrderTaskHk();
			Thread.sleep(5000);
			
			//go to task template
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click(); 
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Go to selected Task
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 259, 1));
				Thread.sleep(5000);
				
				//Add Task in a template
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				Thread.sleep(5000);
				
				//OrderTaskHK
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCustomerOrderTaskHK").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.ClickOn(M.getstring("Automation Test Data", 255, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Calculation Logic
				String text="Add Task";
				M.ScrollByText(text);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCalculationLogic").click();
				driver.findElementByXPath("//android.widget.TextView[@text='Forward']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Number Of Days
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").click();
				driver.hideKeyboard();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").sendKeys("2");
				
				//Default Assignee
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectDefaultAssingnee").click();
				driver.findElementByXPath("//android.widget.TextView[@text='Tahsina']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//SequenceNumber
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").click();
				driver.hideKeyboard();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").sendKeys("1");
				
				//add task
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}catch (Exception e) {
					;
				}
				try {
					String gettext= driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
					Thread.sleep(2000);
					M.ScrollByText("Save Changes");
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
					try {
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}catch (Exception e) {
						;
					}
					Thread.sleep(5000);
					M.BackFun(1);
					try {
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}catch (Exception e) {
						;
					}
				}catch (Exception e) {
					try {
						String gettext= driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
						Thread.sleep(5000);
						M.BackFun(1);
						try {
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						}catch (Exception x) {
							;
						}
						M.ScrollByText("Save Changes");
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
						try {
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						}catch (Exception x) {
							;
						}
						Thread.sleep(5000);
						M.BackFun(1);
						try {
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						}catch (Exception x) {
							;
						}
						
					}catch (Exception x) {
						throw new Exception(x);
					}
				}
				
				
				
			}catch (Exception e) {
				count++;
				str = str + "\n" +"Something is happened to add task in template----"+e;
			}
			
			
			// Go to Order task HK page.
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").click(); 
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}catch (Exception x) {
				throw new Exception(x);
			}
			

			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);

			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			String str1 = "bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription";
			String str2 = "bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {

					Thread.sleep(5000);
					j = counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
								+ "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView")
								.getText();
						if (gettext.contentEquals(data)) {
							;
						} else {
							j++;
						}
					} catch (Exception e) {
						j++;
					}

				}
			}

			Thread.sleep(2000);
			M.SwipBytext(data);

			try {

				driver.findElementByXPath("//android.view.ViewGroup[" + j
						+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 275, 2),
						M.getstring("Automation Test Data", 275, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
							+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					// System.out.println(gettext);
					if (gettext.contains("Enable")) {
						// System.out.println(gettext);
						count++;
						str = str + "\n" + "After click warning message No,Disable button change to Enable";
						// System.out.println(gettext);
					}
				} catch (Exception e) {

					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					DataUp(data);

					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j = counting(data, str1, str2);
					try {
						gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
								+ "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView")
								.getText();
						if (gettext.contentEquals(data)) {
							;
						} else {
							j++;
						}
					} catch (Exception x) {
						j++;
					}

					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
							+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					if (gettext.contains("Enable")) {
						count++;
						str = str + "\n" + "After click warning message No,Disable button change to Enable";
					}

				}

				driver.findElementByXPath("//android.view.ViewGroup[" + j
						+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);

				// warnign message yes
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}

				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 275, 4),
						M.getstring("Automation Test Data", 275, 5));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				int fail = 0;
				try {
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
							+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					count++;
					str = str + "\n"
							+ "After click Disable button and sucessful ok button, Order Task HK card doesn't close";
					if (gettext.contains("Disable")) {
						count++;
						str = str + "\n" + "After click Disable button yes, Order Task HK doesn't Disable";
						fail++;
					}
				} catch (Exception e) {

					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					DataUp(data);

					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j = counting(data, str1, str2);

					try {
						gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						if (gettext.contentEquals(data)) {
							;
						} else {
							j++;
						}
					} catch (Exception x) {
						j++;
					}

					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if (gettext.contains("Disable")) {
						count++;
						str = str + "\n" + "After click Disable button yes, Order Task HK doesn't Disable";
						fail++;
					}

					// Page Refresh
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementByXPath("//android.widget.TextView[@text='Order Task HK']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					} catch (Exception x) {
						;
					}
					if (fail > 0) {

						Thread.sleep(5000);
						M.ScrollByText(data);
						Thread.sleep(3000);
						DataUp(data);

						Thread.sleep(3000);
						M.SwipBytext(data);
						Thread.sleep(3000);

						j = counting(data, str1, str2);

						try {
							gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView")
									.getText();
							if (gettext.contentEquals(data)) {
								;
							} else {
								j++;
							}
						} catch (Exception x) {
							j++;
						}

						gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
								.getText();
						if (gettext.contains("Disable")) {
							count++;
							str = str + "\n"+ "After click Disable button yes message and reload page, Order Task HK doesn't Disable .";
						} else if (gettext.contentEquals(gettext)) {
							count++;
							str = str + "\n"+ "After click Disable button, yes message and after reload page, Order Task HK Disable.";
						}
					}

				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Disable Button doesn't Work";

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Disable Order Task Hk Without Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 671, 6);
			M.setStrData("Pass", "Automation Testcase", 671, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Disable Order Task Hk Without Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 671, 6);
			M.setStrData("Fail", "Automation Testcase", 671, 7);

		}

		ReStart();
	}	
		
		
	
	// Verify Delete Order Task Hk (With Existing Transaction)
	////@Test(priority = 19)
	public void DeleteOrderTaskHkWithExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete Order Task Hk With Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 255, 1);
		try {
			//sortdown
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_filter").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/rbTaskDescription").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDescendingBg").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnApplyALl").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch(Exception e) {
				;
			}
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
	
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
				}
			}
			
			Thread.sleep(2000);
			M.SwipBytext(data);
			
			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				// Warnning message with Sucessfull method
				String sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 278, 2),M.getstring("Automation Test Data", 278, 7));
				if (sucessfull.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + sucessfull;
				}



				try {
					Thread.sleep(5000);
					M.ScrollByText(data);
					

				} catch (Exception x) {
					count++;
					str = str + "\n" + "Order task Hk not found, Existing transactions Order task hk should not delete";
					throw new Exception(str);
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Delete Button doesn't Work";

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Delete Order Task Hk With Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 672, 6);
			M.setStrData("Pass", "Automation Testcase", 672, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Order Task Hk With Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 672, 6);
			M.setStrData("Fail", "Automation Testcase", 672, 7);

		}

		ReStart();
	}
	
	
	
	
	// SearchTask
	////@Test(priority = 20)
	public void SearchTask() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Search Task Executed!");
		Thread.sleep(10000);
		SoftAssert SA = new SoftAssert();
		int match = 0;
		int k = 0;
		int user = 0;
		int bar = 0;
		String str = "";
		String data = "";

		try {
			for (int j = 1; j <= 5; j++) {
				int count = 0;
				int cross = 0;

				data = M.getstring("Automation Test Data", 261, j);
				List<AndroidElement> xyz0 = driver.findElementsByXPath("//android.widget.TextView");
				System.out.println(xyz0.size());
				try {
					Thread.sleep(3000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					DataUp(data);
				}catch (Exception e) {	
					;
				}
				Thread.sleep(3000);
				List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView[@text=\"" + data + "\"]");

				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(data)) {
						count++;
					}
					
				}
				 System.out.println(count);
				Thread.sleep(3000);
				M.Searching(data);
				Thread.sleep(3000);

				List<AndroidElement> xyz4 = driver.findElementsByXPath("//android.widget.TextView");
				Thread.sleep(1000);
				List<AndroidElement> xyz1 = driver.findElementsByXPath("//android.widget.TextView[@text=\"" + data + "\"]");
				for (int i = 0; i < xyz1.size(); i++) {
					if (xyz1.get(i).getText().contains(data)) {
						cross++;
					}

				}
				 System.out.println(cross);

				if (count != cross) {
					match++;
					str = str + "\n" + data + "- This search result does not match";
				}

				if (j == 1) {

					// Cross bar
					try {
						driver.findElementById("android:id/search_close_btn").click();
						driver.hideKeyboard();
						Thread.sleep(1000);

						try {
							String search = driver.findElementById("android:id/search_src_text").getText();
							driver.hideKeyboard();
							if (search.equals("search")) {
								System.out.println("search ok");
							}

							else {
								match++;
								str = str + "\n"+ "Search bar place holder doesn't match & search cross bar does't work";
							}

						} catch (Exception e) {

						}
						Thread.sleep(1000);
						List<AndroidElement> xyz3 = driver.findElementsByXPath("//android.widget.TextView");
						int cros = xyz3.size() + 1;
						int value=Math.abs(xyz0.size()-cros);
						
						System.out.println(xyz0.size() + "     " + cros);
						if (value<3)
							System.out.println("cross data ok");
						else {
							match++;
							str = str + "\n" + "After click Search cross bar All user doesn't show in user list";
						}

					} catch (Exception e) {
						match++;
						str = str + "\n" + "- Cross Bar didn't Find";
					}
				}

				// back button in search field
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
					Thread.sleep(2000);

					if (j == 1) {
						try {
							String Mytask = driver.findElementByXPath("//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
							// System.out.println("back button ok");
						} catch (Exception e) {
							match++;
							str = str + "\n" + "After Click back button search bar doesn't remove";

						}

						List<AndroidElement> xyz3 = driver.findElementsByXPath("//android.widget.TextView");
						int cros = xyz3.size() + 1;
						int value=Math.abs(xyz0.size()-cros);
						
						if (value<3)
							System.out.println("back button data ok");
						else {
							match++;
							str = str + "\n" + "After click back button from search bar user list does not same;";
						}

					}

				} catch (Exception e) {
					if (k == 0) {
						k++;
						match++;
						str = str + "\n" + "Search Back Button didn't find";

					}

				}

			}

			if (match > 0)
				throw new Exception(str);

			M.ScreenShots("Screenshot/Passed", "SearchTask");

			M.setStrData("As Expected", "Automation Testcase", 673, 6);
			M.setStrData("Pass", "Automation Testcase", 673, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Search User");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 673, 6);
			M.setStrData("Fail", "Automation Testcase", 673, 7);

		}
		ReStart();
	}


	

}

