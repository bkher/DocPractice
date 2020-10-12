package net.sigmainfo.lf.automation.portal.pages.Affinity;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;

/**
 * Created by Shaishav.s on 11-12-2018.
 */

public class AffinityPartnerPersonalProfilePage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(AffinityPartnerPersonalProfilePage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public AffinityPartnerPersonalProfilePage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.Affinity_Profilelabel)),
    				"Profile");
           logger.info("=========== AffinityPartnerPersonalProfilePage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("AffinityPartnerPersonalProfilePage could not be loaded within time");
        }
    }
    

    public void SubmitPersonalProfile(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		//scrollToBottomOfThePage(driver);
		//clickButton(driver, getLocator(uiObjParam.Affinity_ProfilePerferredEmail), "Perfrred Email");
		clickButton(driver, getLocator(uiObjParam.Affinity_ProfileNext), "Next");
		Thread.sleep(10000);
	}

	public static void scrollToBottomOfThePage(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,250)", "");
	}


}
