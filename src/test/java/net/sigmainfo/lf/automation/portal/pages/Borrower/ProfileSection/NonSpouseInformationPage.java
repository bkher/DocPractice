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
 * Created by Shaishav.s on 29-04-2018.
 */
public class NonSpouseInformationPage extends AbstractTests {

    private Logger logger = LoggerFactory.getLogger(NonSpouseInformationPage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public NonSpouseInformationPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.nonSpouseInformationPage_pageLabel)).getText()).contains(removeSpecialChar(portalParam.borrowerFirstname +", what's your co-borrower's information?")),"Page title does not contain "+portalParam.borrowerFirstname+", what's your co-borrower's information?");
            assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.nonSpouseInformationPage_firstNameTextbox)),"Firstname textbox is not clickable.");
            logger.info("=========== NonSpouseInformationPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("NonSpouseInformationPage could not be loaded within time");
        }
    }
    public NonSpouseInformationPage(){}

    public ApplicantInformationPage enterNonSpouseDetails() throws Exception {
       
            enterText(driver,getLocator(uiObjParam.nonSpouseInformationPage_firstNameTextbox),portalParam.nonSpouseFirstName);
            Thread.sleep(3000);
            enterText(driver,getLocator(uiObjParam.nonSpouseInformationPage_middleNameTextbox),portalParam.nonSpouseMiddleName);
            enterText(driver,getLocator(uiObjParam.nonSpouseInformationPage_lastNameTextbox),portalParam.nonSpouseLastName);
            enterText(driver,getLocator(uiObjParam.nonSpouseInformationPage_suffixTextbox),portalParam.nonSpouseSuffix);
            enterText(driver,getLocator(uiObjParam.nonSpouseInformationPage_preferredEmailTextbox),portalParam.nonSpouceUsername);
            enterText(driver,getLocator(uiObjParam.nonSpouseInformationPage_phoneTextbox),portalParam.nonSpousePhone);
            clickButton(driver,getLocator(uiObjParam.nonSpouseInformationPage_nextButton),"Next");
      
        return new ApplicantInformationPage(driver);
    }
}
