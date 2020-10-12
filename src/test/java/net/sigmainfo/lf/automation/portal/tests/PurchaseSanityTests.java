package net.sigmainfo.lf.automation.portal.tests;

import org.json.JSONException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import net.sigmainfo.lf.automation.api.function.ApiFuncUtils;
import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.common.Recorder;
import net.sigmainfo.lf.automation.common.TestResults;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.pages.Affinity.AffinityPartnerCompanyProfilePage;
import net.sigmainfo.lf.automation.portal.pages.Affinity.AffinityPartnerGetStartedPage;
import net.sigmainfo.lf.automation.portal.pages.Affinity.AffinityPartnerInviteBorrowerPage;
import net.sigmainfo.lf.automation.portal.pages.Affinity.AffinityPartnerInvitePage;
import net.sigmainfo.lf.automation.portal.pages.Affinity.AffinityPartnerPersonalProfilePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.GetStartedPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.LoginPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Logout;
import net.sigmainfo.lf.automation.portal.pages.Borrower.SignUpPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.WelcomePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.WelcomeSignupPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.WelcomeVideoPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetCompletedPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.AssetsPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection.SpouseAssestPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Dashboard.Dashboard;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Dashboard.WelcometoDashboardPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration.DeclarationCompletePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Declaration.DeclarationPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerAlimondyChildSupportPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerEmploymentPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerIncomeDetailsPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerInterestDividendPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerMilitaryPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerOtherIncomePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerRentalIncomePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerSelfEmploymentIncomePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerSocialSecurityIncomePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.BorrowerSupportPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.IncomeCompletedPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection.IncomeSearchPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.BankruptcyStatementPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.COEFormPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.CertificateOfReleasePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.ChildSupportPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.ClosingStatementPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.DevorceDecreePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.FederalTaxReturnPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.PayStubPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.PercentageOwnerShipPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.PersonalTaxReturnsPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.PurchaseAndSalePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.RecentK1sPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.RecentTwoBankStatement;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.RecentW2Page;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.SocialSecurityAwardPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.SupplyOfStatementPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.PostApplication.YTDPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.AddCoApplicantsPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.BorrowerCommunicationPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.CoborrowerMaritalPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.CurrentResidenceDetailsPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.LoanAmountPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.LoanOfficer;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.PrimaryBorrowerPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.ProfileCompletedPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.PurchasePropertyDetailsPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.RealEstateAgentPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.RealEstatePage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.TellAboutYourselfPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.VAorMilitaryLoanPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.ProfileSection.WhosOnLoanPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Summary.SummaryCompletedPage;
import net.sigmainfo.lf.automation.portal.pages.Borrower.Summary.SummaryPage;
import net.sigmainfo.lf.automation.portal.pages.Lender.LenderLoginPage;
import net.sigmainfo.lf.automation.portal.pages.Lender.LenderPipeLinePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 30-04-2018.
 */


