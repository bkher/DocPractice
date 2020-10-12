package net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.IncomeSearchPage;
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
public class AssetCompletedPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(AssetCompletedPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public AssetCompletedPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
/*			assertTrue(
					driver.findElement(By.xpath("//h1[contains(text(),'completed the assets section.')]")).getText()
							.contains("Great Work! You’ve completed the assets section."),
					"Page does not contain expected text");*/
			assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.assetCompletePage_beginSectionButton)),
					"Begin Section button is not clickable.");
			logger.info("=========== AssetCompletedPage is loaded============");
		} catch (Exception e) {
			throw new Exception("AssetCompletedPage could not be loaded within time");
		}
	}

	public void navigateToIncome() throws Exception {
		clickButton(driver, getLocator(uiObjParam.assetCompletePage_beginSectionButton), "Begin Section");
	    Thread.sleep(6000);
	}
}
