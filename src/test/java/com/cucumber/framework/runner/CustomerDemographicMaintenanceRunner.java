package com.cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = { "classpath:featurefile" }, glue = {
        "classpath:com.cucumber.framework.stepdefinition",
        "classpath:com.cucumber.framework.TestBase" },tags={"@Core-CustomerDemographicMaintenance"},plugin = {"json:target/negative/cucumber.json", "pretty", "html:target/negative/cucumber.html"})

public class CustomerDemographicMaintenanceRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {

    }
}
