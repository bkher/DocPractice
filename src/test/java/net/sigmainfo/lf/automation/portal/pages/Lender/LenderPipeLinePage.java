package net.sigmainfo.lf.automation.portal.pages.Lender;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractCollection;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;

/**
 * Created by Shaishav.s on 30-04-2018.
 */
public class LenderPipeLinePage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(LenderPipeLinePage.class);

	WebDriverWait wait = new WebDriverWait(driver, 240);

	public LenderPipeLinePage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			if (portalParam.ClientName.contains("NAF")) {

				waitForElementToBeVisible(getLocator(uiObjParam.lenderPipeline_firstActiveLoan_daysToCloseLabel));

			}
			if (portalParam.ClientName.contains("OC")) {

				waitForElementToBeVisible(getLocator(uiObjParam.lenderPipeline_firstActiveLoan_daysToCloseLabel));

			}
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			logger.info("=========== LenderPipeLinePage is loaded============");
		} catch (Exception e) {
			throw new Exception("LenderPipeLinePage could not be loaded within time");
		}
	}

	public void logout(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.lenderPipeline_headerPanel_settingDropdown), "Profile Setting");
		clickButton(driver, getLocator(uiObjParam.lenderPipeline_headerPanel_settingDropdown_logoutButton), "Logout");
	}

	public void inviteBorrower(WebDriver driver) throws Exception {
		clickButton(driver, getLocator(uiObjParam.lenderPipelinePage_inviteButton), "Invite");
		Thread.sleep(8000);
		waitForElementToBeVisible(getLocator(uiObjParam.lenderPipeline_inviteDialog_inviteLabel));
		Thread.sleep(8000);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_firstNameTextBox),
				portalParam.borrowerFirstname);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_lastNameTextBox),
				portalParam.borrowerlastname);

		clickButton(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_borrowerButton), "Borrower");

		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_emailTextBox),
				portalParam.borrowerUsername);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_phoneTextBox), portalParam.borrowerPhone);

		clickButton(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_sendInviteButton), "Send Invite");
		Thread.sleep(30000);
		logout(driver);
	}

	public void inviteAffinityPartner(WebDriver driver) throws Exception {
		clickButton(driver, getLocator(uiObjParam.lenderPipelinePage_inviteButton), "Invite");
		Thread.sleep(8000);
		waitForElementToBeVisible(getLocator(uiObjParam.lenderPipeline_inviteDialog_inviteLabel));
		Thread.sleep(8000);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_firstNameTextBox), "Renga");
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_lastNameTextBox), "Rajan");

		clickButton(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_affinityPartnerButton),
				"Affinity Partner");

		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_emailTextBox),
				portalParam.AffinityUserName);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_phoneTextBox), portalParam.borrowerPhone);

		clickButton(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_sendInviteButton), "Send Invite");
		Thread.sleep(30000);
		logout(driver);
	}
}
