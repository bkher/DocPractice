package net.sigmainfo.lf.automation.portal.pages.Borrower;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetsPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.*;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.NonSpouseInformationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractCollection;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 24-04-2018.
 */
public class Logout extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(Logout.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public Logout(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			logger.info("=========== LoginPage is loaded============");
		} catch (Exception e) {
			throw new Exception("LoginPage could not be loaded within time");
		}
	}

	public Logout() {
	}

	public void logout() throws Exception {

            clickButton(driver,getLocator(uiObjParam.Logout_username),"Clicked on Username");
            clickButton(driver,getLocator(uiObjParam.Logout_looutlink),"Clicked on logout link");
	}

}
