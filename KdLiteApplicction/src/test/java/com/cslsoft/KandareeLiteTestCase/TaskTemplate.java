package com.cslsoft.KandareeLiteTestCase;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidElement;

public class TaskTemplate extends BaseClass {
	
	@Test(priority = 0)
	public void Navigate() {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Navigate Hamburgare to Task Template");

	}
	
	
	
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();

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
		    
		    driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
	}
	
	
	
	private void DataUp(String data) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
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
			String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
			// Assert.assertEquals(user,"Add Task Templatess");

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

	
	
	//Template Name
	public void TemplateName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateName").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	
	//Template Description
	public void TemplateDescription(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateDescription").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateDescription").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateDescription").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	
	public void DataFillUp(int i,int j,int k) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if(i==1)
		TemplateName(M.getstring("Automation Test Data", j, k));
		if(i==2)
		TemplateDescription(M.getstring("Automation Test Data", j, k));

	}
	
	public String VerifyText(int i,int j,int k) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String str = "";
		Thread.sleep(2000);

		if(i==1) {
			//Template Name
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateName").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Template Name Doesn't Match");
		}
		if(i==2) {
			//Template Description
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTemplateDescription").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Template Description Doesn't Match");
		}
		if(i==3) {
			//CreatedBy
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "CreatedBy Doesn't Match");
		}
				
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}
	
