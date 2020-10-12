package net.sigmainfo.lf.automation.portal.pages.Borrower;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;
import net.sigmainfo.lf.automation.portal.pages.Lender.LenderGetStartedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;

/**
 * Created by Shaishav.s on 24-04-2018.
 */
public class WelcomePage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(WelcomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public WelcomePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			waitForElementToBeClickable(getLocator(uiObjParam.borrowerHeader_profileDropdown));
			waitForElementToBeClickable(getLocator(uiObjParam.borrowerWelcomePage_purchaseLoanButton));
			waitForElementToBeClickable(getLocator(uiObjParam.borrowerWelcomePage_refinanceLoanButton));
			logger.info("=========== WelcomePage is loaded============");
		} catch (Exception e) {
			throw new Exception("WelcomePage could not be loaded within time");
		}
	}

	public void selectLoanOption(WebDriver driver) throws Exception {

		if ((portalParam.loanType).contains("Purchase")) {
			clickButton(driver, getLocator(uiObjParam.borrowerWelcomePage_purchaseLoanButton), "Purchase Loan");
		} else {
			clickButton(driver, getLocator(uiObjParam.borrowerWelcomePage_refinanceLoanButton), "Refinance Loan");
		}

		//retrySelectLoanOption(driver);
		Thread.sleep(4000);
	}

	public void retrySelectLoanOption(WebDriver driver) throws Exception {
		try {
			Thread.sleep(6000);
			if ((portalParam.loanType).contains("Purchase")) {
				clickButton(driver, getLocator(uiObjParam.borrowerWelcomePage_purchaseLoanButton), "Purchase Loan");
				logger.info("Selected Loan Type after retry......");
			} else {
				clickButton(driver, getLocator(uiObjParam.borrowerWelcomePage_refinanceLoanButton), "Refinance Loan");
				logger.info("Selected Loan Type after retry......");
			}
		} catch (Exception e) {
			logger.info("Loan purpose was already selected......");
			
		}
	}

	public LoginPage logout() throws Exception {
		try {
			clickButton(driver, getLocator(uiObjParam.borrowerHeader_profileDropdown), "Profile Dropdown");
			clickButton(driver, getLocator(uiObjParam.borrowerHeader_profileDropdown_logoutButton), "Logout");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return new LoginPage(driver);
	}
}
