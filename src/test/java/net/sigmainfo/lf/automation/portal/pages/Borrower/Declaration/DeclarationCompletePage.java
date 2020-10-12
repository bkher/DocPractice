package net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.removeSpecialChar;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerAlimondyChildSupportPage;

public class DeclarationCompletePage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(DeclarationCompletePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public DeclarationCompletePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(10000);
			logger.info("=========== DeclarationCompletePage is loaded============");
		} catch (Exception e) {
			throw new Exception("DeclarationCompletePage could not be loaded within time");
		}
	}

	public void CompleteDeclaration() throws Exception {
		
		clickButton(driver, getLocator(uiObjParam.declarationCompletePage_beginSection), "BEGIN SECTION");
		Thread.sleep(12000);
	}

}
