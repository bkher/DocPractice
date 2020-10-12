package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by shaishav.s on 08-05-2018.
 */
public class BorrowerRentalIncomePage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerRentalIncomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerRentalIncomePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(7000);
			logger.info("=========== BorrowerRentalIncomePage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerRentalIncomePage could not be loaded within time");
		}
	}

	public void provideRentalIncomeDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.rentalPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us more about your rental income.")),
				"Page title does not contain please tell us more about your rental income.");

		if (portalParam.additionalProperty != 1) {
			selectValue(getLocator(uiObjParam.rentalPage_propertyTypeDropdown), portalParam.rentalPropertyType);
			Thread.sleep(2000);

			selectNumberOfUnits(getLocator(uiObjParam.rentalPage_numberOfUnitsDropdown), portalParam.propertyTypeUnits);
			selectValue(getLocator(uiObjParam.rentalPage_propertyStatusDropdown), portalParam.rentalPropertyStatus);
			selectValue(getLocator(uiObjParam.rentalPage_propertyUseDropdown), portalParam.rentalPropertyUse);
			enterText(driver, getLocator(uiObjParam.rentalPage_propertyValueTextBox), portalParam.rentalPropertyValue);
			enterText(driver, getLocator(uiObjParam.rentalPage_monthlyRentalIncomeTextBox),
					portalParam.rentalPropertyMonthlyRentalIncome);
			enterText(driver, getLocator(uiObjParam.rentalPage_additionalExpenseTextBox),
					portalParam.monthlyRentalAdditionalExpense);
			Thread.sleep(2000);
			selectAddress(getLocator(uiObjParam.rentalPage_propertyAddressTextBox), portalParam.rentalPropertyAddress);
			// assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.rentalPage_netMonthlyRentalIncomeLabel)).getText()).contains(removeSpecialChar((Integer.parseInt(portalParam.rentalPropertyMonthlyRentalIncome)-(Integer.parseInt(portalParam.monthlyRentalAdditionalExpense))))));
			clickButton(driver, getLocator(uiObjParam.rentalPage_iAmDoneButton), "I am done");
		} else {
			clickButton(driver, getLocator(uiObjParam.rentalPage_iAmDoneButton), "I am done");
		}
		Thread.sleep(7000);
	}
	
	public void provideRentalIncomeDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.rentalPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us more about your spouse's rental income.")),
				"Page title does not contain Please tell us more about your spouse's rental income.");

	
			selectValue(getLocator(uiObjParam.rentalPage_propertyTypeDropdown), portalParam.rentalPropertyType);
			Thread.sleep(2000);

			selectNumberOfUnits(getLocator(uiObjParam.rentalPage_numberOfUnitsDropdown), portalParam.propertyTypeUnits);
			selectValue(getLocator(uiObjParam.rentalPage_propertyStatusDropdown), portalParam.rentalPropertyStatus);
			selectValue(getLocator(uiObjParam.rentalPage_propertyUseDropdown), portalParam.rentalPropertyUse);
			enterText(driver, getLocator(uiObjParam.rentalPage_propertyValueTextBox), portalParam.rentalPropertyValue);
			enterText(driver, getLocator(uiObjParam.rentalPage_monthlyRentalIncomeTextBox),
					portalParam.rentalPropertyMonthlyRentalIncome);
			enterText(driver, getLocator(uiObjParam.rentalPage_additionalExpenseTextBox),
					portalParam.monthlyRentalAdditionalExpense);
			Thread.sleep(2000);
			selectAddress(getLocator(uiObjParam.rentalPage_propertyAddressTextBox), portalParam.rentalPropertyAddress);
			// assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.rentalPage_netMonthlyRentalIncomeLabel)).getText()).contains(removeSpecialChar((Integer.parseInt(portalParam.rentalPropertyMonthlyRentalIncome)-(Integer.parseInt(portalParam.monthlyRentalAdditionalExpense))))));
			clickButton(driver, getLocator(uiObjParam.rentalPage_iAmDoneButton), "I am done");
			Thread.sleep(7000);
	}

	public void provideRentalIncomeDetails_Spouse() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpouserentalPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us more about your spouse's rental income.")),
				"Page title does not contain Please tell us more about your spouse's rental income.");

		selectProperty_Spouse(getLocator(uiObjParam.SpouserentalPage_propertyTypeDropdown),
				portalParam.rentalPropertyType);
		Thread.sleep(2000);

		selectNumberOfUnits_Spouse(getLocator(uiObjParam.SpouserentalPage_numberOfUnitsDropdown),
				portalParam.propertyTypeUnits);
		selectPropertyStatus_Spouse(getLocator(uiObjParam.SpouserentalPage_propertyStatusDropdown),
		   portalParam.rentalPropertyStatus);
		selectPropertyUse_Spouse(getLocator(uiObjParam.SpouserentalPage_propertyUseDropdown),
		    portalParam.rentalPropertyUse);
		enterText(driver, getLocator(uiObjParam.SpouserentalPage_propertyValueTextBox),
				portalParam.rentalPropertyValue);
		enterText(driver, getLocator(uiObjParam.SpouserentalPage_monthlyRentalIncomeTextBox),
				portalParam.rentalPropertyMonthlyRentalIncome);
		enterText(driver, getLocator(uiObjParam.SpouserentalPage_additionalExpenseTextBox),
				portalParam.monthlyRentalAdditionalExpense);
		Thread.sleep(2000);
		selectAddress(getLocator(uiObjParam.SpouserentalPage_propertyAddressTextBox),
				portalParam.rentalPropertyAddress);
		// assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.rentalPage_netMonthlyRentalIncomeLabel)).getText()).contains(removeSpecialChar((Integer.parseInt(portalParam.rentalPropertyMonthlyRentalIncome)-(Integer.parseInt(portalParam.monthlyRentalAdditionalExpense))))));
		clickButton(driver, getLocator(uiObjParam.SpouserentalPage_iAmDoneButton), "I am done");
		Thread.sleep(7000);
	}
	
	public void provideRentalIncomeDetails_SpouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.borrowerSpouserentalPage_pageLabel)).getText())
						.contains(removeSpecialChar("Please tell us more about your rental income.")),
				"Page title does not contain Please tell us more about your rental income.");

		selectProperty_Spouse(getLocator(uiObjParam.SpouserentalPage_propertyTypeDropdown),
				portalParam.rentalPropertyType);
		Thread.sleep(2000);

		selectNumberOfUnits_Spouse(getLocator(uiObjParam.SpouserentalPage_numberOfUnitsDropdown),
				portalParam.propertyTypeUnits);
		selectPropertyStatus_Spouse(getLocator(uiObjParam.SpouserentalPage_propertyStatusDropdown),
		   portalParam.rentalPropertyStatus);
		selectPropertyUse_Spouse(getLocator(uiObjParam.SpouserentalPage_propertyUseDropdown),
		    portalParam.rentalPropertyUse);
		enterText(driver, getLocator(uiObjParam.SpouserentalPage_propertyValueTextBox),
				portalParam.rentalPropertyValue);
		enterText(driver, getLocator(uiObjParam.SpouserentalPage_monthlyRentalIncomeTextBox),
				portalParam.rentalPropertyMonthlyRentalIncome);
		enterText(driver, getLocator(uiObjParam.SpouserentalPage_additionalExpenseTextBox),
				portalParam.monthlyRentalAdditionalExpense);
		Thread.sleep(2000);
		selectAddress(getLocator(uiObjParam.SpouserentalPage_propertyAddressTextBox),
				portalParam.rentalPropertyAddress);
		// assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.rentalPage_netMonthlyRentalIncomeLabel)).getText()).contains(removeSpecialChar((Integer.parseInt(portalParam.rentalPropertyMonthlyRentalIncome)-(Integer.parseInt(portalParam.monthlyRentalAdditionalExpense))))));
		clickButton(driver, getLocator(uiObjParam.SpouserentalPage_iAmDoneButton), "I am done");
		Thread.sleep(7000);
	}

	private void selectValue(By locator, String value) throws Exception {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void selectNumberOfUnits_Spouse(By locator, String value) throws InterruptedException {
		
		String dyam = null;
		if(portalParam.ClientName.contains("NAF")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[17]/questioner-question-set[1]/div[2]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
		if(portalParam.ClientName.contains("OC")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[19]/questioner-question-set[1]/div[2]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		String ID = driver.findElement(locator).getAttribute("data-activates");
		driver.findElement(locator).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(dyam))
				.click();
		Thread.sleep(3000);

	}
	
	public void selectPropertyUse_Spouse(By locator, String value) throws InterruptedException {
		String dyam = null;
		if(portalParam.ClientName.contains("NAF")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[17]/questioner-question-set[1]/div[4]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
		if(portalParam.ClientName.contains("OC")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[19]/questioner-question-set[1]/div[4]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]";
		}
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		String ID = driver.findElement(locator).getAttribute("data-activates");
		driver.findElement(locator).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(dyam))
				.click();
		Thread.sleep(3000);

	}
	
	public void selectPropertyStatus_Spouse(By locator, String value) throws InterruptedException {
		
		String dyam = null;
		if(portalParam.ClientName.contains("NAF")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[17]/questioner-question-set[1]/div[3]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[3]/span[1]";
		}
		if(portalParam.ClientName.contains("OC")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[19]/questioner-question-set[1]/div[3]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[3]/span[1]";
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		String ID = driver.findElement(locator).getAttribute("data-activates");
		driver.findElement(locator).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(dyam))
				.click();
		Thread.sleep(1000);

	}

	public void selectProperty_Spouse(By locator, String value) throws InterruptedException {
		
		String dyam = null;
		if(portalParam.ClientName.contains("NAF")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[17]/questioner-question-set[1]/div[2]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[3]/span[1]";
		}
		if(portalParam.ClientName.contains("OC")) {
			 dyam = "/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[19]/questioner-question-set[1]/div[2]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[3]/span[1]";
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		String ID = driver.findElement(locator).getAttribute("data-activates");
		driver.findElement(locator).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(dyam))
				.click();
		Thread.sleep(1000);

	}

	public void selectNumberOfUnits(By locator, String value) throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		String ID = driver.findElement(locator).getAttribute("data-activates");
		logger.debug("ID.... " + ID);
		driver.findElement(locator).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath("//ul[@id='" + ID + "']//span[contains(text(),'" + value + "')]"))
				.isDisplayed(), value + " is not displayed.");
		if (driver.findElement(By.xpath("//ul[@id='" + ID + "']//span[contains(text(),'" + value + "')]"))
				.isDisplayed()) {
			driver.findElement(By.xpath("//ul[@id='" + ID + "']//span[contains(text(),'" + value + "')]")).click();
		}
		Thread.sleep(1000);

	}
}
