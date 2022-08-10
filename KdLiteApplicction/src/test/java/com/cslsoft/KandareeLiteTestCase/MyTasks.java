package com.cslsoft.KandareeLiteTestCase;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.text.SimpleDateFormat;
import java.util.Date;



//panding
public class MyTasks extends BaseClass  {
	

	
	@Test(priority = 0)
	public void Nevigate() {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
	    
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	    
		driver.findElementByXPath("//android.widget.TextView[@text='My Tasks']").click(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Navigate Hamburgare To MyTasks!!");

	}
	
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();

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
		    
			driver.findElementByXPath("//android.widget.TextView[@text='My Tasks']").click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	}
	public void TaskDiscription(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	private void TaskCategory(String text,int i) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ImageView").click();
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(i==1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if(i==0)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
	}
	
	private void TaskAssignee(String text,int i) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		if(i==1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if(i==0)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();


	}
	
	private void TaskDeadline(String text,int i) {
			
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectPoDate").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"" + text + "\"]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(i==1)
			driver.findElementById("android:id/button1").click();
		else if(i==0)
			driver.findElementById("android:id/button2").click();

	}
	
	private void Remarks(String text) throws InterruptedException {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").click();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").clear();		
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").sendKeys(text);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		

	}
	
	private void DataFillup(int i) throws IOException, InterruptedException {
		String testdata="";
		CallingMethods M=new CallingMethods(driver);
		Thread.sleep(5000);
		//TaskDiscription
		testdata = M.getstring("Automation Test Data", i, 1);
		TaskDiscription(testdata);

		// TaskCategory
		testdata = M.getstring("Automation Test Data", i, 2);
		TaskCategory(testdata,1);
		

		// TaskAssignee
		testdata = M.getstring("Automation Test Data", i, 3);
		TaskAssignee(testdata,1);
		

		// TaskDeadline
		testdata = M.getstring("Automation Test Data", i, 4);
		TaskDeadline(testdata,1);

		// Remarks
		testdata = M.getstring("Automation Test Data", i, 5);
		Remarks(testdata);


	}
	
