package com.cslsoft.CoopersApps_Smoketesting;

import java.time.Duration;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.ios.touch.IOSPressOptions.iosPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;
import java.lang.NullPointerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.examples.CreateUserDefinedDataFormats;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.sql.*; 
public class CallingMethods{
	
	public AndroidDriver<AndroidElement>  driver;
	public CallingMethods(AndroidDriver<AndroidElement> driver) {
	       
		    this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
//Allow Location Access 
	public void AllowLocationAccess() throws Exception {
		try {
			  Thread.sleep(5000);
			  driver.findElementByAccessibilityId("Allow Location Access").click();
			  Thread.sleep(5000);
			  driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click(); 
			  
			  Thread.sleep(5000);
			  driver.findElement(By.className("android.widget.EditText")).getText();
			  
			  //System.out.println("ok!!");
		  }catch(Exception a){
			  System.out.println("After install, App may be crush. Allow location Access button not found");
			  throw new Exception(a);
		  }

	}

	//Login Customer App
	public void Login(String Number) throws Exception {
		
		//Login with valid number
		try {
			
			//Enter mobile number
			Thread.sleep(2000);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.className("android.widget.EditText")).click();
			 driver.findElement(By.className("android.widget.EditText")).sendKeys(Number);
			 
			 //Click on Continue button
			 Thread.sleep(2000);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElementByAccessibilityId("Continue").click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 
			 //Database connection
			 ResultSet rs=Databaseconnection("select OTPCode from OTPLog order by OTPLogId desc limit 1");
			 rs.next();
			 String newcode=rs.getString("OTPCode");
			 DatabaseConnectinOff();
			 
			//convert string to char array.
			 char[] ch = new char[newcode.length()];
			 
			 for (int i = 0; i < newcode.length(); i++) {
		            ch[i] = newcode.charAt(i);
		            char OTP=ch[i];
		            
		            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		            driver.findElementsByClassName("android.widget.EditText").get(i).click();
		            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		            driver.findElementsByClassName("android.widget.EditText").get(i).setValue(Character.toString(OTP));
		        }
			 
			 Thread.sleep(2000);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElementByAccessibilityId("Submit").click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 Thread.sleep(2000);

		}catch(Exception b){
			  System.out.println("Login fail");
			  throw new Exception(b);
		  }
		
	}
	
	
	
	
	 
// ScreenShots
		public void ScreenShots(String FolderName, String FileName) throws IOException {
			String folder_name = FolderName;
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			new File(folder_name).mkdir();
			String file_name = FileName + ".png";
			FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
			System.out.println("Screenshot taken");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	
//Swiping	
		
		public void Swipping(Point p1, Point p2) throws InterruptedException {

			TouchAction tcD = new TouchAction(driver);
			Thread.sleep(2000);
			tcD.longPress(longPressOptions().withPosition(PointOption.point(p1.x, p1.y+20 ))
					.withDuration(ofSeconds(2))).moveTo(PointOption.point(p2.x, p2.y+20)).release().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		 
//SwipBytext
		public void SwipBytext(String text) {

			Point p1 = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").getCenter();
			Point p2 = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").getLocation();

			TouchAction tcD = new TouchAction(driver);
			tcD.longPress(longPressOptions().withPosition(PointOption.point(p1.x + 100, p1.y + 20))
					.withDuration(ofSeconds(2))).moveTo(PointOption.point(p2.x, p2.y + 20)).release().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void SwipBytextRevers(String text) {

			Point p1 = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").getLocation();
			Point p2 = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").getCenter();
			
			TouchAction tcD = new TouchAction(driver);
			tcD.longPress(longPressOptions().withPosition(PointOption.point(p1.x , p1.y + 20))
					.withDuration(ofSeconds(2))).moveTo(PointOption.point(p2.x+100, p2.y + 20)).release().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
//SwipBydubletext
		public void SwipBydubletext(String text,String text1) {

			Point p1 = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").getCenter();
			Point p2 = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text1 + "\"]").getLocation();

			TouchAction tcD = new TouchAction(driver);
			tcD.longPress(longPressOptions().withPosition(PointOption.point(p2.x , p2.y + 20))
					.withDuration(ofSeconds(3))).moveTo(PointOption.point(p1.x, p1.y + 20)).release().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
//Searching
		public void Searching(String ser) {
			driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/ll_search").click();
			driver.findElementById("android:id/search_src_text").clear();
			driver.findElementById("android:id/search_src_text").sendKeys(ser);
			driver.hideKeyboard();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
		
//BackFun
		public void BackFun(int size) {
			for (int j = 1; j <= size; j++) {
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		}
		
//Scroll
		public void Scroll(int j) {
			
			for (int i = 0; i < j; i++) {
				//Dimension dimension = driver.manage().window().getSize();
				Dimension dimension = driver.manage().window().getSize();
				int start_x = (int) (dimension.width * 0.5);
				int start_y = (int) (dimension.height * 0.2);

				int end_x = (int) (dimension.width * 0.5);
				int end_y = (int) (dimension.height * 0.8);

				TouchAction tcD = new TouchAction(driver);
				tcD.press(PointOption.point(start_x, start_y))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
			}

		}
		
//ScrollUpMinor
		public void ScrollUpMinor(int j) {
			
			for (int i = 0; i < j; i++) {
				//System.out.println("ok");
				Dimension dimension = driver.manage().window().getSize();
				int start_x = (int) (dimension.width * 0.5);
				int start_y = (int) (dimension.height * 0.3);
				
				int end_x = (int) (dimension.width * 0.5);
				int end_y = (int) (dimension.height * 0.6);
				
				TouchAction tcD = new TouchAction(driver);
				tcD.press(PointOption.point(start_x, start_y))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(end_x, end_y)).release().perform();
			}
			
		}
		
		public void ScrollDown(int j){
			for(int i=0;i<j;i++)
			{
				Dimension dimension = driver.manage().window().getSize();
				int start_x = (int) (dimension.width * 0.5);
				int start_y = (int) (dimension.height * 0.8);

				int end_x = (int) (dimension.width * 0.5);
				int end_y = (int) (dimension.height * 0.2);
				//Thread.sleep(2000);
				TouchAction tcD = new TouchAction(driver);
				tcD.press(PointOption.point(start_x, start_y))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
			}
			
		}
		public void ScrollDown2(int j) throws InterruptedException{
			for(int i=0;i<j;i++)
			{
				Dimension dimension = driver.manage().window().getSize();
				int start_x = (int) (dimension.width * 0.5);
				int start_y = (int) (dimension.height * 0.8);
				
				int end_x = (int) (dimension.width * 0.5);
				int end_y = (int) (dimension.height * 0.4);
				Thread.sleep(2000);
				TouchAction tcD = new TouchAction(driver);
				tcD.press(PointOption.point(start_x, start_y))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(end_x, end_y)).release().perform();
			}
			
		}
		
//ScrollDwonMinor		
		public void ScrollDownMinor(int j){
			for(int i=0;i<j;i++)
			{
				Dimension dimension = driver.manage().window().getSize();
				int start_x = (int) (dimension.width * 0.5);
				int start_y = (int) (dimension.height * 0.8);

				int end_x = (int) (dimension.width * 0.5);
				int end_y = (int) (dimension.height * 0.7);

				TouchAction tcD = new TouchAction(driver);
				tcD.press(PointOption.point(start_x, start_y))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
			}
			
		}
		
		
		
//ScrollByText
		public void ScrollByText(String text) {
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			MobileElement element = (MobileElement) driver
					.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
							+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
			
			/*
			 * MobileElement element = (MobileElement) driver .findElement(MobileBy.
			 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1))"
			 * + ".scrollIntoView(new UiSelector().text(\"" + scrol + "\").instance(1))"));
			 */
		}
		
//ScrollByIDText
		public void ScrollByIDText(String text) {
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			/*
			 * MobileElement element = (MobileElement)
			 * driver.findElement(MobileBy.AndroidUIAutomator(
			 * "new UiScrollable(new UiSelector().scrollable(true))" +
			 * ".scrollIntoView(new UiSelector().resourceIdMatches(\"" + id + "\").text(\""
			 * + text + "\"))"));
			 */

			
			  MobileElement element = (MobileElement) driver .findElement(MobileBy.
			  AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
			  + ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))"));
			 
		}
		
//Click on selected cart
		public void ClickOn(String text) throws InterruptedException {
			
			ScrollByText(text);
			Thread.sleep(2000);
			List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView[@text=\"" + text + "\"]");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(text)) {
					driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]").click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;
				}

			}

		}
		
