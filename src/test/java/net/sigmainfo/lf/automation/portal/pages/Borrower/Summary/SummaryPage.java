package net.sigmainfo.lf.automation.portal.pages.Borrower.Summary;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration.DeclarationCompletePage;

public class SummaryPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(DeclarationCompletePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public SummaryPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(10000);
			logger.info("=========== SummaryPage is loaded============");
		} catch (Exception e) {
			throw new Exception("SummaryPage could not be loaded within time");
		}
	}

	public void VerifySummary() throws Exception {
		 waitForElementToBeClickable(getLocator(uiObjParam.Summary_PageLabel));
		takeScreenShot(driver, "Summary Screenshot" + portalParam.borrowerUsername);
		CheckResults(uiObjParam.Summary_PageLabel, "Personal info review");
		CheckResults(uiObjParam.Summary_FullName, portalParam.borrowerFirstname + " " + portalParam.borrowerlastname);
		
		
		scrollToBottomOfThePage(driver);
		clickCheckBox(driver, getLocator(uiObjParam.Summary_AgreementCheckBox), "Accepted Agreement");
		clickButton(driver, getLocator(uiObjParam.Summary_Submit), "APPLY NOW");
		Thread.sleep(12000);
	}
	
	public void VerifySummary_coborrower() throws Exception {
		 waitForElementToBeClickable(getLocator(uiObjParam.CoborrowerSummary_PageLabel));
		takeScreenShot(driver, "Summary Screenshot" + portalParam.borrowerUsername);
		CheckResults(uiObjParam.CoborrowerSummary_PageLabel, "Personal info review");
		CheckResults(uiObjParam.Summary_FullName, portalParam.borrowerFirstname + " " + portalParam.borrowerlastname);
		
		
		scrollToBottomOfThePage(driver);
		clickCheckBox(driver, getLocator(uiObjParam.Summary_AgreementCheckBox), "Accepted Agreement");
		clickButton(driver, getLocator(uiObjParam.Summary_Submit), "APPLY NOW");
		Thread.sleep(12000);
	}
	
	public void VerifySummary_SpouseCoborrower() throws Exception {
		waitForElementToBeClickable(getLocator(uiObjParam.CoborrowerSummary_PageLabel));
		takeScreenShot(driver, "Summary Screenshot" + portalParam.borrowerUsername);
		Thread.sleep(5000);
		CheckResults(uiObjParam.CoborrowerSummary_PageLabel, "Personal info review");
		scrollToBottomOfThePage(driver);
		clickCheckBox(driver, getLocator(uiObjParam.Summary_AgreementCheckBox), "Accepted Agreement");
		Thread.sleep(7000);
		clickButton(driver, getLocator(uiObjParam.Summary_Submit), "APPLY NOW");
		Thread.sleep(12000);
	}

	public void CheckResults(String Locator, String Expected) throws Exception {
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(Locator)).getText())
						.contains(removeSpecialChar(Expected)),
				driver.findElement(getLocator(Locator)).getText() + " Does Not Contain the Expected Result(" + Expected
						+ ")");
		logger.info(driver.findElement(getLocator(Locator)).getText() + " -- has been asserted");
	}

	public String YesorNo(boolean Value) {
		String res = "No";
		if (Value) {
			res = "Yes";
		}
		return res;
	}
	public static void clickCheckBox(WebDriver driver, By locator, String value) throws Exception {
		if (driver.findElement(locator).isEnabled()) {
			driver.findElement(locator).click();
			Thread.sleep(1500);
		} else {
			assertFalse(driver.findElement(locator).isEnabled(), "Button could not be clicked");
		}

	}
}