	public void Verifydata(int R) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext="";
		Thread.sleep(2000);
		//Description
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 1), "Task Discription place holder Doesn't Match");

		//Catagory
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCategory").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 2), "Task Category place holder Doesn't Match");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		//Assignee
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 3), "Task Assigne place holder Doesn't Match");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Deadline
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDeadLine").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 4), "Deadline place holder Doesn't Match");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
		
		//Remarks
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 5), "Remarks place holder Doesn't Match");
		
		SA.assertAll();
	}
	
	
	public void TaskDetailsPageVerify(int j) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String testdata="";
		Thread.sleep(3000);
		//Task Description 1
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,1),"Task Description Name Doesn't Match");
		
		//CategoryValue 2
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,2),"Category Value Doesn't Match");
		
		
		//Assignee Name 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tx_assigneeName").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,3),"Assignee Name Doesn't Match");
		//OriginalAssinee 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_originalAssineeValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,3),"Original Assinee Name Doesn't Match");
		
		//Assigned by Name 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_assignerName").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,3),"Assigned by Name Doesn't Match");
		//OriginalAssiner 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_originalAssinerValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,3),"Original Assiner Name Doesn't Match");
		
		
		//deadline 4
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,4),"Deadline Doesn't Match");
		
		//Assigned Date 5
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_assignedDate").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,5),"Assigned Date Doesn't Match");
		
		//CompletionDate
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_completionDateValue").getText();
		SA.assertEquals(testdata,"","Completion Date Should be Blank");
		
		
		Thread.sleep(5000);
		M.ScrollDwon(2);
		
		//Customer 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_customerValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"Customer Name Doesn't Match");

		//PoNumber 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_poNumberValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"PoNumber Doesn't Match");

		//StyleNumber 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_styleNumberValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"StyleNumber Name Doesn't Match");

		//TemplateName 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_templateNameValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"TemplateName Doesn't Match");
		
		//OrderTaskType 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"OrderTaskType Doesn't Match");
		
		//CriticalTask 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtCriticalTask").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"CriticalTask Doesn't Match");

		//Remarks 7
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/remarks").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,7),"Remarks Doesn't Match");
		
		SA.assertAll();

	}
	
	
	public void AssigneTaskDetailsPageVerify(int j) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String testdata="";
		Thread.sleep(3000);
		//Task Description 1
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,1),"Task Description Name Doesn't Match");
		
		//CategoryValue 2
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,2),"Category Value Doesn't Match");
		
		
		//Assignee Name 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tx_assigneeName").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,3),"Assignee Name Doesn't Match");
		//OriginalAssinee 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_originalAssineeValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,3),"Original Assinee Name Doesn't Match");
		
		//Assigned by Name 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_assignerName").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,8),"Assigned by Name Doesn't Match");
		//OriginalAssiner 3
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_originalAssinerValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,8),"Original Assiner Name Doesn't Match");
		
		
		//deadline 4
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,4),"Deadline Doesn't Match");
		
		//Assigned Date 5
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_assignedDate").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,5),"Assigned Date Doesn't Match");
		
		//CompletionDate
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_completionDateValue").getText();
		SA.assertEquals(testdata,"","Completion Date Should be Blank");
		
		
		Thread.sleep(5000);
		M.ScrollDwon(2);
		
		//Customer 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_customerValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"Customer Name Doesn't Match");

		//PoNumber 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_poNumberValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"PoNumber Doesn't Match");

		//StyleNumber 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_styleNumberValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"StyleNumber Name Doesn't Match");

		//TemplateName 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_templateNameValue").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"TemplateName Doesn't Match");
		
		//OrderTaskType 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"OrderTaskType Doesn't Match");
		
		//CriticalTask 6
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtCriticalTask").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,6),"CriticalTask Doesn't Match");

		//Remarks 7
		testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/remarks").getText();
		SA.assertEquals(testdata,M.getstring("Automation Test Data",j,7),"Remarks Doesn't Match");
		
		SA.assertAll();

	}
	
	
	//@Test (priority = 1)
	public void Demo()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Create Attribute and CheckEnttity Executed!");
		int count=0;
		String str="";
		try {
			
			
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
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 534, 6);
			M.setStrData("Pass","Automation Testcase", 534, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 534, 6);
			M.setStrData("Fail","Automation Testcase", 534, 7);
			
			
		}
		
		
		ReStart();
	}
	
	//Verify My Task View
	//@Test (priority = 1)
	public void VerifyMyTaskView()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify My Task View Executed!");
		int count=0;
		String str="";
		String title="";
		String data="";
		int k=0;
		try {
			for(int i=1;i<=3;i++)
			{
				
				data=M.getstring("Automation Test Data", 90, i);
				
				try {
					title = driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView").getText();
					Assert.assertEquals(title, data,"\n"+data+" title doesnot match");
				}catch(AssertionError e) {
					count++;
					str=str+e;
				}
				
				if(i==1)
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				else if(i==2)
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_old_task").click();
				else
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();
				
				
			}

			
			List<AndroidElement> xyz= driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_search");
			k=xyz.size();
			if(k==0)
			{
				count++;
				str=str+"\n Search icon Not found in "+data;
			}
			k=0;
			xyz= driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_filter");
			k=xyz.size();
			if(k==0)
			{
				count++;
				str=str+"\n Sort icon Not found in "+data;
			}
			
			k=2;
			xyz= driver.findElementsByXPath("//android.widget.TextView[@text='My Task']");
			//System.out.println(xyz.size());
			if(k!=xyz.size())
			{
				count++;
				str=str+"\n My Task icon Not found";
			}
			
			k=1;
			xyz= driver.findElementsByXPath("//android.widget.TextView[@text='Assigned Task']");
			//System.out.println(xyz.size());
			if(k!=xyz.size())
			{
				count++;
				str=str+"\n Assigned Task icon Not found";
			}
			
			k=1;
			xyz= driver.findElementsByXPath("//android.widget.TextView[@text='Old Task']");
			//System.out.println(xyz.size());
			if(k!=xyz.size())
			{
				count++;
				str=str+"\n Old Task icon Not found";
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 520, 6);
			M.setStrData("Pass","Automation Testcase", 520, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 520, 6);
			M.setStrData("Fail","Automation Testcase", 520, 7);
			
			
		}
		ReStart();
		
		
	}
	
	
	
	//Verify Place holder Text (New Task)
	//@Test (priority = 2)
	public void VerifyPlaceholderText_NewTask()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Place holder Text_NewTask Executed!");
		int count=0;
		int R=92;
		String str="";
		String gettext="";
		
		try {
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			try {
				Verifydata(R);
			}catch(AssertionError e) {
				count++;
				str=str+e;
			}
			
		
			Thread.sleep(5000);
			M.BackFun(1);
			if (count > 0) 
				throw new Exception(str);
			
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 521, 6);
			M.setStrData("Pass","Automation Testcase", 521, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 521, 6);
			M.setStrData("Fail","Automation Testcase", 521, 7);
		}
		ReStart();
		
	}
	
	
	
	//Verify Disabled Assign Task Button (Default & Blank Field)
	//@Test (priority = 3)
	public void VerifyDisabledAssignTaskButton_Mytask() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Verify Disabled Assign Task Button_Mytask (Default & Blank Field) Executed!");
		try {
			String str="";
			int count=0;
			for(int i=0;i<=5;i++)
			{
				boolean tr;
				String testdata;
				Thread.sleep(2000);
				String ATask="Assign Task";
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Full Field Blank
				if(i==0)
				{
					M.ScrollByText(ATask);
					tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
					if(tr==true)
					{
						count++;
						str=str+"All Fields are Blank But Create Button is Enable";
						
					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;
	
				}
				//TaskDiscription
				if(i!=1)
				{
					testdata=M.getstring("Automation Test Data", 87,1);
					TaskDiscription(testdata);
				}
				
				//TaskCategory	
				if(i!=2)
				{
					testdata=M.getstring("Automation Test Data", 87,2);
					TaskCategory(testdata,1);
					
					
				}
				//TaskAssignee
				if(i!=3)
				{
					testdata=M.getstring("Automation Test Data", 87,3);
					TaskAssignee(testdata,1);
					
						
				}
				//TaskDeadline
				if(i!=4)
				{
					testdata=M.getstring("Automation Test Data", 87,4);
					TaskDeadline(testdata,1);
					
					
				}
				
				//Remarks
				if(i!=5)
				{	
					testdata=M.getstring("Automation Test Data", 87,5);
					Remarks(testdata);										
				}
				//Scroll
				M.ScrollByText(ATask);	
				
				if(i==5)
				{
					tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
					if(tr==false)
					{
						count++;
						str=str+"\n"+"Remarks Field is Optional But AssignTask Button is Disable";
					}
				}
				
				else
				{
					tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").isEnabled();
					if(tr==true)
					{
						System.out.println(i);
						count++;
						if(i==1)
							str=str+"\n"+"TaskDiscription Field is Blank But AssignTask Button is Enable";
						else if(i==2)
							str=str+"\n"+"TaskCategory Field is Blank But AssignTask Button is Enable";
						else if(i==3)
							str=str+"\n"+"TaskAssignee Field is Blank But AssignTask Button is Enable";
						else if(i==4)
							str=str+"\n"+"TaskDeadline Field is Blank But AssignTask Button is Enable";
												
					}
					
				}

				if(i!=6)
				{
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					
					
				}
				
			}
			if(count>0)
			{
				throw new Exception(str);	
			}
			
			M.ScreenShots("Screenshot/Passed","BlankFieldVarifyAssignTaskButton");			  
		    M.setStrData("As Expected","Automation Testcase", 522, 6);
			M.setStrData("Pass","Automation Testcase", 522, 7);

			
		}catch(Exception e) {
			
			M.ScreenShots("Screenshot/Failed","BlankFieldVarifyAssignTaskButton");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 522, 6);
			M.setStrData("Fail","Automation Testcase", 522, 7);

		}
		ReStart();
	}
	
	
	// Create Task With invalid Values
	//@Test (priority = 4)
	public void CreateTaskWithinvalidValues() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Task With invalid Values Executed!");
		int count = 0;
		int j = 6;
		String str = "";
		String testdata = "";
		try {

			for (int i = 1; i <= 3; i++) {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				Thread.sleep(2000);

				// TaskDiscription
				testdata = M.getstring("Automation Test Data", 87, j + i);
				TaskDiscription(testdata);

				// TaskCategory
				testdata = M.getstring("Automation Test Data", 87, 2);
				TaskCategory(testdata, 1);

				// TaskAssignee
				testdata = M.getstring("Automation Test Data", 87, 3);
				TaskAssignee(testdata, 1);

				// Deadline
				testdata = M.getstring("Automation Test Data", 87, 4);
				TaskDeadline(testdata, 1);

				// Remarks
				testdata = M.getstring("Automation Test Data", 87, 5);
				Remarks(testdata);

				Thread.sleep(1000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();

				} catch (Exception e) {
					try {
						String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task']")
								.getText();
						Thread.sleep(5000);
						M.BackFun(1);
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception x) {
							;
						}
					} catch (Exception x) {
						count++;
						str = str + "\n Apps Crush pls check it Manually";
						throw new Exception(str);
					}

				}
				Thread.sleep(5000);
				M.ScrollByText(M.getstring("Automation Test Data", 87, j + i));

				List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(M.getstring("Automation Test Data", 87, j + i))) {
						count++;
						str = str + "\n Task create by invalid data = "
								+ M.getstring("Automation Test Data", 87, j + i);
					}

				}

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Create Task With invalid Values");
			M.setStrData("As Expected", "Automation Testcase", 523, 6);
			M.setStrData("Pass", "Automation Testcase", 523, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Create Task With invalid Values");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 523, 6);
			M.setStrData("Fail", "Automation Testcase", 523, 7);

			
		}
		ReStart();
	}
	
	
	//Dismiss Selected Value From Dropdown
	//@Test (priority = 5)
	public void DismissSelectedValueFromDropdown() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Dismiss Selected Value From Dropdown Executed!");
		SoftAssert SA=new SoftAssert();
		String testdata;
		String gettext;
		int R=92;
		int count=0;
		String str="";
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
		try {
			// TaskCategory
			testdata = M.getstring("Automation Test Data", 87, 2);
			TaskCategory(testdata,0);
			gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCategory").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 2), "Task Category value selected from Dropdown After cancel");

			
			// TaskAssignee
			testdata = M.getstring("Automation Test Data", 87, 3);
			TaskAssignee(testdata,0);
			gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 3), "Task Assigne value selected from Dropdown After cancel");

			// TaskDeadline
			testdata = M.getstring("Automation Test Data", 87, 4);
			TaskDeadline(testdata,0);	
			gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDeadLine").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 4), "Deadline place value selected from Dropdown After cancel");

			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			}catch (Exception e) {
				
			}
			
			try {
				SA.assertAll();
			}catch (AssertionError e) {
				count++;
				str = str +e;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown");			  
		    M.setStrData("As Expected","Automation Testcase", 524, 6);
			M.setStrData("Pass","Automation Testcase", 524, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 524, 6);
			M.setStrData("Fail","Automation Testcase", 524, 7);
	
		}
		ReStart();
	}
	

	
	//Dismiss Unsaved Data (Default & All fields together)
	//@Test (priority = 6)
	public void AssignTaskDataDissmiss() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Assign Task Data Dissmiss Executed!");
		SoftAssert SA=new SoftAssert();
		String testdata;
		String title="";
		String str="";
		String mess="";
		int back=0;
		int fail=0;
		int count=0;
		Thread.sleep(2000);
		try {
			
			//Default Dismiss
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				back++;
				str = str +"\n Back button doesn't found";
				
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
					count++;
					str = str + "\n warring message show after back without input";
				} catch (Exception x) {
					count++;
					str = str + "\n Apps crush after back without input";
				}
			}
			
			Thread.sleep(1000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			
			Thread.sleep(2000);
			DataFillup(87);
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				if(back==0)
					str = str +"\n Back button doesn't found";
				back++;
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			

			//check title & Message
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 101, 2),"- Warrning Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Warrning Title Body Not Found";
			}

			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 101, 3),"- Warrning Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Warrning Message Body Not Found";
				//throw new Exception(str);
			}
			
			Thread.sleep(2000);
			
			//New Task page
			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task']").getText();
				try {
					Verifydata(87);
				}catch(AssertionError e) {
					count++;
					str = str + "\n" +e;
				}
				
				
			} catch (Exception e) {
				//MY Task
				count++;
				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
					str = str + "\n" + "No warring message found & back to New Task page";
					try {
						M.ScrollByText(M.getstring("Automation Test Data", 87, 1));
					}catch (Exception x) {
						;
					}
					
					List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
					for (int j = 0; j < xyz.size(); j++) {
						if (xyz.get(j).getText().contains(M.getstring("Automation Test Data", 87, 1))) {
							str = str + "\n" + "New task create After Unsave date.";
							break;
							
						} 

					}
					
				} catch (Exception x) {
					
					str = str + "\n" + "Apps May be Crush";
					
				}
				
				throw new Exception(str);
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
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			}catch (Exception e) {
				
			}
			
			Thread.sleep(3000);
			//New Task page
			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task']").getText();
				//System.out.println("back button ok");
				try {
					M.ScrollByText(M.getstring("Automation Test Data", 87, 1));
				}catch (Exception e) {
					
				}
				
				List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
				for (int j = 0; j < xyz.size(); j++) {
					if (xyz.get(j).getText().contains(M.getstring("Automation Test Data", 87, 1))) {
						count++;
						str = str + "\n" + "New user create After Unsave date.";
						break;
						
					} 

				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "My Task page not found after back with input";

			}
			
			if (count > 0) {
				throw new Exception(str);
			}
		
			M.ScreenShots("Screenshot/Passed","Dismiss Unsaved Data All & together");			  
		    M.setStrData("As Expected","Automation Testcase", 525, 6);
			M.setStrData("Pass","Automation Testcase", 525, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Unsaved Data All & Together");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 525, 6);
			M.setStrData("Fail","Automation Testcase", 525, 7);
	
		}
		
		ReStart();
	}
	
	
	
	// Dismiss Unsaved Data (For Each Field)
	//@Test(priority = 7)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int error = 0;
		String str = "";
		String title = "";
		String mess = "";

		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);

				if (i == 1)
					TaskDiscription(M.getstring("Automation Test Data", 87, 1));
				else if (i == 2)
					Remarks(M.getstring("Automation Test Data", 87, 5));
				else if (i == 3)
					TaskCategory(M.getstring("Automation Test Data", 87, 2), 1);
				else if (i == 4)
					TaskAssignee(M.getstring("Automation Test Data", 87, 3), 1);
				else
					TaskDeadline(M.getstring("Automation Test Data", 87, 4), 1);

				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Back button doesn't found";
					Thread.sleep(5000);
					M.BackFun(1);

				}

				// check title & Message
				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					// System.out.println(title);
					try {
						Assert.assertEquals(title, M.getstring("Automation Test Data", 101, 2),
								"- Warrning Title doesn't valid");
					} catch (AssertionError e) {
						count++;
						str = str + "\n" + e;
					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Warrning Title Body Not Found";
				}

				try {
					mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					try {
						Assert.assertEquals(mess, M.getstring("Automation Test Data", 101, 3),
								"- Warrning Message doesn't valid");

					} catch (AssertionError e) {
						count++;
						str = str + "\n" + i + e;
					}
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Warrning Message Body Not Found";
					// throw new Exception(str);
				}

				Thread.sleep(2000);

				// New Task page
				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task']").getText();

					if (i == 1)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDescription").clear();
					else if (i == 2)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").clear();

					// Back Button!!
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Back button doesn't found";
						Thread.sleep(5000);
						M.BackFun(1);

					}

					if (i > 2) {
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						} catch (Exception e) {
							count++;
							str = str + "\n" + "Warrning message not found when press back button with data";

						}

					}

					// My Task page
					try {
						gettext = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
						// System.out.println("back button ok");
						// M.SwipBytext(M.getstring("Automation Test Data", 43, 1));
					} catch (Exception e) {
						count++;
						if (i <= 2)
							str = str + "\n" + "User page not found after back without input";
						else
							str = str + "\n" + "User page not found after unsave warrning message yes";

					}

				} catch (Exception e) {
					// Use page

					count++;
					try {
						String gettext = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
						str = str + "\n" + "Warring message not found & back to user page";
						// throw new Exception(str);
					} catch (Exception x) {
						str = str + "\n" + "Apps May be crush....";
					}

				}

			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data For each");
			M.setStrData("As Expected", "Automation Testcase", 526, 6);
			M.setStrData("Pass", "Automation Testcase", 526, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data For each");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 526, 6);
			M.setStrData("Fail", "Automation Testcase", 526, 7);

		}
		ReStart();

	}	
	
	
	
	//Create My Task
	//@Test (priority = 8)
	public void CreateMyTask() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Create My Task Executed!");
		
		String title="";
		String mess="";
		int count=0;
		
		String ATask="Assign Task";
		String str="";

		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
		try {
			
			DataFillup(87);
			
			Thread.sleep(2000);
			M.ScrollByText(ATask);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
			} catch (Exception e) {
				count++;
				str = str + "\n Create Button Doesn't Work";
				throw new Exception(str);
			}
			
			
			
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 102, 2),"- Confirmation Title doesn't valid");
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
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 102, 3),"- Confirmation Message doesn't valid");

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

			
			Thread.sleep(5000);
			M.Scroll(1);
			try {
				Verifydata(87);
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}

			Thread.sleep(2000);
			//M.ScrollByText(ATask);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
			try {
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				str = str + "\n" + "Warring message yes button doesn't work";
				throw new Exception(str);
			}
			

			//Sucessful Message
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 102, 4),"- Successfull Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Title Body Not Found";
			}

			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 102, 5),"- Successfull Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Message Body Not Found";
			}

			

			try {
				Thread.sleep(100);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
				// Assert.assertEquals(user,"Users");

			} catch (Exception e) {
				try {
					count++;
					str = str + "\n" + "After Create task, My task page doesn't found";
					Thread.sleep(100);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
					} catch (Exception y) {
						// count++;
						// str=str+"\n"+"After press back button warring message not found";
					}

				} catch (Exception z) {
					count++;
					str = str + "\n" + "Apps Crush.......";
				}
			}

			if (count > 0) {
				throw new Exception(str);
			}
			

			M.ScreenShots("Screenshot/Passed","CreateAssignTask");			  
		    M.setStrData("As Expected","Automation Testcase", 527, 6);
			M.setStrData("Pass","Automation Testcase", 527, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","CreateAssignTask");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 527, 6);
			M.setStrData("Fail","Automation Testcase", 527, 7);
	
		}
		ReStart();
	}

	

	//Verify Created My Task & Task Data
	//@Test (priority = 9)
	public void VerifyCreatedMyTask_TaskData() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Created My Task & Task Data Executed!");
		String CreateTask ="";
		String str ="";
		int count=0;

		try {
					
			CreateTask = M.getstring("Automation Test Data", 88, 1);
			Thread.sleep(5000);
			M.ScrollByText(CreateTask);
			int pass = 0;
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(CreateTask)) {
					pass++;
					Thread.sleep(5000);
					driver.findElementByXPath("//android.widget.TextView[@text=\"" + CreateTask + "\"]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("New Task didn't create");
			
			try {
				String page=driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
				Assert.assertEquals(page,"Task Detail","Task Detail page not found");
				TaskDetailsPageVerify(88);
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			if (count > 0) {
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Verify Created My Task & Task Data");			  
		    M.setStrData("As Expected","Automation Testcase", 528, 6);
			M.setStrData("Pass","Automation Testcase", 528, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Created My Task & Task Data");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 528, 6);
			M.setStrData("Fail","Automation Testcase", 528, 7);
	
		}
		ReStart();
	}

	
	// SearchTask
	//@Test(priority = 10)
	public void SearchTask() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Search Task Executed!");

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

				data = M.getstring("Automation Test Data", 118, j);
				List<AndroidElement> xyz0 = driver.findElementsByXPath("//android.widget.TextView");
				List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView[@text=\"" + data + "\"]");

				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(data)) {
						count++;
					}
				}
				// System.out.println(count);
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
				// System.out.println(cross);

				if (count != cross) {
					match++;
					str = str + "\n" + data + "- This search result does not match";
				}

				if (j == 1) {

					// call log
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_mobileNumber").click();
						Thread.sleep(2000);
						String mobile1 = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
						Thread.sleep(5000);
						M.BackFun(2);
						Thread.sleep(5000);
						driver.hideKeyboard();

						List<AndroidElement> xyz5 = driver.findElementsByXPath("//android.widget.TextView");
						// System.out.println(xyz4.size() +" "+xyz5.size());
						if (xyz4.size() == xyz5.size())
							System.out.println("call log ok");
						else {
							match++;
							str = str + "\n" + "After from call log user doesn't same as search Result";
							Thread.sleep(2000);
							driver.findElementById("android:id/search_src_text").clear();
							driver.findElementById("android:id/search_src_text").sendKeys(data);
							driver.hideKeyboard();
						}

					} catch (Exception e) {
						match++;
						str = str + "\n" + "Call icon button doesn't work";
					}

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
							String Mytask = driver.findElementByXPath(
									"//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
									.getText();
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

			M.setStrData("As Expected", "Automation Testcase", 529, 6);
			M.setStrData("Pass", "Automation Testcase", 529, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Search User");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 529, 6);
			M.setStrData("Fail", "Automation Testcase", 529, 7);

		}
		ReStart();
	}

	
	//VerifyTaskDetail_ContentLabels
	//@Test (priority = 11)
	public void VerifyTaskDetail_ContentLabels() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("VerifyTaskDetail_ContentLabels Executed!");
		String CreateTask ="";
		String str ="";
		int count=0;
		try {
			
			CreateTask = M.getstring("Automation Test Data", 88, 1);
			Thread.sleep(5000);
			M.ClickOn(CreateTask);
			Thread.sleep(5000);
			
			
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
			for (int i = 1; i <=15 ; i++) {
				int pass = 0;
				if(i==10) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					 xyz = driver.findElementsByClassName("android.widget.TextView");
				}
				for(int j=0;j<xyz.size();j++) {
					if (M.getstring("Automation Test Data", 94, i).contentEquals(xyz.get(j).getText())) {
						pass++;
						j=xyz.size();
						}
						
					}	
				
					if(pass==0) {
						count++;
						str = str + "\n" +M.getstring("Automation Test Data", 94, i)+" label Not found";
					}
	
				}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			if (count > 0) {
				throw new Exception(str);
			}
			
			
			
			M.ScreenShots("Screenshot/Passed","VerifyTaskDetail_ContentLabels");			  
		    M.setStrData("As Expected","Automation Testcase", 530, 6);
			M.setStrData("Pass","Automation Testcase", 530, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","VerifyTaskDetail_ContentLabels");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 530, 6);
			M.setStrData("Fail","Automation Testcase", 530, 7);
	
		}
		ReStart();
		

}

	
	//Verify Adding Comments & Replies in Task Details
	//@Test (priority = 12)
	public void AddingComments_Replies()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Adding Comments & Replies in Task Details Executed!");
		int count=0;
		String str="";
		String Stext="";
		String getText="";
		String CreateTask="";
		try {
			CreateTask = M.getstring("Automation Test Data", 88, 1);
			Thread.sleep(5000);
			M.ClickOn(CreateTask);
			for(int i=0;i<2;i++) {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				if(i==0){
					//Add comment button
					try {
						getText=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 1), "Add Comment text Doesn't Match");
						Boolean t=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").isEnabled();
						if(t==true) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").click();
							Thread.sleep(1000);	
						}else
							throw new Exception("Add Comment button is not Enable");
					}catch (Exception e) {
						throw new Exception("Add comment Button not found");
					}
					
					
				}else {
					//Reply 
					try {
						getText=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 8), "Reply text Doesn't Match");
						Boolean t=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").isEnabled();
						if(t==true) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").click();
							Thread.sleep(1000);	
						}else {
							str=str + "\n" + "Reply button is not Enable";
							try {
								SA.assertAll();
								
							}catch (AssertionError x) {		
								str=str + "\n" + x;
								throw new Exception(str);
							}
							
						}
					}catch (Exception e) {
						throw new Exception("Reply Button not found");
					}
					i=7;
				}
				
				
				//comment title
				try {
					String title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_name").getText();
					SA.assertEquals(title, M.getstring("Automation Test Data", 98, i+2), "Add Comment Title Doesn't Match");
					
				}catch(Exception e) {
					count++;
					str = str + "\n" +"Add Comment Title Not Found";
				}
				getText=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").getText();
				SA.assertEquals(getText, M.getstring("Automation Test Data", 98, i+3), "Comment text place holder Doesn't Match");
				
				//Comment cancel
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").sendKeys(M.getstring("Automation Test Data", 98, i+4));
				driver.hideKeyboard();
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
					
					//task details page
					try {
						String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					} catch (Exception e) {
						throw new Exception("Task Detail page not found After Cancel Comment");
					}
				} catch (Exception e) {
					throw new Exception(M.getstring("Automation Test Data", 98, i+1)+" Comment Cancel Button doesn't Found");
				}
				
				Thread.sleep(5000);
				M.ScrollDwon(1);
				try {
					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtComments");
					for (int j = 0; j < xyz.size(); j++) {
						if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", 98, i+4))) {
							count++;
							str=str + "\n"+M.getstring("Automation Test Data", 98, i+1)+" added After click cancel button";
						}
					}
				}catch (Exception e) {
					;
				}
					
				
				if(i==0)
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").click();
				else
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").click();
				
				//Comment done
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").sendKeys(M.getstring("Automation Test Data", 98, i+4));
				driver.hideKeyboard();
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
					Thread.sleep(2000);
					Stext=M.Sucessfull_Message(M.getstring("Automation Test Data", 104, 2), M.getstring("Automation Test Data", 104, 3));
					if(Stext.isBlank())
					{
						;
					}else {
						count++;
						str = str + "\n" +M.getstring("Automation Test Data", 104, i+1)+Stext ;
					}
				
				} catch (Exception e) {
					throw new Exception("Comment Done Button doesn't Found");
				}
				//task details page
				try {
					Thread.sleep(1000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					Thread.sleep(1000);
				} catch (Exception e) {
					throw new Exception(M.getstring("Automation Test Data", 98, i+1)+" Task Detail page not found After Done Add Comment");
				}
				
				
				Thread.sleep(5000);
				M.ScrollDwon(1);
				int pass=0;
				List<AndroidElement>xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtComments");
				for (int j = 0; j < xyz.size(); j++) {
					if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", 98, i+4))) {
						pass++;
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCommenterShortName").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 5), "Comment Person Name Doesn't Match");
						
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarksRole").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 6), "Comment Person Role Doesn't Match");

						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCommentDate").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 7), "Comment Date Doesn't Match");
						break;
					
					}
				}
				if(pass==0) {
					str = str + "\n" + M.getstring("Automation Test Data", 98, i+4)+" Not added";	
				}
				
				if(i==0) {
					try {
						Thread.sleep(5000);
						M.ScrollByText(M.getstring("Automation Test Data", 98, 1));
						str = str + "\n" + "Add comment button doesn't change";				
						try {
							SA.assertAll();
							
						}catch (AssertionError x) {		
							str=str + "\n" + x;
							throw new Exception(str);
						}
						
					} catch (Exception e) {				
							;
					}
					
				}		
				
			}
			Thread.sleep(5000);
			M.BackFun(1);
			try {
				SA.assertAll();
				
			}catch (AssertionError x) {		
				count++;
				str=str + "\n" + x;
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Adding Comments & Replies in Task Details"); 
		    M.setStrData("As Expected","Automation Testcase", 531, 6);
			M.setStrData("Pass","Automation Testcase", 531, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Adding Comments & Replies in Task Details");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 531, 6);
			M.setStrData("Fail","Automation Testcase", 531, 7);
			
			
		}
		ReStart();
		
		
	}
	
	
	//Dissmiss Unsaved/Dropdown Changes
	//@Test (priority = 13)
	public void Demo1()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dissmiss Unsaved/Dropdown Changes Executed!");
		int count=0;
		String str="";
		String gettext="";
		String CreateTask="";
		try {
			CreateTask = M.getstring("Automation Test Data", 88, 1);
			Thread.sleep(5000);
			M.ClickOn(CreateTask);
			Thread.sleep(5000);
			
			//Task discription
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_task_edit").click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				try {
					String title=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_name").getText();
					SA.assertEquals(title, M.getstring("Automation Test Data", 96, 5), "Edit Task Discription Title Doesn't Match");
					
				}catch(Exception e) {
					count++;
					str = str + "\n" +"Edit Task Discription Title Not Found";
				}
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").clear();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 96, 6), "Edit Task Discription text Doesn't Match");
				
				//Comment cancel
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").sendKeys(M.getstring("Automation Test Data", 96, 1));
				driver.hideKeyboard();
				
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
					
					//task details page
					try {
						Thread.sleep(2000);
						String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					} catch (Exception e) {
						throw new Exception("Task Detail page not found After Cancel Edit Task Discription");
					}
				} catch (Exception e) {
					throw new Exception(" Edit Task Discription Cancel Button doesn't Found");
				}
				
				Thread.sleep(1000);
				gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 87, 1), "Task Discription value save After click Cancel Button");
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Task Description Edit Icon Not Found!!!";
			}
			
			//data
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String Date=M.getstring("Automation Test Data",96, 4);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_deadline_edit").click();
			driver.findElementByXPath("//android.view.View[@content-desc=\"" + Date + "\"]").click();
			
			try {
				driver.findElementById("android:id/button2").click();
				
				//task details page
				try {
					Thread.sleep(2000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
				} catch (Exception e) {
					throw new Exception("Task Detail page not found After Cancel Date");
				}
			} catch (Exception e) {
				throw new Exception(" Date Cancel Button doesn't Found");
			}
			
			Thread.sleep(1000);
			gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 87, 4), "Date. value save After click Cancel Button");
			
			
			// Task category
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_category_edit").click();
			Thread.sleep(2000);
			M.ClickOn(M.getstring("Automation Test Data", 96, 2));
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				
				//task details page
				try {
					Thread.sleep(2000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
				} catch (Exception e) {
					throw new Exception("Task Detail page not found After Cancel Task category");
				}
			} catch (Exception e) {
				throw new Exception(" Task category Cancel Button doesn't Found");
			}
			
			Thread.sleep(1000);
			gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 87, 2), "Task category value save After click Cancel Button");

			Thread.sleep(5000);
			M.BackFun(1);
			
			try {
				SA.assertAll();
			}catch (Exception e) {
				count++;
				str = str + "\n" +e;
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Dissmiss Unsaved/Dropdown Changes"); 
		    M.setStrData("As Expected","Automation Testcase", 532, 6);
			M.setStrData("Pass","Automation Testcase",532, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dissmiss Unsaved/Dropdown Changes");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 532, 6);
			M.setStrData("Fail","Automation Testcase", 532, 7);
			
			
		}
		ReStart();
		
		
	}
	
	
	
	// VerifyTaskDetail (Call & Task Complete Feature)
	//@Test(priority = 14)
	public void VerifyTaskDetailCall_TaskCompleteFeature() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("VerifyTaskDetail_Call & Task Complete Feature Executed!");
		int count = 0;
		int j = 88;
		String str = "";
		String CreateTask = "";
		String testdata = "";
		String title = "";
		String mess = "";
		try {
	
			CreateTask = M.getstring("Automation Test Data", 87, 1);
			Thread.sleep(5000);
			M.ClickOn(CreateTask);
			Thread.sleep(5000);
	
			// Assinged Contact
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_assingedContact").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", j, 9), "Assinged By Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
	
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Assigned By");
			}
	
			// Assignee Contact
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_editAssignee").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", j, 9), "Assignee Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
	
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Assignee");
			}
	
			// Original Assigner
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", j, 9), "Original Assigner Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
			
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Original Assigner");
			}
	
			// Original Assignee
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", j, 9), "Original Assignee Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
			
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Original Assignee");
			}
	
			//Complete Button Feature
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").click();
			} catch (Exception e) {
				count++;
				str = str + "\n Complete Button Doesn't Work";
				try {
					SA.assertAll();
				}catch (AssertionError x) {
					str = str + "\n" + x;
					throw new Exception(str);
				}
			}
			
			//Warning message
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 103, 2),"- Confirmation Title doesn't valid");
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
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 103, 3),"- Confirmation Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				str = str + "\n" + "Confirmation Message Body Not Found";
				try {
					SA.assertAll();
				}catch (AssertionError x) {
					str = str + "\n" + x;
					throw new Exception(str);
				}
			}

			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Detail page not found After click NO in warnning message";
				try {
					SA.assertAll();
				}catch (AssertionError x) {
					str = str + "\n" + x;
					throw new Exception(str);
				}
			}
			
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				str = str + "\n" + "Warring message yes button doesn't work";
				try {
					SA.assertAll();
				}catch (AssertionError x) {
					str = str + "\n" + x;
					throw new Exception(str);
				}
			}
			
			Thread.sleep(5000);
			//Sucessful Message
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 103, 4),"- Successfull Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Title Body Not Found";
			}

			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 103, 5),"- Successfull Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Message Body Not Found";
			}
			
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "My Task page not found After complete task";
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				Thread.sleep(2000);
				String page = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
				
				try {
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_old_task").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(5000);
					M.ScrollByText(CreateTask);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Task doesn't complete sucessfully after complete and not found in oldtask page.";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Apps crush after press back button come to in My Task Page";
				
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
			M.ScreenShots("Screenshot/Passed", "VerifyTaskDetail_Call & Task Complete Feature");
			M.setStrData("As Expected", "Automation Testcase", 533, 6);
			M.setStrData("Pass", "Automation Testcase", 533, 7);
	
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "VerifyTaskDetail_Call & Task Complete Feature");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 533, 6);
			M.setStrData("Fail", "Automation Testcase", 533, 7);
	
			
		}
		ReStart();
	}

	
	
	// Verify Incompleted Old Task
	//@Test (priority = 15)
	public void Verify_Incompleted_Old_Task() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Incompleted Old Task Executed!");
		int count = 0;
		String str = "";
		String data = M.getstring("Automation Test Data", 118, 1);
		String getdes = "";
		String gettext = "";
		String successful = "";
		String confirmation = "";
		int i = 0;
		int complete = 0;
		long value = 0;
		int last = 0;
		try {
			// Go to Old Task Page
			try {
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_old_task").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				try {
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					String text = driver.findElementByXPath(
							"//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
							.getText();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Assert.assertEquals(text, M.getstring("Automation Test Data", 116, 1), "Old Task Page Not Found");

				} catch (AssertionError x) {
					count++;
					str = str + "\n" + x;
					throw new Exception(str);
				}
			} catch (Exception e) {
				str = str + "\n Old Task button not found";
				throw new Exception(str);
			}

			// Find task which is match condition

			Thread.sleep(5000);
			M.ScrollByText(data);
			Thread.sleep(2000);

			List<AndroidElement> xyz3 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz3.size(); j++) {
				if (xyz3.get(j).getText().contains(data)) {
					if (j >= 3) {
						Thread.sleep(5000);
						M.ScrollDwon(1);
					}

				}
			}

			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			int item = xyz.size();
			int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front").size();
			int j = 0;
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

			gettext = driver.findElementByXPath("//android.widget.LinearLayout[" + j
					+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")
					.getText();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//System.out.println(gettext + " j equal " + j);

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
			String ToDate = formatter.format(date);

			value = M.findDifference(gettext, ToDate);

			if (complete == 0) {
				if (value <= 2) {

					try {
						Thread.sleep(3000);
						M.SwipBytext(data);

						Thread.sleep(2000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.LinearLayout[" + j
								+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout")
								.click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

						// warnning message
						Thread.sleep(2000);
						confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 109, 4),
								M.getstring("Automation Test Data", 109, 5));
						if (confirmation.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + confirmation;
						}
						try {
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementByXPath("//android.widget.LinearLayout[" + j
									+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout")
									.click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

						} catch (Exception e) {
							Thread.sleep(5000);
							M.SwipBytext(getdes);
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementByXPath("//android.widget.LinearLayout[" + j
									+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout")
									.click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						}

						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(3000);
						} catch (Exception e) {
							count++;
							str = str + "\n" + "warning yes button not work";
						}
						// Successful Message
						Thread.sleep(2000);
						successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 109, 6),
								M.getstring("Automation Test Data", 109, 7));

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
							str = str + "\n" + "Task does not Undo After sucessfully undo done ";

						} catch (Exception e) {
							Thread.sleep(2000);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();
							try {
								Thread.sleep(3000);
								M.ScrollByText(data);
							} catch (Exception x) {
								count++;
								str = str + "\n" + "Undo Task not found in My task page";

							}

						}

						complete++;

					} catch (Exception e) {
						count++;
						str = str + "\n" + "Incomplete button not found";
					}
				}

			}

			if (complete == 0) {
				count++;
				str = str + "\n" + "data not found in Old Task Page";
				System.out.println("data not found in Old Task Page");

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
			M.ScreenShots("Screenshot/Passed", "Verify Incompleted Old Task");
			M.setStrData("As Expected", "Automation Testcase", 534, 6);
			M.setStrData("Pass", "Automation Testcase", 534, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Incompleted Old Task");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 534, 6);
			M.setStrData("Fail", "Automation Testcase", 534, 7);

		}

		ReStart();
	}
	
	
	
	
	//Verify Completed Task & Call Feature (From Task List)
	@Test (priority = 16)
	public void VerifyCompletedTaskCallFeature()throws IOException, InterruptedException {
			CallingMethods M=new CallingMethods(driver);
			SoftAssert SA=new SoftAssert();
			System.out.println("Verify Completed Task & Call Feature _From Task List Executed!");
			int count=0;
			int pass=0;
			String str="";
			String Stext="";
			String gettext="";
			String UpdateTask="";
			
			
			int k=87;
			try {
				UpdateTask = M.getstring("Automation Test Data", k, 1);
				Thread.sleep(5000);
				try {
					M.ScrollByText(UpdateTask);
				}catch(Exception e) {
					throw new Exception("Selected task not found");
				}
				
				Thread.sleep(2000);
				
				pass=0;
				List<AndroidElement>xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				for (int j = 0; j < xyz.size(); j++) {
					if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", k, 1))) {
						pass++;
						
						//Call Feature
						try {
							driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_mobileNumber").get(j).click();
							Thread.sleep(1000);
							gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", 88, 9), "Assinged By Contact Doesn't Match");
							Thread.sleep(5000);
							M.BackFun(2);
							
							
						}catch(Exception e) {
							count++;
							str = str + "\n Mobile Icon Doesn't Found";
						}
						
						try {
							String page = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
						} catch (Exception e) {
							throw new Exception("My Task page not found After back from device keypaid");
						}
						
						//Complete Feature
						
						try {
							driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llCompleteTask").get(j).click();
							
							//check Confirmation title & Message and click no
							Stext=M.Confirmation_Message(M.getstring("Automation Test Data", 103, 2), M.getstring("Automation Test Data", 103, 3));
							if(Stext.isBlank())
							{
								;
							}else {
								count++;
								str = str + "\n" +Stext ;
							}
							
							Thread.sleep(1000);
							try {
								String page = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
							} catch (Exception e) {
								throw new Exception("My Task page not found After No Warring Message");
							}
							
							driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llCompleteTask").get(j).click();
							
							try {
								
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
							} catch (Exception e) {
								str = str + "\n" + "Warring message yes button doesn't work";
								throw new Exception(str);
							}
							
							//Sucessfull title & message
							Stext=M.Sucessfull_Message(M.getstring("Automation Test Data", 103, 4), M.getstring("Automation Test Data", 103, 5));
							if(Stext.isBlank())
							{
								;
							}else {
								count++;
								str = str + "\n" +Stext ;
							}
							Thread.sleep(1000);
							
							
						}catch(Exception e) {
							count++;
							str = str + "\n Complete Icon Doesn't Found";
						}
						try {
							String page = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
						} catch (Exception e) {
							throw new Exception("My Task page not found After task completed");
						}
						
						
					}
				}
				if(pass==0) {
					throw new Exception("Selected task not found");
				}
				
				try {
					M.ScrollByText(UpdateTask);
					count++;
					str = str + "\n My task complete button doesn't work";
					throw new Exception(str);
				}catch(Exception e) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_old_task").click();
					
					try {
						Thread.sleep(5000);
						M.ScrollByText(UpdateTask);
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();
					}catch(Exception x) {
						throw new Exception("Complete Task not found button in old task");
						
					}
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
				M.ScreenShots("Screenshot/Passed","Verify Completed Task & Call Feature _From Task List"); 
			    M.setStrData("As Expected","Automation Testcase", 535, 6);
				M.setStrData("Pass","Automation Testcase", 535, 7);
				
				
			}catch(Exception e) {
				M.ScreenShots("Screenshot/Failed","Verify Completed Task & Call Feature _From Task List");
				String ErMass=e.toString();
				M.setStrData(ErMass, "Automation Testcase", 535, 6);
				M.setStrData("Fail","Automation Testcase", 535, 7);
				
				
			}
			ReStart();
			
			
		}

	
	
	
	// Update & Verify Task Details
	//@Test (priority = 17)
	public void Update_VerifyTaskDetails() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update & Verify Task Details Executed!");
		int count = 0;
		String str = "";
		String Stext = "";
		String getText = "";
		String CreateTask = "";
		try {
			Thread.sleep(5000);
			CreateMyTask();
			Thread.sleep(5000);
			
			CreateTask = M.getstring("Automation Test Data", 88, 1);
			Thread.sleep(5000);
			M.ClickOn(CreateTask);
			Thread.sleep(5000);

			// Task discription
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_task_edit").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").clear();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").sendKeys(M.getstring("Automation Test Data", 96, 1));
			driver.hideKeyboard();
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				Thread.sleep(2000);
				Stext = M.Sucessfull_Message(M.getstring("Automation Test Data", 103, 4),
						M.getstring("Automation Test Data", 103, 5));
				if (Stext.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "Task Discription" + Stext;
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Discription Done button doesn't work";
			}
			Thread.sleep(1000);
			getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
			SA.assertEquals(getText, M.getstring("Automation Test Data", 96, 1),
					"Task Discription value Doesn't Match");

			// Date.
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String Date = M.getstring("Automation Test Data", 96, 4);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_deadline_edit").click();
			driver.findElementByXPath("//android.view.View[@content-desc=\"" + Date + "\"]").click();

			try {
				driver.findElementById("android:id/button1").click();
				Thread.sleep(2000);
				Stext = M.Sucessfull_Message(M.getstring("Automation Test Data", 103, 4),
						M.getstring("Automation Test Data", 103, 5));
				if (Stext.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "Date" + Stext;
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Date Done button doesn't work";
			}
			Thread.sleep(1000);
			getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
			SA.assertEquals(getText, M.getstring("Automation Test Data", 96, 4), "Date. value Doesn't Match");

			// Task category
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_category_edit").click();
			// driver.findElementByXPath("//android.view.View/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]").click();
			Thread.sleep(2000);
			M.ClickOn(M.getstring("Automation Test Data", 96, 2));
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				Thread.sleep(2000);
				Stext = M.Sucessfull_Message(M.getstring("Automation Test Data", 103, 4),
						M.getstring("Automation Test Data", 103, 5));
				if (Stext.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "Task category" + Stext;
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task category Done button doesn't work";
			}
			Thread.sleep(1000);
			getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
			SA.assertEquals(getText, M.getstring("Automation Test Data", 96, 2), "Task category value Doesn't Match");

			Thread.sleep(5000);
			M.BackFun(1);
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Update & Verify Task Details");
			M.setStrData("As Expected", "Automation Testcase", 536, 6);
			M.setStrData("Pass", "Automation Testcase", 536, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Update & Verify Task Details");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 536, 6);
			M.setStrData("Fail", "Automation Testcase", 536, 7);

			
		}
		ReStart();
	}
	
	
	
	
	//Verify Task List Data 
	//@Test (priority = 18)
	public void VerifyTaskListData ()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Task List Data  Executed!");
		int count=0;
		String str="";
		String Stext="";
		String getText="";
		String UpdateTask="";
		int k=96;
		try {
			UpdateTask = M.getstring("Automation Test Data", k, 1);
			Thread.sleep(5000);
			M.ScrollByText(UpdateTask);
			Thread.sleep(1000);
			
			int pass=0;
			List<AndroidElement>xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", k, 1))) {
					pass++;
					//date
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtDeadline").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", k, 4), "Data Doesn't Match");
					}catch(Exception e) {
						count++;
						str = str + "\n date Icon Doesn't Found";
					}
					
					//taskCategory
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskCategory").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", k, 2), "TaskCategory Doesn't Match");
					}catch(Exception e) {
						count++;
						str = str + "\n TaskCategory Icon Doesn't Found";
					}
					
					//Assigned By Name
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtAssigneeShortName").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", k, 3), "Assigned By Name Doesn't Match");
					}catch(Exception e) {
						count++;
						str = str + "\n Assigned By name Doesn't Found";
					}
					
					//Assigned By icon
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/assigned_Id").get(j).getText();
						//System.out.println("ok");
					}catch(Exception e) {
						count++;
						str = str + "\n TaskStatus Icon Doesn't Found";
					}
					
					//TaskStatus
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus").get(j).getText();
						//System.out.println("ok1");
					}catch(Exception e) {
						count++;
						str = str + "\n TaskStatus Icon Doesn't Found";
					}
					
					//Mobile Icon
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_mobileNumber").get(j).getText();
						//System.out.println("ok2");
					}catch(Exception e) {
						count++;
						str = str + "\n Mobile Icon Doesn't Found";
					}
					
					//Complete Icon
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llCompleteTask").get(j).getText();
						//System.out.println("ok3");
					}catch(Exception e) {
						count++;
						str = str + "\n CompleteTask Icon Doesn't Found";
					}

					
					break;
				
				}
			}
			if(pass==0) {
				count++;
				str = str + "\n" +"Expected Task Not Found";	
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
			M.ScreenShots("Screenshot/Passed","Verify Task List Data "); 
		    M.setStrData("As Expected","Automation Testcase", 537, 6);
			M.setStrData("Pass","Automation Testcase", 537, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Task List Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 537, 6);
			M.setStrData("Fail","Automation Testcase", 537, 7);
			
			
		}
		
		ReStart();
		
	}

	
	
	
	
	//Verify Reassign Button & Place Holder Text
	@Test (priority = 19)
	public void VerifyReassignButton_PlaceHolderText()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Reassign Button & Place Holder Text Executed!");
		int count=0;
		int j=0;
		String str="";
		String Stext="";
		String gettext="";
		String UpdateTask="";
		int k=96;
		try {
			Thread.sleep(5000);
			UpdateTask = M.getstring("Automation Test Data", k, 1);
			
			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				int item = xyz.size();
				int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front").size();
				
				if (item == editId || item > editId) {
					for (int i = 0; i < item; i++) {
						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 1;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}
					}
				} else {

					for (int i = 0; i < item; i++) {

						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 2;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}

					}
				}
				
				try {
					Thread.sleep(1000);
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 99, 1), "Reassigne text Doesn't Match");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				}catch(Exception x) {
					count++;
					str = str + "\n" + "Reassaine button doesnot work";
					throw new Exception(str);
				}
				
				//Warring/ confirmation Message
				Thread.sleep(1000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 105, 2), M.getstring("Automation Test Data", 105, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + confirmation;
				}
				Thread.sleep(1000);
				
				try {
					String text=driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();

				}catch(Exception x) {
					count++;
					str = str + "\n" +"After click Reassign warrning message no then My Task page not found";
					throw new Exception(str);
					
			}
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				}catch(Exception e) {
					count++;
					str = str + "\n" + "Reassign button not found after no pls swipe the task";
					M.SwipBytext(UpdateTask);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				}
				try {
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				} catch (Exception e) {
					str = str + "\n" + "Warring message yes button doesn't work";
					throw new Exception(str);
				}
				
				try {
					String text=driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();

				}catch(Exception x) {
					count++;
					str = str + "\n" +"After click Reassign warrning message yes then Reassign Task page not found";
					throw new Exception(str);
					
			}
				
				try {
					gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_currentAssignee").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 99, 2), "Assignee name Doesn't Match");
				}catch(Exception x) {
					count++;
					str = str + "\n" +"currentAssignee Field not found";
				}
				try {
					gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_newAssignee").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 99, 3), "New Assignee text place holder Doesn't Match");
				}catch(Exception x) {
					count++;
					str = str + "\n" +"New Assignee Field not found";
				}
				try {
					gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 99, 4), "Remarks text place holder Doesn't Match");
				}catch(Exception x) {
					count++;
					str = str + "\n" +"Remarks Field not found";
				}
				try {
					gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 99, 5), "Save Button text Doesn't Match");
				}catch(Exception x) {
					count++;
					str = str + "\n" +"Save Button not found";
				}
				try {
					gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 99, 6), "Cancel Button Doesn't Match");
				}catch(Exception x) {
					count++;
					str = str + "\n" +"Cancel Button not found";
				}
						
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				Thread.sleep(1000);
				try {
					
					String text=driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
					
				}catch(Exception x) {
					count++;
					str = str + "\n" +"My Task page not found After click Reassign Task cancel button ";
					throw new Exception(str);
					
			}
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Reassign button not found";
				
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
			M.ScreenShots("Screenshot/Passed","Verify Reassign Button & Place Holder Text"); 
		    M.setStrData("As Expected","Automation Testcase", 538, 6);
			M.setStrData("Pass","Automation Testcase", 538, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Reassign Button & Place Holder Text");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 538, 6);
			M.setStrData("Fail","Automation Testcase", 538, 7);
			
			
		}
		
		ReStart();
		
	}
	
	
	
	//Verify Cancel & Save Button
	@Test (priority = 20)
	public void VerifyCancel_SaveButton()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Cancel & Save Button Executed!");
		int count=0;
		int j=0;
		String str="";
		String Stext="";
		String gettext="";
		String UpdateTask="";
		int k=96;
		try {
			UpdateTask = M.getstring("Automation Test Data", k, 1);
			Thread.sleep(5000);
			try {
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				int item = xyz.size();
				int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front").size();
				
				if (item == editId || item > editId) {
					for (int i = 0; i < item; i++) {
						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 1;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}
					}
				} else {

					for (int i = 0; i < item; i++) {

						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 2;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}

					}
				}
				try {
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					
				}catch(Exception x) {
					count++;
					str = str + "\n" +"Rassign button doesn't Work";
					throw new Exception(str);
				}
				
				try {
					String text=driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();

				}catch(Exception x) {
					count++;
					str = str + "\n" +"After click Reassign warrning message yes then Reassign Task page not found";
					throw new Exception(str);
				}
					
				boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").isEnabled();
				if(tr==true)
				{
					count++;
					str = str + "\n" +"Save Button should be disable but found enable";
				}
					
				tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").isEnabled();
				if(tr==false)
				{
					count++;
					str = str + "\n" +"Cancel Button should be enable but found disable";
				}
					
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				Thread.sleep(1000);
				try {
						
					String text=driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
						
				}catch(Exception x) {
					count++;
					str = str + "\n" +"My Task page not found After click Reassign Task cancel button ";
					throw new Exception(str);
						
				}
					
				}catch(Exception e) {
					count++;
					str = str + "\n" +"Reassign Button not work";
					
					
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
				M.ScreenShots("Screenshot/Passed","Verify Cancel & Save Button"); 
			    M.setStrData("As Expected","Automation Testcase", 539, 6);
				M.setStrData("Pass","Automation Testcase", 539, 7);
				
				
			}catch(Exception e) {
				M.ScreenShots("Screenshot/Failed","Verify Cancel & Save Button");
				String ErMass=e.toString();
				M.setStrData(ErMass, "Automation Testcase", 539, 6);
				M.setStrData("Fail","Automation Testcase", 539, 7);
				
				
			}
		ReStart();
			
			
}
	
	
	
	// Dismiss_Unsave_Data_Reassinge
	@Test (priority = 21)
	public void Dismiss_Unsave_Data_Reassinge() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss_Unsave_Data_Reassinge Executed!");
		int count = 0;
		int j = 0;
		String str = "";
		String Stext = "";
		String gettext = "";
		String UpdateTask = "";
		int k = 96;
		try {
			UpdateTask = M.getstring("Automation Test Data", k, 1);
			Thread.sleep(5000);
			try {
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				int item = xyz.size();
				int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front").size();
				
				if (item == editId || item > editId) {
					for (int i = 0; i < item; i++) {
						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 1;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}
					}
				} else {

					for (int i = 0; i < item; i++) {

						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 2;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}

					}
				}
				try {
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					
				}catch(Exception x) {
					count++;
					str = str + "\n" +"Rassign button doesn't Work";
					throw new Exception(str);
				}
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();
	
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Reassign warrning message yes then Reassign Task page not found";
					throw new Exception(str);
				}
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_newAssigneeDropDown").click();
				Thread.sleep(2000);
				M.ClickOn(M.getstring("Automation Test Data", 99, 10));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks")
						.sendKeys(M.getstring("Automation Test Data", 99, 11));
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				// Warring/ confirmation Message
				Thread.sleep(1000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 105, 5),M.getstring("Automation Test Data", 105, 6));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + confirmation;
				}
				Thread.sleep(1000);
				
	
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();
					try {
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_newAssignee").getText();
						Assert.assertEquals(gettext, M.getstring("Automation Test Data", 99, 10),
								"After Click cancel warring message No Assignee Name does not Match");
					} catch (AssertionError x) {
						count++;
						str = str + "\n" + x;
					}
	
					try {
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").getText();
						Assert.assertEquals(gettext, M.getstring("Automation Test Data", 99, 11),
								"After Click cancel warring message No Remarks does not Match");
					} catch (AssertionError x) {
						count++;
						str = str + "\n" + x;
					}
	
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Cancel warrning message No then Reassign Task page not found";
					throw new Exception(str);
				}
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
				try {
	
					String text = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
	
				} catch (Exception x) {
					count++;
					str = str + "\n" + "My Task page not found After click Reassign Task cancel button ";
					throw new Exception(str);
	
				}
	
				Thread.sleep(1000);
	
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Reassign button not found after no pls swipe the task";
					M.SwipBytext(UpdateTask);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
				}
	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_newAssigneeDropDown").click();
				Thread.sleep(2000);
				M.ClickOn(M.getstring("Automation Test Data", 99, 10));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Warring message not found after click cancel button";
					throw new Exception(str);
				}
	
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Cancel warrning message No then Reassign Task page not found";
					throw new Exception(str);
				}
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks")
						.sendKeys(M.getstring("Automation Test Data", 99, 11));
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Warring message not found after click cancel button";
					throw new Exception(str);
				}
	
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Cancel warrning message No then Reassign Task page not found";
					throw new Exception(str);
				}
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Reassign Button not work";
	
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
			M.ScreenShots("Screenshot/Passed", "Dismiss_Unsave_Data_Reassinge");
			M.setStrData("As Expected", "Automation Testcase", 540, 6);
			M.setStrData("Pass", "Automation Testcase", 540, 7);
	
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss_Unsave_Data_Reassinge");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase",540, 6);
			M.setStrData("Fail", "Automation Testcase", 540, 7);
	
			
		}
		ReStart();
	}



	//Dropdown Data Dismiss & Cancel Button Dismiss
	@Test (priority = 22)
	public void Dropdown_Data_Dismiss() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dropdown Data Dismiss & Cancel Button Dismiss Executed!");
		int count = 0;
		int j = 0;
		String str = "";
		String Stext = "";
		String gettext = "";
		String UpdateTask = "";
		int k = 96;
		try {
			UpdateTask = M.getstring("Automation Test Data", k, 1);
			Thread.sleep(5000);
			try {
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				int item = xyz.size();
				int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front").size();
				
				if (item == editId || item > editId) {
					for (int i = 0; i < item; i++) {
						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 1;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}
					}
				} else {

					for (int i = 0; i < item; i++) {

						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 2;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}

					}
				}
				try {
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					
				}catch(Exception x) {
					count++;
					str = str + "\n" +"Rassign button doesn't Work";
					throw new Exception(str);
				}

				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();

				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Reassign warrning message yes then Reassign Task page not found";
					throw new Exception(str);
				}

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_newAssigneeDropDown").click();
				Thread.sleep(2000);
				M.ClickOn(M.getstring("Automation Test Data", 99, 10));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
				try {
					gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_newAssignee").getText();
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 99, 10),"After Click cancel warring message No Assignee Name does not Match");
				} catch (AssertionError x) {
					count++;
					str = str + "\n" + x;
				}
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				} catch (Exception e) {
					
				}
				

				
				
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Reassign Button not work";

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
			M.ScreenShots("Screenshot/Passed", "Dropdown Data Dismiss & Cancel Button Dismiss");
			M.setStrData("As Expected", "Automation Testcase", 541, 6);
			M.setStrData("Pass", "Automation Testcase", 541, 7);
	
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dropdown Data Dismiss & Cancel Button Dismiss");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 541, 6);
			M.setStrData("Fail", "Automation Testcase", 541, 7);
	
			
		}
		ReStart();
	}
	
	
	
	//Verify_Reassigning_Task
	@Test (priority = 23)
	public void Verify_Reassigning_Task()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify_Reassigning_Task Executed!");
		int count = 0;
		int j = 0;
		String str = "";
		String Stext = "";
		String gettext = "";
		String UpdateTask = "";
		int k = 96;
		try {
			UpdateTask = M.getstring("Automation Test Data", k, 1);
			Thread.sleep(5000);
			try {
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				int item = xyz.size();
				int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front").size();
				
				if (item == editId || item > editId) {
					for (int i = 0; i < item; i++) {
						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 1;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}
					}
				} else {

					for (int i = 0; i < item; i++) {

						if (xyz.get(i).getText().contains(UpdateTask)) {
							j = i + 2;
							Thread.sleep(5000);
							M.SwipBytext(UpdateTask);
							break;
						}

					}
				}
				try {
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").click();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					
				}catch(Exception x) {
					count++;
					str = str + "\n" +"Rassign button doesn't Work";
					throw new Exception(str);
				}
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();
	
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click Reassign warrning message yes then Reassign Task page not found";
					throw new Exception(str);
				}
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_newAssigneeDropDown").click();
				Thread.sleep(2000);
				M.ClickOn(M.getstring("Automation Test Data", 99, 10));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").sendKeys(M.getstring("Automation Test Data", 99, 11));
				driver.hideKeyboard();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				
				//Success message
				
				Stext=M.Sucessfull_Message(M.getstring("Automation Test Data", 105, 8),M.getstring("Automation Test Data", 105, 9));
				if(Stext.isBlank())
				{
					;
				}else {
					count++;
					str = str + "\n" +Stext ;
				}
				Thread.sleep(1000);
				try {
					
					String text = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
	
				} catch (Exception x) {
					count++;
					str = str + "\n" + "My Task page not found After Reassign Task";
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
					throw new Exception(str);
					
	
				}
				
				//Assign Task
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				Thread.sleep(2000);
				M.ClickOn(UpdateTask);
				
				
				try {
					gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tx_assigneeName").getText();
					Assert.assertEquals(gettext, M.getstring("Automation Test Data", 99, 13),"Assignee Name doesn't match");
				} catch (AssertionError x) {
					count++;
					str = str + "\n" + x;
				}
				
				Thread.sleep(5000);
				M.BackFun(1);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();	
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Reassign Button not work";
	
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
			M.ScreenShots("Screenshot/Passed","Verify_Reassigning_Task"); 
		    M.setStrData("As Expected","Automation Testcase", 542, 6);
			M.setStrData("Pass","Automation Testcase", 542, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify_Reassigning_Task");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 542, 6);
			M.setStrData("Fail","Automation Testcase", 542, 7);
			
			
		}
		
		ReStart();
		
	}
	
	

	//Create Assign Task
	@Test (priority = 24)
	public void CreateAssignTask() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Create Assign Task Executed!");
		
		String title="";
		String mess="";
		int count=0;
		
		String ATask="Assign Task";
		String str="";
		
		try {
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
					Thread.sleep(3000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			}catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}
			
			DataFillup(111);
			
			Thread.sleep(2000);
			M.ScrollByText(ATask);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
			} catch (Exception e) {
				count++;
				str = str + "\n Create Button Doesn't Work";
				throw new Exception(str);
			}
			
			
			
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 102, 2),"- Confirmation Title doesn't valid");
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
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 102, 3),"- Confirmation Message doesn't valid");

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

			
			Thread.sleep(5000);
			M.Scroll(1);
			try {
				Verifydata(111);
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}

			Thread.sleep(2000);
			//M.ScrollByText(ATask);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
			try {
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				str = str + "\n" + "Warring message yes button doesn't work";
				throw new Exception(str);
			}
			

			//Sucessful Message
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 102, 4),"- Successfull Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Title Body Not Found";
			}

			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 102, 5),"- Successfull Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Message Body Not Found";
			}

			

			try {
				Thread.sleep(100);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
				// Assert.assertEquals(user,"Users");
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();	

			} catch (Exception e) {
				try {
					count++;
					str = str + "\n" + "After Create task, Assign Task page doesn't found";
					Thread.sleep(100);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='New Task']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
					} catch (Exception y) {
						// count++;
						// str=str+"\n"+"After press back button warring message not found";
					}
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();	
				} catch (Exception z) {
					count++;
					str = str + "\n" + "Apps Crush.......";
				}
			}

			if (count > 0) {
				throw new Exception(str);
			}
			

			M.ScreenShots("Screenshot/Passed","CreateAssignTask");			  
		    M.setStrData("As Expected","Automation Testcase", 543, 6);
			M.setStrData("Pass","Automation Testcase", 543, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","CreateAssignTask");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 543, 6);
			M.setStrData("Fail","Automation Testcase", 543, 7);
	
		}
		
		ReStart();
	}

	
	
	
	// Verify Created Assign Task & Task Data
	@Test (priority = 25)
	public void VerifyCreatedAssignTask_TaskData() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Created Assign Task & Task Data Executed!");
		String CreateTask = "";
		String str = "";
		int count = 0;

		try {
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			}catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}
			
			CreateTask = M.getstring("Automation Test Data", 112, 1);
			Thread.sleep(5000);
			M.ScrollByText(CreateTask);
			int pass = 0;
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(CreateTask)) {
					pass++;
					Thread.sleep(5000);
					driver.findElementByXPath("//android.widget.TextView[@text=\"" + CreateTask + "\"]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("New Task didn't create");

			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
				Assert.assertEquals(page, "Task Detail", "Task Detail page not found");
				AssigneTaskDetailsPageVerify(112);
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}

			Thread.sleep(5000);
			M.BackFun(1);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();	

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldVarifyAssignTaskButton");
			M.setStrData("As Expected", "Automation Testcase", 544, 6);
			M.setStrData("Pass", "Automation Testcase", 544, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "BlankFieldVarifyAssignTaskButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 544, 6);
			M.setStrData("Fail", "Automation Testcase", 544, 7);

		}
		ReStart();
	}	
	
	
	
	//Verify Assigned Task Detail _ContentLabels
	@Test (priority = 26)
	public void VerifyAssignedTaskDetail_ContentLabels() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Assigned Task Detail(Content Labels) Executed!");
		String CreateTask ="";
		String str ="";
		int count=0;
		try {
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			}catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}
			
			
			CreateTask = M.getstring("Automation Test Data", 112, 1);
			Thread.sleep(5000);
			M.ClickOn(CreateTask);
			Thread.sleep(5000);
			
			
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
			for (int i = 1; i <=15 ; i++) {
				int pass = 0;	
				if(i==10) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					 xyz = driver.findElementsByClassName("android.widget.TextView");
				}
				for(int j=0;j<xyz.size();j++) {
					if (M.getstring("Automation Test Data", 94, i).contentEquals(xyz.get(j).getText())) {
						pass++;
						j=xyz.size();
						}
						
					}	
				
					if(pass==0) {
						count++;
						str = str + "\n" +M.getstring("Automation Test Data", 94, i)+" label Not found";
					}
	
				}
			
			Thread.sleep(5000);
			M.BackFun(1);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();	
			
			if (count > 0) {
				throw new Exception(str);
			}
			
			
			
			M.ScreenShots("Screenshot/Passed","Verify Assigned Task Detail _ContentLabels");			  
		    M.setStrData("As Expected","Automation Testcase", 545, 6);
			M.setStrData("Pass","Automation Testcase", 545, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Assigned Task Detail _ContentLabels");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 545, 6);
			M.setStrData("Fail","Automation Testcase", 545, 7);
	
		}
		ReStart();
		

}
	
	
	
	// Update & Verify Assigne Task Details
	@Test (priority = 27)
	public void Update_VerifyAssigneTaskDetails() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update & Verify Assigne Task Details Executed!");
		int count = 0;
		String str = "";
		String Stext = "";
		String getText = "";
		String CreateTask = "";
		try {
	
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
	
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			} catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}
	
			CreateTask = M.getstring("Automation Test Data", 112, 1);
			Thread.sleep(5000);
			M.ClickOn(CreateTask);
			Thread.sleep(5000);
	
			// Task discription
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_task_edit").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").clear();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value")
					.sendKeys(M.getstring("Automation Test Data", 96, 1));
			driver.hideKeyboard();
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				Thread.sleep(2000);
				Stext = M.Sucessfull_Message(M.getstring("Automation Test Data", 103, 4),
						M.getstring("Automation Test Data", 103, 5));
				if (Stext.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "Task Discription" + Stext;
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task Discription Done button doesn't work";
			}
			Thread.sleep(1000);
			getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
			SA.assertEquals(getText, M.getstring("Automation Test Data", 96, 1), "Task Discription value Doesn't Match");
	
			// Date.
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String Date = M.getstring("Automation Test Data", 96, 4);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_deadline_edit").click();
			driver.findElementByXPath("//android.view.View[@content-desc=\"" + Date + "\"]").click();
	
			try {
				driver.findElementById("android:id/button1").click();
				Thread.sleep(2000);
				Stext = M.Sucessfull_Message(M.getstring("Automation Test Data", 103, 4),
						M.getstring("Automation Test Data", 103, 5));
				if (Stext.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "Date" + Stext;
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Date Done button doesn't work";
			}
			Thread.sleep(1000);
			getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
			SA.assertEquals(getText, M.getstring("Automation Test Data", 96, 4), "Date. value Doesn't Match");
	
			// Task category
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_category_edit").click();
			// driver.findElementByXPath("//android.view.View/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]").click();
			Thread.sleep(2000);
			M.ClickOn(M.getstring("Automation Test Data", 96, 2));
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				Thread.sleep(2000);
				Stext = M.Sucessfull_Message(M.getstring("Automation Test Data", 103, 4),
						M.getstring("Automation Test Data", 103, 5));
				if (Stext.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "Task category" + Stext;
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Task category Done button doesn't work";
			}
			Thread.sleep(1000);
			getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
			SA.assertEquals(getText, M.getstring("Automation Test Data", 96, 2), "Task category value Doesn't Match");
	
			Thread.sleep(5000);
			M.BackFun(1);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();
	
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Update & Verify Assigne Task Details");
			M.setStrData("As Expected", "Automation Testcase", 546, 6);
			M.setStrData("Pass", "Automation Testcase", 546, 7);
	
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Update & Verify Assigne Task Details");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 546, 6);
			M.setStrData("Fail", "Automation Testcase", 546, 7);
	
			
		}
		ReStart();
	}
	
	
	// Verify Completion Button
	@Test (priority = 28)
	public void VerifyCompletionButton ()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Completion Button  Executed!");
		int count=0;
		String str="";
		String Stext="";
		String testdata="";
		String getText="";
		String UpdateTask="";
		int k=96;
		int n=112;
		try {
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
	
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			} catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}
			
			
			UpdateTask = M.getstring("Automation Test Data", k, 1);
			Thread.sleep(5000);
			M.ScrollByText(UpdateTask);
			Thread.sleep(1000);
			
			int pass=0;
			List<AndroidElement>xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", k, 1))) {
					
					//Complete Icon
					try {
						getText=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llCompleteTask").get(j).getText();
						count++;
						str = str + "\n CompleteTask Icon Found in Assigne task list page";
					}catch(Exception e) {
						;
					}

					 driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription").get(j).click();
					break;
				
				}
			}
			try {
				
				getText=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").getText();
				count++;
				str = str + "\n CompleteTask Icon Found in Assigne task details page";
			} catch (Exception e) {
				;
			}
			
			// Assinged Contact
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_assingedContact").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", n, 9), "Assinged By Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
	
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Assigned By");
			}
	
			// Assignee Contact
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_editAssignee").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", n, 10), "Assignee Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
	
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Assignee");
			}
	
			// Original Assigner
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", n, 9), "Original Assigner Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
			
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Original Assigner");
			}
	
			// Original Assignee
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView").click();
			Thread.sleep(1000);
			testdata = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", n, 10), "Original Assignee Contact Doesn't Match");
			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(2000);
			
			//Task Details Page
			try {
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
			} catch (Exception e) {
				throw new Exception("Task Detail page not found After back from Original Assignee");
			}
	
			
			
			Thread.sleep(5000);
			M.BackFun(1);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();
			
			
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
			M.ScreenShots("Screenshot/Passed","Verify Completion Button"); 
		    M.setStrData("As Expected","Automation Testcase", 547, 6);
			M.setStrData("Pass","Automation Testcase", 547, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Completion Button");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 547, 6);
			M.setStrData("Fail","Automation Testcase", 547, 7);
			
			
		}
		ReStart();
	
	}
	 
	
	//Verify Completion of Assigned Task  (Reassigne task)(need to recheck)
	@Test (priority = 29)
	public void Verify_Completion_of_Assigned_Task()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify_Completion_of_Assigned_Task Executed!");
		int count=0;
		String str="";
		String gettext="";
		String task=M.getstring("Automation Test Data", 96, 1);
		
		try {
			
			//log-out
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		    
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		    
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tv_view_profile_edit").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/rlLogout").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			//Log_in
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_email_address").setValue("tahsina@cslsoft.com");

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_login_company_code").setValue("1008");

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_continue").click();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_log_in").click();
			
			
			//navigate
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		    
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		    
			driver.findElementByXPath("//android.widget.TextView[@text='My Tasks']").click(); 
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			Thread.sleep(5000);
			M.ScrollByText(task);
			List<AndroidElement> xyz3 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz3.size(); j++) {
				if (xyz3.get(j).getText().contains(task)) {
					if (j >= 3) {
						Thread.sleep(5000);
						M.ScrollDwon(1);
					}

				}
			}
			
			List<AndroidElement>xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", 96, 1))) {
					
					//Complete Icon
					try {
						//int i=j+1;
						driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llCompleteTask").get(j).click();
						
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						
					}catch(Exception e) {
						count++;
						str = str + "\n Task complete not done";
						throw new Exception(str);
					}
					break;
				
				}
			}
			
			//log_out
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		    
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		    
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tv_view_profile_edit").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/rlLogout").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			//Log_in
			Thread.sleep(2000);
			Nevigate();
			
			//Assigne page
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
			
			
			Thread.sleep(5000);
			M.ScrollByText(task);
			xyz3 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz3.size(); j++) {
				if (xyz3.get(j).getText().contains(task)) {
					if (j >= 3) {
						Thread.sleep(5000);
						M.ScrollDwon(1);
					}

				}
			}
			//check status & date
			xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", 96, 1))) {
					
					//Complete status
					gettext=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus").get(j).getText();
					
					if(gettext.contains("Done")) {
						;
					}else {
						count++;
						str = str + "\n Assigne task not completed and status doesn't match";							
					}
					
					
					gettext=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCompletionDate").get(j).getText();
					
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
					String ToDate= formatter.format(date);
					
					long value=Math.abs(M.findDifference(ToDate,gettext));
					if(value>0) {
						count++;
						str = str + "\n completion date doesn't Match";
					}
					break;
				
				}
			}
			//My Task page.
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();
			
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
			M.ScreenShots("Screenshot/Passed","Verify Completion of Assigned Task"); 
		    M.setStrData("As Expected","Automation Testcase", 548, 6);
			M.setStrData("Pass","Automation Testcase", 548, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Completion of Assigned Task");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 548, 6);
			M.setStrData("Fail","Automation Testcase", 548, 7);
			
			
		}
		
		ReStart();
		
	}
	
	
	//Verify Completion Date of All Assigned Task
	@Test (priority = 30)
		public void Verify_Completion_Date()throws IOException, InterruptedException {
			CallingMethods M=new CallingMethods(driver);
			SoftAssert SA=new SoftAssert();
			System.out.println("Verify Completion Date of All Assigned Task Executed!");
			int count=0;
			int last=0;
			int v=3;
			String str="";
			String gettext="";
			String getdes="";
			try {
				//Assigne page
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				int i=0;
				Thread.sleep(2000);
				List<AndroidElement>xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus");
				//System.out.println( xyz.size());
				for (int j = 0; j < xyz.size(); j++) {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					List<AndroidElement> xyz1 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					if(last==0) {
						if(xyz1.size()>4)
							i = j + 2;
						else
							i = j + 1;
					}else
						j=xyz.size() - 1;
					
					if (xyz.get(j).getText().contains("Done")) {
						
						//Complete Icon
						gettext= driver.findElementByXPath(
								"//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")
								.getText();

						getdes=driver.findElementByXPath(
								"//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
								.getText();
						//System.out.println(getdes);
						//Today Date. 
						Date date = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
						String ToDate= formatter.format(date);
					
						long value=M.findDifference(gettext,ToDate);
						//System.out.println(value);
						if(value>7) {
							count++;
							str = str +"\n"+getdes+ " completion date cross 7 days task should not show";
						}
					
					}

					if(j==v) {
						
						Thread.sleep(1000);
						String get = driver.findElementByXPath(
								"//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
								.getText();
						
						Thread.sleep(5000);
						M.ScrollDwon(1);
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						v = xyz.size() - 1;
						// System.out.println( xyz.size());
						Thread.sleep(1000);
						gettext = xyz.get(v).getText();
						xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus");
						// System.out.println(gettext);
						if (gettext.contentEquals(get)) {
							if(last==0) {
								i=i+1;
								j=0;
								last++;
							}else
								break;
						}else
							j=0;
						

				}
					
					
				}
				
				//My Task page.
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_my_task").click();
				
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
				M.ScreenShots("Screenshot/Passed","Verify Completion Date of All Assigned Task"); 
			    M.setStrData("As Expected","Automation Testcase", 549, 6);
				M.setStrData("Pass","Automation Testcase", 549, 7);
				
				
			}catch(Exception e) {
				M.ScreenShots("Screenshot/Failed","Verify Completion Date of All Assigned Task");
				String ErMass=e.toString();
				M.setStrData(ErMass, "Automation Testcase", 549, 6);
				M.setStrData("Fail","Automation Testcase", 549, 7);
				
				
			}
			
			ReStart();
			
		}
	

	//Delete_complete_task  (Reassigne task del)
	@Test (priority = 31)
	public void Delete_complete_task()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Delete_complete_task Executed!");
		int count=0;
		int value=0;
		String ATask="Assign Task";
		String str="";
		String confirmation="";
		String successful="";
		
		try {
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
					Thread.sleep(3000);
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			}catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}
		
			
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data", 96, 1));
			
			Thread.sleep(3000);
			
			// Task discription
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_task_edit").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").clear();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value")
								.sendKeys("Complete Task-LC Purchase");
			driver.hideKeyboard();
					
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();				
			}catch(Exception e) {
				;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			Thread.sleep(5000);
			M.ScrollByText("Complete Task-LC Purchase");
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains("Complete Task-LC Purchase")) {
					if(j==3)
					{
						Thread.sleep(5000);
						M.ScrollDwon(1);
					}
					
					
				}
			}
			
			Thread.sleep(1000);
			xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			int item=xyz.size();
			int editId=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_reAssign").size();
			int j=0;	
			if (item == editId || item > editId) {
				for (int i = 0; i < item; i++) {
					if (xyz.get(i).getText().contains("Complete Task-LC Purchase")) {
						j=i+1;
						M.SwipBytext("Complete Task-LC Purchase");
						//System.out.println("item="+item);
						break;
					}
				}
			}else {
				
				for (int i = 0; i < item; i++) {
					
					if (xyz.get(i).getText().contains("Complete Task-LC Purchase")) {
						j = i+2;
						M.SwipBytext("Complete Task-LC Purchase");
						//System.out.println("item=="+item);
						break;
					}

				}
			}
			//System.out.println(item);
			//System.out.println(editId);
			//System.out.println(j);
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Delect Button Doesn't Work";
				throw new Exception(str);
			}
			
			
			
			//confirmation_Message
			Thread.sleep(2000);
			confirmation=M.Confirmation_Message(M.getstring("Automation Test Data", 107, 2), M.getstring("Automation Test Data", 107, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + confirmation;
			}
			
			try {
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
			}catch(Exception e) {
				Thread.sleep(5000);
				M.SwipBytext("Complete Task-LC Purchase");
				Thread.sleep(1000);
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
			}
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch(Exception e) {
				count++;
				str = str + "\n" +"confirmation yes button not found";
				throw new Exception(str);
				
			}
			
			//Sucessfull_Message
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 107, 8), M.getstring("Automation Test Data", 107, 10));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
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
			M.ScreenShots("Screenshot/Passed","Delete_complete_task"); 
		    M.setStrData("As Expected","Automation Testcase",550, 6);
			M.setStrData("Pass","Automation Testcase", 550, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Delete_complete_task");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 550, 6);
			M.setStrData("Fail","Automation Testcase", 550, 7);
			
		}
		
		ReStart();
		
	}


	
	//DeleteTask_with_Remarks (Assigne task del)
	@Test (priority = 32)
	public void DeleteTask_with_Remarks()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("DeleteTask_with_Remarks Executed!");
		int count=0;
		int value=0;
		String ATask="Assign Task";
		String str="";
		String confirmation="";
		String successful="";
		
		try {
			//Go to Assign Task Page
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
					Thread.sleep(3000);
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			}catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}
			
			
			
			//Find & Swipe
			try {
				Thread.sleep(5000);
				M.ScrollByText(M.getstring("Automation Test Data", 114, 1));
			}catch (Exception e) {
				str = str + "\n Assign Task for Delete not found";
				throw new Exception(str);
			}
			
			List<AndroidElement> xyz3 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz3.size(); j++) {
				if (xyz3.get(j).getText().contains(M.getstring("Automation Test Data", 114, 1))) {
					if(j>=3)
					{
						Thread.sleep(5000);
						M.ScrollDwon(1);
					}
					
					
				}
			}
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			int item=xyz.size();
			int editId=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_reAssign").size();
			int j=0;	
			if (item == editId || item > editId) {
				for (int i = 0; i < item; i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 114, 1))) {
						j=i+1;
						M.SwipBytext(M.getstring("Automation Test Data", 114, 1));
						//System.out.println("item="+item);
						break;
					}
				}
			}else {
				
				for (int i = 0; i < item; i++) {
					
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 114, 1))) {
						j = i+2;
						M.SwipBytext(M.getstring("Automation Test Data", 114, 1));
						//System.out.println("item=="+item);
						break;
					}

				}
			}
			//System.out.println(item);
			//System.out.println(editId);
			//System.out.println(j);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//warnning message
			Thread.sleep(2000);
			confirmation=M.Confirmation_Message(M.getstring("Automation Test Data", 107, 4), M.getstring("Automation Test Data", 107, 5));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + confirmation;
			}
			
			try {
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
			}catch(Exception e) {
				Thread.sleep(5000);
				M.SwipBytext(M.getstring("Automation Test Data", 114, 1));
				Thread.sleep(1000);
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Successful Message
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 107, 8), M.getstring("Automation Test Data", 107, 9));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
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
			M.ScreenShots("Screenshot/Passed","DeleteTask_with_Remarks"); 
		    M.setStrData("As Expected","Automation Testcase", 551, 6);
			M.setStrData("Pass","Automation Testcase", 551, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","DeleteTask_with_Remarks");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 551, 6);
			M.setStrData("Fail","Automation Testcase", 551, 7);
			
			
		}
		
		ReStart();
		
	}
	
	
	
	// DeleteTask_without_Remarks
	@Test (priority = 33)
	public void DeleteTask_without_Remarks() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("DeleteTask_without_Remarks Executed!");
		int count = 0;
		int value = 0;
		String ATask = "Assign Task";
		String str = "";
		String testdata = "";
		String confirmation = "";
		String successful = "";

		try {
			// Go to Assign Task Page
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_assigned_task").click();
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Assign Task']").getText();
					Thread.sleep(3000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Assign Task page not found";
					throw new Exception(str);
				}
			} catch (Exception e) {
				str = str + "\n Assign Task button not found";
				throw new Exception(str);
			}

			// Create task
			
			try {
				Thread.sleep(5000);
				//TaskDiscription
				testdata = M.getstring("Automation Test Data", 114, 1);
				TaskDiscription(testdata);

				// TaskCategory
				testdata = M.getstring("Automation Test Data",114, 2);
				TaskCategory(testdata,1);
				

				// TaskAssignee
				testdata = M.getstring("Automation Test Data", 114, 3);
				TaskAssignee(testdata,1);
				

				// TaskDeadline
				testdata = M.getstring("Automation Test Data",114, 4);
				TaskDeadline(testdata,1);
				
				Thread.sleep(2000);
				M.ScrollByText(ATask);

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreateAssignTask").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
			}catch (Exception e) {
				str = str + "\n With out Remark task doesn't create so Delete task cann't check";
				throw new Exception(str);
			}

			
			Thread.sleep(5000);
			M.BackFun(1);

			// Find & Swipe
			Thread.sleep(5000);
			M.ScrollByText(M.getstring("Automation Test Data", 114, 1));
			
			List<AndroidElement> xyz3 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			for (int j = 0; j < xyz3.size(); j++) {
				if (xyz3.get(j).getText().contains("Complete Task-LC Purchase")) {
					if(j>=3)
					{
						Thread.sleep(5000);
						M.ScrollDwon(1);
					}
					
					
				}
			}

			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			int item = xyz.size();
			int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_reAssign").size();
			int j = 0;
			if (item == editId || item > editId) {
				for (int i = 0; i < item; i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 114, 1))) {
						j = i + 1;
						M.SwipBytext(M.getstring("Automation Test Data", 114, 1));
						// System.out.println("item="+item);
						break;
					}
				}
			} else {

				for (int i = 0; i < item; i++) {

					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 114, 1))) {
						j = i + 2;
						M.SwipBytext(M.getstring("Automation Test Data", 114, 1));
						// System.out.println("item=="+item);
						break;
					}

				}
			}
			// System.out.println(item);
			// System.out.println(editId);
			// System.out.println(j);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.LinearLayout[" + j
					+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout")
					.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//Warnning message
			Thread.sleep(2000);
			confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 107, 2),M.getstring("Automation Test Data", 107, 3));
			if (confirmation.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + confirmation;
			}

			try {
				driver.findElementByXPath("//android.widget.LinearLayout[" + j+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
			} catch (Exception e) {
				Thread.sleep(5000);
				M.SwipBytext(M.getstring("Automation Test Data", 114, 1));
				Thread.sleep(1000);
				driver.findElementByXPath("//android.widget.LinearLayout[" + j
						+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout")
						.click();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Successful Message
			Thread.sleep(2000);
			successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 107, 8),M.getstring("Automation Test Data", 107, 9));

			if (successful.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + successful;
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
			M.ScreenShots("Screenshot/Passed", "DeleteTask_without_Remarks");
			M.setStrData("As Expected", "Automation Testcase", 552, 6);
			M.setStrData("Pass", "Automation Testcase", 552, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "DeleteTask_without_Remarks");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 552, 6);
			M.setStrData("Fail", "Automation Testcase", 552, 7);

		}

		ReStart();

	}
	
	
	
	//Verify Old Task Data & Call Feature
	@Test (priority = 34)
	public void Verify_Old_Task_Data_Call_Feature() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Old Task Data & Call Feature Executed!");
		int count = 0;
		String str = "";
		String gettext = "";
		String getdes = "";
		String getstatus = "";
		String getAssigne = "";
		int i = 0;
		int v = 3;
		int pass = 0;
		long value=0;
		try {
			// Go to Old Task Page
			try {
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_old_task").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					String text = driver.findElementByXPath(
							"//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
							.getText();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Assert.assertEquals(text, M.getstring("Automation Test Data", 116, 1), "Old Task Page Not Found");

				} catch (AssertionError x) {
					count++;
					str = str + "\n" + x;
					throw new Exception(str);
				}
			} catch (Exception e) {
				str = str + "\n Old Task button not found";
				throw new Exception(str);
			}

			
			// Check All data Status and completion date
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			// System.out.println( xyz.size());
			for (int j = 0; j < xyz.size(); j++) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				List<AndroidElement> xyz1 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if(xyz1.size()>4)
					i = j + 2;
				else
					i = j + 1;
				
				getdes = driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").getText();
				//System.out.println(getdes);
				try {
					getstatus = driver.findElementByXPath("//android.widget.LinearLayout[" + i
							+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
							.getText();
					if (getstatus.contains("Done")) {
						//System.out.println(getdes);
						
						// Complete date
						gettext = driver.findElementByXPath("//android.widget.LinearLayout[" + i
								+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")
								.getText();
						
						//System.out.println(gettext);
						
						Date date = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
						String ToDate = formatter.format(date);

						value = M.findDifference(gettext, ToDate);
						//System.out.println(gettext+" "+getdes+"="+value);
						if (value > 30) {
							count++;
							str = str + "\n" + getdes
									+ " Completion date cross 30 days, task should not show in Old Task Page";
						}
					} else {
						count++;
						str = str + getdes + "\n Task Status Doesn't Match";
					}

				} catch (Exception e) {
					count++;
					str = str + getdes + "\n Task Status not found";
				}
				
				if (j == v) {
					Thread.sleep(1000);
					String get = xyz.get(j).getText();
					// System.out.println(get);
					Thread.sleep(5000);
					M.ScrollDwon(1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					v = xyz.size() - 1;
					// System.out.println( xyz.size());
					Thread.sleep(1000);
					gettext = xyz.get(v).getText();
					// System.out.println(gettext);
					if (gettext.contentEquals(get)) {
						i=i+1;
						break;
					} else
						j = 0;

				}

			}
			try {
				getdes=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").getText();
				
				getstatus = driver.findElementByXPath("//android.widget.LinearLayout[" + i
						+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
						.getText();
				if (getstatus.contains("Done")) {
					//System.out.println(getdes);
					
					// Complete date
					gettext = driver.findElementByXPath("//android.widget.LinearLayout[" + i
							+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")
							.getText();
					
					//System.out.println(gettext);
					
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
					String ToDate = formatter.format(date);

					value = M.findDifference(gettext, ToDate);
					//System.out.println(gettext+" "+getdes+"="+value);
					if (value > 30) {
						count++;
						str = str + "\n" + getdes
								+ " Completion date cross 30 days, task should not show in Old Task Page";
					}
				} else {
					count++;
					str = str + getdes + "\n Task Status Doesn't Match";
				}

			} catch (Exception e) {
				count++;
				str = str + getdes + "\n Task Status not found";
			}
			
			if(pass>0)
			{
				count++;
				str = str + "\n" + "Assinee equal tarana data not found in data list cann't check";
			}
			
			try {
				Thread.sleep(5000);
				M.ScrollByText(M.getstring("Automation Test Data", 116, 2));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				// System.out.println( xyz.size());
				for (int j = 0; j < xyz.size(); j++) {
					if (xyz.get(j).getText().contains(M.getstring("Automation Test Data", 116, 2))) {

						driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llAssigneePhone").get(j).click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 116, 3),
								"Assignee Phone Number Doesn't Match");
						Thread.sleep(5000);
						M.BackFun(2);

						driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llAssignerPhone").get(j).click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 116, 4),
								"Assigner Phone Number Doesn't Match");
						Thread.sleep(5000);
						M.BackFun(2);

						break;
					}
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Complete task not found for check Call Feature";
			}
			
			
			try {
				Thread.sleep(5000);
				M.ScrollByText("Tarana");
				
				
			}catch (Exception e) {
				
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
			M.ScreenShots("Screenshot/Passed", "Verify Old Task Data & Call Feature");
			M.setStrData("As Expected", "Automation Testcase", 553, 6);
			M.setStrData("Pass", "Automation Testcase", 553, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Old Task Data & Call Feature");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 553, 6);
			M.setStrData("Fail", "Automation Testcase", 553, 7);

		}

		ReStart();

	}

	
	// Verify Old task Status
	@Test(priority = 35)
	public void Verify_Old_task_Status() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Old task Status Executed!");
		int count = 0;
		int i = 0;
		int v = 3;
		long value = 0;
		String str = "";
		String deadline = "";
		String status = "";
		String completion = "";
		String getdes = "";
		try {
			// Go to Old Task Page
			try {
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_old_task").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					String text = driver.findElementByXPath(
							"//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
							.getText();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Assert.assertEquals(text, M.getstring("Automation Test Data", 116, 1), "Old Task Page Not Found");

				} catch (AssertionError x) {
					count++;
					str = str + "\n" + x;
					throw new Exception(str);
				}
			} catch (Exception e) {
				str = str + "\n Old Task button not found";
				throw new Exception(str);
			}

			//check status, completion date, deadline
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
			// System.out.println( xyz.size());
			for (int j = 0; j < xyz.size(); j++) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				List<AndroidElement> xyz1 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if(xyz1.size()>4)
					i = j + 2;
				else
					i = j + 1;
				
				getdes=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").getText();
				// System.out.println(getdes);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					status = driver.findElementByXPath("//android.widget.LinearLayout[" + i
							+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
							.getText();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					completion = driver.findElementByXPath("//android.widget.LinearLayout[" + i
							+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")
							.getText();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					deadline = driver.findElementByXPath("//android.widget.LinearLayout[" + i
							+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();

					value = M.findDifference(deadline,completion);
					//System.out.println(deadline+" "+completion+" "+getdes + "=" + value);

					if(value<=0) {
						try {
							Assert.assertEquals(status, M.getstring("Automation Test Data", 116, 5), "Task Status Done on Time Doesn't Match");
						}catch (AssertionError x) {
							count++;
							str = str + "\n"+getdes+ x;
							
						}
						
					}else {
						
						try {
							Assert.assertEquals(status, M.getstring("Automation Test Data", 116, 6), "Task Status Done Later Doesn't Match");
						}catch (AssertionError x) {
							count++;
							str = str + "\n"+getdes+ x;
							
						}
					}

				} catch (Exception e) {
					count++;
					str = str + getdes + "\n Task Status not found";
				}

				if (j == v) {
					Thread.sleep(1000);
					String get = xyz.get(j).getText();
					// System.out.println(get);
					Thread.sleep(5000);
					M.ScrollDwon(1);
					Thread.sleep(1000);
					xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
					v = xyz.size() - 1;
					// System.out.println( xyz.size());
					Thread.sleep(1000);
					String gettext = xyz.get(v).getText();
					// System.out.println(gettext);
					if (gettext.contentEquals(get)) {
						i=i+1;
						break;
					} else
						j = 0;

				}

			}
			//last check status, completion date, deadline
			try {
				getdes=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").getText();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				status = driver.findElementByXPath("//android.widget.LinearLayout[" + i
						+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
						.getText();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				completion = driver.findElementByXPath("//android.widget.LinearLayout[" + i
						+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")
						.getText();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				deadline = driver.findElementByXPath("//android.widget.LinearLayout[" + i
						+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
						.getText();

				value = M.findDifference(deadline,completion);
				//System.out.println(deadline+" "+completion+" "+getdes + "=" + value);

				if(value<=0) {
					try {
						Assert.assertEquals(status, M.getstring("Automation Test Data", 116, 5), "Task Status Done on Time Doesn't Match");
					}catch (AssertionError x) {
						count++;
						str = str + "\n"+getdes+ x;
						
					}
					
				}else {
					
					try {
						Assert.assertEquals(status, M.getstring("Automation Test Data", 116, 6), "Task Status Done Later Doesn't Match");
					}catch (AssertionError x) {
						count++;
						str = str + "\n"+getdes+ x;
						
					}
				}

			} catch (Exception e) {
				count++;
				str = str + getdes + "\n Task Status not found";
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
			M.ScreenShots("Screenshot/Passed", "Verify Old task Status");
			M.setStrData("As Expected", "Automation Testcase", 554, 6);
			M.setStrData("Pass", "Automation Testcase", 554, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Old task Status");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 554, 6);
			M.setStrData("Fail", "Automation Testcase", 554, 7);

			
		}
		ReStart();
	}

	
	
	//Verify Incomplete Feature (pass two days)(need to check)
	@Test (priority = 36)
	public void Verify_Incomplete_twodays()throws IOException, InterruptedException {
			CallingMethods M=new CallingMethods(driver);
			SoftAssert SA=new SoftAssert();
			System.out.println("Vrify Incomplete Feature pass two days Executed!");
			int count = 0;
			String str = "";
			String gettext = "";
			String getdes = "";
			String getstatus = "";
			String getAssigne = "";
			String successful = "";
			int i = 0;
			int v = 3;
			int pass = 0;
			int complete = 0;
			long value=0;
			int last=0;
			try {
				// Go to Old Task Page
				try {
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_old_task").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					try {
						Thread.sleep(3000);
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						String text = driver.findElementByXPath(
								"//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
								.getText();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Assert.assertEquals(text, M.getstring("Automation Test Data", 116, 1), "Old Task Page Not Found");

					} catch (AssertionError x) {
						count++;
						str = str + "\n" + x;
						throw new Exception(str);
					}
				} catch (Exception e) {
					str = str + "\n Old Task button not found";
					throw new Exception(str);
				}

				//Find task which is match condition
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				// System.out.println( xyz.size());
				for (int j = 0; j < xyz.size(); j++) {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					List<AndroidElement> xyz1 = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/front");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					if(last==0) {
						if(xyz1.size()>4)
							i = j + 2;
						else
							i = j + 1;
					}else
						j=xyz.size() - 1;
					
					
					getdes = driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").getText();
					//System.out.println(getdes);
					
					// Complete date
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					gettext = driver.findElementByXPath("//android.widget.LinearLayout[" + i
							+ "]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")
							.getText();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
					String ToDate = formatter.format(date);

					value = M.findDifference(gettext, ToDate);
					//System.out.println(gettext+" "+getdes+"="+value);
					
				
					//System.out.println("this value is i ="+i);
					//System.out.println(getdes);
					
					//task swipe, Assignee == others
					try {
						getAssigne=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[2]").getText();
						System.out.println(getAssigne);
							
						
					}catch (Exception e) {
						Thread.sleep(5000);
						M.ScrollDwonMinor(1);
						try {
							getAssigne=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[2]").getText();
							//System.out.println(getAssigne);
							
						}catch (Exception x) {
							System.out.println("fail.............."+x);
						}
						
					}
					
					//System.out.println(gettext+"  "+getdes+"  "+getAssigne);
					// Try to swipe other Assigne
					if(pass==0) {
						if(getAssigne.contains(M.getstring("Automation Test Data", 116, 7))) {
							Thread.sleep(5000);
							M.SwipBydubletext(getdes, gettext);
							pass++;
							try {
								String incom=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
								//System.out.println(incom);
								count++;
								str = str + "\n" + "Assinee equal tarana can swipe";
							}catch (Exception e) {
								System.out.println("Assinee equal tarana can't swipe");
								;
							}
						}else {
							;
						}
						
					}
					
					//Swipe orginal Assigne			
					if(complete==0) {
						if (getAssigne.contains(M.getstring("Automation Test Data", 116, 8)) && (value > 2)) {
							
							Thread.sleep(5000);
							M.SwipBydubletext(getdes, gettext);
							
							try {
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
								//Sucessfull Message..								
								Thread.sleep(2000);
								successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 109, 2), M.getstring("Automation Test Data", 109, 3));
								
								if(successful.isBlank())
								{
									;
								}else
								{
									count++;
									str = str + "\n" + successful;
								}
								try {
									try {
										Thread.sleep(2000);
										M.SwipBytextRevers(gettext);
										
									}catch(Exception e) {
										Thread.sleep(1000);
										//M.ScrollByText(getdes);
									}
									Thread.sleep(2000);
									M.ScrollByText(getdes);
									
								}catch(Exception e) {
									count++;
									str = str + "\n"+getdes + " Task should not incomplete beacuse it pass 2 days";
								}
								
								complete++;
								
								
							}catch(Exception e) {
								count++;
								str = str + "\n" + "Incomplete button not found";
							}
						} else {
							
						}
						
					}
					
					

					if (j == v) {
						Thread.sleep(1000);
						String get = xyz.get(j).getText();
						// System.out.println(get);
						Thread.sleep(5000);
						M.ScrollDwon(1);
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						v = xyz.size() - 1;
						// System.out.println( xyz.size());
						Thread.sleep(1000);
						gettext = xyz.get(v).getText();
						// System.out.println(gettext);
						if (gettext.contentEquals(get)) {
							
							if(last==0) {
								i=i+1;
								j=0;
								last++;
							}else
								break;
						} else
							j = 0;

					}

				}
				
				if(pass==0) {
					count++;
					str = str + "\n" + "Assinee equal tarana task doesn't found";
					System.out.println("Assinee equal tarana task doesn't found pls complete a task.");
				}
				if(complete==0) {
					count++;
					str = str + "\n" + "Assinee equal Nahid & value grater then two days task doesn't found";
					System.out.println("Assinee equal Nahid & value grater then two days task doesn't found");
					
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
				M.ScreenShots("Screenshot/Passed","Vrify Incomplete Feature pass two days"); 
			    M.setStrData("As Expected","Automation Testcase", 555, 6);
				M.setStrData("Pass","Automation Testcase", 555, 7);
				
				
			}catch(Exception e) {
				M.ScreenShots("Screenshot/Failed","Vrify Incomplete Feature pass two days");
				String ErMass=e.toString();
				M.setStrData(ErMass, "Automation Testcase", 555, 6);
				M.setStrData("Fail","Automation Testcase", 555, 7);
				
				
			}
			
			
			ReStart();
		}
		
	
		
	


}

