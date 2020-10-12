package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 08-05-2018.
 */
public class BorrowerInterestDividendPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerInterestDividendPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerInterestDividendPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			 logger.info("=========== BorrowerInterestDividendPage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerInterestDividendPage could not be loaded within time");
		}
	}

	public BorrowerInterestDividendPage() {
	}

	public void provideInterestDividendIncomeDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.interestDividendPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us more about your dividends or interest income.")),
				"Page title does not contain " + "please tell us more about your dividends or interest income.");
		

		enterText(driver, getLocator(uiObjParam.interestDividendPage_lastYearDividendTextBox),
				portalParam.interestLastYear);
		enterText(driver, getLocator(uiObjParam.interestDividendPage_yearBeforeLastYearDividendTextBox),
				portalParam.interestPreviousYear);
		clickButton(driver, getLocator(uiObjParam.interestDividendPage_nextButton), "Next");
		Thread.sleep(6000);
	}
	
	public void provideInterestDividendIncomeDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.interestDividendPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us more about your spouse's dividends or interest income.")),
				"Page title does not contain " + "Please tell us more about your spouse's dividends or interest income.");
		

		enterText(driver, getLocator(uiObjParam.interestDividendPage_lastYearDividendTextBox),
				portalParam.interestLastYear);
		enterText(driver, getLocator(uiObjParam.interestDividendPage_yearBeforeLastYearDividendTextBox),
				portalParam.interestPreviousYear);
		clickButton(driver, getLocator(uiObjParam.interestDividendPage_nextButton), "Next");
		Thread.sleep(6000);
	}
	
	public void provideInterestDividendIncomeDetails_Spouse() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.SpouseinterestDividendPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us more about your spouse's dividends or interest income.")),
				"Page title does not contain " + "Please tell us more about your spouse's dividends or interest income.");
		

		enterText(driver, getLocator(uiObjParam.SpouseinterestDividendPage_lastYearDividendTextBox),
				portalParam.interestLastYear);
		enterText(driver, getLocator(uiObjParam.SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox),
				portalParam.interestPreviousYear);
		clickButton(driver, getLocator(uiObjParam.SpouseinterestDividendPage_nextButton), "Next");
		Thread.sleep(6000);
	}
	
	public void provideInterestDividendIncomeDetails_SpouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.borrowerSpouseinterestDividendPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us more about your dividends or interest income.")),
				"Page title does not contain " + "Please tell us more about your dividends or interest income.");
		

		enterText(driver, getLocator(uiObjParam.SpouseinterestDividendPage_lastYearDividendTextBox),
				portalParam.interestLastYear);
		enterText(driver, getLocator(uiObjParam.SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox),
				portalParam.interestPreviousYear);
		clickButton(driver, getLocator(uiObjParam.SpouseinterestDividendPage_nextButton), "Next");
		Thread.sleep(6000);
	}
}
