package com.cucumber.framework.TestBase;

import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.utility.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.cucumber.framework.TestBase.TestBase.driver;

/**
 * Created by gveenam on 9/24/2020.
 */
public class SauceLabs {
    public static Logger log = LoggerHelper.getLogger(TestBase.class);


    public static PropertyFileReader configProps = new PropertyFileReader("/src/main/resources/configfile/config.properties");
    public static final String USERNAME = configProps.getProperty("SauceUserName");
    public static final String ACESSKEY=configProps.getProperty("AccessKey");
    public static DesiredCapabilities capabilities;


  /*  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY
            + "@ondemand.saucelabs.com:443/wd/hub";*/


  public static final String URL="https://sso-"+USERNAME+":"+ACESSKEY+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";
  //public static final String URL="https://sso-optum-veena_ganji:efdd821a-9acd-4812-851f-b4f87e59d916@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public WebDriver getChromeDriver() {
        WebDriver webDriver=null;



        String sauceLabsTunnelIdentifier="Optum-Prd";
        capabilities = DesiredCapabilities.chrome();

        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "89.0");
        capabilities.setCapability("screenResolution", "1920x1080");
        //capabilities.setCapability("parent-tunnel", "sauce_admin");
        capabilities.setCapability("parent-tunnel", "optumtest");
        capabilities.setCapability("tunnelIdentifier",
                sauceLabsTunnelIdentifier);
        //capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");                 //capabilities.setCapability("name", "MRATDD-TestSuite");
        //capabilities.setCapability("tunnelIdentifier", "Optum-Prd");
        capabilities.setCapability("build", System.getProperty("BuildNo"));
        String jobName = "Build No:"+System.getProperty("BuildNo")+"_"+ TestBase.featureName +"_" + capabilities.getBrowserName() + "_" + System.getProperty("Environment");
        capabilities.setCapability("name", jobName);
        capabilities.setCapability("recordMp4", true);
      /*  capabilities.setCapability("commandTimeout", 600);
        capabilities.setCapability("maxDuration", 1200);

        capabilities.setCapability("idleTimeout", 120);*/
        try {
            System.out.println("URL="+URL);
            webDriver = new RemoteWebDriver(new URL(URL), capabilities);

          /*  MRScenario.sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
            System.out.println("Session ID:" + (((RemoteWebDriver) webDriver).getSessionId()).toString());
            getJobURL(getSessionId());*/
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return webDriver;
    }
    public WebDriver getIEDriver() {
        WebDriver webDriver=null;



        String sauceLabsTunnelIdentifier="Optum-Prd";
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "11.0");
        capabilities.setCapability("screenResolution", "1920x1080");
        //capabilities.setCapability("parent-tunnel", "sauce_admin");
        capabilities.setCapability("parent-tunnel", "optumtest");
        capabilities.setCapability("tunnelIdentifier",
                sauceLabsTunnelIdentifier);
        //capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");                 //capabilities.setCapability("name", "MRATDD-TestSuite");
        //capabilities.setCapability("tunnelIdentifier", "Optum-Prd");
        capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
        String jobName = "Salesforce Test Execution - Using " + capabilities.getBrowserName() + " in  " +
        System.getProperty("Environment") +" environment";
        capabilities.setCapability("name", jobName);
        capabilities.setCapability("recordMp4", true);
        try {
            webDriver = new RemoteWebDriver(new URL(URL), capabilities);
            System.out.println("URL="+URL);
          /*  MRScenario.sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
            System.out.println("Session ID:" + (((RemoteWebDriver) webDriver).getSessionId()).toString());
            getJobURL(getSessionId());*/
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return webDriver;
    }
    public WebDriver getFirefoxDriver() {
        WebDriver webDriver=null;



        String sauceLabsTunnelIdentifier="Optum-Prd";
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "66.0");
        capabilities.setCapability("screenResolution", "1920x1080");
        //capabilities.setCapability("parent-tunnel", "sauce_admin");
        capabilities.setCapability("parent-tunnel", "optumtest");
        capabilities.setCapability("tunnelIdentifier",
                sauceLabsTunnelIdentifier);
        //capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");                 //capabilities.setCapability("name", "MRATDD-TestSuite");
        //capabilities.setCapability("tunnelIdentifier", "Optum-Prd");
        capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
        String jobName = "Siebel Contact Center Execution - Using " + capabilities.getBrowserName() + " in  " + configProps.getProperty("ENV") +" environment";
        capabilities.setCapability("name", jobName);
        capabilities.setCapability("recordMp4", true);
        try {
            webDriver = new RemoteWebDriver(new URL(URL), capabilities);
            System.out.println("URL="+URL);
          /*  MRScenario.sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
            System.out.println("Session ID:" + (((RemoteWebDriver) webDriver).getSessionId()).toString());
            getJobURL(getSessionId());*/
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return webDriver;
    }

    public WebDriver getIEEdgeDriver() {
        WebDriver webDriver=null;



        String sauceLabsTunnelIdentifier="Optum-Prd";
        DesiredCapabilities capabilities = DesiredCapabilities.edge();

        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "88.0");
        capabilities.setCapability("screenResolution", "1920x1080");
        //capabilities.setCapability("parent-tunnel", "sauce_admin");
        capabilities.setCapability("parent-tunnel", "optumtest");
        capabilities.setCapability("tunnelIdentifier",
                sauceLabsTunnelIdentifier);
        //capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");                 //capabilities.setCapability("name", "MRATDD-TestSuite");
        //capabilities.setCapability("tunnelIdentifier", "Optum-Prd");
        capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
        String jobName = "Siebel Contact Center Execution - Using " + capabilities.getBrowserName() + " in  " + configProps.getProperty("ENV") +" environment";
        capabilities.setCapability("name", jobName);
        capabilities.setCapability("recordMp4", true);
        try {
            webDriver = new RemoteWebDriver(new URL(URL), capabilities);
            System.out.println("URL="+URL);
          /*  MRScenario.sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
            System.out.println("Session ID:" + (((RemoteWebDriver) webDriver).getSessionId()).toString());
            getJobURL(getSessionId());*/
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return webDriver;
    }


    public void setResult(boolean status){
        RestAssured.baseURI="https://saucelabs.com/rest/v1";
        String validRequest = "{\n" +
                "  \"passed\": "+status+"\n" +
                "}";


        String tagName = System.getProperty("Tag");
    String path="/sso-"+configProps.getProperty("SauceUserName")+"/jobs/"+((RemoteWebDriver) TestBase.driver).getSessionId().toString();
        Response response = RestAssured.given()
                .auth()
                .preemptive()
                .basic("sso-"+configProps.getProperty("SauceUserName"), configProps.getProperty("AccessKey"))
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(validRequest)
                .put(path)
                .then().extract().response();
        log.info(response.getStatusCode());









    }
/*
    public void getJobURL(String jobID) {
        String digest = hmacDigest(jobID, USERNAME + ":" + ACCESS_KEY, "HmacMD5");
        JobURL = "https://saucelabs.com/jobs/" + jobID + "?auth=" + digest;
        System.out.println("JobURL ---" + JobURL);
    }*/


}
