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

public class CompanyBankAsset extends BaseClass {
	
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

		} catch (Exception e) {
			;

		}

		
		
	}
	
	
	//ReStart
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Company Assets']").getText();
			
			Boolean tr=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Bank\"]/android.widget.TextView").isSelected();
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
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 417, 8), "CreatedBy Doesn't Match");
		}
		
		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

		
	}
	
	
	
	
	//Verify Company Asset View
	@Test (priority = 1)
	public void VerifyCompanyAssetListView()throws IOException, InterruptedException {
		Thread.sleep(5000);
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Company Asset View Executed!");
		int count=0;
		String str="";
		try {

			//Page Title
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				
				if(gettext.contentEquals("Company Assets")) {
					;
				}else {
					count++;
					str = str + "\n" + "Company Assets Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Company Asset Title doesn't found";
			}
			
			
			
			//Check Bank tab
			try {
				String gettext=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Bank\"]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("Bank")) {
					// Create icon
					try {
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "Bank Create Icon doesn't display";
							//System.out.println(str);
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" +"Bank Create Icon doesn't found";
					}

					//Bank Tab
					try {
						//Total Value
						gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, "Total Value", "Total Value Doesn't Match");
						
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
						str = str + "\n" +e+ "Bank TextLebel Xpath doesn't found";
					}


				}else {
					count++;
					str = str + "\n" + "Bank Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Bank Title doesn't found";
			}
			
			
			
			//Check FDR
			try {
				String gettext=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"FDR\"]/android.widget.TextView").getText();

				if(gettext.contentEquals("FDR")) {
					
					//Go To FDR Tab
					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"FDR\"]/android.widget.TextView").click();
					Thread.sleep(2000);
					
					try {
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "FDR Create Icon doesn't display";
							//System.out.println(str);
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" +"FDR Create Icon doesn't found";
					}

					// FDR Text Lebel
					try {
						// Total Value
						gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, "Total Value", "Total Value Doesn't Match");
						
						// Balance as of
						gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, "Balance as of", "Balance as of Doesn't Match");
						
						try {
							SA.assertAll();
						} catch (AssertionError e) {
							
							str = str + "\n" + e;
						}
						
					} catch (Exception e) {
						count++;
						str = str + "\n" +e+ "FDR Text Xpath doesn't found";
					}
					

				}else {
					count++;
					str = str + "\n" + "FDR Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "FDR Title doesn't found";
			}
			
			
			
			
			//Check Margin Account
			try {
				String gettext=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Margin Account\"]/android.widget.TextView").getText();
				
				if(gettext.contentEquals("Margin Account")) {
					
					//Go To Margin Account Tab
					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Margin Account\"]/android.widget.TextView").click();
					Thread.sleep(2000);
					
					try {
						Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
						if(tr==false) {
							count++;
							str = str + "\n" + "Margin Account Create Icon doesn't display";
							//System.out.println(str);
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" +"Margin Account Create Icon doesn't found";
					}
					
					
					// Margin Account
					try {
						// Total Value
						gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, "Total Value", "Total Value Doesn't Match");
						
						// Balance as of
						gettext=driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, "Balance as of", "Balance as of Doesn't Match");
						
						try {
							SA.assertAll();
						} catch (AssertionError e) {
							
							str = str + "\n" + e;
						}
						
					} catch (Exception e) {
						count++;
						str = str + "\n" +e+ "FDR Text Xpath doesn't found";
					}

				}else {
					count++;
					str = str + "\n" + "Margin Account Title doesn't display";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Margin Account Title doesn't found";
			}
			

			//Go To Bank Tab
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Bank\"]/android.widget.TextView").click();
			Thread.sleep(2000);
			
			
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Company Asset View"); 
		    M.setStrData("As Expected","Automation Testcase", 836, 6);
			M.setStrData("Pass","Automation Testcase", 836, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Company Asset View");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 836, 6);
			M.setStrData("Fail","Automation Testcase", 836, 7);

		}
		
		ReStart();
		
	}

	
	
	//Verify Place Holder Text (Add Bank Asset)
	@Test (priority = 2)
	public void VerifyPlaceHolderText_AddBankAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Place Holder Text_Add Bank Asset Executed!");
		int count=0;
		String str="";
		try {
			//Go to Bank Asset Create page.
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
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 417, 9), "Add Bank Asset title text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Bank Asset Title doesn't found";
			}
			
			//Verify Task Template
			for(int i=1;i<=8;i++)
			{
				String result=VerifyText(i,417,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			try {
				String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 417, 10), "Add Bank Asset button text Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Add Bank Asset Create Button doesn't found";
			}
			
			// back to Bank Tab
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add Bank Asset Create Page Back Button doesn't found";
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
			M.ScreenShots("Screenshot/Passed","Verify Place Holder Text_Add Bank Asset"); 
		    M.setStrData("As Expected","Automation Testcase", 837, 6);
			M.setStrData("Pass","Automation Testcase", 837, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Place Holder Text_Add Bank Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 837, 6);
			M.setStrData("Fail","Automation Testcase", 837, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	
	//Verify Disabled Add Asset Button (Default & With Blank Field)
	@Test (priority = 3)
	public void VerifyDisabledAddAssetButton()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Disabled Add Asset Button -Default & With Blank Field Executed!");
		int count=0;
		String str="";
		int k=420;
		try {
			for (int i = 0; i <= 7; i++) {
				boolean tr;
				
				//Go to Add Bank Asset page.
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
		    M.setStrData("As Expected","Automation Testcase", 838, 6);
			M.setStrData("Pass","Automation Testcase", 838, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Disabled Add Asset Button -Default & With Blank Field");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 838, 6);
			M.setStrData("Fail","Automation Testcase", 838, 7);
			
			
		}

		ReStart();
		PageReload();
	}
	
	
	
	
	 
	//Dismiss Unsaved Data-Add Bank Asset (Default & All fields together)
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
					DataFillUp(i,420,i);
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
			
			
			//Verify Add Bank Asset page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Bank Assets']").getText();
				
				try {
					for(int i=1;i<=7;i++)
					{
						String result= VerifyText(i, 422, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,420,i);
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
			
			 
			String result=PageVerification("Add Bank Assets");
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data- Add Bank Asset Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 839, 6);
			M.setStrData("Pass", "Automation Testcase", 839, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data- Add Bank Asset Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 839, 6);
			M.setStrData("Fail", "Automation Testcase", 839, 7);

		}
		ReStart();
		PageReload();
	}
	 


	
	
	//Dismiss Unsaved Data-Add Bank Asset  (For Each Field)
	//@Test(priority = 5)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int back = 0;
		String str = "";
		int k=420;
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
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",420, i)+ confirmation;
				}				
				
				//Verify Add Bank Asset page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Bank Assets']").getText();
					
					try {
						String result= VerifyText(i, 422, i);
						
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
				
				
				String result=PageVerification("Add Bank Assets");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Add Bank Asset (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 840, 6);
			M.setStrData("Pass", "Automation Testcase", 840, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Add Bank Asset (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 840, 6);
			M.setStrData("Fail", "Automation Testcase", 840, 7);

		}
		ReStart();
		PageReload();
	}


	
	
	//Dismiss Selected Value From Dropdown (Add Bank Asset)		
	//@Test (priority = 6)
	public void DismissSelectedValueFromDropdown_AddBankAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Add Bank Asset) Executed!");
		int count=0;
		String str="";
		try {
			// Go to Add Bank Asset
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
			Bank(M.getstring("Automation Test Data", 420, 1),2);		
			String result = VerifyText(1, 417, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 420, 4),2);		
			result = VerifyText(4, 417, 4);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 420, 6),2);		
			result = VerifyText(6, 417, 6);
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
			result=PageVerification("Add Bank Assets");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Add Bank Asset)"); 
		    M.setStrData("As Expected","Automation Testcase", 841, 6);
			M.setStrData("Pass","Automation Testcase", 841, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Add Bank Asset)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 841, 6);
			M.setStrData("Fail","Automation Testcase", 841, 7);
			
			
		}
		
		
		ReStart();
		PageReload();
	}
	
	
	
	// Create Bank Asset
	@Test (priority = 7)
	public void CreateBankAsset()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Create Bank Asset Executed!");
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
			
			//Go to Add Bank Asset page.
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
					DataFillUp(i,420,i);
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
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Add Bank Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					str = str + "\n" + "After sucessful message ok, Page redirect to Add Bank Asset";
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
					String result = VerifyText(i, 417, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After create Bank Asset, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Add Bank Assets");
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
			M.ScreenShots("Screenshot/Passed","Create Bank Asset"); 
		    M.setStrData("As Expected","Automation Testcase", 842, 6);
			M.setStrData("Pass","Automation Testcase", 842, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Create Bank Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 842, 6);
			M.setStrData("Fail","Automation Testcase", 842, 7);
			
			
		}
		
		
		ReStart();
	}
	

	

	
	// Verify Created Bank Asset
	//@Test (priority = 8)
	public void VerifyCreateBankAsset_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Verify Created Bank Asset & Data Executed!");
		String BankAsset ="";
		String str ="";
		int count=0;
		int j=0;
		int totalvalue=0;
		
		//System.out.println(TotalLiability);
		//System.out.println(OpenedB2B);
		try {
					
			BankAsset = M.getstring("Automation Test Data",420, 1);
			//System.out.println(BankAsset);
			int pass = 0;
			
			try {
				String collect = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTotalLiabilities").getText();
				SA.assertEquals(collect, M.getstring("Automation Test Data", 422, 8), "Total Value Amount Doesn't Match");
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
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",420, 5));
					System.out.println(total);
					if(total!=totaldata) {
						count++;
						str = str + "\n" + "Total Value Amount does not match after added bank Asset";
					}
					
				}else {
					count++;
					str = str + "\n" + "Bank Asset Amount does not added in Total value";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			M.ScrollByText(BankAsset);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(BankAsset)) {
					pass++;
					Thread.sleep(5000);
					j=counting(BankAsset, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(BankAsset)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 8), "Asset Amount Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Asset Amount does not display";
					}
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 2), "Account Number Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Number does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 3), "Account Type Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Type does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 9), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 6), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 7), "Remarks Doesn't Match");
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
				throw new Exception("Bank Asset didn't create");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 10), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 8; i++) {
					String result = VerifyText(i, 422, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 422, 11), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit Bank Assets");
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
			
			M.ScreenShots("Screenshot/Passed"," Verify Created Bank Asset & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 843, 6);
			M.setStrData("Pass","Automation Testcase",843, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Created Bank Asset & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 843, 6);
			M.setStrData("Fail","Automation Testcase", 843, 7);
	
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
		String BankAsset = M.getstring("Automation Test Data",420, 1);
		try {
			try {
				Thread.sleep(2000);
				M.ScrollByText(BankAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(BankAsset)) {
						
						Thread.sleep(5000);
						j=counting(BankAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankAsset)) {
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
						str = str + "By Default in Edit Bank Asset page, Save Changes Button is Enable";

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
					AccountNumber(M.getstring("Automation Test Data", 420, 2));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAccountType").clear();
					driver.hideKeyboard();
					
				}
				if (i == 3) {
					AccountType(M.getstring("Automation Test Data", 420, 3));
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtAssetvalue").clear();
					driver.hideKeyboard();
					
				}
				if (i == 4) {
					Assetvalue(M.getstring("Automation Test Data", 420, 5));
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
			// back to Bank Asset page
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Bank Assets Edit Page Back Button doesn't found";
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
			
			String result=PageVerification("Edit Bank Assets");
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
		    M.setStrData("As Expected","Automation Testcase", 844, 6);
			M.setStrData("Pass","Automation Testcase", 844, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Save Changes Button Disabled (Default & With Blank Field)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 844, 6);
			M.setStrData("Fail","Automation Testcase", 844, 7);
			
			
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
		String BankAsset = M.getstring("Automation Test Data",420, 1);
		
		try {
			
			for(int i=1;i<=7;i++){
				
				try {
					Thread.sleep(2000);
					M.ScrollByText(BankAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(BankAsset)) {
							
							Thread.sleep(5000);
							j=counting(BankAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(BankAsset)) {
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
					DataFillUp(i,424,i);
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
				
				String result=PageVerification("Edit Bank Assets");
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
			M.setStrData("As Expected", "Automation Testcase",845, 6);
			M.setStrData("Pass", "Automation Testcase",845, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Save Changes Button Disabled/Enabled(For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase",845, 6);
			M.setStrData("Fail", "Automation Testcase",845, 7);

		}
		ReStart();
		
	}
	
	
	
	
	//Dismiss Unsaved Data-Edit Bank Assets (Default & All fields together)846
	//@Test(priority = 12)
	public void DismissUnsavedData_EditBankAsset_DefaultAllfieldstogether() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data-EditBankAsset(Default & All fields together) Executed!");
		int count = 0;
		int j=0;
		String str="";
		String BankAsset = M.getstring("Automation Test Data",420, 1);

		try {
			
			//Default dismiss
			try {
				Thread.sleep(2000);
				M.ScrollByText(BankAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(BankAsset)) {
						
						Thread.sleep(5000);
						j=counting(BankAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankAsset)) {
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
			
			//verify Edit Bank Assets page 
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
				M.ScrollByText(BankAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(BankAsset)) {
						
						Thread.sleep(5000);
						j=counting(BankAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankAsset)) {
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
					DataFillUp(i,424,i);
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
			
			
			//Verify  Edit Bank Assets page is present 
			Thread.sleep(2000);
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Bank Assets']").getText();
				
				try {
					for(int i=1;i<=7;i++)
					{
						String result= VerifyText(i, 426, i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After click warning message no-"+ result;
							DataFillUp(i,424,i);
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
			
			
			String result=PageVerification("Edit Bank Assets");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Bank Assets Default & All fields together");
			M.setStrData("As Expected", "Automation Testcase", 846, 6);
			M.setStrData("Pass", "Automation Testcase", 846, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Bank Assets Default & All fields together");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 846, 6);
			M.setStrData("Fail", "Automation Testcase", 846, 7);

		}
		ReStart();

	}
	 

	

	
	
	//Dismiss Unsaved Data-Edit Bank Assets  (For Each Field)847
	//@Test(priority = 13)
	public void DismissUnsavedDataForEachField_EditBankAsset() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data Edit Bank Assets(For Each Field) Executed!");
		int count = 0;
		int back = 0;
		int j=0;
		String str="";
		String BankAsset = M.getstring("Automation Test Data",420, 1);
		int l=424;
		try {
			
			for(int i=1;i<=7;i++){
				Thread.sleep(2000);
				//go to Edit Bank Assets page
				//Default dismiss
				try {
					Thread.sleep(2000);
					M.ScrollByText(BankAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(BankAsset)) {
							
							Thread.sleep(5000);
							j=counting(BankAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(BankAsset)) {
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
					str = str + "\n" +"Press Back Button after input :"+M.getstring("Automation Test Data",424, i)+ confirmation;
				}				
				
				//Verify Add Bank Asset page is present 
				Thread.sleep(2000);
				try {
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Bank Assets']").getText();
					
					try {
						String result= VerifyText(i, 426, i);
						
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
					
					
					String result=PageVerification("Edit Bank Assets");
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

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data-Edit Bank Assets (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 847, 6);
			M.setStrData("Pass", "Automation Testcase", 847, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data-Edit Bank Assets (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 847, 6);
			M.setStrData("Fail", "Automation Testcase", 847, 7);

		}
		ReStart();
		
	}

	
	
	
	//Dismiss Selected Value From Dropdown (Edit Bank Assets)848		
	//@Test (priority = 14)
	public void DismissSelectedValueFromDropdown_EditBankAsset()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown (Edit Bank Assets) Executed!");
		int count=0;
		int j=0;
		String str="";
		String BankAsset = M.getstring("Automation Test Data",420, 1);

		try {
			// Go to Edit Bank Assets
			try {
				Thread.sleep(2000);
				M.ScrollByText(BankAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(BankAsset)) {
						
						Thread.sleep(5000);
						j=counting(BankAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankAsset)) {
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
			Bank(M.getstring("Automation Test Data", 424, 1),2);		
			String result = VerifyText(1, 420, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Currency Dropdown
			Currency(M.getstring("Automation Test Data", 424, 4),2);		
			result = VerifyText(4, 420, 4);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// check Balance As Of Dropdown
			BalanceAsOf(M.getstring("Automation Test Data", 424, 6),2);		
			result = VerifyText(6, 420, 6);
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
			result=PageVerification("Edit Bank Assets");
			
			
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown (Edit Bank Assets)"); 
		    M.setStrData("As Expected","Automation Testcase", 848, 6);
			M.setStrData("Pass","Automation Testcase", 848, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown (Edit Bank Assets)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 848, 6);
			M.setStrData("Fail","Automation Testcase", 848, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	

	// Update Bank Asset 849
	//@Test (priority = 15)
	public void UpdateBankAsset()throws Exception {
		Thread.sleep(10000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update Bank Asset Executed!");
		int count = 0;
		int j=0;
		String str="";
		String BankAsset = M.getstring("Automation Test Data",420, 1);

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
			
			// Go to Edit Bank Assets
			try {
				Thread.sleep(2000);
				M.ScrollByText(BankAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(BankAsset)) {
						
						Thread.sleep(5000);
						j=counting(BankAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankAsset)) {
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
					DataFillUp(i,424,i);
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
				str = str + "\n" + "Create Add Bank Asset button not found";
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Bank Assets']").getText();
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
				str = str + "\n" + "After sucessful message OK, Edit Bank Assets page not found";
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
					String result = VerifyText(i, 417, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After Update Bank Asset, When again go to create page-"+result;
					}

				}

				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			
			String result=PageVerification("Edit Bank Assets");
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
			M.ScreenShots("Screenshot/Passed","Update Bank Assets"); 
		    M.setStrData("As Expected","Automation Testcase", 849, 6);
			M.setStrData("Pass","Automation Testcase", 849, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Bank Assets");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 849, 6);
			M.setStrData("Fail","Automation Testcase", 849, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
	

	
	// Verify Update Bank Asset850
	//@Test (priority = 16)
	public void VerifyUpdateBankAsset_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Bank Asset & Data Executed!");
		String BankAsset =M.getstring("Automation Test Data",424, 1);
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
				SA.assertEquals(collect, M.getstring("Automation Test Data", 426, 8), "Total Value Amount Doesn't Match");
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
					
					int totaldata=Integer.parseInt(M.getstring("Automation Test Data",424, 5))*84;
					System.out.println(totaldata);
					if(totalvalue!=totaldata) {
						count++;
						str = str + "\n" + "Total Value Amount does not match after Updated bank Asset";
					}
					
				}else {
					count++;
					str = str + "\n" + "Bank Asset Amount does not Updated in Total value";
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Found a Error when Match Amount:"+e;

			}
			
			Thread.sleep(2000);
			M.ScrollByText(BankAsset);
			Thread.sleep(2000);
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
			String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
			String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(BankAsset)) {
					pass++;
					Thread.sleep(5000);
					j=counting(BankAsset, str1, str2);
					//System.out.println(j);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(BankAsset)) {
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
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 426, 2), "Account Number Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Number does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 426, 3), "Account Type Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Account Type does not display";
					}
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 426, 9), "As of: Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "As of: does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 426, 6), "Balance as of Doesn't Match");
						//System.out.println(gettext);
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Balance as of does not display";
					}
					
					
					try {
						String gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 426, 7), "Remarks Doesn't Match");
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
				throw new Exception("Bank Asset didn't Update");
			
			
			
			try {
				try {
					Thread.sleep(5000);
					String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 426, 10), "Edit page title Doesn't Match");
				}catch(Exception e) {
					count++;
					str = str + "\n" + "Edit page title does not display";
				}
				
				

				for (int i = 1; i <= 8; i++) {
					String result = VerifyText(i, 426, i);
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
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 426, 11), "Button Text Doesn't Match");
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
			
			String result=PageVerification("Edit Bank Assets");
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

			
			M.ScreenShots("Screenshot/Passed"," Verify Edit Bank Asset & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 850, 6);
			M.setStrData("Pass","Automation Testcase",850, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Edit Bank Asset & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 850, 6);
			M.setStrData("Fail","Automation Testcase", 850, 7);
	
		}
		ReStart();
	}
	
	
	


	// Delete & Verify Deleted Bank Asset852
	//@Test(priority = 18)
	public void Delete_VerifyDeletedBankAsset() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete & Verify Deleted Bank Asset Executed!");
		String BankAsset =M.getstring("Automation Test Data",424, 1);
		String str ="";
		int count=0;
		int j=0;
		try {
			// Go to Edit Bank Assets
			try {
				Thread.sleep(2000);
				M.ScrollByText(BankAsset);
				Thread.sleep(2000);
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
				String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
				String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
				for (int k = 0; k < xyz.size(); k++) {
					if (xyz.get(k).getText().contains(BankAsset)) {
						
						Thread.sleep(5000);
						j=counting(BankAsset, str1, str2);
						//System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(BankAsset)) {
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
					str = str + "\n" + "After Delete Warning message no, Bank Asset card doesn't close";

				} catch (Exception e) {
					try {
						Thread.sleep(2000);
						int x=FindData(BankAsset);
						Thread.sleep(2000);
						if(x==0) {
							count++;
							str = str + "\n" + "After click Delete warning message No,Bank Asset Card Delete ";
							throw new Exception(str);
						}
						//Swip the card
						try {
							
							List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
							String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
							String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
							for (int n = 0; n < xyz.size(); n++) {
								if (xyz.get(n).getText().contains(BankAsset)) {
									
									Thread.sleep(5000);
									j=counting(BankAsset, str1, str2);
									//System.out.println(j);
									try {
										String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
										if(gettext.contentEquals(BankAsset)) {
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
					int x=FindData(BankAsset);
					Thread.sleep(2000);
					if(x==1) {
						count++;
						str = str + "\n" + "After Sucessfully Delete, Bank Asset card doesn't Delete ";
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
			M.ScreenShots("Screenshot/Passed", "Delete & Verify Deleted Bank Asset");
			M.setStrData("As Expected", "Automation Testcase", 852, 6);
			M.setStrData("Pass", "Automation Testcase", 852, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete & Verify Deleted Bank Asset");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 852, 6);
			M.setStrData("Fail", "Automation Testcase", 852, 7);

		}
		PageReload();
		ReStart();
	}
	
	
	
	// Add multiple Bank Asset and verify Totalvalue853
	//@Test (priority = 19)
	public void AddMultipleBankAssetAndverifyTotalvalue()throws Exception {
		Thread.sleep(5000);
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Add multiple Bank Asset and verify Totalvalue Executed!");
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
				
				
				//Go to Add Bank Asset page.
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
						DataFillUp(i,428,l);
					else {
						try {
							DataFillUp(i,420,i);
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
					String result=PageVerification("Add Bank Assets");
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
						int totaldata=Integer.parseInt(M.getstring("Automation Test Data",420, 5));
						System.out.println(total);
						if(total!=totaldata) {
							count++;
							str = str + "\n" + "After added "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Created "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Value does not added in Total value";
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
			M.ScreenShots("Screenshot/Passed","Add multiple Bank Asset and verify Totalvalue"); 
		    M.setStrData("As Expected","Automation Testcase", 853, 6);
			M.setStrData("Pass","Automation Testcase", 853, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Add multiple Bank Asset and verify Totalvalue");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 853, 6);
			M.setStrData("Fail","Automation Testcase", 853, 7);
			
			
		}
		
		
		ReStart();
	}
	

	

	
	// Update Multiple Bank Asset Value & Verify Total Asset.854
	//@Test (priority = 20)
	public void UpdateMultipleBankAssetValueAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple Bank Asset Value & Verify Total Asset. Executed!");
		String BankAsset ="";
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
				BankAsset=M.getstring("Automation Test Data",428, l);
				// Go to Edit Bank Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(BankAsset);
					DataUp(BankAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(BankAsset)) {
							
							Thread.sleep(5000);
							j=counting(BankAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(BankAsset)) {
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
					DataFillUp(5,429,l);
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
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Bank Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
			
				} catch (Exception e) {
					String result=PageVerification("Edit Bank Assets");
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
						
						int totaldata=Integer.parseInt(M.getstring("Automation Test Data",429, l));
						System.out.println(total);
						if(total!=totaldata) {
							count++;
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;

				}
	
				
				
				
			}

			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple Bank Asset Value & Verify Total Asset. ");			  
		    M.setStrData("As Expected","Automation Testcase", 854, 6);
			M.setStrData("Pass","Automation Testcase",854, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Update Multiple Bank Asset Value & Verify Total Asset. ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 854, 6);
			M.setStrData("Fail","Automation Testcase", 854, 7);
	
		}
		ReStart();
	}
	
	
	
	
	// Update Multiple Bank Asset Currency & Verify Total Asset.855
	//@Test (priority = 21)
	public void UpdateMultipleBankAssetCurrencyBDTToUSDAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple Bank Asset Currency & Verify Total Asset Executed!");
		String BankAsset ="";
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
				BankAsset=M.getstring("Automation Test Data",428, l);
				// Go to Edit Bank Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(BankAsset);
					DataUp(BankAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(BankAsset)) {
							
							Thread.sleep(5000);
							j=counting(BankAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(BankAsset)) {
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
					DataFillUp(4,424,4);
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
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Bank Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
					
				} catch (Exception e) {
					String result=PageVerification("Edit Bank Assets");
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
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;
					
				}
				
				
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple Bank Asset Currency & Verify Total Asset ");			  
			M.setStrData("As Expected","Automation Testcase", 855, 6);
			M.setStrData("Pass","Automation Testcase",855, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Update Multiple Bank Asset Currency & Verify Total Asset ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 855, 6);
			M.setStrData("Fail","Automation Testcase", 855, 7);
			
		}
		ReStart();
	}
	
	
	
	
	
	
	// Update Multiple Bank Asset Currency & Verify Total Asset.856
	//@Test (priority = 22)
	public void UpdateMultipleBankAssetCurrencyUSDToBDTAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Update Multiple Bank Asset Currency USD To BDT & Verify Total Asset Executed!");
		String BankAsset ="";
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
				BankAsset=M.getstring("Automation Test Data",428, l);
				// Go to Edit Bank Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(BankAsset);
					DataUp(BankAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(BankAsset)) {
							
							Thread.sleep(5000);
							j=counting(BankAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(BankAsset)) {
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
					DataFillUp(4,420,4);
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
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Bank Assets']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					
					
				} catch (Exception e) {
					String result=PageVerification("Edit Bank Assets");
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
							str = str + "\n" + "After Update "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Update "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Value does not added in Total value";
					}
					
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Found a Error when Match Total Amount value:"+e;
					
				}
				
				
			}
			
			if (count > 0) {
				
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Update Multiple Bank Asset Currency USD To BDT & Verify Total Asset");			  
			M.setStrData("As Expected","Automation Testcase", 856, 6);
			M.setStrData("Pass","Automation Testcase",856, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Update Multiple Bank Asset Currency USD To BDT & Verify Total Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 856, 6);
			M.setStrData("Fail","Automation Testcase", 856, 7);
			
		}
		ReStart();
	}
	
	
	
	
	//Verify Balance as of 857
	//@Test (priority = 23)
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
		    M.setStrData("As Expected","Automation Testcase", 857, 6);
			M.setStrData("Pass","Automation Testcase", 857, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Balance as of");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 857, 6);
			M.setStrData("Fail","Automation Testcase", 857, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	
	// Delete and Verify Total Asset 858
	//@Test (priority = 24)
	public void DeleteAndVerifyTotalAsset() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		Thread.sleep(5000);
		System.out.println("Delete and Verify Total Asset Executed!");
		String BankAsset ="";
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
				BankAsset=M.getstring("Automation Test Data",428, l);
				// Go to Edit Bank Assets
				try {
					Thread.sleep(2000);
					M.ScrollByText(BankAsset);
					DataUp(BankAsset);
					Thread.sleep(2000);
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtBankName");
					String str1="bd.com.cslsoft.kandareeliteapp:id/txtBankName";
					String str2="bd.com.cslsoft.kandareeliteapp:id/txtRemarks";
					for (int k = 0; k < xyz.size(); k++) {
						if (xyz.get(k).getText().contains(BankAsset)) {
							
							Thread.sleep(5000);
							j=counting(BankAsset, str1, str2);
							//System.out.println(j);
							try {
								String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
								if(gettext.contentEquals(BankAsset)) {
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
							str = str + "\n" + "After Delete "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Total Value Calculation does not match";
						}
						
					}else {
						count++;
						str = str + "\n" + "After Delete "+M.getstring("Automation Test Data",428, l)+" Bank Asset, Value does not added in Total value";
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
			M.setStrData("As Expected","Automation Testcase", 858, 6);
			M.setStrData("Pass","Automation Testcase",858, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Delete and Verify Total Asset");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 858, 6);
			M.setStrData("Fail","Automation Testcase", 858, 7);
			
		}
		ReStart();
	}
	
	
	

	

}
