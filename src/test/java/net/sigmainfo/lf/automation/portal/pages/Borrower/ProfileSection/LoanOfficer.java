package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Rengarajan.m on 29-04-2018.
 */
public class LoanOfficer extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(LoanOfficer.class);
	WebDriverWait wait = new WebDriverWait(driver, 24);

	public LoanOfficer(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			  Thread.sleep(7000);
			logger.info("=========== LoanOfficerPage is loaded============");
		} catch (Exception e) {
			throw new Exception("LoanOfficerPage could not be loaded within time");
		}
	}

	public LoanOfficer() {
	}

	public void SubmitLoanOfficerDetails(WebDriver driver) throws Exception {

	
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.LoanOfferPage_PageLabel)).getText())
							.contains(removeSpecialChar("Please tell us about your loan officer.")),
					"Page title does not contain " + ", Please tell us about your loan officer.");

			if (portalParam.LoanOfficer == 1) {
				clickButton(driver, getLocator(uiObjParam.LoanOfferPage_YesLoanOfficer), "Yes");
				enterText(driver, getLocator(uiObjParam.LoanOfferPage_SearchLoanOfficer), portalParam.LoanOfficerName);
			} else {

				clickButton(driver, getLocator(uiObjParam.LoanOfferPage_NoLoanOfficer), "No");
			}

			clickButton(driver, getLocator(uiObjParam.LoanOfferPage_NextLoanOfficer), "Next");

		
	}

	public void SubmitLoanOfficerDetails_coborrower(WebDriver driver) throws Exception {

		
			assertTrue(
					removeSpecialChar(
							driver.findElement(getLocator(uiObjParam.CoborrowerLoanOfficer_PageLabel)).getText())
									.contains(removeSpecialChar("Loan officer details")),
					"Page title does not contain " + ",Loan officer details");

			clickButton(driver, getLocator(uiObjParam.LoanOfferPage_NextLoanOfficer), "Next");

		
	}
}
