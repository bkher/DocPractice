package net.sigmainfo.lf.automation.portal.pages.Borrower.Dashboard;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetCompletedPage;

public class Dashboard extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(Dashboard.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public Dashboard(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(12000);
			logger.info("=========== Dashboard is loaded============");
		} catch (Exception e) {
			throw new Exception("Dashboard could not be loaded within time");
		}
	}

}
