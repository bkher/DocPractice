package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class CoborrowerMaritalPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(CoborrowerMaritalPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public CoborrowerMaritalPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.COBORROWER_MaritalPageLabel)).getText())
							.contains(removeSpecialChar("Cob, Please tell us about your marital status.")),
					"Page title does not contain " + "Please tell us about your marital status.");
			logger.info("=========== CoborrowerMaritalPage is loaded============");
		} catch (Exception e) {
			throw new Exception("CoborrowerMaritalPage could not be loaded within time");
		}
	}

	public void selectApplicants_Married(WebDriver driver) throws Exception {
		PortalParam.CoborrowerSpouseEmail = getCoborrowerId(1);
		Thread.sleep(1500);
		selectBoolean(getLocator(uiObjParam.COBORROWER_MaritalMarried), portalParam.married);
		Thread.sleep(3500);
		if (portalParam.SpouseAsCoBorrower == 1) {
			clickButton(driver, getLocator(uiObjParam.COBORROWER_MaritalYes), "Yes");
			Thread.sleep(20000);
			insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalDOB), portalParam.dateOfBirth);
			insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalSSN), portalParam.ssnNumber);
			insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalEmailID), PortalParam.CoborrowerSpouseEmail);
			insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalCellPhone), portalParam.borrowerPhone);

		} else {
			clickButton(driver, getLocator(uiObjParam.COBORROWER_MaritalNo), "No");
		}
		insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalFirstName), portalParam.spouceFirstName);

		insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalLastName), portalParam.spouceLastName);

		clickButton(driver, getLocator(uiObjParam.COBORROWER_MaritalNext), "Next");
		Thread.sleep(7000);
	}

	public void selectApplicants_UnMarried(WebDriver driver) throws Exception {

		Thread.sleep(1500);
		selectBoolean(getLocator(uiObjParam.COBORROWER_MaritalUnMarried), portalParam.married);
		Thread.sleep(3500);

		clickButton(driver, getLocator(uiObjParam.COBORROWER_MaritalNext), "Next");
	}
	
	public void selectApplicants_Separated(WebDriver driver) throws Exception {

		Thread.sleep(1500);
		selectBoolean(getLocator(uiObjParam.COBORROWER_MaritalSeprated), portalParam.married);
		Thread.sleep(3500);
		
		insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalFirstName), portalParam.spouceFirstName);

		insertText(driver, getLocator(uiObjParam.COBORROWER_MaritalLastName), portalParam.spouceLastName);


		clickButton(driver, getLocator(uiObjParam.COBORROWER_MaritalNext), "Next");
	}

	public void selectBoolean(By locator, int value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		logger.info("Selected boolean :" + value);
	}
}
