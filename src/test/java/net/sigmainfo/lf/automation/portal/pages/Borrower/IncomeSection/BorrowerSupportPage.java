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
public class BorrowerSupportPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerSupportPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerSupportPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(7000);

			logger.info("=========== BorrowerSupportPage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerSupportPage could not be loaded within time");
		}
	}

	public void provideSupportDetails() throws Exception {

		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.supportPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about the support you receive.")),
				"Page title does not contain Please tell us about the support your spouse receive.");
		if (portalParam.borrowerSupportByCourt == 1) {
			clickButton(driver, getLocator(uiObjParam.supportPage_supportByCourtButton), "borrowerSupportByCourt-Yes");
			if (portalParam.borrowerWillReceiveOrderByCourt == 1) {
				clickButton(driver, getLocator(uiObjParam.supportPage_willReceiveCourtSupportButton),
						"Receive court support-Yes");
				if (portalParam.borrowerTwoMonthSupport == 1) {
					clickButton(driver, getLocator(uiObjParam.supportPage_postLoanClosureSupportButton),
							"Loan closure support - Yes");
				} else {
					clickButton(driver, getLocator(uiObjParam.supportPage_postLoanClosureNoSupportButton),
							"Loan closure support - No");
				}
			} else {
				clickButton(driver, getLocator(uiObjParam.supportPage_willNotReceiveCourtSupportButton),
						"Receive court support-No");
			}
		} else {
			clickButton(driver, getLocator(uiObjParam.supportPage_noSupportByCourtButton), "borrowerSupportByCourt-No");
		}
		clickButton(driver, getLocator(uiObjParam.supportPage_nextButton), "Next");
		Thread.sleep(7000);
	}

	public void provideSupportDetails_SpouseProvideHisSpouseDetails() throws Exception {

		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.supportPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about the support your spouse receive.")),
				"Page title does not contain Please tell us about the support your spouse receive.");
		if (portalParam.borrowerSupportByCourt == 1) {
			clickButton(driver, getLocator(uiObjParam.supportPage_supportByCourtButton), "borrowerSupportByCourt-Yes");
			if (portalParam.borrowerWillReceiveOrderByCourt == 1) {
				clickButton(driver, getLocator(uiObjParam.supportPage_willReceiveCourtSupportButton),
						"Receive court support-Yes");
				if (portalParam.borrowerTwoMonthSupport == 1) {
					clickButton(driver, getLocator(uiObjParam.supportPage_postLoanClosureSupportButton),
							"Loan closure support - Yes");
				} else {
					clickButton(driver, getLocator(uiObjParam.supportPage_postLoanClosureNoSupportButton),
							"Loan closure support - No");
				}
			} else {
				clickButton(driver, getLocator(uiObjParam.supportPage_willNotReceiveCourtSupportButton),
						"Receive court support-No");
			}
		} else {
			clickButton(driver, getLocator(uiObjParam.supportPage_noSupportByCourtButton), "borrowerSupportByCourt-No");
		}
		clickButton(driver, getLocator(uiObjParam.supportPage_nextButton), "Next");
		Thread.sleep(7000);
	}

	public void provideSupportDetails_Spouse() throws Exception {

		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpousesupportPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about the support your spouse receive.")),
				"Page title does not contain please tell us about the support you receive.");
		if (portalParam.borrowerSupportByCourt == 1) {
			clickButton(driver, getLocator(uiObjParam.SpousesupportPage_supportByCourtButton),
					"borrowerSupportByCourt-Yes");
			if (portalParam.borrowerWillReceiveOrderByCourt == 1) {
				clickButton(driver, getLocator(uiObjParam.SpousesupportPage_willReceiveCourtSupportButton),
						"Receive court support-Yes");
				if (portalParam.borrowerTwoMonthSupport == 1) {
					clickButton(driver, getLocator(uiObjParam.SpousesupportPage_postLoanClosureSupportButton),
							"Loan closure support - Yes");
				} else {
					clickButton(driver, getLocator(uiObjParam.SpousesupportPage_postLoanClosureNoSupportButton),
							"Loan closure support - No");
				}
			} else {
				clickButton(driver, getLocator(uiObjParam.SpousesupportPage_willNotReceiveCourtSupportButton),
						"Receive court support-No");
			}
		} else {
			clickButton(driver, getLocator(uiObjParam.SpousesupportPage_noSupportByCourtButton),
					"borrowerSupportByCourt-No");
		}
		clickButton(driver, getLocator(uiObjParam.SpousesupportPage_nextButton), "Next");

		Thread.sleep(7000);

	}

	public void provideSupportDetails_SpouseProvideHisDetails() throws Exception {

		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpousesupportPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about the support you receive.")),
				"Page title does not contain Please tell us about the support you receive.");
		if (portalParam.borrowerSupportByCourt == 1) {
			clickButton(driver, getLocator(uiObjParam.SpousesupportPage_supportByCourtButton),
					"borrowerSupportByCourt-Yes");
			if (portalParam.borrowerWillReceiveOrderByCourt == 1) {
				clickButton(driver, getLocator(uiObjParam.SpousesupportPage_willReceiveCourtSupportButton),
						"Receive court support-Yes");
				if (portalParam.borrowerTwoMonthSupport == 1) {
					clickButton(driver, getLocator(uiObjParam.SpousesupportPage_postLoanClosureSupportButton),
							"Loan closure support - Yes");
				} else {
					clickButton(driver, getLocator(uiObjParam.SpousesupportPage_postLoanClosureNoSupportButton),
							"Loan closure support - No");
				}
			} else {
				clickButton(driver, getLocator(uiObjParam.SpousesupportPage_willNotReceiveCourtSupportButton),
						"Receive court support-No");
			}
		} else {
			clickButton(driver, getLocator(uiObjParam.SpousesupportPage_noSupportByCourtButton),
					"borrowerSupportByCourt-No");
		}
		clickButton(driver, getLocator(uiObjParam.SpousesupportPage_nextButton), "Next");

		Thread.sleep(7000);
	}
}
