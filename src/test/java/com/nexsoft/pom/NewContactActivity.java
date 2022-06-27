package com.nexsoft.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewContactActivity extends Utilities {

	private AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
	public WebElement lblNew;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/name_input")
	public WebElement txtName;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/place_input")
	public WebElement txtPlace;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/date_input")
	public WebElement startDate;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/enddate_input")
	public WebElement endDate;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/phone_input")
	public WebElement txtPhone;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/known_yes")
	public WebElement knownYes;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/contact_indoors")
	public WebElement typeIndoors;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/mitigation")
	public WebElement fieldMitigate;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[2]")
	public WebElement mitigate2;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[4]")
	public WebElement mitigate4;
	@AndroidFindBy(id = "android:id/button2")
	private WebElement btnCancel;
	@AndroidFindBy(id = "android:id/button1")
	private WebElement btnOk;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/notes_input")
	public WebElement txtNotes;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/okButton_AddContact")
	public WebElement btnSave;

	public NewContactActivity(AndroidDriver driver) {
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
