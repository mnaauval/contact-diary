package com.nexsoft.pom.activity;

import org.openqa.selenium.support.PageFactory;

import com.nexsoft.pom.handler.DateHandler;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewContactActivity {

	private AndroidDriver driver;
	private DateHandler dateHdl;

	public NewContactActivity(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		dateHdl = new DateHandler(driver);
	}
	
	
}
