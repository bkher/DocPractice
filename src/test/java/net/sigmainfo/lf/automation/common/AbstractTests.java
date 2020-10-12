package net.sigmainfo.lf.automation.common;

import com.mongodb.*;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import net.sigmainfo.lf.automation.api.function.ApiPropertiesReader;
import net.sigmainfo.lf.automation.portal.constant.UIObjParam;
import net.sigmainfo.lf.automation.portal.function.PortalFuncUtils;
import net.sigmainfo.lf.automation.api.config.ApiConfig;
import net.sigmainfo.lf.automation.api.constant.ApiParam;
import net.sigmainfo.lf.automation.portal.config.PortalConfig;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.function.PortalPropertiesReader;
import net.sigmainfo.lf.automation.portal.function.UIObjPropertiesReader;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

//import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * Created by : Shaishav.s on 18-04-2018. Test class : AbstractTests.java
 * Description : Drives automation suite and delegates testng annotations
 * Includes : 1. Setup and quit method for browser opening and closing for
 * portal cases 2. Initializes test data and test property files 3. Custom
 * Reporting methodsgetSummary
 */

@ContextConfiguration(classes = { PortalConfig.class, ApiConfig.class })
@TestExecutionListeners(inheritListeners = false, listeners = { DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class })
@WebAppConfiguration
// @Test
//@Listeners(Listener_Demo.ListenerTest.class)	
public class AbstractTests extends AbstractTestNGSpringContextTests {

	private Logger logger = LoggerFactory.getLogger(AbstractTests.class);

	static Server automationServer = new Server(9096);

	public ConsoleError conerror = new ConsoleError();
	static boolean setupDone = false;
	public static boolean ifFileExist = false;
	public static long auto_start = 0;
	public static String Execution_start_time = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss").format(new Date());
	public static long auto_finish = 0;
	public static String sResBackUp = "res/TestReport.txt";

	public enum browser_list {
		IE, FF, Chrome;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver driver;
	public static int profile_delay = 40;
	public static int ShortSleep = 40;
	public static BrowserMobProxyServer server;
	public static File Purchasecasefile, Refinancecasefile, Purchase_scenfile, Purchase_feafile, Refinance_scenfile,
			Refinance_feafile, feafile;
	String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	public String inviteId = new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime());

	@Autowired
	ApiParam apiParam;

	@Autowired
	ApiPropertiesReader apiPropertiesReader;

	@Autowired
	public PortalParam portalParam;

	@Autowired
	public UIObjParam uiObjParam;

	@Autowired
	UIObjPropertiesReader uiPropertiesReader;

	@Autowired
	public PortalFuncUtils portalFuncUtils;

	@Autowired
	public PortalPropertiesReader portalPropertiesReader;

	@BeforeSuite(alwaysRun = true)
	public void setUpOnce() throws Exception {
		logger.info("======================== Before Suite Invoked ==============================");
		setupJetty("Docitt-automation", automationServer);
		logger.info("Jetty Server Started..........");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		logger.info("======================== After Suite Invoked. ==============================");
		automationServer.getServer().stop();
		logger.info("Jetty Server Stopped..........");
	}

