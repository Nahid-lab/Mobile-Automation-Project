package com.cslsoft.KandareeLiteTestCase;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.examples.CreateUserDefinedDataFormats;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cslsoft.KandareeLiteTestCase.CallingMethods;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Users extends BaseClass {

	@Test(priority = 0)
	public void Navigate() {

		CallingMethods M = new CallingMethods(driver);
		M.LoginMethods();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_nav_menu").click();

		driver.findElementByXPath("//android.widget.TextView[@text='Users']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Navigate Hamburgare to User");

	}

	public void ReStart() throws InterruptedException, IOException {
		try {
			String text = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
		} catch (Exception e) {

			Thread.sleep(1000);
			driver.quit();
			capabilities();
			Thread.sleep(2000);
			Navigate();
		}

	}

	// FullName
	public void FullName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// ShortName
	public void ShortName(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	// Email
	public void Email(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").clear();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	// MobileNumber
	public void MobileNumber(String text) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").click();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").clear();
		driver.hideKeyboard();
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").sendKeys(text);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	// Gender
	public void Gender(String text, int x) {
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userGender").click();
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		if (x == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (x == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	// Department
	public void Department(String text, int x) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		if (x == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (x == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

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

	// Designation
	public void Designation(String text, int x) {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDesignation").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		if (x == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (x == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	// ReprotingPerson
	public void ReportingPerson(String text, int x) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		if (x == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (x == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

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

	// UserType
	public void UserType(String text, int x) {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userTypeDropDown").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		if (x == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (x == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	// User status
	public void UserStatus(String text, int x) throws InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userStatusDropDown").click();
		M.ScrollByText(text);
		driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (x == 1)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
		else if (x == 2)
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/cancelButton").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

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

	public void DataFillUp(int i, int j) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		Thread.sleep(5000);
		FullName(M.getstring("Automation Test Data", i, 1));

		ShortName(M.getstring("Automation Test Data", i, 2));

		if (j == 0)
			Email(M.getstring("Automation Test Data", i, 4));

		MobileNumber(M.getstring("Automation Test Data", i, 5));

		Gender(M.getstring("Automation Test Data", i, 3), 1);

		Department(M.getstring("Automation Test Data", i, 6), 1);

		Thread.sleep(5000);
		M.ScrollDwon(1);

		Designation(M.getstring("Automation Test Data", i, 7), 1);

		ReportingPerson(M.getstring("Automation Test Data", i, 8), 1);

		UserType(M.getstring("Automation Test Data", i, 9), 1);

		if (j == 1)
			UserStatus(M.getstring("Automation Test Data", i, 10), 1);

	}

	public void Verifydata(int R, int i) throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		Thread.sleep(1000);
		// Full Name
		String FullName = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").getText();
		SA.assertEquals(FullName, M.getstring("Automation Test Data", R, 1), "Full Name Doesn't Match");

		// Short name
		String ShortName = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").getText();
		SA.assertEquals(ShortName, M.getstring("Automation Test Data", R, 2), "Short Name Doesn't Match");

		// Gender
		String Gender = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtGender").getText();
		SA.assertEquals(Gender, M.getstring("Automation Test Data", R, 3), "Gender Doesn't Match");

		// Email
		String Email = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").getText();
		SA.assertEquals(Email, M.getstring("Automation Test Data", R, 4), "Email Doesn't Match");

		// Phone
		String Phone = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").getText();
		SA.assertEquals(Phone, M.getstring("Automation Test Data", R, 5), "Phone Number Doesn't Match");

		Thread.sleep(5000);
		M.ScrollDwon(1);
		
		// Department
		String Department = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
		SA.assertEquals(Department, M.getstring("Automation Test Data", R, 6), "Department Doesn't Match");

		// Designation
		String Designation = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdDesignation").getText();
		SA.assertEquals(Designation, M.getstring("Automation Test Data", R, 7), "Designation Doesn't Match");

		// ReportingPerson
		String ReportingPerson = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
		SA.assertEquals(ReportingPerson, M.getstring("Automation Test Data", R, 8), "ReportingPerson Doesn't Match");

		// User Type
		String UserType = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserType").getText();
		SA.assertEquals(UserType, M.getstring("Automation Test Data", R, 9), "UserType Doesn't Match");

		// User Status!!
		if (i == 1) {
			String UserStatus = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserStatus").getText();
			SA.assertEquals(UserStatus, M.getstring("Automation Test Data", R, 10),
					"UserType value selected from Dropdown After cancel");
		}

		SA.assertAll();

	}

	//Verify Place holder Text
	// @Test(priority = 1)
	public void VerifyPlaceholderText() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Place holder Text Executed!");
		try {
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			Verifydata(65, 0);

			Thread.sleep(5000);
			M.BackFun(1);

			M.ScreenShots("Screenshot/Passed", "VerifyPlaceholderText");
			M.setStrData("As Expected", "Automation Testcase", 211, 6);
			M.setStrData("Pass", "Automation Testcase", 211, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "VerifyPlaceholderText");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 211, 6);
			M.setStrData("Fail", "Automation Testcase", 211, 7);
		}
		ReStart();
	}

	//Verify Disabled Create Button (With Blank Field )
	// @Test(priority = 2)
	public void VerifyCreateButtonDisableWhenFieldBlank() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Create Button Disable When Field Blank Executed!");
		try {
			String str = "";
			int count = 0;
			for (int i = 0; i <= 9; i++) {
				boolean tr;
				String testdata;
				Thread.sleep(1000);
				String text = "Create";
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				// Full Field Blank
				if (i == 0) {
					M.ScrollByText(text);
					tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
					if (tr == true) {
						count++;
						str = str + "All Fields are Blank But Create Button is Enable";

					}
					Thread.sleep(5000);
					M.Scroll(1);
					i++;

				}

				// FullName Blank
				if (i != 1) {
					FullName(M.getstring("Automation Test Data", 43, 1));
				}

				// shortNameBlank
				if (i != 2) {
					ShortName(M.getstring("Automation Test Data", 43, 2));
				}
				// UserGender
				if (i != 3) {
					Gender(M.getstring("Automation Test Data", 43, 3), 1);
				}
				// Email
				if (i != 4) {
					Email(M.getstring("Automation Test Data", 43, 4));
				}

				// Phone Number
				if (i != 5) {
					MobileNumber(M.getstring("Automation Test Data", 43, 5));
				}

				// Department
				if (i != 6) {
					Department(M.getstring("Automation Test Data", 43, 6), 1);
				}

				// Designation
				if (i != 7) {
					Designation(M.getstring("Automation Test Data", 43, 7), 1);
				}
				M.ScrollByText("Create");
				// ReportingPerson
				if (i != 8) {
					ReportingPerson(M.getstring("Automation Test Data", 43, 8), 1);
				}
				// UserType
				if (i != 9) {
					UserType(M.getstring("Automation Test Data", 43, 9), 1);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

				}

				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").isEnabled();
				if (tr == true) {
					System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "Full Name Field is Blank But Create Button is Enable";
					else if (i == 2)
						str = str + "\n" + "Short Name Field is Blank But Create Button is Enable";
					else if (i == 3)
						str = str + "\n" + "Gender Field is Blank But Create Button is Enable";
					else if (i == 4)
						str = str + "\n" + "Email Field is Blank But Create Button is Enable";
					else if (i == 5)
						str = str + "\n" + "Phone Number Field is Blank But Create Button is Enable";
					else if (i == 6)
						str = str + "\n" + "Department Field is Blank But Create Button is Enable";
					else if (i == 7)
						str = str + "\n" + "Designation Field is Blank But Create Button is Enable";
					else if (i == 8)
						str = str + "\n" + "ReportingPerson Field is Blank But Create Button is Enable";
					else if (i == 9)
						str = str + "\n" + "UserType Field is Blank But Create Button is Enable";

				}
				if (i != 10) {
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

			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 235, 6);
			M.setStrData("Pass", "Automation Testcase", 235, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 235, 6);
			M.setStrData("Fail", "Automation Testcase", 235, 7);

		}
		ReStart();

	}

	//Create User With Invalid Values
	// @Test(priority = 3)
	public void CreatebyInvalidUserName() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Create by Invalid User Name Executed!");
		try {
			String str = "";
			int count = 0;
			String title = "";
			Thread.sleep(5000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();

			for (int i = 1; i <= 6; i++) {
				// invalid Name&ShortName
				if (i == 1) {
					DataFillUp(45, 0);

				} else if (i == 2) {
					FullName(M.getstring("Automation Test Data", 46, 3));

					ShortName(M.getstring("Automation Test Data", 46, 4));

					Email(M.getstring("Automation Test Data", 46, 5));

				} else if (i == 3) {
					FullName(M.getstring("Automation Test Data", 46, 1));

					// ShortName(M.getstring("Automation Test Data", 45,2));

					Email(M.getstring("Automation Test Data", 45, 11));

				} else if (i == 4) {
					FullName(M.getstring("Automation Test Data", 46, 1));

					ShortName(M.getstring("Automation Test Data", 46, 4));

					Email(M.getstring("Automation Test Data", 45, 12));

				} else if (i == 5) {
					// FullName(M.getstring("Automation Test Data", 45, 1));

					ShortName(M.getstring("Automation Test Data", 46, 2));

					Email(M.getstring("Automation Test Data", 46, 6));

				} else {
					FullName(M.getstring("Automation Test Data", 46, 3));

					ShortName(M.getstring("Automation Test Data", 46, 2));

					Email(M.getstring("Automation Test Data", 46, 7));

				}

				Thread.sleep(2000);
				M.ScrollByText("Create");

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();

					} catch (Exception e) {
						Thread.sleep(5000);
						count++;
						str = str + "\n" + " After Create A User, User Page Not Found";
						M.BackFun(1);
					}
					if (i != 6) {
						Thread.sleep(5000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Thread.sleep(5000);
						DataFillUp(45, 0);
						Thread.sleep(5000);
						M.Scroll(1);

					}

				} else {

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(5000);
					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Create User']")
								.getText();

						if (i == 4) {
							Thread.sleep(5000);
							M.BackFun(1);
							try {
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							} catch (Exception e) {
								count++;
								str = str + "\n"
										+ "Data doesn't Update & After Press Back Button Warring Message Not Found";
							}
						}
					} catch (Exception e) {
						Thread.sleep(5000);
						count++;
						str = str + "\n" + "After Warring Message, Create User Page Not Found";

						if (i != 6) {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Thread.sleep(5000);
							DataFillUp(45, 0);
						}

					}

					Thread.sleep(5000);
					M.Scroll(1);
				}

			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreatebyInvalidUserName");

			M.setStrData("As Expected", "Automation Testcase", 235, 6);
			M.setStrData("Pass", "Automation Testcase", 235, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "CreatebyInvalidUserName");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 235, 6);
			M.setStrData("Fail", "Automation Testcase", 235, 7);

		}
		ReStart();

	}

	//Email Verification
	// @Test(priority = 4)
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
			DataFillUp(43, 0);
			for (int i = 1; i <= 9; i++) {
				Thread.sleep(5000);
				M.Scroll(1);

				data = M.getstring("Automation Test Data", 47, i);

				// Email
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").clear();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").sendKeys(data);
				driver.hideKeyboard();

				Thread.sleep(1000);
				M.ScrollByText("Create");

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					mass = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					// System.out.println(mass);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Error Message Body Not Found";
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
					str = str + "\n" + data + "- Invalid Email Accept";
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if (i != 9) {
						Thread.sleep(5000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
						DataFillUp(43, 0);
					}

				} else {
					try {
						if (i != 9)
							Assert.assertEquals(mass, M.getstring("Automation Test Data", 55, 3),
									"- Email Verification Message doesn't valid");
						else
							Assert.assertEquals(mass, M.getstring("Automation Test Data", 55, 4),
									"- Email Verification Message doesn't valid");

					} catch (AssertionError e) {
						count++;
						str = str + "\n" + data + e;
					}

					try {
						Assert.assertEquals(title, M.getstring("Automation Test Data", 55, 2),
								"- Email Verification Title doesn't valid");
					} catch (AssertionError e) {
						count++;
						str = str + "\n" + data + e;
					}
					Thread.sleep(100);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					try {
						Thread.sleep(100);
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Create User']")
								.getText();
					} catch (Exception e) {
						count++;
						str = str + "\n" + data
								+ "- After click Ok on Warring message, it doesn't back to the Create user page";
						if (i != 9) {
							Thread.sleep(5000);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
							DataFillUp(43, 0);
						}
					}

					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

			}

			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				// Assert.assertEquals(user,"Users");

			} catch (Exception e) {
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Create User']").getText();
					if (user.contentEquals("Create User")) {
						Thread.sleep(5000);
						M.BackFun(1);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						try {
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							Thread.sleep(1000);
						} catch (Exception y) {
							count++;
							str = str + "\n" + "After press back button warring message not found";
						}

					}

				} catch (Exception z) {
					count++;
					str = str + "\n" + "Some thing is wrrong When email verification execute";
				}
			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "User Email Verification");
			M.setStrData("As Expected", "Automation Testcase", 256, 6);
			M.setStrData("Pass", "Automation Testcase", 256, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "User Email Verification");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 256, 6);
			M.setStrData("Fail", "Automation Testcase", 256, 7);

		}
		ReStart();

	}

	//Mobile Number Verification
	// @Test(priority = 5)
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
			String data = "";
			String mess = "";
			String title = "";
			DataFillUp(48, 0);
			for (int i = 1; i <= 6; i++) {
				Thread.sleep(5000);
				M.Scroll(1);
				int j = i + 1;
				if (i == 2 || i == 3 || i == 4) {
					// Email
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").clear();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail")
							.sendKeys(M.getstring("Automation Test Data", 50, i));
					driver.hideKeyboard();

				}

				// Phone Number
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").clear();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone")
						.sendKeys(M.getstring("Automation Test Data", 49, i));
				driver.hideKeyboard();

				data = M.getstring("Automation Test Data", 49, i);

				Thread.sleep(1000);
				M.ScrollByText("Create");

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					// System.out.println(title);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Title Body Not Found";
				}

				try {
					mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					// System.out.println(mass);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Message Body Not Found";
				}

				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 57, j),
							"- Number Field Verification Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + data + e;
				}

				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 57, k),
							"- Number Field Verification Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + data + e;
				}
				k++;
				if (mess.contentEquals(M.getstring("Automation Test Data", 57, j))) {
					if (i == 2 || i == 3) {
						Thread.sleep(3000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						DataFillUp(48, 0);

					} else {
						try {
							Thread.sleep(100);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Create User']")
									.getText();
						} catch (Exception e) {
							count++;
							str = str + "\n" + data
									+ "- After click Ok on Warring message, it doesn't back to the Create user page";
							if (i != 6) {
								Thread.sleep(5000);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
								DataFillUp(43, 0);
							}
						}
						// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
						// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					}
				} else {
					count++;
					if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
						str = str + "\n" + data + "- Accept invalid Number";
						if (i != 6) {
							Thread.sleep(5000);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
							DataFillUp(43, 0);
						}

					} else {
						str = str + "\n" + data + "- " + mess;
						try {
							Thread.sleep(100);
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Create User']")
									.getText();
						} catch (Exception e) {
							count++;
							str = str + "\n" + data
									+ "- After click Ok on Warring message, it doesn't back to the Create user page";
							if (i != 6) {
								Thread.sleep(5000);
								driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
								DataFillUp(43, 0);
							}
						}

					}

				}

			}

			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				// Assert.assertEquals(user,"Users");

			} catch (Exception e) {
				try {
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Create User']").getText();
					if (user.contentEquals("Create User")) {
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

					}

				} catch (Exception z) {
					count++;
					str = str + "\n" + "Some thing is wrrong When email verification execute";
				}
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "User Email Verification");
			M.setStrData("As Expected", "Automation Testcase", 277, 6);
			M.setStrData("Pass", "Automation Testcase", 277, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "User Email Verification");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 277, 6);
			M.setStrData("Fail", "Automation Testcase", 277, 7);

		}

		ReStart();

	}

	// Dismiss Selected Value From Dropdown
	// @Test(priority = 6)
	public void DismissSelectedValueFromDropdown() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("DismissSelectedValueFromDropdown Executed!");
		SoftAssert SA = new SoftAssert();
		int Report = 0;
		int dept = 0;
		int i = 65;
		int k = 43;
		String testdata = "";

		try {
			Thread.sleep(5000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(5000);

			// Gender
			Gender(M.getstring("Automation Test Data", k, 3), 2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtGender").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 3),
					"Gender value selected from Dropdown After cancel");

			// Department
			Department(M.getstring("Automation Test Data", k, 6), 2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 6),
					"Department value selected from Dropdown After cancel");

			// Department
			ReportingPerson(M.getstring("Automation Test Data", k, 8), 1);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
			M.ScrollByText(M.getstring("Automation Test Data", k, 6));
			driver.findElementByXPath(
					"//android.widget.TextView[@text=\"" + M.getstring("Automation Test Data", k, 6) + "\"]").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

			Thread.sleep(1000);
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");

			for (int j = 0; j < xyz.size(); j++) {
				if (xyz.get(j).getText().contains("Warning")) {
					dept++;
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
					SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 6),
							"Department value selected from Dropdown After click NO");

					break;
				}

			}
			if (dept == 0) {
				testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
				SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 6),
						"Department Warning Message Missing");
			}

			// Designation
			Designation(M.getstring("Automation Test Data", k, 7), 2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdDesignation").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 7),
					"Designation value selected from Dropdown After cancel");

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
			} catch (Exception y) {
				// count++;
				// str=str+"\n"+"After press back button warring message not found";
			}
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(5000);

			M.ScrollByText("Create");

			// ReportingPerson
			ReportingPerson(M.getstring("Automation Test Data", k, 8), 2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 8),
					"Reporting Person value selected from Dropdown After cancel");

			// ReportingPerson
			Department(M.getstring("Automation Test Data", k, 6), 1);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
			M.ScrollByText(M.getstring("Automation Test Data", k, 8));
			driver.findElementByXPath(
					"//android.widget.TextView[@text=\"" + M.getstring("Automation Test Data", k, 8) + "\"]").click();

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			Thread.sleep(1000);
			List<AndroidElement> xyz1 = driver.findElementsByClassName("android.widget.TextView");

			for (int j = 0; j < xyz1.size(); j++) {
				if (xyz1.get(j).getText().contains("Warning")) {
					Report++;
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();

					SA.assertEquals(testdata, testdata, "Reporting Person value selected from Dropdown After click NO");
					break;
				}

			}
			if (Report == 0) {
				testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
				SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 8),
						"Reporting Person Warning Message Missing");
			}

			// UserType
			UserType(M.getstring("Automation Test Data", k, 9), 2);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserType").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 9),
					"UserType value selected from Dropdown After cancel");

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
			} catch (Exception y) {
				// count++;
				// str=str+"\n"+"After press back button warring message not found";
			}

			try {
				SA.assertAll();
			} catch (AssertionError e) {
				throw new Exception(e);
			}

			M.ScreenShots("Screenshot/Passed", "DismissSelectedValueFromDropdown(user)");
			M.setStrData("As Expected", "Automation Testcase", 277, 6);
			M.setStrData("Pass", "Automation Testcase", 277, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "DismissSelectedValueFromDropdown(user)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 277, 6);
			M.setStrData("Fail", "Automation Testcase", 277, 7);

		}

		ReStart();

	}

	// Create New User
	// @Test(priority = 7)
	public void CreateUser() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("CreateUser Executed!");
		int count = 0;
		String str = "";
		String data = "";
		String mess = "";
		String title = "";

		try {
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			DataFillUp(43, 0);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 53, 2),
							"- Confirmation Title doesn't valid");
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
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 53, 3),
							"- Confirmation Message doesn't valid");

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
				Verifydata(43, 0);
			} catch (AssertionError e) {
				count++;
				str = str + "\n" + e;
			}

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnCreate").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 53, 4),"- Successfull Title doesn't valid");
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
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 53, 5),
							"- Successfull Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Message Body Not Found";
			}

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				// Assert.assertEquals(user,"Users");

			} catch (Exception e) {
				try {
					count++;
					str = str + "\n" + "After Create user, User page doesn't found";
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Create User']").getText();
					if (user.contentEquals("Create User")) {
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

					}

				} catch (Exception z) {
					count++;
					str = str + "\n" + "Some thing is wrrong After create user.";
				}
			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Create User");
			M.setStrData("As Expected", "Automation Testcase", 296, 6);
			M.setStrData("Pass", "Automation Testcase", 296, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "Create User");
			String ErMass = e.toString().substring(0, 123);
			M.setStrData(ErMass, "Automation Testcase", 296, 6);
			M.setStrData("Fail", "Automation Testcase", 296, 7);

		}

		ReStart();
	}

	// Verify Created User & Data
	// @Test(priority = 8)
	public void VerifyCreatedUsers() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Created Users Executed!");
		String text="";
		String str="";
		int count=0;
		try {
			Thread.sleep(5000);
			text = M.getstring("Automation Test Data", 43, 1);
			M.ScrollByText(text);
			int pass = 0;
			List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(text)) {
					pass++;
					driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;

				}

			}
			if (pass == 0)
				throw new Exception("New User didn't create");

			Thread.sleep(2000);
			try {
				Verifydata(43, 0);

			}catch(AssertionError e) {
				count++;
				str=str+e;
			}

			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);

			} catch (Exception y) {
				// count++;
				// str=str+"\n"+"After press back button warring message not found";
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "VerifyCreatedUsers");
			M.setStrData("As Expected", "Automation Testcase", 326, 6);
			M.setStrData("Pass", "Automation Testcase", 326, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "VerifyCreatedUsers");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 326, 6);
			M.setStrData("Fail", "Automation Testcase", 326, 7);

		}

		ReStart();

	}

	
	// Verify User Details & Call Feature
	// @Test(priority = 9)
	public void ViewUserDetails() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		String str = "";
		int count = 0;
		System.out.println("View User Details Executed!");
		try {
			String src = M.getstring("Automation Test Data", 43, 1);
			Thread.sleep(5000);
			M.Searching(src);

			String name = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_userName").getText();
			SA.assertEquals(name, M.getstring("Automation Test Data", 43, 1), "Full Name doesn't Match");

			String designation = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_designationName").getText();
			SA.assertEquals(designation, M.getstring("Automation Test Data", 43, 7), "Designation Doesn't Match");

			String department = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_departmentName").getText();
			SA.assertEquals(department, M.getstring("Automation Test Data", 43, 6), "Department Doesn't Match");

			String mobile = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_contactNumber").getText();
			SA.assertEquals(mobile, M.getstring("Automation Test Data", 43, 5), "ContactNumber Doesn't Match");
			
			// click on contactNumber
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_contactNumber").click();
				Thread.sleep(2000);
				String mobile1 = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
				SA.assertEquals(mobile1, M.getstring("Automation Test Data", 43, 5),"Call log ContactNumber Doesn't Match");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Call icon button doesn't work";
			}

			Thread.sleep(5000);
			M.BackFun(2);
			Thread.sleep(5000);
			try {
				String m = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_contactNumber").getText();
			} catch (Exception e) {
				count++;
				str = str + "\n" + "User Page Not Found";
			}
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
			} catch (Exception e) {
				// count++;
				// str=str+"\n"+"Seach Back button doesn't work";
			}

			try {
				SA.assertAll();

			} catch (AssertionError e) {
				str = str + "\n" + e;
			}

			if (count > 0)
				throw new Exception(str);

			M.ScreenShots("Screenshot/Passed", "ViewUserDetails");
			M.setStrData("As Expected", "Automation Testcase", 335, 6);
			M.setStrData("Pass", "Automation Testcase", 335, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "ViewUserDetails");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 335, 6);
			M.setStrData("Fail", "Automation Testcase", 335, 7);

		}
		ReStart();
	}

	// Verify Save Change Button Disable (With Blank Field)
	// @Test (priority = 10)
	public void VerifySaveChangeButtonDisable() throws Exception {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Save Change Button Disable With Blank Field Executed!");
		int count = 0;
		String str = "";

		try {
			String src = M.getstring("Automation Test Data", 43, 1);
			Thread.sleep(5000);
			M.ClickOn(src);
			Thread.sleep(5000);

			for (int i = 1; i <= 3; i++) {
				Thread.sleep(5000);
				M.Scroll(1);
				if (i == 1) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").clear();
					driver.hideKeyboard();
				} else if (i == 2) {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName")
							.setValue(M.getstring("Automation Test Data", 43, 1));
					driver.hideKeyboard();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").clear();
					driver.hideKeyboard();

				} else {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName")
							.setValue(M.getstring("Automation Test Data", 43, 2));
					driver.hideKeyboard();
					Thread.sleep(100);
					M.ScrollByText("Save Changes");
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").clear();
					driver.hideKeyboard();

				}

				Thread.sleep(100);
				M.ScrollByText("Save Changes");
				boolean tr;
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == true) {
					count++;
					if (i == 1)
						str = str + "\n " + "Full Name field Blank but Save Change Button is Enable ";
					else if (i == 2)
						str = str + "\n " + "Short Name field Blank but Save Change Button is Enable ";
					else
						str = str + "\n " + "Mobile field Blank but Save Change Button is Enable ";
				}

			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldVerifyButton");
			M.setStrData("As Expected", "Automation Testcase", 342, 6);
			M.setStrData("Pass", "Automation Testcase", 342, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "BlankFieldVerifyButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 342, 6);
			M.setStrData("Fail", "Automation Testcase", 342, 7);
			ReStart();
		}

	}

	// Verify Save Change Button Disabled/Enabled(Before & After Editing)
	// @Test(priority = 11)
	public void VerifySaveChangeButtonEnabled() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Verify Save Change Button Enabled Executed!");
		try {
			String str = "";
			int count = 0;
			for (int i = 0; i <= 9; i++) {
				boolean tr;
				String testdata;
				Thread.sleep(1000);
				String text = "Save Changes";
				String src = M.getstring("Automation Test Data", 43, 1);
				Thread.sleep(2000);
				M.ClickOn(src);
				Thread.sleep(5000);

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
					FullName(M.getstring("Automation Test Data", 52, 1));
				}

				// shortName Editing
				else if (i == 2) {
					ShortName(M.getstring("Automation Test Data", 52, 2));
				}
				// UserGender Editing
				else if (i == 3) {
					Gender(M.getstring("Automation Test Data", 52, 3), 1);
				}
				// Phone Number Editing
				else if (i == 4) {
					Thread.sleep(1000);
					M.ScrollByText("Save Changes");
					MobileNumber(M.getstring("Automation Test Data", 52, 5));
				}

				// Department Editing
				else if (i == 5) {
					Thread.sleep(1000);
					M.ScrollByText("Save Changes");
					Department(M.getstring("Automation Test Data", 52, 6), 1);
				}

				// Designation Editing
				else if (i == 6) {
					Thread.sleep(1000);
					M.ScrollByText("Save Changes");
					Designation(M.getstring("Automation Test Data", 52, 7), 1);

				}

				// ReportingPerson Editing
				else if (i == 7) {
					Thread.sleep(1000);
					M.ScrollByText("Save Changes");
					ReportingPerson(M.getstring("Automation Test Data", 52, 8), 1);
				}

				// UserType Editing
				else if (i == 8) {
					Thread.sleep(1000);
					M.ScrollByText("Save Changes");
					UserType(M.getstring("Automation Test Data", 52, 9), 1);
				}
				// Active/Inactive Editing
				else if (i == 9) {
					Thread.sleep(1000);
					M.ScrollByText("Save Changes");
					UserStatus(M.getstring("Automation Test Data", 52, 10), 1);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

				}

				Thread.sleep(1000);
				M.ScrollByText("Save Changes");
				tr = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").isEnabled();
				if (tr == false) {
					System.out.println(i);
					count++;
					if (i == 1)
						str = str + "\n" + "After modify Full Name Save Changes Button is Disable";
					else if (i == 2)
						str = str + "\n" + "After modify Short Name Save Changes Button is Disable";
					else if (i == 3)
						str = str + "\n" + "After modify Gender Save Changes Button is Disable";
					else if (i == 4)
						str = str + "\n" + "After modify Phone Number Save Changes Button is Disable";
					else if (i == 5)
						str = str + "\n" + "After modify Department Save Changes Button is Disable";
					else if (i == 6)
						str = str + "\n" + "After modify Designation Save Changes Button is Disable";
					else if (i == 7)
						str = str + "\n" + "After modify ReportingPerson Save Changes Button is Disable";
					else if (i == 8)
						str = str + "\n" + "After modify UserType Save Changes Button is Disable";
					else if (i == 9)
						str = str + "\n" + "After modify Active/inactive Save Changes Button is Disable";

				}
				if (i != 10) {
					Thread.sleep(5000);
					M.BackFun(1);
					Thread.sleep(100);
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					} catch (Exception e) {
						// System.out.println("Warning Message Not Found");
					}

				}

			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "BlankFieldDisableCreateButton");
			M.setStrData("As Expected", "Automation Testcase", 235, 6);
			M.setStrData("Pass", "Automation Testcase", 235, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "BlankFieldDisableCreateButton");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 235, 6);
			M.setStrData("Fail", "Automation Testcase", 235, 7);

		}
		ReStart();

	}

	// Dismiss Selected Value From Dropdown (User Profile Edit)
	// @Test(priority = 12)
	public void DismissSelectedValueFromDropdownEdit() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Dismiss Selected Value From Dropdown Profile Edit Executed!");
		SoftAssert SA = new SoftAssert();
		int Report = 0;
		int Status = 0;
		int dept = 0;
		int i = 43;
		int k = 52;
		String testdata = "";

		try {

			String src = M.getstring("Automation Test Data", 43, 1);
			Thread.sleep(2000);
			M.ClickOn(src);

			Thread.sleep(5000);
			// Gender
			Gender(M.getstring("Automation Test Data", k, 3), 2);
			Thread.sleep(1000);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtGender").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 3),
					"Gender value selected from Dropdown After cancel");

			Thread.sleep(5000);
			M.ScrollByText("Save Changes");

			Thread.sleep(2000);
			// Department
			Department(M.getstring("Automation Test Data", k, 6), 2);
			Thread.sleep(1000);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 6),
					"Department value selected from Dropdown After cancel");

			Thread.sleep(2000);
			// Department
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
			M.ScrollByText(M.getstring("Automation Test Data", k, 11));
			driver.findElementByXPath(
					"//android.widget.TextView[@text=\"" + M.getstring("Automation Test Data", k, 11) + "\"]").click();
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

			Thread.sleep(1000);
			List<AndroidElement> xyz0 = driver.findElementsByClassName("android.widget.TextView");

			for (int j = 0; j < xyz0.size(); j++) {
				if (xyz0.get(j).getText().contains("Warning")) {
					dept++;
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					Thread.sleep(1000);
					String testdata1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment")
							.getText();
					SA.assertEquals(testdata1, testdata, "Department value selected from Dropdown After click NO");
					break;
				}

			}
			if (dept == 0) {
				testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtDepartment").getText();
				SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 6),
						"Department Warning Message Missing");
			}

			Thread.sleep(2000);
			// Designation
			Designation(M.getstring("Automation Test Data", k, 7), 2);
			Thread.sleep(1000);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/etdDesignation").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 7),
					"Designation value selected from Dropdown After cancel");

			Thread.sleep(2000);

			// ReportingPerson
			ReportingPerson(M.getstring("Automation Test Data", k, 8), 2);
			Thread.sleep(1000);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 8),
					"Reporting Person value selected from Dropdown After cancel");

			Thread.sleep(2000);
			// ReportingPerson

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
			M.ScrollByText(M.getstring("Automation Test Data", k, 12));
			driver.findElementByXPath(
					"//android.widget.TextView[@text=\"" + M.getstring("Automation Test Data", k, 12) + "\"]").click();

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			Thread.sleep(1000);
			List<AndroidElement> xyz1 = driver.findElementsByClassName("android.widget.TextView");

			for (int j = 0; j < xyz1.size(); j++) {
				if (xyz1.get(j).getText().contains("Warning")) {
					Report++;
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					Thread.sleep(1000);
					String testdata1 = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson")
							.getText();

					SA.assertEquals(testdata1, testdata,
							"Reporting Person value selected from Dropdown After click NO");
					break;
				}

			}
			if (Report == 0) {
				testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtReportingPerson").getText();
				SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 8),
						"Reporting Person Warning Message Missing");
			}

			Thread.sleep(2000);
			// UserType
			UserType(M.getstring("Automation Test Data", k, 9), 2);
			Thread.sleep(1000);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserType").getText();
			SA.assertEquals(testdata, M.getstring("Automation Test Data", i, 9),
					"UserType value selected from Dropdown After cancel");

			Thread.sleep(2000);

			// User Status!!
			UserStatus(M.getstring("Automation Test Data", k, 10), 2);
			Thread.sleep(1000);
			testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserStatus").getText();
			SA.assertEquals(testdata, "Active", "UserStatus value selected from Dropdown After cancel");

			if (testdata.contains("Inactive"))
				UserStatus("Active", 1);

			Thread.sleep(2000);
			// User Status
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userStatusDropDown").click();
			M.ScrollByText(M.getstring("Automation Test Data", k, 10));
			driver.findElementByXPath(
					"//android.widget.TextView[@text=\"" + M.getstring("Automation Test Data", k, 10) + "\"]").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			Thread.sleep(1000);
			List<AndroidElement> xyz2 = driver.findElementsByClassName("android.widget.TextView");
			for (int j = 0; j < xyz2.size(); j++) {
				if (xyz2.get(j).getText().contains("Warning")) {
					Status++;
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					Thread.sleep(1000);
					testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserStatus").getText();
					SA.assertEquals(testdata, "Active", "UserType value selected from Dropdown After click NO");
					break;

				}

			}

			if (Status == 0) {
				testdata = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserStatus").getText();
				SA.assertEquals(testdata, "Active", "UserType Warning Message Missing");
			}

			try {
				Thread.sleep(5000);
				M.BackFun(1);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				Thread.sleep(1000);
			} catch (Exception y) {
				// count++;
				// str=str+"\n"+"After press back button warring message not found";
			}

			try {
				SA.assertAll();
			} catch (AssertionError e) {
				throw new Exception(e);
			}

			M.ScreenShots("Screenshot/Passed", "DismissSelectedValueFromDropdown(UserEdit)");
			M.setStrData("As Expected", "Automation Testcase", 277, 6);
			M.setStrData("Pass", "Automation Testcase", 277, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "DismissSelectedValueFromDropdown(userEdit)");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 277, 6);
			M.setStrData("Fail", "Automation Testcase", 277, 7);

		}

		ReStart();

	}

	// Update Existing User Info
	// @Test(priority = 13)
	public void UpdateExistingUserInfo() throws InterruptedException, IOException {

		CallingMethods M = new CallingMethods(driver);
		System.out.println("Update Existing User Info Executed!");
		SoftAssert SA = new SoftAssert();
		String testdata = "";
		int i = 52;
		int count = 0;
		String str = "";
		String data = "";
		String mess = "";
		String title = "";

		try {
			String src = M.getstring("Automation Test Data", 43, 1);
			Thread.sleep(2000);
			M.ClickOn(src);

			DataFillUp(i, 2);

			// User Status
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userStatusDropDown").click();
			driver.findElementByXPath(
					"//android.widget.TextView[@text=\"" + M.getstring("Automation Test Data", i, 10) + "\"]").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			// User Status title check
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 59, 2),
							"User Status Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "User Status Title Body Not Found";
			}

			// User Status Message check
			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 59, 3),
							"User Status Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "User Status Message Body Not Found";
			}

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Confirmation Title doesn't valid
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 53, 7),
							"- Confirmation Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Confirmation Title Body Not Found";
			}

			// Confirmation Message doesn't valid
			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 53, 6),
							"- Confirmation Message doesn't valid");

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

			// verify User Detail page After decline Save change.
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']").getText();

				Thread.sleep(5000);
				M.Scroll(1);
				try {
					Verifydata(i, 1);

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + "After decline save change..." + e;
					Thread.sleep(5000);
					M.Scroll(1);
					DataFillUp(i, 1);
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "User Detail Page Not Found After decline Save change.";
				str = str + "\n" + "Verification can not do After decline Save change.";
				try {
					M.ClickOn(src);
					try {
						Verifydata(i, 1);
						count++;
						str = str + "\n"
								+ "Data should not be same After if it come to user page then go to the user details page.";
						Thread.sleep(5000);
						M.Scroll(1);
						DataFillUp(i, 1);

					} catch (AssertionError x) {
						// pass
					}
				} catch (Exception y) {
					str = str + "\n" + "Apps may be crush After decline Save change.";
					throw new Exception(str);
				}

			}

			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				str = str + "\n" + "There is No message Body Found After click save change";
				throw new Exception(str);
			}

			// Successful Title Body
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 53, 4),
							"- Successfull Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Title Body Not Found";
			}

			// Successful Message Body
			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 53, 8),
							"- Successfull Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Message Body Not Found";
			}

			try {
				Thread.sleep(100);
				String user = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']").getText();
				// Assert.assertEquals(user,"Users");
				if (user.contentEquals("User Detail")) {
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

				}

			} catch (Exception e) {
				try {
					count++;
					str = str + "\n" + "User Detail Page Not Found After Save change.";
					Thread.sleep(100);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();

				} catch (Exception z) {
					str = str + "\n" + "Apps may be crush After Save change.";
					throw new Exception(str);
				}
			}

			if (count > 0) {
				throw new Exception(str);
			}
			M.ScreenShots("Screenshot/Passed", "Update Existing User Info");
			M.setStrData("As Expected", "Automation Testcase", 342, 6);
			M.setStrData("Pass", "Automation Testcase", 342, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Update Existing User Info");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 342, 6);
			M.setStrData("Fail", "Automation Testcase", 342, 7);

		}

		ReStart();

	}

	//Verify Updated User Info
	// @Test(priority = 14)
	public void VerifyAfterUpdateInfo() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Verify Updated User Info Executed!");
		int i = 52;
		try {
			String src = M.getstring("Automation Test Data", i, 1);
			Thread.sleep(3000);
			try {
				M.ClickOn(src);
			} catch (Exception e) {
				throw new Exception("Use info does not update!!");
			}
			Thread.sleep(2000);

			Verifydata(i, 1);

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

			M.ScreenShots("Screenshot/Passed", "VerifyAfterEdit");
			M.setStrData("As Expected", "Automation Testcase", 361, 6);
			M.setStrData("Pass", "Automation Testcase", 361, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "VerifyAfterEdit");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 361, 6);
			M.setStrData("Fail", "Automation Testcase", 361, 7);

		}
		ReStart();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	//Update User Info With Invalid Values
	// @Test(priority = 15)
	public void UpdateUserInfoWithInvalidValues() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Update User Info With Invalid Values Executed!");

		String str = "";
		String title = "";
		int count = 0;
		int j = 45;
		int k = 1;

		String src = M.getstring("Automation Test Data", 52, 1);
		Thread.sleep(3000);
		M.ClickOn(src);
		Thread.sleep(2000);

		try {
			for (int i = 1; i <= 6; i++) {
				// Special Character
				if (i == 1) {
					FullName(M.getstring("Automation Test Data", 45, 1));

					ShortName(M.getstring("Automation Test Data", 45, 2));

				}
				// Numeric Character
				else if (i == 2) {
					FullName(M.getstring("Automation Test Data", 46, 3));

					ShortName(M.getstring("Automation Test Data", 46, 4));
					j = 46;
					k = 3;

				}
				// Name Special Character
				else if (i == 3) {
					FullName(M.getstring("Automation Test Data", 45, 1));

					ShortName(M.getstring("Automation Test Data", 46, 2));
					j = 45;
					k = 1;

				}
				// Name Numeric Character
				else if (i == 4) {
					FullName(M.getstring("Automation Test Data", 46, 3));

					ShortName(M.getstring("Automation Test Data", 46, 2));
					j = 46;
					k = 3;
				}

				// Short Name Special Character
				else if (i == 5) {
					FullName(M.getstring("Automation Test Data", 52, 1));

					ShortName(M.getstring("Automation Test Data", 45, 2));
					k = 1;
					j = 52;

				}
				// Short Name Numeric Character
				else {
					FullName(M.getstring("Automation Test Data", 52, 1));

					ShortName(M.getstring("Automation Test Data", 46, 4));

				}

				Thread.sleep(2000);
				M.ScrollByText("Save Changes");

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();

				if (title.contentEquals(M.getstring("Automation Test Data", 53, 4))) {
					count++;
					if (i == 1)
						str = str + "\n" + "Special Char Accept in FullName & ShortName";
					else if (i == 2)
						str = str + "\n" + "Numeric Char Accept in FullName & ShortName";
					else if (i == 3)
						str = str + "\n" + "Invalid Char FullName Accept";
					else if (i == 4)
						str = str + "\n" + "Invalid Numeric FullName Accept";
					else if (i == 5)
						str = str + "\n" + "Invalid Char ShortName Accept";
					else
						str = str + "\n" + "Invalid Numeric ShortName Accept";

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					try {

						String user = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']")
								.getText();
						Thread.sleep(5000);
						M.Scroll(1);
						if (i == 6) {
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
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + " After Update User, User Detail Page Not Found";
						Thread.sleep(5000);
						try {
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']")
									.getText();

							src = M.getstring("Automation Test Data", j, k);
							Thread.sleep(3000);
							if (i != 6)
								M.ClickOn(src);
							Thread.sleep(2000);
						} catch (Exception x) {
							str = str + "\n" + i + "- Apps may be crush After Save change.";
							throw new Exception(str);
						}

					}

				} else {

					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(5000);
					// driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']")
								.getText();

						Thread.sleep(5000);
						M.Scroll(1);
						if (i == 6) {
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
						}

					} catch (Exception e) {
						count++;
						str = str + "\n" + " After Warrning to Update, User Detail Page Not Found";
						Thread.sleep(5000);
						try {
							String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']")
									.getText();

							src = M.getstring("Automation Test Data", j, k);
							Thread.sleep(3000);
							if (i != 6)
								M.ClickOn(src);
							Thread.sleep(2000);
						} catch (Exception x) {
							str = str + "\n" + i + "- Apps may be crush After Save change.";
							throw new Exception(str);
						}

					}

				}

			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "EditByInvalidUserName");

			M.setStrData("As Expected", "Automation Testcase", 370, 6);
			M.setStrData("Pass", "Automation Testcase", 370, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "EditByInvalidUserName");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 370, 6);
			M.setStrData("Fail", "Automation Testcase", 370, 7);

		}
		ReStart();

	}

	//Mobile Number Verification (User Info)
	//@Test(priority = 16)
	public void MobileNumberVerifyInEditField() throws IOException, InterruptedException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Mobile Number Verification (User Info) Executed!");

		try {

			int count = 0;
			String str = "";
			int k = 8;
			String data = "";
			String mess = "";
			String title = "";

			String src = M.getstring("Automation Test Data", 52, 1);
			Thread.sleep(3000);
			M.ClickOn(src);
			Thread.sleep(2000);
			M.ScrollByText("Save Changes");
			for (int i = 1; i <= 6; i++) {
				int j = i + 1;

				// Phone Number
				MobileNumber(M.getstring("Automation Test Data", 49, i));

				data = M.getstring("Automation Test Data", 49, i);

				Thread.sleep(1000);
				M.ScrollByText("Save Changes");

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/btnSaveChanges").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					// System.out.println(title);
					try {
						Assert.assertEquals(title, M.getstring("Automation Test Data", 58, k),
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
					try {
						Assert.assertEquals(mess, M.getstring("Automation Test Data", 58, j),
								"- Number Field Verification Message doesn't valid");
						// System.out.println(M.getstring("Automation Test Data", 58, j));

					} catch (AssertionError e) {
						count++;
						str = str + "\n" + data + e;
						if (mess.contentEquals(M.getstring("Automation Test Data", 58, 3))) {
							str = str + "\n" + data + "- Accept invalid Number";

						} else {
							str = str + "\n" + data + "- " + mess;
						}

					}
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				} catch (Exception e) {
					count++;
					str = str + "\n" + i + "Message Body Not Found";
				}
				k++;
				try {
					// Thread.sleep(5000);
					String user = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']").getText();

					if (i == 6) {
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
					}

				} catch (Exception e) {
					count++;
					str = str + "\n" + " After Update, User Detail Page Not Found";
					Thread.sleep(500);
					try {
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();

						Thread.sleep(3000);
						if (i != 6)
							M.ClickOn(src);
						Thread.sleep(2000);
					} catch (Exception x) {
						str = str + "\n" + i + "- Apps may be crush After Save change.";
						throw new Exception(str);
					}

				}

			}

			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "MobileVerificationByEdit");
			M.setStrData("As Expected", "Automation Testcase", 379, 6);
			M.setStrData("Pass", "Automation Testcase", 379, 7);

		} catch (Exception e) {

			M.ScreenShots("Screenshot/Failed", "MobileVerificationByEdit");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 379, 6);
			M.setStrData("Fail", "Automation Testcase", 379, 7);

		}

	}
	
	//MenuPermission
	// @Test(priority = 17)
	public void MenuPermission() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Menu Permission Executed!");
		int count = 0;
		String str = "";

		try {
			String src = M.getstring("Automation Test Data", 52, 1);
			Thread.sleep(3000);
			M.ClickOn(src);
			Thread.sleep(2000);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_menuInfo").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			M.ScrollDwon(3);
			Thread.sleep(5000);
			M.BackFun(1);

			M.ScreenShots("Screenshot/Passed", "MenuPermission");
			M.setStrData("As Expected", "Automation Testcase", 397, 6);
			M.setStrData("Pass", "Automation Testcase", 397, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "MenuPermission");
			String ErMass = e.toString().substring(0, 123);
			M.setStrData(ErMass, "Automation Testcase", 397, 6);
			M.setStrData("Fail", "Automation Testcase", 397, 7);
		}
		ReStart();

	}

	//LibraryPermission
	// @Test(priority = 18)
	public void LibraryPermission() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("LibraryPermission Executed!");
		try {
			String src = M.getstring("Automation Test Data", 52, 1);
			Thread.sleep(3000);
			M.ClickOn(src);
			Thread.sleep(2000);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/nav_libraryInfo").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			M.ScrollDwon(5);
			Thread.sleep(5000);
			M.BackFun(1);

			M.ScreenShots("Screenshot/Passed", "LibraryPermission");
			M.setStrData("As Expected", "Automation Testcase", 406, 6);
			M.setStrData("Pass", "Automation Testcase", 406, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "LibraryPermission");
			String ErMass = e.toString().substring(0, 123);
			M.setStrData(ErMass, "Automation Testcase", 406, 6);
			M.setStrData("Fail", "Automation Testcase", 406, 7);
			try {
				String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				Assert.assertEquals(user, "Users");
			} catch (Exception x) {
				Thread.sleep(1000);
				driver.quit();
				capabilities();
				Thread.sleep(2000);
				Navigate();

			}

		}

	}
     
	//DeleteUser
	//@Test(priority = 19)
	public void DeleteUser() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Delete User Executed!");
		try {
			String title = "";
			String mess = "";
			String str = "Yunus Nahid";
			int count = 0;
			Thread.sleep(2000);
			M.Searching(str);
		
			Thread.sleep(2000);
			M.SwipBytext(str);
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_deleteMain").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Confirmation Title
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();

				try {
					Assert.assertEquals(title, "Warning", "- Confirmation Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Title Body Not Found";
			}
			
			//Confirmation Message
			try {
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				String messtext = "Are you sure you want to delete " + str + " ? This cannot be undone.";
				try {
					Assert.assertEquals(mess, messtext, "- Confirmation Message doesn't valid");
					// System.out.println(M.getstring("Automation Test Data", 58, j));

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;

				}

				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Confirmation Message Body Not Found";
			}
			
			Thread.sleep(2000);
			try {
			M.SwipBytext(str);
			}catch (Exception e) {
				
			}
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_deleteMain").click();
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
			try {
			M.ScrollByText(str);
			}catch (Exception e) {
				
			}
			
			List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView[@text=\"" + str + "\"]");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(str)) {
					str = str + "\n" + "User didn't Delete Yet";
					throw new Exception(str);
					
				}

			}
			

			if (count > 0) {
				throw new Exception(str);
			}

			
			M.ScreenShots("Screenshot/Passed", "Delete User");
			M.setStrData("As Expected", "Automation Testcase", 415, 6);
			M.setStrData("Pass", "Automation Testcase", 415, 7);

		
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Delete User");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 415, 6);
			M.setStrData("Fail", "Automation Testcase", 415, 7);

		}

	}

	//SearchUser
	//@Test(priority = 20)
	public void SearchUser() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		System.out.println("Search User Executed!");
		
		SoftAssert SA = new SoftAssert();
		int match=0;
		int k=0;
		int user=0;
		int bar=0;
		String str="";
		String data="";
		
		try {
			for(int j=1;j<=7;j++)
			{
				int count=0;
				int cross=0;
				
				data = M.getstring("Automation Test Data", 66, j);
				List<AndroidElement> xyz0 = driver.findElementsByXPath("//android.widget.TextView");
				List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView[@text=\"" + data + "\"]");
				for (int i = 0; i < xyz.size(); i++) {
					if (xyz.get(i).getText().contains(data)) {
						count++;						
					}
				}
				//System.out.println(count);
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
				//System.out.println(cross);
				
				if(count!=cross)
				{
					match++;
					str=str + "\n" +data+ "- This search result does not match";
				}
				
				if (j == 1) {
					
					//call log
					try {
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/txt_contactNumber").click();
						Thread.sleep(2000);
						String mobile1 = driver.findElementById("com.samsung.android.dialer:id/digits").getText();
						Thread.sleep(5000);
						M.BackFun(2);
						Thread.sleep(5000);
						driver.hideKeyboard();
						
						List<AndroidElement> xyz5 = driver.findElementsByXPath("//android.widget.TextView");
						if(xyz4.size()==xyz5.size())
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

					
					
					//Cross bar
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
								str = str + "\n" + "Search bar place holder doesn't match & search cross bar does't work";
							}

						} catch (Exception e) {

						}
						Thread.sleep(1000);
						List<AndroidElement> xyz3 = driver.findElementsByXPath("//android.widget.TextView");
						if(xyz0.size()==xyz3.size())
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

				//back button in search field
				Thread.sleep(2000);
				try {
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
					Thread.sleep(2000);

					if (j == 1) {
						try {
							String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
							//System.out.println("back button ok");
						} catch (Exception e) {
							match++;
							str = str + "\n" + "After Click back button search bar doesn't remove";

						}

						List<AndroidElement> xyz3 = driver.findElementsByXPath("//android.widget.TextView");
						if(xyz0.size()==xyz3.size())
							System.out.println("back button data ok");
						else {
							match++;
							str = str + "\n" + "After click back button from search bar user list does not same;";
						}


					}
					
					
					
				}catch (Exception e) {
					if(k==0)
					{
						k++;
						match++;
						str=str + "\n" + "Search Back Button didn't find";
						
					}
					
					
				}
				
				
			}
			
			if(match>0)
				throw new Exception(str);
			
			M.ScreenShots("Screenshot/Passed", "Search User");

			M.setStrData("As Expected", "Automation Testcase", 423, 6);
			M.setStrData("Pass", "Automation Testcase", 423, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "Search User");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 423, 6);
			M.setStrData("Fail", "Automation Testcase", 423, 7);

		}

	}

	//Dismiss Unsaved Data (Default & All fields together)
	 //@Test(priority = 21)
	public void DismissUnsavedDataDefaultAllfieldstogether() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (Default & All fields together) Executed!");
		int count = 0;
		int error = 0;
		String str = "";
		String title="";
		String mess="";
		try {
			
			//Default dismiss
			Thread.sleep(2000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			//Use page
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "User page not found after back without input";

			}
			
			
			//After data input
			
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(5000);
			DataFillUp(43, 0);
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			//check title & Message
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 63, 5),"- Warrning Title doesn't valid");
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
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 63, 2),"- Warrning Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Warrning Message Body Not Found";
				//throw new Exception(str);
			}
			
			Thread.sleep(2000);
			//Create User page
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Create User']").getText();
				Thread.sleep(5000);
				M.Scroll(1);
				try {
					Verifydata(43, 0);
				}catch (Exception e) {
					str = str + "\n" +e;
				}
				
				
			} catch (Exception e) {
				//Use page
				count++;
				try {
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
					str = str + "\n" + "No warring message found & back to user page";
					
					try {
						M.ScrollByText(M.getstring("Automation Test Data", 43, 1));
					}catch (Exception y) {
						;
					}
					
					List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
					for (int j = 0; j < xyz.size(); j++) {
						if (xyz.get(j).getText().contains(M.getstring("Automation Test Data", 43, 1))) {
							count++;
							str = str + "\n" + "New user create After Unsave date.";
							break;
							
						} 

					}
					
				} catch (Exception x) {
					str = str + "\n" + "Apps May be Crush";
					
					throw new Exception(str);
				}
				

			}
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			}catch (Exception e) {
				
			}
			
			Thread.sleep(3000);
			//Use page
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				//System.out.println("back button ok");
				try {
					M.ScrollByText(M.getstring("Automation Test Data", 43, 1));
				}catch (Exception e) {
					
				}
				
				List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
				for (int j = 0; j < xyz.size(); j++) {
					if (xyz.get(j).getText().contains(M.getstring("Automation Test Data", 43, 1))) {
						count++;
						str = str + "\n" + "New user create After Unsave date.";
						break;
						
					} 

				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "User page not found after back input";

			}
			

			
			if (error > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreateDataDismiss");
			M.setStrData("As Expected", "Automation Testcase", 430, 6);
			M.setStrData("Pass", "Automation Testcase", 430, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CreateDataDismiss");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 430, 6);
			M.setStrData("Fail", "Automation Testcase", 430, 7);

		}
		ReStart();

	}
	 
	//Dismiss Unsaved Data (For Each Field)
	//@Test(priority = 22)
	public void DismissUnsavedDataForEachField() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int error = 0;
		String str = "";
		String title="";
		String mess="";
		
		try {
			for(int i=1;i<=9;i++)
			{
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				
				if(i==1)
					FullName(M.getstring("Automation Test Data", 43, 1));
				else if(i==2)
					ShortName(M.getstring("Automation Test Data", 43, 2));
				else if(i==3)
					Email(M.getstring("Automation Test Data", 43, 4));
				else if(i==4)
					MobileNumber(M.getstring("Automation Test Data", 43, 5));
				else if(i==5)
					Gender(M.getstring("Automation Test Data", 43, 3),1);
				else if(i==6)
					Department(M.getstring("Automation Test Data", 43, 6),1);
				else if(i==7)
					Designation(M.getstring("Automation Test Data", 43, 7),1);
				else if(i==8) {
					M.ScrollByText("Create");
					ReportingPerson(M.getstring("Automation Test Data", 43, 8),1);
				}
					
				else {
					M.ScrollByText("Create");
					UserType(M.getstring("Automation Test Data", 43, 9),1);
				}
					
				
				
				
				//Back Button!!
				try {
					Thread.sleep(2000);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				}catch (Exception e) {
					count++;
					str = str + "\n" + "Back button doesn't found";
					Thread.sleep(5000);
					M.BackFun(1);

				}
				
				//check title & Message
				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					// System.out.println(title);
					try {
						Assert.assertEquals(title, M.getstring("Automation Test Data", 63, 5),"- Warrning Title doesn't valid");
					} catch (AssertionError e) {
						count++;
						str = str + "\n" + e;
					}

				} catch (Exception e) {
					count++;
					str = str + "\n" +i+ "Warrning Title Body Not Found";
				}

				try {
					mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					try {
						Assert.assertEquals(mess, M.getstring("Automation Test Data", 63, 2),"- Warrning Message doesn't valid");

					} catch (AssertionError e) {
						count++;
						str = str + "\n" +i+e;
					}
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				} catch (Exception e) {
					count++;
					str = str + "\n" +i+"Warrning Message Body Not Found";
					//throw new Exception(str);
				}
				
				Thread.sleep(2000);
				//Create User page
				try {
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Create User']").getText();
					
					if(i==1)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtFullName").clear();
					else if(i==2)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtShortName").clear();
					else if(i==3)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtUserEmail").clear();
					else if(i==4)
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/edtPhone").clear();
					else
						;
					
					//Back Button!!
					try {
						Thread.sleep(2000);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
						
					}catch (Exception e) {
						count++;
						str = str + "\n" + "Back button doesn't found";
						Thread.sleep(5000);
						M.BackFun(1);

					}
					
					if(i>4)
					{
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						}catch (Exception e) {
							count++;
							str = str + "\n" + "Warrning message not found for click on Yes button";

						}
						
						
					}
					
					//Use page  
					try {
						user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
						//System.out.println("back button ok");
						//M.SwipBytext(M.getstring("Automation Test Data", 43, 1));
					} catch (Exception e) {
						count++;
						if(i<=4)
							str = str + "\n" + "User page not found after back without input";
						else
							str = str + "\n" + "User page not found after unsave warrning message yes";

					}
					
					
					
				} catch (Exception e) {
					//Use page
					
					count++;
					try {
						String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
						str = str + "\n" + "Warring message not found & back to user page";
						//throw new Exception(str);
					} catch (Exception x) {
						str = str + "\n" + "Apps May be crush....";
					}
					
					
					

				}
				
				
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreateDataDismiss");
			M.setStrData("As Expected", "Automation Testcase", 430, 6);
			M.setStrData("Pass", "Automation Testcase", 430, 7);	
			
			
		}catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CreateDataDismiss");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 430, 6);
			M.setStrData("Fail", "Automation Testcase", 430, 7);

		}
		ReStart();
		
	}
	
	
	//Dismiss Unsaved Data In Update User (Default & All Fields)
	//@Test(priority = 23)
	public void DismissUnsavedDataInUpdateUserDefaultAllfields() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data In Update User (Default & All Fields) Executed!");
		int count = 0;
		int error = 0;
		int error1 = 0;
		String str = "";
		String title="";
		String mess="";
		String ser=M.getstring("Automation Test Data", 64, 1);
		try {
			
			//Default dismiss
			Thread.sleep(5000);
			M.ClickOn(ser);
		
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}

			
			Thread.sleep(2000);
			//Use page
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				//System.out.println("back button ok");
			} catch (Exception e) {
				count++;
				str = str + "\n" + "User page not found after back without input";

			}
			
			
			//After data input
			
			Thread.sleep(3000);
			M.ClickOn(ser);
			
			Thread.sleep(5000);
			DataFillUp(43, 1);
			
			//Back Button!!
			try {
				Thread.sleep(2000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}
			
			//check title & Message
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, M.getstring("Automation Test Data", 63, 5),"- Warrning Title doesn't valid");
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
				try {
					Assert.assertEquals(mess, M.getstring("Automation Test Data", 63, 2),"- Warrning Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/noButton").click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Warrning Message Body Not Found";
				//throw new Exception(str);
			}
			
			Thread.sleep(2000);
			
			//User Detail page
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']").getText();
				Thread.sleep(5000);
				M.Scroll(1);
				try {
					Verifydata(64, 1);
				}catch (Exception e) {
					str = str + "\n" + e;
				}
				
				
			} catch (Exception e) {
				//Use page
				count++;
				try {
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
					str = str + "\n" + "No warring message found & back to user page";
					Thread.sleep(3000);
					M.ClickOn(ser);
					Thread.sleep(3000);
					try {
						Verifydata(64, 1);
						Thread.sleep(3000);
						M.BackFun(1);
					}catch (Exception x) {
						str = str + "\n" + x;
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
				str = str + "\n" + "Back button doesn't found";
				Thread.sleep(5000);
				M.BackFun(1);

			}
			Thread.sleep(2000);
			try {
				Thread.sleep(1000);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
			}catch (Exception e) {
				count++;
				str = str + "\n" + "Message body Not found after back with input";
			}
			
			Thread.sleep(3000);
			//Use page
			
			try {
				String user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
				//System.out.println("back button ok");
				
				M.ClickOn(ser);
				Thread.sleep(3000);
				Verifydata(64, 1);
				
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "User page not found after back with input";

			}
			
			
			
			if (error > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreateDataDismiss");
			M.setStrData("As Expected", "Automation Testcase", 430, 6);
			M.setStrData("Pass", "Automation Testcase", 430, 7);		

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CreateDataDismiss");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 430, 6);
			M.setStrData("Fail", "Automation Testcase", 430, 7);

		}
		ReStart();

	}
	 
	//Dismiss Unsaved Data In Update User (For Each Field)
	//@Test(priority = 24)
	public void DismissUnsavedDataForEach() throws InterruptedException, IOException {
		CallingMethods M = new CallingMethods(driver);
		SoftAssert SA = new SoftAssert();
		System.out.println("Dismiss Unsaved Data (For Each Field) Executed!");
		int count = 0;
		int j = 52;
		int error = 0;
		int t = 0;
		String str = "";
		String title="";
		String mess="";
		String ser=M.getstring("Automation Test Data", 64, 1);

		try {
			for (int i = 1; i <= 9; i++) {
				Thread.sleep(5000);
				M.ClickOn(ser);
				Thread.sleep(3000);

				if (i == 1)
					FullName(M.getstring("Automation Test Data", j, i));
				else if (i == 2)
					ShortName(M.getstring("Automation Test Data", j, i));
				else if (i == 3)
					Gender(M.getstring("Automation Test Data", j, i), 1);
				else if (i == 4)
					MobileNumber(M.getstring("Automation Test Data", j, 5));
				else if (i == 5) {
					M.ScrollByText("Save Changes");
					Department(M.getstring("Automation Test Data", j, 6), 1);
				} else if (i == 6) {
					M.ScrollByText("Save Changes");
					Designation(M.getstring("Automation Test Data", j, 7), 1);
				} else if (i == 7) {
					M.ScrollByText("Save Changes");
					ReportingPerson(M.getstring("Automation Test Data", j, 8), 1);
				}

				else if (i == 8) {
					M.ScrollByText("Save Changes");
					UserType(M.getstring("Automation Test Data", j, 9), 1);
				} else {
					M.ScrollByText("Save Changes");
					UserStatus(M.getstring("Automation Test Data", j, 10), 1);
				}

				// Back Button!!
				try {
					Thread.sleep(2000);
					
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
				} catch (Exception e) {
					count++;
					
					if (error == 0)
						str = str + "\n" + "Back button doesn't found";
					error++;
					Thread.sleep(5000);
					M.BackFun(1);

				}

				// check title & Message
					try {
						title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
						// System.out.println(title);
						try {
							Assert.assertEquals(title, M.getstring("Automation Test Data", 63, 5),
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
							Assert.assertEquals(mess, M.getstring("Automation Test Data", 63, 2),
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
						t++;
						// throw new Exception(str);
					}

				
				Thread.sleep(2000);
				
				int z=0;
				// User Details page
				try {
					String user1 = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']").getText();

					// Back Button!!
					try {
						Thread.sleep(2000);
						if(error>0)
							throw new Exception(str) ;
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/llBack").click();
						

					} catch (Exception e) {
						count++;
						if (error == 0)
							str = str + "\n" + "Back button doesn't found";
						error++;
						Thread.sleep(5000);
						M.BackFun(1);

					}

					try {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					} catch (Exception e) {
						count++;
						str = str + "\n" + i + "Warrning message not found for click on Yes button";

					}

					// Use page
					try {
						Thread.sleep(3000);
						user1 = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
						Thread.sleep(3000);

					} catch (Exception e) {
						// Use page
						count++;
						str = str + "\n" + i + "user page not found After click on Yes button";
						
						try {
							user1 = driver.findElementByXPath("//android.widget.TextView[@text='User Detail']").getText();
							count++;
							str = str + "\n" + i + "After click yes Unsave data user stay in user details page";
						} catch (Exception x) {
							z++;
							str = str + "\n" + "Apps May be crush";
							throw new Exception(str);
							
						}
					}

				} catch (Exception x) {
					count++;
					if(z>0)
						throw new Exception(str);
					str = str + "\n" + "User details page not found after click NO";
					try {
						Thread.sleep(3000);
						String user = driver.findElementByXPath("//android.widget.TextView[@text='Users']").getText();
						Thread.sleep(3000);

					} catch (Exception e) {
						// Use page
						count++;
						str = str + "\n" + i + "Apps may be crush";
						throw new Exception(str);
					}
				}
			}
			if (count > 0) {
				throw new Exception(str);
			}

			M.ScreenShots("Screenshot/Passed", "CreateDataDismiss");
			M.setStrData("As Expected", "Automation Testcase", 430, 6);
			M.setStrData("Pass", "Automation Testcase", 430, 7);

		} catch (Exception e) {
			M.ScreenShots("Screenshot/Failed", "CreateDataDismiss");
			String ErMass = e.toString();
			M.setStrData(ErMass, "Automation Testcase", 430, 6);
			M.setStrData("Fail", "Automation Testcase", 430, 7);

		}
		ReStart();

	}
	
	
	
	//Verify Changing Department & Reporting Person Conditions (Create User)
	//@Test (priority = 25)
	public void VerifyChangingDepartmentReportingPerson() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Changing Department & Reporting Person Conditions (Create User) Executed!");
		String title="";
		String str="";
		String testdata="";
		int count=0;
		int k=40;
		String title1="";
		String message="";
		
		try{
			Thread.sleep(3000);
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/floting_action_view").click();
			Thread.sleep(5000);
			M.ScrollDwon(1);
			
			for(int i=1;i<=7;i++)
			{
				if(i==1){
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();
					
					//reporting person
					testdata=M.getstring("Automation Test Data", k, 7);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==2) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==3) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==4) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==5) {
					testdata=M.getstring("Automation Test Data", k, 8);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==6) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				
				//
				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(title, M.getstring("Automation Test Data", 61, 4), "Warning Title Doesn't Match");
					if(i==4||i==7)
					{
						str = str + "\n" +i+ "Department & Reporting person are same but found warnning Title";
					}
				} catch (Exception e) {
					
					if(i!=4) {
						if(i!=7)
						{
							count++;
							str = str + "\n" +i+ "Warning Title Body Not Found";
						}else
						{
							//System.out.println("Department & Reporting person are same department");
						}
						
					}else
					{
						//System.out.println("Department & Reporting person are same department");
					}
				}

				try {
					message=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					SA.assertEquals(message, M.getstring("Automation Test Data", 61, 5), "Warning Message Doesn't Match");	
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
					if(i==4||i==7)
					{
						str = str + "\n" +i+ "Department & Reporting person are same but found warnning Message";
					}
				} catch (Exception e) {
					
					if(i!=4) {
						if(i!=7)
						{
							count++;
							str = str + "\n" +i+ "Warning Message Body Not Found";
						}else
						{
							//System.out.println("Department & Reporting person are same department");
						}
						
					}else
					{
						//System.out.println("Department & Reporting person are same department");
					}
					
				}


			}
			
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
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch (Exception e) {
				;

			}
			
			try {
				SA.assertAll();
			}catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			if(count>0)
				throw new Exception(str);
			
			M.ScreenShots("Screenshot/Passed", "BackButtonWarningMass");
			M.setStrData("As Expected", "Automation Testcase", 235, 6);
			M.setStrData("Pass", "Automation Testcase", 235, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","BackButtonWarningMass");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 235, 6);
			M.setStrData("Fail","Automation Testcase", 235, 7);

		}
		ReStart();

	}
	

	
	//Verify Changing Department & Reporting Person Conditions (Update User)
	//@Test (priority = 26)
	public void VerifyDepartmentReportingPersonConditions() throws IOException, InterruptedException {
		CallingMethods M=new CallingMethods(driver);
		SoftAssert SA=new SoftAssert();
		System.out.println("Verify Changing Department & Reporting Person Conditions (Update User) Executed!");
		String title="";
		String str="";
		String testdata="";
		int count=0;
		int k=40;
		String title1="";
		String message="";
		
		try{
			String ser=M.getstring("Automation Test Data", 29, 1);
			Thread.sleep(5000);
			M.ClickOn(ser);
			for(int i=1;i<=7;i++)
			{
				Thread.sleep(5000);
				M.ScrollDwon(1);
				
				if(i==1){
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==2) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==3) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==4) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userDepartment").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==5) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else if(i==6) {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				else {
					testdata=M.getstring("Automation Test Data", k, i);
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_userReportingPerson").click();
					M.ScrollByText(testdata);
					driver.findElementByXPath("//android.widget.TextView[@text=\""+testdata+"\"]").click();
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/doneButton").click();

				}
				

				try {
					title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
					SA.assertEquals(title, M.getstring("Automation Test Data", 61, 2), "Warning Title Doesn't Match");
					if(i==4||i==7)
					{
						str = str + "\n" +i+ "Department & Reporting person are same but found warnning Title";
					}
				} catch (Exception e) {
					
					if(i!=4) {
						if(i!=7)
						{
							count++;
							str = str + "\n" +i+ "Warning Title Body Not Found";
						}else
						{
							;//System.out.println("Department & Reporting person are same department");
						}
						
					}else
					{
						;//System.out.println("Department & Reporting person are same department");
					}
				}

				try {
					message=driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
					SA.assertEquals(message, M.getstring("Automation Test Data", 61, 3), "Warning Message Doesn't Match");	
					if(i==4||i==7)
					{
						str = str + "\n" +i+ "Department & Reporting person are same but found warnning Message";
					}
					driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				} catch (Exception e) {
					
					if(i!=4) {
						if(i!=7)
						{
							count++;
							str = str + "\n" +i+ "Warning Message Body Not Found";
						}else
						{
							;//System.out.println("Department & Reporting person are same department");
						}
						
					}else
					{
						;//System.out.println("Department & Reporting person are same department");
					}
					
				}


			}
			
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
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch (Exception e) {
				;
			}
			
			
			try {
				SA.assertAll();
			}catch (AssertionError e) {
				count++;
				str = str + "\n " + e;
			}

			if(count>0)
				throw new Exception(str);
			
			M.ScreenShots("Screenshot/Passed", "BackButtonWarningMass");
			M.setStrData("As Expected", "Automation Testcase", 235, 6);
			M.setStrData("Pass", "Automation Testcase", 235, 7);

		}catch(Exception e) {
			M.ScreenShots("Screenshot/Failed","BackButtonWarningMass");
			String ErMass=e.toString();
			M.setStrData(ErMass, "Automation Testcase", 235, 6);
			M.setStrData("Fail","Automation Testcase", 235, 7);

		}
		ReStart();

	}
	
	
}