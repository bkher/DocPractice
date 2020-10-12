package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 25-04-2018.
 */
public class BorrowerEmploymentPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(BorrowerEmploymentPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerEmploymentPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			logger.info("=========== BorrowerEmploymentPage is loaded============");
		} catch (Exception e) {
			throw new Exception("EmploymentPage could not be loaded within time");
		}
	}

	public void provideEmploymentDetails() throws Exception {
		assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.employmentPage_pageLabel)).getText())
				.contains(removeSpecialChar("Please tell us about your employment income for the past two years.")),
				"Page title does not contain " + "please tell us about your employment income for the past two years.");

		enterText(driver, getLocator(uiObjParam.employmentPage_currentEmployerTextBox),
				portalParam.borrowerCurrentEmployer);
		enterText(driver, getLocator(uiObjParam.employmentPage_titleTextBox), portalParam.borrowerTitle);
		enterText(driver, getLocator(uiObjParam.employmentPage_startDateTextBox),
				portalParam.borrowerEmploymentStartDate);
		enterText(driver, getLocator(uiObjParam.employmentPage_inThisLineYearsTextBox),
				portalParam.borrowerInThisLineYear);
		enterText(driver, getLocator(uiObjParam.employmentPage_inThisLineMonthsTextBox),
				portalParam.borrowerInThisLineMonth);
		selectAddress(getLocator(uiObjParam.employmentAddressPage_businessAddressTextBox),
				portalParam.borrowerBusinessAddress);
		enterText(driver, getLocator(uiObjParam.employmentAddressPage_phoneNumberTextBox),
				portalParam.borrowerBusinessPhone);
		enterText(driver, getLocator(uiObjParam.employmentPage_monthlyBaseSalaryTextBox),
				portalParam.borrowerMonthlyBaseSalary);
		Thread.sleep(2000);
		clickButton(driver, getLocator(uiObjParam.employmentPage_bonusButton), "Bonus");
		enterText(driver, getLocator(uiObjParam.employmentPage_bonusTextBox), portalParam.borrowerBonusAmount);
		clickButton(driver, getLocator(uiObjParam.employmentPage_nextButton), "Next");
		if (portalParam.ClientName.contains("OC")) {
			clickButton(driver, getLocator(uiObjParam.employmentPage_nextButton), "Next");
		}
		Thread.sleep(6000);
	}

	public void provideEmploymentDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.employmentPage_pageLabel)).getText())
						.contains(removeSpecialChar(
								"Please tell us about your spouse's employment income for the past two years.")),
				"Page title does not contain "
						+ "Please tell us about your spouse's employment income for the past two years.");

		enterText(driver, getLocator(uiObjParam.employmentPage_currentEmployerTextBox),
				portalParam.borrowerCurrentEmployer);
		enterText(driver, getLocator(uiObjParam.employmentPage_titleTextBox), portalParam.borrowerTitle);
		enterText(driver, getLocator(uiObjParam.employmentPage_startDateTextBox),
				portalParam.borrowerEmploymentStartDate);
		enterText(driver, getLocator(uiObjParam.employmentPage_inThisLineYearsTextBox),
				portalParam.borrowerInThisLineYear);
		enterText(driver, getLocator(uiObjParam.employmentPage_inThisLineMonthsTextBox),
				portalParam.borrowerInThisLineMonth);
		selectAddress(getLocator(uiObjParam.employmentAddressPage_businessAddressTextBox),
				portalParam.borrowerBusinessAddress);
		enterText(driver, getLocator(uiObjParam.employmentAddressPage_phoneNumberTextBox),
				portalParam.borrowerBusinessPhone);
		enterText(driver, getLocator(uiObjParam.employmentPage_monthlyBaseSalaryTextBox),
				portalParam.borrowerMonthlyBaseSalary);
		Thread.sleep(2000);
		clickButton(driver, getLocator(uiObjParam.employmentPage_bonusButton), "Bonus");
		enterText(driver, getLocator(uiObjParam.employmentPage_bonusTextBox), portalParam.borrowerBonusAmount);
		clickButton(driver, getLocator(uiObjParam.employmentPage_nextButton), "Next");
		if (portalParam.ClientName.contains("OC")) {
			clickButton(driver, getLocator(uiObjParam.employmentPage_nextButton), "Next");
		}

		Thread.sleep(6000);
	}

	public void provideEmploymentDetails_Spouse() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpouseemploymentPage_pageLabel)).getText())
						.contains(removeSpecialChar(
								"Please tell us about your spouse's employment income for the past two years.")),
				"Page title does not contain "
						+ "Please tell us about your spouse's employment income for the past two years.");

		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_currentEmployerTextBox),
				portalParam.borrowerCurrentEmployer);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_titleTextBox), portalParam.borrowerTitle);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_startDateTextBox),
				portalParam.borrowerEmploymentStartDate);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_inThisLineYearsTextBox),
				portalParam.borrowerInThisLineYear);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_inThisLineMonthsTextBox),
				portalParam.borrowerInThisLineMonth);
		selectAddress(getLocator(uiObjParam.SpousemploymentAddressPage_businessAddressTextBox),
				portalParam.borrowerBusinessAddress);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentAddressPage_phoneNumberTextBox),
				portalParam.borrowerBusinessPhone);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_monthlyBaseSalaryTextBox),
				portalParam.borrowerMonthlyBaseSalary);
		Thread.sleep(2000);
		clickButton(driver, getLocator(uiObjParam.SpouseemploymentPage_bonusButton), "Bonus");
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_bonusTextBox), portalParam.borrowerBonusAmount);
		clickButton(driver, getLocator(uiObjParam.SpouseemploymentPage_nextButton), "Next");
		if (portalParam.ClientName.contains("OC")) {
			clickButton(driver, getLocator(uiObjParam.SpouseemploymentPage_nextButton), "Next");
		}
		Thread.sleep(6000);
	}

	public void provideEmploymentDetails_SpouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpouseemploymentPage_pageLabel)).getText())
						.contains(removeSpecialChar(
								"Please tell us about your employment income for the past two years.")),
				"Page title does not contain " + "Please tell us about your employment income for the past two years.");

		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_currentEmployerTextBox),
				portalParam.borrowerCurrentEmployer);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_titleTextBox), portalParam.borrowerTitle);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_startDateTextBox),
				portalParam.borrowerEmploymentStartDate);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_inThisLineYearsTextBox),
				portalParam.borrowerInThisLineYear);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_inThisLineMonthsTextBox),
				portalParam.borrowerInThisLineMonth);
		selectAddress(getLocator(uiObjParam.SpousemploymentAddressPage_businessAddressTextBox),
				portalParam.borrowerBusinessAddress);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentAddressPage_phoneNumberTextBox),
				portalParam.borrowerBusinessPhone);
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_monthlyBaseSalaryTextBox),
				portalParam.borrowerMonthlyBaseSalary);
		Thread.sleep(2000);
		clickButton(driver, getLocator(uiObjParam.SpouseemploymentPage_bonusButton), "Bonus");
		enterText(driver, getLocator(uiObjParam.SpouseemploymentPage_bonusTextBox), portalParam.borrowerBonusAmount);
		clickButton(driver, getLocator(uiObjParam.SpouseemploymentPage_nextButton), "Next");
		if (portalParam.ClientName.contains("OC")) {
			clickButton(driver, getLocator(uiObjParam.SpouseemploymentPage_nextButton), "Next");
		}
		Thread.sleep(6000);
	}

}
