package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

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

/**
 * Created by shaishav.s on 07-05-2018.
 */
public class BorrowerSelfEmploymentIncomePage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerSelfEmploymentIncomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerSelfEmploymentIncomePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(7000);
			logger.info("=========== BorrowerSelfEmploymentIncomePage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerSelfEmploymentIncomePage could not be loaded within time");
		}
	}

	public void provideSelfEmploymentDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.businessSelfEmploymentPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please share more about your self-employment income.")),
				"Page title does not contain please share more about your self-employment income.");

		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_monthlyIncomeTextBox),
				portalParam.selfEmploymentMonthlyIncome);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_companyNameTextBox),
				portalParam.selfEmploymentCompanyName);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_titleTextBox),
				portalParam.selfEmploymentTitle);
		selectAddress(getLocator(uiObjParam.businessSelfEmploymentPage_companyAddressTextBox),
				portalParam.selfEmploymentBusinessAddress);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_companyPhoneTextBox),
				portalParam.selfEmploymentBusinessPhone);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_companyStartDateTextBox),
				portalParam.selfEmploymentBusinessStartDate);
		if (portalParam.percentageOwnership==1) {
			clickButton(driver, getLocator(uiObjParam.businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton),
					"Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton),
					"No");
		}
		scrollToBottomOfThePage(driver);
		selectCompanyType(driver,getLocator(uiObjParam.businessSelfEmploymentPage_typeOfCompanyDropdown),
				portalParam.typeOfCompany);
		scrollToElementandClick(driver, getLocator(uiObjParam.businessSelfEmploymentPage_nextButton));
		Thread.sleep(7000);
	}
	
	public void provideSelfEmploymentDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.businessSelfEmploymentPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please share more about your spouse's self-employment income.")),
				"Page title does not contain Please share more about your spouse's self-employment income.");

		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_monthlyIncomeTextBox),
				portalParam.selfEmploymentMonthlyIncome);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_companyNameTextBox),
				portalParam.selfEmploymentCompanyName);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_titleTextBox),
				portalParam.selfEmploymentTitle);
		selectAddress(getLocator(uiObjParam.businessSelfEmploymentPage_companyAddressTextBox),
				portalParam.selfEmploymentBusinessAddress);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_companyPhoneTextBox),
				portalParam.selfEmploymentBusinessPhone);
		enterText(driver, getLocator(uiObjParam.businessSelfEmploymentPage_companyStartDateTextBox),
				portalParam.selfEmploymentBusinessStartDate);
		if (portalParam.percentageOwnership==1) {
			clickButton(driver, getLocator(uiObjParam.businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton),
					"Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton),
					"No");
		}
		scrollToBottomOfThePage(driver);
		selectCompanyType(driver,getLocator(uiObjParam.businessSelfEmploymentPage_typeOfCompanyDropdown),
				portalParam.typeOfCompany);
		scrollToElementandClick(driver, getLocator(uiObjParam.businessSelfEmploymentPage_nextButton));
		Thread.sleep(7000);
	}
	
	public void provideSelfEmploymentDetails_Spouse() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please share more about your spouse's self-employment income.")),
				"Page title does not contain Please share more about your spouse's self-employment income.");

		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox),
				portalParam.selfEmploymentMonthlyIncome);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyNameTextBox),
				portalParam.selfEmploymentCompanyName);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_titleTextBox),
				portalParam.selfEmploymentTitle);
		selectAddress(getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyAddressTextBox),
				portalParam.selfEmploymentBusinessAddress);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyPhoneTextBox),
				portalParam.selfEmploymentBusinessPhone);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyStartDateTextBox),
				portalParam.selfEmploymentBusinessStartDate);
		if (portalParam.percentageOwnership==1) {
			clickButton(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton),
					"Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton),
					"No");
		}
		scrollToBottomOfThePage(driver);
		Thread.sleep(2000);
		selectCompanyType_Spouse(driver,getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown),
		 	portalParam.typeOfCompany);
		scrollToElementandClick(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_nextButton));
		Thread.sleep(7000);
	}
	
	public void provideSelfEmploymentDetails_SpouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please share more about your self-employment income.")),
				"Page title does not contain Please share more about your self-employment income.");

		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox),
				portalParam.selfEmploymentMonthlyIncome);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyNameTextBox),
				portalParam.selfEmploymentCompanyName);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_titleTextBox),
				portalParam.selfEmploymentTitle);
		selectAddress(getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyAddressTextBox),
				portalParam.selfEmploymentBusinessAddress);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyPhoneTextBox),
				portalParam.selfEmploymentBusinessPhone);
		enterText(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_companyStartDateTextBox),
				portalParam.selfEmploymentBusinessStartDate);
		if (portalParam.percentageOwnership==1) {
			clickButton(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton),
					"Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton),
					"No");
		}
		scrollToBottomOfThePage(driver);
		Thread.sleep(2000);
		selectCompanyType_Spouse(driver,getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown),
		 	portalParam.typeOfCompany);
		scrollToElementandClick(driver, getLocator(uiObjParam.SpousebusinessSelfEmploymentPage_nextButton));
		Thread.sleep(7000);
	}
	
	private void selectCompanyType(WebDriver driver, By locator, String value) throws Exception {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).click();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	private void selectCompanyType_Spouse(WebDriver driver, By locator, String value) throws Exception {
	
		String dyam = null;
		if(portalParam.ClientName.contains("NAF")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[15]/questioner-question-set[1]/div[10]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
		if(portalParam.ClientName.contains("OC")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[17]/questioner-question-set[1]/div[10]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		String ID = driver.findElement(locator).getAttribute("data-activates");
		driver.findElement(locator).click();
		Thread.sleep(1000);
			driver.findElement(By.xpath(dyam)).click();
			Thread.sleep(1000);
	}
	
	
}
