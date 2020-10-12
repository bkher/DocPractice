package net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.RealEstatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractCollection;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 25-04-2018.
 */
public class AssetsPage extends AbstractTests {
	private Logger logger = LoggerFactory.getLogger(AssetsPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public AssetsPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			if (portalParam.ClientName.contains("NAF")) {
				waitForTextToBePresent(driver, getLocator(uiObjParam.assetsPage_pageLabel),
						", next we’ll take a look at your savings and investments.");
				// assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.assetsPage_enterManuallyButton)));
			}
			if (portalParam.ClientName.contains("OC")) {
				assertTrue(waitForElementToBeClickable(getLocator(uiObjParam.assetsPage_enterManuallyButton)));
			}
			logger.info("=========== AssetsPage is loaded============");
		} catch (Exception e) {
			throw new Exception("AssetsPage could not be loaded within time");
		}
	}

	public AssetsPage() {
	}

	public void enterAssets() throws Exception {
		if (portalParam.ClientName.contains("NAF")) {
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
			clickButton(driver, getLocator(uiObjParam.savingAndInvestmentPage_enterButton), "Enter");
			Thread.sleep(5000);
			clickButton(driver, getLocator(uiObjParam.assetSumamryPage_iAmDoneButton), "I'M all done");
		}
		if (portalParam.ClientName.contains("OC")) {

			clickButton(driver, getLocator(uiObjParam.assetsPage_enterManuallyButton), "Enter Manually");
			Thread.sleep(5000);
			assertTrue(
					removeSpecialChar(driver.findElement(getLocator(uiObjParam.assetsPage_pageLabel)).getText())
							.contains("Nextwelltakealookatyoursavingsandinvestments"),
							
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
			clickButton(driver, getLocator(uiObjParam.savingAndInvestmentPage_enterButton), "Enter");
			Thread.sleep(8000);
			clickButton(driver, getLocator(uiObjParam.assetSumamryPage_iAmDoneButton), "I'M all done");
		
		/*	verifyManualAssetsAdded(portalParam.borrowerFirstname);
			addAutomatedAssets(portalParam.borrowerFirstname);
			assertTrue(removeSpecialChar(driver.findElement(By.xpath(
					"//h3[contains(text(),'Shaishav, please enter login details to sync your ')]"))
					.getText()).contains(
							portalParam.borrowerFirstname + "pleaseenterlogindetailstosyncyouraccountswiththesystem"),
					"Page title does not match expected text");
			enterText(driver, getLocator(uiObjParam.plaidCredential_userIdTextBox), portalParam.plaidUsername);
			enterText(driver, getLocator(uiObjParam.plaidCredential_passwordTextBox), portalParam.plaidPassword);
			clickButton(driver, getLocator(uiObjParam.plaidCredential_verifyElectronicallyButton),
					"Verify Electronically");
			verifyAutomatedAssetsAdded(portalParam.borrowerFirstname);*/

		}

	}

	private void verifyAutomatedAssetsAdded(String user) throws Exception {
		if ((portalParam.borrowerFirstname).contains(user)) {
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
			assertTrue(removeSpecialChar(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual/assets-scene-title//h3"))
					.getText())
							.contains(removeSpecialChar(portalParam.spouceFirstName
									+ ", below are the financial institutions you have synced with your application.")),
					"Page title does not contain expected text.");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[1]//li[2]/div[1]"))
					.getText().contains("Remove"), "Remove label is not seen");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[1]//li[2]/div[2]"))
					.getText().contains("Owner"), "Owner label is not seen");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[1]//li[2]/div[3]"))
					.getText().contains("Account#"), "Account# label is not seen");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[1]//li[2]/div[4]"))
					.getText().contains("Type"), "Type label is not seen");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[1]//li[2]/div[5]"))
					.getText().contains("Total"), "Total label is not seen");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[1]//li[2]/div[5]"))
					.getText().contains("Total"), "Total label is not seen");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[2]//li[2]"))
					.getText().contains(portalParam.spouseInstitutionName), "Manual bank name is not seen");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[2]//li[3]/div[1]/div[2]"))
					.getText().contains(portalParam.spouceFirstName), "Account holder name does not match");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[2]//li[3]/div[1]/div[3]"))
					.getText().contains(portalParam.spouseAccountNumber), "Account number does not match");
			assertTrue(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[2]//li[3]/div[1]/div[4]"))
					.getText().contains(portalParam.spouseAccountType), "Account type does not match");
			assertTrue(removeSpecialChar(driver.findElement(By.xpath(
					"//div[starts-with(@id,'sigma_shaishav')]//questioner-question-set//questioner-question//assets-lists-manual//ul[2]//li[3]/div[1]/div[5]"))
					.getText()).contains(portalParam.spouseCurrentBalance), "current balance does not match");
		}
	}
}
