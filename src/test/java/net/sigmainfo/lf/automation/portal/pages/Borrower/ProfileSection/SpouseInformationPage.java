package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class SpouseInformationPage extends AbstractTests {

    private Logger logger = LoggerFactory.getLogger(SpouseInformationPage.class);
    WebDriverWait wait = new WebDriverWait(driver, 240);

    public SpouseInformationPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.spouseInformationPage_pageLabel)).getText()).contains(removeSpecialChar(portalParam.borrowerFirstname +", whats your spouses information?")),"Page title does not contain "+portalParam.borrowerFirstname+", what's your spouse's information?");
            assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.spouseInformationPage_firstNameTextbox)),"Firstname is not clickable.");
            logger.info("=========== SpouseInformationPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("SpouseInformationPage could not be loaded within time");
        }
    }
    public SpouseInformationPage(){}

    public SpouseCommunicationPage enterSpouseDetails() throws Exception {
      
            enterText(driver,getLocator(uiObjParam.spouseInformationPage_firstNameTextbox),portalParam.spouceFirstName);
            enterText(driver,getLocator(uiObjParam.spouseInformationPage_middleNameTextbox),portalParam.spouceMiddleName);
            enterText(driver,getLocator(uiObjParam.spouseInformationPage_lastNameTextbox),portalParam.spouceLastName);
            enterText(driver,getLocator(uiObjParam.spouseInformationPage_suffixNameTextbox),portalParam.spouceSuffix);
            enterText(driver,getLocator(uiObjParam.spouseInformationPage_dObTextBox),portalParam.spouseDoB);
            enterText(driver,getLocator(uiObjParam.spouseInformationPage_ssnTextBox),portalParam.spouseSsn);
            //selectPreferredMethodOfCommunication(portalParam.modeOfCommunication);
            clickButton(driver,getLocator(uiObjParam.spouseInformationPage_nextButton),"Next");
        
      
        return new SpouseCommunicationPage(driver);
    }

    public void selectPreferredMethodOfCommunication(String modeOfComm) throws Exception {


    }

}
