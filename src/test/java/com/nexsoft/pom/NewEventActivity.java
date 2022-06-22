package com.nexsoft.pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class NewEventActivity {

	private AndroidDriver driver;
	private TouchAction touchAct;
	private DateHandler dateHdl;

	@FindBy(id = "com.apozas.contactdiary:id/eventname_input")
	private WebElement evName;
	@FindBy(id = "com.apozas.contactdiary:id/eventplace_input")
	private WebElement evPlace;
//	@FindBy(id = "com.apozas.contactdiary:id/eventdate_input")
//	private WebElement pDateStart;
//	@FindBy(id = "com.apozas.contactdiary:id/endeventdate_input")
//	private WebElement pDateEnd;
//	@FindBy(id = "android:id/date_picker_header_year")
//	private WebElement pYear;
//	@FindBy(id = "//android.view.View[@content-desc=\"09 June 2016\"]")
//	private WebElement date;
	@FindBy(id = "com.apozas.contactdiary:id/event_indoor_outdoor")
	private List<WebElement> pTypeRadio;
	@FindBy(id = "com.apozas.contactdiary:id/event_indoors")
	private WebElement pTypeIndoors;
	@FindBy(id = "com.apozas.contactdiary:id/event_mitigation")
	private WebElement evMitigate;
	@FindBy(xpath = "//android.widget.CheckedTextView[1]")
	private WebElement check1;
	@FindBy(xpath = "//android.widget.CheckedTextView[2]")
	private WebElement check2;
	@FindBy(xpath = "//android.widget.CheckedTextView[3]")
	private WebElement check3;
	@FindBy(xpath = "//android.widget.CheckedTextView[4]")
	private WebElement check4;
	@FindBy(id = "android:id/button2")
	private WebElement layCancel;
	@FindBy(id = "android:id/button1")
	private WebElement layOk;
	@FindBy(id = "com.apozas.contactdiary:id/eventpeople_input")
	private WebElement evPeople;
	@FindBy(id = "com.apozas.contactdiary:id/eventphone_input")
	private WebElement evContact;
	@FindBy(id = "com.apozas.contactdiary:id/eventnotes_input")
	private WebElement evNotes;
	@FindBy(id = "com.apozas.contactdiary:id/okButton_AddEvent")
	private WebElement addEvBtn;

	public NewEventActivity(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		touchAct = new TouchAction(driver);
		dateHdl = new DateHandler(driver);
	}

	public void inputData(String name, String place, String people, String contact, String notes) {
		System.out.println("New Event");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		evName.sendKeys(name);
		evPlace.sendKeys(place);
		dateHdl.dateStartHandler(285, 1165, 285, 1800, 590, 900, "20", "June", "2016");
		dateHdl.dateEndHandler(590, 900, "30", "June", "2016");
		evPeople.sendKeys(people);
		evContact.sendKeys(contact);
		pTypeIndoors.click();
		evMitigate.click();
		check1.click();
		check3.click();
		layOk.click();
		evNotes.sendKeys(notes);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		addEvBtn.click();
	}
}
