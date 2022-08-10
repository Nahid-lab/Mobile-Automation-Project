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

public class CompanyFDRAsset extends BaseClass {
	
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
		driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"FDR\"]/android.widget.TextView").click();
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
			
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"FDR\"]/android.widget.TextView").click();
			Thread.sleep(1000);

		} catch (Exception e) {
			;

		}

		
		
	}
	
	
	//ReStart
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
			
			Boolean tr=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"FDR\"]/android.widget.TextView").isSelected();
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
			
			Thread.sleep(1000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"FDR\"]/android.widget.TextView").click();
			
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

	
		
	
	//Institute
	public void Institute(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtInstitute").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtInstitute").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtInstitute").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	
	
	//FDR Number
	public void FDRNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").sendKeys(text);
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
			Institute(M.getstring("Automation Test Data", j, k));
		
		if (i == 2) 
			FDRNumber(M.getstring("Automation Test Data", j, k));
		
		if (i == 3) 
			Currency(M.getstring("Automation Test Data", j, k),1);
		
		if (i == 4) 
			Assetvalue(M.getstring("Automation Test Data", j, k));
		
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
			//Institute
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtInstitute").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Institute Name Doesn't Match");
		}
		
		if(i==2) {
			//FDRNumber
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "FDR Number Doesn't Match");
		}
		
		if(i==3) {
			//Currency
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Currency Doesn't Match");
		}
		if(i==4) {
			//Assetvalue
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").getText();
			// M.setStrData(gettext, "Automation Test Data", i, 1);
			//System.out.println(gettext);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Asset value Doesn't Match");
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
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 417, 8), "CreatedBy Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}
	
	

	
	
	//Verify Place Holder Text (Add FDR Asset)
	//@Test (priority = 1)
	public void VerifyPlaceHolderText_AddFDRAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Place Holder Text_Add FDR Asset Executed!");
		int count=0;
		String str="";
		try {
			
			//Go to FDR Tab.
			try {
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"FDR\"]/android.widget.TextView").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" +"FDR Tab not found";
				throw new Exception(str);
			}
			
			
			//Go to FDR Asset Create page.
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
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 448, 9), "Add FDR Asset title text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add FDR Asset Title doesn't found";
			}
			
			//Verify Task Template
			for(int i=1;i<=7;i++)
			{
				String result=VerifyText(i,448,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 448, 10), "Add FDR Asset button text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add FDR Asset Create Button doesn't found";
			}
			
			// back to Bank Tab
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add FDR Asset Create Page Back Button doesn't found";
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
			M.ScreenShots("Screenshot/Passed","Verify Place Holder Text_Add FDR Asset"); 
		    M.setStrData("As Expected","Automation Testcase", 870, 6);
			M.setStrData("Pass","Automation Testcase", 870, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Place Holder Text_Add FDR Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 870, 6);
			M.setStrData("Fail","Automation Testcase", 870, 7);
			
			
		}

		ReStart();
		PageReload();
	}
	
	
	
	
	
	//Verify Disabled Add Asset Button (Default & With Blank Field)
	//@Test (priority = 2)
	public void VerifyDisabledAddAssetButton()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Disabled Add Asset Button -Default & With Blank Field Executed!");
		int count=0;
		String str="";
		int k=450;
		try {
			for (int i = 0; i <= 6; i++) {
				boolean tr;
				
				//Go to Add FDR Asset page.
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
					Institute(M.getstring("Automation Test Data", k,1));
				}
				if (i != 2) {
					FDRNumber(M.getstring("Automation Test Data", k,2));
				}
				if (i != 3) {
					Currency(M.getstring("Automation Test Data", k,3),1);
				}
				if (i != 4) {
					Assetvalue(M.getstring("Automation Test Data", k,4));
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
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Institute Field is Blank But Add Asset Button is Enable";
					else if (i == 2)
						str = str + "\n" + "FDR Number Field is Blank But Add Asset Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Currency Field is Blank But Add Asset Button is Enable";
					else if (i == 4)
						str = str + "\n" + "Asset Value Field is Blank But Add Asset Button is Enable";
					else if (i == 5)
						str = str + "\n" + "BalanceAsOf Field is Blank But Add Asset Button is Enable";
					
				}else {
					if (i == 6) {
						count++;
						str = str + "\n" + "Remarks Field is not Mandatory field But Add Asset Button is Disable";
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
					//PageReload();
				}
			}
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Disabled Add Asset Button -Default & With Blank Field"); 
		    M.setStrData("As Expected","Automation Testcase", 871, 6);
			M.setStrData("Pass","Automation Testcase", 871, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Disabled Add Asset Button -Default & With Blank Field");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 871, 6);
			M.setStrData("Fail","Automation Testcase", 871, 7);
			
			
		}

		ReStart();
		PageReload();
	}
	
	
	
	
	 
	//Dismiss Unsaved Data-Add FDR Asset (Default & All fields together)
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
			
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,450,i);
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
			
			
			//Verify Add FDR Asset page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add FDR Assets']").getText();
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 452, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,450,i);
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
			
			 
			String result=PageVerification("Add FDR Assets");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data- Add FDR Asset Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 872, 6);
			M.setStrData("Pass", "Automation Testcase", 872, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data- Add FDR Asset Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 872, 6);
			M.setStrData("Fail", "Automation Testcase", 872, 7);

		}
		ReStart();
		PageReload();
	}
	 


	
	
	//Dismiss Unsaved Data-Add FDR Asset  (For Each Field)
	//@Test(priority = 4)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		int k=450;
		try {
			
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
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 432, 2), M.getstring("Automation Test Data", 432, 3));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",450, i)+ confirmation;
				}				
				
				//Verify Add FDR Asset page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add FDR Assets']").getText();
					
					try {
						String result= VerifyText(i, 452, i);
						
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
				
				
				String result=PageVerification("Add FDR Assets");
				if (result.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + result;
				}
				
				//PageReload();
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Add FDR Asset (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 873, 6);
			M.setStrData("Pass", "Automation Testcase", 873, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Add FDR Asset (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 873, 6);
			M.setStrData("Fail", "Automation Testcase", 873, 7);

		}
		ReStart();
		PageReload();
	}


	
	
	//Dismiss Selected Value From Dropdown (Add FDR Asset)		
	//@Test (priority = 5)
	public void DismissSelectedValueFromDropdown_AddFDRAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Add FDR Asset) Executed!");
		int count=0;
		String str="";
		try {
			// Go to Add FDR Asset
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Create icon button doesn't found";
				throw new Exception(str);
			}
			
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 450, 3),2);		
			String result = VerifyText(3, 448, 3);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 450, 5),2);		
			result = VerifyText(5, 448, 5);
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
			result=PageVerification("Add FDR Assets");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Add FDR Asset)"); 
		    M.setStrData("As Expected","Automation Testcase", 874, 6);
			M.setStrData("Pass","Automation Testcase", 874, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Add FDR Asset)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 874, 6);
			M.setStrData("Fail","Automation Testcase", 874, 7);
			
		}
		
		
		ReStart();
		PageReload();
	}
	
	
	
	// create FDR Asset
	//@Test (priority = 6)
	public void CreateFDRAsset()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("create FDR Asset Executed!");
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
			
			//Go to Add FDR Asset page.
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
					DataFillUp(i,450,i);
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
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add FDR Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add FDR Asset";
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
				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 448, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create FDR Asset, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Add FDR Assets");
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
			M.ScreenShots("Screenshot/Passed","Create FDR Asset"); 
		    M.setStrData("As Expected","Automation Testcase", 875, 6);
			M.setStrData("Pass","Automation Testcase", 875, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create FDR Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 875, 6);
			M.setStrData("Fail","Automation Testcase", 875, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
	}
	

	

	
	// Verify Created FDR Asset
	//@Test (priority = 7)
	public void VerifyCreateFDRAsset_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Verify Created FDR Asset & Data Executed!");
		String FDRAsset ="";
		String str ="";
		int count=0;
		int j=0;
		int totalvalue=0;
		
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
					
			FDRAsset = M.getstring("Automation Test Data",450, 1);
			//System.out.println(FDRAsset);
			int pass = 0;
			
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 452, 7), "Total Value Amount Doesn't Match");
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
				TotalValue=0;
				if(TotalValue!=totalvalue) {
					int total=totalvalue-TotalValue;
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",450, 4));
					System.out.println(total);
					if(total!=totaldata) {
						count++;
						str = str + "\n" + "Total Value Amount does not match after added FDR Asset";
					}
					
				}else {
					count++;
					str = str + "\n" + "FDR Asset Amount does not added in Total value";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			M.ScrollByText(FDRAsset);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(FDRAsset)) {
					pass++;
					Thread.sleep(5000);
					j=counting(FDRAsset, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(FDRAsset)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 452, 7), "Asset Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Asset Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 452, 2), "FDR Number Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Number does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 452, 8), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 452, 5), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 452, 6), "Remarks Doesn't Match");
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
				throw new Exception("FDR Asset didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 452, 9), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 7; i++) {
					String result = VerifyText(i, 452, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 452, 10), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit FDR Assets");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			//PageReload();
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Verify Created FDR Asset & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 876, 6);
			M.setStrData("Pass","Automation Testcase",876, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Created FDR Asset & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase",876, 6);
			M.setStrData("Fail","Automation Testcase", 876, 7);
	
		}
		ReStart();
		PageReload();
	}
	
	
	
	
	//Verify Created FDR Asset Detail
	//@Test (priority = 8)
	public void VerifyFDRAssetDetail()throws IOException, InterruptedException {
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
		    M.setStrData("As Expected","Automation Testcase", 885, 6);
			M.setStrData("Pass","Automation Testcase", 885, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify FDR Asset Detail");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 885, 6);
			M.setStrData("Fail","Automation Testcase", 885, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
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
		String FDRAsset = M.getstring("Automation Test Data",450, 1);
		try {
			try {
				Thread.sleep(2000);
				M.ScrollByText(FDRAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(FDRAsset)) {
						
						Thread.sleep(5000);
						j=counting(FDRAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(FDRAsset)) {
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
						str = str + "By Default in Edit FDR Asset page, Save Changes Button is Enable";

					}
					Thread.sleep(2000);
					//M.Scroll(1);
					i++;

				}
				Thread.sleep(2000);
				//M.Scroll(1);
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtInstitute").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtInstitute").clear();
					driver.hideKeyboard();
					
				}
				if (i == 2) {
					Institute(M.getstring("Automation Test Data", 450, 1));
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountNumber").clear();
					driver.hideKeyboard();
					
				}
				if (i == 3) {
					FDRNumber(M.getstring("Automation Test Data", 450, 2));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").clear();
					driver.hideKeyboard();
					
				}

				if (i == 4) {
					Assetvalue(M.getstring("Automation Test Data", 450, 5));
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
						str = str + "\n" + "Institute Field is Blank But Save Changes Button is Enable";
					else if(i==2)
						str = str + "\n" + "FDR Number Field is Blank But Save Changes Button is Enable";
					else if(i==3)
						str = str + "\n" + "Asset Value Field is Blank But Save Changes Button is Enable";
					
				}else {
					
					if (i == 4) {
						count++;
						str = str + "\n" + "Remarks Field is non-mandatory field But Save Changes Button is Disable";
					}
						
				}
				

			}
			// back to Company Asset page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit FDR Assets Edit Page Back Button doesn't found";
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
			
			String result=PageVerification("Edit FDR Assets");
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
		    M.setStrData("As Expected","Automation Testcase", 878, 6);
			M.setStrData("Pass","Automation Testcase", 878, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Save Changes Button Disabled (Default & With Blank Field)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 878, 6);
			M.setStrData("Fail","Automation Testcase", 878, 7);
			
			
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
		String FDRAsset = M.getstring("Automation Test Data",450, 1);
		
		try {
			
			for(int i=1;i<=6;i++){
				
				try {
					Thread.sleep(2000);
					M.ScrollByText(FDRAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(FDRAsset)) {
							
							Thread.sleep(5000);
							j=counting(FDRAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(FDRAsset)) {
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
					DataFillUp(i,454,i);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				
				Thread.sleep(2000);
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if(tr==false) {
					count++;
					if(i==1)
						str = str + "\n" + "Institute field is modify but Save Change button is disable";
					if(i==2)
						str = str + "\n" + "FDR Number field is modify but Save Change button is disable";
					if(i==3)
						str = str + "\n" + "Currency field is modify but Save Change button is disable";
					if(i==4)
						str = str + "\n" + "Asset Value field is modify but Save Change button is disable";
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
				
				String result=PageVerification("Edit FDR Assets");
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
			M.setStrData("As Expected", "Automation Testcase",879, 6);
			M.setStrData("Pass", "Automation Testcase",879, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Save Changes Button Disabled/Enabled(For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase",879, 6);
			M.setStrData("Fail", "Automation Testcase",879, 7);

		}
		ReStart();
		PageReload();
		
	}
	
	
	
	
	//Dismiss Unsaved Data-Edit FDR Assets (Default & All fields together)
	//@Test(priority = 11)
	public void DismissUnsavedData_EditFDRAsset_DefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-EditFDRAsset(Default & All fields together) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String FDRAsset = M.getstring("Automation Test Data",450, 1);

		try {
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				M.ScrollByText(FDRAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(FDRAsset)) {
						
						Thread.sleep(5000);
						j=counting(FDRAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(FDRAsset)) {
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
			
			//verify Edit FDR Assets page 
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
				M.ScrollByText(FDRAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(FDRAsset)) {
						
						Thread.sleep(5000);
						j=counting(FDRAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(FDRAsset)) {
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
			
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,454,i);
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
			
			
			//Verify  Edit FDR Assets page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit FDR Assets']").getText();
				
				try {
					for(int i=1;i<=6;i++)
					{
						String result= VerifyText(i, 456, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							//DataFillUp(i,454,i);
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
			
			
			String result=PageVerification("Edit FDR Assets");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit FDR Assets Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 880, 6);
			M.setStrData("Pass", "Automation Testcase", 880, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit FDR Assets Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 880, 6);
			M.setStrData("Fail", "Automation Testcase", 880, 7);

		}
		ReStart();
		PageReload();

	}
	 

	

	
	
	//Dismiss Unsaved Data-Edit FDR Assets  (For Each Field)881
	//@Test(priority = 12)
	public void DismissUnsavedDataForEachField_EditFDRAsset() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Edit FDR Assets(For Each Field) Executed!");
		int count = 0;
		int back = 0;
		int j=0;
		String str="";
		String FDRAsset = M.getstring("Automation Test Data",450, 1);
		int l=454;
		try {
			
			for(int i=1;i<=6;i++){
				Thread.sleep(2000);
				//go to Edit FDR Assets page
				//Default dismiss
				try {
					Thread.sleep(2000);
					M.ScrollByText(FDRAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(FDRAsset)) {
							
							Thread.sleep(5000);
							j=counting(FDRAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(FDRAsset)) {
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
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",454, i)+ confirmation;
				}				
				
				//Verify Add FDR Asset page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit FDR Assets']").getText();
					
					try {
						String result= VerifyText(i, 456, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							//DataFillUp(i, l, i);
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
					
					
					String result=PageVerification("Edit FDR Assets");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit FDR Assets (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 881, 6);
			M.setStrData("Pass", "Automation Testcase", 881, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit FDR Assets (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 881, 6);
			M.setStrData("Fail", "Automation Testcase", 881, 7);

		}
		ReStart();
		PageReload();
	}

	
	
	
	//Dismiss Selected Value From Dropdown (Edit FDR Assets)882		
	//@Test (priority = 13)
	public void DismissSelectedValueFromDropdown_EditFDRAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Edit FDR Assets) Executed!");
		int count=0;
		int j=0;
		String str="";
		String FDRAsset = M.getstring("Automation Test Data",450, 1);

		try {
			// Go to Edit FDR Assets
			try {
				Thread.sleep(2000);
				M.ScrollByText(FDRAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(FDRAsset)) {
						
						Thread.sleep(5000);
						j=counting(FDRAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(FDRAsset)) {
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
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 454, 3),2);		
			String result = VerifyText(3, 450, 3);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 454, 5),2);		
			result = VerifyText(5, 450, 5);
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
			result=PageVerification("Edit FDR Assets");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Edit FDR Assets)"); 
		    M.setStrData("As Expected","Automation Testcase", 882, 6);
			M.setStrData("Pass","Automation Testcase", 882, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Edit FDR Assets)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 882, 6);
			M.setStrData("Fail","Automation Testcase", 882, 7);
			
			
		}
				
		ReStart();
		PageReload();
	}
	
	
	
	
	

	// Update FDR Asset
	//@Test (priority = 14)
	public void UpdateFDRAsset()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update FDR Asset Executed!");
		int count = 0;
		int j=0;
		String str="";
		String FDRAsset = M.getstring("Automation Test Data",450, 1);

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
			
			// Go to Edit FDR Assets
			try {
				Thread.sleep(2000);
				M.ScrollByText(FDRAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(FDRAsset)) {
						
						Thread.sleep(5000);
						j=counting(FDRAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(FDRAsset)) {
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
			for(int i=1;i<=6;i++) {
				try {
					DataFillUp(i,454,i);
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
				str = str + "\n" + "Save Change button not found";
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit FDR Assets']").getText();
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
				str = str + "\n" + "After sucessful message OK, Edit FDR Assets page not found";
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
				for (int i = 1; i <= 6; i++) {
					String result = VerifyText(i, 448, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After Update FDR Asset, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Edit FDR Assets");
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
			M.ScreenShots("Screenshot/Passed","Update FDR Assets"); 
		    M.setStrData("As Expected","Automation Testcase", 883, 6);
			M.setStrData("Pass","Automation Testcase", 883, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update FDR Assets");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 883, 6);
			M.setStrData("Fail","Automation Testcase", 883, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
	}
	

	
	

	
	// Verify Update FDR Asset
	//@Test (priority = 15)
	public void VerifyUpdateFDRAsset_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update FDR Asset & Data Executed!");
		String FDRAsset =M.getstring("Automation Test Data",454, 1);
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
				SA.assertEquals(collect, M.getstring("Automation Test Data", 456, 7), "Total Value Amount Doesn't Match");
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
					
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",454, 4))*84;
					System.out.println(totaldata);
					if(totalvalue!=totaldata) {
						count++;
						str = str + "\n" + "Total Value Amount does not match after Updated FDR Asset";
					}
					
				}else {
					count++;
					str = str + "\n" + "FDR Asset Amount does not Updated in Total value";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			M.ScrollByText(FDRAsset);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(FDRAsset)) {
					pass++;
					Thread.sleep(5000);
					j=counting(FDRAsset, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(FDRAsset)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 457, 7), "Asset Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Asset Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 456, 2), "FDR Number Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Number does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 456, 8), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 456, 5), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 456, 6), "Remarks Doesn't Match");
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
				throw new Exception("FDR Asset didn't Update");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 456, 9), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 7; i++) {
					String result = VerifyText(i, 456, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 456, 10), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit FDR Assets");
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

			
			M.ScreenShots("Screenshot/Passed"," Verify Edit FDR Asset & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 884, 6);
			M.setStrData("Pass","Automation Testcase",884, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Edit FDR Asset & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 884, 6);
			M.setStrData("Fail","Automation Testcase", 884, 7);
	
		}
		ReStart();
		PageReload();
	}
	
	
	
	
	
	
	//Verify Updated FDR Asset Detail
	//@Test (priority = 16)
	public void VerifyUpdatedFDRAssetDetail()throws IOException, InterruptedException {
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
		    M.setStrData("As Expected","Automation Testcase", 885, 6);
			M.setStrData("Pass","Automation Testcase", 885, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify FDR Asset Detail");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 885, 6);
			M.setStrData("Fail","Automation Testcase", 885, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
	}
	


	// Delete & Verify Deleted FDR Asset
	//@Test(priority = 17)
	public void Delete_VerifyDeletedFDRAsset() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete & Verify Deleted FDR Asset Executed!");
		String FDRAsset =M.getstring("Automation Test Data",454, 1);
		String str ="";
		int count=0;
		int j=0;
		try {
			// Go to Edit FDR Assets
			try {
				Thread.sleep(2000);
				M.ScrollByText(FDRAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(FDRAsset)) {
						
						Thread.sleep(5000);
						j=counting(FDRAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(FDRAsset)) {
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
					str = str + "\n" + "After Delete Warning message no, FDR Asset card doesn't close";

				} catch (Exception e) {
					try {
						Thread.sleep(2000);
						int x=FindData(FDRAsset);
						Thread.sleep(2000);
						if(x==0) {
							count++;
							str = str + "\n" + "After click Delete warning message No,FDR Asset Card Delete ";
							throw new Exception(str);
						}
						//Swip the card
						try {
							
							List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
							String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
							String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
							for (int n = 0; n < xyz.size(); n++) {
								if (xyz.get(n).getText().contains(FDRAsset)) {
									
									Thread.sleep(5000);
									j=counting(FDRAsset, str1, str2);
									//System.out.println(j);
									try {
										String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
										if(gettext.contentEquals(FDRAsset)) {
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
					int x=FindData(FDRAsset);
					Thread.sleep(2000);
					if(x==1) {
						count++;
						str = str + "\n" + "After Sucessfully Delete, FDR Asset card doesn't Delete ";
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
			M.ScreenShots("Screenshot/Passed", "Delete & Verify Deleted FDR Asset");
			M.setStrData("As Expected", "Automation Testcase", 886, 6);
			M.setStrData("Pass", "Automation Testcase", 886, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete & Verify Deleted FDR Asset");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 886, 6);
			M.setStrData("Fail", "Automation Testcase", 886, 7);

		}
		PageReload();
		ReStart();
	}
	
	
	
	// Add multiple FDR Asset and verify Totalvalue
	//@Test (priority = 18)
	public void AddMultipleFDRAssetAndverifyTotalvalue()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Add multiple FDR Asset and verify Totalvalue Executed!");
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
				
				
				//Go to Add FDR Asset page.
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
					if(i==1)
						DataFillUp(i,458,l);
					else {
						try {
							DataFillUp(i,450,i);
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
					
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					} catch (Exception e) {
						;
					}
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "Create Add Asset button not found";
				}
				
				

				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
				} catch (Exception e) {
					String result=PageVerification("Add FDR Assets");
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
						int totaldata=Integer.parseInt(M.getstring("Automation Test Data",450, 4));
						System.out.println(total);
						if(total!=totaldata) {
							count++;
							str = str + "\n" + "After added "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Created "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Value does not added in Total value";
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
			M.ScreenShots("Screenshot/Passed","Add multiple FDR Asset and verify Totalvalue"); 
		    M.setStrData("As Expected","Automation Testcase", 887, 6);
			M.setStrData("Pass","Automation Testcase", 887, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Add multiple FDR Asset and verify Totalvalue");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 887, 6);
			M.setStrData("Fail","Automation Testcase", 887, 7);
			
			
		}
		
		
		ReStart();
	}
	

	

	
	// Update Multiple FDR Asset Value & Verify Total Asset.
	@Test (priority = 19)
	public void UpdateMultipleFDRAssetValueAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple FDR Asset Value & Verify Total Asset. Executed!");
		String FDRAsset ="";
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
				FDRAsset=M.getstring("Automation Test Data",458, l);
				// Go to Edit FDR Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(FDRAsset);
					DataUp(FDRAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(FDRAsset)) {
							
							Thread.sleep(5000);
							j=counting(FDRAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(FDRAsset)) {
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
					DataFillUp(4,459,l);
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
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit FDR Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
			
				} catch (Exception e) {
					String result=PageVerification("Edit FDR Assets");
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
						//System.out.println(totalvalue);
						int total=Math.abs(totalvalue-TotalValue);
						
						int totaldata=Integer.parseInt(M.getstring("Automation Test Data",459, l));
						System.out.println(total);
						if(total!=totaldata) {
							count++;
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;

				}
	
				
				
				
			}

			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple FDR Asset Value & Verify Total Asset. ");			  
		    M.setStrData("As Expected","Automation Testcase", 888, 6);
			M.setStrData("Pass","Automation Testcase",888, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Update Multiple FDR Asset Value & Verify Total Asset. ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 888, 6);
			M.setStrData("Fail","Automation Testcase", 888, 7);
	
		}
		ReStart();
	}
	
	
	
	
	// Update Multiple FDR Asset Currency BDT To USD & Verify Total Asset.
	//@Test (priority = 20)
	public void UpdateMultipleFDRAssetCurrencyBDTToUSDAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple FDR Asset Currency BDT To USD & Verify Total Asset Executed!");
		String FDRAsset ="";
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
				FDRAsset=M.getstring("Automation Test Data",458, l);
				// Go to Edit FDR Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(FDRAsset);
					DataUp(FDRAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(FDRAsset)) {
							
							Thread.sleep(5000);
							j=counting(FDRAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(FDRAsset)) {
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
					DataFillUp(3,454,3);
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
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit FDR Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
					
				} catch (Exception e) {
					String result=PageVerification("Edit FDR Assets");
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
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;
					
				}
				
				
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple FDR Asset Currency BDT To USD & Verify Total Asset ");			  
			M.setStrData("As Expected","Automation Testcase",889, 6);
			M.setStrData("Pass","Automation Testcase",889, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Update Multiple FDR Asset Currency BDT To USD & Verify Total Asset ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase",889, 6);
			M.setStrData("Fail","Automation Testcase",889, 7);
			
		}
		ReStart();
	}
	
	
	
	
	
	
	//Update Multiple FDR Asset Currency USD To BDT & Verify Total Asset.890
	//@Test (priority = 21)
	public void UpdateMultipleFDRAssetCurrencyUSDToBDTAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple FDR Asset Currency USD To BDT & Verify Total Asset Executed!");
		String FDRAsset ="";
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
				FDRAsset=M.getstring("Automation Test Data",458, l);
				// Go to Edit FDR Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(FDRAsset);
					DataUp(FDRAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(FDRAsset)) {
							
							Thread.sleep(5000);
							j=counting(FDRAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(FDRAsset)) {
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
					DataFillUp(3,450,3);
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
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit FDR Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
					
				} catch (Exception e) {
					String result=PageVerification("Edit FDR Assets");
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
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;
					
				}
				
				
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple FDR Asset Currency USD To BDT & Verify Total Asset");			  
			M.setStrData("As Expected","Automation Testcase", 890, 6);
			M.setStrData("Pass","Automation Testcase",890, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Multiple FDR Asset Currency USD To BDT & Verify Total Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 890, 6);
			M.setStrData("Fail","Automation Testcase", 890, 7);
			
		}
		ReStart();
	}
	
	
	
	
	//Verify Balance as of 885
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
		    M.setStrData("As Expected","Automation Testcase", 891, 6);
			M.setStrData("Pass","Automation Testcase", 891, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Balance as of");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 891, 6);
			M.setStrData("Fail","Automation Testcase", 891, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	// Delete and Verify Total Asset 
	//@Test (priority = 23)
	public void DeleteAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Delete and Verify Total Asset Executed!");
		String FDRAsset ="";
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
				FDRAsset=M.getstring("Automation Test Data",458, l);
				// Go to Edit FDR Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(FDRAsset);
					DataUp(FDRAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(FDRAsset)) {
							
							Thread.sleep(5000);
							j=counting(FDRAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(FDRAsset)) {
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
							str = str + "\n" + "After Delete "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Delete "+M.getstring("Automation Test Data",458, l)+" FDR Asset, Value does not added in Total value";
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
			M.setStrData("As Expected","Automation Testcase", 892, 6);
			M.setStrData("Pass","Automation Testcase",892, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Delete and Verify Total Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 892, 6);
			M.setStrData("Fail","Automation Testcase", 892, 7);
			
		}
		ReStart();
	}
	
	
	

	

}
