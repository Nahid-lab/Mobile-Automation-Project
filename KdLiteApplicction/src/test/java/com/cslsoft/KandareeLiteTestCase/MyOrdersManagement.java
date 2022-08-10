package com.cslsoft.KandareeLiteTestCase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MyOrdersManagement extends BaseClass {
	
	
	
	@Test(priority = 0)
	public void Nevigate() throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
	    driver.findElementByXPath("//android.widget.TextView[@text='My Orders']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 System.out.println("Navigate Hamburgare to MyOrdersmanagement!");
		 

	}
	
	
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();

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
		    
			driver.findElementByXPath("//android.widget.TextView[@text='My Orders']").click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
	}
	private void DataUp(String data) throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber");
		for (j = 0; j < xyz.size(); j++) {
			if (xyz.get(j).getText().contains(data)) {
				if (j >= 2) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
				}

			}
		}

	}
	
	public int counting(String data) throws InterruptedException, IOException{
		CallingMethods M=new CallingMethods(driver);
		int i=0;
		int j=0;
		
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber");
		int item = xyz.size();
		int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txt_edit").size();
		
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
			String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
			// Assert.assertEquals(user,"Orders");

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
	
	

	
	// PoNumber
	public void PoNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").sendKeys(text);
		driver.hideKeyboard();
	}
	
	//PoDate
	public void PoDate(String text,int i) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectPoDate").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"" + text + "\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if (i == 1)
			driver.findElementById("android:id/button1").click();
		else if (i == 2)
			driver.findElementById("android:id/button2").click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//SelectCustomer
	public void SelectCustomer(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCustomerSelect").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// ProductCategory
	public void ProductCategory(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectProductCategory").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//StyleNumber
	public void StyleNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llStyleNumber").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llStyleNumber").clear();
		driver.hideKeyboard(); // Hide keyboard from view.
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtStyleNumber").setValue(text);
	}
	
	// ShipmentDate
	public void ShipmentDate(String text, String text1, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectShipmentDate").click();
		driver.findElementById("android:id/date_picker_header_year").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.view.View[@content-desc=\"" + text1 + "\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("android:id/button1").click();
		else if (i == 2)
			driver.findElementById("android:id/button2").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// SelectCurrency
	public void Currency(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCurrency").click();
		//System.out.println(text);
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// SelectUnitOfMeasurement
	public void UnitOfMeasurement(String text, int i, int x) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectUnitOfMeasurement").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String CreButton = "";
		if(x==1)
			CreButton = "Create";
		else if(x==2)
			CreButton = "Save Changes";
		M.ScrollByText(CreButton);
	}
	
	//OrderQuality
	public void OrderQuality(String text) throws InterruptedException {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").clear();
		Thread.sleep(2000);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").sendKeys(text);
		driver.hideKeyboard();

	}
	
	// editFOB
	public void editFOB(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").setValue(text);
		driver.hideKeyboard();
	}
	
	// ShipMode
	public void ShipMode(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectShipMode").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//POStatus
	public void POStatus(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectPOStatus").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	//TnaTemplate
	public void TnaTemplate(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectTnaTemplate").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
		for (int j = 0; j < xyz.size(); j++) {
			if (xyz.get(j).getText().contains("Warning")) {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
			}

		}
	}
	
	//Remarks
	public void Remarks(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").sendKeys(text);
		driver.hideKeyboard();
	}

	
	public void DataFillUp(int i,int j) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(5000);
		int k = i+1;
		PoNumber(M.getstring("Automation Test Data", i, 1));
		PoDate(M.getstring("Automation Test Data", i, 2),1);
		SelectCustomer(M.getstring("Automation Test Data", i, 3),1);
		ProductCategory(M.getstring("Automation Test Data", i, 4),1);
		StyleNumber(M.getstring("Automation Test Data", i, 5));
		ShipmentDate(M.getstring("Automation Test Data", i, 6),M.getstring("Automation Test Data", k, 6),1);
		Currency(M.getstring("Automation Test Data", i, 7),1);
		UnitOfMeasurement(M.getstring("Automation Test Data", i, 8),1, j);
		OrderQuality(M.getstring("Automation Test Data", i, 9));
		editFOB(M.getstring("Automation Test Data", i, 10));
		ShipMode(M.getstring("Automation Test Data", i, 12),1);
		POStatus(M.getstring("Automation Test Data", i, 13),1);
		TnaTemplate(M.getstring("Automation Test Data", i, 14),1);
		Remarks(M.getstring("Automation Test Data", i, 15));
	}
	
	
	public void VerifyText(int i, int j,int n) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		Thread.sleep(2000);
		int k = 181;
		if(n==0) {
			k=i;
			n=2;
		}
			
		// PoNumber
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 1);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 1), "PoNumber Doesn't Match");

		// PoDate
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoDate").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 2);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", k, n), "PoDate Doesn't Match");

		// CustomerSelect
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomer").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 3);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 3), "CustomerSelect Doesn't Match");

		// ProductCategory
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtProductCategory").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 4);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 4), "ProductCategory Doesn't Match");

		// StyleNumber
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtStyleNumber").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 5);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 5), "StyleNumber Doesn't Match");

		if(k==i)
			n=6;
		else
			n=n+2;
		// ShipmentDate
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipmentDate").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 6);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", k, n), "ShipmentDate Doesn't Match");

		Thread.sleep(2000);
		String CreButton = "";
		if (j == 1)
			CreButton = "Create";
		else if (j == 2)
			CreButton = "Save Changes";
		M.ScrollByText(CreButton);

		// SelectCurrency
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 7);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 7), "Currency Doesn't Match");

		// SelectUnitOfMeasurement
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUnitOfMeasurement").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 8);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 8), "UnitOfMeasurement Doesn't Match");

		// OrderQuality
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 9);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 9), "OrderQuality Doesn't Match");

		// editFOB
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 10);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 10), "edtFOB Doesn't Match");

		// OrderAmount
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderAmount").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 11);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 11), "OrderAmount Doesn't Match");

		// ShipMode
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipMode").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 12);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 12), "ShipMode Doesn't Match");

		// POStatus
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPOStatus").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 13);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 13), "POStatus Doesn't Match");

		// TnaTemplate
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTnaTemplate").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 14);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 14), "TnaTemplate Doesn't Match");

		// Remarks
		gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").getText();
		// M.setStrData(gettext, "Automation Test Data", i, 15);
		SA.assertEquals(gettext, M.getstring("Automation Test Data", i, 15), "Remarks Doesn't Match");
		
		SA.assertAll();
	}

	// Cancellation Head part

	// CancelationType
	public void CancelType(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCancelType").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//CancelReason
	public void CancelReason(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCancelReason").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//Cancel Remarks
	public void CancelRemarks(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").setValue(text);
		driver.hideKeyboard();
	}

	//CancellationDate
	public void CancellationDate(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCancellationDate").click();

		driver.findElementByXPath("//android.view.View[@content-desc=\"" + text+ "\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("android:id/button1").click();
		else if (i == 2)
			driver.findElementById("android:id/button2").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//Curency
	public void Curency(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCurency").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//Raw Material Value
	public void RawMaterialValue(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").setValue(text);
		driver.hideKeyboard();
	}

	//Finished Goods Value
	public void FinishedGoodsValue(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").setValue(text);
		driver.hideKeyboard();
	}

	//CancelationDataFillUp
	public void CancelationDataFillUP(int i,int j) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if(i==1)
			CancelType(M.getstring("Automation Test Data", j, 1),1);
		if(i==2)
			CancelReason(M.getstring("Automation Test Data", j, 2),1);
		if(i==3)
			CancelRemarks(M.getstring("Automation Test Data", j, 3));
		if(i==4)
			CancellationDate(M.getstring("Automation Test Data", j, 4),1);
		if(i==5)	
			Curency(M.getstring("Automation Test Data", j, 5),1);
		if(i==6)
			RawMaterialValue(M.getstring("Automation Test Data", j, 6));
		if(i==7)
			FinishedGoodsValue(M.getstring("Automation Test Data", j, 7));

	}
	
	
	//Cancellation Head Data
	public String VerifyCancellationHeadData(int i,int j,int k) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String str = "";
		Thread.sleep(2000);
		if(i==1) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelType").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "CancelType Doesn't Match");
		}
		if(i==2) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelReason").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "CancelReason Doesn't Match");
		}
		if(i==3) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "CancelRemarks Doesn't Match");
		}
		if(i==4) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancellationDate").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", ++j, k), "CancellationDate Doesn't Match");
		}
		if(i==5) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurency").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "Curency Doesn't Match");
		}
		if(i==6) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "RawMaterialValue Doesn't Match");
		}
		if(i==7) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "FinishedGoodsValue Doesn't Match");
		}
		

		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

	}
	
	
	//Cost Incurred Part.........
	
	// Order Cost Head
	public void OrderCostHead(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llOrderCostHeadDropDown").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// Cost Currency
	public void CostCurrency(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCurrencyDropDown").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Cost Incurred
	public void CostIncurred(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").setValue(text);
		driver.hideKeyboard();
	}
	
	// Cost Remarks 
	public void CostRemarks(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").setValue(text);
		driver.hideKeyboard();
	}
	
	//CostDataFillUp
	public void CostDataFillUp(int i,int j) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if (i == 1)
			OrderCostHead(M.getstring("Automation Test Data", j, 1),1);
		if (i == 2)
			CostCurrency(M.getstring("Automation Test Data", j, 2),1);
		if (i == 3)
			CostIncurred(M.getstring("Automation Test Data", j, 3));
		if (i == 4)
			CostRemarks(M.getstring("Automation Test Data", j, 4));

	}
	
	//VerifyCostIncurredData
	public String VerifyCostIncurredData(int i,int j,int k) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		Thread.sleep(2000);
		String str = "";
		// Cost Incurred
		if (i == 1) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etOrderCostHead").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "OrderCostHead Doesn't Match");
		}
		if (i == 2) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCurrency").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "CostCurrency Doesn't Match");
		}
		if (i == 3) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "CostIncurred Doesn't Match");
		}
		if (i == 4) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "CostRemarks Doesn't Match");
		}

		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

	}
	
	
	//Liability Head Part.............
	
	//Liability Head
	public void LiabilityHead(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCancellationLiabilityHeadDropDown").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//Liability Currency
	public void LiabilityCurrency(String text, int i) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCurrencyDropDown").click();
		M.ClickOn(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (i == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (i == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Liability Amount
	public void LiabilityAmount(String text) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").setValue(text);
		Thread.sleep(2000);
		M.BackFun(1);
	}
	
	// RepaymentDays
	public void RepaymentDays(String text) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").setValue(text);
		Thread.sleep(2000);
		M.BackFun(1);
	}
	
	// Liability Remarks
	public void LiabilityRemarks(String text) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").setValue(text);
		Thread.sleep(2000);
		M.BackFun(1);
	}

	
	//LiabilityDataFillUp
	public void LiabilityDataFillUp(int i,int j) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		if (i == 1)
			LiabilityHead(M.getstring("Automation Test Data", j, 1),1);
		if (i == 2)
			LiabilityCurrency(M.getstring("Automation Test Data", j, 2),1);
		if (i == 3)
			LiabilityAmount(M.getstring("Automation Test Data", j, 3));
		if (i == 4)
			RepaymentDays(M.getstring("Automation Test Data", j, 4));
		if (i == 5)
			LiabilityRemarks(M.getstring("Automation Test Data", j, 5));

	}
	
	//VerifyLiabilityData
	private String VerifyLiabilityData(int i,int j,int k) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String str = "";
		Thread.sleep(2000);

		// Liability
		if (i == 1) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCancellationLiabilityHead").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k),"CancellationLiabilityHead Doesn't Match");
		}
		if (i == 2) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCurrency").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "LiabilityCurrency Doesn't Match");
		}
		if (i == 3) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "LiabilityAmount Doesn't Match");
		}
		if (i == 4) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "LiabilityRepaymentDays Doesn't Match");
		}
		if (i == 5) {
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").getText();
			// M.setStrData(gettext, "Automation Test Data", i, k);
			SA.assertEquals(gettext, M.getstring("Automation Test Data", j, k), "LiabilityRemarks Doesn't Match");
			
		}

		try {
			SA.assertAll();
		} catch (AssertionError e) {
			
			str = str + "\n" + e;
		}
		return str;

	}

	
	
	
	// Verify Place holder Text
	 //@Test(priority = 1)
	public void VerifyPlaceholderText() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Place holder Text Executed!");
		int count=0;
		String str="";
		try {
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			try {
				VerifyText(173,1,0);
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			if(count>0)
			{
				//System.out.println(str);
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "VerifyPlaceholderText");
			M.setStrData("As Expected", "Automation Testcase", 580, 6);
			M.setStrData("Pass", "Automation Testcase", 580, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "VerifyPlaceholderText");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 580, 6);
			M.setStrData("Fail", "Automation Testcase", 580, 7);
		}
		ReStart();
	}
	
	
	// Verify Disabled Create Button (Default & With Blank Field ) and Dismiss Unsaved Data (Default & All fields together)
	// @Test(priority = 2)
	public void VerifyCreateButtonDisableWhenFieldBlank() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Submit Button Disable When Field Blank Executed!");
		try {
			String str = "";
			int count = 0;
			int back = 0;
			int k = 175;
			boolean tr;
			String testdata;
			Thread.sleep(1000);
			String text = "Create";
			for (int i = 0; i <= 15; i++) {
				Thread.sleep(5000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				Thread.sleep(5000);
				// Full Field Blank
				if (i == 0) {
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Submit Button is Enable";

					}

				}

				// PoNumber
				if (i != 1) {
					if (i != 0)
						PoNumber(M.getstring("Automation Test Data", k, 1));
				}

				// PoDate
				if (i != 2) {
					if (i != 0)
						PoDate(M.getstring("Automation Test Data", k, 2),1);

				}
				// SelectCustomer
				if (i != 3) {
					if (i != 0)
						SelectCustomer(M.getstring("Automation Test Data", k, 3),1);
				}
				// ProductCategory
				if (i != 4) {
					if (i != 0)
						ProductCategory(M.getstring("Automation Test Data", k, 4),1);
				}

				// StyleNumber
				if (i != 5) {
					if (i != 0)
						StyleNumber(M.getstring("Automation Test Data", k, 5));
				}

				// ShipmentDate
				if (i != 6) {
					if (i != 0)
						ShipmentDate(M.getstring("Automation Test Data", k, 6),M.getstring("Automation Test Data", ++k, 6),1);
				}
				// Currency
				if (i != 7) {
					if (i != 0) {
						if(i==6)
							Currency(M.getstring("Automation Test Data", k, 7),1);
						else
							Currency(M.getstring("Automation Test Data", --k, 7),1);
					}
						
				}
				// UnitOfMeasurement
				if (i != 8) {
					if (i != 0) {
						if(i==7)
							UnitOfMeasurement(M.getstring("Automation Test Data", --k, 8),1,1);
						else
							UnitOfMeasurement(M.getstring("Automation Test Data", k, 8),1,1);
					}
						
				}
				Thread.sleep(3000);
				M.ScrollByText(text);
				Thread.sleep(3000);
				// OrderQuality
				if (i != 9) {
					if (i != 0)
						OrderQuality(M.getstring("Automation Test Data", k, 9));
				}
				// editFOB
				if (i != 10) {
					if (i != 0)
						editFOB(M.getstring("Automation Test Data", k, 10));
				}
				// ShipMode
				if (i != 11) {
					if (i != 0)
						ShipMode(M.getstring("Automation Test Data", k, 12),1);
				}
				// POStatus
				if (i != 12) {
					if (i != 0)
						POStatus(M.getstring("Automation Test Data", k, 13),1);
				}
				// TnaTemplate
				if (i != 13) {
					if (i != 0)
						TnaTemplate(M.getstring("Automation Test Data", k, 14),1);
				}
				// Remarks
				if (i != 14) {
					if (i != 0)
						Remarks(M.getstring("Automation Test Data", k, 15));
				}
				

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == true) {
					// System.out.println(i);

					if (i == 1) {
						count++;
						str = str + "\n" + "PoNumber Field is Blank But Create Button is Enable";
					}

					else if (i == 2) {
						count++;
						str = str + "\n" + "PO Date Field is Blank But Create Button is Enable";
					}
					else if (i == 3) {
						count++;
						str = str + "\n" + "Customer Field is Blank But Create Button is Enable";
					}
					else if (i == 4) {
						count++;
						str = str + "\n" + "Product Category Field is Blank But Create Button is Enable";
					}
					else if (i == 5) {
						count++;
						str = str + "\n" + "Style Number Field is Blank But Create Button is Enable";
					}
					else if (i == 6) {
						count++;
						str = str + "\n" + "Shipment Date Field is Blank But Create Button is Enable";
					}
					else if (i == 7) {
						count++;
						str = str + "\n" + "Currency Field is Blank But Create Button is Enable";
					}
					else if (i == 8) {
						count++;
						str = str + "\n" + "UOM Field is Blank But Create Button is Enable";
					}
					else if (i == 9) {
						count++;
						str = str + "\n" + "Order Quantity Field is Blank But Create Button is Enable";
					}
					else if (i == 10) {
						count++;
						str = str + "\n" + "FOB Field is Blank But Create Button is Enable";
					}
					else if (i == 11) {
						count++;
						str = str + "\n" + "Ship Mode Field is Blank But Create Button is Enable";
					}
					else if (i == 12) {
						count++;
						str = str + "\n" + "PO Status Field is Blank But Create Button is Enable";
					}
					else if (i == 13) {
						count++;
						str = str + "\n" + "TnA Template Field is Blank But Create Button is Enable";
					}
	
					else
						;

				} else {

					if (i == 14) {
						count++;
						str = str + "\n" + "Remarks Field is not Mendetory But Submit Button is disable";
					}else if (i == 15) {
						count++;
						str = str + "\n" + "After all Field fill up Create Button is disable";
					}

					else
						;

				}
				if (i != 16) {
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

					} catch (Exception e) {
						count++;
						back++;
						str = str + "\n Back button doesn't found";
						Thread.sleep(5000);
						M.BackFun(1);
					}
					if (i == 15) {

						// String title =
						// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// String mess =
						// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();

						// M.setStrData(title,"Automation Test Data", 159, 3);
						// M.setStrData(mess,"Automation Test Data", 159, 4);

						// warnning message
						Thread.sleep(2000);
						String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 198, 3),M.getstring("Automation Test Data", 198, 4));
						if (confirmation.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + confirmation;
						}
						try {
							Thread.sleep(5000);
							String page = driver.findElementByXPath("//android.widget.TextView[@text='New Export PO']").getText();
							try {

								Assert.assertEquals(page, "New Export PO", "After unsave warning message no, New Export PO page Title doesn't Match");
								Thread.sleep(5000);
								M.Scroll(2);
								
								VerifyText(175,1,1);

							} catch (AssertionError e) {
								count++;
								str = str + "\n" + e;
							}

						} catch (Exception e) {
							count++;

							try {
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
								str = str + "\n"+ "After press back and click warring message no Orders List page found No button doesn't work";
							} catch (Exception x) {
								str = str + "\n" + "New Export PO page not found check manually what happend";
							}

							throw new Exception(str);

						}

						// Back Button!!
						try {
							Thread.sleep(2000);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

						} catch (Exception e) {
							count++;
							if (back == 0)
								str = str + "\n" + "Back button doesn't found";
							Thread.sleep(5000);
							M.BackFun(1);
							back++;
						}

						// Message yes
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(3000);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
						} catch (Exception e) {
							count++;
							str = str + "\n" + "After press back and click warring message yes Orders page not found";
							try {
								Thread.sleep(5000);
								String page = driver.findElementByXPath("//android.widget.TextView[@text='New Export PO']").getText();
								str = str + "\n"
										+ "After press back and click warring message yes But found customer Detail page, yes button doesn't work";
								Thread.sleep(2000);
								M.BackFun(1);
							} catch (Exception d) {
								str = str + "\n" + "check manually what happend";
								throw new Exception(str);
							}

							
						}

					}

					if (i == 0) {
						try {
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						} catch (Exception e) {
							count++;
							str = str + "\n" + "No Data input but show warning Message";
							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();

							} catch (Exception x) {
								count++;
								str = str + "\n" + "Some thing is wrong check manually";
								throw new Exception(str);
							}
						}

					} else if (i != 15) {
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(5000);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']")
									.getText();
							// System.out.println("Print Ok");
						} catch (Exception e) {
							try {
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
								// System.out.println("Print Ok");
							} catch (Exception x) {
								count++;
								str = str + "\n" + "After Click Back Button, Some thing is wrong check manually";
							}
							
						}

					}
				}

			}
			String t=PageVerification("New Export PO");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}
			
			if (count > 0) {
				//System.out.println(str);
				throw new Exception(str);
			}

			
			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 581, 6);
			M.setStrData("Pass", "Automation Testcase", 581, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 581, 6);
			M.setStrData("Fail", "Automation Testcase", 581, 7);

		}
		ReStart();

	}
	
	
	// Dismiss Selected Value From Dropdown
	// @Test(priority = 3)
	public void DismissSelectedValueFromDropdown() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("DismissSelectedValueFromDropdown Executed!");
		SoftAssert SA = new SoftAssert();
		int count = 0;
		int i =175;
		int k = 173;
		String str = "";

		try {
			Thread.sleep(5000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(5000);

			//Podate
			PoDate(M.getstring("Automation Test Data", i, 2),2);
			String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoDate").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 2), "After cancel PoDate it accept");			
			
			// SelectCustome
			SelectCustomer(M.getstring("Automation Test Data", i, 3),2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomer").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 3), "After cancel Customer it accept");

			//ProductCategory
			ProductCategory(M.getstring("Automation Test Data", i, 4),2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtProductCategory").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 4), " After cancel ProductCategory it accept");

			// ShipmentDate
			ShipmentDate(M.getstring("Automation Test Data", i, 6), M.getstring("Automation Test Data", ++i, 6),2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipmentDate").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 6), "After cancel ShipmentDate it accept");			

			// SelectCurrency
			Currency(M.getstring("Automation Test Data", --i, 7),2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 7), "After cancel Currency it accept");			
			
			// SelectUnitOfMeasurement
			UnitOfMeasurement(M.getstring("Automation Test Data", i, 8),2, 1);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUnitOfMeasurement").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 8), "After cancel UnitOfMeasurement it accept");
			
			// ShipMode
			ShipMode(M.getstring("Automation Test Data", i, 12),2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipMode").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 12), "After cancel ShipMode it accept");

			// POStatus
			POStatus(M.getstring("Automation Test Data", i, 13),2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPOStatus").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 13), "After cancel POStatus it accept");

			// TnaTemplate
			TnaTemplate(M.getstring("Automation Test Data", i, 14),2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTnaTemplate").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 14), "After cancel TnaTemplate it accept");
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				str = str + "\n Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
			}	
	
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			} catch (Exception y) {
				// count++;
				// str=str+"\n"+"After press back button warring message not found";
			}
			String t=PageVerification("New Export PO");
		
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
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

			

			M.ScreenShots("Screenshot/Passed", "DismissSelectedValueFromDropdown(Order)");
			M.setStrData("As Expected", "Automation Testcase", 582, 6);
			M.setStrData("Pass", "Automation Testcase", 582, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "DismissSelectedValueFromDropdown(Order)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 582, 6);
			M.setStrData("Fail", "Automation Testcase", 582, 7);

		}

		ReStart();

	}
	
	
	// Create Order
	// @Test (priority = 4)
	public void CreateOrder() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("CreateOrder Executed!");
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String successful = "";
		String mess = "";
		int count = 0;

		String button = "Create";
		String str = "";

		
		try {
			Thread.sleep(5000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();

			try {
				OrderQuality("5");
				editFOB("00");
				
				//OrderAmount
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderAmount").getText();
				// M.setStrData(gettext, "Automation Test Data", i, 11);
				Assert.assertEquals(gettext, ".00", "OrderAmount Doesn't Match");
				
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}
			
			
			try {
				OrderQuality("00");
				editFOB("05");
				
				//OrderAmount
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderAmount").getText();
				// M.setStrData(gettext, "Automation Test Data", i, 11);
				Assert.assertEquals(gettext, ".00", "OrderAmount Doesn't Match");
				
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}
			
			
			try {
				OrderQuality("-100");
				editFOB("05");
				
				//OrderAmount
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderAmount").getText();
				// M.setStrData(gettext, "Automation Test Data", i, 11);
				Assert.assertEquals(gettext, "-500.00", "OrderAmount Doesn't Match");
				
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}
			
			Thread.sleep(5000);
			M.Scroll(1);
			
			DataFillUp(175,1);
			
			try {
				//OrderAmount
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderAmount").getText();
				// M.setStrData(gettext, "Automation Test Data", i, 11);
				Assert.assertEquals(gettext, M.getstring("Automation Test Data", 175, 11), "OrderAmount Doesn't Match");
				
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}

			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				Thread.sleep(3000);
				String title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n Create Button Doesn't Work";
				throw new Exception(str);
			}
			

			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 200, 2), M.getstring("Automation Test Data", 200, 3));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message, Orders page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='New Export PO']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
							
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
			
	
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", " Create Orders");
			M.setStrData("As Expected", "Automation Testcase", 583, 6);
			M.setStrData("Pass", "Automation Testcase", 583, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", " Create Order");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 583, 6);
			M.setStrData("Fail", "Automation Testcase", 583, 7);

		}
		ReStart();
	}
	
	
	// Verify Create Order & Data 
	// @Test (priority = 5)
	public void VerifyCreateOrder_Data() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Create Order & Data Executed!");
		String order ="";
		String str ="";
		int count=0;
		int j=0;

		try {
					
			order = M.getstring("Automation Test Data",175, 1);
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			int pass = 0;
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(order)) {
					pass++;
					Thread.sleep(5000);
					M.SwipBytext(order);
					Thread.sleep(5000);
					j=counting(order);
					try {
						String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(order)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("Order didn't create");
			
			try {
				Thread.sleep(5000);
				String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
				try {
					
					Assert.assertEquals(page,"Edit Export PO","Edit Export PO page Title doesn't Match");
					
					VerifyText(175,2,1);
					
					
				}catch(AssertionError e)
				{
					count++;
					str = str + "\n" +e;
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Edit Export PO page not found check manually what happend";
				
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			PageVerification("Edit Export PO");
			
			if (count > 0) {
				System.out.println(str);
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed"," Verify Create Order & Data ");			  
		    M.setStrData("As Expected","Automation Testcase", 584, 6);
			M.setStrData("Pass","Automation Testcase", 584, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed"," Verify Create Order & Data ");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 584, 6);
			M.setStrData("Fail","Automation Testcase", 584, 7);
	
		}
		ReStart();
	}
	
	
	//Verify Orders page & List View
	// @Test (priority = 6)
	public void VerifyOrderspage_ListView() throws IOException, InterruptedException {
		
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("VerifyOrderspage_ListView Executed!");
		int count=0;
		String str="";
		String order="";
		int j=0;
		int k=177;
		String getText="";
		Thread.sleep(5000);
		try {
			//Search icon
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_search").isDisplayed();
				if(tr==true) {
					;
				}else {
					
					count++;
					str = str + "\n" + "Search icon is not display";
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Search icon is not Found";
			}
			
			//Filter
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_filter").isDisplayed();
				if(tr==true) {
					;
				}else {
					count++;
					str = str + "\n" + "Sort button is not display";
				}
					
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Sort button is not Found";
			}
			
			//create Icon
			try {
				Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").isDisplayed();
				if(tr==true) {
					;
				}else {
					
					count++;
					str = str + "\n" + "Create Icon is not Display";
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Create Icon is not Found";
			}
			
			//Order Details
			try {
				order = M.getstring("Automation Test Data",175, 1);
				Thread.sleep(5000);
				M.ScrollByText(order);
				DataUp(order);
				int pass = 0;
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(order)) {
						j=counting(order);
						System.out.println(j);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(order)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
						if(j>1) {
							j=j-2;
						}
						else {
							j--;
						}
						System.out.println(j);
						//PO Number
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 1), "PONumber Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n PONumber field Doesn't Found";
						}
						
						//Customer Short Name
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 3), "CustomerShortName Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n Customer Short Name field Doesn't Found";
						}
						
						//Product Category
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtProductCategory").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 4), "Product Category Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n Product Category field Doesn't Found";
						}
						
						//Style No
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtStyleNo").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 5), "StyleNo Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n StyleNo field Doesn't Found";
						}
						
						//Shipment Date
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtShipmentDate").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 6), "ShipmentDate Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n ShipmentDate field Doesn't Found";
						}
						
						//PO Status
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPOStatus").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 13), "POStatus Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n POStatus field Doesn't Found";
						}
						
						//Actual Shipment Date
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtActualShipmentDate").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 12), "Actual Shipment Date Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n Actual Shipment Date field Doesn't Found";
						}
						
						//Amount
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtAmount").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 11), "Amount Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n Amount field Doesn't Found";
						}
						
						//Quantity
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtQuantity").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 9), "Quantity Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n Quantity field Doesn't Found";
						}
						
						//FOB
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRate").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 10), "FOB Doesn't Match");
						}catch(Exception e) {
							count++;
							str = str + "\n FOB field Doesn't Found";
						}
						
						//Order create by FullName
						try {
							getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtMerchandiserFullName").get(j).getText();
							SA.assertEquals(getText, M.getstring("Automation Test Data", k, 2), "Create by FullName Doesn't Match");
							count++;
							str = str + "\n Create by FullName field should not show.";
						}catch(Exception e) {
							;
						}
						
						

						//ReceivedStatus Icon
						try {
							Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgLcReceivedStatus").get(j).isDisplayed();
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "ReceivedStatus Icon is not Found";
						}
						
						
						//Fabric BookingStatus Icon
						try {
							Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgFabricBookingStatus").get(j).isDisplayed();
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "BookingStatus Icon is not Found";
						}
						
						
						//Trims BookingStatus Icon
						try {
							Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgTrimsBookingStatus").get(j).isDisplayed();
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "TrimsBookingStatus Icon is not Found";
						}
						
						
						//Fabric ReceivedStatus Icon
						try {
							Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgFabricReceivedStatus").get(j).isDisplayed();
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "FabricReceivedStatus Icon is not Found";
						}
						
						
						//Trims ReceivedStatus
						try {
							Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgTrimsReceivedStatus").get(j).isDisplayed();
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "TrimsReceivedStatus Icon is not Found";
						}
						
						
						//Production Started Status Icon
						try {
							Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgProductionStartedStatus").get(j).isDisplayed();
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "ProductionStartedStatus Icon is not Found";
						}
						
						
						//Shipment Status Icon
						try {
							Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgShipmentStatus").get(j).isDisplayed();
							
						} catch (Exception e) {
							count++;
							str = str + "\n" + "ShipmentStatus Icon is not Found";
						}
						
					}
				}	

				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "order not Found";
			}
			
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			if(count>0)
			{
				//System.out.println(str);
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","VerifyOrderspage_ListView"); 
		    M.setStrData("As Expected","Automation Testcase", 585, 6);
			M.setStrData("Pass","Automation Testcase", 585, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","VerifyOrderspage_ListView");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 585, 6);
			M.setStrData("Fail","Automation Testcase", 585, 7);
			
			
		}
		
		
		ReStart();
		
	}
	
	

	//Verify Save Change Button Disable (With Blank Field) & Dismiss Unsaved Data (Default and all field)
	// @Test(priority = 7)
	public void VerifySaveChangeButtonDisable() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Save Change Button Disable When Field Blank Executed!");
		
		String str = "";
		String order = M.getstring("Automation Test Data",175, 1);
		int count = 0;
		int k = 179;
		int back = 0;
		int j = 0;
		boolean tr;
		String testdata;
		Thread.sleep(1000);
		String text = "Save Changes";
		
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			Thread.sleep(5000);
			j=counting(order);
			
			try {
				String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
				if(gettext.contentEquals(order)) {
					;
				}else {
					j++;
				}
			}catch(Exception e) {
				j++;
			}
			
			Thread.sleep(5000);
			M.SwipBytext(order);
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
			
			
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
			//check Default
			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
			} catch (Exception e) {
				count++;
				//str = str + "\n" + "No Data Edit but show warning Message";
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					 str = str + "\n" + "No Data Edit but show warning Message";
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Some thing is wrong check manually";
					throw new Exception(str);
				}
			}
			
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			
			Thread.sleep(5000);
			j=counting(order);
			try {
				String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
				if(gettext.contentEquals(order)) {
					;
				}else {
					j++;
				}
			}catch(Exception e) {
				j++;
			}
			Thread.sleep(5000);
			M.SwipBytext(order);
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
			
			
			for (int i = 0; i <= 6; i++) {
				if(i==0) {					
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "\n" + "Without change any field Save Change Button is Enabled ";
						
					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;
					
				}	
				//PoNumber	
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").clear();
					driver.hideKeyboard();
					
				}
						

				//StyleNumber
				if (i == 2) {
					Thread.sleep(5000);
					M.Scroll(1);
					PoNumber(M.getstring("Automation Test Data", k, 1));
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llStyleNumber").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtStyleNumber").clear();
					driver.hideKeyboard();

				}
				
				//OrderQuality
				if (i == 3) {
					Thread.sleep(5000);
					M.Scroll(1);
					
					StyleNumber(M.getstring("Automation Test Data", k, 5));
					Thread.sleep(2000);
					M.ScrollByText(text);
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").clear();
					driver.hideKeyboard();
				}
					
				//FOB
				if (i == 4) {
					OrderQuality(M.getstring("Automation Test Data", k, 9));
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").clear();	
					driver.hideKeyboard();
				}

				//Remarks
				if (i == 5) {
					editFOB(M.getstring("Automation Test Data", k, 10));
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").clear();
					driver.hideKeyboard();
					
				}

				// ShipmentDate
				if (i == 6) {
					Thread.sleep(5000);
					M.Scroll(2);
					DataFillUp(179,2);
				}

				M.ScrollByText(text);
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					
					if (i == 1) {
						count++;
						str = str + "\n" + "PoNumber Field is Blank But Save Changes is Enable";
					}
						
					else if (i == 2) {
						count++;
						str = str + "\n" + "StyleNumber Field is Blank But Save Changes is Enable";
					}
					else if (i == 3) {
						count++;
						str = str + "\n" + "OrderQuality Field is Blank But Save Changes is Enable";
					}
					else if (i == 4) {
						count++;
						str = str + "\n" + "FOB Field is Blank But Save Changes is Enable";
					}
					
						
					else
						;

				}else {
					
					
						
					if (i == 5) {
						count++;
						str = str + "\n" + "After Blank Remarks Field is not Mendetory But Save Changes is disable";
					}					
					else
						;
										
				}
				

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
			
			//warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 198, 3), M.getstring("Automation Test Data", 198, 4));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + confirmation;
			}
			try {
				Thread.sleep(5000);
				String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
				try {
					Thread.sleep(2000);
					M.Scroll(2);
					Thread.sleep(2000);
					VerifyText(179,2,2);
					
				}catch(AssertionError e)
				{
					count++;
					str = str + "\n" +e;
				}
				
			}catch (Exception e) {
				count++;
				
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					str = str + "\n" + "After press back and click warring message no Edit Export PO page found No button doesn't work";
				}catch (Exception x) {
					str = str + "\n" + "Edit Export PO page not found check manually what happend";
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
			
			
			// Message yes
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
			} catch (Exception e) {
				count++;
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					// System.out.println("Print Ok");
					
					str = str + "\n" + "After press Back button, Warring message not found";
				} catch (Exception x) {
					try {
						Thread.sleep(5000);
						String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
						str = str + "\n" + "After press back and click warring message yes But found Edit Export PO page, yes button doesn't work";
					}catch (Exception d) {
						str = str + "\n" + "check manually what happend";
						throw new Exception(str);
					}
				}
				
			}
			//find customer
			try {
				
				Thread.sleep(5000);
				M.ScrollByText(order);
				DataUp(order);
				Thread.sleep(5000);
				M.SwipBytext(order);
				Thread.sleep(5000);
				j=counting(order);
				try {
					String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
					if(gettext.contentEquals(order)) {
						;
					}else {
						j++;
					}
				}catch(Exception e) {
					j++;
				}
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
				
			}catch (Exception e) {
				order=M.getstring("Automation Test Data",179, 1);
				Thread.sleep(5000);
				M.ScrollByText(order);
				DataUp(order);
				Thread.sleep(5000);
				M.SwipBytext(order);
				Thread.sleep(5000);
				j=counting(order);
				try {
					String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
					if(gettext.contentEquals(order)) {
						;
					}else {
						j++;
					}
				}catch(Exception m) {
					j++;
				}
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
				
			}
			Thread.sleep(5000);
			//data verify
			try {
				
				VerifyText(175,2,1);
				
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			String t=PageVerification("Edit Export PO");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 586, 6);
			M.setStrData("Pass", "Automation Testcase", 586, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 586, 6);
			M.setStrData("Fail", "Automation Testcase", 586, 7);

		}
		ReStart();

	}
	


	// Verify Save Change Button Disabled/Enabled(Before & After Editing)
	// @Test(priority = 8)
	public void VerifySaveChangeButtonEnabled() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Change Button Disable to Enabled Executed!");
		String str = "";
		String gettext = "";
		String order = M.getstring("Automation Test Data",175, 1);
		int count = 0;
		boolean tr;
		int j=0;
		int k=175;
		Thread.sleep(1000);
		String text = "Save Changes";
		
		try {
			
			for(int i = 0; i <= 14; i++) {

				Thread.sleep(5000);
				M.ScrollByText(order);
				DataUp(order);
				Thread.sleep(1000);
				j=counting(order);
				Thread.sleep(1000);
				M.SwipBytext(order);
				try {
					gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
					if(gettext.contentEquals(order)) {
						;
					}else {
						j++;
					}
				}catch(Exception e) {
					j++;
				}
				
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
				
				Thread.sleep(5000);
				
				// Before Editing
				if (i == 0) {
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "Default Save Changes Button is Enable";

					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;

				}

				// PoNumber
				if (i == 1) {
					
					PoNumber(M.getstring("Automation Test Data", k, 1));
				}

				// PoDate
				else if (i == 2) {
					PoDate(M.getstring("Automation Test Data", k, 2),1);
					
				}
				// SelectCustomer
				else if (i == 3) {
					SelectCustomer(M.getstring("Automation Test Data", k, 3),1);
					
					
				}
				// ProductCategory
				else if (i == 4) {
					ProductCategory(M.getstring("Automation Test Data", k, 4),1);
					
				}

				// StyleNumber
				else if (i == 5) {
					StyleNumber(M.getstring("Automation Test Data", k, 5));
					
				}

				// ShipmentDate
				else if (i == 6) {
					ShipmentDate(M.getstring("Automation Test Data", k, 6), M.getstring("Automation Test Data", ++k, 6),1);
					--k;
				}
				
				//Currency
				else if (i == 7) {
					Currency(M.getstring("Automation Test Data",k, 7),1);
					
				}
				
				//UnitOfMeasurement
				else if (i == 8) {
					UnitOfMeasurement(M.getstring("Automation Test Data", k, 8),1, 2);
					
				}
				
				//OrderQuality
				else if (i == 9) {
					M.ScrollByText(text);
					Thread.sleep(2000);
					//System.out.println(M.getstring("Automation Test Data", k, 9));
					OrderQuality(M.getstring("Automation Test Data", k, 9));
					
				}
				
				//editFOB
				else if (i == 10) {
					M.ScrollByText(text);
					Thread.sleep(2000);
					editFOB(M.getstring("Automation Test Data", k, 10));
					
				}
				
				//ShipMode
				else if (i == 11) {
					M.ScrollByText(text);
					Thread.sleep(2000);
					ShipMode(M.getstring("Automation Test Data", k, 12),1);
					
				}
				
				//POStatus
				else if (i == 12) {
					M.ScrollByText(text);
					Thread.sleep(2000);
					POStatus(M.getstring("Automation Test Data", k, 13),1);
					
				}
				
				//TnaTemplate
				else if (i == 13) {
					M.ScrollByText(text);
					Thread.sleep(2000);
					TnaTemplate(M.getstring("Automation Test Data", k, 14),1);
					
				}
				
				//Remarks
				else if (i == 14) {
					M.ScrollByText(text);
					Thread.sleep(2000);
					Remarks(M.getstring("Automation Test Data", k, 15));
				}

				Thread.sleep(1000);
				M.ScrollByText(text);
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == false) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "After modify PoNumber Save Changes Button is Disable";
					else if (i == 2)
						str = str + "\n" + "After modify PoDate Save Changes Button is Disable";
					else if (i == 3)
						str = str + "\n" + "After modify SelectCustomer Save Changes Button is Disable";
					else if (i == 4)
						str = str + "\n" + "After modify ProductCategory Save Changes Button is Disable";
					else if (i == 5)
						str = str + "\n" + "After modify StyleNumber Save Changes Button is Disable";
					else if (i == 6)
						str = str + "\n" + "After modify ShipmentDate Save Changes Button is Disable";
					else if (i == 7)
						str = str + "\n" + "After modify Currency Save Changes Button is Disable";
					else if (i == 8)
						str = str + "\n" + "After modify UnitOfMeasurement Save Changes Button is Disable";
					else if (i == 9)
						str = str + "\n" + "After modify OrderQuality Save Changes Button is Disable";
					else if (i == 10)
						str = str + "\n" + "After modify editFOB Save Changes Button is Disable";
					else if (i == 11)
						str = str + "\n" + "After modify ShipMode Save Changes Button is Disable";
					else if (i == 12)
						str = str + "\n" + "After modify POStatus Save Changes Button is Disable";
					else if (i == 13)
						str = str + "\n" + "After modify TnaTemplate Save Changes Button is Disable";
					else if (i == 14)
						str = str + "\n" + "After modify Remarks Save Changes Button is Disable";
					
				}
				
				
				if(i!=15) {
					//Back Button!!
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
						
					}catch (Exception e) {
						Thread.sleep(5000);
						M.BackFun(1);
					}
					

					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception e) {
						;
					}
					
				}
			}
			
			try {
				
				SA.assertAll();
				
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
					
			}
			

			Thread.sleep(3000);
			String test=PageVerification("Edit Export PO");
			if(test.isBlank()) {
				;
			}else {
				count++;
				str = str +test;
			}
			
			
			if (count > 0) {
				System.out.println(str);
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 587, 6);
			M.setStrData("Pass", "Automation Testcase", 587, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 587, 6);
			M.setStrData("Fail", "Automation Testcase", 587, 7);

		}
		ReStart();

	}

	
	
	//Dismiss Unsaved Data In Existing Order (For Each Field)
	// @Test(priority = 9)
	public void DismissUnsavedDataForEach() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Change Button Disable to Enabled Executed!");
		String str = "";
		String gettext = "";
		String order = M.getstring("Automation Test Data",175, 1);
		int count = 0;
		int j = 0;
		int k= 179;
		int r= 175;
		boolean tr;
		String testdata;
		Thread.sleep(1000);
		String text = "Save Changes";
		
		try {
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			Thread.sleep(5000);
			M.SwipBytext(order);
			Thread.sleep(5000);
			j=counting(order);
			try {
				gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
				if(gettext.contentEquals(order)) {
					;
				}else {
					j++;
				}
			}catch(Exception e) {
				j++;
			}
			
			driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
			
			for (int i = 1; i <= 14; i++) {

				// Before Editing

				// PoNumber
				if (i == 1) {
					
					PoNumber(M.getstring("Automation Test Data", k, 1));
					
				}

				// PoDate
				else if (i == 2) {
					PoDate(M.getstring("Automation Test Data", k, 2),1);
					
				}
				// SelectCustomer
				else if (i == 3) {
					SelectCustomer(M.getstring("Automation Test Data", k, 3),1);
					
					
				}
				// ProductCategory
				else if (i == 4) {
					ProductCategory(M.getstring("Automation Test Data", k, 4),1);
					
					
				}

				// StyleNumber
				else if (i == 5) {
					StyleNumber(M.getstring("Automation Test Data", k, 5));
					
				}

				// ShipmentDate
				else if (i == 6) {
					ShipmentDate(M.getstring("Automation Test Data", k, 6),M.getstring("Automation Test Data", ++k, 6),1);
					
				}
				
				//Currency
				else if (i == 7) {
					Currency(M.getstring("Automation Test Data",--k, 7),1);
					
				}
				
				//UnitOfMeasurement
				else if (i == 8) {
					UnitOfMeasurement(M.getstring("Automation Test Data", k, 8),1, 2);
					
				}
				
				//OrderQuality
				else if (i == 9) {
					M.ScrollByText(text);
					OrderQuality(M.getstring("Automation Test Data", k, 9));
					
				}
				
				//editFOB
				else if (i == 10) {
					M.ScrollByText(text);
					editFOB(M.getstring("Automation Test Data", k, 10));
					
				}
				
				//ShipMode
				else if (i == 11) {
					M.ScrollByText(text);
					ShipMode(M.getstring("Automation Test Data", k, 12),1);
					
				}
				
				//POStatus
				else if (i == 12) {
					M.ScrollByText(text);
					POStatus(M.getstring("Automation Test Data", k, 13),1);
					
				}
				
				//TnaTemplate
				else if (i == 13) {
					M.ScrollByText(text);
					TnaTemplate(M.getstring("Automation Test Data", k, 14),1);
					
				}
				
				//Remarks
				else if (i == 14) {
					M.ScrollByText(text);
					Remarks(M.getstring("Automation Test Data", k, 15));
				}

				Thread.sleep(1000);

				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
					
				}catch (Exception e) {
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				//warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 198, 3), M.getstring("Automation Test Data", 198, 4));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + confirmation;
				}
				
				try {
					Thread.sleep(5000);
					String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
					if (i == 1) {
						// PoNumber
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 1);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 1), "PoNumber Doesn't Match");
						
					}
					else if (i == 2){
						// PoDate
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoDate").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 2);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 181, 2), "PoDate Doesn't Match");

					}
					else if (i == 3){
						// CustomerSelect
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomer").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 3);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 3), "CustomerSelect Doesn't Match");

					}
					else if (i == 4){
						// ProductCategory
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtProductCategory").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 4);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 4), "ProductCategory Doesn't Match");

						
					}
					else if (i == 5){
						// StyleNumber
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtStyleNumber").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 5);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 5), "StyleNumber Doesn't Match");

						
					}
					else if (i == 6){
						// ShipmentDate
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipmentDate").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 6);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 181, 4), "ShipmentDate Doesn't Match");

					}
					
					else if (i == 7){
						// SelectCurrency
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 7);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 7), "Currency Doesn't Match");

					}
					
					else if (i == 8){
						// SelectUnitOfMeasurement
						Thread.sleep(5000);
						M.Scroll(1);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUnitOfMeasurement").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 8);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 8), "UnitOfMeasurement Doesn't Match");

					}
					
					else if (i == 9){
						// OrderQuality
						Thread.sleep(1000);
						M.ScrollByText(text);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 9);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 9), "OrderQuality Doesn't Match");

					}
					
					else if (i == 10){
						// editFOB
						Thread.sleep(1000);
						M.ScrollByText(text);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 10);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 10), "edtFOB Doesn't Match");

					}
					
					else if (i == 11){
						// ShipMode
						Thread.sleep(1000);
						M.ScrollByText(text);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipMode").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 12);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 12), "ShipMode Doesn't Match");
						
					}
					
					else if (i == 12){
						// POStatus
						Thread.sleep(1000);
						M.ScrollByText(text);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPOStatus").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 13);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 13), "POStatus Doesn't Match");

					}
					
					else if (i == 13){
						// TnaTemplate
						Thread.sleep(1000);
						M.ScrollByText(text);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTnaTemplate").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 14);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 14), "TnaTemplate Doesn't Match");

					}
					
					else if (i == 14){
						// Remarks
						Thread.sleep(1000);
						M.ScrollByText(text);
						gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").getText();
						// M.setStrData(gettext, "Automation Test Data", i, 15);
						SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 15), "Remarks Doesn't Match");

					}
					
					/*
					try {
						SA.assertAll();
					} catch (AssertionError e) {
						count++;
						str = str + "\n" + e;
					}*/
					
				}catch (Exception e) {
					count++;						
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
						str = str + "\n"+i + " :After change and press back, Edit Export PO page not found";
					}catch (Exception x) {
						str = str + "\n" + "Edit Export PO page not found check manually what happend";
					}						
					throw new Exception(str);
				}
				
			
				try {
					String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
					//Back Button!!
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
						
					}catch (Exception e) {
						Thread.sleep(5000);
						M.BackFun(1);
					}
					try {
						Thread.sleep(100);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
					}catch (Exception e) {
						;
					}
					
					Thread.sleep(3000);
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					}catch (Exception d) {
						count++;
						str = str + "\n" + "After press back and click warring message yes Orders page not found";
						throw new Exception(str);
					}
					
				} catch (Exception e) {
					//count++;
					try {
						Thread.sleep(5000);
						String page=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
						//str = str + "\n" + "After press back and click warring message yes But found customer Detail page, yes button doesn't work";
					}catch (Exception d) {
						//str = str + "\n" + "check manually what happend";
					}
					
					//throw new Exception(str);
				}
				//find customer
				try {
					Thread.sleep(5000);
					M.ScrollByText(order);
					DataUp(order);
					Thread.sleep(5000);
					M.SwipBytext(order);
					Thread.sleep(5000);
					j=counting(order);
					try {
						gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(order)) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
					
				}catch (Exception e) {
					Thread.sleep(5000);
					order=M.getstring("Automation Test Data",179, 2);
					Thread.sleep(5000);
					M.ScrollByText(order);
					DataUp(order);
					Thread.sleep(5000);
					M.SwipBytext(order);
					Thread.sleep(5000);
					j=counting(order);
					try {
						gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(order)) {
							;
						}else {
							j++;
						}
					}catch(Exception m) {
						j++;
					}
					driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
					
				}
				

			}
		
			try {
				SA.assertAll();
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			Thread.sleep(3000);
			String t=PageVerification("Edit Export PO");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}
			
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 588, 6);
			M.setStrData("Pass", "Automation Testcase", 588, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 588, 6);
			M.setStrData("Fail", "Automation Testcase", 588, 7);

		}
		ReStart();

	}
	
	
	
	// Dismiss Selected Value From Dropdown In Existing Order
	// @Test(priority = 10)
	public void DismissSelectedValueFromDropdown_Existing_Order() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("DismissSelectedValueFromDropdown_Existing_Order Executed!");
		SoftAssert SA = new SoftAssert();
		int count = 0;
		int i = 179;
		int k = 175;
		int j = 0;
		String str = "";
		String order = M.getstring("Automation Test Data", 175, 1);

		try {
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			Thread.sleep(5000);
			M.SwipBytext(order);
			Thread.sleep(5000);
			j=counting(order);
			try {
				String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
				if(gettext.contentEquals(order)) {
					;
				}else {
					j++;
				}
			}catch(Exception e) {
				j++;
			}
			
			driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
			
			Thread.sleep(5000);
			
			// Podate
			PoDate(M.getstring("Automation Test Data", i, 2), 2);
			String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoDate").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 181, 1), "After cancel PoDate it accept");

			// SelectCustome
			SelectCustomer(M.getstring("Automation Test Data", i, 3), 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomer").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 3), "After cancel Customer it accept");

			// ProductCategory
			ProductCategory(M.getstring("Automation Test Data", i, 4), 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtProductCategory").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 4),
					" After cancel ProductCategory it accept");

			// ShipmentDate
			ShipmentDate(M.getstring("Automation Test Data", i, 6),M.getstring("Automation Test Data", ++i, 6), 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipmentDate").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", 181, 3), "After cancel ShipmentDate it accept");

			// SelectCurrency
			Currency(M.getstring("Automation Test Data", --i, 7), 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCurrency").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 7), "After cancel Currency it accept");

			// SelectUnitOfMeasurement
			UnitOfMeasurement(M.getstring("Automation Test Data", i, 8), 2, 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUnitOfMeasurement").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 8),
					"After cancel UnitOfMeasurement it accept");

			// ShipMode
			ShipMode(M.getstring("Automation Test Data", i, 12), 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShipMode").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 12), "After cancel ShipMode it accept");

			// POStatus
			POStatus(M.getstring("Automation Test Data", i, 13), 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPOStatus").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 13), "After cancel POStatus it accept");

			// TnaTemplate
			TnaTemplate(M.getstring("Automation Test Data", i, 14), 2);
			gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTnaTemplate").getText();
			SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 14), "After cancel TnaTemplate it accept");

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				str = str + "\n Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			} catch (Exception y) {
				// count++;
				// str=str+"\n"+"After press back button warring message not found";
			}
			String page = PageVerification("Edit Export PO");

			if (page.isBlank()) {
				;
			} else {
				count++;
				str = str + page;
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

			try {
				SA.assertAll();
			} catch (AssertionError e) {
				throw new Exception(e);
			}

			M.ScreenShots("Screenshot/Passed", "DismissSelectedValueFromDropdown(Existing Order)");
			M.setStrData("As Expected", "Automation Testcase", 589, 6);
			M.setStrData("Pass", "Automation Testcase", 589, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "DismissSelectedValueFromDropdown(Existing Order)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 589, 6);
			M.setStrData("Fail", "Automation Testcase", 589, 7);

		}

		ReStart();

	}
	
	
	
	// Update Existing Order
	// @Test (priority = 11)
	public void UpdateOrder() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Update Order Executed!");
		SoftAssert SA = new SoftAssert();
		String gettext = "";
		String successful = "";
		int count = 0;
		String button = "Save Change";
		int j = 0;
		String str = "";
		String order = M.getstring("Automation Test Data", 175, 1);

		
		try {
			Thread.sleep(5000);
			M.ScrollByText(order);
			DataUp(order);
			Thread.sleep(5000);
			M.SwipBytext(order);
			Thread.sleep(5000);
			j=counting(order);
			try {
				gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
				if(gettext.contentEquals(order)) {
					;
				}else {
					j++;
				}
			}catch(Exception e) {
				j++;
			}
			
			driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
			Thread.sleep(5000);
			
			DataFillUp(179,2);
			
			try {
				//OrderAmount
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderAmount").getText();
				// M.setStrData(gettext, "Automation Test Data", i, 11);
				Assert.assertEquals(gettext, M.getstring("Automation Test Data", 179, 11), "OrderAmount Doesn't Match");
				
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}

			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				Thread.sleep(3000);
				String title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n Save Change Button Doesn't Work";
				throw new Exception(str);
			}
			
			//warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 200, 6), M.getstring("Automation Test Data", 200, 7));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + confirmation;
			}
			
			try {
				Thread.sleep(2000);
				M.Scroll(2);
				Thread.sleep(2000);
				VerifyText(179,2,2);
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}

			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n Save Change & Yes Button Doesn't Work";
				throw new Exception(str);
			}
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 200, 4), M.getstring("Automation Test Data", 200, 5));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}
			

			try {
				Thread.sleep(1000);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
				
				try {
					Thread.sleep(1000);
					Boolean tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if(tr==true) {
						count++;
						str = str + "\n" + "After sucessfull ok, Save Change button is Enable";
					}
				}catch (Exception e) {
					;
				}
				
				Thread.sleep(5000);
				M.BackFun(1);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
				}catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After click ok sucessful message, Edit Export PO Page not found";
				
				try {					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					count++;
					str = str + "\n" + "After sucessfull ok, it redirect to order page";
				}catch (Exception y) {
					count++;
					str = str + "\n" + "After sucessfull ok,check manually";
				}
			}
			
			String page = PageVerification("Edit Export PO");

			if (page.isBlank()) {
				;
			} else {
				count++;
				str = str + page;
			}
			
	
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", " Update Order");
			M.setStrData("As Expected", "Automation Testcase", 590, 6);
			M.setStrData("Pass", "Automation Testcase", 590, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", " Update Order");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 590, 6);
			M.setStrData("Fail", "Automation Testcase", 590, 7);

		}
		ReStart();
	}
	

	
	// Verify Update Existing Order & Data 
	// @Test (priority = 12)
	public void VerifyUpdateExistingOrder_Data () throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Update Existing Order & Data Executed!");
		String order ="";
		String str ="";
		int count=0;
		int j=0;
		Thread.sleep(5000);
		try {
			try {
				order = M.getstring("Automation Test Data",179, 1);
				Thread.sleep(5000);
				M.ScrollByText(order);
				DataUp(order);
				int pass = 0;
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(order)) {
						Thread.sleep(5000);
						M.SwipBytext(order);
						Thread.sleep(5000);
						j=counting(order);
						try {
							String gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
							if(gettext.contentEquals(order)) {
								;
							}else {
								j++;
							}
						}catch(Exception e) {
							j++;
						}
						
						driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						break;

					}

				}
				
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "After Update Existing Order but Update Order not Found";
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(5000);
				String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
				try {
					
					VerifyText(179,2,2);
					
					
				}catch(AssertionError e)
				{
					count++;
					str = str + "\n" +e;
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Edit Export PO page not found check manually what happend";
				
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			String page = PageVerification("Edit Export PO");

			if (page.isBlank()) {
				;
			} else {
				count++;
				str = str + page;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Verify Update Existing Order & Data");			  
		    M.setStrData("As Expected","Automation Testcase", 591, 6);
			M.setStrData("Pass","Automation Testcase", 591, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Update Existing Order & Data");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 591, 6);
			M.setStrData("Fail","Automation Testcase", 591, 7);
	
		}
		ReStart();
	}
	
	
	
	// Verify Export PO's Order View
	// @Test (priority = 13)
	public void Verify_ExportPO_OrderinfoView() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify_ExportPO_OrderinfoView Executed!");
		String order ="";
		String str ="";
		String gettext ="";
		int count=0;
		int i=183;
		int j=185;
		
		try {
			order = M.getstring("Automation Test Data",179, 1);
			Thread.sleep(5000);
			M.ClickOn(order);
			Thread.sleep(5000);
			try {
				gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				gettext=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Order\"]").getText();
				
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Order\"]").click();
			
			}catch(Exception e) {
				count++;
				str = str + "\n" + "After Click Selected value order info or order tab not found";
				throw new Exception(str);
			}
			try {
				//Po Number
				
				gettext=driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 1),"PO Number label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtPONumber")).getText();
				SA.assertEquals(gettext,M.getstring("Automation Test Data",j, 1),"PO Number doesn't Match");
				
				//Customer
				
				gettext=driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 2),"Customer Name label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtCustomer")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 2),"Customer Name doesn't Match");
				
				//Product Category
				
				gettext=driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 3),"Product Category label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtProductCategory")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 3),"Product Category doesn't Match");
				
				//StyleNumber

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 4),"Style Number label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtStyleNumber")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 4),"Style Number doesn't Match");
				
				//Order Quantity

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[5]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 5),"Order Quantity label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtOrderQuantity")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 5),"Order Quantity doesn't Match");
				
				//FOB

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[6]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 6),"FOB label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtFOB")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 6),"FOB doesn't Match");	
				
				Thread.sleep(3000);
				M.ScrollDwon(2);
				
				//OrderAmount

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 7),"OrderAmount label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtOrderAmount")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 7),"OrderAmount doesn't Match");
						
				//PODate

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 8),"PO Date label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtPODate")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 8),"PO Date doesn't Match");

				//ShipmentDate

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 9),"Shipment Date label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtShipmentDate")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 9),"Shipment Date doesn't Match");
				
				//ShipmentMode
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtShipmentMode")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",179, 12),"Shipment Mode Doesn't Match");			
				
				//Merchandiser

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[5]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 10),"Merchandiser label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtMerchandiser")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 10),"Merchandiser doesn't Match");

				//POStatus

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[6]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 11),"POStatus label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtPOStatus")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 11),"POStatus doesn't Match");

				//LC Number (LC)

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[7]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 12),"LC Number label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtLCNumbee")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 12),"LC Number doesn't Match");
				
				
				//TemplateName

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[8]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 13),"TemplateName label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtTemplateName")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 13),"TemplateName doesn't Match");
				
				//Actual Ship Date

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 14),"Actual Ship Date label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtActualShipmentDate")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 14),"Actual Ship Date doesn't Match");
				
				//Actual Ship Quantity

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[10]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 15),"Actual Ship Quantity label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtActualShipQuantity")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 15),"Actual Ship Quantity doesn't Match");
				
				//Actual Ship Value

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[11]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 16),"Actual Ship Value label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtActualShipValue")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 16),"Actual Ship Value doesn't Match");
				
				//Delayed Ship Liability Value

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[12]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 17),"Delayed Ship Liability Value label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/txtDelayedShipLiabilityValue")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 17),"Delayed Ship Liability Value doesn't Match");

				//remarks

				gettext=driver.findElementByXPath("//android.widget.LinearLayout[13]/android.widget.TextView").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",i, 18),"remarks label doesn't Match");
				
				gettext=driver.findElement(By.id("bd.com.cslsoft.kandareeliteapp:id/remarks")).getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data",j, 18),"remarks doesn't Match");
				
				Thread.sleep(5000);
				M.BackFun(1);
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Order info label or data not found: "+e;
			}
			
			String page = PageVerification("Order Information");
			if (page.isBlank()) {
				;
			} else {
				count++;
				str = str + page;
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
			M.ScreenShots("Screenshot/Passed","Verify_ExportPO_OrderinfoView"); 
		    M.setStrData("As Expected","Automation Testcase", 592, 6);
			M.setStrData("Pass","Automation Testcase", 592, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify_ExportPO_OrderinfoView");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 592, 6);
			M.setStrData("Fail","Automation Testcase", 592, 7);
			
			
		}
		
		
		ReStart();
	}
		
	
	// Verify Orderinfo Task List Data
	// @Test (priority = 14)
	public void Verify_Orderinfo_TaskListData()throws IOException, InterruptedException, ParseException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Orderinfo Task List Data Executed!");
		int count=0;
		int k=187;
		int pass=0;
		int taskcount=0;
		String str="";
		String gettext="";
		String taskdis="";
		
		//System.out.println(date);
		
		try {
		
			//Data collect from template
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",179, 14));	
				
				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
				taskcount=xyz.size();
				//System.out.println(taskcount);
				for (int i= 0; i < xyz.size(); i++) {
					//System.out.println(taskcount);
					gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc").get(i).getText();
					M.setStrData(gettext, "Automation Test Data",k, 1);
					
					gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskCategory").get(i).getText();
					M.setStrData(gettext, "Automation Test Data",k, 2);
					
					
					
					gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtMileStoneEvent").get(i).getText();
					
					//find out the day
					String days=M.extractInt(gettext);
					
					
					int index=gettext.indexOf("+");
					if (index==-1) {
						index=gettext.indexOf("-");
						days="-"+days;
					}else
						days="+"+days;
					
					M.setStrData(days, "Automation Test Data",k, 3);
					
					gettext=gettext.substring(0,index);
					M.setStrData(gettext, "Automation Test Data",k, 4);
					
					gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskAssignor").get(i).getText();
					M.setStrData(gettext, "Automation Test Data",k, 5);
					
					k++;
					
				}
				
				k=187;
				
				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(5000);
				//Go to Order page
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				 
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.findElementByXPath("//android.widget.TextView[@text='My Orders']").click();
			    Thread.sleep(5000);
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Data doesn't collect from template check manually";
			}
			
			//deadline date genarate/calculation
			try {
				for(int i=1;i<=taskcount;i++) {
					int Eday=Integer.parseInt(M.getstring("Automation Test Data",k, 3));
					String date;
					if(M.getstring("Automation Test Data",k, 4).contentEquals("PO Shipment Date ")) {
						
						date=M.ChangeFormate_Date(M.getstring("Automation Test Data",180, 6),Eday);
					}else
						date=M.ChangeFormate_Date(M.getstring("Automation Test Data",179, 2),Eday);
					
					M.setStrData(date, "Automation Test Data",k, 4);
					k++;
				}
				k=187;
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Date doesn't modify check manually";
			}
			
	
			// Orderinfo task
			try {
				
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",179, 1));	
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(5000);
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				
				if(taskcount!=xyz.size()) {
					count++;
					str = str + "\n" + "Template Task and Order info task are not Equal";
				}
				//System.out.println(xyz.size());
				for (int j=0;j<xyz.size() ; j++) {

					taskdis=M.getstring("Automation Test Data",k, 1)+"-"+M.getstring("Automation Test Data",179, 1);
					M.setStrData(taskdis, "Automation Test Data",k,7);
					//System.out.println(taskdis);
					for (int i=0; i < xyz.size();i++ ) {
						if(xyz.get(i).getText().contentEquals(taskdis)) {
							//System.out.println(i);
							//task icon
							try {
								Boolean tr=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/imgTaskIcon").get(i).isDisplayed();
								if(tr==false) {
									count++;
									str = str + "\n" + taskdis+" task logo doesn't show";
								}
									
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" Task Logo not found";
							}
							
							//Task Deadline
							try {
								gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDeadline").get(i).getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",k, 4),taskdis+" Deadline doesn't Match");
								//System.out.println(gettext);
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" TaskDeadline not found";
							}
							
							//Task Category
							try {
								gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskCategory").get(i).getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",k, 2),taskdis+" TaskCategory doesn't Match");
								//System.out.println(gettext);
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" TaskCategory not found";
							}
							
							
							
							//Task Status
							try {
								gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus").get(i).getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",190, 1),taskdis+" TaskStatus doesn't Match");
								//System.out.println(gettext);
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" TaskStatus not found";
							}
							
							//Assign Date Lable
							try {
								i++;
								gettext = driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]").getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",190, 2),taskdis+" Assign Date lable doesn't Match");
								//System.out.println(gettext);
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" Assign Date lable not found";
							}
							
							//Assignee lable
							try {
								i--;
								gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/assigned_Id").get(i).getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",190, 3),taskdis+" assignee lable doesn't Match");
								//System.out.println(gettext);
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" assignee lable not found";
							}
							
							// Assigner Lable
							try {
								gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/assigner_Id").get(i).getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",190, 4),taskdis+" assigner lable doesn't Match");
								//System.out.println(gettext);
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" Assigner lable not found";
							}
							
							//Assignee Name 
							try {
								gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtAssignee").get(i).getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",k, 5),taskdis+" Assignee doesn't Match");
								//System.out.println(gettext);
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" Assignee not found";
							}
							
							// Assigner Name
							try {
								
								gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtAssigner").get(i).getText();
								SA.assertEquals(gettext,M.getstring("Automation Test Data",190, 5),taskdis+" Assigner doesn't Match");
								//System.out.println(gettext);
								
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" Assigner not found";
							}
							
							// Assignee call button
							try {
								i++;
								driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.ImageView").click();
								//SA.assertEquals(gettext,M.getstring("Automation Test Data",190, 2),taskdis+" Assign Date lable doesn't Match");
								//System.out.println(gettext);
								try {
									gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
									Thread.sleep(5000);
									M.BackFun(2);
								}catch(Exception e) {
									count++;
									str = str + "\n" + taskdis+" Assignee phone number is Blank";
									Thread.sleep(5000);
									M.BackFun(1);
								}
								
								
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" Assignee call button not found";
							}
							
							// Assigner call button
							try {
								driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageView").click();
								//SA.assertEquals(gettext,M.getstring("Automation Test Data",190, 2),taskdis+" Assign Date lable doesn't Match");
								//System.out.println(gettext);
								
								
								try {
									gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
									Thread.sleep(5000);
									M.BackFun(2);
								}catch(Exception e) {
									//System.out.println("ok");
									count++;
									str = str + "\n" + taskdis+" Assigner phone number is Blank";
									Thread.sleep(5000);
									M.BackFun(1);
								}
								
							}catch(Exception e) {
								count++;
								str = str + "\n" + taskdis+" Assigner call button not found";
							}
							i=xyz.size();
							pass++;
						}
						
					}
					if(pass==0) {
						count++;
						str = str + "\n" +taskdis+ " Task not found";
						pass=0;
					}
					
					k++;
					
				}
				
			}catch(Exception e) {
				//System.out.println("Not ok");
				count++;
				str = str + "\n" +e;
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			String page = PageVerification("Order Information");
			if (page.isBlank()) {
				;
			} else {
				count++;
				str = str + page;
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
			M.ScreenShots("Screenshot/Passed","Verify Library Entity Type"); 
		    M.setStrData("As Expected","Automation Testcase", 593, 6);
			M.setStrData("Pass","Automation Testcase", 593, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Library Entity Type");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 593, 6);
			M.setStrData("Fail","Automation Testcase", 593, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
	//VerifyTaskDetail_ContentLabels
	// @Test (priority = 15)
	public void VerifyTaskDetail_ContentLabels() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("VerifyTaskDetail_ContentLabels Executed!");
		String CreateTask ="";
		String str ="";
		int count=0;
		int k=194;
		String testdata="";
		try {
			
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data",179, 1));	
			
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data",188, 7));	
			Thread.sleep(5000);
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
			for (int i = 1; i <=15 ; i++) {
				int pass = 0;
				if(i==10) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					 xyz = driver.findElementsByClassName("android.widget.TextView");
				}
				//System.out.println(i);
				for(int j=0;j<xyz.size();j++) {
					//System.out.println(xyz.get(j).getText());
					if (M.getstring("Automation Test Data", 192, i).contentEquals(xyz.get(j).getText())) {
						pass++;
						j=xyz.size();
						}
						
					}	
				
					if(pass==0) {
						count++;
						str = str + "\n" +M.getstring("Automation Test Data", 192, i)+" label Not found";
					}
	
				}
			Thread.sleep(5000);
			M.Scroll(1);
			try {
			//Task Description 1
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
			SA.assertEquals(testdata,M.getstring("Automation Test Data",188,7),"Task Description Name Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Task Description Field not Found";
			}
			try {
				//CategoryValue 2
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,3),"Category Value Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Category Field not Found";
			}
			try {
				//Assignee Name 3
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tx_assigneeName").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,2),"Assignee Name Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Assignee Name Field not Found";			
			}
			try {	
				//OriginalAssinee 3
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_originalAssineeValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,2),"Original Assinee Name Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Original Assinee Name Field not Found";
			}
			try {
				//Assigned by Name 3
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_assignerName").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,1),"Assigned by Name Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Assigned by Name Field not Found";
			}
			try {
				//OriginalAssiner 3
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_originalAssinerValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,1),"Original Assiner Name Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Original Assiner Name Field not Found";
			}
			
			try {
				//date format change
				SimpleDateFormat sdf= new SimpleDateFormat("dd MMMM yyyy");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				Date currentDate=formatter.parse(M.getstring("Automation Test Data",188,4));  
				String strDate= sdf.format(currentDate);
				
				//deadline 4
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
				SA.assertEquals(testdata,strDate,"Deadline Doesn't Match");
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Deadline Field not Found";
			}
			try {
				//Assigned Date 5
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_assignedDate").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,4),"Assigned Date Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Assigned Date Field not Found";
			}
			try {
				//CompletionDate
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_completionDateValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,7),"Completion Date Should be Blank");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Completion Date Field not Found";
			}
			try {
				//Status Value
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_statusValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,8),"status Value Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"status Field not Found";
			}

			Thread.sleep(5000);
			M.ScrollDwon(1);
			try {			
				//Customer 
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_customerValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,9),"Customer Name Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Customer Field not Found";
			}
			try {
				//PoNumber 
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_poNumberValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,10),"PoNumber Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"PoNumber Field not Found";
			}
			try {
				//StyleNumber 
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_styleNumberValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,11),"StyleNumber Name Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"StyleNumber Field not Found";
			}
			try {
				//TemplateName 
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_templateNameValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,12),"TemplateName Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"TemplateName Field not Found";
			}
			try {
				//OrderTaskType 
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtOrderTaskType").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,13),"OrderTaskType Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"OrderTaskType Field not Found";
			}
			try {
				//CriticalTask 
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtCriticalTask").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,14),"CriticalTask Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"CriticalTask Field not Found";
			}
			try {
				//Remarks 
				testdata=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/remarks").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",k,15),"Remarks Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Remarks Field not Found";
			}

			
			
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				
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
			
			
			
			M.ScreenShots("Screenshot/Passed","VerifyTaskDetail_ContentLabels");			  
		    M.setStrData("As Expected","Automation Testcase", 594, 6);
			M.setStrData("Pass","Automation Testcase", 594, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","VerifyTaskDetail_ContentLabels");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 594, 6);
			M.setStrData("Fail","Automation Testcase", 594, 7);
	
		}
		ReStart();
		

}
	
	
	
	// Dismiss Selected Value From Dropdown and Edit Field(task)
	// @Test (priority = 16)
	public void DismissSelectedValueFromDropdown_EditField()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Dismiss Selected Value From Dropdown and Edit Field Executed!");
		int count=0;
		String str="";
		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",179, 1));	
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data",188, 7));	
				Thread.sleep(5000);
			}catch(Exception e) {
				count++;
				str = str + "\n" + e;
			}
			
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_task_edit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").clear();

				//Task Description 
				String testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").getText();
				SA.assertEquals(testdata,"Enter value","Task Description text place holder not match");
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").sendKeys(M.getstring("Automation Test Data",196,1));
				driver.hideKeyboard();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				Thread.sleep(2000);
				
				//Task Description 
				testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",188,7),"Task Description Name Doesn't Match after dismiss");
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + e;
			}
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_deadline_edit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.view.View[@content-desc=\"" + M.getstring("Automation Test Data",196,2) + "\"]").click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("android:id/button2").click();
				Thread.sleep(2000);
				
				//date format change
				SimpleDateFormat sdf= new SimpleDateFormat("dd MMMM yyyy");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				Date currentDate=formatter.parse(M.getstring("Automation Test Data",188,4));  
				String strDate= sdf.format(currentDate);
				
				//deadline
				String testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
				SA.assertEquals(testdata,strDate,"Deadline Doesn't Match");
				
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + e;
			}
			
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_category_edit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				M.ClickOn(M.getstring("Automation Test Data",196,3));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
				Thread.sleep(2000);
				
				//CategoryValue 2
				String testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
				SA.assertEquals(testdata,M.getstring("Automation Test Data",194,3),"Category Value Doesn't Match after dismiss");
				
			}catch(Exception e) {
				count++;
				str = str + "\n" + e;
			}
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(2);
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
			M.ScreenShots("Screenshot/Passed","Dismiss Selected Value From Dropdown and Edit Field"); 
		    M.setStrData("As Expected","Automation Testcase", 595, 6);
			M.setStrData("Pass","Automation Testcase", 595, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Selected Value From Dropdown and Edit Field");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 595, 6);
			M.setStrData("Fail","Automation Testcase", 595, 7);
			
			
		}
		
		
		ReStart();
	}
	
	
	
	// Verify Adding Comments & Replies in Task Details
	// @Test (priority = 17)
	public void AddingComments_Replies() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Adding Comments & Replies in Task Details Executed!");
		int count = 0;
		String str = "";
		String Stext = "";
		String getText = "";
		String CreateTask = "";
		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 187, 7));
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}
			for (int i = 0; i < 2; i++) {
				Thread.sleep(5000);
				M.ScrollDwon(1);

				if (i == 0) {
					// Add comment button
					try {
						getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 1),
								"Add Comment text Doesn't Match");
						Boolean t = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").isEnabled();
						
						if (t == true) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").click();
							Thread.sleep(1000);
						} else
							throw new Exception("Add Comment button is not Enable");
					} catch (Exception e) {
						throw new Exception("Add comment Button not found");
					}

				} else {
					// Reply
					try {
						getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 8),"Reply text Doesn't Match");
						Boolean t = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").isEnabled();
						if (t == true) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").click();
							Thread.sleep(1000);
						} else {
							str = str + "\n" + "Reply button is not Enable";
							try {
								SA.assertAll();

							} catch (AssertionError x) {
								str = str + "\n" + x;
								throw new Exception(str);
							}

						}
					} catch (Exception e) {
						throw new Exception("Reply Button not found");
					}
					i = 7;
				}

				// comment title
				try {
					String title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_name").getText();
					SA.assertEquals(title, M.getstring("Automation Test Data", 98, i + 2),"Add Comment Title Doesn't Match");

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Add Comment Title Not Found";
				}
				getText = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").getText();
				SA.assertEquals(getText, M.getstring("Automation Test Data", 98, i + 3),"Comment text place holder Doesn't Match");

				// Comment cancel
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").sendKeys(M.getstring("Automation Test Data", 98, i + 4));
				driver.hideKeyboard();
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();

					// task details page
					try {
						String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					} catch (Exception e) {
						throw new Exception("Task Detail page not found After Cancel Comment");
					}
				} catch (Exception e) {
					throw new Exception(M.getstring("Automation Test Data", 98, i + 1) + " Comment Cancel Button doesn't Found");
				}

				Thread.sleep(5000);
				M.ScrollDwon(1);
				try {
					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtComments");
					for (int j = 0; j < xyz.size(); j++) {
						if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", 98, i + 4))) {
							count++;
							str = str + "\n" + M.getstring("Automation Test Data", 98, i + 1)+ " added After click cancel button";
						}
					}
				} catch (Exception e) {
					;
				}

				if (i == 0)
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_add_comment").click();
				else
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btn_replay").click();

				// Comment done
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value")
						.sendKeys(M.getstring("Automation Test Data", 98, i + 4));
				driver.hideKeyboard();
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
					Thread.sleep(2000);
					Stext = M.Sucessfull_Message(M.getstring("Automation Test Data", 104, 2),M.getstring("Automation Test Data", 104, 3));
					if (Stext.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + M.getstring("Automation Test Data", 104, i + 1) + Stext;
					}

				} catch (Exception e) {
					throw new Exception("Comment Done Button doesn't Found");
				}
				// task details page
				try {
					Thread.sleep(1000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					Thread.sleep(1000);
				} catch (Exception e) {
					Thread.sleep(5000);
					M.ClickOn(M.getstring("Automation Test Data", 187, 7));
					
					count++;
					str = str + "\n" + " Task Detail page not found After Done Add Comment";
				}

				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				int pass = 0;
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtComments");
				for (int j = 0; j < xyz.size(); j++) {
					if (xyz.get(j).getText().contentEquals(M.getstring("Automation Test Data", 98, i + 4))) {
						pass++;
						getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCommenterShortName").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 5),"Comment Person Name Doesn't Match");

						getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarksRole").get(j).getText();
						SA.assertEquals(getText, M.getstring("Automation Test Data", 98, 6),"Comment Person Role Doesn't Match");

						
						//date generate
						Date date = new Date();  
					    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
					    String strDate = formatter.format(date);  
						getText = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCommentDate").get(j)
								.getText();
						SA.assertEquals(getText, strDate,"Comment Date Doesn't Match");
						break;

					}
				}
				if (pass == 0) {
					count++;
					str = str + "\n" + M.getstring("Automation Test Data", 98, i + 4) + " Not added";
				}

				if (i == 0) {
					try {
						count++;
						Thread.sleep(5000);
						M.ScrollByText(M.getstring("Automation Test Data", 98, 1));
						str = str + "\n" + "Add comment button doesn't change";
						try {
							SA.assertAll();

						} catch (AssertionError x) {
							str = str + "\n" + x;
							throw new Exception(str);
						}

					} catch (Exception e) {
						;
					}

				}

			}
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(2);
			}
			try {
				SA.assertAll();

			} catch (AssertionError x) {
				count++;
				str = str + "\n" + x;
			}
			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Verify Adding Comments & Replies in Task Details");
			M.setStrData("As Expected", "Automation Testcase", 596, 6);
			M.setStrData("Pass", "Automation Testcase", 596, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Adding Comments & Replies in Task Details");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 596, 6);
			M.setStrData("Fail", "Automation Testcase", 596, 7);

		}
		ReStart();

	}
	
	
	
	// UpdateTaskDetails(task)
	// @Test (priority = 18)
	public void UpdateTaskDetails() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("UpdateTaskDetails Executed!");
		int count = 0;
		String str = "";
		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 188, 7));
				//M.ClickOn(M.getstring("Automation Test Data", 196, 1));
				Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}

			try {

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_task_edit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value").clear();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_field_value")
						.sendKeys(M.getstring("Automation Test Data", 196, 1));
				driver.hideKeyboard();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 202, 2), M.getstring("Automation Test Data", 202, 3));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}

				try {
					Thread.sleep(1000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					Thread.sleep(1000);
				} catch (Exception e) {
					Thread.sleep(5000);
					M.ClickOn(M.getstring("Automation Test Data", 188, 7));
					
					count++;
					str = str + "\n" + " Task Detail page not found After update Task Discription";
				}
				
				// Task Description
				String testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_title").getText();
				SA.assertEquals(testdata, M.getstring("Automation Test Data", 196, 1),"Task Description Name Doesn't Match after change");

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}
			
			try {

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_deadline_edit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.view.View[@content-desc=\"" + M.getstring("Automation Test Data", 196, 2) + "\"]").click();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("android:id/button1").click();
				Thread.sleep(2000);

				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 202, 2), M.getstring("Automation Test Data", 202, 3));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				try {
					Thread.sleep(1000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					Thread.sleep(1000);
				} catch (Exception e) {
					Thread.sleep(5000);
					M.ClickOn(M.getstring("Automation Test Data", 188, 7));
					
					count++;
					str = str + "\n" + " Task Detail page not found After update deadline";
				}
				
				// deadline
				String testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_deadline").getText();
				SA.assertEquals(testdata, M.getstring("Automation Test Data", 196, 2), "Deadline Doesn't Match after change");

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}

			try {

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_category_edit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				M.ClickOn(M.getstring("Automation Test Data", 196, 3));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				Thread.sleep(2000);

				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 202, 2), M.getstring("Automation Test Data", 202, 3));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				try {
					Thread.sleep(1000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
					Thread.sleep(1000);
				} catch (Exception e) {
					Thread.sleep(5000);
					M.ClickOn(M.getstring("Automation Test Data", 188, 7));
					
					count++;
					str = str + "\n" + " Task Detail page not found After Update category";
				}
				
				// CategoryValue 2
				String testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_categoryValue").getText();
				SA.assertEquals(testdata, M.getstring("Automation Test Data", 196, 3),"Category Value Doesn't Match after change");

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_assingedContact").click();
				try {
					String gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
					Thread.sleep(5000);
					M.BackFun(2);
				}catch(Exception e) {
					count++;
					str = str + "\n" +" Assigneed By phone number is Blank";
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +" Assigneed By call button not found";
			}
			
			
			
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/img_editAssignee").click();
				try {
					String gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
					Thread.sleep(5000);
					M.BackFun(2);
				}catch(Exception e) {
					count++;
					str = str + "\n" +" Assignee phone number is Blank";
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +" Assignee call button not found";
			}
			
			
			
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_originalAssinerContanct").click();
				
				try {
					String gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
					Thread.sleep(5000);
					M.BackFun(2);
				}catch(Exception e) {
					count++;
					str = str + "\n" +" Original Assigner phone number is Blank";
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +" Original Assigner call button not found";
			}
			
			
			
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_originalAssineeContact").click();
				try {
					String gettext = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
					Thread.sleep(5000);
					M.BackFun(2);
				}catch(Exception e) {
					count++;
					str = str + "\n" +"Original Assinee phone number is Blank";
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Original Assinee call button not found";
			}
			
			
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				
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
			M.ScreenShots("Screenshot/Passed", "UpdateTaskDetails");
			M.setStrData("As Expected", "Automation Testcase", 597, 6);
			M.setStrData("Pass", "Automation Testcase", 597, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "UpdateTaskDetails");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 597, 6);
			M.setStrData("Fail", "Automation Testcase", 597, 7);

		}

		ReStart();
	}
	

	
	// Verify Complete Button with date & Status
	// @Test (priority = 19)
	public void VerifyCompleteButtonwithdate_Status() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("VerifyCompleteButtonwithdate_Status Executed!");
		int count = 0;
		int id = 0;
		int key = 0;
		String str = "";
		String taskdis = "";
		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(5000);
				// M.ClickOn(M.getstring("Automation Test Data", 188, 7));
				// M.ClickOn(M.getstring("Automation Test Data", 196, 1));
				// Thread.sleep(5000);
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}

			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");

				// System.out.println(taskcount);
				for (int i = 0; i < xyz.size(); i++) {
					// System.out.println(taskcount);
					Thread.sleep(5000);
					taskdis = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription").get(i).getText();
					driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription").get(i).click();
					Thread.sleep(5000);

					try {
						String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tx_assigneeName").getText();
						//System.out.println(gettext);
						try {
							Boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").isDisplayed();
							//System.out.println("ok2");
							if (tr == true) {
								if (gettext.contentEquals(M.getstring("Automation Test Data", 190, 5))) {
									id = i;
									key++;
								} else {
									count++;
									str = str + "\n" + taskdis+ " Complete button Available but Assignee is not login user";
								}

							}
						} catch (Exception e) {
							if (gettext.contentEquals(M.getstring("Automation Test Data", 190, 5))) {
								count++;
								str = str + "\n" + taskdis+ " Complete Button doesn't available where Login user is Assignee";
								id = i;
								key++;
							}
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" + taskdis + " Assignee Name doesn't available";
					}
					// back
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

					} catch (Exception e) {

						Thread.sleep(5000);
						M.BackFun(1);
					}

				}

				if (key > 0) {

					Thread.sleep(5000);
					taskdis = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription").get(id)
							.getText();
					driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription").get(id).click();
					Thread.sleep(5000);

					try {
						String gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tx_assigneeName").getText();

						try {
							Boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").isDisplayed();
							if (gettext.contentEquals(M.getstring("Automation Test Data", 190, 5))) {
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").click();

								// warnning message
								Thread.sleep(2000);
								String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 204, 2),M.getstring("Automation Test Data", 204, 3));
								if (confirmation.isBlank()) {
									;
								} else {
									count++;
									str = str + "\n" + confirmation;
								}

								try {
									Thread.sleep(2000);
									driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").click();
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

								} catch (Exception e) {
									count++;
									str = str + "\n" + taskdis + "In Complete warrning message, Yes button not found";
								}

								// Sucessfull Message..
								Thread.sleep(2000);
								String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 204, 4),
										M.getstring("Automation Test Data", 204, 5));

								if (successful.isBlank()) {
									;
								} else {
									count++;
									str = str + "\n" + successful;
								}

							} else {
								count++;
								str = str + "\n" + taskdis+ " Complete Button is available but login user is not Assignee check manually";
							}
						} catch (Exception e) {
							count++;
							str = str + "\n" + taskdis + " Complete Button doesn't available";
							throw new Exception(str);
						}
					} catch (Exception e) {
						count++;
						str = str + "\n" + taskdis + " Assignee Name doesn't available";
					}

				} else
					throw new Exception(str + "\n" + taskdis + " No Login User as Assignee");

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date);
			String strDate1 = formatter1.format(date);

			try {
				
				try {
					Thread.sleep(2000);
					String page = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					count++;
					str = str + "\n" + "After completed task, task details page not found";
					try {
						int pass=0;
						List<AndroidElement> xyz=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtActualCompletionDate");
						for(int j=0;j<xyz.size();j++) {
							System.out.println(xyz.get(j).getText());
							if(strDate1.contentEquals(xyz.get(j).getText())) {
								pass++;
								break;
							}
						}
						if(pass==0) {
							count++;
							str = str + "\n" + "Completion Date doesn't match";
							
						}
					} catch (Exception x) {

						count++;
						str = str + "\n" + "Completion Date doesn't found in card";
					}

					String testdata = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus").get(id).getText();
					if (testdata.contains("Completed")) {
						;
					} else {
						count++;
						str = str + "\n" + "After complete task Card status does not changed";
					}
					//System.out.println("ok");
					
					// Go to details page
					Thread.sleep(2000);
					driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription").get(id).click();
					Thread.sleep(5000);
					try {
						page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_completionDateValue").getText();
						SA.assertEquals(testdata, strDate, "Completion Date doesn't match");

						testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_statusValue").getText();
						if (testdata.contains("Done")) {
							;
						} else {
							count++;
							str = str + "\n" + "After complete task status does not changed";
						}

						// complete Button
						try {
							Boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").isEnabled();
							if (tr == true) {
								count++;
								str = str + "\n" + "Complete button should be Disable after complete task";
							}

						} catch (Exception x) {

							;
						}

						// back to Order
						try {
							Thread.sleep(1000);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
							Thread.sleep(1000);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

						} catch (Exception m) {

							Thread.sleep(5000);
							M.BackFun(2);
						}

					} catch (Exception x) {
						count++;
						str = str + "\n" + x;
						throw new Exception(str);
					}

				} catch (Exception x) {
					count++;
					str = str + "\n" + "Apps may be crush check manually";
					throw new Exception(str);
				}


			} catch (Exception e) {
				
				
				// date
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
				String testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_completionDateValue").getText();
				SA.assertEquals(testdata, strDate, "Completion Date doesn't match");
				
				// status
				testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_statusValue").getText();
				if (testdata.contains("Done")) {
					;
				} else {
					count++;
					str = str + "\n" + "After complete task status does not changed";
				}

				// complete Button
				try {
					
					Boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").isEnabled();
					if (tr == true) {
						count++;
						str = str + "\n" + "Complete button should be Disable after complete task";
					}

				} catch (Exception x) {

					;
				}

				
				// back to task list
				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
					
				} catch (Exception x) {
					
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				try {
					Thread.sleep(5000);
					page = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

					testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtActualCompletionDate").getText();
					SA.assertEquals(testdata, strDate1, "Card Completion Date doesn't match");

					testdata = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus").get(id).getText();
					if (testdata.contains("Completed")) {
						;
					} else {
						count++;
						str = str + "\n" + "After complete task Card status does not changed";
					}

					// back to Order
					try {
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

					} catch (Exception x) {

						Thread.sleep(5000);
						M.BackFun(1);
					}

				} catch (Exception x) {
					count++;
					str = str + "\n" + "Apps may be crush check manually";
					throw new Exception(str);
				}

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
			M.ScreenShots("Screenshot/Passed", "VerifyCompleteButtonwithdate_Status");
			M.setStrData("As Expected", "Automation Testcase", 598, 6);
			M.setStrData("Pass", "Automation Testcase", 598, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "VerifyCompleteButtonwithdate_Status");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 598, 6);
			M.setStrData("Fail", "Automation Testcase", 598, 7);
		}

	}
	
	

	// Verify Orderinfo Task List by changing TNA Template
	// @Test(priority = 20)
	public void Verify_Orderinfo_TaskList() throws IOException, InterruptedException, ParseException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Orderinfo Task List by Changing TNA Executed!");
		int count = 0;
		int k = 187;
		int LCTask = 0;
		int LCRec = 0;
		String str = "";
		String order = M.getstring("Automation Test Data", 179, 1);
		String gettext = "";

		// System.out.println(date);

		try {

			// Data collect from template
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

				driver.findElementByXPath("//android.widget.TextView[@text='Task Template']").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 14));

				Thread.sleep(5000);
				M.ScrollDwon(1);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
				LCTask = xyz.size();

				// back
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);
				}

				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 175, 14));

				Thread.sleep(5000);
				M.ScrollDwon(1);

				xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDesc");
				LCRec = xyz.size();

				// back
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDetailsBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Data doesn't collect from template check manually";
			}

			// Go to Order page and check task list
			try {

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.TextView[@text='My Orders']").click();

				Thread.sleep(5000);
				M.ClickOn(order);

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(5000);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");

				// Task list data as follow TNA

				if (LCTask != xyz.size()) {
					count++;
					str = str + "\n" + "Lc Task template for order template and Task list is not Equal";
				}
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Lc Task template for order Task list cann't verify";
			}
			// back to order page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);
			}

			// Change TNA Template
			try {
				Thread.sleep(5000);
				M.ScrollByText(order);
				DataUp(order);
				Thread.sleep(5000);
				M.SwipBytext(order);
				Thread.sleep(5000);
				int j = counting(order);
				try {
					gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
					if(gettext.contentEquals(order)) {
						;
					}else {
						j++;
					}
				}catch(Exception e) {
					j++;
				}
				
				driver.findElementByXPath("//android.widget.LinearLayout[" + j+ "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectTnaTemplate").click();
				M.ClickOn(M.getstring("Automation Test Data", 175, 14));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				// warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 206, 2),M.getstring("Automation Test Data", 206, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				Thread.sleep(2000);
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTnaTemplate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 179, 14),"TnaTemplate Doesn't Match after warnning message No");

				TnaTemplate(M.getstring("Automation Test Data", 175, 14), 1);

				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTnaTemplate").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 175, 14),"TnA Template doesn't change.");

				
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

				} catch (Exception e) {
					count++;
					str = str + "\n Save Change Button Doesn't Work";
					throw new Exception(str);
				}

				// back to order page
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception x) {
						;
					}

				} catch (Exception e) {
					;

				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "TNA Template doesn't change";
			}

			// Go to Order page and check task list
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();

				Thread.sleep(5000);
				M.ClickOn(order);

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(5000);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");

				// Task list data as follow TNA

				if (LCRec != xyz.size()) {
					int x=xyz.size()-LCRec;
					if(x>1) {
						count++;
						str = str + "\n" + "Lc Recieve template template and Task list is not Equal";
					}
					
				}else {
					count++;
					str = str + "\n" + "After change TnA Template complete task are not found";
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Lc Recieve template Task list cann't verify";
			}
			// back to order page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);
			}

			String page = PageVerification("Order Information");
			if (page.isBlank()) {
				;
			} else {
				count++;
				str = str + page;
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
			M.ScreenShots("Screenshot/Passed", "Verify Library Entity Type");
			M.setStrData("As Expected", "Automation Testcase", 599, 6);
			M.setStrData("Pass", "Automation Testcase", 599, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Library Entity Type");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 599, 6);
			M.setStrData("Fail", "Automation Testcase", 599, 7);

		}

		ReStart();
	}

	
	
	// VerifyCancellationPlace holder text
	// @Test(priority = 21)
	public void VerifyCancellationPlaceHolderText() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Cancellation Place Holder Text Executed!");
		int count = 0;
		int id = 0;
		String str = "";
		String taskdis = "";
		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			//Verrify CancelationHeadData
			for(int i=1;i<=7;i++)
			{
				String result=VerifyCancellationHeadData(i,222,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			//Go to CostIncurred
			try {				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
			}catch (Exception e) {
				throw new Exception(e);
			}
			
			//Verrify  Cost Incurred
			for(int i=1;i<=4;i++)
			{
				String result=VerifyCostIncurredData(i,224,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			//Go to Orderinfo
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").isDisplayed();
			}catch (Exception e) {
				throw new Exception(e);
			}
			
			Thread.sleep(3000);
			M.ScrollDwon(1);
			
			//Go to Liabilities
			try {				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
			}catch (Exception e) {
				throw new Exception(e);
			}
			
			//Verrify Liability
			for(int i=1;i<=5;i++)
			{
				String result=VerifyLiabilityData(i,226,i);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			//Go to Orderinfo
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").isDisplayed();
			}catch (Exception e) {
				throw new Exception(e);
			}
					
			// back to Order
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception m) {

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
			M.ScreenShots("Screenshot/Passed", "Verify Cancellation Place Holder Text");
			M.setStrData("As Expected", "Automation Testcase", 600, 6);
			M.setStrData("Pass", "Automation Testcase", 600, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Cancellation Place Holder Text");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 600, 6);
			M.setStrData("Fail", "Automation Testcase", 600, 7);
		}

	}
	
	
	
	// Verify Disabled Cancel Button (Default & Blank Field)
	// @Test (priority = 22)
	public void VerifyDisabledCancelButton() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disabled Cancel Button (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 228;
		boolean tr;

		try {
			
			for (int i = 0; i <= 7; i++) {
				//Go to cancelation page
				try {
					Thread.sleep(5000);
					M.ClickOn(M.getstring("Automation Test Data", 179, 1));

					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
					Thread.sleep(5000);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}

				
				// Full Field Blank
				if (i == 0) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelOrder").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Cancel Button is Enable";

					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;

				}
				//CancelType
				if (i != 1) {
					CancelType(M.getstring("Automation Test Data", k, 1),1);
					
				}

				//CancelReason
				if (i != 2) {
					CancelReason(M.getstring("Automation Test Data", k, 2),1);
					

				}
				//CancelRemarks
				if (i != 3) {
					CancelRemarks(M.getstring("Automation Test Data", k, 3));
					

				}
				//CancellationDate
				if (i != 4) {
					CancellationDate(M.getstring("Automation Test Data", k, 4),1);
					

				}

				//Curency
				if (i != 5) {
					Curency(M.getstring("Automation Test Data", k, 5),1);
					
				}
				//RawMaterialValue
				if (i != 6) {
					RawMaterialValue(M.getstring("Automation Test Data", k, 6));
					
					
				}
				//FinishedGoodsValue
				if (i != 7) {
					FinishedGoodsValue(M.getstring("Automation Test Data", k, 7));
					
				}
				

				if (i == 3) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelOrder").isEnabled();
					if (tr == false) {
						count++;
						str = str + "\n" + "Cancel Remarks Field is Optional But Cancel Button is Disable";
					}
				}

				else {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelOrder").isEnabled();
					if (tr == true) {
						System.out.println(i);
						count++;
						if (i == 1)
							str = str + "\n" + "Cancel Type Field is Blank But Cancel Button is Enable";
						else if (i == 2)
							str = str + "\n" + "Cancel Reason Field is Blank But Cancel Button is Enable";
						else if (i == 4)
							str = str + "\n" + "Cancellation Date Field is Blank But Cancel Button is Enable";
						else if (i == 5)
							str = str + "\n" + "Curency Field is Blank But Cancel Button is Enable";
						else if (i == 6)
							str = str + "\n" + "Raw Material Value Field is Blank But Cancel Button is Enable";
						else if (i == 7)
							str = str + "\n" + "Finished Goods Value Field is Blank But Cancel Button is Enable";

					}

				}

				if (i != 8) {
					// back to Order
					try {
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

					} catch (Exception m) {

						Thread.sleep(5000);
						M.BackFun(1);
					}
					try {
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception m) {
						;
					}
					

				}

			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Cancel Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 601, 6);
			M.setStrData("Pass", "Automation Testcase", 601, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Cancel Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 601, 6);
			M.setStrData("Fail", "Automation Testcase", 601, 7);

		}
		ReStart();
	}


	
	// Dismiss Selected Value From Dropdown (Cancellation)
	// @Test(priority = 23)
	public void DismissSelectedValueFromDropdown_Cancellation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Cancellation Place Holder Text Executed!");
		int count = 0;
		int i = 228;
		int j = 230;
		int k = 232;
		String str = "";
		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			// Verrify Cancelation Head Dropdown
			
			CancelType(M.getstring("Automation Test Data", i, 1),2);			
			String result = VerifyCancellationHeadData(1, 222, 1);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			CancelReason(M.getstring("Automation Test Data", i, 2),2);
			result = VerifyCancellationHeadData(2, 222, 2);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			CancellationDate(M.getstring("Automation Test Data", i, 4),2);
			result = VerifyCancellationHeadData(4, 222, 4);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			Curency(M.getstring("Automation Test Data", i, 5),2);
			result = VerifyCancellationHeadData(5, 222, 5);
			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}

			Thread.sleep(5000);
			M.ScrollDwon(1);

			// Go to CostIncurred
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
			} catch (Exception e) {
				throw new Exception(e);
			}

			// Verrify Cost Incurred DropDwon
			
			OrderCostHead(M.getstring("Automation Test Data", j, 1),2);
			result = VerifyCostIncurredData(1, 224, 1);

			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			CostCurrency(M.getstring("Automation Test Data", j, 2),2);
			result = VerifyCostIncurredData(2, 224, 2);

			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			
			// Go to Orderinfo
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]")
						.isDisplayed();
			} catch (Exception e) {
				throw new Exception(e);
			}

			// Go to Liabilities
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
			} catch (Exception e) {
				throw new Exception(e);
			}

			// Verrify Liability Dropdwon
			
			LiabilityHead(M.getstring("Automation Test Data", k, 1),2);
			result = VerifyLiabilityData(1, 226, 1);

			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			LiabilityCurrency(M.getstring("Automation Test Data", k, 2),2);
			result = VerifyLiabilityData(2, 226, 2);

			if (result.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + result;
			}
			
			// Go to Orderinfo
			try {

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]")
						.isDisplayed();
			} catch (Exception e) {
				throw new Exception(e);
			}

			// back to Order
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception m) {

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
			M.ScreenShots("Screenshot/Passed", "Dismiss Selected Value From Dropdown_Cancellation");
			M.setStrData("As Expected", "Automation Testcase", 602, 6);
			M.setStrData("Pass", "Automation Testcase", 602, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Dismiss Selected Value From Dropdown_Cancellation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 602, 6);
			M.setStrData("Fail", "Automation Testcase", 602, 7);
		}

	}
	
	
	
	// Dismiss Unsaved Data (Default & All fields together)
	// @Test (priority = 24)
	public void CancelHeadDismissUnsavedData() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Cancel head Dismiss Unsaved Data (Default & All fields together) Executed!");
		SoftAssert SA=new SoftAssert();
		String str="";
		int back=0;
		int count=0;
		Thread.sleep(2000);
		try {
			
			//Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			
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
			
			//verify warring message for without input
			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
			} catch (Exception e) {
				count++;
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					str = str + "\n warring message show after Press back without input value";
				} catch (Exception x) {
					
					str = str + "\n Apps crush after back without input";
					throw new Exception(str);
				}
			}
			
			Thread.sleep(1000);
			//Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}

			
			Thread.sleep(2000);
			
			for(int i=1;i<=7;i++) {
				CancelationDataFillUP(i,228);
			}
			
			for(int j=1;j<=4;j++) {
				if(j==1) {
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
				}
				if(j==2) {
					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Order\"]").click();
				}
				if(j==3) {
					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				}
				if(j==4) {
					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Production\"]").click();
				}
				
				
				
				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 208, 2), M.getstring("Automation Test Data", 208, 4));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					if(j==1)
						str = str + "\n" +"After Press Back "+ confirmation;
					if(j==2)
						str = str + "\n" +"After Press Order "+ confirmation;
					if(j==3)
						str = str + "\n" +"After Press Task "+ confirmation;
					if(j==4)
						str = str + "\n" +"After Press Production "+ confirmation;
					
				}
				
				Thread.sleep(2000);
				
				//Order Information Page
				try {
					try {
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					}catch (Exception e) {
						Boolean tr = driver.findElementByXPath("//android.widget.TextView[@text='Cancellation']").isSelected();
						if(tr==false) {
							throw new Exception();
						}
					}
					Thread.sleep(5000);
					try {
						Thread.sleep(5000);
						M.ScrollUpMinor(2);
					}catch (Exception e) {
						;
					}

					try {
						for(int i=1;i<=7;i++)
						{
							String result=VerifyCancellationHeadData(i,228,i);
							
							if(result.isBlank()) {
								;
							}else {
								count++;
								if(j==1)
									str = str + "\n" +"After Press Back and warning message No "+ result;
								if(j==2)
									str = str + "\n" +"After Press Order and warning message No  "+ result;
								if(j==3)
									str = str + "\n" +"After Press Task and warning message No  "+ result;
								if(j==4)
									str = str + "\n" +"After Press Production and warning message No  "+ result;
								
								CancelationDataFillUP(i,228);
							}
							
						}
					}catch (Exception e) {
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					
					
					
				} catch (Exception e) {
					//Order page
					count++;
					try {
						List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
						for (int i = 0; i < xyz.size(); i++) {
							if (xyz.get(i).getText().contentEquals("Orders")) {
								str = str + "\n" + "No warring message found after press back Button";
								Thread.sleep(5000);
								M.ClickOn(M.getstring("Automation Test Data", 179, 1));

								Thread.sleep(2000);
								driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
								Thread.sleep(5000);
								
							}else {
								str = str + "\n" + "No warring message found after press "+xyz.get(i).getText();
								Thread.sleep(2000);
								driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
								Thread.sleep(5000);
							}

						}
						
						
						
					} catch (Exception x) {
						
						str = str + "\n" + "Apps May be Crush";
						
					}
					
					//throw new Exception(str);
				}
				
				
				
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
				;
			}
			
			//Order page
			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
				Thread.sleep(5000);
				M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
				Thread.sleep(2000);
				DataUp(M.getstring("Automation Test Data", 179, 1));
				int j=counting(M.getstring("Automation Test Data", 179, 1));
				try {
					gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
					if(gettext.contentEquals(M.getstring("Automation Test Data", 179, 1))) {
						;
					}else {
						j++;
					}
				}catch(Exception e) {
					j++;
				}
				driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtIsCanceled").get(j).isDisplayed();
				count++;
				str = str + "\n" + "After press Back Button with data but the order cancel";
				
			}catch (Exception e) {
				;
			}
						
			if (count > 0) {
				throw new Exception(str);
			}
		
			M.ScreenShots("Screenshot/Passed","Dismiss Unsaved Data All & together");			  
		    M.setStrData("As Expected","Automation Testcase", 603, 6);
			M.setStrData("Pass","Automation Testcase", 603, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Unsaved Data All & Together");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 603, 6);
			M.setStrData("Fail","Automation Testcase", 603, 7);
	
		}
		
		ReStart();
	}
	
	
	
	// CancelHead Dismiss Unsaved Data (For Each Field)
	// @Test(priority = 25)
	public void CancelHeadDismissUnsavedDataForEach() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Cancel head Dismiss Unsaved Data (For Each Field) Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		int pass = 0;
		int count = 0;
		int j = 228;
		Thread.sleep(2000);
		try {

			for (int i = 1; i <= 7; i++) {

				if (pass == 0) {
					// Go to cancellatin page
					try {
						Thread.sleep(5000);
						M.ClickOn(M.getstring("Automation Test Data", 179, 1));

						Thread.sleep(2000);
						driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
						Thread.sleep(5000);

					} catch (Exception e) {
						count++;
						str = str + "\n" + e;
						throw new Exception(str);
					}
					pass = 0;
				}

				// Form Fillup......
				
				CancelationDataFillUP(i, j);

				Thread.sleep(1000);

				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {
					Thread.sleep(5000);
					M.BackFun(1);
				}

				// Warring_Message but use sucessful method
				Thread.sleep(2000);
				String Warring_Message = M.Sucessfull_Message(M.getstring("Automation Test Data", 208, 2), M.getstring("Automation Test Data", 208, 4));
				if (Warring_Message.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + Warring_Message;
				}

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					

				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press Back button Orders page Not Found";
					pass++;
					try {
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
						if(i==3) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").clear();
						}

						if(i==6) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").clear();
						}
						
						if(i==7) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").clear();
						}

					} catch (Exception x) {
						count++;
						str = str + "\n" + "After press Back button Check Manually";
						throw new Exception(str);
					}
				}


			}

			// Back Button!!
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
				
			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Cancel head Dismiss Unsaved Data For Each Field");
			M.setStrData("As Expected", "Automation Testcase", 604, 6);
			M.setStrData("Pass", "Automation Testcase", 604, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Cancel head Dismiss Unsaved Data For Each Field");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 604, 6);
			M.setStrData("Fail", "Automation Testcase", 604, 7);

		}
		ReStart();

	}
	
	
	
	// Verify Disabled Cost incurred add Button (Default & Blank Field)
	// @Test (priority = 26)
	public void VerifyCostIncurredAddButton() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disabled Cost incurred add Button (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 230;
		boolean tr;

		try {
			//Go to cancelation page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			for (int i = 0; i <= 4; i++) {
				
				//Go to cost incurred 
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
					Thread.sleep(2000);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				// Full Field Blank
				if (i == 0) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Add Button is Enable";

					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;

				}
				//Order CostHead
				if (i != 1) {
					OrderCostHead(M.getstring("Automation Test Data", k, 1),1);
				}

				//Cost Currency
				if (i != 2) {
					CostCurrency(M.getstring("Automation Test Data", k, 2),1);
				}
				//Cost Incurred
				if (i != 3) {
					CostIncurred(M.getstring("Automation Test Data", k, 3));
				}
				//Cost Remarks
				if (i != 4) {
					CostRemarks(M.getstring("Automation Test Data", k, 4));
				}
				

				if (i == 4) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == false) {
						count++;
						str = str + "\n" + " Remarks Field is Optional But Add Button is Disable";
					}
				}

				else {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						System.out.println(i);
						count++;
						if (i == 1)
							str = str + "\n" + "Order Cost Head Field is Blank But Add Button is Enable";
						else if (i == 2)
							str = str + "\n" + "Cost Currency Field is Blank But Add Button is Enable";
						else if (i == 3)
							str = str + "\n" + "Cost Incurred Field is Blank But Add Button is Enable";
					}

				}

				if (i != 5) {
					// back to Order info
					try {
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

					} catch (Exception m) {

						count++;
						str = str + "\n" + "Cost incurred Cancel Button not found";
						throw new Exception(str);
					}
					try {
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception m) {
						;
					}
					
					try {
						Thread.sleep(1000);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred Cancel Button Doesn't Work";
						throw new Exception(str);
					}
					

				}

			}
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Cancel Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 605, 6);
			M.setStrData("Pass", "Automation Testcase", 605, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Cancel Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 605, 6);
			M.setStrData("Fail", "Automation Testcase", 605, 7);

		}
		ReStart();
	}


	
	// Dismiss Unsaved Data CostIncurred (Default & All fields together)
	// @Test (priority = 27)
	public void CostIncurredDismissUnsavedData() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Cost Incurred Dismiss Unsaved Data (Default & All fields together) Executed!");
		SoftAssert SA=new SoftAssert();
		String str="";
		int back=0;
		int count=0;
		Thread.sleep(2000);
		try {
			
			//Go to cancellatin & CostIncurred page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Cancel Button not found";
				throw new Exception(str);
			}
			try {
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				count++;
				str = str + "\n" + "After click cancel button show warnning messsage with-out input data";
			} catch (Exception m) {
				;
			}
			
			try {
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Cost incurred Cancel Button Doesn't Work";
				throw new Exception(str);
			}
			
			
		
			//Go to Cost incurred page
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}

			
			
			for(int i=1;i<=4;i++) {
				CostDataFillUp(i,230);
			}
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Cancel Button not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Cancel Button "+ confirmation;
			}
			
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();

				//Thread.sleep(5000);
				//M.Scroll(1);
				
				try {
					for(int i=1;i<=4;i++)
					{
						String result=VerifyCostIncurredData(i,230,i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" + result;
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
				
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
				Thread.sleep(5000);
				M.BackFun(1);
				
				str = str + "\n" + "After click Warring Message No Page Redirect to order information page";
				throw new Exception(str);
				
			}
				
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Cost incurred Cancel Button or warnning yes button Doesn't Work";
				throw new Exception(str);
			}

			
			//Order Information page
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				try {
					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
					for (int i = 0; i < xyz.size(); i++) {
						if (xyz.get(i).getText().contentEquals(M.getstring("Automation Test Data", 230, 1))) {
							count++;
							str = str + "\n" + "After Dissmiss data by cancel button but cost incurred create ";
							break;
						}
					}
				}catch (Exception e) {
					;
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" +"Apps Crush Check Manually";
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
						
			if (count > 0) {
				throw new Exception(str);
			}
		
			M.ScreenShots("Screenshot/Passed","Dismiss Unsaved Data All & together");			  
		    M.setStrData("As Expected","Automation Testcase", 606, 6);
			M.setStrData("Pass","Automation Testcase", 606, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Unsaved Data All & Together");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 606, 6);
			M.setStrData("Fail","Automation Testcase", 606, 7);
	
		}
		
		ReStart();
	}
	

	
	// CostIncurred Dismiss Unsaved Data (For Each Field)
	// @Test(priority = 28)
	public void CostIncurredDismissUnsavedDataForEach() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Cost Incurred Dismiss Unsaved Data (For Each Field) Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		int pass = 0;
		int count = 0;
		int j = 230;
		Thread.sleep(2000);
		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			for (int i = 1; i <= 4; i++) {

				if (pass == 0) {
					// Go to cancellatin page
					Thread.sleep(5000);
					M.ScrollDwon(1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
					Thread.sleep(2000);
					pass = 0;
				}

				// Form Fillup......
				
				CostDataFillUp(i, j);

				Thread.sleep(1000);

				// Back Button!!
				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Cost incurred Cancel Button not found";
					throw new Exception(str);
				}

				// Warring_Message but use sucessful method
				Thread.sleep(2000);
				String Warring_Message = M.Sucessfull_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
				if (Warring_Message.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + Warring_Message;
				}

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					

				} catch (Exception e) {
					count++;
					str = str + "\n" + "After click Cancel button and yes button Orders Information page Not Found";
					pass++;
					try {
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();
						if(i==3) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").clear();
						}

						if(i==4) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").clear();
						}
						
						

					} catch (Exception x) {
						count++;
						str = str + "\n" + "After press Back button Check Manually";
						throw new Exception(str);
					}
				}


			}
			//Press Back button
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Cancel head Dismiss Unsaved Data For Each Field");
			M.setStrData("As Expected", "Automation Testcase", 607, 6);
			M.setStrData("Pass", "Automation Testcase", 607, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Cancel head Dismiss Unsaved Data For Each Field");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 607, 6);
			M.setStrData("Fail", "Automation Testcase", 607, 7);

		}
		ReStart();

	}
	
	
	
	// Verify Disabled Liability add Button (Default & Blank Field)
	// @Test (priority = 29)
	public void VerifyLiabilityAddButton() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println(" Verify Disabled Liability add Button (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 232;
		boolean tr;

		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			for (int i = 0; i <= 5; i++) {
				//Go to cancelation page
				
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
					Thread.sleep(2000);
				}catch (Exception e) {
					count++;
					str = str + "\n" + e;
				}
				
				// Full Field Blank
				if (i == 0) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Cancel Button is Enable";

					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;

				}
				//Order CostHead
				if (i != 1) {
					LiabilityHead(M.getstring("Automation Test Data", k, 1),1);
						
				}

				//LiabilityCurrency
				if (i != 2) {
					LiabilityCurrency(M.getstring("Automation Test Data", k, 2),1);
				}
				//LiabilityAmount
				if (i != 3) {
					LiabilityAmount(M.getstring("Automation Test Data", k, 3));
				}
				//RepaymentDays
				if (i != 4) {
					RepaymentDays(M.getstring("Automation Test Data", k, 4));
				}
				//LiabilityRemarks
				if (i != 5) {
					LiabilityRemarks(M.getstring("Automation Test Data", k, 5));
				}
				

				if (i == 5) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == false) {
						count++;
						str = str + "\n" + " Remarks Field is Optional But Add Button is Disable";
					}
				}

				else {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						//System.out.println(i);
						count++;
						if (i == 1)
							str = str + "\n" + "Liability Head Field is Blank But Add Button is Enable";
						else if (i == 2)
							str = str + "\n" + "Liability Currency Field is Blank But Add Button is Enable";
						else if (i == 3)
							str = str + "\n" + "Liability Amount Field is Blank But Add Button is Enable";
						else if (i == 4)
							str = str + "\n" + "Repayment Days Field is Blank But Add Button is Enable";
					}

				}

				if (i != 6) {
					// back to Order info
					try {
						//System.out.println("press back");
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

					} catch (Exception m) {

						count++;
						str = str + "\n" + "Cost incurred Cancel Button not found";
						throw new Exception(str);
					}
					try {
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception m) {
						;
					}
					
					try {
						Thread.sleep(1000);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred Cancel Button Doesn't Work";
						throw new Exception(str);
					}
					

				}

			}
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Liability add Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 608, 6);
			M.setStrData("Pass", "Automation Testcase", 608, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Liability add Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 608, 6);
			M.setStrData("Fail", "Automation Testcase", 608, 7);

		}
		ReStart();
	}

	
	
	// Liability Dismiss Unsaved Data (Default & All fields together)
	// @Test (priority = 30)
	public void LiabilityDismissUnsavedData() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Liability Dismiss Unsaved Data (Default & All fields together) Executed!");
		SoftAssert SA=new SoftAssert();
		String str="";
		int back=0;
		int count=0;
		Thread.sleep(2000);
		try {
			
			//Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liabilities Cancel Button not found";
				throw new Exception(str);
			}
			try {
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				count++;
				str = str + "\n" + "After click cancel button show warnning messsage with-out input data";
			} catch (Exception m) {
				;
			}
			
			try {
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Liabilities Cancel Button Doesn't Work";
				throw new Exception(str);
			}
			
			
		
			//Go to Cost incurred page
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}

			
			
			for(int i=1;i<=5;i++) {
				LiabilityDataFillUp(i,232);
			}
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liability Cancel Button not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Cancel Button "+ confirmation;
			}
			
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();

				Thread.sleep(5000);
				M.Scroll(1);
				
				try {
					for(int i=1;i<=5;i++)
					{
						String result=VerifyLiabilityData(i,232,i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" + result;
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
				
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
				Thread.sleep(5000);
				M.BackFun(1);
				
				str = str + "\n" + "After click Warring Message No Page Redirect to order information page";
				throw new Exception(str);
				
			}
				
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Liability Cancel Button or warnning yes button Doesn't Work";
				throw new Exception(str);
			}

			
			//Order Information page
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contentEquals(M.getstring("Automation Test Data", 232, 1))) {
						count++;
						str = str + "\n" + "After Dissmiss data by cancel button but Liability create ";
						break;
					}
				}
			}catch (Exception e) {
				count++;
				str = str + "\n" +"Apps Crush Check Manually";
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
						
			if (count > 0) {
				throw new Exception(str);
			}
		
			M.ScreenShots("Screenshot/Passed","Dismiss Unsaved Data All & together");			  
		    M.setStrData("As Expected","Automation Testcase", 609, 6);
			M.setStrData("Pass","Automation Testcase", 609, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Unsaved Data All & Together");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 609, 6);
			M.setStrData("Fail","Automation Testcase", 609, 7);
	
		}
		
		ReStart();
	}
	

	
	// Liability Dismiss Unsaved Data (For Each Field)
	// @Test(priority = 31)
	public void LiabilityDismissUnsavedDataForEach() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Liability Dismiss Unsaved Data (For Each Field) Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		int pass = 0;
		int count = 0;
		int j = 232;
		Thread.sleep(2000);
		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			for (int i = 1; i <= 5; i++) {

				if (pass == 0) {
					// Go to cancellatin page
					Thread.sleep(5000);
					M.ScrollDwon(1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
					Thread.sleep(2000);
					pass = 0;
				}

				// Form Fillup......
				
				LiabilityDataFillUp(i, j);

				Thread.sleep(1000);

				// Press Cancel button!!
				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Liability Cancel Button not found";
					throw new Exception(str);
				}

				// Warring_Message but use sucessful method
				Thread.sleep(2000);
				String Warring_Message = M.Sucessfull_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
				if (Warring_Message.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + Warring_Message;
				}

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					

				} catch (Exception e) {
					count++;
					str = str + "\n" + "After click Cancel button and yes button Orders Information page Not Found";
					pass++;
					try {
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();
						if(i==3) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").clear();
						}

						if(i==4) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").clear();
						}
						
						if(i==5) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").click();
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").clear();
						}
						
						

					} catch (Exception x) {
						count++;
						str = str + "\n" + "After press Back button Check Manually";
						throw new Exception(str);
					}
				}


			}
			//Press Back button
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Liability Dismiss Unsaved Data For Each Field");
			M.setStrData("As Expected", "Automation Testcase", 610, 6);
			M.setStrData("Pass", "Automation Testcase", 610, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Liability Dismiss Unsaved Data For Each Field");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 610, 6);
			M.setStrData("Fail", "Automation Testcase", 610, 7);

		}
		ReStart();

	}
	
	
	// AddCostIncurred
	//@Test (priority = 32)
	public void AddCostIncurred() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("AddCostIncurred Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int back = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// add Cost incurred
			try {
				for (int i = 1; i <= 4; i++) {
					CostDataFillUp(i, 230);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Cancel Button not found";
				throw new Exception(str);
			}

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 2),
					M.getstring("Automation Test Data", 212, 3));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press add Button " + Sucessfull;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']")
						.getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']")
						.getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				count++;
				str = str + "\n" + "After Click add Button, page doesn't Redirect to Order info Page";
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n"+ "After Click add Button, page doesn't Redirect to Order info Page and when press cancel button Unsave Warrning message show";
				} catch (Exception x) {
					;
				}

			}

			// go again add page to check field is Blank or not.
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

				// Verrify Cost Incurred
				for (int i = 1; i <= 4; i++) {
					String result = VerifyCostIncurredData(i, 224, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + "After add cost incurred and when again go to Add cost incurred page ::"+result;
					}

				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					count++;
					str = str + "\n" + "After add cost incurred when again go to Add cost incurred page and after click cancel button show warnning message.";
				} catch (Exception e) {
					;
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					;
				}
			}

			int pass=0;
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
						pass++;
						String gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 230, 4),"Card Remarks Doesn't Match");
						//System.out.println(gettext);
						
						gettext = M.getstring("Automation Test Data", 230, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 230, 3),"CostIncurred Value Doesn't Match");
						//System.out.println(gettext);
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			
			if(pass==0){
				count++;
				str = str + "\n" + "After add Cost incurred but data not add in cost incurred Card";
				throw new Exception(str);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_edit").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Cost Incurred

					for (int i = 1; i <= 4; i++) {
						String result = VerifyCostIncurredData(i, 230, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}

					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
					try {
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						count++;
						str = str + "\n" + "After verify add data from Edit Cost Incurred page and when press cancel button show warning message.";
					} catch (Exception e) {
						;
					}
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {

				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"After Press Order info page back Button "+ confirmation;
					
					try {
						text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();			
						throw new Exception(str);
					} catch (Exception e) {
						;
					}
					
				}
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, Yes button not found";
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
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

			M.ScreenShots("Screenshot/Passed", "AddCostIncurred");
			M.setStrData("As Expected", "Automation Testcase", 611, 6);
			M.setStrData("Pass", "Automation Testcase", 611, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "AddCostIncurred");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 611, 6);
			M.setStrData("Fail", "Automation Testcase", 611, 7);

		}

		ReStart();
	}
	
	
	
	// Edit Cost Incurred
	// @Test (priority = 33)
	public void EditCostIncurred() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Edit CostIncurred Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to Cancellation & AddCostIncurred page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// add Cost incurred
			try {
				for (int i = 1; i <= 4; i++) {
					CostDataFillUp(i, 230);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Add Button not found";
				throw new Exception(str);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception e) {
				;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					
				} catch (Exception x) {
					;
				}

			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_edit").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
					throw new Exception(str);
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
			
			//Edit Cost incurred
			try {
				for (int i = 1; i <= 4; i++) {
					CostDataFillUp(i, 236);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Edit Button not found";
				throw new Exception(str);
			}
			

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 2),M.getstring("Automation Test Data", 212, 3));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Edit Button " + Sucessfull;
			}

			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Edit Cost Incurred']").getText();

				// Verrify Cost Incurred
				for (int i = 1; i <= 4; i++) {
					String result = VerifyCostIncurredData(i, 236, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After Update data when press cancel button warring message show";
					
				} catch (Exception x) {
					;
				}

			} catch (Exception e) {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				count++;
				str = str + "\n" +"After Click edit button, redirect to Order Info page";
			}

			

			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 236, 1))) {
						String gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 236, 4),"Card Remarks Doesn't Match");
						//System.out.println(gettext);
						
						gettext = M.getstring("Automation Test Data", 236, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 236, 3),"CostIncurred Value Doesn't Match");
						//System.out.println(gettext);
						pass++;
					}
				}


			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "After Update Cost incurred but data not update in cost incurred Card";
				throw new Exception(str);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 236, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_edit").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Cost Incurred

					for (int i = 1; i <= 4; i++) {
						String result = VerifyCostIncurredData(i, 236, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}

					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						count++;
						str = str + "\n" + "With out any update, when press cancel button warring message show";
						
					} catch (Exception x) {
						;
					}
				} catch (Exception m) {
					count++;
					str = str + "\n" + m;
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add Cost incurred But when press Back button No Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "EditCostIncurred");
			M.setStrData("As Expected", "Automation Testcase", 612, 6);
			M.setStrData("Pass", "Automation Testcase", 612, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "EditCostIncurred");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 612, 6);
			M.setStrData("Fail", "Automation Testcase", 612, 7);

		}

		ReStart();
	}
	
	
	
	// Delect Cost Incurred
	// @Test (priority = 34)
	public void DelectCostIncurred() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Delect Cost Incurred Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// add Cost incurred
			try {
				for (int i = 1; i <= 4; i++) {
					CostDataFillUp(i, 230);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Add Button not found";
				throw new Exception(str);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception e) {
				;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					
				} catch (Exception x) {
					;
				}

			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_delete").click();
				Thread.sleep(2000);
				

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Delete Button Not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 212, 4), M.getstring("Automation Test Data", 212, 5));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Delete Button "+ confirmation;
			}
			
			try {
				text=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead").getText();
				if(text.contentEquals(M.getstring("Automation Test Data", 230, 1))) {
					;
				}else
					throw new Exception(str);
					
			} catch (Exception m) {
				count++;
				str = str + "\n" + "After Delete Warning No card not found";
				throw new Exception(str);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_delete").click();
				Thread.sleep(2000);
				

			} catch (Exception m) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_delete").click();
				Thread.sleep(2000);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
			} catch (Exception x) {
				;
			}
			
			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 10),M.getstring("Automation Test Data", 212, 11));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press warning Yes Button " + Sucessfull;
			}

			try {
				text=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead").getText();
				if(text.contentEquals(M.getstring("Automation Test Data", 230, 1))) {
					count++;
					str = str + "\n" + "After Delete Cost incurred But Card Still Present ";
				}
					
			} catch (Exception m) {
				;
			}
			

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add Cost incurred But when press Back button, No Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "Delect Cost Incurred");
			M.setStrData("As Expected", "Automation Testcase", 613, 6);
			M.setStrData("Pass", "Automation Testcase", 613, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Cost Incurred");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 613, 6);
			M.setStrData("Fail", "Automation Testcase", 613, 7);

		}

		ReStart();
	}
	
	
	
	
	// Add Liability
	// @Test (priority = 35)
	public void AddLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Add Liability Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// add Liabilities
			try {
				for (int i = 1; i <= 5; i++) {
					LiabilityDataFillUp(i, 232);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liability Cancel Button not found";
				throw new Exception(str);
			}

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 2),M.getstring("Automation Test Data", 212, 3));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press add Button " + Sucessfull;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				count++;
				str = str + "\n" + "After Click add Button, page doesn't Redirect to Order info Page";
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n"+ "After Click add Button, page doesn't Redirect to Order info Page and when press cancel button Unsave Warrning message show";
				} catch (Exception x) {
					;
				}

			}

			// go again add page to check field is Blank or not.
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

				// Verrify Liabilities
				for (int i = 1; i <= 5; i++) {
					String result = VerifyLiabilityData(i, 226, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" +"After create Go again add page to check field is Blank or not"+ result;
					}

				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After create Liabilities then go agian add Liabilities page and without input data click cancel button show warring message.";
				} catch (Exception m) {
					;
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					;
				}
			}

			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						pass++;
						
						String gettext = M.getstring("Automation Test Data", 232, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 232, 3),"CostIncurred Value Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, "Repayment Days","Repayment Days Text Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 232, 4)+" Days","Repayment Days Value Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 232, 5),"Card Remarks Doesn't Match in card");
						//System.out.println(gettext);
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			if(pass==0) {
				count++;
				str = str + "\n" + "After create Liability, Card not Found";
				throw new Exception(str);
			}
			

			try {
				Thread.sleep(2000);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_edit").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Cost Incurred

					for (int i = 1; i <= 5; i++) {
						String result = VerifyLiabilityData(i, 232, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}

					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						count++;
						str = str + "\n" + "After goto Edit page without change when click cancel button warning message show";
					} catch (Exception m) {
						;
					}

				} catch (Exception m) {
					count++;
					str = str + "\n" + "Liability edit button Doesn't Work";
					throw new Exception(str);
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
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
			try {

				//check title & warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
				if(confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" +"After Press back Button from Order info page "+ confirmation;
					try {
						text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();			
						throw new Exception(str);
					} catch (Exception e) {
						;
					}
				}
				
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				try {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + "After press back button, Yes button not found";
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
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

			M.ScreenShots("Screenshot/Passed", "Add Liability");
			M.setStrData("As Expected", "Automation Testcase", 614, 6);
			M.setStrData("Pass", "Automation Testcase", 614, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Add Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 614, 6);
			M.setStrData("Fail", "Automation Testcase", 614, 7);

		}

		ReStart();
	}
	
	
	
	// Edit Liability
	// @Test (priority = 36)
	public void EditLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Edit Liability Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// Add Liabilities
			try {
				for (int i = 1; i <= 5; i++) {
					LiabilityDataFillUp(i, 232);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liabilities Add Button not found";
				throw new Exception(str);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception e) {
				;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					
				} catch (Exception x) {
					;
				}

			}

			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_edit").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

				} catch (Exception m) {
					count++;
					str = str + "\n" + "Liabilities edit button Doesn't Work";
					throw new Exception(str);
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
			
			//Edit Liabilities
			try {
				for (int i = 1; i <= 5; i++) {
					LiabilityDataFillUp(i, 238);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liabilities Edit Button not found";
				throw new Exception(str);
			}
			

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 2),M.getstring("Automation Test Data", 212, 3));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Edit Button " + Sucessfull;
			}

			try {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Edit Liability']").getText();

				// Verrify Liability
				for (int i = 1; i <= 5; i++) {
					String result = VerifyLiabilityData(i, 238, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After sucessfully Edit data when press cancel button warring message show";
					
				} catch (Exception x) {
					;
				}

			} catch (Exception e) {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				count++;
				str = str + "\n" +"After Click edit button, redirect to Order Info page";
			}

			

			try {
				Thread.sleep(5000);
				M.ScrollDwon(2);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 238, 1))) {
						pass++;
						
						String gettext = M.getstring("Automation Test Data", 238, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 238, 3),"CostIncurred Value Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, "Repayment Days","Repayment Days Text Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 238, 4)+" Days","Repayment Days Value Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 238, 5),"Card Remarks Doesn't Match in card");
						//System.out.println(gettext);
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
				

			if(pass==0){
				count++;
				str = str + "\n" + "After Update Liability but data not update in Liability Card";
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 238, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_edit").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Liability

					for (int i = 1; i <= 5; i++) {
						String result = VerifyLiabilityData(i, 238, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}

					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
					
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						count++;
						str = str + "\n" + "In Edit page No Data input,But when press cancel button warring message show";
						
					} catch (Exception x) {
						;
					}

				} catch (Exception m) {
					count++;
					str = str + "\n" + m;
					throw new Exception(str);
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
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

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Add Liability But when press Back button No Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "Edit Liability");
			M.setStrData("As Expected", "Automation Testcase", 615, 6);
			M.setStrData("Pass", "Automation Testcase", 615, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Edit Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 615, 6);
			M.setStrData("Fail", "Automation Testcase", 615, 7);

		}

		ReStart();
	}
	
	
	
	// Delect Liability
	// @Test (priority = 37)
	public void DelectLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Delect Liability Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// Add Liabilities
			try {
				for (int i = 1; i <= 5; i++) {
					LiabilityDataFillUp(i, 232);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liabilities Add Button not found";
				throw new Exception(str);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception e) {
				;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					
				} catch (Exception x) {
					;
				}

			}

			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_delete").click();
				Thread.sleep(2000);
				

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Delete Button Not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 212, 6), M.getstring("Automation Test Data", 212, 7));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Delete Button "+ confirmation;
			}
			
			

			try {
				Thread.sleep(5000);
				M.ScrollDwon(2);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						pass++;
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "After click Delete Warning Message No, But card not found";
				throw new Exception(str);
			}
				

			if(pass==0){
				count++;
				str = str + "\n" + "After click Delete Warning Message No, But card not found";
				throw new Exception(str);
			}
			
			
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_delete").click();
				Thread.sleep(2000);
				

			} catch (Exception m) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_delete").click();
				Thread.sleep(2000);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
			} catch (Exception x) {
				;
			}
			
			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 10),M.getstring("Automation Test Data", 212, 11));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Yes in Delete warning message" + Sucessfull;
			}


			try {
				Thread.sleep(5000);
				M.ScrollDwon(2);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						count++;
						str = str + "\n" + "After Delete Cost incurred But Card Still Present ";
					}
				}

			} catch (Exception m) {
				;
			}
			
			

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				

			} catch (Exception m) {
				count++;
				str = str + "\n" + "After Add & Delete Liability card, when press Back button no Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "Delect Liability");
			M.setStrData("As Expected", "Automation Testcase", 616, 6);
			M.setStrData("Pass", "Automation Testcase", 616, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 616, 6);
			M.setStrData("Fail", "Automation Testcase", 616, 7);

		}

		ReStart();
	}
	
	

	// Order Cancellation with cost incured and Liability
	// @Test (priority = 38)
	public void OrderCancellationwithcostincuredAndLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Order Cancellation with cost incured and Liability Executed!");
		String str = "";
		int count = 0;
		int j = 240;
		int pass=0;
		boolean tr;

		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			//Cancel Head Data Fill up
			for(int i=0;i<=7;i++) {
				CancelationDataFillUP(i,228);
			}
			

			//Go to Cost incurred page
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}
			
			//cost data fill up
			for(int i=1;i<=4;i++) {
				CostDataFillUp(i,240);
			}
			
			//click add button
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
				Thread.sleep(2000);
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				} catch (Exception x) {
					;
				}
				
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Cost incurred Add Button doesn't work check manually";
				throw new Exception(str);
			}
			

			//Go to Liability page
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
			}
			
			//Liability data fill up
			for(int i=1;i<=5;i++) {
				LiabilityDataFillUp(i,242);
			}
			
			//Click Add Button
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
				Thread.sleep(2000);
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				} catch (Exception x) {
					;
				}
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Liability Add Button doesn't work check manually";
				throw new Exception(str);
			}
			
		
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelOrder").click();
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Order cancel button not found";
				throw new Exception(str);
			}
			
			Thread.sleep(2000);
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 210, 2), M.getstring("Automation Test Data", 210, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Order Cancelation Button "+ confirmation;
			}
			
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			}catch(Exception e) {
				count++;
				str = str + "\n" + "After press Order cancel button and warning message No, Order infomation page not found";
				throw new Exception(str);
			}
			
			
			try {
				Thread.sleep(5000);
				M.ScrollUpMinor(2);
			}catch(Exception e) {
				;
			}
			
			try {
				for(int i=1;i<=7;i++)
				{
					String result=VerifyCancellationHeadData(i,228,i);
					
					if(result.isBlank()) {
						;
					}else {
						count++;
						str = str + "\n" + "After click Order cancel warnning mess NO"+result;
						CancelationDataFillUP(i,228);
					}
					
				}
			}catch (Exception e) {
				
				count++;
				str = str + "\n" + e;
				//throw new Exception(str);
			}
			
			
			// check cost incurred and Liability if any data missing then add again
			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			
			List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
			int zxy=xyz.size();
			
			if(xyz.size()!=2) {
				count++;
				str = str + "\n" +"After click Order cancel warnning mess NO Cost incurred or Liability data is missing. ";
				
				
				for (int i = 0; i < 2; i++) {
					String text=M.getstring("Automation Test Data", j, 1);
					if(pass==2)
						break;
					if(zxy!=0) {
						System.out.println("ok= "+i);						
						try {
							if (xyz.get(i).getText().contains(text)) {
								System.out.println("in");
								j=j+2;
								i=-1;
								pass++;
							}
						}catch (Exception e) {
							
							i=1;
						}
						
					}
					
					int k=i+1;
					if(k==2) {
						j=j+2;
						i=-1;
						pass++;
						System.out.println("out");
						
						if(text.contentEquals(M.getstring("Automation Test Data", 240, 1))) {
							//Go to Cost Incurred page
							try {
								Thread.sleep(5000);
								M.ScrollDwon(1);
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
								Thread.sleep(2000);
								
								//Cost Incurred data fill up
								for(int n=1;n<=4;n++) {
									CostDataFillUp(n,240);
								}
								
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
								try {
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								} catch (Exception x) {
									;
								}
								
							} catch (Exception e) {
								count++;
								str = str + "\n" + e;
							}
						}
						else if	(text.contentEquals(M.getstring("Automation Test Data", 242, 1))) {
							//Go to Liability page	
							try {
								Thread.sleep(5000);
								M.ScrollDwon(1);
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
								Thread.sleep(2000);
								
								//Liability data fill up
								for(int n=1;n<=5;n++) {
									LiabilityDataFillUp(n,242);
								}
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
								try {
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								} catch (Exception x) {
									;
								}
								
							} catch (Exception e) {
								count++;
								str = str + "\n" + e;
							}
								
							
						}
					}

				}
			}

			

			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelOrder").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}catch(Exception e) {
				;
			}
			
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 210, 4), M.getstring("Automation Test Data", 210, 5));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				 
				 try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
					} catch (Exception x) {
						count++;
						str = str + "\n" +"After cancelation, Page doesn't Update & save change button not found";
					}
				 
				 try {
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").getText();
				 } catch (Exception x) {
					 count++;
					 str = str + "\n" +"After cancelation, Page doesn't Update & Delete button not found";
				 }
				 
				 
				
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"After Sucessfull Message yes Order Information page not found";
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
	
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Order Cancellation with cost incured and Liability");
			M.setStrData("As Expected", "Automation Testcase", 617, 6);
			M.setStrData("Pass", "Automation Testcase", 617, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Order Cancellation with cost incured and Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 617, 6);
			M.setStrData("Fail", "Automation Testcase", 617, 7);

		}
		ReStart();
	}
	
	
	// Verify Order Cancellation and Data
	// @Test (priority = 39)
	public void VerifyOrderCancellationAndData()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Order Cancellation and Data Executed!");
		int count=0;
		int pass=0;
		String str="";
		String gettext="";
		try {
			Thread.sleep(5000);
			M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(1000);
			DataUp(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(1000);
			int i=1;
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llMainLayout");
			int PONumber= driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber").size();
			if(xyz.size()==PONumber) {
				;
			}
			else {
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				}catch(Exception e) {
					i++;
				}
			}
			for (; i <= xyz.size(); i++) {				
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					//System.out.println(gettext);
					if (gettext.contains(M.getstring("Automation Test Data", 179, 1))) {

						gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 1), "Cancel Status Doesn't Match");
						pass++;
						break;
					}
				}catch(Exception e) {
					;
				}
			}
			if(pass==0) {
				count++;
				str = str + "\n" + "Cancel Status doesn't found in order list page.";
			}
			Thread.sleep(2000);
			M.ClickOn(M.getstring("Automation Test Data", 179, 1));
			

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtIsCanceled").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 1), "Cancel Status Doesn't Match in order details");
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Cancel Status doesn't found in order details page.";
			}
			
			
			//Go to cancelation page
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
			
			
			//Verrify CancelationHeadData
			for(int j=1;j<=7;j++)
			{
				String result=VerifyCancellationHeadData(j,228,j);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			// check cost incurred and Liability if any data missing then add again
			Thread.sleep(5000);
			M.ScrollDwon(1);
						
			xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
						
			if(xyz.size()!=2) {
				count++;
				str = str + "\n" +"Data missing in cost incurred Or Liability section";
			}
			
			try {
				 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
				 SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 2), "Save Changes button text Doesn't Match");
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Save Changes button not found";
			}
			
			try {
				 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").getText();
				 SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 3), "Delete button text Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Delete button not found";
			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
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
			M.ScreenShots("Screenshot/Passed","Verify Order Cancellation and Data"); 
		    M.setStrData("As Expected","Automation Testcase", 618, 6);
			M.setStrData("Pass","Automation Testcase", 618, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Order Cancellation and Data");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 618, 6);
			M.setStrData("Fail","Automation Testcase", 618, 7);
			
			
		}
		
		
		ReStart();
	}
		
		
	
	//Verify cancelation Delect & Save Change Button Disable/Enable (Deafult and With Blank Field)
	//@Test (priority = 40)
	public void VerifyDelectAndSaveChangeButton() throws Exception {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Delect & Save Change Button Disable/Enable (Deafult and With Blank Field) Executed!");
		int count=0;
		String str="";
		

		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			for(int i=0;i<=3;i++)
			{
				Thread.sleep(5000);
				
				if(i==0)
				{
					;
				}
				else if(i==1)
				{	//Remarks Fields
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCancelRemarks").clear();
					driver.hideKeyboard();
				}else if(i==2)
				{
					CancelRemarks(M.getstring("Automation Test Data", 228, 3));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					//Raw Material Value
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRawMaterialValue").clear();
					driver.hideKeyboard();

				}else
				{
					RawMaterialValue(M.getstring("Automation Test Data", 228, 6));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					//Finished Goods 
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFinishedGoodsValue").clear();
					driver.hideKeyboard();

				}
				
				Thread.sleep(2000);
				boolean tr;
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if(tr==true)
				{
					count++;
					if(i==0)
						str=str+"\n "+"No value change but Save Change Button is Enable";
					if(i==2)
						str=str+"\n "+"Raw Material Field is Blank but Save Change Button is Enable";
					if(i==3)
						str=str+"\n "+"Finished Good Field is Blank but Save Change Button is Enable";
				}else {
					count++;
					if(i==1)
						str=str+"\n "+"Remarks Field is not Blank but Save Change Button is Disable";
				}

				tr=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").isEnabled();
				if(tr==false)
				{
					count++;
					if(i==0)
						str=str+"\n "+i+"No value change but Delete Button is Disable";
					if(i==1)
						str=str+"\n "+i+"Remarks Field is Blank but Delete Button is Disable";
					if(i==2)
						str=str+"\n "+i+" Raw Material Field is Blank but Delete Button is Disable";
					if(i==3)
						str=str+"\n "+i+"Finished Good Field is Blank but Delete Button is Disable";
				}

				
			}
			
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}catch(Exception e) {
				;
			}

			
			if(count>0)
			{
				throw new Exception(str);	
			}

			
			M.ScreenShots("Screenshot/Passed","Verify Delect & Save Change Button");
			M.setStrData("As Expected","Automation Testcase",619, 6);
			M.setStrData("Pass","Automation Testcase", 619, 7);
			

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Delect & Save Change Button");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 619, 6);
			M.setStrData("Fail","Automation Testcase", 619, 7);
			
		}

		ReStart();	
		
	}
	
	

	// Verify Cancelation Save Change Button Disabled/Enabled(Before & After Editing)
	// @Test(priority = 41)
	public void VerifyCancelationSaveChangeButtonEnabled() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Cancelation Save Change Button Disable to Enabled Executed!");
		int count=0;
		int k=228;
		String str="";

		try {

			for(int i =1; i <= 11; i++) {

				try {
					Thread.sleep(5000);
					M.ClickOn(M.getstring("Automation Test Data", 179, 1));

					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
					
				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
				
				// CancelType
				if (i == 1) {
					
					CancelType(M.getstring("Automation Test Data", k, 1),1);
					
				}

				// CancelReason
				else if (i == 2) {
					CancelReason(M.getstring("Automation Test Data", k, 2),1);
					
				}
				// CancelRemarks
				else if (i == 3) {
					CancelRemarks(M.getstring("Automation Test Data", k, 3));
					
					
				}
				// CancellationDate
				else if (i == 4) {
					CancellationDate(M.getstring("Automation Test Data", k, 8),1);
					
					
				}

				// Curency
				else if (i == 5) {
					Curency(M.getstring("Automation Test Data", k, 5),1);
					
				}

				// RawMaterialValue
				else if (i == 6) {
					RawMaterialValue(M.getstring("Automation Test Data", k, 6));
					
				}
				
				//FinishedGoodsValue
				else if (i == 7) {
					FinishedGoodsValue(M.getstring("Automation Test Data",k, 7));
					
				}
				
				//Add Cost Incurred
				else if (i == 8) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					
					//Go to Cost incurred page
					try {
						Thread.sleep(5000);
						M.ScrollDwon(1);
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
						Thread.sleep(2000);

					} catch (Exception e) {
						count++;
						str = str + "\n" + e;
					}
					
					//cost data fill up
					for(int j=1;j<=4;j++) {
						CostDataFillUp(j,230);
					}
					

					//click add button
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
						
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
						}catch(Exception e) {
							;
						}
						
						Thread.sleep(2000);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					}catch (Exception e) {
						count++;
						str = str + "\n" + "Add Button doesn't work check manually";
						throw new Exception(str);
					}
				}
				
				//Delete Cost Incurred
				else if (i == 9) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					
					
					Thread.sleep(1000);
					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
					int item=xyz.size();
					int editId=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txt_delete").size();
					int j=0;	
					if (item == editId || item > editId) {
						for (int c = 0; c < item; c++) {
							if (xyz.get(c).getText().contains(M.getstring("Automation Test Data",230, 1))) {
								j=c+1;
								M.SwipBytext(M.getstring("Automation Test Data",230, 1));
								//System.out.println("item="+item);
								break;
							}
						}
					}else {
						
						for (int c = 0; c < item; c++) {
							
							if (xyz.get(c).getText().contains(M.getstring("Automation Test Data",230, 1))) {
								j = c+2;
								M.SwipBytext(M.getstring("Automation Test Data",230, 1));
								//System.out.println("item=="+item);
								break;
							}
 
						}
					}
					//System.out.println(item);
					//System.out.println(editId);
					System.out.println(j);
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
						
						
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

						}catch(Exception e) {
							;
						}
					}catch(Exception e) {
						count++;
						str = str + "\n" +"Delect Button Doesn't Work";
						//throw new Exception(str);
					}
					
					Thread.sleep(5000);
				}
				
				//Add Liability
				else if (i == 10) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					
					//Go to Liability page
					try {
						Thread.sleep(5000);
						M.ScrollDwon(1);
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
						Thread.sleep(2000);
						
					} catch (Exception e) {
						count++;
						str = str + "\n" + e;
					}
					
					//Liability data fill up
					for(int j=1;j<=5;j++) {
						LiabilityDataFillUp(j,232);
					}

					//click add button
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
						
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
						}catch(Exception e) {
							;
						}
						Thread.sleep(2000);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					}catch (Exception e) {
						count++;
						str = str + "\n" + "Add Button doesn't work check manually";
						throw new Exception(str);
					}
				}
				
				//Delete Liability
				else if (i == 11) {
					Thread.sleep(5000);
					M.ScrollDwon(2);
					
					
					Thread.sleep(1000);
					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
					int item=xyz.size();
					int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
					//System.out.println(liability);
					int result=item-liability;
					//System.out.println(result);
					int editId=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txt_delete").size();
					int j=0;	
					if (item == editId || item > editId) {
						for (int c = 0; c < item; c++) {
							if (xyz.get(c).getText().contains(M.getstring("Automation Test Data",232, 1))) {
								j=c+1-result;
								M.SwipBytext(M.getstring("Automation Test Data",232, 1));
								//System.out.println("item="+item);
								break;
							}
						}
					}else {
						
						for (int c = 0; c < item; c++) {
							
							if (xyz.get(c).getText().contains(M.getstring("Automation Test Data",232, 1))) {
								j = c+2-result;
								M.SwipBytext(M.getstring("Automation Test Data",232, 1));
								//System.out.println("item=="+item);
								break;
							}

						}
					}
					System.out.println(item);
					System.out.println(editId);
					System.out.println(j);
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
						//driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

						}catch(Exception e) {
							;
						}
					}catch(Exception e) {
						count++;
						str = str + "\n" +"Delect Button Doesn't Work";
						throw new Exception(str);
					}
					
					Thread.sleep(5000);
					
				}

				Thread.sleep(1000);
				
				Boolean tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == false) {
					//System.out.println(i);
					
					if (i == 1) {
						count++;
						str = str + "\n" + "After modify PoNumber Save Changes Button is Disable";
					}
						
					else if (i == 2){
						count++;
						str = str + "\n" + "After modify PoDate Save Changes Button is Disable";
					}
						
					else if (i == 3){
						count++;
						str = str + "\n" + "After modify SelectCustomer Save Changes Button is Disable";
					}
						
					else if (i == 4){
						count++;
						str = str + "\n" + "After modify ProductCategory Save Changes Button is Disable";
					}
						
					else if (i == 5){
						count++;
						str = str + "\n" + "After modify StyleNumber Save Changes Button is Disable";
					}
						
					else if (i == 6){
						count++;
						str = str + "\n" + "After modify ShipmentDate Save Changes Button is Disable";
					}
						
					else if (i == 7){
						count++;
						str = str + "\n" + "After modify Currency Save Changes Button is Disable";
					}
						
					
					
					
				}else {
					
					if (i == 8){
						count++;
						str = str + "\n" + "After Add Cost incured Save Changes Button is Enable";
					}
						
					else if (i == 9){
						count++;
						str = str + "\n" + "After Delete Cost Incurred Save Changes Button is Enable";
					}
						
					else if (i == 10){
						count++;
						str = str + "\n" + "After Add Liability Save Changes Button is Enable";
					}
						
					else if (i == 11){
						count++;
						str = str + "\n" + "After Delete Liability Save Changes Button is Enable";
					}
						
					
				}
				
				if(i<=12)
				{			
					// Back Button!!
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

					} catch (Exception e) {
						Thread.sleep(5000);
						M.BackFun(1);
					}
					
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					
					}catch(Exception e) {
						;
					}
				}
			

			}
			
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 620, 6);
			M.setStrData("Pass", "Automation Testcase", 620, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 620, 6);
			M.setStrData("Fail", "Automation Testcase", 620, 7);

		}
		ReStart();

	}

	

	
	// AddCostIncurredAfterCancelation
	// @Test (priority = 42)
	public void AddCostIncurredAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("AddCostIncurred AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int back = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// add Cost incurred
			try {
				for (int i = 1; i <= 4; i++) {
					CostDataFillUp(i, 230);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Cancel Button not found";
				throw new Exception(str);
			}

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 2),M.getstring("Automation Test Data", 212, 3));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press add Button " + Sucessfull;
				System.out.println("print");
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']")
						.getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				count++;
				str = str + "\n" + "After Click add Button, page doesn't Redirect to Order info Page";
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n"
							+ "After Click add Button, page doesn't Redirect to Order info Page and when press cancel button Unsave Warrning message show";
				} catch (Exception x) {
					;
				}

			}

			// go again add page to check field is Blank or not.
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
				Thread.sleep(2000);

				// Verrify Cost Incurred
				for (int i = 1; i <= 4; i++) {
					String result = VerifyCostIncurredData(i, 224, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + result;
					}

				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']")
							.getText();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					;
				}
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
			} catch (Exception m) {
				;
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				count++;
				str = str + "\n" + "After Add Cost incurred Card when press Back button Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "AddCostIncurred");
			M.setStrData("As Expected", "Automation Testcase", 621, 6);
			M.setStrData("Pass", "Automation Testcase", 621, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "AddCostIncurred");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 621, 6);
			M.setStrData("Fail", "Automation Testcase", 621, 7);

		}

		ReStart();
	}
	
	
	
	
	// VerifyCostIncurredAfterCancelation
	// @Test (priority = 43)
	public void VerifyCostIncurredAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("VerifyCostIncurred AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int back = 0;
		int count = 0;
		try {
			
			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				Thread.sleep(2000);
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			//Verify Cost incurred card
			int pass=0;
			int j=0;
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
						pass++;
						j=i+1;
						String gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 230, 4),"Card Remarks Doesn't Match");
						//System.out.println(gettext);
						
						gettext = M.getstring("Automation Test Data", 230, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 230, 3),"CostIncurred Value Doesn't Match");
						//System.out.println(gettext);
					}
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			
			if(pass==0){
				count++;
				str = str + "\n" + "After Create Cost incurred But No card Found";
				throw new Exception(str);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Cost Incurred
					
					for (int i = 1; i <= 4; i++) {
						String result = VerifyCostIncurredData(i, 230, i);
						
						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}
						
					}
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
				count++;
				str = str + "\n" + "After verification cost incurred when press Back button Warning message show";
				
			} catch (Exception m) {
				
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
			
			M.ScreenShots("Screenshot/Passed", "VerifyCostIncurredAfterCancelation");
			M.setStrData("As Expected", "Automation Testcase", 622, 6);
			M.setStrData("Pass", "Automation Testcase", 622, 7);
			
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "VerifyCostIncurredAfterCancelation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 622, 6);
			M.setStrData("Fail", "Automation Testcase", 622, 7);
			
		}
		
		ReStart();
	}
	
	
	
	
	// Verify Cost incurred Edit Button After Cancelation(Default & Blank Field)
	// @Test (priority = 44)
	public void VerifyCostIncurredEditButton() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disabled Cost incurred Edit Button After Cancelation (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 230;
		boolean tr;

		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			int j=0;
			int pass=0;
			try {
				Thread.sleep(2000);
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
						j=i+1;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}
			for (int i = 0; i <= 2; i++) {
				//Go to cost incurred page
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					Thread.sleep(2000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

						
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred edit button Doesn't Work";
						throw new Exception(str);
					}
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Edit Button not found";
					throw new Exception(str);
				}
		
				
				// Full Field Blank
				if (i == 0) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						count++;
						str = str + "By Default Edit Button is Enable";

					}
					Thread.sleep(5000);
					i++;

				}
				//Cost Incurred
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").clear();
					driver.hideKeyboard();
				}

				//Cost Remarks
				if (i == 2) {
					//Cost Incurred
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").clear();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etCostIncurred").setValue(M.getstring("Automation Test Data", 230, 3));
					driver.hideKeyboard();
					
					//Cost Remarks
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").clear();
					driver.hideKeyboard();
				}

				if (i == 2) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == false) {
						count++;
						str = str + "\n" + " Remarks Field is Optional But Edit Button is Disable";
					}
				}

				else {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						System.out.println(i);
						count++;
						if (i == 1)
							str = str + "\n" + "Cost Incurred Field is Blank But Edit Button is Enable";
					}

				}

				if (i != 3) {
					// back to Order info
					try {
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
						try {
							Thread.sleep(1000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception m) {
							;
						}
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred Cancel Button not found";
						throw new Exception(str);
					}

					try {
						Thread.sleep(1000);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred Cancel Button Doesn't Work";
						throw new Exception(str);
					}
				}

			}
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disabled Cancel Button (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 623, 6);
			M.setStrData("Pass", "Automation Testcase", 623, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disabled Cancel Button (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 623, 6);
			M.setStrData("Fail", "Automation Testcase", 623, 7);

		}
		ReStart();
	}

	

	// Verify Edit Button Enabled in cost incurred(Before & After Editing)
	// @Test(priority = 45)
	public void VerifyEditButtonEnabledInCostIncurred() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Edit Button Enabled in Cost Incurred (Before & After Editing) Executed!");
		String str = "";
		int count = 0;
		boolean tr;
		int j=0;
		int pass=0;
		int k=236;

		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
						j=i+1;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}
			
			for(int i = 1; i <= 4; i++) {
				//Go to Edit cost incurred page
				try {
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					Thread.sleep(2000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

						
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred edit button Doesn't Work";
						throw new Exception(str);
					}
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Edit Button not found";
					throw new Exception(str);
				}
				
				//data input
				CostDataFillUp(i,k);

				Thread.sleep(1000);
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
				if (tr == false) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "After modify Order Cost Head Field, but Edit Button is Disable";
					else if (i == 2)
						str = str + "\n" + "After modify Currency Field, but Edit Button is Disable";
					else if (i == 3)
						str = str + "\n" + "After modify CostIncurred Field, but Edit Button is Disable";
					else if (i == 4)
						str = str + "\n" + "After modify Remarks Field, but Edit Button is Disable";
					
				}
				
				
				if(i!=5) {
					// back to Order info
					try {
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
						try {
							Thread.sleep(1000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception m) {
							;
						}
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred Cancel Button not found";
						throw new Exception(str);
					}

					try {
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred Cancel Button Doesn't Work";
						throw new Exception(str);
					}
				}
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Edit Button Enabled in Cost Incurred(Before & After Editing)");
			M.setStrData("As Expected", "Automation Testcase", 624, 6);
			M.setStrData("Pass", "Automation Testcase", 624, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Edit Button Enabled in Cost Incurred(Before & After Editing)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 624, 6);
			M.setStrData("Fail", "Automation Testcase", 624, 7);

		}
		ReStart();

	}

	
	
	// Dismiss Unsaved Data CostIncurred After Cancelation(Default & All fields together)
	// @Test (priority = 46)
	public void DismissUnsavedDataInExistingCostIncurred() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Cost Incurred Dismiss Unsaved Data (Default & All fields together) Executed!");
		SoftAssert SA=new SoftAssert();
		String str="";
		int back=0;
		int pass=0;
		int j=0;
		int count=0;
		Thread.sleep(2000);
		try {
			//Go to Cancelation page.
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
						j=i+1;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}

			//Go to Edit cost incurred page
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
					throw new Exception(str);
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
			
			
			
			//Check Default
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Cancel Button not found";
				throw new Exception(str);
			}
			try {
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				count++;
				str = str + "\n" + "After click cancel button show warnning messsage with-out Edit data";
			} catch (Exception m) {
				;
			}
			
			try {
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Cost incurred Cancel Button Doesn't Work";
				throw new Exception(str);
			}
			//Go to Edit cost incurred page
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				
			} catch (Exception m) {
				
				throw new Exception(str);
			}
						
			
			for(int i=1;i<=4;i++) {
				CostDataFillUp(i,236);
			}
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Cancel Button not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Cancel Button "+ confirmation;
			}
			
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Cost Incurred']").getText();
				
				try {
					for(int i=1;i<=4;i++)
					{
						String result=VerifyCostIncurredData(i,236,i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" + result;
							CostDataFillUp(i,236);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
				Thread.sleep(5000);
				M.BackFun(1);
				
				str = str + "\n" + "After click Cancel, Page Redirect to order information page";
				throw new Exception(str);
				
			}
				
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Cost incurred Cancel warnning yes button Doesn't Work";
				throw new Exception(str);
			}

			
			//check data update or not
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contentEquals(M.getstring("Automation Test Data", 236, 1))) {
						count++;
						str = str + "\n" + "After Dissmiss data by cancel button but cost incurred data Update ";
						break;
					}
				}
			}catch (Exception e) {
				count++;
				str = str + "\n" +"Apps Crush Check Manually";
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
						
			if (count > 0) {
				throw new Exception(str);
			}
		
			M.ScreenShots("Screenshot/Passed","Dismiss Unsaved Data All & together");			  
		    M.setStrData("As Expected","Automation Testcase", 625, 6);
			M.setStrData("Pass","Automation Testcase", 625, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Unsaved Data All & Together");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 625, 6);
			M.setStrData("Fail","Automation Testcase", 625, 7);
	
		}
		
		ReStart();
	}
	

	
	// Dismiss Unsaved Data In Existing CostIncurred After Cancelation(For Each Field)
	// @Test(priority = 47)
	public void DismissUnsavedDataInExistingCostIncurredForEach() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Dismiss Unsaved Data In Existing Cost Incurred (For Each Field) Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		int j = 0;
		int pass = 0;
		int count = 0;
		int k = 236;
		Thread.sleep(2000);
		try {

			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
						j=i+1;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}

			//Go to Edit cost incurred page
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
					throw new Exception(str);
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
			
			

			for (int i = 1; i <= 4; i++) {

				if (pass == 0) {
					// Go to cancellatin page
					Thread.sleep(5000);
					M.ScrollDwon(1);
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					Thread.sleep(2000);
					pass = 0;
				}

				// Form Fillup......
				
				CostDataFillUp(i, k);

				Thread.sleep(1000);

				// Back Button!!
				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Cost incurred Cancel Button not found";
					throw new Exception(str);
				}

				// Warring_Message but use sucessful method
				Thread.sleep(2000);
				String Warring_Message = M.Sucessfull_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
				if (Warring_Message.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "After change "+M.getstring("Automation Test Data", 224, i)+ " & When press cancel button ."+Warring_Message;
				}

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					pass=0;

				} catch (Exception e) {
					count++;
					str = str + "\n" + "After click Cancel button and yes button Orders Information page Not Found";
					pass++;
					try {
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Cost Incurred']").getText();

					} catch (Exception x) {
						count++;
						str = str + "\n" + "After press Back button Check Manually";
						throw new Exception(str);
					}
				}


			}
			//Press Back button
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data In Existing Cost Incurred (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 626, 6);
			M.setStrData("Pass", "Automation Testcase", 626, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data In Existing Cost Incurred (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 626, 6);
			M.setStrData("Fail", "Automation Testcase", 626, 7);

		}
		ReStart();

	}
	
	
	
	// Edit Cost Incurred AfterCancelation
	// @Test (priority = 48)
	public void EditCostIncurredAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Edit CostIncurred After Cancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		int j=0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			try {
				
				try {
					List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
					for (int i = 0; i < xyz.size(); i++) {
						if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
							pass++;
							j=i+1;
						}
					}
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + m;
				}
				
				if(pass==0){
					count++;
					str = str + "\n" + "Cost incurred Card Not Found";
					throw new Exception(str);
				}
				
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 230, 1));
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					

				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
					throw new Exception(str);
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
			
			//Edit Cost incurred
			try {
				for (int i = 1; i <= 4; i++) {
					CostDataFillUp(i, 236);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Cost incurred Edit Button not found";
				throw new Exception(str);
			}
			

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 8),M.getstring("Automation Test Data", 212, 9));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Edit Button " + Sucessfull;
			}

			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				

			} catch (Exception e) {
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Edit Cost Incurred']").getText();

				count++;
				str = str + "\n" +"After Click edit button, it found Edit Cost incurred page.";
				
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After Update data when press cancel button warring message show";
					
				} catch (Exception x) {
					;
				}
				
			}
			

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
				count++;
				str = str + "\n" + "After Edit Cost incurred, when press Back button from order info page Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "Edit CostIncurred After Cancelation");
			M.setStrData("As Expected", "Automation Testcase", 627, 6);
			M.setStrData("Pass", "Automation Testcase", 627, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Edit CostIncurred After Cancelation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 627, 6);
			M.setStrData("Fail", "Automation Testcase", 627, 7);

		}

		ReStart();
	}
	


	// Verify Edit CostIncurred AfterCancelation
	// @Test (priority = 49)
	public void VerifyEditCostIncurredAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Edit CostIncurred AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int j = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 236, 1))) {
						String gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 236, 4),"Card Remarks Doesn't Match");
						//System.out.println(gettext);
						
						gettext = M.getstring("Automation Test Data", 236, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 236, 3),"CostIncurred Value Doesn't Match");
						//System.out.println(gettext);
						pass++;
						j=i+1;
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "After Update Cost incurred but data not update in cost incurred Card";
				throw new Exception(str);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 236, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Cost Incurred

					for (int i = 1; i <= 4; i++) {
						String result = VerifyCostIncurredData(i, 236, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}

					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();


				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
					throw new Exception(str);
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
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

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();			
				count++;
				str = str + "\n" + "After Verify Edit Cost incurred, But when press Back button from Order info page Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "Verify Edit CostIncurred AfterCancelation");
			M.setStrData("As Expected", "Automation Testcase", 628, 6);
			M.setStrData("Pass", "Automation Testcase", 628, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Edit CostIncurred AfterCancelation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 628, 6);
			M.setStrData("Fail", "Automation Testcase", 628, 7);

		}

		ReStart();
	}
	
		
	
	// Delect Cost Incurred
	// @Test (priority = 50)
	public void DelectCostIncurredAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Delect CostIncurred AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int j = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 236, 1))) {
						pass++;
						j=i+1;
					}
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			
			if(pass==0){
				count++;
				str = str + "\n" + "Cost incurred Card Not Found";
				throw new Exception(str);
			}
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 236, 1));
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
				

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Delete Button Not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 212, 4), M.getstring("Automation Test Data", 212, 5));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Delete Button "+ confirmation;
			}
					
			//verify card after warning message No
			pass=0;
			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 236, 1))) {
						pass++;
						j=i+1;
					}
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			
			if(pass==0){
				count++;
				str = str + "\n" + "After delete warning message no, Cost incurred Card Not Found";
				throw new Exception(str);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 236, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
				

			} catch (Exception m) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + "After click delete button, warning yes button not found.";
				throw new Exception(str);
			}
			
			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 10),M.getstring("Automation Test Data", 212, 11));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press warning Yes Button " + Sucessfull;
			}

			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 236, 1))) {
						count++;
						str = str + "\n" + "After Delete Cost incurred But Card Still Present ";
					}
				}
				
				
					
			} catch (Exception m) {
				;
			}
			

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				count++;
				str = str + "\n" + "After Delete card when press Back button Warning message show";
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

			M.ScreenShots("Screenshot/Passed", "Delect Cost Incurred After Cancelation");
			M.setStrData("As Expected", "Automation Testcase", 629, 6);
			M.setStrData("Pass", "Automation Testcase", 629, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Cost Incurred After Cancelation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 629, 6);
			M.setStrData("Fail", "Automation Testcase", 629, 7);

		}

		ReStart();
	}
	


	// AddLiabilityAfterCancelation
	// @Test (priority = 51)
	public void AddLiabilityAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Add Liability AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int back = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			// add Liabilities
			try {
				for (int i = 1; i <= 5; i++) {
					LiabilityDataFillUp(i, 232);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liability Cancel Button not found";
				throw new Exception(str);
			}

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 2),M.getstring("Automation Test Data", 212, 3));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press add Button " + Sucessfull;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

			} catch (Exception e) {

				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();

				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				count++;
				str = str + "\n" + "After Click add Button, page doesn't Redirect to Order info Page";
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n"+ "After Click add Button, page doesn't Redirect to Order info Page and when press cancel button Unsave Warrning message show";
				} catch (Exception x) {
					;
				}

			}

			// go again add page to check field is Blank or not.
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
				Thread.sleep(2000);

				// Verrify Liabilities
				for (int i = 1; i <= 5; i++) {
					String result = VerifyLiabilityData(i, 226, i);

					if (result.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" +"After create Go again add page to check field is Blank or not"+ result;
					}

				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After create Liabilities then go agian add Liabilities page and without input data click cancel button show warring message.";
				} catch (Exception m) {
					;
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					;
				}
			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				count++;
				str = str + "\n" + "Add Liabilities But when press Back button, Warning message show";
				
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

			M.ScreenShots("Screenshot/Passed", "Add Liability AfterCancelation");
			M.setStrData("As Expected", "Automation Testcase", 630, 6);
			M.setStrData("Pass", "Automation Testcase", 630, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Add Liability AfterCancelation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 630, 6);
			M.setStrData("Fail", "Automation Testcase", 630, 7);

		}

		ReStart();
	}
	
	
	
	// VerifyLiabilityAfterCancelation
	// @Test (priority = 52)
	public void VerifyLiabilityAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Liability AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int back = 0;
		int count = 0;
		try {
			
			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(2);
				Thread.sleep(2000);
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			//Verify Cost incurred card
			int pass=0;
			int j=0;

			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						pass++;
						j=i+1-result;
						String gettext = M.getstring("Automation Test Data", 232, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 232, 3),"CostIncurred Value Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, "Repayment Days","Repayment Days Text Doesn't Match in card");
						//System.out.println(gettext);
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").get(--j).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 232, 4)+" Days","Repayment Days Value Doesn't Match in card");
						//System.out.println(gettext);
						j++;
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 232, 5),"Card Remarks Doesn't Match in card");
						//System.out.println(gettext);
						
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			if(pass==0) {
				count++;
				str = str + "\n" + "After create Liability, Card not Found";
				throw new Exception(str);
			}

			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Cost Incurred

					for (int i = 1; i <= 5; i++) {
						String result = VerifyLiabilityData(i, 232, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}

					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Liabiliyies edit button Doesn't Work";
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
				count++;
				str = str + "\n" + "After verification cost incurred when press Back button Warning message show";
				
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
			
			M.ScreenShots("Screenshot/Passed", "VerifyLiability AfterCancelation");
			M.setStrData("As Expected", "Automation Testcase", 631, 6);
			M.setStrData("Pass", "Automation Testcase", 631, 7);
			
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "VerifyLiability AfterCancelation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 631, 6);
			M.setStrData("Fail", "Automation Testcase", 631, 7);
			
		}
		
		ReStart();
	}

	
	
	// Verify LiabilityEdit Button After Cancelation(Default & Blank Field)
	// @Test (priority = 53)
	public void VerifyLiabilityEditButton() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Disable Liability Edit Button After Cancelation (Default & Blank Field) Executed!");
		String str = "";
		int count = 0;
		int k = 230;
		boolean tr;

		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			int j=0;
			int pass=0;
			try {
				Thread.sleep(2000);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						j=i+1-result;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}
			for (int i = 0; i <= 3; i++) {
				//Go to cost incurred page
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					Thread.sleep(2000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

						
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Liability edit button Doesn't Work";
						throw new Exception(str);
					}
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Liability Edit Button not found";
					throw new Exception(str);
				}
		
				
				// Full Field Blank
				if (i == 0) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						count++;
						str = str + "By Default Edit Button is Enable";

					}
					Thread.sleep(5000);
					i++;

				}
				//LiabilityAmount
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etLiabilityAmount").clear();
					driver.hideKeyboard();
				}
				//Liability RepaymentDays
				if (i == 2) {
					LiabilityAmount(M.getstring("Automation Test Data", 232, 3));
					
					//Liability RepaymentDays
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRepaymentDays").clear();
					driver.hideKeyboard();
				}

				//Liability Remarks
				if (i == 3) {
					RepaymentDays(M.getstring("Automation Test Data", 232, 4));
					
					//Liability Remarks
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etRemarks").clear();
					driver.hideKeyboard();
				}

				if (i == 3) {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == false) {
						count++;
						str = str + "\n" + " Remarks Field is Optional But Edit Button is Disable";
					}
				}

				else {
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
					if (tr == true) {
						System.out.println(i);
						count++;
						if (i == 1)
							str = str + "\n" + "Liability Amount Field is Blank But Edit Button is Enable";
						if (i == 2)
							str = str + "\n" + "Liability RepaymentDays Field is Blank But Edit Button is Enable";
					}

				}

				if (i != 4) {
					// back to Order info
					try {
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
						try {
							Thread.sleep(1000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception m) {
							;
						}
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Liability Cancel Button not found";
						throw new Exception(str);
					}

					try {
						Thread.sleep(1000);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Liability Cancel Button Doesn't Work";
						throw new Exception(str);
					}
				}

			}
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Disable Liability Edit Button After Cancelation (Default & Blank Field)");
			M.setStrData("As Expected", "Automation Testcase", 632, 6);
			M.setStrData("Pass", "Automation Testcase", 632, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Disable Liability Edit Button After Cancelation (Default & Blank Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 632, 6);
			M.setStrData("Fail", "Automation Testcase", 632, 7);

		}
		ReStart();
	}

	

	// Verify Edit Button Enabled in Liability(Before & After Editing)
	// @Test(priority = 54)
	public void VerifyEditButtonEnabledInLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Edit Button Enabled in Liability (Before & After Editing) Executed!");
		String str = "";
		int count = 0;
		boolean tr;
		int j=0;
		int pass=0;
		int k=238;

		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						j=i+1-result;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}
			
			for(int i = 1; i <= 5; i++) {
				//Go to Edit cost incurred page
				try {
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					Thread.sleep(2000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

						
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Cost incurred edit button Doesn't Work";
						throw new Exception(str);
					}
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Edit Button not found";
					throw new Exception(str);
				}
				
				//data input
				LiabilityDataFillUp(i,k);

				Thread.sleep(1000);
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").isEnabled();
				if (tr == false) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "After modify Order Liability Head Field, but Edit Button is Disable";
					else if (i == 2)
						str = str + "\n" + "After modify Currency Field, but Edit Button is Disable";
					else if (i == 3)
						str = str + "\n" + "After modify Liability Amount Field, but Edit Button is Disable";
					else if (i == 4)
						str = str + "\n" + "After modify Repament Days Field, but Edit Button is Disable";
					else if (i == 5)
						str = str + "\n" + "After modify Remarks Field, but Edit Button is Disable";
					
				}

				if(i!=6) {
					// back to Order info
					try {
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
						try {
							Thread.sleep(1000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception m) {
							;
						}
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Liability Cancel Button not found";
						throw new Exception(str);
					}

					try {
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					} catch (Exception m) {
						count++;
						str = str + "\n" + "Liability Cancel Button Doesn't Work";
						throw new Exception(str);
					}
				}
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Edit Button Enabled in Liability(Before & After Editing)");
			M.setStrData("As Expected", "Automation Testcase", 633, 6);
			M.setStrData("Pass", "Automation Testcase", 633, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Verify Edit Button Enabled in Liability(Before & After Editing)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 633, 6);
			M.setStrData("Fail", "Automation Testcase", 633, 7);

		}
		ReStart();

	}

	
	
	// Dismiss Unsaved Data Liability After Cancelation(Default & All fields together)
	// @Test (priority = 55)
	public void DismissUnsavedDataInExistingLiability() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		System.out.println("Dismiss Unsaved Data In Existing Liability (Default & All fields together) Executed!");
		SoftAssert SA=new SoftAssert();
		String str="";
		int back=0;
		int pass=0;
		int j=0;
		int count=0;
		Thread.sleep(2000);
		try {
			//Go to Cancelation page.
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(1);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						j=i+1-result;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}


			//Go to Edit Liability page
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
					throw new Exception(str);
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
			
			
			
			//Check Default
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liability Cancel Button not found";
				throw new Exception(str);
			}
			try {
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
			} catch (Exception m) {
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					Thread.sleep(1000);
					String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					count++;
					str = str + "\n" + "After click cancel button show warnning messsage with-out Edit data";
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Apps Crush check it.";
					throw new Exception(str);
				}
			}
			
			try {
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Liability Cancel Button Doesn't Work";
				throw new Exception(str);
			}
			//Go to Edit Liability page
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				
			} catch (Exception m) {
				
				throw new Exception(str);
			}
						
			
			for(int i=1;i<=5;i++) {
				LiabilityDataFillUp(i,238);
			}
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liability Cancel Button not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Cancel Button "+ confirmation;
			}
			
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Liability']").getText();
				
				try {
					for(int i=1;i<=5;i++)
					{
						String result=VerifyLiabilityData(i,238,i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" + result;
							LiabilityDataFillUp(i,238);
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
			} catch (Exception e) {	
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
				Thread.sleep(5000);
				M.BackFun(1);
				
				str = str + "\n" + "After click Cancel button, Page Redirect to order information page";
				throw new Exception(str);
				
			}
				
			
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Cost incurred Cancel warnning yes button Doesn't Work";
				throw new Exception(str);
			}

			
			//check data update or not
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				Thread.sleep(5000);
				M.ScrollDwon(1);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contentEquals(M.getstring("Automation Test Data", 238, 1))) {
						count++;
						str = str + "\n" + "After Dissmiss data by cancel button but Liability data Update ";
						break;
					}
				}
			}catch (Exception e) {
				count++;
				str = str + "\n" +"Apps Crush Check Manually";
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
						
			if (count > 0) {
				throw new Exception(str);
			}
		
			M.ScreenShots("Screenshot/Passed","Dismiss Unsaved Data In Existing Liability (Default & All fields together)");			  
		    M.setStrData("As Expected","Automation Testcase", 634, 6);
			M.setStrData("Pass","Automation Testcase", 634, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Dismiss Unsaved Data In Existing Liability (Default & All fields together)");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 634, 6);
			M.setStrData("Fail","Automation Testcase", 634, 7);
	
		}
		
		ReStart();
	}
	

	
	// Dismiss Unsaved Data In Existing Liability After Cancelation(For Each Field)
	// @Test(priority = 56)
	public void DismissUnsavedDataInExistingLiabilityForEach() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Dismiss Unsaved Data In Existing Liability (For Each Field) Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		int j = 0;
		int pass = 0;
		int count = 0;
		int k = 238;
		Thread.sleep(2000);
		try {
			//Go to Cancelation page.
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(2);;
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(2000);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						j=i+1-result;
						pass++;
					}
				}
				
			} catch (Exception x) {
				count++;
				str = str + "\n" + x;
			}
			if(pass==0){
				count++;
				str = str + "\n" + "Selected Card Not Found";
				throw new Exception(str);
			}


			//Go to Edit Liability page
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred edit button Doesn't Work";
					throw new Exception(str);
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
						

			for (int i = 1; i <= 5; i++) {

				if (pass == 0) {
					// Go to Liability page
					Thread.sleep(5000);
					M.ScrollDwon(1);
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
					Thread.sleep(2000);
					pass = 0;
				}

				// Form Fillup......
				
				LiabilityDataFillUp(i, k);

				Thread.sleep(1000);

				// Back Button!!
				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();

				} catch (Exception e) {
					count++;
					str = str + "\n" + "Liability Cancel Button not found";
					throw new Exception(str);
				}

				// Warring_Message but use sucessful method
				Thread.sleep(2000);
				String Warring_Message = M.Sucessfull_Message(M.getstring("Automation Test Data", 208, 3), M.getstring("Automation Test Data", 208, 4));
				if (Warring_Message.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + "After change "+M.getstring("Automation Test Data", 226, i)+Warring_Message;
				}

				try {
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					pass=0;

				} catch (Exception e) {
					count++;
					str = str + "\n" + "After click Cancel button and yes button Orders Information page Not Found";
					pass++;
					try {
						String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Edit Liability']").getText();

					} catch (Exception x) {
						count++;
						str = str + "\n" + "After press Back button Check Manually";
						throw new Exception(str);
					}
				}


			}
			//Press Back button
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Dismiss Unsaved Data In Existing Liability (For Each Field)");
			M.setStrData("As Expected", "Automation Testcase", 635, 6);
			M.setStrData("Pass", "Automation Testcase", 635, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Dismiss Unsaved Data In Existing Liability (For Each Field)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 635, 6);
			M.setStrData("Fail", "Automation Testcase", 635, 7);

		}
		ReStart();

	}
	
	
	// Edit Liability
	// @Test (priority = 57)
	public void EditLiabilityAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Edit Liability AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		Thread.sleep(5000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(5000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(2);
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			
			//Verify Cost incurred card
			int j=0;

			try {
				
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
						j=i+1-result;
						
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			

			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 232, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();

				} catch (Exception m) {
					count++;
					str = str + "\n" + "Liabilities edit button Doesn't Work";
					throw new Exception(str);
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
				throw new Exception(str);
			}
			
			//Edit Liabilities
			try {
				for (int i = 1; i <= 5; i++) {
					LiabilityDataFillUp(i, 238);
				}
			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
				throw new Exception(str);
			}

			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();

			} catch (Exception m) {

				count++;
				str = str + "\n" + "Liabilities Edit Button not found";
				throw new Exception(str);
			}
			

			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 8),M.getstring("Automation Test Data", 212, 9));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Edit Button " + Sucessfull;
			}

			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
			} catch (Exception e) {
				
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Edit Liability']").getText();

				count++;
				str = str + "\n" +"After Click edit button, it doesn't redirect to Order Info page";
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
				
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After sucessfully Edit data when press cancel button warring message show";
					
				} catch (Exception x) {
					;
				}

			}

			/*
			//Verify card data after update
			j=0;
			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 238, 1))) {
						pass++;
						j=i+1-result;
						String gettext = M.getstring("Automation Test Data", 238, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 238, 3),"CostIncurred Value Doesn't Match in card");
						System.out.println(gettext);
						
						gettext = driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, "Repayment Days","Repayment Days Text Doesn't Match in card");
						System.out.println(gettext);
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").get(--j).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 238, 4)+" Days","Repayment Days Value Doesn't Match in card");
						System.out.println(gettext);
						j++;
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 238, 5),"Card Remarks Doesn't Match in card");
						System.out.println(gettext);
						
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Card data not update After Edit.";
	
			}
			
			*/

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				count++;
				str = str + "\n" + "Edit Liability card But when press Back button Warning message show";
			} catch (Exception m) {
				
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

			M.ScreenShots("Screenshot/Passed", "Edit Liability");
			M.setStrData("As Expected", "Automation Testcase", 636, 6);
			M.setStrData("Pass", "Automation Testcase", 636, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Edit Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 636, 6);
			M.setStrData("Fail", "Automation Testcase", 636, 7);

		}

		ReStart();
	}
	
	
	
	// Verify Edit Liability
	// @Test (priority = 58)
	public void VerifyEditLiabilityAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Edit Liability AfterCancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int pass = 0;
		int count = 0;
		Thread.sleep(2000);
		try {
			
			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(2);
				Thread.sleep(2000);
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			//Verify Cost incurred card
			
			int j=0;

			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 238, 1))) {
						pass++;
						j=i+1-result;
						String gettext = M.getstring("Automation Test Data", 238, 2);
						if (gettext.contains("BDT")) {
							text = "৳ ";
						} else
							text = "$ ";

						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostIncurredValue").get(i).getText();
						SA.assertEquals(gettext, text + M.getstring("Automation Test Data", 238, 3),"CostIncurred Value Doesn't Match in card");
						System.out.println(gettext);
						
						gettext = driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						SA.assertEquals(gettext, "Repayment Days","Repayment Days Text Doesn't Match in card");
						System.out.println(gettext);
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").get(--j).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 238, 4)+" Days","Repayment Days Value Doesn't Match in card");
						System.out.println(gettext);
						j++;
						
						gettext = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRemarks").get(i).getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 238, 5),"Card Remarks Doesn't Match in card");
						System.out.println(gettext);
						
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + m;
			}
			if(pass==0) {
				count++;
				str = str + "\n" + "After update Liability, But Card not Update";
				throw new Exception(str);
			}

			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 238, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_saveMessage").isDisplayed();
					// Verrify Cost Incurred

					for (int i = 1; i <= 5; i++) {
						String result = VerifyLiabilityData(i, 238, i);

						if (result.isBlank()) {
							;
						} else {
							count++;
							str = str + "\n" + result;
						}

					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
					
				} catch (Exception m) {
					count++;
					str = str + "\n" + "Liabiliyies edit button Doesn't Work";
				}
				
			} catch (Exception m) {
				count++;
				str = str + "\n" + "Edit Button not found";
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
				count++;
				str = str + "\n" + "After verification Liability when press Back button Warning message show";
				
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
			
			M.ScreenShots("Screenshot/Passed", "verify Edit Liability");
			M.setStrData("As Expected", "Automation Testcase", 637, 6);
			M.setStrData("Pass", "Automation Testcase", 637, 7);
			
		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "verify Edit Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 637, 6);
			M.setStrData("Fail", "Automation Testcase", 637, 7);
			
		}
		
		ReStart();
	}
	
	

	// Delect Liability After Cancelation
	// @Test (priority = 59)
	public void DelectLiabilityAfterCancelation() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Delect Liability After Cancelation Executed!");
		SoftAssert SA = new SoftAssert();
		String str = "";
		String text = "";
		int j = 0;
		int pass = 0;
		int count = 0;
		Thread.sleep(2000);
		try {

			// Go to cancellatin page
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				Thread.sleep(5000);
				M.ScrollDwon(2);
				Thread.sleep(2000);

			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}


			try {
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				int item=xyz.size();
				int liability=driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtRepaymentDays").size();
				//System.out.println(liability);
				int result=item-liability;
				//System.out.println(result);
		
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 238, 1))) {
						j=i+1-result;
					}
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 238, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				
				Thread.sleep(2000);
				

			} catch (Exception m) {
				count++;
				str = str + "\n" + "Delete Button Not found";
				throw new Exception(str);
			}
			
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 212, 6), M.getstring("Automation Test Data", 212, 7));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Delete Button "+ confirmation;
			}
			
			

			try {
				Thread.sleep(5000);
				M.ScrollDwon(2);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 238, 1))) {
						pass++;
					}
				}

			} catch (Exception m) {
				count++;
				str = str + "\n" + "After click Delete Warning Message No, But card not found";
				throw new Exception(str);
			}
				

			if(pass==0){
				count++;
				str = str + "\n" + "After click Delete Warning Message No, But card not found";
				throw new Exception(str);
			}
			
			
			try {
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				M.SwipBytext(M.getstring("Automation Test Data", 238, 1));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
				

			} catch (Exception m) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				
			} catch (Exception x) {
				;
			}
			
			// check Sucessfull message
			Thread.sleep(2000);
			String Sucessfull = M.Sucessfull_Message(M.getstring("Automation Test Data", 212, 10),M.getstring("Automation Test Data", 212, 11));
			if (Sucessfull.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + "After Press Yes in Delete warning message" + Sucessfull;
			}


			try {
				Thread.sleep(5000);
				M.ScrollDwon(2);

				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 238, 1))) {
						count++;
						str = str + "\n" + "After Delete Liability card But Card Still Present ";
					}
				}

			} catch (Exception m) {
				;
			}
			
			

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}

			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				count++;
				str = str + "\n" + "After Add & Delete Liability card, when press Back button Warning message show";

			} catch (Exception m) {
				
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

			M.ScreenShots("Screenshot/Passed", "Delect Liability After Cancelation");
			M.setStrData("As Expected", "Automation Testcase", 638, 6);
			M.setStrData("Pass", "Automation Testcase", 638, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Liability After Cancelation");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 638, 6);
			M.setStrData("Fail", "Automation Testcase", 638, 7);

		}

		ReStart();
	}
	
	
	

	// Delete Canceled Order
	// @Test (priority = 60)
	public void DeleteCanceledOrder() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Delete Canceled Order Executed!");
		String str = "";
		int count = 0;
		int j = 240;
		int pass=0;
		int card=0;
		int card1=0;
		int card2=0;
		boolean tr;

		try {
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}

			// Count cost incurred and Liability 
			Thread.sleep(5000);
			M.ScrollDwon(1);
			try {
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				card=xyz.size();
			}catch (Exception e) {
				;
			}
			
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").click();
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Order Delete button not found";
				throw new Exception(str);
			}
			
			Thread.sleep(2000);
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 214, 2), M.getstring("Automation Test Data", 214, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Order Delete Button "+ confirmation;
			}
			
			
			
			// verify After warning message no	
			try {
				Thread.sleep(1000);
				String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After press Delete Warning Message No, Order Info Page doesn't found";
				throw new Exception(str);
			}
			
			try {
				M.ScrollByText("cancel type");
			}catch (Exception e) {
				;
			}
			
			try {
				for(int i=1;i<=7;i++)
				{
					String result=VerifyCancellationHeadData(i,228,i);
					
					if(result.isBlank()) {
						;
					}else {
						count++;
						str = str + "\n"+"After Press delete warning message No" +result;
					}
					
				}
			}catch (Exception e) {
				
				count++;
				str = str + "\n" + e;
				//throw new Exception(str);
			}

			// Count cost incurred and Liability 
			Thread.sleep(5000);
			M.ScrollDwon(1);
			try {
				List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				card1=xyz.size();
			}catch (Exception e) {
				;
			}
			if(card!=card1) {
				count++;
				str = str + "\n" +"After Press delete warning message No, Card are not Equal with before";
			}
			
			//Click delete and warning message Yes....
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			}catch(Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
		
			//Sucessfull Message..								
			Thread.sleep(2000);
			String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 214, 4), M.getstring("Automation Test Data", 214, 5));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				 
				try {
					M.ScrollByText("cancel type");
				}catch (Exception e) {
					;
				}
				
				try {
					for(int i=1;i<=7;i++)
					{
						String result=VerifyCancellationHeadData(i,222,i);
						
						if(result.isBlank()) {
							;
						}else {
							count++;
							str = str + "\n" +"After Delete Cancelation "+result;
						}
						
					}
				}catch (Exception e) {
					
					count++;
					str = str + "\n" + e;
					//throw new Exception(str);
				}

				// Count cost incurred and Liability 
				Thread.sleep(5000);
				M.ScrollDwon(1);
				try {
					List<AndroidElement> xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
					card=xyz.size();
				}catch (Exception e) {
					card=0;
				}
				if(card!=card2) {
					count++;
					str = str + "\n" +"After Press delete warning message Yes, Card still present";
				}
				
				try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
						count++;
						str = str + "\n" +"After Delete cancelation, Page doesn't Update & save change button found";
					} catch (Exception x) {
						;
					}
				 
				try {
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").getText();
					 count++;
					 str = str + "\n" +"After Delete cancelation, Page doesn't Update & Delete button found";
				 } catch (Exception x) {
					;
				 }
				 

			}catch(Exception e) {
				count++;
				str = str + "\n" +e;
			}
			
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			// check warnning message.
			try {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				count++;
				str = str + "\n" + "After Delete cancelation when press back button warning message found";
			} catch (Exception e) {
				;
			}
			
	
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Delete Canceled Order");
			M.setStrData("As Expected", "Automation Testcase", 639, 6);
			M.setStrData("Pass", "Automation Testcase", 639, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Delete Canceled Order");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 639, 6);
			M.setStrData("Fail", "Automation Testcase", 639, 7);

		}
		ReStart();
	}
	
	
	
	
	// Verify Delete Canceled Order
	// @Test (priority = 61)
	public void VerifyDeleteCanceledOrder()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Delete Canceled Order Executed!");
		int count=0;
		int card=0;
		int card1=0;
		String str="";
		String gettext="";
		try {
			Thread.sleep(5000);
			M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(2000);
			DataUp(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(1000);
			int i=1;
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llMainLayout");
			int PONumber= driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber").size();
			if(xyz.size()==PONumber) {
				;
			}
			else {
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				}catch(Exception e) {
					i++;
				}
			}
			for (; i <= xyz.size(); i++) {				
				try {
					
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					//System.out.println(gettext);
					if (gettext.contains(M.getstring("Automation Test Data", 179, 1))) {

						gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						
						if(gettext.contentEquals(M.getstring("Automation Test Data", 234, 1))) {
							count++;
							str = str + "\n" + "Cancel Status found in orders list page after Delete Cancelation.";	
						}
						
						break;
					}
				}catch(Exception e) {
					;
				}
			}
			
			Thread.sleep(2000);
			M.ClickOn(M.getstring("Automation Test Data", 179, 1));
			

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtIsCanceled").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 1), "Cancel Status Doesn't Match in order details");
				count++;
				str = str + "\n" + "Cancel Status found in orders Details page after Delete Cancelation.";
			}catch(Exception e) {
				;
			}
			
			
			//Go to cancelation page
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
			
			
			//Verrify CancelationHeadData
			for(int j=1;j<=7;j++)
			{
				String result=VerifyCancellationHeadData(j,222,j);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + "After Delete Cancelation"+result;
				}
				
			}
			
			// Count cost incurred and Liability
			Thread.sleep(5000);
			M.ScrollDwon(1);
						
			try {
				xyz =driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
				card=xyz.size();
			}catch (Exception e) {
				card=0;
			}
			if(card!=card1) {
				count++;
				str = str + "\n" +"After Delete Cancelation, Card still present";
			}

			try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
					count++;
					str = str + "\n" +"After Delete cancelation, save change button found";
				} catch (Exception x) {
					;
				}
			 
			try {
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").getText();
				 count++;
				 str = str + "\n" +"After Delete cancelation, Delete button found";
			 } catch (Exception x) {
				;
			 }

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
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
			M.ScreenShots("Screenshot/Passed","Verify Delete Order Cancellation"); 
		    M.setStrData("As Expected","Automation Testcase", 640, 6);
			M.setStrData("Pass","Automation Testcase", 640, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Delete Order Cancellation");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 640, 6);
			M.setStrData("Fail","Automation Testcase", 640, 7);
			
			
		}
		
		
		ReStart();
	}
		
	
	

	// Order Cancellation with-out cost incured and Liability
	// @Test (priority = 62)
	public void OrderCancellationwithoutCostincuredAndLiability() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Order Cancellation with-out cost incured and Liability Executed!");
		String str = "";
		int count = 0;
		int j = 240;
		int pass=0;
		boolean tr;

		try {
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 179, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			
			for(int i=0;i<=7;i++) {
				CancelationDataFillUP(i,228);
			}
			
			
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelOrder").click();
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Order cancel button not found";
				throw new Exception(str);
			}
			
			Thread.sleep(2000);
			//check title & warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 210, 2), M.getstring("Automation Test Data", 210, 3));
			if(confirmation.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" +"After Press Order Cancelation Button "+ confirmation;
			}
			
			
			try {
				M.ScrollByText("Cancel Type");
			}catch(Exception e) {
				;
			}
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				for(int i=1;i<=7;i++)
				{
					String result=VerifyCancellationHeadData(i,228,i);
					
					if(result.isBlank()) {
						;
					}else {
						count++;
						str = str + "\n" + "After click Order cancel warnning mess NO"+result;
						CancelationDataFillUP(i,228);
					}
					
				}
			}catch (Exception e) {
				
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			

			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelOrder").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			}catch(Exception e) {
				;
			}
			
			
			//Sucessfull Message..								
			Thread.sleep(2000);
			String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 210, 4), M.getstring("Automation Test Data", 210, 5));
			
			if(successful.isBlank())
			{
				;
			}else
			{
				count++;
				str = str + "\n" + successful;
			}
			
			try {
				String gettext=driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				 
				 try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
					} catch (Exception x) {
						count++;
						str = str + "\n" +"After cancelation, Page doesn't Update & save change button not found";
					}
				 
				 try {
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").getText();
				 } catch (Exception x) {
					 count++;
					 str = str + "\n" +"After cancelation, Page doesn't Update & Delete button not found";
				 }
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +e;
			}
			
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				count++;
				str = str + "\n" +"After Cancelation when press back show warning message.";
				
			} catch (Exception x) {
				;
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Order Cancellation with-out cost incured and Liability");
			M.setStrData("As Expected", "Automation Testcase", 641, 6);
			M.setStrData("Pass", "Automation Testcase", 641, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Order Cancellation with-out cost incured and Liability");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 641, 6);
			M.setStrData("Fail", "Automation Testcase", 641, 7);

		}
		ReStart();
	}
	
	
	
	
	// Verify Order Cancellation and Data
	// @Test (priority = 63)
	public void VerifyOrderCancellationwithoutcard()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Order Cancellation without card Executed!");
		int pass=0;
		int count=0;
		String str="";
		String gettext="";
		try {
			Thread.sleep(5000);
			M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(1000);
			DataUp(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(1000);
			int i=1;
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llMainLayout");
			int PONumber= driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber").size();
			if(xyz.size()==PONumber) {
				;
			}
			else {
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				}catch(Exception e) {
					i++;
				}
			}
			for (; i <= xyz.size(); i++) {				
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					//System.out.println(gettext);
					if (gettext.contains(M.getstring("Automation Test Data", 179, 1))) {

						gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 1), "Cancel Status Doesn't Match");
						pass++;
						break;
					}
				}catch(Exception e) {
					;
				}
			}
			if(pass==0) {
				count++;
				str = str + "\n" + "Cancel Status doesn't found in order list page.";
			}
			
			Thread.sleep(2000);
			M.ClickOn(M.getstring("Automation Test Data", 179, 1));
			

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtIsCanceled").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 1), "Cancel Status Doesn't Match in order details");
			}catch(Exception e) {
				count++;
				str = str + "\n" + "Cancel Status doesn't found in order details page.";
			}
			
			
			//Go to cancelation page
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
			
			
			//Verrify CancelationHeadData
			for(int j=1;j<=7;j++)
			{
				String result=VerifyCancellationHeadData(j,228,j);
				
				if(result.isBlank()) {
					;
				}else {
					count++;
					str = str + "\n" + result;
				}
				
			}
			
			//check save change Button Visible or not.
			
			try {
				 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").getText();
				 SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 2), "Save Changes button text Doesn't Match");
				
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Save Changes button not found";
			}
			
			try {
				 gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnDelete").getText();
				 SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 3), "Delete button text Doesn't Match");
			}catch(Exception e) {
				count++;
				str = str + "\n" +"Delete button not found";
			}

			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			} catch (Exception x) {
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
			M.ScreenShots("Screenshot/Passed","Verify Order Cancellation and Data"); 
		    M.setStrData("As Expected","Automation Testcase", 642, 6);
			M.setStrData("Pass","Automation Testcase", 642, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Order Cancellation and Data");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 642, 6);
			M.setStrData("Fail","Automation Testcase", 642, 7);
			
			
		}
		
		
		ReStart();
	}
		
		
	
	
	//Verify Deleting Cancelled Order 
	// @Test (priority = 64)
	public void VerifyDeletingCancelledOrder()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Deleting Cancelled Order Executed!");
		int count=0;
		int counter=0;
		String counterstr="";
		String str="";
		String gettext="";
		try {
			Thread.sleep(5000);
			M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(2000);
			DataUp(M.getstring("Automation Test Data", 179, 1));
			Thread.sleep(1000);
			int i=1;
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/llMainLayout");
			int PONumber= driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtPONumber").size();
			if(xyz.size()==PONumber) {
				;
			}
			else {
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
				}catch(Exception e) {
					i++;
				}
			}
			for (; i <= xyz.size(); i++) {				
				try {
					
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					//System.out.println(gettext);
					if (gettext.contains(M.getstring("Automation Test Data", 179, 1))) {
						
						gettext=driver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView").getText();
						
						if(gettext.contentEquals(M.getstring("Automation Test Data", 234, 1))) {
							counter++;
							//counterstr=counterstr + "\n" +"Po Status found in order list page.";
							//System.out.println(counterstr);
							
						}
						
						break;
					}
				}catch(Exception e) {
					;
				}
			}
			
			//Check Orderinfo page status
			Thread.sleep(2000);
			M.ClickOn(M.getstring("Automation Test Data", 179, 1));
			
			
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtIsCanceled").getText();
				SA.assertEquals(gettext, M.getstring("Automation Test Data", 234, 1), "Cancel Status Doesn't Match in order details");
				counter++;
				counterstr=counterstr + "\n" +"Po Status found in order details page.";
				//System.out.println(counterstr);
			}catch(Exception e) {
				;
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			
			if(counter!=0) {
				Thread.sleep(2000);
				M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
				Thread.sleep(2000);
				int j=counting(M.getstring("Automation Test Data", 179, 1));
				Thread.sleep(2000);
				M.SwipBytext(M.getstring("Automation Test Data", 179, 1));
				
				try {
					gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
					if(gettext.contentEquals(M.getstring("Automation Test Data", 179, 1))) {
						;
					}else {
						j++;
					}
				}catch(Exception e) {
					j++;
				}
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();;
				
				//Sucessful Warning_Message
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 216, 6), M.getstring("Automation Test Data", 216, 7));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				Thread.sleep(2000);
				try {
					String text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					try {
						//Check order
						M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Canceled order not found but it should not delete";
					}
					
				}catch(Exception e) {
					Thread.sleep(2000);
					try {						
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						String text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					}catch(Exception m) {
						count++;
						str = str + "\n" + "Apps crush check manually";
					}
					Thread.sleep(2000);
					try {
						//Check order
						M.ScrollByText(M.getstring("Automation Test Data", 179, 1));
					}catch(Exception m) {
						count++;
						str = str + "\n" + "Canceled order not found but it should not delete";
					}
				}
				
			}else
			{
				count++;
				str = str + "\n" + "Canceled order not found pls first cancel a order";
				throw new Exception(str);
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Verify Deleting Cancelled Order"); 
			M.setStrData("As Expected","Automation Testcase", 643, 6);
			M.setStrData("Pass","Automation Testcase", 643, 7);
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Deleting Cancelled Order");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 643, 6);
			M.setStrData("Fail","Automation Testcase", 643, 7);
			
		}
		
		
		ReStart();
	}


	
	
	// Verify Deleting Changed Task Assignee in Order (Reassign)
	// @Test (priority = 65)
	public void VerifyDeletingReassignTaskOrder()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Deleting Reassign Task Order Executed!");
		int count=0;
		int counter=0;
		String counterstr="";
		String str="";
		String gettext="";
		int j=0;
		try {
			Thread.sleep(5000);
			CreateOrder();
			
			try {
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);				
			    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			    
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			    
				driver.findElementByXPath("//android.widget.TextView[@text='My Tasks']").click(); 
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				String UpdateTask = M.getstring("Automation Test Data", 187, 8);
				Thread.sleep(2000);
				M.ScrollByText(UpdateTask);
				Thread.sleep(2000);
				
				
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
					
					try {
						gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").getText();
						if(gettext.contentEquals(M.getstring("Automation Test Data", 187, 8))) {
							;
						}else {
							j++;
						}
							
					}catch(Exception e) {
						j++;
					}
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
	
				//New Assignee
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_newAssigneeDropDown").click();
				Thread.sleep(2000);
				M.ClickOn(M.getstring("Automation Test Data", 99, 10));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
				//Remarks
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/et_remarks").sendKeys(M.getstring("Automation Test Data", 99, 11));
				driver.hideKeyboard();
				
				//click save button
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
				
				Thread.sleep(1000);
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
	
				} catch (Exception x) {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Reassign Task']").getText();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

				}
				
				Thread.sleep(1000);
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='My Task']").getText();
					
					try {
						M.ScrollByText(UpdateTask);
					} catch (Exception x) {
						counter++;
					}
					Thread.sleep(2000);
				    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				    
				    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
				    
					driver.findElementByXPath("//android.widget.TextView[@text='My Orders']").click(); 
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Something is wrong when Reassign the task from my task";
					throw new Exception(str);
					
				}
				

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Reassign Button not work";
				throw new Exception(str);
			}

			
			//try to Delete Reassign task order			
			if(counter!=0) {
				Thread.sleep(5000);
				M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
				Thread.sleep(2000);
				j=counting(M.getstring("Automation Test Data", 175, 1));
				System.out.println(j);
				
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contentEquals(M.getstring("Automation Test Data", 175, 1))) {
						;
					}else {
						j++;
					}
					
				}catch(Exception e) {
					j++;
				}
				
				System.out.println(j);
				
				Thread.sleep(2000);
				M.SwipBytext(M.getstring("Automation Test Data", 175, 1));
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();;
				
				//Sucessful Warning_Message
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 216, 6), M.getstring("Automation Test Data", 216, 8));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				Thread.sleep(2000);
				
				//check order is delete or not..
				try {
					String text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					try {
						//Check order
						M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Reassign order not found but it should not be delete";
						throw new Exception(str);
					}
					
				}catch(Exception e) {
					Thread.sleep(2000);
					
					try {						
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						String text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					}catch(Exception m) {
						count++;
						str = str + "\n" + "Apps crush check manually";
					}
					Thread.sleep(2000);
					try {
						//Check order
						M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
						Thread.sleep(2000);
						j=counting(M.getstring("Automation Test Data", 175, 1));
						
						M.SwipBytext(M.getstring("Automation Test Data", 175, 1));
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);						
						try {
							gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
							if(gettext.contentEquals(M.getstring("Automation Test Data", 175, 1))) {
								;
							}else {
								j++;
							}
						}catch(Exception m) {
							j++;
						}
						
						driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Thread.sleep(2000);
						
						PoNumber(M.getstring("Automation Test Data", 179, 1));
						
						Thread.sleep(5000);
						M.ScrollDwon(2);
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
							
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							// Back Button!!
							try {
								String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
								Thread.sleep(5000);
								M.BackFun(1);
								
							} catch (Exception m) {
								;
							}
						} catch (Exception m) {
							count++;
							str = str + "\n Save Change Button Doesn't Work";
							throw new Exception(str);
						}
					}catch(Exception m) {
						count++;
						str = str + "\n" + "Task Complete order not found but it should not be delete";
						throw new Exception(str);
					}
				}
				
			}else
			{
				count++;
				str = str + "\n" + "Pls first Reassign a order task";
				throw new Exception(str);
			}

			if(count>0)
			{
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Verify Deleting Reassign Task Order"); 
			M.setStrData("As Expected","Automation Testcase", 644, 6);
			M.setStrData("Pass","Automation Testcase", 644, 7);
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Deleting Reassign Task Order");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 644, 6);
			M.setStrData("Fail","Automation Testcase", 644, 7);
			
		}
		
		
		
	}
	

	//Verify Deleting Changed Task Status in Order (Actual Completion Date)
	// @Test (priority = 66)
	public void VerifyDeletingTaskCompleteOrder()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Deleting Task Complete Order Executed!");
		int count=0;
		int counter=0;
		String counterstr="";
		String str="";
		String gettext="";
		try {
			Thread.sleep(5000);
			CreateOrder();
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 175, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + e;
				throw new Exception(str);
			}
			
			try {
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 187, 8));

				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Selected Task not found in task tab";
				throw new Exception(str);
			}
			//task complete
			try {
				Thread.sleep(5000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_complete_task").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

			} catch (Exception e) {
				count++;
				str = str + "\n"  + "Task Complete Button doesn't work properly";
				throw new Exception(str);
			}
			
			//Check Task Status
			try {
				Thread.sleep(1000);
				gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 175, 1));

				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				
				Thread.sleep(2000);
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus").getText();
				if(gettext.contains("Completed")) {
					counter++;
				}else {
					count++;
					str = str + "\n"  + "No Complete Task Found";
					throw new Exception(str);
				}
				
				
			} catch (Exception e) {
				Thread.sleep(1000);
				gettext =  driver.findElementByXPath("//android.widget.TextView[@text='Task Detail']").getText();
				
				// Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception m) {
					Thread.sleep(5000);
					M.BackFun(1);
				}
				
				Thread.sleep(2000);
				gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txtTaskStatus").getText();
				if(gettext.contains("Completed")) {
					counter++;
				}else {
					count++;
					str = str + "\n"  + "No Complete Task Found";
					throw new Exception(str);
				}
			}
			
			// Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			//try to Delete Complete task order
			
			if(counter!=0) {
				Thread.sleep(2000);
				M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
				Thread.sleep(2000);
				int j=counting(M.getstring("Automation Test Data", 175, 1));
				System.out.println(j);
				
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contentEquals(M.getstring("Automation Test Data", 175, 1))) {
						;
					}else {
						j++;
					}
						
				}catch(Exception e) {
					j++;
				}
				
				System.out.println(j);
				
				Thread.sleep(2000);
				M.SwipBytext(M.getstring("Automation Test Data", 175, 1));
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();;
				
				//Sucessful Warning_Message
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 216, 6), M.getstring("Automation Test Data", 216, 8));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				Thread.sleep(2000);
				try {
					String text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					try {
						//Check order
						M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
					}catch(Exception e) {
						count++;
						str = str + "\n" + "Task Complete order not found but it should not be delete";
						throw new Exception(str);
					}
					
				}catch(Exception e) {
					Thread.sleep(2000);
					
					try {						
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						String text=driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					}catch(Exception m) {
						count++;
						str = str + "\n" + "Apps crush check manually";
					}
					Thread.sleep(2000);
					try {
						//Check order
						M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
						Thread.sleep(2000);
						j=counting(M.getstring("Automation Test Data", 175, 1));
						
						M.SwipBytext(M.getstring("Automation Test Data", 175, 1));
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);						
						try {
							gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
							if(gettext.contentEquals(M.getstring("Automation Test Data", 175, 1))) {
								;
							}else {
								j++;
							}
						}catch(Exception m) {
							j++;
						}
						
						driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Thread.sleep(2000);
						
						PoNumber(M.getstring("Automation Test Data", 179, 1));
					
						Thread.sleep(5000);
						M.ScrollDwon(2);
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
							
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							// Back Button!!
							try {
								String page=driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
								Thread.sleep(5000);
								M.BackFun(1);

							} catch (Exception m) {
								;
							}
						} catch (Exception m) {
							count++;
							str = str + "\n Save Change Button Doesn't Work";
							throw new Exception(str);
						}
					}catch(Exception m) {
						count++;
						str = str + "\n" + "Task Complete order not found but it should not be delete";
						throw new Exception(str);
					}
				}
				
			}else
			{
				count++;
				str = str + "\n" + "Task Complete order not found pls first Complete a order task";
				throw new Exception(str);
			}
			
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Verify Deleting Task Complete Order"); 
			M.setStrData("As Expected","Automation Testcase", 645, 6);
			M.setStrData("Pass","Automation Testcase", 645, 7);
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Deleting Task Complete Order");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 645, 6);
			M.setStrData("Fail","Automation Testcase", 645, 7);
			
		}
		
		
		ReStart();
	}
	
	
	
	
	//Delete Order & Verify Deleted Order (Without Cost Incurred & Liabilities)
	// @Test (priority = 67)
	public void DeleteOrderVerifyDeletedOrder()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Delete Order & Verify Deleted Order Without Cost Incurred & Liabilities Executed!");
		int count=0;
		int counter=0;
		String counterstr="";
		String str="";
		String gettext="";
		try {
			Thread.sleep(5000);
			CreateOrder();
			
			try{
				Thread.sleep(2000);
				M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
				counter++;
			}catch(Exception e) {
				throw new Exception("Order not found");
			}
			
			//Delete order
			
			if(counter!=0) {
				Thread.sleep(2000);
				M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
				Thread.sleep(2000);
				int j=counting(M.getstring("Automation Test Data", 175, 1));
				//System.out.println(j);
				
				try {
					gettext=driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contentEquals(M.getstring("Automation Test Data", 175, 1))) {
						;
					}else {
						j++;
					}
					
				}catch(Exception e) {
					j++;
				}
				
				//System.out.println(j);
				
				Thread.sleep(2000);
				M.SwipBytext(M.getstring("Automation Test Data", 175, 1));
				
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();;
				
				//Confirmation Warning_Message
				Thread.sleep(2000);
				String Confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 216, 2), M.getstring("Automation Test Data", 216, 3));
				
				if(Confirmation.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + Confirmation;
				}
				
				Thread.sleep(2000);
				try {
					String text = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					try {
						// Check order
						M.ScrollByText(M.getstring("Automation Test Data", 175, 1));

						Thread.sleep(2000);
						M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
						Thread.sleep(2000);
						j = counting(M.getstring("Automation Test Data", 175, 1));
						// System.out.println(j);
					} catch (Exception e) {
						count++;
						str = str + "\n" + "Order Delete after confirmation message no";
						throw new Exception(str);
					}
					try {
						gettext = driver.findElementByXPath("//android.widget.LinearLayout[" + j + "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
						if (gettext.contentEquals(M.getstring("Automation Test Data", 175, 1))) {
							;
						} else {
							j++;
						}

					} catch (Exception e) {
						j++;
					}

					// Click delete button and warning message yes
					Thread.sleep(2000);
					driver.findElementByXPath("//android.widget.LinearLayout[" + j + "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]").click();;
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					// Sucessful_Message
					Thread.sleep(2000);
					String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 216, 4),M.getstring("Automation Test Data", 216, 5));
					if (successful.isBlank()) {
						;
					} else {
						count++;
						str = str + "\n" + successful;
					}
					
					try {
						//Verify order Delete
						Thread.sleep(2000);
						M.ScrollByText(M.getstring("Automation Test Data", 175, 1));
						count++;
						str = str + "\n" + "After Delete order but still order present";

					} catch (Exception e) {						
						;
					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + "After click warning message No Order page not found";
					throw new Exception(str);

				}

			} else {
				count++;
				str = str + "\n" + "No Order create";
				throw new Exception(str);
			}

			if(count>0)
			{
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Verify Deleting Task Complete Order"); 
			M.setStrData("As Expected","Automation Testcase", 646, 6);
			M.setStrData("Pass","Automation Testcase", 646, 7);
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Deleting Task Complete Order");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 646, 6);
			M.setStrData("Fail","Automation Testcase", 646, 7);
			
		}
		
		
		ReStart();
	}
	
	
	
	// Verify Order task (using same TnA template in multiple Order)
	// @Test (priority = 68)
	public void VerifyOrdertask()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Order task using same TnA template in multiple Order Executed!");
		int count=0;
		int counter=0;
		String counterstr="";
		String str="";
		String gettext="";
		try {
			for(int i=1;i<=3;i++) {
				Thread.sleep(5000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				Thread.sleep(5000);
				DataFillUp(179,1);
				
				Thread.sleep(5000);
				M.Scroll(1);
				PoNumber(M.getstring("Automation Test Data", 244, i));
				
				Thread.sleep(2000);
				M.ScrollByText("Create");
				
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
					Thread.sleep(3000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception e) {
						;
					}
				} catch (Exception e) {
					count++;
					str = str + "\n Create Button Doesn't Work";
					throw new Exception(str);
				}
				
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
				} catch (Exception e) {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='New Export PO']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception x) {
						;
					}
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Orders']").getText();
					} catch (Exception x) {
						str = str + "\n After create Order and press back Button Order page not found.";
						throw new Exception(str);
					}
					
				}
				
				try{
					Thread.sleep(2000);
					M.ScrollByText(M.getstring("Automation Test Data", 244, i));
					counter++;
				}catch(Exception e) {
					throw new Exception("Create Order not found");
				}
				
			}
			
			for(int i=1;i<=3;i++) {
				
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 244, i));
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(2000);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				
				if(xyz.size()!=2) {
					count++;
					str = str + "\n"+ M.getstring("Automation Test Data", 244, i)+ " Task Does not Match with TnA Template task";
					
				}
				
				// back to order page
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);
				}
				
			}
			
			
			for(int i=1;i<=3;i++) {
				
				try {
					Thread.sleep(5000);
					M.ScrollByText(M.getstring("Automation Test Data", 244, i));
					DataUp(M.getstring("Automation Test Data", 244, i));
					Thread.sleep(5000);
					M.SwipBytext(M.getstring("Automation Test Data", 244, i));
					Thread.sleep(5000);
					int j = counting(M.getstring("Automation Test Data", 244, i));
					try {
						gettext = driver.findElementByXPath("//android.widget.LinearLayout["+j+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView").getText();						
						if(gettext.contentEquals(M.getstring("Automation Test Data", 244, i))) {
							;
						}else {
							j++;
						}
					}catch(Exception e) {
						j++;
					}
					
					driver.findElementByXPath("//android.widget.LinearLayout[" + j+ "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
					Thread.sleep(5000);
					M.ScrollDwon(1);

					TnaTemplate(M.getstring("Automation Test Data", 175, 14), 1);

					gettext = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtTnaTemplate").getText();
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 175, 14),"TnA Template doesn't change.");

					
					Thread.sleep(2000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
						Thread.sleep(3000);
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();

					} catch (Exception e) {
						count++;
						str = str + "\n Save Change Button Doesn't Work";
						throw new Exception(str);
					}

					// back to order page
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Edit Export PO']").getText();
						Thread.sleep(5000);
						M.BackFun(1);
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception x) {
							;
						}
					} catch (Exception e) {
						;

					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + "TNA Template doesn't change";
				}
				
			}
			
			
			for(int i=1;i<=3;i++) {
				
				Thread.sleep(5000);
				M.ClickOn(M.getstring("Automation Test Data", 244, i));
				Thread.sleep(2000);
				driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Task\"]").click();
				Thread.sleep(2000);
				List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtTaskDescription");
				
				if(xyz.size()!=1) {
					count++;
					str = str + "\n"+"After change TnA Template "+ M.getstring("Automation Test Data", 244, i)+ " Task Does not Match with TnA Template task";
					
				}
				
				// back to order page
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

				} catch (Exception e) {

					Thread.sleep(5000);
					M.BackFun(1);
				}
				
			}
			
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Verify Order task using same TnA template in multiple Order"); 
		    M.setStrData("As Expected","Automation Testcase", 647, 6);
			M.setStrData("Pass","Automation Testcase", 647, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify Order task using same TnA template in multiple Order");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 647, 6);
			M.setStrData("Fail","Automation Testcase", 647, 7);
			
		}
		
		
		ReStart();
	}
	


	// Add Multiple Cost incurred in Cancelation page.
	// @Test (priority = 69)
	public void AddMultipleCostincurred()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Add Multiple Cost incurred in Cancelation page Executed!");
		int count=0;
		String str="";
		try {
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data", 244, 1));

			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
			for(int i=1;i<=5;i++) {
				
				// Go to cancellation page
				try {
					
					Thread.sleep(5000);
					M.ScrollDwon(1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddCostIncurred").click();
					Thread.sleep(2000);

				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				// add Cost incurred
				try {
					for (int j = 1; j <= 4; j++) {
						CostDataFillUp(j, 230);
					}
				} catch (Exception m) {
					count++;
					str = str + "\n" + m;
					throw new Exception(str);
				}

				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
					Thread.sleep(1000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception x) {
						;
					}

				} catch (Exception m) {
					count++;
					str = str + "\n" + "Cost incurred Cancel Button not found";
					throw new Exception(str);
				}
				try {
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();

				} catch (Exception e) {
					try {
						String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Cost Incurred']").getText();

						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception x) {
							;
						}
					} catch (Exception x) {
						count++;
						str = str + "\n" + "Apps may be crush when create cost incurred";
						throw new Exception(str);
					}

				}

				
			}
			
			Thread.sleep(5000);
			M.ScrollDwon(1);
			int pass=0;
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 230, 1))) {
					pass++;
					
				}
			}
			
			if(pass!=5) {
				count++;
				str = str + "\n" + "Cost incurred are not equal After added";
				
			}
			// back to order page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();

			} catch (Exception e) {

				Thread.sleep(5000);
				M.BackFun(1);
			}
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			} catch (Exception x) {
				;
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Add Multiple Cost incurred in Cancelation page"); 
		    M.setStrData("As Expected","Automation Testcase", 648, 6);
			M.setStrData("Pass","Automation Testcase", 648, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Add Multiple Cost incurred in Cancelation page");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 648, 6);
			M.setStrData("Fail","Automation Testcase", 648, 7);
			
			
		}
		
		
		ReStart();
	}


	
	// Add Multiple Liabilities in Cancelation page.
	// @Test (priority = 70)
	public void AddMultipleLiabilities()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Add Multiple Liabilities in Cancelation page Executed!");
		int count=0;
		String str="";
		try {
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data", 244, 1));
			
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Cancellation\"]").click();
			for(int i=1;i<=5;i++) {
				
				try {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llAddLiabilities").click();
					Thread.sleep(2000);

				} catch (Exception e) {
					count++;
					str = str + "\n" + e;
					throw new Exception(str);
				}
				
				// add Liabilities
				try {
					for (int j = 1; j <= 5; j++) {
						LiabilityDataFillUp(j, 232);
					}
				} catch (Exception m) {
					count++;
					str = str + "\n" + m;
					throw new Exception(str);
				}

				try {
					Thread.sleep(1000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnAddButton").click();
					Thread.sleep(1000);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					} catch (Exception x) {
						;
					}
					
				} catch (Exception m) {

					count++;
					str = str + "\n" + "Liability Cancel Button not found";
					throw new Exception(str);
				}
				
				try {
					Thread.sleep(1000);
					String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Order Information']").getText();
					
				} catch (Exception e) {
					try {
						String gettext = driver.findElementByXPath("//android.widget.TextView[@text='Add Liability']").getText();
						
						Thread.sleep(1000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCancelButton").click();
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						} catch (Exception x) {
							;
						}
					} catch (Exception x) {
						count++;
						str = str + "\n" + "Apps may be crush when create Liability";
						throw new Exception(str);
					}
					
				}
				
				
			}
			
			Thread.sleep(5000);
			M.ScrollDwon(1);
			int pass=0;
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCostHead");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 232, 1))) {
					pass++;
					//System.out.println("ok");
				}
			}
			
			if(pass!=5) {
				count++;
				str = str + "\n" + "Liability are not equal After added";
				
			}
			// back to order page
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			} catch (Exception e) {
				
				Thread.sleep(5000);
				M.BackFun(1);
			}
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			} catch (Exception x) {
				;
			}
			
			if(count>0)
			{
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed","Add Multiple Cost incurred in Cancelation page"); 
			M.setStrData("As Expected","Automation Testcase", 649, 6);
			M.setStrData("Pass","Automation Testcase", 649, 7);
			
			
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Add Multiple Cost incurred in Cancelation page");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 649, 6);
			M.setStrData("Fail","Automation Testcase", 649, 7);
			
			
		}
		
		
		ReStart();
	}
	

	
}
