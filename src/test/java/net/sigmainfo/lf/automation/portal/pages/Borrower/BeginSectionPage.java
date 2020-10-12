package net.sigmainfo.lf.automation.portal.pages.Borrower;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.TellAboutYourselfPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 24-04-2018.
 */
public class BeginSectionPage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(BeginSectionPage.class);
    WebDriverWait wait = new WebDriverWait(driver,180);

    public BeginSectionPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            /*assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.beginSectionPage_beginSectionButton)),"Begin Section button is not clickable");
            assertTrue(waitForElementToBeVisible(getLocator(uiObjParam.beginSectionPage_welcomeMessage)),"Begin section welcome message is not visible");*/
            logger.info("=========== BeginSectionPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("BeginSectionPage could not be loaded within time");
        }
    }
    public BeginSectionPage(){}

    public TellAboutYourselfPage startQuestionnaire(WebDriver driver) throws Exception {
        try
        {
            clickButton(driver,getLocator(uiObjParam.beginSectionPage_beginSectionButton),"Begin Section");
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return new TellAboutYourselfPage(driver);
    }
}
