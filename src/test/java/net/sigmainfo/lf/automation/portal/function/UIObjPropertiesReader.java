package net.sigmainfo.lf.automation.portal.function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shaishav.s on Shaishav.s on 22-04-2018.
 */
@Component
public class UIObjPropertiesReader {

	@Value(value = "${RefinancePage.RefinanceLoanAmount}")
	private String RefinancePage_RefinanceLoanAmount;

	@Value(value = "${RefinancePage.1stLoanAmount}")
	private String RefinancePage_1stLoanAmount;

	@Value(value = "${RefinancePage.2ndLoanAmount}")
	private String RefinancePage_2ndLoanAmount;

	@Value(value = "${RefinancePage.OtherLoanAmount}")
	private String RefinancePage_OtherLoanAmount;

	@Value(value = "${RefinancePage.Iscashoutequality}")
	private String RefinancePage_Iscashoutequality;

	@Value(value = "${RefinancePage.IsNotcashoutequality}")
	private String RefinancePage_IsNotcashoutequality;

	@Value(value = "${Refinance.pageLabel}")
	private String Refinance_pageLabel;

	@Value(value = "${Refinance.propertyTypeDropdown}")
	private String Refinance_propertyTypeDropdown;

	@Value(value = "${Refinance.numberOfUnitsDropdown}")
	private String Refinance_numberOfUnitsDropdown;

	@Value(value = "${Affinity.Profilelabel}")
	private String Affinity_Profilelabel;

	@Value(value = "${Affinity.CompanyProfilelabel}")
	private String Affinity_CompanyProfilelabel;

	@Value(value = "${Affinity.Invitelabel}")
	private String Affinity_Invitelabel;

	@Value(value = "${Affinity.ProfileFirstName}")
	private String Affinity_ProfileFirstName;

	@Value(value = "${Affinity.ProfileLastName}")
	private String Affinity_ProfileLastName;

	@Value(value = "${Affinity.ProfilePerferredEmail}")
	private String Affinity_ProfilePerferredEmail;

	@Value(value = "${Affinity.ProfilePhone}")
	private String Affinity_ProfilePhone;

	@Value(value = "${Affinity.ProfileNext}")
	private String Affinity_ProfileNext;

	@Value(value = "${Affinity.CompanyProfileCompanyName}")
	private String Affinity_CompanyProfileCompanyName;

	@Value(value = "${Affinity.CompanyProfileAddress}")
	private String Affinity_CompanyProfileAddress;

	@Value(value = "${Affinity.CompanyProfilePhone}")
	private String Affinity_CompanyProfilePhone;

	@Value(value = "${Affinity.CompanyProfileNext}")
	private String Affinity_CompanyProfileNext;

	@Value(value = "${Affinity.InviteFirstName}")
	private String Affinity_InviteFirstName;

	@Value(value = "${Affinity.InviteLastName}")
	private String Affinity_InviteLastName;

	@Value(value = "${Affinity.InviteEmail}")
	private String Affinity_InviteEmail;

	@Value(value = "${Affinity.InvitePhone}")
	private String Affinity_InvitePhone;

	@Value(value = "${Affinity.InviteButton}")
	private String Affinity_InviteButton;

	@Value(value = "${borrowerCommunicationPage.coborSpousepreferredEmailTextBox}")
	private String borrowerCommunicationPage_coborSpousepreferredEmailTextBox;

	@Value(value = "${CobSpouseLoginTellAboutYouPage.tellAboutYourselfLabel}")
	private String CobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel;

	@Value(value = "${borrowerCommunicationPage.coborHispreferredEmailTextBox}")
	private String borrowerCommunicationPage_coborHispreferredEmailTextBox;

