package net.sigmainfo.lf.automation.portal.pages.Affinity;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;

/**
 * Created by Shaishav.s on 11-12-2018.
 */

public class AffinityPartnerInvitePage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(AffinityPartnerInvitePage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public AffinityPartnerInvitePage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.Affinity_Invitelabel)),
    				"Invite");
           logger.info("=========== AffinityPartnerGetStartedPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("AffinityPartnerInvitePage could not be loaded within time");
        }
    }


    public void invitePage(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		insertText(driver, getLocator(uiObjParam.Affinity_InviteFirstName),
				portalParam.borrowerFirstname);
		insertText(driver, getLocator(uiObjParam.Affinity_InviteLastName),
				portalParam.borrowerlastname);
		insertText(driver, getLocator(uiObjParam.Affinity_InviteEmail), portalParam.AffinityUserName);
		insertText(driver, getLocator(uiObjParam.Affinity_InvitePhone), portalParam.borrowerPhone);
		clickButton(driver, getLocator(uiObjParam.Affinity_InviteButton), "Invite");
		Thread.sleep(15000);
	}


}
