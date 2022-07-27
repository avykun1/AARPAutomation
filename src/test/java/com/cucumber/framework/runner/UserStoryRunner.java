package com.cucumber.framework.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = { "classpath:featurefile" }, glue = {
        "classpath:com.cucumber.framework.stepdefinition",
        "classpath:com.cucumber.framework.TestBase" },tags={"@US3481733"},plugin = {"json:target/negative/cucumber.json", "pretty", "html:target/negative/cucumber.html"})


public class UserStoryRunner extends AbstractTestNGCucumberTests  {

    @DataProvider(parallel = true)

   public Object[][] scenarios(){
        return super.features();

    }

}
