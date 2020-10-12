package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 07-05-2018.
 */
public class SpouseCommunicationPage extends AbstractTests {

    private Logger logger = LoggerFactory.getLogger(SpouseInformationPage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public SpouseCommunicationPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.spouseCommunicationPage_pageLabel)).getText()).contains(removeSpecialChar(portalParam.borrowerFirstname +", please let us know how we may best contact your spouse")),"Page title does not contain "+portalParam.borrowerFirstname+", please let us know how we may best contact your spouse");
            assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.spouseCommunicationPage_emailButton)),"Email button is not clickable");
            logger.info("=========== SpouseCommunicationPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("SpouseCommunicationPage could not be loaded within time");
        }
    }
    public SpouseCommunicationPage(){}

    public NonSpouseInformationPage enterSpouseCommunicationDetails() throws Exception {
        try
        {
            enterText(driver,getLocator(uiObjParam.spouseCommunicationPage_preferredEmailTextbox),portalParam.spouceUsername);
            enterText(driver,getLocator(uiObjParam.spouseCommunicationPage_phoneTextbox),portalParam.spoucePhone);
            if((portalParam.spouceComm).equalsIgnoreCase("Email"))
            {
                clickButton(driver,getLocator(uiObjParam.spouseCommunicationPage_emailButton),"Email");
            }
            else if((portalParam.spouceComm).equalsIgnoreCase("Phone"))
            {
                clickButton(driver,getLocator(uiObjParam.spouseCommunicationPage_phoneButton),"Phone");
            }
            if((portalParam.spouceComm).equalsIgnoreCase("Text"))
            {
                clickButton(driver,getLocator(uiObjParam.spouseCommunicationPage_textButton),"Text");
            }
            else
            {
                clickButton(driver,getLocator(uiObjParam.spouseCommunicationPage_allButton),"All");
            }
            Thread.sleep(1500);
            clickButton(driver,getLocator(uiObjParam.spouseCommunicationPage_nextButton),"Next");
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return new NonSpouseInformationPage(driver);
    }
}
