package com.cslsoft.KandareeLiteTestCase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.Dimension;
import io.appium.java_client.MobileBy;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;



public class Customer extends BaseClass  {
	
	
	@Test(priority = 0)
	public void Nevigate() throws InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		M.LoginMethods();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
		 
		 driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 
		 
		 System.out.println("Navigate Hamburgare to Customers Profile!");

	}
	
	public void ReStart() throws InterruptedException, IOException {
		try {
			String text=driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();

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
		    
			driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
	}
	
	
	
	public String PageVerification(String text) throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		String str="";
		try {
			Thread.sleep(100);
			String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
			// Assert.assertEquals(user,"Customers");

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
	public void UpCustomer(String data) throws InterruptedException {
		int j;
		CallingMethods M = new CallingMethods(driver);
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
		for (j = 0; j < xyz.size(); j++) {
			if (xyz.get(j).getText().contains(data)) {
				j++;
				if (j >= 5) {
					Thread.sleep(5000);
					M.ScrollDwon(1);
					Thread.sleep(5000);
				}
				

			}
		}
		
	}
	
	
	public int counting(String data) throws InterruptedException, IOException{
		int i=0;
		int j=0;
		CallingMethods M = new CallingMethods(driver); 
		List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
		int item = xyz.size();
		int editId = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_mainLayout").size();
		
		/*
		 * if( item < editId) { M.ScrollDwonMinor(1); xyz = driver.findElementsById(
		 * "bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName"); item = xyz.size();
		 * editId =
		 * driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/ll_mainLayout").
		 * size(); }
		 * driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txt_delete").size();
		 */
		
		System.out.println("item=="+item);
		System.out.println("editId=="+editId);
		
		
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
					try {
						driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").isDisplayed();
					}catch (Exception e) {
						j--;
					}
				
				}

			}
		}
		System.out.println("j=="+j);
		return j;

		
	}
	
	
	
	// FullName
	public void FullName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	// ShortName
	public void ShortName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	
	// Country
	public void Country(String text, int x) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(2000);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCountryArrow").click();
		M.ClickOn(text);
		//driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		if (x == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (x == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	
	// Email
	public void Email(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	
	// MobileNumber
	public void MobileNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	
	// Address
	public void Address(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	//DataFillUp
	public void DataFillUp(int i) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(5000);
		FullName(M.getstring("Automation Test Data", i, 1));

		ShortName(M.getstring("Automation Test Data", i, 2));

		Country(M.getstring("Automation Test Data", i, 3), 1);
		
		Email(M.getstring("Automation Test Data", i, 4));

		MobileNumber(M.getstring("Automation Test Data", i, 5));
		
		Address(M.getstring("Automation Test Data", i, 6));

		
	}
	
	
	//Verify Place holder
	public void Verifydata(int R) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String gettext="";
		Thread.sleep(2000);
		
		//Customer Name
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 1), "Customer Name Doesn't Match");
		
		
		//Short Name
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 2), "Short Name Doesn't Match");
		
		
		//Country
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCountry").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 3), "Country Doesn't Match");
		
		
		//Customer Email
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 4), "Customer Email Doesn't Match");
		
		
		//Customer Phone
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 5), "Customer Phone Doesn't Match");
		
		
		//Address
		gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").getText();
		SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 6), "Address Doesn't Match");
	
		SA.assertAll();
	}
	
	
	// Verify Place holder Text
	//@Test(priority = 1)
	public void VerifyPlaceholderText() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Place holder Text Executed!");
		int R = 128;
		try {
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			Verifydata(R);

			Thread.sleep(5000);
			M.BackFun(1);

			M.ScreenShots("Screenshot/Passed", "VerifyPlaceholderText");
			M.setStrData("As Expected", "Automation Testcase", 556, 6);
			M.setStrData("Pass", "Automation Testcase", 556, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "VerifyPlaceholderText");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 556, 6);
			M.setStrData("Fail", "Automation Testcase", 556, 7);
		}
		ReStart();
	}
	
	
	//Verify Disabled Submit Button (With Blank Field )
	//@Test(priority = 2)
	public void VerifyCreateButtonDisableWhenFieldBlank() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Submit Button Disable When Field Blank Executed!");
		try {
			String str = "";
			int count = 0;
			int back = 0;
			int k = 130;
			boolean tr;
			String testdata;
			Thread.sleep(1000);
			String text = "Submit";
			for (int i = 0; i <= 7; i++) {
				
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				// Full Field Blank
				if (i == 0) {
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSubmit").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Submit Button is Enable";

					}
					

				}

				// FullName Blank
				if (i != 1) {
					if (i!=0)
						FullName(M.getstring("Automation Test Data", k, 1));
				}

				// ShortNameBlank
				if (i != 2) {
					if (i!=0)
						ShortName(M.getstring("Automation Test Data", k, 2));
					
				}
				// Country
				if (i != 3) {
					if (i!=0)
						Country(M.getstring("Automation Test Data", k, 3), 1);
				}
				// Email
				if (i != 4) {
					if (i!=0)
						Email(M.getstring("Automation Test Data", k, 4));
				}

				// Phone Number
				if (i != 5) {
					if (i!=0)
						MobileNumber(M.getstring("Automation Test Data", k, 5));
				}

				// Address
				if (i != 6) {
					if (i!=0)
						Address(M.getstring("Automation Test Data", k, 6));
				}


				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSubmit").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					
					if (i == 1) {
						count++;
						str = str + "\n" + "Full Name Field is Blank But Submit Button is Enable";
					}
						
					else if (i == 2) {
						count++;
						str = str + "\n" + "Short Name Field is Blank But Submit Button is Enable";
					}
						
					else
						;

				}else {
					
					if (i == 3) {
						count++;
						str = str + "\n" + "Country Field is not Mendetory But Submit Button is disable";
					}
						
					else if (i == 4) {
						count++;
						str = str + "\n" + "Email Field is not Mendetory But Submit Button is disable";
					}
						
					else if (i == 5) {
						count++;
						str = str + "\n" + "Phone Number Field is not Mendetory But Submit Button is disable";
					}
						
					else if (i == 6) {
						count++;
						str = str + "\n" + "Address Field is not Mendetory But Submit Button is disable";
					}
					else if (i == 7) {
						count++;
						str = str + "\n" + "Logo Field is not Mendetory But Submit Button is disable";
					}
						
					else
						;
										
				}
				if (i != 8) {
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
					if(i==7) {
						
						//String title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						//String mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
						
						//M.setStrData(title,"Automation Test Data", 159, 3);
						//M.setStrData(mess,"Automation Test Data", 159, 4);
						
						//warnning message
						Thread.sleep(2000);
						String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 159, 3), M.getstring("Automation Test Data", 159, 4));
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
							String page=driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
							try {
								
								Assert.assertEquals(page,"New Customer","Customer Detail page Title doesn't Match");
								
								Verifydata(130);
								
							}catch(AssertionError e)
							{
								count++;
								str = str + "\n" +e;
							}
							
						}catch (Exception e) {
							count++;
							
							try {
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
								str = str + "\n" + "After press back and click warring message no 'New Customer' page found No button doesn't work";
							}catch (Exception x) {
								str = str + "\n" + "Customer Detail page not found check manually what happend";
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
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
						} catch (Exception e) {
							count++;
							str = str + "\n" + "After press back and click warring message yes customer page not found";
							try {
								Thread.sleep(5000);
								String page=driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
								str = str + "\n" + "After press back and click warring message yes But found customer Detail page, yes button doesn't work";
							}catch (Exception d) {
								str = str + "\n" + "check manually what happend";
							}
							
							throw new Exception(str);
						}
						
						
					}
					
					if(i==0)
					{
						try {
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						} catch (Exception e) {
							count++;
							str = str + "\n" + "No Data input but show warning Message";
							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
								
							} catch (Exception x) {
								count++;
								str = str + "\n" + "Some thing is wrong check manually";
								throw new Exception(str);
							}
						}
						
						
					}else if(i!=7) {
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(5000);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
							//System.out.println("Print Ok");
						} catch (Exception e) {
							count++;
							str = str + "\n" + "After Click Back Button, Some thing is wrong check manually";
					}
					

					}
				}

			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 557, 6);
			M.setStrData("Pass", "Automation Testcase", 557, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 557, 6);
			M.setStrData("Fail", "Automation Testcase", 557, 7);

		}
		ReStart();

	}

	 
	// New Customer With Invalid Values
	//@Test(priority = 3)
	public void CreatebyInvalidUserName() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Create by Invalid User Name Executed!");
		try {
			String str = "";
			int count = 0;
			int j = 0;
			int pass = 0;
			String title = "";
			Thread.sleep(5000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();

			for (int i = 1; i <= 6; i++) {
				// invalid Name&ShortName
				if (pass == 0)
					DataFillUp(130);
				Thread.sleep(2000);
				FullName(M.getstring("Automation Test Data", 132, i));
				ShortName(M.getstring("Automation Test Data", 133, i));
				Email(M.getstring("Automation Test Data", 134, i));
				pass = 0;
				Thread.sleep(5000);
				M.ScrollDwon(1);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSubmit").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();

				if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
					count++;
					if (i == 1)
						str = str + "\n" + "Special Char Accept in FullName & ShortName";
					else if (i == 2)
						str = str + "\n" + "Numeric Char Accept in FullName & ShortName";
					else if (i == 3)
						str = str + "\n" + "Invalid Char ShortName Accept";
					else if (i == 4)
						str = str + "\n" + "Invalid Numeric ShortName Accept";
					else if (i == 5)
						str = str + "\n" + "Invalid Char FullName Accept";
					else
						str = str + "\n" + "Invalid Numeric FullName Accept";

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']")
								.getText();

						if (i != 6) {
							Thread.sleep(5000);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Thread.sleep(5000);
						}

					} catch (Exception e) {
						;
					}

				} else {

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(5000);

					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']")
								.getText();
						Thread.sleep(5000);
						M.Scroll(1);
						pass++;

					} catch (Exception e) {
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']")
									.getText();
							Thread.sleep(5000);
							M.Scroll(1);
							pass++;
							count++;
							str = str + "\n" + "After Warring Message, some unwantted message show";
							Thread.sleep(5000);
						} catch (Exception x) {
							try {

								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']")
										.getText();
								Thread.sleep(5000);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								count++;
								str = str + "\n" + "After click on ok Warring Message, Redirect to customers page ";
							} catch (Exception y) {

								count++;
								str = str + "\n" + "After click on ok Warring Message, apps may be crush ";
							}

						}
					}
				}

			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreatebyInvalidUserName");

			M.setStrData("As Expected", "Automation Testcase", 558, 6);
			M.setStrData("Pass", "Automation Testcase", 558, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "CreatebyInvalidUserName");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 558, 6);
			M.setStrData("Fail", "Automation Testcase", 558, 7);

		}
		ReStart();

	} 

	// Email Verification
	//@Test(priority = 4)
	public void EmailVerification() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();

		System.out.println("Email Verification Executed!");

		try {
			Thread.sleep(5000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			int count = 0;
			String str = "";
			String mass = "";
			String title = "";
			String data = "";
			DataFillUp(136);
			for (int i = 1; i <= 9; i++) {
				Thread.sleep(5000);
				M.Scroll(1);

				data = M.getstring("Automation Test Data", 135, i);

				// Email
				Email(data);

				Thread.sleep(1000);
				M.ScrollDwon(1);

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSubmit").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				try {
					mass = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					// System.out.println(mass);
					M.setStrData(mass, "Automation Test Data", 155, 3);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Invalid Email Message Body Not Found";
				}

				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					// System.out.println(title);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Title Body Not Found";
				}

				if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
					count++;
					if(i!=9)
						str = str + "\n" + data + "- Invalid Email Accept";
					else
						str = str + "\n" + data + "- Existing Customer Email Accept";
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					try {
						String text=driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
					}catch (Exception e) {
						try {
							String text=driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
							Thread.sleep(5000);
							M.BackFun(1);
							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							}catch (Exception m) {
								;
							}
							
						}catch (Exception m) {
							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							}catch (Exception x) {
								;
							}
						}
						
					}
					
					if (i != 9) {
						Thread.sleep(5000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
						DataFillUp(130);
					}

				} else {
					try {
						if (i != 9)
							Assert.assertEquals(mass, M.getstring("Automation Test Data", 155, 3),"- Email Verification Message doesn't valid");
						else
							Assert.assertEquals(mass, M.getstring("Automation Test Data", 155, 4),"- Existing Email Verification Message doesn't valid");

					} catch (AssertionError e) {
						count++;
						str = str + "\n" + data + e;
					}

					try {
						Assert.assertEquals(title, M.getstring("Automation Test Data", 155, 2),
								"- Email Verification Title doesn't valid");
					} catch (AssertionError e) {
						count++;
						str = str + "\n" + data + e;
					}
					Thread.sleep(100);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
						Thread.sleep(5000);
						M.Scroll(1);

					} catch (Exception e) {
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
							Thread.sleep(5000);
							M.Scroll(1);
							count++;
							str = str + "\n" + "After Warring Message, some unwantted message show";
							Thread.sleep(5000);
						} catch (Exception x) {
							try {

								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']")
										.getText();
								Thread.sleep(5000);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								DataFillUp(130);
								count++;
								str = str + "\n" + "After click on ok Warring Message, Redirect to customers page ";
							} catch (Exception y) {

								count++;
								str = str + "\n" + "After click on ok Warring Message, apps may be crush ";
							}

						}
					}

					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

			}
			String t=PageVerification("New Customer");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "User Email Verification");
			M.setStrData("As Expected", "Automation Testcase", 559, 6);
			M.setStrData("Pass", "Automation Testcase", 559, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "User Email Verification");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 559, 6);
			M.setStrData("Fail", "Automation Testcase", 559, 7);

		}
		ReStart();

	}
	
	
	//Mobile Number Verification
	//Mobile Number Verification
	//@Test(priority = 5)
	public void MobileNumberVerification() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Mobile Number Verification Executed!");

		try {
			Thread.sleep(5000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			int count = 0;
			String str = "";
			int k = 8;
			int pass = 0;
			String data = "";
			String mess = "";
			String title = "";
			DataFillUp(139);
			for (int i = 1; i <= 6; i++) {
				Thread.sleep(5000);
				M.Scroll(1);
				int j = i + 1;
				Email(M.getstring("Automation Test Data", 50, i));
				
				data = M.getstring("Automation Test Data", 49, i);
				
				// Phone Number
				MobileNumber(data);

				//System.out.println(data);

				Thread.sleep(1000);
				M.ScrollByText("Submit");

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSubmit").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				

				try {
					Thread.sleep(2000);
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					// System.out.println(title);
					 
					 try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 156, k),
									"- Number Field Verification Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + "\n" + data + e;
						}

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Title Body Not Found";
				}

				try {
					mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					// System.out.println(mess);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					

					try {
						Assert.assertEquals(mess, M.getstring("Automation Test Data", 156, j),
								"- Number Field Verification Message doesn't valid");

					} catch (AssertionError e) {
						count++;
						str = str + "\n" + data + e;
					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Message Body Not Found";
				}
				
				k++;
				if (mess.contentEquals(M.getstring("Automation Test Data", 156, j))) {
					if (i == 2 || i == 3) {
						pass++;

					} else {
						;
						// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
						// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					}
				} else {
					count++;
					if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
						str = str + "\n" + data + "- Accept invalid Number";
						pass++;
					} else {
						count++;
						str = str + "\n" + data + "- " + mess;

						

					}

				}
				if (i != 6) {
					try {
						Thread.sleep(100);
						String user = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
						Thread.sleep(2000);
						M.Scroll(1);
						if(pass>0)
							DataFillUp(139);
						pass=0;
					} catch (Exception e) {
						
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
							Thread.sleep(5000);
							M.Scroll(1);
							count++;
							str = str + "\n" + "After Warring Message, some unwantted message show";
							Thread.sleep(5000);
						} catch (Exception x) {
							try {

								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']")
										.getText();
								Thread.sleep(5000);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								DataFillUp(130);
								count++;
								str = str + "\n" + "After click on ok Warring Message, Redirect to customers page ";
							} catch (Exception y) {

								count++;
								str = str + "\n" + "After click on ok Warring Message, apps may be crush ";
							}

						}
						
					}
					
				}


			}

			String t=PageVerification("New Customer");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "User Email Verification");
			M.setStrData("As Expected", "Automation Testcase", 560, 6);
			M.setStrData("Pass", "Automation Testcase", 560, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "User Email Verification");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 560, 6);
			M.setStrData("Fail", "Automation Testcase", 560, 7);

		}

		ReStart();

	}
	
	
	//CreateCustome
	//Create Customer
	//@Test (priority = 6)
	public void CreateCustomer() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("CreateCustome Executed!");

		String successful = "";
		String mess = "";
		int count = 0;

		String button = "Submit";
		String str = "";

		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
		try {
			//Country Fields dismiss unsave data.
			Thread.sleep(5000);
			Country("canada", 2);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String country = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCountry").getText();
			if(country.contentEquals("canada")) {
				count++;
				str = str + "\n Country select After dismiss";
			}
			
			//Image Upload...
			
			try {
				 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/imgCustomerImage").click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 
				 driver.findElementById("android:id/text1").click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 
				 try {
					 driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
				 }catch (Exception e) {
					 ;
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 
				 driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc='Button'])[3]/android.widget.ImageView").click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 
				 Thread.sleep(2000);
				
			}catch (Exception e) {
				count++;
				str = str + "\n Photo doesn't Update";
				
			}
			
			Thread.sleep(2000);
			DataFillUp(130);

			Thread.sleep(2000);
			M.ScrollByText(button);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSubmit").click();
				Thread.sleep(3000);
				String title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n Submit Button Doesn't Work";
				throw new Exception(str);
			}
			

			
			//Sucessfull Message..								
			Thread.sleep(2000);
			successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 156, 9), M.getstring("Automation Test Data", 156, 3));
			
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After sucessful message Customers page not found";
				try {
					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(3000);
					try {
						user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
						
					} catch (Exception y) {
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							count++;
							str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
							Thread.sleep(3000);
							user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
							
						}catch (Exception z) {
							count++;
							str = str + "\n" + "After Sucessful Message, And when click Back check Manually";
							Thread.sleep(5000);
							
						}
						
					}
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "After click on ok sucessful Message, apps may be crush ";

				}
				
			}
			
			String t=PageVerification("New Customer");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", " Create Customer");
			M.setStrData("As Expected", "Automation Testcase", 561, 6);
			M.setStrData("Pass", "Automation Testcase", 561, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", " Create Customer");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 561, 6);
			M.setStrData("Fail", "Automation Testcase", 561, 7);

		}
		ReStart();
	}
	
	
	//VerifyCreateCustome_TaskData
	//Verify CreateCustome & Task Data
	//@Test (priority = 7)
	public void VerifyCreateCustome_TaskData() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Create Custome & Task Data Executed!");
		String CreateTask ="";
		String str ="";
		int count=0;

		try {
					
			CreateTask = M.getstring("Automation Test Data",130, 2);
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
				throw new Exception("Customer didn't create");
			
			try {
				Thread.sleep(5000);
				String page=driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
				try {
					
					Assert.assertEquals(page,"Customer Detail","Customer Detail page Title doesn't Match");
					
					Verifydata(130);
					
				}catch(AssertionError e)
				{
					count++;
					str = str + "\n" +e;
				}
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Customer Detail page not found check manually what happend";
				
			}
			
			Thread.sleep(5000);
			M.BackFun(1);
			
			if (count > 0) {
				throw new Exception(str);
			}
			
			M.ScreenShots("Screenshot/Passed","Verify CreateCustome & Task Data");			  
		    M.setStrData("As Expected","Automation Testcase", 562, 6);
			M.setStrData("Pass","Automation Testcase", 562, 7);


		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Verify CreateCustome & Task Data");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 562, 6);
			M.setStrData("Fail","Automation Testcase", 562, 7);
	
		}
		ReStart();
	}

	
	
	
	//VerifyCustomersListView
	//Verify Customers List View
	//@Test (priority = 8)
	public void VerifyCustomersListView() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Customers List View Executed!");
		int count = 0;
		String str = "";
		String data = M.getstring("Automation Test Data",130, 2);
		try {
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
			
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					if (j >=5) {
						Thread.sleep(5000);
						M.ScrollDwon(1);
					}

				}
			}
			
			xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					j=j+1;
					try {
						Boolean tr=driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView").isDisplayed();
						if(tr==true) {
							;
						}else {
							
							count++;
							str = str + "\n" + "Thumbnail icon is not Display";
						}
						
					} catch (Exception e) {
						count++;
						str = str + "\n" + "Thumbnail icon is not Found";
					}
					
					String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText();
					System.out.println(gettext);
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 130, 2), "Short Name Doesn't Match");	
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]").getText();
					System.out.println(gettext);
					SA.assertEquals(gettext, M.getstring("Automation Test Data", 130, 1), "Customer Name Doesn't Match");	
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
					System.out.println(gettext);
					SA.assertEquals(gettext, "No open orders", "3rd line Doesn't Match");	

				}
			}
			
			
			
			
		}catch (Exception e) {
			count++;
			str = str + "\n" + "Customer Not found";
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
			M.ScreenShots("Screenshot/Passed", "Verify Customers List View");
			M.setStrData("As Expected", "Automation Testcase", 563, 8);
			M.setStrData("Pass", "Automation Testcase", 563, 9);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Customers List View");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 563, 8);
			M.setStrData("Fail", "Automation Testcase", 563, 9);

		}

		ReStart();
	}

	
	
	
	//Verify Save Change Button Disable (With Blank Field)
	//@Test(priority = 9)
	public void VerifySaveChangeButtonDisable() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Save Change Button Disable When Field Blank Executed!");
		try {
			String str = "";
			int count = 0;
			int k = 137;
			int back = 0;
			boolean tr;
			String testdata;
			Thread.sleep(1000);
			String text = "Save Changes";
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data",130, 2));
			Thread.sleep(5000);
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "No Data Edit but show warning Message";
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
					
				} catch (Exception x) {
					count++;
					str = str + "\n" + "Some thing is wrong check manually";
					throw new Exception(str);
				}
			}
			
			Thread.sleep(5000);
			M.ClickOn(M.getstring("Automation Test Data",130, 2));
			
			for (int i = 0; i <= 6; i++) {
				if(i==0) {					
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
					if (tr == true) {
						count++;
						str = str + "\n" + "With-out change any field Save Change Button is enabled by default ";
						
					}
					Thread.sleep(5000);
					M.Scroll(1);
					
					try {
						
						 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/imgCustomerImage").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 
						 driver.findElementById("android:id/text1").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 try {
							 driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
						 }catch (Exception e) {
							 ;
						 }
						
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 //com.sec.android.gallery3d:id/thumbnail
						 driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc='Button'])[2]/android.widget.ImageView").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 
						 Thread.sleep(5000);
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 Thread.sleep(2000);
						 
						 M.ScrollByText(text);
							tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
							if (tr == true) {
								count++;
								str = str + "\n" + "After change Image Save Change Button is Enabled ";
								
							}
						
					}catch (Exception e) {
						count++;
						str = str + "\n Photo doesn't Update for check save change button is Enable or Disable after change photo.";
						
					}				
					i++;
				}
				
				// FullName Blank
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").clear();
					driver.hideKeyboard();
				}
					
				// ShortNameBlank
				if (i == 2) {
					FullName(M.getstring("Automation Test Data", k, 1));
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").clear();
					driver.hideKeyboard();
					
					
				}
				// Email
				if (i == 3) {
					ShortName(M.getstring("Automation Test Data", k, 2));
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").clear();
					driver.hideKeyboard();
					
				}

				// Phone Number
				if (i == 4) {
					Email(M.getstring("Automation Test Data", k, 4));
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").clear();
					driver.hideKeyboard();
					
					
				}

				// Address
				if (i == 5) {
					MobileNumber(M.getstring("Automation Test Data", k, 5));
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").clear();
					driver.hideKeyboard();
					
				}
				if(i==6) {
					Address(M.getstring("Automation Test Data", k, 6));
					Country(M.getstring("Automation Test Data",k , 3), 1);
					break;
					
				}
					

				M.ScrollByText(text);
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == true) {
					//System.out.println(i);
					
					if (i == 1) {
						count++;
						str = str + "\n" + "Full Name Field is Blank But Save Changes is Enable";
					}
						
					else if (i == 2) {
						count++;
						str = str + "\n" + "Short Name Field is Blank But Save Changes is Enable";
					}
						
					else
						;

				}else {
					
					
						
					if (i == 3) {
						count++;
						str = str + "\n" + "After erase Email, Save Changes is disable but Email Field is not Mendetory field.";
					}
						
					else if (i == 4) {
						count++;
						str = str + "\n" + "After erase Phone Number, Save Changes is disable but Phone Number Field is not Mendetory field.";
					}
						
					else if (i == 5) {
						count++;
						str = str + "\n" + "After erase Address, Save Changes is disable but Address Field is not Mendetory field.";
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
				Thread.sleep(5000);
				M.BackFun(1);
			}
			
			//warnning message
			Thread.sleep(2000);
			String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 159, 3), M.getstring("Automation Test Data", 159, 4));
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
				String page=driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
				try {
					
					Assert.assertEquals(page,"Customer Detail","Customer Detail page Title doesn't Match");
					
					Verifydata(137);
					
				}catch(AssertionError e)
				{
					count++;
					str = str + "\n" +e;
				}
				
			}catch (Exception e) {
				count++;
				
				try {
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
					str = str + "\n" + "After press back and click warring message no customer Detail page found No button doesn't work";
				}catch (Exception x) {
					str = str + "\n" + "Customer Detail page not found check manually what happend";
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
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After press back and click warring message yes customer page not found";
				try {
					Thread.sleep(5000);
					String page=driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
					str = str + "\n" + "After press back and click warring message yes But found customer Detail page, yes button doesn't work";
				}catch (Exception d) {
					str = str + "\n" + "check manually what happend";
				}
				
				throw new Exception(str);
			}
			//find customer
			try {
				
				M.ClickOn(M.getstring("Automation Test Data",130, 2));
				Thread.sleep(5000);
			}catch (Exception e) {
				
				M.ClickOn(M.getstring("Automation Test Data",137, 2));
				Thread.sleep(5000);
			}
			
			//data verify
			try {
				
				Verifydata(130);
				Thread.sleep(5000);
				M.BackFun(1);
				
			}catch(AssertionError e)
			{
				count++;
				str = str + "\n" +e;
			}
			
			
			String t=PageVerification("Customer Detail");
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
			M.setStrData("As Expected", "Automation Testcase", 563, 6);
			M.setStrData("Pass", "Automation Testcase", 563, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 563, 6);
			M.setStrData("Fail", "Automation Testcase", 563, 7);

		}
		ReStart();

	}
	
	
	
	
	// Verify Save Change Button Disabled/Enabled(Before & After Editing)
	//@Test(priority = 10)
	public void VerifySaveChangeButtonEnabled() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Change Button Disable to Enabled Executed!");
		try {
			String str = "";
			String gettext = "";
			int count = 0;
			int k= 137;
			int R= 130;
			boolean tr;
			String testdata;
			Thread.sleep(1000);
			String text = "Save Changes";
			
			Thread.sleep(2000);
			M.ClickOn( M.getstring("Automation Test Data", 130, 2));
			Thread.sleep(5000);
			
			for(int i = 0; i <= 6; i++) {

				// Before Editing
				if (i == 0) {
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
					if (tr == false) {
						count++;
						str = str + "Default Save Changes Button is Enable";

					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;

				}

				// FullName Editing
				if (i == 1) {
					FullName(M.getstring("Automation Test Data", k, 1));
				}

				// shortName Editing
				else if (i == 2) {
					ShortName(M.getstring("Automation Test Data", k, 2));
				}
				// Country
				else if (i == 3) {
					Country(M.getstring("Automation Test Data",k , 3), 1);
					
				}
				// Email
				else if (i == 4) {
					Email(M.getstring("Automation Test Data",k , 4));
					
				}

				// MobileNumber
				else if (i == 5) {
					MobileNumber(M.getstring("Automation Test Data", k, 5));
				}

				// Address
				else if (i == 6) {
					Address(M.getstring("Automation Test Data", k, 6));
				}

				Thread.sleep(1000);
				M.ScrollByText("Save Changes");
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == false) {
					//System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "After modify Full Name Save Changes Button is Disable";
					else if (i == 2)
						str = str + "\n" + "After modify Short Name Save Changes Button is Disable";
					else if (i == 3)
						str = str + "\n" + "After modify Country Save Changes Button is Disable";
					else if (i == 4)
						str = str + "\n" + "After modify Email Save Changes Button is Disable";
					else if (i == 5)
						str = str + "\n" + "After modify Phone Number Save Changes Button is Disable";
					else if (i == 6)
						str = str + "\n" + "After modify Address Save Changes Button is Disable";
					
				}
				if (i != 7) {
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(100);
					//warnning message
					Thread.sleep(2000);
					String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 159, 3), M.getstring("Automation Test Data", 159, 4));
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
						String page=driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
						if (i == 1) {
							//Customer Name
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 1), "Customer Name Doesn't Match");
							
						}
						else if (i == 2){
							//Short Name
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 2), "Short Name Doesn't Match");
	
						}
						else if (i == 3){
							//Country
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCountry").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 3), "Country Doesn't Match");
							
						}
						else if (i == 4){
							//Customer Email
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 4), "Customer Email Doesn't Match");
							
						}
						else if (i == 5){
							//Customer Phone
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 5), "Customer Phone Doesn't Match");
							
						}
						else if (i == 6){
							//Address
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", k, 6), "Address Doesn't Match");
						}
						
						try {
							SA.assertAll();
						} catch (AssertionError e) {
							count++;
							str = str + "\n" + e;
						}
						
					}catch (Exception e) {
						count++;						
						try {
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
							str = str + "\n" + "After press back and click warring message no customer Detail page found No button doesn't work";
						}catch (Exception x) {
							str = str + "\n" + "Customer Detail page not found check manually what happend";
						}						
						throw new Exception(str);
					}
					
					
					try {
						Thread.sleep(5000);
						M.BackFun(1);
						Thread.sleep(100);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(3000);
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
					} catch (Exception e) {
						count++;
						str = str + "\n" + "After press back and click warring message yes customer page not found";
						try {
							Thread.sleep(5000);
							String page=driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
							str = str + "\n" + "After press back and click warring message yes But found customer Detail page, yes button doesn't work";
						}catch (Exception d) {
							str = str + "\n" + "check manually what happend";
						}
						
						throw new Exception(str);
					}
					//find customer
					try {
						Thread.sleep(5000);
						M.ClickOn(M.getstring("Automation Test Data",130, 2));
						Thread.sleep(5000);
					}catch (Exception e) {
						Thread.sleep(5000);
						M.ClickOn(M.getstring("Automation Test Data",137, 2));
						Thread.sleep(5000);
					}
					
					
					try {
						Thread.sleep(5000);
						String page=driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
						if (i == 1) {
							//Customer Name
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 1), "Customer Name Doesn't Match");
							
						}
						else if (i == 2){
							//Short Name
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 2), "Short Name Doesn't Match");
	
						}
						else if (i == 3){
							//Country
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCountry").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 3), "Country Doesn't Match");
							
						}
						else if (i == 4){
							//Customer Email
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 4), "Customer Email Doesn't Match");
							
						}
						else if (i == 5){
							//Customer Phone
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 5), "Customer Phone Doesn't Match");
						}
						else if (i == 6){
							//Address
							gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").getText();
							SA.assertEquals(gettext, M.getstring("Automation Test Data", R, 6), "Address Doesn't Match");
							
							

						}
						try {
							SA.assertAll();
							
						} catch (AssertionError e) {
							count++;
							str = str + "\n" + e;
							if(i==6) {
								DataFillUp(130);
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								M.ScrollByText(text);
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							}
								
						}
						
												
					}catch (Exception e) {
						count++;
						str = str + "\n" + "Customer Details page not found, check manually what happend";
						throw new Exception(str);
					}
					
					

				}

			}
			Thread.sleep(5000);
			M.BackFun(1);
			Thread.sleep(3000);
			String t=PageVerification("Customer Detail");
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
			M.setStrData("As Expected", "Automation Testcase", 564, 6);
			M.setStrData("Pass", "Automation Testcase", 564, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 564, 6);
			M.setStrData("Fail", "Automation Testcase", 564, 7);

		}
		ReStart();

	}

	

	
	// Update Customer Info With Invalid Values
	//@Test(priority = 11)
	public void UpdateCustomerbyInvalidUserName() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Update Customer Info With Invalid Values Executed!");
		try {
			String str = "";
			int count = 0;
			int j = 0;
			int k = 0;
			int pass = 0;
			String title = "";
			Thread.sleep(1000);
			String text = "Save Changes";
			Thread.sleep(2000);
			M.ClickOn( M.getstring("Automation Test Data", 130, 2));
			Thread.sleep(5000);

			for (int i = 1; i <= 7; i++) {
				// invalid Name&ShortName
				Thread.sleep(5000);
				if(i!=7) {
					FullName(M.getstring("Automation Test Data", 132, i));
					ShortName(M.getstring("Automation Test Data", 133, i));
				}else {
					FullName(M.getstring("Automation Test Data", 130, 1));
					ShortName(M.getstring("Automation Test Data", 130, 2));
				}
				Thread.sleep(2000);
				M.ScrollByText(text);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(i==7) {
					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					}catch (Exception e) {
						;
						
					}
					break;
				}
				pass = 0;
				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				}catch (Exception e) {
					pass++;
					
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
						Thread.sleep(5000);
						M.Scroll(1);
						
						//Customer Name
						String gettext=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").getText();
						
						//Short Name
						String  gettext1=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").getText();
						if(gettext.contains(M.getstring("Automation Test Data", 132, i)) || gettext1.contains(M.getstring("Automation Test Data", 133, i))) {
							if (i == 1)
								str = str + "\n" + "Special Char Accept in FullName & ShortName";
							else if (i == 2)
								str = str + "\n" + "Numeric Char Accept in FullName & ShortName";
							else if (i == 3)
								str = str + "\n" + "Invalid Char ShortName Accept";
							else if (i == 4)
								str = str + "\n" + "Invalid Numeric ShortName Accept";
							else if (i == 5)
								str = str + "\n" + "Invalid Char FullName Accept";
							else
								str = str + "\n" + "Invalid Numeric FullName Accept";
						}

					} catch (Exception y) {
						try {
							//System.out.println("print ok");
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
							count++;
							str = str + "\n" + "After sucessfully update invalid data, it redirect Customers page.";
							//System.out.println("print ok");
							Thread.sleep(5000);
							M.ScrollByText(M.getstring("Automation Test Data", 133, i));
							Thread.sleep(2000);
							List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
							for (i = 0; i < xyz.size(); i++) {
								if (xyz.get(i).getText().contains(M.getstring("Automation Test Data", 133, i))) {
									j = i + 1;
									driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").click();
									Thread.sleep(2000);
									break;
								}
							}

							if (i == 1)
								str = str + "\n" + "Special Char Accept in FullName & ShortName";
							else if (i == 2)
								str = str + "\n" + "Numeric Char Accept in FullName & ShortName";
							else if (i == 3)
								str = str + "\n" + "Invalid Char ShortName Accept";
							else if (i == 4)
								str = str + "\n" + "Invalid Numeric ShortName Accept";
							else if (i == 5)
								str = str + "\n" + "Invalid Char FullName Accept";
							else
								str = str + "\n" + "Invalid Numeric FullName Accept";
							
						}catch (Exception z) {
							count++;
							str = str + "\n" + "After sucessfully update invalid data, Apps may be crush check manually";
							throw new Exception(str);
						}
					}
					
				}
				if(pass==0) {
					//System.out.println("print not ok");
					if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
						count++;
						if (i == 1)
							str = str + "\n" + "Special Char Accept in FullName & ShortName";
						else if (i == 2)
							str = str + "\n" + "Numeric Char Accept in FullName & ShortName";
						else if (i == 3)
							str = str + "\n" + "Invalid Char ShortName Accept";
						else if (i == 4)
							str = str + "\n" + "Invalid Numeric ShortName Accept";
						else if (i == 5)
							str = str + "\n" + "Invalid Char FullName Accept";
						else
							str = str + "\n" + "Invalid Numeric FullName Accept";

						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						try {
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
							Thread.sleep(5000);
							M.Scroll(1);

						} catch (Exception e) {
							try {
								Thread.sleep(2000);
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
								count++;
								str = str + "\n" + "After sucessfully update invalid data, it redirect Customers page.";
								
								Thread.sleep(5000);
								M.ClickOn(M.getstring("Automation Test Data", 133, i));
								
							}catch (Exception x) {
								count++;
								str = str + "\n" + "After sucessfully update invalid data, Apps may be crush check manually";
							}
						}

					} else if(pass==0) {
						
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(5000);

						// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
						try {
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
							Thread.sleep(5000);
							M.Scroll(1);

						} catch (Exception e) {
							try {
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
								count++;
								str = str + "\n" + "After warnning update invalid data, it redirect Customers page.";
								
								Thread.sleep(5000);
								M.ClickOn(M.getstring("Automation Test Data", 133, i));
								
								
								
							} catch (Exception x) {
								try {
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									count++;
									str = str + "\n" + "After Warring Message, some unwantted message show";
									
									String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
									Thread.sleep(5000);
									M.Scroll(1);
									
								}catch (Exception y) {
									count++;
									str = str + "\n" + "After warnning update invalid data, Apps may be crush check manually";
								}

							}
						}
					}
					
				}



			}
			
			String t=PageVerification("Customer Detail");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreatebyInvalidUserName");

			M.setStrData("As Expected", "Automation Testcase", 565, 6);
			M.setStrData("Pass", "Automation Testcase", 565, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "CreatebyInvalidUserName");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 565, 6);
			M.setStrData("Fail", "Automation Testcase", 565, 7);

		}
		ReStart();

	} 
	

	
	// Email Verification
	//@Test(priority = 12)
	public void UserEmailVerification() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();

		System.out.println("Email Verification Executed!");

		try {
			Thread.sleep(5000);
			M.ClickOn( M.getstring("Automation Test Data", 130, 2));
			Thread.sleep(5000);
			int count = 0;
			String str = "";
			String mass = "";
			String title = "";
			String data = "";
			String text = "Save Changes";
			for (int i = 1; i <= 9; i++) {
				Thread.sleep(5000);
				M.Scroll(1);

				data = M.getstring("Automation Test Data", 135, i);

				// Email
				Email(data);

				Thread.sleep(2000);
				M.ScrollByText(text);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				//Message
				try {
					mass = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					// System.out.println(mass);
					M.setStrData(mass, "Automation Test Data", 155, 3);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Error Message Body Not Found";
				}

				//Title
				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					// System.out.println(title);
					
					if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
						count++;
						str = str + "\n" + data + "- Invalid Email Accept";
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						if (i != 9) {
							Thread.sleep(5000);
							M.ClickOn( M.getstring("Automation Test Data", 130, 2));
							Thread.sleep(5000);
						}

					} else {
						try {
							if (i != 9)
								Assert.assertEquals(mass, M.getstring("Automation Test Data", 155, 3),
										"- Email Verification Message doesn't valid");
							else
								Assert.assertEquals(mass, M.getstring("Automation Test Data", 155, 4),
										"- Existing Email Verification Message doesn't valid");

						} catch (AssertionError e) {
							count++;
							str = str + "\n" + data + e;
						}

						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 155, 2),
									"- Email Verification Title doesn't valid");
						} catch (AssertionError e) {
							count++;
							str = str + "\n" + data + e;
						}
						Thread.sleep(100);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
					
				}

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Title Body Not Found";
				}

					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
						

					} catch (Exception e) {
						
						try {

							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
							Thread.sleep(5000);
							M.ClickOn( M.getstring("Automation Test Data", 130, 2));
							Thread.sleep(5000);
							count++;
							str = str + "\n" + "After click on ok Warring Message, Redirect to customers page ";
						} catch (Exception y) {

							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
								count++;
								str = str + "\n" + "After Warring Message, some unwantted message show";
								Thread.sleep(5000);
							} catch (Exception x) {
								count++;
								str = str + "\n" + "After click on ok Warring Message, apps may be crush ";

							}
						}
						
						
					}

					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				

			}
			String t=PageVerification("Customer Detail");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "User Email Verification");
			M.setStrData("As Expected", "Automation Testcase", 567, 6);
			M.setStrData("Pass", "Automation Testcase", 567, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "User Email Verification");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 567, 6);
			M.setStrData("Fail", "Automation Testcase", 567, 7);

		}
		ReStart();

	}
	
	

	
	
	//Mobile Number Verification
	//@Test(priority = 13)
	public void UserMobileNumberVerification() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Mobile Number Verification Executed!");

		try {
			int count = 0;
			String str = "";
			int k = 8;
			String data = "";
			String mess = "";
			String title = "";
			Thread.sleep(5000);
			M.ClickOn( M.getstring("Automation Test Data", 130, 2));
			Thread.sleep(5000);
			for (int i = 1; i <= 7; i++) {

				int j = i + 1;
				
				data = M.getstring("Automation Test Data", 49, i);
				
				
				if(i!=7) {
					// Phone Number
					MobileNumber(data);
				}else {
					MobileNumber(M.getstring("Automation Test Data", 49, 2));
				}

				//System.out.println(data);

				Thread.sleep(1000);
				M.ScrollByText("Save Changes");
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				

				try {
					Thread.sleep(2000);
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					 //System.out.println(title);
					 
					 try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 157, k),"- Number Field Verification Title doesn't valid");
							
						} catch (AssertionError e) {
							count++;
							str = str + "\n" + data + e;
						}

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Title Body Not Found";
				}
				
				
				try {
					mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					//System.out.println(mess);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					try {
						Assert.assertEquals(mess, M.getstring("Automation Test Data", 157, j),"- Number Field Verification Message doesn't valid");

					} catch (AssertionError e) {
						count++;
						str = str + "\n" + data + e;
					}
					
					
					if (mess.contentEquals(M.getstring("Automation Test Data", 157, j))) {
						
					} else {
						
						if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
							str = str + "\n" + data + "- Accept invalid Number";
							count++;

						} else {
							count++;
							str = str + "\n" + data + "- " + mess;

							

						}

					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Message Body Not Found";
				}


				
				k++;
				
				if (i != 6) {
					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
						

					} catch (Exception e) {
						
						try {

							String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
							Thread.sleep(5000);
							M.ClickOn( M.getstring("Automation Test Data", 130, 2));
							Thread.sleep(5000);
							count++;
							str = str + "\n" + "After click on ok Warring Message, Redirect to customers page ";
						} catch (Exception y) {

							try {
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
								count++;
								str = str + "\n" + "After Warring Message, some unwantted message show";
								Thread.sleep(5000);
							} catch (Exception x) {
								count++;
								str = str + "\n" + "After click on ok Warring Message, apps may be crush ";

							}
						}
					
				}


			}
		}
			
			String t=PageVerification("Customer Detail");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}
			
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "User Email Verification");
			M.setStrData("As Expected", "Automation Testcase", 568, 6);
			M.setStrData("Pass", "Automation Testcase", 568, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "User Email Verification");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 568, 6);
			M.setStrData("Fail", "Automation Testcase", 568, 7);

		}

		ReStart();

	}
	
	
	
	
	
	// Update Customer info
	//@Test (priority = 14)
	public void UpdateCustomerInfo() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Update Customer Info Executed!");

		String successful = "";
		String mess = "";
		int count = 0;
		int pass = 0;

		String button = "Save Changes";
		String str = "";
		
		try {
			
			Thread.sleep(2000);
			M.ClickOn( M.getstring("Automation Test Data", 130, 2));
			Thread.sleep(5000);

			// Image Upload...

			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/imgCustomerImage").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				driver.findElementById("android:id/text1").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				try {
					 driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
				 }catch (Exception e) {
					 ;
				 }
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				driver.findElementByXPath(
						"(//android.widget.FrameLayout[@content-desc='Button'])[1]/android.widget.ImageView").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				
				//Sucessfull Message..								
				Thread.sleep(5000);
				successful=M.Sucessfull_Message(M.getstring("Automation Test Data", 161, 2), M.getstring("Automation Test Data", 161, 3));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				

			} catch (Exception e) {
				count++;
				str = str + "\n Photo doesn't Update";

			}

			Thread.sleep(2000);
			DataFillUp(137);

			Thread.sleep(2000);
			M.ScrollByText(button);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				Thread.sleep(3000);
				
			} catch (Exception e) {
				count++;
				str = str + "\n Submit Button Doesn't Work";
				throw new Exception(str);
			}
			
			
			
			// Sucessfull Message..
			Thread.sleep(2000);
			successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 163, 9),M.getstring("Automation Test Data", 163, 3));

			if (successful.isBlank()) {
				;
			} else {
				count++;
				str = str + "\n" + successful;
			}

			try {
				Thread.sleep(1000);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(5000);	
				
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					count++;
					str = str + "\n" + "After sucessfull ok, when click back it show a warning message";
				}catch (Exception e) {
					;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "After click ok sucessful message, Customer Details Page not found";
				
				try {					
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
					count++;
					str = str + "\n" + "After sucessfull ok, it redirect to Customer page";
					
				}catch (Exception y) {
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						count++;
						str = str + "\n" + "After sucessfull ok, it show a warning message";
						
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
					} catch (Exception x) {
						count++;
						str = str + "\n" + "After sucessfull ok,check manually";
					}
				}

			}
			
			
			String t=PageVerification("Customer Detail");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreateAssignTask");
			M.setStrData("As Expected", "Automation Testcase", 569, 6);
			M.setStrData("Pass", "Automation Testcase", 569, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CreateAssignTask");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 569, 6);
			M.setStrData("Fail", "Automation Testcase", 569, 7);

		}
		ReStart();
	}
	
	
	
	
	// Verify Updated Customer Info
	//@Test (priority = 15)
	public void VerifyUpdateCustomerinfo() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Updated Customer Info Executed!");
		String update = "";
		String str = "";
		int count = 0;

		try {

			update = M.getstring("Automation Test Data", 137, 2);
			Thread.sleep(5000);
			M.ClickOn(update);
			

			try {
				Thread.sleep(5000);
				String page = driver.findElementByXPath("//android.widget.TextView[@text='Customer Detail']").getText();
				try {

					Assert.assertEquals(page, "Customer Detail", "Customer Detail page Title doesn't Match");

					Verifydata(137);

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Customer Detail page not found check manually what happend";

			}

			Thread.sleep(5000);
			M.BackFun(1);
			
			String t=PageVerification("Customer Detail");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "Verify Updated Customer Info");
			M.setStrData("As Expected", "Automation Testcase", 570, 6);
			M.setStrData("Pass", "Automation Testcase", 570, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Verify Updated Customer Info");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 570, 6);
			M.setStrData("Fail", "Automation Testcase", 570, 7);

		}
		ReStart();
	}
	
	

	
	
	// Dismiss Unsaved Data (For Each Field)
	//@Test(priority = 16)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int k = 137;
		String str = "";

		try {
			for (int i = 1; i <= 6; i++) {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);

				if (i == 1)
					FullName(M.getstring("Automation Test Data", k, 1));
				else if (i == 2)
					ShortName(M.getstring("Automation Test Data", k, 2));
				else if (i == 3)
					Email(M.getstring("Automation Test Data", k, 4));
				else if (i == 4)
					MobileNumber(M.getstring("Automation Test Data", k, 5));
				else if (i == 5)
					Address(M.getstring("Automation Test Data", k, 6));
				else {
					Country(M.getstring("Automation Test Data", k, 3), 1);
				}

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

				// check warning title & Message
				//Warnning message
				Thread.sleep(2000);
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 159, 3),M.getstring("Automation Test Data", 159, 4));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}


				Thread.sleep(2000);
				// New Customer page
				try {
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='New Customer']").getText();

					if (i == 1)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerFullName").clear();
					else if (i == 2)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerShortName").clear();
					else if (i == 3)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdCustomerEmail").clear();
					else if (i == 4)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtCustomerPhone").clear();
					else if (i == 5)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdAddress").clear();
					else
						;

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

					if (i > 5) {
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						} catch (Exception e) {
							count++;
							str = str + "\n" + "Warrning message not found for click on Yes button";
						}

					}

					//Customers page
					try {
						user1 = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
						// System.out.println("back button ok");
						// M.SwipBytext(M.getstring("Automation Test Data", 43, 1));
					} catch (Exception e) {
						count++;
						if (i <= 5)
							str = str + "\n" + "Customers not found after back without input";
						else
							str = str + "\n" + "Customers not found after unsave warrning message yes";

					}

				} catch (Exception e) {
					// Use page
					count++;
					try {
						String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Customers']").getText();
						str = str + "\n" + "Warring message not found & back to user page";
						// throw new Exception(str);
					} catch (Exception x) {
						str = str + "\n" + "Apps May be crush....";
					}

				}

			}
			
			String t=PageVerification("Customer Detail");
			if(t.isBlank()) {
				;
			}else {
				count++;
				str = str +t;
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreateDataDismiss");
			M.setStrData("As Expected", "Automation Testcase", 571, 6);
			M.setStrData("Pass", "Automation Testcase", 571, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CreateDataDismiss");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 571, 6);
			M.setStrData("Fail", "Automation Testcase", 571, 7);

		}
		ReStart();

	}
	
	
	
	
	//Verify Disable Customer (Without Existing Transaction)
	//@Test (priority = 17)
	public void DisableCustomerWithoutExistingTransaction()throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Disable Customer Without Existing Transaction Executed!");
		int count=0;
		int j = 0;
		int i;
		String str="";
		String data=M.getstring("Automation Test Data", 137, 2);
		try {
			
			Thread.sleep(5000);
			M.ScrollByText(data);
			UpCustomer(data);
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					j=j+1;
					String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
					//System.out.println(gettext);
					if(gettext.contains("No open orders")) {
						Thread.sleep(2000);
						M.SwipBytext(data);
						Thread.sleep(2000);
					}
					
				}
			}
						
			j=counting(data);
			System.out.println(j);
	
			try {
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				//Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 165, 2),M.getstring("Automation Test Data", 165, 3));
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
					UpCustomer(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j=counting(data);
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contains("Enable")) {
						count++;
						str = str + "\n" +"After click warning message No,Disable button change to Enable";
					}
					
					
				}
				
				driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 165, 2), M.getstring("Automation Test Data", 165, 3));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				//Sucessfull Message..								
				Thread.sleep(2000);
				successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 165, 4), M.getstring("Automation Test Data", 165, 5));
				
				if(successful.isBlank())
				{
					;
				}else
				{
					count++;
					str = str + "\n" + successful;
				}
				
				
				try {
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, customer doesn't Disable";
					}	
				}catch(Exception e) {
					
					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					UpCustomer(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j=counting(data);
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if(gettext.contains("Disable")) {
						count++;
						str = str + "\n" +"After click Disable button yes, customer doesn't Disable";
					}
					
					//Page Refresh
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						 
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 
						 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 
						 driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click();
						 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}catch(Exception x) {
						;
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
			M.ScreenShots("Screenshot/Passed","Disable Customer Without Existing Transaction"); 
		    M.setStrData("As Expected","Automation Testcase", 571, 8);
			M.setStrData("Pass","Automation Testcase", 571, 9);
			
		
		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","Disable Customer Without Existing Transaction");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 571,8);
			M.setStrData("Fail","Automation Testcase", 571, 9);
						
		}
		
		
		ReStart();
	}
	
	
	
	
	// Verify Enable Customer (Without Existing Transaction)
	//@Test (priority = 18)
	public void EnableCustomerWithoutExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Enable Customer Without Existing Transaction Executed!");
		int count = 0;
		int j = 0;
		int i;
		String str = "";
		String data = M.getstring("Automation Test Data", 137, 2);
		try {

			Thread.sleep(5000);
			M.ScrollByText(data);
			UpCustomer(data);
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					j=j+1;
					String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
					//System.out.println(gettext);
					if(gettext.contains("No open orders")) {
						Thread.sleep(2000);
						M.SwipBytext(data);
						Thread.sleep(2000);
					}
					
				}
			}

			
			
			j = counting(data);
			System.out.println(j);
			
			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 166, 2),M.getstring("Automation Test Data", 166, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					// System.out.println(gettext);
					if (gettext.contains("Disable")) {
						// System.out.println(gettext);
						count++;
						str = str + "\n" + "After click warning message No,Enable button change to Disable";
						// System.out.println(gettext);
					}
				} catch (Exception e) {

					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					UpCustomer(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j = counting(data);

					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j + "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if (gettext.contains("Disable")) {
						count++;
						str = str + "\n" + "After click warning message No,Enable button change to Disable";
					}

				}

				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);

				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 166, 2),M.getstring("Automation Test Data", 166, 3));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				// Sucessfull Message..
				Thread.sleep(2000);
				successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 166, 4),M.getstring("Automation Test Data", 166, 5));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				try {
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if (gettext.contains("Enable")) {
						count++;
						str = str + "\n" + "After click Enable button yes, customer doesn't Enable";
					}
				} catch (Exception e) {

					Thread.sleep(5000);
					M.ScrollByText(data);
					Thread.sleep(3000);
					UpCustomer(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);
					
					j = counting(data);
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if (gettext.contains("Enable")) {
						count++;
						str = str + "\n" + "After click Enable button yes, customer doesn't Enable";
					}

					// Page Refresh
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					} catch (Exception x) {
						;
					}

				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Enable Button doesn't Work";

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Enable Customer Without Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 572, 6);
			M.setStrData("Pass", "Automation Testcase", 572, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Enable Customer Without Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 572, 6);
			M.setStrData("Fail", "Automation Testcase", 572, 7);

		}

		ReStart();
	}
	
	


	// Verify Delete Customer (Without Existing Transaction)
	//@Test(priority = 19)
	public void DeleteCustomerWithoutExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete Customer Without Existing Transaction Executed!");
		int count = 0;
		int j = 0;
		int i;
		String str = "";
		String data = M.getstring("Automation Test Data", 137, 2);
		try {

			Thread.sleep(5000);
			M.ScrollByText(data);
			UpCustomer(data);
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					j=j+1;
					String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
					//System.out.println(gettext);
					if(gettext.contains("No open orders")) {
						Thread.sleep(2000);
						M.SwipBytext(data);
						Thread.sleep(2000);
					}
					
				}
			}
			

			j = counting(data);
			System.out.println(j);


			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 168, 2),
						M.getstring("Automation Test Data", 168, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				try {
					Thread.sleep(2000);
					String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
							+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView")
							.getText();
					// System.out.println(gettext);

				} catch (Exception e) {
					try {
						Thread.sleep(5000);
						M.ScrollByText(data);
						UpCustomer(data);

						Thread.sleep(3000);
						M.SwipBytext(data);
						Thread.sleep(3000);
						
						j = counting(data);
					} catch (Exception x) {
						count++;
						str = str + "\n" + "After click Delete warning message No,Customer Id Delete ";
						throw new Exception(str);
					}

				}

				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 168, 2),
						M.getstring("Automation Test Data", 168, 3));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				// Sucessfull Message..
				Thread.sleep(2000);
				successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 168, 4),
						M.getstring("Automation Test Data", 168, 5));

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
					str = str + "\n" + "After Sucessfully Delete, Customer ID doesn't Delete ";
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
			M.ScreenShots("Screenshot/Passed", "Delete Customer Without Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 573, 6);
			M.setStrData("Pass", "Automation Testcase", 573, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Customer Without Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 573, 6);
			M.setStrData("Fail", "Automation Testcase", 573, 7);

		}

		ReStart();
	}
	
	
	
	
	// Verify Disable Customer (With Existing Transaction)
	//@Test (priority = 20)
	public void DisableCustomerWithExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Disable Customer With Existing Transaction Executed!");
		int count = 0;
		int j = 0;
		int i;
		String str = "";

		String data = M.getstring("Automation Test Data", 130, 2);
		try {
			Thread.sleep(5000);
			CreateCustomer();

			try {
				// Navigate to MyOrder Page
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.TextView[@text='My Orders']").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(5000);

				// Click create button
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				Thread.sleep(2000);

				// PoNumber
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPoNumber").sendKeys("Automation-12/4/21");
				driver.hideKeyboard();

				// PoDate
				// String Date=M.getstring("Automation Test Data",30, 1);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectPoDate").click();
				// driver.findElementById("android:id/date_picker_header_year").click(); use for
				// Emulator

				// driver.findElementByXPath("//android.view.View[@content-desc=\"" + Date +
				// "\"]").click();
				driver.findElementById("android:id/button1").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// CustomerSelect
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llCustomerSelect").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String customer = M.getstring("Automation Test Data", 130, 1);
				M.ClickOn(customer);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// ProductCategory
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectProductCategory").click();
				M.ClickOn("Test 2");
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// StyleNumber
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llStyleNumber").click();
				driver.hideKeyboard(); // Hide keyboard from view.
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtStyleNumber")
						.setValue("Auto StyleNo_29/11");

				// ShipmentDate
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectShipmentDate").click();
				// driver.findElementById("android:id/date_picker_header_year").click();
				// String date1=M.getstring("Automation Test Data",30, 2);
				// M.ScrollByText(date1);
				// M.ClickOn(date1);
				// Date=M.getstring("Automation Test Data",30, 3);

				// driver.findElementByXPath("//android.view.View[@content-desc=\"" + Date +
				// "\"]").click();
				driver.findElementById("android:id/button1").click();
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

				// SelectCurrency
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectCurrency").click();
				driver.findElementByXPath("//android.widget.TextView[@text='BDT']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// SelectUnitOfMeasurement
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectUnitOfMeasurement").click();
				driver.findElementByXPath("//android.widget.TextView[@text='Pcs']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String CreButton = "Create";
				M.ScrollByText(CreButton);

				// OrderQuality
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtOrderQuality").setValue("1000");
				driver.hideKeyboard();

				// editFOB
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFOB").setValue("10");
				driver.hideKeyboard();

				// ShipMode
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectShipMode").click();
				M.ClickOn("Test 1");
				// driver.findElementByXPath("//android.widget.TextView[@text='Test
				// 1']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// POStatus
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectPOStatus").click();
				M.ClickOn("Test2");
				// driver.findElementByXPath("//android.widget.TextView[@text='Test2']").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// TnaTemplate
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llSelectTnaTemplate").click();
				String TnaTemp = "LC Task Template For Order";
				M.ClickOn(TnaTemp);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// Remarks
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtRemarks").sendKeys("Auto QA Remarks");
				driver.hideKeyboard();

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				Thread.sleep(5000);
				M.BackFun(1);
				Thread.sleep(2000);
				System.out.println("addNewOrder Executed!");

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Order not create, check Manually";
			}

			// Navigate to Customer Page.

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(5000);
			M.ScrollByText(data);
			UpCustomer(data);
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					j++;
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText();
						Thread.sleep(2000);
						M.SwipBytext(data);
						Thread.sleep(2000);

					}catch (Exception e) {
						count++;
						str = str + "\n" +"No Transaction Found in selected customer";
						throw new Exception(str);
						
					}
					
				}
			}

			j = counting(data);
			//System.out.println(j);
			
			
			// System.out.println(gettext);
			

			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				
				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 165, 6),M.getstring("Automation Test Data", 165, 7));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
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
					UpCustomer(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);
					
					j = counting(data);
					
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					if (gettext.contains("Enable")) {
						count++;
						str = str + "\n" + "After click warning message No,Disable button change to Enable";
					}

				}

				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);

				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 165, 6),M.getstring("Automation Test Data", 165, 7));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				// Sucessfull Message..
				Thread.sleep(2000);
				successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 165, 4),M.getstring("Automation Test Data", 165, 5));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				try {
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					if (gettext.contains("Disable")) {
						count++;
						str = str + "\n" + "After click Disable button yes, customer doesn't Disable";
					}
				} catch (Exception e) {

					Thread.sleep(5000);
					M.ScrollByText(data);
					UpCustomer(data);

					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j = counting(data);

					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j + "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if (gettext.contains("Disable")) {
						count++;
						str = str + "\n" + "After click Disable button yes, customer doesn't Disable";
					}

					// Page Refresh
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					} catch (Exception x) {
						;
					}

				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Disable Button doesn't Work";

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Disable Customer With Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 574, 6);
			M.setStrData("Pass", "Automation Testcase", 574, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Disable Customer With Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 574, 6);
			M.setStrData("Fail", "Automation Testcase", 574, 7);

		}

		ReStart();
	}
	
	
	
	// Verify Enable Customer (With Existing Transaction)
	//@Test (priority = 21)
	public void EnableCustomerWithExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Enable Customer With Existing Transaction Executed!");
		int count = 0;
		int j = 0;
		int i;
		String str = "";
		String data = M.getstring("Automation Test Data", 130, 2);
		try {

			Thread.sleep(5000);
			M.ScrollByText(data);
			UpCustomer(data);
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					j++;
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText();
						Thread.sleep(2000);
						M.SwipBytext(data);
						Thread.sleep(2000);

					}catch (Exception e) {
						count++;
						str = str + "\n" +"No Transaction Found in selected customer";
						throw new Exception(str);
						
					}
					
				}
			}

			j = counting(data);

			System.out.println(j);

			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j
						+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);
				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 166, 2),
						M.getstring("Automation Test Data", 166, 3));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				String gettext;
				try {
					Thread.sleep(2000);
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					// System.out.println(gettext);
					if (gettext.contains("Disable")) {
						// System.out.println(gettext);
						count++;
						str = str + "\n" + "After click warning message No,Enable button change to Disable";
						// System.out.println(gettext);
					}
				} catch (Exception e) {

					Thread.sleep(5000);
					M.ScrollByText(data);
					UpCustomer(data);

					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j = counting(data);

					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j + "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					if (gettext.contains("Disable")) {
						count++;
						str = str + "\n" + "After click warning message No,Enable button change to Disable";
					}

				}

				driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]").click();
				Thread.sleep(2000);

				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 166, 2),
						M.getstring("Automation Test Data", 166, 3));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				// Sucessfull Message..
				Thread.sleep(2000);
				successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 166, 4),
						M.getstring("Automation Test Data", 166, 5));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				try {
					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView").getText();
					if (gettext.contains("Enable")) {
						count++;
						str = str + "\n" + "After click Enable button yes, customer doesn't Enable";
					}
				} catch (Exception e) {

					Thread.sleep(5000);
					M.ScrollByText(data);
					UpCustomer(data);
					
					Thread.sleep(3000);
					M.SwipBytext(data);
					Thread.sleep(3000);

					j = counting(data);

					gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
							+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
							.getText();
					if (gettext.contains("Enable")) {
						count++;
						str = str + "\n" + "After click Enable button yes, customer doesn't Enable";
					}

					// Page Refresh
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					} catch (Exception x) {
						;
					}

				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Enable Button doesn't Work";

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Enable Customer With Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 575, 6);
			M.setStrData("Pass", "Automation Testcase", 575, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Enable Customer With Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 575, 6);
			M.setStrData("Fail", "Automation Testcase", 575, 7);

		}

		ReStart();
	}
		
	
	
	// Verify Delete Customer (With Existing Transaction)
	//@Test(priority = 22)
	public void DeleteCustomerWithExistingTransaction() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Delete Customer With Existing Transaction Executed!");
		int count = 0;
		int j = 0;
		int i;
		String str = "";
		String data = M.getstring("Automation Test Data", 130, 2);
		try {

			Thread.sleep(5000);
			M.ScrollByText(data);
			UpCustomer(data);
			
			List<AndroidElement> xyz = driver.findElementsById("bd.com.cslsoft.kandareeliteapp:id/txtCustomerShortName");
			for (j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains(data)) {
					j++;
					try {
						String gettext = driver.findElementByXPath("//android.view.ViewGroup["+j+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText();
						Thread.sleep(2000);
						M.SwipBytext(data);
						Thread.sleep(2000);

					}catch (Exception e) {
						count++;
						str = str + "\n" +"No Transaction Found in selected customer";
						throw new Exception(str);
						
					}
					
				}
			}
			
			j = counting(data);
			System.out.println(j);
			

			try {
				driver.findElementByXPath("//android.view.ViewGroup[" + j
						+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				// Warnning message
				String confirmation = M.Confirmation_Message(M.getstring("Automation Test Data", 168, 2),
						M.getstring("Automation Test Data", 168, 8));
				if (confirmation.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + confirmation;
				}

				try {
					Thread.sleep(2000);
					String gettext = driver.findElementByXPath("//android.view.ViewGroup[" + j
							+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView")
							.getText();
					// System.out.println(gettext);

				} catch (Exception e) {
					try {
						Thread.sleep(5000);
						M.ScrollByText(data);
						UpCustomer(data);
						Thread.sleep(3000);

						Thread.sleep(3000);
						M.SwipBytext(data);
						Thread.sleep(3000);

						j = counting(data);


					} catch (Exception x) {
						count++;
						str = str + "\n" + "After click Delete warning message No,Customer Id Delete ";
						throw new Exception(str);
					}

				}

				driver.findElementByXPath("//android.view.ViewGroup[" + j
						+ "]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]").click();
				Thread.sleep(2000);

				// Sucessfull Message..
				Thread.sleep(2000);
				String successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 168, 2),
						M.getstring("Automation Test Data", 168, 8));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				// Sucessfull Message..
				Thread.sleep(2000);
				successful = M.Sucessfull_Message(M.getstring("Automation Test Data", 168, 6),
						M.getstring("Automation Test Data", 168, 7));

				if (successful.isBlank()) {
					;
				} else {
					count++;
					str = str + "\n" + successful;
				}

				
				// Page Refresh
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElementByXPath("//android.widget.TextView[@text='Home']").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					driver.findElementByXPath("//android.widget.TextView[@text='Customers']").click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception x) {
					;
				}
				
				try {
					Thread.sleep(5000);
					M.ScrollByText(data);
					

				} catch (Exception x) {
					count++;
					str = str + "\n" + "Customer have a Transaction but it Delete";
					throw new Exception(str);
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Delete Button doesn't Work";

			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Delete Customer With Existing Transaction");
			M.setStrData("As Expected", "Automation Testcase", 576, 6);
			M.setStrData("Pass", "Automation Testcase", 576, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete Customer With Existing Transaction");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 576, 6);
			M.setStrData("Fail", "Automation Testcase", 576, 7);

		}

		ReStart();
	}
	

	//Verify Sorting
	//@Test(priority = 23)
	public void SortingCustomer() {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_filter").click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/rbShortName").click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llDescendingBg").click();
		 
		 driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnApplyALl").click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 System.out.println("Sorting Customer Executed!");
		//driver.quit();

	}

	
	

}
