package net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection;

import net.sigmainfo.lf.automation.common.AbstractTests;

import org.openqa.selenium.By;
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
public class CurrentResidenceDetailsPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(CurrentResidenceDetailsPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 240);

	public CurrentResidenceDetailsPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			  Thread.sleep(7000);
			logger.info("=========== CurrentResidenceDetailsPage is loaded============");
		} catch (Exception e) {
			throw new Exception("CurrentResidenceDetailsPage could not be loaded within time");
		}
	}

	public void provideCurrentResidentialDetails() throws Exception {
		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.currentResidentialDetailsPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please provide resident history for past two years.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please provide resident history for past two years.");

		if (portalParam.sameResidence == 1) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_sameResidenceAsSpouseButton),
					"this residence the same as your spouse - Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_notSameResidenceAsSpouseButton),
					"this residence the same as your spouse - No");
		}
		if ((portalParam.residenceStatus).equalsIgnoreCase("Own")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_ownButton), "Own");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Rent")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_rentButton), "Rent");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Other")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_otherButton), "Other");
		}

		if ((portalParam.loanType).contains("Purchase")) {
			selectAddress(getLocator(uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox),
					portalParam.currentAddress);
			enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
					portalParam.stayingSince);

			if (portalParam.planningToSale == 1) {
				clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_planningToSellButton),
						"Planning to Sell - Yes");
			} else {
				clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_notPlanningToSellButton),
						"Planning to Sell - No");
			}
		} else {

			if (driver.findElement(By.xpath("//input[@id='C-1037']")).isSelected()) {
				enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
						portalParam.stayingSince);

			} else {
				selectAddress(getLocator(uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox),
						portalParam.currentAddress);
				enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
						portalParam.stayingSince);

			}

		}

		clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_nextButton), "Next");
	}

	public void provideCurrentResidentialDetails_Individual() throws Exception {

		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.currentResidentialDetailsPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please provide resident history for past two years.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please provide resident history for past two years.");
		if ((portalParam.residenceStatus).equalsIgnoreCase("Own")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_ownButton), "Own");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Rent")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_rentButton), "Rent");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Other")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_otherButton), "Other");
		}
		if ((portalParam.loanType).contains("Purchase")) {
			selectAddress(getLocator(uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox),
					portalParam.currentAddress);
			enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
					portalParam.stayingSince);

			if (portalParam.planningToSale == 1) {
				clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_planningToSellButton),
						"Planning to Sell - Yes");
			} else {
				clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_notPlanningToSellButton),
						"Planning to Sell - No");
			}

		} else {
			if (driver.findElement(By.xpath("//input[@id='C-1037']")).isSelected()) {
				enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
						portalParam.stayingSince);

			} else {
				selectAddress(getLocator(uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox),
						portalParam.currentAddress);
				enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
						portalParam.stayingSince);

			}

		}
		clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_nextButton), "Next");
	}

	public void provideCurrentResidentialDetails_SpouseEnteringHisDetails() throws Exception {

		assertTrue(
				removeSpecialChar(driver
						.findElement(getLocator(uiObjParam.SpousecurrentResidentialDetailsPage_pageLabel)).getText())
								.contains(removeSpecialChar(
										"Please provide resident history of your spouse for past two years.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please provide resident history for past two years.");

		if (portalParam.sameResidence == 1) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_sameResidenceAsSpouseButton),
					"this residence the same as your spouse - Yes");
		} else {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_notSameResidenceAsSpouseButton),
					"this residence the same as your spouse - No");
		}
		
		if ((portalParam.residenceStatus).equalsIgnoreCase("Own")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_ownButton), "Own");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Rent")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_rentButton), "Rent");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Other")) {
			clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_otherButton), "Other");
		}
		if ((portalParam.loanType).contains("Purchase")) {
			selectAddress(getLocator(uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox),
					portalParam.currentAddress);
			enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
					portalParam.stayingSince);

			if (portalParam.planningToSale == 1) {
				clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_planningToSellButton),
						"Planning to Sell - Yes");
			} else {
				clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_notPlanningToSellButton),
						"Planning to Sell - No");
			}
		} else {

			if (driver.findElement(By.xpath("//input[@id='C-1037']")).isSelected()) {
				enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
						portalParam.stayingSince);

			} else {
				selectAddress(getLocator(uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox),
						portalParam.currentAddress);
				enterText(driver, getLocator(uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox),
						portalParam.stayingSince);

			}
		}

		clickButton(driver, getLocator(uiObjParam.currentResidentialDetailsPage_nextButton), "Next");
	}

	public void provideCurrentResidentialDetails_coborrower() throws Exception {

		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.currentResidentialDetailsPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please provide resident history for past two years.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please provide resident history for past two years.");
		if ((portalParam.residenceStatus).equalsIgnoreCase("Own")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_ownButton), "Own");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Rent")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_rentButton), "Rent");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Other")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_otherButton), "Other");
		}

		selectAddress(getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox),
				portalParam.currentAddress);
		enterText(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox),
				portalParam.stayingSince);

		if ((portalParam.loanType).contains("Purchase")) {
			if (portalParam.planningToSale == 1) {
				Thread.sleep(3000);
				clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_planningToSellButton),
						"Planning to Sell - Yes");
			} else {
				clickButton(driver,
						getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton),
						"Planning to Sell - No");
			}
		} else {

		}

		clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_nextButton), "Next");
	}

	public void provideCurrentResidentialDetails_coborrowerHisSpouse() throws Exception {

		assertTrue(
				removeSpecialChar(driver
						.findElement(getLocator(uiObjParam.SpousecurrentResidentialDetailsPage_pageLabel)).getText())
								.contains(removeSpecialChar(
										"Please provide resident history of your spouse for past two years.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please provide resident history for past two years.");
		if (portalParam.sameResidence == 1) {
			clickButton(driver,
					getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton),
					"this residence the same as your spouse - Yes");
		} else {
			clickButton(driver,
					getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton),
					"this residence the same as your spouse - No");
		}
		if ((portalParam.residenceStatus).equalsIgnoreCase("Own")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_ownButton), "Own");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Rent")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_rentButton), "Rent");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Other")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_otherButton), "Other");
		}
		selectAddress(getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox),
				portalParam.currentAddress);
		enterText(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox),
				portalParam.stayingSince);
		
		if ((portalParam.loanType).contains("Purchase")) {
			if (portalParam.planningToSale == 1) {
				Thread.sleep(3000);
				clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_planningToSellButton),
						"Planning to Sell - Yes");
			} else {
				clickButton(driver,
						getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton),
						"Planning to Sell - No");
			}
		} else {

		}
		clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_nextButton), "Next");
	}

	public void provideCurrentResidentialDetails_coborrowerSpouse() throws Exception {

		assertTrue(
				removeSpecialChar(
						driver.findElement(getLocator(uiObjParam.currentResidentialDetailsPage_pageLabel)).getText())
								.contains(removeSpecialChar("Please provide resident history for past two years.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please provide resident history for past two years.");

		if (portalParam.sameResidence == 1) {
			clickButton(driver,
					getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton),
					"this residence the same as your spouse - Yes");
		} else {
			clickButton(driver,
					getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton),
					"this residence the same as your spouse - No");
		}
		if ((portalParam.residenceStatus).equalsIgnoreCase("Own")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_ownButton), "Own");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Rent")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_rentButton), "Rent");
		} else if ((portalParam.residenceStatus).equalsIgnoreCase("Other")) {
			clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_otherButton), "Other");
		}
		selectAddress(getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox),
				portalParam.currentAddress);
		enterText(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox),
				portalParam.stayingSince);
	
		if ((portalParam.loanType).contains("Purchase")) {
			if (portalParam.planningToSale == 1) {
				clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_planningToSellButton),
						"Planning to Sell - Yes");
			} else {
				clickButton(driver,
						getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton),
						"Planning to Sell - No");
			}
		} else {

		}
	

		clickButton(driver, getLocator(uiObjParam.CoborrwercurrentResidentialDetailsPage_nextButton), "Next");
	}
}
