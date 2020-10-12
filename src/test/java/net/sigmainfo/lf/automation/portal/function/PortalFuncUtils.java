package net.sigmainfo.lf.automation.portal.function;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.server.ExportException;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import static java.util.concurrent.TimeUnit.SECONDS;
import static jxl.biff.BaseCellFeatures.logger;
import static net.sigmainfo.lf.automation.common.AbstractTests.driver;
import static net.sigmainfo.lf.automation.portal.constant.PortalParam.browser;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by : Shaishav.s on 24-04-2018. Test class : PortalFuncUtils.java
 * Description : Contains reusable methods used while Portal automation Includes
 * : 1. Reads classpath resources 2. Read test data from excel sheet
 * implementation
 */
@Component
public class PortalFuncUtils {

	@Autowired
	PortalParam portalParam;

	@Autowired
	public UIObjParam uiObjParam;

	private static Logger logger = LoggerFactory.getLogger(PortalFuncUtils.class);
	public static int WAIT_TIME = 360;
	public static int TIMEOUT = 360;
	private boolean acceptNextAlert = true;

	public String getTestData(String FuncMod, String TestID, String valueName) {
		final Sheet sheet;
		String value = "";

		try {
			// sheet=
			// Workbook.getWorkbook(getResourceFromClasspath(System.getProperty("envParam")+"/TestData/MPS_Data.xls")).getSheet(FuncMod);
			sheet = Workbook
					.getWorkbook(
							getResourceFromClasspath(System.getProperty("envParam") + portalParam.testdataSourceName))
					.getSheet(FuncMod);

			Cell t1 = sheet.findCell(TestID);
			Cell c1 = sheet.findCell(valueName);

			if (t1 == null)
				return "";
			else {
				int fndRow = t1.getRow();
				value = sheet.getCell(c1.getColumn(), fndRow).getContents();
			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;

	}

	public InputStream getResourceFromClasspath(String resourceName) throws IOException {

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);

		if (inputStream == null) {
			throw new FileNotFoundException("resource '" + resourceName + "' not found in the classpath");
		}

		return inputStream;
	}

	public static void insertText(WebDriver driver, By locator, String value) throws Exception {
		try {
			assertTrue(PortalFuncUtils.waitForElementToBeVisible(locator));
			assertTrue(PortalFuncUtils.waitForElementToBeClickable(locator));
			Thread.sleep(500);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(value);
			Thread.sleep(5000);
			logger.info("Entered text:" + value);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void enterText(WebDriver driver, By locator, String text) throws Exception {
		try {
			Actions actions = new Actions(driver);
			new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(text);
			actions.build().perform();
			logger.info("Entered :" + text);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void selectDropdownByvalue(WebDriver driver, By locator, String value) throws Exception {
		// Thread.sleep(2000);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]")).click();
				logger.info("Selected :" + value);
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		// Thread.sleep(2000);
		/*
		 * Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(60, SECONDS) .pollingEvery(5, SECONDS)
		 * .ignoring(NoSuchElementException.class)
		 * .ignoring(StaleElementReferenceException.class);
		 * 
		 * WebElement foo = stubbornWait.until(new Function<WebDriver, WebElement>() {
		 * public WebElement apply(WebDriver driver) { return
		 * driver.findElement(locator); } }); try { new
		 * Select(driver.findElement(locator)).selectByVisibleText(value); }
		 * catch(Exception e) { throw new Exception(value +
		 * " can not be selected because of : "+ e.getMessage()); }
		 */
	}

	public static void selectDropdownByNonDivValue(WebDriver driver, By locator, String value) throws Exception {
		Thread.sleep(3000);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			waitForElementToBeVisible(By.xpath("//*[contains(text(),'" + value + "')]"));
			assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]")).click();
				logger.info("Selected :" + value);
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static String getTooltipText(WebDriver driver, By locator) throws Exception {
		try {
			String tooltip = driver.findElement(locator).getAttribute("title");
			return tooltip;
		} catch (Exception e) {
			throw new Exception("Can not fetch the tooltip because of :" + e.getMessage());
		}
	}

	public static void selectSearchDropdown(WebDriver driver, By locator, String value) throws Exception {
		try {
			driver.findElement(locator).click();
			driver.findElement(locator).sendKeys(value);
			driver.findElement(locator).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new Exception("Selecting " + value + "from the dropdown failed because of : " + e.getMessage());
		}
	}

	/*
	 * public static void waitUntilElementLocated(WebDriver driver,By locator)
	 * throws Exception { try { WebDriverWait wait = new WebDriverWait(driver,
	 * WAIT_TIME); wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	 * } catch (Exception e) { throw new
	 * Exception("Element could not be located within wait time"); } }
	 */

	/*
	 * public static void waitUntilElementVisible(WebDriver driver,By locator)
	 * throws Exception { try { WebDriverWait wait = new WebDriverWait(driver,
	 * WAIT_TIME);
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }
	 * catch(Exception e) { throw new
	 * Exception("Element could not be visible within wait time"); } }
	 */

	public boolean ifEnabled(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		if (element.isEnabled())
			return true;
		else
			return false;
	}

	public static void waitUntilElementInvisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void selectRadioButton(WebDriver driver, By locator, String value) {
		List<WebElement> radios = driver.findElements(locator);

		for (WebElement element : radios) {

			if (element.getAttribute("value").equals(value)) {
				element.click();
			}
			break;
		}
	}

	public static void selectCheckboxes(WebDriver driver, By locator, String value) {
		List<WebElement> checkbox = driver.findElements(locator);

		for (WebElement element : checkbox) {

			if (element.getAttribute("value").equals(value)) {
				element.click();
			}
			break;
		}
	}

	public static void selectCheckbox(WebDriver driver, By locator) {
		WebElement checkbox = driver.findElement(locator);
		checkbox.click();
	}

	/*
	 * public static boolean clickButton(WebDriver driver, By locator, String value)
	 * throws Exception { try { assertTrue(waitForElementToBeClickable(locator));
	 * driver.findElement(locator).click();
	 * logger.info("Clicked on button :"+value); return true; } catch (Exception e)
	 * { return false; } }
	 */

	public static void clickButton(WebDriver driver, By locator, String value) throws Exception {
		waitForElementToBeVisible(locator);
		waitForElementToBeClickable(locator);
		if (driver.findElement(locator).isEnabled()) {
			driver.findElement(locator).click();
			Thread.sleep(1500);
			logger.info("Clicked on button :" + value);
		} else {
			assertFalse(driver.findElement(locator).isEnabled(), "Button could not be clicked");
		}

	}

	public static void clickCheckBox(WebDriver driver, By locator, String value) throws Exception {
		if (driver.findElement(locator).isEnabled()) {
			driver.findElement(locator).click();
			Thread.sleep(1500);
			logger.info("Clicked on button :" + value);
		} else {
			assertFalse(driver.findElement(locator).isEnabled(), "Button could not be clicked");
		}

	}

	public static void waitForTextToBePresent(WebDriver driver, By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
	}

	public static void waitForTexyToBeInvisible(WebDriver driver, By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, value));
	}

	public static void navigateTo(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public static void navigateBackpage(WebDriver driver, String url) {
		driver.navigate().back();
	}

	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText(WebDriver driver, String url) {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public String getAttribute(WebDriver driver, By byElement, String attribute) {
		String atr = null;
		WebElement element = driver.findElement(byElement);
		if (attribute.equalsIgnoreCase("name"))
			atr = element.getAttribute("name");
		else if (attribute.equalsIgnoreCase("id"))
			atr = element.getAttribute("id");
		else if (attribute.equalsIgnoreCase("class"))
			atr = element.getAttribute("class");
		else if (attribute.equalsIgnoreCase("name"))
			atr = element.getAttribute("name");
		else if (attribute.equalsIgnoreCase("title"))
			atr = element.getAttribute("title");
		else if (attribute.equalsIgnoreCase("type"))
			atr = element.getAttribute("type");
		else if (attribute.equalsIgnoreCase("value"))
			atr = element.getAttribute("value");
		return atr;
	}

	// This method will work for selecting date - Kendo Date Picker

	public void selectKendoDate(WebDriver driver, By locator, String date) throws Exception {

		WebElement datePicker = driver.findElement(locator);
		datePicker.click();

		// Provide the day of the month to select the date.
		pickKendoDate(driver, date);
	}

	private void pickKendoDate(WebDriver driver, String date) throws Exception {

		By locator = By.className("appropriate-locator");

		// waitUntilElementLocated(driver,locator);
		waitForElementToBeVisible(locator);
		WebElement table = driver.findElement(locator);

		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(date)) {
					driver.findElement(By.linkText(date)).click();
				}
			}
		}
		Thread.sleep(2000);
	}

	public String[][] getExcelData(String fileName, String sheetName, String methodName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			System.out.println(totalNoOfRows + ":" + totalNoOfCols);
			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int row = 1; row < totalNoOfRows; row++) {
				int column = 0;
				if (sh.getCell(column, row).getContents().contains("verifySuccessfulSignIn")) {
					for (column = 0; column < totalNoOfCols; column++) {
						arrayExcelData[row - 1][column] = sh.getCell(column, row).getContents();
						System.out.println(row + ":" + column + ":" + sh.getCell(column, row).getContents());
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public static By getLocator(String strElement) throws Exception {

		// extract the locator type and value from the object
		String locatorValue = null;
		String locatorType = strElement.split(":-")[0];
		if (PortalParam.SpouseDeclarion == 1) {
			 locatorValue = PortalParam.DeclartionSectionsId + strElement.split(":-")[1];
		} else {
			 locatorValue = strElement.split(":-")[1];
		}

		// for testing and debugging purposes
		// System.out.println("Retrieving object of type '" + locatorType + "' and value
		// '" + locatorValue + "' from the object map");

		// return a instance of the By class based on the type of the locator
		// this By can be used by the browser object in the actual test
		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public static void waitForPageToLoadCompletely(WebDriver driver) {
		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for page Load Request to complete.");
		}
	}

	public static void selectCalendar(WebDriver driver, By locator, String value, String calUnit) throws Exception {
		Thread.sleep(2000);
		try {
			if (calUnit.equalsIgnoreCase("Month")) {
				if (value.contains("Jan"))
					value = " Jan ";
				else if (value.contains("Feb"))
					value = " Feb ";
				else if (value.contains("Mar"))
					value = " Mar ";
				else if (value.contains("Apr"))
					value = "04";
				else if (value.contains("May"))
					value = " May ";
				else if (value.contains("Jun"))
					value = " Jun ";
				else if (value.contains("Jul"))
					value = " Jul ";
				else if (value.contains("Aug"))
					value = " Aug";
				else if (value.contains("Sep"))
					value = " Sep ";
				else if (value.contains("Oct"))
					value = " Oct ";
				else if (value.contains("Nov"))
					value = " Nov ";
				else if (value.contains("Dev"))
					value = " Dec ";
			}
			new Select(driver.findElement(locator)).selectByValue(value);
			logger.info("Selected :" + value);
		} catch (Exception e) {
			throw new Exception(value + " can not be selected because of : " + e.getMessage());
		}
		Thread.sleep(2000);
	}

	public static void scrollOnTopOfThePage(WebDriver driver, String portal) throws Exception {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
		logger.info("Scrolling on top of the page");
		Thread.sleep(5000);
	}

	public static void scrollToBottomOfThePage(WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		logger.info("Scrolling on bottom of the page");
		Thread.sleep(5000);
	}

	public static void waitTillPageBottom(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript(
				"if (document.body.scrollHeight == document.body.scrollTop + window.innerHeight) { return true; } else { return false; }");
		logger.info("Scrolling on bottom of the page");
	}

	public static void scrollUntil(By locator, WebDriver driver) throws Exception {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2500);
	}

	public static void scrollToElementandClick(WebDriver driver, By element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(element));
			Thread.sleep(2500);
			driver.findElement(element).click();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static boolean isVisible(By locator, WebDriver driver) {
		if (driver.findElement(locator).isDisplayed())
			return true;
		else
			return false;
	}

	public static void scrollToElement(WebDriver driver, By element) throws Exception {
		assertTrue(waitForElementToBeVisible(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}

	public static String removeSpecialChar(String value) {
		value = value.replaceAll("[^a-zA-Z0-9]", "").trim();
		value = value.replaceAll("\\s", "");
		return value;
	}

	public static void createNewTab(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		/*
		 * Actions newTab = new Actions(driver); newTab.sendKeys(Keys.CONTROL +
		 * "t").perform();
		 */
	}

	public static void waitForNumberOfWindowsEqualTo(final int numberOfWindows) {
		new WebDriverWait(driver, TIMEOUT) {
		}.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (driver.getWindowHandles().size() == numberOfWindows);
			}
		});
	}

	public static void selectFromVadinDropdown(By locator, String duration) throws Exception {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			Thread.sleep(2500);
			driver.findElement(locator).click();
			List<WebElement> options = driver.findElements(By.xpath("//*[@id='items']/vaadin-combo-box-item"));
			for (int i = 1; i <= options.size(); i++) {
				if (driver
						.findElement(
								By.xpath("//div[@id='items']/vaadin-combo-box-item[contains(.,'" + duration + "')]"))
						.isDisplayed()) {
					new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(
							By.xpath("//div[@id='items']/vaadin-combo-box-item[contains(.,'" + duration + "')]")));
					driver.findElement(
							By.xpath("//div[@id='items']/vaadin-combo-box-item[contains(.,'" + duration + "')]"))
							.click();
					logger.info("Selected :" + duration);
				}

			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public static void waitUntilSignButtons(WebDriver driver, final int signCount) {
		// final WebElement table = element;

		new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS)
				.until(new Predicate<WebDriver>() {

					public boolean apply(WebDriver d) {
						List<WebElement> signButtonsList = driver.findElements(By.xpath(
								"//button[@class='tab-button' AND @type='button' AND starts-with(@data-qa,'signature-tab-required-')]"));
						return (signButtonsList.size() >= signCount);
					}
				});
	}

	/*
	 * public static void waitForElementToBeClickable(WebDriver driver,By element)
	 * throws Exception { try { new
	 * WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(
	 * element)); } catch (Exception e) { throw new Exception(e.getMessage()); } }
	 */

	/*
	 * public static void selectVaadinOption(String account) throws Exception{ try {
	 * clickButton(driver,PortalFuncUtils.getLocator(UIObjParam.
	 * backoffice_appDetailspage_cashflowTab_uploadBankStatement_accountTypeComboBox
	 * ),"Account type"); Thread.sleep(2000); for(int i=1;i<=2;i++){ WebElement
	 * accountType = driver.findElement(By.xpath("/
	 *//*
		 * [@id='items']/vaadin-combo-box-item["+i+"]")); String text =
		 * accountType.getText();
		 * 
		 * if(text.contains(account)){ accountType.click(); } }
		 * logger.info("Selected :"+account); } catch (Exception e) { throw new
		 * Exception(e.getMessage()); } }
		 */

	public static boolean waitForElementToBeVisible(By element) throws Exception {
		try {
			new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(element));
			new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public static boolean waitForElementToBeClickable(By element) throws Exception {
		try {
			// assertTrue(waitForElementToBeVisible(element));
			new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public static boolean waitforInvisibilityOf(By element) throws Exception {
		try {
			new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public static boolean waitForPresencfElement(By element) throws Exception {
		try {
			new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public static boolean waitForTextToBe(By element, String text) throws Exception {
		try {
			new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.textToBe(element, text));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public static String getRandomAlphabets(int length) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s = "";
		Random random = new Random();
		for (int i = 1; i <= length; i++) {
			char c = alphabet.charAt(random.nextInt(26));
			s += c;
		}

		return s;
	}

	public static void selectDateFromVaadinCalendar(WebDriver driver, By locator, String kycExpiryDate, String purpose)
			throws Exception {
		try {
			String id = null;
			if (purpose.contains("salaryDate")) {
				id = "salaryDate";
			} else if (purpose.contains("Perfios Salary")) {
				id = "SalaryDate";
			} else if (purpose.contains("Document")) {
				id = "DocumentDate";
			} else if (purpose.contains("Funding")) {
				id = "FundedDate";
			} else if (purpose.contains("EMI")) {
				id = "FirstEmiDate";
			}
			clickButton(driver, locator, "calendar control");
			Thread.sleep(4000);
			scrollToElementandClick(driver, By.xpath("//*[@id='" + id
					+ "']//vaadin-date-picker-overlay[@id='overlay']//div[@id='scrollers']//*[@id='yearScroller']//*[contains(text(),'"
					+ kycExpiryDate.split("-")[2] + "')]"));
			Thread.sleep(4000);
			scrollUntil(By.xpath("//*[@id='" + id
					+ "']//vaadin-date-picker-overlay[@id='overlay']//div[@id='scrollers']//vaadin-month-calendar//*[@id='title' and contains(text(),'"
					+ kycExpiryDate.replaceAll("-", " ").split(" ")[1] + " "
					+ kycExpiryDate.replaceAll("-", " ").split(" ")[2] + "')]"), driver);
			Thread.sleep(4000);
			scrollToElementandClick(driver, By.xpath("//*[@id='" + id + "']//*[starts-with(@aria-label,'"
					+ kycExpiryDate.replace("-", " ") + "') and @role='button']"));
			Thread.sleep(4000);
		} catch (Exception e) {
			throw new Exception("Date can not be selected from the calendar");
		}
	}

	public static void clear(WebDriver driver, By locator, String value) throws Exception {
		try {
			assertTrue(PortalFuncUtils.waitForElementToBeVisible(locator));
			assertTrue(PortalFuncUtils.waitForElementToBeClickable(locator));
			Thread.sleep(500);
			driver.findElement(locator).clear();
			logger.info("Cleared text:" + value);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void selectFromDropdown(By locator, String value) throws Exception {
		/*
		 * try { new WebDriverWait(driver,
		 * 60).until(ExpectedConditions.elementToBeClickable(locator));
		 * Thread.sleep(2500); driver.findElement(locator).click(); Thread.sleep(2000);
		 * String dropdownOptions = locator.toString() + "/following-sibling::ul/li";
		 * List<WebElement> options = driver.findElements(By.xpath(dropdownOptions));
		 * for (int i = 1; i <= options.size(); i++) { if
		 * (driver.findElement(By.xpath(locator.toString()+"/following-sibling::ul/li["+
		 * i+"]/span[contains(text(),'"+value+"')]")).isDisplayed()) { new
		 * WebDriverWait(driver,
		 * 60).until(ExpectedConditions.elementToBeClickable(By.xpath(locator.toString()
		 * +"/following-sibling::ul/li["+i+"]/span[contains(text(),'"+value+"')]")));
		 * driver.findElement(By.xpath(locator.toString()+"/following-sibling::ul/li["+i
		 * +"]/span[contains(text(),'"+value+"')]")).click();
		 * logger.info("Selected :"+value); }
		 * 
		 * } }catch (Exception e) { throw new Exception(e.getMessage()); }
		 */
		driver.findElement(locator).click();
		Thread.sleep(2000);
		if (!value.contains("[a-zA-Z]+")) {
			for (int i = 2; i <= 15; i++) {
				if (value.contains("S-Corp") || value.contains("Partnership") || value.contains("LLC")
						|| value.contains("Schedule C")) {
					WebElement proeprtyType = driver.findElement(By.cssSelector(
							"div[id='companytype10'] div[class*='questioner-question-set']:nth-child(3) ui-options[name='dobMonth'] div[class*='select-wrapper'] li:nth-child("
									+ i + ")"));
				} else {

				}
				WebElement proeprtyType = driver.findElement(By.cssSelector(
						"div[id='propertytype3'] div[class*='questioner-question-set']:nth-child(2) ui-options[name='dobMonth'] div[class*='select-wrapper'] li:nth-child("
								+ i + ")"));
				String text = proeprtyType.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).getText();
				if (text.contains(value)) {
					proeprtyType.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
				}
			}
			logger.info("Selected :" + value);
		} else {
			for (int i = 2; i <= 15; i++) {
				WebElement proeprtyType = driver.findElement(By.cssSelector(
						"ui-options[name='dobMonth'] div[class*='select-wrapper'] li:nth-child(" + i + ")"));
				String text = proeprtyType.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).getText();
				if (text.contains(value)) {
					proeprtyType.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
				}
			}
			logger.info("Selected :" + value);
		}
	}

	public static void selectBoolean(By locator, int value) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		logger.info("Selected boolean :" + value);
	}

	public static void selectAddress(By locator, String firstAddress) throws Exception {
		
		insertText(driver, locator, firstAddress);
		Thread.sleep(5000);
		String addr=driver.findElement(locator).getText();
		if(addr.equalsIgnoreCase(firstAddress))
		{
			
		}
		else
		{
			insertText(driver, locator, firstAddress);
		}
		selectOptionWithText(firstAddress);
		Thread.sleep(7000);
	}

	public static void selectOptionWithText(String firstAddress) throws InterruptedException {
		new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='pac-item']//span[contains(text(),'" + firstAddress + "')]")));
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='pac-item']//span[contains(text(),'" + firstAddress + "')]")).click();
		logger.info("Selected address :" + firstAddress);
		Thread.sleep(5000);
	}

	public static String getRelationship(int i) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Parent");
		hm.put(2, "Sibling");
		hm.put(3, "Other Relative");
		hm.put(4, "Co-Worker");
		hm.put(5, "Other");
		return hm.get(i);
	}

	public static BufferedImage Base64ToBI(String Image) throws IOException {
		String base64Image = Image.split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		BufferedImage bufimg = ImageIO.read(new ByteArrayInputStream(imageBytes));
		return bufimg;
	}

	private static void fileupload() throws InterruptedException, AWTException, IOException {
		String userDirectory = System.getProperty("user.dir");
		userDirectory = userDirectory.replaceAll("/", "\\\\/");
		Thread.sleep(3000);
		String command = PortalParam.upload_file_location + "upload.exe";
		File file = new File(PortalParam.upload_file_location + "BankStatement.pdf");
		Runtime.getRuntime().exec(command + " " + file.getAbsolutePath());
		Thread.sleep(3000);
	}

	public static void DocUpload(String Platform, String PicturesBase64, String OpenBase64)
			throws InterruptedException, FindFailed, IOException, AWTException {
		if (Platform.equals("linux")) {
			Thread.sleep(3000);
			Screen UploadScreen = new Screen();
			Pattern Pictures = new Pattern(Base64ToBI(PicturesBase64));
			Pattern Open = new Pattern(Base64ToBI(OpenBase64));
			Thread.sleep(2000);
			UploadScreen.click(Pictures);
			Thread.sleep(2000);
			UploadScreen.click(Open);
			Thread.sleep(3000);
		} else {
			fileupload();
		}
	}

	public static void DocUploadHTML() throws InterruptedException, IOException {
		String userDirectory = System.getProperty("user.dir");
		userDirectory = userDirectory.replaceAll("/", "\\\\/");
		Thread.sleep(3000);
		String command = PortalParam.upload_file_location + "upload.exe";
		File file = new File(PortalParam.upload_file_location + "BankStatement.html");
		Runtime.getRuntime().exec(command + " " + file.getAbsolutePath());
		Thread.sleep(3000);

	}

}
