package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.function.PortalFuncUtils;
import net.sigmainfo.lf.automation.portal.function.PortalPropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 29-06-2018.
 */
public class AddCoApplicantsPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(AddCoApplicantsPage.class);
	
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public AddCoApplicantsPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(6000);
			assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.addCoApplicantsPage_addFirstCoborrower)),
					"Button to add first coborrower is not clickable.");
			logger.info("=========== AddCoApplicantsPage is loaded============");
		} catch (Exception e) {
			throw new Exception("AddCoApplicantsPage could not be loaded within time");
		}
	}

	public  void selectDropdownByValue(WebDriver driver, By locator, String value) throws Exception {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			
		
			
			if (portalParam.SpouseAsCoBorrower == 1)
			{
				driver.findElement(By.xpath("/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[8]/questioner-question-set[1]/div[3]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-add-coborrower[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]")).click();
				
			}
			else
			{
			driver.findElement(By.xpath("/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[6]/questioner-question-set[1]/div[3]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-add-coborrower[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[3]/span[1]")).click();
			}
			
		/*	assertTrue(driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("// span[contains(text(),'" + value + "')]")).click();
			}*/
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public void addCoborrowers(WebDriver driver) throws Exception {
		for (int i = 1; i <= 1; i++) {
			clickButton(driver,
					By.xpath(
							"//div[contains(@class,'ui-add-coborrower')]/div[h3][contains(.,'CO-BORROWER " + i + "')]"),
					"Add " + i + "th Coborrower");
			enterText(driver, getLocator(uiObjParam.addCoApplicantsPage_cob1FirstNameTextbox), portalParam.CoborrowerFirstName);
			enterText(driver, getLocator(uiObjParam.addCoApplicantsPage_cob1LastNameTextbox), portalParam.CoborrowerLastName);
			//PortalParam.CoBorrowerEmail_1 = getCoborrowerId(i);
			logger.info("Co-borrower Email ID... " + portalParam.nonSpouceUsername);
			enterText(driver, getLocator(uiObjParam.addCoApplicantsPage_cob1EmailTextbox), portalParam.nonSpouceUsername);
			selectDropdownByValue(driver, getLocator(uiObjParam.addCoApplicantsPage_cob1RelationshipDropdown),
					getRelationship(i));
		}
		clickButton(driver, getLocator(uiObjParam.addCoApplicantsPage_InviteButton), "Send Invite");
		clickButton(driver, getLocator(uiObjParam.addCoApplicantsPage_Continue), "Conitnue");
		Thread.sleep(5000);
	}
}
