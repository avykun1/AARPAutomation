package com.cucumber.framework.runner.Demographic;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CucumberOptions(features = { "classpath:featurefile/C71604_ContactDemographic/F511036_SF_AddressChanges/AddressCascadingFromHouseholdToPersonAccount.feature" }, glue = {
		"classpath:com.cucumber.framework.stepdefinition",
		"classpath:com.cucumber.framework.TestBase" },plugin = {"json:target/negative/cucumber.json", "pretty", "html:target/negative/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
		tags = {"@Smoke","@Regression"}
)

public class AddressCascadeFromHH_to_PA_Runner extends AbstractTestNGCucumberTests {
	@BeforeClass
		public static void setup() {
		// Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String strScenarioName = "Address Cascade from Household to Person Account";

		String userdir=System.getProperty("user.dir");
		String fileName ="C:\\Extent_Reports\\"+strDate+"_"+strScenarioName+".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);

		//ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File("C:\\Users\\vvenkat2\\Downloads\\cucumber-testing-master\\ExtenReports\\extentreports.html"),false);
		// Loads the extent config xml to customize on the report.
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "v11.0");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.6.0");

		// Also you can add system information using a hash map
		Map systemInfo = new HashMap();
		systemInfo.put("Cucumber version", "v1.2.3");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}

	}


