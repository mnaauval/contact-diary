package com.nexsoft.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
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
	private List<String> choice;

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
		choice = new ArrayList<String>();
		choice.add("1");
		choice.add("3");
	}

	@Test(priority = 1)
	public void createEvent1() {
		System.out.println("create event 1");
		mainAct.clickAddBtn();
		mainAct.clickNewEventBtn();
		newEv.txtName.sendKeys("Sparing1");
		newEv.txtPlace.sendKeys("Basecamp Tundra");
		newEv.setStartDate("24", "June", "2022");
		newEv.setEndDate("30", "June", "2022");
		newEv.txtPeople.sendKeys("All Tundra Squad");
		newEv.txtContact.sendKeys("089709870870");
		newEv.typeIndoors.click();
		newEv.setMitigation(choice);
		newEv.txtNotes.sendKeys("All equipment");
		newEv.btnSave.click();
	}

	@Test(priority = 2)
	public void createEvent2() {
		System.out.println("create event 2");
		mainAct.clickNewEventBtn();
		newEv.txtName.sendKeys("Sparing2");
		newEv.txtPlace.sendKeys("Basecamp Tundra2");
		newEv.setStartDate("24", "June", "2022");
		newEv.setEndDate("30", "June", "2022");
		newEv.txtPeople.sendKeys("All Tundra2 Squad");
		newEv.txtContact.sendKeys("089709870870");
		newEv.typeIndoors.click();
		newEv.setMitigation(choice);
		newEv.txtNotes.sendKeys("All equipment2");
		newEv.btnSave.click();
	}

	@Test(priority = 3, enabled = false)
	public void createEventTest() {
		mainAct.clickAddBtn();
		mainAct.clickNewEventBtn();
		newEv.setDate("05072022");
	}

	@Test(priority = 4)
	public void getEventName() {
		List<String> lstEvName = new ArrayList<String>();
		lstEvName.add("1");
		lstEvName.add("2");
		List<String> lstEvNameAct = new ArrayList<String>();
		lstEvNameAct = mainAct.getEventName(lstEvName);
		List<String> lstEvNameExp = new ArrayList<String>();
		lstEvNameExp.add("📅   Sparing1");
		lstEvNameExp.add("📅   Sparing2");
		Assert.assertEquals(lstEvNameAct, lstEvNameExp);
	}
}
