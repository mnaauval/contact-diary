package com.nexsoft.pom.activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.nexsoft.pom.handler.DateHandler;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewEventActivity {

	private AndroidDriver driver;
	private DateHandler dateHdl;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventname_input")
	public WebElement txtName;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventplace_input")
	public WebElement txtPlace;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventdate_input")
	private WebElement startDate;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/endeventdate_input")
	private WebElement endDate;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventinittime_input")
	private WebElement startTime;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventendtime_input")
	private WebElement endTime;
	@AndroidFindBy(id = "android:id/toggle_mode")
	private WebElement toggleTime;
	@AndroidFindBy(id = "android:id/input_hour")
	private WebElement inputHour;
	@AndroidFindBy(id = "android:id/input_minute")
	private WebElement inputMinute;
	@AndroidFindBy(id = "android:id/label_error")
	private WebElement lblTimeError;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_indoor_outdoor")
	private List<WebElement> radioType;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_indoors")
	public WebElement typeIndoors;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_mitigation")
	private WebElement fieldMitigate;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[1]")
	private WebElement mitigate1;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[2]")
	private WebElement mitigate2;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[3]")
	private WebElement mitigate3;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[4]")
	private WebElement mitigate4;
	@AndroidFindBy(id = "android:id/button2")
	private WebElement btnCancel;
	@AndroidFindBy(id = "android:id/button1")
	private WebElement btnOk;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventpeople_input")
	public WebElement txtPeople;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventphone_input")
	public WebElement txtContact;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventnotes_input")
	public WebElement txtNotes;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/okButton_AddEvent")
	public WebElement btnSave;

	public NewEventActivity(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		dateHdl = new DateHandler(driver);
	}

	public void setStartDate(String date, String month, String year) {
//		dateHdl.dateStartHandler("24", "June", "2022");
		dateHdl.dateStartHandler(date, month, year);
	}

	public void setEndDate(String date, String month, String year) {
//		dateHdl.dateEndHandler("30", "June", "2022");
		dateHdl.dateEndHandler(date, month, year);
	}

	public void setMitigation(List<String> choice) {
		fieldMitigate.click();
		for (String no : choice) {
			String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/"
					+ "android.widget.FrameLayout/android.widget.LinearLayout/"
					+ "android.widget.FrameLayout/android.widget.ListView/" + "android.widget.CheckedTextView[" + no
					+ "]";
			driver.findElement(By.xpath(xpath)).click();
		}
		btnOk.click();
	}

	public void setStartDate(String date) {
		dateHdl.setStartDate(date);
	}

	public void setEndDate(String date) {
		dateHdl.setEndDate(date);
	}
}
