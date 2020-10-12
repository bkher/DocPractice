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


public class RefinanceLoanAmountPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(RefinanceLoanAmountPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public RefinanceLoanAmountPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.loanAmountPage_pageLabel)).getText())
					.contains(removeSpecialChar("Tell us about the loan you want.")),
					"Page title does not contain " + "Tell us about the loan you want.");
			logger.info("=========== RefinanceLoanAmountPage is loaded============");
		} catch (Exception e) {
			throw new Exception("RefinanceLoanAmountPage could not be loaded within time");
		}
	}



	public void enterLoanDetails(WebDriver driver) throws Exception {
		enterText(driver, getLocator(uiObjParam.RefinancePage_RefinanceLoanAmount), portalParam.purchasePrice);
		enterText(driver, getLocator(uiObjParam.RefinancePage_1stLoanAmount), portalParam.downPayment);
		enterText(driver, getLocator(uiObjParam.RefinancePage_2ndLoanAmount), portalParam.purchasePrice);
		enterText(driver, getLocator(uiObjParam.RefinancePage_OtherLoanAmount), portalParam.purchasePrice);
		clickButton(driver, getLocator(uiObjParam.RefinancePage_IsNotcashoutequality), "Next");
		clickButton(driver, getLocator(uiObjParam.loanAmountPage_nextButton), "Next");

	}
	
	
	
	public void enterLoanDetails_SpouseVerifyHisSpouseDetails(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.loanAmountPage_nextButton), "Next");

	}
}
