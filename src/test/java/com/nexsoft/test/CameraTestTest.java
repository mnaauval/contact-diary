package com.nexsoft.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nexsoft.pom.activity.CustomCameraActivity;
import com.nexsoft.pom.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;

public class CameraTestTest {

	private AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private CustomCameraActivity customCam;
	private Utilities util;

	@BeforeTest
	public void init() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0");
		capabilities.setCapability("uid", "52c5c997");
//		capabilities.setCapability("uid", "emulator-5554");
		capabilities.setCapability("appPackage", "com.dimatt.camtest");
		capabilities.setCapability("appActivity", "com.dimatt.camtest.SplashScreen");
		capabilities.setCapability("autoGrantPermissions", "true");
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customCam = new CustomCameraActivity(driver);
		util = new Utilities(driver);
	}

	@Test(priority = 1)
	public void createScreenshotTest() {
		customCam.takePicture();
		util.screenshootElm(customCam.previewBackCam);
		util.screenshootElm(customCam.previewFrontCam);
	}
}
