package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class ApplicantInformationPage extends AbstractTests {

    private Logger logger = LoggerFactory.getLogger(ApplicantInformationPage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public ApplicantInformationPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.applicantInformationPage_pageLabel)).getText()).contains(removeSpecialChar(portalParam.borrowerFirstname+", who should be the primary borrower on this application?")));
            logger.info("=========== ApplicantInformationPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("ApplicantInformationPage could not be loaded within time");
        }
    }
    public ApplicantInformationPage(){}

    public void verifyApplicants() throws Exception {
     
            assertTrue(driver.findElement(By.xpath("//div[starts-with(@id,'ID')][4]//div[contains(text(),'"+portalParam.borrowerFirstname+" "+portalParam.borrowerlastname+"')]")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//div[starts-with(@id,'ID')][4]//div[contains(text(),'"+portalParam.spouceFirstName+" "+portalParam.spouceLastName+"')]")).isDisplayed());
            //assertTrue(driver.findElement(By.xpath("//div[starts-with(@id,'ID')][4]//div[contains(text(),'"+portalParam.nonSpouseFirstName+" "+portalParam.nonSpouseLastName+"')]")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//label[@for='SS1ui-select-one']")).isDisplayed());
            clickButton(driver,getLocator(uiObjParam.applicantInformationPage_nextButton),"Next");
        
            Thread.sleep(7000);
  
    }
}
