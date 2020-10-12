package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 07-05-2018.
 */
public class BorrowerAlimondyChildSupportPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerAlimondyChildSupportPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerAlimondyChildSupportPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			logger.info("=========== BorrowerAlimondyChildSupportPage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerAlimondyChildSupportPage could not be loaded within time");
		}
	}

	public void provideAlimonyDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.alimondyChildSupportPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us about the support you receive.")),
				"Page title does not contain " + "Please tell us about the support you receive.");
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_alimonyPerMonthTextBox),
				portalParam.borrowerMonthlyAlimony);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_alimonyStartDateTextBox),
				portalParam.borrowerAlimonyStartDate);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_childSupportPerMonthTextBox),
				portalParam.borrowerMonthlyChildSupport);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_childNameTextBox),
				portalParam.borrowerSupportChildName);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_childDoBTextBox),
				portalParam.borrowerSupportChildDoB);
		clickButton(driver, getLocator(uiObjParam.alimondyChildSupportPage_nextButton), "Next");
		Thread.sleep(6000);
	}

	public void provideAlimonyDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.alimondyChildSupportPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us about the support your spouse receive.")),
				"Page title does not contain " + "Please tell us about the support your spouse receive.");
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_alimonyPerMonthTextBox),
				portalParam.borrowerMonthlyAlimony);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_alimonyStartDateTextBox),
				portalParam.borrowerAlimonyStartDate);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_childSupportPerMonthTextBox),
				portalParam.borrowerMonthlyChildSupport);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_childNameTextBox),
				portalParam.borrowerSupportChildName);
		enterText(driver, getLocator(uiObjParam.alimondyChildSupportPage_childDoBTextBox),
				portalParam.borrowerSupportChildDoB);
		clickButton(driver, getLocator(uiObjParam.alimondyChildSupportPage_nextButton), "Next");
		Thread.sleep(6000);
	}

	public void provideAlimonyDetails_Spouse() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.SpousealimondyChildSupportPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us about the support your spouse receive.")),
				"Page title does not contain " + "Please tell us about the support your spouse receive.");
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_alimonyPerMonthTextBox),
				portalParam.borrowerMonthlyAlimony);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_alimonyStartDateTextBox),
				portalParam.borrowerAlimonyStartDate);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_childSupportPerMonthTextBox),
				portalParam.borrowerMonthlyChildSupport);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_childNameTextBox),
				portalParam.borrowerSupportChildName);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_childDoBTextBox),
				portalParam.borrowerSupportChildDoB);
		clickButton(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_nextButton), "Next");
		Thread.sleep(6000);

	}

	public void provideAlimonyDetails_SpouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.SpousealimondyChildSupportPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us about the support you receive.")),
				"Page title does not contain " + "Please tell us about the support you receive.");
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_alimonyPerMonthTextBox),
				portalParam.borrowerMonthlyAlimony);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_alimonyStartDateTextBox),
				portalParam.borrowerAlimonyStartDate);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_childSupportPerMonthTextBox),
				portalParam.borrowerMonthlyChildSupport);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_childNameTextBox),
				portalParam.borrowerSupportChildName);
		enterText(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_childDoBTextBox),
				portalParam.borrowerSupportChildDoB);
		clickButton(driver, getLocator(uiObjParam.SpousealimondyChildSupportPage_nextButton), "Next");
		Thread.sleep(6000);

	}
}
