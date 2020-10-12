package net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.enterText;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.removeSpecialChar;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeClickable;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForElementToBeVisible;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForTextToBePresent;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sigmainfo.lf.automation.common.AbstractTests;

public class SpouseAssestPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(AssetsPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public SpouseAssestPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(10000);
			if (portalParam.ClientName.contains("OC")) {
				assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.spouseAssetsPage_enterManuallyButton)));
			}
			logger.info("=========== SpouseAssetsPage is loaded============");
		} catch (Exception e) {
			throw new Exception("AssetsPage could not be loaded within time");
		}
	}

	public void enterAssets() throws Exception {
		if (portalParam.ClientName.contains("NAF")) {
			Thread.sleep(5000);

			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_institutionNameTextBox),
					portalParam.institutionName);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_accountTypeTextBox),
					portalParam.accountType);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_currentBalanceTextBox),
					portalParam.currentBalance);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_accountNumberTextBox),
					portalParam.accountNumber);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_accountHolderNameTextBox),
					portalParam.accountName);
			clickButton(driver, getLocator(uiObjParam.spouseSavingAndInvestmentPage_enterButton), "Enter");
			Thread.sleep(5000);
			clickButton(driver, getLocator(uiObjParam.spouseAssetSummaryPage_iAmDoneButton), "I'M all done");
		}
		
		if (portalParam.ClientName.contains("OC")) {

			clickButton(driver, getLocator(uiObjParam.spouseAssetsPage_enterManuallyButton), "Enter Manually");
			Thread.sleep(5000);
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.spouseAssetsPage_pageLabel)).getText())
							.contains(portalParam.spouceFirstName + "nextwelltakealookatyoursavingsandinvestments"),
					"Page label is not displaying appropriate title.");
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_institutionNameTextBox),
					portalParam.institutionName);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_accountTypeTextBox),
					portalParam.accountType);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_currentBalanceTextBox),
					portalParam.currentBalance);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_accountNumberTextBox),
					portalParam.accountNumber);
			enterText(driver, getLocator(uiObjParam.savingAndInvestmentPage_accountHolderNameTextBox),
					portalParam.accountName);
			clickButton(driver, getLocator(uiObjParam.spouseSavingAndInvestmentPage_enterButton), "Enter");
			Thread.sleep(8000);
			clickButton(driver, getLocator(uiObjParam.spouseAssetSummaryPage_iAmDoneButton), "I'M all done");
		
		/*	verifyManualAssetsAdded(portalParam.spouceFirstName);
			addAutomatedAssets(portalParam.spouceFirstName);
			assertTrue(removeSpecialChar(driver.findElement(By.xpath(
					"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]/questioner-question-set[1]/div[1]/div[1]/questioner-question[1]/assets-container[1]/div[1]/assets-forms-credentials[1]/div[1]/div[1]/assets-scene-title[1]/div[1]/h3[1]"))
					.getText()).contains(
							portalParam.spouceFirstName + "pleaseenterlogindetailstosyncyouraccountswiththesystem"),
					"Page title does not match expected text");
			enterText(driver, getLocator(uiObjParam.spousePlaidCredential_userIdTextBox), portalParam.plaidUsername);
			enterText(driver, getLocator(uiObjParam.spousePlaidCredential_passwordTextBox), portalParam.plaidPassword);
			clickButton(driver, getLocator(uiObjParam.spousePlaidCredential_verifyElectronicallyButton),
					"Verify Electronically");
			verifyAutomatedAssetsAdded(portalParam.spouceFirstName);*/

		}
	}

	private void verifyAutomatedAssetsAdded(String user) throws Exception {
		if ((portalParam.spouceFirstName).contains(user)) {
			assertTrue(driver.findElement(By.xpath(
					"//div[@class='bank-statements clearfix style-scope assets-lists-manual']//ul[3]//li[1]//img[1]"))
					.getAttribute("alt").contains(portalParam.borrowerBank), "Automated Assets not added");
			Thread.sleep(5000);
			clickButton(driver, getLocator(uiObjParam.assetSumamryPage_iAmDoneButton), "I'M all done");
		} else if ((portalParam.spouceFirstName).contains(user)) {
			assertTrue(driver.findElement(By.xpath(
					"//div[@class='bank-statements clearfix style-scope assets-lists-manual']//ul[3]//li[1]//img[1]"))
					.getAttribute("alt").contains(portalParam.borrowerBank), "Automated Assets not added");
			Thread.sleep(5000);
			clickButton(driver, getLocator(uiObjParam.spouseAssetSummaryPage_iAmDoneButton), "I'M all done");
		}
	}

	private void addAutomatedAssets(String user) throws Exception {
		if ((portalParam.borrowerFirstname).contains(user)) {
			clickButton(driver, getLocator(uiObjParam.assetSumamryPage_addAccountButton), "Add automated bank");
			WebElement institution = null;
			switch (portalParam.borrowerBank) {
			case "Chase": {
				institution = driver.findElement(By.xpath(
						"//div[contains(@class,'bank-grid-container clearfix style-scope assets-grid')]//div[3]//img[1]"));
				break;
			}

			case "Bank Of America": {
				institution = driver.findElement(By.xpath(
						"//div[contains(@class,'bank-grid-container clearfix style-scope assets-grid')]//div[1]//img[1]"));
				break;
			}
			}

			// portalParam.borrowerBank
			institution.click();

		} else if ((portalParam.spouceFirstName).contains(user)) {
			clickButton(driver, getLocator(uiObjParam.spouseAssetSummaryPage_addAccountButton), "Add automated bank");
			for (int i = 2; i <= 9; i++) {
				WebElement institution = driver.findElement(
						By.xpath("//div[contains(@class,'bank-grid-container clearfix style-scope assets-grid')]//div["
								+ i + "]//img[1]"));
				String text = institution.getText();
				if (text.equalsIgnoreCase(portalParam.spouseBank)) {
					institution.click();
				}
			}
		}

	}

	private void verifyManualAssetsAdded(String user) {
		if ((portalParam.borrowerFirstname).equalsIgnoreCase(user)) {
			assertTrue(removeSpecialChar(driver
					.findElement(By.xpath(
							"//*[@id='SS1']/questioner-question-set//assets-lists-manual/assets-scene-title/div/h3"))
					.getText())
							.contains(removeSpecialChar(portalParam.borrowerFirstname
									+ ", below are the financial institutions you have provided with your application.")),
					"Page title does not contain expected text.");
			assertTrue(driver
					.findElement(By
							.xpath("//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[1]//li[2]/div[1]"))
					.getText().contains("Remove"), "Remove label is not seen");
			assertTrue(driver
					.findElement(By
							.xpath("//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[1]//li[2]/div[2]"))
					.getText().contains("Owner"), "Owner label is not seen");
			assertTrue(driver
					.findElement(By
							.xpath("//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[1]//li[2]/div[3]"))
					.getText().contains("Account#"), "Account# label is not seen");
			assertTrue(driver
					.findElement(By
							.xpath("//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[1]//li[2]/div[4]"))
					.getText().contains("Type"), "Type label is not seen");
			assertTrue(driver
					.findElement(By
							.xpath("//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[1]//li[2]/div[5]"))
					.getText().contains("Total"), "Total label is not seen");
			assertTrue(driver
					.findElement(By
							.xpath("//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[1]//li[2]/div[5]"))
					.getText().contains("Total"), "Total label is not seen");
			assertTrue(driver
					.findElement(By.xpath("//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[2]//li[2]"))
					.getText().contains(portalParam.institutionName), "Manual bank name is not seen");
			assertTrue(driver
					.findElement(By.xpath(
							"//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[2]//li[3]/div[1]/div[2]"))
					.getText().contains(portalParam.borrowerFirstname), "Account holder name does not match");
			assertTrue(driver
					.findElement(By.xpath(
							"//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[2]//li[3]/div[1]/div[3]"))
					.getText().contains(portalParam.accountNumber), "Account number does not match");
			assertTrue(driver
					.findElement(By.xpath(
							"//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[2]//li[3]/div[1]/div[4]"))
					.getText().contains(portalParam.accountType), "Account type does not match");
			assertTrue(removeSpecialChar(driver
					.findElement(By.xpath(
							"//*[@id='SS1']/questioner-question-set//assets-lists-manual//ul[2]//li[3]/div[1]/div[5]"))
					.getText()).contains(portalParam.currentBalance), "current balance does not match");
		} else if ((portalParam.spouceFirstName).equalsIgnoreCase(user)) {
			
		}
	}

}
