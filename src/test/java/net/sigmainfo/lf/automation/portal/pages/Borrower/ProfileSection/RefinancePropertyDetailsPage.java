package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.constant.PortalParam.isContract;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RefinancePropertyDetailsPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(RefinancePropertyDetailsPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public RefinancePropertyDetailsPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			assertTrue(
					removeSpecialChar(
							driver.findElement(getLocator(uiObjParam.Refinance_pageLabel)).getText())
									.contains(removeSpecialChar("Tell us about the property you�re looking to refinance..")),
					"Page title does not contain " + "Tell us about the property you�re looking to refinance.");

			logger.info("=========== RefinancePropertyDetailsPage is loaded============");
		} catch (Exception e) {
			throw new Exception("RefinancePropertyDetailsPage could not be loaded within time");
		}
	}

	public RefinancePropertyDetailsPage() {
	}

	public void providePropertyDetails(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		selectFromDropdown(getLocator(uiObjParam.Refinance_propertyTypeDropdown),
				portalParam.propertyType);
		if (portalParam.propertyType.equalsIgnoreCase("Multi-Family")) {
			selectFromDropdown(getLocator(uiObjParam.Refinance_numberOfUnitsDropdown),
					portalParam.numberOfUnits);
		}
		selectFromDropdown(getLocator(uiObjParam.purchasePropertyDetailsPage_propertyUseDropdown),
				portalParam.propertyUse);
		selectAddress(getLocator(uiObjParam.purchasePropertyDetailsPage_addressTextBox), portalParam.firstAddress);
		clickButton(driver, getLocator(uiObjParam.purchasePropertyDetailsPage_nextButton), "Next");
	}

	public void providePropertyDetails_SpouseVerifyHisSpouseDetails(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.purchasePropertyDetailsPage_nextButton), "Next");
	}

	public void selectFromDropdown(By locator, String value) {
		WebElement PropertyTypeListItem = null;
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		if (value.equalsIgnoreCase("Single Family")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Single Family')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Single Family')]"));
		} else if (value.equalsIgnoreCase("Condo")) {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Condo')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Condo')]"));
		} else if (value.equalsIgnoreCase("2-4 Units")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'2-4 Units')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'2-4 Units')]"));
		} else if (value.equalsIgnoreCase("Mixed Use")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Mixed Use')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Mixed Use')]"));
		} else if (value.equalsIgnoreCase("Other")) {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Other')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Other')]"));
		} else if (value.equalsIgnoreCase("Primary")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Primary')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Primary')]"));
		} else if (value.equalsIgnoreCase("Second Home")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Second Home')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Second Home')]"));
		} else if (value.equalsIgnoreCase("Investment Property")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Investment Property')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Investment Property')]"));
		} else if (value.equalsIgnoreCase("Alaska")) {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Alaska')]"))));
			PropertyTypeListItem = driver.findElement(By.xpath("//span[contains(text(),'Alaska')]"));
		}
		actions.moveToElement(PropertyTypeListItem);
		actions.click();
		actions.build().perform();
		logger.info("Selected from dropdown :" + value);
	}
}
