package com.nexsoft.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nexsoft.pom.MainActivity;
import com.nexsoft.pom.NewEventActivity;

import io.appium.java_client.android.AndroidDriver;

public class CreateEventTest {

	private AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private MainActivity mainAct;
	private NewEventActivity newEv;

	@BeforeTest
	public void init() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0");
//		capabilities.setCapability("uid", "52c5c997");
//		capabilities.setCapability("uid", "emulator-5554");
		capabilities.setCapability("appPackage", "com.apozas.contactdiary");
		capabilities.setCapability("appActivity", "com.apozas.contactdiary.MainActivity");
//		capabilities.setCapability("appActivity", "com.apozas.contactdiary.NewEventActivity");
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainAct = new MainActivity(driver);
		newEv = new NewEventActivity(driver);
	}

	@Test(priority = 1)
	public void addEvent() {
		System.out.println("TEST");
		mainAct.addEvent();
	}

	@Test(priority = 2)
	public void createEvent() {
		newEv.inputData("Mabar", "Basecamp", "All OG", "08973231212", "Don't be late, bring snacks");
	}
}
