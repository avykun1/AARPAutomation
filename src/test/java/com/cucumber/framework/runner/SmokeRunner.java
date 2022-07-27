package com.cucumber.framework.runner;
import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CucumberOptions(features = { "classpath:featurefile" }, glue = {
        "classpath:com.cucumber.framework.stepdefinition",
        "classpath:com.cucumber.framework.TestBase" },tags={"@Smoke"},plugin = {"json:target/negative/cucumber.json", "pretty", "html:target/negative/cucumber.html"})


public class SmokeRunner extends AbstractTestNGCucumberTests  {
    @BeforeClass
    public static void setup() {

    }

}
