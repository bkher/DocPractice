package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.support.AbstractTestContextBootstrapper;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 02-05-2018.
 */
public class BorrowerCommunicationPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(TellAboutYourselfPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public BorrowerCommunicationPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			  Thread.sleep(7000);
			logger.info("=========== BorrowerCommunicationPage is loaded============");
		} catch (Exception e) {
			throw new Exception("BorrowerCommunicationPage could not be loaded within time");
		}
	}

	public BorrowerCommunicationPage() {
	}

	public void provideCommunicationDetails_borrower(WebDriver driver) throws Exception {
		Thread.sleep(8000);
		logger.info(driver.findElement(getLocator(uiObjParam.borrowerCommunicationPage_preferredEmailTextBox))
				.getAttribute("value"));
		assertTrue(
				driver.findElement(getLocator(uiObjParam.borrowerCommunicationPage_preferredEmailTextBox))
						.getAttribute("value").contains(portalParam.borrowerUsername),
				"Borrower email is not prefilled.");

		if ((portalParam.modeOfCommunication).equalsIgnoreCase("Email")) {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_emailButton), "Email");
		} else if ((portalParam.modeOfCommunication).equalsIgnoreCase("Phone")) {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_phoneButton), "Phone");
		} else if ((portalParam.modeOfCommunication).equalsIgnoreCase("Text")) {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_textButton), "Text");
		} else {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_allButton), "All");
		}
		insertText(driver, getLocator(uiObjParam.borrowerCommunicationPage_phoneNumberTextBox),
				portalParam.borrowerPhone);
		insertText(driver, getLocator(uiObjParam.borrowerCommunicationPage_cellPhone), portalParam.borrowerPhone);
		clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_nextButton), "Next");

	}

	public void provideCommunicationDetails_coborrower(WebDriver driver) throws Exception {
		Thread.sleep(8000);
		logger.info(driver.findElement(getLocator(uiObjParam.borrowerCommunicationPage_coborpreferredEmailTextBox))
						.getAttribute("value"));
		assertTrue(
				driver.findElement(getLocator(uiObjParam.borrowerCommunicationPage_coborpreferredEmailTextBox))
						.getAttribute("value").contains(portalParam.borrowerUsername),
				"Borrower email is not prefilled.");

		if ((portalParam.modeOfCommunication).equalsIgnoreCase("Email")) {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_emailButton), "Email");
		} else if ((portalParam.modeOfCommunication).equalsIgnoreCase("Phone")) {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_phoneButton), "Phone");
		} else if ((portalParam.modeOfCommunication).equalsIgnoreCase("Text")) {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_textButton), "Text");
		} else {
			clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_allButton), "All");
		}
		insertText(driver, getLocator(uiObjParam.borrowerCommunicationPage_phoneNumberTextBox),
				portalParam.borrowerPhone);
		insertText(driver, getLocator(uiObjParam.borrowerCommunicationPage_cellPhone), portalParam.borrowerPhone);
		clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_nextButton), "Next");

	}

	public void provideCommunicationDetails_SpouseVerifyHisSpouseDetails(WebDriver driver) throws Exception {
		Thread.sleep(8000);
		assertTrue(
				driver.findElement(getLocator(uiObjParam.borrowerCommunicationPage_preferredEmailTextBox))
						.getAttribute("value").contains(portalParam.borrowerUsername),
				"Borrower email is not prefilled.");
		clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_nextButton), "Next");

	}

	public void provideCommunicationDetails_CobSpouseVerifyHisSpouseDetails(WebDriver driver) throws Exception {
		Thread.sleep(8000);
		assertTrue(
				driver.findElement(getLocator(uiObjParam.borrowerCommunicationPage_coborSpousepreferredEmailTextBox))
						.getAttribute("value").contains(portalParam.borrowerUsername),
				"Borrower email is not prefilled.");
		
		clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_nextButton), "Next");

	}

	public void provideCommunicationDetails_SpouseVerifyHisDetails(WebDriver driver) throws Exception {
		Thread.sleep(8000);
		assertTrue(
				driver.findElement(getLocator(uiObjParam.borrowerCommunicationPage_coborpreferredEmailTextBox))
						.getAttribute("value").contains(portalParam.spouceUsername),
				"Borrower email is not prefilled.");
		driver.findElement(By.xpath("/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[7]/questioner-question-set[1]/div[4]/div[1]/questioner-question[1]/ui-container[1]/div[1]/ui-toggle-button-group[1]/div[1]/div[2]/label[1]"))
		.click();
		clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_nextButton), "Next");

	}

	public void provideCommunicationDetails_CobSpouseVerifyHisDetails(WebDriver driver) throws Exception {

		Thread.sleep(8000);
		clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_cobSpouseemailButton), "Email");
		clickButton(driver, getLocator(uiObjParam.borrowerCommunicationPage_nextButton), "Next");

	}

}
