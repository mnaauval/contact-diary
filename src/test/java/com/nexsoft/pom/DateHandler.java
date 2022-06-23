package com.nexsoft.pom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DateHandler {

	private AndroidDriver driver;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventdate_input")
	private WebElement pickDateStart;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/endeventdate_input")
	private WebElement pickDateEnd;
	@AndroidFindBy(id = "android:id/date_picker_header_year")
	private WebElement headYear;
	@AndroidFindBy(id = "android:id/date_picker_header_date")
	private WebElement headDate;
	@AndroidFindBy(id = "android:id/prev")
	private WebElement prevYearBtn;
	@AndroidFindBy(id = "android:id/next")
	private WebElement nextYearBtn;
	@AndroidFindBy(id = "android:id/button2")
	private WebElement btnCancel;
	@AndroidFindBy(id = "android:id/button1")
	private WebElement btnOk;

	public DateHandler(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void setStartDate(String dateInput) {
		pickDateStart.click();
		String date = headDate.getText();
		String year = headYear.getText();
		System.out.println(date + " " + year);

		Date dateCalendar = null;
		try {
//			EEE, MMM d yyyy
//			Wed, Jun 1 2022
			dateCalendar = new SimpleDateFormat("EEE, MMM d yyyy", Locale.US).parse(date + " " + year);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Date dateUsers = null;
		try {
			dateUsers = new SimpleDateFormat("ddMMyyy", Locale.US).parse(dateInput);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		int currYear = dateCalendar.getYear();
		int currMonth = dateCalendar.getMonth();

		int targetYear = dateUsers.getYear();
		int targetMonth = dateUsers.getMonth();

		int stepYear = Math.abs((currYear - targetYear) * 12);
		int stepMonth = Math.abs((currMonth - targetMonth));

		int step = stepYear + stepMonth;
		System.out.println(stepYear + " " + stepMonth + " " + step);
		if (currYear < targetYear) {
			for (int i = 0; i < step; i++) {
				nextYearBtn.click();
			}
		} else if (currYear > targetYear) {
			for (int i = 0; i < step; i++) {
				prevYearBtn.click();
			}
		}

		if (stepYear == 0) {
			if (currMonth < targetMonth) {
				for (int i = 0; i < step; i++) {
					nextYearBtn.click();
				}
			} else if (currMonth > targetMonth) {
				for (int i = 0; i < step; i++) {
					prevYearBtn.click();
				}
			}
		}

		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + dateFormat.format(dateUsers) + "\"]"))
				.click();
		btnOk.click();
	}

	public void setEndDate(String dateInput) {
		pickDateEnd.click();
		String date = headDate.getText();
		String year = headYear.getText();
		System.out.println(date + " " + year);

		Date dateCalendar = null;
		try {
//			EEE, MMM d yyyy
//			Wed, Jun 1 2022
			dateCalendar = new SimpleDateFormat("EEE, MMM d yyyy", Locale.US).parse(date + " " + year);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Date dateUsers = null;
		try {
			dateUsers = new SimpleDateFormat("ddMMyyy", Locale.US).parse(dateInput);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		int currYear = dateCalendar.getYear();
		int currMonth = dateCalendar.getMonth();

		int targetYear = dateUsers.getYear();
		int targetMonth = dateUsers.getMonth();

		int stepYear = Math.abs((currYear - targetYear) * 12);
		int stepMonth = Math.abs((currMonth - targetMonth));

		int step = stepYear + stepMonth;
		System.out.println(stepYear + " " + stepMonth + " " + step);
		if (currYear < targetYear) {
			for (int i = 0; i < step; i++) {
				nextYearBtn.click();
			}
		} else if (currYear > targetYear) {
			for (int i = 0; i < step; i++) {
				prevYearBtn.click();
			}
		}

		if (stepYear == 0) {
			if (currMonth < targetMonth) {
				for (int i = 0; i < step; i++) {
					nextYearBtn.click();
				}
			} else if (currMonth > targetMonth) {
				for (int i = 0; i < step; i++) {
					prevYearBtn.click();
				}
			}
		}

		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + dateFormat.format(dateUsers) + "\"]"))
				.click();
		btnOk.click();
	}

}
