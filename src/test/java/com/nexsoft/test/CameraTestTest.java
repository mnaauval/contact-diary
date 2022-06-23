package com.nexsoft.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nexsoft.pom.CustomCameraActivity;
import com.nexsoft.pom.ScreenshotHandler;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class CameraTestTest {

	private AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private CustomCameraActivity customCam;
	private ScreenshotHandler shot;

	@BeforeTest
	public void init() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0");
		capabilities.setCapability("uid", "52c5c997");
//		capabilities.setCapability("uid", "emulator-5554");
		capabilities.setCapability("appPackage", "com.dimatt.camtest");
		capabilities.setCapability("appActivity", "com.dimatt.camtest.SplashScreen");
//		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customCam = new CustomCameraActivity(driver);
		shot = new ScreenshotHandler(driver);
	}

	@Test(priority = 1)
	public void createScreenshotTest() {
		customCam.takePicture();
		shot.screenshootElm(customCam.previewBackCam);
		shot.screenshootElm(customCam.previewFrontCam);
		String file = "<img src='file://" + shot.screenshootElm(customCam.previewBackCam)
				+ "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
		String file2 = "<img src='file://" + shot.screenshootElm(customCam.previewFrontCam)
				+ "'height=\"350\" width=\"792\"/>";
		Reporter.log(file2);
	}
}
