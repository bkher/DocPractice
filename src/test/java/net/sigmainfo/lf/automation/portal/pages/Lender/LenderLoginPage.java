package net.sigmainfo.lf.automation.portal.pages.Lender;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;
import net.sigmainfo.lf.automation.portal.function.StringEncrypter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;

/**
 * Created by Shaishav.s on 30-04-2018.
 */
public class LenderLoginPage extends AbstractTests {

    private Logger logger = LoggerFactory.getLogger(LenderLoginPage.class);

    WebDriverWait wait = new WebDriverWait(driver,240);

    public LenderLoginPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            //waitForElementToBeVisible(getLocator(uiObjParam.lenderLoginPage_emailTextBox));
            waitForElementToBeClickable(getLocator(uiObjParam.lenderLoginPage_emailTextBox));
            //waitForElementToBeClickable(getLocator(uiObjParam.lenderGetStartedPage_loginButton));
            logger.info("=========== LenderLoginPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("LenderLoginPage could not be loaded within time");
        }
    }

    public void loginToLenderPortal(WebDriver driver) throws Exception {
            insertText(driver,getLocator(uiObjParam.lenderLoginPage_emailTextBox),portalParam.lenderUsername);
            insertText(driver,getLocator(uiObjParam.lenderLoginPage_passwordTextBox), StringEncrypter.createNewEncrypter().decrypt(PortalParam.lenderPassword));
            clickButton(driver,getLocator(uiObjParam.lenderLoginPage_loginButton),"Login");
            Thread.sleep(4000);
    }
}
