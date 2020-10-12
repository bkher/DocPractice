package net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.DocUpload;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.enterText;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration.DeclarationCompletePage;

public class CertificateOfReleasePage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(DeclarationCompletePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public CertificateOfReleasePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			logger.info("=========== CertificateOfReleasePage is loaded============");
			Thread.sleep(10000);
		} catch (Exception e) {
			throw new Exception("CertificateOfReleasePage could not be loaded within time");
		}
	}

	public void CompleteVerification() throws Exception {
		Thread.sleep(10000);
		clickButton(driver, getLocator(uiObjParam.CertificateOfReleasePage_UploadArea), "Upload Area");
		DocUpload(portalParam.Platform, portalParam.Pictures, portalParam.Open);
		clickButton(driver, getLocator(uiObjParam.CertificateOfReleasePage_WriteExplanation), "Upload Area");
		enterText(driver, getLocator(uiObjParam.CertificateOfReleasePage_Editor), "Self");
		clickButton(driver, getLocator(uiObjParam.CertificateOfReleasePage_Next), "Next");
		Thread.sleep(10000);

	}
	
	public void CompleteVerification_skip() throws Exception {
		Thread.sleep(10000);
		clickButton(driver, getLocator(uiObjParam.CertificateOfReleasePage_Next), "Next");
		Thread.sleep(10000);

	}

}