		//all integers from string
		public String extractInt(String str)
	    {
	        str = str.replaceAll("[^\\d]", " ");
	  
	        str = str.trim();
	  
	        str = str.replaceAll(" +", " ");
	  
	        if (str.equals(""))
	            return "-1";
	  
	        return str;
	    }

		
		//Verification
		public String verify(String text) {
			String verify = "";
			int count=0;
			List<AndroidElement> xyz = driver.findElementsByXPath("//android.widget.TextView");
			for (int i = 0; i < xyz.size(); i++) {
				if (xyz.get(i).getText().contains(text)) {
					count++;
					break;
				}

			}
			if(count==0)
			{
				verify=text+" Doesn't Found";
			}
			return verify;

		}
		
//Verify confirmation message and click no
		public String Confirmation_Message(String txt1, String txt2){
		String title_text=txt1;
		String message_text=txt2;
		String title="";
		String str="";
		String mess="";
		int count=0;
		try {
			title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
			// System.out.println(title);
			try {
				Assert.assertEquals(title, title_text,"- Confirmation Title doesn't valid");
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
			//System.out.println(mess);
			try {
				Assert.assertEquals(mess, message_text,"- Confirmation Message doesn't valid");

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
		
		
		return str;
	}
		
//Sucessfull Message verification
		public String Sucessfull_Message(String txt1, String txt2) {
			// TODO Auto-generated method stub
			String title_text=txt1;
			String message_text=txt2;
			String title="";
			String str="";
			String mess="";
			int count=0;
			try {
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, title_text,"- Successfull Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Title Body Not Found";
			}

			try {
				Thread.sleep(2000);
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				//System.out.println(mess);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				try {
					Assert.assertEquals(mess, message_text,"- Successfull Message doesn't valid");

				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}

			} catch (Exception e) {
				count++;
				str = str + "\n" + "Successfull Message Body Not Found";
			}
			return str;

		}
		
	
		
//Error Message verification
		public String Error_Message(String txt1, String txt2) {
			// TODO Auto-generated method stub
			String title_text=txt1;
			String message_text=txt2;
			String title="";
			String str="";
			String mess="";
			int count=0;
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				title = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvTitle").getText();
				// System.out.println(title);
				try {
					Assert.assertEquals(title, title_text,"- Error Title doesn't valid");
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Error Title Body Not Found";
			}
			
			try {
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				mess = driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/tvMessage").getText();
				//System.out.println(mess);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElementById("bd.com.cslsoft.kandareeliteapp:id/yesButton").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				try {
					Assert.assertEquals(mess, message_text,"- Error Message doesn't valid");
					
				} catch (AssertionError e) {
					count++;
					str = str + "\n" + e;
				}
				
			} catch (Exception e) {
				count++;
				str = str + "\n" + "Error Message Body Not Found";
			}
			return str;
			
		}
		
		
//date format
		
		
		public long findDifference(String start_date,String end_date)
		{

			// SimpleDateFormat converts the
			// string format to date object
			SimpleDateFormat sdf= new SimpleDateFormat("dd MMMM yyyy");
			long value=0;
			// Try Block
			try {

				Date d1 = sdf.parse(start_date);
				Date d2 = sdf.parse(end_date);


				long difference_In_Time
					= d2.getTime() - d1.getTime();
				

				long difference_In_Days
					= (difference_In_Time
					/ (1000 * 60 * 60 * 24))
					% 365;

				value= difference_In_Days;
			}

			// Catch the Exception
			catch (ParseException e) {
				e.printStackTrace();
			}
			return value;
			
		}
		
//change formate and date		
		public String ChangeFormate_Date(String date,int i) throws ParseException {
			

			SimpleDateFormat sdf= new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			
			Date currentDate=sdf.parse(date);  

		    // convert date to calendar
		    Calendar c = Calendar.getInstance();
		    c.setTime(currentDate);

		    c.add(Calendar.DATE, i); 
		        
		    Date currentDatePlusOne = c.getTime();
		         
		    
		    String strDate= formatter.format(currentDatePlusOne);
			return strDate;

		}
		
//Database connection
		Connection con;
		String host="cslsoft.cocvobqdb4ud.us-east-2.rds.amazonaws.com";
		String port="3306";
		String database_name="appTSTDB_Coopers";
		String user="admin";
		String password="Admin$csl$aws#97531";
		  //Class.forName("com.mysql.jdbc.Driver"); 
		public ResultSet Databaseconnection(String quy) throws SQLException {
			
			  //Class.forName("com.mysql.jdbc.Driver");  
			  con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database_name,user,password);
			  //System.out.println(con);
			  
			  //System.out.println("CON="+con.getClass().getSimpleName());
			  //System.out.println("OK1");
			  Statement stmt=con.createStatement();  
			  //System.out.println("stmt="+stmt.getClass().getSimpleName());
			  ResultSet rs=stmt.executeQuery(quy);  
			  //System.out.println("OK2");
			  //System.out.println("rs="+rs.getClass().getSimpleName());
			  
			  //System.out.println("OK3");
			  //con.close();  
			return rs;
			
		}
		public void DatabaseConnectinOff() throws SQLException {
			  
			  //Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database_name,user,password);
			  //System.out.println(con);
			  con.close();  
		}
		
		

//Data driven from excel		
		public String setStrData(String Sdata, String ShitName, int rowN, int cellN) throws IOException {
			File appDir = new File("src/test/resources");
			File datafile = new File(appDir, "KandareeLite_TC.xlsx");
			FileInputStream Dfile = new FileInputStream(datafile);

			XSSFWorkbook wb = new XSSFWorkbook(Dfile);
			XSSFSheet sheet = wb.getSheet(ShitName);
			XSSFRow row = sheet.getRow(rowN);
			if (row == null)
				row = sheet.createRow(rowN);

			XSSFCell cell = row.getCell(cellN);
			if (cell == null)
				cell = row.createCell(cellN);

			cell.setCellValue(Sdata);
			String data = cell.getStringCellValue();
			FileOutputStream fos = new FileOutputStream(datafile);
			wb.write(fos);
			fos.close();
			return data;

		}
		
