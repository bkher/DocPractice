package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.enterText;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getRelationship;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.removeSpecialChar;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.selectDropdownByvalue;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;

public class VAorMilitaryLoanPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(AddCoApplicantsPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public VAorMilitaryLoanPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			assertTrue(
					removeSpecialChar(
							driver.findElement(getLocator(uiObjParam.VAorMilitaryLoanPage_pageLabel)).getText())
									.contains(removeSpecialChar("We are proud to offer VA/Military loans.")),
					"Page title does not contain " + portalParam.borrowerFirstname
							+ ", please add the information for these co-borrowers.");
			logger.info("=========== VA/Military Loan Page  is loaded============");
		} catch (Exception e) {
			throw new Exception("VA/Military Loan Page could not be loaded within time");
		}
	}

	public void MilitaryLoanEligibility(WebDriver driver) throws Exception {
		if (portalParam.EliglibleForMilitary==1) {
			clickButton(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_EligibleForMilitaryLoan), "Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_NotEligibleForMilitaryLoan), "No");
		}

		if (portalParam.MilitaryDuty.equalsIgnoreCase("Active")) {
			clickCheckBox(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDuty),
					"Active Military Duty");
			enterText(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDate),
					portalParam.MilitaryActiveDate);
		} else if (portalParam.MilitaryDuty.equalsIgnoreCase("Retired")) {
			clickCheckBox(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_RetiredMilitary),
					"Retired Military");
		} else if (portalParam.MilitaryDuty.equalsIgnoreCase("Non Active Member")) {
			clickCheckBox(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_NonActiveMilitaryLoan),
					"Non-Active Member"); 
		} else {
			clickCheckBox(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_SurvivingSpouse),
					"Surviving Spouse");
		}

		if (portalParam.ActiveMilitaryLoan==1) {
			clickButton(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryLoan), "Active Military Loan");
		} else {
			clickButton(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_NonActiveMilitaryLoan),
					"Active Military Loan");
		}

		if (portalParam.ChildCareExpenses==1) {
			clickButton(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_PossesChildCareExpense),
					"Active Military Loan");
			enterText(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_ChildCareExpenseTextBox),
					portalParam.ChildCareExpense);
		} else {
			clickButton(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_DontPossesChildCareExpense),
					"Active Military Loan");
		}

		clickButton(driver, getLocator(uiObjParam.VAorMilitaryLoanPage_nextButton), "Next");
	}
}
