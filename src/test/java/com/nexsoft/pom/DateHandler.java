package com.nexsoft.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class DateHandler {

	private AndroidDriver driver;
	private TouchAction touchAct;

	@FindBy(id = "com.apozas.contactdiary:id/eventdate_input")
	private WebElement pDateStart;
	@FindBy(id = "com.apozas.contactdiary:id/endeventdate_input")
	private WebElement pDateEnd;
	@FindBy(id = "android:id/date_picker_header_year")
	private WebElement pYear;
	@FindBy(id = "android:id/button2")
	private WebElement layCancel;
	@FindBy(id = "android:id/button1")
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
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=" + "\"" + date + " " + month + " " + year + "\"" + "]"))
				.click();
		layOk.click();
	}

	public void dateEndHandler(int posX, int posY, String date, String month, String year) {
		pDateEnd.click();
		touchAct.tap(PointOption.point(posX, posY)).perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=" + "\"" + date + " " + month + " " + year + "\"" + "]"))
				.click();
		layOk.click();
	}
}