	/*
	 * @PostConstruct private void postConstruct() throws SQLException, Exception {
	 * if (!setupDone) { logger.
	 * info("======================== Post Construct Invoked. =============================="
	 * ); setupDBParams(); setupUIObjects(); setupDone = true; } }
	 */
	public void setupUIObjects() {
		logger.info("--------------- READING UI OBJECTS ----------------");

		uiObjParam.lenderGetStartedPage_getStartedLabel = uiPropertiesReader.getLenderGetStartedPage_getStartedLabel();
		logger.info(
				"uiObjParam.lenderGetStartedPage_getStartedLabel : " + uiObjParam.lenderGetStartedPage_getStartedLabel);
		uiObjParam.lenderGetStartedPage_loginButton = uiPropertiesReader.getLenderGetStartedPage_loginButton();
		logger.info("uiObjParam.lenderGetStartedPage_loginButton : " + uiObjParam.lenderGetStartedPage_loginButton);
		uiObjParam.lenderLoginPage_emailTextBox = uiPropertiesReader.getLenderLoginPage_emailTextBox();
		logger.info("uiObjParam.lenderLoginPage_emailTextBox : " + uiObjParam.lenderLoginPage_emailTextBox);
		uiObjParam.lenderLoginPage_passwordTextBox = uiPropertiesReader.getLenderLoginPage_passwordTextBox();
		logger.info("uiObjParam.lenderLoginPage_passwordTextBox : " + uiObjParam.lenderLoginPage_passwordTextBox);
		uiObjParam.lenderLoginPage_loginButton = uiPropertiesReader.getLenderLoginPage_loginButton();
		logger.info("uiObjParagetSummarym.lenderLoginPage_loginButton : " + uiObjParam.lenderLoginPage_loginButton);
		uiObjParam.lenderPipelinePage_inviteButton = uiPropertiesReader.getLenderPipelinePage_inviteButton();
		logger.info("uiObjParam.lenderPipelinePage_inviteButton : " + uiObjParam.lenderPipelinePage_inviteButton);
		uiObjParam.lenderPipelinePage_panelLoanOfficePic = uiPropertiesReader
				.getLenderPipelinePage_panelLoanOfficePic();
		logger.info("uiObjParam.lenderPipelinePage_panelLoanOfficePic : "
				+ uiObjParam.lenderPipelinePage_panelLoanOfficePic);
		uiObjParam.lenderPipelinePage_panelLoanOfficerLabel = uiPropertiesReader
				.getLenderPipelinePage_panelLoanOfficerLabel();
		logger.info("uiObjParam.lenderPipelinePage_panelLoanOfficerLabel : "
				+ uiObjParam.lenderPipelinePage_panelLoanOfficerLabel);
		uiObjParam.lenderPipeline_headerPanel_settingDropdown = uiPropertiesReader
				.getLenderPipeline_headerPanel_settingDropdown();
		logger.info("uiObjParam.lenderPipeline_headerPanel_settingDropdown : "
				+ uiObjParam.lenderPipeline_headerPanel_settingDropdown);
		uiObjParam.lenderPipeline_activeLoansTab = uiPropertiesReader.getLenderPipeline_activeLoansTab();
		logger.info("uiObjParam.lenderPipeline_activeLoansTab : " + uiObjParam.lenderPipeline_activeLoansTab);
		uiObjParam.lenderPipeline_applicationsTab = uiPropertiesReader.getLenderPipeline_applicationsTab();
		logger.info("uiObjParam.lenderPipeline_applicationsTab : " + uiObjParam.lenderPipeline_applicationsTab);
		uiObjParam.lenderPipeline_closedTab = uiPropertiesReader.getLenderPipeline_closedTab();
		logger.info("uiObjParam.lenderPipeline_closedTab : " + uiObjParam.lenderPipeline_closedTab);
		uiObjParam.lenderPipeline_firstActiveLoan_daysToCloseLabel = uiPropertiesReader
				.getLenderPipeline_firstActiveLoan_daysToCloseLabel();
		logger.info("uiObjParam.lenderPipeline_firstActiveLoan_daysToCloseLabel : "
				+ uiObjParam.lenderPipeline_firstActiveLoan_daysToCloseLabel);
		uiObjParam.lenderPipeline_firstActiveLoan_firstLoanIdLabel = uiPropertiesReader
				.getLenderPipeline_firstActiveLoan_firstLoanIdLabel();
		logger.info("uiObjParam.lenderPipeline_firstActiveLoan_firstLoanIdLabel : "
				+ uiObjParam.lenderPipeline_firstActiveLoan_firstLoanIdLabel);
		uiObjParam.lenderLoginPage_forgetPasswordLink = uiPropertiesReader.getLenderLoginPage_forgetPasswordLink();
		logger.info("uiObjParam.lenderLoginPage_forgetPasswordLink : " + uiObjParam.lenderLoginPage_forgetPasswordLink);
		uiObjParam.lenderPipeline_headerPanel_settingDropdown_logoutButton = uiPropertiesReader
				.getLenderPipeline_headerPanel_settingDropdown_logoutButton();
		logger.info("uiObjParam.lenderPipeline_headerPanel_settingDropdown_logoutButton : "
				+ uiObjParam.lenderPipeline_headerPanel_settingDropdown_logoutButton);
		uiObjParam.lenderPipeline_inviteDialog_inviteLabel = uiPropertiesReader
				.getLenderPipeline_inviteDialog_inviteLabel();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_inviteLabel : "
				+ uiObjParam.lenderPipeline_inviteDialog_inviteLabel);
		uiObjParam.lenderPipeline_inviteDialog_firstNameTextBox = uiPropertiesReader
				.getLenderPipeline_inviteDialog_firstNameTextBox();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_firstNameTextBox : "
				+ uiObjParam.lenderPipeline_inviteDialog_firstNameTextBox);
		uiObjParam.lenderPipeline_inviteDialog_lastNameTextBox = uiPropertiesReader
				.getLenderPipeline_inviteDialog_lastNameTextBox();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_lastNameTextBox : "
				+ uiObjParam.lenderPipeline_inviteDialog_lastNameTextBox);
		uiObjParam.lenderPipeline_inviteDialog_borrowerButton = uiPropertiesReader
				.getLenderPipeline_inviteDialog_borrowerButton();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_borrowerButton : "
				+ uiObjParam.lenderPipeline_inviteDialog_borrowerButton);
		uiObjParam.lenderPipeline_inviteDialog_affinityPartnerButton = uiPropertiesReader
				.getLenderPipeline_inviteDialog_affinityPartnerButton();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_affinityPartnerButton : "
				+ uiObjParam.lenderPipeline_inviteDialog_affinityPartnerButton);
		uiObjParam.lenderPipeline_inviteDialog_emailTextBox = uiPropertiesReader
				.getLenderPipeline_inviteDialog_emailTextBox();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_emailTextBox : "
				+ uiObjParam.lenderPipeline_inviteDialog_emailTextBox);
		uiObjParam.lenderPipeline_inviteDialog_phoneTextBox = uiPropertiesReader
				.getLenderPipeline_inviteDialog_phoneTextBox();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_phoneTextBox : "
				+ uiObjParam.lenderPipeline_inviteDialog_phoneTextBox);
		uiObjParam.lenderPipeline_inviteDialog_sendInviteButton = uiPropertiesReader
				.getLenderPipeline_inviteDialog_sendInviteButton();
		logger.info("uiObjParam.lenderPipeline_inviteDialog_sendInviteButton : "
				+ uiObjParam.lenderPipeline_inviteDialog_sendInviteButton);
		uiObjParam.borrowerSignUpPage_emailTextBox = uiPropertiesReader.getBorrowerSignUpPage_emailTextBox();
		logger.info("uiObjParam.borrowerSignUpPage_emailTextBox : " + uiObjParam.borrowerSignUpPage_emailTextBox);
		uiObjParam.borrowerSignUpPage_passwordTextBox = uiPropertiesReader.getBorrowerSignUpPage_passwordTextBox();
		logger.info("uiObjParam.borrowerSignUpPage_passwordTextBox : " + uiObjParam.borrowerSignUpPage_passwordTextBox);
		uiObjParam.borrowerSignUpPage_confirmPasswordTextBox = uiPropertiesReader
				.getBorrowerSignUpPage_confirmPasswordTextBox();
		logger.info("uiObjParam.borrowerSignUpPage_confirmPasswordTextBox : "
				+ uiObjParam.borrowerSignUpPage_confirmPasswordTextBox);
		uiObjParam.borrowerSignUpPage_signUpButton = uiPropertiesReader.getBorrowerSignUpPage_signUpButton();
		logger.info("uiObjParam.borrowerSignUpPage_signUpButton : " + uiObjParam.borrowerSignUpPage_signUpButton);
		uiObjParam.borrowerSignUpPage_welcomeMessage = uiPropertiesReader.getBorrowerSignUpPage_welcomeMessage();
		logger.info("uiObjParam.borrowerSignUpPage_welcomeMessage : " + uiObjParam.borrowerSignUpPage_welcomeMessage);
		uiObjParam.borrowerWelcomePage_typeOfLoanSelectionMessage = uiPropertiesReader
				.getBorrowerWelcomePage_typeOfLoanSelectionMessage();
		logger.info("uiObjParagetSummarym.borrowerWelcomePage_typeOfLoanSelectionMessage : "
				+ uiObjParam.borrowerWelcomePage_typeOfLoanSelectionMessage);
		uiObjParam.borrowerWelcomePage_purchaseLoanButton = uiPropertiesReader
				.getBorrowerWelcomePage_purchaseLoanButton();
		logger.info("uiObjParam.borrowerWelcomePage_purchaseLoanButton : "
				+ uiObjParam.borrowerWelcomePage_purchaseLoanButton);
		uiObjParam.borrowerWelcomePage_refinanceLoanButton = uiPropertiesReader
				.getBorrowerWelcomePage_refinanceLoanButton();
		logger.info("uiObjParam.borrowerWelcomePage_refinanceLoanButton : "
				+ uiObjParam.borrowerWelcomePage_refinanceLoanButton);
		uiObjParam.borrowerHeader_nafLogo = uiPropertiesReader.getBorrowerHeader_nafLogo();
		logger.info("uiObjParam.borrowerHeader_nafLogo : " + uiObjParam.borrowerHeader_nafLogo);
		uiObjParam.borrowerHeader_profileDropdown = uiPropertiesReader.getBorrowerHeader_profileDropdown();
		logger.info("uiObjParam.borrowerHeader_profileDropdown : " + uiObjParam.borrowerHeader_profileDropdown);
		uiObjParam.borrowerHeader_profileDropdown_logoutButton = uiPropertiesReader
				.getBorrowerHeader_profileDropdown_logoutButton();
		logger.info("uiObjParam.borrowerHeader_profileDropdown_logoutButton : "
				+ uiObjParam.borrowerHeader_profileDropdown_logoutButton);
		uiObjParam.borrowerWelcomeVideoPage_lenderImage = uiPropertiesReader.getBorrowerWelcomeVideoPage_lenderImage();
		logger.info(
				"uiObjParam.borrowerWelcomeVideoPage_lenderImage : " + uiObjParam.borrowerWelcomeVideoPage_lenderImage);
		uiObjParam.borrowerWelcomeVideoPage_loanOfficerLabel = uiPropertiesReader
				.getBorrowerWelcomeVideoPage_loanOfficerLabel();
		logger.info("uiObjParam.borrowerWelcomeVideoPage_loanOfficerLabel : "
				+ uiObjParam.borrowerWelcomeVideoPage_loanOfficerLabel);
		uiObjParam.borrowerWelcomeVideoPage_loanOfficerEmailLabel = uiPropertiesReader
				.getBorrowerWelcomeVideoPage_loanOfficerEmailLabel();
		logger.info("uiObjParam.borrowerWelcomeVideoPage_loanOfficerEmailLabel : "
				+ uiObjParam.borrowerWelcomeVideoPage_loanOfficerEmailLabel);
		uiObjParam.borrowerWelcomeVideoPage_loanOfficerPhoneLabel = uiPropertiesReader
				.getBorrowerWelcomeVideoPage_loanOfficerPhoneLabel();
		logger.info("uiObjParam.borrowerWelcomeVideoPage_loanOfficerPhoneLabel : "
				+ uiObjParam.borrowerWelcomeVideoPage_loanOfficerPhoneLabel);
		uiObjParam.borrowerWelcomeVideoPage_video = uiPropertiesReader.getBorrowerWelcomeVideoPage_video();
		logger.info("uiObjParam.borrowerWelcomeVideoPage_video : " + uiObjParam.borrowerWelcomeVideoPage_video);
		uiObjParam.borrowerWelcomeVideoPage_welcomeMessage = uiPropertiesReader
				.getBorrowerWelcomeVideoPage_welcomeMessage();
		logger.info("uiObjParam.borrowerWelcomeVideoPage_welcomeMessage : "
				+ uiObjParam.borrowerWelcomeVideoPage_welcomeMessage);
		uiObjParam.borrowerWelcomeVideoPage_getStartedButton = uiPropertiesReader
				.getBorrowerWelcomeVideoPage_getStartedButton();
		logger.info("uiObjParam.borrowerWelcomeVideoPage_getStartedButton : "
				+ uiObjParam.borrowerWelcomeVideoPage_getStartedButton);
		uiObjParam.beginSectionPage_welcomeMessage = uiPropertiesReader.getBeginSectionPage_welcomeMessage();
		logger.info("uiObjParam.beginSectionPage_welcomeMessage : " + uiObjParam.beginSectionPage_welcomeMessage);
		uiObjParam.beginSectionPage_beginSectionButton = uiPropertiesReader.getBeginSectionPage_beginSectionButton();
		logger.info(
				"uiObjParam.beginSectionPage_beginSectionButton : " + uiObjParam.beginSectionPage_beginSectionButton);
		uiObjParam.TellAboutYouPage_firstNameTextbox = uiPropertiesReader.getTellAboutYouPage_firstNameTextbox();
		logger.info("uiObjParam.TellAboutYouPage_firstNameTextbox : " + uiObjParam.TellAboutYouPage_firstNameTextbox);
		uiObjParam.TellAboutYouPage_middleNameTextbox = uiPropertiesReader.getTellAboutYouPage_middleNameTextbox();
		logger.info("uiObjParam.TellAboutYouPage_middleNameTextbox : " + uiObjParam.TellAboutYouPage_middleNameTextbox);
		uiObjParam.TellAboutYouPage_lastNameTextbox = uiPropertiesReader.getTellAboutYouPage_lastNameTextbox();
		logger.info("uiObjParam.TellAboutYouPage_lastNameTextbox : " + uiObjParam.TellAboutYouPage_lastNameTextbox);
		uiObjParam.TellAboutYouPage_suffixTextBox = uiPropertiesReader.getTellAboutYouPage_suffixTextBox();
		logger.info("uiObjParam.TellAboutYouPage_suffixTextBox : " + uiObjParam.TellAboutYouPage_suffixTextBox);
		uiObjParam.TellAboutYouPage_DoBTextBox = uiPropertiesReader.getTellAboutYouPage_DoBTextBox();
		logger.info("uiObjParam.TellAboutYouPage_DoBTextBox : " + uiObjParam.TellAboutYouPage_DoBTextBox);
		uiObjParam.TellAboutYouPage_ssnTextBox = uiPropertiesReader.getTellAboutYouPage_ssnTextBox();
		logger.info("uiObjParam.TellAboutYouPage_ssnTextBox : " + uiObjParam.TellAboutYouPage_ssnTextBox);
		uiObjParam.borrowerCommunicationPage_pageLabel = uiPropertiesReader.getEmploymentPage_pageLabel();
		logger.info(
				"uiObjParam.borrowerCommunicationPage_pageLabel : " + uiObjParam.borrowerCommunicationPage_pageLabel);
		uiObjParam.borrowerCommunicationPage_preferredEmailTextBox = uiPropertiesReader
				.getBorrowerCommunicationPage_preferredEmailTextBox();
		logger.info("uiObjParam.borrowerCommunicationPage_preferredEmailTextBox : "
				+ uiObjParam.borrowerCommunicationPage_preferredEmailTextBox);
		uiObjParam.borrowerCommunicationPage_phoneNumberTextBox = uiPropertiesReader
				.getBorrowerCommunicationPage_phoneNumberTextBox();
		logger.info("uiObjParam.borrowerCommunicationPage_phoneNumberTextBox : "
				+ uiObjParam.borrowerCommunicationPage_phoneNumberTextBox);
		uiObjParam.borrowerCommunicationPage_phoneButton = uiPropertiesReader
				.getBorrowerCommunicationPage_phoneButton();
		logger.info("uiObjParam.borrowerCommunicationPage_phoneButton : "
				+ uiObjParam.borrowerCommunicationPage_phoneButton);
		uiObjParam.borrowerCommunicationPage_emailButton = uiPropertiesReader
				.getBorrowerCommunicationPage_emailButton();
		logger.info("uiObjParam.borrowerCommunicationPage_emailButton : "
				+ uiObjParam.borrowerCommunicationPage_emailButton);
		uiObjParam.borrowerCommunicationPage_textButton = uiPropertiesReader.getBorrowerCommunicationPage_textButton();
		logger.info(
				"uiObjParam.borrowerCommunicationPage_textButton : " + uiObjParam.borrowerCommunicationPage_textButton);
		uiObjParam.borrowerCommunicationPage_allButton = uiPropertiesReader.getBorrowerCommunicationPage_allButton();
		logger.info(
				"uiObjParam.borrowerCommunicationPage_allButton : " + uiObjParam.borrowerCommunicationPage_allButton);
		uiObjParam.borrowerCommunicationPage_nextButton = uiPropertiesReader.getBorrowerCommunicationPage_nextButton();
		logger.info(
				"uiObjParam.borrowerCommunicationPage_nextButton : " + uiObjParam.borrowerCommunicationPage_nextButton);
		uiObjParam.TellAboutYouPage_nextButton = uiPropertiesReader.getTellAboutYouPage_nextButton();
		logger.info("uiObjParam.TellAboutYouPage_nextButton : " + uiObjParam.TellAboutYouPage_nextButton);
		uiObjParam.TellAboutYouPage_NavigationHeaderLabel = uiPropertiesReader
				.getTellAboutYouPage_NavigationHeaderLabel();
		logger.info("uiObjParam.TellAboutYouPage_NavigationHeaderLabel : "
				+ uiObjParam.TellAboutYouPage_NavigationHeaderLabel);
		uiObjParam.TellAboutYouPage_progressBarLabel = uiPropertiesReader.getTellAboutYouPage_progressBarLabel();
		logger.info("uiObjParam.TellAboutYouPage_progressBarLabel : " + uiObjParam.TellAboutYouPage_progressBarLabel);
		uiObjParam.TellAboutYouPage_tellAboutYourselfLabel = uiPropertiesReader
				.getTellAboutYouPage_tellAboutYourselfLabel();
		logger.info("uiObjParam.TellAboutYouPage_tellAboutYourselfLabel : "
				+ uiObjParam.TellAboutYouPage_tellAboutYourselfLabel);
		uiObjParam.purchasePropertyDetailsPage_propertyTypeDropdown = uiPropertiesReader
				.getPurchasePropertyDetailsPage_propertyTypeDropdown();
		logger.info("uiObjParam.purchasePropertyDetailsPage_propertyTypeDropdown : "
				+ uiObjParam.purchasePropertyDetailsPage_propertyTypeDropdown);
		uiObjParam.purchasePropertyDetailsPage_numberOfUnitsDropdown = uiPropertiesReader
				.getPurchasePropertyDetailsPage_numberOfUnitsDropdown();
		logger.info("uiObjParam.purchasePropertyDetailsPage_numberOfUnitsDropdown : "
				+ uiObjParam.purchasePropertyDetailsPage_numberOfUnitsDropdown);
		uiObjParam.purchasePropertyDetailsPage_selectedProperty = uiPropertiesReader
				.getPurchasePropertyDetailsPage_selectedProperty();
		logger.info("uiObjParam.purchasePropertyDetailsPage_selectedProperty : "
				+ uiObjParam.purchasePropertyDetailsPage_selectedProperty);
		uiObjParam.purchasePropertyDetailsPage_notSelectedProperty = uiPropertiesReader
				.getPurchasePropertyDetailsPage_notSelectedProperty();
		logger.info("uiObjParam.purchasePropertyDetailsPage_notSelectedProperty : "
				+ uiObjParam.purchasePropertyDetailsPage_notSelectedProperty);
		uiObjParam.purchasePropertyDetailsPage_inContract = uiPropertiesReader
				.getPurchasePropertyDetailsPage_inContract();
		logger.info("uiObjParam.purchasePropertyDetailsPage_inContract : "
				+ uiObjParam.purchasePropertyDetailsPage_inContract);
		uiObjParam.purchasePropertyDetailsPage_notInContract = uiPropertiesReader
				.getPurchasePropertyDetailsPage_notInContract();
		logger.info("uiObjParam.purchasePropertyDetailsPage_notInContract : "
				+ uiObjParam.purchasePropertyDetailsPage_notInContract);
		uiObjParam.purchasePropertyDetailsPage_propertyUseDropdown = uiPropertiesReader
				.getPurchasePropertyDetailsPage_propertyUseDropdown();
		logger.info("uiObjParam.purchasePropertyDetailsPage_propertyUseDropdown : "
				+ uiObjParam.purchasePropertyDetailsPage_propertyUseDropdown);
		uiObjParam.purchasePropertyDetailsPage_addressTextBox = uiPropertiesReader
				.getPurchasePropertyDetailsPage_addressTextBox();
		logger.info("uiObjParam.purchasePropertyDetailsPage_addressTextBox : "
				+ uiObjParam.purchasePropertyDetailsPage_addressTextBox);
		uiObjParam.purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox = uiPropertiesReader
				.getPurchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox();
		logger.info("uiObjParam.purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox : "
				+ uiObjParam.purchasePropertyDetailsPage_expectedMonthlyRentalIncomeTextBox);
		uiObjParam.purchasePropertyDetailsPage_nextButton = uiPropertiesReader
				.getPurchasePropertyDetailsPage_nextButton();
		logger.info("uiObjParam.purchasePropertyDetailsPage_nextButton : "
				+ uiObjParam.purchasePropertyDetailsPage_nextButton);
		uiObjParam.loanAmountPage_pageLabel = uiPropertiesReader.getLoanAmountPage_pageLabel();
		logger.info("uiObjParam.loanAmountPage_pageLabel : " + uiObjParam.loanAmountPage_pageLabel);
		uiObjParam.loanAmountPage_purchasePriceTextbox = uiPropertiesReader.getLoanAmountPage_purchasePriceTextbox();
		logger.info(
				"uiObjParam.loanAmountPage_purchasePriceTextbox : " + uiObjParam.loanAmountPage_purchasePriceTextbox);
		uiObjParam.loanAmountPage_downPaymentTextbox = uiPropertiesReader.getLoanAmountPage_downPaymentTextbox();
		logger.info("uiObjParam.loanAmountPage_downPaymentTextbox : " + uiObjParam.loanAmountPage_downPaymentTextbox);
		uiObjParam.loanAmountPage_nextButton = uiPropertiesReader.getLoanAmountPage_nextButton();
		logger.info("uiObjParam.loanAmountPage_nextButton : " + uiObjParam.loanAmountPage_nextButton);
		uiObjParam.loanAmountPage_loanAmountTextbox = uiPropertiesReader.getLoanAmountPage_loanAmountTextbox();
		logger.info("uiObjParam.loanAmountPage_loanAmountTextbox : " + uiObjParam.loanAmountPage_loanAmountTextbox);
		uiObjParam.loanAmountPage_loanPercentageTextbox = uiPropertiesReader.getLoanAmountPage_loanPercentageTextbox();
		logger.info(
				"uiObjParam.loanAmountPage_loanPercentageTextbox : " + uiObjParam.loanAmountPage_loanPercentageTextbox);
		uiObjParam.purchasePropertyDetailsPage_pageLabel = uiPropertiesReader
				.getPurchasePropertyDetailsPage_pageLabel();
		logger.info("uiObjParam.purchasePropertyDetailsPage_pageLabel : "
				+ uiObjParam.purchasePropertyDetailsPage_pageLabel);
		uiObjParam.whosOnTheLoanPage_pageLabel = uiPropertiesReader.getWhosOnTheLoanPage_pageLabel();
		logger.info("uiObjParam.whosOnTheLoanPage_pageLabel : " + uiObjParam.whosOnTheLoanPage_pageLabel);
		uiObjParam.whosOnTheLoanPage_marriedButton = uiPropertiesReader.getWhosOnTheLoanPage_marriedButton();
		logger.info("uiObjParam.whosOnTheLoanPage_marriedButton : " + uiObjParam.whosOnTheLoanPage_marriedButton);
		uiObjParam.whosOnTheLoanPage_separatedButton = uiPropertiesReader.getWhosOnTheLoanPage_separatedButton();
		logger.info("uiObjParam.whosOnTheLoanPage_separatedButton : " + uiObjParam.whosOnTheLoanPage_separatedButton);
		uiObjParam.whosOnTheLoanPage_unmarriedButton = uiPropertiesReader.getWhosOnTheLoanPage_unmarriedButton();
		logger.info("uiObjParam.whosOnTheLoanPage_unmarriedButton : " + uiObjParam.whosOnTheLoanPage_unmarriedButton);
		uiObjParam.whosOnTheLoanPage_individualCreditCheckbox = uiPropertiesReader
				.getWhosOnTheLoanPage_individualCreditCheckbox();
		logger.info("uiObjParam.whosOnTheLoanPage_individualCreditCheckbox : "
				+ uiObjParam.whosOnTheLoanPage_individualCreditCheckbox);
		uiObjParam.whosOnTheLoanPage_jointCreditCheckbox = uiPropertiesReader
				.getWhosOnTheLoanPage_jointCreditCheckbox();
		logger.info("uiObjParam.whosOnTheLoanPage_jointCreditCheckbox : "
				+ uiObjParam.whosOnTheLoanPage_jointCreditCheckbox);
		uiObjParam.whosOnTheLoanPage_spouseFirstNameTextBox = uiPropertiesReader
				.getWhosOnTheLoanPage_spouseFirstNameTextBox();
		logger.info("uiObjParam.whosOnTheLoanPage_spouseFirstNameTextBox : "
				+ uiObjParam.whosOnTheLoanPage_spouseFirstNameTextBox);
		uiObjParam.whosOnTheLoanPage_spouseLastNameTextBox = uiPropertiesReader
				.getWhosOnTheLoanPage_spouseLastNameTextBox();
		logger.info("uiObjParam.whosOnTheLoanPage_spouseLastNameTextBox : "
				+ uiObjParam.whosOnTheLoanPage_spouseLastNameTextBox);
		uiObjParam.whosOnTheLoanPage_nextButton = uiPropertiesReader.getWhosOnTheLoanPage_nextButton();
		logger.info("uiObjParam.whosOnTheLoanPage_nextButton : " + uiObjParam.whosOnTheLoanPage_nextButton);
		uiObjParam.addCoApplicantsPage_pageLabel = uiPropertiesReader.getAddCoApplicantsPage_pageLabel();
		logger.info("uiObjParam.addCoApplicantsPage_pageLabel : " + uiObjParam.addCoApplicantsPage_pageLabel);
		uiObjParam.addCoApplicantsPage_addFirstCoborrower = uiPropertiesReader
				.getAddCoApplicantsPage_addFirstCoborrower();
		logger.info("uiObjParam.addCoApplicantsPage_addFirstCoborrower : "
				+ uiObjParam.addCoApplicantsPage_addFirstCoborrower);
		uiObjParam.addCoApplicantsPage_cob1FirstNameTextbox = uiPropertiesReader
				.getAddCoApplicantsPage_cob1FirstNameTextbox();
		logger.info("uiObjParam.addCoApplicantsPage_cob1FirstNameTextbox : "
				+ uiObjParam.addCoApplicantsPage_cob1FirstNameTextbox);
		uiObjParam.addCoApplicantsPage_cob1LastNameTextbox = uiPropertiesReader
				.getAddCoApplicantsPage_cob1LastNameTextbox();
		logger.info("uiObjParam.addCoApplicantsPage_cob1LastNameTextbox : "
				+ uiObjParam.addCoApplicantsPage_cob1LastNameTextbox);
		uiObjParam.addCoApplicantsPage_cob1EmailTextbox = uiPropertiesReader.getAddCoApplicantsPage_cob1EmailTextbox();
		logger.info(
				"uiObjParam.addCoApplicantsPage_cob1EmailTextbox : " + uiObjParam.addCoApplicantsPage_cob1EmailTextbox);
		uiObjParam.addCoApplicantsPage_cob1RelationshipDropdown = uiPropertiesReader
				.getAddCoApplicantsPage_cob1RelationshipDropdown();
		logger.info("uiObjParam.addCoApplicantsPage_cob1RelationshipDropdown : "
				+ uiObjParam.addCoApplicantsPage_cob1RelationshipDropdown);
		uiObjParam.spouseInformationPage_firstNameTextbox = uiPropertiesReader
				.getSpouseInformationPage_firstNameTextbox();
		logger.info("uiObjParam.spouseInformationPage_firstNameTextbox : "
				+ uiObjParam.spouseInformationPage_firstNameTextbox);
		uiObjParam.spouseInformationPage_middleNameTextbox = uiPropertiesReader
				.getSpouseInformationPage_middleNameTextbox();
		logger.info("uiObjParam.spouseInformationPage_middleNameTextbox : "
				+ uiObjParam.spouseInformationPage_middleNameTextbox);
		uiObjParam.spouseInformationPage_lastNameTextbox = uiPropertiesReader
				.getSpouseInformationPage_lastNameTextbox();
		logger.info("uiObjParam.spouseInformationPage_lastNameTextbox : "
				+ uiObjParam.spouseInformationPage_lastNameTextbox);
		uiObjParam.spouseInformationPage_suffixNameTextbox = uiPropertiesReader
				.getSpouseInformationPage_suffixNameTextbox();
		logger.info("uiObjParam.spouseInformationPage_suffixNameTextbox : "
				+ uiObjParam.spouseInformationPage_suffixNameTextbox);
		uiObjParam.spouseInformationPage_dObTextBox = uiPropertiesReader.getSpouseInformationPage_dObTextBox();
		logger.info("uiObjParam.spouseInformationPage_dObTextBox : " + uiObjParam.spouseInformationPage_dObTextBox);
		uiObjParam.spouseInformationPage_ssnTextBox = uiPropertiesReader.getSpouseInformationPage_ssnTextBox();
		logger.info("uiObjParam.spouseInformationPage_ssnTextBox : " + uiObjParam.spouseInformationPage_ssnTextBox);
		uiObjParam.spouseInformationPage_nextButton = uiPropertiesReader.getSpouseInformationPage_nextButton();
		logger.info("uiObjParam.spouseInformationPage_nextButton : " + uiObjParam.spouseInformationPage_nextButton);
		uiObjParam.spouseCommunicationPage_pageLabel = uiPropertiesReader.getSpouseCommunicationPage_pageLabel();
		logger.info("uiObjParam.spouseCommunicationPage_pageLabel : " + uiObjParam.spouseCommunicationPage_pageLabel);
		uiObjParam.spouseCommunicationPage_preferredEmailTextbox = uiPropertiesReader
				.getSpouseCommunicationPage_preferredEmailTextbox();
		logger.info("uiObjParam.spouseCommunicationPage_preferredEmailTextbox : "
				+ uiObjParam.spouseCommunicationPage_preferredEmailTextbox);
		uiObjParam.spouseCommunicationPage_phoneTextbox = uiPropertiesReader.getSpouseCommunicationPage_phoneTextbox();
		logger.info(
				"uiObjParam.spouseCommunicationPage_phoneTextbox : " + uiObjParam.spouseCommunicationPage_phoneTextbox);
		uiObjParam.spouseCommunicationPage_phoneButton = uiPropertiesReader.getSpouseCommunicationPage_phoneButton();
		logger.info(
				"uiObjParam.spouseCommunicationPage_phoneButton : " + uiObjParam.spouseCommunicationPage_phoneButton);
		uiObjParam.spouseCommunicationPage_emailButton = uiPropertiesReader.getSpouseCommunicationPage_emailButton();
		logger.info(
				"uiObjParam.spouseCommunicationPage_emailButton : " + uiObjParam.spouseCommunicationPage_emailButton);
		uiObjParam.spouseCommunicationPage_textButton = uiPropertiesReader.getSpouseCommunicationPage_textButton();
		logger.info("uiObjParam.spouseCommunicationPage_textButton : " + uiObjParam.spouseCommunicationPage_textButton);
		uiObjParam.spouseCommunicationPage_allButton = uiPropertiesReader.getSpouseCommunicationPage_allButton();
		logger.info("uiObjParam.spouseCommunicationPage_allButton : " + uiObjParam.spouseCommunicationPage_allButton);
		uiObjParam.spouseCommunicationPage_nextButton = uiPropertiesReader.getSpouseCommunicationPage_nextButton();
		logger.info("uiObjParam.spouseCommunicationPage_nextButton : " + uiObjParam.spouseCommunicationPage_nextButton);
		uiObjParam.whosOnTheLoanPage_nextButton = uiPropertiesReader.getWhosOnTheLoanPage_nextButton();
		logger.info("uiObjParam.whosOnTheLoanPage_nextButton : " + uiObjParam.whosOnTheLoanPage_nextButton);
		uiObjParam.nonSpouseInformationPage_firstNameTextbox = uiPropertiesReader
				.getNonSpouseInformationPage_firstNameTextbox();
		logger.info("uiObjParam.nonSpouseInformationPage_firstNameTextbox : "
				+ uiObjParam.nonSpouseInformationPage_firstNameTextbox);
		uiObjParam.nonSpouseInformationPage_middleNameTextbox = uiPropertiesReader
				.getNonSpouseInformationPage_middleNameTextbox();
		logger.info("uiObjParam.nonSpouseInformationPage_middleNameTextbox : "
				+ uiObjParam.nonSpouseInformationPage_middleNameTextbox);
		uiObjParam.nonSpouseInformationPage_lastNameTextbox = uiPropertiesReader
				.getNonSpouseInformationPage_lastNameTextbox();
		logger.info("uiObjParam.nonSpouseInformationPage_lastNameTextbox : "
				+ uiObjParam.nonSpouseInformationPage_lastNameTextbox);
		uiObjParam.nonSpouseInformationPage_suffixTextbox = uiPropertiesReader
				.getNonSpouseInformationPage_suffixTextbox();
		logger.info("uiObjParam.nonSpouseInformationPage_suffixTextbox : "
				+ uiObjParam.nonSpouseInformationPage_suffixTextbox);
		uiObjParam.nonSpouseInformationPage_preferredEmailTextbox = uiPropertiesReader
				.getNonSpouseInformationPage_preferredEmailTextbox();
		logger.info("uiObjParam.nonSpouseInformationPage_preferredEmailTextbox : "
				+ uiObjParam.nonSpouseInformationPage_preferredEmailTextbox);
		uiObjParam.nonSpouseInformationPage_phoneTextbox = uiPropertiesReader
				.getNonSpouseInformationPage_phoneTextbox();
		logger.info("uiObjParam.nonSpouseInformationPage_phoneTextbox : "
				+ uiObjParam.nonSpouseInformationPage_phoneTextbox);
		uiObjParam.nonSpouseInformationPage_nextButton = uiPropertiesReader.getNonSpouseInformationPage_nextButton();
		logger.info(
				"uiObjParam.nonSpouseInformationPage_nextButton : " + uiObjParam.nonSpouseInformationPage_nextButton);
		uiObjParam.spouseInformationPage_pageLabel = uiPropertiesReader.getSpouseInformationPage_pageLabel();
		logger.info("uiObjParam.spouseInformationPage_pageLabel : " + uiObjParam.spouseInformationPage_pageLabel);
		uiObjParam.nonSpouseInformationPage_pageLabel = uiPropertiesReader.getNonSpouseInformationPage_pageLabel();
		logger.info("uiObjParam.nonSpouseInformationPage_pageLabel : " + uiObjParam.nonSpouseInformationPage_pageLabel);
		uiObjParam.applicantInformationPage_coborrowerNameLabel = uiPropertiesReader
				.getApplicantInformationPage_coborrowerNameLabel();
		logger.info("uiObjParam.applicantInformationPage_coborrowerNameLabel : "
				+ uiObjParam.applicantInformationPage_coborrowerNameLabel);
		uiObjParam.applicantInformationPage_coborrowerLabel = uiPropertiesReader
				.getApplicantInformationPage_coborrowerLabel();
		logger.info("uiObjParam.applicantInformationPage_coborrowerLabel : "
				+ uiObjParam.applicantInformationPage_coborrowerLabel);
		uiObjParam.applicantInformationPage_progressBarLabel = uiPropertiesReader
				.getApplicantInformationPage_progressBarLabel();
		logger.info("uiObjParam.applicantInformationPage_progressBarLabel : "
				+ uiObjParam.applicantInformationPage_progressBarLabel);
		uiObjParam.applicantInformationPage_nextButton = uiPropertiesReader.getApplicantInformationPage_nextButton();
		logger.info(
				"uiObjParam.applicantInformationPage_nextButton : " + uiObjParam.applicantInformationPage_nextButton);
		uiObjParam.applicantInformationPage_pageLabel = uiPropertiesReader.getApplicantInformationPage_pageLabel();
		logger.info("uiObjParam.applicantInformationPage_pageLabel : " + uiObjParam.applicantInformationPage_pageLabel);
		uiObjParam.loanEligibilityPage_eligibleForLoanButton = uiPropertiesReader
				.getLoanEligibilityPage_eligibleForLoanButton();
		logger.info("uiObjParam.loanEligibilityPage_eligibleForLoanButton : "
				+ uiObjParam.loanEligibilityPage_eligibleForLoanButton);
		uiObjParam.loanEligibilityPage_notEligibleForLoanButton = uiPropertiesReader
				.getLoanEligibilityPage_notEligibleForLoanButton();
		logger.info("uiObjParam.loanEligibilityPage_notEligibleForLoanButton : "
				+ uiObjParam.loanEligibilityPage_notEligibleForLoanButton);
		uiObjParam.loanEligibilityPage_haveCurrentLoanButton = uiPropertiesReader
				.getLoanEligibilityPage_haveCurrentLoanButton();
		logger.info("uiObjParam.loanEligibilityPage_haveCurrentLoanButton : "
				+ uiObjParam.loanEligibilityPage_haveCurrentLoanButton);
		uiObjParam.loanEligibilityPage_noCurrentLoanButton = uiPropertiesReader
				.getLoanEligibilityPage_noCurrentLoanButton();
		logger.info("uiObjParam.loanEligibilityPage_noCurrentLoanButton : "
				+ uiObjParam.loanEligibilityPage_noCurrentLoanButton);
		uiObjParam.loanEligibilityPage_dutyWithExpirationDateCheckbox = uiPropertiesReader
				.getLoanEligibilityPage_dutyWithExpirationDateCheckbox();
		logger.info("uiObjParam.loanEligibilityPage_dutyWithExpirationDateCheckbox : "
				+ uiObjParam.loanEligibilityPage_dutyWithExpirationDateCheckbox);
		uiObjParam.loanEligibilityPage_childCareExpenseButton = uiPropertiesReader
				.getLoanEligibilityPage_childCareExpenseButton();
		logger.info("uiObjParam.loanEligibilityPage_childCareExpenseButton : "
				+ uiObjParam.loanEligibilityPage_childCareExpenseButton);
		uiObjParam.loanEligibilityPage_noChildCareExpenseButton = uiPropertiesReader
				.getLoanEligibilityPage_noChildCareExpenseButton();
		logger.info("uiObjParam.loanEligibilityPage_noChildCareExpenseButton : "
				+ uiObjParam.loanEligibilityPage_noChildCareExpenseButton);
		uiObjParam.loanEligibilityPage_childCareExpenseTextbox = uiPropertiesReader
				.getLoanEligibilityPage_childCareExpenseTextbox();
		logger.info("uiObjParam.loanEligibilityPage_childCareExpenseTextbox : "
				+ uiObjParam.loanEligibilityPage_childCareExpenseTextbox);
		uiObjParam.loanEligibilityPage_CurrentlyRetiredCheckbox = uiPropertiesReader
				.getLoanEligibilityPage_CurrentlyRetiredCheckbox();
		logger.info("uiObjParam.loanEligibilityPage_CurrentlyRetiredCheckbox : "
				+ uiObjParam.loanEligibilityPage_CurrentlyRetiredCheckbox);
		uiObjParam.loanEligibilityPage_NonActivatedCheckbox = uiPropertiesReader
				.getLoanEligibilityPage_NonActivatedCheckbox();
		logger.info("uiObjParam.loanEligibilityPage_NonActivatedCheckbox : "
				+ uiObjParam.loanEligibilityPage_NonActivatedCheckbox);
		uiObjParam.loanEligibilityPage_SurvivingSpouseCheckbox = uiPropertiesReader
				.getLoanEligibilityPage_SurvivingSpouseCheckbox();
		logger.info("uiObjParam.loanEligibilityPage_SurvivingSpouseCheckbox : "
				+ uiObjParam.loanEligibilityPage_SurvivingSpouseCheckbox);
		uiObjParam.loanEligibilityPage_projectedExpiryDateTextbox = uiPropertiesReader
				.getLoanEligibilityPage_projectedExpiryDateTextbox();
		logger.info("uiObjParam.loanEligibilityPage_projectedExpiryDateTextbox : "
				+ uiObjParam.loanEligibilityPage_projectedExpiryDateTextbox);
		uiObjParam.loanEligibilityPage_nextButton = uiPropertiesReader.getLoanEligibilityPage_nextButton();
		logger.info("uiObjParam.loanEligibilityPage_nextButton : " + uiObjParam.loanEligibilityPage_nextButton);
		uiObjParam.loanEligibilityPage_pageLabel = uiPropertiesReader.getLoanEligibilityPage_pageLabel();
		logger.info("uiObjParam.loanEligibilityPage_pageLabel : " + uiObjParam.loanEligibilityPage_pageLabel);
		uiObjParam.realEstateAgentPage_pageLabel = uiPropertiesReader.getRealEstateAgentPage_pageLabel();
		logger.info("uiObjParam.realEstateAgentPage_pageLabel : " + uiObjParam.realEstateAgentPage_pageLabel);
		uiObjParam.realEstateAgentPage_workingWithAgentButton = uiPropertiesReader
				.getRealEstateAgentPage_workingWithAgentButton();
		logger.info("uiObjParam.realEstateAgentPage_workingWithAgentButton : "
				+ uiObjParam.realEstateAgentPage_workingWithAgentButton);
		uiObjParam.realEstateAgentPage_notWorkingWithAgentButton = uiPropertiesReader
				.getRealEstateAgentPage_notWorkingWithAgentButton();
		logger.info("uiObjParam.realEstateAgentPage_notWorkingWithAgentButton : "
				+ uiObjParam.realEstateAgentPage_notWorkingWithAgentButton);
		uiObjParam.realEstateAgentPage_referAgentButton = uiPropertiesReader.getRealEstateAgentPage_referAgentButton();
		logger.info(
				"uiObjParam.realEstateAgentPage_referAgentButton : " + uiObjParam.realEstateAgentPage_referAgentButton);
		uiObjParam.realEstateAgentPage_notReferAgentButton = uiPropertiesReader
				.getRealEstateAgentPage_notReferAgentButton();
		logger.info("uiObjParam.realEstateAgentPage_notReferAgentButton : "
				+ uiObjParam.realEstateAgentPage_notReferAgentButton);
		uiObjParam.realEstateAgentPage_nextButton = uiPropertiesReader.getRealEstateAgentPage_nextButton();
		logger.info("uiObjParam.realEstateAgentPage_nextButton : " + uiObjParam.realEstateAgentPage_nextButton);
		uiObjParam.currentResidentialDetailsPage_pageLabel = uiPropertiesReader
				.getCurrentResidentialDetailsPage_pageLabel();
		logger.info("uiObjParam.currentResidentialDetailsPage_pageLabel : "
				+ uiObjParam.currentResidentialDetailsPage_pageLabel);
		uiObjParam.currentResidentialDetailsPage_sameResidenceAsSpouseButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_sameResidenceAsSpouseButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_sameResidenceAsSpouseButton : "
				+ uiObjParam.currentResidentialDetailsPage_sameResidenceAsSpouseButton);
		uiObjParam.currentResidentialDetailsPage_notSameResidenceAsSpouseButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_notSameResidenceAsSpouseButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_notSameResidenceAsSpouseButton : "
				+ uiObjParam.currentResidentialDetailsPage_notSameResidenceAsSpouseButton);
		uiObjParam.currentResidentialDetailsPage_ownButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_ownButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_ownButton : "
				+ uiObjParam.currentResidentialDetailsPage_ownButton);
		uiObjParam.currentResidentialDetailsPage_rentButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_rentButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_rentButton : "
				+ uiObjParam.currentResidentialDetailsPage_rentButton);
		uiObjParam.currentResidentialDetailsPage_otherButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_otherButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_otherButton : "
				+ uiObjParam.currentResidentialDetailsPage_otherButton);
		uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox = uiPropertiesReader
				.getCurrentResidentialDetailsPage_currentResidenceTextbox();
		logger.info("uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox : "
				+ uiObjParam.currentResidentialDetailsPage_currentResidenceTextbox);
		uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox = uiPropertiesReader
				.getCurrentResidentialDetailsPage_stayingHereSinceTextbox();
		logger.info("uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox : "
				+ uiObjParam.currentResidentialDetailsPage_stayingHereSinceTextbox);
		uiObjParam.currentResidentialDetailsPage_bothAddressSameCheckbox = uiPropertiesReader
				.getCurrentResidentialDetailsPage_bothAddressSameCheckbox();
		logger.info("uiObjParagetSummarym.currentResidentialDetailsPage_bothAddressSameCheckbox : "
				+ uiObjParam.currentResidentialDetailsPage_bothAddressSameCheckbox);
		uiObjParam.currentResidentialDetailsPage_planningToSellButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_planningToSellButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_planningToSellButton : "
				+ uiObjParam.currentResidentialDetailsPage_planningToSellButton);
		uiObjParam.currentResidentialDetailsPage_notPlanningToSellButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_notPlanningToSellButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_notPlanningToSellButton : "
				+ uiObjParam.currentResidentialDetailsPage_notPlanningToSellButton);
		uiObjParam.currentResidentialDetailsPage_nextButton = uiPropertiesReader
				.getCurrentResidentialDetailsPage_nextButton();
		logger.info("uiObjParam.currentResidentialDetailsPage_nextButton : "
				+ uiObjParam.currentResidentialDetailsPage_nextButton);
		uiObjParam.realEstatePage_ownAdditionalPropertiesButton = uiPropertiesReader
				.getRealEstatePage_ownAdditionalPropertiesButton();
		logger.info("uiObjParam.realEstatePage_ownAdditionalPropertiesButton : "
				+ uiObjParam.realEstatePage_ownAdditionalPropertiesButton);
		uiObjParam.realEstatePage_dontOwnAdditionalPropertiesButton = uiPropertiesReader
				.getRealEstatePage_dontOwnAdditionalPropertiesButton();
		logger.info("uiObjParam.realEstatePage_dontOwnAdditionalPropertiesButton : "
				+ uiObjParam.realEstatePage_dontOwnAdditionalPropertiesButton);
		uiObjParam.realEstatePage_propertyAddressTextbox = uiPropertiesReader
				.getRealEstatePage_propertyAddressTextbox();
		logger.info("uiObjParam.realEstatePage_propertyAddressTextbox : "
				+ uiObjParam.realEstatePage_propertyAddressTextbox);
		uiObjParam.realEstatePage_propertyValueTextbox = uiPropertiesReader.getRealEstatePage_propertyValueTextbox();
		logger.info(
				"uiObjParam.realEstatePage_propertyValueTextbox : " + uiObjParam.realEstatePage_propertyValueTextbox);
		uiObjParam.realEstatePage_rentalIncomeTextbox = uiPropertiesReader.getRealEstatePage_rentalIncomeTextbox();
		logger.info("uiObjParam.realEstatePage_rentalIncomeTextbox : " + uiObjParam.realEstatePage_rentalIncomeTextbox);
		uiObjParam.realEstatePage_additioanlIncomeTextbox = uiPropertiesReader
				.getRealEstatePage_additioanlIncomeTextbox();
		logger.info("uiObjParam.realEstatePage_additioanlIncomeTextbox : "
				+ uiObjParam.realEstatePage_additioanlIncomeTextbox);
		uiObjParam.realEstatePage_netRentalIncomeLabel = uiPropertiesReader.getRealEstatePage_netRentalIncomeLabel();
		logger.info(
				"uiObjParam.realEstatePage_netRentalIncomeLabel : " + uiObjParam.realEstatePage_netRentalIncomeLabel);
		uiObjParam.realEstatePage_propertyTypeDropdown = uiPropertiesReader.getRealEstatePage_propertyTypeDropdown();
		logger.info(
				"uiObjParam.realEstatePage_propertyTypeDropdown : " + uiObjParam.realEstatePage_propertyTypeDropdown);
		uiObjParam.realEstatePage_numberOfUnitsDropdown = uiPropertiesReader.getRealEstatePage_numberOfUnitsDropdown();
		logger.info(
				"uiObjParam.realEstatePage_numberOfUnitsDropdown : " + uiObjParam.realEstatePage_numberOfUnitsDropdown);
		uiObjParam.realEstatePage_propertyStatusDropdown = uiPropertiesReader
				.getRealEstatePage_propertyStatusDropdown();
		logger.info("uiObjParam.realEstatePage_propertyStatusDropdown : "
				+ uiObjParam.realEstatePage_propertyStatusDropdown);
		uiObjParam.realEstatePage_propertyUseDropdown = uiPropertiesReader.getRealEstatePage_propertyUseDropdown();
		logger.info("uiObjParam.realEstatePage_propertyUseDropdown : " + uiObjParam.realEstatePage_propertyUseDropdown);
		uiObjParam.realEstatePage_submitButton = uiPropertiesReader.getRealEstatePage_submitButton();
		logger.info("uiObjParam.realEstatePage_submitButton : " + uiObjParam.realEstatePage_submitButton);
		uiObjParam.realEstatePage_pageLabel = uiPropertiesReader.getRealEstatePage_pageLabel();
		logger.info("uiObjParam.realEstatePage_pageLabel : " + uiObjParam.realEstatePage_pageLabel);
		uiObjParam.profileCompletedPage_beginSectionButton = uiPropertiesReader
				.getProfileCompletedPage_beginSectionButton();
		logger.info("uiObjParam.profileCompletedPage_beginSectionButton : "
				+ uiObjParam.profileCompletedPage_beginSectionButton);
		uiObjParam.profileCompletedPage_profileCompletionMessage = uiPropertiesReader
				.getProfileCompletedPage_profileCompletionMessage();
		logger.info("uiObjParam.profileCompletedPage_profileCompletionMessage : "
				+ uiObjParam.profileCompletedPage_profileCompletionMessage);
		uiObjParam.assetsPage_pageLabel = uiPropertiesReader.getAssetsPage_pageLabel();
		logger.info("uiObjParam.assetsPage_pageLabel : " + uiObjParam.assetsPage_pageLabel);
		uiObjParam.assetsPage_verifyElectronicallyButton = uiPropertiesReader
				.getAssetsPage_verifyElectronicallyButton();
		logger.info("uiObjParam.assetsPage_verifyElectronicallyButton : "
				+ uiObjParam.assetsPage_verifyElectronicallyButton);
		uiObjParam.assetsPage_enterManuallyButton = uiPropertiesReader.getAssetsPage_enterManuallyButton();
		logger.info("uiObjParam.assetsPage_enterManuallyButton : " + uiObjParam.assetsPage_enterManuallyButton);
		uiObjParam.savingAndInvestmentPage_institutionNameTextBox = uiPropertiesReader
				.getSavingAndInvestmentPage_institutionNameTextBox();
		logger.info("uiObjParam.savingAndInvestmentPage_institutionNameTextBox : "
				+ uiObjParam.savingAndInvestmentPage_institutionNameTextBox);
		uiObjParam.savingAndInvestmentPage_accountTypeTextBox = uiPropertiesReader
				.getSavingAndInvestmentPage_accountTypeTextBox();
		logger.info("uiObjParam.savingAndInvestmentPage_accountTypeTextBox : "
				+ uiObjParam.savingAndInvestmentPage_accountTypeTextBox);
		uiObjParam.savingAndInvestmentPage_currentBalanceTextBox = uiPropertiesReader
				.getSavingAndInvestmentPage_currentBalanceTextBox();
		logger.info("uiObjParam.savingAndInvestmentPage_currentBalanceTextBox : "
				+ uiObjParam.savingAndInvestmentPage_currentBalanceTextBox);
		uiObjParam.savingAndInvestmentPage_accountNumberTextBox = uiPropertiesReader
				.getSavingAndInvestmentPage_accountNumberTextBox();
		logger.info("uiObjParam.savingAndInvestmentPage_accountNumberTextBox : "
				+ uiObjParam.savingAndInvestmentPage_accountNumberTextBox);
		uiObjParam.savingAndInvestmentPage_accountHolderNameTextBox = uiPropertiesReader
				.getSavingAndInvestmentPage_accountHolderNameTextBox();
		logger.info("uiObjParam.savingAndInvestmentPage_accountHolderNameTextBox : "
				+ uiObjParam.savingAndInvestmentPage_accountHolderNameTextBox);
		uiObjParam.savingAndInvestmentPage_enterButton = uiPropertiesReader.getSavingAndInvestmentPage_enterButton();
		logger.info(
				"uiObjParam.savingAndInvestmentPage_enterButton : " + uiObjParam.savingAndInvestmentPage_enterButton);
		uiObjParam.savingAndInvestmentPage_pageLabel = uiPropertiesReader.getSavingAndInvestmentPage_pageLabel();
		logger.info("uiObjParam.savingAndInvestmentPage_pageLabel : " + uiObjParam.savingAndInvestmentPage_pageLabel);
		uiObjParam.assetSumamryPage_addAccountButton = uiPropertiesReader.getAssetSumamryPage_addAccountButton();
		logger.info("uiObjParam.assetSumamryPage_addAccountButton : " + uiObjParam.assetSumamryPage_addAccountButton);
		uiObjParam.assetSumamryPage_iAmDoneButton = uiPropertiesReader.getAssetSumamryPage_iAmDoneButton();
		logger.info("uiObjParam.assetSumamryPage_iAmDoneButton : " + uiObjParam.assetSumamryPage_iAmDoneButton);
		uiObjParam.plaidCredential_userIdTextBox = uiPropertiesReader.getPlaidCredential_userIdTextBox();
		logger.info("uiObjParam.plaidCredential_userIdTextBox : " + uiObjParam.plaidCredential_userIdTextBox);
		uiObjParam.plaidCredential_passwordTextBox = uiPropertiesReader.getPlaidCredential_passwordTextBox();
		logger.info("uiObjParam.plaidCredential_passwordTextBox : " + uiObjParam.plaidCredential_passwordTextBox);
		uiObjParam.plaidCredential_verifyElectronicallyButton = uiPropertiesReader
				.getPlaidCredential_verifyElectronicallyButton();
		logger.info("uiObjParam.plaidCredential_verifyElectronicallyButton : "
				+ uiObjParam.plaidCredential_verifyElectronicallyButton);
		uiObjParam.borrowerLoginPage_emailTextbox = uiPropertiesReader.getBorrowerLoginPage_emailTextbox();
		logger.info("uiObjParam.borrowerLoginPage_emailTextbox : " + uiObjParam.borrowerLoginPage_emailTextbox);
		uiObjParam.borrowerLoginPage_passwordTextbox = uiPropertiesReader.getBorrowerLoginPage_passwordTextbox();
		logger.info("uiObjParam.borrowerLoginPage_passwordTextbox : " + uiObjParam.borrowerLoginPage_passwordTextbox);
		uiObjParam.borrowerLoginPage_signInButton = uiPropertiesReader.getBorrowerLoginPage_signInButton();
		logger.info("uiObjParam.borrowerLoginPage_signInButton : " + uiObjParam.borrowerLoginPage_signInButton);
		uiObjParam.borrowerLoginPage_forgetPasswordLink = uiPropertiesReader.getBorrowerLoginPage_forgetPasswordLink();
		logger.info(
				"uiObjParam.borrowerLoginPage_forgetPasswordLink : " + uiObjParam.borrowerLoginPage_forgetPasswordLink);
		uiObjParam.borrowerLoginPage_termsAndConditionLink = uiPropertiesReader
				.getBorrowerLoginPage_termsAndConditionLink();
		logger.info("uiObjParam.borrowerLoginPage_termsAndConditionLink : "
				+ uiObjParam.borrowerLoginPage_termsAndConditionLink);
		uiObjParam.spouseAssetsPage_pageLabel = uiPropertiesReader.getSpouseAssetsPage_pageLabel();
		logger.info("uiObjParam.spouseAssetsPage_pageLabel : " + uiObjParam.spouseAssetsPage_pageLabel);
		uiObjParam.spouseAssetsPage_enterManuallyButton = uiPropertiesReader.getSpouseAssetsPage_enterManuallyButton();
		logger.info(
				"uiObjParam.spouseAssetsPage_enterManuallyButton : " + uiObjParam.spouseAssetsPage_enterManuallyButton);
		uiObjParam.spouseSavingAndInvestmentPage_pageLabel = uiPropertiesReader
				.getSpouseSavingAndInvestmentPage_pageLabel();
		logger.info("uiObjParam.spouseSavingAndInvestmentPage_pageLabel : "
				+ uiObjParam.spouseSavingAndInvestmentPage_pageLabel);
		uiObjParam.spouseSavingAndInvestmentPage_institutionNameTextBox = uiPropertiesReader
				.getSpouseSavingAndInvestmentPage_institutionNameTextBox();
		logger.info("uiObjParam.spouseSavingAndInvestmentPage_institutionNameTextBox : "
				+ uiObjParam.spouseSavingAndInvestmentPage_institutionNameTextBox);
		uiObjParam.spouseSavingAndInvestmentPage_accountTypeTextBox = uiPropertiesReader
				.getSpouseSavingAndInvestmentPage_accountTypeTextBox();
		logger.info("uiObjParam.spouseSavingAndInvestmentPage_accountTypeTextBox : "
				+ uiObjParam.spouseSavingAndInvestmentPage_accountTypeTextBox);
		uiObjParam.spouseSavingAndInvestmentPage_currentBalanceTextBox = uiPropertiesReader
				.getSpouseSavingAndInvestmentPage_currentBalanceTextBox();
		logger.info("uiObjParam.spouseSavingAndInvestmentPage_currentBalanceTextBox : "
				+ uiObjParam.spouseSavingAndInvestmentPage_currentBalanceTextBox);
		uiObjParam.spouseSavingAndInvestmentPage_accountNumberTextBox = uiPropertiesReader
				.getSpouseSavingAndInvestmentPage_accountNumberTextBox();
		logger.info("uiObjParam.spouseSavingAndInvestmentPage_accountNumberTextBox : "
				+ uiObjParam.spouseSavingAndInvestmentPage_accountNumberTextBox);
		uiObjParam.spouseSavingAndInvestmentPage_accountHolderNameTextBox = uiPropertiesReader
				.getSpouseSavingAndInvestmentPage_accountHolderNameTextBox();
		logger.info("uiObjParam.spouseSavingAndInvestmentPage_accountHolderNameTextBox : "
				+ uiObjParam.spouseSavingAndInvestmentPage_accountHolderNameTextBox);
		uiObjParam.spouseSavingAndInvestmentPage_enterButton = uiPropertiesReader
				.getSpouseSavingAndInvestmentPage_enterButton();
		logger.info("uiObjParam.spouseSavingAndInvestmentPage_enterButton : "
				+ uiObjParam.spouseSavingAndInvestmentPage_enterButton);
		uiObjParam.spouseAssetSummaryPage_pageLabel = uiPropertiesReader.getSpouseAssetSummaryPage_pageLabel();
		logger.info("uiObjParam.spouseAssetSummaryPage_pageLabel : " + uiObjParam.spouseAssetSummaryPage_pageLabel);
		uiObjParam.spouseAssetSummaryPage_iAmDoneButton = uiPropertiesReader.getSpouseAssetSummaryPage_iAmDoneButton();
		logger.info(
				"uiObjParam.spouseAssetSummaryPage_iAmDoneButton : " + uiObjParam.spouseAssetSummaryPage_iAmDoneButton);
		uiObjParam.spouseAssetSummaryPage_addAccountButton = uiPropertiesReader
				.getSpouseAssetSummaryPage_addAccountButton();
		logger.info("uiObjParam.spouseAssetSummaryPage_addAccountButton : "
				+ uiObjParam.spouseAssetSummaryPage_addAccountButton);
		uiObjParam.spousePlaidCredential_userIdTextBox = uiPropertiesReader.getSpousePlaidCredential_userIdTextBox();
		logger.info(
				"uiObjParam.spousePlaidCredential_userIdTextBox : " + uiObjParam.spousePlaidCredential_userIdTextBox);
		uiObjParam.spousePlaidCredential_passwordTextBox = uiPropertiesReader
				.getSpousePlaidCredential_passwordTextBox();
		logger.info("uiObjParam.spousePlaidCredential_passwordTextBox : "
				+ uiObjParam.spousePlaidCredential_passwordTextBox);
		uiObjParam.spousePlaidCredential_verifyElectronicallyButton = uiPropertiesReader
				.getSpousePlaidCredential_verifyElectronicallyButton();
		logger.info("uiObjParam.spousePlaidCredential_verifyElectronicallyButton : "
				+ uiObjParam.spousePlaidCredential_verifyElectronicallyButton);
		uiObjParam.assetCompletePage_beginSectionButton = uiPropertiesReader.getAssetCompletePage_beginSectionButton();
		logger.info(
				"uiObjParam.assetCompletePage_beginSectionButton : " + uiObjParam.assetCompletePage_beginSectionButton);
		uiObjParam.incomeSearchPage_pageLabel = uiPropertiesReader.getIncomeSearchPage_pageLabel();
		logger.info("uiObjParam.incomeSearchPage_pageLabel : " + uiObjParam.incomeSearchPage_pageLabel);
		uiObjParam.incomeSearchPage_employmentButton = uiPropertiesReader.getIncomeSearchPage_employmentButton();
		logger.info("uiObjParam.incomeSearchPage_employmentButton : " + uiObjParam.incomeSearchPage_employmentButton);
		uiObjParam.incomeSearchPage_alimonyChildSupportButton = uiPropertiesReader
				.getIncomeSearchPage_alimonyChildSupportButton();
		logger.info("uiObjParam.incomeSearchPage_alimonyChildSupportButton : "
				+ uiObjParam.incomeSearchPage_alimonyChildSupportButton);
		uiObjParam.incomeSearchPage_businessSelfEmploymentButton = uiPropertiesReader
				.getIncomeSearchPage_businessSelfEmploymentButton();
		logger.info("uiObjParam.incomeSearchPage_businessSelfEmploymentButton : "
				+ uiObjParam.incomeSearchPage_businessSelfEmploymentButton);
		uiObjParam.incomeSearchPage_millitaryButton = uiPropertiesReader.getIncomeSearchPage_millitaryButton();
		logger.info("uiObjParam.incomeSearchPage_millitaryButton : " + uiObjParam.incomeSearchPage_millitaryButton);
		uiObjParam.incomeSearchPage_rentalButton = uiPropertiesReader.getIncomeSearchPage_rentalButton();
		logger.info("uiObjParam.incomeSearchPage_rentalButton : " + uiObjParam.incomeSearchPage_rentalButton);
		uiObjParam.incomeSearchPage_socialSecurityButton = uiPropertiesReader
				.getIncomeSearchPage_socialSecurityButton();
		logger.info("uiObjParam.incomeSearchPage_socialSecurityButton : "
				+ uiObjParam.incomeSearchPage_socialSecurityButton);
		uiObjParam.incomeSearchPage_interestDividendButton = uiPropertiesReader
				.getIncomeSearchPage_interestDividendButton();
		logger.info("uiObjParam.incomeSearchPage_interestDividendButton : "
				+ uiObjParam.incomeSearchPage_interestDividendButton);
		uiObjParam.incomeSearchPage_othertButton = uiPropertiesReader.getIncomeSearchPage_othertButton();
		logger.info("uiObjParam.incomeSearchPage_othertButton : " + uiObjParam.incomeSearchPage_othertButton);
		uiObjParam.incomeSearchPage_noIncomeButton = uiPropertiesReader.getIncomeSearchPage_noIncomeButton();
		logger.info("uiObjParam.incomeSearchPage_noIncomeButton : " + uiObjParam.incomeSearchPage_noIncomeButton);
		uiObjParam.incomeSearchPage_beginButton = uiPropertiesReader.getIncomeSearchPage_beginButton();
		logger.info("uiObjParam.incomeSearchPage_beginButton : " + uiObjParam.incomeSearchPage_beginButton);
		uiObjParam.employmentPage_pageLabel = uiPropertiesReader.getEmploymentPage_pageLabel();
		logger.info("uiObjParam.employmentPage_pageLabel : " + uiObjParam.employmentPage_pageLabel);
		uiObjParam.employmentPage_currentlyWorkHereCheckbox = uiPropertiesReader
				.getEmploymentPage_currentlyWorkHereCheckbox();
		logger.info("uiObjParam.employmentPage_currentlyWorkHereCheckbox : "
				+ uiObjParam.employmentPage_currentlyWorkHereCheckbox);
		uiObjParam.employmentPage_endDatePresentTextBox = uiPropertiesReader.getEmploymentPage_endDatePresentTextBox();
		logger.info(
				"uiObjParam.employmentPage_endDatePresentTextBox : " + uiObjParam.employmentPage_endDatePresentTextBox);
		uiObjParam.employmentPage_endDateManualTextBox = uiPropertiesReader.getEmploymentPage_endDateManualTextBox();
		logger.info(
				"uiObjParam.employmentPage_endDateManualTextBox : " + uiObjParam.employmentPage_endDateManualTextBox);
		uiObjParam.employmentPage_commissionTextBox = uiPropertiesReader.getEmploymentPage_commissionTextBox();
		logger.info("uiObjParam.employmentPage_commissionTextBox : " + uiObjParam.employmentPage_commissionTextBox);
		uiObjParam.employmentPage_overtimeTextBox = uiPropertiesReader.getEmploymentPage_overtimeTextBox();
		logger.info("uiObjParam.employmentPage_overtimeTextBox : " + uiObjParam.employmentPage_overtimeTextBox);
		uiObjParam.employmentPage_currentEmployerTextBox = uiPropertiesReader
				.getEmploymentPage_currentEmployerTextBox();
		logger.info("uiObjParam.employmentPage_currentEmployerTextBox : "
				+ uiObjParam.employmentPage_currentEmployerTextBox);
		uiObjParam.employmentPage_titleTextBox = uiPropertiesReader.getEmploymentPage_titleTextBox();
		logger.info("uiObjParam.employmentPage_titleTextBox : " + uiObjParam.employmentPage_titleTextBox);
		uiObjParam.employmentPage_startDateTextBox = uiPropertiesReader.getEmploymentPage_startDateTextBox();
		logger.info("uiObjParam.employmentPage_startDateTextBox : " + uiObjParam.employmentPage_startDateTextBox);
		uiObjParam.employmentPage_inThisLineYearsTextBox = uiPropertiesReader
				.getEmploymentPage_inThisLineYearsTextBox();
		logger.info("uiObjParam.employmentPage_inThisLineYearsTextBox : "
				+ uiObjParam.employmentPage_inThisLineYearsTextBox);
		uiObjParam.employmentPage_inThisLineMonthsTextBox = uiPropertiesReader
				.getEmploymentPage_inThisLineMonthsTextBox();
		logger.info("uiObjParam.employmentPage_inThisLineMonthsTextBox : "
				+ uiObjParam.employmentPage_inThisLineMonthsTextBox);
		uiObjParam.employmentPage_monthlyBaseSalaryTextBox = uiPropertiesReader
				.getEmploymentPage_monthlyBaseSalaryTextBox();
		logger.info("uiObjParam.employmentPage_monthlyBaseSalaryTextBox : "
				+ uiObjParam.employmentPage_monthlyBaseSalaryTextBox);
		uiObjParam.employmentPage_bonusButton = uiPropertiesReader.getEmploymentPage_bonusButton();
		logger.info("uiObjParam.employmentPage_bonusButton : " + uiObjParam.employmentPage_bonusButton);
		uiObjParam.employmentPage_bonusTextBox = uiPropertiesReader.getEmploymentPage_bonusTextBox();
		logger.info("uiObjParam.employmentPage_bonusTextBox : " + uiObjParam.employmentPage_bonusTextBox);
		uiObjParam.employmentPage_commissionButton = uiPropertiesReader.getEmploymentPage_commissionButton();
		logger.info("uiObjParam.employmentPage_commissionButton : " + uiObjParam.employmentPage_commissionButton);
		uiObjParam.employmentPage_overtimeButton = uiPropertiesReader.getEmploymentPage_overtimeButton();
		logger.info("uiObjParam.employmentPage_overtimeButton : " + uiObjParam.employmentPage_overtimeButton);
		uiObjParam.employmentPage_allButton = uiPropertiesReader.getEmploymentPage_allButton();
		logger.info("uiObjParam.employmentPage_allButton : " + uiObjParam.employmentPage_allButton);
		uiObjParam.employmentPage_nextButton = uiPropertiesReader.getEmploymentPage_nextButton();
		logger.info("uiObjParam.employmentPage_nextButton : " + uiObjParam.employmentPage_nextButton);
		uiObjParam.employmentAddressPage_pageLabel = uiPropertiesReader.getEmploymentAddressPage_pageLabel();
		logger.info("uiObjParam.employmentAddressPage_pageLabel : " + uiObjParam.employmentAddressPage_pageLabel);
		uiObjParam.employmentAddressPage_businessAddressTextBox = uiPropertiesReader
				.getEmploymentAddressPage_businessAddressTextBox();
		logger.info("uiObjParam.employmentAddressPage_businessAddressTextBox : "
				+ uiObjParam.employmentAddressPage_businessAddressTextBox);
		uiObjParam.employmentAddressPage_phoneNumberTextBox = uiPropertiesReader
				.getEmploymentAddressPage_phoneNumberTextBox();
		logger.info("uiObjParam.employmentAddressPage_phoneNumberTextBox : "
				+ uiObjParam.employmentAddressPage_phoneNumberTextBox);
		uiObjParam.employmentAddressPage_iAmDoneButton = uiPropertiesReader.getEmploymentAddressPage_iAmDoneButton();
		logger.info(
				"uiObjParam.employmentAddressPage_iAmDoneButton : " + uiObjParam.employmentAddressPage_iAmDoneButton);
		uiObjParam.incomeDetailsPage_pageLabel = uiPropertiesReader.getIncomeDetailsPage_pageLabel();
		logger.info("uiObjParam.incomeDetailsPage_pageLabel : " + uiObjParam.incomeDetailsPage_pageLabel);
		uiObjParam.incomeDetailsPage_dateOfBirthTextBox = uiPropertiesReader.getIncomeDetailsPage_dateOfBirthTextBox();
		logger.info(
				"uiObjParam.incomeDetailsPage_dateOfBirthTextBox : " + uiObjParam.incomeDetailsPage_dateOfBirthTextBox);
		uiObjParam.incomeDetailsPage_ssnTextBox = uiPropertiesReader.getIncomeDetailsPage_ssnTextBox();
		logger.info("uiObjParam.incomeDetailsPage_ssnTextBox : " + uiObjParam.incomeDetailsPage_ssnTextBox);
		uiObjParam.incomeDetailsPage_findMyIncomeButton = uiPropertiesReader.getIncomeDetailsPage_findMyIncomeButton();
		logger.info(
				"uiObjParam.incomeDetailsPage_findMyIncomeButton : " + uiObjParam.incomeDetailsPage_findMyIncomeButton);
		uiObjParam.alimondyChildSupportPage_pageLabel = uiPropertiesReader.getAlimondyChildSupportPage_pageLabel();
		logger.info("uiObjParam.alimondyChildSupportPage_pageLabel : " + uiObjParam.alimondyChildSupportPage_pageLabel);
		uiObjParam.alimondyChildSupportPage_alimonyPerMonthTextBox = uiPropertiesReader
				.getAlimondyChildSupportPage_alimonyPerMonthTextBox();
		logger.info("uiObjParam.alimondyChildSupportPage_alimonyPerMonthTextBox : "
				+ uiObjParam.alimondyChildSupportPage_alimonyPerMonthTextBox);
		uiObjParam.alimondyChildSupportPage_alimonyStartDateTextBox = uiPropertiesReader
				.getAlimondyChildSupportPage_alimonyStartDateTextBox();
		logger.info("uiObjParam.alimondyChildSupportPage_alimonyStartDateTextBox : "
				+ uiObjParam.alimondyChildSupportPage_alimonyStartDateTextBox);
		uiObjParam.alimondyChildSupportPage_childSupportPerMonthTextBox = uiPropertiesReader
				.getAlimondyChildSupportPage_childSupportPerMonthTextBox();
		logger.info("uiObjParam.alimondyChildSupportPage_childSupportPerMonthTextBox : "
				+ uiObjParam.alimondyChildSupportPage_childSupportPerMonthTextBox);
		uiObjParam.alimondyChildSupportPage_childNameTextBox = uiPropertiesReader
				.getAlimondyChildSupportPage_childNameTextBox();
		logger.info("uiObjParam.alimondyChildSupportPage_childNameTextBox : "
				+ uiObjParam.alimondyChildSupportPage_childNameTextBox);
		uiObjParam.alimondyChildSupportPage_childDoBTextBox = uiPropertiesReader
				.getAlimondyChildSupportPage_childDoBTextBox();
		logger.info("uiObjParam.alimondyChildSupportPage_childDoBTextBox : "
				+ uiObjParam.alimondyChildSupportPage_childDoBTextBox);
		uiObjParam.alimondyChildSupportPage_nextButton = uiPropertiesReader.getAlimondyChildSupportPage_nextButton();
		logger.info(
				"uiObjParam.alimondyChildSupportPage_nextButton : " + uiObjParam.alimondyChildSupportPage_nextButton);
		uiObjParam.supportPage_pageLabel = uiPropertiesReader.getSupportPage_pageLabel();
		logger.info("uiObjParam.supportPage_pageLabel : " + uiObjParam.supportPage_pageLabel);
		uiObjParam.supportPage_supportByCourtButton = uiPropertiesReader.getSupportPage_supportByCourtButton();
		logger.info("uiObjParam.supportPage_supportByCourtButton : " + uiObjParam.supportPage_supportByCourtButton);
		uiObjParam.supportPage_noSupportByCourtButton = uiPropertiesReader.getSupportPage_noSupportByCourtButton();
		logger.info("uiObjParam.supportPage_noSupportByCourtButton : " + uiObjParam.supportPage_noSupportByCourtButton);
		uiObjParam.supportPage_willReceiveCourtSupportButton = uiPropertiesReader
				.getSupportPage_willReceiveCourtSupportButton();
		logger.info("uiObjParam.supportPage_willReceiveCourtSupportButton : "
				+ uiObjParam.supportPage_willReceiveCourtSupportButton);
		uiObjParam.supportPage_willNotReceiveCourtSupportButton = uiPropertiesReader
				.getSupportPage_willNotReceiveCourtSupportButton();
		logger.info("uiObjParam.supportPage_willNotReceiveCourtSupportButton : "
				+ uiObjParam.supportPage_willNotReceiveCourtSupportButton);
		uiObjParam.supportPage_postLoanClosureSupportButton = uiPropertiesReader
				.getSupportPage_postLoanClosureSupportButton();
		logger.info("uiObjParam.supportPage_postLoanClosureSupportButton : "
				+ uiObjParam.supportPage_postLoanClosureSupportButton);
		uiObjParam.supportPage_postLoanClosureNoSupportButton = uiPropertiesReader
				.getSupportPage_postLoanClosureNoSupportButton();
		logger.info("uiObjParam.supportPage_postLoanClosureNoSupportButton : "
				+ uiObjParam.supportPage_postLoanClosureNoSupportButton);
		uiObjParam.supportPage_nextButton = uiPropertiesReader.getSupportPage_nextButton();
		logger.info("uiObjParam.supportPage_nextButton : " + uiObjParam.supportPage_nextButton);
		uiObjParam.businessSelfEmploymentPage_pageLabel = uiPropertiesReader.getBusinessSelfEmploymentPage_pageLabel();
		logger.info(
				"uiObjParam.businessSelfEmploymentPage_pageLabel : " + uiObjParam.businessSelfEmploymentPage_pageLabel);
		uiObjParam.businessSelfEmploymentPage_currentlyWorkHereCheckbox = uiPropertiesReader
				.getBusinessSelfEmploymentPage_currentlyWorkHereCheckbox();
		logger.info("uiObjParam.businessSelfEmploymentPage_currentlyWorkHereCheckbox : "
				+ uiObjParam.businessSelfEmploymentPage_currentlyWorkHereCheckbox);
		uiObjParam.businessSelfEmploymentPage_monthlyIncomeTextBox = uiPropertiesReader
				.getBusinessSelfEmploymentPage_monthlyIncomeTextBox();
		logger.info("uiObjParam.businessSelfEmploymentPage_monthlyIncomeTextBox : "
				+ uiObjParam.businessSelfEmploymentPage_monthlyIncomeTextBox);
		uiObjParam.businessSelfEmploymentPage_companyNameTextBox = uiPropertiesReader
				.getBusinessSelfEmploymentPage_companyNameTextBox();
		logger.info("uiObjParam.businessSelfEmploymentPage_companyNameTextBox : "
				+ uiObjParam.businessSelfEmploymentPage_companyNameTextBox);
		uiObjParam.businessSelfEmploymentPage_titleTextBox = uiPropertiesReader
				.getBusinessSelfEmploymentPage_titleTextBox();
		logger.info("uiObjParam.businessSelfEmploymentPage_titleTextBox : "
				+ uiObjParam.businessSelfEmploymentPage_titleTextBox);
		uiObjParam.businessSelfEmploymentPage_companyAddressTextBox = uiPropertiesReader
				.getBusinessSelfEmploymentPage_companyAddressTextBox();
		logger.info("uiObjParam.businessSelfEmploymentPage_companyAddressTextBox : "
				+ uiObjParam.businessSelfEmploymentPage_companyAddressTextBox);
		uiObjParam.businessSelfEmploymentPage_companyPhoneTextBox = uiPropertiesReader
				.getBusinessSelfEmploymentPage_companyPhoneTextBox();
		logger.info("uiObjParam.businessSelfEmploymentPage_companyPhoneTextBox : "
				+ uiObjParam.businessSelfEmploymentPage_companyPhoneTextBox);
		uiObjParam.businessSelfEmploymentPage_companyStartDateTextBox = uiPropertiesReader
				.getBusinessSelfEmploymentPage_companyStartDateTextBox();
		logger.info("uiObjParam.businessSelfEmploymentPage_companyStartDateTextBox : "
				+ uiObjParam.businessSelfEmploymentPage_companyStartDateTextBox);
		uiObjParam.businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton = uiPropertiesReader
				.getBusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton();
		logger.info("uiObjParam.businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton : "
				+ uiObjParam.businessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton);
		uiObjParam.businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton = uiPropertiesReader
				.getBusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton();
		logger.info("uiObjParam.businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton : "
				+ uiObjParam.businessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton);
		uiObjParam.businessSelfEmploymentPage_typeOfCompanyDropdown = uiPropertiesReader
				.getBusinessSelfEmploymentPage_typeOfCompanyDropdown();
		logger.info("uiObjParam.businessSelfEmploymentPage_typeOfCompanyDropdown : "
				+ uiObjParam.businessSelfEmploymentPage_typeOfCompanyDropdown);
		uiObjParam.businessSelfEmploymentPage_nextButton = uiPropertiesReader
				.getBusinessSelfEmploymentPage_nextButton();
		logger.info("uiObjParam.businessSelfEmploymentPage_nextButton : "
				+ uiObjParam.businessSelfEmploymentPage_nextButton);
		uiObjParam.militaryPage_pageLabel = uiPropertiesReader.getMilitaryPage_pageLabel();
		logger.info("uiObjParam.militaryPage_pageLabel : " + uiObjParam.militaryPage_pageLabel);
		uiObjParam.militaryPage_perMonthIncomeTextBox = uiPropertiesReader.getMilitaryPage_perMonthIncomeTextBox();
		logger.info("uiObjParam.militaryPage_perMonthIncomeTextBox : " + uiObjParam.militaryPage_perMonthIncomeTextBox);
		uiObjParam.militaryPage_nextButton = uiPropertiesReader.getMilitaryPage_nextButton();
		logger.info("uiObjParam.militaryPage_nextButton : " + uiObjParam.militaryPage_nextButton);
		uiObjParam.rentalPage_pageLabel = uiPropertiesReader.getRentalPage_pageLabel();
		logger.info("uiObjParam.rentalPage_pageLabel : " + uiObjParam.rentalPage_pageLabel);
		uiObjParam.rentalPage_rentalIncomeTextBox = uiPropertiesReader.getRentalPage_rentalIncomeTextBox();
		logger.info("uiObjParam.rentalPage_rentalIncomeTextBox : " + uiObjParam.rentalPage_rentalIncomeTextBox);
		uiObjParam.rentalPage_propertyAddressTextBox = uiPropertiesReader.getRentalPage_propertyAddressTextBox();
		logger.info("uiObjParam.rentalPage_propertyAddressTextBox : " + uiObjParam.rentalPage_propertyAddressTextBox);
		uiObjParam.rentalPage_propertyTypeDropdown = uiPropertiesReader.getRentalPage_propertyTypeDropdown();
		logger.info("uiObjParam.rentalPage_propertyTypeDropdown : " + uiObjParam.rentalPage_propertyTypeDropdown);
		uiObjParam.rentalPage_numberOfUnitsDropdown = uiPropertiesReader.getRentalPage_numberOfUnitsDropdown();
		logger.info("uiObjParam.rentalPage_numberOfUnitsDropdown : " + uiObjParam.rentalPage_numberOfUnitsDropdown);
		uiObjParam.rentalPage_iAmDoneButton = uiPropertiesReader.getRentalPage_iAmDoneButton();
		logger.info("uiObjParam.rentalPage_iAmDoneButton : " + uiObjParam.rentalPage_iAmDoneButton);
		uiObjParam.rentalPage_propertyStatusDropdown = uiPropertiesReader.getRentalPage_propertyStatusDropdown();
		logger.info("uiObjParam.rentalPage_propertyStatusDropdown : " + uiObjParam.rentalPage_propertyStatusDropdown);
		uiObjParam.rentalPage_propertyUseDropdown = uiPropertiesReader.getRentalPage_propertyUseDropdown();
		logger.info("uiObjParam.rentalPage_propertyUseDropdown : " + uiObjParam.rentalPage_propertyUseDropdown);
		uiObjParam.rentalPage_propertyValueTextBox = uiPropertiesReader.getRentalPage_propertyValueTextBox();
		logger.info("uiObjParam.rentalPage_propertyValueTextBox : " + uiObjParam.rentalPage_propertyValueTextBox);
		uiObjParam.rentalPage_monthlyRentalIncomeTextBox = uiPropertiesReader
				.getRentalPage_monthlyRentalIncomeTextBox();
		logger.info("uiObjParam.rentalPage_monthlyRentalIncomeTextBox : "
				+ uiObjParam.rentalPage_monthlyRentalIncomeTextBox);
		uiObjParam.rentalPage_additionalExpenseTextBox = uiPropertiesReader.getRentalPage_additionalExpenseTextBox();
		logger.info(
				"uiObjParam.rentalPage_additionalExpenseTextBox : " + uiObjParam.rentalPage_additionalExpenseTextBox);
		uiObjParam.rentalPage_netMonthlyRentalIncomeLabel = uiPropertiesReader
				.getRentalPage_netMonthlyRentalIncomeLabel();
		logger.info("uiObjParam.rentalPage_netMonthlyRentalIncomeLabel : "
				+ uiObjParam.rentalPage_netMonthlyRentalIncomeLabel);
		uiObjParam.socialSecurityPage_pageLabel = uiPropertiesReader.getSocialSecurityPage_pageLabel();
		logger.info("uiObjParam.socialSecurityPage_pageLabel : " + uiObjParam.socialSecurityPage_pageLabel);
		uiObjParam.socialSecurityPage_incomePerMonthTextBox = uiPropertiesReader
				.getSocialSecurityPage_incomePerMonthTextBox();
		logger.info("uiObjParam.socialSecurityPage_incomePerMonthTextBox : "
				+ uiObjParam.socialSecurityPage_incomePerMonthTextBox);
		uiObjParam.socialSecurityPage_nextButton = uiPropertiesReader.getSocialSecurityPage_nextButton();
		logger.info("uiObjParam.socialSecurityPage_nextButton : " + uiObjParam.socialSecurityPage_nextButton);
		uiObjParam.interestDividendPage_pageLabel = uiPropertiesReader.getInterestDividendPage_pageLabel();
		logger.info("uiObjParam.interestDividendPage_pageLabel : " + uiObjParam.interestDividendPage_pageLabel);
		uiObjParam.interestDividendPage_lastYearDividendTextBox = uiPropertiesReader
				.getInterestDividendPage_lastYearDividendTextBox();
		logger.info("uiObjParam.interestDividendPage_lastYearDividendTextBox : "
				+ uiObjParam.interestDividendPage_lastYearDividendTextBox);
		uiObjParam.interestDividendPage_yearBeforeLastYearDividendTextBox = uiPropertiesReader
				.getInterestDividendPage_yearBeforeLastYearDividendTextBox();
		logger.info("uiObjParam.interestDividendPage_yearBeforeLastYearDividendTextBox : "
				+ uiObjParam.interestDividendPage_yearBeforeLastYearDividendTextBox);
		uiObjParam.interestDividendPage_nextButton = uiPropertiesReader.getInterestDividendPage_nextButton();
		logger.info("uiObjParam.interestDividendPage_nextButton : " + uiObjParam.interestDividendPage_nextButton);
		uiObjParam.otherIncomePage_pageLabel = uiPropertiesReader.getOtherIncomePage_pageLabel();
		logger.info("uiObjParam.otherIncomePage_pageLabel : " + uiObjParam.otherIncomePage_pageLabel);
		uiObjParam.otherIncomePage_otherIncomeTextBox = uiPropertiesReader.getOtherIncomePage_otherIncomeTextBox();
		logger.info("uiObjParam.otherIncomePage_otherIncomeTextBox : " + uiObjParam.otherIncomePage_otherIncomeTextBox);
		uiObjParam.otherIncomePage_sourceOfIncomeDropdown = uiPropertiesReader
				.getOtherIncomePage_sourceOfIncomeDropdown();
		logger.info("uiObjParam.otherIncomePage_sourceOfIncomeDropdown : "
				+ uiObjParam.otherIncomePage_sourceOfIncomeDropdown);
		uiObjParam.otherIncomePage_otherIncomeForMoreThan2YearsButton = uiPropertiesReader
				.getOtherIncomePage_otherIncomeForMoreThan2YearsButton();
		logger.info("uiObjParam.otherIncomePage_otherIncomeForMoreThan2YearsButton : "
				+ uiObjParam.otherIncomePage_otherIncomeForMoreThan2YearsButton);
		uiObjParam.otherIncomePage_otherIncomeForLessThan2YearsButton = uiPropertiesReader
				.getOtherIncomePage_otherIncomeForLessThan2YearsButton();
		logger.info("uiObjParam.otherIncomePage_otherIncomeForLessThan2YearsButton : "
				+ uiObjParam.otherIncomePage_otherIncomeForLessThan2YearsButton);
		uiObjParam.otherIncomePage_nextButton = uiPropertiesReader.getOtherIncomePage_nextButton();
		logger.info("uiObjParam.otherIncomePage_nextButton : " + uiObjParam.otherIncomePage_nextButton);
		uiObjParam.WhosOnTheLoanPage_AddAnotherCoBorrower = uiPropertiesReader
				.getWhosOnTheLoanPage_AddAnotherCoBorrower();
		logger.info("uiObjParam.WhosOnTheLoanPage_AddAnotherCoBorrower : "
				+ uiObjParam.WhosOnTheLoanPage_AddAnotherCoBorrower);
		uiObjParam.whosOnTheLoanPage_AddSpouseasCoBorrower = uiPropertiesReader
				.getWhosOnTheLoanPage_AddSpouseasCoBorrower();
		logger.info("uiObjParam.whosOnTheLoanPage_AddSpouseasCoBorrower : "
				+ uiObjParam.whosOnTheLoanPage_AddSpouseasCoBorrower);
		uiObjParam.VAorMilitaryLoanPage_NotEligibleForMilitaryLoan = uiPropertiesReader
				.getVAorMilitaryLoanPage_NotEligibleForMilitaryLoan();
		logger.info("uiObjParam.VAorMilitaryLoanPage_NotEligibleForMilitaryLoan : "
				+ uiObjParam.VAorMilitaryLoanPage_NotEligibleForMilitaryLoan);
		uiObjParam.VAorMilitaryLoanPage_pageLabel = uiPropertiesReader.getVAorMilitaryLoanPage_pageLabel();
		logger.info("uiObjParam.VAorMilitaryLoanPage_pageLabel : " + uiObjParam.VAorMilitaryLoanPage_pageLabel);
		uiObjParam.VAorMilitaryLoanPage_nextButton = uiPropertiesReader.getVAorMilitaryLoanPage_nextButton();
		logger.info("uiObjParam.VAorMilitaryLoanPage_nextButton : " + uiObjParam.VAorMilitaryLoanPage_nextButton);
		uiObjParam.realEstateAgentPage_AgentFirstName = uiPropertiesReader.getRealEstateAgentPage_AgentFirstName();
		logger.info("uiObjParam.realEstateAgentPage_AgentFirstName : " + uiObjParam.realEstateAgentPage_AgentFirstName);
		uiObjParam.realEstateAgentPage_AgentLastName = uiPropertiesReader.getRealEstateAgentPage_AgentLastName();
		logger.info("uiObjParam.realEstateAgentPage_AgentLastName : " + uiObjParam.realEstateAgentPage_AgentLastName);
		uiObjParam.purchasePropertyDetailsPage_addressUnits = uiPropertiesReader
				.getPurchasePropertyDetailsPage_addressUnits();
		logger.info("uiObjParam.purchasePropertyDetailsPage_addressUnits : "
				+ uiObjParam.purchasePropertyDetailsPage_addressUnits);
		uiObjParam.purchasePropertyDetailsPage_StateDropdown = uiPropertiesReader
				.getPurchasePropertyDetailsPage_StateDropdown();
		logger.info("uiObjParam.purchasePropertyDetailsPage_StateDropdown : "
				+ uiObjParam.purchasePropertyDetailsPage_StateDropdown);
		uiObjParam.purchasePropertyDetailsPage_CityTextBox = uiPropertiesReader
				.getPurchasePropertyDetailsPage_CityTextBox();
		logger.info("uiObjParam.purchasePropertyDetailsPage_CityTextBox : "
				+ uiObjParam.purchasePropertyDetailsPage_CityTextBox);
		uiObjParam.purchasePropertyDetailsPage_ZipCodeTextBox = uiPropertiesReader
				.getPurchasePropertyDetailsPage_ZipCodeTextBox();
		logger.info("uiObjParam.purchasePropertyDetailsPage_ZipCodeTextBox : "
				+ uiObjParam.purchasePropertyDetailsPage_ZipCodeTextBox);
		uiObjParam.VAorMilitaryLoanPage_EligibleForMilitaryLoan = uiPropertiesReader
				.getVAorMilitaryLoanPage_EligibleForMilitaryLoan();
		logger.info("uiObjParam.VAorMilitaryLoanPage_EligibleForMilitaryLoan : "
				+ uiObjParam.VAorMilitaryLoanPage_EligibleForMilitaryLoan);
		uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDuty = uiPropertiesReader
				.getVAorMilitaryLoanPage_ActiveMilitaryDuty();
		logger.info("uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDuty : "
				+ uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDuty);
		uiObjParam.VAorMilitaryLoanPage_RetiredMilitary = uiPropertiesReader.getVAorMilitaryLoanPage_RetiredMilitary();
		logger.info(
				"uiObjParam.VAorMilitaryLoanPage_RetiredMilitary : " + uiObjParam.VAorMilitaryLoanPage_RetiredMilitary);
		uiObjParam.VAorMilitaryLoanPage_SurvivingSpouse = uiPropertiesReader.getVAorMilitaryLoanPage_SurvivingSpouse();
		logger.info(
				"uiObjParam.VAorMilitaryLoanPage_SurvivingSpouse : " + uiObjParam.VAorMilitaryLoanPage_SurvivingSpouse);
		uiObjParam.VAorMilitaryLoanPage_NonActivatedMember = uiPropertiesReader
				.getVAorMilitaryLoanPage_NonActivatedMember();
		logger.info("uiObjParam.VAorMilitaryLoanPage_NonActivatedMember : "
				+ uiObjParam.VAorMilitaryLoanPage_NonActivatedMember);
		uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDate = uiPropertiesReader
				.getVAorMilitaryLoanPage_ActiveMilitaryDate();
		logger.info("uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDate : "
				+ uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryDate);
		uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryLoan = uiPropertiesReader
				.getVAorMilitaryLoanPage_ActiveMilitaryLoan();
		logger.info("uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryLoan : "
				+ uiObjParam.VAorMilitaryLoanPage_ActiveMilitaryLoan);
		uiObjParam.VAorMilitaryLoanPage_PossesChildCareExpense = uiPropertiesReader
				.getVAorMilitaryLoanPage_PossesChildCareExpense();
		logger.info("uiObjParam.VAorMilitaryLoanPage_PossesChildCareExpense : "
				+ uiObjParam.VAorMilitaryLoanPage_PossesChildCareExpense);
		uiObjParam.VAorMilitaryLoanPage_DontPossesChildCareExpense = uiPropertiesReader
				.getVAorMilitaryLoanPage_DontPossesChildCareExpense();
		logger.info("uiObjParam.VAorMilitaryLoanPage_DontPossesChildCareExpense : "
				+ uiObjParam.VAorMilitaryLoanPage_DontPossesChildCareExpense);
		uiObjParam.VAorMilitaryLoanPage_ChildCareExpenseTextBox = uiPropertiesReader
				.getVAorMilitaryLoanPage_ChildCareExpenseTextBox();
		logger.info("uiObjParam.VAorMilitaryLoanPage_ChildCareExpenseTextBox : "
				+ uiObjParam.VAorMilitaryLoanPage_ChildCareExpenseTextBox);
		uiObjParam.whosOnTheLoanPage_SpouseNotasCoBorrower = uiPropertiesReader
				.getWhosOnTheLoanPage_SpouseNotasCoBorrower();
		logger.info("uiObjParam.whosOnTheLoanPage_SpouseNotasCoBorrower : "
				+ uiObjParam.whosOnTheLoanPage_SpouseNotasCoBorrower);
		uiObjParam.whosOnTheLoanPage_spouseDateOfBirth = uiPropertiesReader.getWhosOnTheLoanPage_spouseDateOfBirth();
		logger.info(
				"uiObjParam.whosOnTheLoanPage_spouseDateOfBirth : " + uiObjParam.whosOnTheLoanPage_spouseDateOfBirth);
		uiObjParam.whosOnTheLoanPage_spouseSSN = uiPropertiesReader.getWhosOnTheLoanPage_spouseSSN();
		logger.info("uiObjParam.whosOnTheLoanPage_spouseSSN : " + uiObjParam.whosOnTheLoanPage_spouseSSN);
		uiObjParam.whosOnTheLoanPage_spouseEmail = uiPropertiesReader.getWhosOnTheLoanPage_spouseEmail();
		logger.info("uiObjParam.whosOnTheLoanPage_spouseEmail : " + uiObjParam.whosOnTheLoanPage_spouseEmail);
		uiObjParam.whosOnTheLoanPage_spousePhone = uiPropertiesReader.getWhosOnTheLoanPage_spousePhone();
		logger.info("uiObjParam.whosOnTheLoanPage_spousePhone : " + uiObjParam.whosOnTheLoanPage_spousePhone);
		uiObjParam.addCoApplicantsPage_Continue = uiPropertiesReader.getAddCoApplicantsPage_Continue();
		logger.info("uiObjParam.addCoApplicantsPage_Continue : " + uiObjParam.addCoApplicantsPage_Continue);
		uiObjParam.addCoApplicantsPage_InviteButton = uiPropertiesReader.getAddCoApplicantsPage_InviteButton();
		logger.info("uiObjParam.addCoApplicantsPage_InviteButton : " + uiObjParam.addCoApplicantsPage_InviteButton);
		uiObjParam.primaryBorrower_pageLabel = uiPropertiesReader.getPrimaryBorrower_pageLabel();
		logger.info("uiObjParam.primaryBorrower_pageLabel : " + uiObjParam.primaryBorrower_pageLabel);
		uiObjParam.primaryBorrower_Next = uiPropertiesReader.getPrimaryBorrower_Next();
		logger.info("uiObjParam.primaryBorrower_Next : " + uiObjParam.primaryBorrower_Next);
		uiObjParam.incomeCompletePage_pageLabel = uiPropertiesReader.getIncomeCompletePage_pageLabel();
		logger.info("uiObjParam.incomeCompletePage_pageLabel : " + uiObjParam.incomeCompletePage_pageLabel);
		uiObjParam.incomeCompletePage_beginSection = uiPropertiesReader.getIncomeCompletePage_beginSection();
		logger.info("uiObjParam.incomeCompletePage_beginSection : " + uiObjParam.incomeCompletePage_beginSection);
		uiObjParam.declaration_JudgmentsYes = uiPropertiesReader.getDeclaration_JudgmentsYes();
		logger.info("uiObjParam.declaration_JudgmentsYes : " + uiObjParam.declaration_JudgmentsYes);
		uiObjParam.declaration_JudgmentsNo = uiPropertiesReader.getDeclaration_JudgmentsNo();
		logger.info("uiObjParam.declaration_JudgmentsNo : " + uiObjParam.declaration_JudgmentsNo);
		uiObjParam.declaration_JudgmentsCommentBox = uiPropertiesReader.getDeclaration_JudgmentsCommentBox();
		logger.info("uiObjParam.declaration_JudgmentsCommentBox : " + uiObjParam.declaration_JudgmentsCommentBox);
		uiObjParam.declaration_BankruptYes = uiPropertiesReader.getDeclaration_BankruptYes();
		logger.info("uiObjParam.declaration_BankruptYes : " + uiObjParam.declaration_BankruptYes);
		uiObjParam.declaration_BankruptNo = uiPropertiesReader.getDeclaration_BankruptNo();
		logger.info("uiObjParam.declaration_BankruptNo : " + uiObjParam.declaration_BankruptNo);
		uiObjParam.declaration_BankruptCommentBox = uiPropertiesReader.getDeclaration_BankruptCommentBox();
		logger.info("uiObjParam.declaration_BankruptCommentBox : " + uiObjParam.declaration_BankruptCommentBox);
		uiObjParam.declaration_ForeClosureYes = uiPropertiesReader.getDeclaration_ForeClosureYes();
		logger.info("uiObjParam.declaration_ForeClosureYes : " + uiObjParam.declaration_ForeClosureYes);
		uiObjParam.declaration_ForeClosureNo = uiPropertiesReader.getDeclaration_ForeClosureNo();
		logger.info("uiObjParam.declaration_ForeClosureNo : " + uiObjParam.declaration_ForeClosureNo);
		uiObjParam.declaration_ForeClosureCommentBox = uiPropertiesReader.getDeclaration_ForeClosureCommentBox();
		logger.info("uiObjParam.declaration_ForeClosureCommentBox : " + uiObjParam.declaration_ForeClosureCommentBox);
		uiObjParam.declaration_LawSuitePropertyYes = uiPropertiesReader.getDeclaration_LawSuitePropertyYes();
		logger.info("uiObjParam.declaration_LawSuitePropertyYes : " + uiObjParam.declaration_LawSuitePropertyYes);
		uiObjParam.declaration_LawSuitePropertyNo = uiPropertiesReader.getDeclaration_LawSuitePropertyNo();
		logger.info("uiObjParam.declaration_LawSuitePropertyNo : " + uiObjParam.declaration_LawSuitePropertyNo);
		uiObjParam.declaration_LawSuitePropertyCommentBox = uiPropertiesReader
				.getDeclaration_LawSuitePropertyCommentBox();
		logger.info("uiObjParam.declaration_LawSuitePropertyCommentBox : "
				+ uiObjParam.declaration_LawSuitePropertyCommentBox);
		uiObjParam.declaration_ObligatedPropertyYes = uiPropertiesReader.getDeclaration_ObligatedPropertyYes();
		logger.info("uiObjParam.declaration_ObligatedPropertyYes : " + uiObjParam.declaration_ObligatedPropertyYes);
		uiObjParam.declaration_ObligatedPropertyNo = uiPropertiesReader.getDeclaration_ObligatedPropertyNo();
		logger.info("uiObjParam.declaration_ObligatedPropertyNo : " + uiObjParam.declaration_ObligatedPropertyNo);
		uiObjParam.declaration_ObligatedPropertyCommentBox = uiPropertiesReader
				.getDeclaration_ObligatedPropertyCommentBox();
		logger.info("uiObjParam.declaration_ObligatedPropertyCommentBox : "
				+ uiObjParam.declaration_ObligatedPropertyCommentBox);
		uiObjParam.declaration_DeliquentYes = uiPropertiesReader.getDeclaration_DeliquentYes();
		logger.info("uiObjParam.declaration_DeliquentYes : " + uiObjParam.declaration_DeliquentYes);
		uiObjParam.declaration_DeliquentNo = uiPropertiesReader.getDeclaration_DeliquentNo();
		logger.info("uiObjParam.declaration_DeliquentNo : " + uiObjParam.declaration_DeliquentNo);
		uiObjParam.declaration_DeliquentCommentBox = uiPropertiesReader.getDeclaration_DeliquentCommentBox();
		logger.info("uiObjParam.declaration_DeliquentCommentBox : " + uiObjParam.declaration_DeliquentCommentBox);
		uiObjParam.declaration_ObligatedAlimonyYes = uiPropertiesReader.getDeclaration_ObligatedAlimonyYes();
		logger.info("uiObjParam.declaration_ObligatedAlimonyYes : " + uiObjParam.declaration_ObligatedAlimonyYes);
		uiObjParam.declaration_ObligatedAlimonyNo = uiPropertiesReader.getDeclaration_ObligatedAlimonyNo();
		logger.info(
				"uiObjParamgetSummary.declaration_ObligatedAlimonyNo : " + uiObjParam.declaration_ObligatedAlimonyNo);
		uiObjParam.declaration_ObligatedAlimonyCommentBox = uiPropertiesReader
				.getDeclaration_ObligatedAlimonyCommentBox();
		logger.info("uiObjParam.declaration_ObligatedAlimonyCommentBox : "
				+ uiObjParam.declaration_ObligatedAlimonyCommentBox);
		uiObjParam.declaration_DownPaymentBorrowedYes = uiPropertiesReader.getDeclaration_DownPaymentBorrowedYes();
		logger.info("uiObjParam.declaration_DownPaymentBorrowedYes : " + uiObjParam.declaration_DownPaymentBorrowedYes);
		uiObjParam.declaration_DownPaymentBorrowedNo = uiPropertiesReader.getDeclaration_DownPaymentBorrowedNo();
		logger.info("uiObjParam.declaration_DownPaymentBorrowedNo : " + uiObjParam.declaration_DownPaymentBorrowedNo);
		uiObjParam.declaration_DownPaymentBorrowedCommentBox = uiPropertiesReader
				.getDeclaration_DownPaymentBorrowedCommentBox();
		logger.info("uiObjParam.declaration_DownPaymentBorrowedCommentBox : "
				+ uiObjParam.declaration_DownPaymentBorrowedCommentBox);
		uiObjParam.declaration_CoMakerYes = uiPropertiesReader.getDeclaration_CoMakerYes();
		logger.info("uiObjParam.declaration_Yes : " + uiObjParam.declaration_CoMakerYes);
		uiObjParam.declaration_CoMakerNo = uiPropertiesReader.getDeclaration_CoMakerNo();
		logger.info("uiObjParam.declaration_CoMakerNo : " + uiObjParam.declaration_CoMakerNo);
		uiObjParam.declaration_CoMakerCommentBox = uiPropertiesReader.getDeclaration_CoMakerCommentBox();
		logger.info("uiObjParam.declaration_CoMakerCommentBox : " + uiObjParam.declaration_CoMakerCommentBox);
		uiObjParam.declaration_USCitizenYes = uiPropertiesReader.getDeclaration_USCitizenYes();
		logger.info("uiObjParam.declaration_USCitizenYes : " + uiObjParam.declaration_USCitizenYes);
		uiObjParam.declaration_USCitizenNo = uiPropertiesReader.getDeclaration_USCitizenNo();
		logger.info("uiObjParam.declaration_USCitizenNo : " + uiObjParam.declaration_USCitizenNo);
		uiObjParam.declaration_ResidentAlienYes = uiPropertiesReader.getDeclaration_ResidentAlienYes();
		logger.info("uiObjParam.declaration_ResidentAlienYes : " + uiObjParam.declaration_ResidentAlienYes);
		uiObjParam.declaration_ResidentAlienNo = uiPropertiesReader.getDeclaration_ResidentAlienNo();
		logger.info("uiObjParam.declaration_ResidentAlienNo : " + uiObjParam.declaration_ResidentAlienNo);
		uiObjParam.declaration_PrimaryResidenceYes = uiPropertiesReader.getDeclaration_PrimaryResidenceYes();
		logger.info("uiObjParam.declaration_PrimaryResidenceYes : " + uiObjParam.declaration_PrimaryResidenceYes);
		uiObjParam.declaration_PrimaryResidenceNo = uiPropertiesReader.getDeclaration_PrimaryResidenceNo();
		logger.info("uiObjParam.declaration_PrimaryResidenceNo : " + uiObjParam.declaration_PrimaryResidenceNo);
		uiObjParam.declaration_OwnershipYes = uiPropertiesReader.getDeclaration_OwnershipYes();
		logger.info("uiObjParam.declaration_OwnershipYes : " + uiObjParam.declaration_OwnershipYes);
		uiObjParam.declaration_OwnershipNo = uiPropertiesReader.getDeclaration_OwnershipNo();
		logger.info("uiObjParam.declaration_OwnershipNo : " + uiObjParam.declaration_OwnershipNo);
		uiObjParam.declaration_OwnershipTypeOfPropertyDropDown = uiPropertiesReader
				.getDeclaration_OwnershipTypeOfPropertyDropDown();
		logger.info("uiObjParam.declaration_OwnershipTypeOfPropertyDropDown : "
				+ uiObjParam.declaration_OwnershipTypeOfPropertyDropDown);
		uiObjParam.declaration_OwnershipTitleToHomeDropDown = uiPropertiesReader
				.getDeclaration_OwnershipTitleToHomeDropDown();
		logger.info("uiObjParam.declaration_OwnershipTitleToHomeDropDown : "
				+ uiObjParam.declaration_OwnershipTitleToHomeDropDown);
		uiObjParam.whosOnTheLoanPage_DontAddAnotherCoBorrower = uiPropertiesReader
				.getWhosOnTheLoanPage_DontAddAnotherCoBorrower();
		logger.info("uiObjParam.whosOnTheLoanPage_DontAddAnotherCoBorrower : "
				+ uiObjParam.whosOnTheLoanPage_DontAddAnotherCoBorrower);
		uiObjParam.declaration_PageLabel = uiPropertiesReader.getDeclaration_PageLabel();
		logger.info("uiObjParam.declaration_PageLabel : " + uiObjParam.declaration_PageLabel);
		uiObjParam.declaration_Ethinicity = uiPropertiesReader.getDeclaration_Ethinicity();
		logger.info("uiObjParam.declaration_Ethinicity : " + uiObjParam.declaration_Ethinicity);
		uiObjParam.declaration_race = uiPropertiesReader.getDeclaration_race();
		logger.info("uiObjParam.declaration_race : " + uiObjParam.declaration_race);
		uiObjParam.declaration_Male = uiPropertiesReader.getDeclaration_Male();
		logger.info("uiObjParam.declaration_Male : " + uiObjParam.declaration_Male);
		uiObjParam.declaration_Female = uiPropertiesReader.getDeclaration_Female();
		logger.info("uiObjParam.declaration_Female : " + uiObjParam.declaration_Female);
		uiObjParam.declaration_next = uiPropertiesReader.getDeclaration_next();
		logger.info("uiObjParam.declaration_next : " + uiObjParam.declaration_next);
		uiObjParam.declarationCompletePage_beginSection = uiPropertiesReader.getDeclarationCompletePage_beginSection();
		logger.info(
				"uiObjParam.declarationCompletePage_beginSection : " + uiObjParam.declarationCompletePage_beginSection);
		uiObjParam.Summary_PageLabel = uiPropertiesReader.getSummary_PageLabel();
		logger.info("uiObjParam.Summary_PageLabel : " + uiObjParam.Summary_PageLabel);

		uiObjParam.Summary_FullName = uiPropertiesReader.getSummary_FullName();
		logger.info("uiObjParam.Summary_FullName : " + uiObjParam.Summary_FullName);

		uiObjParam.Summary_DOB = uiPropertiesReader.getSummary_DOB();
		logger.info("uiObjParam.Summary_DOB : " + uiObjParam.Summary_DOB);

		uiObjParam.Summary_SSN = uiPropertiesReader.getSummary_SSN();
		logger.info("uiObjParam.Summary_SSN : " + uiObjParam.Summary_SSN);

		uiObjParam.Summary_PhoneNumber = uiPropertiesReader.getSummary_PhoneNumber();
		logger.info("uiObjParam.Summary_PhoneNumber : " + uiObjParam.Summary_PhoneNumber);

		uiObjParam.Summary_SelectedProperty = uiPropertiesReader.getSummary_SelectedProperty();
		logger.info("uiObjParam.Summary_SelectedProperty : " + uiObjParam.Summary_SelectedProperty);

		uiObjParam.Summary_PropertyType = uiPropertiesReader.getSummary_PropertyType();
		logger.info("uiObjParam.Summary_PropertyType : " + uiObjParam.Summary_PropertyType);

		uiObjParam.Summary_CurrentlyWorkHere = uiPropertiesReader.getSummary_CurrentlyWorkHere();
		logger.info("uiObjParam.Summary_CurrentlyWorkHere : " + uiObjParam.Summary_CurrentlyWorkHere);

		uiObjParam.Summary_EmployerName = uiPropertiesReader.getSummary_EmployerName();
		logger.info("uiObjParam.Summary_EmployerName : " + uiObjParam.Summary_EmployerName);

		uiObjParam.Summary_LoanAmount = uiPropertiesReader.getSummary_LoanAmount();
		logger.info("uiObjParam.Summary_LoanAmount : " + uiObjParam.Summary_LoanAmount);

		uiObjParam.Summary_TypeOfCredit = uiPropertiesReader.getSummary_TypeOfCredit();
		logger.info("uiObjParam.Summary_TypeOfCredit : " + uiObjParam.Summary_TypeOfCredit);

		uiObjParam.Summary_SpouseAsCoBorrower = uiPropertiesReader.getSummary_SpouseAsCoBorrower();
		logger.info("uiObjParam.Summary_SpouseAsCoBorrower : " + uiObjParam.Summary_SpouseAsCoBorrower);

		uiObjParam.Summary_AddAnotherCoBorrower = uiPropertiesReader.getSummary_AddAnotherCoBorrower();
		logger.info("uiObjParam.Summary_AddAnotherCoBorrower : " + uiObjParam.Summary_AddAnotherCoBorrower);

		uiObjParam.Summary_EligibleForMilitaryLoan = uiPropertiesReader.getSummary_EligibleForMilitaryLoan();
		logger.info("uiObjParam.Summary_EligibleForMilitaryLoan : " + uiObjParam.Summary_EligibleForMilitaryLoan);

		uiObjParam.Summary_AlimondyChildSupport = uiPropertiesReader.getSummary_AlimondyChildSupport();
		logger.info("uiObjParam.Summary_AlimondyChildSupport : " + uiObjParam.Summary_AlimondyChildSupport);

		uiObjParam.Summary_WorkingWithRealEstateAgent = uiPropertiesReader.getSummary_WorkingWithRealEstateAgent();
		logger.info("uiObjParam.Summary_WorkingWithRealEstateAgent : " + uiObjParam.Summary_WorkingWithRealEstateAgent);

		uiObjParam.Summary_CompanyName = uiPropertiesReader.getSummary_CompanyName();
		logger.info("uiObjParam.Summary_CompanyName : " + uiObjParam.Summary_CompanyName);

		uiObjParam.Summary_ResidenceSameAsSpouse = uiPropertiesReader.getSummary_ResidenceSameAsSpouse();
		logger.info("uiObjParam.Summary_ResidenceSameAsSpouse : " + uiObjParam.Summary_ResidenceSameAsSpouse);

		uiObjParam.Summary_MilitaryPay = uiPropertiesReader.getSummary_MilitaryPay();
		logger.info("uiObjParam.Summary_MilitaryPay : " + uiObjParam.Summary_MilitaryPay);

		uiObjParam.Summary_TypeOfProperty = uiPropertiesReader.getSummary_TypeOfProperty();
		logger.info("uiObjParam.Summary_TypeOfProperty : " + uiObjParam.Summary_TypeOfProperty);

		uiObjParam.Summary_SocialSecurityIncome = uiPropertiesReader.getSummary_SocialSecurityIncome();
		logger.info("uiObjParam.Summary_SocialSecurityIncome : " + uiObjParam.Summary_SocialSecurityIncome);

		uiObjParam.Summary_SourceOfIncome = uiPropertiesReader.getSummary_SourceOfIncome();
		logger.info("uiObjParam.Summary_SourceOfIncome : " + uiObjParam.Summary_SourceOfIncome);

		uiObjParam.Summary_AssetTotal = uiPropertiesReader.getSummary_AssetTotal();
		logger.info("uiObjParam.Summary_AssetTotal : " + uiObjParam.Summary_AssetTotal);

		uiObjParam.Summary_OwnedPropertyType = uiPropertiesReader.getSummary_OwnedPropertyType();
		logger.info("uiObjParam.Summary_OwnedPropertyType : " + uiObjParam.Summary_OwnedPropertyType);

		uiObjParam.Summary_Race = uiPropertiesReader.getSummary_Race();
		logger.info("uiObjParam.Summary_Race : " + uiObjParam.Summary_Race);

		uiObjParam.Summary_CoMakeronNote = uiPropertiesReader.getSummary_CoMakeronNote();
		logger.info("uiObjParam.Summary_CoMakeronNote : " + uiObjParam.Summary_CoMakeronNote);

		uiObjParam.Summary_AgreementCheckBox = uiPropertiesReader.getSummary_AgreementCheckBox();
		logger.info("uiObjParam.Summary_AgreementCheckBox : " + uiObjParam.Summary_AgreementCheckBox);

		uiObjParam.Summary_Submit = uiPropertiesReader.getSummary_Submit();
		logger.info("uiObjParam.Summary_Submit : " + uiObjParam.Summary_Submit);

		uiObjParam.SummaryCompletedPage_PageLabel = uiPropertiesReader.getSummaryCompletedPage_PageLabel();
		logger.info("uiObjParam.SummaryCompletedPage_PageLabel : " + uiObjParam.SummaryCompletedPage_PageLabel);
		uiObjParam.SummaryCompletedPage_ViewMyDashboard = uiPropertiesReader.getSummaryCompletedPage_ViewMyDashboard();
		logger.info(
				"uiObjParam.SummaryCompletedPage_ViewMyDashboard : " + uiObjParam.SummaryCompletedPage_ViewMyDashboard);
		uiObjParam.RecentK1sPage_PageLabel = uiPropertiesReader.getRecentK1sPage_PageLabel();
		logger.info("uiObjParam.RecentK1sPage_PageLabel : " + uiObjParam.RecentK1sPage_PageLabel);
		uiObjParam.RecentK1sPage_UploadArea = uiPropertiesReader.getRecentK1sPage_UploadArea();
		logger.info("uiObjParam.RecentK1sPage_UploadArea : " + uiObjParam.RecentK1sPage_UploadArea);
		uiObjParam.RecentK1sPage_WriteExplanation = uiPropertiesReader.getRecentK1sPage_WriteExplanation();
		logger.info("uiObjParam.RecentK1sPage_WriteExplanation : " + uiObjParam.RecentK1sPage_WriteExplanation);
		uiObjParam.RecentK1sPage_Editor = uiPropertiesReader.getRecentK1sPage_Editor();
		logger.info("uiObjParam.RecentK1sPage_Editor : " + uiObjParam.RecentK1sPage_Editor);
		uiObjParam.RecentK1sPage_Next = uiPropertiesReader.getRecentK1sPage_Next();
		logger.info("uiObjParam.RecentK1sPage_Next : " + uiObjParam.RecentK1sPage_Next);
		uiObjParam.YTDPage_PageLabel = uiPropertiesReader.getYTDPage_PageLabel();
		logger.info("uiObjParam.YTDPage_PageLabel : " + uiObjParam.YTDPage_PageLabel);
		uiObjParam.YTDPage_UploadArea = uiPropertiesReader.getYTDPage_UploadArea();
		logger.info("uiObjParam.YTDPage_UploadArea : " + uiObjParam.YTDPage_UploadArea);
		uiObjParam.YTDPage_WriteExplanation = uiPropertiesReader.getYTDPage_WriteExplanation();
		logger.info("uiObjParam.YTDPage_WriteExplanation : " + uiObjParam.YTDPage_WriteExplanation);
		uiObjParam.YTDPage_Editor = uiPropertiesReader.getYTDPage_Editor();
		logger.info("uiObjParam.YTDPage_Editor : " + uiObjParam.YTDPage_Editor);
		uiObjParam.YTDPage_Next = uiPropertiesReader.getYTDPage_Next();
		logger.info("uiObjParam.YTDPage_Next : " + uiObjParam.YTDPage_Next);
		uiObjParam.PersonalTaxReturnsPage_DocUploadArea = uiPropertiesReader.getPersonalTaxReturnsPage_DocUploadArea();
		logger.info(
				"uiObjParam.PersonalTaxReturnsPage_DocUploadArea : " + uiObjParam.PersonalTaxReturnsPage_DocUploadArea);
		uiObjParam.PersonalTaxReturnsPage_Next = uiPropertiesReader.getPersonalTaxReturnsPage_Next();
		logger.info("uiObjParam.PersonalTaxReturnsPage_Next : " + uiObjParam.PersonalTaxReturnsPage_Next);
		uiObjParam.FederalTaxReturnsPage_DocUploadArea = uiPropertiesReader.getFederalTaxReturnsPage_DocUploadArea();
		logger.info(
				"uiObjParam.FederalTaxReturnsPageDocUploadArea : " + uiObjParam.FederalTaxReturnsPage_DocUploadArea);
		uiObjParam.FederalTaxReturnsPage_Next = uiPropertiesReader.getFederalTaxReturnsPage_Next();
		logger.info("uiObjParam.FederalTaxReturnsPage_Next : " + uiObjParam.FederalTaxReturnsPage_Next);
		uiObjParam.PercentageOwnerShipPage_UploadArea = uiPropertiesReader.getPercentageOwnerShipPage_UploadArea();
		logger.info("uiObjParam.PercentageOwnerShipPage_UploadArea : " + uiObjParam.PercentageOwnerShipPage_UploadArea);
		uiObjParam.PercentageOwnerShipPage_WriteExplanation = uiPropertiesReader
				.getPercentageOwnerShipPage_WriteExplanation();
		logger.info("uiObjParam.PercentageOwnerShipPage_WriteExplanation : "
				+ uiObjParam.PercentageOwnerShipPage_WriteExplanation);
		uiObjParam.PercentageOwnerShipPage_Editor = uiPropertiesReader.getPercentageOwnerShipPage_Editor();
		logger.info("uiObjParam.PercentageOwnerShipPage_Editor : " + uiObjParam.PercentageOwnerShipPage_Editor);
		uiObjParam.PercentageOwnerShipPage_Next = uiPropertiesReader.getPercentageOwnerShipPage_Next();
		logger.info("uiObjParam.PercentageOwnerShipPage_Next : " + uiObjParam.PercentageOwnerShipPage_Next);
		uiObjParam.PayStubPage_UploadArea = uiPropertiesReader.getPayStubPage_UploadArea();
		logger.info("uiObjParam.PayStubPage_UploadArea : " + uiObjParam.PayStubPage_UploadArea);
		uiObjParam.PayStubPage_Next = uiPropertiesReader.getPayStubPage_Next();
		logger.info("uiObjParam.PayStubPage_Next : " + uiObjParam.PayStubPage_Next);
		uiObjParam.RecentW2Page_UploadArea = uiPropertiesReader.getRecentW2Page_UploadArea();
		logger.info("uiObjParam.RecentW2Page_UploadArea : " + uiObjParam.RecentW2Page_UploadArea);
		uiObjParam.RecentW2Page_Next = uiPropertiesReader.getRecentW2Page_Next();
		logger.info("uiObjParam.RecentW2Page_Next : " + uiObjParam.RecentW2Page_Next);
		uiObjParam.PurchaseAndSalePage_UploadArea = uiPropertiesReader.getPurchaseAndSalePage_UploadArea();
		logger.info("uiObjParam.PurchaseAndSalePage_UploadArea : " + uiObjParam.PurchaseAndSalePage_UploadArea);
		uiObjParam.PurchaseAndSalePage_WriteExplanation = uiPropertiesReader.getPurchaseAndSalePage_WriteExplanation();
		logger.info(
				"uiObjParam.PurchaseAndSalePage_WriteExplanation : " + uiObjParam.PurchaseAndSalePage_WriteExplanation);
		uiObjParam.PurchaseAndSalePage_Editor = uiPropertiesReader.getPurchaseAndSalePage_Editor();
		logger.info("uiObjParam.PurchaseAndSalePage_Editor : " + uiObjParam.PurchaseAndSalePage_Editor);
		uiObjParam.PurchaseAndSalePage_Next = uiPropertiesReader.getPurchaseAndSalePage_Next();
		logger.info("uiObjParam.PurchaseAndSalePage_Next : " + uiObjParam.PurchaseAndSalePage_Next);
		uiObjParam.ChildSupportPage_UploadArea = uiPropertiesReader.getChildSupportPage_UploadArea();
		logger.info("uiObjParam.ChildSupportPage_UploadArea : " + uiObjParam.ChildSupportPage_UploadArea);
		uiObjParam.ChildSupportPage_Next = uiPropertiesReader.getChildSupportPage_Next();
		logger.info("uiObjParam.ChildSupportPage_Next : " + uiObjParam.ChildSupportPage_Next);
		uiObjParam.DevorceDecreePage_UploadArea = uiPropertiesReader.getDevorceDecreePage_UploadArea();
		logger.info("uiObjParam.DevorceDecreePage_UploadArea : " + uiObjParam.DevorceDecreePage_UploadArea);
		uiObjParam.DevorceDecreePage_WriteExplanation = uiPropertiesReader.getDevorceDecreePage_WriteExplanation();
		logger.info("uiObjParam.DevorceDecreePage_WriteExplanation : " + uiObjParam.DevorceDecreePage_WriteExplanation);
		uiObjParam.DevorceDecreePage_Editor = uiPropertiesReader.getDevorceDecreePage_Editor();
		logger.info("uiObjParam.DevorceDecreePage_Editor : " + uiObjParam.DevorceDecreePage_Editor);
		uiObjParam.DevorceDecreePage_Next = uiPropertiesReader.getDevorceDecreePage_Next();
		logger.info("uiObjParam.DevorceDecreePage_Next : " + uiObjParam.DevorceDecreePage_Next);
		uiObjParam.COEFormPage_UploadArea = uiPropertiesReader.getCOEFormPage_UploadArea();
		logger.info("uiObjParam.COEFormPage_UploadArea : " + uiObjParam.COEFormPage_UploadArea);
		uiObjParam.COEFormPage_Next = uiPropertiesReader.getCOEFormPage_Next();
		logger.info("uiObjParam.COEFormPage_Next : " + uiObjParam.COEFormPage_Next);
		uiObjParam.CertificateOfReleasePage_UploadArea = uiPropertiesReader.getCertificateOfReleasePage_UploadArea();
		logger.info(
				"uiObjParam.CertificateOfReleasePage_UploadArea : " + uiObjParam.CertificateOfReleasePage_UploadArea);
		uiObjParam.CertificateOfReleasePage_WriteExplanation = uiPropertiesReader
				.getCertificateOfReleasePage_WriteExplanation();
		logger.info("uiObjParam.CertificateOfReleasePage_WriteExplanation : "
				+ uiObjParam.CertificateOfReleasePage_WriteExplanation);
		uiObjParam.CertificateOfReleasePage_Editor = uiPropertiesReader.getCertificateOfReleasePage_Editor();
		logger.info("uiObjParam.CertificateOfReleasePage_Editor : " + uiObjParam.CertificateOfReleasePage_Editor);
		uiObjParam.CertificateOfReleasePage_Next = uiPropertiesReader.getCertificateOfReleasePage_Next();
		logger.info("uiObjParam.CertificateOfReleasePage_Next : " + uiObjParam.CertificateOfReleasePage_Next);
		uiObjParam.SupplyOfStatementPage_UploadArea = uiPropertiesReader.getSupplyOfStatementPage_UploadArea();
		logger.info("uiObjParam.SupplyOfStatementPage_UploadArea : " + uiObjParam.SupplyOfStatementPage_UploadArea);
		uiObjParam.SupplyOfStatementPage_WriteExplanation = uiPropertiesReader
				.getSupplyOfStatementPage_WriteExplanation();
		logger.info("uiObjParam.SupplyOfStatementPage_WriteExplanation : "
				+ uiObjParam.SupplyOfStatementPage_WriteExplanation);
		uiObjParam.SupplyOfStatementPage_Editor = uiPropertiesReader.getSupplyOfStatementPage_Editor();
		logger.info("uiObjParam.SupplyOfStatementPage_Editor : " + uiObjParam.SupplyOfStatementPage_Editor);
		uiObjParam.SupplyOfStatementPage_Next = uiPropertiesReader.getSupplyOfStatementPage_Next();
		logger.info("uiObjParam.SupplyOfStatementPage_Next : " + uiObjParam.SupplyOfStatementPage_Next);
		uiObjParam.SocialSecurityAwardPage_UploadArea = uiPropertiesReader.getSocialSecurityAwardPage_UploadArea();
		logger.info("uiObjParam.SocialSecurityAwardPage_UploadArea : " + uiObjParam.SocialSecurityAwardPage_UploadArea);
		uiObjParam.SocialSecurityAwardPage_WriteExplanation = uiPropertiesReader
				.getSocialSecurityAwardPage_WriteExplanation();
		logger.info("uiObjParam.SocialSecurityAwardPage_WriteExplanation : "
				+ uiObjParam.SocialSecurityAwardPage_WriteExplanation);
		uiObjParam.SocialSecurityAwardPage_Editor = uiPropertiesReader.getSocialSecurityAwardPage_Editor();
		logger.info("uiObjParam.SocialSecurityAwardPage_Editor : " + uiObjParam.SocialSecurityAwardPage_Editor);
		uiObjParam.SocialSecurityAwardPage_Next = uiPropertiesReader.getSocialSecurityAwardPage_Next();
		logger.info("uiObjParam.SocialSecurityAwardPage_Next : " + uiObjParam.SocialSecurityAwardPage_Next);
		uiObjParam.ClosingStatementPage_UploadArea = uiPropertiesReader.getClosingStatementPage_UploadArea();
		logger.info("uiObjParam.ClosingStatementPage_UploadArea : " + uiObjParam.ClosingStatementPage_UploadArea);
		uiObjParam.ClosingStatementPage_WriteExplanation = uiPropertiesReader
				.getClosingStatementPage_WriteExplanation();
		logger.info("uiObjParam.ClosingStatementPage_WriteExplanation : "
				+ uiObjParam.ClosingStatementPage_WriteExplanation);
		uiObjParam.ClosingStatementPage_Editor = uiPropertiesReader.getClosingStatementPage_Editor();
		logger.info("uiObjParam.ClosingStatementPage_Editor : " + uiObjParam.ClosingStatementPage_Editor);
		uiObjParam.ClosingStatementPage_Next = uiPropertiesReader.getClosingStatementPage_Next();
		logger.info("uiObjParam.ClosingStatementPage_Next : " + uiObjParam.ClosingStatementPage_Next);
		uiObjParam.WelcomeToDashboardPage_PageLabel = uiPropertiesReader.getWelcomeToDashboardPage_PageLabel();
		logger.info("uiObjParam.WelcomeToDashboardPage_PageLabel : " + uiObjParam.WelcomeToDashboardPage_PageLabel);
		uiObjParam.WelcomeToDashboardPage_LetsJustGo = uiPropertiesReader.getWelcomeToDashboardPage_LetsJustGo();
		logger.info("uiObjParam.WelcomeToDashboardPage_LetsJustGo : " + uiObjParam.WelcomeToDashboardPage_LetsJustGo);
		uiObjParam.WelcomeToDashboardPage_TakeTheTour = uiPropertiesReader.getWelcomeToDashboardPage_TakeTheTour();
		logger.info("uiObjParam.WelcomeToDashboardPage_TakeTheTour : " + uiObjParam.WelcomeToDashboardPage_TakeTheTour);
		uiObjParam.Dashboard_PageLabel = uiPropertiesReader.getDashboard_PageLabel();
		logger.info("uiObjParam.Dashboard_PageLabel : " + uiObjParam.Dashboard_PageLabel);
		uiObjParam.GetStartedPage_Signup = uiPropertiesReader.getGetStartedPage_Signup();
		logger.info("uiObjParam.GetStartedPage_Signup : " + uiObjParam.GetStartedPage_Signup);
		uiObjParam.GetStartedPage_Login = uiPropertiesReader.getGetStartedPage_Login();
		logger.info("uiObjParam.GetStartedPage_Login : " + uiObjParam.GetStartedPage_Login);
		uiObjParam.WelcomeSignupPage_GetStarted = uiPropertiesReader.getWelcomeSignupPage_GetStarted();
		logger.info("uiObjParam.WelcomeSignupPage_GetStarted : " + uiObjParam.WelcomeSignupPage_GetStarted);
		uiObjParam.borrowerCommunicationPage_cellPhone = uiPropertiesReader.getBorrowerCommunicationPage_cellPhone();
		logger.info(
				"uiObjParam.borrowerCommunicationPage_cellPhone : " + uiObjParam.borrowerCommunicationPage_cellPhone);
		uiObjParam.LoanOfferPage_YesLoanOfficer = uiPropertiesReader.getLoanOfferPage_YesLoanOfficer();
		logger.info("uiObjParam.LoanOfferPage_YesLoanOfficer : " + uiObjParam.LoanOfferPage_YesLoanOfficer);
		uiObjParam.LoanOfferPage_NoLoanOfficer = uiPropertiesReader.getLoanOfferPage_NoLoanOfficer();
		logger.info("uiObjParam.LoanOfferPage_NoLoanOfficer : " + uiObjParam.LoanOfferPage_NoLoanOfficer);
		uiObjParam.LoanOfferPage_SearchLoanOfficer = uiPropertiesReader.getLoanOfferPage_SearchLoanOfficer();
		logger.info("uiObjParam.LoanOfferPage_SearchLoanOfficer : " + uiObjParam.LoanOfferPage_SearchLoanOfficer);
		uiObjParam.LoanOfferPage_NextLoanOfficer = uiPropertiesReader.getLoanOfferPage_NextLoanOfficer();
		logger.info("uiObjParam.LoanOfferPage_NextLoanOfficer : " + uiObjParam.LoanOfferPage_NextLoanOfficer);
		uiObjParam.LoanOfferPage_PageLabel = uiPropertiesReader.getLoanOfferPage_PageLabel();
		logger.info("uiObjParam.LoanOfferPage_PageLabel : " + uiObjParam.LoanOfferPage_PageLabel);
		uiObjParam.borrowerCommunicationPage_coborpreferredEmailTextBox = uiPropertiesReader
				.getBorrowerCommunicationPage_coborpreferredEmailTextBox();
		logger.info("uiObjParam.borrowerCommunicationPage_coborpreferredEmailTextBox : "
				+ uiObjParam.borrowerCommunicationPage_coborpreferredEmailTextBox);

		uiObjParam.COBORROWER_MaritalMarried = uiPropertiesReader.getCOBORROWER_MaritalMarried();
		logger.info("uiObjParam.COBORROWER_MaritalMarried : " + uiObjParam.COBORROWER_MaritalMarried);
		uiObjParam.COBORROWER_MaritalSeprated = uiPropertiesReader.getCOBORROWER_MaritalSeprated();
		logger.info("uiObjParam.COBORROWER_MaritalSeprated : " + uiObjParam.COBORROWER_MaritalSeprated);
		uiObjParam.COBORROWER_MaritalUnMarried = uiPropertiesReader.getCOBORROWER_MaritalUnMarried();
		logger.info("uiObjParam.COBORROWER_MaritalUnMarried : " + uiObjParam.COBORROWER_MaritalUnMarried);
		uiObjParam.COBORROWER_MaritalNext = uiPropertiesReader.getCOBORROWER_MaritalNext();
		logger.info("uiObjParam.COBORROWER_MaritalNext : " + uiObjParam.COBORROWER_MaritalNext);
		uiObjParam.COBORROWER_MaritalPageLabel = uiPropertiesReader.getCOBORROWER_MaritalPageLabel();
		logger.info("uiObjParam.COBORROWER_MaritalPageLabel : " + uiObjParam.COBORROWER_MaritalPageLabel);
		uiObjParam.COBORROWER_MaritalNo = uiPropertiesReader.getCOBORROWER_MaritalNo();
		logger.info("uiObjParam.COBORROWER_MaritalNo : " + uiObjParam.COBORROWER_MaritalNo);
		uiObjParam.COBORROWER_MaritalYes = uiPropertiesReader.getCOBORROWER_MaritalYes();
		logger.info("uiObjParam.COBORROWER_MaritalYes : " + uiObjParam.COBORROWER_MaritalYes);
		uiObjParam.COBORROWER_MaritalFirstName = uiPropertiesReader.getCOBORROWER_MaritalFirstName();
		logger.info("uiObjParam.COBORROWER_MaritalFirstName : " + uiObjParam.COBORROWER_MaritalFirstName);
		uiObjParam.COBORROWER_MaritalMiddleName = uiPropertiesReader.getCOBORROWER_MaritalMiddleName();
		logger.info("uiObjParam.COBORROWER_MaritalMiddleName : " + uiObjParam.COBORROWER_MaritalMiddleName);
		uiObjParam.COBORROWER_MaritalLastName = uiPropertiesReader.getCOBORROWER_MaritalLastName();
		logger.info("uiObjParam.COBORROWER_MaritalLastName : " + uiObjParam.COBORROWER_MaritalLastName);
		uiObjParam.COBORROWER_MaritalSuffix = uiPropertiesReader.getCOBORROWER_MaritalSuffix();
		logger.info("uiObjParam.COBORROWER_MaritalSuffix : " + uiObjParam.COBORROWER_MaritalSuffix);
		uiObjParam.COBORROWER_MaritalDOB = uiPropertiesReader.getCOBORROWER_MaritalDOB();
		logger.info("uiObjParam.COBORROWER_MaritalDOB : " + uiObjParam.COBORROWER_MaritalDOB);
		uiObjParam.COBORROWER_MaritalSSN = uiPropertiesReader.getCOBORROWER_MaritalSSN();
		logger.info("uiObjParam.COBORROWER_MaritalSSN : " + uiObjParam.COBORROWER_MaritalSSN);
		uiObjParam.COBORROWER_MaritalEmailID = uiPropertiesReader.getCOBORROWER_MaritalEmailID();
		logger.info("uiObjParam.COBORROWER_MaritalEmailID : " + uiObjParam.COBORROWER_MaritalEmailID);
		uiObjParam.COBORROWER_MaritalCellPhone = uiPropertiesReader.getCOBORROWER_MaritalCellPhone();
		logger.info("uiObjParam.COBORROWER_MaritalCellPhone : " + uiObjParam.COBORROWER_MaritalCellPhone);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_pageLabel = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_pageLabel();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_pageLabel : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_pageLabel);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_ownButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_ownButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_ownButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_ownButton);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_rentButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_rentButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_rentButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_rentButton);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_otherButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_otherButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_otherButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_otherButton);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_currentResidenceTextbox();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_currentResidenceTextbox);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_stayingHereSinceTextbox);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_bothAddressSameCheckbox);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_planningToSellButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_planningToSellButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_planningToSellButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_planningToSellButton);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_notPlanningToSellButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_notPlanningToSellButton);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_nextButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_nextButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_nextButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_nextButton);
		uiObjParam.CoborrwerrealEstatePage_pageLabel = uiPropertiesReader.getCoborrwerrealEstatePage_pageLabel();
		logger.info("uiObjParam.CoborrwerrealEstatePage_pageLabel : " + uiObjParam.CoborrwerrealEstatePage_pageLabel);
		uiObjParam.CoborrwerrealEstatePage_ownAdditionalPropertiesButton = uiPropertiesReader
				.getCoborrwerrealEstatePage_ownAdditionalPropertiesButton();
		logger.info("uiObjParam.CoborrwerrealEstatePage_ownAdditionalPropertiesButton : "
				+ uiObjParam.CoborrwerrealEstatePage_ownAdditionalPropertiesButton);
		uiObjParam.CoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton = uiPropertiesReader
				.getCoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton();
		logger.info("uiObjParam.CoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton : "
				+ uiObjParam.CoborrwerrealEstatePage_dontOwnAdditionalPropertiesButton);
		uiObjParam.CoborrwerrealEstatePage_propertyAddressTextbox = uiPropertiesReader
				.getCoborrwerrealEstatePage_propertyAddressTextbox();
		logger.info("uiObjParam.CoborrwerrealEstatePage_propertyAddressTextbox : "
				+ uiObjParam.CoborrwerrealEstatePage_propertyAddressTextbox);
		uiObjParam.CoborrwerrealEstatePage_propertyValueTextbox = uiPropertiesReader
				.getCoborrwerrealEstatePage_propertyValueTextbox();
		logger.info("uiObjParam.CoborrwerrealEstatePage_propertyValueTextbox : "
				+ uiObjParam.CoborrwerrealEstatePage_propertyValueTextbox);
		uiObjParam.CoborrwerrealEstatePage_rentalIncomeTextbox = uiPropertiesReader
				.getCoborrwerrealEstatePage_rentalIncomeTextbox();
		logger.info("uiObjParam.CoborrwerrealEstatePage_rentalIncomeTextbox : "
				+ uiObjParam.CoborrwerrealEstatePage_rentalIncomeTextbox);
		uiObjParam.CoborrwerrealEstatePage_additioanlIncomeTextbox = uiPropertiesReader
				.getCoborrwerrealEstatePage_additioanlIncomeTextbox();
		logger.info("uiObjParam.CoborrwerrealEstatePage_additioanlIncomeTextbox : "
				+ uiObjParam.CoborrwerrealEstatePage_additioanlIncomeTextbox);
		uiObjParam.CoborrwerrealEstatePage_netRentalIncomeLabel = uiPropertiesReader
				.getCoborrwerrealEstatePage_netRentalIncomeLabel();
		logger.info("uiObjParam.CoborrwerrealEstatePage_netRentalIncomeLabel : "
				+ uiObjParam.CoborrwerrealEstatePage_netRentalIncomeLabel);
		uiObjParam.CoborrwerrealEstatePage_propertyTypeDropdown = uiPropertiesReader
				.getCoborrwerrealEstatePage_propertyTypeDropdown();
		logger.info("uiObjParam.CoborrwerrealEstatePage_propertyTypeDropdown : "
				+ uiObjParam.CoborrwerrealEstatePage_propertyTypeDropdown);
		uiObjParam.CoborrwerrealEstatePage_numberOfUnitsDropdown = uiPropertiesReader
				.getCoborrwerrealEstatePage_numberOfUnitsDropdown();
		logger.info("uiObjParam.CoborrwerrealEstatePage_numberOfUnitsDropdown : "
				+ uiObjParam.CoborrwerrealEstatePage_numberOfUnitsDropdown);
		uiObjParam.CoborrwerrealEstatePage_propertyStatusDropdown = uiPropertiesReader
				.getCoborrwerrealEstatePage_propertyStatusDropdown();
		logger.info("uiObjParam.CoborrwerrealEstatePage_propertyStatusDropdown : "
				+ uiObjParam.CoborrwerrealEstatePage_propertyStatusDropdown);
		uiObjParam.CoborrwerrealEstatePage_propertyUseDropdown = uiPropertiesReader
				.getCoborrwerrealEstatePage_propertyUseDropdown();
		logger.info("uiObjParam.CoborrwerrealEstatePage_propertyUseDropdown : "
				+ uiObjParam.CoborrwerrealEstatePage_propertyUseDropdown);
		uiObjParam.CoborrwerrealEstatePage_submitButton = uiPropertiesReader.getCoborrwerrealEstatePage_submitButton();
		logger.info(
				"uiObjParam.CoborrwerrealEstatePage_submitButton : " + uiObjParam.CoborrwerrealEstatePage_submitButton);
		uiObjParam.CoborrowerincomeSearchPage_pageLabel = uiPropertiesReader.getCoborrowerincomeSearchPage_pageLabel();
		logger.info(
				"uiObjParam.CoborrowerincomeSearchPage_pageLabel : " + uiObjParam.CoborrowerincomeSearchPage_pageLabel);
		uiObjParam.CoborrowerincomeSearchPage_employmentButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_employmentButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_employmentButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_employmentButton);
		uiObjParam.CoborrowerincomeSearchPage_alimonyChildSupportButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_alimonyChildSupportButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_alimonyChildSupportButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_alimonyChildSupportButton);
		uiObjParam.CoborrowerincomeSearchPage_businessSelfEmploymentButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_businessSelfEmploymentButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_businessSelfEmploymentButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_businessSelfEmploymentButton);
		uiObjParam.CoborrowerincomeSearchPage_millitaryButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_millitaryButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_millitaryButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_millitaryButton);
		uiObjParam.CoborrowerincomeSearchPage_rentalButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_rentalButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_rentalButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_rentalButton);
		uiObjParam.CoborrowerincomeSearchPage_socialSecurityButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_socialSecurityButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_socialSecurityButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_socialSecurityButton);
		uiObjParam.CoborrowerincomeSearchPage_interestDividendButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_interestDividendButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_interestDividendButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_interestDividendButton);
		uiObjParam.CoborrowerincomeSearchPage_othertButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_othertButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_othertButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_othertButton);
		uiObjParam.CoborrowerincomeSearchPage_noIncomeButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_noIncomeButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_noIncomeButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_noIncomeButton);
		uiObjParam.CoborrowerincomeSearchPage_beginButton = uiPropertiesReader
				.getCoborrowerincomeSearchPage_beginButton();
		logger.info("uiObjParam.CoborrowerincomeSearchPage_beginButton : "
				+ uiObjParam.CoborrowerincomeSearchPage_beginButton);
		uiObjParam.CoborrowerSummary_PageLabel = uiPropertiesReader.getCoborrowerSummary_PageLabel();
		logger.info("uiObjParam.CoborrowerSummary_PageLabel : " + uiObjParam.CoborrowerSummary_PageLabel);
		uiObjParam.Logout_username = uiPropertiesReader.getLogout_username();
		logger.info("uiObjParam.Logout_username : " + uiObjParam.Logout_username);
		uiObjParam.Logout_looutlink = uiPropertiesReader.getLogout_looutlink();
		logger.info("uiObjParam.Logout_looutlink : " + uiObjParam.Logout_looutlink);
		uiObjParam.CoborrowerLoanOfficer_PageLabel = uiPropertiesReader.getCoborrowerLoanOfficer_PageLabel();
		logger.info("uiObjParam.CoborrowerLoanOfficer_PageLabel : " + uiObjParam.CoborrowerLoanOfficer_PageLabel);
		uiObjParam.SpouseAddedotherIncomePage_nextButton = uiPropertiesReader
				.getSpouseAddedotherIncomePage_nextButton();
		logger.info("uiObjParam.SpouseAddedotherIncomePage_nextButton : "
				+ uiObjParam.SpouseAddedotherIncomePage_nextButton);
		uiObjParam.whosOnTheLoanPage_spouseSuffixTextBox = uiPropertiesReader
				.getWhosOnTheLoanPage_spouseSuffixTextBox();
		logger.info("uiObjParam.whosOnTheLoanPage_spouseSuffixTextBox : "
				+ uiObjParam.whosOnTheLoanPage_spouseSuffixTextBox);
		uiObjParam.SpouseincomeSearchPage_pageLabel = uiPropertiesReader.getSpouseincomeSearchPage_pageLabel();
		logger.info("uiObjParam.SpouseincomeSearchPage_pageLabel : " + uiObjParam.SpouseincomeSearchPage_pageLabel);

		uiObjParam.SpouseincomeSearchPage_employmentButton = uiPropertiesReader
				.getSpouseincomeSearchPage_employmentButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_employmentButton : "
				+ uiObjParam.SpouseincomeSearchPage_employmentButton);
		uiObjParam.SpouseincomeSearchPage_alimonyChildSupportButton = uiPropertiesReader
				.getSpouseincomeSearchPage_alimonyChildSupportButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_alimonyChildSupportButton : "
				+ uiObjParam.SpouseincomeSearchPage_alimonyChildSupportButton);
		uiObjParam.SpouseincomeSearchPage_businessSelfEmploymentButton = uiPropertiesReader
				.getSpouseincomeSearchPage_businessSelfEmploymentButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_businessSelfEmploymentButton : "
				+ uiObjParam.SpouseincomeSearchPage_businessSelfEmploymentButton);
		uiObjParam.SpouseincomeSearchPage_millitaryButton = uiPropertiesReader
				.getSpouseincomeSearchPage_millitaryButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_millitaryButton : "
				+ uiObjParam.SpouseincomeSearchPage_millitaryButton);
		uiObjParam.SpouseincomeSearchPage_rentalButton = uiPropertiesReader.getSpouseincomeSearchPage_rentalButton();
		logger.info(
				"uiObjParam.SpouseincomeSearchPage_rentalButton : " + uiObjParam.SpouseincomeSearchPage_rentalButton);
		uiObjParam.SpouseincomeSearchPage_socialSecurityButton = uiPropertiesReader
				.getSpouseincomeSearchPage_socialSecurityButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_socialSecurityButton : "
				+ uiObjParam.SpouseincomeSearchPage_socialSecurityButton);
		logger.info("uiObjParam.SpouseincomeSearchPage_socialSecurityButton : "
				+ uiObjParam.SpouseincomeSearchPage_socialSecurityButton);
		uiObjParam.SpouseincomeSearchPage_interestDividendButton = uiPropertiesReader
				.getSpouseincomeSearchPage_interestDividendButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_interestDividendButton : "
				+ uiObjParam.SpouseincomeSearchPage_interestDividendButton);
		uiObjParam.SpouseincomeSearchPage_othertButton = uiPropertiesReader.getSpouseincomeSearchPage_othertButton();
		logger.info(
				"uiObjParam.SpouseincomeSearchPage_othertButton : " + uiObjParam.SpouseincomeSearchPage_othertButton);
		uiObjParam.SpouseincomeSearchPage_noIncomeButton = uiPropertiesReader
				.getSpouseincomeSearchPage_noIncomeButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_noIncomeButton : "
				+ uiObjParam.SpouseincomeSearchPage_noIncomeButton);
		uiObjParam.SpouseincomeSearchPage_beginButton = uiPropertiesReader.getSpouseincomeSearchPage_beginButton();
		logger.info("uiObjParam.SpouseincomeSearchPage_beginButton : " + uiObjParam.SpouseincomeSearchPage_beginButton);
		uiObjParam.SpouseemploymentPage_pageLabel = uiPropertiesReader.getSpouseemploymentPage_pageLabel();
		logger.info("uiObjParam.SpouseemploymentPage_pageLabel : " + uiObjParam.SpouseemploymentPage_pageLabel);
		uiObjParam.SpouseemploymentPage_currentlyWorkHereCheckbox = uiPropertiesReader
				.getSpouseemploymentPage_currentlyWorkHereCheckbox();
		logger.info("uiObjParam.SpouseemploymentPage_currentlyWorkHereCheckbox : "
				+ uiObjParam.SpouseemploymentPage_currentlyWorkHereCheckbox);
		uiObjParam.SpouseemploymentPage_currentEmployerTextBox = uiPropertiesReader
				.getSpouseemploymentPage_currentEmployerTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_currentEmployerTextBox : "
				+ uiObjParam.SpouseemploymentPage_currentEmployerTextBox);
		uiObjParam.SpouseemploymentPage_titleTextBox = uiPropertiesReader.getSpouseemploymentPage_titleTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_titleTextBox : " + uiObjParam.SpouseemploymentPage_titleTextBox);
		uiObjParam.SpouseemploymentPage_startDateTextBox = uiPropertiesReader
				.getSpouseemploymentPage_startDateTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_startDateTextBox : "
				+ uiObjParam.SpouseemploymentPage_startDateTextBox);
		uiObjParam.SpouseemploymentPage_endDatePresentTextBox = uiPropertiesReader
				.getSpouseemploymentPage_endDatePresentTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_endDatePresentTextBox : "
				+ uiObjParam.SpouseemploymentPage_endDatePresentTextBox);
		uiObjParam.SpouseemploymentPage_endDateManualTextBox = uiPropertiesReader
				.getSpouseemploymentPage_endDateManualTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_endDateManualTextBox : "
				+ uiObjParam.SpouseemploymentPage_endDateManualTextBox);
		uiObjParam.SpouseemploymentPage_inThisLineYearsTextBox = uiPropertiesReader
				.getSpouseemploymentPage_inThisLineYearsTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_inThisLineYearsTextBox : "
				+ uiObjParam.SpouseemploymentPage_inThisLineYearsTextBox);
		uiObjParam.SpouseemploymentPage_inThisLineMonthsTextBox = uiPropertiesReader
				.getSpouseemploymentPage_inThisLineMonthsTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_inThisLineMonthsTextBox : "
				+ uiObjParam.SpouseemploymentPage_inThisLineMonthsTextBox);
		uiObjParam.SpouseemploymentPage_monthlyBaseSalaryTextBox = uiPropertiesReader
				.getSpouseemploymentPage_monthlyBaseSalaryTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_monthlyBaseSalaryTextBox : "
				+ uiObjParam.SpouseemploymentPage_monthlyBaseSalaryTextBox);
		uiObjParam.SpouseemploymentPage_bonusButton = uiPropertiesReader.getSpouseemploymentPage_bonusButton();
		logger.info("uiObjParam.SpouseemploymentPage_bonusButton : " + uiObjParam.SpouseemploymentPage_bonusButton);
		uiObjParam.SpouseemploymentPage_commissionButton = uiPropertiesReader
				.getSpouseemploymentPage_commissionButton();
		logger.info("uiObjParam.SpouseemploymentPage_commissionButton : "
				+ uiObjParam.SpouseemploymentPage_commissionButton);
		uiObjParam.SpouseemploymentPage_overtimeButton = uiPropertiesReader.getSpouseemploymentPage_overtimeButton();
		logger.info(
				"uiObjParam.SpouseemploymentPage_overtimeButton : " + uiObjParam.SpouseemploymentPage_overtimeButton);
		uiObjParam.SpouseemploymentPage_allButton = uiPropertiesReader.getSpouseemploymentPage_allButton();
		logger.info("uiObjParam.SpouseemploymentPage_allButton : " + uiObjParam.SpouseemploymentPage_allButton);
		uiObjParam.SpouseemploymentPage_bonusTextBox = uiPropertiesReader.getSpouseemploymentPage_bonusTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_bonusTextBox : " + uiObjParam.SpouseemploymentPage_bonusTextBox);
		uiObjParam.SpouseemploymentPage_commissionTextBox = uiPropertiesReader
				.getSpouseemploymentPage_commissionTextBox();
		logger.info("uiObjParam.SpouseemploymentPage_commissionTextBox : "
				+ uiObjParam.SpouseemploymentPage_commissionTextBox);
		uiObjParam.SpouseemploymentPage_overtimeTextBox = uiPropertiesReader.getSpouseemploymentPage_overtimeTextBox();
		logger.info(
				"uiObjParam.SpouseemploymentPage_overtimeTextBox : " + uiObjParam.SpouseemploymentPage_overtimeTextBox);
		uiObjParam.SpouseemploymentPage_nextButton = uiPropertiesReader.getSpouseemploymentPage_nextButton();
		logger.info("uiObjParam.SpouseemploymentPage_nextButton : " + uiObjParam.SpouseemploymentPage_nextButton);
		uiObjParam.SpousealimondyChildSupportPage_pageLabel = uiPropertiesReader
				.getSpousealimondyChildSupportPage_pageLabel();
		logger.info("uiObjParam.SpousealimondyChildSupportPage_pageLabel : "
				+ uiObjParam.SpousealimondyChildSupportPage_pageLabel);
		uiObjParam.SpousealimondyChildSupportPage_alimonyPerMonthTextBox = uiPropertiesReader
				.getSpousealimondyChildSupportPage_alimonyPerMonthTextBox();
		logger.info("uiObjParam.SpousealimondyChildSupportPage_alimonyPerMonthTextBox : "
				+ uiObjParam.SpousealimondyChildSupportPage_alimonyPerMonthTextBox);
		uiObjParam.SpousealimondyChildSupportPage_alimonyStartDateTextBox = uiPropertiesReader
				.getSpousealimondyChildSupportPage_alimonyStartDateTextBox();
		logger.info("uiObjParam.SpousealimondyChildSupportPage_alimonyStartDateTextBox : "
				+ uiObjParam.SpousealimondyChildSupportPage_alimonyStartDateTextBox);
		uiObjParam.SpousealimondyChildSupportPage_childSupportPerMonthTextBox = uiPropertiesReader
				.getSpousealimondyChildSupportPage_childSupportPerMonthTextBox();
		logger.info("uiObjParam.SpousealimondyChildSupportPage_childSupportPerMonthTextBox : "
				+ uiObjParam.SpousealimondyChildSupportPage_childSupportPerMonthTextBox);
		uiObjParam.SpousealimondyChildSupportPage_childNameTextBox = uiPropertiesReader
				.getSpousealimondyChildSupportPage_childNameTextBox();
		logger.info("uiObjParam.SpousealimondyChildSupportPage_childNameTextBox : "
				+ uiObjParam.SpousealimondyChildSupportPage_childNameTextBox);
		uiObjParam.SpousealimondyChildSupportPage_childDoBTextBox = uiPropertiesReader
				.getSpousealimondyChildSupportPage_childDoBTextBox();
		logger.info("uiObjParam.SpousealimondyChildSupportPage_childDoBTextBox : "
				+ uiObjParam.SpousealimondyChildSupportPage_childDoBTextBox);
		uiObjParam.SpousealimondyChildSupportPage_nextButton = uiPropertiesReader
				.getSpousealimondyChildSupportPage_nextButton();
		logger.info("uiObjParam.SpousealimondyChildSupportPage_nextButton : "
				+ uiObjParam.SpousealimondyChildSupportPage_nextButton);
		uiObjParam.SpousemploymentAddressPage_businessAddressTextBox = uiPropertiesReader
				.getSpousemploymentAddressPage_businessAddressTextBox();
		logger.info("uiObjParam.SpousemploymentAddressPage_businessAddressTextBox : "
				+ uiObjParam.SpousemploymentAddressPage_businessAddressTextBox);
		uiObjParam.SpouseemploymentAddressPage_phoneNumberTextBox = uiPropertiesReader
				.getSpouseemploymentAddressPage_phoneNumberTextBox();
		logger.info("uiObjParam.SpouseemploymentAddressPage_phoneNumberTextBox : "
				+ uiObjParam.SpouseemploymentAddressPage_phoneNumberTextBox);

		uiObjParam.SpousesupportPage_pageLabel = uiPropertiesReader.getSpousesupportPage_pageLabel();
		logger.info("uiObjParam.SpousesupportPage_pageLabel : " + uiObjParam.SpousesupportPage_pageLabel);
		uiObjParam.SpousesupportPage_supportByCourtButton = uiPropertiesReader
				.getSpousesupportPage_supportByCourtButton();
		logger.info("uiObjParam.SpousesupportPage_supportByCourtButton : "
				+ uiObjParam.SpousesupportPage_supportByCourtButton);
		uiObjParam.SpousesupportPage_noSupportByCourtButton = uiPropertiesReader
				.getSpousesupportPage_noSupportByCourtButton();
		logger.info("uiObjParam.SpousesupportPage_noSupportByCourtButton : "
				+ uiObjParam.SpousesupportPage_noSupportByCourtButton);
		uiObjParam.SpousesupportPage_willReceiveCourtSupportButton = uiPropertiesReader
				.getSpousesupportPage_willReceiveCourtSupportButton();
		logger.info("uiObjParam.SpousesupportPage_willReceiveCourtSupportButton : "
				+ uiObjParam.SpousesupportPage_willReceiveCourtSupportButton);
		uiObjParam.SpousesupportPage_willNotReceiveCourtSupportButton = uiPropertiesReader
				.getSpousesupportPage_willNotReceiveCourtSupportButton();
		logger.info("uiObjParam.SpousesupportPage_willNotReceiveCourtSupportButton : "
				+ uiObjParam.SpousesupportPage_willNotReceiveCourtSupportButton);
		uiObjParam.SpousesupportPage_postLoanClosureSupportButton = uiPropertiesReader
				.getSpousesupportPage_postLoanClosureSupportButton();
		logger.info("uiObjParam.SpousesupportPage_postLoanClosureSupportButton : "
				+ uiObjParam.SpousesupportPage_postLoanClosureSupportButton);
		uiObjParam.SpousesupportPage_postLoanClosureNoSupportButton = uiPropertiesReader
				.getSpousesupportPage_postLoanClosureNoSupportButton();
		logger.info("uiObjParam.SpousesupportPage_postLoanClosureNoSupportButton : "
				+ uiObjParam.SpousesupportPage_postLoanClosureNoSupportButton);
		uiObjParam.SpousesupportPage_nextButton = uiPropertiesReader.getSpousesupportPage_nextButton();
		logger.info("uiObjParam.SpousesupportPage_nextButton : " + uiObjParam.SpousesupportPage_nextButton);
		uiObjParam.SpousebusinessSelfEmploymentPage_pageLabel = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_pageLabel();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_pageLabel : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_pageLabel);
		uiObjParam.SpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_currentlyWorkHereCheckbox);
		uiObjParam.SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_monthlyIncomeTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_monthlyIncomeTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_companyNameTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_companyNameTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_companyNameTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_companyNameTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_titleTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_titleTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_titleTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_titleTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_companyAddressTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_companyAddressTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_companyAddressTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_companyAddressTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_companyPhoneTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_companyPhoneTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_companyPhoneTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_companyPhoneTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_companyStartDateTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_companyStartDateTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_companyStartDateTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_companyStartDateTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_companyEndDatePresentTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_companyEndDateManualTextBox = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_companyEndDateManualTextBox();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_companyEndDateManualTextBox : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_companyEndDateManualTextBox);
		uiObjParam.SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_moreThan25PercentStakeInCompanyButton);
		uiObjParam.SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_lessThan25PercentStakeInCompanyButton);
		uiObjParam.SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_typeOfCompanyDropdown();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_typeOfCompanyDropdown);
		uiObjParam.SpousebusinessSelfEmploymentPage_nextButton = uiPropertiesReader
				.getSpousebusinessSelfEmploymentPage_nextButton();
		logger.info("uiObjParam.SpousebusinessSelfEmploymentPage_nextButton : "
				+ uiObjParam.SpousebusinessSelfEmploymentPage_nextButton);

		uiObjParam.SpousemilitaryPage_pageLabel = uiPropertiesReader.getSpousemilitaryPage_pageLabel();
		logger.info("uiObjParam.SpousemilitaryPage_pageLabel : " + uiObjParam.SpousemilitaryPage_pageLabel);
		uiObjParam.SpousemilitaryPage_perMonthIncomeTextBox = uiPropertiesReader
				.getSpousemilitaryPage_perMonthIncomeTextBox();
		logger.info("uiObjParam.SpousemilitaryPage_perMonthIncomeTextBox : "
				+ uiObjParam.SpousemilitaryPage_perMonthIncomeTextBox);
		uiObjParam.SpousemilitaryPage_nextButton = uiPropertiesReader.getSpousemilitaryPage_nextButton();
		logger.info("uiObjParam.SpousemilitaryPage_nextButton : " + uiObjParam.SpousemilitaryPage_nextButton);
		uiObjParam.SpouserentalPage_pageLabel = uiPropertiesReader.getSpouserentalPage_pageLabel();
		logger.info("uiObjParam.SpouserentalPage_pageLabel : " + uiObjParam.SpouserentalPage_pageLabel);
		uiObjParam.SpouserentalPage_rentalIncomeTextBox = uiPropertiesReader.getSpouserentalPage_rentalIncomeTextBox();
		logger.info(
				"uiObjParam.SpouserentalPage_rentalIncomeTextBox : " + uiObjParam.SpouserentalPage_rentalIncomeTextBox);
		uiObjParam.SpouserentalPage_propertyAddressTextBox = uiPropertiesReader
				.getSpouserentalPage_propertyAddressTextBox();
		logger.info("uiObjParam.SpouserentalPage_propertyAddressTextBox : "
				+ uiObjParam.SpouserentalPage_propertyAddressTextBox);
		uiObjParam.SpouserentalPage_propertyTypeDropdown = uiPropertiesReader
				.getSpouserentalPage_propertyTypeDropdown();
		logger.info("uiObjParam.SpouserentalPage_propertyTypeDropdown : "
				+ uiObjParam.SpouserentalPage_propertyTypeDropdown);
		uiObjParam.SpouserentalPage_numberOfUnitsDropdown = uiPropertiesReader
				.getSpouserentalPage_numberOfUnitsDropdown();
		logger.info("uiObjParam.SpouserentalPage_numberOfUnitsDropdown : "
				+ uiObjParam.SpouserentalPage_numberOfUnitsDropdown);
		uiObjParam.SpouserentalPage_propertyStatusDropdown = uiPropertiesReader
				.getSpouserentalPage_propertyStatusDropdown();
		logger.info("uiObjParam.SpouserentalPage_propertyStatusDropdown : "
				+ uiObjParam.SpouserentalPage_propertyStatusDropdown);
		uiObjParam.SpouserentalPage_propertyUseDropdown = uiPropertiesReader.getSpouserentalPage_propertyUseDropdown();
		logger.info(
				"uiObjParam.SpouserentalPage_propertyUseDropdown : " + uiObjParam.SpouserentalPage_propertyUseDropdown);
		uiObjParam.SpouserentalPage_propertyValueTextBox = uiPropertiesReader
				.getSpouserentalPage_propertyValueTextBox();
		logger.info("uiObjParam.SpouserentalPage_propertyValueTextBox : "
				+ uiObjParam.SpouserentalPage_propertyValueTextBox);
		uiObjParam.SpouserentalPage_monthlyRentalIncomeTextBox = uiPropertiesReader
				.getSpouserentalPage_monthlyRentalIncomeTextBox();
		logger.info("uiObjParam.SpouserentalPage_monthlyRentalIncomeTextBox : "
				+ uiObjParam.SpouserentalPage_monthlyRentalIncomeTextBox);
		uiObjParam.SpouserentalPage_additionalExpenseTextBox = uiPropertiesReader
				.getSpouserentalPage_additionalExpenseTextBox();
		logger.info("uiObjParam.SpouserentalPage_additionalExpenseTextBox : "
				+ uiObjParam.SpouserentalPage_additionalExpenseTextBox);
		uiObjParam.SpouserentalPage_netMonthlyRentalIncomeLabel = uiPropertiesReader
				.getSpouserentalPage_netMonthlyRentalIncomeLabel();
		logger.info("uiObjParam.SpouserentalPage_netMonthlyRentalIncomeLabel : "
				+ uiObjParam.SpouserentalPage_netMonthlyRentalIncomeLabel);
		uiObjParam.SpouserentalPage_iAmDoneButton = uiPropertiesReader.getSpouserentalPage_iAmDoneButton();
		logger.info("uiObjParam.SpouserentalPage_iAmDoneButton : " + uiObjParam.SpouserentalPage_iAmDoneButton);

		uiObjParam.SpousesocialSecurityPage_pageLabel = uiPropertiesReader.getSpousesocialSecurityPage_pageLabel();
		logger.info("uiObjParam.SpousesocialSecurityPage_pageLabel : " + uiObjParam.SpousesocialSecurityPage_pageLabel);
		uiObjParam.SpousesocialSecurityPage_incomePerMonthTextBox = uiPropertiesReader
				.getSpousesocialSecurityPage_incomePerMonthTextBox();
		logger.info("uiObjParam.SpousesocialSecurityPage_incomePerMonthTextBox : "
				+ uiObjParam.SpousesocialSecurityPage_incomePerMonthTextBox);
		uiObjParam.SpousesocialSecurityPage_nextButton = uiPropertiesReader.getSpousesocialSecurityPage_nextButton();
		logger.info(
				"uiObjParam.SpousesocialSecurityPage_nextButton : " + uiObjParam.SpousesocialSecurityPage_nextButton);
		uiObjParam.SpouseinterestDividendPage_pageLabel = uiPropertiesReader.getSpouseinterestDividendPage_pageLabel();
		logger.info(
				"uiObjParam.SpouseinterestDividendPage_pageLabel : " + uiObjParam.SpouseinterestDividendPage_pageLabel);
		uiObjParam.SpouseinterestDividendPage_lastYearDividendTextBox = uiPropertiesReader
				.getSpouseinterestDividendPage_lastYearDividendTextBox();
		logger.info("uiObjParam.SpouseinterestDividendPage_lastYearDividendTextBox : "
				+ uiObjParam.SpouseinterestDividendPage_lastYearDividendTextBox);
		uiObjParam.SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox = uiPropertiesReader
				.getSpouseinterestDividendPage_yearBeforeLastYearDividendTextBox();
		logger.info("uiObjParam.SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox : "
				+ uiObjParam.SpouseinterestDividendPage_yearBeforeLastYearDividendTextBox);
		uiObjParam.SpouseinterestDividendPage_nextButton = uiPropertiesReader
				.getSpouseinterestDividendPage_nextButton();
		logger.info("uiObjParam.SpouseinterestDividendPage_nextButton : "
				+ uiObjParam.SpouseinterestDividendPage_nextButton);
		uiObjParam.SpouseotherIncomePage_pageLabel = uiPropertiesReader.getSpouseotherIncomePage_pageLabel();
		logger.info("uiObjParam.SpouseotherIncomePage_pageLabel : " + uiObjParam.SpouseotherIncomePage_pageLabel);
		uiObjParam.SpouseotherIncomePage_otherIncomeTextBox = uiPropertiesReader
				.getSpouseotherIncomePage_otherIncomeTextBox();
		logger.info("uiObjParam.SpouseotherIncomePage_otherIncomeTextBox : "
				+ uiObjParam.SpouseotherIncomePage_otherIncomeTextBox);
		uiObjParam.SpouseotherIncomePage_sourceOfIncomeDropdown = uiPropertiesReader
				.getSpouseotherIncomePage_sourceOfIncomeDropdown();
		logger.info("uiObjParam.SpouseotherIncomePage_sourceOfIncomeDropdown : "
				+ uiObjParam.SpouseotherIncomePage_sourceOfIncomeDropdown);
		uiObjParam.SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton = uiPropertiesReader
				.getSpouseotherIncomePage_otherIncomeForMoreThan2YearsButton();
		logger.info("uiObjParam.SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton : "
				+ uiObjParam.SpouseotherIncomePage_otherIncomeForMoreThan2YearsButton);
		uiObjParam.SpouseotherIncomePage_otherIncomeForLessThan2YearsButton = uiPropertiesReader
				.getSpouseotherIncomePage_otherIncomeForLessThan2YearsButton();
		logger.info("uiObjParam.SpouseotherIncomePage_otherIncomeForLessThan2YearsButton : "
				+ uiObjParam.SpouseotherIncomePage_otherIncomeForLessThan2YearsButton);
		uiObjParam.SpouseotherIncomePage_nextButton = uiPropertiesReader.getSpouseotherIncomePage_nextButton();
		logger.info("uiObjParam.SpouseotherIncomePage_nextButton : " + uiObjParam.SpouseotherIncomePage_nextButton);
		uiObjParam.SpouseAddeddeclaration_next = uiPropertiesReader.getSpouseAddeddeclaration_next();
		logger.info("uiObjParam.SpouseAddeddeclaration_next : " + uiObjParam.SpouseAddeddeclaration_next);
		uiObjParam.Spousedeclaration_race = uiPropertiesReader.getSpousedeclaration_race();
		logger.info("uiObjParam.Spousedeclaration_race : " + uiObjParam.Spousedeclaration_race);
		uiObjParam.SpouseLoginTellAboutYouPage_tellAboutYourselfLabel = uiPropertiesReader
				.getSpouseLoginTellAboutYouPage_tellAboutYourselfLabel();
		logger.info("uiObjParam.SpouseLoginTellAboutYouPage_tellAboutYourselfLabel : "
				+ uiObjParam.SpouseLoginTellAboutYouPage_tellAboutYourselfLabel);
		uiObjParam.SpouseLoginborrowerCommunicationPage_pageLabel = uiPropertiesReader
				.getSpouseLoginborrowerCommunicationPage_pageLabel();
		logger.info("uiObjParam.SpouseLoginborrowerCommunicationPage_pageLabel : "
				+ uiObjParam.SpouseLoginborrowerCommunicationPage_pageLabel);
		uiObjParam.SpousecurrentResidentialDetailsPage_pageLabel = uiPropertiesReader
				.getSpousecurrentResidentialDetailsPage_pageLabel();
		logger.info("uiObjParam.SpousecurrentResidentialDetailsPage_pageLabel : "
				+ uiObjParam.SpousecurrentResidentialDetailsPage_pageLabel);
		uiObjParam.borrowerSpouserentalPage_pageLabel = uiPropertiesReader.getBorrowerSpouserentalPage_pageLabel();
		logger.info("uiObjParam.borrowerSpouserentalPage_pageLabel : " + uiObjParam.borrowerSpouserentalPage_pageLabel);
		uiObjParam.borrowerSpouseinterestDividendPage_pageLabel = uiPropertiesReader
				.getBorrowerSpouseinterestDividendPage_pageLabel();
		logger.info("uiObjParam.borrowerSpouseinterestDividendPage_pageLabel : "
				+ uiObjParam.borrowerSpouseinterestDividendPage_pageLabel);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_sameResidenceAsSpouseButton);
		uiObjParam.CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton = uiPropertiesReader
				.getCoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton();
		logger.info("uiObjParam.CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton : "
				+ uiObjParam.CoborrwercurrentResidentialDetailsPage_notSameResidenceAsSpouseButton);
		uiObjParam.borrowerCommunicationPage_coborSpousepreferredEmailTextBox = uiPropertiesReader
				.getBorrowerCommunicationPage_coborSpousepreferredEmailTextBox();
		logger.info("uiObjParam.borrowerCommunicationPage_coborSpousepreferredEmailTextBox : "
				+ uiObjParam.borrowerCommunicationPage_coborSpousepreferredEmailTextBox);
		uiObjParam.borrowerCommunicationPage_coborHispreferredEmailTextBox = uiPropertiesReader
				.getBorrowerCommunicationPage_coborHispreferredEmailTextBox();
		logger.info("uiObjParam.borrowerCommunicationPage_coborHispreferredEmailTextBox : "
				+ uiObjParam.borrowerCommunicationPage_coborHispreferredEmailTextBox);
		uiObjParam.borrowerCommunicationPage_cobSpouseemailButton = uiPropertiesReader
				.getBorrowerCommunicationPage_cobSpouseemailButton();
		logger.info("uiObjParam.borrowerCommunicationPage_cobSpouseemailButton : "
				+ uiObjParam.borrowerCommunicationPage_cobSpouseemailButton);
		uiObjParam.CobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel = uiPropertiesReader
				.getCobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel();
		logger.info("uiObjParam.CobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel : "
				+ uiObjParam.CobSpouseLoginTellAboutYouPage_tellAboutYourselfLabel);
		uiObjParam.Affinity_ProfileFirstName = uiPropertiesReader.getAffinity_ProfileFirstName();
		logger.info("uiObjParam.Affinity_ProfileFirstName : " + uiObjParam.Affinity_ProfileFirstName);
		uiObjParam.Affinity_ProfileLastName = uiPropertiesReader.getAffinity_ProfileLastName();
		logger.info("uiObjParam.Affinity_ProfileLastName : " + uiObjParam.Affinity_ProfileLastName);
		uiObjParam.Affinity_ProfilePerferredEmail = uiPropertiesReader.getAffinity_ProfilePerferredEmail();
		logger.info("uiObjParam.Affinity_ProfilePerferredEmail : " + uiObjParam.Affinity_ProfilePerferredEmail);
		uiObjParam.Affinity_ProfilePhone = uiPropertiesReader.getAffinity_ProfilePhone();
		logger.info("uiObjParam.Affinity_ProfilePhone : " + uiObjParam.Affinity_ProfilePhone);
		uiObjParam.Affinity_ProfileNext = uiPropertiesReader.getAffinity_ProfileNext();
		logger.info("uiObjParam.Affinity_ProfileNext : " + uiObjParam.Affinity_ProfileNext);
		uiObjParam.Affinity_CompanyProfileCompanyName = uiPropertiesReader.getAffinity_CompanyProfileCompanyName();
		logger.info("uiObjParam.Affinity_CompanyProfileCompanyName : " + uiObjParam.Affinity_CompanyProfileCompanyName);
		uiObjParam.Affinity_CompanyProfileAddress = uiPropertiesReader.getAffinity_CompanyProfileAddress();
		logger.info("uiObjParam.Affinity_CompanyProfileAddress : " + uiObjParam.Affinity_CompanyProfileAddress);
		uiObjParam.Affinity_CompanyProfilePhone = uiPropertiesReader.getAffinity_CompanyProfilePhone();
		logger.info("uiObjParam.Affinity_CompanyProfilePhone : " + uiObjParam.Affinity_CompanyProfilePhone);
		uiObjParam.Affinity_CompanyProfileNext = uiPropertiesReader.getAffinity_CompanyProfileNext();
		logger.info("uiObjParam.Affinity_CompanyProfileNext : " + uiObjParam.Affinity_CompanyProfileNext);
		uiObjParam.Affinity_InviteFirstName = uiPropertiesReader.getAffinity_InviteFirstName();
		logger.info("uiObjParam.Affinity_InviteFirstName : " + uiObjParam.Affinity_InviteFirstName);
		uiObjParam.Affinity_InviteLastName = uiPropertiesReader.getAffinity_InviteLastName();
		logger.info("uiObjParam.Affinity_InviteLastName : " + uiObjParam.Affinity_InviteLastName);
		uiObjParam.Affinity_InviteEmail = uiPropertiesReader.getAffinity_InviteEmail();
		logger.info("uiObjParam.Affinity_InviteEmail : " + uiObjParam.Affinity_InviteEmail);
		uiObjParam.Affinity_InvitePhone = uiPropertiesReader.getAffinity_InvitePhone();
		logger.info("uiObjParam.Affinity_InvitePhone : " + uiObjParam.Affinity_InvitePhone);
		uiObjParam.Affinity_InviteButton = uiPropertiesReader.getAffinity_InviteButton();
		logger.info("uiObjParam.Affinity_InviteButton : " + uiObjParam.Affinity_InviteButton);
		uiObjParam.Affinity_Profilelabel = uiPropertiesReader.getAffinity_Profilelabel();
		logger.info("uiObjParam.Affinity_Profilelabel : " + uiObjParam.Affinity_Profilelabel);
		uiObjParam.Affinity_CompanyProfilelabel = uiPropertiesReader.getAffinity_CompanyProfilelabel();
		logger.info("uiObjParam.Affinity_CompanyProfilelabel : " + uiObjParam.Affinity_CompanyProfilelabel);
		uiObjParam.Affinity_Invitelabel = uiPropertiesReader.getAffinity_Invitelabel();
		logger.info("uiObjParam.Affinity_Invitelabel : " + uiObjParam.Affinity_Invitelabel);
		uiObjParam.Refinance_pageLabel = uiPropertiesReader.getRefinance_pageLabel();
		logger.info("uiObjParam.Refinance_pageLabel : " + uiObjParam.Refinance_pageLabel);
		uiObjParam.Refinance_propertyTypeDropdown = uiPropertiesReader.getRefinance_propertyTypeDropdown();
		logger.info("uiObjParam.Refinance_propertyTypeDropdown : " + uiObjParam.Refinance_propertyTypeDropdown);
		uiObjParam.Refinance_numberOfUnitsDropdown = uiPropertiesReader.getRefinance_numberOfUnitsDropdown();
		logger.info("uiObjParam.Refinance_numberOfUnitsDropdown : " + uiObjParam.Refinance_numberOfUnitsDropdown);
		uiObjParam.RefinancePage_RefinanceLoanAmount = uiPropertiesReader.getRefinancePage_RefinanceLoanAmount();
		logger.info("uiObjParam.RefinancePage_RefinanceLoanAmount : " + uiObjParam.RefinancePage_RefinanceLoanAmount);
		uiObjParam.RefinancePage_1stLoanAmount = uiPropertiesReader.getRefinancePage_1stLoanAmount();
		logger.info("uiObjParam.RefinancePage_1stLoanAmount : " + uiObjParam.RefinancePage_1stLoanAmount);
		uiObjParam.RefinancePage_2ndLoanAmount = uiPropertiesReader.getRefinancePage_2ndLoanAmount();
		logger.info("uiObjParam.RefinancePage_2ndLoanAmount : " + uiObjParam.RefinancePage_2ndLoanAmount);
		uiObjParam.RefinancePage_OtherLoanAmount = uiPropertiesReader.getRefinancePage_OtherLoanAmount();
		logger.info("uiObjParam.RefinancePage_OtherLoanAmount : " + uiObjParam.RefinancePage_OtherLoanAmount);
		uiObjParam.RefinancePage_Iscashoutequality = uiPropertiesReader.getRefinancePage_Iscashoutequality();
		logger.info("uiObjParam.RefinancePage_Iscashoutequality : " + uiObjParam.RefinancePage_Iscashoutequality);
		uiObjParam.RefinancePage_IsNotcashoutequality = uiPropertiesReader.getRefinancePage_IsNotcashoutequality();
		logger.info("uiObjParam.RefinancePage_IsNotcashoutequality : " + uiObjParam.RefinancePage_IsNotcashoutequality);

	}

	public void setupDBParams() {

		logger.info("--------------- READING PORTAL PROPERTIES FILE ----------------");

		portalParam.ClientName = portalPropertiesReader.getClientName();
		logger.info("portalParam.ClientName :" + portalParam.ClientName);
		portalParam.lenderUrl = portalPropertiesReader.getLenderUrl();
		logger.info("portalParam.lenderUrl :" + portalParam.lenderUrl);
		portalParam.borrowerUrl = portalPropertiesReader.getBorrowerUrl();
		logger.info("portalParam.borrowerUrl :" + portalParam.borrowerUrl);
		portalParam.custom_report_location = portalPropertiesReader.getCustom_report_location();
		logger.info("portalParam.custom_report_location :" + portalParam.custom_report_location);
		portalParam.upload_file_location = portalPropertiesReader.getUpload_file_location();
		logger.info("portalParam.upload_file_location :" + portalParam.upload_file_location);
		portalParam.browser = portalPropertiesReader.getBrowser();
		logger.info("portalParam.browser :" + portalParam.browser);
		portalParam.lenderUsername = portalPropertiesReader.getLenderUserName();
		logger.info("portalParam.lenderUsername :" + portalParam.lenderUsername);
		portalParam.lenderPassword = portalPropertiesReader.getLenderPassword();
		logger.info("portalParam.lenderPassword :" + portalParam.lenderPassword);
		portalParam.testdataSourceName = portalPropertiesReader.getTestdataSourceName();
		logger.info("portalParam.testdataSourceName :" + portalParam.testdataSourceName);
		portalParam.mongoDbUser = portalPropertiesReader.getMongoDbUser();
		logger.info("portalParam.mongoDbUser :" + portalParam.mongoDbUser);
		portalParam.mongoDb = portalPropertiesReader.getMongoDb();
		logger.info("portalParam.mongoDb :" + portalParam.mongoDb);
		portalParam.mongoHost = portalPropertiesReader.getMongoHost();
		logger.info("portalParam.mongoHost :" + portalParam.mongoHost);
		portalParam.mongoPort = Integer.parseInt(portalPropertiesReader.getMongoPort());
		logger.info("portalParam.mongoPort :" + portalParam.mongoPort);
		portalParam.mongoDbPwd = portalPropertiesReader.getMongoDbPwd();
		logger.info("portalParam.mongoDbPwd :" + portalParam.mongoDbPwd);
		portalParam.plaidUsername = portalPropertiesReader.getPlaidUsername();
		logger.info("portalParam.plaidUsername :" + portalParam.plaidUsername);
		portalParam.plaidPassword = portalPropertiesReader.getPlaidPassword();
		logger.info("portalParam.plaidPassword :" + portalParam.plaidPassword);
		portalParam.Pictures = portalPropertiesReader.getLinux_pictures();
		logger.info("portalParam.Pictures :" + portalParam.Pictures);
		portalParam.Open = portalPropertiesReader.getLinux_open();
		logger.info("portalParam.Open :" + portalParam.Open);
		portalParam.Platform = portalPropertiesReader.getPlatform();
		logger.info("portalParam.Platform :" + portalParam.Platform);
	}

	private void setupJetty(final String contextRoot, Server server) throws Exception {
		final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(ApiConfig.class, PortalConfig.class);
		// applicationContext.register(SmppConfig.class);
		final ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(applicationContext));
		final ServletContextHandler context = new ServletContextHandler();
		context.setErrorHandler(null);
		context.setContextPath("/" + contextRoot);
		context.addServlet(servletHolder, "/*");

		server.setHandler(context);
		server.start();
	}

	@Test(groups = { "Result", "", "" }, description = "Results file creation")
	public static void AAResultsBackUp() throws Exception {
		System.out.println("*****Begining of ResultsBackUp *********************");

		try {
			TestResults.CreateResultTxt();
			// TestResults.ExportResultToTxt("Portal Url:=",GlobalVariables.portalUrl);
			Assert.assertTrue(true, "ResultsBackUp test case has been Passed.");
			System.out.println("*****Ending of ResultsBackUp *********************");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception happened in executing test case ResultsBackUp");
			fail("ResultsBackUp test case has been failed.");
		}
	}

	protected void initializeData(String FuncMod, String Test_ID) throws Exception {

		try {

			logger.info("Reading test data from " + FuncMod + " worksheet.");
			logger.info("-----------------------------------------------");

			if (FuncMod.equalsIgnoreCase("Purchase") || FuncMod.equalsIgnoreCase("Refinance")) {
				portalParam.testId = portalFuncUtils.getTestData(FuncMod, Test_ID, "Test_ID");
				logger.info("portalParam.testId: " + portalParam.testId);
				portalParam.borrowerFirstname = portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerFirstname");
				logger.info("portalParam.borrowerFirstname: " + portalParam.borrowerFirstname);
				portalParam.borrowerlastname = portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerlastname");
				logger.info("portalParam.borrowerlastname: " + portalParam.borrowerlastname);
				portalParam.borrowerPhone = portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerPhone");
				logger.info("portalParam.borrowerPhone: " + portalParam.borrowerPhone);
				portalParam.inviteUserType = portalFuncUtils.getTestData(FuncMod, Test_ID, "inviteUserType");
				logger.info("portalParam.inviteUserType: " + portalParam.inviteUserType);
				portalParam.loanType = portalFuncUtils.getTestData(FuncMod, Test_ID, "loanType");
				logger.info("portalParam.loanType: " + portalParam.loanType);
				portalParam.modeOfCommunication = portalFuncUtils.getTestData(FuncMod, Test_ID, "modeOfCommunication");
				logger.info("portalParam.modeOfCommunication: " + portalParam.modeOfCommunication);
				portalParam.propertyType = portalFuncUtils.getTestData(FuncMod, Test_ID, "propertyType");
				logger.info("portalParam.propertyType: " + portalParam.propertyType);
				portalParam.realEstatepropertyType = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"realEstatepropertyType");
				logger.info("portalParam.realEstatepropertyType: " + portalParam.realEstatepropertyType);
				portalParam.propertyTypeUnits = portalFuncUtils.getTestData(FuncMod, Test_ID, "propertyTypeUnits");
				logger.info("portalParam.propertyTypeUnits: " + portalParam.propertyTypeUnits);
				portalParam.numberOfUnits = portalFuncUtils.getTestData(FuncMod, Test_ID, "numberOfUnits");
				logger.info("portalParam.numberOfUnits: " + portalParam.numberOfUnits);
				portalParam.isProperty = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "isProperty"));
				logger.info("portalParam.isProperty: " + portalParam.isProperty);
				portalParam.isContract = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "isContract"));
				logger.info("portalParam.isContract: " + portalParam.isContract);
				portalParam.propertyUse = portalFuncUtils.getTestData(FuncMod, Test_ID, "propertyUse");
				logger.info("portalParam.propertyUse: " + portalParam.propertyUse);
				portalParam.firstAddress = portalFuncUtils.getTestData(FuncMod, Test_ID, "firstAddress");
				logger.info("portalParam.firstAddress: " + portalParam.firstAddress);
				portalParam.expectedMonthlyRentalIncome = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"expectedMonthlyRentalIncome");
				logger.info("portalParam.expectedMonthlyRentalIncome: " + portalParam.expectedMonthlyRentalIncome);
				portalParam.purchasePrice = portalFuncUtils.getTestData(FuncMod, Test_ID, "purchasePrice");
				logger.info("portalParam.purchasePrice: " + portalParam.purchasePrice);
				portalParam.downPayment = portalFuncUtils.getTestData(FuncMod, Test_ID, "downPayment");
				logger.info("portalParam.downPayment: " + portalParam.downPayment);
				portalParam.married = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "married"));
				logger.info("portalParam.married: " + portalParam.married);
				portalParam.creditType = portalFuncUtils.getTestData(FuncMod, Test_ID, "creditType");
				logger.info("portalParam.creditType: " + portalParam.creditType);
				portalParam.spouceFirstName = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouceFirstName");
				logger.info("portalParam.spouceFirstName: " + portalParam.spouceFirstName);
				portalParam.spouceMiddleName = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseMiddleName");
				logger.info("portalParam.spouceMiddleName: " + portalParam.spouceMiddleName);
				portalParam.spouceLastName = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouceLastName");
				logger.info("portalParam.spouceLastName: " + portalParam.spouceLastName);
				portalParam.spouceSuffix = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseSuffix");
				logger.info("portalParam.spouceSuffix: " + portalParam.spouceSuffix);
				portalParam.spouseDoB = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseDoB");
				logger.info("portalParam.spouseDoB: " + portalParam.spouseDoB);
				portalParam.spouseSsn = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseSsn");
				logger.info("portalParam.spouseSsn: " + portalParam.spouseSsn);
				portalParam.spoucePhone = portalFuncUtils.getTestData(FuncMod, Test_ID, "spoucePhone");
				logger.info("portalParam.spoucePhone: " + portalParam.spoucePhone);
				portalParam.spouceComm = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouceComm");
				logger.info("portalParam.spouceComm: " + portalParam.spouceComm);
				portalParam.nonSpouseFirstName = portalFuncUtils.getTestData(FuncMod, Test_ID, "nonSpouseFirstName");
				logger.info("portalParam.nonSpouseFirstName: " + portalParam.nonSpouseFirstName);
				portalParam.nonSpouseMiddleName = portalFuncUtils.getTestData(FuncMod, Test_ID, "nonSpouseMiddleName");
				logger.info("portalParam.nonSpouseMiddleName: " + portalParam.nonSpouseMiddleName);
				portalParam.nonSpouseLastName = portalFuncUtils.getTestData(FuncMod, Test_ID, "nonSpouseLastName");
				logger.info("portalParam.nonSpouseLastName: " + portalParam.nonSpouseLastName);
				portalParam.nonSpouseSuffix = portalFuncUtils.getTestData(FuncMod, Test_ID, "nonSpouseSuffix");
				logger.info("portalParam.nonSpouseSuffix: " + portalParam.nonSpouseSuffix);
				portalParam.nonSpousePhone = portalFuncUtils.getTestData(FuncMod, Test_ID, "nonSpousePhone");
				logger.info("portalParam.nonSpousePhone: " + portalParam.nonSpousePhone);
				portalParam.eligibleLoan = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "eligibleLoan"));
				logger.info("portalParam.eligibleLoan: " + portalParam.eligibleLoan);
				portalParam.currentLoanEligibilitySatus = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"currentLoanEligibilitySatus");
				logger.info("portalParam.currentLoanEligibilitySatus: " + portalParam.currentLoanEligibilitySatus);
				portalParam.childCareAmount = portalFuncUtils.getTestData(FuncMod, Test_ID, "childCareAmount");
				logger.info("portalParam.childCareAmount: " + portalParam.childCareAmount);
				portalParam.childCareExpense = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "childCareExpense"));
				logger.info("portalParam.childCareExpense: " + portalParam.childCareExpense);
				portalParam.currentLoan = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "currentLoan"));
				logger.info("portalParam.currentLoan: " + portalParam.currentLoan);
				portalParam.realEstateAgent = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "realEstateAgent"));
				logger.info("portalParam.realEstateAgent: " + portalParam.realEstateAgent);
				portalParam.referAgent = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "referAgent"));
				logger.info("portalParam.realEstateAgent: " + portalParam.referAgent);
				portalParam.sameResidence = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "sameResidence"));
				logger.info("portalParam.sameResidence: " + portalParam.sameResidence);
				portalParam.residenceStatus = portalFuncUtils.getTestData(FuncMod, Test_ID, "residenceStatus");
				logger.info("portalParam.residenceStatus: " + portalParam.residenceStatus);
				portalParam.currentAddress = portalFuncUtils.getTestData(FuncMod, Test_ID, "currentAddress");
				logger.info("portalParam.currentAddress: " + portalParam.currentAddress);
				portalParam.stayingSince = portalFuncUtils.getTestData(FuncMod, Test_ID, "stayingSince");
				logger.info("portalParam.stayingSince: " + portalParam.stayingSince);
				portalParam.planningToSale = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "planningToSale"));
				logger.info("portalParam.planningToSale: " + portalParam.planningToSale);
				portalParam.additionalProperty = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "additionalProperty"));
				logger.info("portalParam.additionalProperty: " + portalParam.additionalProperty);
				portalParam.propertyAddress = portalFuncUtils.getTestData(FuncMod, Test_ID, "propertyAddress");
				logger.info("portalParam.propertyAddress: " + portalParam.propertyAddress);
				portalParam.propertyStatus = portalFuncUtils.getTestData(FuncMod, Test_ID, "propertyStatus");
				logger.info("portalParam.propertyStatus: " + portalParam.propertyStatus);
				portalParam.propertyValue = portalFuncUtils.getTestData(FuncMod, Test_ID, "propertyValue");
				logger.info("portalParam.propertyValue: " + portalParam.propertyValue);
				portalParam.rentalIncome = portalFuncUtils.getTestData(FuncMod, Test_ID, "rentalIncome");
				logger.info("portalParam.rentalIncome: " + portalParam.rentalIncome);
				portalParam.expenses = portalFuncUtils.getTestData(FuncMod, Test_ID, "expenses");
				logger.info("portalParam.expenses: " + portalParam.expenses);
				portalParam.institutionName = portalFuncUtils.getTestData(FuncMod, Test_ID, "institutionName");
				logger.info("portalParam.institutionName: " + portalParam.institutionName);
				portalParam.accountType = portalFuncUtils.getTestData(FuncMod, Test_ID, "accountType");
				logger.info("portalParam.accountType: " + portalParam.accountType);
				portalParam.currentBalance = portalFuncUtils.getTestData(FuncMod, Test_ID, "currentBalance");
				logger.info("portalParam.currentBalance: " + portalParam.currentBalance);
				portalParam.accountNumber = portalFuncUtils.getTestData(FuncMod, Test_ID, "accountNumber");
				logger.info("portalParam.accountNumber: " + portalParam.accountNumber);
				portalParam.accountName = portalFuncUtils.getTestData(FuncMod, Test_ID, "accountName");
				logger.info("portalParam.accountName: " + portalParam.accountName);
				portalParam.borrowerBank = portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerBank");
				logger.info("portalParam.borrowerBank: " + portalParam.borrowerBank);
				portalParam.spouseBank = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseBank");
				logger.info("portalParam.spouseBank: " + portalParam.spouseBank);
				portalParam.spouseInstitutionName = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"spouseInstitutionName");
				logger.info("pogetSummaryrtalParam.spouseInstitutionName: " + portalParam.spouseInstitutionName);
				portalParam.spouseAccountType = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseAccountType");
				logger.info("portalParam.spouseAccountType: " + portalParam.spouseAccountType);
				portalParam.spouseCurrentBalance = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"spouseCurrentBalance");
				logger.info("portalParam.spouseCurrentBalance: " + portalParam.spouseCurrentBalance);
				portalParam.spouseAccountNumber = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseAccountNumber");
				logger.info("portalParam.spouseAccountNumber: " + portalParam.spouseAccountNumber);
				portalParam.spouseAccountName = portalFuncUtils.getTestData(FuncMod, Test_ID, "spouseAccountName");
				logger.info("portalParam.spouseAccountName: " + portalParam.spouseAccountName);
				portalParam.dateOfBirth = portalFuncUtils.getTestData(FuncMod, Test_ID, "dateOfBirth");
				logger.info("portalParam.dateOfBirth: " + portalParam.dateOfBirth);
				portalParam.ssnNumber = portalFuncUtils.getTestData(FuncMod, Test_ID, "ssnNumber");
				logger.info("portalParam.ssnNumber: " + portalParam.ssnNumber);
				portalParam.borrowerCurrentEmployer = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerCurrentEmployer");
				logger.info("portalParam.borrowerCurrentEmployer: " + portalParam.borrowerCurrentEmployer);
				portalParam.borrowerTitle = portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerTitle");
				logger.info("portalParam.borrowerTitle: " + portalParam.borrowerTitle);
				portalParam.borrowerEmploymentStartDate = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerEmploymentStartDate");
				logger.info("portalParam.borrowerEmploymentStartDate: " + portalParam.borrowerEmploymentStartDate);
				portalParam.borrowerInThisLineYear = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerInThisLineYear");
				logger.info("portalParam.borrowerInThisLineYear: " + portalParam.borrowerInThisLineYear);
				portalParam.borrowerInThisLineMonth = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerInThisLineMonth");
				logger.info("portalParam.borrowerInThisLineMonth: " + portalParam.borrowerInThisLineMonth);
				portalParam.borrowerMonthlyBaseSalary = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerMonthlyBaseSalary");
				logger.info("portalParam.borrowerMonthlyBaseSalary: " + portalParam.borrowerMonthlyBaseSalary);
				portalParam.borrowerBonusAmount = portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerBonusAmount");
				logger.info("portalParam.borrowerBonusAmount: " + portalParam.borrowerBonusAmount);
				portalParam.borrowerBusinessAddress = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerBusinessAddress");
				logger.info("portalParam.borrowerBusinessAddress: " + portalParam.borrowerBusinessAddress);
				portalParam.borrowerBusinessPhone = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerBusinessPhone");
				logger.info("portalParam.borrowerBusinessPhone: " + portalParam.borrowerBusinessPhone);
				portalParam.borrowerMonthlyAlimony = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerMonthlyAlimony");
				logger.info("portalParam.borrowerMonthlyAlimony: " + portalParam.borrowerMonthlyAlimony);
				portalParam.borrowerAlimonyStartDate = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerAlimonyStartDate");
				logger.info("portalParam.borrowerAlimonyStartDate: " + portalParam.borrowerAlimonyStartDate);
				portalParam.borrowerMonthlyChildSupport = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerMonthlyChildSupport");
				logger.info("portalParam.borrowerMonthlyChildSupport: " + portalParam.borrowerMonthlyChildSupport);
				portalParam.borrowerSupportChildName = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerSupportChildName");
				logger.info("portalParam.borrowerSupportChildName: " + portalParam.borrowerSupportChildName);
				portalParam.borrowerSupportChildDoB = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"borrowerSupportChildDoB");
				logger.info("portalParam.borrowerSupportChildDoB: " + portalParam.borrowerSupportChildDoB);
				portalParam.borrowerSupportByCourt = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerSupportByCourt"));
				logger.info("portalParam.borrowerSupportByCourt: " + portalParam.borrowerSupportByCourt);
				portalParam.borrowerWillReceiveOrderByCourt = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerWillReceiveOrderByCourt"));
				logger.info(
						"portalParam.borrowerWillReceiveOrderByCourt: " + portalParam.borrowerWillReceiveOrderByCourt);
				portalParam.borrowerTwoMonthSupport = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "borrowerTwoMonthSupport"));
				logger.info("portalParam.borrowerTwoMonthSupport: " + portalParam.borrowerTwoMonthSupport);
				portalParam.selfEmploymentMonthlyIncome = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"selfEmploymentMonthlyIncome");
				logger.info("portalParam.selfEmploymentMonthlyIncome: " + portalParam.selfEmploymentMonthlyIncome);
				portalParam.percentageOwnership = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "percentageOwnership"));
				logger.info("portalParam.percentageOwnership: " + portalParam.percentageOwnership);
				portalParam.selfEmploymentCompanyName = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"selfEmploymentCompanyName");
				logger.info("portalParam.selfEmploymentCompanyName: " + portalParam.selfEmploymentCompanyName);
				portalParam.selfEmploymentTitle = portalFuncUtils.getTestData(FuncMod, Test_ID, "selfEmploymentTitle");
				logger.info("portalParam.selfEmploymentTitle: " + portalParam.selfEmploymentTitle);
				portalParam.selfEmploymentBusinessAddress = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"selfEmploymentBusinessAddress");
				logger.info("portalParam.selfEmploymentBusinessAddress: " + portalParam.selfEmploymentBusinessAddress);
				portalParam.selfEmploymentBusinessPhone = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"selfEmploymentBusinessPhone");
				logger.info("portalParam.selfEmploymentBusinessPhone: " + portalParam.selfEmploymentBusinessPhone);
				portalParam.selfEmploymentBusinessStartDate = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"selfEmploymentBusinessStartDate");
				logger.info(
						"portalParam.selfEmploymentBusinessStartDate: " + portalParam.selfEmploymentBusinessStartDate);
				portalParam.typeOfCompany = portalFuncUtils.getTestData(FuncMod, Test_ID, "typeOfCompany");
				logger.info("portalParam.typeOfCompany: " + portalParam.typeOfCompany);
				portalParam.monthlyMilitoryPay = portalFuncUtils.getTestData(FuncMod, Test_ID, "monthlyMilitoryPay");
				logger.info("portalParam.monthlyMilitoryPay: " + portalParam.monthlyMilitoryPay);
				portalParam.monthlyRentalIncome = portalFuncUtils.getTestData(FuncMod, Test_ID, "monthlyRentalIncome");
				logger.info("portalParam.monthlyRentalIncome: " + portalParam.monthlyRentalIncome);
				portalParam.rentalPropertyAddress = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"rentalPropertyAddress");
				logger.info("portalParam.rentalPropertyAddress: " + portalParam.rentalPropertyAddress);
				portalParam.rentalPropertyType = portalFuncUtils.getTestData(FuncMod, Test_ID, "rentalPropertyType");
				logger.info("portalParam.rentalPropertyType: " + portalParam.rentalPropertyType);
				portalParam.rentalPropertyUnits = portalFuncUtils.getTestData(FuncMod, Test_ID, "rentalPropertyUnits");
				logger.info("portalParam.rentalPropertyUnits: " + portalParam.rentalPropertyUnits);
				portalParam.rentalPropertyStatus = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"rentalPropertyStatus");
				logger.info("portalParam.rentalPropertyStatus: " + portalParam.rentalPropertyStatus);
				portalParam.rentalPropertyUse = portalFuncUtils.getTestData(FuncMod, Test_ID, "rentalPropertyUse");
				logger.info("portalParam.rentalPropertyUse: " + portalParam.rentalPropertyUse);
				portalParam.rentalPropertyValue = portalFuncUtils.getTestData(FuncMod, Test_ID, "rentalPropertyValue");
				logger.info("portalParam.rentalPropertyValue: " + portalParam.rentalPropertyValue);
				portalParam.rentalPropertyMonthlyRentalIncome = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"rentalPropertyMonthlyRentalIncome");
				logger.info("portalParam.rentalPropertyMonthlyRentalIncome: "
						+ portalParam.rentalPropertyMonthlyRentalIncome);
				portalParam.monthlyRentalAdditionalExpense = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"monthlyRentalAdditionalExpense");
				logger.info(
						"portalParam.monthlyRentalAdditionalExpense: " + portalParam.monthlyRentalAdditionalExpense);
				portalParam.socialSecurityIncome = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"socialSecurityIncome");
				logger.info("portalParam.socialSecurityIncome: " + portalParam.socialSecurityIncome);
				portalParam.interestLastYear = portalFuncUtils.getTestData(FuncMod, Test_ID, "interestLastYear");
				logger.info("portalParam.interestLastYear: " + portalParam.interestLastYear);
				portalParam.interestPreviousYear = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"interestPreviousYear");
				logger.info("portalParam.interestPreviousYear: " + portalParam.interestPreviousYear);
				portalParam.otherIncomePerMonth = portalFuncUtils.getTestData(FuncMod, Test_ID, "otherIncomePerMonth");
				logger.info("portalParam.otherIncomePerMonth: " + portalParam.otherIncomePerMonth);
				portalParam.sourceOfIncome = portalFuncUtils.getTestData(FuncMod, Test_ID, "sourceOfIncome");
				logger.info("portalParam.sourceOfIncome: " + portalParam.sourceOfIncome);
				portalParam.continuousIncome = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "continuousIncome"));
				logger.info("portalParam.continuousIncome: " + portalParam.continuousIncome);
				portalParam.EliglibleForMilitary = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "EliglibleForMilitary"));
				logger.info("portalParam.EliglibleForMilitary: " + portalParam.EliglibleForMilitary);
				portalParam.MilitaryDuty = portalFuncUtils.getTestData(FuncMod, Test_ID, "MilitaryDuty");
				logger.info("portalParam.MilitaryDuty: " + portalParam.MilitaryDuty);
				portalParam.MilitaryActiveDate = portalFuncUtils.getTestData(FuncMod, Test_ID, "MilitaryActiveDate");
				logger.info("portalParam.MilitaryActiveDate: " + portalParam.MilitaryActiveDate);
				portalParam.ActiveMilitaryLoan = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "ActiveMilitaryLoan"));
				logger.info("portalParam.ActiveMilitaryLoan: " + portalParam.ActiveMilitaryLoan);
				portalParam.ChildCareExpenses = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "ChildCareExpenses"));
				logger.info("portalParam.ChildCareExpenses: " + portalParam.ChildCareExpenses);
				portalParam.ChildCareExpense = portalFuncUtils.getTestData(FuncMod, Test_ID, "ChildCareExpense");
				logger.info("portalParam.ChildCareExpense: " + portalParam.ChildCareExpense);
				portalParam.SpouseAsCoBorrower = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "SpouseAsCoBorrower"));
				logger.info("portalParam.SpouseAsCoBorrower: " + portalParam.SpouseAsCoBorrower);
				portalParam.AddAnotherCoBorrower = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "AddAnotherCoBorrower"));
				logger.info("portalParam.AddAnotherCoBorrower: " + portalParam.AddAnotherCoBorrower);
				portalParam.Judgments = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "Judgments"));
				logger.info("portalParam.Judgments: " + portalParam.Judgments);
				portalParam.Bankrupt = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "Bankrupt"));
				logger.info("portalParam.Bankrupt: " + portalParam.Bankrupt);
				portalParam.ForeClosure = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "ForeClosure"));
				logger.info("portalParam.ForeClosure: " + portalParam.ForeClosure);
				portalParam.LawSuiteProperty = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "LawSuiteProperty"));
				logger.info("portalParam.LawSuiteProperty: " + portalParam.LawSuiteProperty);
				portalParam.ObligatedProperty = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "ObligatedProperty"));
				logger.info("portalParam.ObligatedProperty: " + portalParam.ObligatedProperty);
				portalParam.Deliquent = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "Deliquent"));
				logger.info("portalParam.Deliquent: " + portalParam.Deliquent);
				portalParam.ObligatedAlimony = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "ObligatedAlimony"));
				logger.info("portalParam.ObligatedAlimony: " + portalParam.ObligatedAlimony);
				portalParam.DownPaymentBorrowed = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "DownPaymentBorrowed"));
				logger.info("portalParam.DownPaymentBorrowed: " + portalParam.DownPaymentBorrowed);
				portalParam.CoMaker = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "CoMaker"));
				logger.info("portalParam.CoMaker: " + portalParam.CoMaker);
				portalParam.USCitizen = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "USCitizen"));
				logger.info("portalParam.USCitizen: " + portalParam.USCitizen);
				portalParam.ResidentAlien = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "ResidentAlien"));
				logger.info("portalParam.ResidentAlien: " + portalParam.ResidentAlien);
				portalParam.PrimaryResidence = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "PrimaryResidence"));
				logger.info("portalParam.PrimaryResidence: " + portalParam.PrimaryResidence);
				portalParam.Ownership = Integer.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "Ownership"));
				logger.info("portalParam.Ownership: " + portalParam.Ownership);
				portalParam.JudgmentsComments = portalFuncUtils.getTestData(FuncMod, Test_ID, "JudgmentsComments");
				logger.info("portalParam.JudgmentsComments: " + portalParam.JudgmentsComments);
				portalParam.BankruptComments = portalFuncUtils.getTestData(FuncMod, Test_ID, "BankruptComments");
				logger.info("portalParam.BankruptComments: " + portalParam.BankruptComments);
				portalParam.ForeClosureComments = portalFuncUtils.getTestData(FuncMod, Test_ID, "ForeClosureComments");
				logger.info("portalParam.ForeClosureComments: " + portalParam.ForeClosureComments);
				portalParam.LawSuitePropertyComments = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"LawSuitePropertyComments");
				logger.info("portalParam.LawSuitePropertyComments: " + portalParam.LawSuitePropertyComments);
				portalParam.ObligatedPropertyComments = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"ObligatedPropertyComments");
				logger.info("portalParam.ObligatedPropertyComments: " + portalParam.ObligatedPropertyComments);
				portalParam.DeliquentComments = portalFuncUtils.getTestData(FuncMod, Test_ID, "DeliquentComments");
				logger.info("portalParam.DeliquentComments: " + portalParam.DeliquentComments);
				portalParam.ObligatedAlimonyComments = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"ObligatedAlimonyComments");
				logger.info("portalParam.ObligatedAlimonyComments: " + portalParam.ObligatedAlimonyComments);
				portalParam.DownPaymentBorrowedComments = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"DownPaymentBorrowedComments");
				logger.info("portalParam.DownPaymentBorrowedComments: " + portalParam.DownPaymentBorrowedComments);
				portalParam.CoMakerComments = portalFuncUtils.getTestData(FuncMod, Test_ID, "CoMakerComments");
				logger.info("portalParam.CoMakerComments: " + portalParam.CoMakerComments);
				portalParam.OwnershipTypeOfProperty = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"OwnershipTypeOfProperty");
				logger.info("portalParam.OwnershipTypeOfProperty: " + portalParam.OwnershipTypeOfProperty);
				portalParam.OwnershipTitleToHome = portalFuncUtils.getTestData(FuncMod, Test_ID,
						"OwnershipTitleToHome");
				logger.info("portalParam.OwnershipTitleToHome: " + portalParam.OwnershipTitleToHome);
				portalParam.LoanOfficer = Integer
						.parseInt(portalFuncUtils.getTestData(FuncMod, Test_ID, "LoanOfficer"));
				logger.info("portalParam.LoanOfficer: " + portalParam.LoanOfficer);
				portalParam.LoanOfficerName = portalFuncUtils.getTestData(FuncMod, Test_ID, "LoanOfficerName");
				logger.info("portalParam.LoanOfficerName: " + portalParam.LoanOfficerName);

				portalParam.CoborrowerFirstName = portalFuncUtils.getTestData(FuncMod, Test_ID, "CoborrowerFirstName");
				logger.info("portalParam.CoborrowerFirstName: " + portalParam.CoborrowerFirstName);

				portalParam.CoborrowerLastName = portalFuncUtils.getTestData(FuncMod, Test_ID, "CoborrowerLastName");
				logger.info("portalParam.CoborrowerLastName: " + portalParam.CoborrowerLastName);

				portalParam.SpouseDeclarion = 0;
				logger.info("portalParam.SpouseDeclarion: " + portalParam.SpouseDeclarion);
				portalParam.CoborSpouseDeclaration = 0;
				logger.info("portalParam.CoborSpouseDeclaration: " + portalParam.CoborSpouseDeclaration);
			}
			logger.info("-----------------------------------------------");
		} catch (Exception e) {
			logger.info("    *****    Field not present in \"" + FuncMod + "\" worksheet.");
		}
	}

	public void writeToReport(String funcMod, String sTestID, String result) throws Exception {

		String base64String = null;
		JSONObject obj = new JSONObject();
		obj.put("name", sTestID);
		obj.put("status", result);
		try {
			if ((funcMod.contains("Purchase")) && (result.equalsIgnoreCase("Failed"))) {
				// File file = new
				// File(System.getProperty("user.dir")+"\\src\\test\\resources\\images\\"+sTestID+".png");
				File file = new File(
						portalParam.custom_report_location + sTestID + "_" + portalParam.loanType + ".png");
				System.out.println(file.exists());
				byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
				base64String = new String(encoded, StandardCharsets.US_ASCII);
				obj.put("screenshot", "data:image/png;base64," + base64String);
			}

			if ((funcMod.contains("Refinance")) && (result.equalsIgnoreCase("Failed"))) {
				// File file = new

				// File(System.getProperty("user.dir")+"\\src\\test\\resources\\images\\"+sTestID+".png");
				File file = new File(
						portalParam.custom_report_location + sTestID + "_" + portalParam.loanType + ".png");
				System.out.println(file.exists());
				byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
				base64String = new String(encoded, StandardCharsets.US_ASCII);
				obj.put("screenshot", "data:image/png;base64," + base64String);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		try {
			if ((funcMod.contains("Purchase"))) {
				File file = new File(PortalParam.custom_report_location + "Purchase.json");
				ifFileExist = file.createNewFile();
				if (ifFileExist) {
					FileWriter f = new FileWriter(file);
					f.write("cases : [" + obj.toString());
					f.flush();
					f.close();
				} else {
					FileWriter f = new FileWriter(file, true);
					f.write("," + obj.toString());
					f.flush();
					f.close();
				}
			}
			if ((funcMod.contains("Refinance"))) {
				File file = new File(PortalParam.custom_report_location + "Refinance.json");
				ifFileExist = file.createNewFile();
				if (ifFileExist) {
					FileWriter f = new FileWriter(file);
					f.write("cases : [" + obj.toString());
					f.flush();
					f.close();
				} else {
					FileWriter f = new FileWriter(file, true);
					f.write("," + obj.toString());
					f.flush();
					f.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod(groups = { "PurchaseTests", "PortalTests", "RefinanceTests", "LenderBorrowerIndividualCreditFlow",
			"LenderAffinityBorrowerNonSpouseAddedCoborrowerFlow", "CoborrwerAddedSpouseLoginCompleteApplication",
			"LenderBorrowerCoborrwerAddedSpouseFlow", "BorrowerInviteSpouseLoginAndCompleteApplication",
			"DirectSignUpBorrowerSpouseNoAdditionalCoborrowerFlow", "LenderBorrowerSpouseAddedCoborrowerFlow",
			"LenderBorrowerCoborrwerMarriedSeparatedFlow", "LenderBorrowerMarriedSeparatedAddedCoborrowerFlow",
			"DirectSignUpBorrowerCoborrwerNonSpouseFlow", "DirectSignupBorrowerIndividualFlow",
			"DirectSignupBorrowerCoborrowerFlow", "DirectSignUpBorrowerCoborrwerUnmarriedFlow",
			"LenderBorrowerNonSpouseAddedCoborrowerIndividualCreditFlow", "LenderBorrowerNonSpouseAddedCoborrowerFlow",
			"BorrowerSpouseAddedCoborrowerFlow", "CoborrwerSpouseAddAnotherCoborrwer",
			"LenderBorrowerCoborrwerNonSpouseFlow", "Sanity" })
	@Parameters("browser")
	public void setUp() throws Exception {
		// String ibrowser = GlobalVariables.browser;

		browser_list browser = browser_list.valueOf(portalPropertiesReader.getBrowser());
		System.out.println();
		String nodeUrl;
		switch (browser) {

		case IE:

			// IEDriverServer available @
			// http://code.google.com/p/selenium/downloads/list
			System.setProperty("webdriver.ie.driver", "./webdriver/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(capabilities);
			driver.get(portalPropertiesReader.getLenderUrl());
			break;

		case Chrome:
			// chromedriver available @http://code.google.com/p/chromedriver/downloads/list
			String ChromeDriver = "chromedriver.exe";
			if (portalPropertiesReader.getPlatform().equals("linux")) {
				ChromeDriver = "chromedriver";
			}
			String ChromePath = "./webdriver/" + ChromeDriver;
			System.setProperty("webdriver.chrome.driver", "./webdriver/" + ChromeDriver);
			System.setProperty("java.awt.headless", "false");

			server = new BrowserMobProxyServer();
			server.start();
			Proxy proxy = ClientUtil.createSeleniumProxy(server);
			Thread.sleep(10000);
			server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
			driver = createProxyDriver("chrome", proxy, ChromePath);
			driver.get(portalPropertiesReader.getLenderUrl());
			server.newHar(portalPropertiesReader.getLenderUrl());
			break;

		case FF:
			System.setProperty("webdriver.gecko.driver", "./webdriver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(portalPropertiesReader.getLenderUrl());
		}

		Thread.sleep(profile_delay);
		driver.manage().timeouts().implicitlyWait(ShortSleep, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Loading url :" + portalPropertiesReader.getLenderUrl());

	}

	@AfterMethod(groups = { "PurchaseTests", "PortalTests", "RefinanceTests", "LenderBorrowerIndividualCreditFlow",
			"LenderAffinityBorrowerNonSpouseAddedCoborrowerFlow", "CoborrwerAddedSpouseLoginCompleteApplication",
			"LenderBorrowerCoborrwerAddedSpouseFlow", "BorrowerInviteSpouseLoginAndCompleteApplication",
			"DirectSignUpBorrowerSpouseNoAdditionalCoborrowerFlow", "LenderBorrowerSpouseAddedCoborrowerFlow",
			"LenderBorrowerCoborrwerMarriedSeparatedFlow", "LenderBorrowerMarriedSeparatedAddedCoborrowerFlow",
			"DirectSignUpBorrowerCoborrwerUnmarriedFlow", "DirectSignUpBorrowerCoborrwerNonSpouseFlow",
			"DirectSignupBorrowerIndividualFlow", "LenderBorrowerNonSpouseAddedCoborrowerFlow",
			"BorrowerSpouseAddedCoborrowerFlow", "LenderBorrowerNonSpouseAddedCoborrowerIndividualCreditFlow",
			"CoborrwerSpouseAddAnotherCoborrwer", "LenderBorrowerCoborrwerNonSpouseFlow", "Sanity",
			"DirectSignupBorrowerCoborrowerFlow" })
	public void quit() throws IOException {

		// String absoluteFilePath = "./ConsoleErrors/" + portalParam.testId + "_" +
		// portalParam.loanType + ".txt";
		// File file = new File(absoluteFilePath);
		// file.createNewFile();
		conerror.ConsoleError(portalParam.testId + portalParam.loanType);
		logger.info("TestName... " + portalParam.testId);
		Har har = server.getHar();
		String harlocation = "./har/" + portalParam.testId + "_" + portalParam.loanType + ".har";
		File harFile = new File(harlocation);
		har.writeTo(harFile);
		driver.quit();
	}

	/**
	 * Waits for the expected condition to complete
	 *
	 * @param e       the expected condition to wait until it becomes true
	 * @param timeout how long to wait for the expected condition to turn true
	 * @return true if the expected condition returned true and false if not
	 */
	public boolean waitForCondition(ExpectedCondition<Boolean> e, int timeout) {
		WebDriverWait w = new WebDriverWait(driver, timeout);
		boolean returnValue = true;
		try {
			w.until(e);
		} catch (TimeoutException te) {
			logger.error("Failed to find the expected condition", te);
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * Wait for the element to disappear from the screen
	 *
	 * @param finder  the element to wait to disappear
	 * @param timeout how long to wait for the item to disappear (in seconds)
	 * @return true if the element disappeared and false if it did not
	 */
	protected boolean waitForElementRemoval(final By finder, int timeout) {
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElements(finder).size() == 0;
			}
		};
		boolean returnValue = waitForCondition(e, timeout);
		return returnValue;
	}

	/**
	 * Wait for the element to appear on the screen
	 * 
	 * @param findergetSummary the element to wait to appear
	 * @param timeout          how long to wait for the item to appear (in seconds)
	 * @return true if the element appeared and false if it did not
	 */
	protected boolean waitForElement(final By finder, int timeout) {
		// logger.info("Waiting for element to load");
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElements(finder).size() > 0;
			}
		};
		boolean returnValue = waitForCondition(e, timeout);
		return returnValue;
	}

	/**
	 * Sleeps for the desired amount of time
	 *
	 * @param time the amount of time to sleep in ms
	 */
	protected void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ie) {
		}
	}

	public void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		wait.until(pageLoadCondition);
	}

	@BeforeSuite(alwaysRun = true)
	public void startCaseReport() throws Exception {
		deletePreviousScreenshots();
		logger.info("Initializing reporting framework");
		logger.info("---------------------------------");
		auto_start = System.currentTimeMillis();

		logger.info("portalParam.custom_report_location:" + portalParam.custom_report_location);

		FileUtils.copyFile(new File(portalParam.custom_report_location + "header.txt"),
				new File(portalParam.custom_report_location + "header_template.txt"));
		FileUtils.copyFile(new File(portalParam.custom_report_location + "trailor.txt"),
				new File(portalParam.custom_report_location + "trailor_template.txt"));

		logger.info("Calling Before Suite for generating reporting files.");

		Purchasecasefile = new File(portalParam.custom_report_location + "Purchase.json");
		Refinancecasefile = new File(portalParam.custom_report_location + "Refinance.json");
		Purchase_scenfile = new File(portalParam.custom_report_location + "Purchase_scenario.json");
		Purchase_feafile = new File(portalParam.custom_report_location + "Purchase_feature.json");
		Refinance_scenfile = new File(portalParam.custom_report_location + "Refinance_scenario.json");
		Refinance_feafile = new File(portalParam.custom_report_location + "Refinance_feature.json");

		feafile = new File(portalParam.custom_report_location + "feature.json");

		Purchasecasefile.createNewFile();
		FileWriter purchasecasefile = new FileWriter(Purchasecasefile);
		Refinancecasefile.createNewFile();
		FileWriter refinancecasefile = new FileWriter(Refinancecasefile);
		Purchase_scenfile.createNewFile();
		FileWriter portal_scenf = new FileWriter(Purchase_scenfile);
		Purchase_feafile.createNewFile();
		FileWriter portal_feaf = new FileWriter(Purchase_feafile);
		Refinance_scenfile.createNewFile();
		FileWriter api_scenf = new FileWriter(Refinance_scenfile);
		Refinance_feafile.createNewFile();
		FileWriter api_feaf = new FileWriter(Refinance_feafile);

		feafile.createNewFile();
		FileWriter featurefw = new FileWriter(feafile);
		portal_feaf.write("features: [");
		portal_scenf.write("scenarios: [");
		purchasecasefile.write("cases : [");
		purchasecasefile.flush();
		purchasecasefile.close();
		refinancecasefile.write("cases : [");
		refinancecasefile.flush();
		refinancecasefile.close();
		portal_scenf.flush();
		portal_scenf.close();
		portal_feaf.flush();
		portal_feaf.close();
		featurefw.write("features: [");
		api_feaf.write("features: [");
		api_scenf.write("scenarios: [");
		api_scenf.flush();
		api_scenf.close();
		api_feaf.flush();
		api_feaf.close();
		featurefw.flush();
		featurefw.close();

	}

	private void deletePreviousScreenshots() {
		File folder = new File(PortalParam.custom_report_location);
		File fList[] = folder.listFiles();

		for (File f : fList) {
			if (f.getName().endsWith(".png")) {
				f.delete();
			}
		}
	}

	public void generateReport(String className, String description, String funcModule)
			throws IOException, JSONException {

		String classStatus = "";
		File scenFile = null;

		if (funcModule.equalsIgnoreCase("Refinance")) {
			scenFile = Refinance_scenfile;
			logger.info("scenFile:" + scenFile);
			logger.info("casefile:" + Refinancecasefile);
			BufferedReader scenreader = new BufferedReader(new FileReader(scenFile));
			BufferedReader reader = new BufferedReader(new FileReader(Refinancecasefile));
			String line = "", oldtext = "";
			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r";
			}

			reader.close();
			String newtext = oldtext.replaceAll("\\[\\,", "[");
			newtext = newtext.replaceAll("\n", "");
			newtext = newtext + "]";
			FileWriter f = new FileWriter(Refinancecasefile, true);
			f.write(newtext);
			f.flush();
			f.close();

			JSONObject jobj = new JSONObject();
			jobj.put("name", className);
			jobj.put("description", description);
			jobj.put("tags", "");
			if (newtext.contains("Fail")) {
				classStatus = "Fail";
			} else {
				classStatus = "Pass";
			}
			jobj.put("status", classStatus);
			jobj.put("automated", "true");

			line = "";
			oldtext = "";
			while ((line = scenreader.readLine()) != null) {
				oldtext += line + "\r";
			}
			FileWriter scenf = new FileWriter(scenFile, true);
			if (!oldtext.contains("scenarios: [")) {
				scenf.write("scenarios: [\n");
			}
			scenf.write(jobj.toString().replaceAll("\\}", "") + "," + newtext + "\n},");
			scenf.flush();
			scenf.close();
		} else if (funcModule.equalsIgnoreCase("Purchase")) {
			scenFile = Purchase_scenfile;
			logger.info("scenFile:" + scenFile);
			logger.info("casefile:" + Purchasecasefile);
			BufferedReader scenreader = new BufferedReader(new FileReader(scenFile));
			BufferedReader reader = new BufferedReader(new FileReader(Purchasecasefile));
			String line = "", oldtext = "";
			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r";
			}

			reader.close();
			String newtext = oldtext.replaceAll("\\[\\,", "[");
			newtext = newtext.replaceAll("\n", "");
			newtext = newtext + "]";
			FileWriter f = new FileWriter(Purchasecasefile, true);
			f.write(newtext);
			f.flush();
			f.close();

			JSONObject jobj = new JSONObject();
			jobj.put("name", className);
			jobj.put("description", description);
			jobj.put("tags", "");
			if (newtext.contains("Fail")) {
				classStatus = "Fail";
			} else {
				classStatus = "Pass";
			}
			jobj.put("status", classStatus);
			jobj.put("automated", "true");

			line = "";
			oldtext = "";
			while ((line = scenreader.readLine()) != null) {
				oldtext += line + "\r";
			}
			FileWriter scenf = new FileWriter(scenFile, true);
			if (!oldtext.contains("scenarios: [")) {
				scenf.write("scenarios: [\n");
			}
			scenf.write(jobj.toString().replaceAll("\\}", "") + "," + newtext + "\n},");
			scenf.flush();
			scenf.close();
		}

		// casefile.delete();
	}

	@AfterSuite(alwaysRun = true)
	public void prepareFinalReport() throws IOException, JSONException, java.lang.Exception {

		auto_finish = System.currentTimeMillis();

		String testEnvtString = setTestEnvtDetails(auto_start, auto_finish, Execution_start_time);
		testEnvtString = testEnvtString.toString().replaceAll("\"values\"", "values").replaceAll("\\[\\{", "\\[")
				.replaceAll("\\}\\]", "\\]").replaceAll("\":\"", ":");

		UpdateEnvtParams(testEnvtString, portalParam.custom_report_location + "header_template.txt");
		System.out.println(testEnvtString);
		logger.info("Calling After Suite for preparing html report.");

		if ((Purchase_feafile.isFile()) && (Purchase_scenfile.isFile())) {
			BufferedReader Purchase_feareader = new BufferedReader(new FileReader(Purchase_feafile));
			BufferedReader portal_scenreader = new BufferedReader(new FileReader(Purchase_scenfile));

			String line = "", oldtext = "";
			while ((line = portal_scenreader.readLine()) != null) {
				oldtext += line + "\r";
			}
			portal_scenreader.close();
			// String newfeatext = oldtext.replaceAll("\\}\\,\\r",",\n");
			JSONObject fobj = new JSONObject();
			fobj.put("name", "Purchase");
			fobj.put("description", "Purchase Sanity Test");

			FileWriter feaf = new FileWriter(Purchase_feafile, true);
			feaf.write(fobj.toString() + ",\n" + oldtext);
			feaf.flush();
			feaf.close();

			oldtext = "";
			while ((line = Purchase_feareader.readLine()) != null) {
				oldtext += line + "\r";
			}
			Purchase_feareader.close();
			oldtext = oldtext.replaceAll("\\\"\\}\\,\\r", "\\\",\n");
			oldtext = oldtext.replaceAll("\\^\\,", "");
			String finalFeatureText = oldtext + "]},";
			FileWriter finalfeaf = new FileWriter(Purchase_feafile);
			finalfeaf.write(finalFeatureText);
			finalfeaf.flush();
			finalfeaf.close();
		}

		if ((Refinance_feafile.isFile()) && (Refinance_scenfile.isFile())) {
			BufferedReader Purchase_feareader = new BufferedReader(new FileReader(Refinance_feafile));
			BufferedReader portal_scenreader = new BufferedReader(new FileReader(Refinance_scenfile));

			String line = "", oldtext = "";
			while ((line = portal_scenreader.readLine()) != null) {
				oldtext += line + "\r";
			}
			portal_scenreader.close();
			// String newfeatext = oldtext.replaceAll("\\}\\,\\r",",\n");
			JSONObject fobj = new JSONObject();
			fobj.put("name", "Refinance");
			fobj.put("description", "Refinance Sanity Test");

			FileWriter feaf = new FileWriter(Refinance_feafile, true);
			feaf.write(fobj.toString() + ",\n" + oldtext);
			feaf.flush();
			feaf.close();

			oldtext = "";
			while ((line = Purchase_feareader.readLine()) != null) {
				oldtext += line + "\r";
			}
			Purchase_feareader.close();
			oldtext = oldtext.replaceAll("\\\"\\}\\,\\r", "\\\",\n");
			oldtext = oldtext.replaceAll("\\^\\,", "");
			String finalFeatureText = oldtext + "]},";
			FileWriter finalfeaf = new FileWriter(Refinance_feafile);
			finalfeaf.write(finalFeatureText);
			finalfeaf.flush();
			finalfeaf.close();
		}

		// casefile.delete();

		BufferedReader Purchase_feareader = new BufferedReader(new FileReader(Purchase_feafile));
		BufferedReader Refinance_feareader = new BufferedReader(new FileReader(Refinance_feafile));

		String oldtext = "", line = "";
		while ((line = Refinance_feareader.readLine()) != null) {
			oldtext += line + "\r";
		}
		while ((line = Purchase_feareader.readLine()) != null) {
			oldtext += line + "\r";
		}

		Purchase_feareader.close();
		Refinance_feareader.close();
		String[] parts = oldtext.split("features: \\[", 2);
		oldtext = parts[0].replaceAll("features: \\[", "") + parts[1].replaceAll("features: \\[", "");

		FileWriter finalfeaf = new FileWriter(feafile, true);
		finalfeaf.write(oldtext);
		finalfeaf.flush();
		finalfeaf.close();

		File htmlReportFile = null;
		if (portalParam.ClientName.contains("NAF")) {
			htmlReportFile = new File(portalParam.custom_report_location + "NAF_Automation.html");

		}
		if (portalParam.ClientName.contains("OC")) {
			htmlReportFile = new File(portalParam.custom_report_location + "OC_Automation.html");

		}
		File reportHeader = new File(portalParam.custom_report_location + "header_template.txt");
		File reportFeature = new File(portalParam.custom_report_location + "feature.json");
		File reportTrailer = new File(portalParam.custom_report_location + "trailor_template.txt");
		oldtext = "";
		line = "";
		BufferedReader reportReader = new BufferedReader(new FileReader(reportHeader));
		while ((line = reportReader.readLine()) != null) {
			oldtext += line + "\r";
		}

		BufferedReader featureReader = new BufferedReader(new FileReader(reportFeature));
		while ((line = featureReader.readLine()) != null) {
			oldtext += line + "\r";
		}

		BufferedReader trailerReader = new BufferedReader(new FileReader(reportTrailer));
		while ((line = trailerReader.readLine()) != null) {
			oldtext += line + "\r";
		}

		htmlReportFile.createNewFile();

		FileWriter htmlf = new FileWriter(htmlReportFile);
		htmlf.write(oldtext);
		htmlf.flush();
		htmlf.close();
		UpdateEnvtParams("ENVT_DETAILS", portalParam.custom_report_location + "header_template.txt");
	}

	public void UpdateEnvtParams(String testEnvtString, String fileName) {
		try {
			String newtext = null;
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "", oldtext = "";
			while ((line = reader.readLine()) != null) {
				oldtext += line + "";
			}
			reader.close();
			// replace a word in a file
			// String newtext = oldtext.replaceAll("drink", "Love");

			// To replace a line in a file
			if (!testEnvtString.equalsIgnoreCase("ENVT_DETAILS")) {
				newtext = oldtext.replaceAll("ENVT_DETAILS", testEnvtString);
			} else {
				newtext = oldtext.replaceAll(testEnvtString, "ENVT_DETAILS");
			}
			FileWriter writer = new FileWriter(fileName);
			writer.write(newtext);
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public String setTestEnvtDetails(long startTime, long endTime, String execution_start_time)
			throws java.lang.Exception {
		JSONObject jo = new JSONObject();
		jo.put("ClientName", portalParam.ClientName);
		jo.put("Operating System", System.getProperty("os.name").toLowerCase());
		jo.put("Testing environment",
				PortalFuncUtils.removeSpecialChar(System.getProperty("envParam")).replaceAll("\\\\", ""));
		jo.put("Date", execution_start_time);
		jo.put("Total Execution Time", toHHMMDD(endTime - startTime));

		JSONArray ja = new JSONArray();
		ja.put(jo);

		JSONObject mainObj = new JSONObject();
		mainObj.put("values", ja);
		return mainObj.toString();
	}

	public String toHHMMDD(long time) {

		String hms = String.format("%02d" + " hrs" + ":%02d" + " mins" + ":%02d" + " sec",
				TimeUnit.MILLISECONDS.toHours(time),
				TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)),
				TimeUnit.MILLISECONDS.toSeconds(time)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)));
		return hms;
	}

	public boolean isPopedUp() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public String getOnlyStrings(String s) {
		Pattern pattern = Pattern.compile("[^a-z A-Z]");
		Matcher matcher = pattern.matcher(s);
		String str = matcher.replaceAll("");
		return str;
	}

	/*
	 * public static String getOtp(String mobileNumber) { MongoClient mongoClient =
	 * null; mongoClient = new MongoClient(new ServerAddress(PortalParam.mongoHost,
	 * Integer.parseInt(PortalParam.mongoPort))); DB db =
	 * mongoClient.getDB(PortalParam.mongoDb); DBCollection collection =
	 * db.getCollection(PortalParam.mongoCollection); BasicDBObject query = new
	 * BasicDBObject(); query.append("Username", mobileNumber); DBObject dbObject =
	 * collection.findOne(query); return dbObject.get("OtpCode").toString(); }
	 */

	/*
	 * public static String getEmailVerificationCode(String email,String
	 * applicationId) throws Exception { DBObject dbObject; try { MongoClient
	 * mongoClient = null; mongoClient = new MongoClient(new
	 * ServerAddress(PortalParam.mongoHost,
	 * Integer.parseInt(PortalParam.mongoPort))); DB db =
	 * mongoClient.getDB("email-verification"); DBCollection collection =
	 * db.getCollection("email-verification"); BasicDBObject query = new
	 * BasicDBObject(); query.append("Email", email); query.append("EntityId",
	 * applicationId); dbObject = collection.findOne(query); }catch (Exception e) {
	 * throw new Exception("OTP can not be retrieved from database."); } return
	 * dbObject.get("Code").toString();
	 * 
	 * }
	 */

	public static String takeScreenShot(WebDriver driver, String screenShotName) {
		try {
			screenShotName = screenShotName + ".png";
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(PortalParam.custom_report_location, screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);
			return screenShotName;
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			return null;
		}
	}

	public String getBorrowerSignUpURL(String username) {
		logger.info("Querying mongoDb for the user " + username);
		logger.info("==================");
		MongoClient mongoClient = null;

		MongoCredential credential = MongoCredential.createCredential(portalParam.mongoDbUser, portalParam.mongoDb,
				portalParam.mongoDbPwd.toCharArray());
		mongoClient = new MongoClient(new ServerAddress(portalParam.mongoHost, portalParam.mongoPort),
				Arrays.asList(credential));
		DB db = mongoClient.getDB("assignment");
		DBCollection collection = db.getCollection("invites");
		BasicDBObject query = new BasicDBObject();
		query.append("InviteEmail", username);
		DBObject dbObject = collection.findOne(query);
		String url = (String) dbObject.get("InvitationUrl");
		mongoClient.close();
		logger.info("Sign Up Invitation URL..." + url);
		return url;
	}

	public String getCoborrowerId(int i) {
		return portalParam.borrowerFirstname + "." + portalParam.borrowerlastname + "+"
				+ new SimpleDateFormat("ddmmHHmmss").format(Calendar.getInstance().getTime()) + i + "@"
				+ portalParam.ClientName.toLowerCase() + ".com";
	}

	public static WebDriver createProxyDriver(String type, Proxy proxy, String path) {
		if (type.equalsIgnoreCase("chrome"))
			return createChromeDriver(createProxyCapabilities(proxy), path);
		throw new RuntimeException("Unknown WebDriver browser: " + type);
	}

	public static DesiredCapabilities createProxyCapabilities(Proxy proxy) {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("proxy", proxy);
		return capabilities;
	}

	public static WebDriver createChromeDriver(DesiredCapabilities capabilities, String path) {
		System.setProperty("webdriver.chrome.driver", path);
		if (capabilities != null) {
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			return new ChromeDriver(capabilities);
		} else
			return new ChromeDriver();

	}
}
