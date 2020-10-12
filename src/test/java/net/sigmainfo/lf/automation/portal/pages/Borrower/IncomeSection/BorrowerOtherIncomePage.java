package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 08-05-2018.
 */
public class BorrowerOtherIncomePage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerOtherIncomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerOtherIncomePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			logger.info("=========== BorrowerOtherIncomePage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerOtherIncomePage could not be loaded within time");
		}
	}

	public void provideOtherIncomeDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.otherIncomePage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about your other income.")),
				"Page title does not contain please tell us about your other income.");
		enterText(driver, getLocator(uiObjParam.otherIncomePage_otherIncomeTextBox), portalParam.otherIncomePerMonth);
		selectValueFromDropdown(driver, getLocator(uiObjParam.otherIncomePage_sourceOfIncomeDropdown),
				portalParam.sourceOfIncome);
		if (portalParam.continuousIncome == 1) {
			clickButton(driver, getLocator(uiObjParam.otherIncomePage_otherIncomeForMoreThan2YearsButton),
					"Income for more than two years : Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.otherIncomePage_otherIncomeForLessThan2YearsButton),
					"Income for more than two years : No");
		}
		if (portalParam.SpouseAsCoBorrower == 1) {
			clickButton(driver, getLocator(uiObjParam.SpouseAddedotherIncomePage_nextButton), "Next");
		} else {
			clickButton(driver, getLocator(uiObjParam.otherIncomePage_nextButton), "Next");
		}
		Thread.sleep(6000);
	}
	
	public void provideOtherIncomeDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.otherIncomePage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about your spouse's other income.")),
				"Page title does not contain Please tell us about your spouse's other income.");
		enterText(driver, getLocator(uiObjParam.otherIncomePage_otherIncomeTextBox), portalParam.otherIncomePerMonth);
		selectValueFromDropdown(driver, getLocator(uiObjParam.otherIncomePage_sourceOfIncomeDropdown),
				portalParam.sourceOfIncome);
		if (portalParam.continuousIncome == 1) {
			clickButton(driver, getLocator(uiObjParam.otherIncomePage_otherIncomeForMoreThan2YearsButton),
					"Income for more than two years : Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.otherIncomePage_otherIncomeForLessThan2YearsButton),
					"Income for more than two years : No");
		}
		if (portalParam.SpouseAsCoBorrower == 1) {
			clickButton(driver, getLocator(uiObjParam.SpouseAddedotherIncomePage_nextButton), "Next");
		} else {
			clickButton(driver, getLocator(uiObjParam.otherIncomePage_nextButton), "Next");
		}
		Thread.sleep(6000);
	}

	public void provideOtherIncomeDetails_Spouse() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpouseotherIncomePage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about your spouse's other income.")),
				"Page title does not contain please tell us about your spouse's other income.");
		enterText(driver, getLocator(uiObjParam.SpouseotherIncomePage_otherIncomeTextBox), portalParam.otherIncomePerMonth);
		selectValueFromDropdown_Spouse(driver, getLocator(uiObjParam.SpouseotherIncomePage_sourceOfIncomeDropdown),
				portalParam.sourceOfIncome);
		if (portalParam.continuousIncome == 1) {
			clickButton(driver, getLocator(uiObjParam.SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton),
					"Income for more than two years : Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.SpouseotherIncomePage_otherIncomeForLessThan2YearsButton),
					"Income for more than two years : No");
		}
		clickButton(driver, getLocator(uiObjParam.SpouseotherIncomePage_nextButton), "Next");
		Thread.sleep(6000);
	}
	
	public void provideOtherIncomeDetails_SpouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpouseotherIncomePage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us about your other income.")),
				"Page title does not contain Please tell us about your other income.");
		enterText(driver, getLocator(uiObjParam.SpouseotherIncomePage_otherIncomeTextBox), portalParam.otherIncomePerMonth);
		selectValueFromDropdown_Spouse(driver, getLocator(uiObjParam.SpouseotherIncomePage_sourceOfIncomeDropdown),
				portalParam.sourceOfIncome);
		if (portalParam.continuousIncome == 1) {
			clickButton(driver, getLocator(uiObjParam.SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton),
					"Income for more than two years : Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.SpouseotherIncomePage_otherIncomeForLessThan2YearsButton),
					"Income for more than two years : No");
		}
		clickButton(driver, getLocator(uiObjParam.SpouseotherIncomePage_nextButton), "Next");
		Thread.sleep(6000);
	}

	private void selectValueFromDropdown(WebDriver driver, By locator, String value) throws Exception {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).click();
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void selectValueFromDropdown_Spouse(WebDriver driver, By locator, String value) throws Exception {
	
		String dyam = null;
		if(portalParam.ClientName.contains("NAF")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[20]/questioner-question-set[1]/div[2]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
		if(portalParam.ClientName.contains("OC")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[22]/questioner-question-set[1]/div[2]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(dyam))
					.click();

			Thread.sleep(5000);
		
	}
}
