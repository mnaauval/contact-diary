package com.nexsoft.definitions.newcontact;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nexsoft.pom.MainActivity;
import com.nexsoft.pom.NewContactActivity;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewContactDefine {

	private AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private MainActivity mainAct;
	private NewContactActivity newContact;
	private List<String> choice;
	private WebDriverWait wait;

	@Before
	public void init() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("uid", "52c5c997");
//		capabilities.setCapability("uid", "emulator-5554");
		capabilities.setCapability("appPackage", "com.apozas.contactdiary");
		capabilities.setCapability("appActivity", "com.apozas.contactdiary.MainActivity");

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainAct = new MainActivity(driver);
		newContact = new NewContactActivity(driver);
		choice = new ArrayList<String>();
		choice.add("2");
		choice.add("4");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Given("User at Main Activity")
	public void atMainActivity() {
		String actl = mainAct.lblDiary.getText();
		String expt = "Contact Diary";
		Assert.assertEquals(actl, expt);
		System.out.println(actl);
	}

	@When("User tap add button")
	public void clickAddBtn() {
		mainAct.clickAddBtn();
	}
	
	@And("User tap create new contact button")
	public void clickNewEvent() {
		mainAct.clickNewContacttBtn();
	}
	
	@And("User go to New Contact Activity")
	public void atContactActivity() {
		String actl = newContact.lblNew.getText();
		String expt = "New contact";
		Assert.assertEquals(actl, expt);
		System.out.println(actl);
	}

	@And("User input contact name {string} and place {string}")
	public void inputNameAndPlace(String name, String place) {
		newContact.txtName.sendKeys(name);
		newContact.txtPlace.sendKeys(place);
		System.out.println(name);
		System.out.println(place);
	}

	@And("User input start date {string} and end date {string}")
	public void inputDate(String start, String end) {
		newContact.setStartDateContact(start);
		newContact.setEndDateContact(end);
		System.out.println(start);
		System.out.println(end);
	}
	
	@And("User input phone {string} and notes {string}")
	public void inputPhoneAndNotes(String phone, String notes) {
		newContact.txtPhone.sendKeys(phone);
		newContact.txtNotes.sendKeys(notes);
		System.out.println(phone);
		System.out.println(notes);
	}
	
	@And("User choose known and type")
	public void inputRadioAndCheckbox() {
		newContact.typeIndoors.click();
		newContact.knownYes.click();
		newContact.setMitigation(choice);
	}
	
	@Then("User save new contact")
	public void clickBtnSave() {
//		newContact.screenshoot(driver);
		newContact.btnSave.click();
	}
	
	@And("Contact showed in Main Activity")
	public void showContacts() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> lstElement = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//android.widget.TextView[@resource-id='com.apozas.contactdiary:id/list_item']")));

		String unknownChar = "👤";
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String contact = webElement.getText().replace(unknownChar, "").trim();
			System.out.println(contact);
			if (contact.equalsIgnoreCase("Flopson")) {
				checkData = true;
				break;
			}
		}
		assertTrue(checkData);
	}
	
	@After
	public void closeConn() {
		newContact.screenshoot(driver);
		driver.quit();
	}
}
