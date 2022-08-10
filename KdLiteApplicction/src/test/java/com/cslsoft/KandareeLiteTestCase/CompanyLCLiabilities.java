package com.cslsoft.KandareeLiteTestCase;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CompanyLCLiabilities extends BaseClass {

	int TotalLiability=0;
	int Anticipated=0;
	int OpenedB2B=0;
	int Packing_Credit=0;
	int Negotiation=0;
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
		 
		 System.out.println("Navigate Hamburgare to Company Liabilities!");
		 

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

		} catch (Exception e) {
			;

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
						
					}

			}
				Thread.sleep(2000);
				M.ScrollDwon(1);
		}

		} catch (Exception e) {
			;

		}
		return pass;

		
		
	}
	
	
	//ReStart
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
			
			Boolean tr=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"LC Liability\"]/android.widget.TextView").isSelected();
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
		}
		
	}
	

	//DataUp
	private void DataUp(String data) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
		for (j = 0; j < xyz.size(); j++) {
			if (xyz.get(j).getText().contains(data)) {
				if (j >= 6) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
				}

			}
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
		//System.out.println("item:"+item);
		//System.out.println("editId:"+editId);
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


	public void DataFillUp(int i,int j,int k) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if (i == 1) 
			LiabilityType(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 2) 
			Currency(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 3) 
			LiabilityAmount(M.getstring("Automation Test Data", j, k));
		
		if (i == 4) 
			BalanceAsOf(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 5) 
			Remarks(M.getstring("Automation Test Data", j, k));
		

	}
	
	
	
	
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
			//Currency
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Currency Doesn't Match");
		}
		if(i==3) {
			//LiabilityAmount
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Liability Amount Doesn't Match");
		}
				
		
		if(i==4) {
			//BalanceAsOf
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtBalanceAsOf").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "BalanceAsOf Doesn't Match");
		}
		if(i==5) {
			//Remarks
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Remarks Doesn't Match");
		}
		if(i==6) {
			//CreatedBy
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 320, 6), "CreatedBy Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}

	
	
	//Verify Company Liabilities View
	//@Test (priority = 1)
	public void VerifyCompanyLiabilitiesListView()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Company Liabilities View Executed!");
		int count=0;
		String str="";
		try {

			//Page Title
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				
				if(gettext.contentEquals("Company Liabilities")) {
					;
				}else {
					count++;
					str = str + "\n" + "Company Liabilities Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Company Liabilities Title doesn't found";
			}
			
			
			// Create page
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
				if(tr==false) {
					count++;
					str = str + "\n" + "LC Liability Create Icon doesn't display";
					//System.out.println(str);
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" +"LC Liability Create Icon doesn't found";
			}

			
			//Check Lc Liability tab
			try {
				String gettext=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"LC Liability\"]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("LC Liability")) {
					;
				}else {
					count++;
					str = str + "\n" + "LC Liability Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "LC Liability Title doesn't found";
			}
			
			
			//Check Bank Loans
			try {
				String gettext=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Bank Loans\"]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("Bank Loans")) {
					;
				}else {
					count++;
					str = str + "\n" + "Bank Loans Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Bank Loans Title doesn't found";
			}
			
			
			//Check Creditors
			try {
				String gettext=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("Creditors")) {
					;
				}else {
					count++;
					str = str + "\n" + "Creditors Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Creditors Title doesn't found";
			}
			
			//Lc Liability Tab
			try {
				//Total Liability
				String gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Total Liability", "Total Liability Doesn't Match");
				
				//Balance as of
				gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Balance as of", "Balance as of Doesn't Match");
				
				
				//Opened B2B LCs
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Opened B2B LCs", "Opened B2B LCs Doesn't Match");
				
				
				//Anticipated B2B LCs
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Anticipated B2B LCs", "Anticipated B2B LCs Doesn't Match");
				
				
				//Packing Credit
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Packing Credit", "Packing Credit Doesn't Match");
				
				
				//Negotiation
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Negotiation", "Negotiation Doesn't Match");
				
				
				//Others
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Others", "Others Doesn't Match");
				
				
				
				try {
					SA.assertAll();
				} catch (AssertionError e) {
					
					str = str + "\n" + e;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +e+ "Lc Liability Text Xpath doesn't found";
			}
			
			//Go To Bank Loans Tab
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Bank Loans\"]/android.widget.TextView").click();
			Thread.sleep(2000);
			
			
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
				if(tr==false) {
					count++;
					str = str + "\n" + "Bank Loans Create Icon doesn't display";
					//System.out.println(str);
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Bank Loans Create Icon doesn't found";
			}

			
			// Bank Loans

			try {
				// Total Liability
				String gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Total Liability", "Total Liability Doesn't Match");
				
				// Balance as of
				gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Balance as of", "Balance as of Doesn't Match");
				
				
				// Forced Loan
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Forced Loan", "Forced Loan Doesn't Match");
				
				
				// Term Loan
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Term Loan", "Term Loan Doesn't Match");
				
				
				// Project Loan
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Project Loan", "Project Loan Doesn't Match");
				
				
				// SOD Account
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "SOD Account", "SOD Account Doesn't Match");
				
				
				//Others
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Others", "Others Doesn't Match");
				
				

				try {
					SA.assertAll();
				} catch (AssertionError e) {
					
					str = str + "\n" + e;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +e+ "Bank Loans Text Xpath doesn't found";
			}
			
			
			//Go To Creditors Tab
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Creditors\"]/android.widget.TextView").click();
			Thread.sleep(2000);
			
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
				if(tr==false) {
					count++;
					str = str + "\n" + "Creditors Create Icon doesn't display";
					//System.out.println(str);
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Creditors Create Icon doesn't found";
			}
			
			
			// Creditors
			try {
				// Total Liability
				String gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Total Liability", "Total Liability Doesn't Match");
				
				// Balance as of
				gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Balance as of", "Balance as of Doesn't Match");
				
				
				// Trade Creditor
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Trade Creditor", "Trade Creditor Doesn't Match");
				
				
				// Machineries Supplier
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Machineries Supplier", "Machineries Supplier Doesn't Match");
				
				
				// Other Creditors
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Other Creditors", "Other Creditors Doesn't Match");
				
				
				// Non-Trade Creditor
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Non-Trade Creditor", "Non-Trade Creditor Account Doesn't Match");
				
				
				//Others
				gettext=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Others", "Others Doesn't Match");
				
				

				try {
					SA.assertAll();
				} catch (AssertionError e) {
					
					str = str + "\n" + e;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +e+ "Bank Loans Text Xpath doesn't found";
			}
						
			
			
			//Go To Creditors Tab
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"LC Liability\"]/android.widget.TextView").click();
			Thread.sleep(2000);
			
			
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Company Liabilities View"); 
		    M.setStrData("As Expected","Automation Testcase", 721, 6);
			M.setStrData("Pass","Automation Testcase", 721, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Company Liabilities View");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 721, 6);
			M.setStrData("Fail","Automation Testcase", 721, 7);

		}
		
		ReStart();
		
	}

		
	
	
	//Verify Place Holder Text (Add LC Liability)
	//@Test (priority = 2)
	public void VerifyPlaceHolderText_AddLCLiability()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Place Holder Text_Add LC Liability Executed!");
		int count=0;
		String str="";
		try {
			//Go to Liability Create page.
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Create icon not found";
				throw new Exception(str);
			}
			
			Thread.sleep(5000);
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 320, 9), "Add LC Liability title text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add LC Liability Title doesn't found";
			}
			
			//Verify Task Template
			for(int i=1;i<=6;i++)
			{
				String result=VerifyText(i,320,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 320, 9), "Add LC Liability button text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add LC Liability Create Button doesn't found";
			}
			
			// back to LC Liability page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add LC Liability Create Page Back Button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
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
			M.ScreenShots("Screenshot/Passed","Verify Place Holder Text_Add LC Liability"); 
		    M.setStrData("As Expected","Automation Testcase", 722, 6);
			M.setStrData("Pass","Automation Testcase", 722, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Place Holder Text_Add LC Liability");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 722, 6);
			M.setStrData("Fail","Automation Testcase", 722, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	//Verify Disabled Add LC Liability Button (Default & With Blank Field)
	//@Test (priority = 3)
	public void VerifyDisabledAddLCLiabilityButton()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Disabled Add LC Liability Button -Default & With Blank Field Executed!");
		int count=0;
		String str="";
		int k=322;
		try {
			for (int i = 0; i <= 5; i++) {
				boolean tr;
				
				//Go to Add LC Liability page.
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
					tr =driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Add LC Liability Button is Enable";

					}
					
					i++;
				}
				Thread.sleep(2000);
				if (i != 1) {
					LiabilityType(M.getstring("Automation Test Data", k,1),1);
				}
				if (i != 2) {
					Currency(M.getstring("Automation Test Data", k,2),1);
				}
				if (i != 3) {
					LiabilityAmount(M.getstring("Automation Test Data", k,3));
				}
				if (i != 4) {
					BalanceAsOf(M.getstring("Automation Test Data", k,4),1);
				}
				if (i != 5) {
					Remarks(M.getstring("Automation Test Data", k,5));
				}
				Thread.sleep(2000);

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == true) {
					System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Liability Type Field is Blank But Add LC Liability Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Currency Field is Blank But Add LC Liability Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Liability Amount Field is Blank But Add LC Liability Button is Enable";
					else if (i == 4)
						str = str + "\n" + "BalanceAsOf Field is Blank But Add LC Liability Button is Enable";
						
				}else {
					if (i == 5) {
						count++;
						str = str + "\n" + "Remarks Field is not Mandatory field But Add LC Liability Button is Disable";
					}
				}
				if (i != 6) {
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
			M.ScreenShots("Screenshot/Passed","Verify Disabled Add LC Liability Button -Default & With Blank Field"); 
		    M.setStrData("As Expected","Automation Testcase", 723, 6);
			M.setStrData("Pass","Automation Testcase", 723, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Disabled Add LC Liability Button -Default & With Blank Field");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 723, 6);
			M.setStrData("Fail","Automation Testcase", 723, 7);
			
			
		}

		ReStart();
	}
	
	
	
	 
	 
	//Dismiss Unsaved Data-Add LC Liability (Default & All fields together)
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
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
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
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=5;i++) {
				try {
					DataFillUp(i,322,i);
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
			
			
			//Verify Add LC Liability page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add LC Liability']").getText();
				
				try {
					for(int i=1;i<=5;i++)
					{
						String result= VerifyText(i, 322, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,322,i);
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
			
			
			String result=PageVerification("Add LC Liability");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data- Add LC Liability Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 724, 6);
			M.setStrData("Pass", "Automation Testcase", 724, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data- Add LC Liability Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 724, 6);
			M.setStrData("Fail", "Automation Testcase", 724, 7);

		}
		ReStart();

	}
	 


	
	
	//Dismiss Unsaved Data-Add LC Liabilty  (For Each Field)
	//@Test(priority = 5)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		int k=322;
		try {
			
			for(int i=1;i<=5;i++){
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
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",322, i)+ confirmation;
				}				
				
				//Verify Add LC Liability page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add LC Liability']").getText();
					
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
				
				
				String result=PageVerification("Add LC Liability");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Add LC Liabilty (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 725, 6);
			M.setStrData("Pass", "Automation Testcase", 725, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Add LC Liabilty (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 725, 6);
			M.setStrData("Fail", "Automation Testcase", 725, 7);

		}
		ReStart();
		
	}

	
	
	//Dismiss Selected Value From Dropdown (Add LC Liability)		
	//@Test (priority = 6)
	public void DismissSelectedValueFromDropdown_AddLCLiability()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Add LC Liability) Executed!");
		int count=0;
		String str="";
		try {
			// Go to Add LC Liability
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			
			// check Liability Type Dropdown
			LiabilityType(M.getstring("Automation Test Data", 324, 1),2);		
			String result = VerifyText(1, 320, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 324, 2),2);		
			result = VerifyText(2, 320, 2);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 324, 4),2);		
			result = VerifyText(4, 320, 4);
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
			result=PageVerification("Add LC Liability");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Add LC Liability)"); 
		    M.setStrData("As Expected","Automation Testcase", 726, 6);
			M.setStrData("Pass","Automation Testcase", 726, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Add LC Liability)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 726, 6);
			M.setStrData("Fail","Automation Testcase", 726, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	
	// Create LC Liability
	//@Test (priority = 7)
	public void CreateLCLiability()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create LC Liability Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		
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

			OpenedB2B = Integer.parseInt(collect);

			System.out.println(OpenedB2B);

		} catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Amount:"+e;

		}
		
		try {
			
			//Go to Add LC Liability page.
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
			for(int i=1;i<=5;i++) {
				try {
					DataFillUp(i,322,i);
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
				str = str + "\n" + "Create Add LC Liability button not found";
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
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add LC Liability']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add LC Liability";
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
				for (int i = 1; i <= 5; i++) {
					String result = VerifyText(i, 320, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create LC Liability, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Add LC Liability");
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
			M.ScreenShots("Screenshot/Passed","Create LC Liability"); 
		    M.setStrData("As Expected","Automation Testcase", 727, 6);
			M.setStrData("Pass","Automation Testcase", 727, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create LC Liability");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 727, 6);
			M.setStrData("Fail","Automation Testcase", 727, 7);
			
			
		}
		
		
		ReStart();
	}
	

	

	
	// Verify Created LC Liability
	//@Test (priority = 8)
	public void VerifyCreateLCLiability_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Created LC Liability & Data Executed!");
		String LCLiablility ="";
		String str ="";
		int count=0;
		int j=0;
		int totalLiability=0;
		int openedB2B=0;
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
					
			LCLiablility = M.getstring("Automation Test Data",322, 1);
			//System.out.println(LCLiablility);
			int pass = 0;
			
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 326, 6), "Total Liability Amount Doesn't Match");
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

				// Collect Opened B2B
				
				collect = driver.findElementByXPath(
						"//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
						.getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 326, 6), "Opened B2B Liability Amount Doesn't Match");
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

				openedB2B = Integer.parseInt(collect);

				System.out.println(openedB2B);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when collect Amount:"+e;

			}

			//check calculation
			try {
				
				if(TotalLiability!=totalLiability) {
					int total=totalLiability-TotalLiability;
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",322, 3));
					System.out.println(total);
					if(total!=totaldata) {
						count++;
						str = str + "\n" + "Total Liability Amount not match after add Liability";
					}
					
				}else {
					count++;
					str = str + "\n" + "Liability Amount does not added in Total Liability";
				}
				if(OpenedB2B!=openedB2B) {
					int card=openedB2B-OpenedB2B;
					int carddata=Integer.parseInt(M.getstring("Automation Test Data",322, 3));
					System.out.println(card);
					if(card!=carddata) {
						count++;
						str = str + "\n" + "Opened B2B Amount does not match after add Liability";
					}
					
				}else {
					count++;
					str = str + "\n" + "Liability Amount does not added in OpenedB2B Liability";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			FindData(LCLiablility);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(LCLiablility)) {
					pass++;
					Thread.sleep(5000);
					j=counting(LCLiablility, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(LCLiablility)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 326, 6), "Liability Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Liability Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 326, 7), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 326, 4), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 326, 5), "Remarks Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Remarks does not display";
					}
					
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("LC Liablility didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 326, 8), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 326, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 326, 9), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit LC Liablility");
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
			
			M.ScreenShots("Screenshot/Passed"," Verify Created LC Liability & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 728, 6);
			M.setStrData("Pass","Automation Testcase",728, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Created LC Liability & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 728, 6);
			M.setStrData("Fail","Automation Testcase", 728, 7);
	
		}
		ReStart();
	}
	
	
	
	
	//Verify Save Changes Button Disabled (Default & With Blank Field)
	//@Test (priority = 9)
	public void VerifySaveChangesButtonDisabled_Default_Blank()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled (Default & With Blank Field) Executed!");
		int count=0;
		int j=0;
		String str="";
		String LCLiablility = M.getstring("Automation Test Data",322, 1);
		try {
			try {
				Thread.sleep(2000);
				FindData(LCLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(LCLiablility)) {
						
						Thread.sleep(5000);
						j=counting(LCLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(LCLiablility)) {
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
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			for (int i = 0; i <= 2; i++) {
				boolean tr;

				Thread.sleep(3000);
				// Full Field Blank
				if (i == 0) {
					Thread.sleep(2000);
					
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "Default in Edit LC Liability page, Save Changes Button is Enable";

					}
					Thread.sleep(2000);
					//M.Scroll(1);
					i++;

				}
				Thread.sleep(2000);
				//M.Scroll(1);
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").clear();
					driver.hideKeyboard();
					
				}
				if (i == 2) {
					LiabilityAmount(M.getstring("Automation Test Data", 322, 3));
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
						str = str + "\n" + "Liability Amount Field is Blank But Save Changes Button is Enable";
					
					
				}else {
					
					if (i == 2)
						str = str + "\n" + "Remarks Field is non-mandatory field But Save Changes Button is Disable";
				}
				

			}
			// back to LC Liability page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit LC Liability Edit Page Back Button doesn't found";
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
			
			String result=PageVerification("Edit LC Liability");
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
		    M.setStrData("As Expected","Automation Testcase", 729, 6);
			M.setStrData("Pass","Automation Testcase", 729, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Save Changes Button Disabled (Default & With Blank Field)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 729, 6);
			M.setStrData("Fail","Automation Testcase", 729, 7);
			
			
		}
		ReStart();
		PageReload();
		
	}
	
	
	
	
	
	//Verify Save Changes Button Disabled/Enabled (For Each Field)
	//@Test(priority = 10)
	public void VerifySaveChangesButtonDisabledEnabled() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled/Enabled (For Each Field) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String LCLiablility = M.getstring("Automation Test Data",322, 1);
		
		try {
			
			for(int i=1;i<=5;i++){
				
				try {
					Thread.sleep(2000);
					FindData(LCLiablility);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(LCLiablility)) {
							
							Thread.sleep(5000);
							j=counting(LCLiablility, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(LCLiablility)) {
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
						Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
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
					DataFillUp(i,324,i);
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
						str = str + "\n" + "Currency field is modify but Save Change button is disable";
					if(i==3)
						str = str + "\n" + "Liability Amount field is modify but Save Change button is disable";
					if(i==4)
						str = str + "\n" + "Balance as of field is modify but Save Change button is disable";
					if(i==5)
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
				
				String result=PageVerification("Edit LC Liability");
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
			M.setStrData("As Expected", "Automation Testcase", 730, 6);
			M.setStrData("Pass", "Automation Testcase", 730, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Save Changes Button Disabled/Enabled(For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 730, 6);
			M.setStrData("Fail", "Automation Testcase", 730, 7);

		}
		ReStart();
		
	}
	
	

	 
	//Dismiss Unsaved Data-Edit LC Liability (Default & All fields together)
	//@Test(priority = 11)
	public void DismissUnsavedData_EditLCLiability_DefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-EditLCLiability(Default & All fields together) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String LCLiablility = M.getstring("Automation Test Data",322, 1);

		try {
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				FindData(LCLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(LCLiablility)) {
						
						Thread.sleep(5000);
						j=counting(LCLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(LCLiablility)) {
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
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
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
			
			//verify Edit Lc Liability page 
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
				FindData(LCLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(LCLiablility)) {
						
						Thread.sleep(5000);
						j=counting(LCLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(LCLiablility)) {
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
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=5;i++) {
				try {
					DataFillUp(i,324,i);
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
			
			
			//Verify  Edit Lc Liability page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit LC Liability']").getText();
				
				try {
					for(int i=1;i<=5;i++)
					{
						String result= VerifyText(i, 328, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,324,i);
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
			
			
			String result=PageVerification("Edit LC Liability");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit LC Liability Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 731, 6);
			M.setStrData("Pass", "Automation Testcase", 731, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit LC Liability Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 731, 6);
			M.setStrData("Fail", "Automation Testcase", 731, 7);

		}
		ReStart();

	}
	 

	

	
	
	//Dismiss Unsaved Data-Edit LC Liabilty  (For Each Field)
	//@Test(priority = 12)
	public void DismissUnsavedDataForEachField_EditLCLiabilty() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Edit LC Liabilty(For Each Field) Executed!");
		int count = 0;
		int back = 0;
		int j=0;
		String str="";
		String LCLiablility = M.getstring("Automation Test Data",322, 1);
		int k=324;
		try {
			
			for(int i=1;i<=5;i++){
				Thread.sleep(2000);
				//go to Edit LC Liabilty page
				try {
					Thread.sleep(2000);
					FindData(LCLiablility);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int n = 0; n < xyz.size(); n++) {
						if (xyz.get(n).getText().contains(LCLiablility)) {
							
							Thread.sleep(5000);
							j=counting(LCLiablility, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(LCLiablility)) {
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
						Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
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
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",324, i)+ confirmation;
				}				
				
				//Verify Add LC Liability page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit LC Liability']").getText();
					
					try {
						String result= VerifyText(i, 328, i);
						
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
					
					
					String result=PageVerification("Edit LC Liability");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit LC Liabilty (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 732, 6);
			M.setStrData("Pass", "Automation Testcase", 732, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit LC Liabilty (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 732, 6);
			M.setStrData("Fail", "Automation Testcase", 732, 7);

		}
		ReStart();
		
	}

	
	
	
	
	//Dismiss Selected Value From Dropdown (Edit LC Liability)		
	//@Test (priority = 13)
	public void DismissSelectedValueFromDropdown_EditLCLiability()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Edit LC Liability) Executed!");
		int count=0;
		int j=0;
		String str="";
		String LCLiablility = M.getstring("Automation Test Data",322, 1);

		try {
			// Go to Edit LC Liability
			try {
				Thread.sleep(2000);
				FindData(LCLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(LCLiablility)) {
						
						Thread.sleep(5000);
						j=counting(LCLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(LCLiablility)) {
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
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			// check Liability Type Dropdown
			LiabilityType(M.getstring("Automation Test Data", 324, 1),2);		
			String result = VerifyText(1, 322, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 324, 2),2);		
			result = VerifyText(2, 322, 2);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 324, 4),2);		
			result = VerifyText(4, 322, 4);
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
			result=PageVerification("Edit LC Liability");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Edit LC Liability)"); 
		    M.setStrData("As Expected","Automation Testcase", 733, 6);
			M.setStrData("Pass","Automation Testcase", 733, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Edit LC Liability)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 733, 6);
			M.setStrData("Fail","Automation Testcase", 733, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	

	// Update LC Liability
	//@Test (priority = 14)
	public void UpdateLCLiability()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update LC Liability Executed!");
		int count = 0;
		int j=0;
		String str="";
		String LCLiablility = M.getstring("Automation Test Data",322, 1);

		String successful = "";
		
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

			OpenedB2B = Integer.parseInt(collect);

			System.out.println(OpenedB2B);

		} catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Amount:"+e;

		}
		
		try {
			
			//Go to Edit LC Liability page.
			try {
				Thread.sleep(2000);
				FindData(LCLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(LCLiablility)) {
						
						Thread.sleep(5000);
						j=counting(LCLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(LCLiablility)) {
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
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
					M.Swipping(p2,p1);
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			
			// Data input
			for(int i=1;i<=5;i++) {
				try {
					DataFillUp(i,324,i);
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
				str = str + "\n" + "Create Add LC Liability button not found";
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit LC Liability']").getText();
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
				str = str + "\n" + "After sucessful message OK, Edit LC Liability page not found";
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();

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
				for (int i = 1; i <= 5; i++) {
					String result = VerifyText(i, 320, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After Update LC Liability, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Edit LC Liability");
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
			M.ScreenShots("Screenshot/Passed","Update LC Liability"); 
		    M.setStrData("As Expected","Automation Testcase", 734, 6);
			M.setStrData("Pass","Automation Testcase", 734, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update LC Liability");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 734, 6);
			M.setStrData("Fail","Automation Testcase", 734, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
	

	
	// Verify Update LC Liability
	//@Test (priority = 15)
	public void VerifyUpdateLCLiability_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update LC Liability & Data Executed!");
		String LCLiablility =M.getstring("Automation Test Data",324, 1);
		String str ="";
		int count=0;
		int pass=0;
		int j=0;
		
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			Thread.sleep(2000);
			FindData(LCLiablility);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(LCLiablility)) {
					pass++;
					Thread.sleep(5000);
					j=counting(LCLiablility, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(LCLiablility)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 328, 6), "Liability Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Liability Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 328, 7), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 328, 4), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 328, 5), "Remarks Doesn't Match");
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
				throw new Exception("LC Liablility didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 328, 8), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 328, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 328, 9), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit LC Liablility");
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
			
			M.ScreenShots("Screenshot/Passed"," Verify Edit LC Liability & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 735, 6);
			M.setStrData("Pass","Automation Testcase",735, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Edit LC Liability & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 735, 6);
			M.setStrData("Fail","Automation Testcase", 735, 7);
	
		}
		ReStart();
	}
	
	


	// Delete & Verify Deleted LC Liability
	//@Test(priority = 16)
	public void Delete_VerifyDeletedLCLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete & Verify Deleted LC Liability Executed!");
		String LCLiablility =M.getstring("Automation Test Data",324, 1);
		String str ="";
		int count=0;
		int j=0;
		try {
			//Swip the card
			try {
				Thread.sleep(2000);
				FindData(LCLiablility);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(LCLiablility)) {
						
						Thread.sleep(5000);
						j=counting(LCLiablility, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(LCLiablility)) {
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
					str = str + "\n" + "After Delete Warning message no, LC Liability card doesn't close";

				} catch (Exception e) {
					try {
						Thread.sleep(2000);
						int x=FindData(LCLiablility);
						Thread.sleep(2000);
						if(x==0) {
							count++;
							str = str + "\n" + "After click Delete warning message No,LC Liability Card Delete ";
							throw new Exception(str);
						}
						//Swip the card
						try {
							
							List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
							String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
							String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
							for (int n = 0; n < xyz.size(); n++) {
								if (xyz.get(n).getText().contains(LCLiablility)) {
									
									Thread.sleep(5000);
									j=counting(LCLiablility, str1, str2);
									//System.out.println(j);
									try {
										String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
										if(gettext.contentEquals(LCLiablility)) {
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
								Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getLocation();
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
					int x=FindData(LCLiablility);
					Thread.sleep(2000);
					if(x==1) {
						count++;
						str = str + "\n" + "After Sucessfully Delete, LC Liablility card doesn't Delete ";
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
			M.ScreenShots("Screenshot/Passed", "Delete & Verify Deleted LC Liability");
			M.setStrData("As Expected", "Automation Testcase", 736, 6);
			M.setStrData("Pass", "Automation Testcase", 736, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete & Verify Deleted LC Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 736, 6);
			M.setStrData("Fail", "Automation Testcase", 736, 7);

		}
		PageReload();
		ReStart();
	}
	
	
	
	

	
		

	
	
	
	
	
	
	
	
	
	
	
	
	


}
