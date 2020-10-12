package net.sigmainfo.lf.automation.portal.pages.Borrower;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;

public class WelcomeSignupPage extends AbstractTests{
	private Logger logger = LoggerFactory.getLogger(WelcomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public WelcomeSignupPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			waitForElementToBeClickable(getLocator(uiObjParam.WelcomeSignupPage_GetStarted));
			logger.info("=========== WelcomeSignup page is loaded============");
		} catch (Exception e) {
			throw new Exception("WelcomeSignup page could not be loaded within time");
		}
	}

	public void getStarted() throws Exception {
		clickButton(driver, getLocator(uiObjParam.WelcomeSignupPage_GetStarted), "GetStarted");
	}
}
