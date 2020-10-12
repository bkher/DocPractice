package net.sigmainfo.lf.automation.portal.pages.Borrower;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 24-04-2018.
 */
public class WelcomeVideoPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(WelcomeVideoPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public WelcomeVideoPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			
		//	assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.borrowerWelcomeVideoPage_welcomeMessage)),
		//			"Welcome message not visible");
			assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.borrowerWelcomeVideoPage_getStartedButton)),
					"get started button is not clickable");
			logger.info("=========== WelcomeVideoPage is loaded============");
		} catch (Exception e) {
			throw new Exception("WelcomeVideoPage could not be loaded within time");
		}
	}

	public void navigateSignUpPage(WebDriver driver) throws Exception {
		assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.borrowerWelcomeVideoPage_lenderImage)),
				"Loan office image is not visible.");
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.borrowerWelcomeVideoPage_getStartedButton), "Get Started");
	}

	public void navigateSignUpPage_Coborrower(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.borrowerWelcomeVideoPage_getStartedButton), "Get Started");
	}
	
	public void navigateSignUpPage_affinitypartner(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.borrowerWelcomeVideoPage_getStartedButton), "Get Started");
	}

	
}