		public int setIntData(int Idata, String ShitName, int rowN, int cellN) throws IOException {
			File appDir = new File("src/test/resources");
			File datafile = new File(appDir, "KandareeLite_TC.xlsx");
			FileInputStream Dfile = new FileInputStream(datafile);

			XSSFWorkbook wb = new XSSFWorkbook(Dfile);
			XSSFSheet sheet = wb.getSheet(ShitName);
			XSSFRow row = sheet.getRow(rowN);
			if (row == null)
				row = sheet.createRow(rowN);

			XSSFCell cell = row.getCell(cellN);
			if (cell == null)
				cell = row.createCell(cellN);

			cell.setCellValue(Idata);
			int data = (int) cell.getNumericCellValue();
			FileOutputStream fos = new FileOutputStream(datafile);
			wb.write(fos);
			fos.close();
			return data;

		}
		


		public String getstring(String ShitName, int rowN, int cellN) throws IOException {
			File appDir = new File("src/test/resources");
			File datafile = new File(appDir, "KandareeLite_TC.xlsx");
			FileInputStream Dfile = new FileInputStream(datafile);

			XSSFWorkbook wb = new XSSFWorkbook(Dfile);
			XSSFSheet sheet = wb.getSheet(ShitName);
			XSSFRow row = sheet.getRow(rowN);
			if (row == null)
				row = sheet.createRow(rowN);

			XSSFCell cell = row.getCell(cellN);
			if (cell == null)
				cell = row.createCell(cellN);
			String data = cell.getStringCellValue();
			return data;

		}

		public int getinteger(String ShitName, int rowN, int cellN) throws IOException {
			File appDir = new File("src/test/resources");
			File datafile = new File(appDir, "KandareeLite_TC.xlsx");
			FileInputStream Dfile = new FileInputStream(datafile);

			XSSFWorkbook wb = new XSSFWorkbook(Dfile);
			XSSFSheet sheet = wb.getSheet(ShitName);
			XSSFRow row = sheet.getRow(rowN);
			if (row == null)
				row = sheet.createRow(rowN);

			XSSFCell cell = row.getCell(cellN);
			if (cell == null)
				cell = row.createCell(cellN);
			int data = (int) cell.getNumericCellValue();
			return data;

		}




}