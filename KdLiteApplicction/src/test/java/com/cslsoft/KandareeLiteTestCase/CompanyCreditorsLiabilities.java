package com.cslsoft.KandareeLiteTestCase;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CompanyCreditorsLiabilities extends BaseClass {


	int TotalLiability=0;
	int TradeCreditor=0;
	int Non_TradeCreditor=0;
	int MachineriesSupplier=0;
	int ProjectSupplier=0;
	int Others=0;
	
	
	@Test(priority = 0)
	public void Nevigate() throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
		Thread.sleep(1000);
		
		System.out.println("Navigate Hamburgare to Company Liabilities!");
		 

	}
	
	//ReStart
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
			
			Boolean tr=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").isSelected();
			if(tr==false) {
				throw new Exception();
			}

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
		    
		    driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
			Thread.sleep(1000);
		}
		
	}


	public int FindData(String text) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int pass=0;
		try {
			Thread.sleep(2000);
			M.ScrollDwon2(1);
			for(int i=0;i<10;i++) {
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				if(xyz.size()==0) {
					i=10;
					break;
				}
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(text)) {
						pass++;
						i=10;
						break;
					}

			}
				if(i!=10) {
					Thread.sleep(2000);
					M.ScrollDwon(1);
				}
				
		}

		} catch (Exception e) {
			;

		}
		return pass;

		
		
	}
	


	//DataUp
	public void DataUp(String data) throws InterruptedException {
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
	
	
	

	public void PageReload() throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			;

		}

		
		
	}
	
	
	
	//counting
	public int counting(String data, String data1,String data2) throws InterruptedException, IOException{
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		
		List<AndroidElement> xyz = driver.findElementsById(data1);
		int item = xyz.size();
		int editId = driver.findElementsById(data2).size()-1;
		
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
	
	
	

	//PageVerification
	public String PageVerification(String text) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		String str="";
		try {
			Thread.sleep(100);
			String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
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

	
	
	//LiabilityType
	public void LiabilityType(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectLiabilityType").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	//Creditor Name
	public void CreditorName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPartyName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPartyName").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPartyName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	
	
	
	//Currency
	public void Currency(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCurrency").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
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
				if(xyz.get(j).getText().contains("Unsaved"))
				{
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;				
				}
							
			}
		}catch (Exception e) {
			;
		}

	}
	
	
	//LiabilityAmount
	public void LiabilityAmount(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	
	
	//BalanceAsOf
	public void BalanceAsOf(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectBalanceAsOf").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@content-desc=\"" + text + "\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(i==1)
			driver.findElementById("android:id/button1").click();
		else if(i==2)
			driver.findElementById("android:id/button2").click();
		
	}
	
	
	
	//Remarks
	public void Remarks(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	
	//DataFillUp
	public void DataFillUp(int i,int j,int k) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if (i == 1) 
			LiabilityType(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 2) 
			CreditorName(M.getstring("Automation Test Data", j, k));
		
		if (i == 3) 
			Currency(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 4) 
			LiabilityAmount(M.getstring("Automation Test Data", j, k));
		
		if (i == 5) 
			BalanceAsOf(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 6) 
			Remarks(M.getstring("Automation Test Data", j, k));
		

	}
	
	
	
	//VerifyText
	public String VerifyText(int i,int j,int k) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String str = "";
		Thread.sleep(2000);

		if(i==1) {
			//LiabilityType
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityType").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Liability Type Doesn't Match");
		}
		
		if(i==2) {
			//Creditor Name
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPartyName").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Creditor Name Doesn't Match");
		}
		if(i==3) {
			//Currency
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Currency Doesn't Match");
		}
		if(i==4) {
			//LiabilityAmount
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Liability Amount Doesn't Match");
		}
				
		
		if(i==5) {
			//BalanceAsOf
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtBalanceAsOf").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "BalanceAsOf Doesn't Match");
		}
		if(i==6) {
			//Remarks
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Remarks Doesn't Match");
		}
		if(i==7) {
			//CreatedBy
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 360, 7), "CreatedBy Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}

	
	
	
	
	
	//Verify Place Holder Text (Add Creditor)
	//@Test (priority = 1)
	public void VerifyPlaceHolderText_AddCreditor()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Place Holder Text_Add Creditor Executed!");
		int count=0;
		String str="";
		try {
			//Go to Creditor Tab.
			try {
				
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			//Go to Creditor Create page.
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditor Create icon not found";
				throw new Exception(str);
			}
			
			Thread.sleep(5000);
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 360, 9), "Add Creditor title text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Creditor Title doesn't found";
			}
			
			//Verify Task Template
			for(int i=1;i<=7;i++)
			{
				String result=VerifyText(i,360,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 360, 10), "Add Creditor button text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Creditor Create Button doesn't found";
			}
			
			// back to Creditor Liability page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add Creditor Create Page Back Button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			String result=PageVerification("Add Creditor");
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
			M.ScreenShots("Screenshot/Passed","Verify Place Holder Text_Add Creditor"); 
		    M.setStrData("As Expected","Automation Testcase", 773, 6);
			M.setStrData("Pass","Automation Testcase", 773, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Place Holder Text_Add Creditor");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 773, 6);
			M.setStrData("Fail","Automation Testcase", 773, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	//Verify Disabled Add Creditor Button (Default & With Blank Field)
	//@Test (priority = 2)
	public void VerifyDisabledAddCreditorButton()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Disabled Add Creditor Button -Default & With Blank Field Executed!");
		int count=0;
		String str="";
		int k=362;
		try {
			//Go to Creditor Tab.
			try {
				
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			for (int i = 0; i <= 6; i++) {
				boolean tr;
				Thread.sleep(2000);
				//Go to Add Creditor page.
				try {
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
					Thread.sleep(2000);
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Add Creditor Create icon not found";
					throw new Exception(str);
				}
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				// Full Field Blank
				if (i == 0) {
					tr =driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Add Creditor Button is Enable";

					}
					
					i++;
				}
				Thread.sleep(2000);
				if (i != 1) {
					LiabilityType(M.getstring("Automation Test Data", k,1),1);
				}
				if (i != 2) {
					CreditorName(M.getstring("Automation Test Data", k,2));
				}
				if (i != 3) {
					Currency(M.getstring("Automation Test Data", k,3),1);
				}
				if (i != 4) {
					LiabilityAmount(M.getstring("Automation Test Data", k,4));
				}
				if (i != 5) {
					BalanceAsOf(M.getstring("Automation Test Data", k,5),1);
				}
				if (i != 6) {
					Remarks(M.getstring("Automation Test Data", k,6));
				}
				Thread.sleep(2000);

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == true) {
					System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Liability Type Field is Blank But Add Creditor Liability Button is Enable";
					else if (i == 2)
						str = str + "\n" + "CreditorName Field is Blank But Add Creditor Liability Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Currency Field is Blank But Add Creditor Liability Button is Enable";
					else if (i == 4)
						str = str + "\n" + "Liability Amount Field is Blank But Add Creditor Liability Button is Enable";
					else if (i == 5)
						str = str + "\n" + "BalanceAsOf Field is Blank ButAdd Creditor Liability Button is Enable";
						
				}else {
					if (i == 5) {
						count++;
						str = str + "\n" + "Remarks Field is not Mandatory field But Add Creditor Liability Button is Disable";
					}
				}
				if (i != 7) {
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.BackFun(1);
					Thread.sleep(1000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					} catch (Exception e) {
						// System.out.println("Warning Message Not Found");
					}

				}
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Disabled Add Creditor Button -Default & With Blank Field"); 
		    M.setStrData("As Expected","Automation Testcase", 774, 6);
			M.setStrData("Pass","Automation Testcase", 774, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Disabled Add Creditor Button -Default & With Blank Field");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 774, 6);
			M.setStrData("Fail","Automation Testcase", 774, 7);
			
			
		}

		ReStart();
	}
	
	
	
	 
	 
	//Dismiss Unsaved Data-Add Creditor (Default & All fields together)
	//@Test(priority = 3)
	public void DismissUnsavedDataDefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-Add Creditor (Default & All fields together) Executed!");
		int count = 0;
		String str = "";

		try {
			//Go to Creditor Tab.
			try {
				
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//System.out.println("1");
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Add Creditor Create icon button doesn't found";
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				//System.out.println("2");
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Add Creditor Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
				
			}
			Thread.sleep(2000);
			
			//verify Add Task Templates page 
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
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
				//System.out.println("3");
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Add Creditor Create icon button doesn't found";
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,362,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
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
			
			
			//Verify Add Creditor page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Creditor']").getText();
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 362, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,362,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Company Liabilities page";
				throw new Exception(str);
				
			}
				
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			
			String result=PageVerification("Add Creditor");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data- Add Creditor Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 775, 6);
			M.setStrData("Pass", "Automation Testcase", 775, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data- Add Creditor Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 775, 6);
			M.setStrData("Fail", "Automation Testcase", 775, 7);

		}
		ReStart();

	}
	 



	//Dismiss Unsaved Data-Add Creditor (For Each Field)
	//@Test(priority = 4)
	public void DismissUnsavedData_AddCreditor_ForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-Add Creditor (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		int k=362;
		try {
			//Go to Creditor Tab.
			try {
				
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			for(int i=1;i<=6;i++){
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				
				//data fill up
				try {
					DataFillUp(i,k,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
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
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",362, i)+ confirmation;
				}				
				
				//Verify Add Creditor page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Creditor']").getText();
					
					try {
						String result= VerifyText(i, k, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i, k, i);
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
					
					str = str + "\n" + "After click Back button and warning message no, Page Redirect to Company Liabilities page";
					throw new Exception(str);
					

				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
					
				}catch (Exception e) {
					
					Thread.sleep(5000);
					M.BackFun(1);

				}
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
				}catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				
				
				String result=PageVerification("Add Creditor");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Add Creditor (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 776, 6);
			M.setStrData("Pass", "Automation Testcase", 776, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Add Creditor (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 776, 6);
			M.setStrData("Fail", "Automation Testcase", 776, 7);

		}
		ReStart();
		
	}

	
	
	//Dismiss Selected Value From Dropdown (Add Creditor)		
	//@Test (priority = 5)
	public void DismissSelectedValueFromDropdown_AddCreditor()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Add Creditor) Executed!");
		int count=0;
		String str="";
		try {
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			// Go to Add Creditor
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			Thread.sleep(5000);
			// check Liability Type Dropdown
			LiabilityType(M.getstring("Automation Test Data", 362, 1),2);		
			String result = VerifyText(1, 360, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 362, 3),2);		
			result = VerifyText(2, 360, 2);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 362, 5),2);		
			result = VerifyText(4, 360, 4);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			result=PageVerification("Add Creditor");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Add Creditor)"); 
		    M.setStrData("As Expected","Automation Testcase", 777, 6);
			M.setStrData("Pass","Automation Testcase", 777, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Add Creditor)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 777, 6);
			M.setStrData("Fail","Automation Testcase", 777, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	

	// Create Creditor
	// @Test (priority = 6)
	public void CreateCreditorLiability()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Creditor Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		
		//Go to Creditor Tab.
		try {
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
			
		} catch (Exception e) {
			count++;
			str = str + "\n" +"Creditors Tab not found";
			throw new Exception(str);
		}
		
		//Collect totall amount and TradeCreditor.
		try {
			Thread.sleep(5000);
			String collect=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
			 if(collect.contains("-")) {
				 collect="0";
			}else{
				collect = collect.replaceAll("[৳]*", ""); 
		        //System.out.println(collect);
		         
			     int ind=collect.indexOf(".");
			     collect=collect.substring(0,ind);
			    // System.out.println(collect);
			}
		   

			collect = collect.trim(); 
			
			TotalLiability=Integer.parseInt(collect);
			System.out.println(TotalLiability);
			
			
			
			collect=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
			 if(collect.contains("-")) {
				 collect="0";
			}else{
				collect = collect.replaceAll("[৳]*", ""); 
		        //System.out.println(collect);
		         
			     int ind=collect.indexOf(".");
			     collect=collect.substring(0,ind);
			     //System.out.println(collect);
			}
		   

			collect = collect.trim(); 
			//collect = collect.replaceAll("[-]*", "0"); 

			TradeCreditor=Integer.parseInt(collect);
			System.out.println(TradeCreditor);
			

		}catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Amount:"+e;
			
		}
		

		try {
			
			//Go to Add Creditor page.
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
					DataFillUp(i,362,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Thread.sleep(2000);
			//M.ScrollByText(text);
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Add Creditor button not found";
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message, Company Liabilities page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Creditor']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add Creditor";
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
							
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
				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 360, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Creditor, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Add Creditor");
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
			M.ScreenShots("Screenshot/Passed","Create Creditor"); 
		    M.setStrData("As Expected","Automation Testcase", 778, 6);
			M.setStrData("Pass","Automation Testcase", 778, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Creditor");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 778, 6);
			M.setStrData("Fail","Automation Testcase", 778, 7);
			
			
		}
		
	
		ReStart();
	}
	


	
	// Verify Created Creditor
	// @Test (priority = 7)
	public void VerifyCreateCreditor_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Created Creditor & Data Executed!");
		String CreditorLiability ="";
		String str ="";
		int count=0;
		int j=0;
		int totalLiability=0;
		int tradeCreditor=0;
		//System.out.println(TotalLiability);
		//System.out.println(TradeCreditor);
		try {
					
			CreditorLiability = M.getstring("Automation Test Data",362, 1);
			System.out.println(CreditorLiability);
			int pass = 0;
			
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 366, 7), "Total Liability Amount Doesn't Match");
				if (collect.contains("-")) {
					collect = "0";
				} else {
					collect = collect.replaceAll("[৳]*", "");
					//System.out.println(collect);

					int ind = collect.indexOf(".");
					collect = collect.substring(0, ind);
					//System.out.println(collect);
				}

				collect = collect.trim();

				totalLiability = Integer.parseInt(collect);
				System.out.println(totalLiability);

				// Collect Trade Creditor
				
				collect = driver.findElementByXPath(
						"//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
						.getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 366, 7), "Trade Creditor Liability Amount Doesn't Match");
				if (collect.contains("-")) {
					collect = "0";
				} else {
					collect = collect.replaceAll("[৳]*", "");
					//System.out.println(collect);

					int ind = collect.indexOf(".");
					collect = collect.substring(0, ind);
					//System.out.println(collect);
				}

				collect = collect.trim();
				// collect = collect.replaceAll("[-]*", "0");

				tradeCreditor = Integer.parseInt(collect);

				System.out.println(tradeCreditor);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when collect Amount:"+e;

			}

			//check calculation
			try {
				
				if(TotalLiability!=totalLiability) {
					int total=totalLiability-TotalLiability;
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",362, 4));
					System.out.println("total"+total);
					if(total!=totaldata) {
						count++;
						str = str + "\n" + "Total Liability Amount not match after add Liability";
					}
					
				}else {
					count++;
					str = str + "\n" + "Liability Amount does not added in Total Liability";
				}
				if(TradeCreditor!=tradeCreditor) {
					int card=tradeCreditor-TradeCreditor;
					int carddata=Integer.parseInt(M.getstring("Automation Test Data",362, 4));
					System.out.println("card"+card);
					if(card!=carddata) {
						count++;
						str = str + "\n" + "Trade Creditor Amount does not match after add Liability";
					}
					
				}else {
					count++;
					str = str + "\n" + "Liability Amount does not added in TradeCreditor Liability";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			FindData(CreditorLiability);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(CreditorLiability)) {
					pass++;
					Thread.sleep(5000);
					j=counting(CreditorLiability, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(CreditorLiability)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					//System.out.println(j);
											
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 366, 7), "Liability Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Liability Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 366, 8), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 366, 5), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[3]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 366, 2), "Bank Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Bank does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 366, 6), "Remarks Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Remarks does not display";
					}
					
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Creditor Liablility didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 366, 9), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 7; i++) {
					String result = VerifyText(i, 366, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 366, 10), "Button Text Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Button Text does not display";
				}
				
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}

			Thread.sleep(5000);
			M.BackFun(1);
			
			String result=PageVerification("Edit Creditor");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			PageReload();
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Verify Created Creditor & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 779, 6);
			M.setStrData("Pass","Automation Testcase",779, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Created Creditor & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 779, 6);
			M.setStrData("Fail","Automation Testcase", 779, 7);
	
		}
		ReStart();
	}
	
	
	
		
	
	
	//Verify Save Changes Button Disabled (Default & With Blank Field)
	//@Test (priority = 8)
	public void VerifySaveChangesButtonDisabled_Default_Blank()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled (Default & With Blank Field) Executed!");
		int count=0;
		int j=0;
		String str="";
		String CreditorLiability = M.getstring("Automation Test Data",362, 1);
		try {
			try {
				
				//Go to Creditor Tab.
				try {
					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
					
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Creditors Tab not found";
					throw new Exception(str);
				}
				
				Thread.sleep(2000);
				FindData(CreditorLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(CreditorLiability)) {
						
						Thread.sleep(5000);
						j=counting(CreditorLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CreditorLiability)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
					}
				}
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			for (int i = 0; i <= 3; i++) {
				boolean tr;

				Thread.sleep(3000);
				// Full Field Blank
				if (i == 0) {
					Thread.sleep(2000);
					
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "Default in Edit Creditor page, Save Changes Button is Enable";

					}
					Thread.sleep(2000);
					//M.Scroll(1);
					i++;

				}
				Thread.sleep(2000);
				//M.Scroll(1);
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPartyName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPartyName").clear();
					driver.hideKeyboard();
				}
				if (i == 2) {
					CreditorName(M.getstring("Automation Test Data", 362, 2));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").clear();
					driver.hideKeyboard();
					
				}
				if (i == 3) {
					LiabilityAmount(M.getstring("Automation Test Data", 362, 4));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").clear();
					driver.hideKeyboard();
					
				}
				
				

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Creditor Name Field is Blank But Save Changes Button is Enable";
					if (i == 2)
						str = str + "\n" + "Liability Amount Field is Blank But Save Changes Button is Enable";
					
					
				}else {
					
					if (i == 3)
						str = str + "\n" + "Remarks Field is non-mandatory field But Save Changes Button is Disable";
				}
				

			}
			// back to Creditor Liablility page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Creditor Edit Page Back Button doesn't found";
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
			
			String result=PageVerification("Edit Creditor");
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
		    M.setStrData("As Expected","Automation Testcase", 780, 6);
			M.setStrData("Pass","Automation Testcase", 780, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Save Changes Button Disabled (Default & With Blank Field)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 780, 6);
			M.setStrData("Fail","Automation Testcase", 780, 7);
			
			
		}
		ReStart();
		PageReload();
		
	}
	
	
	
	
	//Verify Save Changes Button Disabled/Enabled (For Each Field)
	//@Test(priority = 9)
	public void VerifySaveChangesButtonDisabledEnabled() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled/Enabled (For Each Field) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String CreditorLiability = M.getstring("Automation Test Data",362, 1);
		
		try {
			
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			for(int i=1;i<=6;i++){
				
				try {
					Thread.sleep(2000);
					FindData(CreditorLiability);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(CreditorLiability)) {
							
							Thread.sleep(5000);
							j=counting(CreditorLiability, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(CreditorLiability)) {
									;
								}else {
									j++;
								}
							}catch(Exception e) {
								j++;
							}
						}
					}
						//Swipping
						Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
						Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
						M.Swipping(p2,p1);
						Thread.sleep(5000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				}catch (Exception e) {
					throw new Exception("Error occures when card swip");
				}
				
				Thread.sleep(5000);
				//data fill up
				try {
					DataFillUp(i,364,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				
				Thread.sleep(2000);
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if(tr==false) {
					count++;
					if(i==1)
						str = str + "\n" + "Liability field is modify but Save Change button is disable";
					if(i==2)
						str = str + "\n" + "Creditor Name field is modify but Save Change button is disable";
					if(i==3)
						str = str + "\n" + "Currency field is modify but Save Change button is disable";
					if(i==4)
						str = str + "\n" + "Liability Amount field is modify but Save Change button is disable";
					if(i==5)
						str = str + "\n" + "Balance as of field is modify but Save Change button is disable";
					if(i==6)
						str = str + "\n" + "Remarks field is modify but Save Change button is disable";
					
				}

				//Back Button!!
				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

				} catch (Exception m) {
					
					Thread.sleep(5000);
					M.BackFun(1);
				}
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				} catch (Exception e) {
					;
				}			
				
				String result=PageVerification("Edit Creditor");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
					throw new Exception(str);
				}
				
				PageReload();
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Save Changes Button Disabled/Enabled (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 781, 6);
			M.setStrData("Pass", "Automation Testcase", 781, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Save Changes Button Disabled/Enabled(For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 781, 6);
			M.setStrData("Fail", "Automation Testcase", 781, 7);

		}
		ReStart();
		
	}
	
	

	 
	//Dismiss Unsaved Data-Edit Creditor (Default & All fields together)
	//@Test(priority = 10)
	public void DismissUnsavedData_EditCreditor_DefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-EditCreditor(Default & All fields together) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String CreditorLiability = M.getstring("Automation Test Data",362, 1);

		try {
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				FindData(CreditorLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(CreditorLiability)) {
						
						Thread.sleep(5000);
						j=counting(CreditorLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CreditorLiability)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
					}
				}
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
				
			}
			Thread.sleep(2000);
			
			//verify Edit Creditor page 
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
					count++;
					str = str + "\n" + "After click back button show warnning messsage with-out input data";
					
				}catch (Exception x) {
					count++;
					str = str + "\n" + "After press back button with-out input data, Apps may be Crush.";
					throw new Exception(str);
				}

			}
			
			//Reload page
			PageReload();
			
			//After input data
			
			try {
				Thread.sleep(2000);
				FindData(CreditorLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(CreditorLiability)) {
						
						Thread.sleep(5000);
						j=counting(CreditorLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CreditorLiability)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
					}
				}
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,364,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
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
			
			
			//Verify  Edit Creditor page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Creditor']").getText();
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 368, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,364,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Company Liabilities page";
				throw new Exception(str);
				
			}
				
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			
			String result=PageVerification("Edit Creditor");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			PageReload();
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Creditor Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 782, 6);
			M.setStrData("Pass", "Automation Testcase", 782, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Creditor Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 782, 6);
			M.setStrData("Fail", "Automation Testcase", 782, 7);

		}
		ReStart();

	}
	 

	

	//Dismiss Unsaved Data-Edit Creditor  (For Each Field)
	//@Test(priority = 11)
	public void DismissUnsavedDataForEachField_EditLCLiabilty() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Edit Creditor(For Each Field) Executed!");
		int count = 0;
		int back = 0;
		int j=0;
		String str="";
		String CreditorLiability = M.getstring("Automation Test Data",362, 1);
		int k=364;
		try {
			
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			for(int i=1;i<=6;i++){
				Thread.sleep(2000);
				//Go to Edit Creditor page
				try {
					Thread.sleep(2000);
					FindData(CreditorLiability);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int n = 0; n < xyz.size(); n++) {
						if (xyz.get(n).getText().contains(CreditorLiability)) {
							
							Thread.sleep(5000);
							j=counting(CreditorLiability, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(CreditorLiability)) {
									;
								}else {
									j++;
								}
							}catch(Exception e) {
								j++;
							}
						}
					}
						//Swipping
						Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
						Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
						M.Swipping(p2,p1);
						Thread.sleep(5000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				}catch (Exception e) {
					throw new Exception("Error occures when card swip");
				}
				
				//data fill up
				try {
					DataFillUp(i,k,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
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
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",364, i)+ confirmation;
				}				
				
				//Verify Add Creditor Liablility page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Creditor']").getText();
					
					try {
						String result= VerifyText(i, 368, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i, k, i);
						}
					}catch (Exception e) {
						
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
					// Back Button!!
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						
					}catch (Exception e) {
						
						Thread.sleep(5000);
						M.BackFun(1);

					}
					Thread.sleep(2000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						Thread.sleep(1000);
						 gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
					}catch (Exception e) {
						count++;
						str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
						throw new Exception(str);
					}
					
					
					String result=PageVerification("Edit Creditor");
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}
					
					
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
					
					str = str + "\n" + " After click Back button and warning message no, Page Redirect to Company Liabilities page";
					//throw new Exception(str);
					

				}
				
				PageReload();
				
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Creditor (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 783, 6);
			M.setStrData("Pass", "Automation Testcase", 783, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Creditor (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 783, 6);
			M.setStrData("Fail", "Automation Testcase", 783, 7);

		}
		ReStart();
		
	}

	
	
	
	
	//Dismiss Selected Value From Dropdown (Edit Creditor)		
	//@Test (priority = 12)
	public void DismissSelectedValueFromDropdown_EditLCLiability()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Edit Creditor) Executed!");
		int count=0;
		int j=0;
		String str="";
		String CreditorLiability = M.getstring("Automation Test Data",362, 1);

		try {
			
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			
			// Go to Edit Creditor
			try {
				Thread.sleep(2000);
				FindData(CreditorLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(CreditorLiability)) {
						
						Thread.sleep(5000);
						j=counting(CreditorLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CreditorLiability)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
					}
				}
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			// check Liability Type Dropdown
			LiabilityType(M.getstring("Automation Test Data", 364, 1),2);		
			String result = VerifyText(1, 362, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}	

			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 364, 3),2);		
			result = VerifyText(3, 362, 3);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 364, 5),2);		
			result = VerifyText(5, 362, 5);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			}catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			result=PageVerification("Edit Creditor");
			
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			PageReload();
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Edit Creditor)"); 
		    M.setStrData("As Expected","Automation Testcase", 784, 6);
			M.setStrData("Pass","Automation Testcase", 784, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Edit Creditor)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 784, 6);
			M.setStrData("Fail","Automation Testcase", 784, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	

	// Update Creditor Liablility
	//@Test (priority = 13)
	public void UpdateLCLiability()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update Creditor Liablility Executed!");
		int count = 0;
		int j=0;
		String str="";
		String BankLiablility = M.getstring("Automation Test Data",362, 1);

		String successful = "";
		
		//Go to Creditor Tab.
		try {
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
			
		} catch (Exception e) {
			count++;
			str = str + "\n" +"Creditors Tab not found";
			throw new Exception(str);
		}
		
		try {
			String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
			if (collect.contains("-")) {
				collect = "0";
			} else {
				collect = collect.replaceAll("[৳]*", "");
				//System.out.println(collect);

				int ind = collect.indexOf(".");
				collect = collect.substring(0, ind);
				//System.out.println(collect);
			}

			collect = collect.trim();

			TotalLiability = Integer.parseInt(collect);
			System.out.println(TotalLiability);

			// Collect Opened B2B
			collect = driver.findElementByXPath(
					"//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
					.getText();
			if (collect.contains("-")) {
				collect = "0";
			} else {
				collect = collect.replaceAll("[৳]*", "");
				//System.out.println(collect);

				int ind = collect.indexOf(".");
				collect = collect.substring(0, ind);
				//System.out.println(collect);
			}

			collect = collect.trim();
			// collect = collect.replaceAll("[-]*", "0");

			TradeCreditor = Integer.parseInt(collect);

			System.out.println(TradeCreditor);

		} catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Amount:"+e;

		}
		
		try {
			
			//Go to Edit Creditor page.
			try {
				Thread.sleep(2000);
				FindData(BankLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(BankLiablility)) {
						
						Thread.sleep(5000);
						j=counting(BankLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankLiablility)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
					}
				}
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			
			// Data input
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,364,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
			}
			
			//Thread.sleep(2000);
			//M.ScrollByText(text);
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Add Creditor Liablility button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 4), M.getstring("Automation Test Data", 305, 5));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Creditor']").getText();
				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(5000);
				try {
					 user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
					
				} catch (Exception y) {
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						count++;
						str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
						Thread.sleep(3000);
						user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
						
					}catch (Exception z) {
						count++;
						str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
						Thread.sleep(5000);
						
					}
					
				}
			} catch (Exception e) {
				count++;
				
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
					str = str + "\n" + "After sucessful message OK, Edit Creditor page not found and it redirect to Company Liabilities page.";
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
				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 360, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After Update Creditor Liablility, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Edit Creditor");
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
			PageReload();
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Update Creditor Liablility"); 
		    M.setStrData("As Expected","Automation Testcase", 785, 6);
			M.setStrData("Pass","Automation Testcase", 785, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Creditor Liablility");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 785, 6);
			M.setStrData("Fail","Automation Testcase", 785, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
	
	// Verify Update Creditor Liablility
	//@Test (priority = 14)
	public void VerifyUpdateCreditorLiability_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Creditor Liablility & Data Executed!");
		String BankLiablility =M.getstring("Automation Test Data",364, 1);
		String str ="";
		int count=0;
		int pass=0;
		int j=0;
		
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			
			
			Thread.sleep(2000);
			FindData(BankLiablility);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(BankLiablility)) {
					pass++;
					Thread.sleep(5000);
					j=counting(BankLiablility, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(BankLiablility)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					//System.out.println(j);
											
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 368, 7), "Liability Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Liability Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 368, 8), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 368, 5), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[3]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 368, 2), "Bank Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Bank does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 368, 6), "Remarks Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Remarks does not display";
					}
					
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Bank Liability didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 368, 9), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 368, i);
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 368, 10), "Button Text Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Button Text does not display";
				}
				
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;

			}

			Thread.sleep(5000);
			M.BackFun(1);
			
			String result=PageVerification("Edit Creditor");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			PageReload();
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Verify Edit Creditor & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 786, 6);
			M.setStrData("Pass","Automation Testcase", 786, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Edit Creditor & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 786, 6);
			M.setStrData("Fail","Automation Testcase", 786, 7);
	
		}
		ReStart();
	}
	
	



	// Delete & Verify Deleted Creditor Liablility
	//@Test(priority = 15)
	public void Delete_VerifyDeletedCreditorLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete & Verify Deleted Creditor Liablility Executed!");
		String BankLiablility =M.getstring("Automation Test Data",364, 1);
		String str ="";
		int count=0;
		int j=0;
		try {
			//Go to Creditor Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Tab not found";
				throw new Exception(str);
			}
			

			
			//Swip the card
			try {
				Thread.sleep(2000);
				FindData(BankLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(BankLiablility)) {
						
						Thread.sleep(5000);
						j=counting(BankLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankLiablility)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
					}
				}
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}

			
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);

				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 385, 2),M.getstring("Automation Test Data", 385, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}
				
				
				try {
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(2000);
					count++;
					str = str + "\n" + "After Delete Warning message no, Creditor Liablility card doesn't close";

				} catch (Exception e) {
					try {
						Thread.sleep(2000);
						int x=FindData(BankLiablility);
						Thread.sleep(2000);
						if(x==0) {
							count++;
							str = str + "\n" + "After click Delete warning message No,Creditor Liablility Card Delete ";
							throw new Exception(str);
						}
						//Swip the card
						try {
							
							List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
							String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
							String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
							for (int n = 0; n < xyz.size(); n++) {
								if (xyz.get(n).getText().contains(BankLiablility)) {
									
									Thread.sleep(5000);
									j=counting(BankLiablility, str1, str2);
									//System.out.println(j);
									try {
										String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
										if(gettext.contentEquals(BankLiablility)) {
											;
										}else {
											j++;
										}
									}catch(Exception c) {
										j++;
									}
								}
							}
								//Swipping
								Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
								Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
								M.Swipping(p2,p1);
								Thread.sleep(5000);
						
								//Click Delete Button
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								Thread.sleep(2000);
						}catch (Exception y) {
							throw new Exception("Error occures when card swip");
						}
					} catch (Exception x) {
						;
					}

				}

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
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 385, 4),M.getstring("Automation Test Data", 385, 5));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				try {
					Thread.sleep(2000);
					int x=FindData(BankLiablility);
					Thread.sleep(2000);
					if(x==1) {
						count++;
						str = str + "\n" + "After Sucessfully Delete, Creditor Liablility card doesn't Delete ";
						throw new Exception(str);
					}
					

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
			M.ScreenShots("Screenshot/Passed", "Delete & Verify Deleted Creditor Liablility");
			M.setStrData("As Expected", "Automation Testcase", 787, 6);
			M.setStrData("Pass", "Automation Testcase", 787, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete & Verify Deleted Creditor Liablility");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 787, 6);
			M.setStrData("Fail", "Automation Testcase", 787, 7);

		}
		PageReload();
		ReStart();
	}
	
	

	
		
	
	


}
