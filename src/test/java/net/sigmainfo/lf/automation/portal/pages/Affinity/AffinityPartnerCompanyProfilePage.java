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

public class AffinityPartnerCompanyProfilePage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(AffinityPartnerCompanyProfilePage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public AffinityPartnerCompanyProfilePage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.Affinity_CompanyProfilelabel)),
    				"Company Profile");
           logger.info("=========== AffinityPartnerCompanyProfilePage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("AffinityPartnerCompanyProfilePage could not be loaded within time");
        }
    }


    public void SubmitCompanyProfile(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		
		insertText(driver, getLocator(uiObjParam.Affinity_CompanyProfileCompanyName),
				"Sigma Info slns");
		selectAddress(getLocator(uiObjParam.Affinity_CompanyProfileAddress),
				portalParam.currentAddress);
		insertText(driver, getLocator(uiObjParam.Affinity_CompanyProfilePhone), portalParam.borrowerPhone);
		clickButton(driver, getLocator(uiObjParam.Affinity_CompanyProfileNext), "Next");
		Thread.sleep(10000);
		
	}


}
