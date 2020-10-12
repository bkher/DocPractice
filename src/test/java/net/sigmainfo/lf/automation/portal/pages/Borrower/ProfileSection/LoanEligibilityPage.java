package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class LoanEligibilityPage extends AbstractTests {

    private Logger logger = LoggerFactory.getLogger(LoanEligibilityPage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public LoanEligibilityPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            assertTrue(removeSpecialChar(driver.findElement(getLocator(uiObjParam.loanEligibilityPage_pageLabel)).getText()).contains(removeSpecialChar(portalParam.borrowerFirstname +", we are proud to offer VA/Military loans.")),"Page title does not contain "+portalParam.borrowerFirstname+", , we are proud to offer VA/Military loans.");
            assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.loanEligibilityPage_eligibleForLoanButton)),"Eligible for loan button is not clickable.");
            logger.info("=========== LoanEligibilityPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("LoanEligibilityPage could not be loaded within time");
        }
    }
    public LoanEligibilityPage(){}

    public RealEstateAgentPage selectLoanInfo() throws Exception {
       
            if(portalParam.eligibleLoan==1)
            {
                clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_eligibleForLoanButton),"Eligible for millitary loan - Yes");
                if(portalParam.currentLoanEligibilitySatus.contains("retired"))
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_CurrentlyRetiredCheckbox),"selected radio : currently retired");
                }
                else if(portalParam.currentLoanEligibilitySatus.contains("expiration"))
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_dutyWithExpirationDateCheckbox),"selected radio : currently serving with expiry date");
                }
                else if(portalParam.currentLoanEligibilitySatus.contains("non-activated"))
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_NonActivatedCheckbox),"selected radio : non-activated member");
                }
                else if (portalParam.currentLoanEligibilitySatus.contains("Surviving spouse"))
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_SurvivingSpouseCheckbox),"selected radio : Surviving spouse");
                }
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Do you currently have')]")));
                if(portalParam.currentLoan==1)
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_haveCurrentLoanButton),"Have existing loan - Yes");
                }
                else
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_noCurrentLoanButton),"Have existing loan - No");
                }

                if(portalParam.childCareExpense==1)
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_childCareExpenseButton),"have monthly child care expense - Yes");
                    enterText(driver,getLocator(uiObjParam.loanEligibilityPage_childCareExpenseTextbox),portalParam.childCareAmount);
                }
                else
                {
                    clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_noChildCareExpenseButton),"have monthly child care expense - No");
                }
            }
            else if(portalParam.eligibleLoan==1)
            {
                clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_notEligibleForLoanButton),"Eligible for millitary loan - No");
            }
            //selectStatus();
            clickButton(driver,getLocator(uiObjParam.loanEligibilityPage_nextButton),"Next");
       
        return new RealEstateAgentPage(driver);
    }

    /*private void selectStatus(String status) {
        List<WebElement> options = driver.findElements(By.xpath("/*//*[@id='SS8']//SelectOptions1//ui-container//ui-radio-tree-view//li"));
        for (int i = 1; i <= options.size(); i++) {
            if (driver.findElement(By.xpath("/*//*[@id='SS8']//SelectOptions1//ui-container//ui-radio-tree-view//li["+i+"]//div[contains(.,'"+status+"')]")).isDisplayed()) {
                new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='items']/vaadin-combo-box-item[contains(.,'" + duration + "')]")));
                driver.findElement(By.xpath("//div[@id='items']/vaadin-combo-box-item[contains(.,'" + duration + "')]")).click();
                logger.info("Selected :"+duration);
            }

        }*/

}
