package com.nexsoft.pom.newevent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class DateHandler {

	private AndroidDriver driver;
	private TouchAction touchAct;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventdate_input")
	private WebElement pDateStart;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/endeventdate_input")
	private WebElement pDateEnd;
	@AndroidFindBy(id = "android:id/date_picker_header_year")
	private WebElement pYear;
	@AndroidFindBy(id = "android:id/date_picker_header_date")
	private WebElement headDate;
	@AndroidFindBy(id = "android:id/prev")
	private WebElement prevYearBtn;
	@AndroidFindBy(id = "android:id/next")
	private WebElement nextYearBtn;
	@AndroidFindBy(id = "android:id/button2")
	private WebElement layCancel;
	@AndroidFindBy(id = "android:id/button1")
	private WebElement layOk;

	public DateHandler(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		touchAct = new TouchAction(driver);
	}

	public void dateStartHandler(int fromX, int fromY, int toX, int toY, int posX, int posY, String date, String month,
			String year) {
		pDateStart.click();
		pYear.click();
		touchAct.press(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
		touchAct.tap(PointOption.point(posX, posY)).perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println(pYear.getText());
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=" + "\"" + date + " " + month + " " + year + "\"" + "]"))
				.click();
		layOk.click();
	}

	public void dateStartHandler(String date, String month, String year) {
		pDateStart.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println(pYear.getText());
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=" + "\"" + date + " " + month + " " + year + "\"" + "]"))
				.click();
		layOk.click();
	}

	public void dateEndHandler(int posX, int posY, String date, String month, String year) {
		pDateEnd.click();
		touchAct.tap(PointOption.point(posX, posY)).perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println(pYear.getText());
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=" + "\"" + date + " " + month + " " + year + "\"" + "]"))
				.click();
		layOk.click();
	}

	public void dateEndHandler(String date, String month, String year) {
		pDateEnd.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println(pYear.getText());
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=" + "\"" + date + " " + month + " " + year + "\"" + "]"))
				.click();
		layOk.click();
	}

	public void setDate(String dateInput) {
		pDateStart.click();
		String date = headDate.getText();
		String year = pYear.getText();
		System.out.println(date + " " + year);

		Date dateCalendar = null;
		try {
//			EEE, MMM d yyyy
//			Wed, Jun 1 2022
			dateCalendar = new SimpleDateFormat("EEE, MMM d yyyy").parse(date + " " + year);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Date dateUsers = null;
		try {
			dateUsers = new SimpleDateFormat("ddMMyyy").parse(dateInput);
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

		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + dateFormat.format(dateUsers) + "\"]"))
				.click();
		layOk.click();

	}

}
