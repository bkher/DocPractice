package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class LoanAmountPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(LoanAmountPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public LoanAmountPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.loanAmountPage_pageLabel)).getText())
					.contains(removeSpecialChar("Tell us about the loan you want.")),
					"Page title does not contain " + "Tell us about the loan you want.");
			assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.loanAmountPage_purchasePriceTextbox)),
					"Purchase price text is not clickable.");
			logger.info("=========== LoanAmountPage is loaded============");
		} catch (Exception e) {
			throw new Exception("LoanAmountPage could not be loaded within time");
		}
	}



	public void enterLoanDetails(WebDriver driver) throws Exception {
		enterText(driver, getLocator(uiObjParam.loanAmountPage_purchasePriceTextbox), portalParam.purchasePrice);
		enterText(driver, getLocator(uiObjParam.loanAmountPage_downPaymentTextbox), portalParam.downPayment);
		assertEquals(Integer.parseInt(
				driver.findElement(getLocator(uiObjParam.loanAmountPage_loanPercentageTextbox)).getAttribute("value")),
				20);
		assertEquals(driver.findElement(getLocator(uiObjParam.loanAmountPage_loanAmountTextbox)).getAttribute("value"),
				"$ 400,000");
		clickButton(driver, getLocator(uiObjParam.loanAmountPage_nextButton), "Next");

	}
	
	public void enterLoanDetails_SpouseVerifyHisSpouseDetails(WebDriver driver) throws Exception {
		clickButton(driver, getLocator(uiObjParam.loanAmountPage_nextButton), "Next");

	}
}
