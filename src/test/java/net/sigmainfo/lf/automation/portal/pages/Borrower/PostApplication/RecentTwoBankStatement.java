package net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.DocUpload;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;

import org.openqa.selenium.By;
import net.sigmainfo.lf.automation.common.AbstractTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration.DeclarationCompletePage;

public class RecentTwoBankStatement extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(DeclarationCompletePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public RecentTwoBankStatement(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			logger.info("=========== RecentTwoBankStatement is loaded============");
			Thread.sleep(10000);
		} catch (Exception e) {
			throw new Exception("RecentTwoBankStatement could not be loaded within time");
		}
	}

	public void CompleteVerification() throws Exception {
		Thread.sleep(10000);
		if (portalParam.ClientName.contains("NAF")) {
			clickButton(driver, getLocator(uiObjParam.RecentW2Page_UploadArea), "Recent W2 Upload Area");
			logger.info("Recent W2 Upload Area");
			DocUpload(portalParam.Platform, portalParam.Pictures, portalParam.Open);
			Thread.sleep(10000);
			// selectBoolean(getLocator(uiObjParam.RecentW2Page_Next), "Recent W2 Next
			// Button");
			clickButton(driver, getLocator(uiObjParam.RecentW2Page_Next), "Recent W2 Next Button");
			logger.info("Recent W2 Next Button");
			Thread.sleep(10000);
		}
		if (portalParam.ClientName.contains("OC")) {
			clickButton(driver, getLocator(uiObjParam.RecentW2Page_Next), "Recent W2 Next Button");
			logger.info("Recent W2 Next Button");
			Thread.sleep(10000);
		}
	}

	public void CompleteVerification_skip() throws Exception {
		Thread.sleep(10000);
		// selectBoolean(getLocator(uiObjParam.RecentW2Page_Next), "Recent W2 Next
		// Button");
		clickButton(driver, getLocator(uiObjParam.RecentW2Page_Next), "Recent W2 Next Button");
		logger.info("Recent W2 Next Button");
		Thread.sleep(10000);
	}

	public void selectBoolean(By locator, String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		logger.info("Clicked on :" + value);
	}
}
