package com.cucumber.framework.TestBase;

import com.cucumber.framework.utility.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by gveenam on 9/24/2020.
 */
public class LocalWebDriver {
    WebDriver driver;
    public WebDriver setupChromeDriver(){
        ChromeOptions option = new ChromeOptions();
        //added to remove popup and
        option.setExperimentalOption("useAutomationExtension", false);
        option.addArguments("start-maximized");
        //   DesiredCapabilities chrome = DesiredCapabilities.chrome();
       /*option.addArguments("--incognito");*/

       /* chrome.setJavascriptEnabled(true);
        chrome.setCapability(ChromeOptions.CAPABILITY, option);
     */   if (System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver"));
            driver= new ChromeDriver(option);
        }
        else if(System.getProperty("os.name").contains("Window")){
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
            driver= new ChromeDriver(option);
        }
        return driver;
    }
/*
    public  WebDriver setupFirefoxDriver() {
        DesiredCapabilities firefox = DesiredCapabilities.firefox();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        firefox.setCapability(FirefoxDriver.PROFILE, profile);
        firefox.setCapability("marionette", true);
        if (System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriver"));
            driver= new FirefoxDriver(firefox);
        }
        else if(System.getProperty("os.name").contains("Window")){
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriver.exe"));
            driver= new FirefoxDriver(firefox);
        }
        return driver;
    }*/

    public WebDriver setupIEEdgeDriver() {



        EdgeOptions option = new EdgeOptions();

        option.setCapability("UseChromium",true);
        //added to remove popup and
        // option.set
        //commented for the Edge
     /*   option.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
       option.setExperimentalOption("useAutomationExtension", false);

        option.addArguments("start-maximized");
     option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));*/
        //commented for the Edge
     /*System.setProperty("webdriver.ie.driver.loglevel","INFO");
        System.setProperty("webdriver.ie.driver.logfile","C:\\IEServerlog.log");
*/
        System.setProperty("webdriver.edge.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/msedgedriver.exe"));

        driver=new EdgeDriver(option);
        return driver;
    }


    public WebDriver setupIEDriver() {
        // cap.setBrowserName("internet explorer");

        // capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true)
        //  cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,
        //  ElementScrollBehavior.BOTTOM);
        //    cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//        ?
        //  cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        // cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        //cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);*/

        //  cap.setJavascriptEnabled(true);
        System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/IEDriverServer.exe"));
        return new InternetExplorerDriver();
    }
}
