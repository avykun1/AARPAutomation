package com.cucumber.framework.helper;


import com.cucumber.framework.utility.DateTimeHelper;
import com.cucumber.framework.utility.ResourceHelper;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.*;

import gherkin.lexer.No;
import org.apache.commons.io.FileUtils;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import com.cucumber.framework.TestBase.TestBase;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static com.cucumber.framework.TestBase.TestBase.js;


public class GenericFunctions {

    private static final Logger log = LoggerHelper.getLogger(GenericFunctions.class);
    //static WebDriver driver=TestBase.driver;

    /*
     * This method used to read the value from the test field
     * @Param: element-Action to be perfomed on an element
     * @Author: Vasanth
     * @Modified By: N/A
     */
    public static String readFiefldvalueJs(WebElement element) {
        if (element == null) {
            log.info("weblement is null");
            return null;
        }

        boolean displayed = false;
        try {
            displayed = element.isDisplayed();
        } catch (Exception e) {
            log.error(e);
            return null;
        }

        if (!displayed)
            return null;

        //String value = (String)(js.executeScript("return arguments[0].value", driver.findElement(By.name("s_2_1_146_0"))));
        String value = (String) (js.executeScript("return arguments[0].value", element));
        log.info("Field value read as: " + value);
        return value;
    }

    /*
     * This method used to remove the special Charaters in a String
     * @Param: element-Action to be perfomed on an element
     * @Author: Vasanth
     * @Modified By: N/A
     */

    public static String removeSplChar(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        log.info("Special Char has been removed from the String " + s);
        return s;

    }

     /*
     * This method used verify whether the element is enabled or disabled
     * Returns the boolean value
     * @Param: element-Action to be perfomed on an element
     * @Author: Vasanth
     * @Modified By: N/A
     */

    public static boolean isEnabled(WebElement webElement) {

        WaitHelper.waitForElementVisible(webElement,20);

        if (webElement.isEnabled()) {
            log.info("This WebElement is enabled : " + webElement.getText());
            return true;
        } else {
            log.info("This WebElement is not enabled : " + webElement.getText());
            return false;
        }

    }
     /*
     * This method used verify whether the element is displayed on the page
     * Returns the boolean value
     * @Param: element-Action to be perfomed on an element
     * @Author: Vasanth
     * @Modified By: N/A
     */

    public static boolean isDisplayed(WebElement element, String locatorName) {

        WaitHelper.waitForElementVisible(element,20);
        try {
            element.isDisplayed();
            log.info(locatorName + " is displayed");

            return true;
        } catch (Exception e) {
            log.info("fail: " + locatorName + " is not displayed");
            return false;
        }

    }

    /*
     * This method used get the element Text
     * Returns the text as String
     * @Param: element-Action to be perfomed on an element
     * @Author: Vasanth
     * @Modified By: N/A
     */

    public static String getElementText(WebElement element) {
        WaitHelper.waitForElementVisible(element,20);
        if (null == element) {
            log.info("weblement is null");
            return null;
        }
        String elementText = null;
        try {
            elementText = element.getText();
        } catch (Exception ex) {
            log.info("Element not found " + ex);
        }
        return elementText;
    }

