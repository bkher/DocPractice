package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetCompletedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 25-04-2018.
 */
public class IncomeCompletedPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(IncomeSearchPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public IncomeCompletedPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(7000);
			logger.info("=========== Begin Section Page is loaded============");
		} catch (Exception e) {
			throw new Exception("Begin Section could not be loaded within time");
		}
	}

	public void BeginDecalration() throws Exception {
	
			clickButton(driver, getLocator(uiObjParam.incomeCompletePage_beginSection), "BEGIN SECTION");
			Thread.sleep(8000);
		

	}
}
