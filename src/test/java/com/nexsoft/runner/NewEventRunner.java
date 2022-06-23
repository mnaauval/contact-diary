package com.nexsoft.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/NewEvent.feature", 
glue = "com.nexsoft.definitions")
public class NewEventRunner extends AbstractTestNGCucumberTests {

}
