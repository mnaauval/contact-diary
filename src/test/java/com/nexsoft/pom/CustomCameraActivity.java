package com.nexsoft.pom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomCameraActivity {

	private AndroidDriver driver;
	private WebDriverWait wait;

	@AndroidFindBy(id = "com.dimatt.camtest:id/btn_capture1")
	public WebElement btnCamera;
	@AndroidFindBy(id = "com.dimatt.camtest:id/back_camera_preview")
	public WebElement previewBackCam;
	@AndroidFindBy(id = "com.dimatt.camtest:id/front_camera_preview")
	public WebElement previewFrontCam;

	public CustomCameraActivity(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void takePicture() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.dimatt.camtest:id/btn_capture1"))).click();
	}
}
