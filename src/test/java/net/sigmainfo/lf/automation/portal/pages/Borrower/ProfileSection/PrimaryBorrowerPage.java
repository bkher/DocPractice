package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.removeSpecialChar;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static org.testng.Assert.assertTrue;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sigmainfo.lf.automation.common.AbstractTests;

public class PrimaryBorrowerPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(AddCoApplicantsPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public PrimaryBorrowerPage(WebDriver driver) throws Exception {
		// try {
		this.driver = driver;
		waitForPageToLoad(driver);

		Thread.sleep(5000);		

		logger.info("=========== Select Primary Borrower Page is loaded============");
		
	}

	public void SelectPrimaryBorrower() throws Exception {
		clickButton(driver, getLocator(uiObjParam.primaryBorrower_Next), "Next");

	}
}
