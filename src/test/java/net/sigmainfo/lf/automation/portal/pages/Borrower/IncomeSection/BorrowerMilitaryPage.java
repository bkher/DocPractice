package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 08-05-2018.
 */
public class BorrowerMilitaryPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerMilitaryPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerMilitaryPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			
			Thread.sleep(6000);
			logger.info("=========== BorrowerMilitaryPage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerMilitaryPage could not be loaded within time");
		}
	} 

	public void provideMilitaryIncomeDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.militaryPage_pageLabel)).getText())
						.contains(removeSpecialChar("Military pay")),
				"Page title does not contain military pay");
		enterText(driver, getLocator(uiObjParam.militaryPage_perMonthIncomeTextBox), portalParam.monthlyMilitoryPay);
		clickButton(driver, getLocator(uiObjParam.militaryPage_nextButton), "Next");
		Thread.sleep(6000);
	}
	
	public void provideMilitaryIncomeDetails_SpouseProvideHisSpouseDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.militaryPage_pageLabel)).getText())
						.contains(removeSpecialChar("Military pay")),
				"Page title does not contain military pay");
		enterText(driver, getLocator(uiObjParam.militaryPage_perMonthIncomeTextBox), portalParam.monthlyMilitoryPay);
		clickButton(driver, getLocator(uiObjParam.militaryPage_nextButton), "Next");
		Thread.sleep(6000);
	}
	
	public void provideMilitaryIncomeDetails_spouse() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpousemilitaryPage_pageLabel)).getText())
						.contains(removeSpecialChar("Military pay")),
				"Page title does not contain military pay");
		enterText(driver, getLocator(uiObjParam.SpousemilitaryPage_perMonthIncomeTextBox), portalParam.monthlyMilitoryPay);
		clickButton(driver, getLocator(uiObjParam.SpousemilitaryPage_nextButton), "Next");
		Thread.sleep(6000);
	}
	
	public void provideMilitaryIncomeDetails_spouseProvideHisDetails() throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.SpousemilitaryPage_pageLabel)).getText())
						.contains(removeSpecialChar("Military pay")),
				"Page title does not contain military pay");
		enterText(driver, getLocator(uiObjParam.SpousemilitaryPage_perMonthIncomeTextBox), portalParam.monthlyMilitoryPay);
		clickButton(driver, getLocator(uiObjParam.SpousemilitaryPage_nextButton), "Next");
		Thread.sleep(6000);
	}
}
