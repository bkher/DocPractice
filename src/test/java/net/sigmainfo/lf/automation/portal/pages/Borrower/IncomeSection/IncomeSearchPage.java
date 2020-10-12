package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetCompletedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 25-04-2018.
 */
public class IncomeSearchPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(IncomeSearchPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public IncomeSearchPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(7000);
			logger.info("=========== IncomeSearchPage is loaded============");
		} catch (Exception e) {
			throw new Exception("IncomeSearchPage could not be loaded within time");
		}
	}

	public void selectIncomeTypes() throws Exception {
	
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.incomeSearchPage_pageLabel)).getText())
							.contains(removeSpecialChar(portalParam.borrowerFirstname + ",'s income")),
					"Page title does not contain " + portalParam.borrowerFirstname + ",'s income");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_employmentButton), "Employment");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_businessSelfEmploymentButton),
					"Business Self Employment");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_alimonyChildSupportButton),
					"Alimony/Child Support");
			if (portalParam.additionalProperty != 1) {
				clickButton(driver, getLocator(uiObjParam.incomeSearchPage_rentalButton), "Rental");
			}
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_millitaryButton), "Military");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_interestDividendButton), "Interest/Dividend");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_socialSecurityButton), "Social Security");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_othertButton), "Others");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_beginButton), "Begin");
			Thread.sleep(7000);
	}

	public void selectIncomeTypes_SpouseProvideHisSpouseDetails() throws Exception {
	
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.incomeSearchPage_pageLabel)).getText())
							.contains(removeSpecialChar(portalParam.borrowerFirstname + ",'s income")),
					"Page title does not contain " + portalParam.borrowerFirstname + ",'s income");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_employmentButton), "Employment");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_businessSelfEmploymentButton),
					"Business Self Employment");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_alimonyChildSupportButton),
					"Alimony/Child Support");

			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_rentalButton), "Rental");

			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_millitaryButton), "Military");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_interestDividendButton), "Interest/Dividend");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_socialSecurityButton), "Social Security");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_othertButton), "Others");
			clickButton(driver, getLocator(uiObjParam.incomeSearchPage_beginButton), "Begin");
			Thread.sleep(7000);
	}

	public void selectIncomeTypes_coborrower() throws Exception {
	
			assertTrue(
					removeSpecialChar(
							driver.findElement(getLocator(uiObjParam.CoborrowerincomeSearchPage_pageLabel)).getText())
									.contains(removeSpecialChar(portalParam.borrowerFirstname + ",'s income")),
					"Page title does not contain " + portalParam.borrowerFirstname + ",'s income");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_employmentButton), "Employment");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_businessSelfEmploymentButton),
					"Business Self Employment");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_alimonyChildSupportButton),
					"Alimony/Child Support");
			if (portalParam.additionalProperty != 1) {
				clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_rentalButton), "Rental");
			}
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_millitaryButton), "Military");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_interestDividendButton),
					"Interest/Dividend");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_socialSecurityButton),
					"Social Security");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_othertButton), "Others");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_beginButton), "Begin");
			Thread.sleep(7000);

	}

	public void selectIncomeTypes_SpouseLoginSubmitscoborrower() throws Exception {
		
			assertTrue(
					removeSpecialChar(
							driver.findElement(getLocator(uiObjParam.CoborrowerincomeSearchPage_pageLabel)).getText())
									.contains(removeSpecialChar(portalParam.borrowerFirstname + ",'s income")),
					"Page title does not contain " + portalParam.borrowerFirstname + ",'s income");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_employmentButton), "Employment");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_businessSelfEmploymentButton),
					"Business Self Employment");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_alimonyChildSupportButton),
					"Alimony/Child Support");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_rentalButton), "Rental");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_millitaryButton), "Military");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_interestDividendButton),
					"Interest/Dividend");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_socialSecurityButton),
					"Social Security");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_othertButton), "Others");
			clickButton(driver, getLocator(uiObjParam.CoborrowerincomeSearchPage_beginButton), "Begin");
			Thread.sleep(7000);
	}

	public void selectIncomeTypes_Spousecoborrower() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpouseincomeSearchPage_pageLabel)).getText())
						.contains(removeSpecialChar(portalParam.spouceFirstName + ",'s income")),
				"Page title does not contain " + portalParam.spouceFirstName + ",'s income");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_employmentButton), "Employment");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_businessSelfEmploymentButton),
				"Business Self Employment");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_alimonyChildSupportButton),
				"Alimony/Child Support");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_rentalButton), "Rental");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_millitaryButton), "Military");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_interestDividendButton), "Interest/Dividend");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_socialSecurityButton), "Social Security");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_othertButton), "Others");
		clickButton(driver, getLocator(uiObjParam.SpouseincomeSearchPage_beginButton), "Begin");
		Thread.sleep(7000);
	}
}
