package com.cslsoft.KandareeLiteTestCase;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class CompanyMarginAccountAsset extends BaseClass {
	
	int TotalValue=0; 
	
	
	@Test(priority = 0)
	public void Nevigate() throws InterruptedException, IOException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//UserCreateLiability(1);
		
		driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Margin Account\"]/android.widget.TextView").click();
		Thread.sleep(1000);
		
		System.out.println("Navigate Hamburgare to Company Assets!");

	}
	
	
	//Reload.
	public void PageReload() throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Margin Account\"]/android.widget.TextView").click();
			Thread.sleep(1000);

		} catch (Exception e) {
			;

		}

		
		
	}
	
	
	//ReStart
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
			
			Boolean tr=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Margin Account\"]/android.widget.TextView").isSelected();
			if(tr==false) {
				System.out.println("Expected Tab Not Selected");
				
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
		    
		    driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Margin Account\"]/android.widget.TextView").click();
			Thread.sleep(1000);
			Thread.sleep(5000);
			
		}
		
	}

	
	//Find Data
	public int FindData(String text) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int pass=0;
		try {
			Thread.sleep(2000);
			for(int i=0;i<10;i++) {
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
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
	
	
	
	//DataUp
	private void DataUp(String data) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
		for (j = 0; j < xyz.size(); j++) {
			if (xyz.get(j).getText().contains(data)) {
				if (j >= 3) {
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

	
	
	//PageVerification
	public String PageVerification(String text) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		String str="";
		try {
			Thread.sleep(100);
			String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
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

	
		
	
	//Bank
	public void Bank(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectBank").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	//Account Number
	public void AccountNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}


	//Account Type
	public void AccountType(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").sendKeys(text);
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
	
	
	//Asset value
	public void Assetvalue(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").sendKeys(text);
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
			Bank(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 2) 
			AccountNumber(M.getstring("Automation Test Data", j, k));
		
		if (i == 3) 
			AccountType(M.getstring("Automation Test Data", j, k));
		
		if (i == 4) 
			Currency(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 5) 
			Assetvalue(M.getstring("Automation Test Data", j, k));
		
		if (i == 6) 
			BalanceAsOf(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 7) 
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
			//Bank
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtBank").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Bank Name Doesn't Match");
		}
		
		if(i==2) {
			//AccountNumber
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Account Number Doesn't Match");
		}
		
		if(i==3) {
			//AccountType
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Account Type Doesn't Match");
		}
		if(i==4) {
			//Currency
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Currency Doesn't Match");
		}
		if(i==5) {
			//Assetvalue
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Asset value Doesn't Match");
		}

		if(i==6) {
			//BalanceAsOf
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtBalanceAsOf").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "BalanceAsOf Doesn't Match");
		}
		if(i==7) {
			//Remarks
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Remarks Doesn't Match");
		}
		if(i==8) {
			//CreatedBy
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCreatedBy").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 468, 8), "CreatedBy Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}
	
	
	
	
	//Verify Place Holder Text (Add Margin Account Asset)
	//@Test (priority = 1)
	public void VerifyPlaceHolderText_AddMarginAccountAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Place Holder Text_Add Margin Account Asset Executed!");
		int count=0;
		String str="";
		try {
			//Go to Margin Account Asset Create page.
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
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 468, 9), "Add Margin Account Asset title text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Margin Account Asset Title doesn't found";
			}
			
			//Verify Task Template
			for(int i=1;i<=8;i++)
			{
				String result=VerifyText(i,468,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 468, 10), "Add Margin Account Asset button text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Margin Account Asset Create Button doesn't found";
			}
			
			// back to Bank Tab
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add Margin Account Asset Create Page Back Button doesn't found";
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
			M.ScreenShots("Screenshot/Passed","Verify Place Holder Text_Add Margin Account Asset"); 
		    M.setStrData("As Expected","Automation Testcase", 901, 6);
			M.setStrData("Pass","Automation Testcase", 901, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Place Holder Text_Add Margin Account Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 901, 6);
			M.setStrData("Fail","Automation Testcase", 901, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	
	//Verify Disabled Add Asset Button (Default & With Blank Field)
	//@Test (priority = 2)
	public void VerifyDisabledAddAssetButton()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Disabled Add Asset Button -Default & With Blank Field Executed!");
		int count=0;
		String str="";
		int k=470;
		try {
			for (int i = 0; i <= 7; i++) {
				boolean tr;
				
				//Go to Add Margin Account Asset page.
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
						str = str + "All Fields are Blank But Add Asset Button is Enable";
					}
					
					i++;
				}
				Thread.sleep(2000);
				if (i != 1) {
					Bank(M.getstring("Automation Test Data", k,1),1);
				}
				if (i != 2) {
					AccountNumber(M.getstring("Automation Test Data", k,2));
				}
				if (i != 3) {
					AccountType(M.getstring("Automation Test Data", k,3));
				}
				if (i != 4) {
					Currency(M.getstring("Automation Test Data", k,4),1);
				}
				if (i != 5) {
					Assetvalue(M.getstring("Automation Test Data", k,5));
				}
				if (i != 6) {
					BalanceAsOf(M.getstring("Automation Test Data", k,6),1);
				}
				if (i != 7) {
					Remarks(M.getstring("Automation Test Data", k,7));
				}
				Thread.sleep(2000);

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Bank Field is Blank But Add Asset Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Account Number Field is Blank But Add Asset Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Account Type Field is Blank But Add Asset Button is Enable";
					else if (i == 4)
						str = str + "\n" + "Currency Field is Blank But Add Asset Button is Enable";
					else if (i == 5)
						str = str + "\n" + "Asset Value Field is Blank But Add Asset Button is Enable";
					else if (i == 6)
						str = str + "\n" + "BalanceAsOf Field is Blank But Add Asset Button is Enable";
					
				}else {
					if (i == 7) {
						count++;
						str = str + "\n" + "Remarks Field is not Mandatory field But Add Asset Button is Disable";
					}
				}
				if (i != 8) {
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
					//PageReload();
				}
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Disabled Add Asset Button -Default & With Blank Field"); 
		    M.setStrData("As Expected","Automation Testcase", 902, 6);
			M.setStrData("Pass","Automation Testcase", 902, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Disabled Add Asset Button -Default & With Blank Field");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 902, 6);
			M.setStrData("Fail","Automation Testcase", 902, 7);
			
			
		}

		ReStart();
	}
	
	
	
	
	 
	//Dismiss Unsaved Data-Add Margin Account Asset (Default & All fields together)
	//@Test(priority = 3)
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
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
			
			for(int i=1;i<=7;i++) {
				try {
					DataFillUp(i,470,i);
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
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 432, 2), M.getstring("Automation Test Data", 432, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify Add Margin Account Asset page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Margin Account Assets']").getText();
				
				try {
					for(int i=1;i<=7;i++)
					{
						String result= VerifyText(i, 472, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,470,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Company Assets page";
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
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work, so that Company Assets page not found.";
				throw new Exception(str);
			}
			
			 
			String result=PageVerification("Add Margin Account Assets");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data- Add Margin Account Asset Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 903, 6);
			M.setStrData("Pass", "Automation Testcase", 903, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data- Add Margin Account Asset Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 903, 6);
			M.setStrData("Fail", "Automation Testcase", 903, 7);

		}
		ReStart();
		PageReload();
	}
	 


	
	
	//Dismiss Unsaved Data-Add Margin Account Asset  (For Each Field)
	//@Test(priority = 4)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		int k=470;
		try {
			
			for(int i=1;i<=7;i++){
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 432, 2), M.getstring("Automation Test Data", 432, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",470, i)+ confirmation;
				}				
				
				//Verify Add Margin Account Asset page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Margin Account Assets']").getText();
					
					try {
						String result= VerifyText(i, 472, i);
						
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
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
					
					str = str + "\n" + "After click Back button and warning message no, Page Redirect to Company Assets page";
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
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
				}catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
					throw new Exception(str);
				}
				
				
				String result=PageVerification("Add Margin Account Assets");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Add Margin Account Asset (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 904, 6);
			M.setStrData("Pass", "Automation Testcase", 904, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Add Margin Account Asset (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 904, 6);
			M.setStrData("Fail", "Automation Testcase", 904, 7);

		}
		ReStart();
		PageReload();
	}


	
	
	//Dismiss Selected Value From Dropdown (Add Margin Account Asset)		
	//@Test (priority = 5)
	public void DismissSelectedValueFromDropdown_AddMarginAccountAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Add Margin Account Asset) Executed!");
		int count=0;
		String str="";
		try {
			// Go to Add Margin Account Asset
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			
			// check Bank Type Dropdown
			Bank(M.getstring("Automation Test Data", 470, 1),2);		
			String result = VerifyText(1, 468, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 470, 4),2);		
			result = VerifyText(4, 468, 4);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 470, 6),2);		
			result = VerifyText(6, 468, 6);
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
			result=PageVerification("Add Margin Account Assets");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Add Margin Account Asset)"); 
		    M.setStrData("As Expected","Automation Testcase", 905, 6);
			M.setStrData("Pass","Automation Testcase", 905, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Add Margin Account Asset)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 905, 6);
			M.setStrData("Fail","Automation Testcase", 905, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	// Create Margin Account Asset
	//@Test (priority = 6)
	public void CreateMarginAccountAsset()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Margin Account Asset Executed!");
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

			TotalValue = Integer.parseInt(collect);
			System.out.println(TotalValue);

		} catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Total Values:"+e;

		}
		
		try {
			
			//Go to Add Margin Account Asset page.
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
			for(int i=1;i<=7;i++) {
				try {
					DataFillUp(i,470,i);
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
				str = str + "\n" + "Create Add Asset button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 434, 2), M.getstring("Automation Test Data", 434, 3));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message, Company Assets page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Margin Account Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add Margin Account Asset";
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
							
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
				for (int i = 1; i <= 7; i++) {
					String result = VerifyText(i, 468, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Margin Account Asset, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Add Margin Account Assets");
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
			M.ScreenShots("Screenshot/Passed","Create Margin Account Asset"); 
		    M.setStrData("As Expected","Automation Testcase", 906, 6);
			M.setStrData("Pass","Automation Testcase", 906, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Margin Account Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 906, 6);
			M.setStrData("Fail","Automation Testcase", 906, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
	}
	

	

	
	// Verify Created Margin Account Asset
	//@Test (priority = 7)
	public void VerifyCreateMarginAccountAsset_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Verify Created Margin Account Asset & Data Executed!");
		String MarginAccountAsset ="";
		String str ="";
		int count=0;
		int j=0;
		int totalvalue=0;
		
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
					
			MarginAccountAsset = M.getstring("Automation Test Data",470, 1);
			//System.out.println(MarginAccountAsset);
			int pass = 0;
			
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 472, 8), "Total Value Amount Doesn't Match");
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

				totalvalue = Integer.parseInt(collect);
				System.out.println(totalvalue);


			} catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when collect Amount:"+e;

			}

			//check calculation
			try {
				
				if(TotalValue!=totalvalue) {
					int total=totalvalue-TotalValue;
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",470, 5));
					System.out.println(total);
					if(total!=totaldata) {
						count++;
						str = str + "\n" + "Total Value Amount does not match after added Margin Account Asset";
					}
					
				}else {
					count++;
					str = str + "\n" + "Margin Account Asset Amount does not added in Total value";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			M.ScrollByText(MarginAccountAsset);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(MarginAccountAsset)) {
					pass++;
					Thread.sleep(5000);
					j=counting(MarginAccountAsset, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(MarginAccountAsset)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 8), "Asset Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Asset Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 2), "Account Number Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Number does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 3), "Account Type Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Type does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 9), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 6), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 7), "Remarks Doesn't Match");
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
				throw new Exception("Margin Account Asset didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 10), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 8; i++) {
					String result = VerifyText(i, 472, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 472, 11), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit Margin Account Asset");
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
			
			M.ScreenShots("Screenshot/Passed"," Verify Created Margin Account Asset & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 907, 6);
			M.setStrData("Pass","Automation Testcase",907, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Created Margin Account Asset & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 907, 6);
			M.setStrData("Fail","Automation Testcase", 907, 7);
	
		}
		ReStart();
		PageReload();
	}
	
	
	
	
	//Verify Created Margin Account Asset Detail
	//@Test (priority = 8)
	public void VerifyMarginAccountAssetDetail()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify FDR Asset Detail Executed!");
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
			M.ScreenShots("Screenshot/Passed","Verify FDR Asset Detail"); 
		    M.setStrData("As Expected","Automation Testcase", 908, 6);
			M.setStrData("Pass","Automation Testcase", 908, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify FDR Asset Detail");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 908, 6);
			M.setStrData("Fail","Automation Testcase", 908, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
	}
	

	
	
	
	
	
	
	//Verify Save Changes Button Disabled (Default & With Blank Field)909
	//@Test (priority = 9)
	public void VerifySaveChangesButtonDisabled_Default_Blank()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled (Default & With Blank Field) Executed!");
		int count=0;
		int j=0;
		String str="";
		String MarginAccountAsset = M.getstring("Automation Test Data",470, 1);
		try {
			try {
				Thread.sleep(2000);
				M.ScrollByText(MarginAccountAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(MarginAccountAsset)) {
						
						Thread.sleep(5000);
						j=counting(MarginAccountAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(MarginAccountAsset)) {
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
			
			for (int i = 0; i <= 4; i++) {
				boolean tr;

				Thread.sleep(3000);
				// Full Field Blank
				if (i == 0) {
					Thread.sleep(2000);
					
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "By Default in Edit Margin Account Asset page, Save Changes Button is Enable";

					}
					Thread.sleep(2000);
					//M.Scroll(1);
					i++;

				}
				Thread.sleep(2000);
				//M.Scroll(1);
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").clear();
					driver.hideKeyboard();
					
				}
				if (i == 2) {
					AccountNumber(M.getstring("Automation Test Data", 470, 2));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").clear();
					driver.hideKeyboard();
					
				}
				if (i == 3) {
					AccountType(M.getstring("Automation Test Data", 470, 3));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").clear();
					driver.hideKeyboard();
					
				}
				if (i == 4) {
					Assetvalue(M.getstring("Automation Test Data", 470, 5));
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
						str = str + "\n" + "Account Number Field is Blank But Save Changes Button is Enable";
					else if(i==2)
						str = str + "\n" + "Account Type Field is Blank But Save Changes Button is Enable";
					else if(i==3)
						str = str + "\n" + "Asset Value Field is Blank But Save Changes Button is Enable";
					
				}else {
					
					if (i == 4) {
						count++;
						str = str + "\n" + "Remarks Field is non-mandatory field But Save Changes Button is Disable";
					}
						
				}
				

			}
			// back to Margin Account Asset page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Margin Account Asset Edit Page Back Button doesn't found";
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
			
			String result=PageVerification("Edit Margin Account Asset");
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
		    M.setStrData("As Expected","Automation Testcase", 909, 6);
			M.setStrData("Pass","Automation Testcase", 909, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Save Changes Button Disabled (Default & With Blank Field)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 909, 6);
			M.setStrData("Fail","Automation Testcase", 909, 7);
			
			
		}
		ReStart();
		PageReload();
		
	}
	
	
	
	
	
	
	//Verify Save Changes Button Disabled/Enabled (For Each Field)910
	//@Test(priority = 10)
	public void VerifySaveChangesButtonDisabledEnabled() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Changes Button Disabled/Enabled (For Each Field) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String MarginAccountAsset = M.getstring("Automation Test Data",470, 1);
		
		try {
			
			for(int i=1;i<=7;i++){
				
				try {
					Thread.sleep(2000);
					M.ScrollByText(MarginAccountAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(MarginAccountAsset)) {
							
							Thread.sleep(5000);
							j=counting(MarginAccountAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(MarginAccountAsset)) {
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
					DataFillUp(i,474,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				
				Thread.sleep(2000);
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if(tr==false) {
					count++;
					if(i==1)
						str = str + "\n" + "Bank field is modify but Save Change button is disable";
					if(i==2)
						str = str + "\n" + "Account Number field is modify but Save Change button is disable";
					if(i==3)
						str = str + "\n" + "Account Type is modify but Save Change button is disable";
					if(i==4)
						str = str + "\n" + "Currency field is modify but Save Change button is disable";
					if(i==5)
						str = str + "\n" + "Asset Value field is modify but Save Change button is disable";
					if(i==6)
						str = str + "\n" + "Balance as of field is modify but Save Change button is disable";
					if(i==7)
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
				
				String result=PageVerification("Edit Margin Account Asset");
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
			M.setStrData("As Expected", "Automation Testcase",910, 6);
			M.setStrData("Pass", "Automation Testcase",910, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Save Changes Button Disabled/Enabled(For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase",910, 6);
			M.setStrData("Fail", "Automation Testcase",910, 7);

		}
		ReStart();
		PageReload();
	}
	
	
	
	
	//Dismiss Unsaved Data-Edit Margin Account Asset (Default & All fields together)911
	//@Test(priority = 11)
	public void DismissUnsavedData_EditMarginAccountAsset_DefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-EditMarginAccountAsset(Default & All fields together) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String MarginAccountAsset = M.getstring("Automation Test Data",470, 1);

		try {
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				M.ScrollByText(MarginAccountAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(MarginAccountAsset)) {
						
						Thread.sleep(5000);
						j=counting(MarginAccountAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(MarginAccountAsset)) {
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
			
			//verify Edit Margin Account Asset page 
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
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
				M.ScrollByText(MarginAccountAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(MarginAccountAsset)) {
						
						Thread.sleep(5000);
						j=counting(MarginAccountAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(MarginAccountAsset)) {
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
			
			for(int i=1;i<=7;i++) {
				try {
					DataFillUp(i,474,i);
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
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 432, 2), M.getstring("Automation Test Data", 432, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Back Button "+ confirmation;
			}
			
			
			//Verify  Edit Margin Account Asset page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Margin Account Asset']").getText();
				
				try {
					for(int i=1;i<=7;i++)
					{
						String result= VerifyText(i, 476, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,474,i);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
				
				str = str + "\n" + "After click Back button and warning message no, Page Redirect to Company Assets page";
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
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
				throw new Exception(str);
			}
			
			
			String result=PageVerification("Edit Margin Account Asset");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Margin Account Asset Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 911, 6);
			M.setStrData("Pass", "Automation Testcase", 911, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Margin Account Asset Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 911, 6);
			M.setStrData("Fail", "Automation Testcase", 911, 7);

		}
		ReStart();
		PageReload();
	}
	 

	

	
	
	//Dismiss Unsaved Data-Edit Margin Account Asset  (For Each Field)912
	//@Test(priority = 12)
	public void DismissUnsavedDataForEachField_EditMarginAccountAsset() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Edit Margin Account Asset(For Each Field) Executed!");
		int count = 0;
		int back = 0;
		int j=0;
		String str="";
		String MarginAccountAsset = M.getstring("Automation Test Data",470, 1);
		int l=474;
		try {
			
			for(int i=1;i<=7;i++){
				Thread.sleep(2000);
				//go to Edit Margin Account Asset page
				//Default dismiss
				try {
					Thread.sleep(2000);
					M.ScrollByText(MarginAccountAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(MarginAccountAsset)) {
							
							Thread.sleep(5000);
							j=counting(MarginAccountAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(MarginAccountAsset)) {
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
					DataFillUp(i,l,i);
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 432, 2), M.getstring("Automation Test Data", 432, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",474, i)+ confirmation;
				}				
				
				//Verify Add Margin Account Asset page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Margin Account Asset']").getText();
					
					try {
						String result= VerifyText(i, 476, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i, l, i);
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
						 gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
					}catch (Exception e) {
						count++;
						str = str + "\n" + "After press back button, warnning yes button Doesn't Work";
						throw new Exception(str);
					}
					
					
					String result=PageVerification("Edit Margin Account Asset");
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}
					
					
					
				} catch (Exception e) {	
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
					
					str = str + "\n" + " After click Back button and warning message no, Page Redirect to Company Assets page";
					//throw new Exception(str);
					

				}
				
				PageReload();
				
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Margin Account Asset (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 912, 6);
			M.setStrData("Pass", "Automation Testcase", 912, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Margin Account Asset (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 912, 6);
			M.setStrData("Fail", "Automation Testcase", 912, 7);

		}
		ReStart();
		PageReload();
	}

	
	
	
	//Dismiss Selected Value From Dropdown (Edit Margin Account Asset)913		
	//@Test (priority = 13)
	public void DismissSelectedValueFromDropdown_EditMarginAccountAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Edit Margin Account Asset) Executed!");
		int count=0;
		int j=0;
		String str="";
		String MarginAccountAsset = M.getstring("Automation Test Data",470, 1);

		try {
			// Go to Edit Margin Account Asset
			try {
				Thread.sleep(2000);
				M.ScrollByText(MarginAccountAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(MarginAccountAsset)) {
						
						Thread.sleep(5000);
						j=counting(MarginAccountAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(MarginAccountAsset)) {
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
			Bank(M.getstring("Automation Test Data", 474, 1),2);		
			String result = VerifyText(1, 470, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 474, 4),2);		
			result = VerifyText(4, 470, 4);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 474, 6),2);		
			result = VerifyText(6, 472, 6);
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
			result=PageVerification("Edit Margin Account Asset");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Edit Margin Account Asset)"); 
		    M.setStrData("As Expected","Automation Testcase", 913, 6);
			M.setStrData("Pass","Automation Testcase", 913, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Edit Margin Account Asset)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 913, 6);
			M.setStrData("Fail","Automation Testcase", 913, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
		
	}
	
	
	
	
	

	// Update Margin Account Asset 914
	//@Test (priority = 14)
	public void UpdateMarginAccountAsset()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update Margin Account Asset Executed!");
		int count = 0;
		int j=0;
		String str="";
		String MarginAccountAsset = M.getstring("Automation Test Data",470, 1);

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

			TotalValue= Integer.parseInt(collect);
			System.out.println(TotalValue);


		} catch (Exception e) {
			count++;
			str = str + "\n" + "Found a Error when collect Amount:"+e;

		}
		
		try {
			
			// Go to Edit Margin Account Asset
			try {
				Thread.sleep(2000);
				M.ScrollByText(MarginAccountAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(MarginAccountAsset)) {
						
						Thread.sleep(5000);
						j=counting(MarginAccountAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(MarginAccountAsset)) {
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
			for(int i=1;i<=7;i++) {
				try {
					DataFillUp(i,474,i);
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
				str = str + "\n" + "Create Add Margin Account Asset button not found";
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 434, 4), M.getstring("Automation Test Data", 434, 5));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Margin Account Asset']").getText();
				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(5000);
				try {
					 user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
					
				} catch (Exception y) {
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						count++;
						str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
						Thread.sleep(3000);
						user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
						
					}catch (Exception z) {
						count++;
						str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
						Thread.sleep(5000);
						
					}
					
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message OK, Edit Margin Account Asset page not found";
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();

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
				for (int i = 1; i <= 7; i++) {
					String result = VerifyText(i, 468, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After Update Margin Account Asset, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Edit Margin Account Asset");
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
			M.ScreenShots("Screenshot/Passed","Update Margin Account Assets"); 
		    M.setStrData("As Expected","Automation Testcase", 914, 6);
			M.setStrData("Pass","Automation Testcase", 914, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Margin Account Assets");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 914, 6);
			M.setStrData("Fail","Automation Testcase", 914, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
		
	}
	

	
	

	
	// Verify Update Margin Account Asset915
	//@Test (priority = 15)
	public void VerifyUpdateMarginAccountAsset_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Margin Account Asset & Data Executed!");
		String MarginAccountAsset =M.getstring("Automation Test Data",474, 1);
		String str ="";
		int count=0;
		int pass=0;
		int j=0;
		int totalvalue=0;
		
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			//TotalValue=100000;	
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 476, 8), "Total Value Amount Doesn't Match");
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

				totalvalue = Integer.parseInt(collect);
				System.out.println(totalvalue);


			} catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when collect Amount:"+e;

			}

			//check calculation
			try {
				
				if(TotalValue!=totalvalue) {
					
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",474, 5))*84;
					System.out.println(totaldata);
					if(totalvalue!=totaldata) {
						count++;
						str = str + "\n" + "Total Value Amount does not match after Updated Margin Account Asset";
					}
					
				}else {
					count++;
					str = str + "\n" + "Margin Account Asset Amount does not Updated in Total value";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			M.ScrollByText(MarginAccountAsset);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(MarginAccountAsset)) {
					pass++;
					Thread.sleep(5000);
					j=counting(MarginAccountAsset, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(MarginAccountAsset)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 427, 8), "Asset Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Asset Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 476, 2), "Account Number Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Number does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 476, 3), "Account Type Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Type does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 476, 9), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 476, 6), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 476, 7), "Remarks Doesn't Match");
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
				throw new Exception("Margin Account Asset didn't Update");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 476, 10), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 8; i++) {
					String result = VerifyText(i, 476, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 476, 11), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit Margin Account Asset");
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

			
			M.ScreenShots("Screenshot/Passed"," Verify Edit Margin Account Asset & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 915, 6);
			M.setStrData("Pass","Automation Testcase",915, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Edit Margin Account Asset & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 915, 6);
			M.setStrData("Fail","Automation Testcase", 915, 7);
	
		}
		ReStart();
		PageReload();
		
	}
	
	
	
	
	
	
	//Verify Updated Margin Account Asset Detail 916
	//@Test (priority = 16)
	public void VerifyUpdatedMarginAccountAssetDetail()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Updated FDR Asset Detail Executed!");
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
			M.ScreenShots("Screenshot/Passed","Verify FDR Asset Detail"); 
		    M.setStrData("As Expected","Automation Testcase", 916, 6);
			M.setStrData("Pass","Automation Testcase", 916, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify FDR Asset Detail");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 916, 6);
			M.setStrData("Fail","Automation Testcase", 916, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
	}
	


	
	


	// Delete & Verify Deleted Margin Account Asset917
	//@Test(priority = 17)
	public void Delete_VerifyDeletedMarginAccountAsset() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete & Verify Deleted Margin Account Asset Executed!");
		String MarginAccountAsset =M.getstring("Automation Test Data",474, 1);
		String str ="";
		int count=0;
		int j=0;
		try {
			// Go to Edit Margin Account Asset
			try {
				Thread.sleep(2000);
				M.ScrollByText(MarginAccountAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(MarginAccountAsset)) {
						
						Thread.sleep(5000);
						j=counting(MarginAccountAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(MarginAccountAsset)) {
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 436, 2),M.getstring("Automation Test Data", 436, 3));
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
					str = str + "\n" + "After Delete Warning message no, Margin Account Asset card doesn't close";

				} catch (Exception e) {
					try {
						Thread.sleep(2000);
						int x=FindData(MarginAccountAsset);
						Thread.sleep(2000);
						if(x==0) {
							count++;
							str = str + "\n" + "After click Delete warning message No,Margin Account Asset Card Delete ";
							throw new Exception(str);
						}
						//Swip the card
						try {
							
							List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
							String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
							String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
							for (int n = 0; n < xyz.size(); n++) {
								if (xyz.get(n).getText().contains(MarginAccountAsset)) {
									
									Thread.sleep(5000);
									j=counting(MarginAccountAsset, str1, str2);
									//System.out.println(j);
									try {
										String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
										if(gettext.contentEquals(MarginAccountAsset)) {
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
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 436, 4),M.getstring("Automation Test Data", 436, 5));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				try {
					Thread.sleep(2000);
					int x=FindData(MarginAccountAsset);
					Thread.sleep(2000);
					if(x==1) {
						count++;
						str = str + "\n" + "After Sucessfully Delete, Margin Account Asset card doesn't Delete ";
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
			M.ScreenShots("Screenshot/Passed", "Delete & Verify Deleted Margin Account Asset");
			M.setStrData("As Expected", "Automation Testcase", 917, 6);
			M.setStrData("Pass", "Automation Testcase", 917, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete & Verify Deleted Margin Account Asset");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 917, 6);
			M.setStrData("Fail", "Automation Testcase", 917, 7);

		}
		
		ReStart();
		
	}
	
	
	
	// Add multiple Margin Account Asset and verify Totalvalue918
	//@Test (priority = 18)
	public void AddMultipleMarginAccountAssetAndverifyTotalvalue()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Add multiple Margin Account Asset and verify Totalvalue Executed!");
		int count = 0;
		String str = "";
		String successful = "";
		
		try {
			
			for(int l=1;l<=5;l++) {
				//collect Total value
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

					TotalValue = Integer.parseInt(collect);
					System.out.println(TotalValue);

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Total Values:"+e;

				}
				
				
				//Go to Add Margin Account Asset page.
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
				for(int i=1;i<=7;i++) {
					if(i==1)
						DataFillUp(i,478,l);
					else {
						try {
							DataFillUp(i,470,i);
						}catch (Exception e) {
							count++;
							str = str + "\n" + e;
						}
						
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
					str = str + "\n" + "Create Add Asset button not found";
				}
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}
				

				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
				} catch (Exception e) {
					String result=PageVerification("Add Margin Account Assets");
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}
				}
				
				
				
				int totalvalue=0;
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

					totalvalue = Integer.parseInt(collect);
					System.out.println(totalvalue);


				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount:"+e;

				}

				//check calculation
				try {
					
					if(TotalValue!=totalvalue) {
						int total=totalvalue-TotalValue;
						int totaldata=Integer.parseInt(M.getstring("Automation Test Data",470, 5));
						System.out.println(total);
						if(total!=totaldata) {
							count++;
							str = str + "\n" + "After added "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Created "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;

				}
	
				
				
				
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Add multiple Margin Account Asset and verify Totalvalue"); 
		    M.setStrData("As Expected","Automation Testcase", 918, 6);
			M.setStrData("Pass","Automation Testcase", 918, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Add multiple Margin Account Asset and verify Totalvalue");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 918, 6);
			M.setStrData("Fail","Automation Testcase", 918, 7);
			
			
		}
		
		
		ReStart();
	}
	

	

	
	// Update Multiple Margin Account Asset Value & Verify Total Asset.919
	//@Test (priority = 19)
	public void UpdateMultipleMarginAccountAssetValueAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple Margin Account Asset Value & Verify Total Asset. Executed!");
		String MarginAccountAsset ="";
		String str ="";
		int count=0;
		int j=0;
		int totalvalue=0;
		String asset="";
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			
			for(int l=1;l<=5;l++) {
				//collect Total value
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

					TotalValue = Integer.parseInt(collect);
					System.out.println(TotalValue);

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Total Values:"+e;

				}
				MarginAccountAsset=M.getstring("Automation Test Data",478, l);
				// Go to Edit Margin Account Asset
				try {
					Thread.sleep(2000);
					M.ScrollByText(MarginAccountAsset);
					DataUp(MarginAccountAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(MarginAccountAsset)) {
							
							Thread.sleep(5000);
							j=counting(MarginAccountAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(MarginAccountAsset)) {
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
				
				asset=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").getText();
				// Data input
				try {
					DataFillUp(5,479,l);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				//Thread.sleep(2000);
				//M.ScrollByText(text);
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Add Asset button not found";
				}
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}
				

				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Margin Account Asset']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
			
				} catch (Exception e) {
					String result=PageVerification("Edit Margin Account Asset");
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}
				}
				Thread.sleep(5000);
				M.ScrollUpMinor(3);
		
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

					totalvalue = Integer.parseInt(collect);
					System.out.println(totalvalue);


				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount:"+e;

				}

				//check calculation
				try {
					
					if(TotalValue!=totalvalue) {
						
						
						int ind = asset.indexOf(".");
						asset = asset.substring(0, ind);
						asset = asset.trim();
						
						int value=Integer.parseInt(asset);
						
						totalvalue=totalvalue+value;
						System.out.println(totalvalue);
						int total=Math.abs(totalvalue-TotalValue);
						
						int totaldata=Integer.parseInt(M.getstring("Automation Test Data",479, l));
						System.out.println(total);
						if(total!=totaldata) {
							count++;
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;

				}
	
				
				
				
			}

			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple Margin Account Asset Value & Verify Total Asset. ");			  
		    M.setStrData("As Expected","Automation Testcase", 919, 6);
			M.setStrData("Pass","Automation Testcase",919, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Update Multiple Margin Account Asset Value & Verify Total Asset. ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 919, 6);
			M.setStrData("Fail","Automation Testcase", 919, 7);
	
		}
		ReStart();
	}
	
	
	
	
	// Update Multiple Margin Account Asset Currency BDT To USD & Verify Total Asset.920
	//@Test (priority = 20)
	public void UpdateMultipleMarginAccountAssetCurrencyBDTToUSDAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple Margin Account Asset Currency & Verify Total Asset Executed!");
		String MarginAccountAsset ="";
		String str ="";
		int count=0;
		int j=0;
		int totalvalue=0;
		String asset="";
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			
			for(int l=1;l<=5;l++) {
				//collect Total value
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
					
					TotalValue = Integer.parseInt(collect);
					System.out.println(TotalValue);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Total Values:"+e;
					
				}
				MarginAccountAsset=M.getstring("Automation Test Data",478, l);
				// Go to Edit Margin Account Asset
				try {
					Thread.sleep(2000);
					M.ScrollByText(MarginAccountAsset);
					DataUp(MarginAccountAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(MarginAccountAsset)) {
							
							Thread.sleep(5000);
							j=counting(MarginAccountAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(MarginAccountAsset)) {
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
				
				asset=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").getText();
				// Data input
				try {
					DataFillUp(4,474,4);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				//Thread.sleep(2000);
				//M.ScrollByText(text);
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Add Asset button not found";
				}
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}
				
				
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Margin Account Asset']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
					
				} catch (Exception e) {
					String result=PageVerification("Edit Margin Account Asset");
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}
				}
				Thread.sleep(5000);
				M.ScrollUpMinor(3);
				
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
					
					totalvalue = Integer.parseInt(collect);
					System.out.println(totalvalue);
					
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount:"+e;
					
				}
				
				//check calculation
				try {
					
					if(TotalValue!=totalvalue) {
						
						
						int ind = asset.indexOf(".");
						asset = asset.substring(0, ind);
						asset = asset.trim();
						
						int value=Integer.parseInt(asset);
						
						TotalValue=TotalValue-value;
						value=value*84;
						TotalValue=TotalValue+value;
						
						System.out.println(TotalValue);
						if(totalvalue!=TotalValue) {
							count++;
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;
					
				}
				
				
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple Margin Account Asset Currency & Verify Total Asset ");			  
			M.setStrData("As Expected","Automation Testcase", 920, 6);
			M.setStrData("Pass","Automation Testcase",920, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Update Multiple Margin Account Asset Currency & Verify Total Asset ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 920, 6);
			M.setStrData("Fail","Automation Testcase", 920, 7);
			
		}
		ReStart();
	}
	
	
	
	
	
	
	// Update Multiple Margin Account Asset Currency USD To BDT& Verify Total Asset.921
	//@Test (priority = 21)
	public void UpdateMultipleMarginAccountAssetCurrencyUSDToBDTAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple Margin Account Asset Currency USD To BDT & Verify Total Asset Executed!");
		String MarginAccountAsset ="";
		String str ="";
		int count=0;
		int j=0;
		int totalvalue=0;
		String asset="";
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			
			for(int l=1;l<=5;l++) {
				//collect Total value
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
					
					TotalValue = Integer.parseInt(collect);
					System.out.println(TotalValue);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Total Values:"+e;
					
				}
				MarginAccountAsset=M.getstring("Automation Test Data",478, l);
				// Go to Edit Margin Account Asset
				try {
					Thread.sleep(2000);
					M.ScrollByText(MarginAccountAsset);
					DataUp(MarginAccountAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(MarginAccountAsset)) {
							
							Thread.sleep(5000);
							j=counting(MarginAccountAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(MarginAccountAsset)) {
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
				
				asset=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").getText();
				// Data input
				try {
					DataFillUp(4,470,4);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				//Thread.sleep(2000);
				//M.ScrollByText(text);
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Add Asset button not found";
				}
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (Exception e) {
					;
				}
				
				
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Margin Account Asset']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
					
				} catch (Exception e) {
					String result=PageVerification("Edit Margin Account Asset");
					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}
				}
				Thread.sleep(5000);
				M.ScrollUpMinor(3);
				
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
					
					totalvalue = Integer.parseInt(collect);
					System.out.println(totalvalue);
					
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount:"+e;
					
				}
				
				//check calculation
				try {
					
					if(TotalValue!=totalvalue) {
						
						
						int ind = asset.indexOf(".");
						asset = asset.substring(0, ind);
						asset = asset.trim();
						
						int value=Integer.parseInt(asset);
						
						TotalValue=TotalValue+value;
						value=value*84;
						TotalValue=TotalValue-value;
						
						System.out.println("After calculation = "+TotalValue);
						if(totalvalue!=TotalValue) {
							count++;
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;
					
				}
				
				
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple Margin Account Asset Currency USD To BDT & Verify Total Asset");			  
			M.setStrData("As Expected","Automation Testcase", 921, 6);
			M.setStrData("Pass","Automation Testcase",921, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Multiple Margin Account Asset Currency USD To BDT & Verify Total Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 921, 6);
			M.setStrData("Fail","Automation Testcase", 921, 7);
			
		}
		ReStart();
	}
	
	
	
	
	//Verify Balance as of 922
	//@Test (priority = 22)
	public void VerifyBalanceAsOf()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Balance as of Executed!");
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
			M.ScreenShots("Screenshot/Passed","Verify Balance as of"); 
		    M.setStrData("As Expected","Automation Testcase", 922, 6);
			M.setStrData("Pass","Automation Testcase", 922, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Balance as of");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 922, 6);
			M.setStrData("Fail","Automation Testcase", 922, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	// Delete and Verify Total Asset 923
	//@Test (priority = 23)
	public void DeleteAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Delete and Verify Total Asset Executed!");
		String MarginAccountAsset ="";
		String str ="";
		int count=0;
		int j=0;
		int totalvalue=0;
		int value=0;
		String asset="";
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
			
			for(int l=1;l<=5;l++) {
				//collect Total value
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
					
					TotalValue = Integer.parseInt(collect);
					//System.out.println(TotalValue);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Total Values:"+e;
					
				}
				MarginAccountAsset=M.getstring("Automation Test Data",478, l);
				// Go to Edit Margin Account Asset
				try {
					Thread.sleep(2000);
					M.ScrollByText(MarginAccountAsset);
					DataUp(MarginAccountAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(MarginAccountAsset)) {
							
							Thread.sleep(5000);
							j=counting(MarginAccountAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(MarginAccountAsset)) {
									;
								}else {
									j++;
								}
							}catch(Exception e) {
								j++;
							}
						}
					}
					
					asset=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();

					
					//Swipping
					Point p1 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getCenter();
					Point p2 = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getCenter();
					M.Swipping(p2,p1);
					
					
				}catch (Exception e) {
					throw new Exception("Error occures when card swip");
				}
				
				
				try {
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Delete button not found";
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
					
					totalvalue = Integer.parseInt(collect);
					//System.out.println(totalvalue);
					
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount:"+e;
					
				}
				
				try {
					String collect = asset;
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
					
					value = Integer.parseInt(collect);
					//System.out.println(value );
					
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when collect Amount:"+e;
					
				}
				
				//check calculation
				try {
					
					if(TotalValue!=totalvalue) {
						
						TotalValue=TotalValue-value;
						
						//System.out.println(TotalValue);
						if(totalvalue!=TotalValue) {
							count++;
							str = str + "\n" + "After Delete "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Delete "+M.getstring("Automation Test Data",478, l)+" Margin Account Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;
					
				}
				
				
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Delete and Verify Total Asset");			  
			M.setStrData("As Expected","Automation Testcase", 923, 6);
			M.setStrData("Pass","Automation Testcase",923, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Delete and Verify Total Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 923, 6);
			M.setStrData("Fail","Automation Testcase", 923, 7);
			
		}
		ReStart();
	}
	
	
	

	

}
