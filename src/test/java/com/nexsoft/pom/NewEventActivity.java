package com.nexsoft.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewEventActivity extends Utilities {

	private AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
	public WebElement lblNew;
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
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void setMitigation(List<String> choice) {
		fieldMitigate.click();
		for (String no : choice) {
			String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/"
					+ "android.widget.FrameLayout/android.widget.LinearLayout/"
					+ "android.widget.FrameLayout/android.widget.ListView/" 
					+ "android.widget.CheckedTextView[" + no + "]";
			driver.findElement(By.xpath(xpath)).click();
		}
		btnOk.click();
	}

}
