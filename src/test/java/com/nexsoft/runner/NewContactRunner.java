package com.nexsoft.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/NewContact.feature", 
glue = "com.nexsoft.definitions.newcontact")
public class NewContactRunner extends AbstractTestNGCucumberTests {

}
