package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class ProfileCompletedPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(ProfileCompletedPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public ProfileCompletedPage(WebDriver driver) throws Exception {
	
			this.driver = driver;
			waitForPageToLoad(driver);
			if (portalParam.ClientName.contains("NAF")) {
				assertTrue(
						removeSpecialChar(
								driver.findElement(getLocator(uiObjParam.profileCompletedPage_profileCompletionMessage))
										.getText()).contains("GreatYouvecompletedyourNewAmericanFundingprofile"),
						"Page label does not contain expected message.");

			}
			if (portalParam.ClientName.contains("OC")) {
				assertTrue(
						removeSpecialChar(
								driver.findElement(getLocator(uiObjParam.profileCompletedPage_profileCompletionMessage))
										.getText()).contains("GreatYouvecompletedyourOpenCloseprofile"),
						"Page label does not contain expected message.");

			}
			assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.profileCompletedPage_beginSectionButton)),
					"Begin Section button is not clickable.");
			logger.info("=========== ProfileCompletedPage is loaded============");
	
	}

	public void clickBeginSectionBtn() throws Exception {
		clickButton(driver, getLocator(uiObjParam.profileCompletedPage_beginSectionButton), "Begin Section");
		logger.info("Clicking on BEGIN SECTION button");
		Thread.sleep(6000);
	}
}