    /*
     * This method used Take the screenshot
     * Returns path of the file as String
     * @Param: name- Name of the Screenshot
     * @Author: Vasanth
     * @Modified By: N/A
     */
    public static String takeScreenShot(String name) throws IOException {


        File destDir = new File(ResourceHelper.getResourcePath("screenshots/") + DateTimeHelper.getCurrentDate());
        if (!destDir.exists())
            destDir.mkdir();

        File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + name + ".jpg");
        try {
            FileUtils.copyFile(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE), destPath);
        } catch (IOException e) {
            log.error(e);
            throw e;
        }
        log.info(destPath.getAbsolutePath());
        return destPath.getAbsolutePath();
    }

     /*
     * This method used click an element
     * @Param: element- Action to be perfomed on an element
     * @Param: loctorName- Name of the Locator displayed in the Page
     * @Author: Veena
     * @Modified By: N/A
     */

    public static void click(WebElement element, String locatorName) {

        WaitHelper.waitForElementClickable(element,20);

        System.out.println("element focused on click : "+element);
        System.out.println("Locator name that is clicked : "+ locatorName);

        try {
          //  highlightElement(element);
            element.click();
            log.info(locatorName + " is clicked");
        } catch (Exception e) {
            log.error(locatorName + "is not clicked");
           // log.error(e.getMessage());
        }


    }

    public static void highlightElement(WebElement ele) {

        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid yellow;');", ele);
    }

    /*
    * This method used enter value in an element
    * @Param: element-The action to be performed on an element
    * @Param: value-Value to be entered on an element
    * @locatorName: Name of the element that is displayed on the page
    * @Author: Veena
    * @Modified By: N/A
    */
    public static void type(WebElement element, String value, String locatorName) {

        WaitHelper.waitForElementVisible(element,20);

        try {
          element.clear();
            element.sendKeys(value);
            if(!(locatorName.equalsIgnoreCase("username")|| locatorName.equalsIgnoreCase("password"))){
                log.info(locatorName + " is enter with the " + value);
            }


        } catch (NoSuchElementException e) {
            log.error("Data typing action is not perform on " + locatorName + " with data is " + value);
        }
    }

    /*
    * This method used select the combobox by index
    * @Param: element-The action to be performed on an element
    * @Param: index-Index of the option
    * @locatorName: Name of the element that is displayed on the page
    * @Author: Veena
    * @Modified By: N/A
    */

    public static void Index(WebElement element, int index, String locatorName) {
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            log.info("Option at index " + index + " is Selected from the DropDown" + locatorName);
        } catch (NoSuchElementException | ElementNotSelectableException e) {
            log.error("Option at index " + index + " is  not Selected from the DropDown" + locatorName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
     /*
    * This method used select the combobox by value
    * @Param: element-The action to be performed on an element
    * @Param: value- Value to be selected from the combobox
    * @locatorName: Name of the element that is displayed on the page
    * @Author: Veena
    * @Modified By: N/A
    */

    public static void selectByValue(WebElement element, String value, String locatorName) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            log.info("Option with value attribute " + value + " is  Selected from the DropDown " + locatorName);
        } catch (NoSuchElementException | ElementNotSelectableException e) {
            log.error("Option with value attribute " + value + " is not Selected from the DropDown " + locatorName);

        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    /**
     * This method used select the combobox by text
     *
     * @Param: element-The action to be performed on an element
     * @Param: visibleText- VisibleText to be selected from the combobox
     * @locatorName: Name of the element that is displayed on the page
     * @Author: Veena
     * @Modified By: N/A
     */


    public static void selectByVisibleText(WebElement element, String visibletext, String locatorName) {
        try {
            Select s = new Select(element);
            s.selectByVisibleText(visibletext);
            log.info(visibletext + "  is Selected from the DropDown " + locatorName);
        } catch (NoSuchElementException | ElementNotSelectableException e) {
            log.error(visibletext + " is Not Select from the DropDown " + locatorName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    /**
     * This method used to return the element
     *
     * @Param: By-The action to be performed on an element
     * @Author: Vasanth
     * @Modified By: N/A
     */


   public static WebElement getElement(By locator) {
        try{
            //System.out.println("getElement : "+TestBase.driver.findElement(locator).getText());
            return TestBase.driver.findElement(locator);
        }
        catch (Exception e){
            return  null;
        }
    }




    /**
     * This method used to perform the click action using Java Script
     *
     * @Param: element-The action to be performed on an element
     * @Param: locatorName- The name of the element diplayed on the Page
     * @Author: Veena
     * @Modified By: N/A
     */

    public static void jSClick(WebElement element, String locatorName) {

        try {
            highlightElement(element);

            js.executeScript("arguments[0].click();", element);
            log.info(locatorName + " is clicked");

        } catch (Throwable e) {
            log.error(locatorName + " is not clicked");
        }
    }


    /**
     * This method used to perform mouseover on an element
     *
     * @Param element: The action to be performed on an element
     * @Param locatorName: The name of the element diplayed on the Page
     * @Author: Veena
     * @Modified By: N/A
     */

    public static void mouseHover(WebElement element, String locatorName) {
        boolean flag = false;
        try {
            new Actions(TestBase.driver).moveToElement(element).build().perform();
            log.info("Able to perfom mouse over on " + locatorName);
        } catch (NoSuchElementException e) {
            log.error("Unable to perfom mouse over on " + locatorName);
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method used to perform right click on an element
     *
     * @Param element: The action to be performed on an element
     * @Param locatorName: The name of the element diplayed on the Page
     * @Author: Veena
     * @Modified By: N/A
     */

    public static void rightClick(WebElement element, String locatorName) {

        try {

            Actions clicker = new Actions(TestBase.driver);
            clicker.contextClick(element).perform();
            log.info("Able to perfom right click on" + locatorName);

        } catch (NoSuchElementException e) {
            log.error("Unable to perform right click on " + locatorName);
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
    }

    public static String getUrL() {
        return TestBase.driver.getCurrentUrl();
    }


    /**
     * This method used to return the columnn count of the table
     *
     * @Param element: The action to be performed on an element
     * @Author: Veena
     * @Modified By: N/A
     */
    public int getColumncount(WebElement tr) {
        int a = 0;
        try {
            List<WebElement> columns = tr.findElements(By.tagName("td"));
            a = columns.size();
            System.out.println(columns.size());
            for (WebElement column : columns) {
                System.out.print(column.getText());
                System.out.print("|");
            }
        } catch (ElementNotVisibleException e) {
            log.error(tr + " element is not visible");
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        return a;

    }

    /**
     * This method used to wait until the element present
     *
     * @Param element: The action to be performed on an element
     * @Param waitElement: The element for which we need to wait for
     * @Param locatorName: The name of the element diplayed on the Page
     * @Author: Veena
     * @Modified By: N/A
     */
    public static void clickAndWaitForElementPresent(WebElement locator, WebElement waitElement, String locatorName) {
        boolean flag = false;
        try {
            click(locator, locatorName);
            WaitHelper.waitForElementPresent(waitElement, locatorName);
            log.info("Clicked on " + locatorName + " and waited till" + waitElement + "is presented");
        } catch (Exception e) {
            log.error("unable to click on " + locatorName);
        }
    }


    /**
     * This method used to return the row count of the table
     *
     * @Param element: The action to be performed on an element
     * @Author: Veena
     * @Modified By: N/A
     */

    public static int getRowCount(WebElement table) {

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a = rows.size() - 1;
        return a;
    }

    /**
     * This method used to accept the alert
     *
     * @return boolean: Return true if alert is presented and accepted otherwise return false
     * @Param element: The action to be performed on an element
     * @Author: Veena
     * @Modified By: N/A
     */

    public static void acceptAlert() {

        Alert alert = null;

        try {

            // Check the presence of alert
            alert = TestBase.driver.switchTo().alert();
            // if present consume the alert
            alert.accept();

            log.info("Alert is presented and accepted");
        } catch (NoAlertPresentException ex) {
            log.error("Alert is not presented");
        }

    }

    /**
     * To launch URL
     *
     * @param url : url value want to launch
     * @throws Throwable
     */
    public static void launchUrl(String url) {

        try {
            TestBase.driver.manage().deleteAllCookies();
            //driver.manage().window().maximize();
            TestBase.driver.navigate().to(url);
            //ImplicitWait();
            log.info("URL Launched successfully");

        } catch (Exception e) {
            log.error("URL is not launched");
        }
    }

    /**
     * This method used to verify whether the checkbox is checked or not
     *
     * @return boolean: Return true if checkbox is checked
     * @Param element: The action to be performed on an element
     * @Author: Veena
     * @Modified By: N/A
     */
    public static boolean isChecked(WebElement element, String locatorName) {
        WaitHelper.waitForElementVisible(element,20);

        boolean flag = false;
        try {
            if (element.isSelected()) {
                log.info(locatorName + "the checkbox is checked");
                flag = true;
            }

        } catch (NoSuchElementException e) {
            log.error(locatorName + "Checkbox is not checked");
            flag = false;
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        return flag;
    }


    /**
     * This method used to verify text of the element
     *
     * @return boolean: Return true if the element text matches with the expected text
     * @Param element: The action to be performed on an element
     * @Author: Veena
     * @Modified By: N/A
     */
    public static boolean verifyText(WebElement element, String text, String locatorName) {
        try {

            String vtxt = getElementText(element).trim();
            // text="General Program"; //need to delete
            if (vtxt.equals(text.trim())) {
                log.info(locatorName + "text:" + vtxt + "matches with expected:" + text);

                return true;
            } else {
                log.error(locatorName + "text:" + vtxt + "not matches with expected:" + text);
                return false;
            }

        } catch (Exception e) {
            log.error("unable to get the text from the " + locatorName);
            return false;

        }
    }

    /**
     * @throws Throwable
     * @return: return title of current page.
     */

    public static String getTitle() {
        String text = "";
        try {
            text = TestBase.driver.getTitle();
        } catch (WebDriverException e) {
            log.error(e.getMessage());
        }
        return text;
    }


    /**
     * Verify Title of the page.
     *
     * @param title : Expected title of the page.
     */
    public static boolean verifyTitle(String title) {


        try {
            String titleA = TestBase.driver.getTitle();
            if(titleA.equals(title)){
                System.out.println("Expected Title :-"+title+" and the Actual Title are matching :-"+titleA);
            }else{
                System.out.println("Expected Title :-"+title+" and the Actual Title are not matching :-"+titleA);
            }
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    /**
     * This method used to verify text present in the page
     *
     * @return boolean: Return true if checkbox is checked
     * @Param text: The text that needs to verify
     * @Author: Veena
     * @Modified By: N/A
     */
    public static boolean verifyTextPresent(String text) {
        if ((TestBase.driver.getPageSource()).contains(text)) {
            return true;
        } else {
            return false;
        }


    }

    /**
     * This method used to get the attribute
     *
     * @param locatorName: the name of the element
     * @return string: Return attribute value
     * @Param eleement: The web element on which we need to perform action
     * @Param attribute: the attribute of the elemenet
     * @Author: Veena
     * @Modified By: N/A
     */

    public static String getAttribute(WebElement element, String attribute, String locatorName) {

        String value = "";
        try {
            if (isDisplayed(element, locatorName)) {
                value = element.getAttribute(attribute);
            }
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        return value;
    }


    /**
     * This method used to get the value of the eleemnt
     *
     * @param locatorName: the name of the element
     * @return string: Return value of the element
     * @Param eleement: The web element on which we need to perform action
     * @Author: Veena
     * @Modified By: N/A
     */
    public static String getValue(WebElement element, String locatorName) {
        String text = "";
        try {
            if (element.isDisplayed()) {
                text = element.getAttribute("value");

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return text;
    }


    /**
     * This method used to mouse over an element using Java Script
     *
     * @Param eleement: The web element on which we need to perform action
     * @Param locatorName: The web element on which we need to perform action
     * @Author: Veena
     * @Modified By: N/A
     */

    public static void mouseHoverByJavaScript(WebElement element, String locatorName) {
        try {
            String javaScript = "var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                    + "arguments[0].dispatchEvent(evObj);";

            js.executeScript(javaScript, element);
            log.info("Mouse over action performed on" + element);
        } catch (Throwable e) {
            log.error("Unable to do mouse over on" + element);
        }
    }


    /**
     * This method switch the focus to selected frame using frame index
     *
     * @param index : Index of frame wish to switch
     */
    public static void switchToFrameByIndex(int index) {

        try {
            TestBase.driver.switchTo().frame(index);
            log.info("Switched to frame by index" + index);

        } catch (NoSuchFrameException e) {
            log.error("Frame is not displayed");
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method switch the to frame using frame ID.
     *
     * @param idValue : Frame ID wish to switch
     */
    public static void switchToFrameById(String idValue) {
        try {
            TestBase.driver.switchTo().frame(idValue);
            log.info("Switched to frame by index" + idValue);

        } catch (NoSuchFrameException e) {
            log.error("Frame is not displayed");
        } catch (Throwable e) {
            log.error(e.getMessage());

        }
    }

    public static void switchToFrameUsingWebelement(WebElement ele){
    try{
        TestBase.driver.switchTo().frame(ele);
        log.info("Switched to frame by elex" + ele);

    } catch (NoSuchFrameException e) {
        log.error("Frame is not displayed");
    } catch (Throwable e) {
        log.error(e.getMessage());

    }

    }

    /**
     * This method switch the to frame using frame Name.
     *
     * @param nameValue : Frame Name wish to switch
     */
    public static void switchToFrameByName(String nameValue) {
        try {
            TestBase.driver.switchTo().frame(nameValue);
            log.info("Switched to frame by Name" + nameValue);

        } catch (NoSuchFrameException e) {
            log.error("Frame is not displayed");
        } catch (Throwable e) {
            log.error(e.getMessage());

        }
    }

    /**
     * This method switch the to Default Frame.
     *
     * @throws Throwable
     */
    public static void switchToDefaultFrame() {
        try {
            TestBase.driver.switchTo().defaultContent();
            log.info("Switched to the default content");

        } catch (NoSuchFrameException e) {
            log.error("Unable to switch to default content");
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
    }


    /**
     * This method wait selenium until element present on web page.
     */
    public static void ImplicitWait() {

        TestBase.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public static List<WebElement> getElements(By locator) {

        List<WebElement> ele = TestBase.driver.findElements(locator);

        return ele;
    }


    public static void executeJavaScriptOnElement(String script) {
        ((JavascriptExecutor) TestBase.driver).executeScript(script);
    }

    public static void closeBrowser() {
        TestBase.driver.close();
        TestBase.driver.quit();
    }


    public static void switchToRecentOpenedWindow() {
        try {
            String strPrntWnd = TestBase.driver.getWindowHandle();
            Set<String> strWnds = TestBase.driver.getWindowHandles();
            for (String a : strWnds) {
                if (!a.equalsIgnoreCase(strPrntWnd))
                    TestBase.driver.switchTo().window(a);
            }
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
    }


    public static void clear(WebElement element, String locatorName) {
        try {
            element.clear();
            log.error("text got cleared on" + locatorName);

        } catch (Throwable e) {
            log.error("text is not cleared" + locatorName);
        }
    }

    public static void switchToParentWithChildClose() {
        switchToParentWindow();

        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());

        for (int i = 1; i < windowsId.size(); i++) {
            log.info(windowsId.get(i));
            TestBase.driver.switchTo().window(windowsId.get(i));
            TestBase.driver.close();
        }

        switchToParentWindow();
    }

    public static void goBack() {
        TestBase.driver.navigate().back();
        log.info("");
    }

    public static void goForward() {
        TestBase.driver.navigate().forward();
        log.info("");
    }

    public static void refresh() {
        TestBase.driver.navigate().refresh();
        log.info("");
    }

    public static Set<String> getWindowHandlens() {
        log.info("");
        return TestBase.driver.getWindowHandles();
    }

    public static void switchToWindow(int index) {
        try {
            LinkedList<String> windowsId = new LinkedList<String>(
                    getWindowHandlens());

            if (index < 0 || index > windowsId.size())
                throw new IllegalArgumentException("Invalid Index : " + index);

            TestBase.driver.switchTo().window(windowsId.get(index));
            log.info(index);
        } catch (NoSuchWindowException e) {
            log.error("Unable to switch to the window , window is not present");
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
    }

    public static void switchToParentWindow() {
        try {
            LinkedList<String> windowsId = new LinkedList<String>(
                    getWindowHandlens());
            TestBase.driver.switchTo().window(windowsId.get(0));
            log.info("");
        } catch (NoSuchWindowException e) {
            log.error("Window is not present ");
        }
    }

    //Java Sccipt functions

    public static Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) TestBase.driver;
        log.info(script);
        return exe.executeScript(script);
    }

    public static Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) TestBase.driver;
        log.info(script);
        return exe.executeScript(script, args);
    }

    public static void scrollToElemet(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        log.info(element);
    }

    public static void scrollToElemetAndClick(WebElement element) {
        scrollToElemet(element);
        element.click();
        log.info(element);
    }

    public static void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
        log.info(element);
    }

    public static void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
        log.info(element);
    }

    public static void scrollDownVertically() {
        try {
            executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        catch (Exception e){
            log.info("Couldn't able to scroll down");
        }
    }

    public static void scrollUpVertically() {
        executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public static void scrollDownByPixel() {
        executeScript("window.scrollBy(0,1500)");
    }

    public static void scrollUpByPixel() {
        executeScript("window.scrollBy(0,-1500)");
    }

    public static void scrollHorizontally() {
        JavascriptExecutor jse = (JavascriptExecutor) TestBase.driver;
        jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");
    }

    public static void ZoomInBypercentage() {
        executeScript("document.body.style.zoom='40%'");
    }

    public static void ZoomBy100percentage() {
        executeScript("document.body.style.zoom='100%'");
    }

    //alerts

    public static void dismissAlert() {
        TestBase.driver.switchTo().alert().dismiss();
    }

    public static String getAlertText() {
        String text = "";
        try {
            WaitHelper.waitForAlertPresent(50);
            text = TestBase.driver.switchTo().alert().getText();
            log.info(text);
        } catch (NoAlertPresentException e) {
            log.error("No Alert Exception");
        }
        return text;
    }

    public static boolean isAlertPresent() {
        WaitHelper.waitForAlertPresent(30);
        try {
            TestBase.driver.switchTo().alert();
            log.info("true");
            return true;
        } catch (NoAlertPresentException e) {
            // Ignore
            log.info("false");
            return false;
        }
    }

    public static void clickStaleElement(WebElement element, String locatorName) {
        int count = 0;
        boolean clicked = false;
        while (count < 4 || !clicked) {
            try {
                WebElement yourSlipperyElement = element;
                yourSlipperyElement.click();
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

    /*
     * This method used to select checkbox
     * @Param: element- Action to be perfomed on an element
     * @Param: loctorName- Name of the Locator displayed in the Page
     * @Author: Veena
     * @Modified By: N/A
     */

    public static void selectCheckBox(WebElement element, String locatorName) {

        try {
            if (!isChecked(element, locatorName)) {
                element.click();
            }

            log.info(locatorName + "is Checked");
        } catch (Exception e) {
            log.error(locatorName + "is not Checked");
        }


    }

     /*
     * This method used to un select checkbox
     * @Param: element-  WebElement on which we need to perform action
     * @Param: loctorName- Name of the element in a page.
     * @Return: void
     * @Author: Veena
     * @Created Date: N/A
     */

    public static void unSelectCheckBox(WebElement element, String locatorName) {

        try {
            if (isChecked(element, locatorName)) {
                element.click();
            }

            log.info(locatorName + "is unselected");
        } catch (Exception e) {
            log.error(locatorName + "is selected");
        }


    }

    public static boolean selectValueFromCombobox(WebElement element, String value, String locatorName) {


        element.click();
        List<WebElement> listItems = TestBase.driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for (WebElement item : listItems) {
            if (item.getText().equals(value)) {
                item.click();
                log.info("Value:" + value + "is selected from the " + locatorName);
                return true;
            }
        }
        log.error("Value:" + value + "is not available in " + locatorName);
        log.error("Value:" + value + "is not available in " + locatorName);
        return false;
    }


    public static boolean verifyValueExistInInputTypeCompbox(WebElement element, String value, String locatorName) {
        try {
            element.click();
            Thread.sleep(3000);
            List<WebElement> listItems = TestBase.driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
            for (WebElement item : listItems) {
                if (item.getText().equals(value)) {
                    return true;
                }
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return false;
    }


    public static Set<String> getWindowHandles() {
        return TestBase.driver.getWindowHandles();
    }

    public static boolean verifyValueExistInCombobox(WebElement element, String option, String locatorName) {

        try {
            Select select = new Select(element);
            List<WebElement> allOptions = select.getOptions();
            for (WebElement eoption : allOptions) {
                if (eoption.getText().equals(option)) {
                    return true;
                }
            }
            return false;
        } catch (ElementNotSelectableException | ElementNotVisibleException e) {
            log.error(e.getMessage());
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        return false;

    }

    public static boolean verify_AttributeValue(WebElement element, String attribute, String text, String locatorName) {

        String value = "";
        try {
            value = getAttribute(element, attribute, locatorName);
            if (value.equalsIgnoreCase(text)) {
                log.info(attribute + " value for " + locatorName + " is " + value);
                return true;
            } else {
                log.info(attribute + " value for " + locatorName + " is " + value);

            }
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public static boolean has_scrollbar(WebElement elem) {

        Long cheight = (Long) js.executeScript("return arguments[0].clientHeight", elem);
        Long sheight = (Long) js.executeScript("return arguments[0].scrollHeight", elem);
        log.info("Height=" + cheight);
        log.info("Scroll Height =" + sheight);
        if (cheight < sheight) {
            log.info("It has Scroll bar");
            return true;
        }
        log.info("It doesn't have Scroll bar");
        return false;
    }

    public static String getValueByJavaScript(WebElement element) {
        if (element == null) {
            log.info("weblement is null");
            return null;
        }

        boolean displayed = false;
        try {
            displayed = element.isDisplayed();
        } catch (Exception e) {
            log.error(e);
            return null;
        }

        if (!displayed)
            return null;

        //String value = (String)(js.executeScript("return arguments[0].value", driver.findElement(By.name("s_2_1_146_0"))));
        String value = (String) (js.executeScript("return arguments[0].value", element));
        log.info("Field value read as: " + value);
        return value;
    }

    public static String getCssAttribute(WebElement element, String attribute, String locatorName) {
        String value = element.getAttribute(attribute);
        if (value != null) {
            log.info(locatorName + "Attribute:" + attribute + "value:" + value);
        } else {
            log.error(locatorName + "Attribute:" + attribute + "value:" + value);
        }
        return value;
    }

    public static List<String> getValuesFromCombobox(WebElement element, String locatorName) {
        element.click();
        WebElement element1 = element.findElement(By.xpath("./preceding-sibling::input"));
        List<WebElement> listItems = TestBase.driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        ArrayList<String> listOfValues = new ArrayList<String>();
        for (WebElement item : listItems) {
            if (!item.getText().equals("")) {
                listOfValues.add(item.getText());
            }
        }
        if (!getValueByJavaScript(element1).equals("")) {
            listOfValues.add(getValueByJavaScript(element1));
        }
        return listOfValues;
    }

    public static String getFirstSelectedOption(WebElement element, String locatorName) {


        try {
            Select select = new Select(element);

            WebElement option = select.getFirstSelectedOption();

            String defaultItem = option.getText();
            log.info(defaultItem + " is selected bydefault ");
            return defaultItem;

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static void navigateBackToURL() {
        TestBase.driver.navigate().back();
    }

    public static String randomString(int count){
          String ALPHA_NUMERIC="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb=new StringBuilder(count);
        while(count--!=0){
            int index=(int)(Math.random()*ALPHA_NUMERIC.length());
            sb.append(ALPHA_NUMERIC.charAt(index));


        }
        return sb.toString();

    }


    /*
    * This method retrive the currentdate and time and return as a string
    * Author: Subhashini Rajagopalan
    * Date Added: 2/14/2021
    * *
    * */

     //removed : from the pattern
    //Date Modified: 2/22/2021
    public static String getCurrentDateAndTime() {
        Date date = new Date( );
        SimpleDateFormat format =
                new SimpleDateFormat ("ddMMYYYY'AT'hhmm");

        System.out.println("Current Date: " + format.format(date));
        return format.format(date);
    }


    /*
     * Author: Subhashini Rajagopalan
     * Purpose: Added to insert charcters between letters in strings
     * Date: 3/22/2021
     * */

    public String addChar(String str, char ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }


    public static void pressEnterButton(String Action, WebElement element){
        if(Action.equalsIgnoreCase("enter")){
            element.sendKeys(Keys.ENTER);
        }else if(Action.equalsIgnoreCase("arrowdown")){
            element.sendKeys(Keys.ARROW_DOWN);
        }
    }


    /*
     * Author: Harish Chidere
     * This Method is to get Six months back date in MM/DD/YYYY Format
     * Date: 4/27/2021
     * */
    public static String getSixMonthsBackDate(){

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -200);
        SimpleDateFormat format = new SimpleDateFormat ("MM/dd/YYYY");

        String a = format.format(c.getTime());
        System.out.println("Six Months Back Date: " +a);

        return a;
    }

    public static String getTwoMonthsFutureDate(String dateFormat){

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, +60);
        SimpleDateFormat format = new SimpleDateFormat (dateFormat);

        String a = format.format(c.getTime());
        System.out.println("Two Months Future Date: " +a);

        return a;
    }

    /*
     * Author: Harish Chidere
     * This Method is to get Tomorrow's date in MM/DD/YYYY Format
     * Date: 4/27/2021
     * */
    public static String getTomorrowsDate(){

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        SimpleDateFormat format = new SimpleDateFormat ("MM/dd/YYYY");

        String a = format.format(c.getTime());
        System.out.println("Tomorrow's Date: " +a);

        return a;
    }


    /*
     * Author: Harish Chidere
     * This Method is to get Today's date in MM/DD/YYYY Format
     * Date: 4/27/2021
     * */
    public static String getTodaysDate(){

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 0);
        SimpleDateFormat format = new SimpleDateFormat ("MM/dd/YYYY");

        String a = format.format(c.getTime());
        System.out.println("Today's Date: " +a);

        return a;
    }

    /*
     * Author: Harish Chidere
     * This Method is to Verify Element is Not Present on Webpage
     * Date: 4/27/2021
     * */
    public static void verifyElementIsNotPresent(List<WebElement> element, String locatorName){

        try {
            int i = element.size();
            if (i == 0) {
                log.info(locatorName + " Not Present On The Webpage");
            }else{
                log.info(locatorName + " Present On The Webpage");
            }
        }catch (WebDriverException e){
            log.error(locatorName+" is not present on the webpage");
        }
    }

    /*Method to check the options availability in a input combo list
     *
     * */

    public static void verifyMultipleTexts(List<WebElement> element, String expectedText) {
        System.out.println("Inside multiple txt.......");
        String[] expectedTextArray = expectedText.split("@");
        SoftAssert sa = new SoftAssert();
        for (int i = 0; i < element.size(); i++) {
            String actualText = element.get(i).getText().trim();
            String expected = expectedTextArray[i].trim();
            System.out.println("Actual : " + actualText + " Expected : " + expected);
            sa.assertEquals(actualText, expected);
        }
        sa.assertAll();
    }



    public static void verifyMultipleTextsHavingSameValue(List<WebElement> element, String expectedText) {
        System.out.println("Inside multiple txt.......");
        SoftAssert sa = new SoftAssert();
        for (int i = 0; i < element.size(); i++) {
            String actualText = element.get(i).getText().trim();
            System.out.println("Actual : " + actualText + " Expected : " + expectedText);
            sa.assertEquals(actualText, expectedText.trim());
        }
        sa.assertAll();
    }


    /*
    * This method is used to convert a given date format to expected format
    * */


    public static String convertDateIntoRequiredFormat(String actFormat, String date, String expecFormat) {

        String expecDate=null;

        try{
            SimpleDateFormat sdf =new SimpleDateFormat(actFormat);
            Date d = sdf.parse(date);
            SimpleDateFormat sdf2 = new SimpleDateFormat(expecFormat);
            expecDate=sdf2.format(d);

        } catch(ParseException e) {
            System.out.println("Exception "+e);
        }

        return expecDate;
    }


    public static void verifyContainsUrl(String text){

        String url = TestBase.driver.getCurrentUrl();
        if(url.contains(text)){
            System.out.println("Actual URL :-"+url+" is contains the expected Text"+text);
        }else{
            System.out.println("Actual URL :-"+url+" is not contains the expected Text"+text);
        }
    }


    public static void verifyLink(String urlLink){

        try {

            URL link = new URL(urlLink);
            HttpURLConnection httpConn = (HttpURLConnection)link.openConnection();
            httpConn.setConnectTimeout(3000);
            httpConn.connect();

            if (httpConn.getResponseCode() == 200){
                log.info(httpConn.getResponseMessage());
            }

            if (httpConn.getResponseCode() == 400){
                log.error(httpConn.getResponseMessage());
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }



}








