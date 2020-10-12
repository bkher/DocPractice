package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 07-05-2018.
 */
public class BorrowerIncomeDetailsPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerIncomeDetailsPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerIncomeDetailsPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
				  assertTrue(
							removeSpecialChar(driver.findElement(getLocator(uiObjParam.incomeDetailsPage_pageLabel)).getText())
									.contains(removeSpecialChar("Next we’ll look at your income details.")),
							"Page title does not contain " + "next we’ll look at your income details.");
					
		
			  logger.info("=========== BorrowerIncomeDetailsPage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerIncomeDetailsPage could not be loaded within time");
		}
	}

	public void verifyIncomeDetails() throws Exception {
		assertTrue(driver.findElement(getLocator(uiObjParam.incomeDetailsPage_dateOfBirthTextBox)).getAttribute("value")
				.contains(portalParam.dateOfBirth));
		assertTrue(removeSpecialChar(
				driver.findElement(getLocator(uiObjParam.incomeDetailsPage_ssnTextBox)).getAttribute("value"))
						.contains(portalParam.ssnNumber));
		clickButton(driver, getLocator(uiObjParam.incomeDetailsPage_findMyIncomeButton), "Find My Income");

		Thread.sleep(6000);
	
	}
}
