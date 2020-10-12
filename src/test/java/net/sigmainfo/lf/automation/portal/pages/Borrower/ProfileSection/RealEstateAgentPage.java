package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
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
public class RealEstateAgentPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(RealEstateAgentPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public RealEstateAgentPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			
			waitForPageToLoad(driver);
			  Thread.sleep(7000);
			logger.info("=========== RealEstateAgentPage is loaded============");
		} catch (Exception e) {
			throw new Exception("RealEstateAgentPage could not be loaded within time");
		}
	}

	public void enterRealEstateDetails() throws Exception {
		
		
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.realEstateAgentPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please tell us about your real estate agent.")),
				"Page title does not match");
		assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.realEstateAgentPage_workingWithAgentButton)),
				"Are you working with a real estate agent button clickable.");
		if (portalParam.realEstateAgent==1) {
			clickButton(driver, getLocator(uiObjParam.realEstateAgentPage_workingWithAgentButton),
					"working with a real estate agent - Yes");
			Thread.sleep(1000);
			insertText(driver, getLocator(uiObjParam.realEstateAgentPage_AgentFirstName), "RealEstate");
			insertText(driver, getLocator(uiObjParam.realEstateAgentPage_AgentLastName), "Agent");
		} else {
			clickButton(driver, getLocator(uiObjParam.realEstateAgentPage_notWorkingWithAgentButton),
					"working with a real estate agent - NO");
			if (portalParam.referAgent==1) {
				clickButton(driver, getLocator(uiObjParam.realEstateAgentPage_referAgentButton), "Refer agent - Yes");
			} else {
				clickButton(driver, getLocator(uiObjParam.realEstateAgentPage_notReferAgentButton), "Refer agent - No");
			}
		}
		clickButton(driver, getLocator(uiObjParam.realEstateAgentPage_nextButton), "Refer agent - No");
		
	}
	
public void enterRealEstateDetails_coborrower() throws Exception {
		
		
			assertTrue(
					removeSpecialChar(
							driver.findElement(getLocator(uiObjParam.realEstateAgentPage_pageLabel)).getText())
									.contains(removeSpecialChar("Real estate agent details")),
					"Page title does not match");
		
		clickButton(driver, getLocator(uiObjParam.realEstateAgentPage_nextButton), "Viewed Real EstateAgent Details - Next");
		
	}
}
