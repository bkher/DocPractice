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

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class RealEstatePage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(RealEstatePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public RealEstatePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.realEstatePage_pageLabel)).getText())
							.contains(removeSpecialChar("Please tell us about all properties you currently own.")),
					"Page title does not match");
			// assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.realEstatePage_ownAdditionalPropertiesButton)),"own
			// any additional properties button is not clickable.");
			logger.info("=========== RealEstatePage is loaded============");
		} catch (Exception e) {
			throw new Exception("RealEstatePage could not be loaded within time");
		}
	}

	public RealEstatePage() {
	}

	public void provideRealEstateDetails() throws Exception {
		int netRentalIncome = (Integer.parseInt(portalParam.rentalIncome) - Integer.parseInt(portalParam.expenses));
		if (portalParam.additionalProperty==1) {
			clickButton(driver, getLocator(uiObjParam.realEstatePage_ownAdditionalPropertiesButton),
					"Own Additioanl Property : Yes");

			selectFromPropertyDropdown(getLocator(uiObjParam.realEstatePage_propertyTypeDropdown),
					portalParam.realEstatepropertyType);
			Thread.sleep(2000);
			selectNumberOfUnits(getLocator(uiObjParam.realEstatePage_numberOfUnitsDropdown),
					portalParam.propertyTypeUnits);
			selectFromPropertyDropdown(getLocator(uiObjParam.realEstatePage_propertyStatusDropdown),
					portalParam.propertyStatus);
			scrollToBottomOfThePage(driver);
			selectFromPropertyDropdown(getLocator(uiObjParam.realEstatePage_propertyUseDropdown),
					portalParam.propertyUse);
			enterText(driver, getLocator(uiObjParam.realEstatePage_propertyValueTextbox), portalParam.propertyValue);
			enterText(driver, getLocator(uiObjParam.realEstatePage_rentalIncomeTextbox), portalParam.rentalIncome);
			enterText(driver, getLocator(uiObjParam.realEstatePage_additioanlIncomeTextbox), portalParam.expenses);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(getLocator(uiObjParam.realEstatePage_netRentalIncomeLabel))).getText()
					.contains("$" + String.valueOf(netRentalIncome));
			Thread.sleep(2000);
			selectAddress(getLocator(uiObjParam.realEstatePage_propertyAddressTextbox), portalParam.propertyAddress);
			Thread.sleep(2000);

		} else {
			clickButton(driver, getLocator(uiObjParam.realEstatePage_dontOwnAdditionalPropertiesButton),
					"Own Additioanl Property : No");
		}
		clickButton(driver, getLocator(uiObjParam.realEstatePage_submitButton), "Submit");
	}
	
	public void provideRealEstateDetails_coborrower() throws Exception {
		int netRentalIncome = (Integer.parseInt(portalParam.rentalIncome) - Integer.parseInt(portalParam.expenses));
		if (portalParam.additionalProperty==1) {
			clickButton(driver, getLocator(uiObjParam.CoborrwerrealEstatePage_ownAdditionalPropertiesButton),
					"Own Additioanl Property : Yes");

			selectFromPropertyDropdown(getLocator(uiObjParam.CoborrwerrealEstatePage_propertyTypeDropdown),
					portalParam.realEstatepropertyType);
			Thread.sleep(2000);
			selectNumberOfUnits(getLocator(uiObjParam.CoborrwerrealEstatePage_numberOfUnitsDropdown),
					portalParam.propertyTypeUnits);
			selectFromPropertyDropdown(getLocator(uiObjParam.CoborrwerrealEstatePage_propertyStatusDropdown),
					portalParam.propertyStatus);
			scrollToBottomOfThePage(driver);
			selectFromPropertyDropdown(getLocator(uiObjParam.CoborrwerrealEstatePage_propertyUseDropdown),
					portalParam.propertyUse);
			enterText(driver, getLocator(uiObjParam.CoborrwerrealEstatePage_propertyValueTextbox), portalParam.propertyValue);
			enterText(driver, getLocator(uiObjParam.CoborrwerrealEstatePage_rentalIncomeTextbox), portalParam.rentalIncome);
			enterText(driver, getLocator(uiObjParam.CoborrwerrealEstatePage_additioanlIncomeTextbox), portalParam.expenses);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(getLocator(uiObjParam.CoborrwerrealEstatePage_netRentalIncomeLabel))).getText()
					.contains("$" + String.valueOf(netRentalIncome));
			Thread.sleep(2000);
			selectAddress(getLocator(uiObjParam.CoborrwerrealEstatePage_propertyAddressTextbox), portalParam.propertyAddress);
			Thread.sleep(2000);

		} else {
			clickButton(driver, getLocator(uiObjParam.CoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton),
					"Own Additioanl Property : No");
		}
		clickButton(driver, getLocator(uiObjParam.CoborrwerrealEstatePage_submitButton), "Submit");
	}



	private void selectFromPropertyDropdown(By locator, String propertyType) throws InterruptedException {
		driver.findElement(locator).click();
		Thread.sleep(2000);
		List<WebElement> propertyTypeList = driver
				.findElements(By.cssSelector("ui-options[name='dobMonth'] div[class*='select-wrapper'] li"));

		for (WebElement s : propertyTypeList) {
			String s2 = s.getText();
			if (s2.equals(propertyType)) {
				s.click();
				break;
			}
		}
		logger.info("Selected :" + propertyType);
		Thread.sleep(1500);
	}

	private void selectValueFromDropdown(By locator, String value) throws Exception {
		try {
			new WebDriverWait(driver, 240).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void selectNumberOfUnits(By locator, String value) throws InterruptedException {
		new WebDriverWait(driver, 240).until(ExpectedConditions.elementToBeClickable(locator));
		String ID = driver.findElement(locator).getAttribute("data-activates");
		driver.findElement(locator).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath("//ul[@id='" + ID + "']//span[contains(text(),'" + value + "')]"))
				.isDisplayed(), value + " is not displayed.");
		if (driver.findElement(By.xpath("//ul[@id='" + ID + "']//span[contains(text(),'" + value + "')]")).isDisplayed()) {
			driver.findElement(By.xpath("//ul[@id='" + ID + "']//span[contains(text(),'" + value + "')]")).click();
		}
		Thread.sleep(1000);

	}
}

