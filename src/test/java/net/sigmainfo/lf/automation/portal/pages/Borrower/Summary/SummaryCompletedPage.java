package net.sigmainfo.lf.automation.portal.pages.Borrower.Summary;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration.DeclarationCompletePage;

public class SummaryCompletedPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(DeclarationCompletePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public SummaryCompletedPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			  Thread.sleep(10000);
			    waitForElementToBeClickable(getLocator(uiObjParam.SummaryCompletedPage_ViewMyDashboard));
			logger.info("=========== DeclarationCompletePage is loaded============");
		} catch (Exception e) {
			throw new Exception("DeclarationCompletePage could not be loaded within time");
		}
	}

	public void CompleteSummary() throws Exception {
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.SummaryCompletedPage_ViewMyDashboard), "VIEW MY DASHBOARD");
		Thread.sleep(10000);
	}

}
