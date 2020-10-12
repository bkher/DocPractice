package net.sigmainfo.lf.automation.portal.pages.Lender;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;

/**
 * Created by Shaishav.s on 30-04-2018.
 */

public class LenderGetStartedPage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(LenderGetStartedPage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public LenderGetStartedPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            waitForElementToBeVisible(getLocator(UIObjParam.lenderGetStartedPage_getStartedLabel));
            waitForElementToBeClickable(getLocator(UIObjParam.lenderGetStartedPage_loginButton));
            logger.info("=========== LenderGetStartedPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("LenderGetStartedPage could not be loaded within time");
        }
    }
    public LenderGetStartedPage(){}

    public LenderLoginPage navigateToLoginPage() throws Exception {
     
            clickButton(driver,getLocator(uiObjParam.lenderGetStartedPage_loginButton),"Login");
            Thread.sleep(3000);
        return new LenderLoginPage(driver);
    }


}
