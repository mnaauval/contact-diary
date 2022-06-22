package com.nexsoft.pom;

import java.util.concurrent.TimeUnit;

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

	@AndroidFindBy(id = "com.apozas.contactdiary:id/fab")
//	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='3']")
	private WebElement btnAddEvent;

	public MainActivity(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		touchAct = new TouchAction(driver);
	}

	public void addEvent() {
		System.out.println("Main");
		btnAddEvent.click();
		touchAct.tap(PointOption.point(950, 1825)).perform();
	}
}
