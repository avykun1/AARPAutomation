package com.cucumber.framework.helper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.utility.ExcelReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;





public class WaitHelper {


	private static Logger log = LoggerHelper.getLogger(WaitHelper.class);
	static WebDriver driver = TestBase.driver;
	static WebDriverWait wait;


	public static void setImplicitWait(long timeout, TimeUnit unit) {
		log.info(timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}



	public static WebElement waitForElementVisible(WebElement element, long timeout) {
		try {
			return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
		}

		 catch (NoSuchElementException | TimeoutException e){
			log.error(e.getMessage());
		}
		return null;
	}

	public static WebElement waitForElementClickable(WebElement element, int timeout) {
		try {

			return new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	/**
	 * This method used to wait until the element present
	 *
	 * @Param element: The action to be performed on an element
	 * @Param locatorName: The name of the element diplayed on the Page
	 * @Author: Veena
	 * @Modified By: N/A
	 */
	public static void waitForElementPresent(WebElement element, String locator) {
		boolean flag = false;
		try {
			for (int i = 0; i < 30; i++) {
				if (element.isDisplayed()) {
					return;
				} else {
					Thread.sleep(1000);
				}
			}

		} catch (Exception e) {

		}

	}

	public static void waitForTitlePresent(String title, long time) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			log.error("Title is not present");
		}

	}

	/**
	 * This method used to wait until the title present
	 *
	 * @Param title: The Title we expect to see on Page once it gets loaded
	 * @Param time: The maximum time it will wait for title to appear
	 * @Author: Shruti
	 * @Modified By: N/A
	 */


	public static void waitForTexttobePresentinelement(WebElement ele, String text, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
		} catch (Exception e) {
			log.error("Text is not present");
		}

	}

	public static void waitForAlertPresent(long time) {
		try {
			new WebDriverWait(driver, 60)
					.ignoring(NoAlertPresentException.class)
					.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			log.error("alert is not present waited till the max timeout");
		}
	}

	public static void waitForAttributeChange(WebElement element, String attribute, String value, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);

			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					String enabled = element.getAttribute(attribute);
					if (enabled.equals(value))
						return true;
					else
						return false;
				}
			});
		}
		catch(Exception e){
			log.error(e.getMessage());
		}
	}

	public static void waitUntilDataLoadsInWebTable(WebElement table, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				int elementCount = table.findElements(By.xpath("./tr")).size();
				if (elementCount > 1)
					return true;
				else
					return false;
			}
		});
	}


	public static void sleep(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {

		}
	}

	public static void pageLoadWait(int pageLoadTimeout){
		new WebDriverWait(driver, pageLoadTimeout).until(
				webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}







	public static boolean isElementListPresent(List<WebElement> elements, WebDriver driver){
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(elements));
			if (elements.size() > 0){
				log.error("Element: " + elements + " is displayed");
				return  true;
			}
		} catch (NoSuchElementException | TimeoutException e){
			log.error(e.getMessage());
		}
		return false;
	}


	public static void waitForElements(List<WebElement> objectProperty, int waitTimeInSeconds, WebDriver driver){
		long startIimeInMs;
		long endTimeInMs;
		long totalElapsedTimeInMs;
		startIimeInMs = System.currentTimeMillis();
		while (true){
			try {
				if (isElementListPresent(objectProperty, driver)) {
					break;
				}
			} catch (NoSuchElementException e){
				endTimeInMs = System.currentTimeMillis();
				totalElapsedTimeInMs = endTimeInMs - startIimeInMs;
				if (totalElapsedTimeInMs >= waitTimeInSeconds * 1000){
					throw new NoSuchElementException("Not able to find element " + objectProperty);
				}
			}
		}

	}





}
