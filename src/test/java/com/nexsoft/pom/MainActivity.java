package com.nexsoft.pom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class MainActivity {

	private AndroidDriver driver;
	private TouchAction touchAct;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Diary']")
	public WebElement lblDiary;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/fab")
//	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='3']")
	private WebElement btnAddEvent;

	public MainActivity(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		touchAct = new TouchAction(driver);
	}

	public void clickAddBtn() {
		System.out.println("Add Btn");
		btnAddEvent.click();
	}

	public void clickNewEventBtn() {
		System.out.println("New Event Btn");
		if (driver.getCapabilities().getCapability("uid").toString().equals("52c5c997")) {
			touchAct.tap(PointOption.point(950, 1825)).perform();
		} else if (driver.getCapabilities().getCapability("uid").toString().equals("emulator-5554")) {
			touchAct.tap(PointOption.point(950, 1520)).perform();
		}
	}
	
	public void clickNewContacttBtn() {
		System.out.println("New Event Btn");
		if (driver.getCapabilities().getCapability("uid").toString().equals("52c5c997")) {
			touchAct.tap(PointOption.point(940, 2040)).perform();
		} else if (driver.getCapabilities().getCapability("uid").toString().equals("emulator-5554")) {
//			touchAct.tap(PointOption.point(950, 1520)).perform();
		}
	}

	public <T> List<String> getEventName(List<String> lstEv) {
		List<String> lstEvName = new ArrayList<String>();
		for (String i : lstEv) {
			String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
					+ "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout"
					+ "/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[1]"
					+ "/android.widget.ListView/android.widget.LinearLayout[" + i + "]"
					+ "/android.widget.LinearLayout/android.widget.TextView";
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
			lstEvName.add(driver.findElement(By.xpath(xpath)).getText());
		}
		return lstEvName;
	}

}
