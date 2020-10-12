package net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration.DeclarationCompletePage;

public class PersonalTaxReturnsPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(DeclarationCompletePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public PersonalTaxReturnsPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			logger.info("=========== PersonalTaxReturnsPage is loaded============");
			Thread.sleep(10000);
		} catch (Exception e) {
			throw new Exception("PersonalTaxReturnsPage could not be loaded within time");
		}
	}

	public void CompleteVerification() throws Exception {
		Thread.sleep(10000);
		if (portalParam.ClientName.contains("NAF")) {
			if (portalParam.Platform.equals("windows")) {
				clickButton(driver, getLocator(uiObjParam.PersonalTaxReturnsPage_DocUploadArea), "Upload Area");
				DocUploadHTML();
				String Text = driver.findElement(By.xpath("//li[@class='style-scope ui-error-summary']")).getText();
				assertTrue(Text.contains("Allowed files type are .pdf, .jpg, .png, .gif, .doc, .docx, .xls, .xlsx"),
						"Error Message not Displayed");
			}
			clickButton(driver, getLocator(uiObjParam.PersonalTaxReturnsPage_DocUploadArea), "Upload Area");
			DocUpload(portalParam.Platform, portalParam.Pictures, portalParam.Open);
			clickButton(driver, getLocator(uiObjParam.PersonalTaxReturnsPage_Next), "Upload Area");
		}
		if (portalParam.ClientName.contains("OC")) {
			clickButton(driver, getLocator(uiObjParam.PersonalTaxReturnsPage_Next), "Upload Area");
		}
		Thread.sleep(10000);
	}

	public void CompleteVerification_skip() throws Exception {
		Thread.sleep(10000);
		clickButton(driver, getLocator(uiObjParam.PersonalTaxReturnsPage_Next), "Upload Area");
		Thread.sleep(10000);
	}

}
