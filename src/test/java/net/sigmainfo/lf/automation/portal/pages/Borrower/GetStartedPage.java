package net.sigmainfo.lf.automation.portal.pages.Borrower;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;

public class GetStartedPage extends AbstractTests{
	private Logger logger = LoggerFactory.getLogger(WelcomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public GetStartedPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			waitForElementToBeClickable(getLocator(uiObjParam.GetStartedPage_Signup));
			logger.info("=========== GetStarted page is loaded============");
		} catch (Exception e) {
			throw new Exception("GetStarted page could not be loaded within time");
		}
	}

	public void signUp() throws Exception {
		clickButton(driver, getLocator(uiObjParam.GetStartedPage_Signup), "SignUp");
	}
 
	public void login() throws Exception
	{
		clickButton(driver, getLocator(uiObjParam.GetStartedPage_Login), "Login");
	}
}
