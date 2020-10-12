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
public class BorrowerEmployerAddressPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(BorrowerEmploymentPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerEmployerAddressPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			assertTrue(
					removeSpecialChar(
							driver.findElement(getLocator(uiObjParam.employmentAddressPage_pageLabel)).getText())
									.contains(removeSpecialChar(portalParam.borrowerFirstname
											+ ", employer location and contact information.")),
					"Page title does not contain " + portalParam.borrowerFirstname
							+ ", employer location and contact information.");

			logger.info("=========== BorrowerEmployerAddressPage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerEmployerAddressPage could not be loaded within time");
		}
	}

	public BorrowerEmployerAddressPage() {
	}

	public void provideEmploymentAddressDetails() throws Exception {
	
			selectAddress(getLocator(uiObjParam.employmentAddressPage_businessAddressTextBox),
					portalParam.borrowerBusinessAddress);
			enterText(driver, getLocator(uiObjParam.employmentAddressPage_phoneNumberTextBox),
					portalParam.borrowerBusinessPhone);
			clickButton(driver, getLocator(uiObjParam.employmentAddressPage_iAmDoneButton), "NO, I'M DONE");
			Thread.sleep(6000);
		
	}
}
