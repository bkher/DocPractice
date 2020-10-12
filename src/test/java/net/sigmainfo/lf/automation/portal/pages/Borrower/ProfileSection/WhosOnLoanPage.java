package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 29-04-2018.
 */
public class WhosOnLoanPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(WhosOnLoanPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public WhosOnLoanPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.whosOnTheLoanPage_pageLabel)).getText())
							.contains(removeSpecialChar("Who will be on the loan?")),
					"Page title does not contain " + "Who will be on the loan?");
			logger.info("=========== WhosOnLoanPage is loaded============");
		} catch (Exception e) {
			throw new Exception("WhosOnLoanPage could not be loaded within time");
		}
	}

	public void selectApplicants(WebDriver driver) throws Exception {
		if (portalParam.creditType.contains("Individual")) {
			clickCheckBox(driver, getLocator(uiObjParam.whosOnTheLoanPage_individualCreditCheckbox),
					"Individual Credit");
		} else if (portalParam.creditType.contains("Joint")) {
			clickCheckBox(driver, getLocator(uiObjParam.whosOnTheLoanPage_jointCreditCheckbox), "Joint Credit");
		}
		Thread.sleep(1500);
		selectBoolean(getLocator(uiObjParam.whosOnTheLoanPage_marriedButton), portalParam.married);
		Thread.sleep(3500);
		if (portalParam.SpouseAsCoBorrower == 1) {
			clickButton(driver, getLocator(uiObjParam.whosOnTheLoanPage_AddSpouseasCoBorrower), "Yes");
			Thread.sleep(2000);
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseDateOfBirth), portalParam.dateOfBirth);
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseSSN), portalParam.ssnNumber);
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseEmail), portalParam.spouceUsername);
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spousePhone), portalParam.borrowerPhone);
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseFirstNameTextBox),
					portalParam.spouceFirstName);

			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseLastNameTextBox), portalParam.spouceLastName);
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseSuffixTextBox), portalParam.spouceLastName);
			
            
			Thread.sleep(2000);
		
			if (portalParam.AddAnotherCoBorrower == 1) {
				driver.findElement(By.xpath("/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[5]/questioner-question-set[1]/div[20]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-switch-loan[1]/div[1]/div[1]/label[1]")).click();
				//clickButton(driver, getLocator(uiObjParam.whosOnTheLoanPage_AddAnotherCoBorrower), "Yes");
			   
			} else {
				clickButton(driver, getLocator(uiObjParam.whosOnTheLoanPage_DontAddAnotherCoBorrower), "No");
				//driver.findElement(By.xpath("//div[contains(@class,'modal-dialog modal-lg style-scope ui-modal')]//span[contains(@class,'style-scope ui-button')][contains(text(),'Yes')]")).click();
				//Thread.sleep(5000);
			}
		

		} else {
			clickButton(driver, getLocator(uiObjParam.whosOnTheLoanPage_SpouseNotasCoBorrower), "No");
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseFirstNameTextBox),
					portalParam.spouceFirstName);

			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseSuffixTextBox), portalParam.spouceLastName);
			insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseLastNameTextBox), portalParam.spouceLastName);

		}
		Thread.sleep(2000);
		clickButton(driver, getLocator(uiObjParam.whosOnTheLoanPage_nextButton), "Next");
		Thread.sleep(10000);
	}

	public void selectIndividualCredit(WebDriver driver) throws Exception {
		if (portalParam.creditType.contains("Individual")) {
			clickCheckBox(driver, getLocator(uiObjParam.whosOnTheLoanPage_individualCreditCheckbox),
					"Individual Credit");
		} else if (portalParam.creditType.contains("Joint")) {
			clickCheckBox(driver, getLocator(uiObjParam.whosOnTheLoanPage_jointCreditCheckbox), "Joint Credit");
		}
		Thread.sleep(1500);
		selectBoolean(getLocator(uiObjParam.whosOnTheLoanPage_unmarriedButton), portalParam.married);
		Thread.sleep(3500);

		clickButton(driver, getLocator(uiObjParam.whosOnTheLoanPage_nextButton), "Next");
	}
	
	public void selectJoint_MarriedSeparated(WebDriver driver) throws Exception {
		if (portalParam.creditType.contains("Individual")) {
			clickCheckBox(driver, getLocator(uiObjParam.whosOnTheLoanPage_individualCreditCheckbox),
					"Individual Credit");
		} else if (portalParam.creditType.contains("Joint")) {
			clickCheckBox(driver, getLocator(uiObjParam.whosOnTheLoanPage_jointCreditCheckbox), "Joint Credit");
		}
		Thread.sleep(1500);
		selectBoolean(getLocator(uiObjParam.whosOnTheLoanPage_separatedButton), portalParam.married);
		Thread.sleep(3500);

		insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseFirstNameTextBox),
				portalParam.spouceFirstName);

		insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseSuffixTextBox), portalParam.spouceLastName);
		insertText(driver, getLocator(uiObjParam.whosOnTheLoanPage_spouseLastNameTextBox), portalParam.spouceLastName);

		clickButton(driver, getLocator(uiObjParam.whosOnTheLoanPage_nextButton), "Next");
	}

	public void selectBoolean(By locator, int value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		logger.info("Selected boolean :" + value);
	}
}
