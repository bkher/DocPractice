package net.sigmainfo.lf.automation.portal.pages.Affinity;

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
public class AffinityPartnerInviteBorrowerPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(AffinityPartnerInviteBorrowerPage.class);

	WebDriverWait wait = new WebDriverWait(driver, 240);

	public AffinityPartnerInviteBorrowerPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			logger.info("=========== LenderPipeLinePage is loaded============");
		} catch (Exception e) {
			throw new Exception("LenderPipeLinePage could not be loaded within time");
		}
	}

	

	public void inviteBorrower(WebDriver driver) throws Exception {
		clickButton(driver, getLocator(uiObjParam.lenderPipelinePage_inviteButton), "Invite");
		waitForElementToBeVisible(getLocator(uiObjParam.lenderPipeline_inviteDialog_inviteLabel));
		Thread.sleep(5000);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_firstNameTextBox),
				portalParam.borrowerFirstname);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_lastNameTextBox),
				portalParam.borrowerlastname);

		clickButton(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_borrowerButton), "Borrower");

		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_emailTextBox),
				portalParam.borrowerUsername);
		insertText(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_phoneTextBox), portalParam.borrowerPhone);
		Thread.sleep(3000);
		clickButton(driver, getLocator(uiObjParam.lenderPipeline_inviteDialog_sendInviteButton), "Send Invite");
		Thread.sleep(12000);
	}

}
