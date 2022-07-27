package com.cucumber.framework.TestBase;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import com.cucumber.framework.PageObject.Login.HomePage;

import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.utility.ExcelReader;
import com.cucumber.framework.utility.PropertyFileReader;
/*
import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;*/
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.swing.plaf.synth.SynthEditorPaneUI;


/**
 * 
 * @author bsingh5
 *
 */
public class TestBase {

    public static Logger log = LoggerHelper.getLogger(TestBase.class);

    public static WebDriver driver;
    public static PropertyFileReader configProps = new PropertyFileReader("/src/main/resources/configfile/config.properties");
    public static String featureName = "";
    //	public static String userName;
    public static String password = "";
    public static String userName = "";
    public static String scenarioName;
    public static String environment;

 /*   protected static ThreadLocal<SauceSession> session = new ThreadLocal<>();
    protected static ThreadLocal<SauceOptions> options = new ThreadLocal<>();

    public SauceSession getSession() {
        return session.get();
    }*/


    public static JavascriptExecutor js;
//	public static SoftAssert softAssert;
    //public static String scenarioName="";

    //Intialize the driver


    public void launchURL() {
        String url = null;
        environment=System.getProperty("environment");

      if (environment.equalsIgnoreCase("Prod")) {
            url = "https://login.salesforce.com/";
        } else {
          url = "https://test.salesforce.com/";
        }
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().deleteAllCookies();
    }


   /* @BeforeSuite
    public void initialize(){



    }*/

    @Before
    public void before(Scenario scenario) throws Throwable {

        String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
        featureName =rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);


        System.out.println("Running:"+featureName);
        scenarioName = scenario.getName().trim();


        log.info("Running ..." + scenarioName);

        String browserType= System.getProperty("Browser");
        if(System.getProperty("Browser")==null ||System.getProperty("Browser").equalsIgnoreCase("${Browser}")){
            browserType="Chrome";
        }



        if (!Boolean.parseBoolean(configProps.getProperty("IsSauceLabsSelected"))) {
            LocalWebDriver localWebDriver = new LocalWebDriver();

            if (browserType==null ||browserType.equalsIgnoreCase("Chrome")) {
                driver = localWebDriver.setupChromeDriver();

            } else if (browserType.equalsIgnoreCase("Firefox")) {
                //  driver = setupFirefoxDriver();


            } else if (browserType.equalsIgnoreCase("Iexplorer")) {
                driver = localWebDriver.setupIEDriver();

            } else if (browserType.equalsIgnoreCase("IEEdge")) {
                driver = localWebDriver.setupIEEdgeDriver();


            }
        } else {
            SauceLabs sauceLabs = new SauceLabs();
            if (browserType==null ||browserType.equalsIgnoreCase("Chrome")) {
                driver = sauceLabs.getChromeDriver();

            } else if (browserType.equalsIgnoreCase("Firefox")) {
                driver = sauceLabs.getFirefoxDriver();


            } else if (browserType.equalsIgnoreCase("Iexplorer")) {
                driver = sauceLabs.getIEDriver();

            } else if (browserType.equalsIgnoreCase("IEEdge")) {
                driver = sauceLabs.getIEEdgeDriver();


            }

        }


        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(configProps.getProperty("PageLoadTimeOut")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(configProps.getProperty("ImplcitWait")), TimeUnit.SECONDS);

        launchURL();
        log.info(((RemoteWebDriver) driver).getSessionId().toString());

        ExcelReader.readExcel(scenarioName);


    }



    @After
    public void after(Scenario scenario) throws Exception {
        //   GenericFunctions.acceptAlert();
        if(Boolean.parseBoolean(configProps.getProperty("IsSauceLabsSelected"))) {
            new SauceLabs().setResult(!scenario.isFailed());
        }
        if(scenario.isFailed()){
            log.info(scenario+ "is failed at "+driver.getCurrentUrl());
            embedScreenshot(scenario);

           // SauceLabs.capabilities.setCapability("Passed",true);
        }
        else{
           // SauceLabs.capabilities.setCapability("Passed",false);
        }
        HomePage homePage = new HomePage();

        homePage.logout();
        System.out.println(scenario.getStatus() + " " + scenario.getName());





        driver.quit();
//Add here later



    }


    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        } catch (WebDriverException noscreenshotSupport) {
            //System.err.println("Cannot take screenshot");
        }
    }


}






