package net.sigmainfo.lf.automation.portal.pages.Affinity;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;

/**
 * Created by Shaishav.s on 11-12-2018.
 */

public class AffinityPartnerGetStartedPage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(AffinityPartnerGetStartedPage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public AffinityPartnerGetStartedPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
           logger.info("=========== AffinityPartnerGetStartedPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("AffinityPartnerGetStartedPage could not be loaded within time");
        }
    }
    public AffinityPartnerGetStartedPage(){}

    public void navigateSignUpPage(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		clickButton(driver, getLocator(uiObjParam.borrowerWelcomeVideoPage_getStartedButton), "Get Started");
	}


}
