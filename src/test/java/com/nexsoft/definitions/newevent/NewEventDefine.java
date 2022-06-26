package com.nexsoft.definitions.newevent;

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
import com.nexsoft.pom.NewEventActivity;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewEventDefine {

	private AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private MainActivity mainAct;
	private NewEventActivity newEv;
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
		newEv = new NewEventActivity(driver);
		choice = new ArrayList<String>();
		choice.add("1");
		choice.add("3");
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

	@And("User tap create new event button")
	public void clickNewEvent() {
		mainAct.clickNewEventBtn();
	}

	@And("User go to New Event Activity")
	public void atEventActivity() {
		String actl = newEv.lblNew.getText();
		String expt = "New event";
		Assert.assertEquals(actl, expt);
		System.out.println(actl);
	}

	@And("User input event name {string} and event place {string}")
	public void inputNameAndPlace(String name, String place) {
		newEv.txtName.sendKeys(name);
		newEv.txtPlace.sendKeys(place);
		System.out.println(name);
		System.out.println(place);
	}

	@And("User input start date {string} and end date {string}")
	public void inputDate(String start, String end) {
		newEv.setStartDateEvent(start);
		newEv.setEndDateEvent(end);
		System.out.println(start);
		System.out.println(end);
	}

	@And("User input companions {string} and phone {string}")
	public void inputPeopleAndPhone(String people, String phone) {
		newEv.txtPeople.sendKeys(people);
		newEv.txtContact.sendKeys(phone);
		System.out.println(people);
		System.out.println(phone);
	}

	@And("User choose encounter type and prevention type")
	public void inputRadioAndCheckBox() {
		newEv.typeIndoors.click();
		newEv.setMitigation(choice);
	}

	@And("User input notes {string}")
	public void inputNotes(String notes) {
		newEv.txtNotes.sendKeys(notes);
		System.out.println(notes);
	}

	@Then("User save new event")
	public void clickBtnSave() {
		newEv.btnSave.click();
	}

	@And("Event showed in Main Activity")
	public void showEvents() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> lstElement = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//android.widget.TextView[@resource-id='com.apozas.contactdiary:id/list_item']")));

//		String unknownChar = "👤";
		String unknownChar = "📅";
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String event = webElement.getText().replace(unknownChar, "").trim();
			System.out.println(event);
			if (event.equalsIgnoreCase("Tourney1")) {
				checkData = true;
				break;
			}
		}
		assertTrue(checkData);
	}
	
	@After
	public void closeConn() {
		driver.quit();
	}
}
