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
public class BorrowerSocialSecurityIncomePage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(BorrowerSocialSecurityIncomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerSocialSecurityIncomePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(7000);
			logger.info("=========== BorrowerSocialSecurityIncomePage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerSocialSecurityIncomePage could not be loaded within time");
		}
	}

	public void provideSocialSecurityIncomeDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.socialSecurityPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us more about your social security income.")),
				"Page title does not contain please tell us more about your social security income.");
		enterText(driver, getLocator(uiObjParam.socialSecurityPage_incomePerMonthTextBox),
				portalParam.socialSecurityIncome);
		clickButton(driver, getLocator(uiObjParam.socialSecurityPage_nextButton), "Next");
		Thread.sleep(7000);
	}

	public void provideSocialSecurityIncomeDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.socialSecurityPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us more about your spouse's social security income.")),
				"Page title does not contain Please tell us more about your spouse's social security income.");
		enterText(driver, getLocator(uiObjParam.socialSecurityPage_incomePerMonthTextBox),
				portalParam.socialSecurityIncome);
		clickButton(driver, getLocator(uiObjParam.socialSecurityPage_nextButton), "Next");
		Thread.sleep(7000);
	}

	public void provideSocialSecurityIncomeDetails_Spouse() throws Exception {
		assertTrue(removeSpecialChar(
				driver.findElement(getLocator(uiObjParam.SpousesocialSecurityPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us more about your spouse's social security income.")),
				"Page title does not contain Please tell us more about your spouse's social security income.");
		enterText(driver, getLocator(uiObjParam.SpousesocialSecurityPage_incomePerMonthTextBox),
				portalParam.socialSecurityIncome);
		clickButton(driver, getLocator(uiObjParam.SpousesocialSecurityPage_nextButton), "Next");
		Thread.sleep(7000);
	}

	public void provideSocialSecurityIncomeDetails_SpouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.SpousesocialSecurityPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us more about your social security income.")),
				"Page title does not contain Please tell us more about your social security income.");
		enterText(driver, getLocator(uiObjParam.SpousesocialSecurityPage_incomePerMonthTextBox),
				portalParam.socialSecurityIncome);
		clickButton(driver, getLocator(uiObjParam.SpousesocialSecurityPage_nextButton), "Next");
		Thread.sleep(7000);
	}
}
