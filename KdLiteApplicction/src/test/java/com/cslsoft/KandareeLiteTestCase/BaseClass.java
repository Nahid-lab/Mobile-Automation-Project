package com.cslsoft.KandareeLiteTestCase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseClass {

	public AndroidDriver<AndroidElement>  driver;
	
	@BeforeClass
	public  AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{

		File appDir = new File("src/test/resources");
		File app = new File(appDir, "KandareeLiteApp.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "500");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "R8KNB0053FJ");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.resetApp();
			

		
		return driver;
		
	}


	
	 //@AfterClass
	 public void CloseApps() {
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	 
	 System.out.println("quit the class"); 
	 driver.quit();
	 }

}