	@Value(value = "${borrowerCommunicationPage.cobSpouseemailButton}")
	private String borrowerCommunicationPage_cobSpouseemailButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.sameResidenceAsSpouseButton}")
	private String CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.notSameResidenceAsSpouseButton}")
	private String CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton;

	@Value(value = "${SpouseLoginborrowerCommunicationPage.pageLabel}")
	private String SpouseLoginborrowerCommunicationPage_pageLabel;

	@Value(value = "${SpousecurrentResidentialDetailsPage.pageLabel}")
	private String SpousecurrentResidentialDetailsPage_pageLabel;

	@Value(value = "${borrowerSpouserentalPage.pageLabel}")
	private String borrowerSpouserentalPage_pageLabel;

	@Value(value = "${borrowerSpouseinterestDividendPage.pageLabel}")
	private String borrowerSpouseinterestDividendPage_pageLabel;

	@Value(value = "${Spousedeclaration.race}")
	private String Spousedeclaration_race;

	@Value(value = "${SpouseLoginTellAboutYouPage.tellAboutYourselfLabel}")
	private String SpouseLoginTellAboutYouPage_tellAboutYourselfLabel;

	@Value(value = "${SpouseAddeddeclaration.next}")
	private String SpouseAddeddeclaration_next;

	@Value(value = "${SpousesocialSecurityPage.pageLabel}")
	private String SpousesocialSecurityPage_pageLabel;

	@Value(value = "${SpousesocialSecurityPage.incomePerMonthTextBox}")
	private String SpousesocialSecurityPage_incomePerMonthTextBox;

	@Value(value = "${SpousesocialSecurityPage.nextButton}")
	private String SpousesocialSecurityPage_nextButton;

	@Value(value = "${SpouseinterestDividendPage.pageLabel}")
	private String SpouseinterestDividendPage_pageLabel;

	@Value(value = "${SpouseinterestDividendPage.lastYearDividendTextBox}")
	private String SpouseinterestDividendPage_lastYearDividendTextBox;

	@Value(value = "${SpouseinterestDividendPage.yearBeforeLastYearDividendTextBox}")
	private String SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox;

	@Value(value = "${SpouseinterestDividendPage.nextButton}")
	private String SpouseinterestDividendPage_nextButton;

	@Value(value = "${SpouseotherIncomePage.pageLabel}")
	private String SpouseotherIncomePage_pageLabel;

	@Value(value = "${SpouseotherIncomePage.otherIncomeTextBox}")
	private String SpouseotherIncomePage_otherIncomeTextBox;

	@Value(value = "${SpouseotherIncomePage.sourceOfIncomeDropdown}")
	private String SpouseotherIncomePage_sourceOfIncomeDropdown;

	@Value(value = "${SpouseotherIncomePage.otherIncomeForMoreThan2YearsButton}")
	private String SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton;

	@Value(value = "${SpouseotherIncomePage.otherIncomeForLessThan2YearsButton}")
	private String SpouseotherIncomePage_otherIncomeForLessThan2YearsButton;

	@Value(value = "${SpouseotherIncomePage.nextButton}")
	private String SpouseotherIncomePage_nextButton;

	@Value(value = "${SpousemilitaryPage.pageLabel}")
	private String SpousemilitaryPage_pageLabel;

	@Value(value = "${SpousemilitaryPage.perMonthIncomeTextBox}")
	private String SpousemilitaryPage_perMonthIncomeTextBox;

	@Value(value = "${SpousemilitaryPage.nextButton}")
	private String SpousemilitaryPage_nextButton;

	@Value(value = "${SpouserentalPage.pageLabel}")
	private String SpouserentalPage_pageLabel;

	@Value(value = "${SpouserentalPage.rentalIncomeTextBox}")
	private String SpouserentalPage_rentalIncomeTextBox;

	@Value(value = "${SpouserentalPage.propertyAddressTextBox}")
	private String SpouserentalPage_propertyAddressTextBox;

	@Value(value = "${SpouserentalPage.propertyTypeDropdown}")
	private String SpouserentalPage_propertyTypeDropdown;

	@Value(value = "${SpouserentalPage.numberOfUnitsDropdown}")
	private String SpouserentalPage_numberOfUnitsDropdown;

	@Value(value = "${SpouserentalPage.propertyStatusDropdown}")
	private String SpouserentalPage_propertyStatusDropdown;

	@Value(value = "${SpouserentalPage.propertyUseDropdown}")
	private String SpouserentalPage_propertyUseDropdown;

	@Value(value = "${SpouserentalPage.propertyValueTextBox}")
	private String SpouserentalPage_propertyValueTextBox;

	@Value(value = "${SpouserentalPage.monthlyRentalIncomeTextBox}")
	private String SpouserentalPage_monthlyRentalIncomeTextBox;

	@Value(value = "${SpouserentalPage.additionalExpenseTextBox}")
	private String SpouserentalPage_additionalExpenseTextBox;

	@Value(value = "${SpouserentalPage.netMonthlyRentalIncomeLabel}")
	private String SpouserentalPage_netMonthlyRentalIncomeLabel;

	@Value(value = "${SpouserentalPage.iAmDoneButton}")
	private String SpouserentalPage_iAmDoneButton;

	@Value(value = "${SpousesupportPage.pageLabel}")
	private String SpousesupportPage_pageLabel;

	@Value(value = "${SpousesupportPage.supportByCourtButton}")
	private String SpousesupportPage_supportByCourtButton;

	@Value(value = "${SpousesupportPage.noSupportByCourtButton}")
	private String SpousesupportPage_noSupportByCourtButton;

	@Value(value = "${SpousesupportPage.willReceiveCourtSupportButton}")
	private String SpousesupportPage_willReceiveCourtSupportButton;

	@Value(value = "${SpousesupportPage.willNotReceiveCourtSupportButton}")
	private String SpousesupportPage_willNotReceiveCourtSupportButton;

	@Value(value = "${SpousesupportPage.postLoanClosureSupportButton}")
	private String SpousesupportPage_postLoanClosureSupportButton;

	@Value(value = "${SpousesupportPage.postLoanClosureNoSupportButton}")
	private String SpousesupportPage_postLoanClosureNoSupportButton;

	@Value(value = "${SpousesupportPage.nextButton}")
	private String SpousesupportPage_nextButton;

	@Value(value = "${SpousebusinessSelfEmploymentPage.pageLabel}")
	private String SpousebusinessSelfEmploymentPage_pageLabel;

	@Value(value = "${SpousebusinessSelfEmploymentPage.currentlyWorkHereCheckbox}")
	private String SpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.monthlyIncomeTextBox}")
	private String SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.companyNameTextBox}")
	private String SpousebusinessSelfEmploymentPage_companyNameTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.titleTextBox}")
	private String SpousebusinessSelfEmploymentPage_titleTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.companyAddressTextBox}")
	private String SpousebusinessSelfEmploymentPage_companyAddressTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.companyPhoneTextBox}")
	private String SpousebusinessSelfEmploymentPage_companyPhoneTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.companyStartDateTextBox}")
	private String SpousebusinessSelfEmploymentPage_companyStartDateTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.companyEndDatePresentTextBox}")
	private String SpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.companyEndDateManualTextBox}")
	private String SpousebusinessSelfEmploymentPage_companyEndDateManualTextBox;

	@Value(value = "${SpousebusinessSelfEmploymentPage.moreThan25PercentStakeInCompanyButton}")
	private String SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton;

	@Value(value = "${SpousebusinessSelfEmploymentPage.lessThan25PercentStakeInCompanyButton}")
	private String SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton;

	@Value(value = "${SpousebusinessSelfEmploymentPage.typeOfCompanyDropdown}")
	private String SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown;

	@Value(value = "${SpousebusinessSelfEmploymentPage.nextButton}")
	private String SpousebusinessSelfEmploymentPage_nextButton;

	@Value(value = "${SpousemploymentAddressPage.businessAddressTextBox}")
	private String SpousemploymentAddressPage_businessAddressTextBox;

	@Value(value = "${SpouseemploymentAddressPage.phoneNumberTextBox}")
	private String SpouseemploymentAddressPage_phoneNumberTextBox;

	@Value(value = "${SpouseemploymentPage.currentlyWorkHereCheckbox}")
	private String SpouseemploymentPage_currentlyWorkHereCheckbox;

	@Value(value = "${SpouseemploymentPage.currentEmployerTextBox}")
	private String SpouseemploymentPage_currentEmployerTextBox;

	@Value(value = "${SpouseemploymentPage.titleTextBox}")
	private String SpouseemploymentPage_titleTextBox;

	@Value(value = "${SpouseemploymentPage.startDateTextBox}")
	private String SpouseemploymentPage_startDateTextBox;

	@Value(value = "${SpouseemploymentPage.endDatePresentTextBox}")
	private String SpouseemploymentPage_endDatePresentTextBox;

	@Value(value = "${SpouseemploymentPage.endDateManualTextBox}")
	private String SpouseemploymentPage_endDateManualTextBox;

	@Value(value = "${SpouseemploymentPage.inThisLineYearsTextBox}")
	private String SpouseemploymentPage_inThisLineYearsTextBox;

	@Value(value = "${SpouseemploymentPage.inThisLineMonthsTextBox}")
	private String SpouseemploymentPage_inThisLineMonthsTextBox;

	@Value(value = "${SpouseemploymentPage.monthlyBaseSalaryTextBox}")
	private String SpouseemploymentPage_monthlyBaseSalaryTextBox;

	@Value(value = "${SpouseemploymentPage.bonusButton}")
	private String SpouseemploymentPage_bonusButton;

	@Value(value = "${SpouseemploymentPage.commissionButton}")
	private String SpouseemploymentPage_commissionButton;

	@Value(value = "${SpouseemploymentPage.overtimeButton}")
	private String SpouseemploymentPage_overtimeButton;

	@Value(value = "${SpouseemploymentPage.allButton}")
	private String SpouseemploymentPage_allButton;

	@Value(value = "${SpouseemploymentPage.bonusTextBox}")
	private String SpouseemploymentPage_bonusTextBox;

	@Value(value = "${SpouseemploymentPage.commissionTextBox}")
	private String SpouseemploymentPage_commissionTextBox;

	@Value(value = "${SpouseemploymentPage.overtimeTextBox}")
	private String SpouseemploymentPage_overtimeTextBox;

	@Value(value = "${SpouseemploymentPage.nextButton}")
	private String SpouseemploymentPage_nextButton;

	@Value(value = "${SpousealimondyChildSupportPage.pageLabel}")
	private String SpousealimondyChildSupportPage_pageLabel;

	@Value(value = "${SpousealimondyChildSupportPage.alimonyPerMonthTextBox}")
	private String SpousealimondyChildSupportPage_alimonyPerMonthTextBox;

	@Value(value = "${SpousealimondyChildSupportPage.alimonyStartDateTextBox}")
	private String SpousealimondyChildSupportPage_alimonyStartDateTextBox;

	@Value(value = "${SpousealimondyChildSupportPage.childSupportPerMonthTextBox}")
	private String SpousealimondyChildSupportPage_childSupportPerMonthTextBox;

	@Value(value = "${SpousealimondyChildSupportPage.childNameTextBox}")
	private String SpousealimondyChildSupportPage_childNameTextBox;

	@Value(value = "${SpousealimondyChildSupportPage.childDoBTextBox}")
	private String SpousealimondyChildSupportPage_childDoBTextBox;

	@Value(value = "${SpousealimondyChildSupportPage.nextButton}")
	private String SpousealimondyChildSupportPage_nextButton;

	@Value(value = "${SpouseemploymentPage.pageLabel}")
	private String SpouseemploymentPage_pageLabel;

	@Value(value = "${SpouseincomeSearchPage.employmentButton}")
	private String SpouseincomeSearchPage_employmentButton;

	@Value(value = "${SpouseincomeSearchPage.alimonyChildSupportButton}")
	private String SpouseincomeSearchPage_alimonyChildSupportButton;

	@Value(value = "${SpouseincomeSearchPage.businessSelfEmploymentButton}")
	private String SpouseincomeSearchPage_businessSelfEmploymentButton;

	@Value(value = "${SpouseincomeSearchPage.millitaryButton}")
	private String SpouseincomeSearchPage_millitaryButton;

	@Value(value = "${SpouseincomeSearchPage.rentalButton}")
	private String SpouseincomeSearchPage_rentalButton;

	@Value(value = "${SpouseincomeSearchPage.socialSecurityButton}")
	private String SpouseincomeSearchPage_socialSecurityButton;

	@Value(value = "${SpouseincomeSearchPage.interestDividendButton}")
	private String SpouseincomeSearchPage_interestDividendButton;

	@Value(value = "${SpouseincomeSearchPage.othertButton}")
	private String SpouseincomeSearchPage_othertButton;

	@Value(value = "${SpouseincomeSearchPage.noIncomeButton}")
	private String SpouseincomeSearchPage_noIncomeButton;

	@Value(value = "${SpouseincomeSearchPage.beginButton}")
	private String SpouseincomeSearchPage_beginButton;

	@Value(value = "${SpouseincomeSearchPage.pageLabel}")
	private String SpouseincomeSearchPage_pageLabel;

	@Value(value = "${whosOnTheLoanPage.spouseSuffixTextBox}")
	private String whosOnTheLoanPage_spouseSuffixTextBox;

	@Value(value = "${SpouseAddedotherIncomePage.nextButton}")
	private String SpouseAddedotherIncomePage_nextButton;

	@Value(value = "${CoborrowerLoanOfficer.PageLabel}")
	private String CoborrowerLoanOfficer_PageLabel;

	@Value(value = "${Logout.username}")
	private String Logout_username;

	@Value(value = "${Logout.looutlink}")
	private String Logout_looutlink;

	@Value(value = "${CoborrowerSummary.PageLabel}")
	private String CoborrowerSummary_PageLabel;

	@Value(value = "${CoborrowerincomeSearchPage.pageLabel}")
	private String CoborrowerincomeSearchPage_pageLabel;

	@Value(value = "${CoborrowerincomeSearchPage.employmentButton}")
	private String CoborrowerincomeSearchPage_employmentButton;

	@Value(value = "${CoborrowerincomeSearchPage.alimonyChildSupportButton}")
	private String CoborrowerincomeSearchPage_alimonyChildSupportButton;

	@Value(value = "${CoborrowerincomeSearchPage.businessSelfEmploymentButton}")
	private String CoborrowerincomeSearchPage_businessSelfEmploymentButton;

	@Value(value = "${CoborrowerincomeSearchPage.millitaryButton}")
	private String CoborrowerincomeSearchPage_millitaryButton;

	@Value(value = "${CoborrowerincomeSearchPage.rentalButton}")
	private String CoborrowerincomeSearchPage_rentalButton;

	@Value(value = "${CoborrowerincomeSearchPage.socialSecurityButton}")
	private String CoborrowerincomeSearchPage_socialSecurityButton;

	@Value(value = "${CoborrowerincomeSearchPage.interestDividendButton}")
	private String CoborrowerincomeSearchPage_interestDividendButton;

	@Value(value = "${CoborrowerincomeSearchPage.othertButton}")
	private String CoborrowerincomeSearchPage_othertButton;

	@Value(value = "${CoborrowerincomeSearchPage.noIncomeButton}")
	private String CoborrowerincomeSearchPage_noIncomeButton;

	@Value(value = "${CoborrowerincomeSearchPage.beginButton}")
	private String CoborrowerincomeSearchPage_beginButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.pageLabel}")
	private String CoborrwercurrentResidentialDetailsPage_pageLabel;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.ownButton}")
	private String CoborrwercurrentResidentialDetailsPage_ownButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.rentButton}")
	private String CoborrwercurrentResidentialDetailsPage_rentButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.otherButton}")
	private String CoborrwercurrentResidentialDetailsPage_otherButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.currentResidenceTextbox}")
	private String CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.stayingHereSinceTextbox}")
	private String CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.bothAddressSameCheckbox}")
	private String CoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.planningToSellButton}")
	private String CoborrwercurrentResidentialDetailsPage_planningToSellButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.notPlanningToSellButton}")
	private String CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton;

	@Value(value = "${CoborrwercurrentResidentialDetailsPage.nextButton}")
	private String CoborrwercurrentResidentialDetailsPage_nextButton;

	@Value(value = "${CoborrwerrealEstatePage.pageLabel}")
	private String CoborrwerrealEstatePage_pageLabel;

	@Value(value = "${CoborrwerrealEstatePage.ownAdditionalPropertiesButton}")
	private String CoborrwerrealEstatePage_ownAdditionalPropertiesButton;

	@Value(value = "${CoborrwerrealEstatePage.dontOwnAdditionalPropertiesButton}")
	private String CoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton;

	@Value(value = "${CoborrwerrealEstatePage.propertyAddressTextbox}")
	private String CoborrwerrealEstatePage_propertyAddressTextbox;

	@Value(value = "${CoborrwerrealEstatePage.propertyValueTextbox}")
	private String CoborrwerrealEstatePage_propertyValueTextbox;

	@Value(value = "${CoborrwerrealEstatePage.rentalIncomeTextbox}")
	private String CoborrwerrealEstatePage_rentalIncomeTextbox;

	@Value(value = "${CoborrwerrealEstatePage.additioanlIncomeTextbox}")
	private String CoborrwerrealEstatePage_additioanlIncomeTextbox;

	@Value(value = "${CoborrwerrealEstatePage.netRentalIncomeLabel}")
	private String CoborrwerrealEstatePage_netRentalIncomeLabel;

	@Value(value = "${CoborrwerrealEstatePage.propertyTypeDropdown}")
	private String CoborrwerrealEstatePage_propertyTypeDropdown;

	@Value(value = "${CoborrwerrealEstatePage.numberOfUnitsDropdown}")
	private String CoborrwerrealEstatePage_numberOfUnitsDropdown;

	@Value(value = "${CoborrwerrealEstatePage.propertyStatusDropdown}")
	private String CoborrwerrealEstatePage_propertyStatusDropdown;

	@Value(value = "${CoborrwerrealEstatePage.propertyUseDropdown}")
	private String CoborrwerrealEstatePage_propertyUseDropdown;

	@Value(value = "${CoborrwerrealEstatePage.submitButton}")
	private String CoborrwerrealEstatePage_submitButton;

	@Value(value = "${COBORROWER.MaritalMarried}")
	private String COBORROWER_MaritalMarried;

	@Value(value = "${COBORROWER.MaritalSeprated}")
	private String COBORROWER_MaritalSeprated;

	@Value(value = "${COBORROWER.MaritalUnMarried}")
	private String COBORROWER_MaritalUnMarried;

	@Value(value = "${COBORROWER.MaritalNext}")
	private String COBORROWER_MaritalNext;

	@Value(value = "${COBORROWER.MaritalPageLabel}")
	private String COBORROWER_MaritalPageLabel;

	@Value(value = "${COBORROWER.MaritalNo}")
	private String COBORROWER_MaritalNo;

	@Value(value = "${COBORROWER.MaritalYes}")
	private String COBORROWER_MaritalYes;

	@Value(value = "${COBORROWER.MaritalFirstName}")
	private String COBORROWER_MaritalFirstName;

	@Value(value = "${COBORROWER.MaritalMiddleName}")
	private String COBORROWER_MaritalMiddleName;

	@Value(value = "${COBORROWER.MaritalLastName}")
	private String COBORROWER_MaritalLastName;

	@Value(value = "${COBORROWER.MaritalSuffix}")
	private String COBORROWER_MaritalSuffix;

	@Value(value = "${COBORROWER.MaritalDOB}")
	private String COBORROWER_MaritalDOB;

	@Value(value = "${COBORROWER.MaritalSSN}")
	private String COBORROWER_MaritalSSN;

	@Value(value = "${COBORROWER.MaritalEmailID}")
	private String COBORROWER_MaritalEmailID;

	@Value(value = "${COBORROWER.MaritalCellPhone}")
	private String COBORROWER_MaritalCellPhone;

	@Value(value = "${borrowerCommunicationPage.coborpreferredEmailTextBox}")
	private String borrowerCommunicationPage_coborpreferredEmailTextBox;

	@Value(value = "${LoanOfferPage.PageLabel}")
	private String LoanOfferPage_PageLabel;

	@Value(value = "${lenderGetStartedPage.getStartedLabel}")
	private String lenderGetStartedPage_getStartedLabel;

	@Value(value = "${lenderGetStartedPage.loginButton}")
	private String lenderGetStartedPage_loginButton;

	@Value(value = "${lenderLoginPage.emailTextBox}")
	private String lenderLoginPage_emailTextBox;

	@Value(value = "${lenderLoginPage.passwordTextBox}")
	private String lenderLoginPage_passwordTextBox;

	@Value(value = "${lenderLoginPage.forgetPasswordLink}")
	private String lenderLoginPage_forgetPasswordLink;

	@Value(value = "${lenderLoginPage.loginButton}")
	private String lenderLoginPage_loginButton;

	@Value(value = "${lenderPipelinePage.inviteButton}")
	private String lenderPipelinePage_inviteButton;

	@Value(value = "${lenderPipelinePage.panelLoanOfficePic}")
	private String lenderPipelinePage_panelLoanOfficePic;

	@Value(value = "${lenderPipelinePage.panelLoanOfficerLabel}")
	private String lenderPipelinePage_panelLoanOfficerLabel;

	@Value(value = "${lenderPipeline.headerPanel.settingDropdown}")
	private String lenderPipeline_headerPanel_settingDropdown;

	@Value(value = "${lenderPipeline.activeLoansTab}")
	private String lenderPipeline_activeLoansTab;

	@Value(value = "${lenderPipeline.applicationsTab}")
	private String lenderPipeline_applicationsTab;

	@Value(value = "${lenderPipeline.closedTab}")
	private String lenderPipeline_closedTab;

	@Value(value = "${lenderPipeline.firstActiveLoan.daysToCloseLabel}")
	private String lenderPipeline_firstActiveLoan_daysToCloseLabel;

	@Value(value = "${lenderPipeline.firstActiveLoan.firstLoanIdLabel}")
	private String lenderPipeline_firstActiveLoan_firstLoanIdLabel;

	@Value(value = "${lenderPipeline.headerPanel.settingDropdown.logoutButton}")
	private String lenderPipeline_headerPanel_settingDropdown_logoutButton;

	@Value(value = "${lenderPipeline.inviteDialog.inviteLabel}")
	private String lenderPipeline_inviteDialog_inviteLabel;

	@Value(value = "${lenderPipeline.inviteDialog.firstNameTextBox}")
	private String lenderPipeline_inviteDialog_firstNameTextBox;

	@Value(value = "${lenderPipeline.inviteDialog.lastNameTextBox}")
	private String lenderPipeline_inviteDialog_lastNameTextBox;

	@Value(value = "${lenderPipeline.inviteDialog.borrowerButton}")
	private String lenderPipeline_inviteDialog_borrowerButton;

	@Value(value = "${lenderPipeline.inviteDialog.affinityPartnerButton}")
	private String lenderPipeline_inviteDialog_affinityPartnerButton;

	@Value(value = "${lenderPipeline.inviteDialog.emailTextBox}")
	private String lenderPipeline_inviteDialog_emailTextBox;

	@Value(value = "${lenderPipeline.inviteDialog.phoneTextBox}")
	private String lenderPipeline_inviteDialog_phoneTextBox;

	@Value(value = "${lenderPipeline.inviteDialog.sendInviteButton}")
	private String lenderPipeline_inviteDialog_sendInviteButton;

	@Value(value = "${borrowerSignUpPage.emailTextBox}")
	private String borrowerSignUpPage_emailTextBox;

	@Value(value = "${borrowerSignUpPage.passwordTextBox}")
	private String borrowerSignUpPage_passwordTextBox;

	@Value(value = "${borrowerSignUpPage.confirmPasswordTextBox}")
	private String borrowerSignUpPage_confirmPasswordTextBox;

	@Value(value = "${borrowerSignUpPage.signUpButton}")
	private String borrowerSignUpPage_signUpButton;

	@Value(value = "${borrowerSignUpPage.welcomeMessage}")
	private String borrowerSignUpPage_welcomeMessage;

	@Value(value = "${borrowerWelcomePage.typeOfLoanSelectionMessage}")
	private String borrowerWelcomePage_typeOfLoanSelectionMessage;

	@Value(value = "${borrowerWelcomePage.purchaseLoanButton}")
	private String borrowerWelcomePage_purchaseLoanButton;

	@Value(value = "${borrowerWelcomePage.refinanceLoanButton}")
	private String borrowerWelcomePage_refinanceLoanButton;

	@Value(value = "${borrowerHeader.nafLogo}")
	private String borrowerHeader_nafLogo;

	@Value(value = "${borrowerHeader.profileDropdown}")
	private String borrowerHeader_profileDropdown;

	@Value(value = "${borrowerHeader.profileDropdown.logoutButton}")
	private String borrowerHeader_profileDropdown_logoutButton;

	@Value(value = "${borrowerWelcomeVideoPage.lenderImage}")
	private String borrowerWelcomeVideoPage_lenderImage;

	@Value(value = "${borrowerWelcomeVideoPage.loanOfficerLabel}")
	private String borrowerWelcomeVideoPage_loanOfficerLabel;

	@Value(value = "${borrowerWelcomeVideoPage.loanOfficerEmailLabel}")
	private String borrowerWelcomeVideoPage_loanOfficerEmailLabel;

	@Value(value = "${borrowerWelcomeVideoPage.loanOfficerPhoneLabel}")
	private String borrowerWelcomeVideoPage_loanOfficerPhoneLabel;

	@Value(value = "${borrowerWelcomeVideoPage.video}")
	private String borrowerWelcomeVideoPage_video;

	@Value(value = "${borrowerWelcomeVideoPage.welcomeMessage}")
	private String borrowerWelcomeVideoPage_welcomeMessage;

	@Value(value = "${borrowerWelcomeVideoPage.getStartedButton}")
	private String borrowerWelcomeVideoPage_getStartedButton;

	@Value(value = "${beginSectionPage.welcomeMessage}")
	private String beginSectionPage_welcomeMessage;

	@Value(value = "${beginSectionPage.beginSectionButton}")
	private String beginSectionPage_beginSectionButton;

	@Value(value = "${TellAboutYouPage.firstNameTextbox}")
	private String TellAboutYouPage_firstNameTextbox;

	@Value(value = "${TellAboutYouPage.middleNameTextbox}")
	private String TellAboutYouPage_middleNameTextbox;

	@Value(value = "${TellAboutYouPage.lastNameTextbox}")
	private String TellAboutYouPage_lastNameTextbox;

	@Value(value = "${TellAboutYouPage.suffixTextBox}")
	private String TellAboutYouPage_suffixTextBox;

	@Value(value = "${TellAboutYouPage.DoBTextBox}")
	private String TellAboutYouPage_DoBTextBox;

	@Value(value = "${TellAboutYouPage.ssnTextBox}")
	private String TellAboutYouPage_ssnTextBox;

	@Value(value = "${TellAboutYouPage.nextButton}")
	private String TellAboutYouPage_nextButton;

	@Value(value = "${borrowerCommunicationPage.pageLabel}")
	private String borrowerCommunicationPage_pageLabel;

	@Value(value = "${borrowerCommunicationPage.preferredEmailTextBox}")
	private String borrowerCommunicationPage_preferredEmailTextBox;

	@Value(value = "${borrowerCommunicationPage.phoneNumberTextBox}")
	private String borrowerCommunicationPage_phoneNumberTextBox;

	@Value(value = "${borrowerCommunicationPage.phoneButton}")
	private String borrowerCommunicationPage_phoneButton;

	@Value(value = "${borrowerCommunicationPage.emailButton}")
	private String borrowerCommunicationPage_emailButton;

	@Value(value = "${borrowerCommunicationPage.textButton}")
	private String borrowerCommunicationPage_textButton;

	@Value(value = "${borrowerCommunicationPage.allButton}")
	private String borrowerCommunicationPage_allButton;

	@Value(value = "${borrowerCommunicationPage.nextButton}")
	private String borrowerCommunicationPage_nextButton;

	@Value(value = "${TellAboutYouPage.NavigationHeaderLabel}")
	private String TellAboutYouPage_NavigationHeaderLabel;

	@Value(value = "${TellAboutYouPage.progressBarLabel}")
	private String TellAboutYouPage_progressBarLabel;

	@Value(value = "${TellAboutYouPage.tellAboutYourselfLabel}")
	private String TellAboutYouPage_tellAboutYourselfLabel;

	@Value(value = "${purchasePropertyDetailsPage.propertyTypeDropdown}")
	private String purchasePropertyDetailsPage_propertyTypeDropdown;

	@Value(value = "${purchasePropertyDetailsPage.numberOfUnitsDropdown}")
	private String purchasePropertyDetailsPage_numberOfUnitsDropdown;

	@Value(value = "${purchasePropertyDetailsPage.expectedMonthlyRentalIncomeTextBox}")
	private String purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox;

	@Value(value = "${purchasePropertyDetailsPage.selectedProperty}")
	private String purchasePropertyDetailsPage_selectedProperty;

	@Value(value = "${purchasePropertyDetailsPage.notSelectedProperty}")
	private String purchasePropertyDetailsPage_notSelectedProperty;

	@Value(value = "${purchasePropertyDetailsPage.inContract}")
	private String purchasePropertyDetailsPage_inContract;

	@Value(value = "${purchasePropertyDetailsPage.notInContract}")
	private String purchasePropertyDetailsPage_notInContract;

	@Value(value = "${purchasePropertyDetailsPage.propertyUseDropdown}")
	private String purchasePropertyDetailsPage_propertyUseDropdown;

	@Value(value = "${purchasePropertyDetailsPage.addressTextBox}")
	private String purchasePropertyDetailsPage_addressTextBox;

	@Value(value = "${purchasePropertyDetailsPage.nextButton}")
	private String purchasePropertyDetailsPage_nextButton;

	@Value(value = "${loanAmountPage.pageLabel}")
	private String loanAmountPage_pageLabel;

	@Value(value = "${loanAmountPage.purchasePriceTextbox}")
	private String loanAmountPage_purchasePriceTextbox;

	@Value(value = "${loanAmountPage.downPaymentTextbox}")
	private String loanAmountPage_downPaymentTextbox;

	@Value(value = "${loanAmountPage.nextButton}")
	private String loanAmountPage_nextButton;

	@Value(value = "${loanAmountPage.loanAmountTextbox}")
	private String loanAmountPage_loanAmountTextbox;

	@Value(value = "${loanAmountPage.loanPercentageTextbox}")
	private String loanAmountPage_loanPercentageTextbox;

	@Value(value = "${purchasePropertyDetailsPage.pageLabel}")
	private String purchasePropertyDetailsPage_pageLabel;

	@Value(value = "${whosOnTheLoanPage.pageLabel}")
	private String whosOnTheLoanPage_pageLabel;

	@Value(value = "${whosOnTheLoanPage.marriedButton}")
	private String whosOnTheLoanPage_marriedButton;

	@Value(value = "${whosOnTheLoanPage.separatedButton}")
	private String whosOnTheLoanPage_separatedButton;

	@Value(value = "${whosOnTheLoanPage.unmarriedButton}")
	private String whosOnTheLoanPage_unmarriedButton;

	@Value(value = "${whosOnTheLoanPage.individualCreditCheckbox}")
	private String whosOnTheLoanPage_individualCreditCheckbox;

	@Value(value = "${whosOnTheLoanPage.nextButton}")
	private String whosOnTheLoanPage_nextButton;

	@Value(value = "${whosOnTheLoanPage.spouseFirstNameTextBox}")
	private String whosOnTheLoanPage_spouseFirstNameTextBox;

	@Value(value = "${whosOnTheLoanPage.spouseLastNameTextBox}")
	private String whosOnTheLoanPage_spouseLastNameTextBox;

	@Value(value = "${whosOnTheLoanPage.jointCreditCheckbox}")
	private String whosOnTheLoanPage_jointCreditCheckbox;

	@Value(value = "${addCoApplicantsPage.pageLabel}")
	private String addCoApplicantsPage_pageLabel;

	@Value(value = "${addCoApplicantsPage.addFirstCoborrower}")
	private String addCoApplicantsPage_addFirstCoborrower;

	@Value(value = "${addCoApplicantsPage.cob1FirstNameTextbox}")
	private String addCoApplicantsPage_cob1FirstNameTextbox;

	@Value(value = "${addCoApplicantsPage.cob1LastNameTextbox}")
	private String addCoApplicantsPage_cob1LastNameTextbox;

	@Value(value = "${addCoApplicantsPage.cob1EmailTextbox}")
	private String addCoApplicantsPage_cob1EmailTextbox;

	@Value(value = "${addCoApplicantsPage.cob1RelationshipDropdown}")
	private String addCoApplicantsPage_cob1RelationshipDropdown;

	@Value(value = "${spouseInformationPage.firstNameTextbox}")
	private String spouseInformationPage_firstNameTextbox;

	@Value(value = "${spouseInformationPage.middleNameTextbox}")
	private String spouseInformationPage_middleNameTextbox;

	@Value(value = "${spouseInformationPage.lastNameTextbox}")
	private String spouseInformationPage_lastNameTextbox;

	@Value(value = "${spouseInformationPage.suffixNameTextbox}")
	private String spouseInformationPage_suffixNameTextbox;

	@Value(value = "${spouseInformationPage.dObTextBox}")
	private String spouseInformationPage_dObTextBox;

	@Value(value = "${spouseInformationPage.ssnTextBox}")
	private String spouseInformationPage_ssnTextBox;

	@Value(value = "${spouseInformationPage.nextButton}")
	private String spouseInformationPage_nextButton;

	@Value(value = "${spouseCommunicationPage.pageLabel}")
	private String spouseCommunicationPage_pageLabel;

	@Value(value = "${spouseCommunicationPage.preferredEmailTextbox}")
	private String spouseCommunicationPage_preferredEmailTextbox;

	@Value(value = "${spouseCommunicationPage.phoneTextbox}")
	private String spouseCommunicationPage_phoneTextbox;

	@Value(value = "${spouseCommunicationPage.phoneButton}")
	private String spouseCommunicationPage_phoneButton;

	@Value(value = "${spouseCommunicationPage.emailButton}")
	private String spouseCommunicationPage_emailButton;

	@Value(value = "${spouseCommunicationPage.textButton}")
	private String spouseCommunicationPage_textButton;

	@Value(value = "${spouseCommunicationPage.allButton}")
	private String spouseCommunicationPage_allButton;

	@Value(value = "${spouseCommunicationPage.nextButton}")
	private String spouseCommunicationPage_nextButton;

	@Value(value = "${nonSpouseInformationPage.firstNameTextbox}")
	private String nonSpouseInformationPage_firstNameTextbox;

	@Value(value = "${nonSpouseInformationPage.middleNameTextbox}")
	private String nonSpouseInformationPage_middleNameTextbox;

	@Value(value = "${nonSpouseInformationPage.lastNameTextbox}")
	private String nonSpouseInformationPage_lastNameTextbox;

	@Value(value = "${nonSpouseInformationPage.suffixTextbox}")
	private String nonSpouseInformationPage_suffixTextbox;

	@Value(value = "${nonSpouseInformationPage.preferredEmailTextbox}")
	private String nonSpouseInformationPage_preferredEmailTextbox;

	@Value(value = "${nonSpouseInformationPage.phoneTextbox}")
	private String nonSpouseInformationPage_phoneTextbox;

	@Value(value = "${nonSpouseInformationPage.nextButton}")
	private String nonSpouseInformationPage_nextButton;

	@Value(value = "${spouseInformationPage.pageLabel}")
	private String spouseInformationPage_pageLabel;

	@Value(value = "${nonSpouseInformationPage.pageLabel}")
	private String nonSpouseInformationPage_pageLabel;

	@Value(value = "${applicantInformationPage.coborrowerLabel}")
	private String applicantInformationPage_coborrowerLabel;

	@Value(value = "${applicantInformationPage.coborrowerNameLabel}")
	private String applicantInformationPage_coborrowerNameLabel;

	@Value(value = "${applicantInformationPage.progressBarLabel}")
	private String applicantInformationPage_progressBarLabel;

	@Value(value = "${applicantInformationPage.nextButton}")
	private String applicantInformationPage_nextButton;

	@Value(value = "${applicantInformationPage.pageLabel}")
	private String applicantInformationPage_pageLabel;

	@Value(value = "${loanEligibilityPage.eligibleForLoanButton}")
	private String loanEligibilityPage_eligibleForLoanButton;

	@Value(value = "${loanEligibilityPage.notEligibleForLoanButton}")
	private String loanEligibilityPage_notEligibleForLoanButton;

	@Value(value = "${loanEligibilityPage.haveCurrentLoanButton}")
	private String loanEligibilityPage_haveCurrentLoanButton;

	@Value(value = "${loanEligibilityPage.noCurrentLoanButton}")
	private String loanEligibilityPage_noCurrentLoanButton;

	@Value(value = "${loanEligibilityPage.dutyWithExpirationDateCheckbox}")
	private String loanEligibilityPage_dutyWithExpirationDateCheckbox;

	@Value(value = "${loanEligibilityPage.childCareExpenseButton}")
	private String loanEligibilityPage_childCareExpenseButton;

	@Value(value = "${loanEligibilityPage.noChildCareExpenseButton}")
	private String loanEligibilityPage_noChildCareExpenseButton;

	@Value(value = "${loanEligibilityPage.childCareExpenseTextbox}")
	private String loanEligibilityPage_childCareExpenseTextbox;

	@Value(value = "${loanEligibilityPage.CurrentlyRetiredCheckbox}")
	private String loanEligibilityPage_CurrentlyRetiredCheckbox;

	@Value(value = "${loanEligibilityPage.NonActivatedCheckbox}")
	private String loanEligibilityPage_NonActivatedCheckbox;

	@Value(value = "${loanEligibilityPage.SurvivingSpouseCheckbox}")
	private String loanEligibilityPage_SurvivingSpouseCheckbox;

	@Value(value = "${loanEligibilityPage.projectedExpiryDateTextbox}")
	private String loanEligibilityPage_projectedExpiryDateTextbox;

	@Value(value = "${loanEligibilityPage.nextButton}")
	private String loanEligibilityPage_nextButton;

	@Value(value = "${loanEligibilityPage.pageLabel}")
	private String loanEligibilityPage_pageLabel;

	@Value(value = "${realEstateAgentPage.pageLabel}")
	private String realEstateAgentPage_pageLabel;

	@Value(value = "${realEstateAgentPage.workingWithAgentButton}")
	private String realEstateAgentPage_workingWithAgentButton;

	@Value(value = "${realEstateAgentPage.notWorkingWithAgentButton}")
	private String realEstateAgentPage_notWorkingWithAgentButton;

	@Value(value = "${realEstateAgentPage.referAgentButton}")
	private String realEstateAgentPage_referAgentButton;

	@Value(value = "${realEstateAgentPage.notReferAgentButton}")
	private String realEstateAgentPage_notReferAgentButton;

	@Value(value = "${realEstateAgentPage.nextButton}")
	private String realEstateAgentPage_nextButton;

	@Value(value = "${currentResidentialDetailsPage.pageLabel}")
	private String currentResidentialDetailsPage_pageLabel;

	@Value(value = "${currentResidentialDetailsPage.sameResidenceAsSpouseButton}")
	private String currentResidentialDetailsPage_sameResidenceAsSpouseButton;

	@Value(value = "${currentResidentialDetailsPage.notSameResidenceAsSpouseButton}")
	private String currentResidentialDetailsPage_notSameResidenceAsSpouseButton;

	@Value(value = "${currentResidentialDetailsPage.ownButton}")
	private String currentResidentialDetailsPage_ownButton;

	@Value(value = "${currentResidentialDetailsPage.rentButton}")
	private String currentResidentialDetailsPage_rentButton;

	@Value(value = "${currentResidentialDetailsPage.otherButton}")
	private String currentResidentialDetailsPage_otherButton;

	@Value(value = "${currentResidentialDetailsPage.currentResidenceTextbox}")
	private String currentResidentialDetailsPage_currentResidenceTextbox;

	@Value(value = "${currentResidentialDetailsPage.stayingHereSinceTextbox}")
	private String currentResidentialDetailsPage_stayingHereSinceTextbox;

	@Value(value = "${currentResidentialDetailsPage.bothAddressSameCheckbox}")
	private String currentResidentialDetailsPage_bothAddressSameCheckbox;

	@Value(value = "${currentResidentialDetailsPage.planningToSellButton}")
	private String currentResidentialDetailsPage_planningToSellButton;

	@Value(value = "${currentResidentialDetailsPage.notPlanningToSellButton}")
	private String currentResidentialDetailsPage_notPlanningToSellButton;

	@Value(value = "${currentResidentialDetailsPage.nextButton}")
	private String currentResidentialDetailsPage_nextButton;

	@Value(value = "${realEstatePage.ownAdditionalPropertiesButton}")
	private String realEstatePage_ownAdditionalPropertiesButton;

	@Value(value = "${realEstatePage.dontOwnAdditionalPropertiesButton}")
	private String realEstatePage_dontOwnAdditionalPropertiesButton;

	@Value(value = "${realEstatePage.propertyAddressTextbox}")
	private String realEstatePage_propertyAddressTextbox;

	@Value(value = "${realEstatePage.propertyValueTextbox}")
	private String realEstatePage_propertyValueTextbox;

	@Value(value = "${realEstatePage.rentalIncomeTextbox}")
	private String realEstatePage_rentalIncomeTextbox;

	@Value(value = "${realEstatePage.additioanlIncomeTextbox}")
	private String realEstatePage_additioanlIncomeTextbox;

	@Value(value = "${realEstatePage.netRentalIncomeLabel}")
	private String realEstatePage_netRentalIncomeLabel;

	@Value(value = "${realEstatePage.propertyTypeDropdown}")
	private String realEstatePage_propertyTypeDropdown;

	@Value(value = "${realEstatePage.numberOfUnitsDropdown}")
	private String realEstatePage_numberOfUnitsDropdown;

	@Value(value = "${realEstatePage.propertyStatusDropdown}")
	private String realEstatePage_propertyStatusDropdown;

	@Value(value = "${realEstatePage.propertyUseDropdown}")
	private String realEstatePage_propertyUseDropdown;

	@Value(value = "${realEstatePage.submitButton}")
	private String realEstatePage_submitButton;

	@Value(value = "${realEstatePage.pageLabel}")
	private String realEstatePage_pageLabel;

	@Value(value = "${profileCompletedPage.beginSectionButton}")
	private String profileCompletedPage_beginSectionButton;

	@Value(value = "${profileCompletedPage.profileCompletionMessage}")
	private String profileCompletedPage_profileCompletionMessage;

	@Value(value = "${assetsPage.pageLabel}")
	private String assetsPage_pageLabel;

	@Value(value = "${assetsPage.verifyElectronicallyButton}")
	private String assetsPage_verifyElectronicallyButton;

	@Value(value = "${assetsPage.enterManuallyButton}")
	private String assetsPage_enterManuallyButton;

	@Value(value = "${savingAndInvestmentPage.institutionNameTextBox}")
	private String savingAndInvestmentPage_institutionNameTextBox;

	@Value(value = "${savingAndInvestmentPage.accountTypeTextBox}")
	private String savingAndInvestmentPage_accountTypeTextBox;

	@Value(value = "${savingAndInvestmentPage.currentBalanceTextBox}")
	private String savingAndInvestmentPage_currentBalanceTextBox;

	@Value(value = "${savingAndInvestmentPage.accountNumberTextBox}")
	private String savingAndInvestmentPage_accountNumberTextBox;

	@Value(value = "${savingAndInvestmentPage.accountHolderNameTextBox}")
	private String savingAndInvestmentPage_accountHolderNameTextBox;

	@Value(value = "${savingAndInvestmentPage.enterButton}")
	private String savingAndInvestmentPage_enterButton;

	@Value(value = "${savingAndInvestmentPage.pageLabel}")
	private String savingAndInvestmentPage_pageLabel;

	@Value(value = "${assetSumamryPage.addAccountButton}")
	private String assetSumamryPage_addAccountButton;

	@Value(value = "${assetSumamryPage.iAmDoneButton}")
	private String assetSumamryPage_iAmDoneButton;

	@Value(value = "${plaidCredential.userIdTextBox}")
	private String plaidCredential_userIdTextBox;

	@Value(value = "${plaidCredential.passwordTextBox}")
	private String plaidCredential_passwordTextBox;

	@Value(value = "${plaidCredential.verifyElectronicallyButton}")
	private String plaidCredential_verifyElectronicallyButton;

	@Value(value = "${borrowerLoginPage.emailTextbox}")
	private String borrowerLoginPage_emailTextbox;

	@Value(value = "${borrowerLoginPage.passwordTextbox}")
	private String borrowerLoginPage_passwordTextbox;

	@Value(value = "${borrowerLoginPage.signInButton}")
	private String borrowerLoginPage_signInButton;

	@Value(value = "${borrowerLoginPage.forgetPasswordLink}")
	private String borrowerLoginPage_forgetPasswordLink;

	@Value(value = "${borrowerLoginPage.termsAndConditionLink}")
	private String borrowerLoginPage_termsAndConditionLink;

	@Value(value = "${spouseAssetsPage.pageLabel}")
	private String spouseAssetsPage_pageLabel;

	@Value(value = "${spouseAssetsPage.enterManuallyButton}")
	private String spouseAssetsPage_enterManuallyButton;

	@Value(value = "${spouseSavingAndInvestmentPage.pageLabel}")
	private String spouseSavingAndInvestmentPage_pageLabel;

	@Value(value = "${spouseSavingAndInvestmentPage.institutionNameTextBox}")
	private String spouseSavingAndInvestmentPage_institutionNameTextBox;

	@Value(value = "${spouseSavingAndInvestmentPage.accountTypeTextBox}")
	private String spouseSavingAndInvestmentPage_accountTypeTextBox;

	@Value(value = "${spouseSavingAndInvestmentPage.currentBalanceTextBox}")
	private String spouseSavingAndInvestmentPage_currentBalanceTextBox;

	@Value(value = "${spouseSavingAndInvestmentPage.accountNumberTextBox}")
	private String spouseSavingAndInvestmentPage_accountNumberTextBox;

	@Value(value = "${spouseSavingAndInvestmentPage.accountHolderNameTextBox}")
	private String spouseSavingAndInvestmentPage_accountHolderNameTextBox;

	@Value(value = "${spouseSavingAndInvestmentPage.enterButton}")
	private String spouseSavingAndInvestmentPage_enterButton;

	@Value(value = "${spouseAssetSummaryPage.pageLabel}")
	private String spouseAssetSummaryPage_pageLabel;

	@Value(value = "${spouseAssetSummaryPage.iAmDoneButton}")
	private String spouseAssetSummaryPage_iAmDoneButton;

	@Value(value = "${spouseAssetSummaryPage.addAccountButton}")
	private String spouseAssetSummaryPage_addAccountButton;

	@Value(value = "${spousePlaidCredential.userIdTextBox}")
	private String spousePlaidCredential_userIdTextBox;

	@Value(value = "${spousePlaidCredential.passwordTextBox}")
	private String spousePlaidCredential_passwordTextBox;

	@Value(value = "${spousePlaidCredential.verifyElectronicallyButton}")
	private String spousePlaidCredential_verifyElectronicallyButton;

	@Value(value = "${assetCompletePage.beginSectionButton}")
	private String assetCompletePage_beginSectionButton;

	@Value(value = "${incomeSearchPage.pageLabel}")
	private String incomeSearchPage_pageLabel;

	@Value(value = "${incomeSearchPage.employmentButton}")
	private String incomeSearchPage_employmentButton;

	@Value(value = "${incomeSearchPage.alimonyChildSupportButton}")
	private String incomeSearchPage_alimonyChildSupportButton;

	@Value(value = "${incomeSearchPage.businessSelfEmploymentButton}")
	private String incomeSearchPage_businessSelfEmploymentButton;

	@Value(value = "${incomeSearchPage.millitaryButton}")
	private String incomeSearchPage_millitaryButton;

	@Value(value = "${incomeSearchPage.rentalButton}")
	private String incomeSearchPage_rentalButton;

	@Value(value = "${incomeSearchPage.socialSecurityButton}")
	private String incomeSearchPage_socialSecurityButton;

	@Value(value = "${incomeSearchPage.interestDividendButton}")
	private String incomeSearchPage_interestDividendButton;

	@Value(value = "${incomeSearchPage.othertButton}")
	private String incomeSearchPage_othertButton;

	@Value(value = "${incomeSearchPage.noIncomeButton}")
	private String incomeSearchPage_noIncomeButton;

	@Value(value = "${incomeSearchPage.beginButton}")
	private String incomeSearchPage_beginButton;

	@Value(value = "${employmentPage.pageLabel}")
	private String employmentPage_pageLabel;

	@Value(value = "${employmentPage.currentlyWorkHereCheckbox}")
	private String employmentPage_currentlyWorkHereCheckbox;

	@Value(value = "${employmentPage.endDatePresentTextBox}")
	private String employmentPage_endDatePresentTextBox;

	@Value(value = "${employmentPage.endDateManualTextBox}")
	private String employmentPage_endDateManualTextBox;

	@Value(value = "${employmentPage.currentEmployerTextBox}")
	private String employmentPage_currentEmployerTextBox;

	@Value(value = "${employmentPage.titleTextBox}")
	private String employmentPage_titleTextBox;

	@Value(value = "${employmentPage.startDateTextBox}")
	private String employmentPage_startDateTextBox;

	@Value(value = "${employmentPage.inThisLineYearsTextBox}")
	private String employmentPage_inThisLineYearsTextBox;

	@Value(value = "${employmentPage.inThisLineMonthsTextBox}")
	private String employmentPage_inThisLineMonthsTextBox;

	@Value(value = "${employmentPage.monthlyBaseSalaryTextBox}")
	private String employmentPage_monthlyBaseSalaryTextBox;

	@Value(value = "${employmentPage.bonusButton}")
	private String employmentPage_bonusButton;

	@Value(value = "${employmentPage.bonusTextBox}")
	private String employmentPage_bonusTextBox;

	@Value(value = "${employmentPage.commissionTextBox}")
	private String employmentPage_commissionTextBox;

	@Value(value = "${employmentPage.overtimeTextBox}")
	private String employmentPage_overtimeTextBox;

	@Value(value = "${employmentPage.commissionButton}")
	private String employmentPage_commissionButton;

	@Value(value = "${employmentPage.overtimeButton}")
	private String employmentPage_overtimeButton;

	@Value(value = "${employmentPage.allButton}")
	private String employmentPage_allButton;

	@Value(value = "${employmentPage.nextButton}")
	private String employmentPage_nextButton;

	@Value(value = "${employmentAddressPage.pageLabel}")
	private String employmentAddressPage_pageLabel;

	@Value(value = "${employmentAddressPage.businessAddressTextBox}")
	private String employmentAddressPage_businessAddressTextBox;

	@Value(value = "${employmentAddressPage.phoneNumberTextBox}")
	private String employmentAddressPage_phoneNumberTextBox;

	@Value(value = "${employmentAddressPage.iAmDoneButton}")
	private String employmentAddressPage_iAmDoneButton;

	@Value(value = "${incomeDetailsPage.pageLabel}")
	private String incomeDetailsPage_pageLabel;

	@Value(value = "${incomeDetailsPage.dateOfBirthTextBox}")
	private String incomeDetailsPage_dateOfBirthTextBox;

	@Value(value = "${incomeDetailsPage.ssnTextBox}")
	private String incomeDetailsPage_ssnTextBox;

	@Value(value = "${incomeDetailsPage.findMyIncomeButton}")
	private String incomeDetailsPage_findMyIncomeButton;

	@Value(value = "${alimondyChildSupportPage.pageLabel}")
	private String alimondyChildSupportPage_pageLabel;

	@Value(value = "${alimondyChildSupportPage.alimonyPerMonthTextBox}")
	private String alimondyChildSupportPage_alimonyPerMonthTextBox;

	@Value(value = "${alimondyChildSupportPage.alimonyStartDateTextBox}")
	private String alimondyChildSupportPage_alimonyStartDateTextBox;

	@Value(value = "${alimondyChildSupportPage.childSupportPerMonthTextBox}")
	private String alimondyChildSupportPage_childSupportPerMonthTextBox;

	@Value(value = "${alimondyChildSupportPage.childNameTextBox}")
	private String alimondyChildSupportPage_childNameTextBox;

	@Value(value = "${realEstateAgentPage.AgentLastName}")
	private String realEstateAgentPage_AgentLastName;

	@Value(value = "${alimondyChildSupportPage.childDoBTextBox}")
	private String alimondyChildSupportPage_childDoBTextBox;

	@Value(value = "${alimondyChildSupportPage.nextButton}")
	private String alimondyChildSupportPage_nextButton;

	@Value(value = "${supportPage.pageLabel}")
	private String supportPage_pageLabel;

	@Value(value = "${supportPage.supportByCourtButton}")
	private String supportPage_supportByCourtButton;

	@Value(value = "${supportPage.noSupportByCourtButton}")
	private String supportPage_noSupportByCourtButton;

	@Value(value = "${supportPage.willReceiveCourtSupportButton}")
	private String supportPage_willReceiveCourtSupportButton;

	@Value(value = "${supportPage.willNotReceiveCourtSupportButton}")
	private String supportPage_willNotReceiveCourtSupportButton;

	@Value(value = "${supportPage.postLoanClosureSupportButton}")
	private String supportPage_postLoanClosureSupportButton;

	@Value(value = "${supportPage.postLoanClosureNoSupportButton}")
	private String supportPage_postLoanClosureNoSupportButton;

	@Value(value = "${supportPage.nextButton}")
	private String supportPage_nextButton;

	@Value(value = "${businessSelfEmploymentPage.pageLabel}")
	private String businessSelfEmploymentPage_pageLabel;

	@Value(value = "${businessSelfEmploymentPage.currentlyWorkHereCheckbox}")
	private String businessSelfEmploymentPage_currentlyWorkHereCheckbox;

	@Value(value = "${businessSelfEmploymentPage.monthlyIncomeTextBox}")
	private String businessSelfEmploymentPage_monthlyIncomeTextBox;

	@Value(value = "${businessSelfEmploymentPage.companyNameTextBox}")
	private String businessSelfEmploymentPage_companyNameTextBox;

	@Value(value = "${businessSelfEmploymentPage.titleTextBox}")
	private String businessSelfEmploymentPage_titleTextBox;

	@Value(value = "${businessSelfEmploymentPage.companyAddressTextBox}")
	private String businessSelfEmploymentPage_companyAddressTextBox;

	@Value(value = "${businessSelfEmploymentPage.companyPhoneTextBox}")
	private String businessSelfEmploymentPage_companyPhoneTextBox;

	@Value(value = "${businessSelfEmploymentPage.companyStartDateTextBox}")
	private String businessSelfEmploymentPage_companyStartDateTextBox;

	@Value(value = "${businessSelfEmploymentPage.moreThan25PercentStakeInCompanyButton}")
	private String businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton;

	@Value(value = "${businessSelfEmploymentPage.lessThan25PercentStakeInCompanyButton}")
	private String businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton;

	@Value(value = "${businessSelfEmploymentPage.typeOfCompanyDropdown}")
	private String businessSelfEmploymentPage_typeOfCompanyDropdown;

	@Value(value = "${businessSelfEmploymentPage.nextButton}")
	private String businessSelfEmploymentPage_nextButton;

	@Value(value = "${militaryPage.pageLabel}")
	private String militaryPage_pageLabel;

	@Value(value = "${militaryPage.perMonthIncomeTextBox}")
	private String militaryPage_perMonthIncomeTextBox;

	@Value(value = "${militaryPage.nextButton}")
	private String militaryPage_nextButton;

	@Value(value = "${rentalPage.pageLabel}")
	private String rentalPage_pageLabel;

	@Value(value = "${rentalPage.rentalIncomeTextBox}")
	private String rentalPage_rentalIncomeTextBox;

	@Value(value = "${rentalPage.propertyAddressTextBox}")
	private String rentalPage_propertyAddressTextBox;

	@Value(value = "${rentalPage.propertyTypeDropdown}")
	private String rentalPage_propertyTypeDropdown;

	@Value(value = "${rentalPage.propertyStatusDropdown}")
	private String rentalPage_propertyStatusDropdown;

	@Value(value = "${rentalPage.propertyUseDropdown}")
	private String rentalPage_propertyUseDropdown;

	@Value(value = "${rentalPage.propertyValueTextBox}")
	private String rentalPage_propertyValueTextBox;

	@Value(value = "${rentalPage.monthlyRentalIncomeTextBox}")
	private String rentalPage_monthlyRentalIncomeTextBox;

	@Value(value = "${rentalPage.additionalExpenseTextBox}")
	private String rentalPage_additionalExpenseTextBox;

	@Value(value = "${rentalPage.netMonthlyRentalIncomeLabel}")
	private String rentalPage_netMonthlyRentalIncomeLabel;

	@Value(value = "${rentalPage.numberOfUnitsDropdown}")
	private String rentalPage_numberOfUnitsDropdown;

	@Value(value = "${rentalPage.iAmDoneButton}")
	private String rentalPage_iAmDoneButton;

	@Value(value = "${socialSecurityPage.pageLabel}")
	private String socialSecurityPage_pageLabel;

	@Value(value = "${socialSecurityPage.incomePerMonthTextBox}")
	private String socialSecurityPage_incomePerMonthTextBox;

	@Value(value = "${socialSecurityPage.nextButton}")
	private String socialSecurityPage_nextButton;

	@Value(value = "${interestDividendPage.pageLabel}")
	private String interestDividendPage_pageLabel;

	@Value(value = "${interestDividendPage.lastYearDividendTextBox}")
	private String interestDividendPage_lastYearDividendTextBox;

	@Value(value = "${interestDividendPage.yearBeforeLastYearDividendTextBox}")
	private String interestDividendPage_yearBeforeLastYearDividendTextBox;

	@Value(value = "${interestDividendPage.nextButton}")
	private String interestDividendPage_nextButton;

	@Value(value = "${otherIncomePage.pageLabel}")
	private String otherIncomePage_pageLabel;

	@Value(value = "${otherIncomePage.otherIncomeTextBox}")
	private String otherIncomePage_otherIncomeTextBox;

	@Value(value = "${otherIncomePage.sourceOfIncomeDropdown}")
	private String otherIncomePage_sourceOfIncomeDropdown;

	@Value(value = "${otherIncomePage.otherIncomeForMoreThan2YearsButton}")
	private String otherIncomePage_otherIncomeForMoreThan2YearsButton;

	@Value(value = "${otherIncomePage.otherIncomeForLessThan2YearsButton}")
	private String otherIncomePage_otherIncomeForLessThan2YearsButton;

	@Value(value = "${otherIncomePage.nextButton}")
	private String otherIncomePage_nextButton;

	@Value(value = "${whosOnTheLoanPage.AddAnotherCoBorrower}")
	private String whosOnTheLoanPage_AddAnotherCoBorrower;

	@Value(value = "${whosOnTheLoanPage.AddSpouseasCoBorrower}")
	private String whosOnTheLoanPage_AddSpouseasCoBorrower;

	@Value(value = "${VAorMilitaryLoanPage.NotEligibleForMilitaryLoan}")
	private String VAorMilitaryLoanPage_NotEligibleForMilitaryLoan;

	@Value(value = "${VAorMilitaryLoanPage.pageLabel}")
	private String VAorMilitaryLoanPage_pageLabel;

	@Value(value = "${VAorMilitaryLoanPage.nextButton}")
	private String VAorMilitaryLoanPage_nextButton;

	@Value(value = "${realEstateAgentPage.AgentFirstName}")
	private String realEstateAgentPage_AgentFirstName;

	@Value(value = "${purchasePropertyDetailsPage.addressUnits}")
	private String purchasePropertyDetailsPage_addressUnits;

	@Value(value = "${purchasePropertyDetailsPage.CityTextBox}")
	private String purchasePropertyDetailsPage_CityTextBox;

	@Value(value = "${purchasePropertyDetailsPage.StateDropdown}")
	private String purchasePropertyDetailsPage_StateDropdown;

	@Value(value = "${purchasePropertyDetailsPage.ZipCodeTextBox}")
	private String purchasePropertyDetailsPage_ZipCodeTextBox;

	@Value(value = "${VAorMilitaryLoanPage.EligibleForMilitaryLoan}")
	private String VAorMilitaryLoanPage_EligibleForMilitaryLoan;

	@Value(value = "${VAorMilitaryLoanPage.ActiveMilitaryDuty}")
	private String VAorMilitaryLoanPage_ActiveMilitaryDuty;

	@Value(value = "${VAorMilitaryLoanPage.RetiredMilitary}")
	private String VAorMilitaryLoanPage_RetiredMilitary;

	@Value(value = "${VAorMilitaryLoanPage.SurvivingSpouse}")
	private String VAorMilitaryLoanPage_SurvivingSpouse;

	@Value(value = "${VAorMilitaryLoanPage.NonActivatedMember}")
	private String VAorMilitaryLoanPage_NonActivatedMember;

	@Value(value = "${VAorMilitaryLoanPage.ActiveMilitaryDate}")
	private String VAorMilitaryLoanPage_ActiveMilitaryDate;

	@Value(value = "${VAorMilitaryLoanPage.ActiveMilitaryLoan}")
	private String VAorMilitaryLoanPage_ActiveMilitaryLoan;

	@Value(value = "${VAorMilitaryLoanPage.NonActiveMilitaryLoan}")
	private String VAorMilitaryLoanPage_NonActiveMilitaryLoan;

	@Value(value = "${VAorMilitaryLoanPage.PossesChildCareExpense}")
	private String VAorMilitaryLoanPage_PossesChildCareExpense;

	@Value(value = "${VAorMilitaryLoanPage.DontPossesChildCareExpense}")
	private String VAorMilitaryLoanPage_DontPossesChildCareExpense;

	@Value(value = "${VAorMilitaryLoanPage.ChildCareExpenseTextBox}")
	private String VAorMilitaryLoanPage_ChildCareExpenseTextBox;

	@Value(value = "${whosOnTheLoanPage.SpouseNotasCoBorrower}")
	private String whosOnTheLoanPage_SpouseNotasCoBorrower;

	@Value(value = "${whosOnTheLoanPage.DontAddAnotherCoBorrower}")
	private String WhosOnTheLoanPage_DontAddAnotherCoBorrower;

	@Value(value = "${whosOnTheLoanPage.spouseDateOfBirth}")
	private String whosOnTheLoanPage_spouseDateOfBirth;

	@Value(value = "${whosOnTheLoanPage.spouseSSN}")
	private String whosOnTheLoanPage_spouseSSN;

	@Value(value = "${whosOnTheLoanPage.spouseEmail}")
	private String whosOnTheLoanPage_spouseEmail;

	@Value(value = "${whosOnTheLoanPage.spousePhone}")
	private String whosOnTheLoanPage_spousePhone;

	@Value(value = "${addCoApplicantsPage.Continue}")
	private String addCoApplicantsPage_Continue;

	@Value(value = "${addCoApplicantsPage.InviteButton}")
	private String addCoApplicantsPage_InviteButton;

	@Value(value = "${primaryBorrower.pageLabel}")
	private String primaryBorrower_pageLabel;

	@Value(value = "${primaryBorrower.Next}")
	private String primaryBorrower_Next;

	@Value(value = "${incomeCompletePage.pageLabel}")
	private String incomeCompletePage_pageLabel;

	@Value(value = "${incomeCompletePage.beginSection}")
	private String incomeCompletePage_beginSection;

	@Value(value = "${declaration.JudgmentsYes}")
	private String declaration_JudgmentsYes;

	@Value(value = "${declaration.JudgmentsNo}")
	private String declaration_JudgmentsNo;

	@Value(value = "${declaration.JudgmentsCommentBox}")
	private String declaration_JudgmentsCommentBox;

	@Value(value = "${declaration.BankruptYes}")
	private String declaration_BankruptYes;

	@Value(value = "${declaration.BankruptNo}")
	private String declaration_BankruptNo;

	@Value(value = "${declaration.BankruptCommentBox}")
	private String declaration_BankruptCommentBox;

	@Value(value = "${declaration.ForeClosureYes}")
	private String declaration_ForeClosureYes;

	@Value(value = "${declaration.ForeClosureNo}")
	private String declaration_ForeClosureNo;

	@Value(value = "${declaration.ForeClosureCommentBox}")
	private String declaration_ForeClosureCommentBox;

	@Value(value = "${declaration.LawSuitePropertyYes}")
	private String declaration_LawSuitePropertyYes;

	@Value(value = "${declaration.LawSuitePropertyNo}")
	private String declaration_LawSuitePropertyNo;

	@Value(value = "${declaration.LawSuitePropertyCommentBox}")
	private String declaration_LawSuitePropertyCommentBox;

	@Value(value = "${declaration.ObligatedPropertyYes}")
	private String declaration_ObligatedPropertyYes;

	@Value(value = "${declaration.ObligatedPropertyNo}")
	private String declaration_ObligatedPropertyNo;

	@Value(value = "${declaration.ObligatedPropertyCommentBox}")
	private String declaration_ObligatedPropertyCommentBox;

	@Value(value = "${declaration.DeliquentYes}")
	private String declaration_DeliquentYes;

	@Value(value = "${declaration.DeliquentNo}")
	private String declaration_DeliquentNo;

	@Value(value = "${declaration.DeliquentCommentBox}")
	private String declaration_DeliquentCommentBox;

	@Value(value = "${declaration.ObligatedAlimonyYes}")
	private String declaration_ObligatedAlimonyYes;

	@Value(value = "${declaration.ObligatedAlimonyNo}")
	private String declaration_ObligatedAlimonyNo;

	@Value(value = "${declaration.ObligatedAlimonyCommentBox}")
	private String declaration_ObligatedAlimonyCommentBox;

	@Value(value = "${declaration.DownPaymentBorrowedYes}")
	private String declaration_DownPaymentBorrowedYes;

	@Value(value = "${declaration.DownPaymentBorrowedNo}")
	private String declaration_DownPaymentBorrowedNo;

	@Value(value = "${declaration.DownPaymentBorrowedCommentBox}")
	private String declaration_DownPaymentBorrowedCommentBox;

	@Value(value = "${declaration.CoMakerYes}")
	private String declaration_CoMakerYes;

	@Value(value = "${declaration.CoMakerNo}")
	private String declaration_CoMakerNo;

	@Value(value = "${declaration.CoMakerCommentBox}")
	private String declaration_CoMakerCommentBox;

	@Value(value = "${declaration.USCitizenYes}")
	private String declaration_USCitizenYes;

	@Value(value = "${declaration.USCitizenNo}")
	private String declaration_USCitizenNo;

	@Value(value = "${declaration.ResidentAlienYes}")
	private String declaration_ResidentAlienYes;

	@Value(value = "${declaration.ResidentAlienNo}")
	private String declaration_ResidentAlienNo;

	@Value(value = "${declaration.PrimaryResidenceYes}")
	private String declaration_PrimaryResidenceYes;

	@Value(value = "${declaration.PrimaryResidenceNo}")
	private String declaration_PrimaryResidenceNo;

	@Value(value = "${declaration.OwnershipYes}")
	private String declaration_OwnershipYes;

	@Value(value = "${declaration.OwnershipNo}")
	private String declaration_OwnershipNo;

	@Value(value = "${declaration.OwnershipTypeOfPropertyDropDown}")
	private String declaration_OwnershipTypeOfPropertyDropDown;

	@Value(value = "${declaration.OwnershipTitleToHomeDropDown}")
	private String declaration_OwnershipTitleToHomeDropDown;

	@Value(value = "${declaration.PageLabel}")
	private String declaration_PageLabel;

	@Value(value = "${declaration.Ethinicity}")
	private String declaration_Ethinicity;

	@Value(value = "${declaration.race}")
	private String declaration_race;

	@Value(value = "${declaration.Male}")
	private String declaration_Male;

	@Value(value = "${declaration.Female}")
	private String declaration_Female;

	@Value(value = "${declaration.next}")
	private String declaration_next;

	@Value(value = "${declarationCompletePage.beginSection}")
	private String declarationCompletePage_beginSection;

	@Value(value = "${Summary.PageLabel}")
	private String Summary_PageLabel;

	@Value(value = "${Summary.FullName}")
	private String Summary_FullName;

	@Value(value = "${Summary.DOB}")
	private String Summary_DOB;

	@Value(value = "${Summary.SSN}")
	private String Summary_SSN;

	@Value(value = "${Summary.PhoneNumber}")
	private String Summary_PhoneNumber;

	@Value(value = "${Summary.SelectedProperty}")
	private String Summary_SelectedProperty;

	@Value(value = "${Summary.PropertyType}")
	private String Summary_PropertyType;

	@Value(value = "${Summary.CurrentlyWorkHere}")
	private String Summary_CurrentlyWorkHere;

	@Value(value = "${Summary.EmployerName}")
	private String Summary_EmployerName;

	@Value(value = "${Summary.LoanAmount}")
	private String Summary_LoanAmount;

	@Value(value = "${Summary.TypeOfCredit}")
	private String Summary_TypeOfCredit;

	@Value(value = "${Summary.SpouseAsCoBorrower}")
	private String Summary_SpouseAsCoBorrower;

	@Value(value = "${Summary.AddAnotherCoBorrower}")
	private String Summary_AddAnotherCoBorrower;

	@Value(value = "${Summary.EligibleForMilitaryLoan}")
	private String Summary_EligibleForMilitaryLoan;

	@Value(value = "${Summary.AlimondyChildSupport}")
	private String Summary_AlimondyChildSupport;

	@Value(value = "${Summary.WorkingWithRealEstateAgent}")
	private String Summary_WorkingWithRealEstateAgent;

	@Value(value = "${Summary.CompanyName}")
	private String Summary_CompanyName;

	@Value(value = "${Summary.ResidenceSameAsSpouse}")
	private String Summary_ResidenceSameAsSpouse;

	@Value(value = "${Summary.MilitaryPay}")
	private String Summary_MilitaryPay;

	@Value(value = "${Summary.TypeOfProperty}")
	private String Summary_TypeOfProperty;

	@Value(value = "${Summary.SocialSecurityIncome}")
	private String Summary_SocialSecurityIncome;

	@Value(value = "${Summary.SourceOfIncome}")
	private String Summary_SourceOfIncome;

	@Value(value = "${Summary.AssetTotal}")
	private String Summary_AssetTotal;

	@Value(value = "${Summary.OwnedPropertyType}")
	private String Summary_OwnedPropertyType;

	@Value(value = "${Summary.Race}")
	private String Summary_Race;

	@Value(value = "${Summary.CoMakeronNote}")
	private String Summary_CoMakeronNote;

	@Value(value = "${Summary.AgreementCheckBox}")
	private String Summary_AgreementCheckBox;

	@Value(value = "${Summary.Submit}")
	private String Summary_Submit;

	@Value(value = "${SummaryCompletedPage.PageLabel}")
	private String SummaryCompletedPage_PageLabel;

	@Value(value = "${SummaryCompletedPage.ViewMyDashboard}")
	private String SummaryCompletedPage_ViewMyDashboard;

	@Value(value = "${RecentK1sPage.PageLabel}")
	private String RecentK1sPage_PageLabel;

	@Value(value = "${RecentK1sPage.UploadArea}")
	private String RecentK1sPage_UploadArea;

	@Value(value = "${RecentK1sPage.WriteExplanation}")
	private String RecentK1sPage_WriteExplanation;

	@Value(value = "${RecentK1sPage.Editor}")
	private String RecentK1sPage_Editor;

	@Value(value = "${RecentK1sPage.Next}")
	private String RecentK1sPage_Next;

	@Value(value = "${YTDPage.PageLabel}")
	private String YTDPage_PageLabel;

	@Value(value = "${YTDPage.UploadArea}")
	private String YTDPage_UploadArea;

	@Value(value = "${YTDPage.WriteExplanation}")
	private String YTDPage_WriteExplanation;

	@Value(value = "${YTDPage.Editor}")
	private String YTDPage_Editor;

	@Value(value = "${YTDPage.Next}")
	private String YTDPage_Next;

	@Value(value = "${PersonalTaxReturnsPage.DocUploadArea}")
	private String PersonalTaxReturnsPage_DocUploadArea;

	@Value(value = "${PersonalTaxReturnsPage.Next}")
	private String PersonalTaxReturnsPage_Next;

	@Value(value = "${FederalTaxReturnsPage.DocUploadArea}")
	private String FederalTaxReturnsPage_DocUploadArea;

	@Value(value = "${FederalTaxReturnsPage.Next}")
	private String FederalTaxReturnsPage_Next;

	@Value(value = "${PercentageOwnerShipPage.UploadArea}")
	private String PercentageOwnerShipPage_UploadArea;

	@Value(value = "${PercentageOwnerShipPage.WriteExplanation}")
	private String PercentageOwnerShipPage_WriteExplanation;

	@Value(value = "${PercentageOwnerShipPage.Editor}")
	private String PercentageOwnerShipPage_Editor;

	@Value(value = "${PercentageOwnerShipPage.Next}")
	private String PercentageOwnerShipPage_Next;

	@Value(value = "${PayStubPage.UploadArea}")
	private String PayStubPage_UploadArea;

	@Value(value = "${PayStubPage.Next}")
	private String PayStubPage_Next;

	@Value(value = "${RecentW2Page.UploadArea}")
	private String RecentW2Page_UploadArea;

	@Value(value = "${RecentW2Page.Next}")
	private String RecentW2Page_Next;

	@Value(value = "${PurchaseAndSalePage.UploadArea}")
	private String PurchaseAndSalePage_UploadArea;

	@Value(value = "${PurchaseAndSalePage.WriteExplanation}")
	private String PurchaseAndSalePage_WriteExplanation;

	@Value(value = "${PurchaseAndSalePage.Editor}")
	private String PurchaseAndSalePage_Editor;

	@Value(value = "${PurchaseAndSalePage.Next}")
	private String PurchaseAndSalePage_Next;

	@Value(value = "${ChildSupportPage.UploadArea}")
	private String ChildSupportPage_UploadArea;

	@Value(value = "${ChildSupportPage.Next}")
	private String ChildSupportPage_Next;

	@Value(value = "${DevorceDecreePage.UploadArea}")
	private String DevorceDecreePage_UploadArea;

	@Value(value = "${DevorceDecreePage.WriteExplanation}")
	private String DevorceDecreePage_WriteExplanation;

	@Value(value = "${DevorceDecreePage.Editor}")
	private String DevorceDecreePage_Editor;

	@Value(value = "${DevorceDecreePage.Next}")
	private String DevorceDecreePage_Next;

	@Value(value = "${COEFormPage.UploadArea}")
	private String COEFormPage_UploadArea;

	@Value(value = "${COEFormPage.Next}")
	private String COEFormPage_Next;

	@Value(value = "${CertificateOfReleasePage.UploadArea}")
	private String CertificateOfReleasePage_UploadArea;

	@Value(value = "${CertificateOfReleasePage.WriteExplanation}")
	private String CertificateOfReleasePage_WriteExplanation;

	@Value(value = "${CertificateOfReleasePage.Editor}")
	private String CertificateOfReleasePage_Editor;

	@Value(value = "${CertificateOfReleasePage.Next}")
	private String CertificateOfReleasePage_Next;

	@Value(value = "${SupplyOfStatementPage.UploadArea}")
	private String SupplyOfStatementPage_UploadArea;

	@Value(value = "${SupplyOfStatementPage.WriteExplanation}")
	private String SupplyOfStatementPage_WriteExplanation;

	@Value(value = "${SupplyOfStatementPage.Editor}")
	private String SupplyOfStatementPage_Editor;

	@Value(value = "${SupplyOfStatementPage.Next}")
	private String SupplyOfStatementPage_Next;

	@Value(value = "${SocialSecurityAwardPage.UploadArea}")
	private String SocialSecurityAwardPage_UploadArea;

	@Value(value = "${SocialSecurityAwardPage.WriteExplanation}")
	private String SocialSecurityAwardPage_WriteExplanation;

	@Value(value = "${SocialSecurityAwardPage.Editor}")
	private String SocialSecurityAwardPage_Editor;

	@Value(value = "${SocialSecurityAwardPage.Next}")
	private String SocialSecurityAwardPage_Next;

	@Value(value = "${ClosingStatementPage.UploadArea}")
	private String ClosingStatementPage_UploadArea;

	@Value(value = "${ClosingStatementPage.WriteExplanation}")
	private String ClosingStatementPage_WriteExplanation;

	@Value(value = "${ClosingStatementPage.Editor}")
	private String ClosingStatementPage_Editor;

	@Value(value = "${ClosingStatementPage.Next}")
	private String ClosingStatementPage_Next;

	@Value(value = "${WelcomeToDashboardPage.PageLabel}")
	private String WelcomeToDashboardPage_PageLabel;

	@Value(value = "${WelcomeToDashboardPage.LetsJustGo}")
	private String WelcomeToDashboardPage_LetsJustGo;

	@Value(value = "${WelcomeToDashboardPage.TakeTheTour}")
	private String WelcomeToDashboardPage_TakeTheTour;

	@Value(value = "${Dashboard.PageLabel}")
	private String Dashboard_PageLabel;

	@Value(value = "${GetStartedPage.Signup}")
	private String GetStartedPage_Signup;

	@Value(value = "${GetStartedPage.Login}")
	private String GetStartedPage_Login;

	@Value(value = "${WelcomeSignupPage.GetStarted}")
	private String WelcomeSignupPage_GetStarted;

	@Value(value = "${borrowerCommunicationPage.cellPhone}")
	private String borrowerCommunicationPage_cellPhone;

	@Value(value = "${LoanOfferPage.YesLoanOfficer}")
	private String LoanOfferPage_YesLoanOfficer;

	@Value(value = "${LoanOfferPage.NoLoanOfficer}")
	private String LoanOfferPage_NoLoanOfficer;

	@Value(value = "${LoanOfferPage.SearchLoanOfficer}")
	private String LoanOfferPage_SearchLoanOfficer;

	@Value(value = "${LoanOfferPage.NextLoanOfficer}")
	private String LoanOfferPage_NextLoanOfficer;

	public String getWelcomeToDashboardPage_PageLabel() {
		return WelcomeToDashboardPage_PageLabel;
	}

	public void setWelcomeToDashboardPage_PageLabel(String welcomeToDashboardPage_PageLabel) {
		WelcomeToDashboardPage_PageLabel = welcomeToDashboardPage_PageLabel;
	}

	public String getWelcomeToDashboardPage_LetsJustGo() {
		return WelcomeToDashboardPage_LetsJustGo;
	}

	public void setWelcomeToDashboardPage_LetsJustGo(String welcomeToDashboardPage_LetsJustGo) {
		WelcomeToDashboardPage_LetsJustGo = welcomeToDashboardPage_LetsJustGo;
	}

	public String getWelcomeToDashboardPage_TakeTheTour() {
		return WelcomeToDashboardPage_TakeTheTour;
	}

	public void setWelcomeToDashboardPage_TakeTheTour(String welcomeToDashboardPage_TakeTheTour) {
		WelcomeToDashboardPage_TakeTheTour = welcomeToDashboardPage_TakeTheTour;
	}

	public String getDashboard_PageLabel() {
		return Dashboard_PageLabel;
	}

	public void setDashboard_PageLabel(String dashboard_PageLabel) {
		Dashboard_PageLabel = dashboard_PageLabel;
	}

	public String getPercentageOwnerShipPage_UploadArea() {
		return PercentageOwnerShipPage_UploadArea;
	}

	public void setPercentageOwnerShipPage_UploadArea(String percentageOwnerShipPage_UploadArea) {
		PercentageOwnerShipPage_UploadArea = percentageOwnerShipPage_UploadArea;
	}

	public String getPercentageOwnerShipPage_WriteExplanation() {
		return PercentageOwnerShipPage_WriteExplanation;
	}

	public void setPercentageOwnerShipPage_WriteExplanation(String percentageOwnerShipPage_WriteExplanation) {
		PercentageOwnerShipPage_WriteExplanation = percentageOwnerShipPage_WriteExplanation;
	}

	public String getPercentageOwnerShipPage_Editor() {
		return PercentageOwnerShipPage_Editor;
	}

	public void setPercentageOwnerShipPage_Editor(String percentageOwnerShipPage_Editor) {
		PercentageOwnerShipPage_Editor = percentageOwnerShipPage_Editor;
	}

	public String getPercentageOwnerShipPage_Next() {
		return PercentageOwnerShipPage_Next;
	}

	public void setPercentageOwnerShipPage_Next(String percentageOwnerShipPage_Next) {
		PercentageOwnerShipPage_Next = percentageOwnerShipPage_Next;
	}

	public String getPayStubPage_UploadArea() {
		return PayStubPage_UploadArea;
	}

	public void setPayStubPage_UploadArea(String payStubPage_UploadArea) {
		PayStubPage_UploadArea = payStubPage_UploadArea;
	}

	public String getPayStubPage_Next() {
		return PayStubPage_Next;
	}

	public void setPayStubPage_Next(String payStubPage_Next) {
		PayStubPage_Next = payStubPage_Next;
	}

	public String getRecentW2Page_UploadArea() {
		return RecentW2Page_UploadArea;
	}

	public void setRecentW2Page_UploadArea(String recentW2Page_UploadArea) {
		RecentW2Page_UploadArea = recentW2Page_UploadArea;
	}

	public String getRecentW2Page_Next() {
		return RecentW2Page_Next;
	}

	public void setRecentW2Page_Next(String recentW2Page_Next) {
		RecentW2Page_Next = recentW2Page_Next;
	}

	public String getPurchaseAndSalePage_UploadArea() {
		return PurchaseAndSalePage_UploadArea;
	}

	public void setPurchaseAndSalePage_UploadArea(String purchaseAndSalePage_UploadArea) {
		PurchaseAndSalePage_UploadArea = purchaseAndSalePage_UploadArea;
	}

	public String getPurchaseAndSalePage_WriteExplanation() {
		return PurchaseAndSalePage_WriteExplanation;
	}

	public void setPurchaseAndSalePage_WriteExplanation(String purchaseAndSalePage_WriteExplanation) {
		PurchaseAndSalePage_WriteExplanation = purchaseAndSalePage_WriteExplanation;
	}

	public String getPurchaseAndSalePage_Editor() {
		return PurchaseAndSalePage_Editor;
	}

	public void setPurchaseAndSalePage_Editor(String purchaseAndSalePage_Editor) {
		PurchaseAndSalePage_Editor = purchaseAndSalePage_Editor;
	}

	public String getPurchaseAndSalePage_Next() {
		return PurchaseAndSalePage_Next;
	}

	public void setPurchaseAndSalePage_Next(String purchaseAndSalePage_Next) {
		PurchaseAndSalePage_Next = purchaseAndSalePage_Next;
	}

	public String getChildSupportPage_UploadArea() {
		return ChildSupportPage_UploadArea;
	}

	public void setChildSupportPage_UploadArea(String childSupportPage_UploadArea) {
		ChildSupportPage_UploadArea = childSupportPage_UploadArea;
	}

	public String getChildSupportPage_Next() {
		return ChildSupportPage_Next;
	}

	public void setChildSupportPage_Next(String childSupportPage_Next) {
		ChildSupportPage_Next = childSupportPage_Next;
	}

	public String getDevorceDecreePage_UploadArea() {
		return DevorceDecreePage_UploadArea;
	}

	public void setDevorceDecreePage_UploadArea(String devorceDecreePage_UploadArea) {
		DevorceDecreePage_UploadArea = devorceDecreePage_UploadArea;
	}

	public String getDevorceDecreePage_WriteExplanation() {
		return DevorceDecreePage_WriteExplanation;
	}

	public void setDevorceDecreePage_WriteExplanation(String devorceDecreePage_WriteExplanation) {
		DevorceDecreePage_WriteExplanation = devorceDecreePage_WriteExplanation;
	}

	public String getDevorceDecreePage_Editor() {
		return DevorceDecreePage_Editor;
	}

	public void setDevorceDecreePage_Editor(String devorceDecreePage_Editor) {
		DevorceDecreePage_Editor = devorceDecreePage_Editor;
	}

	public String getDevorceDecreePage_Next() {
		return DevorceDecreePage_Next;
	}

	public void setDevorceDecreePage_Next(String devorceDecreePage_Next) {
		DevorceDecreePage_Next = devorceDecreePage_Next;
	}

	public String getCOEFormPage_UploadArea() {
		return COEFormPage_UploadArea;
	}

	public void setCOEFormPage_UploadArea(String cOEFormPage_UploadArea) {
		COEFormPage_UploadArea = cOEFormPage_UploadArea;
	}

	public String getCOEFormPage_Next() {
		return COEFormPage_Next;
	}

	public void setCOEFormPage_Next(String cOEFormPage_Next) {
		COEFormPage_Next = cOEFormPage_Next;
	}

	public String getCertificateOfReleasePage_UploadArea() {
		return CertificateOfReleasePage_UploadArea;
	}

	public void setCertificateOfReleasePage_UploadArea(String certificateOfReleasePage_UploadArea) {
		CertificateOfReleasePage_UploadArea = certificateOfReleasePage_UploadArea;
	}

	public String getCertificateOfReleasePage_WriteExplanation() {
		return CertificateOfReleasePage_WriteExplanation;
	}

	public void setCertificateOfReleasePage_WriteExplanation(String certificateOfReleasePage_WriteExplanation) {
		CertificateOfReleasePage_WriteExplanation = certificateOfReleasePage_WriteExplanation;
	}

	public String getCertificateOfReleasePage_Editor() {
		return CertificateOfReleasePage_Editor;
	}

	public void setCertificateOfReleasePage_Editor(String certificateOfReleasePage_Editor) {
		CertificateOfReleasePage_Editor = certificateOfReleasePage_Editor;
	}

	public String getCertificateOfReleasePage_Next() {
		return CertificateOfReleasePage_Next;
	}

	public void setCertificateOfReleasePage_Next(String certificateOfReleasePage_Next) {
		CertificateOfReleasePage_Next = certificateOfReleasePage_Next;
	}

	public String getSupplyOfStatementPage_UploadArea() {
		return SupplyOfStatementPage_UploadArea;
	}

	public void setSupplyOfStatementPage_UploadArea(String supplyOfStatementPage_UploadArea) {
		SupplyOfStatementPage_UploadArea = supplyOfStatementPage_UploadArea;
	}

	public String getSupplyOfStatementPage_WriteExplanation() {
		return SupplyOfStatementPage_WriteExplanation;
	}

	public void setSupplyOfStatementPage_WriteExplanation(String supplyOfStatementPage_WriteExplanation) {
		SupplyOfStatementPage_WriteExplanation = supplyOfStatementPage_WriteExplanation;
	}

	public String getSupplyOfStatementPage_Editor() {
		return SupplyOfStatementPage_Editor;
	}

	public void setSupplyOfStatementPage_Editor(String supplyOfStatementPage_Editor) {
		SupplyOfStatementPage_Editor = supplyOfStatementPage_Editor;
	}

	public String getSupplyOfStatementPage_Next() {
		return SupplyOfStatementPage_Next;
	}

	public void setSupplyOfStatementPage_Next(String supplyOfStatementPage_Next) {
		SupplyOfStatementPage_Next = supplyOfStatementPage_Next;
	}

	public String getSocialSecurityAwardPage_UploadArea() {
		return SocialSecurityAwardPage_UploadArea;
	}

	public void setSocialSecurityAwardPage_UploadArea(String socialSecurityAwardPage_UploadArea) {
		SocialSecurityAwardPage_UploadArea = socialSecurityAwardPage_UploadArea;
	}

	public String getSocialSecurityAwardPage_WriteExplanation() {
		return SocialSecurityAwardPage_WriteExplanation;
	}

	public void setSocialSecurityAwardPage_WriteExplanation(String socialSecurityAwardPage_WriteExplanation) {
		SocialSecurityAwardPage_WriteExplanation = socialSecurityAwardPage_WriteExplanation;
	}

	public String getSocialSecurityAwardPage_Editor() {
		return SocialSecurityAwardPage_Editor;
	}

	public void setSocialSecurityAwardPage_Editor(String socialSecurityAwardPage_Editor) {
		SocialSecurityAwardPage_Editor = socialSecurityAwardPage_Editor;
	}

	public String getSocialSecurityAwardPage_Next() {
		return SocialSecurityAwardPage_Next;
	}

	public void setSocialSecurityAwardPage_Next(String socialSecurityAwardPage_Next) {
		SocialSecurityAwardPage_Next = socialSecurityAwardPage_Next;
	}

	public String getClosingStatementPage_UploadArea() {
		return ClosingStatementPage_UploadArea;
	}

	public void setClosingStatementPage_UploadArea(String closingStatementPage_UploadArea) {
		ClosingStatementPage_UploadArea = closingStatementPage_UploadArea;
	}

	public String getClosingStatementPage_WriteExplanation() {
		return ClosingStatementPage_WriteExplanation;
	}

	public void setClosingStatementPage_WriteExplanation(String closingStatementPage_WriteExplanation) {
		ClosingStatementPage_WriteExplanation = closingStatementPage_WriteExplanation;
	}

	public String getClosingStatementPage_Editor() {
		return ClosingStatementPage_Editor;
	}

	public void setClosingStatementPage_Editor(String closingStatementPage_Editor) {
		ClosingStatementPage_Editor = closingStatementPage_Editor;
	}

	public String getClosingStatementPage_Next() {
		return ClosingStatementPage_Next;
	}

	public void setClosingStatementPage_Next(String closingStatementPage_Next) {
		ClosingStatementPage_Next = closingStatementPage_Next;
	}

	public String getPersonalTaxReturnsPage_DocUploadArea() {
		return PersonalTaxReturnsPage_DocUploadArea;
	}

	public void setPersonalTaxReturnsPage_DocUploadArea(String personalTaxReturnsPage_DocUploadArea) {
		PersonalTaxReturnsPage_DocUploadArea = personalTaxReturnsPage_DocUploadArea;
	}

	public String getPersonalTaxReturnsPage_Next() {
		return PersonalTaxReturnsPage_Next;
	}

	public void setPersonalTaxReturnsPage_Next(String personalTaxReturnsPage_Next) {
		PersonalTaxReturnsPage_Next = personalTaxReturnsPage_Next;
	}

	public String getFederalTaxReturnsPage_DocUploadArea() {
		return FederalTaxReturnsPage_DocUploadArea;
	}

	public void setFederalTaxReturnsPage_DocUploadArea(String federalTaxReturnsPageDocUploadArea) {
		FederalTaxReturnsPage_DocUploadArea = federalTaxReturnsPageDocUploadArea;
	}

	public String getFederalTaxReturnsPage_Next() {
		return FederalTaxReturnsPage_Next;
	}

	public void setFederalTaxReturnsPage_Next(String federalTaxReturnsPage_Next) {
		FederalTaxReturnsPage_Next = federalTaxReturnsPage_Next;
	}

	public String getRecentK1sPage_PageLabel() {
		return RecentK1sPage_PageLabel;
	}

	public void setRecentK1sPage_PageLabel(String recentK1sPage_PageLabel) {
		RecentK1sPage_PageLabel = recentK1sPage_PageLabel;
	}

	public String getRecentK1sPage_UploadArea() {
		return RecentK1sPage_UploadArea;
	}

	public void setRecentK1sPage_UploadArea(String recentK1sPage_UploadArea) {
		RecentK1sPage_UploadArea = recentK1sPage_UploadArea;
	}

	public String getRecentK1sPage_WriteExplanation() {
		return RecentK1sPage_WriteExplanation;
	}

	public void setRecentK1sPage_WriteExplanation(String recentK1sPage_WriteExplanation) {
		RecentK1sPage_WriteExplanation = recentK1sPage_WriteExplanation;
	}

	public String getRecentK1sPage_Editor() {
		return RecentK1sPage_Editor;
	}

	public void setRecentK1sPage_Editor(String recentK1sPage_Editor) {
		RecentK1sPage_Editor = recentK1sPage_Editor;
	}

	public String getRecentK1sPage_Next() {
		return RecentK1sPage_Next;
	}

	public void setRecentK1sPage_Next(String recentK1sPage_Next) {
		RecentK1sPage_Next = recentK1sPage_Next;
	}

	public String getYTDPage_PageLabel() {
		return YTDPage_PageLabel;
	}

	public void setYTDPage_PageLabel(String yTDPage_PageLabel) {
		YTDPage_PageLabel = yTDPage_PageLabel;
	}

	public String getYTDPage_UploadArea() {
		return YTDPage_UploadArea;
	}

	public void setYTDPage_UploadArea(String yTDPage_UploadArea) {
		YTDPage_UploadArea = yTDPage_UploadArea;
	}

	public String getYTDPage_WriteExplanation() {
		return YTDPage_WriteExplanation;
	}

	public void setYTDPage_WriteExplanation(String yTDPage_WriteExplanation) {
		YTDPage_WriteExplanation = yTDPage_WriteExplanation;
	}

	public String getYTDPage_Editor() {
		return YTDPage_Editor;
	}

	public void setYTDPage_Editor(String yTDPage_Editor) {
		YTDPage_Editor = yTDPage_Editor;
	}

	public String getYTDPage_Next() {
		return YTDPage_Next;
	}

	public void setYTDPage_Next(String yTDPage_Next) {
		YTDPage_Next = yTDPage_Next;
	}

	public String getSummaryCompletedPage_PageLabel() {
		return SummaryCompletedPage_PageLabel;
	}

	public void setSummaryCompletedPage_PageLabel(String summaryCompletedPage_PageLabel) {
		SummaryCompletedPage_PageLabel = summaryCompletedPage_PageLabel;
	}

	public String getSummaryCompletedPage_ViewMyDashboard() {
		return SummaryCompletedPage_ViewMyDashboard;
	}

	public void setSummaryCompletedPage_ViewMyDashboard(String summaryCompletedPage_ViewMyDashboard) {
		SummaryCompletedPage_ViewMyDashboard = summaryCompletedPage_ViewMyDashboard;
	}

	public String getSummary_PageLabel() {
		return Summary_PageLabel;
	}

	public void setSummary_PageLabel(String summary_PageLabel) {
		Summary_PageLabel = summary_PageLabel;
	}

	public String getSummary_FullName() {
		return Summary_FullName;
	}

	public void setSummary_FullName(String summary_FullName) {
		Summary_FullName = summary_FullName;
	}

	public String getSummary_DOB() {
		return Summary_DOB;
	}

	public void setSummary_DOB(String summary_DOB) {
		Summary_DOB = summary_DOB;
	}

	public String getSummary_SSN() {
		return Summary_SSN;
	}

	public void setSummary_SSN(String summary_SSN) {
		Summary_SSN = summary_SSN;
	}

	public String getSummary_PhoneNumber() {
		return Summary_PhoneNumber;
	}

	public void setSummary_PhoneNumber(String summary_PhoneNumber) {
		Summary_PhoneNumber = summary_PhoneNumber;
	}

	public String getSummary_SelectedProperty() {
		return Summary_SelectedProperty;
	}

	public void setSummary_SelectedProperty(String summary_SelectedProperty) {
		Summary_SelectedProperty = summary_SelectedProperty;
	}

	public String getSummary_PropertyType() {
		return Summary_PropertyType;
	}

	public void setSummary_PropertyType(String summary_PropertyType) {
		Summary_PropertyType = summary_PropertyType;
	}

	public String getSummary_CurrentlyWorkHere() {
		return Summary_CurrentlyWorkHere;
	}

	public void setSummary_CurrentlyWorkHere(String summary_CurrentlyWorkHere) {
		Summary_CurrentlyWorkHere = summary_CurrentlyWorkHere;
	}

	public String getSummary_EmployerName() {
		return Summary_EmployerName;
	}

	public void setSummary_EmployerName(String summary_EmployerName) {
		Summary_EmployerName = summary_EmployerName;
	}

	public String getSummary_LoanAmount() {
		return Summary_LoanAmount;
	}

	public void setSummary_LoanAmount(String summary_LoanAmount) {
		Summary_LoanAmount = summary_LoanAmount;
	}

	public String getSummary_TypeOfCredit() {
		return Summary_TypeOfCredit;
	}

	public void setSummary_TypeOfCredit(String summary_TypeOfCredit) {
		Summary_TypeOfCredit = summary_TypeOfCredit;
	}

	public String getSummary_SpouseAsCoBorrower() {
		return Summary_SpouseAsCoBorrower;
	}

	public void setSummary_SpouseAsCoBorrower(String summary_SpouseAsCoBorrower) {
		Summary_SpouseAsCoBorrower = summary_SpouseAsCoBorrower;
	}

	public String getSummary_AddAnotherCoBorrower() {
		return Summary_AddAnotherCoBorrower;
	}

	public void setSummary_AddAnotherCoBorrower(String summary_AddAnotherCoBorrower) {
		Summary_AddAnotherCoBorrower = summary_AddAnotherCoBorrower;
	}

	public String getSummary_EligibleForMilitaryLoan() {
		return Summary_EligibleForMilitaryLoan;
	}

	public void setSummary_EligibleForMilitaryLoan(String summary_EligibleForMilitaryLoan) {
		Summary_EligibleForMilitaryLoan = summary_EligibleForMilitaryLoan;
	}

	public String getSummary_AlimondyChildSupport() {
		return Summary_AlimondyChildSupport;
	}

	public void setSummary_AlimondyChildSupport(String summary_AlimondyChildSupport) {
		Summary_AlimondyChildSupport = summary_AlimondyChildSupport;
	}

	public String getSummary_WorkingWithRealEstateAgent() {
		return Summary_WorkingWithRealEstateAgent;
	}

	public void setSummary_WorkingWithRealEstateAgent(String summary_WorkingWithRealEstateAgent) {
		Summary_WorkingWithRealEstateAgent = summary_WorkingWithRealEstateAgent;
	}

	public String getSummary_CompanyName() {
		return Summary_CompanyName;
	}

	public void setSummary_CompanyName(String summary_CompanyName) {
		Summary_CompanyName = summary_CompanyName;
	}

	public String getSummary_ResidenceSameAsSpouse() {
		return Summary_ResidenceSameAsSpouse;
	}

	public void setSummary_ResidenceSameAsSpouse(String summary_ResidenceSameAsSpouse) {
		Summary_ResidenceSameAsSpouse = summary_ResidenceSameAsSpouse;
	}

	public String getSummary_MilitaryPay() {
		return Summary_MilitaryPay;
	}

	public void setSummary_MilitaryPay(String summary_MilitaryPay) {
		Summary_MilitaryPay = summary_MilitaryPay;
	}

	public String getSummary_TypeOfProperty() {
		return Summary_TypeOfProperty;
	}

	public void setSummary_TypeOfProperty(String summary_TypeOfProperty) {
		Summary_TypeOfProperty = summary_TypeOfProperty;
	}

	public String getSummary_SocialSecurityIncome() {
		return Summary_SocialSecurityIncome;
	}

	public void setSummary_SocialSecurityIncome(String summary_SocialSecurityIncome) {
		Summary_SocialSecurityIncome = summary_SocialSecurityIncome;
	}

	public String getSummary_SourceOfIncome() {
		return Summary_SourceOfIncome;
	}

	public void setSummary_SourceOfIncome(String summary_SourceOfIncome) {
		Summary_SourceOfIncome = summary_SourceOfIncome;
	}

	public String getSummary_AssetTotal() {
		return Summary_AssetTotal;
	}

	public void setSummary_AssetTotal(String summary_AssetTotal) {
		Summary_AssetTotal = summary_AssetTotal;
	}

	public String getSummary_OwnedPropertyType() {
		return Summary_OwnedPropertyType;
	}

	public void setSummary_OwnedPropertyType(String summary_OwnedPropertyType) {
		Summary_OwnedPropertyType = summary_OwnedPropertyType;
	}

	public String getSummary_Race() {
		return Summary_Race;
	}

	public void setSummary_Race(String summary_Race) {
		Summary_Race = summary_Race;
	}

	public String getSummary_CoMakeronNote() {
		return Summary_CoMakeronNote;
	}

	public void setSummary_CoMakeronNote(String summary_CoMakeronNote) {
		Summary_CoMakeronNote = summary_CoMakeronNote;
	}

	public String getSummary_AgreementCheckBox() {
		return Summary_AgreementCheckBox;
	}

	public void setSummary_AgreementCheckBox(String summary_AgreementCheckBox) {
		Summary_AgreementCheckBox = summary_AgreementCheckBox;
	}

	public String getSummary_Submit() {
		return Summary_Submit;
	}

	public void setSummary_Submit(String summary_Submit) {
		Summary_Submit = summary_Submit;
	}

	public String getDeclarationCompletePage_beginSection() {
		return declarationCompletePage_beginSection;
	}

	public void setDeclarationCompletePage_beginSection(String declarationCompletePage_beginSection) {
		this.declarationCompletePage_beginSection = declarationCompletePage_beginSection;
	}

	public String getDeclaration_PageLabel() {
		return declaration_PageLabel;
	}

	public void setDeclaration_PageLabel(String declaration_PageLabel) {
		this.declaration_PageLabel = declaration_PageLabel;
	}

	public String getDeclaration_Ethinicity() {
		return declaration_Ethinicity;
	}

	public void setDeclaration_Ethinicity(String declaration_Ethinicity) {
		this.declaration_Ethinicity = declaration_Ethinicity;
	}

	public String getDeclaration_race() {
		return declaration_race;
	}

	public void setDeclaration_race(String declaration_race) {
		this.declaration_race = declaration_race;
	}

	public String getDeclaration_Male() {
		return declaration_Male;
	}

	public void setDeclaration_Male(String declaration_Male) {
		this.declaration_Male = declaration_Male;
	}

	public String getDeclaration_Female() {
		return declaration_Female;
	}

	public void setDeclaration_Female(String declaration_Female) {
		this.declaration_Female = declaration_Female;
	}

	public String getDeclaration_next() {
		return declaration_next;
	}

	public void setDeclaration_next(String declaration_next) {
		this.declaration_next = declaration_next;
	}

	public String getDeclaration_CoMakerYes() {
		return declaration_CoMakerYes;
	}

	public void setDeclaration_CoMakerYes(String declaration_CoMakerYes) {
		this.declaration_CoMakerYes = declaration_CoMakerYes;
	}

	public String getDeclaration_JudgmentsYes() {
		return declaration_JudgmentsYes;
	}

	public void setDeclaration_JudgmentsYes(String declaration_JudgmentsYes) {
		this.declaration_JudgmentsYes = declaration_JudgmentsYes;
	}

	public String getDeclaration_JudgmentsNo() {
		return declaration_JudgmentsNo;
	}

	public void setDeclaration_JudgmentsNo(String declaration_JudgmentsNo) {
		this.declaration_JudgmentsNo = declaration_JudgmentsNo;
	}

	public String getDeclaration_JudgmentsCommentBox() {
		return declaration_JudgmentsCommentBox;
	}

	public void setDeclaration_JudgmentsCommentBox(String declaration_JudgmentsCommentBox) {
		this.declaration_JudgmentsCommentBox = declaration_JudgmentsCommentBox;
	}

	public String getDeclaration_BankruptYes() {
		return declaration_BankruptYes;
	}

	public void setDeclaration_BankruptYes(String declaration_BankruptYes) {
		this.declaration_BankruptYes = declaration_BankruptYes;
	}

	public String getDeclaration_BankruptNo() {
		return declaration_BankruptNo;
	}

	public void setDeclaration_BankruptNo(String declaration_BankruptNo) {
		this.declaration_BankruptNo = declaration_BankruptNo;
	}

	public String getDeclaration_BankruptCommentBox() {
		return declaration_BankruptCommentBox;
	}

	public void setDeclaration_BankruptCommentBox(String declaration_BankruptCommentBox) {
		this.declaration_BankruptCommentBox = declaration_BankruptCommentBox;
	}

	public String getDeclaration_ForeClosureYes() {
		return declaration_ForeClosureYes;
	}

	public void setDeclaration_ForeClosureYes(String declaration_ForeClosureYes) {
		this.declaration_ForeClosureYes = declaration_ForeClosureYes;
	}

	public String getDeclaration_ForeClosureNo() {
		return declaration_ForeClosureNo;
	}

	public void setDeclaration_ForeClosureNo(String declaration_ForeClosureNo) {
		this.declaration_ForeClosureNo = declaration_ForeClosureNo;
	}

	public String getDeclaration_ForeClosureCommentBox() {
		return declaration_ForeClosureCommentBox;
	}

	public void setDeclaration_ForeClosureCommentBox(String declaration_ForeClosureCommentBox) {
		this.declaration_ForeClosureCommentBox = declaration_ForeClosureCommentBox;
	}

	public String getDeclaration_LawSuitePropertyYes() {
		return declaration_LawSuitePropertyYes;
	}

	public void setDeclaration_LawSuitePropertyYes(String declaration_LawSuitePropertyYes) {
		this.declaration_LawSuitePropertyYes = declaration_LawSuitePropertyYes;
	}

	public String getDeclaration_LawSuitePropertyNo() {
		return declaration_LawSuitePropertyNo;
	}

	public void setDeclaration_LawSuitePropertyNo(String declaration_LawSuitePropertyNo) {
		this.declaration_LawSuitePropertyNo = declaration_LawSuitePropertyNo;
	}

	public String getDeclaration_LawSuitePropertyCommentBox() {
		return declaration_LawSuitePropertyCommentBox;
	}

	public void setDeclaration_LawSuitePropertyCommentBox(String declaration_LawSuitePropertyCommentBox) {
		this.declaration_LawSuitePropertyCommentBox = declaration_LawSuitePropertyCommentBox;
	}

	public String getDeclaration_ObligatedPropertyYes() {
		return declaration_ObligatedPropertyYes;
	}

	public void setDeclaration_ObligatedPropertyYes(String declaration_ObligatedPropertyYes) {
		this.declaration_ObligatedPropertyYes = declaration_ObligatedPropertyYes;
	}

	public String getDeclaration_ObligatedPropertyNo() {
		return declaration_ObligatedPropertyNo;
	}

	public void setDeclaration_ObligatedPropertyNo(String declaration_ObligatedPropertyNo) {
		this.declaration_ObligatedPropertyNo = declaration_ObligatedPropertyNo;
	}

	public String getDeclaration_ObligatedPropertyCommentBox() {
		return declaration_ObligatedPropertyCommentBox;
	}

	public void setDeclaration_ObligatedPropertyCommentBox(String declaration_ObligatedPropertyCommentBox) {
		this.declaration_ObligatedPropertyCommentBox = declaration_ObligatedPropertyCommentBox;
	}

	public String getDeclaration_DeliquentYes() {
		return declaration_DeliquentYes;
	}

	public void setDeclaration_DeliquentYes(String declaration_DeliquentYes) {
		this.declaration_DeliquentYes = declaration_DeliquentYes;
	}

	public String getDeclaration_DeliquentNo() {
		return declaration_DeliquentNo;
	}

	public void setDeclaration_DeliquentNo(String declaration_DeliquentNo) {
		this.declaration_DeliquentNo = declaration_DeliquentNo;
	}

	public String getDeclaration_DeliquentCommentBox() {
		return declaration_DeliquentCommentBox;
	}

	public void setDeclaration_DeliquentCommentBox(String declaration_DeliquentCommentBox) {
		this.declaration_DeliquentCommentBox = declaration_DeliquentCommentBox;
	}

	public String getDeclaration_ObligatedAlimonyYes() {
		return declaration_ObligatedAlimonyYes;
	}

	public void setDeclaration_ObligatedAlimonyYes(String declaration_ObligatedAlimonyYes) {
		this.declaration_ObligatedAlimonyYes = declaration_ObligatedAlimonyYes;
	}

	public String getDeclaration_ObligatedAlimonyNo() {
		return declaration_ObligatedAlimonyNo;
	}

	public void setDeclaration_ObligatedAlimonyNo(String declaration_ObligatedAlimonyNo) {
		this.declaration_ObligatedAlimonyNo = declaration_ObligatedAlimonyNo;
	}

	public String getDeclaration_ObligatedAlimonyCommentBox() {
		return declaration_ObligatedAlimonyCommentBox;
	}

	public void setDeclaration_ObligatedAlimonyCommentBox(String declaration_ObligatedAlimonyCommentBox) {
		this.declaration_ObligatedAlimonyCommentBox = declaration_ObligatedAlimonyCommentBox;
	}

	public String getDeclaration_DownPaymentBorrowedYes() {
		return declaration_DownPaymentBorrowedYes;
	}

	public void setDeclaration_DownPaymentBorrowedYes(String declaration_DownPaymentBorrowedYes) {
		this.declaration_DownPaymentBorrowedYes = declaration_DownPaymentBorrowedYes;
	}

	public String getDeclaration_DownPaymentBorrowedNo() {
		return declaration_DownPaymentBorrowedNo;
	}

	public void setDeclaration_DownPaymentBorrowedNo(String declaration_DownPaymentBorrowedNo) {
		this.declaration_DownPaymentBorrowedNo = declaration_DownPaymentBorrowedNo;
	}

	public String getDeclaration_DownPaymentBorrowedCommentBox() {
		return declaration_DownPaymentBorrowedCommentBox;
	}

	public void setDeclaration_DownPaymentBorrowedCommentBox(String declaration_DownPaymentBorrowedCommentBox) {
		this.declaration_DownPaymentBorrowedCommentBox = declaration_DownPaymentBorrowedCommentBox;
	}

	public String getDeclaration_CoMakerNo() {
		return declaration_CoMakerNo;
	}

	public void setDeclaration_CoMakerNo(String declaration_CoMakerNo) {
		this.declaration_CoMakerNo = declaration_CoMakerNo;
	}

	public String getDeclaration_CoMakerCommentBox() {
		return declaration_CoMakerCommentBox;
	}

	public void setDeclaration_CoMakerCommentBox(String declaration_CoMakerCommentBox) {
		this.declaration_CoMakerCommentBox = declaration_CoMakerCommentBox;
	}

	public String getDeclaration_USCitizenYes() {
		return declaration_USCitizenYes;
	}

	public void setDeclaration_USCitizenYes(String declaration_USCitizenYes) {
		this.declaration_USCitizenYes = declaration_USCitizenYes;
	}

	public String getDeclaration_USCitizenNo() {
		return declaration_USCitizenNo;
	}

	public void setDeclaration_USCitizenNo(String declaration_USCitizenNo) {
		this.declaration_USCitizenNo = declaration_USCitizenNo;
	}

	public String getDeclaration_ResidentAlienYes() {
		return declaration_ResidentAlienYes;
	}

	public void setDeclaration_ResidentAlienYes(String declaration_ResidentAlienYes) {
		this.declaration_ResidentAlienYes = declaration_ResidentAlienYes;
	}

	public String getDeclaration_ResidentAlienNo() {
		return declaration_ResidentAlienNo;
	}

	public void setDeclaration_ResidentAlienNo(String declaration_ResidentAlienNo) {
		this.declaration_ResidentAlienNo = declaration_ResidentAlienNo;
	}

	public String getDeclaration_PrimaryResidenceYes() {
		return declaration_PrimaryResidenceYes;
	}

	public void setDeclaration_PrimaryResidenceYes(String declaration_PrimaryResidenceYes) {
		this.declaration_PrimaryResidenceYes = declaration_PrimaryResidenceYes;
	}

	public String getDeclaration_PrimaryResidenceNo() {
		return declaration_PrimaryResidenceNo;
	}

	public void setDeclaration_PrimaryResidenceNo(String declaration_PrimaryResidenceNo) {
		this.declaration_PrimaryResidenceNo = declaration_PrimaryResidenceNo;
	}

	public String getDeclaration_OwnershipYes() {
		return declaration_OwnershipYes;
	}

	public void setDeclaration_OwnershipYes(String declaration_OwnershipYes) {
		this.declaration_OwnershipYes = declaration_OwnershipYes;
	}

	public String getDeclaration_OwnershipNo() {
		return declaration_OwnershipNo;
	}

	public void setDeclaration_OwnershipNo(String declaration_OwnershipNo) {
		this.declaration_OwnershipNo = declaration_OwnershipNo;
	}

	public String getDeclaration_OwnershipTypeOfPropertyDropDown() {
		return declaration_OwnershipTypeOfPropertyDropDown;
	}

	public void setDeclaration_OwnershipTypeOfPropertyDropDown(String declaration_OwnershipTypeOfPropertyDropDown) {
		this.declaration_OwnershipTypeOfPropertyDropDown = declaration_OwnershipTypeOfPropertyDropDown;
	}

	public String getDeclaration_OwnershipTitleToHomeDropDown() {
		return declaration_OwnershipTitleToHomeDropDown;
	}

	public void setDeclaration_OwnershipTitleToHomeDropDown(String declaration_OwnershipTitleToHomeDropDown) {
		this.declaration_OwnershipTitleToHomeDropDown = declaration_OwnershipTitleToHomeDropDown;
	}

	public String getIncomeCompletePage_beginSection() {
		return incomeCompletePage_beginSection;
	}

	public void setIncomeCompletePage_beginSection(String incomeCompletePage_beginSection) {
		this.incomeCompletePage_beginSection = incomeCompletePage_beginSection;
	}

	public String getIncomeCompletePage_pageLabel() {
		return incomeCompletePage_pageLabel;
	}

	public void setIncomeCompletePage_pageLabel(String incomeCompletePage_pageLabel) {
		this.incomeCompletePage_pageLabel = incomeCompletePage_pageLabel;
	}

	public String getPrimaryBorrower_pageLabel() {
		return primaryBorrower_pageLabel;
	}

	public void setPrimaryBorrower_pageLabel(String primaryBorrower_pageLabel) {
		this.primaryBorrower_pageLabel = primaryBorrower_pageLabel;
	}

	public String getPrimaryBorrower_Next() {
		return primaryBorrower_Next;
	}

	public void setPrimaryBorrower_Next(String primaryBorrower_Next) {
		this.primaryBorrower_Next = primaryBorrower_Next;
	}

	public String getAddCoApplicantsPage_InviteButton() {
		return addCoApplicantsPage_InviteButton;
	}

	public void setAddCoApplicantsPage_InviteButton(String addCoApplicantsPage_InviteButton) {
		this.addCoApplicantsPage_InviteButton = addCoApplicantsPage_InviteButton;
	}

	public String getAddCoApplicantsPage_Continue() {
		return addCoApplicantsPage_Continue;
	}

	public void setAddCoApplicantsPage_Continue(String addCoApplicantsPage_Continue) {
		this.addCoApplicantsPage_Continue = addCoApplicantsPage_Continue;
	}

	public String getWhosOnTheLoanPage_spouseDateOfBirth() {
		return whosOnTheLoanPage_spouseDateOfBirth;
	}

	public void setWhosOnTheLoanPage_spouseDateOfBirth(String whosOnTheLoanPage_spouseDateOfBirth) {
		this.whosOnTheLoanPage_spouseDateOfBirth = whosOnTheLoanPage_spouseDateOfBirth;
	}

	public String getWhosOnTheLoanPage_spouseSSN() {
		return whosOnTheLoanPage_spouseSSN;
	}

	public void setWhosOnTheLoanPage_spouseSSN(String whosOnTheLoanPage_spouseSSN) {
		this.whosOnTheLoanPage_spouseSSN = whosOnTheLoanPage_spouseSSN;
	}

	public String getWhosOnTheLoanPage_spouseEmail() {
		return whosOnTheLoanPage_spouseEmail;
	}

	public void setWhosOnTheLoanPage_spouseEmail(String whosOnTheLoanPage_spouseEmail) {
		this.whosOnTheLoanPage_spouseEmail = whosOnTheLoanPage_spouseEmail;
	}

	public String getWhosOnTheLoanPage_spousePhone() {
		return whosOnTheLoanPage_spousePhone;
	}

	public void setWhosOnTheLoanPage_spousePhone(String whosOnTheLoanPage_spousePhone) {
		this.whosOnTheLoanPage_spousePhone = whosOnTheLoanPage_spousePhone;
	}

	public String getWhosOnTheLoanPage_DontAddAnotherCoBorrower() {
		return WhosOnTheLoanPage_DontAddAnotherCoBorrower;
	}

	public void setWhosOnTheLoanPage_DontAddAnotherCoBorrower(String whosOnTheLoanPage_DontAddAnotherCoBorrower) {
		WhosOnTheLoanPage_DontAddAnotherCoBorrower = whosOnTheLoanPage_DontAddAnotherCoBorrower;
	}

	public String getWhosOnTheLoanPage_SpouseNotasCoBorrower() {
		return whosOnTheLoanPage_SpouseNotasCoBorrower;
	}

	public void setWhosOnTheLoanPage_SpouseNotasCoBorrower(String whosOnTheLoanPage_SpouseNotasCoBorrower) {
		this.whosOnTheLoanPage_SpouseNotasCoBorrower = whosOnTheLoanPage_SpouseNotasCoBorrower;
	}

	public String getVAorMilitaryLoanPage_ActiveMilitaryDuty() {
		return VAorMilitaryLoanPage_ActiveMilitaryDuty;
	}

	public void setVAorMilitaryLoanPage_ActiveMilitaryDuty(String vAorMilitaryLoanPage_ActiveMilitaryDuty) {
		VAorMilitaryLoanPage_ActiveMilitaryDuty = vAorMilitaryLoanPage_ActiveMilitaryDuty;
	}

	public String getVAorMilitaryLoanPage_RetiredMilitary() {
		return VAorMilitaryLoanPage_RetiredMilitary;
	}

	public void setVAorMilitaryLoanPage_RetiredMilitary(String vAorMilitaryLoanPage_RetiredMilitary) {
		VAorMilitaryLoanPage_RetiredMilitary = vAorMilitaryLoanPage_RetiredMilitary;
	}

	public String getVAorMilitaryLoanPage_SurvivingSpouse() {
		return VAorMilitaryLoanPage_SurvivingSpouse;
	}

	public void setVAorMilitaryLoanPage_SurvivingSpouse(String vAorMilitaryLoanPage_SurvivingSpouse) {
		VAorMilitaryLoanPage_SurvivingSpouse = vAorMilitaryLoanPage_SurvivingSpouse;
	}

	public String getVAorMilitaryLoanPage_NonActivatedMember() {
		return VAorMilitaryLoanPage_NonActivatedMember;
	}

	public void setVAorMilitaryLoanPage_NonActivatedMember(String vAorMilitaryLoanPage_NonActivatedMember) {
		VAorMilitaryLoanPage_NonActivatedMember = vAorMilitaryLoanPage_NonActivatedMember;
	}

	public String getVAorMilitaryLoanPage_ActiveMilitaryDate() {
		return VAorMilitaryLoanPage_ActiveMilitaryDate;
	}

	public void setVAorMilitaryLoanPage_ActiveMilitaryDate(String vAorMilitaryLoanPage_ActiveMilitaryDate) {
		VAorMilitaryLoanPage_ActiveMilitaryDate = vAorMilitaryLoanPage_ActiveMilitaryDate;
	}

	public String getVAorMilitaryLoanPage_ActiveMilitaryLoan() {
		return VAorMilitaryLoanPage_ActiveMilitaryLoan;
	}

	public void setVAorMilitaryLoanPage_ActiveMilitaryLoan(String vAorMilitaryLoanPage_ActiveMilitaryLoan) {
		VAorMilitaryLoanPage_ActiveMilitaryLoan = vAorMilitaryLoanPage_ActiveMilitaryLoan;
	}

	public String getVAorMilitaryLoanPage_NonActiveMilitaryLoan() {
		return VAorMilitaryLoanPage_NonActiveMilitaryLoan;
	}

	public void setVAorMilitaryLoanPage_NonActiveMilitaryLoan(String vAorMilitaryLoanPage_NonActiveMilitaryLoan) {
		VAorMilitaryLoanPage_NonActiveMilitaryLoan = vAorMilitaryLoanPage_NonActiveMilitaryLoan;
	}

	public String getVAorMilitaryLoanPage_PossesChildCareExpense() {
		return VAorMilitaryLoanPage_PossesChildCareExpense;
	}

	public void setVAorMilitaryLoanPage_PossesChildCareExpense(String vAorMilitaryLoanPage_PossesChildCareExpense) {
		VAorMilitaryLoanPage_PossesChildCareExpense = vAorMilitaryLoanPage_PossesChildCareExpense;
	}

	public String getVAorMilitaryLoanPage_DontPossesChildCareExpense() {
		return VAorMilitaryLoanPage_DontPossesChildCareExpense;
	}

	public void setVAorMilitaryLoanPage_DontPossesChildCareExpense(
			String vAorMilitaryLoanPage_DontPossesChildCareExpense) {
		VAorMilitaryLoanPage_DontPossesChildCareExpense = vAorMilitaryLoanPage_DontPossesChildCareExpense;
	}

	public String getVAorMilitaryLoanPage_ChildCareExpenseTextBox() {
		return VAorMilitaryLoanPage_ChildCareExpenseTextBox;
	}

	public void setVAorMilitaryLoanPage_ChildCareExpenseTextBox(String vAorMilitaryLoanPage_ChildCareExpenseTextBox) {
		VAorMilitaryLoanPage_ChildCareExpenseTextBox = vAorMilitaryLoanPage_ChildCareExpenseTextBox;
	}

	public String getVAorMilitaryLoanPage_EligibleForMilitaryLoan() {
		return VAorMilitaryLoanPage_EligibleForMilitaryLoan;
	}

	public void setVAorMilitaryLoanPage_EligibleForMilitaryLoan(String vAorMilitaryLoanPage_EligibleForMilitaryLoan) {
		VAorMilitaryLoanPage_EligibleForMilitaryLoan = vAorMilitaryLoanPage_EligibleForMilitaryLoan;
	}

	public String getPurchasePropertyDetailsPage_CityTextBox() {
		return purchasePropertyDetailsPage_CityTextBox;
	}

	public void setPurchasePropertyDetailsPage_CityTextBox(String purchasePropertyDetailsPage_CityTextBox) {
		this.purchasePropertyDetailsPage_CityTextBox = purchasePropertyDetailsPage_CityTextBox;
	}

	public String getPurchasePropertyDetailsPage_StateDropdown() {
		return purchasePropertyDetailsPage_StateDropdown;
	}

	public void setPurchasePropertyDetailsPage_StateDropdown(String purchasePropertyDetailsPage_StateDropdown) {
		this.purchasePropertyDetailsPage_StateDropdown = purchasePropertyDetailsPage_StateDropdown;
	}

	public String getPurchasePropertyDetailsPage_ZipCodeTextBox() {
		return purchasePropertyDetailsPage_ZipCodeTextBox;
	}

	public void setPurchasePropertyDetailsPage_ZipCodeTextBox(String purchasePropertyDetailsPage_ZipCodeTextBox) {
		this.purchasePropertyDetailsPage_ZipCodeTextBox = purchasePropertyDetailsPage_ZipCodeTextBox;
	}

	public String getPurchasePropertyDetailsPage_addressUnits() {
		return purchasePropertyDetailsPage_addressUnits;
	}

	public void setPurchasePropertyDetailsPage_addressUnits(String purchasePropertyDetailsPage_addressUnits) {
		this.purchasePropertyDetailsPage_addressUnits = purchasePropertyDetailsPage_addressUnits;
	}

	public String getRealEstateAgentPage_AgentFirstName() {
		return realEstateAgentPage_AgentFirstName;
	}

	public void setRealEstateAgentPage_AgentFirstName(String realEstateAgentPage_AgentFirstName) {
		this.realEstateAgentPage_AgentFirstName = realEstateAgentPage_AgentFirstName;
	}

	public String getRealEstateAgentPage_AgentLastName() {
		return realEstateAgentPage_AgentLastName;
	}

	public void setRealEstateAgentPage_AgentLastName(String realEstateAgentPage_AgentLastName) {
		this.realEstateAgentPage_AgentLastName = realEstateAgentPage_AgentLastName;
	}

	public String getVAorMilitaryLoanPage_nextButton() {
		return VAorMilitaryLoanPage_nextButton;
	}

	public void setVAorMilitaryLoanPage_nextButton(String vAorMilitaryLoanPage_nextButton) {
		VAorMilitaryLoanPage_nextButton = vAorMilitaryLoanPage_nextButton;
	}

	public String getVAorMilitaryLoanPage_pageLabel() {
		return VAorMilitaryLoanPage_pageLabel;
	}

	public void setVAorMilitaryLoanPage_pageLabel(String vAorMilitaryLoanPage_pageLabel) {
		VAorMilitaryLoanPage_pageLabel = vAorMilitaryLoanPage_pageLabel;
	}

	public String getVAorMilitaryLoanPage_NotEligibleForMilitaryLoan() {
		return VAorMilitaryLoanPage_NotEligibleForMilitaryLoan;
	}

	public void setVAorMilitaryLoanPage_NotEligibleForMilitaryLoan(
			String vAorMilitaryLoanPage_NotEligibleForMilitaryLoan) {
		VAorMilitaryLoanPage_NotEligibleForMilitaryLoan = vAorMilitaryLoanPage_NotEligibleForMilitaryLoan;
	}

	public String getWhosOnTheLoanPage_AddSpouseasCoBorrower() {
		return whosOnTheLoanPage_AddSpouseasCoBorrower;
	}

	public void setWhosOnTheLoanPage_AddSpouseasCoBorrower(String whosOnTheLoanPage_AddSpouseasCoBorrower) {
		this.whosOnTheLoanPage_AddSpouseasCoBorrower = whosOnTheLoanPage_AddSpouseasCoBorrower;
	}

	public String getWhosOnTheLoanPage_AddAnotherCoBorrower() {
		return whosOnTheLoanPage_AddAnotherCoBorrower;
	}

	public void setWhosOnTheLoanPage_AddAnotherCoBorrower(String whosOnTheLoanPage_AddAnotherCoBorrower) {
		this.whosOnTheLoanPage_AddAnotherCoBorrower = whosOnTheLoanPage_AddAnotherCoBorrower;
	}

	public String getPurchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox() {
		return purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox;
	}

	public void setPurchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox(
			String purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox) {
		this.purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox = purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox;
	}

	public String getPurchasePropertyDetailsPage_numberOfUnitsDropdown() {
		return purchasePropertyDetailsPage_numberOfUnitsDropdown;
	}

	public void setPurchasePropertyDetailsPage_numberOfUnitsDropdown(
			String purchasePropertyDetailsPage_numberOfUnitsDropdown) {
		this.purchasePropertyDetailsPage_numberOfUnitsDropdown = purchasePropertyDetailsPage_numberOfUnitsDropdown;
	}

	public String getTellAboutYouPage_DoBTextBox() {
		return TellAboutYouPage_DoBTextBox;
	}

	public void setTellAboutYouPage_DoBTextBox(String tellAboutYouPage_DoBTextBox) {
		TellAboutYouPage_DoBTextBox = tellAboutYouPage_DoBTextBox;
	}

	public String getTellAboutYouPage_ssnTextBox() {
		return TellAboutYouPage_ssnTextBox;
	}

	public void setTellAboutYouPage_ssnTextBox(String tellAboutYouPage_ssnTextBox) {
		TellAboutYouPage_ssnTextBox = tellAboutYouPage_ssnTextBox;
	}

	public String getIncomeSearchPage_pageLabel() {
		return incomeSearchPage_pageLabel;
	}

	public void setIncomeSearchPage_pageLabel(String incomeSearchPage_pageLabel) {
		this.incomeSearchPage_pageLabel = incomeSearchPage_pageLabel;
	}

	public String getIncomeSearchPage_employmentButton() {
		return incomeSearchPage_employmentButton;
	}

	public void setIncomeSearchPage_employmentButton(String incomeSearchPage_employmentButton) {
		this.incomeSearchPage_employmentButton = incomeSearchPage_employmentButton;
	}

	public String getIncomeSearchPage_alimonyChildSupportButton() {
		return incomeSearchPage_alimonyChildSupportButton;
	}

	public void setIncomeSearchPage_alimonyChildSupportButton(String incomeSearchPage_alimonyChildSupportButton) {
		this.incomeSearchPage_alimonyChildSupportButton = incomeSearchPage_alimonyChildSupportButton;
	}

	public String getIncomeSearchPage_businessSelfEmploymentButton() {
		return incomeSearchPage_businessSelfEmploymentButton;
	}

	public void setIncomeSearchPage_businessSelfEmploymentButton(String incomeSearchPage_businessSelfEmploymentButton) {
		this.incomeSearchPage_businessSelfEmploymentButton = incomeSearchPage_businessSelfEmploymentButton;
	}

	public String getIncomeSearchPage_millitaryButton() {
		return incomeSearchPage_millitaryButton;
	}

	public void setIncomeSearchPage_millitaryButton(String incomeSearchPage_millitaryButton) {
		this.incomeSearchPage_millitaryButton = incomeSearchPage_millitaryButton;
	}

	public String getIncomeSearchPage_rentalButton() {
		return incomeSearchPage_rentalButton;
	}

	public void setIncomeSearchPage_rentalButton(String incomeSearchPage_rentalButton) {
		this.incomeSearchPage_rentalButton = incomeSearchPage_rentalButton;
	}

	public String getIncomeSearchPage_socialSecurityButton() {
		return incomeSearchPage_socialSecurityButton;
	}

	public void setIncomeSearchPage_socialSecurityButton(String incomeSearchPage_socialSecurityButton) {
		this.incomeSearchPage_socialSecurityButton = incomeSearchPage_socialSecurityButton;
	}

	public String getIncomeSearchPage_interestDividendButton() {
		return incomeSearchPage_interestDividendButton;
	}

	public void setIncomeSearchPage_interestDividendButton(String incomeSearchPage_interestDividendButton) {
		this.incomeSearchPage_interestDividendButton = incomeSearchPage_interestDividendButton;
	}

	public String getIncomeSearchPage_othertButton() {
		return incomeSearchPage_othertButton;
	}

	public void setIncomeSearchPage_othertButton(String incomeSearchPage_othertButton) {
		this.incomeSearchPage_othertButton = incomeSearchPage_othertButton;
	}

	public String getIncomeSearchPage_noIncomeButton() {
		return incomeSearchPage_noIncomeButton;
	}

	public void setIncomeSearchPage_noIncomeButton(String incomeSearchPage_noIncomeButton) {
		this.incomeSearchPage_noIncomeButton = incomeSearchPage_noIncomeButton;
	}

	public String getIncomeSearchPage_beginButton() {
		return incomeSearchPage_beginButton;
	}

	public void setIncomeSearchPage_beginButton(String incomeSearchPage_beginButton) {
		this.incomeSearchPage_beginButton = incomeSearchPage_beginButton;
	}

	public String getEmploymentPage_pageLabel() {
		return employmentPage_pageLabel;
	}

	public void setEmploymentPage_pageLabel(String employmentPage_pageLabel) {
		this.employmentPage_pageLabel = employmentPage_pageLabel;
	}

	public String getEmploymentPage_currentEmployerTextBox() {
		return employmentPage_currentEmployerTextBox;
	}

	public void setEmploymentPage_currentEmployerTextBox(String employmentPage_currentEmployerTextBox) {
		this.employmentPage_currentEmployerTextBox = employmentPage_currentEmployerTextBox;
	}

	public String getEmploymentPage_titleTextBox() {
		return employmentPage_titleTextBox;
	}

	public void setEmploymentPage_titleTextBox(String employmentPage_titleTextBox) {
		this.employmentPage_titleTextBox = employmentPage_titleTextBox;
	}

	public String getEmploymentPage_startDateTextBox() {
		return employmentPage_startDateTextBox;
	}

	public void setEmploymentPage_startDateTextBox(String employmentPage_startDateTextBox) {
		this.employmentPage_startDateTextBox = employmentPage_startDateTextBox;
	}

	public String getEmploymentPage_inThisLineYearsTextBox() {
		return employmentPage_inThisLineYearsTextBox;
	}

	public void setEmploymentPage_inThisLineYearsTextBox(String employmentPage_inThisLineYearsTextBox) {
		this.employmentPage_inThisLineYearsTextBox = employmentPage_inThisLineYearsTextBox;
	}

	public String getEmploymentPage_inThisLineMonthsTextBox() {
		return employmentPage_inThisLineMonthsTextBox;
	}

	public void setEmploymentPage_inThisLineMonthsTextBox(String employmentPage_inThisLineMonthsTextBox) {
		this.employmentPage_inThisLineMonthsTextBox = employmentPage_inThisLineMonthsTextBox;
	}

	public String getEmploymentPage_monthlyBaseSalaryTextBox() {
		return employmentPage_monthlyBaseSalaryTextBox;
	}

	public void setEmploymentPage_monthlyBaseSalaryTextBox(String employmentPage_monthlyBaseSalaryTextBox) {
		this.employmentPage_monthlyBaseSalaryTextBox = employmentPage_monthlyBaseSalaryTextBox;
	}

	public String getEmploymentPage_bonusButton() {
		return employmentPage_bonusButton;
	}

	public void setEmploymentPage_bonusButton(String employmentPage_bonusButton) {
		this.employmentPage_bonusButton = employmentPage_bonusButton;
	}

	public String getEmploymentPage_commissionButton() {
		return employmentPage_commissionButton;
	}

	public void setEmploymentPage_commissionButton(String employmentPage_commissionButton) {
		this.employmentPage_commissionButton = employmentPage_commissionButton;
	}

	public String getEmploymentPage_overtimeButton() {
		return employmentPage_overtimeButton;
	}

	public void setEmploymentPage_overtimeButton(String employmentPage_overtimeButton) {
		this.employmentPage_overtimeButton = employmentPage_overtimeButton;
	}

	public String getEmploymentPage_allButton() {
		return employmentPage_allButton;
	}

	public void setEmploymentPage_allButton(String employmentPage_allButton) {
		this.employmentPage_allButton = employmentPage_allButton;
	}

	public String getEmploymentPage_nextButton() {
		return employmentPage_nextButton;
	}

	public void setEmploymentPage_nextButton(String employmentPage_nextButton) {
		this.employmentPage_nextButton = employmentPage_nextButton;
	}

	public String getEmploymentAddressPage_pageLabel() {
		return employmentAddressPage_pageLabel;
	}

	public void setEmploymentAddressPage_pageLabel(String employmentAddressPage_pageLabel) {
		this.employmentAddressPage_pageLabel = employmentAddressPage_pageLabel;
	}

	public String getEmploymentAddressPage_businessAddressTextBox() {
		return employmentAddressPage_businessAddressTextBox;
	}

	public void setEmploymentAddressPage_businessAddressTextBox(String employmentAddressPage_businessAddressTextBox) {
		this.employmentAddressPage_businessAddressTextBox = employmentAddressPage_businessAddressTextBox;
	}

	public String getEmploymentAddressPage_phoneNumberTextBox() {
		return employmentAddressPage_phoneNumberTextBox;
	}

	public void setEmploymentAddressPage_phoneNumberTextBox(String employmentAddressPage_phoneNumberTextBox) {
		this.employmentAddressPage_phoneNumberTextBox = employmentAddressPage_phoneNumberTextBox;
	}

	public String getEmploymentAddressPage_iAmDoneButton() {
		return employmentAddressPage_iAmDoneButton;
	}

	public void setEmploymentAddressPage_iAmDoneButton(String employmentAddressPage_iAmDoneButton) {
		this.employmentAddressPage_iAmDoneButton = employmentAddressPage_iAmDoneButton;
	}

	public String getIncomeDetailsPage_pageLabel() {
		return incomeDetailsPage_pageLabel;
	}

	public void setIncomeDetailsPage_pageLabel(String incomeDetailsPage_pageLabel) {
		this.incomeDetailsPage_pageLabel = incomeDetailsPage_pageLabel;
	}

	public String getIncomeDetailsPage_dateOfBirthTextBox() {
		return incomeDetailsPage_dateOfBirthTextBox;
	}

	public void setIncomeDetailsPage_dateOfBirthTextBox(String incomeDetailsPage_dateOfBirthTextBox) {
		this.incomeDetailsPage_dateOfBirthTextBox = incomeDetailsPage_dateOfBirthTextBox;
	}

	public String getIncomeDetailsPage_ssnTextBox() {
		return incomeDetailsPage_ssnTextBox;
	}

	public void setIncomeDetailsPage_ssnTextBox(String incomeDetailsPage_ssnTextBox) {
		this.incomeDetailsPage_ssnTextBox = incomeDetailsPage_ssnTextBox;
	}

	public String getIncomeDetailsPage_findMyIncomeButton() {
		return incomeDetailsPage_findMyIncomeButton;
	}

	public void setIncomeDetailsPage_findMyIncomeButton(String incomeDetailsPage_findMyIncomeButton) {
		this.incomeDetailsPage_findMyIncomeButton = incomeDetailsPage_findMyIncomeButton;
	}

	public String getAlimondyChildSupportPage_pageLabel() {
		return alimondyChildSupportPage_pageLabel;
	}

	public void setAlimondyChildSupportPage_pageLabel(String alimondyChildSupportPage_pageLabel) {
		this.alimondyChildSupportPage_pageLabel = alimondyChildSupportPage_pageLabel;
	}

	public String getAlimondyChildSupportPage_alimonyPerMonthTextBox() {
		return alimondyChildSupportPage_alimonyPerMonthTextBox;
	}

	public void setAlimondyChildSupportPage_alimonyPerMonthTextBox(
			String alimondyChildSupportPage_alimonyPerMonthTextBox) {
		this.alimondyChildSupportPage_alimonyPerMonthTextBox = alimondyChildSupportPage_alimonyPerMonthTextBox;
	}

	public String getAlimondyChildSupportPage_alimonyStartDateTextBox() {
		return alimondyChildSupportPage_alimonyStartDateTextBox;
	}

	public void setAlimondyChildSupportPage_alimonyStartDateTextBox(
			String alimondyChildSupportPage_alimonyStartDateTextBox) {
		this.alimondyChildSupportPage_alimonyStartDateTextBox = alimondyChildSupportPage_alimonyStartDateTextBox;
	}

	public String getAlimondyChildSupportPage_childSupportPerMonthTextBox() {
		return alimondyChildSupportPage_childSupportPerMonthTextBox;
	}

	public void setAlimondyChildSupportPage_childSupportPerMonthTextBox(
			String alimondyChildSupportPage_childSupportPerMonthTextBox) {
		this.alimondyChildSupportPage_childSupportPerMonthTextBox = alimondyChildSupportPage_childSupportPerMonthTextBox;
	}

	public String getAlimondyChildSupportPage_childNameTextBox() {
		return alimondyChildSupportPage_childNameTextBox;
	}

	public void setAlimondyChildSupportPage_childNameTextBox(String alimondyChildSupportPage_childNameTextBox) {
		this.alimondyChildSupportPage_childNameTextBox = alimondyChildSupportPage_childNameTextBox;
	}

	public String getAlimondyChildSupportPage_childDoBTextBox() {
		return alimondyChildSupportPage_childDoBTextBox;
	}

	public void setAlimondyChildSupportPage_childDoBTextBox(String alimondyChildSupportPage_childDoBTextBox) {
		this.alimondyChildSupportPage_childDoBTextBox = alimondyChildSupportPage_childDoBTextBox;
	}

	public String getAlimondyChildSupportPage_nextButton() {
		return alimondyChildSupportPage_nextButton;
	}

	public void setAlimondyChildSupportPage_nextButton(String alimondyChildSupportPage_nextButton) {
		this.alimondyChildSupportPage_nextButton = alimondyChildSupportPage_nextButton;
	}

	public String getSupportPage_pageLabel() {
		return supportPage_pageLabel;
	}

	public void setSupportPage_pageLabel(String supportPage_pageLabel) {
		this.supportPage_pageLabel = supportPage_pageLabel;
	}

	public String getSupportPage_supportByCourtButton() {
		return supportPage_supportByCourtButton;
	}

	public void setSupportPage_supportByCourtButton(String supportPage_supportByCourtButton) {
		this.supportPage_supportByCourtButton = supportPage_supportByCourtButton;
	}

	public String getSupportPage_noSupportByCourtButton() {
		return supportPage_noSupportByCourtButton;
	}

	public void setSupportPage_noSupportByCourtButton(String supportPage_noSupportByCourtButton) {
		this.supportPage_noSupportByCourtButton = supportPage_noSupportByCourtButton;
	}

	public String getSupportPage_willReceiveCourtSupportButton() {
		return supportPage_willReceiveCourtSupportButton;
	}

	public void setSupportPage_willReceiveCourtSupportButton(String supportPage_willReceiveCourtSupportButton) {
		this.supportPage_willReceiveCourtSupportButton = supportPage_willReceiveCourtSupportButton;
	}

	public String getSupportPage_willNotReceiveCourtSupportButton() {
		return supportPage_willNotReceiveCourtSupportButton;
	}

	public void setSupportPage_willNotReceiveCourtSupportButton(String supportPage_willNotReceiveCourtSupportButton) {
		this.supportPage_willNotReceiveCourtSupportButton = supportPage_willNotReceiveCourtSupportButton;
	}

	public String getSupportPage_postLoanClosureSupportButton() {
		return supportPage_postLoanClosureSupportButton;
	}

	public void setSupportPage_postLoanClosureSupportButton(String supportPage_postLoanClosureSupportButton) {
		this.supportPage_postLoanClosureSupportButton = supportPage_postLoanClosureSupportButton;
	}

	public String getSupportPage_postLoanClosureNoSupportButton() {
		return supportPage_postLoanClosureNoSupportButton;
	}

	public void setSupportPage_postLoanClosureNoSupportButton(String supportPage_postLoanClosureNoSupportButton) {
		this.supportPage_postLoanClosureNoSupportButton = supportPage_postLoanClosureNoSupportButton;
	}

	public String getSupportPage_nextButton() {
		return supportPage_nextButton;
	}

	public void setSupportPage_nextButton(String supportPage_nextButton) {
		this.supportPage_nextButton = supportPage_nextButton;
	}

	public String getBusinessSelfEmploymentPage_pageLabel() {
		return businessSelfEmploymentPage_pageLabel;
	}

	public void setBusinessSelfEmploymentPage_pageLabel(String businessSelfEmploymentPage_pageLabel) {
		this.businessSelfEmploymentPage_pageLabel = businessSelfEmploymentPage_pageLabel;
	}

	public String getBusinessSelfEmploymentPage_monthlyIncomeTextBox() {
		return businessSelfEmploymentPage_monthlyIncomeTextBox;
	}

	public void setBusinessSelfEmploymentPage_monthlyIncomeTextBox(
			String businessSelfEmploymentPage_monthlyIncomeTextBox) {
		this.businessSelfEmploymentPage_monthlyIncomeTextBox = businessSelfEmploymentPage_monthlyIncomeTextBox;
	}

	public String getBusinessSelfEmploymentPage_companyNameTextBox() {
		return businessSelfEmploymentPage_companyNameTextBox;
	}

	public void setBusinessSelfEmploymentPage_companyNameTextBox(String businessSelfEmploymentPage_companyNameTextBox) {
		this.businessSelfEmploymentPage_companyNameTextBox = businessSelfEmploymentPage_companyNameTextBox;
	}

	public String getBusinessSelfEmploymentPage_titleTextBox() {
		return businessSelfEmploymentPage_titleTextBox;
	}

	public void setBusinessSelfEmploymentPage_titleTextBox(String businessSelfEmploymentPage_titleTextBox) {
		this.businessSelfEmploymentPage_titleTextBox = businessSelfEmploymentPage_titleTextBox;
	}

	public String getBusinessSelfEmploymentPage_companyAddressTextBox() {
		return businessSelfEmploymentPage_companyAddressTextBox;
	}

	public void setBusinessSelfEmploymentPage_companyAddressTextBox(
			String businessSelfEmploymentPage_companyAddressTextBox) {
		this.businessSelfEmploymentPage_companyAddressTextBox = businessSelfEmploymentPage_companyAddressTextBox;
	}

	public String getBusinessSelfEmploymentPage_companyPhoneTextBox() {
		return businessSelfEmploymentPage_companyPhoneTextBox;
	}

	public void setBusinessSelfEmploymentPage_companyPhoneTextBox(
			String businessSelfEmploymentPage_companyPhoneTextBox) {
		this.businessSelfEmploymentPage_companyPhoneTextBox = businessSelfEmploymentPage_companyPhoneTextBox;
	}

	public String getBusinessSelfEmploymentPage_companyStartDateTextBox() {
		return businessSelfEmploymentPage_companyStartDateTextBox;
	}

	public void setBusinessSelfEmploymentPage_companyStartDateTextBox(
			String businessSelfEmploymentPage_companyStartDateTextBox) {
		this.businessSelfEmploymentPage_companyStartDateTextBox = businessSelfEmploymentPage_companyStartDateTextBox;
	}

	public String getBusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton() {
		return businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton;
	}

	public void setBusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton(
			String businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton) {
		this.businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton = businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton;
	}

	public String getBusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton() {
		return businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton;
	}

	public void setBusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton(
			String businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton) {
		this.businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton = businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton;
	}

	public String getBusinessSelfEmploymentPage_typeOfCompanyDropdown() {
		return businessSelfEmploymentPage_typeOfCompanyDropdown;
	}

	public void setBusinessSelfEmploymentPage_typeOfCompanyDropdown(
			String businessSelfEmploymentPage_typeOfCompanyDropdown) {
		this.businessSelfEmploymentPage_typeOfCompanyDropdown = businessSelfEmploymentPage_typeOfCompanyDropdown;
	}

	public String getBusinessSelfEmploymentPage_nextButton() {
		return businessSelfEmploymentPage_nextButton;
	}

	public void setBusinessSelfEmploymentPage_nextButton(String businessSelfEmploymentPage_nextButton) {
		this.businessSelfEmploymentPage_nextButton = businessSelfEmploymentPage_nextButton;
	}

	public String getMilitaryPage_pageLabel() {
		return militaryPage_pageLabel;
	}

	public void setMilitaryPage_pageLabel(String militaryPage_pageLabel) {
		this.militaryPage_pageLabel = militaryPage_pageLabel;
	}

	public String getMilitaryPage_perMonthIncomeTextBox() {
		return militaryPage_perMonthIncomeTextBox;
	}

	public void setMilitaryPage_perMonthIncomeTextBox(String militaryPage_perMonthIncomeTextBox) {
		this.militaryPage_perMonthIncomeTextBox = militaryPage_perMonthIncomeTextBox;
	}

	public String getMilitaryPage_nextButton() {
		return militaryPage_nextButton;
	}

	public void setMilitaryPage_nextButton(String militaryPage_nextButton) {
		this.militaryPage_nextButton = militaryPage_nextButton;
	}

	public String getRentalPage_pageLabel() {
		return rentalPage_pageLabel;
	}

	public void setRentalPage_pageLabel(String rentalPage_pageLabel) {
		this.rentalPage_pageLabel = rentalPage_pageLabel;
	}

	public String getRentalPage_rentalIncomeTextBox() {
		return rentalPage_rentalIncomeTextBox;
	}

	public void setRentalPage_rentalIncomeTextBox(String rentalPage_rentalIncomeTextBox) {
		this.rentalPage_rentalIncomeTextBox = rentalPage_rentalIncomeTextBox;
	}

	public String getRentalPage_propertyAddressTextBox() {
		return rentalPage_propertyAddressTextBox;
	}

	public void setRentalPage_propertyAddressTextBox(String rentalPage_propertyAddressTextBox) {
		this.rentalPage_propertyAddressTextBox = rentalPage_propertyAddressTextBox;
	}

	public String getRentalPage_propertyTypeDropdown() {
		return rentalPage_propertyTypeDropdown;
	}

	public void setRentalPage_propertyTypeDropdown(String rentalPage_propertyTypeDropdown) {
		this.rentalPage_propertyTypeDropdown = rentalPage_propertyTypeDropdown;
	}

	public String getRentalPage_iAmDoneButton() {
		return rentalPage_iAmDoneButton;
	}

	public void setRentalPage_iAmDoneButton(String rentalPage_iAmDoneButton) {
		this.rentalPage_iAmDoneButton = rentalPage_iAmDoneButton;
	}

	public String getSocialSecurityPage_pageLabel() {
		return socialSecurityPage_pageLabel;
	}

	public void setSocialSecurityPage_pageLabel(String socialSecurityPage_pageLabel) {
		this.socialSecurityPage_pageLabel = socialSecurityPage_pageLabel;
	}

	public String getSocialSecurityPage_incomePerMonthTextBox() {
		return socialSecurityPage_incomePerMonthTextBox;
	}

	public void setSocialSecurityPage_incomePerMonthTextBox(String socialSecurityPage_incomePerMonthTextBox) {
		this.socialSecurityPage_incomePerMonthTextBox = socialSecurityPage_incomePerMonthTextBox;
	}

	public String getSocialSecurityPage_nextButton() {
		return socialSecurityPage_nextButton;
	}

	public void setSocialSecurityPage_nextButton(String socialSecurityPage_nextButton) {
		this.socialSecurityPage_nextButton = socialSecurityPage_nextButton;
	}

	public String getInterestDividendPage_pageLabel() {
		return interestDividendPage_pageLabel;
	}

	public void setInterestDividendPage_pageLabel(String interestDividendPage_pageLabel) {
		this.interestDividendPage_pageLabel = interestDividendPage_pageLabel;
	}

	public String getInterestDividendPage_lastYearDividendTextBox() {
		return interestDividendPage_lastYearDividendTextBox;
	}

	public void setInterestDividendPage_lastYearDividendTextBox(String interestDividendPage_lastYearDividendTextBox) {
		this.interestDividendPage_lastYearDividendTextBox = interestDividendPage_lastYearDividendTextBox;
	}

	public String getInterestDividendPage_yearBeforeLastYearDividendTextBox() {
		return interestDividendPage_yearBeforeLastYearDividendTextBox;
	}

	public void setInterestDividendPage_yearBeforeLastYearDividendTextBox(
			String interestDividendPage_yearBeforeLastYearDividendTextBox) {
		this.interestDividendPage_yearBeforeLastYearDividendTextBox = interestDividendPage_yearBeforeLastYearDividendTextBox;
	}

	public String getInterestDividendPage_nextButton() {
		return interestDividendPage_nextButton;
	}

	public void setInterestDividendPage_nextButton(String interestDividendPage_nextButton) {
		this.interestDividendPage_nextButton = interestDividendPage_nextButton;
	}

	public String getOtherIncomePage_pageLabel() {
		return otherIncomePage_pageLabel;
	}

	public void setOtherIncomePage_pageLabel(String otherIncomePage_pageLabel) {
		this.otherIncomePage_pageLabel = otherIncomePage_pageLabel;
	}

	public String getOtherIncomePage_otherIncomeTextBox() {
		return otherIncomePage_otherIncomeTextBox;
	}

	public void setOtherIncomePage_otherIncomeTextBox(String otherIncomePage_otherIncomeTextBox) {
		this.otherIncomePage_otherIncomeTextBox = otherIncomePage_otherIncomeTextBox;
	}

	public String getOtherIncomePage_sourceOfIncomeDropdown() {
		return otherIncomePage_sourceOfIncomeDropdown;
	}

	public void setOtherIncomePage_sourceOfIncomeDropdown(String otherIncomePage_sourceOfIncomeDropdown) {
		this.otherIncomePage_sourceOfIncomeDropdown = otherIncomePage_sourceOfIncomeDropdown;
	}

	public String getOtherIncomePage_otherIncomeForMoreThan2YearsButton() {
		return otherIncomePage_otherIncomeForMoreThan2YearsButton;
	}

	public void setOtherIncomePage_otherIncomeForMoreThan2YearsButton(
			String otherIncomePage_otherIncomeForMoreThan2YearsButton) {
		this.otherIncomePage_otherIncomeForMoreThan2YearsButton = otherIncomePage_otherIncomeForMoreThan2YearsButton;
	}

	public String getOtherIncomePage_otherIncomeForLessThan2YearsButton() {
		return otherIncomePage_otherIncomeForLessThan2YearsButton;
	}

	public void setOtherIncomePage_otherIncomeForLessThan2YearsButton(
			String otherIncomePage_otherIncomeForLessThan2YearsButton) {
		this.otherIncomePage_otherIncomeForLessThan2YearsButton = otherIncomePage_otherIncomeForLessThan2YearsButton;
	}

	public String getOtherIncomePage_nextButton() {
		return otherIncomePage_nextButton;
	}

	public void setOtherIncomePage_nextButton(String otherIncomePage_nextButton) {
		this.otherIncomePage_nextButton = otherIncomePage_nextButton;
	}

	public String getAssetCompletePage_beginSectionButton() {
		return assetCompletePage_beginSectionButton;
	}

	public void setAssetCompletePage_beginSectionButton(String assetCompletePage_beginSectionButton) {
		this.assetCompletePage_beginSectionButton = assetCompletePage_beginSectionButton;
	}

	public String getSpousePlaidCredential_userIdTextBox() {
		return spousePlaidCredential_userIdTextBox;
	}

	public void setSpousePlaidCredential_userIdTextBox(String spousePlaidCredential_userIdTextBox) {
		this.spousePlaidCredential_userIdTextBox = spousePlaidCredential_userIdTextBox;
	}

	public String getSpousePlaidCredential_passwordTextBox() {
		return spousePlaidCredential_passwordTextBox;
	}

	public void setSpousePlaidCredential_passwordTextBox(String spousePlaidCredential_passwordTextBox) {
		this.spousePlaidCredential_passwordTextBox = spousePlaidCredential_passwordTextBox;
	}

	public String getSpousePlaidCredential_verifyElectronicallyButton() {
		return spousePlaidCredential_verifyElectronicallyButton;
	}

	public void setSpousePlaidCredential_verifyElectronicallyButton(
			String spousePlaidCredential_verifyElectronicallyButton) {
		this.spousePlaidCredential_verifyElectronicallyButton = spousePlaidCredential_verifyElectronicallyButton;
	}

	public String getBorrowerLoginPage_emailTextbox() {
		return borrowerLoginPage_emailTextbox;
	}

	public void setBorrowerLoginPage_emailTextbox(String borrowerLoginPage_emailTextbox) {
		this.borrowerLoginPage_emailTextbox = borrowerLoginPage_emailTextbox;
	}

	public String getSpouseAssetsPage_pageLabel() {
		return spouseAssetsPage_pageLabel;
	}

	public void setSpouseAssetsPage_pageLabel(String spouseAssetsPage_pageLabel) {
		this.spouseAssetsPage_pageLabel = spouseAssetsPage_pageLabel;
	}

	public String getSpouseAssetsPage_enterManuallyButton() {
		return spouseAssetsPage_enterManuallyButton;
	}

	public void setSpouseAssetsPage_enterManuallyButton(String spouseAssetsPage_enterManuallyButton) {
		this.spouseAssetsPage_enterManuallyButton = spouseAssetsPage_enterManuallyButton;
	}

	public String getSpouseSavingAndInvestmentPage_pageLabel() {
		return spouseSavingAndInvestmentPage_pageLabel;
	}

	public void setSpouseSavingAndInvestmentPage_pageLabel(String spouseSavingAndInvestmentPage_pageLabel) {
		this.spouseSavingAndInvestmentPage_pageLabel = spouseSavingAndInvestmentPage_pageLabel;
	}

	public String getSpouseSavingAndInvestmentPage_institutionNameTextBox() {
		return spouseSavingAndInvestmentPage_institutionNameTextBox;
	}

	public void setSpouseSavingAndInvestmentPage_institutionNameTextBox(
			String spouseSavingAndInvestmentPage_institutionNameTextBox) {
		this.spouseSavingAndInvestmentPage_institutionNameTextBox = spouseSavingAndInvestmentPage_institutionNameTextBox;
	}

	public String getSpouseSavingAndInvestmentPage_accountTypeTextBox() {
		return spouseSavingAndInvestmentPage_accountTypeTextBox;
	}

	public void setSpouseSavingAndInvestmentPage_accountTypeTextBox(
			String spouseSavingAndInvestmentPage_accountTypeTextBox) {
		this.spouseSavingAndInvestmentPage_accountTypeTextBox = spouseSavingAndInvestmentPage_accountTypeTextBox;
	}

	public String getSpouseSavingAndInvestmentPage_currentBalanceTextBox() {
		return spouseSavingAndInvestmentPage_currentBalanceTextBox;
	}

	public void setSpouseSavingAndInvestmentPage_currentBalanceTextBox(
			String spouseSavingAndInvestmentPage_currentBalanceTextBox) {
		this.spouseSavingAndInvestmentPage_currentBalanceTextBox = spouseSavingAndInvestmentPage_currentBalanceTextBox;
	}

	public String getSpouseSavingAndInvestmentPage_accountNumberTextBox() {
		return spouseSavingAndInvestmentPage_accountNumberTextBox;
	}

	public void setSpouseSavingAndInvestmentPage_accountNumberTextBox(
			String spouseSavingAndInvestmentPage_accountNumberTextBox) {
		this.spouseSavingAndInvestmentPage_accountNumberTextBox = spouseSavingAndInvestmentPage_accountNumberTextBox;
	}

	public String getSpouseSavingAndInvestmentPage_accountHolderNameTextBox() {
		return spouseSavingAndInvestmentPage_accountHolderNameTextBox;
	}

	public void setSpouseSavingAndInvestmentPage_accountHolderNameTextBox(
			String spouseSavingAndInvestmentPage_accountHolderNameTextBox) {
		this.spouseSavingAndInvestmentPage_accountHolderNameTextBox = spouseSavingAndInvestmentPage_accountHolderNameTextBox;
	}

	public String getSpouseSavingAndInvestmentPage_enterButton() {
		return spouseSavingAndInvestmentPage_enterButton;
	}

	public void setSpouseSavingAndInvestmentPage_enterButton(String spouseSavingAndInvestmentPage_enterButton) {
		this.spouseSavingAndInvestmentPage_enterButton = spouseSavingAndInvestmentPage_enterButton;
	}

	public String getSpouseAssetSummaryPage_pageLabel() {
		return spouseAssetSummaryPage_pageLabel;
	}

	public void setSpouseAssetSummaryPage_pageLabel(String spouseAssetSummaryPage_pageLabel) {
		this.spouseAssetSummaryPage_pageLabel = spouseAssetSummaryPage_pageLabel;
	}

	public String getSpouseAssetSummaryPage_iAmDoneButton() {
		return spouseAssetSummaryPage_iAmDoneButton;
	}

	public void setSpouseAssetSummaryPage_iAmDoneButton(String spouseAssetSummaryPage_iAmDoneButton) {
		this.spouseAssetSummaryPage_iAmDoneButton = spouseAssetSummaryPage_iAmDoneButton;
	}

	public String getSpouseAssetSummaryPage_addAccountButton() {
		return spouseAssetSummaryPage_addAccountButton;
	}

	public void setSpouseAssetSummaryPage_addAccountButton(String spouseAssetSummaryPage_addAccountButton) {
		this.spouseAssetSummaryPage_addAccountButton = spouseAssetSummaryPage_addAccountButton;
	}

	public String getBorrowerLoginPage_passwordTextbox() {
		return borrowerLoginPage_passwordTextbox;
	}

	public void setBorrowerLoginPage_passwordTextbox(String borrowerLoginPage_passwordTextbox) {
		this.borrowerLoginPage_passwordTextbox = borrowerLoginPage_passwordTextbox;
	}

	public String getBorrowerLoginPage_signInButton() {
		return borrowerLoginPage_signInButton;
	}

	public void setBorrowerLoginPage_signInButton(String borrowerLoginPage_signInButton) {
		this.borrowerLoginPage_signInButton = borrowerLoginPage_signInButton;
	}

	public String getBorrowerLoginPage_forgetPasswordLink() {
		return borrowerLoginPage_forgetPasswordLink;
	}

	public void setBorrowerLoginPage_forgetPasswordLink(String borrowerLoginPage_forgetPasswordLink) {
		this.borrowerLoginPage_forgetPasswordLink = borrowerLoginPage_forgetPasswordLink;
	}

	public String getBorrowerLoginPage_termsAndConditionLink() {
		return borrowerLoginPage_termsAndConditionLink;
	}

	public void setBorrowerLoginPage_termsAndConditionLink(String borrowerLoginPage_termsAndConditionLink) {
		this.borrowerLoginPage_termsAndConditionLink = borrowerLoginPage_termsAndConditionLink;
	}

	public String getPlaidCredential_userIdTextBox() {
		return plaidCredential_userIdTextBox;
	}

	public void setPlaidCredential_userIdTextBox(String plaidCredential_userIdTextBox) {
		this.plaidCredential_userIdTextBox = plaidCredential_userIdTextBox;
	}

	public String getPlaidCredential_passwordTextBox() {
		return plaidCredential_passwordTextBox;
	}

	public void setPlaidCredential_passwordTextBox(String plaidCredential_passwordTextBox) {
		this.plaidCredential_passwordTextBox = plaidCredential_passwordTextBox;
	}

	public String getPlaidCredential_verifyElectronicallyButton() {
		return plaidCredential_verifyElectronicallyButton;
	}

	public void setPlaidCredential_verifyElectronicallyButton(String plaidCredential_verifyElectronicallyButton) {
		this.plaidCredential_verifyElectronicallyButton = plaidCredential_verifyElectronicallyButton;
	}

	public String getSavingAndInvestmentPage_pageLabel() {
		return savingAndInvestmentPage_pageLabel;
	}

	public void setSavingAndInvestmentPage_pageLabel(String savingAndInvestmentPage_pageLabel) {
		this.savingAndInvestmentPage_pageLabel = savingAndInvestmentPage_pageLabel;
	}

	public String getAssetSumamryPage_addAccountButton() {
		return assetSumamryPage_addAccountButton;
	}

	public void setAssetSumamryPage_addAccountButton(String assetSumamryPage_addAccountButton) {
		this.assetSumamryPage_addAccountButton = assetSumamryPage_addAccountButton;
	}

	public String getAssetSumamryPage_iAmDoneButton() {
		return assetSumamryPage_iAmDoneButton;
	}

	public void setAssetSumamryPage_iAmDoneButton(String assetSumamryPage_iAmDoneButton) {
		this.assetSumamryPage_iAmDoneButton = assetSumamryPage_iAmDoneButton;
	}

	public String getAssetsPage_pageLabel() {
		return assetsPage_pageLabel;
	}

	public void setAssetsPage_pageLabel(String assetsPage_pageLabel) {
		this.assetsPage_pageLabel = assetsPage_pageLabel;
	}

	public String getAssetsPage_enterManuallyButton() {
		return assetsPage_enterManuallyButton;
	}

	public void setAssetsPage_enterManuallyButton(String assetsPage_enterManuallyButton) {
		this.assetsPage_enterManuallyButton = assetsPage_enterManuallyButton;
	}

	public String getSavingAndInvestmentPage_institutionNameTextBox() {
		return savingAndInvestmentPage_institutionNameTextBox;
	}

	public void setSavingAndInvestmentPage_institutionNameTextBox(
			String savingAndInvestmentPage_institutionNameTextBox) {
		this.savingAndInvestmentPage_institutionNameTextBox = savingAndInvestmentPage_institutionNameTextBox;
	}

	public String getSavingAndInvestmentPage_accountTypeTextBox() {
		return savingAndInvestmentPage_accountTypeTextBox;
	}

	public void setSavingAndInvestmentPage_accountTypeTextBox(String savingAndInvestmentPage_accountTypeTextBox) {
		this.savingAndInvestmentPage_accountTypeTextBox = savingAndInvestmentPage_accountTypeTextBox;
	}

	public String getSavingAndInvestmentPage_currentBalanceTextBox() {
		return savingAndInvestmentPage_currentBalanceTextBox;
	}

	public void setSavingAndInvestmentPage_currentBalanceTextBox(String savingAndInvestmentPage_currentBalanceTextBox) {
		this.savingAndInvestmentPage_currentBalanceTextBox = savingAndInvestmentPage_currentBalanceTextBox;
	}

	public String getSavingAndInvestmentPage_accountNumberTextBox() {
		return savingAndInvestmentPage_accountNumberTextBox;
	}

	public void setSavingAndInvestmentPage_accountNumberTextBox(String savingAndInvestmentPage_accountNumberTextBox) {
		this.savingAndInvestmentPage_accountNumberTextBox = savingAndInvestmentPage_accountNumberTextBox;
	}

	public String getSavingAndInvestmentPage_accountHolderNameTextBox() {
		return savingAndInvestmentPage_accountHolderNameTextBox;
	}

	public void setSavingAndInvestmentPage_accountHolderNameTextBox(
			String savingAndInvestmentPage_accountHolderNameTextBox) {
		this.savingAndInvestmentPage_accountHolderNameTextBox = savingAndInvestmentPage_accountHolderNameTextBox;
	}

	public String getSavingAndInvestmentPage_enterButton() {
		return savingAndInvestmentPage_enterButton;
	}

	public void setSavingAndInvestmentPage_enterButton(String savingAndInvestmentPage_enterButton) {
		this.savingAndInvestmentPage_enterButton = savingAndInvestmentPage_enterButton;
	}

	public String getProfileCompletedPage_beginSectionButton() {
		return profileCompletedPage_beginSectionButton;
	}

	public void setProfileCompletedPage_beginSectionButton(String profileCompletedPage_beginSectionButton) {
		this.profileCompletedPage_beginSectionButton = profileCompletedPage_beginSectionButton;
	}

	public String getProfileCompletedPage_profileCompletionMessage() {
		return profileCompletedPage_profileCompletionMessage;
	}

	public void setProfileCompletedPage_profileCompletionMessage(String profileCompletedPage_profileCompletionMessage) {
		this.profileCompletedPage_profileCompletionMessage = profileCompletedPage_profileCompletionMessage;
	}

	public String getRealEstatePage_pageLabel() {
		return realEstatePage_pageLabel;
	}

	public void setRealEstatePage_pageLabel(String realEstatePage_pageLabel) {
		this.realEstatePage_pageLabel = realEstatePage_pageLabel;
	}

	public String getRealEstatePage_ownAdditionalPropertiesButton() {
		return realEstatePage_ownAdditionalPropertiesButton;
	}

	public void setRealEstatePage_ownAdditionalPropertiesButton(String realEstatePage_ownAdditionalPropertiesButton) {
		this.realEstatePage_ownAdditionalPropertiesButton = realEstatePage_ownAdditionalPropertiesButton;
	}

	public String getRealEstatePage_dontOwnAdditionalPropertiesButton() {
		return realEstatePage_dontOwnAdditionalPropertiesButton;
	}

	public void setRealEstatePage_dontOwnAdditionalPropertiesButton(
			String realEstatePage_dontOwnAdditionalPropertiesButton) {
		this.realEstatePage_dontOwnAdditionalPropertiesButton = realEstatePage_dontOwnAdditionalPropertiesButton;
	}

	public String getRealEstatePage_propertyAddressTextbox() {
		return realEstatePage_propertyAddressTextbox;
	}

	public void setRealEstatePage_propertyAddressTextbox(String realEstatePage_propertyAddressTextbox) {
		this.realEstatePage_propertyAddressTextbox = realEstatePage_propertyAddressTextbox;
	}

	public String getRealEstatePage_propertyValueTextbox() {
		return realEstatePage_propertyValueTextbox;
	}

	public void setRealEstatePage_propertyValueTextbox(String realEstatePage_propertyValueTextbox) {
		this.realEstatePage_propertyValueTextbox = realEstatePage_propertyValueTextbox;
	}

	public String getRealEstatePage_rentalIncomeTextbox() {
		return realEstatePage_rentalIncomeTextbox;
	}

	public void setRealEstatePage_rentalIncomeTextbox(String realEstatePage_rentalIncomeTextbox) {
		this.realEstatePage_rentalIncomeTextbox = realEstatePage_rentalIncomeTextbox;
	}

	public String getRealEstatePage_additioanlIncomeTextbox() {
		return realEstatePage_additioanlIncomeTextbox;
	}

	public void setRealEstatePage_additioanlIncomeTextbox(String realEstatePage_additioanlIncomeTextbox) {
		this.realEstatePage_additioanlIncomeTextbox = realEstatePage_additioanlIncomeTextbox;
	}

	public String getRealEstatePage_netRentalIncomeLabel() {
		return realEstatePage_netRentalIncomeLabel;
	}

	public void setRealEstatePage_netRentalIncomeLabel(String realEstatePage_netRentalIncomeLabel) {
		this.realEstatePage_netRentalIncomeLabel = realEstatePage_netRentalIncomeLabel;
	}

	public String getRealEstatePage_propertyTypeDropdown() {
		return realEstatePage_propertyTypeDropdown;
	}

	public void setRealEstatePage_propertyTypeDropdown(String realEstatePage_propertyTypeDropdown) {
		this.realEstatePage_propertyTypeDropdown = realEstatePage_propertyTypeDropdown;
	}

	public String getRealEstatePage_propertyStatusDropdown() {
		return realEstatePage_propertyStatusDropdown;
	}

	public void setRealEstatePage_propertyStatusDropdown(String realEstatePage_propertyStatusDropdown) {
		this.realEstatePage_propertyStatusDropdown = realEstatePage_propertyStatusDropdown;
	}

	public String getRealEstatePage_submitButton() {
		return realEstatePage_submitButton;
	}

	public void setRealEstatePage_submitButton(String realEstatePage_submitButton) {
		this.realEstatePage_submitButton = realEstatePage_submitButton;
	}

	public String getCurrentResidentialDetailsPage_nextButton() {
		return currentResidentialDetailsPage_nextButton;
	}

	public void setCurrentResidentialDetailsPage_nextButton(String currentResidentialDetailsPage_nextButton) {
		this.currentResidentialDetailsPage_nextButton = currentResidentialDetailsPage_nextButton;
	}

	public String getCurrentResidentialDetailsPage_pageLabel() {
		return currentResidentialDetailsPage_pageLabel;
	}

	public void setCurrentResidentialDetailsPage_pageLabel(String currentResidentialDetailsPage_pageLabel) {
		this.currentResidentialDetailsPage_pageLabel = currentResidentialDetailsPage_pageLabel;
	}

	public String getCurrentResidentialDetailsPage_sameResidenceAsSpouseButton() {
		return currentResidentialDetailsPage_sameResidenceAsSpouseButton;
	}

	public void setCurrentResidentialDetailsPage_sameResidenceAsSpouseButton(
			String currentResidentialDetailsPage_sameResidenceAsSpouseButton) {
		this.currentResidentialDetailsPage_sameResidenceAsSpouseButton = currentResidentialDetailsPage_sameResidenceAsSpouseButton;
	}

	public String getCurrentResidentialDetailsPage_notSameResidenceAsSpouseButton() {
		return currentResidentialDetailsPage_notSameResidenceAsSpouseButton;
	}

	public void setCurrentResidentialDetailsPage_notSameResidenceAsSpouseButton(
			String currentResidentialDetailsPage_notSameResidenceAsSpouseButton) {
		this.currentResidentialDetailsPage_notSameResidenceAsSpouseButton = currentResidentialDetailsPage_notSameResidenceAsSpouseButton;
	}

	public String getCurrentResidentialDetailsPage_ownButton() {
		return currentResidentialDetailsPage_ownButton;
	}

	public void setCurrentResidentialDetailsPage_ownButton(String currentResidentialDetailsPage_ownButton) {
		this.currentResidentialDetailsPage_ownButton = currentResidentialDetailsPage_ownButton;
	}

	public String getCurrentResidentialDetailsPage_rentButton() {
		return currentResidentialDetailsPage_rentButton;
	}

	public void setCurrentResidentialDetailsPage_rentButton(String currentResidentialDetailsPage_rentButton) {
		this.currentResidentialDetailsPage_rentButton = currentResidentialDetailsPage_rentButton;
	}

	public String getCurrentResidentialDetailsPage_otherButton() {
		return currentResidentialDetailsPage_otherButton;
	}

	public void setCurrentResidentialDetailsPage_otherButton(String currentResidentialDetailsPage_otherButton) {
		this.currentResidentialDetailsPage_otherButton = currentResidentialDetailsPage_otherButton;
	}

	public String getCurrentResidentialDetailsPage_currentResidenceTextbox() {
		return currentResidentialDetailsPage_currentResidenceTextbox;
	}

	public void setCurrentResidentialDetailsPage_currentResidenceTextbox(
			String currentResidentialDetailsPage_currentResidenceTextbox) {
		this.currentResidentialDetailsPage_currentResidenceTextbox = currentResidentialDetailsPage_currentResidenceTextbox;
	}

	public String getCurrentResidentialDetailsPage_stayingHereSinceTextbox() {
		return currentResidentialDetailsPage_stayingHereSinceTextbox;
	}

	public void setCurrentResidentialDetailsPage_stayingHereSinceTextbox(
			String currentResidentialDetailsPage_stayingHereSinceTextbox) {
		this.currentResidentialDetailsPage_stayingHereSinceTextbox = currentResidentialDetailsPage_stayingHereSinceTextbox;
	}

	public String getCurrentResidentialDetailsPage_bothAddressSameCheckbox() {
		return currentResidentialDetailsPage_bothAddressSameCheckbox;
	}

	public void setCurrentResidentialDetailsPage_bothAddressSameCheckbox(
			String currentResidentialDetailsPage_bothAddressSameCheckbox) {
		this.currentResidentialDetailsPage_bothAddressSameCheckbox = currentResidentialDetailsPage_bothAddressSameCheckbox;
	}

	public String getCurrentResidentialDetailsPage_planningToSellButton() {
		return currentResidentialDetailsPage_planningToSellButton;
	}

	public void setCurrentResidentialDetailsPage_planningToSellButton(
			String currentResidentialDetailsPage_planningToSellButton) {
		this.currentResidentialDetailsPage_planningToSellButton = currentResidentialDetailsPage_planningToSellButton;
	}

	public String getCurrentResidentialDetailsPage_notPlanningToSellButton() {
		return currentResidentialDetailsPage_notPlanningToSellButton;
	}

	public void setCurrentResidentialDetailsPage_notPlanningToSellButton(
			String currentResidentialDetailsPage_notPlanningToSellButton) {
		this.currentResidentialDetailsPage_notPlanningToSellButton = currentResidentialDetailsPage_notPlanningToSellButton;
	}

	public String getRealEstateAgentPage_pageLabel() {
		return realEstateAgentPage_pageLabel;
	}

	public void setRealEstateAgentPage_pageLabel(String realEstateAgentPage_pageLabel) {
		this.realEstateAgentPage_pageLabel = realEstateAgentPage_pageLabel;
	}

	public String getRealEstateAgentPage_workingWithAgentButton() {
		return realEstateAgentPage_workingWithAgentButton;
	}

	public void setRealEstateAgentPage_workingWithAgentButton(String realEstateAgentPage_workingWithAgentButton) {
		this.realEstateAgentPage_workingWithAgentButton = realEstateAgentPage_workingWithAgentButton;
	}

	public String getRealEstateAgentPage_notWorkingWithAgentButton() {
		return realEstateAgentPage_notWorkingWithAgentButton;
	}

	public void setRealEstateAgentPage_notWorkingWithAgentButton(String realEstateAgentPage_notWorkingWithAgentButton) {
		this.realEstateAgentPage_notWorkingWithAgentButton = realEstateAgentPage_notWorkingWithAgentButton;
	}

	public String getRealEstateAgentPage_referAgentButton() {
		return realEstateAgentPage_referAgentButton;
	}

	public void setRealEstateAgentPage_referAgentButton(String realEstateAgentPage_referAgentButton) {
		this.realEstateAgentPage_referAgentButton = realEstateAgentPage_referAgentButton;
	}

	public String getRealEstateAgentPage_notReferAgentButton() {
		return realEstateAgentPage_notReferAgentButton;
	}

	public void setRealEstateAgentPage_notReferAgentButton(String realEstateAgentPage_notReferAgentButton) {
		this.realEstateAgentPage_notReferAgentButton = realEstateAgentPage_notReferAgentButton;
	}

	public String getRealEstateAgentPage_nextButton() {
		return realEstateAgentPage_nextButton;
	}

	public void setRealEstateAgentPage_nextButton(String realEstateAgentPage_nextButton) {
		this.realEstateAgentPage_nextButton = realEstateAgentPage_nextButton;
	}

	public String getLoanEligibilityPage_pageLabel() {
		return loanEligibilityPage_pageLabel;
	}

	public void setLoanEligibilityPage_pageLabel(String loanEligibilityPage_pageLabel) {
		this.loanEligibilityPage_pageLabel = loanEligibilityPage_pageLabel;
	}

	public String getLoanEligibilityPage_eligibleForLoanButton() {
		return loanEligibilityPage_eligibleForLoanButton;
	}

	public void setLoanEligibilityPage_eligibleForLoanButton(String loanEligibilityPage_eligibleForLoanButton) {
		this.loanEligibilityPage_eligibleForLoanButton = loanEligibilityPage_eligibleForLoanButton;
	}

	public String getLoanEligibilityPage_notEligibleForLoanButton() {
		return loanEligibilityPage_notEligibleForLoanButton;
	}

	public void setLoanEligibilityPage_notEligibleForLoanButton(String loanEligibilityPage_notEligibleForLoanButton) {
		this.loanEligibilityPage_notEligibleForLoanButton = loanEligibilityPage_notEligibleForLoanButton;
	}

	public String getLoanEligibilityPage_haveCurrentLoanButton() {
		return loanEligibilityPage_haveCurrentLoanButton;
	}

	public void setLoanEligibilityPage_haveCurrentLoanButton(String loanEligibilityPage_haveCurrentLoanButton) {
		this.loanEligibilityPage_haveCurrentLoanButton = loanEligibilityPage_haveCurrentLoanButton;
	}

	public String getLoanEligibilityPage_noCurrentLoanButton() {
		return loanEligibilityPage_noCurrentLoanButton;
	}

	public void setLoanEligibilityPage_noCurrentLoanButton(String loanEligibilityPage_noCurrentLoanButton) {
		this.loanEligibilityPage_noCurrentLoanButton = loanEligibilityPage_noCurrentLoanButton;
	}

	public String getLoanEligibilityPage_nextButton() {
		return loanEligibilityPage_nextButton;
	}

	public void setLoanEligibilityPage_nextButton(String loanEligibilityPage_nextButton) {
		this.loanEligibilityPage_nextButton = loanEligibilityPage_nextButton;
	}

	public String getApplicantInformationPage_pageLabel() {
		return applicantInformationPage_pageLabel;
	}

	public void setApplicantInformationPage_pageLabel(String applicantInformationPage_pageLabel) {
		this.applicantInformationPage_pageLabel = applicantInformationPage_pageLabel;
	}

	public String getApplicantInformationPage_nextButton() {
		return applicantInformationPage_nextButton;
	}

	public void setApplicantInformationPage_nextButton(String applicantInformationPage_nextButton) {
		this.applicantInformationPage_nextButton = applicantInformationPage_nextButton;
	}

	public String getApplicantInformationPage_coborrowerLabel() {
		return applicantInformationPage_coborrowerLabel;
	}

	public void setApplicantInformationPage_coborrowerLabel(String applicantInformationPage_coborrowerLabel) {
		this.applicantInformationPage_coborrowerLabel = applicantInformationPage_coborrowerLabel;
	}

	public String getApplicantInformationPage_coborrowerNameLabel() {
		return applicantInformationPage_coborrowerNameLabel;
	}

	public void setApplicantInformationPage_coborrowerNameLabel(String applicantInformationPage_coborrowerNameLabel) {
		this.applicantInformationPage_coborrowerNameLabel = applicantInformationPage_coborrowerNameLabel;
	}

	public String getApplicantInformationPage_progressBarLabel() {
		return applicantInformationPage_progressBarLabel;
	}

	public void setApplicantInformationPage_progressBarLabel(String applicantInformationPage_progressBarLabel) {
		this.applicantInformationPage_progressBarLabel = applicantInformationPage_progressBarLabel;
	}

	public String getSpouseInformationPage_pageLabel() {
		return spouseInformationPage_pageLabel;
	}

	public void setSpouseInformationPage_pageLabel(String spouseInformationPage_pageLabel) {
		this.spouseInformationPage_pageLabel = spouseInformationPage_pageLabel;
	}

	public String getNonSpouseInformationPage_pageLabel() {
		return nonSpouseInformationPage_pageLabel;
	}

	public void setNonSpouseInformationPage_pageLabel(String nonSpouseInformationPage_pageLabel) {
		this.nonSpouseInformationPage_pageLabel = nonSpouseInformationPage_pageLabel;
	}

	public String getNonSpouseInformationPage_firstNameTextbox() {
		return nonSpouseInformationPage_firstNameTextbox;
	}

	public void setNonSpouseInformationPage_firstNameTextbox(String nonSpouseInformationPage_firstNameTextbox) {
		this.nonSpouseInformationPage_firstNameTextbox = nonSpouseInformationPage_firstNameTextbox;
	}

	public String getNonSpouseInformationPage_middleNameTextbox() {
		return nonSpouseInformationPage_middleNameTextbox;
	}

	public void setNonSpouseInformationPage_middleNameTextbox(String nonSpouseInformationPage_middleNameTextbox) {
		this.nonSpouseInformationPage_middleNameTextbox = nonSpouseInformationPage_middleNameTextbox;
	}

	public String getNonSpouseInformationPage_lastNameTextbox() {
		return nonSpouseInformationPage_lastNameTextbox;
	}

	public void setNonSpouseInformationPage_lastNameTextbox(String nonSpouseInformationPage_lastNameTextbox) {
		this.nonSpouseInformationPage_lastNameTextbox = nonSpouseInformationPage_lastNameTextbox;
	}

	public String getNonSpouseInformationPage_suffixTextbox() {
		return nonSpouseInformationPage_suffixTextbox;
	}

	public void setNonSpouseInformationPage_suffixTextbox(String nonSpouseInformationPage_suffixTextbox) {
		this.nonSpouseInformationPage_suffixTextbox = nonSpouseInformationPage_suffixTextbox;
	}

	public String getNonSpouseInformationPage_preferredEmailTextbox() {
		return nonSpouseInformationPage_preferredEmailTextbox;
	}

	public void setNonSpouseInformationPage_preferredEmailTextbox(
			String nonSpouseInformationPage_preferredEmailTextbox) {
		this.nonSpouseInformationPage_preferredEmailTextbox = nonSpouseInformationPage_preferredEmailTextbox;
	}

	public String getNonSpouseInformationPage_phoneTextbox() {
		return nonSpouseInformationPage_phoneTextbox;
	}

	public void setNonSpouseInformationPage_phoneTextbox(String nonSpouseInformationPage_phoneTextbox) {
		this.nonSpouseInformationPage_phoneTextbox = nonSpouseInformationPage_phoneTextbox;
	}

	public String getNonSpouseInformationPage_nextButton() {
		return nonSpouseInformationPage_nextButton;
	}

	public void setNonSpouseInformationPage_nextButton(String nonSpouseInformationPage_nextButton) {
		this.nonSpouseInformationPage_nextButton = nonSpouseInformationPage_nextButton;
	}

	public String getWhosOnTheLoanPage_pageLabel() {
		return whosOnTheLoanPage_pageLabel;
	}

	public void setWhosOnTheLoanPage_pageLabel(String whosOnTheLoanPage_pageLabel) {
		this.whosOnTheLoanPage_pageLabel = whosOnTheLoanPage_pageLabel;
	}

	public String getWhosOnTheLoanPage_marriedButton() {
		return whosOnTheLoanPage_marriedButton;
	}

	public void setWhosOnTheLoanPage_marriedButton(String whosOnTheLoanPage_marriedButton) {
		this.whosOnTheLoanPage_marriedButton = whosOnTheLoanPage_marriedButton;
	}

	public String getWhosOnTheLoanPage_separatedButton() {
		return whosOnTheLoanPage_separatedButton;
	}

	public void setWhosOnTheLoanPage_separatedButton(String whosOnTheLoanPage_separatedButton) {
		this.whosOnTheLoanPage_separatedButton = whosOnTheLoanPage_separatedButton;
	}

	public String getWhosOnTheLoanPage_unmarriedButton() {
		return whosOnTheLoanPage_unmarriedButton;
	}

	public void setWhosOnTheLoanPage_unmarriedButton(String whosOnTheLoanPage_unmarriedButton) {
		this.whosOnTheLoanPage_unmarriedButton = whosOnTheLoanPage_unmarriedButton;
	}

	public String getWhosOnTheLoanPage_individualCreditCheckbox() {
		return whosOnTheLoanPage_individualCreditCheckbox;
	}

	public void setWhosOnTheLoanPage_individualCreditCheckbox(String whosOnTheLoanPage_individualCreditCheckbox) {
		this.whosOnTheLoanPage_individualCreditCheckbox = whosOnTheLoanPage_individualCreditCheckbox;
	}

	public String getWhosOnTheLoanPage_jointCreditCheckbox() {
		return whosOnTheLoanPage_jointCreditCheckbox;
	}

	public void setWhosOnTheLoanPage_jointCreditCheckbox(String whosOnTheLoanPage_jointCreditCheckbox) {
		this.whosOnTheLoanPage_jointCreditCheckbox = whosOnTheLoanPage_jointCreditCheckbox;
	}

	public String getSpouseInformationPage_firstNameTextbox() {
		return spouseInformationPage_firstNameTextbox;
	}

	public void setSpouseInformationPage_firstNameTextbox(String spouseInformationPage_firstNameTextbox) {
		this.spouseInformationPage_firstNameTextbox = spouseInformationPage_firstNameTextbox;
	}

	public String getSpouseInformationPage_middleNameTextbox() {
		return spouseInformationPage_middleNameTextbox;
	}

	public void setSpouseInformationPage_middleNameTextbox(String spouseInformationPage_middleNameTextbox) {
		this.spouseInformationPage_middleNameTextbox = spouseInformationPage_middleNameTextbox;
	}

	public String getSpouseInformationPage_lastNameTextbox() {
		return spouseInformationPage_lastNameTextbox;
	}

	public void setSpouseInformationPage_lastNameTextbox(String spouseInformationPage_lastNameTextbox) {
		this.spouseInformationPage_lastNameTextbox = spouseInformationPage_lastNameTextbox;
	}

	public String getSpouseInformationPage_suffixNameTextbox() {
		return spouseInformationPage_suffixNameTextbox;
	}

	public void setSpouseInformationPage_suffixNameTextbox(String spouseInformationPage_suffixNameTextbox) {
		this.spouseInformationPage_suffixNameTextbox = spouseInformationPage_suffixNameTextbox;
	}

	public String getSpouseInformationPage_dObTextBox() {
		return spouseInformationPage_dObTextBox;
	}

	public void setSpouseInformationPage_dObTextBox(String spouseInformationPage_dObTextBox) {
		this.spouseInformationPage_dObTextBox = spouseInformationPage_dObTextBox;
	}

	public String getSpouseInformationPage_ssnTextBox() {
		return spouseInformationPage_ssnTextBox;
	}

	public void setSpouseInformationPage_ssnTextBox(String spouseInformationPage_ssnTextBox) {
		this.spouseInformationPage_ssnTextBox = spouseInformationPage_ssnTextBox;
	}

	public String getSpouseCommunicationPage_preferredEmailTextbox() {
		return spouseCommunicationPage_preferredEmailTextbox;
	}

	public void setSpouseCommunicationPage_preferredEmailTextbox(String spouseCommunicationPage_preferredEmailTextbox) {
		this.spouseCommunicationPage_preferredEmailTextbox = spouseCommunicationPage_preferredEmailTextbox;
	}

	public String getSpouseCommunicationPage_phoneTextbox() {
		return spouseCommunicationPage_phoneTextbox;
	}

	public void setSpouseCommunicationPage_phoneTextbox(String spouseCommunicationPage_phoneTextbox) {
		this.spouseCommunicationPage_phoneTextbox = spouseCommunicationPage_phoneTextbox;
	}

	public String getSpouseCommunicationPage_phoneButton() {
		return spouseCommunicationPage_phoneButton;
	}

	public void setSpouseCommunicationPage_phoneButton(String spouseCommunicationPage_phoneButton) {
		this.spouseCommunicationPage_phoneButton = spouseCommunicationPage_phoneButton;
	}

	public String getSpouseCommunicationPage_emailButton() {
		return spouseCommunicationPage_emailButton;
	}

	public void setSpouseCommunicationPage_emailButton(String spouseCommunicationPage_emailButton) {
		this.spouseCommunicationPage_emailButton = spouseCommunicationPage_emailButton;
	}

	public String getSpouseCommunicationPage_textButton() {
		return spouseCommunicationPage_textButton;
	}

	public void setSpouseCommunicationPage_textButton(String spouseCommunicationPage_textButton) {
		this.spouseCommunicationPage_textButton = spouseCommunicationPage_textButton;
	}

	public String getSpouseCommunicationPage_allButton() {
		return spouseCommunicationPage_allButton;
	}

	public void setSpouseCommunicationPage_allButton(String spouseCommunicationPage_allButton) {
		this.spouseCommunicationPage_allButton = spouseCommunicationPage_allButton;
	}

	public String getSpouseCommunicationPage_nextButton() {
		return spouseCommunicationPage_nextButton;
	}

	public void setSpouseCommunicationPage_nextButton(String spouseCommunicationPage_nextButton) {
		this.spouseCommunicationPage_nextButton = spouseCommunicationPage_nextButton;
	}

	public String getSpouseInformationPage_nextButton() {
		return spouseInformationPage_nextButton;
	}

	public void setSpouseInformationPage_nextButton(String spouseInformationPage_nextButton) {
		this.spouseInformationPage_nextButton = spouseInformationPage_nextButton;
	}

	public String getPurchasePropertyDetailsPage_pageLabel() {
		return purchasePropertyDetailsPage_pageLabel;
	}

	public void setPurchasePropertyDetailsPage_pageLabel(String purchasePropertyDetailsPage_pageLabel) {
		this.purchasePropertyDetailsPage_pageLabel = purchasePropertyDetailsPage_pageLabel;
	}

	public String getLoanAmountPage_pageLabel() {
		return loanAmountPage_pageLabel;
	}

	public void setLoanAmountPage_pageLabel(String loanAmountPage_pageLabel) {
		this.loanAmountPage_pageLabel = loanAmountPage_pageLabel;
	}

	public String getLoanAmountPage_purchasePriceTextbox() {
		return loanAmountPage_purchasePriceTextbox;
	}

	public void setLoanAmountPage_purchasePriceTextbox(String loanAmountPage_purchasePriceTextbox) {
		this.loanAmountPage_purchasePriceTextbox = loanAmountPage_purchasePriceTextbox;
	}

	public String getLoanAmountPage_downPaymentTextbox() {
		return loanAmountPage_downPaymentTextbox;
	}

	public void setLoanAmountPage_downPaymentTextbox(String loanAmountPage_downPaymentTextbox) {
		this.loanAmountPage_downPaymentTextbox = loanAmountPage_downPaymentTextbox;
	}

	public String getLoanAmountPage_nextButton() {
		return loanAmountPage_nextButton;
	}

	public void setLoanAmountPage_nextButton(String loanAmountPage_nextButton) {
		this.loanAmountPage_nextButton = loanAmountPage_nextButton;
	}

	public String getLoanAmountPage_loanAmountTextbox() {
		return loanAmountPage_loanAmountTextbox;
	}

	public void setLoanAmountPage_loanAmountTextbox(String loanAmountPage_loanAmountTextbox) {
		this.loanAmountPage_loanAmountTextbox = loanAmountPage_loanAmountTextbox;
	}

	public String getLoanAmountPage_loanPercentageTextbox() {
		return loanAmountPage_loanPercentageTextbox;
	}

	public void setLoanAmountPage_loanPercentageTextbox(String loanAmountPage_loanPercentageTextbox) {
		this.loanAmountPage_loanPercentageTextbox = loanAmountPage_loanPercentageTextbox;
	}

	public String getPurchasePropertyDetailsPage_propertyTypeDropdown() {
		return purchasePropertyDetailsPage_propertyTypeDropdown;
	}

	public void setPurchasePropertyDetailsPage_propertyTypeDropdown(
			String purchasePropertyDetailsPage_propertyTypeDropdown) {
		this.purchasePropertyDetailsPage_propertyTypeDropdown = purchasePropertyDetailsPage_propertyTypeDropdown;
	}

	public String getPurchasePropertyDetailsPage_selectedProperty() {
		return purchasePropertyDetailsPage_selectedProperty;
	}

	public void setPurchasePropertyDetailsPage_selectedProperty(String purchasePropertyDetailsPage_selectedProperty) {
		this.purchasePropertyDetailsPage_selectedProperty = purchasePropertyDetailsPage_selectedProperty;
	}

	public String getPurchasePropertyDetailsPage_notSelectedProperty() {
		return purchasePropertyDetailsPage_notSelectedProperty;
	}

	public void setPurchasePropertyDetailsPage_notSelectedProperty(
			String purchasePropertyDetailsPage_notSelectedProperty) {
		this.purchasePropertyDetailsPage_notSelectedProperty = purchasePropertyDetailsPage_notSelectedProperty;
	}

	public String getPurchasePropertyDetailsPage_inContract() {
		return purchasePropertyDetailsPage_inContract;
	}

	public void setPurchasePropertyDetailsPage_inContract(String purchasePropertyDetailsPage_inContract) {
		this.purchasePropertyDetailsPage_inContract = purchasePropertyDetailsPage_inContract;
	}

	public String getPurchasePropertyDetailsPage_notInContract() {
		return purchasePropertyDetailsPage_notInContract;
	}

	public void setPurchasePropertyDetailsPage_notInContract(String purchasePropertyDetailsPage_notInContract) {
		this.purchasePropertyDetailsPage_notInContract = purchasePropertyDetailsPage_notInContract;
	}

	public String getPurchasePropertyDetailsPage_propertyUseDropdown() {
		return purchasePropertyDetailsPage_propertyUseDropdown;
	}

	public void setPurchasePropertyDetailsPage_propertyUseDropdown(
			String purchasePropertyDetailsPage_propertyUseDropdown) {
		this.purchasePropertyDetailsPage_propertyUseDropdown = purchasePropertyDetailsPage_propertyUseDropdown;
	}

	public String getPurchasePropertyDetailsPage_addressTextBox() {
		return purchasePropertyDetailsPage_addressTextBox;
	}

	public void setPurchasePropertyDetailsPage_addressTextBox(String purchasePropertyDetailsPage_addressTextBox) {
		this.purchasePropertyDetailsPage_addressTextBox = purchasePropertyDetailsPage_addressTextBox;
	}

	public String getPurchasePropertyDetailsPage_nextButton() {
		return purchasePropertyDetailsPage_nextButton;
	}

	public void setPurchasePropertyDetailsPage_nextButton(String purchasePropertyDetailsPage_nextButton) {
		this.purchasePropertyDetailsPage_nextButton = purchasePropertyDetailsPage_nextButton;
	}

	public String getTellAboutYouPage_firstNameTextbox() {
		return TellAboutYouPage_firstNameTextbox;
	}

	public void setTellAboutYouPage_firstNameTextbox(String tellAboutYouPage_firstNameTextbox) {
		TellAboutYouPage_firstNameTextbox = tellAboutYouPage_firstNameTextbox;
	}

	public String getTellAboutYouPage_middleNameTextbox() {
		return TellAboutYouPage_middleNameTextbox;
	}

	public void setTellAboutYouPage_middleNameTextbox(String tellAboutYouPage_middleNameTextbox) {
		TellAboutYouPage_middleNameTextbox = tellAboutYouPage_middleNameTextbox;
	}

	public String getTellAboutYouPage_lastNameTextbox() {
		return TellAboutYouPage_lastNameTextbox;
	}

	public void setTellAboutYouPage_lastNameTextbox(String tellAboutYouPage_lastNameTextbox) {
		TellAboutYouPage_lastNameTextbox = tellAboutYouPage_lastNameTextbox;
	}

	public String getTellAboutYouPage_suffixTextBox() {
		return TellAboutYouPage_suffixTextBox;
	}

	public void setTellAboutYouPage_suffixTextBox(String tellAboutYouPage_suffixTextBox) {
		TellAboutYouPage_suffixTextBox = tellAboutYouPage_suffixTextBox;
	}

	public String getBorrowerCommunicationPage_pageLabel() {
		return borrowerCommunicationPage_pageLabel;
	}

	public void setBorrowerCommunicationPage_pageLabel(String borrowerCommunicationPage_pageLabel) {
		this.borrowerCommunicationPage_pageLabel = borrowerCommunicationPage_pageLabel;
	}

	public String getBorrowerCommunicationPage_preferredEmailTextBox() {
		return borrowerCommunicationPage_preferredEmailTextBox;
	}

	public void setBorrowerCommunicationPage_preferredEmailTextBox(
			String borrowerCommunicationPage_preferredEmailTextBox) {
		this.borrowerCommunicationPage_preferredEmailTextBox = borrowerCommunicationPage_preferredEmailTextBox;
	}

	public String getBorrowerCommunicationPage_phoneNumberTextBox() {
		return borrowerCommunicationPage_phoneNumberTextBox;
	}

	public void setBorrowerCommunicationPage_phoneNumberTextBox(String borrowerCommunicationPage_phoneNumberTextBox) {
		this.borrowerCommunicationPage_phoneNumberTextBox = borrowerCommunicationPage_phoneNumberTextBox;
	}

	public String getBorrowerCommunicationPage_phoneButton() {
		return borrowerCommunicationPage_phoneButton;
	}

	public void setBorrowerCommunicationPage_phoneButton(String borrowerCommunicationPage_phoneButton) {
		this.borrowerCommunicationPage_phoneButton = borrowerCommunicationPage_phoneButton;
	}

	public String getBorrowerCommunicationPage_emailButton() {
		return borrowerCommunicationPage_emailButton;
	}

	public void setBorrowerCommunicationPage_emailButton(String borrowerCommunicationPage_emailButton) {
		this.borrowerCommunicationPage_emailButton = borrowerCommunicationPage_emailButton;
	}

	public String getBorrowerCommunicationPage_textButton() {
		return borrowerCommunicationPage_textButton;
	}

	public void setBorrowerCommunicationPage_textButton(String borrowerCommunicationPage_textButton) {
		this.borrowerCommunicationPage_textButton = borrowerCommunicationPage_textButton;
	}

	public String getBorrowerCommunicationPage_allButton() {
		return borrowerCommunicationPage_allButton;
	}

	public void setBorrowerCommunicationPage_allButton(String borrowerCommunicationPage_allButton) {
		this.borrowerCommunicationPage_allButton = borrowerCommunicationPage_allButton;
	}

	public String getBorrowerCommunicationPage_nextButton() {
		return borrowerCommunicationPage_nextButton;
	}

	public void setBorrowerCommunicationPage_nextButton(String borrowerCommunicationPage_nextButton) {
		this.borrowerCommunicationPage_nextButton = borrowerCommunicationPage_nextButton;
	}

	public String getTellAboutYouPage_nextButton() {
		return TellAboutYouPage_nextButton;
	}

	public void setTellAboutYouPage_nextButton(String tellAboutYouPage_nextButton) {
		TellAboutYouPage_nextButton = tellAboutYouPage_nextButton;
	}

	public String getTellAboutYouPage_NavigationHeaderLabel() {
		return TellAboutYouPage_NavigationHeaderLabel;
	}

	public void setTellAboutYouPage_NavigationHeaderLabel(String tellAboutYouPage_NavigationHeaderLabel) {
		TellAboutYouPage_NavigationHeaderLabel = tellAboutYouPage_NavigationHeaderLabel;
	}

	public String getTellAboutYouPage_progressBarLabel() {
		return TellAboutYouPage_progressBarLabel;
	}

	public void setTellAboutYouPage_progressBarLabel(String tellAboutYouPage_progressBarLabel) {
		TellAboutYouPage_progressBarLabel = tellAboutYouPage_progressBarLabel;
	}

	public String getTellAboutYouPage_tellAboutYourselfLabel() {
		return TellAboutYouPage_tellAboutYourselfLabel;
	}

	public void setTellAboutYouPage_tellAboutYourselfLabel(String tellAboutYouPage_tellAboutYourselfLabel) {
		TellAboutYouPage_tellAboutYourselfLabel = tellAboutYouPage_tellAboutYourselfLabel;
	}

	public String getBeginSectionPage_welcomeMessage() {
		return beginSectionPage_welcomeMessage;
	}

	public void setBeginSectionPage_welcomeMessage(String beginSectionPage_welcomeMessage) {
		this.beginSectionPage_welcomeMessage = beginSectionPage_welcomeMessage;
	}

	public String getBeginSectionPage_beginSectionButton() {
		return beginSectionPage_beginSectionButton;
	}

	public void setBeginSectionPage_beginSectionButton(String beginSectionPage_beginSectionButton) {
		this.beginSectionPage_beginSectionButton = beginSectionPage_beginSectionButton;
	}

	public String getBorrowerWelcomeVideoPage_getStartedButton() {
		return borrowerWelcomeVideoPage_getStartedButton;
	}

	public void setBorrowerWelcomeVideoPage_getStartedButton(String borrowerWelcomeVideoPage_getStartedButton) {
		this.borrowerWelcomeVideoPage_getStartedButton = borrowerWelcomeVideoPage_getStartedButton;
	}

	public String getBorrowerWelcomeVideoPage_lenderImage() {
		return borrowerWelcomeVideoPage_lenderImage;
	}

	public void setBorrowerWelcomeVideoPage_lenderImage(String borrowerWelcomeVideoPage_lenderImage) {
		this.borrowerWelcomeVideoPage_lenderImage = borrowerWelcomeVideoPage_lenderImage;
	}

	public String getBorrowerWelcomeVideoPage_loanOfficerLabel() {
		return borrowerWelcomeVideoPage_loanOfficerLabel;
	}

	public void setBorrowerWelcomeVideoPage_loanOfficerLabel(String borrowerWelcomeVideoPage_loanOfficerLabel) {
		this.borrowerWelcomeVideoPage_loanOfficerLabel = borrowerWelcomeVideoPage_loanOfficerLabel;
	}

	public String getBorrowerWelcomeVideoPage_loanOfficerEmailLabel() {
		return borrowerWelcomeVideoPage_loanOfficerEmailLabel;
	}

	public void setBorrowerWelcomeVideoPage_loanOfficerEmailLabel(
			String borrowerWelcomeVideoPage_loanOfficerEmailLabel) {
		this.borrowerWelcomeVideoPage_loanOfficerEmailLabel = borrowerWelcomeVideoPage_loanOfficerEmailLabel;
	}

	public String getBorrowerWelcomeVideoPage_loanOfficerPhoneLabel() {
		return borrowerWelcomeVideoPage_loanOfficerPhoneLabel;
	}

	public void setBorrowerWelcomeVideoPage_loanOfficerPhoneLabel(
			String borrowerWelcomeVideoPage_loanOfficerPhoneLabel) {
		this.borrowerWelcomeVideoPage_loanOfficerPhoneLabel = borrowerWelcomeVideoPage_loanOfficerPhoneLabel;
	}

	public String getBorrowerWelcomeVideoPage_video() {
		return borrowerWelcomeVideoPage_video;
	}

	public void setBorrowerWelcomeVideoPage_video(String borrowerWelcomeVideoPage_video) {
		this.borrowerWelcomeVideoPage_video = borrowerWelcomeVideoPage_video;
	}

	public String getBorrowerWelcomeVideoPage_welcomeMessage() {
		return borrowerWelcomeVideoPage_welcomeMessage;
	}

	public void setBorrowerWelcomeVideoPage_welcomeMessage(String borrowerWelcomeVideoPage_welcomeMessage) {
		this.borrowerWelcomeVideoPage_welcomeMessage = borrowerWelcomeVideoPage_welcomeMessage;
	}

	public String getBorrowerWelcomePage_typeOfLoanSelectionMessage() {
		return borrowerWelcomePage_typeOfLoanSelectionMessage;
	}

	public void setBorrowerWelcomePage_typeOfLoanSelectionMessage(
			String borrowerWelcomePage_typeOfLoanSelectionMessage) {
		this.borrowerWelcomePage_typeOfLoanSelectionMessage = borrowerWelcomePage_typeOfLoanSelectionMessage;
	}

	public String getBorrowerWelcomePage_purchaseLoanButton() {
		return borrowerWelcomePage_purchaseLoanButton;
	}

	public void setBorrowerWelcomePage_purchaseLoanButton(String borrowerWelcomePage_purchaseLoanButton) {
		this.borrowerWelcomePage_purchaseLoanButton = borrowerWelcomePage_purchaseLoanButton;
	}

	public String getBorrowerWelcomePage_refinanceLoanButton() {
		return borrowerWelcomePage_refinanceLoanButton;
	}

	public void setBorrowerWelcomePage_refinanceLoanButton(String borrowerWelcomePage_refinanceLoanButton) {
		this.borrowerWelcomePage_refinanceLoanButton = borrowerWelcomePage_refinanceLoanButton;
	}

	public String getBorrowerHeader_nafLogo() {
		return borrowerHeader_nafLogo;
	}

	public void setBorrowerHeader_nafLogo(String borrowerHeader_nafLogo) {
		this.borrowerHeader_nafLogo = borrowerHeader_nafLogo;
	}

	public String getBorrowerHeader_profileDropdown() {
		return borrowerHeader_profileDropdown;
	}

	public void setBorrowerHeader_profileDropdown(String borrowerHeader_profileDropdown) {
		this.borrowerHeader_profileDropdown = borrowerHeader_profileDropdown;
	}

	public String getBorrowerHeader_profileDropdown_logoutButton() {
		return borrowerHeader_profileDropdown_logoutButton;
	}

	public void setBorrowerHeader_profileDropdown_logoutButton(String borrowerHeader_profileDropdown_logoutButton) {
		this.borrowerHeader_profileDropdown_logoutButton = borrowerHeader_profileDropdown_logoutButton;
	}

	public String getBorrowerSignUpPage_welcomeMessage() {
		return borrowerSignUpPage_welcomeMessage;
	}

	public void setBorrowerSignUpPage_welcomeMessage(String borrowerSignUpPage_welcomeMessage) {
		this.borrowerSignUpPage_welcomeMessage = borrowerSignUpPage_welcomeMessage;
	}

	public String getBorrowerSignUpPage_emailTextBox() {
		return borrowerSignUpPage_emailTextBox;
	}

	public void setBorrowerSignUpPage_emailTextBox(String borrowerSignUpPage_emailTextBox) {
		this.borrowerSignUpPage_emailTextBox = borrowerSignUpPage_emailTextBox;
	}

	public String getBorrowerSignUpPage_passwordTextBox() {
		return borrowerSignUpPage_passwordTextBox;
	}

	public void setBorrowerSignUpPage_passwordTextBox(String borrowerSignUpPage_passwordTextBox) {
		this.borrowerSignUpPage_passwordTextBox = borrowerSignUpPage_passwordTextBox;
	}

	public String getBorrowerSignUpPage_confirmPasswordTextBox() {
		return borrowerSignUpPage_confirmPasswordTextBox;
	}

	public void setBorrowerSignUpPage_confirmPasswordTextBox(String borrowerSignUpPage_confirmPasswordTextBox) {
		this.borrowerSignUpPage_confirmPasswordTextBox = borrowerSignUpPage_confirmPasswordTextBox;
	}

	public String getBorrowerSignUpPage_signUpButton() {
		return borrowerSignUpPage_signUpButton;
	}

	public void setBorrowerSignUpPage_signUpButton(String borrowerSignUpPage_signUpButton) {
		this.borrowerSignUpPage_signUpButton = borrowerSignUpPage_signUpButton;
	}

	public String getLenderPipeline_inviteDialog_inviteLabel() {
		return lenderPipeline_inviteDialog_inviteLabel;
	}

	public void setLenderPipeline_inviteDialog_inviteLabel(String lenderPipeline_inviteDialog_inviteLabel) {
		this.lenderPipeline_inviteDialog_inviteLabel = lenderPipeline_inviteDialog_inviteLabel;
	}

	public String getLenderPipeline_inviteDialog_firstNameTextBox() {
		return lenderPipeline_inviteDialog_firstNameTextBox;
	}

	public void setLenderPipeline_inviteDialog_firstNameTextBox(String lenderPipeline_inviteDialog_firstNameTextBox) {
		this.lenderPipeline_inviteDialog_firstNameTextBox = lenderPipeline_inviteDialog_firstNameTextBox;
	}

	public String getLenderPipeline_inviteDialog_lastNameTextBox() {
		return lenderPipeline_inviteDialog_lastNameTextBox;
	}

	public void setLenderPipeline_inviteDialog_lastNameTextBox(String lenderPipeline_inviteDialog_lastNameTextBox) {
		this.lenderPipeline_inviteDialog_lastNameTextBox = lenderPipeline_inviteDialog_lastNameTextBox;
	}

	public String getLenderPipeline_inviteDialog_borrowerButton() {
		return lenderPipeline_inviteDialog_borrowerButton;
	}

	public void setLenderPipeline_inviteDialog_borrowerButton(String lenderPipeline_inviteDialog_borrowerButton) {
		this.lenderPipeline_inviteDialog_borrowerButton = lenderPipeline_inviteDialog_borrowerButton;
	}

	public String getLenderPipeline_inviteDialog_affinityPartnerButton() {
		return lenderPipeline_inviteDialog_affinityPartnerButton;
	}

	public void setLenderPipeline_inviteDialog_affinityPartnerButton(
			String lenderPipeline_inviteDialog_affinityPartnerButton) {
		this.lenderPipeline_inviteDialog_affinityPartnerButton = lenderPipeline_inviteDialog_affinityPartnerButton;
	}

	public String getLenderPipeline_inviteDialog_emailTextBox() {
		return lenderPipeline_inviteDialog_emailTextBox;
	}

	public void setLenderPipeline_inviteDialog_emailTextBox(String lenderPipeline_inviteDialog_emailTextBox) {
		this.lenderPipeline_inviteDialog_emailTextBox = lenderPipeline_inviteDialog_emailTextBox;
	}

	public String getLenderPipeline_inviteDialog_phoneTextBox() {
		return lenderPipeline_inviteDialog_phoneTextBox;
	}

	public void setLenderPipeline_inviteDialog_phoneTextBox(String lenderPipeline_inviteDialog_phoneTextBox) {
		this.lenderPipeline_inviteDialog_phoneTextBox = lenderPipeline_inviteDialog_phoneTextBox;
	}

	public String getLenderPipeline_inviteDialog_sendInviteButton() {
		return lenderPipeline_inviteDialog_sendInviteButton;
	}

	public void setLenderPipeline_inviteDialog_sendInviteButton(String lenderPipeline_inviteDialog_sendInviteButton) {
		this.lenderPipeline_inviteDialog_sendInviteButton = lenderPipeline_inviteDialog_sendInviteButton;
	}

	public String getLenderPipeline_headerPanel_settingDropdown_logoutButton() {
		return lenderPipeline_headerPanel_settingDropdown_logoutButton;
	}

	public void setLenderPipeline_headerPanel_settingDropdown_logoutButton(
			String lenderPipeline_headerPanel_settingDropdown_logoutButton) {
		this.lenderPipeline_headerPanel_settingDropdown_logoutButton = lenderPipeline_headerPanel_settingDropdown_logoutButton;
	}

	public String getLenderLoginPage_forgetPasswordLink() {
		return lenderLoginPage_forgetPasswordLink;
	}

	public void setLenderLoginPage_forgetPasswordLink(String lenderLoginPage_forgetPasswordLink) {
		this.lenderLoginPage_forgetPasswordLink = lenderLoginPage_forgetPasswordLink;
	}

	public String getLenderLoginPage_loginButton() {
		return lenderLoginPage_loginButton;
	}

	public void setLenderLoginPage_loginButton(String lenderLoginPage_loginButton) {
		this.lenderLoginPage_loginButton = lenderLoginPage_loginButton;
	}

	public String getLenderPipelinePage_inviteButton() {
		return lenderPipelinePage_inviteButton;
	}

	public void setLenderPipelinePage_inviteButton(String lenderPipelinePage_inviteButton) {
		this.lenderPipelinePage_inviteButton = lenderPipelinePage_inviteButton;
	}

	public String getLenderPipelinePage_panelLoanOfficePic() {
		return lenderPipelinePage_panelLoanOfficePic;
	}

	public void setLenderPipelinePage_panelLoanOfficePic(String lenderPipelinePage_panelLoanOfficePic) {
		this.lenderPipelinePage_panelLoanOfficePic = lenderPipelinePage_panelLoanOfficePic;
	}

	public String getLenderPipelinePage_panelLoanOfficerLabel() {
		return lenderPipelinePage_panelLoanOfficerLabel;
	}

	public void setLenderPipelinePage_panelLoanOfficerLabel(String lenderPipelinePage_panelLoanOfficerLabel) {
		this.lenderPipelinePage_panelLoanOfficerLabel = lenderPipelinePage_panelLoanOfficerLabel;
	}

	public String getLenderPipeline_headerPanel_settingDropdown() {
		return lenderPipeline_headerPanel_settingDropdown;
	}

	public void setLenderPipeline_headerPanel_settingDropdown(String lenderPipeline_headerPanel_settingDropdown) {
		this.lenderPipeline_headerPanel_settingDropdown = lenderPipeline_headerPanel_settingDropdown;
	}

	public String getLenderPipeline_activeLoansTab() {
		return lenderPipeline_activeLoansTab;
	}

	public void setLenderPipeline_activeLoansTab(String lenderPipeline_activeLoansTab) {
		this.lenderPipeline_activeLoansTab = lenderPipeline_activeLoansTab;
	}

	public String getLenderPipeline_applicationsTab() {
		return lenderPipeline_applicationsTab;
	}

	public void setLenderPipeline_applicationsTab(String lenderPipeline_applicationsTab) {
		this.lenderPipeline_applicationsTab = lenderPipeline_applicationsTab;
	}

	public String getLenderPipeline_closedTab() {
		return lenderPipeline_closedTab;
	}

	public void setLenderPipeline_closedTab(String lenderPipeline_closedTab) {
		this.lenderPipeline_closedTab = lenderPipeline_closedTab;
	}

	public String getLenderPipeline_firstActiveLoan_daysToCloseLabel() {
		return lenderPipeline_firstActiveLoan_daysToCloseLabel;
	}

	public void setLenderPipeline_firstActiveLoan_daysToCloseLabel(
			String lenderPipeline_firstActiveLoan_daysToCloseLabel) {
		this.lenderPipeline_firstActiveLoan_daysToCloseLabel = lenderPipeline_firstActiveLoan_daysToCloseLabel;
	}

	public String getLenderPipeline_firstActiveLoan_firstLoanIdLabel() {
		return lenderPipeline_firstActiveLoan_firstLoanIdLabel;
	}

	public void setLenderPipeline_firstActiveLoan_firstLoanIdLabel(
			String lenderPipeline_firstActiveLoan_firstLoanIdLabel) {
		this.lenderPipeline_firstActiveLoan_firstLoanIdLabel = lenderPipeline_firstActiveLoan_firstLoanIdLabel;
	}

	public String getLenderLoginPage_emailTextBox() {
		return lenderLoginPage_emailTextBox;
	}

	public void setLenderLoginPage_emailTextBox(String lenderLoginPage_emailTextBox) {
		this.lenderLoginPage_emailTextBox = lenderLoginPage_emailTextBox;
	}

	public String getLenderLoginPage_passwordTextBox() {
		return lenderLoginPage_passwordTextBox;
	}

	public void setLenderLoginPage_passwordTextBox(String lenderLoginPage_passwordTextBox) {
		this.lenderLoginPage_passwordTextBox = lenderLoginPage_passwordTextBox;
	}

	public String getLenderGetStartedPage_getStartedLabel() {
		return lenderGetStartedPage_getStartedLabel;
	}

	public void setLenderGetStartedPage_getStartedLabel(String lenderGetStartedPage_getStartedLabel) {
		this.lenderGetStartedPage_getStartedLabel = lenderGetStartedPage_getStartedLabel;
	}

	public String getLenderGetStartedPage_loginButton() {
		return lenderGetStartedPage_loginButton;
	}

	public void setLenderGetStartedPage_loginButton(String lenderGetStartedPage_loginButton) {
		this.lenderGetStartedPage_loginButton = lenderGetStartedPage_loginButton;
	}

	public String getSpouseCommunicationPage_pageLabel() {
		return spouseCommunicationPage_pageLabel;
	}

	public void setSpouseCommunicationPage_pageLabel(String spouseCommunicationPage_pageLabel) {
		this.spouseCommunicationPage_pageLabel = spouseCommunicationPage_pageLabel;
	}

	public String getRealEstatePage_numberOfUnitsDropdown() {
		return realEstatePage_numberOfUnitsDropdown;
	}

	public void setRealEstatePage_numberOfUnitsDropdown(String realEstatePage_numberOfUnitsDropdown) {
		this.realEstatePage_numberOfUnitsDropdown = realEstatePage_numberOfUnitsDropdown;
	}

	public String getRealEstatePage_propertyUseDropdown() {
		return realEstatePage_propertyUseDropdown;
	}

	public void setRealEstatePage_propertyUseDropdown(String realEstatePage_propertyUseDropdown) {
		this.realEstatePage_propertyUseDropdown = realEstatePage_propertyUseDropdown;
	}

	public String getEmploymentPage_bonusTextBox() {
		return employmentPage_bonusTextBox;
	}

	public void setEmploymentPage_bonusTextBox(String employmentPage_bonusTextBox) {
		this.employmentPage_bonusTextBox = employmentPage_bonusTextBox;
	}

	public String getRentalPage_numberOfUnitsDropdown() {
		return rentalPage_numberOfUnitsDropdown;
	}

	public void setRentalPage_numberOfUnitsDropdown(String rentalPage_numberOfUnitsDropdown) {
		this.rentalPage_numberOfUnitsDropdown = rentalPage_numberOfUnitsDropdown;
	}

	public String getAssetsPage_verifyElectronicallyButton() {
		return assetsPage_verifyElectronicallyButton;
	}

	public void setAssetsPage_verifyElectronicallyButton(String assetsPage_verifyElectronicallyButton) {
		this.assetsPage_verifyElectronicallyButton = assetsPage_verifyElectronicallyButton;
	}

	public String getEmploymentPage_currentlyWorkHereCheckbox() {
		return employmentPage_currentlyWorkHereCheckbox;
	}

	public void setEmploymentPage_currentlyWorkHereCheckbox(String employmentPage_currentlyWorkHereCheckbox) {
		this.employmentPage_currentlyWorkHereCheckbox = employmentPage_currentlyWorkHereCheckbox;
	}

	public String getEmploymentPage_endDatePresentTextBox() {
		return employmentPage_endDatePresentTextBox;
	}

	public void setEmploymentPage_endDatePresentTextBox(String employmentPage_endDatePresentTextBox) {
		this.employmentPage_endDatePresentTextBox = employmentPage_endDatePresentTextBox;
	}

	public String getEmploymentPage_endDateManualTextBox() {
		return employmentPage_endDateManualTextBox;
	}

	public void setEmploymentPage_endDateManualTextBox(String employmentPage_endDateManualTextBox) {
		this.employmentPage_endDateManualTextBox = employmentPage_endDateManualTextBox;
	}

	public String getEmploymentPage_commissionTextBox() {
		return employmentPage_commissionTextBox;
	}

	public void setEmploymentPage_commissionTextBox(String employmentPage_commissionTextBox) {
		this.employmentPage_commissionTextBox = employmentPage_commissionTextBox;
	}

	public String getEmploymentPage_overtimeTextBox() {
		return employmentPage_overtimeTextBox;
	}

	public void setEmploymentPage_overtimeTextBox(String employmentPage_overtimeTextBox) {
		this.employmentPage_overtimeTextBox = employmentPage_overtimeTextBox;
	}

	public String getBusinessSelfEmploymentPage_currentlyWorkHereCheckbox() {
		return businessSelfEmploymentPage_currentlyWorkHereCheckbox;
	}

	public void setBusinessSelfEmploymentPage_currentlyWorkHereCheckbox(
			String businessSelfEmploymentPage_currentlyWorkHereCheckbox) {
		this.businessSelfEmploymentPage_currentlyWorkHereCheckbox = businessSelfEmploymentPage_currentlyWorkHereCheckbox;
	}

	public String getRentalPage_propertyStatusDropdown() {
		return rentalPage_propertyStatusDropdown;
	}

	public void setRentalPage_propertyStatusDropdown(String rentalPage_propertyStatusDropdown) {
		this.rentalPage_propertyStatusDropdown = rentalPage_propertyStatusDropdown;
	}

	public String getRentalPage_propertyUseDropdown() {
		return rentalPage_propertyUseDropdown;
	}

	public void setRentalPage_propertyUseDropdown(String rentalPage_propertyUseDropdown) {
		this.rentalPage_propertyUseDropdown = rentalPage_propertyUseDropdown;
	}

	public String getRentalPage_propertyValueTextBox() {
		return rentalPage_propertyValueTextBox;
	}

	public void setRentalPage_propertyValueTextBox(String rentalPage_propertyValueTextBox) {
		this.rentalPage_propertyValueTextBox = rentalPage_propertyValueTextBox;
	}

	public String getRentalPage_monthlyRentalIncomeTextBox() {
		return rentalPage_monthlyRentalIncomeTextBox;
	}

	public void setRentalPage_monthlyRentalIncomeTextBox(String rentalPage_monthlyRentalIncomeTextBox) {
		this.rentalPage_monthlyRentalIncomeTextBox = rentalPage_monthlyRentalIncomeTextBox;
	}

	public String getRentalPage_additionalExpenseTextBox() {
		return rentalPage_additionalExpenseTextBox;
	}

	public void setRentalPage_additionalExpenseTextBox(String rentalPage_additionalExpenseTextBox) {
		this.rentalPage_additionalExpenseTextBox = rentalPage_additionalExpenseTextBox;
	}

	public String getRentalPage_netMonthlyRentalIncomeLabel() {
		return rentalPage_netMonthlyRentalIncomeLabel;
	}

	public void setRentalPage_netMonthlyRentalIncomeLabel(String rentalPage_netMonthlyRentalIncomeLabel) {
		this.rentalPage_netMonthlyRentalIncomeLabel = rentalPage_netMonthlyRentalIncomeLabel;
	}

	public String getLoanEligibilityPage_dutyWithExpirationDateCheckbox() {
		return loanEligibilityPage_dutyWithExpirationDateCheckbox;
	}

	public void setLoanEligibilityPage_dutyWithExpirationDateCheckbox(
			String loanEligibilityPage_dutyWithExpirationDateCheckbox) {
		this.loanEligibilityPage_dutyWithExpirationDateCheckbox = loanEligibilityPage_dutyWithExpirationDateCheckbox;
	}

	public String getLoanEligibilityPage_CurrentlyRetiredCheckbox() {
		return loanEligibilityPage_CurrentlyRetiredCheckbox;
	}

	public void setLoanEligibilityPage_CurrentlyRetiredCheckbox(String loanEligibilityPage_CurrentlyRetiredCheckbox) {
		this.loanEligibilityPage_CurrentlyRetiredCheckbox = loanEligibilityPage_CurrentlyRetiredCheckbox;
	}

	public String getLoanEligibilityPage_NonActivatedCheckbox() {
		return loanEligibilityPage_NonActivatedCheckbox;
	}

	public void setLoanEligibilityPage_NonActivatedCheckbox(String loanEligibilityPage_NonActivatedCheckbox) {
		this.loanEligibilityPage_NonActivatedCheckbox = loanEligibilityPage_NonActivatedCheckbox;
	}

	public String getLoanEligibilityPage_SurvivingSpouseCheckbox() {
		return loanEligibilityPage_SurvivingSpouseCheckbox;
	}

	public void setLoanEligibilityPage_SurvivingSpouseCheckbox(String loanEligibilityPage_SurvivingSpouseCheckbox) {
		this.loanEligibilityPage_SurvivingSpouseCheckbox = loanEligibilityPage_SurvivingSpouseCheckbox;
	}

	public String getLoanEligibilityPage_projectedExpiryDateTextbox() {
		return loanEligibilityPage_projectedExpiryDateTextbox;
	}

	public void setLoanEligibilityPage_projectedExpiryDateTextbox(
			String loanEligibilityPage_projectedExpiryDateTextbox) {
		this.loanEligibilityPage_projectedExpiryDateTextbox = loanEligibilityPage_projectedExpiryDateTextbox;
	}

	public String getLoanEligibilityPage_childCareExpenseButton() {
		return loanEligibilityPage_childCareExpenseButton;
	}

	public void setLoanEligibilityPage_childCareExpenseButton(String loanEligibilityPage_childCareExpenseButton) {
		this.loanEligibilityPage_childCareExpenseButton = loanEligibilityPage_childCareExpenseButton;
	}

	public String getLoanEligibilityPage_noChildCareExpenseButton() {
		return loanEligibilityPage_noChildCareExpenseButton;
	}

	public void setLoanEligibilityPage_noChildCareExpenseButton(String loanEligibilityPage_noChildCareExpenseButton) {
		this.loanEligibilityPage_noChildCareExpenseButton = loanEligibilityPage_noChildCareExpenseButton;
	}

	public String getLoanEligibilityPage_childCareExpenseTextbox() {
		return loanEligibilityPage_childCareExpenseTextbox;
	}

	public void setLoanEligibilityPage_childCareExpenseTextbox(String loanEligibilityPage_childCareExpenseTextbox) {
		this.loanEligibilityPage_childCareExpenseTextbox = loanEligibilityPage_childCareExpenseTextbox;
	}

	public String getWhosOnTheLoanPage_nextButton() {
		return whosOnTheLoanPage_nextButton;
	}

	public void setWhosOnTheLoanPage_nextButton(String whosOnTheLoanPage_nextButton) {
		this.whosOnTheLoanPage_nextButton = whosOnTheLoanPage_nextButton;
	}

	public String getWhosOnTheLoanPage_spouseFirstNameTextBox() {
		return whosOnTheLoanPage_spouseFirstNameTextBox;
	}

	public void setWhosOnTheLoanPage_spouseFirstNameTextBox(String whosOnTheLoanPage_spouseFirstNameTextBox) {
		this.whosOnTheLoanPage_spouseFirstNameTextBox = whosOnTheLoanPage_spouseFirstNameTextBox;
	}

	public String getWhosOnTheLoanPage_spouseLastNameTextBox() {
		return whosOnTheLoanPage_spouseLastNameTextBox;
	}

	public void setWhosOnTheLoanPage_spouseLastNameTextBox(String whosOnTheLoanPage_spouseLastNameTextBox) {
		this.whosOnTheLoanPage_spouseLastNameTextBox = whosOnTheLoanPage_spouseLastNameTextBox;
	}

	public String getAddCoApplicantsPage_pageLabel() {
		return addCoApplicantsPage_pageLabel;
	}

	public void setAddCoApplicantsPage_pageLabel(String addCoApplicantsPage_pageLabel) {
		this.addCoApplicantsPage_pageLabel = addCoApplicantsPage_pageLabel;
	}

	public String getAddCoApplicantsPage_addFirstCoborrower() {
		return addCoApplicantsPage_addFirstCoborrower;
	}

	public void setAddCoApplicantsPage_addFirstCoborrower(String addCoApplicantsPage_addFirstCoborrower) {
		this.addCoApplicantsPage_addFirstCoborrower = addCoApplicantsPage_addFirstCoborrower;
	}

	public String getAddCoApplicantsPage_cob1FirstNameTextbox() {
		return addCoApplicantsPage_cob1FirstNameTextbox;
	}

	public void setAddCoApplicantsPage_cob1FirstNameTextbox(String addCoApplicantsPage_cob1FirstNameTextbox) {
		this.addCoApplicantsPage_cob1FirstNameTextbox = addCoApplicantsPage_cob1FirstNameTextbox;
	}

	public String getAddCoApplicantsPage_cob1LastNameTextbox() {
		return addCoApplicantsPage_cob1LastNameTextbox;
	}

	public void setAddCoApplicantsPage_cob1LastNameTextbox(String addCoApplicantsPage_cob1LastNameTextbox) {
		this.addCoApplicantsPage_cob1LastNameTextbox = addCoApplicantsPage_cob1LastNameTextbox;
	}

	public String getAddCoApplicantsPage_cob1EmailTextbox() {
		return addCoApplicantsPage_cob1EmailTextbox;
	}

	public void setAddCoApplicantsPage_cob1EmailTextbox(String addCoApplicantsPage_cob1EmailTextbox) {
		this.addCoApplicantsPage_cob1EmailTextbox = addCoApplicantsPage_cob1EmailTextbox;
	}

	public String getAddCoApplicantsPage_cob1RelationshipDropdown() {
		return addCoApplicantsPage_cob1RelationshipDropdown;
	}

	public void setAddCoApplicantsPage_cob1RelationshipDropdown(String addCoApplicantsPage_cob1RelationshipDropdown) {
		this.addCoApplicantsPage_cob1RelationshipDropdown = addCoApplicantsPage_cob1RelationshipDropdown;
	}

	public String getGetStartedPage_Signup() {
		return GetStartedPage_Signup;
	}

	public void setGetStartedPage_Signup(String getStartedPage_Signup) {
		GetStartedPage_Signup = getStartedPage_Signup;
	}

	public String getGetStartedPage_Login() {
		return GetStartedPage_Login;
	}

	public void setGetStartedPage_Login(String getStartedPage_Login) {
		GetStartedPage_Login = getStartedPage_Login;
	}

	public String getWelcomeSignupPage_GetStarted() {
		return WelcomeSignupPage_GetStarted;
	}

	public void setWelcomeSignupPage_GetStarted(String welcomeSignupPage_GetStarted) {
		WelcomeSignupPage_GetStarted = welcomeSignupPage_GetStarted;
	}

	public String getBorrowerCommunicationPage_cellPhone() {
		return borrowerCommunicationPage_cellPhone;
	}

	public void setBorrowerCommunicationPage_cellPhone(String borrowerCommunicationPage_cellPhone) {
		borrowerCommunicationPage_cellPhone = borrowerCommunicationPage_cellPhone;
	}

	public String getLoanOfferPage_YesLoanOfficer() {
		return LoanOfferPage_YesLoanOfficer;
	}

	public void setLoanOfferPage_YesLoanOfficer(String loanOfferPage_YesLoanOfficer) {
		LoanOfferPage_YesLoanOfficer = loanOfferPage_YesLoanOfficer;
	}

	public String getLoanOfferPage_NoLoanOfficer() {
		return LoanOfferPage_NoLoanOfficer;
	}

	public void setLoanOfferPage_NoLoanOfficer(String loanOfferPage_NoLoanOfficer) {
		LoanOfferPage_NoLoanOfficer = loanOfferPage_NoLoanOfficer;
	}

	public String getLoanOfferPage_SearchLoanOfficer() {
		return LoanOfferPage_SearchLoanOfficer;
	}

	public void setLoanOfferPage_SearchLoanOfficer(String loanOfferPage_SearchLoanOfficer) {
		LoanOfferPage_SearchLoanOfficer = loanOfferPage_SearchLoanOfficer;
	}

	public String getLoanOfferPage_NextLoanOfficer() {
		return LoanOfferPage_NextLoanOfficer;
	}

	public void setLoanOfferPage_NextLoanOfficer(String loanOfferPage_NextLoanOfficer) {
		LoanOfferPage_NextLoanOfficer = loanOfferPage_NextLoanOfficer;
	}

	public String getLoanOfferPage_PageLabel() {
		return LoanOfferPage_PageLabel;
	}

	public void setLoanOfferPage_PageLabel(String loanOfferPage_PageLabel) {
		LoanOfferPage_PageLabel = loanOfferPage_PageLabel;
	}

	public String getBorrowerCommunicationPage_coborpreferredEmailTextBox() {
		return borrowerCommunicationPage_coborpreferredEmailTextBox;
	}

	public void setBorrowerCommunicationPage_coborpreferredEmailTextBox(
			String borrowerCommunicationPage_coborpreferredEmailTextBox) {
		borrowerCommunicationPage_coborpreferredEmailTextBox = borrowerCommunicationPage_coborpreferredEmailTextBox;
	}

	public String getCOBORROWER_MaritalMarried() {
		return COBORROWER_MaritalMarried;
	}

	public void setCOBORROWER_MaritalMarried(String cOBORROWER_MaritalMarried) {
		COBORROWER_MaritalMarried = cOBORROWER_MaritalMarried;
	}

	public String getCOBORROWER_MaritalSeprated() {
		return COBORROWER_MaritalSeprated;
	}

	public void setCOBORROWER_MaritalSeprated(String cOBORROWER_MaritalSeprated) {
		COBORROWER_MaritalSeprated = cOBORROWER_MaritalSeprated;
	}

	public String getCOBORROWER_MaritalUnMarried() {
		return COBORROWER_MaritalUnMarried;
	}

	public void setCOBORROWER_MaritalUnMarried(String cOBORROWER_MaritalUnMarried) {
		COBORROWER_MaritalUnMarried = cOBORROWER_MaritalUnMarried;
	}

	public String getCOBORROWER_MaritalNext() {
		return COBORROWER_MaritalNext;
	}

	public void setCOBORROWER_MaritalNext(String cOBORROWER_MaritalNext) {
		COBORROWER_MaritalNext = cOBORROWER_MaritalNext;
	}

	public String getCOBORROWER_MaritalPageLabel() {
		return COBORROWER_MaritalPageLabel;
	}

	public void setCOBORROWER_MaritalPageLabel(String cOBORROWER_MaritalPageLabel) {
		COBORROWER_MaritalPageLabel = cOBORROWER_MaritalPageLabel;
	}

	public String getCOBORROWER_MaritalNo() {
		return COBORROWER_MaritalNo;
	}

	public void setCOBORROWER_MaritalNo(String cOBORROWER_MaritalNo) {
		COBORROWER_MaritalNo = cOBORROWER_MaritalNo;
	}

	public String getCOBORROWER_MaritalYes() {
		return COBORROWER_MaritalYes;
	}

	public void setCOBORROWER_MaritalYes(String cOBORROWER_MaritalYes) {
		COBORROWER_MaritalYes = cOBORROWER_MaritalYes;
	}

	public String getCOBORROWER_MaritalFirstName() {
		return COBORROWER_MaritalFirstName;
	}

	public void setCOBORROWER_MaritalFirstName(String cOBORROWER_MaritalFirstName) {
		COBORROWER_MaritalFirstName = cOBORROWER_MaritalFirstName;
	}

	public String getCOBORROWER_MaritalMiddleName() {
		return COBORROWER_MaritalMiddleName;
	}

	public void setCOBORROWER_MaritalMiddleName(String cOBORROWER_MaritalMiddleName) {
		COBORROWER_MaritalMiddleName = cOBORROWER_MaritalMiddleName;
	}

	public String getCOBORROWER_MaritalLastName() {
		return COBORROWER_MaritalLastName;
	}

	public void setCOBORROWER_MaritalLastName(String cOBORROWER_MaritalLastName) {
		COBORROWER_MaritalLastName = cOBORROWER_MaritalLastName;
	}

	public String getCOBORROWER_MaritalSuffix() {
		return COBORROWER_MaritalSuffix;
	}

	public void setCOBORROWER_MaritalSuffix(String cOBORROWER_MaritalSuffix) {
		COBORROWER_MaritalSuffix = cOBORROWER_MaritalSuffix;
	}

	public String getCOBORROWER_MaritalDOB() {
		return COBORROWER_MaritalDOB;
	}

	public void setCOBORROWER_MaritalDOB(String cOBORROWER_MaritalDOB) {
		COBORROWER_MaritalDOB = cOBORROWER_MaritalDOB;
	}

	public String getCOBORROWER_MaritalSSN() {
		return COBORROWER_MaritalSSN;
	}

	public void setCOBORROWER_MaritalSSN(String cOBORROWER_MaritalSSN) {
		COBORROWER_MaritalSSN = cOBORROWER_MaritalSSN;
	}

	public String getCOBORROWER_MaritalEmailID() {
		return COBORROWER_MaritalEmailID;
	}

	public void setCOBORROWER_MaritalEmailID(String cOBORROWER_MaritalEmailID) {
		COBORROWER_MaritalEmailID = cOBORROWER_MaritalEmailID;
	}

	public String getCOBORROWER_MaritalCellPhone() {
		return COBORROWER_MaritalCellPhone;
	}

	public void setCOBORROWER_MaritalCellPhone(String cOBORROWER_MaritalCellPhone) {
		COBORROWER_MaritalCellPhone = cOBORROWER_MaritalCellPhone;
	}

	public String getCoborrwercurrentResidentialDetailsPage_pageLabel() {
		return CoborrwercurrentResidentialDetailsPage_pageLabel;
	}

	public void setCoborrwercurrentResidentialDetailsPage_pageLabel(
			String coborrwercurrentResidentialDetailsPage_pageLabel) {
		CoborrwercurrentResidentialDetailsPage_pageLabel = coborrwercurrentResidentialDetailsPage_pageLabel;
	}

	public String getCoborrwercurrentResidentialDetailsPage_ownButton() {
		return CoborrwercurrentResidentialDetailsPage_ownButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_ownButton(
			String coborrwercurrentResidentialDetailsPage_ownButton) {
		CoborrwercurrentResidentialDetailsPage_ownButton = coborrwercurrentResidentialDetailsPage_ownButton;
	}

	public String getCoborrwercurrentResidentialDetailsPage_rentButton() {
		return CoborrwercurrentResidentialDetailsPage_rentButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_rentButton(
			String coborrwercurrentResidentialDetailsPage_rentButton) {
		CoborrwercurrentResidentialDetailsPage_rentButton = coborrwercurrentResidentialDetailsPage_rentButton;
	}

	public String getCoborrwercurrentResidentialDetailsPage_otherButton() {
		return CoborrwercurrentResidentialDetailsPage_otherButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_otherButton(
			String coborrwercurrentResidentialDetailsPage_otherButton) {
		CoborrwercurrentResidentialDetailsPage_otherButton = coborrwercurrentResidentialDetailsPage_otherButton;
	}

	public String getCoborrwercurrentResidentialDetailsPage_currentResidenceTextbox() {
		return CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox;
	}

	public void setCoborrwercurrentResidentialDetailsPage_currentResidenceTextbox(
			String coborrwercurrentResidentialDetailsPage_currentResidenceTextbox) {
		CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox = coborrwercurrentResidentialDetailsPage_currentResidenceTextbox;
	}

	public String getCoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox() {
		return CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox;
	}

	public void setCoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox(
			String coborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox) {
		CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox = coborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox;
	}

	public String getCoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox() {
		return CoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox;
	}

	public void setCoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox(
			String coborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox) {
		CoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox = coborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox;
	}

	public String getCoborrwercurrentResidentialDetailsPage_planningToSellButton() {
		return CoborrwercurrentResidentialDetailsPage_planningToSellButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_planningToSellButton(
			String coborrwercurrentResidentialDetailsPage_planningToSellButton) {
		CoborrwercurrentResidentialDetailsPage_planningToSellButton = coborrwercurrentResidentialDetailsPage_planningToSellButton;
	}

	public String getCoborrwercurrentResidentialDetailsPage_notPlanningToSellButton() {
		return CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_notPlanningToSellButton(
			String coborrwercurrentResidentialDetailsPage_notPlanningToSellButton) {
		CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton = coborrwercurrentResidentialDetailsPage_notPlanningToSellButton;
	}

	public String getCoborrwercurrentResidentialDetailsPage_nextButton() {
		return CoborrwercurrentResidentialDetailsPage_nextButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_nextButton(
			String coborrwercurrentResidentialDetailsPage_nextButton) {
		CoborrwercurrentResidentialDetailsPage_nextButton = coborrwercurrentResidentialDetailsPage_nextButton;
	}

	public String getCoborrwerrealEstatePage_pageLabel() {
		return CoborrwerrealEstatePage_pageLabel;
	}

	public void setCoborrwerrealEstatePage_pageLabel(String coborrwerrealEstatePage_pageLabel) {
		CoborrwerrealEstatePage_pageLabel = coborrwerrealEstatePage_pageLabel;
	}

	public String getCoborrwerrealEstatePage_ownAdditionalPropertiesButton() {
		return CoborrwerrealEstatePage_ownAdditionalPropertiesButton;
	}

	public void setCoborrwerrealEstatePage_ownAdditionalPropertiesButton(
			String coborrwerrealEstatePage_ownAdditionalPropertiesButton) {
		CoborrwerrealEstatePage_ownAdditionalPropertiesButton = coborrwerrealEstatePage_ownAdditionalPropertiesButton;
	}

	public String getCoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton() {
		return CoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton;
	}

	public void setCoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton(
			String coborrwerrealEstatePage_dontOwnAdditionalPropertiesButton) {
		CoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton = coborrwerrealEstatePage_dontOwnAdditionalPropertiesButton;
	}

	public String getCoborrwerrealEstatePage_propertyAddressTextbox() {
		return CoborrwerrealEstatePage_propertyAddressTextbox;
	}

	public void setCoborrwerrealEstatePage_propertyAddressTextbox(
			String coborrwerrealEstatePage_propertyAddressTextbox) {
		CoborrwerrealEstatePage_propertyAddressTextbox = coborrwerrealEstatePage_propertyAddressTextbox;
	}

	public String getCoborrwerrealEstatePage_propertyValueTextbox() {
		return CoborrwerrealEstatePage_propertyValueTextbox;
	}

	public void setCoborrwerrealEstatePage_propertyValueTextbox(String coborrwerrealEstatePage_propertyValueTextbox) {
		CoborrwerrealEstatePage_propertyValueTextbox = coborrwerrealEstatePage_propertyValueTextbox;
	}

	public String getCoborrwerrealEstatePage_rentalIncomeTextbox() {
		return CoborrwerrealEstatePage_rentalIncomeTextbox;
	}

	public void setCoborrwerrealEstatePage_rentalIncomeTextbox(String coborrwerrealEstatePage_rentalIncomeTextbox) {
		CoborrwerrealEstatePage_rentalIncomeTextbox = coborrwerrealEstatePage_rentalIncomeTextbox;
	}

	public String getCoborrwerrealEstatePage_additioanlIncomeTextbox() {
		return CoborrwerrealEstatePage_additioanlIncomeTextbox;
	}

	public void setCoborrwerrealEstatePage_additioanlIncomeTextbox(
			String coborrwerrealEstatePage_additioanlIncomeTextbox) {
		CoborrwerrealEstatePage_additioanlIncomeTextbox = coborrwerrealEstatePage_additioanlIncomeTextbox;
	}

	public String getCoborrwerrealEstatePage_netRentalIncomeLabel() {
		return CoborrwerrealEstatePage_netRentalIncomeLabel;
	}

	public void setCoborrwerrealEstatePage_netRentalIncomeLabel(String coborrwerrealEstatePage_netRentalIncomeLabel) {
		CoborrwerrealEstatePage_netRentalIncomeLabel = coborrwerrealEstatePage_netRentalIncomeLabel;
	}

	public String getCoborrwerrealEstatePage_propertyTypeDropdown() {
		return CoborrwerrealEstatePage_propertyTypeDropdown;
	}

	public void setCoborrwerrealEstatePage_propertyTypeDropdown(String coborrwerrealEstatePage_propertyTypeDropdown) {
		CoborrwerrealEstatePage_propertyTypeDropdown = coborrwerrealEstatePage_propertyTypeDropdown;
	}

	public String getCoborrwerrealEstatePage_numberOfUnitsDropdown() {
		return CoborrwerrealEstatePage_numberOfUnitsDropdown;
	}

	public void setCoborrwerrealEstatePage_numberOfUnitsDropdown(String coborrwerrealEstatePage_numberOfUnitsDropdown) {
		CoborrwerrealEstatePage_numberOfUnitsDropdown = coborrwerrealEstatePage_numberOfUnitsDropdown;
	}

	public String getCoborrwerrealEstatePage_propertyStatusDropdown() {
		return CoborrwerrealEstatePage_propertyStatusDropdown;
	}

	public void setCoborrwerrealEstatePage_propertyStatusDropdown(
			String coborrwerrealEstatePage_propertyStatusDropdown) {
		CoborrwerrealEstatePage_propertyStatusDropdown = coborrwerrealEstatePage_propertyStatusDropdown;
	}

	public String getCoborrwerrealEstatePage_propertyUseDropdown() {
		return CoborrwerrealEstatePage_propertyUseDropdown;
	}

	public void setCoborrwerrealEstatePage_propertyUseDropdown(String coborrwerrealEstatePage_propertyUseDropdown) {
		CoborrwerrealEstatePage_propertyUseDropdown = coborrwerrealEstatePage_propertyUseDropdown;
	}

	public String getCoborrwerrealEstatePage_submitButton() {
		return CoborrwerrealEstatePage_submitButton;
	}

	public void setCoborrwerrealEstatePage_submitButton(String coborrwerrealEstatePage_submitButton) {
		CoborrwerrealEstatePage_submitButton = coborrwerrealEstatePage_submitButton;
	}

	public String getCoborrowerincomeSearchPage_pageLabel() {
		return CoborrowerincomeSearchPage_pageLabel;
	}

	public void setCoborrowerincomeSearchPage_pageLabel(String coborrowerincomeSearchPage_pageLabel) {
		CoborrowerincomeSearchPage_pageLabel = coborrowerincomeSearchPage_pageLabel;
	}

	public String getCoborrowerincomeSearchPage_employmentButton() {
		return CoborrowerincomeSearchPage_employmentButton;
	}

	public void setCoborrowerincomeSearchPage_employmentButton(String coborrowerincomeSearchPage_employmentButton) {
		CoborrowerincomeSearchPage_employmentButton = coborrowerincomeSearchPage_employmentButton;
	}

	public String getCoborrowerincomeSearchPage_alimonyChildSupportButton() {
		return CoborrowerincomeSearchPage_alimonyChildSupportButton;
	}

	public void setCoborrowerincomeSearchPage_alimonyChildSupportButton(
			String coborrowerincomeSearchPage_alimonyChildSupportButton) {
		CoborrowerincomeSearchPage_alimonyChildSupportButton = coborrowerincomeSearchPage_alimonyChildSupportButton;
	}

	public String getCoborrowerincomeSearchPage_businessSelfEmploymentButton() {
		return CoborrowerincomeSearchPage_businessSelfEmploymentButton;
	}

	public void setCoborrowerincomeSearchPage_businessSelfEmploymentButton(
			String coborrowerincomeSearchPage_businessSelfEmploymentButton) {
		CoborrowerincomeSearchPage_businessSelfEmploymentButton = coborrowerincomeSearchPage_businessSelfEmploymentButton;
	}

	public String getCoborrowerincomeSearchPage_millitaryButton() {
		return CoborrowerincomeSearchPage_millitaryButton;
	}

	public void setCoborrowerincomeSearchPage_millitaryButton(String coborrowerincomeSearchPage_millitaryButton) {
		CoborrowerincomeSearchPage_millitaryButton = coborrowerincomeSearchPage_millitaryButton;
	}

	public String getCoborrowerincomeSearchPage_rentalButton() {
		return CoborrowerincomeSearchPage_rentalButton;
	}

	public void setCoborrowerincomeSearchPage_rentalButton(String coborrowerincomeSearchPage_rentalButton) {
		CoborrowerincomeSearchPage_rentalButton = coborrowerincomeSearchPage_rentalButton;
	}

	public String getCoborrowerincomeSearchPage_socialSecurityButton() {
		return CoborrowerincomeSearchPage_socialSecurityButton;
	}

	public void setCoborrowerincomeSearchPage_socialSecurityButton(
			String coborrowerincomeSearchPage_socialSecurityButton) {
		CoborrowerincomeSearchPage_socialSecurityButton = coborrowerincomeSearchPage_socialSecurityButton;
	}

	public String getCoborrowerincomeSearchPage_interestDividendButton() {
		return CoborrowerincomeSearchPage_interestDividendButton;
	}

	public void setCoborrowerincomeSearchPage_interestDividendButton(
			String coborrowerincomeSearchPage_interestDividendButton) {
		CoborrowerincomeSearchPage_interestDividendButton = coborrowerincomeSearchPage_interestDividendButton;
	}

	public String getCoborrowerincomeSearchPage_othertButton() {
		return CoborrowerincomeSearchPage_othertButton;
	}

	public void setCoborrowerincomeSearchPage_othertButton(String coborrowerincomeSearchPage_othertButton) {
		CoborrowerincomeSearchPage_othertButton = coborrowerincomeSearchPage_othertButton;
	}

	public String getCoborrowerincomeSearchPage_noIncomeButton() {
		return CoborrowerincomeSearchPage_noIncomeButton;
	}

	public void setCoborrowerincomeSearchPage_noIncomeButton(String coborrowerincomeSearchPage_noIncomeButton) {
		CoborrowerincomeSearchPage_noIncomeButton = coborrowerincomeSearchPage_noIncomeButton;
	}

	public String getCoborrowerincomeSearchPage_beginButton() {
		return CoborrowerincomeSearchPage_beginButton;
	}

	public void setCoborrowerincomeSearchPage_beginButton(String coborrowerincomeSearchPage_beginButton) {
		CoborrowerincomeSearchPage_beginButton = coborrowerincomeSearchPage_beginButton;
	}

	public String getCoborrowerSummary_PageLabel() {
		return CoborrowerSummary_PageLabel;
	}

	public void setCoborrowerSummary_PageLabel(String coborrowerSummary_PageLabel) {
		CoborrowerSummary_PageLabel = coborrowerSummary_PageLabel;
	}

	public String getLogout_username() {
		return Logout_username;
	}

	public void setLogout_username(String logout_username) {
		Logout_username = logout_username;
	}

	public String getLogout_looutlink() {
		return Logout_looutlink;
	}

	public void setLogout_looutlink(String logout_looutlink) {
		Logout_looutlink = logout_looutlink;
	}

	public String getCoborrowerLoanOfficer_PageLabel() {
		return CoborrowerLoanOfficer_PageLabel;
	}

	public void setCoborrowerLoanOfficer_PageLabel(String coborrowerLoanOfficer_PageLabel) {
		CoborrowerLoanOfficer_PageLabel = coborrowerLoanOfficer_PageLabel;
	}

	public String getSpouseAddedotherIncomePage_nextButton() {
		return SpouseAddedotherIncomePage_nextButton;
	}

	public void setSpouseAddedotherIncomePage_nextButton(String spouseAddedotherIncomePage_nextButton) {
		SpouseAddedotherIncomePage_nextButton = spouseAddedotherIncomePage_nextButton;
	}

	public String getWhosOnTheLoanPage_spouseSuffixTextBox() {
		return whosOnTheLoanPage_spouseSuffixTextBox;
	}

	public void setWhosOnTheLoanPage_spouseSuffixTextBox(String whosOnTheLoanPage_spouseSuffixTextBox) {
		whosOnTheLoanPage_spouseSuffixTextBox = whosOnTheLoanPage_spouseSuffixTextBox;
	}

	public String getSpouseincomeSearchPage_pageLabel() {
		return SpouseincomeSearchPage_pageLabel;
	}

	public void setSpouseincomeSearchPage_pageLabel(String spouseincomeSearchPage_pageLabel) {
		SpouseincomeSearchPage_pageLabel = spouseincomeSearchPage_pageLabel;
	}

	public String getSpouseincomeSearchPage_employmentButton() {
		return SpouseincomeSearchPage_employmentButton;
	}

	public void setSpouseincomeSearchPage_employmentButton(String spouseincomeSearchPage_employmentButton) {
		SpouseincomeSearchPage_employmentButton = spouseincomeSearchPage_employmentButton;
	}

	public String getSpouseincomeSearchPage_alimonyChildSupportButton() {
		return SpouseincomeSearchPage_alimonyChildSupportButton;
	}

	public void setSpouseincomeSearchPage_alimonyChildSupportButton(
			String spouseincomeSearchPage_alimonyChildSupportButton) {
		SpouseincomeSearchPage_alimonyChildSupportButton = spouseincomeSearchPage_alimonyChildSupportButton;
	}

	public String getSpouseincomeSearchPage_businessSelfEmploymentButton() {
		return SpouseincomeSearchPage_businessSelfEmploymentButton;
	}

	public void setSpouseincomeSearchPage_businessSelfEmploymentButton(
			String spouseincomeSearchPage_businessSelfEmploymentButton) {
		SpouseincomeSearchPage_businessSelfEmploymentButton = spouseincomeSearchPage_businessSelfEmploymentButton;
	}

	public String getSpouseincomeSearchPage_millitaryButton() {
		return SpouseincomeSearchPage_millitaryButton;
	}

	public void setSpouseincomeSearchPage_millitaryButton(String spouseincomeSearchPage_millitaryButton) {
		SpouseincomeSearchPage_millitaryButton = spouseincomeSearchPage_millitaryButton;
	}

	public String getSpouseincomeSearchPage_rentalButton() {
		return SpouseincomeSearchPage_rentalButton;
	}

	public void setSpouseincomeSearchPage_rentalButton(String spouseincomeSearchPage_rentalButton) {
		SpouseincomeSearchPage_rentalButton = spouseincomeSearchPage_rentalButton;
	}

	public String getSpouseincomeSearchPage_socialSecurityButton() {
		return SpouseincomeSearchPage_socialSecurityButton;
	}

	public void setSpouseincomeSearchPage_socialSecurityButton(String spouseincomeSearchPage_socialSecurityButton) {
		SpouseincomeSearchPage_socialSecurityButton = spouseincomeSearchPage_socialSecurityButton;
	}

	public String getSpouseincomeSearchPage_interestDividendButton() {
		return SpouseincomeSearchPage_interestDividendButton;
	}

	public void setSpouseincomeSearchPage_interestDividendButton(String spouseincomeSearchPage_interestDividendButton) {
		SpouseincomeSearchPage_interestDividendButton = spouseincomeSearchPage_interestDividendButton;
	}

	public String getSpouseincomeSearchPage_othertButton() {
		return SpouseincomeSearchPage_othertButton;
	}

	public void setSpouseincomeSearchPage_othertButton(String spouseincomeSearchPage_othertButton) {
		SpouseincomeSearchPage_othertButton = spouseincomeSearchPage_othertButton;
	}

	public String getSpouseincomeSearchPage_noIncomeButton() {
		return SpouseincomeSearchPage_noIncomeButton;
	}

	public void setSpouseincomeSearchPage_noIncomeButton(String spouseincomeSearchPage_noIncomeButton) {
		SpouseincomeSearchPage_noIncomeButton = spouseincomeSearchPage_noIncomeButton;
	}

	public String getSpouseincomeSearchPage_beginButton() {
		return SpouseincomeSearchPage_beginButton;
	}

	public void setSpouseincomeSearchPage_beginButton(String spouseincomeSearchPage_beginButton) {
		SpouseincomeSearchPage_beginButton = spouseincomeSearchPage_beginButton;
	}

	public String getSpouseemploymentPage_pageLabel() {
		return SpouseemploymentPage_pageLabel;
	}

	public void setSpouseemploymentPage_pageLabel(String spouseemploymentPage_pageLabel) {
		SpouseemploymentPage_pageLabel = spouseemploymentPage_pageLabel;
	}

	public String getSpouseemploymentPage_currentlyWorkHereCheckbox() {
		return SpouseemploymentPage_currentlyWorkHereCheckbox;
	}

	public void setSpouseemploymentPage_currentlyWorkHereCheckbox(
			String spouseemploymentPage_currentlyWorkHereCheckbox) {
		SpouseemploymentPage_currentlyWorkHereCheckbox = spouseemploymentPage_currentlyWorkHereCheckbox;
	}

	public String getSpouseemploymentPage_currentEmployerTextBox() {
		return SpouseemploymentPage_currentEmployerTextBox;
	}

	public void setSpouseemploymentPage_currentEmployerTextBox(String spouseemploymentPage_currentEmployerTextBox) {
		SpouseemploymentPage_currentEmployerTextBox = spouseemploymentPage_currentEmployerTextBox;
	}

	public String getSpouseemploymentPage_titleTextBox() {
		return SpouseemploymentPage_titleTextBox;
	}

	public void setSpouseemploymentPage_titleTextBox(String spouseemploymentPage_titleTextBox) {
		SpouseemploymentPage_titleTextBox = spouseemploymentPage_titleTextBox;
	}

	public String getSpouseemploymentPage_startDateTextBox() {
		return SpouseemploymentPage_startDateTextBox;
	}

	public void setSpouseemploymentPage_startDateTextBox(String spouseemploymentPage_startDateTextBox) {
		SpouseemploymentPage_startDateTextBox = spouseemploymentPage_startDateTextBox;
	}

	public String getSpouseemploymentPage_endDatePresentTextBox() {
		return SpouseemploymentPage_endDatePresentTextBox;
	}

	public void setSpouseemploymentPage_endDatePresentTextBox(String spouseemploymentPage_endDatePresentTextBox) {
		SpouseemploymentPage_endDatePresentTextBox = spouseemploymentPage_endDatePresentTextBox;
	}

	public String getSpouseemploymentPage_endDateManualTextBox() {
		return SpouseemploymentPage_endDateManualTextBox;
	}

	public void setSpouseemploymentPage_endDateManualTextBox(String spouseemploymentPage_endDateManualTextBox) {
		SpouseemploymentPage_endDateManualTextBox = spouseemploymentPage_endDateManualTextBox;
	}

	public String getSpouseemploymentPage_inThisLineYearsTextBox() {
		return SpouseemploymentPage_inThisLineYearsTextBox;
	}

	public void setSpouseemploymentPage_inThisLineYearsTextBox(String spouseemploymentPage_inThisLineYearsTextBox) {
		SpouseemploymentPage_inThisLineYearsTextBox = spouseemploymentPage_inThisLineYearsTextBox;
	}

	public String getSpouseemploymentPage_inThisLineMonthsTextBox() {
		return SpouseemploymentPage_inThisLineMonthsTextBox;
	}

	public void setSpouseemploymentPage_inThisLineMonthsTextBox(String spouseemploymentPage_inThisLineMonthsTextBox) {
		SpouseemploymentPage_inThisLineMonthsTextBox = spouseemploymentPage_inThisLineMonthsTextBox;
	}

	public String getSpouseemploymentPage_monthlyBaseSalaryTextBox() {
		return SpouseemploymentPage_monthlyBaseSalaryTextBox;
	}

	public void setSpouseemploymentPage_monthlyBaseSalaryTextBox(String spouseemploymentPage_monthlyBaseSalaryTextBox) {
		SpouseemploymentPage_monthlyBaseSalaryTextBox = spouseemploymentPage_monthlyBaseSalaryTextBox;
	}

	public String getSpouseemploymentPage_bonusButton() {
		return SpouseemploymentPage_bonusButton;
	}

	public void setSpouseemploymentPage_bonusButton(String spouseemploymentPage_bonusButton) {
		SpouseemploymentPage_bonusButton = spouseemploymentPage_bonusButton;
	}

	public String getSpouseemploymentPage_commissionButton() {
		return SpouseemploymentPage_commissionButton;
	}

	public void setSpouseemploymentPage_commissionButton(String spouseemploymentPage_commissionButton) {
		SpouseemploymentPage_commissionButton = spouseemploymentPage_commissionButton;
	}

	public String getSpouseemploymentPage_overtimeButton() {
		return SpouseemploymentPage_overtimeButton;
	}

	public void setSpouseemploymentPage_overtimeButton(String spouseemploymentPage_overtimeButton) {
		SpouseemploymentPage_overtimeButton = spouseemploymentPage_overtimeButton;
	}

	public String getSpouseemploymentPage_allButton() {
		return SpouseemploymentPage_allButton;
	}

	public void setSpouseemploymentPage_allButton(String spouseemploymentPage_allButton) {
		SpouseemploymentPage_allButton = spouseemploymentPage_allButton;
	}

	public String getSpouseemploymentPage_bonusTextBox() {
		return SpouseemploymentPage_bonusTextBox;
	}

	public void setSpouseemploymentPage_bonusTextBox(String spouseemploymentPage_bonusTextBox) {
		SpouseemploymentPage_bonusTextBox = spouseemploymentPage_bonusTextBox;
	}

	public String getSpouseemploymentPage_commissionTextBox() {
		return SpouseemploymentPage_commissionTextBox;
	}

	public void setSpouseemploymentPage_commissionTextBox(String spouseemploymentPage_commissionTextBox) {
		SpouseemploymentPage_commissionTextBox = spouseemploymentPage_commissionTextBox;
	}

	public String getSpouseemploymentPage_overtimeTextBox() {
		return SpouseemploymentPage_overtimeTextBox;
	}

	public void setSpouseemploymentPage_overtimeTextBox(String spouseemploymentPage_overtimeTextBox) {
		SpouseemploymentPage_overtimeTextBox = spouseemploymentPage_overtimeTextBox;
	}

	public String getSpouseemploymentPage_nextButton() {
		return SpouseemploymentPage_nextButton;
	}

	public void setSpouseemploymentPage_nextButton(String spouseemploymentPage_nextButton) {
		SpouseemploymentPage_nextButton = spouseemploymentPage_nextButton;
	}

	public String getSpousealimondyChildSupportPage_pageLabel() {
		return SpousealimondyChildSupportPage_pageLabel;
	}

	public void setSpousealimondyChildSupportPage_pageLabel(String spousealimondyChildSupportPage_pageLabel) {
		SpousealimondyChildSupportPage_pageLabel = spousealimondyChildSupportPage_pageLabel;
	}

	public String getSpousealimondyChildSupportPage_alimonyPerMonthTextBox() {
		return SpousealimondyChildSupportPage_alimonyPerMonthTextBox;
	}

	public void setSpousealimondyChildSupportPage_alimonyPerMonthTextBox(
			String spousealimondyChildSupportPage_alimonyPerMonthTextBox) {
		SpousealimondyChildSupportPage_alimonyPerMonthTextBox = spousealimondyChildSupportPage_alimonyPerMonthTextBox;
	}

	public String getSpousealimondyChildSupportPage_alimonyStartDateTextBox() {
		return SpousealimondyChildSupportPage_alimonyStartDateTextBox;
	}

	public void setSpousealimondyChildSupportPage_alimonyStartDateTextBox(
			String spousealimondyChildSupportPage_alimonyStartDateTextBox) {
		SpousealimondyChildSupportPage_alimonyStartDateTextBox = spousealimondyChildSupportPage_alimonyStartDateTextBox;
	}

	public String getSpousealimondyChildSupportPage_childSupportPerMonthTextBox() {
		return SpousealimondyChildSupportPage_childSupportPerMonthTextBox;
	}

	public void setSpousealimondyChildSupportPage_childSupportPerMonthTextBox(
			String spousealimondyChildSupportPage_childSupportPerMonthTextBox) {
		SpousealimondyChildSupportPage_childSupportPerMonthTextBox = spousealimondyChildSupportPage_childSupportPerMonthTextBox;
	}

	public String getSpousealimondyChildSupportPage_childNameTextBox() {
		return SpousealimondyChildSupportPage_childNameTextBox;
	}

	public void setSpousealimondyChildSupportPage_childNameTextBox(
			String spousealimondyChildSupportPage_childNameTextBox) {
		SpousealimondyChildSupportPage_childNameTextBox = spousealimondyChildSupportPage_childNameTextBox;
	}

	public String getSpousealimondyChildSupportPage_childDoBTextBox() {
		return SpousealimondyChildSupportPage_childDoBTextBox;
	}

	public void setSpousealimondyChildSupportPage_childDoBTextBox(
			String spousealimondyChildSupportPage_childDoBTextBox) {
		SpousealimondyChildSupportPage_childDoBTextBox = spousealimondyChildSupportPage_childDoBTextBox;
	}

	public String getSpousealimondyChildSupportPage_nextButton() {
		return SpousealimondyChildSupportPage_nextButton;
	}

	public void setSpousealimondyChildSupportPage_nextButton(String spousealimondyChildSupportPage_nextButton) {
		SpousealimondyChildSupportPage_nextButton = spousealimondyChildSupportPage_nextButton;
	}

	public String getSpousemploymentAddressPage_businessAddressTextBox() {
		return SpousemploymentAddressPage_businessAddressTextBox;
	}

	public void setSpousemploymentAddressPage_businessAddressTextBox(
			String spousemploymentAddressPage_businessAddressTextBox) {
		SpousemploymentAddressPage_businessAddressTextBox = spousemploymentAddressPage_businessAddressTextBox;
	}

	public String getSpouseemploymentAddressPage_phoneNumberTextBox() {
		return SpouseemploymentAddressPage_phoneNumberTextBox;
	}

	public void setSpouseemploymentAddressPage_phoneNumberTextBox(
			String spouseemploymentAddressPage_phoneNumberTextBox) {
		SpouseemploymentAddressPage_phoneNumberTextBox = spouseemploymentAddressPage_phoneNumberTextBox;
	}

	public String getSpousesupportPage_pageLabel() {
		return SpousesupportPage_pageLabel;
	}

	public void setSpousesupportPage_pageLabel(String spousesupportPage_pageLabel) {
		SpousesupportPage_pageLabel = spousesupportPage_pageLabel;
	}

	public String getSpousesupportPage_supportByCourtButton() {
		return SpousesupportPage_supportByCourtButton;
	}

	public void setSpousesupportPage_supportByCourtButton(String spousesupportPage_supportByCourtButton) {
		SpousesupportPage_supportByCourtButton = spousesupportPage_supportByCourtButton;
	}

	public String getSpousesupportPage_noSupportByCourtButton() {
		return SpousesupportPage_noSupportByCourtButton;
	}

	public void setSpousesupportPage_noSupportByCourtButton(String spousesupportPage_noSupportByCourtButton) {
		SpousesupportPage_noSupportByCourtButton = spousesupportPage_noSupportByCourtButton;
	}

	public String getSpousesupportPage_willReceiveCourtSupportButton() {
		return SpousesupportPage_willReceiveCourtSupportButton;
	}

	public void setSpousesupportPage_willReceiveCourtSupportButton(
			String spousesupportPage_willReceiveCourtSupportButton) {
		SpousesupportPage_willReceiveCourtSupportButton = spousesupportPage_willReceiveCourtSupportButton;
	}

	public String getSpousesupportPage_willNotReceiveCourtSupportButton() {
		return SpousesupportPage_willNotReceiveCourtSupportButton;
	}

	public void setSpousesupportPage_willNotReceiveCourtSupportButton(
			String spousesupportPage_willNotReceiveCourtSupportButton) {
		SpousesupportPage_willNotReceiveCourtSupportButton = spousesupportPage_willNotReceiveCourtSupportButton;
	}

	public String getSpousesupportPage_postLoanClosureSupportButton() {
		return SpousesupportPage_postLoanClosureSupportButton;
	}

	public void setSpousesupportPage_postLoanClosureSupportButton(
			String spousesupportPage_postLoanClosureSupportButton) {
		SpousesupportPage_postLoanClosureSupportButton = spousesupportPage_postLoanClosureSupportButton;
	}

	public String getSpousesupportPage_postLoanClosureNoSupportButton() {
		return SpousesupportPage_postLoanClosureNoSupportButton;
	}

	public void setSpousesupportPage_postLoanClosureNoSupportButton(
			String spousesupportPage_postLoanClosureNoSupportButton) {
		SpousesupportPage_postLoanClosureNoSupportButton = spousesupportPage_postLoanClosureNoSupportButton;
	}

	public String getSpousesupportPage_nextButton() {
		return SpousesupportPage_nextButton;
	}

	public void setSpousesupportPage_nextButton(String spousesupportPage_nextButton) {
		SpousesupportPage_nextButton = spousesupportPage_nextButton;
	}

	public String getSpousebusinessSelfEmploymentPage_pageLabel() {
		return SpousebusinessSelfEmploymentPage_pageLabel;
	}

	public void setSpousebusinessSelfEmploymentPage_pageLabel(String spousebusinessSelfEmploymentPage_pageLabel) {
		SpousebusinessSelfEmploymentPage_pageLabel = spousebusinessSelfEmploymentPage_pageLabel;
	}

	public String getSpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox() {
		return SpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox;
	}

	public void setSpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox(
			String spousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox) {
		SpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox = spousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox;
	}

	public String getSpousebusinessSelfEmploymentPage_monthlyIncomeTextBox() {
		return SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_monthlyIncomeTextBox(
			String spousebusinessSelfEmploymentPage_monthlyIncomeTextBox) {
		SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox = spousebusinessSelfEmploymentPage_monthlyIncomeTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_companyNameTextBox() {
		return SpousebusinessSelfEmploymentPage_companyNameTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_companyNameTextBox(
			String spousebusinessSelfEmploymentPage_companyNameTextBox) {
		SpousebusinessSelfEmploymentPage_companyNameTextBox = spousebusinessSelfEmploymentPage_companyNameTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_titleTextBox() {
		return SpousebusinessSelfEmploymentPage_titleTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_titleTextBox(String spousebusinessSelfEmploymentPage_titleTextBox) {
		SpousebusinessSelfEmploymentPage_titleTextBox = spousebusinessSelfEmploymentPage_titleTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_companyAddressTextBox() {
		return SpousebusinessSelfEmploymentPage_companyAddressTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_companyAddressTextBox(
			String spousebusinessSelfEmploymentPage_companyAddressTextBox) {
		SpousebusinessSelfEmploymentPage_companyAddressTextBox = spousebusinessSelfEmploymentPage_companyAddressTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_companyPhoneTextBox() {
		return SpousebusinessSelfEmploymentPage_companyPhoneTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_companyPhoneTextBox(
			String spousebusinessSelfEmploymentPage_companyPhoneTextBox) {
		SpousebusinessSelfEmploymentPage_companyPhoneTextBox = spousebusinessSelfEmploymentPage_companyPhoneTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_companyStartDateTextBox() {
		return SpousebusinessSelfEmploymentPage_companyStartDateTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_companyStartDateTextBox(
			String spousebusinessSelfEmploymentPage_companyStartDateTextBox) {
		SpousebusinessSelfEmploymentPage_companyStartDateTextBox = spousebusinessSelfEmploymentPage_companyStartDateTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox() {
		return SpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox(
			String spousebusinessSelfEmploymentPage_companyEndDatePresentTextBox) {
		SpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox = spousebusinessSelfEmploymentPage_companyEndDatePresentTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_companyEndDateManualTextBox() {
		return SpousebusinessSelfEmploymentPage_companyEndDateManualTextBox;
	}

	public void setSpousebusinessSelfEmploymentPage_companyEndDateManualTextBox(
			String spousebusinessSelfEmploymentPage_companyEndDateManualTextBox) {
		SpousebusinessSelfEmploymentPage_companyEndDateManualTextBox = spousebusinessSelfEmploymentPage_companyEndDateManualTextBox;
	}

	public String getSpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton() {
		return SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton;
	}

	public void setSpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton(
			String spousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton) {
		SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton = spousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton;
	}

	public String getSpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton() {
		return SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton;
	}

	public void setSpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton(
			String spousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton) {
		SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton = spousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton;
	}

	public String getSpousebusinessSelfEmploymentPage_typeOfCompanyDropdown() {
		return SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown;
	}

	public void setSpousebusinessSelfEmploymentPage_typeOfCompanyDropdown(
			String spousebusinessSelfEmploymentPage_typeOfCompanyDropdown) {
		SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown = spousebusinessSelfEmploymentPage_typeOfCompanyDropdown;
	}

	public String getSpousebusinessSelfEmploymentPage_nextButton() {
		return SpousebusinessSelfEmploymentPage_nextButton;
	}

	public void setSpousebusinessSelfEmploymentPage_nextButton(String spousebusinessSelfEmploymentPage_nextButton) {
		SpousebusinessSelfEmploymentPage_nextButton = spousebusinessSelfEmploymentPage_nextButton;
	}

	public String getSpousemilitaryPage_pageLabel() {
		return SpousemilitaryPage_pageLabel;
	}

	public void setSpousemilitaryPage_pageLabel(String spousemilitaryPage_pageLabel) {
		SpousemilitaryPage_pageLabel = spousemilitaryPage_pageLabel;
	}

	public String getSpousemilitaryPage_perMonthIncomeTextBox() {
		return SpousemilitaryPage_perMonthIncomeTextBox;
	}

	public void setSpousemilitaryPage_perMonthIncomeTextBox(String spousemilitaryPage_perMonthIncomeTextBox) {
		SpousemilitaryPage_perMonthIncomeTextBox = spousemilitaryPage_perMonthIncomeTextBox;
	}

	public String getSpousemilitaryPage_nextButton() {
		return SpousemilitaryPage_nextButton;
	}

	public void setSpousemilitaryPage_nextButton(String spousemilitaryPage_nextButton) {
		SpousemilitaryPage_nextButton = spousemilitaryPage_nextButton;
	}

	public String getSpouserentalPage_pageLabel() {
		return SpouserentalPage_pageLabel;
	}

	public void setSpouserentalPage_pageLabel(String spouserentalPage_pageLabel) {
		SpouserentalPage_pageLabel = spouserentalPage_pageLabel;
	}

	public String getSpouserentalPage_rentalIncomeTextBox() {
		return SpouserentalPage_rentalIncomeTextBox;
	}

	public void setSpouserentalPage_rentalIncomeTextBox(String spouserentalPage_rentalIncomeTextBox) {
		SpouserentalPage_rentalIncomeTextBox = spouserentalPage_rentalIncomeTextBox;
	}

	public String getSpouserentalPage_propertyAddressTextBox() {
		return SpouserentalPage_propertyAddressTextBox;
	}

	public void setSpouserentalPage_propertyAddressTextBox(String spouserentalPage_propertyAddressTextBox) {
		SpouserentalPage_propertyAddressTextBox = spouserentalPage_propertyAddressTextBox;
	}

	public String getSpouserentalPage_propertyTypeDropdown() {
		return SpouserentalPage_propertyTypeDropdown;
	}

	public void setSpouserentalPage_propertyTypeDropdown(String spouserentalPage_propertyTypeDropdown) {
		SpouserentalPage_propertyTypeDropdown = spouserentalPage_propertyTypeDropdown;
	}

	public String getSpouserentalPage_numberOfUnitsDropdown() {
		return SpouserentalPage_numberOfUnitsDropdown;
	}

	public void setSpouserentalPage_numberOfUnitsDropdown(String spouserentalPage_numberOfUnitsDropdown) {
		SpouserentalPage_numberOfUnitsDropdown = spouserentalPage_numberOfUnitsDropdown;
	}

	public String getSpouserentalPage_propertyStatusDropdown() {
		return SpouserentalPage_propertyStatusDropdown;
	}

	public void setSpouserentalPage_propertyStatusDropdown(String spouserentalPage_propertyStatusDropdown) {
		SpouserentalPage_propertyStatusDropdown = spouserentalPage_propertyStatusDropdown;
	}

	public String getSpouserentalPage_propertyUseDropdown() {
		return SpouserentalPage_propertyUseDropdown;
	}

	public void setSpouserentalPage_propertyUseDropdown(String spouserentalPage_propertyUseDropdown) {
		SpouserentalPage_propertyUseDropdown = spouserentalPage_propertyUseDropdown;
	}

	public String getSpouserentalPage_propertyValueTextBox() {
		return SpouserentalPage_propertyValueTextBox;
	}

	public void setSpouserentalPage_propertyValueTextBox(String spouserentalPage_propertyValueTextBox) {
		SpouserentalPage_propertyValueTextBox = spouserentalPage_propertyValueTextBox;
	}

	public String getSpouserentalPage_monthlyRentalIncomeTextBox() {
		return SpouserentalPage_monthlyRentalIncomeTextBox;
	}

	public void setSpouserentalPage_monthlyRentalIncomeTextBox(String spouserentalPage_monthlyRentalIncomeTextBox) {
		SpouserentalPage_monthlyRentalIncomeTextBox = spouserentalPage_monthlyRentalIncomeTextBox;
	}

	public String getSpouserentalPage_additionalExpenseTextBox() {
		return SpouserentalPage_additionalExpenseTextBox;
	}

	public void setSpouserentalPage_additionalExpenseTextBox(String spouserentalPage_additionalExpenseTextBox) {
		SpouserentalPage_additionalExpenseTextBox = spouserentalPage_additionalExpenseTextBox;
	}

	public String getSpouserentalPage_netMonthlyRentalIncomeLabel() {
		return SpouserentalPage_netMonthlyRentalIncomeLabel;
	}

	public void setSpouserentalPage_netMonthlyRentalIncomeLabel(String spouserentalPage_netMonthlyRentalIncomeLabel) {
		SpouserentalPage_netMonthlyRentalIncomeLabel = spouserentalPage_netMonthlyRentalIncomeLabel;
	}

	public String getSpouserentalPage_iAmDoneButton() {
		return SpouserentalPage_iAmDoneButton;
	}

	public void setSpouserentalPage_iAmDoneButton(String spouserentalPage_iAmDoneButton) {
		SpouserentalPage_iAmDoneButton = spouserentalPage_iAmDoneButton;
	}

	public String getSpousesocialSecurityPage_pageLabel() {
		return SpousesocialSecurityPage_pageLabel;
	}

	public void setSpousesocialSecurityPage_pageLabel(String spousesocialSecurityPage_pageLabel) {
		SpousesocialSecurityPage_pageLabel = spousesocialSecurityPage_pageLabel;
	}

	public String getSpousesocialSecurityPage_incomePerMonthTextBox() {
		return SpousesocialSecurityPage_incomePerMonthTextBox;
	}

	public void setSpousesocialSecurityPage_incomePerMonthTextBox(
			String spousesocialSecurityPage_incomePerMonthTextBox) {
		SpousesocialSecurityPage_incomePerMonthTextBox = spousesocialSecurityPage_incomePerMonthTextBox;
	}

	public String getSpousesocialSecurityPage_nextButton() {
		return SpousesocialSecurityPage_nextButton;
	}

	public void setSpousesocialSecurityPage_nextButton(String spousesocialSecurityPage_nextButton) {
		SpousesocialSecurityPage_nextButton = spousesocialSecurityPage_nextButton;
	}

	public String getSpouseinterestDividendPage_pageLabel() {
		return SpouseinterestDividendPage_pageLabel;
	}

	public void setSpouseinterestDividendPage_pageLabel(String spouseinterestDividendPage_pageLabel) {
		SpouseinterestDividendPage_pageLabel = spouseinterestDividendPage_pageLabel;
	}

	public String getSpouseinterestDividendPage_lastYearDividendTextBox() {
		return SpouseinterestDividendPage_lastYearDividendTextBox;
	}

	public void setSpouseinterestDividendPage_lastYearDividendTextBox(
			String spouseinterestDividendPage_lastYearDividendTextBox) {
		SpouseinterestDividendPage_lastYearDividendTextBox = spouseinterestDividendPage_lastYearDividendTextBox;
	}

	public String getSpouseinterestDividendPage_yearBeforeLastYearDividendTextBox() {
		return SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox;
	}

	public void setSpouseinterestDividendPage_yearBeforeLastYearDividendTextBox(
			String spouseinterestDividendPage_yearBeforeLastYearDividendTextBox) {
		SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox = spouseinterestDividendPage_yearBeforeLastYearDividendTextBox;
	}

	public String getSpouseinterestDividendPage_nextButton() {
		return SpouseinterestDividendPage_nextButton;
	}

	public void setSpouseinterestDividendPage_nextButton(String spouseinterestDividendPage_nextButton) {
		SpouseinterestDividendPage_nextButton = spouseinterestDividendPage_nextButton;
	}

	public String getSpouseotherIncomePage_pageLabel() {
		return SpouseotherIncomePage_pageLabel;
	}

	public void setSpouseotherIncomePage_pageLabel(String spouseotherIncomePage_pageLabel) {
		SpouseotherIncomePage_pageLabel = spouseotherIncomePage_pageLabel;
	}

	public String getSpouseotherIncomePage_otherIncomeTextBox() {
		return SpouseotherIncomePage_otherIncomeTextBox;
	}

	public void setSpouseotherIncomePage_otherIncomeTextBox(String spouseotherIncomePage_otherIncomeTextBox) {
		SpouseotherIncomePage_otherIncomeTextBox = spouseotherIncomePage_otherIncomeTextBox;
	}

	public String getSpouseotherIncomePage_sourceOfIncomeDropdown() {
		return SpouseotherIncomePage_sourceOfIncomeDropdown;
	}

	public void setSpouseotherIncomePage_sourceOfIncomeDropdown(String spouseotherIncomePage_sourceOfIncomeDropdown) {
		SpouseotherIncomePage_sourceOfIncomeDropdown = spouseotherIncomePage_sourceOfIncomeDropdown;
	}

	public String getSpouseotherIncomePage_otherIncomeForMoreThan2YearsButton() {
		return SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton;
	}

	public void setSpouseotherIncomePage_otherIncomeForMoreThan2YearsButton(
			String spouseotherIncomePage_otherIncomeForMoreThan2YearsButton) {
		SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton = spouseotherIncomePage_otherIncomeForMoreThan2YearsButton;
	}

	public String getSpouseotherIncomePage_otherIncomeForLessThan2YearsButton() {
		return SpouseotherIncomePage_otherIncomeForLessThan2YearsButton;
	}

	public void setSpouseotherIncomePage_otherIncomeForLessThan2YearsButton(
			String spouseotherIncomePage_otherIncomeForLessThan2YearsButton) {
		SpouseotherIncomePage_otherIncomeForLessThan2YearsButton = spouseotherIncomePage_otherIncomeForLessThan2YearsButton;
	}

	public String getSpouseotherIncomePage_nextButton() {
		return SpouseotherIncomePage_nextButton;
	}

	public void setSpouseotherIncomePage_nextButton(String spouseotherIncomePage_nextButton) {
		SpouseotherIncomePage_nextButton = spouseotherIncomePage_nextButton;
	}

	public String getSpouseAddeddeclaration_next() {
		return SpouseAddeddeclaration_next;
	}

	public void setSpouseAddeddeclaration_next(String spouseAddeddeclaration_next) {
		SpouseAddeddeclaration_next = spouseAddeddeclaration_next;
	}

	public String getSpousedeclaration_race() {
		return Spousedeclaration_race;
	}

	public void setSpousedeclaration_race(String spousedeclaration_race) {
		Spousedeclaration_race = spousedeclaration_race;
	}

	public String getSpouseLoginTellAboutYouPage_tellAboutYourselfLabel() {
		return SpouseLoginTellAboutYouPage_tellAboutYourselfLabel;
	}

	public void setSpouseLoginTellAboutYouPage_tellAboutYourselfLabel(
			String spouseLoginTellAboutYouPage_tellAboutYourselfLabel) {
		SpouseLoginTellAboutYouPage_tellAboutYourselfLabel = spouseLoginTellAboutYouPage_tellAboutYourselfLabel;
	}

	public String getSpouseLoginborrowerCommunicationPage_pageLabel() {
		return SpouseLoginborrowerCommunicationPage_pageLabel;
	}

	public void setSpouseLoginborrowerCommunicationPage_pageLabel(
			String spouseLoginborrowerCommunicationPage_pageLabel) {
		SpouseLoginborrowerCommunicationPage_pageLabel = spouseLoginborrowerCommunicationPage_pageLabel;
	}

	public String getSpousecurrentResidentialDetailsPage_pageLabel() {
		return SpousecurrentResidentialDetailsPage_pageLabel;
	}

	public void setSpousecurrentResidentialDetailsPage_pageLabel(String spousecurrentResidentialDetailsPage_pageLabel) {
		SpousecurrentResidentialDetailsPage_pageLabel = spousecurrentResidentialDetailsPage_pageLabel;
	}

	public String getBorrowerSpouserentalPage_pageLabel() {
		return borrowerSpouserentalPage_pageLabel;
	}

	public void setBorrowerSpouserentalPage_pageLabel(String borrowerSpouserentalPage_pageLabel) {
		borrowerSpouserentalPage_pageLabel = borrowerSpouserentalPage_pageLabel;
	}

	public String getBorrowerSpouseinterestDividendPage_pageLabel() {
		return borrowerSpouseinterestDividendPage_pageLabel;
	}

	public void setBorrowerSpouseinterestDividendPage_pageLabel(String borrowerSpouseinterestDividendPage_pageLabel) {
		borrowerSpouseinterestDividendPage_pageLabel = borrowerSpouseinterestDividendPage_pageLabel;
	}

	public String getCoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton() {
		return CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton(
			String coborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton) {
		CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton = coborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton;
	}

	public String getCoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton() {
		return CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton;
	}

	public void setCoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton(
			String coborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton) {
		CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton = coborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton;
	}

	public String getBorrowerCommunicationPage_coborSpousepreferredEmailTextBox() {
		return borrowerCommunicationPage_coborSpousepreferredEmailTextBox;
	}

	public void setBorrowerCommunicationPage_coborSpousepreferredEmailTextBox(
			String borrowerCommunicationPage_coborSpousepreferredEmailTextBox) {
		borrowerCommunicationPage_coborSpousepreferredEmailTextBox = borrowerCommunicationPage_coborSpousepreferredEmailTextBox;
	}

	public String getBorrowerCommunicationPage_coborHispreferredEmailTextBox() {
		return borrowerCommunicationPage_coborHispreferredEmailTextBox;
	}

	public void setBorrowerCommunicationPage_coborHispreferredEmailTextBox(
			String borrowerCommunicationPage_coborHispreferredEmailTextBox) {
		borrowerCommunicationPage_coborHispreferredEmailTextBox = borrowerCommunicationPage_coborHispreferredEmailTextBox;
	}

	public String getBorrowerCommunicationPage_cobSpouseemailButton() {
		return borrowerCommunicationPage_cobSpouseemailButton;
	}

	public void setBorrowerCommunicationPage_cobSpouseemailButton(
			String borrowerCommunicationPage_cobSpouseemailButton) {
		borrowerCommunicationPage_cobSpouseemailButton = borrowerCommunicationPage_cobSpouseemailButton;
	}

	public String getCobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel() {
		return CobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel;
	}

	public void setCobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel(
			String cobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel) {
		CobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel = cobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel;
	}

	public String getAffinity_ProfileFirstName() {
		return Affinity_ProfileFirstName;
	}

	public void setAffinity_ProfileFirstName(String affinity_ProfileFirstName) {
		Affinity_ProfileFirstName = affinity_ProfileFirstName;
	}

	public String getAffinity_ProfileLastName() {
		return Affinity_ProfileLastName;
	}

	public void setAffinity_ProfileLastName(String affinity_ProfileLastName) {
		Affinity_ProfileLastName = affinity_ProfileLastName;
	}

	public String getAffinity_ProfilePerferredEmail() {
		return Affinity_ProfilePerferredEmail;
	}

	public void setAffinity_ProfilePerferredEmail(String affinity_ProfilePerferredEmail) {
		Affinity_ProfilePerferredEmail = affinity_ProfilePerferredEmail;
	}

	public String getAffinity_ProfilePhone() {
		return Affinity_ProfilePhone;
	}

	public void setAffinity_ProfilePhone(String affinity_ProfilePhone) {
		Affinity_ProfilePhone = affinity_ProfilePhone;
	}

	public String getAffinity_ProfileNext() {
		return Affinity_ProfileNext;
	}

	public void setAffinity_ProfileNext(String affinity_ProfileNext) {
		Affinity_ProfileNext = affinity_ProfileNext;
	}

	public String getAffinity_CompanyProfileCompanyName() {
		return Affinity_CompanyProfileCompanyName;
	}

	public void setAffinity_CompanyProfileCompanyName(String affinity_CompanyProfileCompanyName) {
		Affinity_CompanyProfileCompanyName = affinity_CompanyProfileCompanyName;
	}

	public String getAffinity_CompanyProfileAddress() {
		return Affinity_CompanyProfileAddress;
	}

	public void setAffinity_CompanyProfileAddress(String affinity_CompanyProfileAddress) {
		Affinity_CompanyProfileAddress = affinity_CompanyProfileAddress;
	}

	public String getAffinity_CompanyProfilePhone() {
		return Affinity_CompanyProfilePhone;
	}

	public void setAffinity_CompanyProfilePhone(String affinity_CompanyProfilePhone) {
		Affinity_CompanyProfilePhone = affinity_CompanyProfilePhone;
	}

	public String getAffinity_CompanyProfileNext() {
		return Affinity_CompanyProfileNext;
	}

	public void setAffinity_CompanyProfileNext(String affinity_CompanyProfileNext) {
		Affinity_CompanyProfileNext = affinity_CompanyProfileNext;
	}

	public String getAffinity_InviteFirstName() {
		return Affinity_InviteFirstName;
	}

	public void setAffinity_InviteFirstName(String affinity_InviteFirstName) {
		Affinity_InviteFirstName = affinity_InviteFirstName;
	}

	public String getAffinity_InviteLastName() {
		return Affinity_InviteLastName;
	}

	public void setAffinity_InviteLastName(String affinity_InviteLastName) {
		Affinity_InviteLastName = affinity_InviteLastName;
	}

	public String getAffinity_InviteEmail() {
		return Affinity_InviteEmail;
	}

	public void setAffinity_InviteEmail(String affinity_InviteEmail) {
		Affinity_InviteEmail = affinity_InviteEmail;
	}

	public String getAffinity_InvitePhone() {
		return Affinity_InvitePhone;
	}

	public void setAffinity_InvitePhone(String affinity_InvitePhone) {
		Affinity_InvitePhone = affinity_InvitePhone;
	}

	public String getAffinity_InviteButton() {
		return Affinity_InviteButton;
	}

	public void setAffinity_InviteButton(String affinity_InviteButton) {
		Affinity_InviteButton = affinity_InviteButton;
	}

	public String getAffinity_Profilelabel() {
		return Affinity_Profilelabel;
	}

	public void setAffinity_Profilelabel(String affinity_Profilelabel) {
		Affinity_Profilelabel = affinity_Profilelabel;
	}

	public String getAffinity_CompanyProfilelabel() {
		return Affinity_CompanyProfilelabel;
	}

	public void setAffinity_CompanyProfilelabel(String affinity_CompanyProfilelabel) {
		Affinity_CompanyProfilelabel = affinity_CompanyProfilelabel;
	}

	public String getAffinity_Invitelabel() {
		return Affinity_Invitelabel;
	}

	public void setAffinity_Invitelabel(String affinity_Invitelabel) {
		Affinity_Invitelabel = affinity_Invitelabel;
	}

	public String getRefinance_pageLabel() {
		return Refinance_pageLabel;
	}

	public void setRefinance_pageLabel(String refinance_pageLabel) {
		Refinance_pageLabel = refinance_pageLabel;
	}

	public String getRefinance_propertyTypeDropdown() {
		return Refinance_propertyTypeDropdown;
	}

	public void setRefinance_propertyTypeDropdown(String refinance_propertyTypeDropdown) {
		Refinance_propertyTypeDropdown = refinance_propertyTypeDropdown;
	}

	public String getRefinance_numberOfUnitsDropdown() {
		return Refinance_numberOfUnitsDropdown;
	}

	public void setRefinance_numberOfUnitsDropdown(String refinance_numberOfUnitsDropdown) {
		Refinance_numberOfUnitsDropdown = refinance_numberOfUnitsDropdown;
	}

	public String getRefinancePage_RefinanceLoanAmount() {
		return RefinancePage_RefinanceLoanAmount;
	}

	public void setRefinancePage_RefinanceLoanAmount(String refinancePage_RefinanceLoanAmount) {
		RefinancePage_RefinanceLoanAmount = refinancePage_RefinanceLoanAmount;
	}

	public String getRefinancePage_1stLoanAmount() {
		return RefinancePage_1stLoanAmount;
	}

	public void setRefinancePage_1stLoanAmount(String refinancePage_1stLoanAmount) {
		RefinancePage_1stLoanAmount = refinancePage_1stLoanAmount;
	}

	public String getRefinancePage_2ndLoanAmount() {
		return RefinancePage_2ndLoanAmount;
	}

	public void setRefinancePage_2ndLoanAmount(String refinancePage_2ndLoanAmount) {
		RefinancePage_2ndLoanAmount = refinancePage_2ndLoanAmount;
	}

	public String getRefinancePage_OtherLoanAmount() {
		return RefinancePage_OtherLoanAmount;
	}

	public void setRefinancePage_OtherLoanAmount(String refinancePage_OtherLoanAmount) {
		RefinancePage_OtherLoanAmount = refinancePage_OtherLoanAmount;
	}

	public String getRefinancePage_Iscashoutequality() {
		return RefinancePage_Iscashoutequality;
	}

	public void setRefinancePage_Iscashoutequality(String refinancePage_Iscashoutequality) {
		RefinancePage_Iscashoutequality = refinancePage_Iscashoutequality;
	}

	public String getRefinancePage_IsNotcashoutequality() {
		return RefinancePage_IsNotcashoutequality;
	}

	public void setRefinancePage_IsNotcashoutequality(String refinancePage_IsNotcashoutequality) {
		RefinancePage_IsNotcashoutequality = refinancePage_IsNotcashoutequality;
	}
}
