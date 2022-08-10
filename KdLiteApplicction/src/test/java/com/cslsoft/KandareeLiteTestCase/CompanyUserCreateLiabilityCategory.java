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

public class CompanyUserCreateLiabilityCategory extends BaseClass {


	int TotalLiability=0;
	int Subtotal1=0;
	int Subtotal2=0;
	int Others=0;
	
	
	@Test(priority = 0)
	public void Nevigate() throws InterruptedException, IOException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UserCreateLiability(1);
		
		System.out.println("Navigate Hamburgare to Company Liabilities!");
		

	}
	

	public int UserCreateLiability(int k) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int pass=0;
		for(int i=0;i<5;i++)
		{
			Point p1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tabs").getCenter();
			Point p2 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tabs").getLocation();
			Thread.sleep(2000);
			if(k==1)
				M.Swipping(p1, p2);
			try {
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Current Liability\"]/android.widget.TextView").click();
				i=5;
				pass++;
				break;
			}catch(Exception x) {
				
			}
			if(k==0)
				M.Swipping(p1, p2);
			
		}
		return pass;
	}
	
	//ReStart
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").getText();
			
			Boolean tr=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Current Liability\"]/android.widget.TextView").isSelected();
			if(tr==false) {
				System.out.println("System");
				
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
			UserCreateLiability(1);
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
						//System.out.println(text);
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
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
		for (j = 0; j < xyz.size(); j++) {
			if (xyz.get(j).getText().contains(data)) {
				if (j >= 4) {
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
			UserCreateLiability(1);
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
	
	
	//Party Name
	public void PartyName(String text) {
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
			PartyName(M.getstring("Automation Test Data", j, k));
		
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
			//Party Name
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPartyName").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Party Name Doesn't Match");
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
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 390, 7), "CreatedBy Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}

	
	// Add & Verify User Created Liability Category
	//@Test (priority = 1)
	public void Add_VerifyUserCreatedLiabilityCategory() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Add & Verify User Created Liability Category Executed!");
		int count = 0;
		String str = "";
		try {
			// Go to Library and create Liability category
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.findElementByXPath("//android.widget.TextView[@text='Library']").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Go to the Liability Category Department
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_libraryDepartment").click();
				 M.ClickOn(M.getstring("Automation Test Data", 389, 2));
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				 //create Liability category.
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").click();
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_libraryValues").setValue(M.getstring("Automation Test Data", 389, 1));
				 driver.hideKeyboard();
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				 //Successful Added Message
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Something is worng when create Laibility category :"+e;
				throw new Exception(str);
			}
			
		
			//Go to Company Liabilities
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElementByXPath("//android.widget.TextView[@text='Company Liabilities']").click();
			Thread.sleep(2000);
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(1);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}
				
			

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Add & Verify User Created Liability Category");
			M.setStrData("As Expected", "Automation Testcase", 810, 6);
			M.setStrData("Pass", "Automation Testcase", 810, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Add & Verify User Created Liability Category");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 810, 6);
			M.setStrData("Fail", "Automation Testcase", 810, 7);

		}

		ReStart();
	}
	
	
	
	
	// Verify User Created Liability Category View
	//@Test (priority = 2)
	public void VerifyUserCreatedLiabilityCategoryView() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify User Created Liability Category View Executed!");
		int count = 0;
		String str = "";
		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}
			
			// Create page
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
				if(tr==false) {
					count++;
					str = str + "\n" + "User Created Liability Create Icon doesn't display";
					//System.out.println(str);
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" +"User Created Liability Create Icon doesn't found";
			}

			
			//User Created Liability Tab
			try {
				//Total Liability
				String gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Total Liability", "Total Liability Doesn't Match");
				
				//Balance as of
				gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, "Balance as of", "Balance as of Doesn't Match");
				
				
				try {
					SA.assertAll();
				} catch (AssertionError e) {
					
					str = str + "\n" + e;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +e+ "Liability Total Amount and Balance as of Xpath doesn't found";
			}

			try {
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
				if(xyz.size()>0) {
					count++;
					for (int n = 0; n < xyz.size(); n++) {
						str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount.";
					}
				}
			}catch (Exception e) {
				;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Verify User Created Liability Category View");
			M.setStrData("As Expected", "Automation Testcase", 811, 6);
			M.setStrData("Pass", "Automation Testcase", 811, 7);
			
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify User Created Liability Category View");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 811, 6);
			M.setStrData("Fail", "Automation Testcase", 811, 7);
			
		}
		
		ReStart();
	}
	
	
	//Verify Place Holder Text (Add Current Liability)
	//@Test (priority = 3)
	public void VerifyPlaceHolderText_AddCurrentLiability()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Place Holder Text_Add Current Liability Executed!");
		int count=0;
		String str="";
		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}
			
			
			//Go to Current Liability Create page.
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"Current Liability Create icon not found";
				throw new Exception(str);
			}
			
			Thread.sleep(5000);
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 390, 9), "Add Current Liability title text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Current Liability Title doesn't found";
			}
			
			//Verify Task Template
			for(int i=1;i<=7;i++)
			{
				String result=VerifyText(i,390,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 390, 10), "Add Current Liability button text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Current Liability Create Button doesn't found";
			}
			
			// back to Current Liability page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add Current Liability Create Page Back Button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			String result=PageVerification("Add Current Liability");
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
			M.ScreenShots("Screenshot/Passed","Verify Place Holder Text_Add Current Liability"); 
		    M.setStrData("As Expected","Automation Testcase", 812, 6);
			M.setStrData("Pass","Automation Testcase", 812, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Place Holder Text_Add Current Liability");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 812, 6);
			M.setStrData("Fail","Automation Testcase", 812, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
		
	//Verify Disabled Add Current Liability Button (Default & With Blank Field)
	//@Test (priority = 4)
	public void VerifyDisabledAddCurrentLiabilityButton()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Disabled Add Current Liability Button -Default & With Blank Field Executed!");
		int count=0;
		String str="";
		int k=392;
		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}
			
			
			for (int i = 0; i <= 6; i++) {
				boolean tr;
				Thread.sleep(2000);
				//Go to Add Current Liability page.
				try {
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
					Thread.sleep(2000);
				} catch (Exception e) {
					count++;
					str = str + "\n" +"Add Current Liability Create icon not found";
					throw new Exception(str);
				}
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				// Full Field Blank
				if (i == 0) {
					tr =driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Add Current Liability Button is Enable";

					}
					
					i++;
				}
				Thread.sleep(2000);
				if (i != 1) {
					LiabilityType(M.getstring("Automation Test Data", k,1),1);
				}
				if (i != 2) {
					PartyName(M.getstring("Automation Test Data", k,2));
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
						str = str + "\n" + "Liability Type Field is Blank But Add Current Liability Button is Enable";
					else if (i == 2)
						str = str + "\n" + "PartyName Field is Blank But Add Current Liability Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Currency Field is Blank But Add Current Liability Button is Enable";
					else if (i == 4)
						str = str + "\n" + "Liability Amount Field is Blank But Add Current Liability Button is Enable";
					else if (i == 5)
						str = str + "\n" + "BalanceAsOf Field is Blank ButAdd Current Liability Button is Enable";
						
				}else {
					if (i == 5) {
						count++;
						str = str + "\n" + "Remarks Field is not Mandatory field But Add Current Liability Button is Disable";
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
			M.ScreenShots("Screenshot/Passed","Verify Disabled Add Current Liability Button -Default & With Blank Field"); 
		    M.setStrData("As Expected","Automation Testcase", 813, 6);
			M.setStrData("Pass","Automation Testcase", 813, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Disabled Add Current Liability Button -Default & With Blank Field");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 813, 6);
			M.setStrData("Fail","Automation Testcase", 813, 7);
			
			
		}

		ReStart();
	}
	
	
	
 
	 
	//Dismiss Unsaved Data-Add Current Liability (Default & All fields together)
	//@Test(priority = 5)
	public void DismissUnsavedDataDefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-Add Current Liability (Default & All fields together) Executed!");
		int count = 0;
		String str = "";

		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
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
				str = str + "\n" + "Add Current Liability Create icon button doesn't found";
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				//System.out.println("2");
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Add Current Liability Back button doesn't found";
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
				str = str + "\n" + "Add Current Liability Create icon button doesn't found";
			}
			
			Thread.sleep(5000);
			
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,392,i);
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
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 381, 2), M.getstring("Automation Test Data", 381, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify Add Current Liability page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Current Liability']").getText();
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 392, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,392,i);
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
			
			
			String result=PageVerification("Add Current Liability");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data- Add Current Liability Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 814, 6);
			M.setStrData("Pass", "Automation Testcase", 814, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data- Add Current Liability Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 814, 6);
			M.setStrData("Fail", "Automation Testcase", 814, 7);

		}
		ReStart();

	}
	 
		


	//Dismiss Unsaved Data-Add Current Liability (For Each Field)
	//@Test(priority = 6)
	public void DismissUnsavedData_AddCurrentLiability_ForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-Add Current Liability (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		int k=392;
		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 381, 2), M.getstring("Automation Test Data", 381, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",392, i)+ confirmation;
				}				
				
				//Verify Add Current Liability page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Current Liability']").getText();
					
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
				
				
				String result=PageVerification("Add Current Liability");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Add Current Liability (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 815, 6);
			M.setStrData("Pass", "Automation Testcase", 815, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Add Current Liability (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 815, 6);
			M.setStrData("Fail", "Automation Testcase", 815, 7);

		}
		ReStart();
		
	}

	
	
	//Dismiss Selected Value From Dropdown (Add Current Liability)		
	//@Test (priority = 7)
	public void DismissSelectedValueFromDropdown_AddCurrentLiability()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Add Current Liability) Executed!");
		int count=0;
		String str="";
		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			

			
			// Go to Add Current Liability
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
			LiabilityType(M.getstring("Automation Test Data", 392, 1),2);		
			String result = VerifyText(1, 390, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 392, 3),2);		
			result = VerifyText(2, 390, 2);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 392, 5),2);		
			result = VerifyText(4, 390, 4);
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
			result=PageVerification("Add Current Liability");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Add Current Liability)"); 
		    M.setStrData("As Expected","Automation Testcase", 816, 6);
			M.setStrData("Pass","Automation Testcase", 816, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Add Current Liability)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 816, 6);
			M.setStrData("Fail","Automation Testcase", 816, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	

	// Create Current Liability
	// @Test (priority = 8)
	public void CreateCurrentLiability()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Current Liability Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		
		//Go to Current Liability Tab.
		int pass=UserCreateLiability(0);
		if(pass==0) {
			str=str + "\n" +"User Create Liability category not found";
			throw new Exception(str);
		}			
		
		//Collect totall amount Liability.
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
			

		}catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Amount:"+e;
			
		}
		

		try {
			
			//Go to Add Current Liability page.
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
					DataFillUp(i,392,i);
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
				str = str + "\n" + "Create Add Current Liability button not found";
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
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Current Liability']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add Current Liability";
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
					String result = VerifyText(i, 390, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Current Liability, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Add Current Liability");
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
			M.ScreenShots("Screenshot/Passed","Create Current Liability"); 
		    M.setStrData("As Expected","Automation Testcase", 817, 6);
			M.setStrData("Pass","Automation Testcase", 817, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Current Liability");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 817, 6);
			M.setStrData("Fail","Automation Testcase", 817, 7);
			
			
		}
		
	
		ReStart();
	}
	


	
	// Verify Created Current Liability
	// @Test (priority = 9)
	public void VerifyCreateCurrentLiability_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Created Current Liability & Data Executed!");
		String CurrentLiability="";
		String str ="";
		int count=0;
		int j=0;
		int totalLiability=0;
		int subtotal1=0;
		//System.out.println(TotalLiability);
		//System.out.println(subtotal1);
		try {
					
			CurrentLiability = M.getstring("Automation Test Data",392, 1);
			System.out.println(CurrentLiability);
			
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			

			pass=0;
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 396, 7), "Total Liability Amount Doesn't Match");
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

				// Collect Trade Current Liability
				
				collect = driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 396, 7), "Current Liability Amount Doesn't Match");
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

				subtotal1 = Integer.parseInt(collect);

				System.out.println(subtotal1);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when collect Amount:"+e;

			}

			//check calculation
			try {
				
				if(TotalLiability!=totalLiability) {
					int total=totalLiability-TotalLiability;
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",392, 4));
					System.out.println("total"+total);
					if(total!=totaldata) {
						count++;
						str = str + "\n" + "Total Liability Amount not match after add Liability";
					}
					
				}else {
					count++;
					str = str + "\n" + "Liability Amount does not added in Total Liability";
				}				
				
				int carddata=Integer.parseInt(M.getstring("Automation Test Data",392, 4));
				if(subtotal1!=carddata) {
					count++;
					str = str + "\n" + "Trade Current Liability Amount does not match after add Liability";
				}else {
					;
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			FindData(CurrentLiability);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(CurrentLiability)) {
					pass++;
					Thread.sleep(5000);
					j=counting(CurrentLiability, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(CurrentLiability)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 396, 7), "Liability Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Liability Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 396, 8), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 396, 5), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[3]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 396, 2), "Creditor Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Creditor does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 396, 6), "Remarks Doesn't Match");
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
				throw new Exception("Current Liability Liablility didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 396, 9), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 7; i++) {
					String result = VerifyText(i, 396, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 396, 10), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit Current Liability");
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
			
			M.ScreenShots("Screenshot/Passed"," Verify Created Current Liability & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 818, 6);
			M.setStrData("Pass","Automation Testcase",818, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Created Current Liability & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 818, 6);
			M.setStrData("Fail","Automation Testcase", 818, 7);
	
		}
		ReStart();
	}
	
	
	
		
	//Verify Save Changes Button Disabled (Default & With Blank Field)
	//@Test (priority = 10)
	public void VerifySaveChangesButtonDisabled_Default_Blank()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled (Default & With Blank Field) Executed!");
		int count=0;
		int j=0;
		String str="";
		String CurrentLiability = M.getstring("Automation Test Data",392, 1);
		try {
			try {
					
				//Go to Current Liability Tab.
				int pass=UserCreateLiability(0);
				if(pass==0) {
					str=str + "\n" +"User Create Liability category not found";
					throw new Exception(str);
				}			
					
				Thread.sleep(2000);
				FindData(CurrentLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(CurrentLiability)) {
						
						Thread.sleep(5000);
						j=counting(CurrentLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CurrentLiability)) {
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
						str = str + "Default in Edit Current Liability page, Save Changes Button is Enable";

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
					PartyName(M.getstring("Automation Test Data", 392, 2));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtLiabilityAmount").clear();
					driver.hideKeyboard();
					
				}
				if (i == 3) {
					LiabilityAmount(M.getstring("Automation Test Data", 392, 4));
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
						str = str + "\n" + "Party Name Field is Blank But Save Changes Button is Enable";
					if (i == 2)
						str = str + "\n" + "Liability Amount Field is Blank But Save Changes Button is Enable";
					
					
				}else {
					
					if (i == 3)
						str = str + "\n" + "Remarks Field is non-mandatory field But Save Changes Button is Disable";
				}
				

			}
			// back to Current Liability Liablility page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Current Liability Edit Page Back Button doesn't found";
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
			
			String result=PageVerification("Edit Current Liability");
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
		    M.setStrData("As Expected","Automation Testcase", 819, 6);
			M.setStrData("Pass","Automation Testcase", 819, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Save Changes Button Disabled (Default & With Blank Field)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 819, 6);
			M.setStrData("Fail","Automation Testcase", 819, 7);
			
			
		}
		ReStart();
		PageReload();
		
	}
	
	
	
	
	//Verify Save Changes Button Disabled/Enabled (For Each Field)
	//@Test(priority = 11)
	public void VerifySaveChangesButtonDisabledEnabled() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled/Enabled (For Each Field) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String CurrentLiability = M.getstring("Automation Test Data",392, 1);
		
		try {		
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			
			
			for(int i=1;i<=6;i++){
				
				try {
					Thread.sleep(2000);
					FindData(CurrentLiability);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(CurrentLiability)) {
							
							Thread.sleep(5000);
							j=counting(CurrentLiability, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(CurrentLiability)) {
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
					DataFillUp(i,394,i);
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
						str = str + "\n" + "Party Name field is modify but Save Change button is disable";
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
				
				String result=PageVerification("Edit Current Liability");
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
			M.setStrData("As Expected", "Automation Testcase", 820, 6);
			M.setStrData("Pass", "Automation Testcase", 820, 7);	

		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Save Changes Button Disabled/Enabled(For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 820, 6);
			M.setStrData("Fail", "Automation Testcase", 820, 7);

		}
		ReStart();
		
	}
	
	
	
	 
	//Dismiss Unsaved Data-Edit Current Liability (Default & All fields together)
	//@Test(priority = 12)
	public void DismissUnsavedData_EditCurrentLiability_DefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-EditCurrent Liability(Default & All fields together) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String CurrentLiability = M.getstring("Automation Test Data",392, 1);

		try {
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				FindData(CurrentLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(CurrentLiability)) {
						
						Thread.sleep(5000);
						j=counting(CurrentLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CurrentLiability)) {
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
			
			//verify Edit Current Liability page 
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
				FindData(CurrentLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(CurrentLiability)) {
						
						Thread.sleep(5000);
						j=counting(CurrentLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CurrentLiability)) {
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
					DataFillUp(i,394,i);
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
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 381, 2), M.getstring("Automation Test Data", 381, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify  Edit Current Liability page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Current Liability']").getText();
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 398, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,394,i);
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
			
			
			String result=PageVerification("Edit Current Liability");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Current Liability Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 821, 6);
			M.setStrData("Pass", "Automation Testcase", 821, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Current Liability Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 821, 6);
			M.setStrData("Fail", "Automation Testcase", 821, 7);

		}
		ReStart();

	}
	 

	

	//Dismiss Unsaved Data-Edit Current Liability  (For Each Field)
	//@Test(priority = 13)
	public void DismissUnsavedDataForEachField_EditLCLiabilty() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Edit Current Liability(For Each Field) Executed!");
		int count = 0;
		int back = 0;
		int j=0;
		String str="";
		String CurrentLiability = M.getstring("Automation Test Data",392, 1);
		int k=394;
		try {
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			
			
			for(int i=1;i<=6;i++){
				Thread.sleep(2000);
				//Go to Edit Current Liability page
				try {
					Thread.sleep(2000);
					FindData(CurrentLiability);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int n = 0; n < xyz.size(); n++) {
						if (xyz.get(n).getText().contains(CurrentLiability)) {
							
							Thread.sleep(5000);
							j=counting(CurrentLiability, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(CurrentLiability)) {
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 381, 2), M.getstring("Automation Test Data", 381, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",394, i)+ confirmation;
				}				
				
				//Verify Add Current Liability Liablility page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Current Liability']").getText();
					
					try {
						String result= VerifyText(i, 398, i);
						
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
					
					
					String result=PageVerification("Edit Current Liability");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Current Liability (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 822, 6);
			M.setStrData("Pass", "Automation Testcase", 822, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Current Liability (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 822, 6);
			M.setStrData("Fail", "Automation Testcase", 822, 7);

		}
		ReStart();
		
	}

	
	

	
	// Dismiss Selected Value From Dropdown (Edit Current Liability)		
	// @Test (priority = 14)
	public void DismissSelectedValueFromDropdown_EditLCLiability()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Edit Current Liability) Executed!");
		int count=0;
		int j=0;
		String str="";
		String CurrentLiability = M.getstring("Automation Test Data",392, 1);

		try {
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			
			
			// Go to Edit Current Liability
			try {
				Thread.sleep(2000);
				FindData(CurrentLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(CurrentLiability)) {
						
						Thread.sleep(5000);
						j=counting(CurrentLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CurrentLiability)) {
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
			LiabilityType(M.getstring("Automation Test Data", 394, 1),2);		
			String result = VerifyText(1, 392, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}	

			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 394, 3),2);		
			result = VerifyText(3, 392, 3);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 394, 5),2);		
			result = VerifyText(5, 392, 5);
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
			result=PageVerification("Edit Current Liability");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Edit Current Liability)"); 
		    M.setStrData("As Expected","Automation Testcase", 823, 6);
			M.setStrData("Pass","Automation Testcase", 823, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Edit Current Liability)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 823, 6);
			M.setStrData("Fail","Automation Testcase", 823, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	

	// Update Current Liability Liablility
	//@Test (priority = 15)
	public void UpdateLCLiability()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update Current Liability Liablility Executed!");
		int count = 0;
		int j=0;
		String str="";
		String CurrentLiability = M.getstring("Automation Test Data",392, 1);

		String successful = "";
		
		//Go to Current Liability Tab.
		int pass=UserCreateLiability(0);
		if(pass==0) {
			str=str + "\n" +"User Create Liability category not found";
			throw new Exception(str);
		}			
		
		//Collect Amount...
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

			Subtotal1 = Integer.parseInt(collect);

			System.out.println(Subtotal1);

		} catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Amount:"+e;

		}
		
		try {
			
			//Go to Edit Current Liability page.
			try {
				Thread.sleep(2000);
				FindData(CurrentLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(CurrentLiability)) {
						
						Thread.sleep(5000);
						j=counting(CurrentLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CurrentLiability)) {
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
					DataFillUp(i,394,i);
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
				str = str + "\n" + "Create Add Current Liability Liablility button not found";
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Current Liability']").getText();
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
					str = str + "\n" + "After sucessful message OK, Edit Current Liability page not found and it redirect to Company Liabilities page.";
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
					String result = VerifyText(i, 390, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After Update Current Liability Liablility, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Edit Current Liability");
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
			M.ScreenShots("Screenshot/Passed","Update Current Liability Liablility"); 
		    M.setStrData("As Expected","Automation Testcase", 824, 6);
			M.setStrData("Pass","Automation Testcase", 824, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Current Liability Liablility");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 824, 6);
			M.setStrData("Fail","Automation Testcase", 824, 7);
			
			
		}
		
		
		ReStart();
	}

	

	
	
	// Verify Update Current Liability Liablility
	//@Test (priority = 16)
	public void VerifyUpdateCurrentLiability_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Current Liability Liablility & Data Executed!");
		String CurrentLiability =M.getstring("Automation Test Data",394, 1);
		String str ="";
		int count=0;
		int pass=0;
		int j=0;
		int totalLiability=0;
		int subtotal1=0;
		
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			//Go to Current Liability Tab.
			pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			

			Thread.sleep(5000);
			//Collect Amount...
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 399, 7), "Total Liability Amount Doesn't Match");
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

				// Collect Trade Current Liability
				
				collect = driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 399, 7), "Current Liability Amount Doesn't Match");
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

				subtotal1 = Integer.parseInt(collect);

				System.out.println(subtotal1);


			} catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when collect Amount:"+e;

			}

			//check calculation
			try {
				
				if(TotalLiability!=totalLiability) {
					//int total=totalLiability-TotalLiability;
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",399, 4));
					//System.out.println("total"+total);
					if(totalLiability!=totaldata) {
						count++;
						str = str + "\n" + "Total Liability Amount not match after add Liability";
					}
					
				}else {
					count++;
					str = str + "\n" + "Liability Amount does not added in Total Liability";
				}
				if(subtotal1!=Subtotal1) {
					//int card=subtotal1-Subtotal1;
					int carddata=Integer.parseInt(M.getstring("Automation Test Data",399, 4));
					//System.out.println("card"+card);
					if(subtotal1!=carddata) {
						count++;
						str = str + "\n" + "Sale taxes payable Amount does not match after add Liability";
					}
					
				}else {
					count++;
					str = str + "\n" + "Liability Amount does not added in Sale taxes payable Liability";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			

			
			
			pass=0;
			Thread.sleep(2000);
			FindData(CurrentLiability);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(CurrentLiability)) {
					pass++;
					Thread.sleep(5000);
					j=counting(CurrentLiability, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(CurrentLiability)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 398, 7), "Liability Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Liability Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 398, 8), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 398, 5), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[3]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 398, 2), "Bank Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Bank does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 398, 6), "Remarks Doesn't Match");
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 398, 9), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 398, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 398, 10), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit Current Liability");
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
			
			M.ScreenShots("Screenshot/Passed"," Verify Edit Current Liability & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 825, 6);
			M.setStrData("Pass","Automation Testcase", 825, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Edit Current Liability & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 825, 6);
			M.setStrData("Fail","Automation Testcase", 825, 7);
	
		}
		ReStart();
	}
	
	

	

	// Delete & Verify Deleted Current Liability Liablility
	//@Test(priority = 17)
	public void Delete_VerifyDeletedCurrentLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete & Verify Deleted Current Liability Liablility Executed!");
		String CurrentLiability =M.getstring("Automation Test Data",394, 1);
		String str ="";
		int count=0;
		int j=0;
		try {
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			


			
			//Swip the card
			try {
				Thread.sleep(2000);
				FindData(CurrentLiability);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(CurrentLiability)) {
						
						Thread.sleep(5000);
						j=counting(CurrentLiability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(CurrentLiability)) {
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
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();
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
					str = str + "\n" + "After Delete Warning message no, Current Liability Liablility card doesn't close";

				} catch (Exception e) {
					try {
						Thread.sleep(2000);
						int x=FindData(CurrentLiability);
						Thread.sleep(2000);
						if(x==0) {
							count++;
							str = str + "\n" + "After click Delete warning message No,Current Liability Liablility Card Delete ";
							throw new Exception(str);
						}
						//Swip the card
						try {
							
							List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
							String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
							String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
							for (int n = 0; n < xyz.size(); n++) {
								if (xyz.get(n).getText().contains(CurrentLiability)) {
									
									Thread.sleep(5000);
									j=counting(CurrentLiability, str1, str2);
									//System.out.println(j);
									try {
										String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
										if(gettext.contentEquals(CurrentLiability)) {
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
					int x=FindData(CurrentLiability);
					Thread.sleep(2000);
					if(x==1) {
						count++;
						str = str + "\n" + "After Sucessfully Delete, Current Liability Liablility card doesn't Delete ";
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
			M.ScreenShots("Screenshot/Passed", "Delete & Verify Deleted Current Liability Liablility");
			M.setStrData("As Expected", "Automation Testcase", 826, 6);
			M.setStrData("Pass", "Automation Testcase", 826, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete & Verify Deleted Current Liability Liablility");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 826, 6);
			M.setStrData("Fail", "Automation Testcase", 826, 7);

		}
		PageReload();
		ReStart();
	}
	
	



	// Verify Liability Type- Others (Positive)
	//@Test (priority = 18)
	public void VerifyLiabilityType_Others_Positive()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Liability Type- Others (Positive) Executed!");
		int count = 0;
		int k = 405;
		String str = "";
		String successful = "";
		int totalLiability=0;
		
		

		try {
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			
			
			Thread.sleep(5000);
			for(int j=1;j<=5;j++) {
				//Collect totall amount Liability.
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
					//System.out.println(TotalLiability);
					

				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount:"+e;
					
				}
				
				
				//Go to Add Current Liability page.
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
						DataFillUp(i,k,i);
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
					str = str + "\n" + "Create Add Current Liability button not found";
				}
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
				

				String result=PageVerification("Add Current Liability");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
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

					totalLiability = Integer.parseInt(collect);
					//System.out.println(totalLiability);

					

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount After Create:"+e;

				}
				
				//check calculation
				try {
					
					if(TotalLiability!=totalLiability) {
						int total=totalLiability-TotalLiability;
						int totaldata=Integer.parseInt(M.getstring("Automation Test Data",k, 4));
						//System.out.println("total"+total);
						if(total!=totaldata) {
							count++;
							str = str + "\n" + "Total Liability Amount not match after add:- "+M.getstring("Automation Test Data",k, 1);
						}
						
					}else {
						count++;
						str = str + "\n" + "Liability Amount does not added in Total Liability when added:- "+M.getstring("Automation Test Data",k, 1);
					}				
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Amount:"+e;

				}

				k--;
				
				
				try {
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
					if(xyz.size()>0) {							
						for (int n = 0; n < xyz.size(); n++) {
							if(j==1) {
								if (xyz.get(n).getText().matches("Interest Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After create-Interest Payable Liability Types.";
								}
							}
							if(j==2) {
								if (xyz.get(n).getText().matches("Interest Payable||Income Taxes Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After create-Interest Payable Liability,Income Taxes Payable Types.";
								}
							}
							if(j==3) {
								if (xyz.get(n).getText().matches("Interest Payable||Income Taxes Payable||Account Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After create-Interest Payable Liability,Income Taxes Payable,Account Payable Types.";
								}
							}
							if(j==4) {
								if (xyz.get(n).getText().matches("Interest Payable||Income Taxes Payable||Account Payable||Sale Taxes Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After create-Interest Payable Liability,Income Taxes Payable,Account Payable,Sale Taxes Payable Types.";
								}
							}
							if(j==5) {
								if (xyz.get(n).getText().matches("Interest Payable||Income Taxes Payable||Account Payable||Sale Taxes Payable||Others")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After create-Interest Payable Liability,Income Taxes Payable,Account Payable,Sale Taxes Payable Types,Payroll Taxes Payable.";
								}
							}
							
							
						}
					}
				}catch (Exception e) {
					;
				}

			}
			
			//Check Sequence in BreakDown Liability
			try { 
				//Interest Payable Liability Amount
				String LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 405, 1), "Interest Payable Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 405, 7), "Interest Payable Liability Amount Doesn't Match");
				
				//Income Taxes Payable Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 404, 1), "Income Taxes Payable Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 404, 7), "Income Taxes Payable Liability Amount Doesn't Match");
				
				//Account Payable Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 403, 1), "Account Payable Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 403, 7), "Account Payable Liability Amount Doesn't Match");
			
				
				//Sale Taxes Payable Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 402, 1), "Sale Taxes Payable Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 402, 7), "Sale Taxes Payable Liability Amount Doesn't Match");
				
				
				//Others Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, "Others", "Others Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 401, 7), "Others Liability Amount Doesn't Match");
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + e;
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
			M.ScreenShots("Screenshot/Passed","Verify Liability Type- Others (Positive)"); 
		    M.setStrData("As Expected","Automation Testcase", 827, 6);
			M.setStrData("Pass","Automation Testcase", 827, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Liability Type- Others (Positive)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 827, 6);
			M.setStrData("Fail","Automation Testcase", 827, 7);
			
			
		}
		
	
		ReStart();
	}
	

	
	
	// Edit Lowest to highest and highest to lowest liability and verify breakdown Liability alter with other.
	//@Test (priority = 19)
	public void EditLowestToHighestAndHighestToLowestLiability()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Edit Lowest to highest and highest to lowest liability Executed!");
		int count = 0;
		int k = 0;
		int j = 0;
		String LiabilityAmount ="";
		String str = "";
		String Liability = "";
		int totalLiability=0;
		
		//Go to Current Liability Tab.
		int pass=UserCreateLiability(0);
		if(pass==0) {
			str=str + "\n" +"User Create Liability category not found";
			throw new Exception(str);
		}			

		try {
	
			//Lowest amount change to highest
			try {
				Liability = M.getstring("Automation Test Data",401, 1);
				//Swip the card
				try {
					Thread.sleep(2000);
					FindData(Liability);
					Thread.sleep(2000);
					DataUp(Liability);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int n = 0; n < xyz.size(); n++) {
						if (xyz.get(n).getText().contains(Liability)) {
							
							Thread.sleep(5000);
							j=counting(Liability, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Liability)) {
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
				
				
				//update amount
				LiabilityAmount(M.getstring("Automation Test Data",401, 8));
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Add Current Liability button not found";
				}
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
				

				String result=PageVerification("Add Current Liability");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
				}
				
				Thread.sleep(5000);
				M.ScrollUpMinor(3);
				//Others Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 402, 7), "Others Liability Amount Doesn't Match After change Lowest value to highest value");
				
				pass=0;
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
				for(int p=0;p<xyz.size();p++) {
					if (xyz.get(p).getText().contains("Sale Taxes Payable")) {
						count++;
						str = str + "\n" +"Sale Taxes Payable should be invisible after edit Payroll Taxes Payable Amount by higher value.";
					}else if(xyz.get(p).getText().contains("Payroll Taxes Payable")) {
						pass++;
					}
					
				}
				
				if(pass==0) {
					count++;
					str = str + "\n" +"Payroll Taxes Payable not found, it should be visible in breakdown total liability after edit by higher value.";
				}
				
				

			}catch(Exception e) {
				throw new Exception("Error found when change Liability amount Low to High:- "+e);
			}
			
			
			//Highest amount change to Lowest
			try {
				Liability = M.getstring("Automation Test Data",405, 1);
				//Swip the card
				try {
					Thread.sleep(2000);
					FindData(Liability);
					Thread.sleep(2000);
					DataUp(Liability);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int n = 0; n < xyz.size(); n++) {
						if (xyz.get(n).getText().contains(Liability)) {
							
							Thread.sleep(5000);
							j=counting(Liability, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Liability)) {
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
				
				
				//update amount
				LiabilityAmount(M.getstring("Automation Test Data",405, 8));
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Add Current Liability button not found";
				}
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
				
				
				String result=PageVerification("Add Current Liability");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
				}
				
				Thread.sleep(5000);
				M.ScrollUpMinor(3);
				//Others Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 405, 9), "Others Liability Amount Doesn't Match After change highest value to Lowest value");
				
				pass=0;
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
				for(int p=0;p<xyz.size();p++) {
					if (xyz.get(p).getText().contains("Interest Payable")) {
						count++;
						str = str + "\n" +"Interest Payable should be invisible after edit Amount by lowest value.";
					}else if(xyz.get(p).getText().contains("Sale Taxes Payable")) {
						pass++;
					}
					
				}
				
				if(pass==0) {
					count++;
					str = str + "\n" +"Sale Taxes Payable not found, it should be visible in breakdown total liability after edit Interest Payable Amount by lowest value.";
				}
	
				
			}catch(Exception e) {
				throw new Exception("Error found when change Liability amount High to low:- "+e);
			}
/*
			try {
				List<AndroidElement> xyz1 =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilitiesAmount");
				for(int p=0;p<xyz.size();p++) {
					
					String collect = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilitiesAmount").get(p).getText();
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
					
					for(int l=p;l<xyz.size();l++) {
						collect = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilitiesAmount").get(l).getText();
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

						Subtotal1 = Integer.parseInt(collect);
						System.out.println(Subtotal1);
						
						if(Subtotal1>TotalLiability) {
							count++;
							str = str + "\n" +"Liability Types are not update Sequencially: "+xyz1.get(l).getText()+" value is greater than "+xyz.get(p).getText()+ " ,which should be lower.";
						}
						
						
					}

				}
			} catch(Exception e) {
				count++;
				str = str + "\n" + e;
			}
*/			
			
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
			M.ScreenShots("Screenshot/Passed","Edit Lowest to highest and highest to lowest liability"); 
			M.setStrData("As Expected","Automation Testcase", 828, 6);
			M.setStrData("Pass","Automation Testcase", 828, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Edit Lowest to highest and highest to lowest liability");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 828, 6);
			M.setStrData("Fail","Automation Testcase", 828, 7);

		}
		
		
		ReStart();
	}
	
	

	
	// Delete card and verify field is invisible
	//@Test (priority = 20)
	public void DeleteCardAndVerifyFieldIsInvisible()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete card and verify field is invisible Executed!");
		int count = 0;
		int k=405;
		int j = 0;
		String str = "";
		String Liability = "";
		
		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			

			
			//Delete card and verify field is invisible or not
			
			for(int l=1;l<=5;l++) {
				
				Liability = M.getstring("Automation Test Data",k, 1);
				k--;
				//Swip the card
				try {
					Thread.sleep(2000);
					FindData(Liability);
					Thread.sleep(2000);
					DataUp(Liability);
					//System.out.println("ok");
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
					for (int n = 0; n < xyz.size(); n++) {
						if (xyz.get(n).getText().contains(Liability)) {
							
							Thread.sleep(5000);
							j=counting(Liability, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(Liability)) {
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
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				}catch (Exception e) {
					throw new Exception("Error occures when card swip");
				}
				
				//warnign message yes
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}catch(Exception e) {
					;
				}
				
				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 385, 4),M.getstring("Automation Test Data", 385, 5));
				
				//check field is invisible or not
				try {
					Thread.sleep(5000);
					M.ScrollUpMinor(3);
					Thread.sleep(5000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
					if(xyz.size()>0) {							
						for (int n = 0; n < xyz.size(); n++) {
							if(l==1) {
								if (xyz.get(n).getText().matches("Payroll Taxes Payable||Income Taxes Payable||Account Payable||Sale Taxes Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After Delete-Interest Payable Liability Types.";
								}
							}
							if(l==2) {
								if (xyz.get(n).getText().matches("Payroll Taxes Payable||Account Payable||Sale Taxes Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After Delete-Interest Payable Liability,Income Taxes Payable Types.";
								}
							}
							if(l==3) {
								if (xyz.get(n).getText().matches("Payroll Taxes Payable||Sale Taxes Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After Delete-Interest Payable Liability,Income Taxes Payable,Account Payable Types.";
								}
							}
							if(l==4) {
								if (xyz.get(n).getText().matches("Payroll Taxes Payable")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After Delete-Interest Payable Liability,Income Taxes Payable,Account Payable,Sale Taxes Payable Types.";
								}
							}
							if(l==5) {
								
								if (xyz.get(n).getText().matches("Null")) {
									;
								}else {
									count++;
									str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After Delete-Interest Payable Liability,Income Taxes Payable,Account Payable,Sale Taxes Payable Types,Payroll Taxes Payable Types.";
								}
							}
							
							
						}
					}
				}catch (Exception e) {
					;
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
			M.ScreenShots("Screenshot/Passed","Delete card and verify field is invisible or not"); 
			M.setStrData("As Expected","Automation Testcase", 829, 6);
			M.setStrData("Pass","Automation Testcase", 829, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Delete card and verify field is invisible or not");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 829, 6);
			M.setStrData("Fail","Automation Testcase", 829, 7);
			
		}
		
		
		ReStart();
	}
	
	


	// Added Liability Lower value to Higher and verify others field value alter with higher
	//@Test (priority = 21)
	public void AddLiability_Lowervalue_To_Higher_And_verify_others_field_value()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Liability Type- Others (Positive) Executed!");
		int count = 0;
		int k = 401;
		String str = "";
		String successful = "";
		int totalLiability=0;

		try {
			
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			
			
			Thread.sleep(5000);
			for(int j=1;j<=6;j++) {
				
				//Go to Add Current Liability page.
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
						DataFillUp(i,k,i);
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
					str = str + "\n" + "Create Add Current Liability button not found";
				}
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 305, 2), M.getstring("Automation Test Data", 305, 3));
				

				String result=PageVerification("Add Current Liability");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
				}
				
				k++;
				
				if(j>4) {
					
					//check which liablity type added in others
					try {
						Thread.sleep(5000);
						M.ScrollUpMinor(3);
						Thread.sleep(5000);
						pass=0;
						List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
						if(xyz.size()>0) {							
							for (int n = 0; n < xyz.size(); n++) {
								if(j==5) {
									if (xyz.get(n).getText().matches("Interest Payable||Income Taxes Payable||Account Payable||Sale Taxes Payable||Others")) {
										;
									}else {
										count++;
										str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount where it should be Alter with Interest Payable and it should be added in Others field";
									}
									if(pass==0) {
										pass++;
										//Others Liability Amount
										String LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
										SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 401, 7), "Others Liability Amount Doesn't Match it should be found Payroll Taxes Payable liability amount.");									
									
									}
								}
								
								if(j==6) {
									if (xyz.get(n).getText().matches("Interest Payable||Income Taxes Payable||Account Payable||Customer Deposits||Others")) {
										;
									}else {
										count++;
										str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount where it should be Alter with Customer Deposits and it should be added in Others field";
									}
									
									//Others Liability Amount
									if(pass==0) {
										pass++;
										String LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
										SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 402, 8), "Others Liability Amount Doesn't Match it should be found Payroll Taxes Payable value plus Sale Taxes Payable value.");
										
									}
									
								}
								
							}
						}
					}catch (Exception e) {
						;
					}

					
				}
			}
	
			//Check Sequence in BreakDown Liability
			try { 
				//Interest Payable Liability Amount
				String LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 406, 1), "Customer Deposits Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 406, 7), "Customer Deposits Liability Amount Doesn't Match");
				
				//Income Taxes Payable Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 405, 1), "Interest Payable Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 405, 7), "Interest Payable Liability Amount Doesn't Match");
				
				//Account Payable Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 404, 1), "Income Taxes Payable Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 404, 7), "Income Taxes Payable Liability Amount Doesn't Match");
			
				
				//Sale Taxes Payable Liability Amount
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 403, 1), "Account Payable Breakdown Lebel Doesn't Match");
				LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 403, 7), "Account Payable Liability Amount Doesn't Match");

			}catch(Exception e) {
				count++;
				str = str + "\n" + e;
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
			M.ScreenShots("Screenshot/Passed","Verify Liability Type- Others (Positive)"); 
		    M.setStrData("As Expected","Automation Testcase", 830, 6);
			M.setStrData("Pass","Automation Testcase", 830, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Liability Type- Others (Positive)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 830, 6);
			M.setStrData("Fail","Automation Testcase", 830, 7);
			
			
		}
		
	
		ReStart();
	}
	
	
	
		
	

	
	// Delete card and verify field is invisible
	//@Test (priority = 22)
	public void DeletelargestCardAndVerifyAddLiabilityInBreakdownTotal()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete card and verify field is invisible Executed!");
		int count = 0;
		int k=404;
		int j = 0;
		String str = "";
		String Liability = "";
		
		try {
			//Go to Current Liability Tab.
			int pass=UserCreateLiability(0);
			if(pass==0) {
				str=str + "\n" +"User Create Liability category not found";
				throw new Exception(str);
			}			

			
			//Delete card and verify field is invisible or not
			Liability = M.getstring("Automation Test Data",k, 1);
			
			//Swip the card
			try {
				Thread.sleep(2000);
				FindData(Liability);
				Thread.sleep(2000);
				DataUp(Liability);
				//System.out.println("ok");
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtLiabilityType";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtBalanceAsOf";
				for (int n = 0; n < xyz.size(); n++) {
					if (xyz.get(n).getText().contains(Liability)) {
						
						Thread.sleep(5000);
						j=counting(Liability, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(Liability)) {
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
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				throw new Exception("Error occures when card swip");
			}
			
			//warnign message yes
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch(Exception e) {
				;
			}
			
			// Sucessfull Message..
			Thread.sleep(2000);
			String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 385, 4),M.getstring("Automation Test Data", 385, 5));
			

			
			
			//check field is alter or not.
			try {
				Thread.sleep(5000);
				M.ScrollUpMinor(3);
				Thread.sleep(5000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtLcLiabilities");
				if(xyz.size()>0) {							
					for (int n = 0; n < xyz.size(); n++) {
						if (xyz.get(n).getText().matches("Interest Payable||Customer Deposits||Account Payable||Sale Taxes Payable||Others")) {
							;
						}else {
							count++;
							str = str + "\n" +xyz.get(n).getText()+ ": Found as a breakdown of the total liability amount After Delete-Income Taxes Payable Types.";
							str = str + "\n" +"But should found only Interest Payable||Customer Deposits||Account Payable||Sale Taxes Payable in BreakDown list";
						}
	
					}
				}
				
				//Others Liability Amount
				String LiabilityAmount= driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
				SA.assertEquals(LiabilityAmount, M.getstring("Automation Test Data", 401, 7), "Others Liability Amount Doesn't Match it should be found Payroll Taxes Payable liability amount after Delete.");

			}catch (Exception e) {
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
			M.ScreenShots("Screenshot/Passed","Delete card and verify field is invisible or not"); 
			M.setStrData("As Expected","Automation Testcase", 831, 6);
			M.setStrData("Pass","Automation Testcase", 831, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Delete card and verify field is invisible or not");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 831, 6);
			M.setStrData("Fail","Automation Testcase", 831, 7);
			
		}
		
		
		ReStart();
	}
	
	




}