// Template task \\\
	
	//Order Task HK
	public void OrderTaskHK(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCustomerOrderTaskHK").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	//Calculation Logic
	public void CalculationLogic(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCalculationLogic").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	//Default Assingnee
	public void DefaultAssingnee(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectDefaultAssingnee").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	//NumberOfDays
	public void NumberOfDays(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	//Sequence Numbe
	public void SequenceNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").sendKeys(text);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
		
	public void TaskDataFillUp(int i,int j,int k) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if (i == 1)
			OrderTaskHK(M.getstring("Automation Test Data", j, k), 1);
		if (i == 6)
			CalculationLogic(M.getstring("Automation Test Data", j, k), 1);
		if (i == 7)
			NumberOfDays(M.getstring("Automation Test Data", j, k));
		if (i == 8)
			DefaultAssingnee(M.getstring("Automation Test Data", j, k), 1);
		if (i == 9)
			SequenceNumber(M.getstring("Automation Test Data", j, k));
		
	}

	public String VerifyTemplateTask(int i,int j,int k) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String str = "";
		Thread.sleep(2000);

		if(i==1) {
			//OrderTaskHK
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderTaskHK").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Order TaskHK Doesn't Match");
		}
		if(i==2) {
			//Task Category
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTaskCategory").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Task Category Doesn't Match");
		}
				
		if(i==3) {
			//Order TaskType
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderTaskType").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Order TaskType Doesn't Match");
		}
		
		if(i==4) {
			//Critical Task
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCriticalTask").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Critical Task Doesn't Match");
		}
		
		if(i==5) {
			//Event Milestone
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtEventMilestone").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Event Milestone Doesn't Match");
		}
		
		if(i==6) {
			//Calculation Logic
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCalculationLogic").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Calculation Logic Doesn't Match");
		}
		
		if(i==7) {
			//NumberOfDays
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Number Of Days Doesn't Match");
		}
		
		if(i==8) {
			//Default Assingnee
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDefaultAssingnee").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Default Assingnee Doesn't Match");
		}
		
		if(i==9) {
			//Sequence Number
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Sequence Number Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}	
	
	
	
	
	//Verify Task Templates View
	//@Test (priority = 1)
	public void VerifyTaskTemplatesListView()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Task Templates View Executed!");
		int count=0;
		String str="";
		try {

			try {
				String gettext=driver.findElementByXPath("//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("Task Templates")) {
					;
				}else {
					count++;
					str = str + "\n" + "Task Template Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Template Title doesn't found";
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
			M.ScreenShots("Screenshot/Passed","Verify Task Templates View"); 
		    M.setStrData("As Expected","Automation Testcase", 680, 6);
			M.setStrData("Pass","Automation Testcase", 680, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Task Templates View");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 680, 6);
			M.setStrData("Fail","Automation Testcase", 680, 7);

		}
		ReStart();
	}

		
	
	// Verify Place Holder Text (New Task Template & Add Template Task)
	// @Test(priority = 2)
	public void VerifyCancellationPlaceHolderText() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Place Holder Text- New Task Template & Add Template Task Executed!");
		int count = 0;
		int id = 0;
		String str = "";
		String taskdis = "";
		try {
			//Go to create template page.
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Create icon not found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("New Task Template")) {
					;
				}else {
					count++;
					str = str + "\n" + "New Task Template Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "New Task Template Title doesn't found";
			}
			
			//Verify Task Template
			for(int i=1;i<=3;i++)
			{
				String result=VerifyText(i,284,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
		
			
			//Go to AddTemplateTask
			try {				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
			}catch (Exception e) {
				throw new Exception(e);
			}
			
			try {
				String gettext=driver.findElementByXPath("//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("Add Template Task")) {
					;
				}else {
					count++;
					str = str + "\n" + "Add Template Task Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task Title doesn't found";
			}
			
			//Verrify  Cost Incurred
			for(int i=1;i<=9;i++)
			{
				String result=VerifyTemplateTask(i,286,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
					
			// back to Order
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception m) {

				Thread.sleep(5000);
				M.BackFun(2);
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
			M.ScreenShots("Screenshot/Passed", "Verify Place Holder Text-New Task Template & Add Template Task");
			M.setStrData("As Expected", "Automation Testcase", 681, 6);
			M.setStrData("Pass", "Automation Testcase", 681, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Place Holder Text-New Task Template & Add Template Task");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 681, 6);
			M.setStrData("Fail", "Automation Testcase", 681, 7);
		}
		ReStart();

	}
	
	
	
	// Verify Disabled Create Task Template Button (Default & With Blank Field)
	// @Test (priority = 3)
	public void VerifyDisabledCreateTaskTemplateButton() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disabled Create Task Template Button (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 288;

		try {

			for (int i = 0; i <= 2; i++) {
				boolean tr;
				
				//Go to Create Task Template page.
				try {
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Create icon not found";
					throw new Exception(str);
				}
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				// Full Field Blank
				if (i == 0) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Create Task Template Button is Enable";

					}
					
					i++;

				}
				Thread.sleep(2000);
				if (i != 1) {
					TemplateName(M.getstring("Automation Test Data", k,1));
				}
				if (i != 2) {
					TemplateDescription(M.getstring("Automation Test Data", k,2));
				}
				Thread.sleep(2000);

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == true) {
					System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Template Name Field is Blank But Create Task Template Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Template Description Field is Blank But Create Task Template Button is Enable";
					
					

				}
				if (i != 3) {
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
				
				String result=PageVerification("New Task Template");
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

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Create Task Template Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 682, 6);
			M.setStrData("Pass", "Automation Testcase", 682, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Create Task Template Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 682, 6);
			M.setStrData("Fail", "Automation Testcase", 682, 7);

		}
		ReStart();
	}
	
	
	 
	 
	//Dismiss Unsaved Data-New Task Template (Default & All fields together)
	//@Test(priority = 4)
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
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
				
			}
			Thread.sleep(2000);
			
			//verify Add Task Templates page 
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
					count++;
					str = str + "\n" + "After click back button show warnning messsage with-out input data";
					
				}catch (Exception x) {
					count++;
					str = str + "\n" + "After press back button with-out input data, Apps may be Crush.";
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
			
			for(int i=1;i<=2;i++) {
				try {
					DataFillUp(i,288,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2), M.getstring("Automation Test Data", 303, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify New Task Templates page is present 
			Thread.sleep(2000);
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
				
				try {
					for(int i=1;i<=2;i++)
					{
						String result= VerifyText(i, 288, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,288,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Task Templates page";
				throw new Exception(str);
				
			}
				
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			
			String result=PageVerification("New Task Template");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-New Task Templates");
			M.setStrData("As Expected", "Automation Testcase", 683, 6);
			M.setStrData("Pass", "Automation Testcase", 683, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-New Task Templates");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 683, 6);
			M.setStrData("Fail", "Automation Testcase", 683, 7);

		}
		ReStart();

	}
	 

	
	
	//Dismiss Unsaved Data-New Task Template  (For Each Field)
	//@Test(priority = 5)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		
		try {
			
			for(int i=1;i<=2;i++){
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				
				//data fill up
				try {
					DataFillUp(i,288,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2), M.getstring("Automation Test Data", 303, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",288, i)+ confirmation;
				}				
				
				//Verify New Task Template page is present 
				Thread.sleep(2000);				
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
					
					try {
						String result= VerifyText(i, 288, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i, 288, i);
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
					
					str = str + "\n" + "After click Back button and warning message no, Page Redirect to Task Templates page";
					throw new Exception(str);
					
				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);

				}
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				
				String result=PageVerification("New Task Template");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-New Task Templates (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 684, 6);
			M.setStrData("Pass", "Automation Testcase", 684, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-New Task Templates (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 684, 6);
			M.setStrData("Fail", "Automation Testcase", 684, 7);

		}
		ReStart();
		
	}

	
	
	
	// Verify Disabled Add Template Task Button (Default & With Blank Field)
	//@Test (priority = 6)
	public void VerifyDisabledAddTemplateTaskButton() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disabled Add Template Task Button (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 292;

		try {
			//Go to Create Task Template page.
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Create icon not found";
				throw new Exception(str);
			}
			
			for (int i = 0; i <= 5; i++) {
				boolean tr;
				Thread.sleep(3000);
				try {
					//Add Template Task
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Add Template Task icon not found";
					throw new Exception(str);
				}
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				// Full Field Blank
				if (i == 0) {
					Thread.sleep(2000);
					M.ScrollByText("Add Task");
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Create Task Template Button is Enable";

					}
					Thread.sleep(2000);
					//M.Scroll(1);
					i++;

				}
				Thread.sleep(2000);
				//M.Scroll(1);
				if (i != 1) {
					OrderTaskHK(M.getstring("Automation Test Data", k,1),1);
				}
				if (i != 2) {
					CalculationLogic(M.getstring("Automation Test Data", k, 6), 1);
				}
				if (i != 3) {
					NumberOfDays(M.getstring("Automation Test Data", k, 7));
				}
				if (i != 4) {
					DefaultAssingnee(M.getstring("Automation Test Data", k, 8), 1);
				}
				if (i != 5) {
					SequenceNumber(M.getstring("Automation Test Data", k, 9));
				}
				Thread.sleep(2000);
				M.ScrollByText("Add Task");
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Order Task HK Field is Blank But ADD Template Task Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Calculation Logic Field is Blank But ADD Template Task Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Number Of Days Field is Blank But ADD Template Task Button is Enable";
					else if (i == 4)
						str = str + "\n" + "Default Assingnee Field is Blank But ADD Template Task Button is Enable";
					else if (i == 5)
						str = str + "\n" + "Sequence Number Field is Blank But ADD Template Task Button is Enable";

				}
				if (i != 6) {
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
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
					} catch (Exception e) {
						str = str + "\n" + "After press back button and yes button, New task template page not found";
						throw new Exception(str);
					}

				}

			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Add Template Task Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 685, 6);
			M.setStrData("Pass", "Automation Testcase", 685, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Add Template Task Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 685, 6);
			M.setStrData("Fail", "Automation Testcase", 685, 7);

		}
		ReStart();
	}
	
	
	 
	
	
	// Dismiss Selected Value From Dropdown (Add Template Task)
	//@Test(priority = 7)
	public void DismissSelectedValueFromDropdown_AddTemplateTask() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (AddTemplateTask) Executed!");
		int count = 0;
		String str = "";
		int i = 292;
		
		try {
			//Go to New Task Template page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(2000);
				//Go to Add Template Task
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Add Template Task icon not found";
					throw new Exception(str);
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			
			// Verrify Order Task HK
			OrderTaskHK(M.getstring("Automation Test Data", i, 1),2);			
			String result = VerifyTemplateTask(1, 286, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// Verrify Calculation Logic
			CalculationLogic(M.getstring("Automation Test Data", i, 6),2);
			result = VerifyTemplateTask(6, 286, 6);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// Verrify Default Assingnee
			DefaultAssingnee(M.getstring("Automation Test Data", i, 8),2);
			result = VerifyTemplateTask(8, 286, 8);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception m) {
					
					;
				}

				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception m) {
					
					;
				}
				Thread.sleep(5000);
				M.BackFun(1);

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
			M.ScreenShots("Screenshot/Passed", "Dismiss Selected Value From Dropdown (AddTemplateTask)");
			M.setStrData("As Expected", "Automation Testcase", 686, 6);
			M.setStrData("Pass", "Automation Testcase", 686, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Selected Value From Dropdown (AddTemplateTask)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 686, 6);
			M.setStrData("Fail", "Automation Testcase", 686, 7);
		}

	}
	
	
	// Dismiss Unsaved Data-Add Template Task (Default & All fields together)
	//@Test(priority = 8)
	public void DismissAddTemplateTaskUnsavedDataDefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Add Template Task (Default & All fields together) Executed!");
		int count = 0;
		String str = "";

		try {

			// Go to New Task Template page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(2000);
				// Go to Add Template Task
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Add Template Task icon not found";
					throw new Exception(str);
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);

			// verify Add Task Templates page
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
				// System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
					count++;
					str = str + "\n" + "After click back button show warnning messsage with-out input data";

				} catch (Exception x) {
					count++;
					str = str + "\n" + "After press back button with-out input data, Apps may be Crush.";
					throw new Exception(str);
				}

			}

			// After input data
			
			// Go to Add Template Task
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task icon not found";
				throw new Exception(str);
			}

			Thread.sleep(5000);

			for (int i = 1; i <= 9; i++) {
				try {
					TaskDataFillUp(i, 292, i);
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}

			// check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2),M.getstring("Automation Test Data", 303, 3));
			if (confirmation.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Back Button " + confirmation;
			}

			// Verify Add Templates Task page is present
			Thread.sleep(5000);
			M.Scroll(1);
			Thread.sleep(5000);
			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();

				try {
					for (int i = 1; i <= 9; i++) {
						String result = VerifyTemplateTask(i, 292, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + "After click warning message no-" + result;
							TaskDataFillUp(i, 292, i);
						}

					}
				} catch (Exception e) {

					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}

			} catch (Exception e) {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task Templates']").getText();

				str = str + "\n"+ "After click Back button and warning message no, Page Redirect to New Task Templates page";
				throw new Exception(str);

			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			
			String result = PageVerification("New Task Template");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-New Task Templates");
			M.setStrData("As Expected", "Automation Testcase", 687, 6);
			M.setStrData("Pass", "Automation Testcase", 687, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-New Task Templates");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 687, 6);
			M.setStrData("Fail", "Automation Testcase", 687, 7);

		}
		ReStart();

	}		
	
	
	
	

	//Dismiss Unsaved Data-New Task Template  (For Each Field)
	//@Test(priority = 9)
	public void DismissAddTemplateTaskUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Add Template Task (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		
		try {
			// Go to New Task Template page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(2000);
				

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			for(int i=1;i<=9;i++){
				Thread.sleep(5000);
				// Go to Add Template Task
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Add Template Task icon not found";
					throw new Exception(str);
				}	
				Thread.sleep(5000);
				//data fill up
				//System.out.println(i);
				try {
					TaskDataFillUp(i, 292, i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Back button doesn't found";
					Thread.sleep(5000);
					M.BackFun(1);

				}
								
				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2), M.getstring("Automation Test Data", 303, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",292, i)+ confirmation;
				}				
				
				//Verify Add Template Task page is present 
				Thread.sleep(2000);				
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
					
					try {
						String result= VerifyTemplateTask(i, 292, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							TaskDataFillUp(i, 292, i);
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
					
					str = str + "\n" + "After click Back button and warning message no, Page Redirect to New Task Templates page";
					throw new Exception(str);
					
				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);

				}
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				if(i==1)
					i=5;

			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}

			String result = PageVerification("New Task Template");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Add Template Task (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 688, 6);
			M.setStrData("Pass", "Automation Testcase", 688, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Add Template Task (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 688, 6);
			M.setStrData("Fail", "Automation Testcase", 688, 7);

		}
		ReStart();
		
	}

	
	
	
	// Create Task Template
	//@Test (priority = 10)
	public void CreateTaskTemplate()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Task Template Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		String text = "Create Task Template";
		
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
			for(int i=1;i<=2;i++) {
				try {
					DataFillUp(i,288,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Thread.sleep(2000);
			//M.ScrollByText(text);
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Task Template button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message, Task Templates page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to New Task Template";
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
							
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
			
			Thread.sleep(5000);
			//check create field is blank or not
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			try {
				for (int i = 1; i <= 2; i++) {
					String result = VerifyText(i, 284, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Task Template, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("New Task Template");
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
			M.ScreenShots("Screenshot/Passed","Create Task Template"); 
		    M.setStrData("As Expected","Automation Testcase", 689, 6);
			M.setStrData("Pass","Automation Testcase", 689, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Task Template");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 689, 6);
			M.setStrData("Fail","Automation Testcase", 689, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
	
	// Verify Create Order & Data 
	//@Test (priority = 11)
	public void VerifyCreateTaskTemplate_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Create Task Template & Data Executed!");
		String order ="";
		String str ="";
		int count=0;
		int j=0;

		try {
					
			order = M.getstring("Automation Test Data",288, 1);
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(order)) {
					pass++;
					Thread.sleep(5000);
					j=counting(order, str1, str2);
					
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(order)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
					System.out.println(j);
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Template user create icon does not display";
					}
					
					
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 288, 1), "Task Template Name Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Template Name does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 288, 2), "Task Template Discription Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Template Discription does not display";
					}
					
					
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();						
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Task Template didn't create");
			
			
			// Verify task Template details data
			try {
				
				
				try {
					Thread.sleep(5000);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}

				for (int i = 1; i <= 2; i++) {
					String result = VerifyText(i, 288, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				//Button Text
				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 3),"CreatedBy Name Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 4),
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
			
			String result=PageVerification("Task Template Detail");
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
		    M.setStrData("As Expected","Automation Testcase", 690, 6);
			M.setStrData("Pass","Automation Testcase", 690, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Create Order & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 690, 6);
			M.setStrData("Fail","Automation Testcase", 690, 7);
	
		}
		ReStart();
	}
	
	
	
	//Add Template Tasks in Existing Task Template
	//@Test (priority = 12)
	public void VerifyTemplateTask()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Add Template Tasks in Existing Task Template Executed!");
		int count=0;
		String str="";
		String Temp="";
		try {
			Temp = M.getstring("Automation Test Data",288, 1);
			Thread.sleep(5000);
			
			// Go to Task Template
			
			try {
				M.ClickOn(Temp);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Templete not found in templete list.";
				throw new Exception(str);
			}
			
			// Go to Add Template Task
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task icon not found";
				throw new Exception(str);
			}	
			
			
			// Data input
			for (int i = 1; i <= 9; i++) {
				try {
					TaskDataFillUp(i, 292, i);
					if(i==1)
						i=5;
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

			}			
			
			//Template Task add button
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Template Task button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}


			//Verify page after add task
			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message ok, Task Template Detail page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add Template Task";
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
							
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
			
			
			// Go to Add Template Task
			try {
				Thread.sleep(5000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task icon not found";
				throw new Exception(str);
			}	
			
			//verify Template Task Blank page
			try {
				for (int i = 1; i <= 9; i++) {
					String result = VerifyTemplateTask(i, 286, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Template Task , When again go to add task page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			// Back Button from Add Template Task page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from add task template page after add task and go again..";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}			
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte add task.";
				} catch (Exception e) {
					;
				}
				
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
			M.ScreenShots("Screenshot/Passed","Add Template Tasks in Existing Task Template"); 
		    M.setStrData("As Expected","Automation Testcase", 691, 6);
			M.setStrData("Pass","Automation Testcase", 691, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Add Template Tasks in Existing Task Template");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 691, 6);
			M.setStrData("Fail","Automation Testcase", 691, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	// Verify Add Templete Task & Data 
	//@Test (priority = 13)
	public void VerifyAddTempleteTask_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Add Templete Task & Data Executed!");
		String Temp ="";
		String Task ="";
		String str ="";
		int count=0;
		int j=0;

		try {
					
			Temp = M.getstring("Automation Test Data",288, 1);
			// Go to Task Template

			try {
				M.ClickOn(Temp);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Templete not found in templete list.";
				throw new Exception(str);
			}

			

			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			Task=M.getstring("Automation Test Data",292, 1);
			
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(Task)) {
					pass++;
					Thread.sleep(5000);
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
					//Order task icon
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order task icon does not display in Card";
					}
					
					//Sequence Number
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 9), "Sequence Number Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Sequence Number does not display in Card";
					}
					
					//Order Task Hk
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 1), "Order Task Hk Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order Task Hk does not display in Card";
					}
					
					//Task Category
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 2), "Task Category Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Category does not display in Card";
					}
					
					//Task Assigner Name
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 11), "Task Assigner Name Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Assigner Name does not display in Card";
					}
					
					//Critical task
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 4), "Critical task Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Critical task does not display in Card";
					}
					
					//EventMileStone
					String text=M.getstring("Automation Test Data", 293, 5)+" + "+M.getstring("Automation Test Data", 293, 7)+" Days";
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView").getText();
						SA.assertEquals(gettext, text, "Event MileStone Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Event MileStone does not display in Card";
					}
					
					
					Thread.sleep(5000);
					M.SwipBytext(M.getstring("Automation Test Data", 293, 1));
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Template Task didn't add in template");
			
			
			
			try {
				
				Thread.sleep(5000);
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Update Template Task']").getText();
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Update Template Task page not found check manually what happend";
					throw new Exception(str);
				}
				
				int k=293;
				for (int i = 1; i <= 9; i++) {
					if(i==9)
						k=292;
					String result = VerifyTemplateTask(i, k, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 4),"Save Changes button Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}


			// Back Button from Add Template Task page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Update Template Task page .";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}			
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte verify task.";
				} catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				;
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
			
			M.ScreenShots("Screenshot/Passed"," Verify Add Templete Task & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 692, 6);
			M.setStrData("Pass","Automation Testcase", 692, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Add Templete Task & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 692, 6);
			M.setStrData("Fail","Automation Testcase", 692, 7);
	
		}
		ReStart();
	}
	
	 
	
	
	// Dismiss Selected Value From Dropdown (UpdateTemplate Task)
	//@Test(priority = 14)
	public void DismissSelectedValueFromDropdown_UpdateTemplateTask() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (UpdateTemplate Task) Executed!");
		int count = 0;
		String str = "";
		String Temp = "";
		String Task = "";
		int i = 294;
		int k = 293;
		
		try {
			//Go to Task Template Detail page
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				Task=M.getstring("Automation Test Data",292, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				//Go to Add Template Task
				try {
					M.ScrollDwon(1);
					
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					int j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					Thread.sleep(2000);
					M.SwipBytext(Task);
					//click on Edit button
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Exiting Template Task not found";
					throw new Exception(str);
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			

			// Verrify Order Task HK
			OrderTaskHK(M.getstring("Automation Test Data", i, 1),2);			
			String result = VerifyTemplateTask(1, k, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// Verrify Calculation Logic
			CalculationLogic(M.getstring("Automation Test Data", i, 6),2);
			result = VerifyTemplateTask(6, k, 6);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// Verrify Default Assingnee
			DefaultAssingnee(M.getstring("Automation Test Data", i, 8),2);
			result = VerifyTemplateTask(8, k, 8);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Update Template Task page .";
				} catch (Exception m) {
					
					;
				}

				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte verify task.";
				} catch (Exception m) {
					
					;
				}
				Thread.sleep(5000);
				M.BackFun(1);

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
			M.ScreenShots("Screenshot/Passed", "Dismiss Selected Value From Dropdown (AddTemplateTask)");
			M.setStrData("As Expected", "Automation Testcase", 693, 6);
			M.setStrData("Pass", "Automation Testcase", 693, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Selected Value From Dropdown (AddTemplateTask)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 693, 6);
			M.setStrData("Fail", "Automation Testcase", 693, 7);
		}

	}
	
	
	
	
	// Verify Disabled Add Template Task Button (Default & With Blank Field)
	//@Test (priority =15)
	public void VerifyDisabledUpdateTemplateTaskButton() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disabled Update Template Task Button (Default & Blank Field) Executed!");
		String str = "";
		String Temp = "";
		String Task = "";
		int count = 0;
		int k = 294;
		

		try {
			//Go to Task Template Detail page
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				Task=M.getstring("Automation Test Data",292, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				//Go to Add Template Task
				try {
					M.ScrollDwon(1);
					
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					int j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					Thread.sleep(2000);
					M.SwipBytext(Task);
					//click on Edit button
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Exiting Template Task not found";
					throw new Exception(str);
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			
			for (int i = 0; i <= 2; i++) {
				boolean tr;

				Thread.sleep(3000);
				// Full Field Blank
				if (i == 0) {
					Thread.sleep(2000);
					M.ScrollByText("Save Changes");
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").isEnabled();
					if (tr == true) {
						count++;
						str = str + "Default in Update page, Save Changes Task Template Button is Enable";

					}
					Thread.sleep(2000);
					//M.Scroll(1);
					i++;

				}
				Thread.sleep(2000);
				//M.Scroll(1);
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtNumberOfDays").clear();
					driver.hideKeyboard();
					
				}
				if (i == 2) {
					NumberOfDays(M.getstring("Automation Test Data", k,7));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtSequenceNumber").clear();
					driver.hideKeyboard();
					
				}
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Number Of Days Field is Blank But Save Changes Template Task Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Sequence Number Field is Blank But Save Changes Template Task Button is Enable";
					
				}
				

			}

			// Back Button from Add Template Task page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//count++;
					//str = str + "\n" + "Unwanted warning message show, when back from Update Template Task page .";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}			
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte verify task.";
				} catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				;
			}			
			
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Add Template Task Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 694, 6);
			M.setStrData("Pass", "Automation Testcase", 694, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Add Template Task Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 694, 6);
			M.setStrData("Fail", "Automation Testcase", 694, 7);

		}
		ReStart();
	}
	
	
	
	
	
	//Verify Save Changes Button Disabled/Enabled  (For Each Field)
	//@Test(priority = 16)
	public void VerifySaveChangesButtonDisabledEnabled_UpdateTemplateTask() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("VerifySaveChangesButtonDisabledEnabled_UpdateTemplateTask Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		String Temp = "";
		String Task = "";
		
		try {
			//Go to Task Template Detail page
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				Task=M.getstring("Automation Test Data",292, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				//Go to Update Template Task
				
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			
			for(int i=1;i<=9;i++){
				Thread.sleep(5000);
				// Go to Add Template Task
				try {
					M.ScrollDwon(1);
					
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					int j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					Thread.sleep(2000);
					M.SwipBytext(Task);
					//click on Edit button
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Exiting Template Task not found";
					throw new Exception(str);
				}
				
				Thread.sleep(5000);
				//data fill up
				//System.out.println(i);
				try {
					TaskDataFillUp(i, 294, i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				Boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").isEnabled();
				if (tr == false) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Order Task HK field is modify but Save Change button is disable";
					
					else if (i == 6)
						str = str + "\n" + "Calculation Logical field is modify but Save Change button is disable";
					
					else if (i == 7)
						str = str + "\n" + "Number of days Field is modify but Save Change button is disable";
					
					else if (i == 8)
						str = str + "\n" + "Default Assignee Field is modify but Save Change button is disable";
					
					else if (i == 9)
						str = str + "\n" + "Sequence Number Field is modify but Save Change button is disable";
					
				}

				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Back button doesn't found";
					Thread.sleep(5000);
					M.BackFun(1);

				}
								
				
				Thread.sleep(2000);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					;
				}
				if(i==1)
					i=5;

			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "VerifySaveChangesButtonDisabledEnabled_UpdateTemplateTask");
			M.setStrData("As Expected", "Automation Testcase", 695, 6);
			M.setStrData("Pass", "Automation Testcase", 695, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "VerifySaveChangesButtonDisabledEnabled_UpdateTemplateTask");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 695, 6);
			M.setStrData("Fail", "Automation Testcase", 695, 7);

		}
		ReStart();
		
	}


	
	
	// Dismiss Unsaved Data-Add Template Task (Default & All fields together)
	//@Test(priority = 17)
	public void DismissUpdateTemplateTaskUnsavedDataDefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Update Template Task (Default & All fields together) Executed!");
		int count = 0;
		int j = 0;
		String str = "";
		String Temp = "";
		String Task = "";
		
		

		try {
			//Go to Task Template Detail page
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				Task=M.getstring("Automation Test Data",292, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				//Go to Add Template Task
				try {
					M.ScrollDwon(1);
					
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					Thread.sleep(2000);
					M.SwipBytext(Task);
					//click on Edit button
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Exiting Template Task not found";
					throw new Exception(str);
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			
			//back button
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);

			// verify Add Task Templates page
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
				// System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
					count++;
					str = str + "\n" + "After click back button, show warnning messsage with-out input data";

				} catch (Exception x) {
					count++;
					str = str + "\n" + "After press back button with-out input data, Apps may be Crush.";
					throw new Exception(str);
				}

			}

			// After input data
			
			// Go to Add Template Task
			try {
				Thread.sleep(2000);
				M.SwipBytext(Task);
				//click on Edit button
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Exiting Template Task not found";
				throw new Exception(str);
			}

			Thread.sleep(5000);

			for (int i = 1; i <= 9; i++) {
				try {
					TaskDataFillUp(i, 294, i);
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}

			// check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2),M.getstring("Automation Test Data", 303, 3));
			if (confirmation.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Back Button " + confirmation;
			}

			// Verify Add Templates Task page is present
			Thread.sleep(5000);
			M.Scroll(1);
			Thread.sleep(5000);
			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Update Template Task']").getText();

				try {
					for (int i = 1; i <= 9; i++) {
						String result = VerifyTemplateTask(i, 294, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + "After click warning message no-" + result;
							TaskDataFillUp(i, 294, i);
						}

					}
				} catch (Exception e) {

					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}

			} catch (Exception e) {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();

				str = str + "\n"+ "After click Back button and warning message no, Page Redirect to Task Template Detail page";
				throw new Exception(str);

			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			
			String result = PageVerification("Task Template Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Update Templates Task");
			M.setStrData("As Expected", "Automation Testcase", 696, 6);
			M.setStrData("Pass", "Automation Testcase", 696, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Update Templates Task");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 696, 6);
			M.setStrData("Fail", "Automation Testcase", 696, 7);

		}
		ReStart();

	}		
	
	
	
	

	//Dismiss Unsaved Data-New Task Template  (For Each Field)
	//@Test(priority = 18)
	public void DismissUpdateTemplateTaskUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Update Template Task (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		int j= 0;
		String str = "";
		String Temp = "";
		String Task = "";
		
		try {
			//Go to Task Template Detail page
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				Task=M.getstring("Automation Test Data",292, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				//Go to Update Template Task
				
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			
			for(int i=1;i<=9;i++){
				Thread.sleep(5000);
				// Go to Add Template Task
				try {
					M.ScrollDwon(1);
					if(i==1) {
						Thread.sleep(2000);
						List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
						String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
						String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
						j=counting(Task, str1, str2);
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(Task)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
					}
					
					Thread.sleep(2000);
					M.SwipBytext(Task);
					//click on Edit button
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Exiting Template Task not found";
					throw new Exception(str);
				}
				
				Thread.sleep(5000);
				//data fill up
				//System.out.println(i);
				try {
					TaskDataFillUp(i, 294, i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				//Back button
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Back button doesn't found";
					Thread.sleep(5000);
					M.BackFun(1);

				}
								
				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2), M.getstring("Automation Test Data", 303, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",294, i)+ confirmation;
				}				
				
				//Verify Update Template Task page is present 
				Thread.sleep(2000);				
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Update Template Task']").getText();
					
					try {
						String result= VerifyTemplateTask(i, 294, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							TaskDataFillUp(i, 294, i);
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
					
					str = str + "\n" + "After click Back button and warning message no, Page Redirect to Task Template Detail page";
					throw new Exception(str);
					
				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);

				}
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				if(i==1)
					i=5;

			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);

			}

			String result = PageVerification("Task Template Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Update Template Task (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 697, 6);
			M.setStrData("Pass", "Automation Testcase", 697, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Update Template Task (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 697, 6);
			M.setStrData("Fail", "Automation Testcase", 697, 7);

		}
		ReStart();
		
	}

	
	
	
	
	//Update Template Tasks in Existing Task Template
	//@Test (priority = 19)
	public void UpdateTemplateTask()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Update Template Tasks in Existing Task Template Executed!");
		int count=0;
		int j=0;
		String str="";
		String Temp = "";
		String Task = "";
		
		

		try {
			//Go to Task Template Detail page
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				Task=M.getstring("Automation Test Data",292, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				//Go to Add Template Task
				try {
					M.ScrollDwon(1);
					
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					Thread.sleep(2000);
					M.SwipBytext(Task);
					//click on Edit button
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Exiting Template Task not found";
					throw new Exception(str);
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			
			
			// Data input
			for (int i = 1; i <= 9; i++) {
				try {
					TaskDataFillUp(i, 294, i);
					if(i==1)
						i=5;
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

			}		
			
			Thread.sleep(2000);
			M.ScrollByText("Save Changes");
			
			//Template Task add button
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Save Changes button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 4), M.getstring("Automation Test Data", 305, 5));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}


			//Verify page after update task
			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Update Template Task']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message ok, Task Template Detail page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
					str = str + "\n" + "After sucessful message ok, Page redirect to Task Template Detail";
					
					
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
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n"+ "Unwanted warning message show, when back from Update Template Task page afte update.";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}

			// Go to Add Template Task
			try {
				Thread.sleep(5000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task icon not found";
				throw new Exception(str);
			}	
			
			//verify Template Task Blank page
			try {
				for (int i = 1; i <= 9; i++) {
					String result = VerifyTemplateTask(i, 286, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Template Task , When again go to add task page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			// Back Button from Add Template Task page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from add task template page after add task and go again..";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}			
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte add task.";
				} catch (Exception e) {
					;
				}
				
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
			M.ScreenShots("Screenshot/Passed","Update Template Tasks in Existing Task Template"); 
		    M.setStrData("As Expected","Automation Testcase", 698, 6);
			M.setStrData("Pass","Automation Testcase", 698, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Template Tasks in Existing Task Template");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 698, 6);
			M.setStrData("Fail","Automation Testcase", 698, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	// Verify Update Templete Task & Data 
	//@Test (priority = 20)
	public void VerifyUpdateTempleteTask_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Templete Task & Data Executed!");
		String Temp ="";
		String Task ="";
		String str ="";
		int count=0;
		int j=0;

		try {
					
			Temp = M.getstring("Automation Test Data",288, 1);
			
			// Go to Task Template
			try {
				M.ClickOn(Temp);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Templete not found in templete list.";
				throw new Exception(str);
			}

			

			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			Task=M.getstring("Automation Test Data",294, 1);
			
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(Task)) {
					pass++;
					Thread.sleep(5000);
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
					//Order task icon
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order task icon does not display in Card";
					}
					
					//Sequence Number
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 9), "Sequence Number Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Sequence Number does not display in Card";
					}
					
					//Order Task Hk
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 294, 1), "Order Task Hk Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order Task Hk does not display in Card";
					}
					
					//Task Category
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 294, 2), "Task Category Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Category does not display in Card";
					}
					
					//Task Assigner Name
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 294, 8), "Task Assigner Name Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Assigner Name does not display in Card";
					}
					
					//Critical task
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 294, 4), "Critical task Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Critical task does not display in Card";
					}
					
					//EventMileStone
					String text=M.getstring("Automation Test Data", 294, 5)+" - "+M.getstring("Automation Test Data", 294, 7)+" Days";
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView").getText();
						SA.assertEquals(gettext, text, "Event MileStone Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Event MileStone does not display in Card";
					}
					
					
					Thread.sleep(5000);
					M.SwipBytext(M.getstring("Automation Test Data", 294, 1));
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			System.out.println(pass);
			if (pass == 0)
				throw new Exception("Template Task didn't Update in template");
			
			
			
			try {
				
				Thread.sleep(5000);
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Update Template Task']").getText();
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Update Template Task page not found check manually what happend";
					throw new Exception(str);
				}
				
				int k=294;
				for (int i = 1; i <= 9; i++) {
					
					String result = VerifyTemplateTask(i, k, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 4),"Save Changes button Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}


			// Back Button from Add Template Task page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Update Template Task page .";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}			
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte verify task.";
				} catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				;
			}			
			
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			if (count > 0) {
				//System.out.println(str);
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Verify Update Templete Task & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 699, 6);
			M.setStrData("Pass","Automation Testcase", 699, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Update Templete Task & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 699, 6);
			M.setStrData("Fail","Automation Testcase", 699, 7);
	
		}
		ReStart();
	}
	
	
	
	
	// Delete Template Task (Without Transaction)
	//@Test(priority = 21)
	public void DeleteTemplateTaskWithoutExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete Template Task Without Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String Temp ="";
		String Task ="";
		

		try {
					
			Temp = M.getstring("Automation Test Data",288, 1);
			
			// Go to Task Template
			try {
				M.ClickOn(Temp);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Templete not found in templete list.";
				throw new Exception(str);
			}

			

			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			Task=M.getstring("Automation Test Data",294, 1);
			
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(Task)) {
					pass++;
					Thread.sleep(5000);
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}

					break;

				}

			}
			try{
				Thread.sleep(5000);
				M.SwipBytext(M.getstring("Automation Test Data", 294, 1));
				Thread.sleep(5000);
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Template Task not found or delete button not found.";
				throw new Exception(str);
			}
			
			
			// Warnning message
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 310, 2),M.getstring("Automation Test Data", 310, 3));
			if (confirmation.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + confirmation;
			}

			try {
				Thread.sleep(2000);
				String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				count++;
				str = str + "\n" + "After Delete Warning message no, template card doesn't close";

			} catch (Exception e) {
				try {
					Thread.sleep(5000);
					M.ScrollByText(Task);
					Thread.sleep(5000);
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					
					Thread.sleep(5000);
					M.SwipBytext(M.getstring("Automation Test Data", 294, 1));
					Thread.sleep(5000);
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Delete warning message No,Template Task card Delete ";
					throw new Exception(str);
				}

			}
			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
			}catch(Exception e) {
				str = str + "\n" + "Delete Button not found";
				throw new Exception(str);
			}
			

			//warnign message yes
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}catch(Exception e) {
				;
			}
			
			
			try {
				
				//Sucessfull message
				String sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 310, 4),M.getstring("Automation Test Data", 310, 5));
				if (sucessfull.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + sucessfull;
				}


			} catch (Exception e) {
				count++;
				str = str + "\n" + "Delete Button doesn't Work";

			}
			
			try {
				Thread.sleep(5000);
				M.ScrollByText(Task);
				count++;
				str = str + "\n" + "After Delete and sucessfull message OK, Template task doesn't delete";

			} catch (Exception x) {
				
				;
			}

			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte Delete task.";
				} catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				;
			}			
			


			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Delete Template Task Without Transaction");
			M.setStrData("As Expected", "Automation Testcase", 700, 6);
			M.setStrData("Pass", "Automation Testcase", 700, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Template Task Without Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 700, 6);
			M.setStrData("Fail", "Automation Testcase", 700, 7);

		}

		ReStart();
	}
	
		
	
	
	// Verify Disabled Task Template Save changes Button (Default & With Blank Field)
	// @Test (priority = 22)
	public void VerifyDisabledTaskTemplateSavechangesButton() throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disabled Task Template Save changes Button (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 288;
		String Temp = M.getstring("Automation Test Data",288, 1);
		try {
			//Go to Task Template Detail page.
			try {
				M.ClickOn(Temp);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Templete not found in templete list.";
				throw new Exception(str);
			}
			for (int i = 0; i <= 2; i++) {
				boolean tr;
				
				
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				
				
				// By Default.
				if (i == 0) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
					if (tr == true) {
						count++;
						str = str + "No field is modify but Task Template Save Changes Button is Enable";

					}
					
					i++;

				}
				Thread.sleep(2000);
				if (i == 1) {
					TemplateName(M.getstring("Automation Test Data", k,20));
				}
				if (i == 2) {
					TemplateName(M.getstring("Automation Test Data", k,1));
					TemplateDescription(M.getstring("Automation Test Data", k,20));
				}
				Thread.sleep(2000);

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == true) {
					System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Template Name Field is Blank But Create Task Template Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Template Description Field is Blank But Create Task Template Button is Enable";
					
				}
			}
			
			//back to home page.
			try {
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.BackFun(1);
				Thread.sleep(100);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				// System.out.println("Warning Message Not Found");
			}

			String result = PageVerification("Task Template Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Task Template Save changes Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase",701, 6);
			M.setStrData("Pass", "Automation Testcase", 701, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Task Template Save changes Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 701, 6);
			M.setStrData("Fail", "Automation Testcase", 701, 7);

		}
		ReStart();
	}
	

	
	
	
	// Verify Disabled Task Template Save changes Button (For Each Field)
	//@Test(priority = 23)
	public void VerifyDisabledTaskTemplateSavechangesButton_EachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println(" Verify Disabled Task Template Save changes Button (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		String Temp = "";
		String Task = "";
		
		try {
			//Go to Task Template Detail page

			
			for(int i=1;i<=2;i++){
				Thread.sleep(5000);
				try {
					Thread.sleep(2000);
					Temp = M.getstring("Automation Test Data",288, 1);
					M.ClickOn(Temp);
					Thread.sleep(5000);
					
					
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Existing Task Template doesn't found";
					throw new Exception(str);
				}
				
				try {
					DataFillUp(i, 290, i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				Boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == false) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Template Name field is modify but Save Change button is disable";
					
					else if (i == 2)
						str = str + "\n" + "Template Discription field is modify but Save Change button is disable";
					
					
				}

				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);

				}
								
				
				Thread.sleep(2000);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					;
				}
				

			}

			String result = PageVerification("Task Template Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}


			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", " Verify Disabled Task Template Save changes Button (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 702, 6);
			M.setStrData("Pass", "Automation Testcase", 702, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", " Verify Disabled Task Template Save changes Button (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 702, 6);
			M.setStrData("Fail", "Automation Testcase", 702, 7);

		}
		ReStart();
		
	}

	
	 
	 
	//Dismiss Unsaved Data-Task Template Detail (Default & All fields together)
	//@Test(priority = 24)
	public void DismissUnsavedData_TaskTemplateDetail_DefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-Task Template Detail (Default & All fields together) Executed!");
		int count = 0;
		String str = "";
		String Temp = "";
		try {
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
				
			}
			Thread.sleep(2000);
			
			//verify Add Task Templates page 
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
					count++;
					str = str + "\n" + "After click back button show warnning messsage with-out input data";
					
				}catch (Exception x) {
					count++;
					str = str + "\n" + "After press back button with-out input data, Apps may be Crush.";
					throw new Exception(str);
				}

			}
			
			
			//After input data
			
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=2;i++) {
				try {
					DataFillUp(i,290,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2), M.getstring("Automation Test Data", 303, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify Task Template Detail page is present 
			Thread.sleep(2000);
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
				
				try {
					for(int i=1;i<=2;i++)
					{
						String result= VerifyText(i, 290, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,288,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Task Templates page";
				throw new Exception(str);
				
			}
				
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			
			String result=PageVerification("Task Template Detail");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Task Templates Detail");
			M.setStrData("As Expected", "Automation Testcase", 704, 6);
			M.setStrData("Pass", "Automation Testcase", 704, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Task Templates Detail");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 704, 6);
			M.setStrData("Fail", "Automation Testcase", 704, 7);

		}
		ReStart();

	}
	 

	
	
	//Dismiss Unsaved Data-Task Template Detail  (For Each Field)
	//@Test(priority = 25)
	public void DismissUnsavedData_TaskTemplateDetail_ForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		String Temp = "";
		try {
			
			for(int i=1;i<=2;i++){
				try {
					Thread.sleep(2000);
					Temp = M.getstring("Automation Test Data",288, 1);
					M.ClickOn(Temp);
					Thread.sleep(5000);
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Existing Task Template doesn't found";
					throw new Exception(str);
				}
				
				//data fill up
				try {
					DataFillUp(i,290,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 303, 2), M.getstring("Automation Test Data", 303, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",290, i)+ confirmation;
				}				
				
				//Verify New Task Template page is present 
				Thread.sleep(2000);				
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
					
					try {
						String result= VerifyText(i, 290, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i, 290, i);
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
					
					str = str + "\n" + "After click Back button and warning message no, Page Redirect to Task Templates page";
					throw new Exception(str);
					
				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);

				}
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				
				String result=PageVerification("Task Template Detail");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Task Template Detail (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 704, 6);
			M.setStrData("Pass", "Automation Testcase", 704, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Task Template Detail (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 704, 6);
			M.setStrData("Fail", "Automation Testcase", 704, 7);

		}
		ReStart();
		
	}

	
	
	
	
	// Update Task Template
	//@Test (priority = 26)
	public void UpdateTaskTemplate()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update Task Template Executed!");
		int count = 0;
		String str = "";
		String Temp = "";
		String successful = "";
		String text = "Create Task Template";
		
		try {
			
			//Go to create page.
			try {
				Thread.sleep(2000);
				Temp = M.getstring("Automation Test Data",288, 1);
				M.ClickOn(Temp);
				Thread.sleep(5000);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Existing Task Template doesn't found";
				throw new Exception(str);
			}
			
			// Data input
			for(int i=1;i<=2;i++) {
				try {
					DataFillUp(i,290,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Thread.sleep(2000);
			//M.ScrollByText(text);
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Task Template button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 313, 4), M.getstring("Automation Test Data", 313, 5));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessfully update, Task Template Details page not found";
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
					str = str + "\n" + "After sucessfully update, Page redirect to Task Templates";

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

			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n"+ "Unwanted warning message show, when back from Task Template Detail page afte update.";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}

			Thread.sleep(5000);
			//check create field is blank or not
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			try {
				for (int i = 1; i <= 2; i++) {
					String result = VerifyText(i, 284, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Task Template, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Task Template Detail");
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
			M.ScreenShots("Screenshot/Passed","Create Task Template"); 
		    M.setStrData("As Expected","Automation Testcase", 705, 6);
			M.setStrData("Pass","Automation Testcase", 705, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Task Template");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 705, 6);
			M.setStrData("Fail","Automation Testcase", 705, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
	
	// Verify Update Task Template
	//@Test (priority = 27)
	public void VerifyUpdateTaskTemplate_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Task Template & Data Executed!");
		String order ="";
		String str ="";
		int count=0;
		int j=0;

		try {
					
			order = M.getstring("Automation Test Data",290, 1);
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(order)) {
					pass++;
					Thread.sleep(5000);
					j=counting(order, str1, str2);
					
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(order)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
					//System.out.println(j);
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Template user create icon does not display";
					}
					
					
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 290, 1), "Task Template Name Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Template Name does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 290, 2), "Task Template Discription Doesn't Match");
						System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Template Discription does not display";
					}
					
					
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();						
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Task Template didn't create");
			
			
			// Verify task Template details data
			try {
				
				
				try {
					Thread.sleep(5000);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}

				for (int i = 1; i <= 2; i++) {
					String result = VerifyText(i, 290, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				//Create By
				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 3),"CreatedBy Name Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");
				//Button Text
				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 4),
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
			
			String result=PageVerification("Task Template Detail");
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
			
			M.ScreenShots("Screenshot/Passed","Verify Update Task Template & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 706, 6);
			M.setStrData("Pass","Automation Testcase", 706, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Update Task Template & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 706, 6);
			M.setStrData("Fail","Automation Testcase", 706, 7);
	
		}
		ReStart();
	}
	

	
	
	
	//Verify Disable Task Templatek (Without Existing Transaction)
	//@Test (priority = 28)
	public void DisableTaskTemplateWithoutExistingTransaction()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Disable Task Template Without Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 290, 1);
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
	
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 307, 2),M.getstring("Automation Test Data", 307, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}
				
				
				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					//System.out.println(gettext);
					count++;
					str = str + "\n" +"After click warning message No, Task Template card still open.";
					if(gettext.contains("Enable")) {
						//System.out.println(gettext);
						count++;
						str = str + "\n" +"After click warning message No, Disable button change to Enable";
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
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
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
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 307, 4), M.getstring("Automation Test Data", 307, 5));
				
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
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					count++;
					str = str + "\n" +"After click Disable button and sucessful ok button, Task Template card doesn't close";
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, Task Template doesn't Disable";
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
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, Task Template doesn't Disable";
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
						 
						 driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
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
						
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contains("Disable")) {
							count++;
							str = str + "\n" +"After click Disable button yes message and reload page, Task Template doesn't Disable .";
						}else if(gettext.contentEquals(gettext)){
							count++;
							str = str + "\n" +"After click Disable button, yes message and after reload page, Task Template Disable.";
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
			M.ScreenShots("Screenshot/Passed","Disable Task Template Without Existing Transaction"); 
		    M.setStrData("As Expected","Automation Testcase", 707, 6);
			M.setStrData("Pass","Automation Testcase", 707, 7);
			
		
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Disable Task Template Without Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 707,6);
			M.setStrData("Fail","Automation Testcase", 707, 7);
						
		}
		
		
		ReStart();
	}
	
	
	
	
	
	//Verify Enable Task Templatek (Without Existing Transaction)
	//@Test (priority = 29)
	public void EnableTaskTemplateWithoutExistingTransaction()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Enable Task Template Without Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 290, 1);
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
	
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 308, 2),M.getstring("Automation Test Data", 308, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}
				
				
				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					//System.out.println(gettext);
					count++;
					str = str + "\n" +"After click warning message No, Task Template card still open.";
					if(gettext.contains("Disable")) {
						//System.out.println(gettext);
						count++;
						str = str + "\n" +"After click warning message No, Enable button change to Disable";
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
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
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
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 308, 4), M.getstring("Automation Test Data", 308, 5));
				
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
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					count++;
					str = str + "\n" +"After click ENable button and sucessful ok button, Task Template card doesn't close";
					if(gettext.contains("Enable")) {
						count++;
						str = str + "\n" +"After click Enable button yes, Task Template doesn't Enable";
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
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					if(gettext.contains("Enable")) {
						count++;
						str = str + "\n" +"After click Enable button yes, Task Template doesn't Enable";
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
						 
						 driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
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
						
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contains("Enable")) {
							count++;
							str = str + "\n" +"After click Disable button yes message and reload page, Task Template doesn't Enable .";
						}else if(gettext.contentEquals(gettext)){
							count++;
							str = str + "\n" +"After click Disable button, yes message and after reload page, Task Template Enable.";
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
			M.ScreenShots("Screenshot/Passed","Enable Task Templatek Without Existing Transaction"); 
		    M.setStrData("As Expected","Automation Testcase", 708, 6);
			M.setStrData("Pass","Automation Testcase", 708, 7);
			
		
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Enable Task Templatek Without Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 708,6);
			M.setStrData("Fail","Automation Testcase", 708, 7);
						
		}
		
		
		ReStart();
	}
	
	
	
	
	
	
	//Delete Task Template (Without Existing Transaction)
	//@Test (priority = 30)
	public void DeleteTaskTemplateWithoutExistingTransaction()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Delete Task Template Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 290, 1);
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
					
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
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
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
				//Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 312, 2),M.getstring("Automation Test Data", 312, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}
				
				
				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").getText();
					//System.out.println(gettext);
					count++;
					str = str + "\n" + "After Delete Warning message no, Task Template card still open.";
					
				}catch(Exception e) {
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
							gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							
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
						str = str + "\n" + "After click Delete warning message No,Task Template card Delete ";
						throw new Exception(str);
					}
					
				}
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
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
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 312, 4), M.getstring("Automation Test Data", 312, 5));
				
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
					Thread.sleep(5000);
					M.ScrollByText(data);
					count++;
					str = str + "\n" + "After Sucessfully Delete, Order Task Hk card doesn't Delete ";
					fail++;

				} catch (Exception x) {
					;
				}
					
				//Page Refresh
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception x) {
					;
				}

				if (fail > 0) {

					try {
						Thread.sleep(5000);
						M.ScrollByText(data);

					} catch (Exception x) {
						count++;
						str = str + "\n" + "After Sucessfully Delete and reload page , then Delete Task Template.";
					}
				}
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Delete Button doesn't Work";
				
			}
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Delete Task Template Without Existing Transaction"); 
			M.setStrData("As Expected","Automation Testcase", 709, 6);
			M.setStrData("Pass","Automation Testcase", 709, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Delete Task Template Without Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 709,6);
			M.setStrData("Fail","Automation Testcase", 709, 7);
			
		}
		
		
		ReStart();
	}
	
	
	
	
	// Create Task Template with Template Task
	//@Test (priority = 31)
	public void CreateTaskTemplateWithTemplateTask()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Task Template with Template Task Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		
		
		try {
			
			//Go to Task Templete create page.
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
			for(int i=1;i<=2;i++) {
				try {
					DataFillUp(i,288,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			Thread.sleep(2000);
			// Go to Add Template Task
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task icon not found";
				throw new Exception(str);
			}

			// Data input
			for (int i = 1; i <= 9; i++) {
				try {
					TaskDataFillUp(i, 292, i);
					if (i == 1)
						i = 5;
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

			}

			// Template Task add button
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Template Task button not found";
			}

			// Sucessfull Message..
			Thread.sleep(2000);
			successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2),M.getstring("Automation Test Data", 305, 3));

			if (successful.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + successful;
			}			
			
			

			//Verify page after add task
			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message ok, New Task Template page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add Template Task";
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
							
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
						throw new Exception(str);
						
					}

				}
				
			}
			
			
			//Create Task Template....
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Task Template button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message, Task Templates page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to New Task Template";
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Task Templates']").getText();
							
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
			
			
			
			String result=PageVerification("New Task Template");
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
			M.ScreenShots("Screenshot/Passed","Create Task Template with Template Task"); 
		    M.setStrData("As Expected","Automation Testcase", 710, 6);
			M.setStrData("Pass","Automation Testcase", 710, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Task Template with Template Task");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 710, 6);
			M.setStrData("Fail","Automation Testcase", 710, 7);
			
			
		}
		
		
		ReStart();
	}

	
	
	
	// Verify Created Task Template With Template Task
	//@Test (priority = 32)
	public void VerifyCreatedTaskTemplateWithTemplateTask()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Created Task Template With Template Task Executed!");
		int count=0;
		int j=0;
		String str="";
		String order="";
		String Task="";
		try {
			
			// Verify Task Templete Card
			order = M.getstring("Automation Test Data", 288, 1);
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			int pass = 0;
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1 = "bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2 = "bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(order)) {
					pass++;
					Thread.sleep(5000);
					j = counting(order, str1, str2);

					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j + "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						if (gettext.contentEquals(order)) {
							;
						} else {
							j++;
						}
					} catch (Exception e) {
						j++;
					}

					System.out.println(j);
					try {
						Boolean tr = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageView").isDisplayed();

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Task Template user create icon does not display";
					}

					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j + "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 288, 1),"Task Template Name Doesn't Match");
						System.out.println(gettext);
					} catch (Exception e) {
						count++;
						str = str + "\n" + "Task Template Name does not display";
					}

					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j + "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 288, 2),"Task Template Discription Doesn't Match");
						System.out.println(gettext);
					} catch (Exception e) {
						count++;
						str = str + "\n" + "Task Template Discription does not display";
					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.view.ViewGroup[" + j + "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Task Template didn't create");

			// Verify task Template details data
			try {

				try {
					Thread.sleep(5000);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']")
							.getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}

				for (int i = 1; i <= 2; i++) {
					String result = VerifyText(i, 288, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}

				// Button Text
				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 3),"CreatedBy Name Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 4),"Save Changes button Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}
			
			
			
			// Verify Template Task.....

			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			Task=M.getstring("Automation Test Data",292, 1);
			
			pass = 0;
			xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
			str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
			str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(Task)) {
					pass++;
					Thread.sleep(5000);
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
					//Order task icon
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView").isDisplayed();
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order task icon does not display in Card";
					}
					
					//Sequence Number
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 9), "Sequence Number Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Sequence Number does not display in Card";
					}
					
					//Order Task Hk
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 1), "Order Task Hk Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Order Task Hk does not display in Card";
					}
					
					//Task Category
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 2), "Task Category Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Category does not display in Card";
					}
					
					//Task Assigner Name
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 11), "Task Assigner Name Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Assigner Name does not display in Card";
					}
					
					//Critical task
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 293, 4), "Critical task Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Critical task does not display in Card";
					}
					
					//EventMileStone
					String text=M.getstring("Automation Test Data", 293, 5)+" + "+M.getstring("Automation Test Data", 293, 7)+" Days";
					try {
						String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView").getText();
						SA.assertEquals(gettext, text, "Event MileStone Doesn't Match in Card");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Event MileStone does not display in Card";
					}
					
					
					Thread.sleep(5000);
					M.SwipBytext(M.getstring("Automation Test Data", 293, 1));
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Template Task didn't add in template");
			
			
			
			try {
				
				Thread.sleep(5000);
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Update Template Task']").getText();
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Update Template Task page not found check manually what happend";
					throw new Exception(str);
				}
				
				int k=293;
				for (int i = 1; i <= 9; i++) {
					if(i==9)
						k=292;
					String result = VerifyTemplateTask(i, k, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				try {
					String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").getText();
					// M.setStrData(gettext, "Automation Test Data", i, 1);
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 290, 4),"Save Changes button Doesn't Match");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}


			// Back Button from Add Template Task page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Update Template Task page .";
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}			
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte verify task.";
				} catch (Exception e) {
					;
				}
				
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
			M.ScreenShots("Screenshot/Passed","Verify Created Task Template With Template Task"); 
		    M.setStrData("As Expected","Automation Testcase", 711, 6);
			M.setStrData("Pass","Automation Testcase", 711, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Created Task Template With Template Task");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 711, 6);
			M.setStrData("Fail","Automation Testcase", 711, 7);
			
			
		}
		
		
		ReStart();
	}

	
	
	
	//Verify Adding Multiple different Template Tasks and Same Template Tasks
	//@Test (priority = 33)
	public void VerifyAddingMultipleTemplateTasks_SameTemplateTasks()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Adding Multiple Template Tasks and Same Template Tasks Executed!");
		int count=0;
		String str="";
		String Temp="";
		int row=296;
		try {
			Temp = M.getstring("Automation Test Data",288, 1);
			Thread.sleep(5000);
			
			// Go to Task Template
			
			try {
				M.ClickOn(Temp);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Templete not found in templete list.";
				throw new Exception(str);
			}
			
			for(int k=1;k<=4;k++) {
				
				// Go to Add Template Task
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Thread.sleep(5000);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Add Template Task icon not found";
					throw new Exception(str);
				}	
				
				
				Thread.sleep(5000);
				M.Scroll(1);
				//System.out.println(row);
				
				// Data input
				for (int i = 1; i <= 9; i++) {
					try {
						TaskDataFillUp(i, row, i);
						if(i==1)
							i=5;
					} catch (Exception e) {
						count++;
						str = str + "\n" + e;
					}

				}			
				
				row++;
				
				//Template Task add button
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Template Task button not found";
				}
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}


				//Verify page after add task
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After sucessful message ok, Task Template Detail page not found";
					try {
						
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
						Thread.sleep(5000);
						M.BackFun(1);
						Thread.sleep(3000);
						str = str + "\n" + "After sucessful message ok, Page redirect to Add Template Task";
						try {
							user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
							
						} catch (Exception y) {
							try {
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								count++;
								str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
								Thread.sleep(3000);
								user = driver.findElementByXPath("//android.widget.TextView[@text='Task Template Detail']").getText();
								
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
				
			}
			
			row=296;
			// Go to Add Template Task
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task icon not found";
				throw new Exception(str);
			}	
			
			for(int k=1;k<=4;k++) {
				
				Thread.sleep(5000);
				M.Scroll(1);
				try {
					OrderTaskHK(M.getstring("Automation Test Data",row, 1), 1);
					
					count++;
					str = str + "\n" + M.getstring("Automation Test Data",row, 1) + " This order task HK already add in Template but still show in list. ";
				} catch (Exception e) {
					;
				}
				
				row++;
			}
			//  Back from template task  page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}

			} catch (Exception e) {
				;
			}	
			
			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
			if(xyz.size()!=5) {
				count++;
				str = str + "\n" + "Multiple Task Number Doesn't Match";
			}
			
			
			
			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte add task.";
				} catch (Exception e) {
					;
				}
				
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
			M.ScreenShots("Screenshot/Passed","Verify Adding Multiple Template Tasks"); 
		    M.setStrData("As Expected","Automation Testcase", 712, 6);
			M.setStrData("Pass","Automation Testcase", 712, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Adding Multiple Template Tasks");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 712, 6);
			M.setStrData("Fail","Automation Testcase", 712, 7);
			
			
		}
		
		
		ReStart();
	}

	
	
	//Verify Template Tasks Sequence Number
	//@Test (priority = 34)
	public void VerifyTemplateTasksSequenceNumber()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Template Tasks Sequence Number Executed!");
		int count=0;
		int row=296;
		String str="";
		String Task="";
		int j=0;
		try {
			//Go to New Task Template page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(2000);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
		
			for(int k=1;k<=4;k++) {
				
				// Go to Add Template Task
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Thread.sleep(5000);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Add Template Task icon not found";
					throw new Exception(str);
				}	
				
				
				Thread.sleep(5000);
				M.Scroll(1);
				//System.out.println(row);
				
				// Data input
				for (int i = 1; i <= 9; i++) {
					try {
						TaskDataFillUp(i, row, i);
						if(i==1)
							i=5;
					} catch (Exception e) {
						count++;
						str = str + "\n" + e;
					}

				}			
				Thread.sleep(2000);
				SequenceNumber(M.getstring("Automation Test Data", row, 10));
				Thread.sleep(5000);
				
				
				//Template Task add button
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Template Task button not found";
				}
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}

				//Verify page after add task
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After sucessful message ok, Task Template Detail page not found";
					try {
						
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
						Thread.sleep(5000);
						M.BackFun(1);
						Thread.sleep(3000);
						str = str + "\n" + "After sucessful message ok, Page redirect to Add Template Task";
						try {
							user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
							
						} catch (Exception y) {
							try {
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								count++;
								str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
								Thread.sleep(3000);
								user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
								
							}catch (Exception z) {
								count++;
								str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
								Thread.sleep(5000);
								
							}
							
						}
						
					} catch (Exception x) {
						count++;
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							Thread.sleep(1000);
							str = str + "\n" + "Unwanted Message show, After click Sucessful Message";
							
						} catch (Exception y) {
							
							str = str + "\n" + "Apps May be crush pls check Manually...";
							
						}

					}
					
				}
				
				if(k>1) {
					try {
						Thread.sleep(5000);
						M.ScrollDwon(1);
						
						Task=M.getstring("Automation Test Data",row, 1);
						
						List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
						String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
						String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
						for (int i = 0; i < xyz.size(); i++) {
							if (xyz.get(i).getText().contains(Task)) {
								Thread.sleep(5000);
								j=counting(Task, str1, str2);
								try {
									String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
									if(gettext.contentEquals(Task)) {
										;
									}else {
										j++;
									}
								}catch(Exception e) {
									j++;
								}
								
								//Sequence Number
								try {
									String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
									try {
										Assert.assertEquals(gettext, M.getstring("Automation Test Data", row, 13), " Sequence Number input:"+M.getstring("Automation Test Data", row, 10)+" in "+Task+" But it should be alter in card by :"+M.getstring("Automation Test Data", row, 13));

									}catch(AssertionError e) {
										count++;
										str = str + "\n" +e;
									}
								}catch(Exception e) {
									count++;
									str = str + "\n" + "Sequence Number does not display in Card for:"+Task;
								}
							}
						}
						
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Something is wrong when with match with sequence number";
					}
					
					
				}
				
				
				row++;
			}
			
			// check Sequntially added and any dublicate value present or not.
			
			row=296;
			for(int k=1;k<=4;k++) {
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					
					Task=M.getstring("Automation Test Data",row, 1);
					
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					for (int i = 0; i < xyz.size(); i++) {
						if (xyz.get(i).getText().contains(Task)) {
							Thread.sleep(5000);
							j=counting(Task, str1, str2);
							try {
								String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Task)) {
									;
								}else {
									j++;
								}
							}catch(Exception e) {
								j++;
							}
							
							//Sequence Number
							try {
								String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
								//System.out.println(gettext);
								try {
									Assert.assertEquals(gettext, M.getstring("Automation Test Data", row, 12), " After added Sequence Number Doesn't Match in Card for :"+Task+ " Found: "+gettext +" but it should be :"+M.getstring("Automation Test Data", row, 12));
									
								}catch(AssertionError e) {
									count++;
									str = str + "\n" +e;
									for(int n=296;n<=299;n++) {
										if (n == row) {
									        continue;
									      }else {
									    	  if(gettext.contains(M.getstring("Automation Test Data", n, 12))) {
									    		  count++;
													str = str + "\n" + "Dublicate sequence number accept in :"+Task;
									    	  }
									    	  
									      }
										
									}
								}
							}catch(Exception e) {
								count++;
								str = str + "\n" + "Sequence Number does not display in Card for:"+Task;
							}
						}
					}
					
					
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Something is wrong when with match with sequence number";
				}
				row++;
				
			}
			
			
			// Change Sequence Number last to first
			row = 296;
			for (int k = 1; k <= 4; k++) {
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);

					Task = M.getstring("Automation Test Data", row, 1);

					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1 = "bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2 = "bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					for (int i = 0; i < xyz.size(); i++) {
						if (xyz.get(i).getText().contains(Task)) {
							Thread.sleep(5000);
							j = counting(Task, str1, str2);
							try {
								String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
										.getText();
								if (gettext.contentEquals(Task)) {
									;
								} else {
									j++;
								}
							} catch (Exception e) {
								j++;
							}

							// Sequence Number
							try {
								String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
										.getText();
								if(gettext.contains(M.getstring("Automation Test Data", 299, 12))) {
									Thread.sleep(5000);
									M.SwipBytext(Task);
									
									Thread.sleep(5000);
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
									//change sequence number
									Thread.sleep(2000);
									SequenceNumber(M.getstring("Automation Test Data", 296, 10));
									Thread.sleep(5000);
									
									
									//Template Task add button
									try {
										driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
										driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
										driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									} catch (Exception e) {
										count++;
										str = str + "\n" + "Create Template Task button not found";
									}
									
									
									//Verify page after add task
									try {
										Thread.sleep(100);
										String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
									} catch (Exception e) {
										count++;
										str = str + "\n" + "After sucessful message ok, Task Template Detail page not found";
										try {
											
											String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
											Thread.sleep(5000);
											M.BackFun(1);
											Thread.sleep(3000);
											str = str + "\n" + "After sucessful message ok, Page redirect to Add Template Task";
											try {
												user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
												
											} catch (Exception y) {
												try {
													driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
													count++;
													str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
													Thread.sleep(3000);
													user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
													
												}catch (Exception z) {
													count++;
													str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
													Thread.sleep(5000);
													
												}
												
											}
											
										} catch (Exception x) {
											count++;
											try {
												driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
												Thread.sleep(1000);
												str = str + "\n" + "Unwanted Message show, After click Sucessful Message";
												
											} catch (Exception y) {
												
												str = str + "\n" + "Apps May be crush pls check Manually...";
												
											}

										}
										
									}
							
									
									// check Channge sequence number last to first
									try {
										Thread.sleep(5000);
										M.ScrollDwon(1);
										System.out.println(Task);
										Thread.sleep(5000);
										j=counting(Task, str1, str2);
										try {
											gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
											System.out.println("gettext:"+gettext);
											if(gettext.contentEquals(Task)) {
												;
											}else {
												j++;
											}
										}catch(Exception e) {
											j++;
										}
										
										//Sequence Number
										try {
											gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
											try {
												Assert.assertEquals(gettext, M.getstring("Automation Test Data", 297, 12), " change last Sequence Number to First Number but Doesn't Match in Card for :"+Task+ " Found: "+gettext +" but it should be :"+M.getstring("Automation Test Data", 296, 10));
												
											}catch(AssertionError e) {
												count++;
												str = str + "\n" +e;
												
											}
										}catch(Exception e) {
											count++;
											str = str + "\n" + "when change for last to first, Sequence Number does not display in Card for:"+Task;
										}
										
									}catch(Exception e) {
										count++;
										str = str + "\n" + "when change for last to first, Something is wrong when with match with sequence number";
									}

									
									
									
									i=xyz.size();
									
									
								}
							} catch (Exception e) {
								count++;
								str = str + "\n" + "\"when change last to first, Sequence Number does not display in Card for:" + Task;
							}
							

						}
					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + "when change last to first, Something is wrong when with match with sequence number";
				}
				row++;

			}	
			//System.out.println("pass");
			
			// After change Sequence Number last to first check Sequntially added and any dublicate value present or not.
			
			row=296;
			for(int k=1;k<=4;k++) {
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					
					Task=M.getstring("Automation Test Data",row, 1);
					
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					int miss=xyz.size()-1;
					int dublicate=0;
					for (int i = 0; i < xyz.size(); i++) {
						//System.out.println("Number:"+xyz.size());
						//System.out.println(xyz.get(i).getText() +Task);
						if (xyz.get(i).getText().contains(Task)) {
							//System.out.println("OK1");
							Thread.sleep(5000);
							j=counting(Task, str1, str2);
							try {
								String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Task)) {
									;
								}else {
									j++;
								}
							}catch(Exception e) {
								j++;
							}
							
							//check dublicate Template Task
							for(int l=0; l< xyz.size(); l++) {
								if (xyz.get(l).getText().contains(Task)) {
									dublicate++;
								}
								//System.out.println("OK2");
							}
							
							if(dublicate>1) {
								count++;
								str = str + "\n" +" After change last to first Dublicate Task Found:- "+Task;
							}
							
							
							//Sequence Number
							try {
								String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
								//System.out.println(gettext);
								try {
									Assert.assertEquals(gettext, M.getstring("Automation Test Data", row, 14), " After change last to first Sequence Number Doesn't Match in Card for :"+Task);
									
								}catch(AssertionError e) {
									count++;
									str = str + "\n" +e;
									for(int n=296;n<=299;n++) {
										if (n == row) {
									        continue;
									      }else {
									    	  if(gettext.contains(M.getstring("Automation Test Data", n, 15))) {
									    		  count++;
												str = str + "\n" + "Dublicate sequence number accept in :"+Task;
												//System.out.println("OK3");
									    	  }
									    	  
									      }
										
									}
								}
							}catch(Exception e) {
								count++;
								str = str + "\n" + "After change last to first, Sequence Number does not display in Card for:"+Task;
							}
							i=miss;
						}else {
							if(i==miss) {
								//System.out.println("Missing:"+i);
								//System.out.println(xyz.get(i).getText() +Task);
								
								count++;
								str = str + "\n" + "After change Last to first sequence number "+Task+" Template Task is missing";
								
							}
						}
					}
					
					
				}catch(Exception e) {
					count++;
					str = str + "\n" + "After change last to first, Something is wrong when with match with sequence number";
				}
				row++;
				
			}

			
			
			

			// Change Sequence Number first to last 
			row = 299;
			for (int k = 1; k <= 4; k++) {
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);

					Task = M.getstring("Automation Test Data", row, 1);

					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1 = "bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2 = "bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					for (int i = 0; i < xyz.size(); i++) {
						if (xyz.get(i).getText().contains(Task)) {
							Thread.sleep(5000);
							j = counting(Task, str1, str2);
							try {
								String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
										.getText();
								if (gettext.contentEquals(Task)) {
									;
								} else {
									j++;
								}
							} catch (Exception e) {
								j++;
							}

							// Sequence Number
							try {
								String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
										.getText();
								if(gettext.contains(M.getstring("Automation Test Data", 297, 12))) {
									Thread.sleep(5000);
									M.SwipBytext(Task);
									
									Thread.sleep(5000);
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
									//change sequence number
									Thread.sleep(2000);
									SequenceNumber(M.getstring("Automation Test Data", 299, 10));
									Thread.sleep(5000);
									
									
									//Template Task add button
									try {
										driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
										driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
										driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									} catch (Exception e) {
										count++;
										str = str + "\n" + "Create Template Task button not found";
									}
									
									
									//Verify page after add task
									try {
										Thread.sleep(100);
										String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
									} catch (Exception e) {
										count++;
										str = str + "\n" + "After sucessful message ok, Task Template Detail page not found";
										try {
											
											String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
											Thread.sleep(5000);
											M.BackFun(1);
											Thread.sleep(3000);
											str = str + "\n" + "After sucessful message ok, Page redirect to Add Template Task";
											try {
												user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
												
											} catch (Exception y) {
												try {
													driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
													count++;
													str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
													Thread.sleep(3000);
													user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
													
												}catch (Exception z) {
													count++;
													str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
													Thread.sleep(5000);
													
												}
												
											}
											
										} catch (Exception x) {
											count++;
											try {
												driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
												Thread.sleep(1000);
												str = str + "\n" + "Unwanted Message show, After click Sucessful Message";
												
											} catch (Exception y) {
												
												str = str + "\n" + "Apps May be crush pls check Manually...";
												
											}

										}
										
									}
							
									
									// check Channge sequence number first to last
									try {
										Thread.sleep(5000);
										M.ScrollDwon(1);
										System.out.println(Task);
										Thread.sleep(5000);
										j=counting(Task, str1, str2);
										try {
											gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
											//System.out.println("gettext:"+gettext);
											if(gettext.contentEquals(Task)) {
												;
											}else {
												j++;
											}
										}catch(Exception e) {
											j++;
										}
										
										//Sequence Number
										try {
											gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
											
											//System.out.println("Sequence Number for task: "+gettext+Task);
											try {
												Assert.assertEquals(gettext, M.getstring("Automation Test Data", 299, 12), " change First Sequence Number to Last Number but Doesn't Match in Card for :"+Task+ " Found: "+gettext +" but it should be :"+M.getstring("Automation Test Data", 299, 12));
												
											}catch(AssertionError e) {
												count++;
												str = str + "\n" +e;
												
											}
										}catch(Exception e) {
											count++;
											str = str + "\n" + "After Change first to last, Sequence Number does not display in Card for:"+Task;
										}
										
									}catch(Exception e) {
										count++;
										str = str + "\n" + "when change for first to last, Something is wrong when with match with sequence number";
									}

									
									break;
									
								}
							} catch (Exception e) {
								count++;
								str = str + "\n" + "when change for first to last,Sequence Number does not display in Card for:" + Task;
							}
							

						}
					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + "when change for first to last,Something is wrong when with match with sequence number";
				}
				row--;

			}	
			//System.out.println("pass");
			
			// After change Sequence Number first to last check Sequntially added and any dublicate value present or not.
			
			row=296;
			for(int k=1;k<=4;k++) {
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					
					Task=M.getstring("Automation Test Data",row, 1);
					
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
					int miss=xyz.size()-1;
					int dublicate=0;
					for (int i = 0; i < xyz.size(); i++) {
						//System.out.println("Number:"+xyz.size());
						//System.out.println(xyz.get(i).getText() +Task);
						if (xyz.get(i).getText().contains(Task)) {
							//System.out.println("OK1");
							Thread.sleep(5000);
							j=counting(Task, str1, str2);
							try {
								String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Task)) {
									;
								}else {
									j++;
								}
							}catch(Exception e) {
								j++;
							}
							
							//check dublicate Template Task
							for(int l=0; l< xyz.size(); l++) {
								if (xyz.get(l).getText().contains(Task)) {
									dublicate++;
								}
								//System.out.println("OK2");
							}
							
							if(dublicate>1) {
								count++;
								str = str + "\n" +" After change first to last Dublicate Task Found:- "+Task;
							}
							
							
							//Sequence Number
							try {
								
								String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
								//System.out.println("Sequence Number: "+gettext);
								try {
									Assert.assertEquals(gettext, M.getstring("Automation Test Data", row, 15), " After change first to last andcheck Sequntially, Sequence Number Doesn't Match in Card for :"+Task);
									
								}catch(AssertionError e) {
									count++;
									str = str + "\n" +e;
									for(int n=296;n<=299;n++) {
										if (n == row) {
									        continue;
									      }else {
									    	  if(gettext.contains(M.getstring("Automation Test Data", n, 15))) {
									    		 count++;
												str = str + "\n" + "After change first to last andcheck Sequntially, Dublicate sequence number accept in :"+Task;
												//System.out.println("OK3");
									    	  }
									    	  
									      }
										
									}
								}
							}catch(Exception e) {
								//System.out.println(j);
								count++;
								str = str + "\n" + "After change first to last andcheck Sequntially, Sequence Number does not display in Card for:"+Task+j;
							}
							i=miss;
						}else {
							if(i==miss) {
								count++;
								str = str + "\n" + "After change first to last andcheck Sequntially, "+Task+" Template Task is missing";
								
							}
						}
					}
					
					
				}catch(Exception e) {
					count++;
					str = str + "\n" + "After change first to last andcheck Sequntially, Something is wrong when with match with sequence number";
				}
				row++;
				
			}

			
					
			//Edit with sequence number "0" &"10"
			
			row=298;
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);

				Task = M.getstring("Automation Test Data", row, 1);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
				String str1 = "bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
				String str2 = "bd.com.cslsoft.kandareeliteapp:id/txt_edit";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(Task)) {
						Thread.sleep(5000);
						j = counting(Task, str1, str2);
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
									.getText();
							if (gettext.contentEquals(Task)) {
								;
							} else {
								j++;
							}
						} catch (Exception e) {
							j++;
						}

						// Sequence Number
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
									.getText();
							
							Thread.sleep(5000);
							M.SwipBytext(Task);
							
							Thread.sleep(5000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							//change sequence number
							Thread.sleep(2000);
							SequenceNumber(M.getstring("Automation Test Data", 296, 16));
							Thread.sleep(5000);
							
							
							//Template Task add button
							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							} catch (Exception e) {
								count++;
								str = str + "\n" + "Create Template Task button not found";
							}
							
							//Check warning message....
							String index=M.Sucessfull_Message("Warning", "Sequnce Number Out of index");
							if (index.isBlank()) {
								;
							} else {
								count++;
								str = str + "\n" + index;
							}
							//Verify page after add task
							try {
								Thread.sleep(100);
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
								
								
								Thread.sleep(5000);
								M.BackFun(1);
								
							} catch (Exception e) {
								try {
									String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();

									count++;
									str = str + "\n" + "After Input Sequence Number 0, Template task edit Accept and page redirect to the New Task Template page.";
									
								} catch (Exception y) {
									try {
										driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
										count++;
										str = str + "\n" + "Sequence Number '0', may be accept";
										Thread.sleep(3000);
										String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
										
										
									}catch (Exception z) {
										try {
											String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
											Thread.sleep(5000);
											M.BackFun(1);
										} catch (Exception x) {
											count++;
											str = str + "\n" + "Apps May be crush pls check Manually...";
										}
										
										
										
									}
									
								}
								
								
							}
							Thread.sleep(5000);
							j=counting(Task, str1, str2);
							try {
								gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Task)) {
									;
								}else {
									j++;
								}
							}catch(Exception x) {
								j++;
							}
								
							
							try {
								gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
								//System.out.println("Sequence Number: "+gettext);
								try {
									Assert.assertEquals(gettext, M.getstring("Automation Test Data", 298, 16));
									count++;
									str = str + "\n" +"After input Sequence Number '0' template task Accept and create Task ";	
								}catch(AssertionError x) {
									;
								}
								
							}catch(Exception x) {
								;
							}
							
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "When try to change Sequence Number 0, does not display in Card for:" + Task;
						}
						

					}
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "When try to change Sequence Number 0, Something is wrong when with match with sequence number";
			}
			
			
			
			
			//Edit Sequence Number with 10			
			
			row=298;
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				Task = M.getstring("Automation Test Data", row, 1);
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
				String str1 = "bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
				String str2 = "bd.com.cslsoft.kandareeliteapp:id/txt_edit";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(Task)) {
						Thread.sleep(5000);
						j = counting(Task, str1, str2);
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
									.getText();
							if (gettext.contentEquals(Task)) {
								;
							} else {
								j++;
							}
						} catch (Exception e) {
							j++;
						}
						
						// Sequence Number
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
									.getText();
							
							Thread.sleep(5000);
							M.SwipBytext(Task);
							
							Thread.sleep(5000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							//change sequence number
							Thread.sleep(2000);
							SequenceNumber(M.getstring("Automation Test Data", 297, 16));
							Thread.sleep(5000);
							
							
							//Template Task add button
							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							} catch (Exception e) {
								count++;
								str = str + "\n" + "Create Template Task button not found";
							}
							
							//Check warning message....
							String index=M.Sucessfull_Message("Warning", "Sequnce Number Out of index");
							if (index.isBlank()) {
								;
							} else {
								count++;
								str = str + "\n" + index;
							}
							//Verify page after add task
							try {
								Thread.sleep(100);
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
								
								
								Thread.sleep(5000);
								M.BackFun(1);
								
							} catch (Exception e) {
								try {
									String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
									
									count++;
									str = str + "\n" + "After Input Sequence Number 10, Template task edit Accept and page redirect to the New Task Template page.";
									
								} catch (Exception y) {
									try {
										driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
										count++;
										str = str + "\n" + "Sequence Number '10', may be accept";
										Thread.sleep(3000);
										String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
										
										
									}catch (Exception z) {
										try {
											String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
											Thread.sleep(5000);
											M.BackFun(1);
										} catch (Exception x) {
											count++;
											str = str + "\n" + "Apps May be crush pls check Manually...";
										}
										
										
										
									}
									
								}
								
								
							}
							Thread.sleep(5000);
							j=counting(Task, str1, str2);
							try {
								gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Task)) {
									;
								}else {
									j++;
								}
							}catch(Exception x) {
								j++;
							}
							
							
							try {
								gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
								//System.out.println("Sequence Number: "+gettext);
								try {
									Assert.assertEquals(gettext, M.getstring("Automation Test Data", 299, 16));
									count++;
									str = str + "\n" +"After input Sequence Number '10' template task Accept and create Task ";	
								}catch(AssertionError x) {
									;
								}
								
							}catch(Exception x) {
								;
							}
							
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "When try to change Sequence Number 10, does not display in Card for:" + Task;
						}
						
						
					}
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "When try to change Sequence Number 10, Something is wrong when with match with sequence number";
			}
			
			
			
			
			//////Enter 0 value in new template task
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddTemplateTask").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Template Task icon not found";
				throw new Exception(str);
			}	
			
			
			Thread.sleep(5000);
			M.Scroll(1);
			//System.out.println(row);
			
			// Data input
			for (int i = 1; i <= 9; i++) {
				try {
					TaskDataFillUp(i, 300, i);
					if(i==1)
						i=5;
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

			}			
			
			
			//Template Task add button
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Template Task button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				;
			}

			//Verify page after add task
			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message ok, Task Template Detail page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Template Task']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add Template Task";
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='New Task Template']").getText();
							
						}catch (Exception z) {
							count++;
							str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
							Thread.sleep(5000);
							
						}
						
					}
					
				} catch (Exception x) {
					count++;
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						str = str + "\n" + "Unwanted Message show, After click Sucessful Message";
						
					} catch (Exception y) {
						
						str = str + "\n" + "Apps May be crush pls check Manually...";
						
					}

				}
				
			}

			//check "0" input value added or not.
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				Task=M.getstring("Automation Test Data",row, 1);
				
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(Task)) {
						Thread.sleep(5000);
						j=counting(Task, str1, str2);
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(Task)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
						row=300;
						//Sequence Number
						try {
							String gettext=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
							try {
								Assert.assertEquals(gettext, M.getstring("Automation Test Data", 300, 16), " Sequence Number input:"+M.getstring("Automation Test Data", row, 16)+" in "+Task+" But it should be alter in card by :"+M.getstring("Automation Test Data", row, 16));

							}catch(AssertionError e) {
								count++;
								str = str + "\n" +e;
							}
						}catch(Exception e) {
							count++;
							str = str + "\n" + "After input '0',Sequence Number does not display in Card for:"+Task;
						}
					}
				}
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + "After input '0',Something is wrong when with match with sequence number";
			}
			
			

			
			//  Back from template task  page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}

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
			M.ScreenShots("Screenshot/Passed","Verify Template Tasks Sequence Number"); 
		    M.setStrData("As Expected","Automation Testcase", 713, 6);
			M.setStrData("Pass","Automation Testcase", 713, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Template Tasks Sequence Number");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 713, 6);
			M.setStrData("Fail","Automation Testcase", 713, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	
	//Verify Disable Task Template (With Existing Transaction)
	//@Test (priority = 35)
	public void VerifyDisableTaskTemplatWithExistingTransaction()throws IOException, InterruptedException, Exception {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Disable Task Template With Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 288, 1);
		try {
			
			// Go to Order page and create order
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.findElementByXPath("//android.widget.TextView[@text='My Orders']").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				Thread.sleep(2000);
				//Create Order....
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				Thread.sleep(2000);
				
				//PoNumber
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").sendKeys("Auto-29/11");
				driver.hideKeyboard();
				
				//PoDate
				String Date=M.getstring("Automation Test Data",175, 2);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectPoDate").click();
				//driver.findElementById("android:id/date_picker_header_year").click();  use for Emulator
				
				driver.findElementByXPath("//android.view.View[@content-desc=\"" + Date + "\"]").click();
				driver.findElementById("android:id/button1").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//CustomerSelect
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCustomerSelect").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String customer="Yunus SQA";
				M.ClickOn(customer);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//ProductCategory
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectProductCategory").click();
				M.ClickOn("Test 2");
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//StyleNumber
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llStyleNumber").click();
				driver.hideKeyboard(); //Hide keyboard from view.
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtStyleNumber").setValue("Auto StyleNo_29/11");
				
				//ShipmentDate
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectShipmentDate").click();
				Date=M.getstring("Automation Test Data",175, 2);
				
				driver.findElementByXPath("//android.view.View[@content-desc=\"" + Date + "\"]").click();
				driver.findElementById("android:id/button1").click();
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				//SelectCurrency
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCurrency").click();
				driver.findElementByXPath("//android.widget.TextView[@text='BDT']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//SelectUnitOfMeasurement
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectUnitOfMeasurement").click();
				driver.findElementByXPath("//android.widget.TextView[@text='Pcs']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				String CreButton = "Create";
				M.ScrollByText(CreButton);
				
				//OrderQuality
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").setValue("1000");
				driver.hideKeyboard();
				
				//editFOB
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").setValue("10");
				driver.hideKeyboard();

				//ShipMode
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectShipMode").click();
				M.ClickOn("Test 1");
				driver.findElementByXPath("//android.widget.TextView[@text='Test 1']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//POStatus
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectPOStatus").click();
				M.ClickOn("Test2");
				driver.findElementByXPath("//android.widget.TextView[@text='Test2']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//TnaTemplate
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectTnaTemplate").click();
				M.ClickOn(data);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				
				//Remarks
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").sendKeys("Auto QA Remarks");
				driver.hideKeyboard();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}catch(Exception e) {
					;
				}

				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				Thread.sleep(2000);
				System.out.println("addNewOrder Executed!");
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				
			}catch(Exception e) {
				System.out.println(e);
				str = str + "\n" + "Order doesn't create using task template check mamually";
				throw new Exception(str);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click(); 
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				Thread.sleep(5000);
				M.ScrollByText(data);
				DataUp(data);
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Task Template not found in list";
				throw new Exception(str);				
			}
			
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
	
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 307, 6),M.getstring("Automation Test Data", 307, 7));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}
				
				
				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					//System.out.println(gettext);
					count++;
					str = str + "\n" +"After click warning message No, Task Template card still open.";
					if(gettext.contains("Enable")) {
						//System.out.println(gettext);
						count++;
						str = str + "\n" +"After click warning message No, Disable button change to Enable";
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
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
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
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 307, 4), M.getstring("Automation Test Data", 307, 5));
				
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
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					count++;
					str = str + "\n" +"After click Disable button and sucessful ok button, Task Template card doesn't close";
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, Task Template doesn't Disable";
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
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(data)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").getText();
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, Task Template doesn't Disable";
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
						 
						 driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
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
						
						gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contains("Disable")) {
							count++;
							str = str + "\n" +"After click Disable button yes message and reload page, Task Template doesn't Disable .";
						}else if(gettext.contentEquals(gettext)){
							count++;
							str = str + "\n" +"After click Disable button, yes message and after reload page, Task Template Disable.";
						}
					}

					 
					
				}
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Disable Button doesn't Work";
				
			}
			
			try {
				
				xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");				
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(data)) {
		
						Thread.sleep(5000);
						j=counting(data, str1, str2);
						try {
							String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
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
				
				//enable template
				try {
					driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					Thread.sleep(2000);
					
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					}catch(Exception e) {
						;
					}
					
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				//Page Refresh
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
					 
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					 driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					 
					 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					 
					 driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}catch(Exception x) {
					;
				}
					
					

			}catch (Exception e) {
				count++;
				str = str + "\n" + "Enable button doesn't work";
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
			
			M.ScreenShots("Screenshot/Passed","Verify Disable Task Template With Existing Transaction"); 
			M.setStrData("As Expected","Automation Testcase", 714, 6);
			M.setStrData("Pass","Automation Testcase", 714, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Disable Task Template With Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 714, 6);
			M.setStrData("Fail","Automation Testcase", 714, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	
	// Delete Template Task (With Existing Transaction)
	//@Test(priority = 36)
	public void DeleteTemplateTaskWithExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete Template Task With Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String Temp ="";
		String Task ="";
		

		try {
					
			Temp = M.getstring("Automation Test Data",288, 1);
			
			// Go to Task Template
			try {
				M.ClickOn(Temp);
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Templete not found in templete list.";
				throw new Exception(str);
			}

			

			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			Task=M.getstring("Automation Test Data",296, 1);
			
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txt_edit";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(Task)) {
					pass++;
					Thread.sleep(5000);
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}

					break;

				}

			}
			try{
				Thread.sleep(5000);
				M.SwipBytext(M.getstring("Automation Test Data", 294, 1));
				Thread.sleep(5000);
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Template Task not found or delete button not found.";
				throw new Exception(str);
			}
			
			
			// Warnning message
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 310, 6),M.getstring("Automation Test Data", 310, 7));
			if (confirmation.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + confirmation;
			}

			try {
				Thread.sleep(2000);
				String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				count++;
				str = str + "\n" + "After Delete Warning message no, template card doesn't close";

			} catch (Exception e) {
				try {
					Thread.sleep(5000);
					M.ScrollByText(Task);
					Thread.sleep(5000);
					j=counting(Task, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(Task)) {
							;
						}else {
							j++;
						}
					}catch(Exception x) {
						j++;
					}
					
					
					Thread.sleep(5000);
					M.SwipBytext(M.getstring("Automation Test Data", 294, 1));
					Thread.sleep(5000);
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Delete warning message No,Template Task card Delete ";
					throw new Exception(str);
				}

			}
			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
			}catch(Exception e) {
				str = str + "\n" + "Delete Button not found";
				throw new Exception(str);
			}
			

			//warnign message yes
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}catch(Exception e) {
				;
			}
			
			
			try {
				
				//Sucessfull message
				String sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 310, 4),M.getstring("Automation Test Data", 310, 5));
				if (sucessfull.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + sucessfull;
				}


			} catch (Exception e) {
				count++;
				str = str + "\n" + "Delete Button doesn't Work";

			}
			
			try {
				Thread.sleep(5000);
				M.ScrollByText(Task);
				count++;
				str = str + "\n" + "After Delete and sucessfull message OK, Template task doesn't delete";

			} catch (Exception x) {
				
				;
			}

			// Back from task template detail page.!!
			try {
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "Unwanted warning message show, when back from Task Template Detail page afte Delete task.";
				} catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				;
			}			
			


			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Delete Template Task With Transaction");
			M.setStrData("As Expected", "Automation Testcase", 715, 6);
			M.setStrData("Pass", "Automation Testcase", 715, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Template Task With Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 715, 6);
			M.setStrData("Fail", "Automation Testcase", 715, 7);

		}

		ReStart();
	}
	
		
	
	// SearchTask
	//@Test(priority = 37)
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
			
			Thread.sleep(2000);
			for (int j = 1; j <= 5; j++) {
				int count = 0;
				int cross = 0;

				data = M.getstring("Automation Test Data", 301, j);
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

			M.setStrData("As Expected", "Automation Testcase", 716, 6);
			M.setStrData("Pass", "Automation Testcase", 716, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Search User");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 716, 6);
			M.setStrData("Fail", "Automation Testcase", 716, 7);

		}
		ReStart();
	}

	
	
	
	
	
	
	//Delete Task Template (Without Existing Transaction)
	//@Test (priority = 38)
	public void DeleteTaskTemplateWithExistingTransaction()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Delete Task Template With Existing Transaction Executed!");
		int count=0;
		int j = 0;
		String str="";
		String data=M.getstring("Automation Test Data", 288, 1);
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			DataUp(data);
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtTaskTemplateName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/img_libraryImage";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(data)) {
					
					Thread.sleep(5000);
					j=counting(data, str1, str2);
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
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
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 312, 6),M.getstring("Automation Test Data", 312, 7));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				

				//warnign message yes
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "After Task Template using in Order, Template should not Delete but Template delete here...";
					
				}catch(Exception e) {
					;
				}
				
				int fail=0;
				
				try {
					Thread.sleep(5000);
					M.ScrollByText(data);
					

				} catch (Exception x) {
					count++;
					str = str + "\n" + "After Task Template using in Order, Template should not Delete but Template not found";
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

					driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception x) {
					;
				}

				if (fail > 0) {

					try {
						Thread.sleep(5000);
						M.ScrollByText(data);

					} catch (Exception x) {
						count++;
						str = str + "\n" + "After Sucessfully Delete and reload page , then Delete Task Template.";
					}
				}
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Delete Button doesn't Work";
				
			}
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Delete Task Template With Existing Transaction"); 
			M.setStrData("As Expected","Automation Testcase", 717, 6);
			M.setStrData("Pass","Automation Testcase", 717, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Delete Task Template With Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 717,6);
			M.setStrData("Fail","Automation Testcase", 717, 7);
			
		}
		
		
		ReStart();
	}
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
