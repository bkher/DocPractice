package net.sigmainfo.lf.automation.portal.pages.Borrower.Dashboard;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetCompletedPage;

public class WelcometoDashboardPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(AssetCompletedPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public WelcometoDashboardPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.WelcomeToDashboardPage_LetsJustGo)),
					"Lets Just Go button is not clickable.");
			logger.info("=========== WelcometoDashboardPage is loaded============");
		} catch (Exception e) {
			throw new Exception("WelcometoDashboardPage could not be loaded within time");
		}
	}

	public void navigateToDashboard() throws Exception {
		Thread.sleep(10000);
		clickButton(driver, getLocator(uiObjParam.WelcomeToDashboardPage_LetsJustGo), "Lets Just Go");
		Thread.sleep(20000);
	}
}