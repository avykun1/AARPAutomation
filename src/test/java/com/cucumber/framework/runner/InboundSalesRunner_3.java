package com.cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = { "classpath:featurefile" }, glue = {
        "classpath:com.cucumber.framework.stepdefinition",
        "classpath:com.cucumber.framework.TestBase" },tags={"@Delta-InboundSales-3"},plugin = {"json:target/negative/cucumber.json", "pretty", "html:target/negative/cucumber.html"})

public class InboundSalesRunner_3 extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {

    }
}