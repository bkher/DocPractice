package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.BeginSectionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class TellAboutYourselfPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(TellAboutYourselfPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public TellAboutYourselfPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(2000);
			logger.info("=========== TellAboutYourselfPage is loaded============");
		} catch (Exception e) {
			throw new Exception("TellAboutYourselfPage could not be loaded within time");
		}
	}

	public void providePersonalDetails(WebDriver driver) throws Exception {

		assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.TellAboutYouPage_tellAboutYourselfLabel)),
				"Tell us about yourself label not seen");
		// enterText(driver,getLocator(uiObjParam.TellAboutYouPage_firstNameTextbox),portalParam.borrowerFirstname);
		// enterText(driver,getLocator(uiObjParam.TellAboutYouPage_lastNameTextbox),portalParam.borrowerlastname);
		enterText(driver, getLocator(uiObjParam.TellAboutYouPage_DoBTextBox), "11112000");
		enterText(driver, getLocator(uiObjParam.TellAboutYouPage_ssnTextBox), portalParam.ssnNumber);
		clickButton(driver, getLocator(uiObjParam.TellAboutYouPage_nextButton), "Next");
	}

	public void directSignupPersonalDetails(WebDriver driver) throws Exception {

		assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.TellAboutYouPage_tellAboutYourselfLabel)),
				"Tell us about yourself label not seen");

		enterText(driver, getLocator(uiObjParam.TellAboutYouPage_firstNameTextbox), portalParam.borrowerFirstname);
		enterText(driver, getLocator(uiObjParam.TellAboutYouPage_lastNameTextbox), portalParam.borrowerlastname);
		enterText(driver, getLocator(uiObjParam.TellAboutYouPage_DoBTextBox), "11112000");
		enterText(driver, getLocator(uiObjParam.TellAboutYouPage_ssnTextBox), portalParam.ssnNumber);
		/**/
		clickButton(driver, getLocator(uiObjParam.TellAboutYouPage_nextButton), "Next");
	}

	public void providePersonalDetails_SpouseVerifyHisSpouseDetails(WebDriver driver) throws Exception {

		assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.SpouseLoginTellAboutYouPage_tellAboutYourselfLabel)),
				"Tell us about your spouse.");

		clickButton(driver, getLocator(uiObjParam.TellAboutYouPage_nextButton), "Next");
	}
	
	public void providePersonalDetails_SpouseVerfyHisDetails(WebDriver driver) throws Exception {

		assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.TellAboutYouPage_tellAboutYourselfLabel)),
				"Tell us about yourself label not seen");
		clickButton(driver, getLocator(uiObjParam.TellAboutYouPage_nextButton), "Next");
	}
	
	public void providePersonalDetails_CobSpouseVerfyHisDetails(WebDriver driver) throws Exception {

		assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.CobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel)),
				"Tell us about yourself label not seen");
		clickButton(driver, getLocator(uiObjParam.TellAboutYouPage_nextButton), "Next");
	}

}
