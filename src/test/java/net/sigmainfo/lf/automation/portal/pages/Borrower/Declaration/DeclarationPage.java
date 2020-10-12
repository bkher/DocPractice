package net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.clickButton;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.enterText;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.removeSpecialChar;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sigmainfo.lf.automation.portal.function.PortalFuncUtils;
import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerAlimondyChildSupportPage;

public class DeclarationPage extends AbstractTests {

	private static Logger logger = LoggerFactory.getLogger(DeclarationPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public DeclarationPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			Thread.sleep(8000);
			logger.info("=========== DeclarationPage is loaded============");
		} catch (Exception e) {
			throw new Exception("DeclarationPage could not be loaded within time");
		}
	}

	public void submitDeclaration() throws Exception {

		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.declaration_PageLabel)).getText())
						.contains(removeSpecialChar(
								portalParam.borrowerFirstname + ", please review the list of declarations below.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please review the list of declarations below.");

		DesicionMaker(PortalParam.Judgments, uiObjParam.declaration_JudgmentsYes,
				uiObjParam.declaration_JudgmentsCommentBox, PortalParam.JudgmentsComments,
				uiObjParam.declaration_JudgmentsNo);

		DesicionMaker(PortalParam.Bankrupt, uiObjParam.declaration_BankruptYes,
				uiObjParam.declaration_BankruptCommentBox, PortalParam.BankruptComments,
				uiObjParam.declaration_BankruptNo);

		DesicionMaker(PortalParam.ForeClosure, uiObjParam.declaration_ForeClosureYes,
				uiObjParam.declaration_ForeClosureCommentBox, PortalParam.ForeClosureComments,
				uiObjParam.declaration_ForeClosureNo);

		DesicionMaker(PortalParam.LawSuiteProperty, uiObjParam.declaration_LawSuitePropertyYes,
				uiObjParam.declaration_LawSuitePropertyCommentBox, PortalParam.LawSuitePropertyComments,
				uiObjParam.declaration_LawSuitePropertyNo);

		DesicionMaker(PortalParam.ObligatedProperty, uiObjParam.declaration_ObligatedPropertyYes,
				uiObjParam.declaration_ObligatedPropertyCommentBox, PortalParam.ObligatedPropertyComments,
				uiObjParam.declaration_ObligatedPropertyNo);

		DesicionMaker(PortalParam.Deliquent, uiObjParam.declaration_DeliquentYes,
				uiObjParam.declaration_DeliquentCommentBox, PortalParam.DeliquentComments,
				uiObjParam.declaration_DeliquentNo);

		DesicionMaker(PortalParam.ObligatedAlimony, uiObjParam.declaration_ObligatedAlimonyYes,
				uiObjParam.declaration_ObligatedAlimonyCommentBox, PortalParam.ObligatedAlimonyComments,
				uiObjParam.declaration_ObligatedAlimonyNo);

		DesicionMaker(PortalParam.DownPaymentBorrowed, uiObjParam.declaration_DownPaymentBorrowedYes,
				uiObjParam.declaration_DownPaymentBorrowedCommentBox, PortalParam.DownPaymentBorrowedComments,
				uiObjParam.declaration_DownPaymentBorrowedNo);

		DesicionMaker(PortalParam.CoMaker, uiObjParam.declaration_CoMakerYes, uiObjParam.declaration_CoMakerCommentBox,
				PortalParam.CoMakerComments, uiObjParam.declaration_CoMakerNo);

		DesicionMaker(PortalParam.USCitizen, uiObjParam.declaration_USCitizenYes, uiObjParam.declaration_USCitizenNo);

		DesicionMaker(PortalParam.ResidentAlien, uiObjParam.declaration_ResidentAlienYes,
				uiObjParam.declaration_ResidentAlienNo);

		DesicionMaker(PortalParam.PrimaryResidence, uiObjParam.declaration_PrimaryResidenceYes,
				uiObjParam.declaration_PrimaryResidenceNo);

		DesicionMaker(PortalParam.Ownership, uiObjParam.declaration_OwnershipYes, uiObjParam.declaration_OwnershipNo);

		selectValue(getLocator(uiObjParam.declaration_OwnershipTypeOfPropertyDropDown),
				PortalParam.OwnershipTypeOfProperty);

		selectValue(getLocator(uiObjParam.declaration_OwnershipTitleToHomeDropDown), PortalParam.OwnershipTitleToHome);

		if (portalParam.CoborSpouseDeclaration == 0) {
			scrollToBottomOfThePage(driver);
			clickButton(driver, getLocator(uiObjParam.declaration_Ethinicity),
					"I do not wish to provide this information");

			if (portalParam.SpouseAsCoBorrower == 1) {

				Thread.sleep(5000);
				driver.findElement(By.cssSelector("#C-70")).click();
				clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
				clickButton(driver, getLocator(uiObjParam.SpouseAddeddeclaration_next), "Next");
			} else {
				Thread.sleep(5000);
				clickButton(driver, getLocator(uiObjParam.declaration_race), "White");
				clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
				clickButton(driver, getLocator(uiObjParam.declaration_next), "Next");
			}
		} else {
			scrollToBottomOfThePage(driver);
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[1]/questioner-question-set[1]/div[29]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-check-box[1]/div[1]/label[1]"))
					.click();
		
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[1]/questioner-question-set[1]/div[31]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-check-box[1]/div[1]/label[1]"))
					.click();
			clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
			clickButton(driver, getLocator(uiObjParam.SpouseAddeddeclaration_next), "Next");

		}

	}

	public void submitDeclaration_SpouseProvideHisSpouseDeclaration() throws Exception {

		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.declaration_PageLabel)).getText())
						.contains(removeSpecialChar("Please review the list of declarations for "
								+ portalParam.borrowerFirstname + " below.")),
				"Page title does not contain " + portalParam.borrowerFirstname
						+ ", please review the list of declarations below.");

		DesicionMaker(PortalParam.Judgments, uiObjParam.declaration_JudgmentsYes,
				uiObjParam.declaration_JudgmentsCommentBox, PortalParam.JudgmentsComments,
				uiObjParam.declaration_JudgmentsNo);

		DesicionMaker(PortalParam.Bankrupt, uiObjParam.declaration_BankruptYes,
				uiObjParam.declaration_BankruptCommentBox, PortalParam.BankruptComments,
				uiObjParam.declaration_BankruptNo);

		DesicionMaker(PortalParam.ForeClosure, uiObjParam.declaration_ForeClosureYes,
				uiObjParam.declaration_ForeClosureCommentBox, PortalParam.ForeClosureComments,
				uiObjParam.declaration_ForeClosureNo);

		DesicionMaker(PortalParam.LawSuiteProperty, uiObjParam.declaration_LawSuitePropertyYes,
				uiObjParam.declaration_LawSuitePropertyCommentBox, PortalParam.LawSuitePropertyComments,
				uiObjParam.declaration_LawSuitePropertyNo);

		DesicionMaker(PortalParam.ObligatedProperty, uiObjParam.declaration_ObligatedPropertyYes,
				uiObjParam.declaration_ObligatedPropertyCommentBox, PortalParam.ObligatedPropertyComments,
				uiObjParam.declaration_ObligatedPropertyNo);

		DesicionMaker(PortalParam.Deliquent, uiObjParam.declaration_DeliquentYes,
				uiObjParam.declaration_DeliquentCommentBox, PortalParam.DeliquentComments,
				uiObjParam.declaration_DeliquentNo);

		DesicionMaker(PortalParam.ObligatedAlimony, uiObjParam.declaration_ObligatedAlimonyYes,
				uiObjParam.declaration_ObligatedAlimonyCommentBox, PortalParam.ObligatedAlimonyComments,
				uiObjParam.declaration_ObligatedAlimonyNo);

		DesicionMaker(PortalParam.DownPaymentBorrowed, uiObjParam.declaration_DownPaymentBorrowedYes,
				uiObjParam.declaration_DownPaymentBorrowedCommentBox, PortalParam.DownPaymentBorrowedComments,
				uiObjParam.declaration_DownPaymentBorrowedNo);

		DesicionMaker(PortalParam.CoMaker, uiObjParam.declaration_CoMakerYes, uiObjParam.declaration_CoMakerCommentBox,
				PortalParam.CoMakerComments, uiObjParam.declaration_CoMakerNo);

		DesicionMaker(PortalParam.USCitizen, uiObjParam.declaration_USCitizenYes, uiObjParam.declaration_USCitizenNo);

		DesicionMaker(PortalParam.ResidentAlien, uiObjParam.declaration_ResidentAlienYes,
				uiObjParam.declaration_ResidentAlienNo);

		DesicionMaker(PortalParam.PrimaryResidence, uiObjParam.declaration_PrimaryResidenceYes,
				uiObjParam.declaration_PrimaryResidenceNo);

		DesicionMaker(PortalParam.Ownership, uiObjParam.declaration_OwnershipYes, uiObjParam.declaration_OwnershipNo);

		selectValue(getLocator(uiObjParam.declaration_OwnershipTypeOfPropertyDropDown),
				PortalParam.OwnershipTypeOfProperty);

		selectValue(getLocator(uiObjParam.declaration_OwnershipTitleToHomeDropDown), PortalParam.OwnershipTitleToHome);

		scrollToBottomOfThePage(driver);
		clickButton(driver, getLocator(uiObjParam.declaration_Ethinicity), "I do not wish to provide this information");

		if (portalParam.SpouseAsCoBorrower == 1) {

			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#C-70")).click();
			clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
			clickButton(driver, getLocator(uiObjParam.SpouseAddeddeclaration_next), "Next");
		} else {
			Thread.sleep(5000);
			clickButton(driver, getLocator(uiObjParam.declaration_race), "White");
			clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
			clickButton(driver, getLocator(uiObjParam.declaration_next), "Next");
		}

	}

	public void submitDeclaration_Spouse() throws Exception {

		String Test = driver.findElement(By.xpath(
				"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]"))
				.getAttribute("id");
		PortalParam.DeclartionSectionsId = "//div[@id='" + Test + "']";
		logger.info("Dynamic Declartion ID.." + PortalParam.DeclartionSectionsId);
		portalParam.SpouseDeclarion = 1;
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.declaration_PageLabel)).getText())
						.contains(removeSpecialChar("Please review the list of declarations for "
								+ portalParam.spouceFirstName + " below.")),
				"Page title does not contain Please review the list of declarations for below.");
		DesicionMaker(PortalParam.Judgments, uiObjParam.declaration_JudgmentsYes,
				uiObjParam.declaration_JudgmentsCommentBox, PortalParam.JudgmentsComments,
				uiObjParam.declaration_JudgmentsNo);

		DesicionMaker(PortalParam.Bankrupt, uiObjParam.declaration_BankruptYes,
				uiObjParam.declaration_BankruptCommentBox, PortalParam.BankruptComments,
				uiObjParam.declaration_BankruptNo);

		DesicionMaker(PortalParam.ForeClosure, uiObjParam.declaration_ForeClosureYes,
				uiObjParam.declaration_ForeClosureCommentBox, PortalParam.ForeClosureComments,
				uiObjParam.declaration_ForeClosureNo);

		DesicionMaker(PortalParam.LawSuiteProperty, uiObjParam.declaration_LawSuitePropertyYes,
				uiObjParam.declaration_LawSuitePropertyCommentBox, PortalParam.LawSuitePropertyComments,
				uiObjParam.declaration_LawSuitePropertyNo);

		DesicionMaker(PortalParam.ObligatedProperty, uiObjParam.declaration_ObligatedPropertyYes,
				uiObjParam.declaration_ObligatedPropertyCommentBox, PortalParam.ObligatedPropertyComments,
				uiObjParam.declaration_ObligatedPropertyNo);

		DesicionMaker(PortalParam.Deliquent, uiObjParam.declaration_DeliquentYes,
				uiObjParam.declaration_DeliquentCommentBox, PortalParam.DeliquentComments,
				uiObjParam.declaration_DeliquentNo);

		DesicionMaker(PortalParam.ObligatedAlimony, uiObjParam.declaration_ObligatedAlimonyYes,
				uiObjParam.declaration_ObligatedAlimonyCommentBox, PortalParam.ObligatedAlimonyComments,
				uiObjParam.declaration_ObligatedAlimonyNo);

		DesicionMaker(PortalParam.DownPaymentBorrowed, uiObjParam.declaration_DownPaymentBorrowedYes,
				uiObjParam.declaration_DownPaymentBorrowedCommentBox, PortalParam.DownPaymentBorrowedComments,
				uiObjParam.declaration_DownPaymentBorrowedNo);

		DesicionMaker(PortalParam.CoMaker, uiObjParam.declaration_CoMakerYes, uiObjParam.declaration_CoMakerCommentBox,
				PortalParam.CoMakerComments, uiObjParam.declaration_CoMakerNo);

		DesicionMaker(PortalParam.USCitizen, uiObjParam.declaration_USCitizenYes, uiObjParam.declaration_USCitizenNo);

		DesicionMaker(PortalParam.ResidentAlien, uiObjParam.declaration_ResidentAlienYes,
				uiObjParam.declaration_ResidentAlienNo);

		DesicionMaker(PortalParam.PrimaryResidence, uiObjParam.declaration_PrimaryResidenceYes,
				uiObjParam.declaration_PrimaryResidenceNo);

		DesicionMaker(PortalParam.Ownership, uiObjParam.declaration_OwnershipYes, uiObjParam.declaration_OwnershipNo);

		selectValue_SpouseOwnerShipproperty(getLocator(uiObjParam.declaration_OwnershipTypeOfPropertyDropDown),
				PortalParam.OwnershipTypeOfProperty);

		selectValue_SpouseOwnershipHomeType(getLocator(uiObjParam.declaration_OwnershipTitleToHomeDropDown),
				PortalParam.OwnershipTitleToHome);

		if (portalParam.CoborSpouseDeclaration == 0) {
			scrollToBottomOfThePage(driver);
			clickButton(driver, getLocator(uiObjParam.declaration_Ethinicity),
					"I do not wish to provide this information");

			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#C-1070")).click();
			clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
			portalParam.SpouseDeclarion = 0;
			clickButton(driver, getLocator(uiObjParam.declaration_next), "Next");
		} else {
			
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]/questioner-question-set[1]/div[29]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-check-box[1]/div[1]/input[1]"))
					.click();
			scrollToBottomOfThePage(driver);
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]/questioner-question-set[1]/div[31]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-check-box[1]/div[1]/input[1]"))
					.click();
			clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
			portalParam.SpouseDeclarion = 0;
			clickButton(driver, getLocator(uiObjParam.declaration_next), "Next");
		}

	}

	public void submitDeclaration_SpouseProvideHisDeclration() throws Exception {

		String Test = driver.findElement(By.xpath(
				"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]"))
				.getAttribute("id");
		PortalParam.DeclartionSectionsId = "//div[@id='" + Test + "']";
		logger.info("Dynamic Declartion ID.." + PortalParam.DeclartionSectionsId);
		portalParam.SpouseDeclarion = 1;
		assertTrue(
				removeSpecialChar(driver.findElement(getLocator(uiObjParam.declaration_PageLabel)).getText())
						.contains(removeSpecialChar(
								portalParam.spouceFirstName + ", please review the list of declarations below.")),
				"Page title does not contain Please review the list of declarations for below.");
		DesicionMaker(PortalParam.Judgments, uiObjParam.declaration_JudgmentsYes,
				uiObjParam.declaration_JudgmentsCommentBox, PortalParam.JudgmentsComments,
				uiObjParam.declaration_JudgmentsNo);

		DesicionMaker(PortalParam.Bankrupt, uiObjParam.declaration_BankruptYes,
				uiObjParam.declaration_BankruptCommentBox, PortalParam.BankruptComments,
				uiObjParam.declaration_BankruptNo);

		DesicionMaker(PortalParam.ForeClosure, uiObjParam.declaration_ForeClosureYes,
				uiObjParam.declaration_ForeClosureCommentBox, PortalParam.ForeClosureComments,
				uiObjParam.declaration_ForeClosureNo);

		DesicionMaker(PortalParam.LawSuiteProperty, uiObjParam.declaration_LawSuitePropertyYes,
				uiObjParam.declaration_LawSuitePropertyCommentBox, PortalParam.LawSuitePropertyComments,
				uiObjParam.declaration_LawSuitePropertyNo);

		DesicionMaker(PortalParam.ObligatedProperty, uiObjParam.declaration_ObligatedPropertyYes,
				uiObjParam.declaration_ObligatedPropertyCommentBox, PortalParam.ObligatedPropertyComments,
				uiObjParam.declaration_ObligatedPropertyNo);

		DesicionMaker(PortalParam.Deliquent, uiObjParam.declaration_DeliquentYes,
				uiObjParam.declaration_DeliquentCommentBox, PortalParam.DeliquentComments,
				uiObjParam.declaration_DeliquentNo);

		DesicionMaker(PortalParam.ObligatedAlimony, uiObjParam.declaration_ObligatedAlimonyYes,
				uiObjParam.declaration_ObligatedAlimonyCommentBox, PortalParam.ObligatedAlimonyComments,
				uiObjParam.declaration_ObligatedAlimonyNo);

		DesicionMaker(PortalParam.DownPaymentBorrowed, uiObjParam.declaration_DownPaymentBorrowedYes,
				uiObjParam.declaration_DownPaymentBorrowedCommentBox, PortalParam.DownPaymentBorrowedComments,
				uiObjParam.declaration_DownPaymentBorrowedNo);

		DesicionMaker(PortalParam.CoMaker, uiObjParam.declaration_CoMakerYes, uiObjParam.declaration_CoMakerCommentBox,
				PortalParam.CoMakerComments, uiObjParam.declaration_CoMakerNo);

		DesicionMaker(PortalParam.USCitizen, uiObjParam.declaration_USCitizenYes, uiObjParam.declaration_USCitizenNo);

		DesicionMaker(PortalParam.ResidentAlien, uiObjParam.declaration_ResidentAlienYes,
				uiObjParam.declaration_ResidentAlienNo);

		DesicionMaker(PortalParam.PrimaryResidence, uiObjParam.declaration_PrimaryResidenceYes,
				uiObjParam.declaration_PrimaryResidenceNo);

		DesicionMaker(PortalParam.Ownership, uiObjParam.declaration_OwnershipYes, uiObjParam.declaration_OwnershipNo);

		selectValue_SpouseOwnerShipproperty(getLocator(uiObjParam.declaration_OwnershipTypeOfPropertyDropDown),
				PortalParam.OwnershipTypeOfProperty);

		selectValue_SpouseOwnershipHomeType(getLocator(uiObjParam.declaration_OwnershipTitleToHomeDropDown),
				PortalParam.OwnershipTitleToHome);

		
		if (portalParam.CoborSpouseDeclaration == 0) {
			scrollToBottomOfThePage(driver);
			clickButton(driver, getLocator(uiObjParam.declaration_Ethinicity), "I do not wish to provide this information");

			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#C-1070")).click();
			clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
			portalParam.SpouseDeclarion = 0;
			clickButton(driver, getLocator(uiObjParam.declaration_next), "Next");
		} else {
			scrollToBottomOfThePage(driver);
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]/questioner-question-set[1]/div[29]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-check-box[1]/div[1]/input[1]"))
					.click();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]/questioner-question-set[1]/div[31]/div[2]/questioner-question[1]/ui-container[1]/div[1]/ui-check-box[1]/div[1]/input[1]"))
					.click();
			clickButton(driver, getLocator(uiObjParam.declaration_Male), "Male");
			portalParam.SpouseDeclarion = 0;
			clickButton(driver, getLocator(uiObjParam.declaration_next), "Next");
		}

	}

	public static void scrollToBottomOfThePage(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,250)", "");
	}

	public void DesicionMaker(int Check, String Yes, String CommentBox, String Comment, String No) throws Exception {
		if (Check == 1) {
			clickButton(driver, getLocator(Yes), "Yes");
			Thread.sleep(2000);
			enterText(driver, getLocator(CommentBox), Comment);
		} else {
			clickButton(driver, getLocator(No), "No");
		}
	}

	public void DesicionMaker(int Check, String Yes, String No) throws Exception {
		if (Check == 1) {
			clickButton(driver, getLocator(Yes), "Yes");
		} else {
			clickButton(driver, getLocator(No), "No");
		}
	}

	private void selectValue_SpouseOwnerShipproperty(By locator, String value) throws Exception {

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]/questioner-question-set[1]/div[25]/div[3]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]"))
				.click();

	}

	private void selectValue_SpouseOwnershipHomeType(By locator, String value) throws Exception {

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/platform-shell[1]/div[1]/borrower-private-layout[1]/div[1]/micro-app[1]/div[1]/questioner-sections[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ui-form[1]/right-content-area[1]/div[1]/div[1]/sub-sections[1]/div[2]/questioner-question-set[1]/div[26]/div[3]/questioner-question[1]/ui-container[1]/div[1]/ui-options[1]/div[1]/div[1]/ul[1]/li[2]/span[1]"))
				.click();

	}

	private void selectValue(By locator, String value) throws Exception {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).isDisplayed(),
					value + " is not displayed.");
			if (driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