public class PurchaseSanityTests extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(PurchaseSanityTests.class);
	public static String funcMod = "Purchase";

	public static Recorder recorder = new Recorder();

	@Autowired
	TestResults testResults;

	@Autowired
	ApiFuncUtils apiFuncUtils;

	public PurchaseSanityTests() {
	}

	@AfterClass(alwaysRun = true)
	public void endCasereport() throws IOException, JSONException {

		String funcModule = "Purchase";
		String className = org.apache.commons.lang.StringUtils.substringAfterLast(this.getClass().getName(), ".");
		String description = "Verify  "
				+ org.apache.commons.lang.StringUtils.substringAfterLast(this.getClass().getName(), ".");
		generateReport(className, description, funcModule);
	}

	/**
	 * TestName : verifyEndToEndFlow Description : This test case checks health
	 * check of actual functionality Owner : REngarajan
	 *
	 */

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "LenderBorrowerNonSpouseAddedCoborrowerFlow" })
	public void LenderBorrowerNonSpouseAddedCoborrowerFlow() throws Exception {
		String sTestID = "LenderBorrowerNonSpouseAddedCoborrowerFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);

			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  

			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		}

		finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "DirectSignupBorrowerCoborrowerFlow" })
	public void DirectSignupBorrowerCoborrowerFlow() throws Exception {
		String sTestID = "DirectSignupBorrowerCoborrowerFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			driver.get(portalParam.borrowerUrl);
			GetStartedPage getStartedPage = new GetStartedPage(driver);
			getStartedPage.signUp();
			SignUpPage signUp = new SignUpPage(driver);
			signUp.directSignup();
			WelcomeSignupPage welcomeSignupPage = new WelcomeSignupPage(driver);
			welcomeSignupPage.getStarted();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.directSignupPersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			LoanOfficer loanofficerPage = new LoanOfficer(driver);
			loanofficerPage.SubmitLoanOfficerDetails(driver);
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		}

		finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "LenderBorrowerIndividualCreditFlow" })
	public void LenderBorrowerIndividualCreditFlow() throws Exception {
		String sTestID = "LenderBorrowerIndividualCreditFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {
			// LenderLenderBorrowerNonSpouseAddedCoborrowerIndividualCreditFlow
			// Flow Starts
			logger.info("BorrowerNonSpouseFlowAddedCoborrowerFlow");
			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectIndividualCredit(driver);
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_Individual();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification_skip();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}

	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "DirectSignupBorrowerIndividualFlow" })
	public void DirectSignupBorrowerIndividualFlow() throws Exception {
		String sTestID = "DirectSignupBorrowerIndividualFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			driver.get(portalParam.borrowerUrl);
			GetStartedPage getStartedPage = new GetStartedPage(driver);
			getStartedPage.signUp();
			SignUpPage signUp = new SignUpPage(driver);
			signUp.directSignup();
			WelcomeSignupPage welcomeSignupPage = new WelcomeSignupPage(driver);
			welcomeSignupPage.getStarted();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.directSignupPersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectIndividualCredit(driver);
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			LoanOfficer loanofficerPage = new LoanOfficer(driver);
			loanofficerPage.SubmitLoanOfficerDetails(driver);
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_Individual();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}

	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "DirectSignUpBorrowerCoborrwerNonSpouseFlow" })
	public void DirectSignUpBorrowerCoborrwerNonSpouseFlow() throws Exception {
		String sTestID = "DirectSignUpBorrowerCoborrwerNonSpouseFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			driver.get(portalParam.borrowerUrl);
			GetStartedPage getStartedPage = new GetStartedPage(driver);
			getStartedPage.signUp();
			SignUpPage signUp = new SignUpPage(driver);
			signUp.directSignup();
			WelcomeSignupPage welcomeSignupPage = new WelcomeSignupPage(driver);
			welcomeSignupPage.getStarted();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.directSignupPersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			LoanOfficer loanofficerPage = new LoanOfficer(driver);
			loanofficerPage.SubmitLoanOfficerDetails(driver);
			Logout logout = new Logout(driver);
			logout.logout();
			portalParam.borrowerUsername = portalParam.nonSpouceUsername;
			portalParam.borrowerFirstname = portalParam.CoborrowerFirstName;
			portalParam.borrowerlastname = portalParam.CoborrowerLastName;
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage1 = new WelcomeVideoPage(driver);
			welcomeVideoPage1.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			TellAboutYourselfPage tellAboutYourselfPage1 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage1.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage1 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage1.provideCommunicationDetails_coborrower(driver);
			CoborrowerMaritalPage coborrowerMaritalPage = new CoborrowerMaritalPage(driver);
			coborrowerMaritalPage.selectApplicants_Married(driver);
			RealEstateAgentPage realEstateAgentPage1 = new RealEstateAgentPage(driver);
			realEstateAgentPage1.enterRealEstateDetails_coborrower();
			LoanOfficer loanofficerPage1 = new LoanOfficer(driver);
			loanofficerPage1.SubmitLoanOfficerDetails_coborrower(driver);
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_coborrower();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails_coborrower();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes_coborrower();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_coborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "DirectSignUpBorrowerCoborrwerUnmarriedFlow" })
	public void DirectSignUpBorrowerCoborrwerUnmarriedFlow() throws Exception {
		String sTestID = "DirectSignUpBorrowerCoborrwerUnmarriedFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			driver.get(portalParam.borrowerUrl);
			GetStartedPage getStartedPage = new GetStartedPage(driver);
			getStartedPage.signUp();
			SignUpPage signUp = new SignUpPage(driver);
			signUp.directSignup();
			WelcomeSignupPage welcomeSignupPage = new WelcomeSignupPage(driver);
			welcomeSignupPage.getStarted();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.directSignupPersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			LoanOfficer loanofficerPage = new LoanOfficer(driver);
			loanofficerPage.SubmitLoanOfficerDetails(driver);
			Logout logout = new Logout(driver);
			logout.logout();
			portalParam.borrowerUsername = portalParam.nonSpouceUsername;
			portalParam.borrowerFirstname = portalParam.CoborrowerFirstName;
			portalParam.borrowerlastname = portalParam.CoborrowerLastName;
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage1 = new WelcomeVideoPage(driver);
			welcomeVideoPage1.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			TellAboutYourselfPage tellAboutYourselfPage1 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage1.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage1 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage1.provideCommunicationDetails_coborrower(driver);
			CoborrowerMaritalPage coborrowerMaritalPage = new CoborrowerMaritalPage(driver);
			coborrowerMaritalPage.selectApplicants_UnMarried(driver);
			RealEstateAgentPage realEstateAgentPage1 = new RealEstateAgentPage(driver);
			realEstateAgentPage1.enterRealEstateDetails_coborrower();
			LoanOfficer loanofficerPage1 = new LoanOfficer(driver);
			loanofficerPage1.SubmitLoanOfficerDetails_coborrower(driver);
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_coborrower();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails_coborrower();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes_coborrower();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_coborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "LenderBorrowerCoborrwerNonSpouseFlow" })
	public void LenderBorrowerCoborrwerNonSpouseFlow() throws Exception {
		String sTestID = "LenderBorrowerCoborrwerNonSpouseFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			Logout logout = new Logout(driver);
			logout.logout();
			portalParam.borrowerUsername = portalParam.nonSpouceUsername;
			portalParam.borrowerFirstname = portalParam.CoborrowerFirstName;
			portalParam.borrowerlastname = portalParam.CoborrowerLastName;
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage1 = new WelcomeVideoPage(driver);
			welcomeVideoPage1.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			TellAboutYourselfPage tellAboutYourselfPage1 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage1.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage1 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage1.provideCommunicationDetails_coborrower(driver);
			CoborrowerMaritalPage coborrowerMaritalPage = new CoborrowerMaritalPage(driver);
			coborrowerMaritalPage.selectApplicants_Married(driver);
			RealEstateAgentPage realEstateAgentPage1 = new RealEstateAgentPage(driver);
			realEstateAgentPage1.enterRealEstateDetails_coborrower();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_coborrower();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails_coborrower();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes_coborrower();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_coborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "LenderBorrowerMarriedSeparatedAddedCoborrowerFlow" })
	public void LenderBorrowerMarriedSeparatedAddedCoborrowerFlow() throws Exception {
		String sTestID = "LenderBorrowerMarriedSeparatedAddedCoborrowerFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectJoint_MarriedSeparated(driver);

			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  

			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_Individual();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		}

		finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "LenderBorrowerCoborrwerMarriedSeparatedFlow" })
	public void LenderBorrowerCoborrwerMarriedSeparatedFlow() throws Exception {
		String sTestID = "LenderBorrowerCoborrwerMarriedSeparatedFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			Logout logout = new Logout(driver);
			logout.logout();
			portalParam.borrowerUsername = portalParam.nonSpouceUsername;
			portalParam.borrowerFirstname = portalParam.CoborrowerFirstName;
			portalParam.borrowerlastname = portalParam.CoborrowerLastName;
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage1 = new WelcomeVideoPage(driver);
			welcomeVideoPage1.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			TellAboutYourselfPage tellAboutYourselfPage1 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage1.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage1 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage1.provideCommunicationDetails_coborrower(driver);
			CoborrowerMaritalPage coborrowerMaritalPage = new CoborrowerMaritalPage(driver);
			coborrowerMaritalPage.selectApplicants_Separated(driver);
			RealEstateAgentPage realEstateAgentPage1 = new RealEstateAgentPage(driver);
			realEstateAgentPage1.enterRealEstateDetails_coborrower();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_coborrower();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails_coborrower();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes_coborrower();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_coborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity",
			"DirectSignUpBorrowerSpouseNoAdditionalCoborrowerFlow" })
	public void DirectSignUpBorrowerSpouseNoAdditionalCoborrowerFlow() throws Exception {
		String sTestID = "DirectSignUpBorrowerSpouseNoAdditionalCoborrowerFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			driver.get(portalParam.borrowerUrl);
			GetStartedPage getStartedPage = new GetStartedPage(driver);
			getStartedPage.signUp();
			SignUpPage signUp = new SignUpPage(driver);
			signUp.directSignup();
			WelcomeSignupPage welcomeSignupPage = new WelcomeSignupPage(driver);
			welcomeSignupPage.getStarted();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.directSignupPersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			LoanOfficer loanofficerPage = new LoanOfficer(driver);
			loanofficerPage.SubmitLoanOfficerDetails(driver);
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeSearchPage incomeSearchPage1 = new IncomeSearchPage(driver);
			incomeSearchPage1.selectIncomeTypes_Spousecoborrower();
			BorrowerEmploymentPage borrowerEmploymentPage1 = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage1.provideEmploymentDetails_Spouse();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage1 = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage1.provideAlimonyDetails_Spouse();
			BorrowerSupportPage borrowerSupportPage1 = new BorrowerSupportPage(driver);
			borrowerSupportPage1.provideSupportDetails_Spouse();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage1 = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage1.provideSelfEmploymentDetails_Spouse();
			BorrowerMilitaryPage borrowerMilitaryPage1 = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage1.provideMilitaryIncomeDetails_spouse();
			BorrowerRentalIncomePage borrowerRentalIncomePage1 = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage1.provideRentalIncomeDetails_Spouse();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage1 = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage1.provideSocialSecurityIncomeDetails_Spouse();
			BorrowerInterestDividendPage borrowerInterestDividendPage1 = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage1.provideInterestDividendIncomeDetails_Spouse();
			BorrowerOtherIncomePage borrowerOtherIncomePage1 = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage1.provideOtherIncomeDetails_Spouse();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationPage declationPage1 = new DeclarationPage(driver);
			declationPage1.submitDeclaration_Spouse();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_SpouseCoborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification_skip();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		}

		finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "LenderBorrowerSpouseAddedCoborrowerFlow" })
	public void LenderBorrowerSpouseAddedCoborrowerFlow() throws Exception {
		String sTestID = "LenderBorrowerSpouseAddedCoborrowerFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);

			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  

			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeSearchPage incomeSearchPage1 = new IncomeSearchPage(driver);
			incomeSearchPage1.selectIncomeTypes_Spousecoborrower();
			BorrowerEmploymentPage borrowerEmploymentPage1 = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage1.provideEmploymentDetails_Spouse();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage1 = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage1.provideAlimonyDetails_Spouse();
			BorrowerSupportPage borrowerSupportPage1 = new BorrowerSupportPage(driver);
			borrowerSupportPage1.provideSupportDetails_Spouse();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage1 = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage1.provideSelfEmploymentDetails_Spouse();
			BorrowerMilitaryPage borrowerMilitaryPage1 = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage1.provideMilitaryIncomeDetails_spouse();
			BorrowerRentalIncomePage borrowerRentalIncomePage1 = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage1.provideRentalIncomeDetails_Spouse();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage1 = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage1.provideSocialSecurityIncomeDetails_Spouse();
			BorrowerInterestDividendPage borrowerInterestDividendPage1 = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage1.provideInterestDividendIncomeDetails_Spouse();
			BorrowerOtherIncomePage borrowerOtherIncomePage1 = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage1.provideOtherIncomeDetails_Spouse();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationPage declationPage1 = new DeclarationPage(driver);
			declationPage1.submitDeclaration_Spouse();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_SpouseCoborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification_skip();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		}

		finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "BorrowerInviteSpouseLoginAndCompleteApplication" })
	public void BorrowerInviteSpouseLoginAndCompleteApplication() throws Exception {
		String sTestID = "BorrowerInviteSpouseLoginAndCompleteApplication";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);

			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  

			Logout logout = new Logout(driver);
			logout.logout();

			driver.get(getBorrowerSignUpURL(portalParam.spouceUsername));

			WelcomeVideoPage welcomeVideoPage1 = new WelcomeVideoPage(driver);
			welcomeVideoPage1.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			TellAboutYourselfPage tellAboutYourselfPage1 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage1.providePersonalDetails_SpouseVerifyHisSpouseDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage1 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage1.provideCommunicationDetails_SpouseVerifyHisSpouseDetails(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage1 = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage1.providePropertyDetails_SpouseVerifyHisSpouseDetails(driver);
			LoanAmountPage loanAmountPage1 = new LoanAmountPage(driver);
			loanAmountPage1.enterLoanDetails_SpouseVerifyHisSpouseDetails(driver);
			TellAboutYourselfPage tellAboutYourselfPage2 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage2.providePersonalDetails_SpouseVerfyHisDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage2 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage2.provideCommunicationDetails_SpouseVerifyHisDetails(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_SpouseEnteringHisDetails();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes_SpouseProvideHisSpouseDetails();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails_SpouseProvideHisSpouseDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails_SpouseProvideHisSpouseDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails_SpouseProvideHisSpouseDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails_SpouseProvideHisSpouseDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails_SpouseProvideHisSpouseDetails();
			IncomeSearchPage incomeSearchPage1 = new IncomeSearchPage(driver);
			incomeSearchPage1.selectIncomeTypes_Spousecoborrower();
			BorrowerEmploymentPage borrowerEmploymentPage1 = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage1.provideEmploymentDetails_SpouseProvideHisDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage1 = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage1.provideAlimonyDetails_SpouseProvideHisDetails();
			BorrowerSupportPage borrowerSupportPage1 = new BorrowerSupportPage(driver);
			borrowerSupportPage1.provideSupportDetails_SpouseProvideHisDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage1 = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage1.provideSelfEmploymentDetails_SpouseProvideHisDetails();
			BorrowerMilitaryPage borrowerMilitaryPage1 = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage1.provideMilitaryIncomeDetails_spouseProvideHisDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage1 = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage1.provideRentalIncomeDetails_SpouseProvideHisDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage1 = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage1.provideSocialSecurityIncomeDetails_SpouseProvideHisDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage1 = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage1.provideInterestDividendIncomeDetails_SpouseProvideHisDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage1 = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage1.provideOtherIncomeDetails_SpouseProvideHisDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration_SpouseProvideHisSpouseDeclaration();
			DeclarationPage declationPage1 = new DeclarationPage(driver);
			declationPage1.submitDeclaration_SpouseProvideHisDeclration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_SpouseCoborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		}

		finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "LenderBorrowerCoborrwerAddedSpouseFlow" })
	public void LenderBorrowerCoborrwerAddedSpouseFlow() throws Exception {
		String sTestID = "LenderBorrowerCoborrwerAddedSpouseFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			Logout logout = new Logout(driver);
			logout.logout();
			portalParam.borrowerUsername = portalParam.nonSpouceUsername;
			portalParam.borrowerFirstname = portalParam.CoborrowerFirstName;
			portalParam.borrowerlastname = portalParam.CoborrowerLastName;
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage1 = new WelcomeVideoPage(driver);
			welcomeVideoPage1.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			TellAboutYourselfPage tellAboutYourselfPage1 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage1.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage1 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage1.provideCommunicationDetails_coborrower(driver);
			CoborrowerMaritalPage coborrowerMaritalPage = new CoborrowerMaritalPage(driver);
			coborrowerMaritalPage.selectApplicants_Married(driver);
			RealEstateAgentPage realEstateAgentPage1 = new RealEstateAgentPage(driver);
			realEstateAgentPage1.enterRealEstateDetails_coborrower();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_coborrowerSpouse();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails_coborrower();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes_coborrower();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeSearchPage incomeSearchPage1 = new IncomeSearchPage(driver);
			incomeSearchPage1.selectIncomeTypes_Spousecoborrower();
			BorrowerEmploymentPage borrowerEmploymentPage1 = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage1.provideEmploymentDetails_Spouse();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage1 = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage1.provideAlimonyDetails_Spouse();
			BorrowerSupportPage borrowerSupportPage1 = new BorrowerSupportPage(driver);
			borrowerSupportPage1.provideSupportDetails_Spouse();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage1 = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage1.provideSelfEmploymentDetails_Spouse();
			BorrowerMilitaryPage borrowerMilitaryPage1 = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage1.provideMilitaryIncomeDetails_spouse();
			BorrowerRentalIncomePage borrowerRentalIncomePage1 = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage1.provideRentalIncomeDetails_Spouse();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage1 = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage1.provideSocialSecurityIncomeDetails_Spouse();
			BorrowerInterestDividendPage borrowerInterestDividendPage1 = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage1.provideInterestDividendIncomeDetails_Spouse();
			BorrowerOtherIncomePage borrowerOtherIncomePage1 = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage1.provideOtherIncomeDetails_Spouse();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			portalParam.CoborSpouseDeclaration = 1;
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationPage declationPage1 = new DeclarationPage(driver);
			declationPage1.submitDeclaration_Spouse();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_SpouseCoborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification_skip();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity", "CoborrwerAddedSpouseLoginCompleteApplication" })
	public void CoborrwerAddedSpouseLoginCompleteApplication() throws Exception {
		String sTestID = "CoborrwerAddedSpouseLoginCompleteApplication";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteBorrower(driver);
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);
			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  
			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			RealEstateAgentPage realEstateAgentPage = new RealEstateAgentPage(driver);
			realEstateAgentPage.enterRealEstateDetails();
			Logout logout = new Logout(driver);
			logout.logout();
			portalParam.borrowerUsername = portalParam.nonSpouceUsername;
			portalParam.borrowerFirstname = portalParam.CoborrowerFirstName;
			portalParam.borrowerlastname = portalParam.CoborrowerLastName;
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage1 = new WelcomeVideoPage(driver);
			welcomeVideoPage1.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			TellAboutYourselfPage tellAboutYourselfPage1 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage1.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage1 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage1.provideCommunicationDetails_coborrower(driver);
			CoborrowerMaritalPage coborrowerMaritalPage = new CoborrowerMaritalPage(driver);
			coborrowerMaritalPage.selectApplicants_Married(driver);
			RealEstateAgentPage realEstateAgentPage1 = new RealEstateAgentPage(driver);
			realEstateAgentPage1.enterRealEstateDetails_coborrower();
			Logout logout1 = new Logout(driver);
			logout1.logout();
			driver.get(getBorrowerSignUpURL(portalParam.CoborrowerSpouseEmail));
			WelcomeVideoPage welcomeVideoPage2 = new WelcomeVideoPage(driver);
			welcomeVideoPage2.navigateSignUpPage_Coborrower(driver);
			SignUpPage signUp2 = new SignUpPage(driver);
			signUp2.signUp();
			TellAboutYourselfPage tellAboutYourselfPage3 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage3.providePersonalDetails_SpouseVerifyHisSpouseDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage3 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage3.provideCommunicationDetails_CobSpouseVerifyHisSpouseDetails(driver);
			TellAboutYourselfPage tellAboutYourselfPage2 = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage2.providePersonalDetails_CobSpouseVerfyHisDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage2 = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage2.provideCommunicationDetails_CobSpouseVerifyHisDetails(driver);
			RealEstateAgentPage realEstateAgentPage3 = new RealEstateAgentPage(driver);
			realEstateAgentPage3.enterRealEstateDetails_coborrower();
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails_coborrowerHisSpouse();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails_coborrower();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes_SpouseLoginSubmitscoborrower();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails_SpouseProvideHisSpouseDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails_SpouseProvideHisSpouseDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails_SpouseProvideHisSpouseDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails_SpouseProvideHisSpouseDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails_SpouseProvideHisSpouseDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails_SpouseProvideHisSpouseDetails();
			IncomeSearchPage incomeSearchPage1 = new IncomeSearchPage(driver);
			incomeSearchPage1.selectIncomeTypes_Spousecoborrower();
			BorrowerEmploymentPage borrowerEmploymentPage1 = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage1.provideEmploymentDetails_SpouseProvideHisDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage1 = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage1.provideAlimonyDetails_SpouseProvideHisDetails();
			BorrowerSupportPage borrowerSupportPage1 = new BorrowerSupportPage(driver);
			borrowerSupportPage1.provideSupportDetails_SpouseProvideHisDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage1 = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage1.provideSelfEmploymentDetails_SpouseProvideHisDetails();
			BorrowerMilitaryPage borrowerMilitaryPage1 = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage1.provideMilitaryIncomeDetails_spouseProvideHisDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage1 = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage1.provideRentalIncomeDetails_SpouseProvideHisDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage1 = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage1.provideSocialSecurityIncomeDetails_SpouseProvideHisDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage1 = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage1.provideInterestDividendIncomeDetails_SpouseProvideHisDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage1 = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage1.provideOtherIncomeDetails_SpouseProvideHisDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration_SpouseProvideHisSpouseDeclaration();
			portalParam.CoborSpouseDeclaration = 1;
			DeclarationPage declationPage1 = new DeclarationPage(driver);
			declationPage1.submitDeclaration_SpouseProvideHisDeclration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary_SpouseCoborrower();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification_skip();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification_skip();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification_skip();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification_skip();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification_skip();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification_skip();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification_skip();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification_skip();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification_skip();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification_skip();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification_skip();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification_skip();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification_skip();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification_skip();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);  
			Thread.sleep(10000);
			result = "Passed";
		} finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}

	@Test(description = "", groups = { "PurchaseTests", "Sanity",
			"LenderAffinityBorrowerNonSpouseAddedCoborrowerFlow" })
	public void LenderAffinityBorrowerNonSpouseAddedCoborrowerFlow() throws Exception {
		String sTestID = "LenderAffinityBorrowerNonSpouseAddedCoborrowerFlow";
		recorder.startRecording(sTestID + "_" + portalParam.loanType);
		String result = "Failed";
		WebDriverWait wait = new WebDriverWait(driver, 180);
		testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
		logger.warn("" + portalParam.Pictures);
		logger.info("******************Begining of TEST CASE: " + sTestID + "*******************");
		initializeData(funcMod, sTestID);
		try {

			PortalParam.AffinityUserName = "Affinity" + portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.AffinityUserName :" + portalParam.AffinityUserName);

			PortalParam.borrowerUsername = portalPropertiesReader.getBorrowerUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.borrowerUsername :" + portalParam.borrowerUsername);
			portalParam.spouceUsername = portalPropertiesReader.getSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.spouceUsername :" + portalParam.spouceUsername);
			portalParam.nonSpouceUsername = portalPropertiesReader.getNonSpouceUsername() + "+"
					+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + "@" + portalParam.ClientName.toLowerCase() + ".com";
			logger.info("portalParam.nonSpouceUsername :" + portalParam.nonSpouceUsername);
			LenderLoginPage lenderLoginPage = new LenderLoginPage(driver);
			lenderLoginPage.loginToLenderPortal(driver);
			LenderPipeLinePage lenderPipelinePage = new LenderPipeLinePage(driver);
			lenderPipelinePage.inviteAffinityPartner(driver);
			Thread.sleep(5000);
			driver.get(getBorrowerSignUpURL(portalParam.AffinityUserName));
			AffinityPartnerGetStartedPage APGetStartedPage = new AffinityPartnerGetStartedPage(driver);
			APGetStartedPage.navigateSignUpPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp();
			AffinityPartnerPersonalProfilePage APPersonalProfilePage = new AffinityPartnerPersonalProfilePage(driver);
			APPersonalProfilePage.SubmitPersonalProfile(driver);
			AffinityPartnerCompanyProfilePage APCompanyProfilePage = new AffinityPartnerCompanyProfilePage(driver);
			APCompanyProfilePage.SubmitCompanyProfile(driver);
			Thread.sleep(5000);
			AffinityPartnerInvitePage APInvitePage = new AffinityPartnerInvitePage(driver);
			APInvitePage.invitePage(driver);
			AffinityPartnerInviteBorrowerPage APInviteBorrowerPage = new AffinityPartnerInviteBorrowerPage(driver);
			APInviteBorrowerPage.inviteBorrower(driver);
			Logout logout = new Logout(driver);
			logout.logout();
			driver.get(getBorrowerSignUpURL(portalParam.borrowerUsername));
			WelcomeVideoPage welcomeVideoPage = new WelcomeVideoPage(driver);
			welcomeVideoPage.navigateSignUpPage_affinitypartner(driver);
			SignUpPage signUp1 = new SignUpPage(driver);
			signUp1.signUp();
			WelcomePage welcomePage = new WelcomePage(driver);
			welcomePage.selectLoanOption(driver);
			TellAboutYourselfPage tellAboutYourselfPage = new TellAboutYourselfPage(driver);
			tellAboutYourselfPage.providePersonalDetails(driver);
			BorrowerCommunicationPage borrowerCommunicationPage = new BorrowerCommunicationPage(driver);
			borrowerCommunicationPage.provideCommunicationDetails_borrower(driver);
			PurchasePropertyDetailsPage purchasePropertyDetailsPage = new PurchasePropertyDetailsPage(driver);
			purchasePropertyDetailsPage.providePropertyDetails(driver);
			LoanAmountPage loanAmountPage = new LoanAmountPage(driver);
			loanAmountPage.enterLoanDetails(driver);
			WhosOnLoanPage whosOnLoanPage = new WhosOnLoanPage(driver);
			whosOnLoanPage.selectApplicants(driver);

			AddCoApplicantsPage addCoApplicantsPage = new AddCoApplicantsPage(driver);
			addCoApplicantsPage.addCoborrowers(driver);
			 
			  

			VAorMilitaryLoanPage vAorMilitaryLoanPage = new VAorMilitaryLoanPage(driver);
			vAorMilitaryLoanPage.MilitaryLoanEligibility(driver);
			CurrentResidenceDetailsPage currentResidenceDetailsPage = new CurrentResidenceDetailsPage(driver);
			currentResidenceDetailsPage.provideCurrentResidentialDetails();
			RealEstatePage realEstatePage = new RealEstatePage(driver);
			realEstatePage.provideRealEstateDetails();
			ProfileCompletedPage profileCompletedPage = new ProfileCompletedPage(driver);
			profileCompletedPage.clickBeginSectionBtn();
			AssetsPage assetPage = new AssetsPage();
			assetPage.enterAssets();
			AssetCompletedPage assetCompletedPage = new AssetCompletedPage(driver);
			assetCompletedPage.navigateToIncome();
			IncomeSearchPage incomeSearchPage = new IncomeSearchPage(driver);
			incomeSearchPage.selectIncomeTypes();
			BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage(driver);
			borrowerEmploymentPage.provideEmploymentDetails();
			BorrowerAlimondyChildSupportPage borrowerAlimondyChildSupportPage = new BorrowerAlimondyChildSupportPage(
					driver);
			borrowerAlimondyChildSupportPage.provideAlimonyDetails();
			BorrowerSupportPage borrowerSupportPage = new BorrowerSupportPage(driver);
			borrowerSupportPage.provideSupportDetails();
			BorrowerSelfEmploymentIncomePage borrowerSelfEmploymentIncomePage = new BorrowerSelfEmploymentIncomePage(
					driver);
			borrowerSelfEmploymentIncomePage.provideSelfEmploymentDetails();
			BorrowerMilitaryPage borrowerMilitaryPage = new BorrowerMilitaryPage(driver);
			borrowerMilitaryPage.provideMilitaryIncomeDetails();
			BorrowerRentalIncomePage borrowerRentalIncomePage = new BorrowerRentalIncomePage(driver);
			borrowerRentalIncomePage.provideRentalIncomeDetails();
			BorrowerSocialSecurityIncomePage borrowerSocialSecurityIncomePage = new BorrowerSocialSecurityIncomePage(
					driver);
			borrowerSocialSecurityIncomePage.provideSocialSecurityIncomeDetails();
			BorrowerInterestDividendPage borrowerInterestDividendPage = new BorrowerInterestDividendPage(driver);
			borrowerInterestDividendPage.provideInterestDividendIncomeDetails();
			BorrowerOtherIncomePage borrowerOtherIncomePage = new BorrowerOtherIncomePage(driver);
			borrowerOtherIncomePage.provideOtherIncomeDetails();
			IncomeCompletedPage incomeCompletedPage = new IncomeCompletedPage(driver);
			incomeCompletedPage.BeginDecalration();
			DeclarationPage declationPage = new DeclarationPage(driver);
			declationPage.submitDeclaration();
			DeclarationCompletePage declarationCompletePage = new DeclarationCompletePage(driver);
			declarationCompletePage.CompleteDeclaration();
			SummaryPage summaryPage = new SummaryPage(driver);
			summaryPage.VerifySummary();
			SummaryCompletedPage summaryCompletedPage = new SummaryCompletedPage(driver);
			summaryCompletedPage.CompleteSummary();
			PersonalTaxReturnsPage personalTaxReturnsPage = new PersonalTaxReturnsPage(driver);
			personalTaxReturnsPage.CompleteVerification();
			FederalTaxReturnPage federalTaxReturnPage = new FederalTaxReturnPage(driver);
			federalTaxReturnPage.CompleteVerification();
			RecentK1sPage recentK1sPage = new RecentK1sPage(driver);
			recentK1sPage.CompleteVerification();
			YTDPage yTDPage = new YTDPage(driver);
			yTDPage.CompleteVerification();
			PercentageOwnerShipPage percentageOwnerShipPage = new PercentageOwnerShipPage(driver);
			percentageOwnerShipPage.CompleteVerification();
			PayStubPage payStubPage = new PayStubPage(driver);
			payStubPage.CompleteVerification();
			RecentW2Page recentW2Page = new RecentW2Page(driver);
			recentW2Page.CompleteVerification();
			RecentTwoBankStatement recentbankstat = new RecentTwoBankStatement(driver);
			recentbankstat.CompleteVerification();
			PurchaseAndSalePage purchaseAndSalePage = new PurchaseAndSalePage(driver);
			purchaseAndSalePage.CompleteVerification();
			ChildSupportPage childSupportPage = new ChildSupportPage(driver);
			childSupportPage.CompleteVerification();
			DevorceDecreePage devorceDecreePage = new DevorceDecreePage(driver);
			devorceDecreePage.CompleteVerification();
			COEFormPage cOEFormPage = new COEFormPage(driver);
			cOEFormPage.CompleteVerification();
			CertificateOfReleasePage certificateOfReleasePage = new CertificateOfReleasePage(driver);
			certificateOfReleasePage.CompleteVerification();
			SupplyOfStatementPage supplyOfStatementPage = new SupplyOfStatementPage(driver);
			supplyOfStatementPage.CompleteVerification();
			SocialSecurityAwardPage socialSecurityAwardPage = new SocialSecurityAwardPage(driver);
			socialSecurityAwardPage.CompleteVerification();
			BankruptcyStatementPage bankruptcyStatementPage = new BankruptcyStatementPage(driver);
			bankruptcyStatementPage.CompleteVerification();
			ClosingStatementPage closingStatementPage = new ClosingStatementPage(driver);
			closingStatementPage.CompleteVerification();
			WelcometoDashboardPage welcometoDashboardPage = new WelcometoDashboardPage(driver);
			welcometoDashboardPage.navigateToDashboard();
			Dashboard dashboard = new Dashboard(driver);
			Thread.sleep(10000);
			result = "Passed";
		}

		finally {
			recorder.stopRecording();
			logger.info("\n*****Execution of testcase: " + sTestID + "  ends.******************\n");
			String imagePath = portalParam.custom_report_location
					+ takeScreenShot(driver, sTestID + "_" + portalParam.loanType);
			testResults.ExportResultToTxt(sTestID + "_" + portalParam.loanType + "\t" + result, testResults.sResBackUp + testResults.sResFile);
			writeToReport(funcMod, sTestID, result);
		}
	}
}
