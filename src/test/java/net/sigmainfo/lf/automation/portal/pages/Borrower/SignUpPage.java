package net.sigmainfo.lf.automation.portal.pages.Borrower;

import net.sigmainfo.lf.automation.common.AbstractTests;
import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import net.sigmainfo.lf.automation.portal.function.StringEncrypter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractCollection;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;

/**
 * Created by Shaishav.s on 24-04-2018.
 */
public class SignUpPage extends AbstractTests {

	private Logger logger = LoggerFactory.getLogger(SignUpPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 180);

	public SignUpPage(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			waitForPageToLoad(driver);
			//waitForElementToBeVisible(getLocator(uiObjParam.borrowerSignUpPage_welcomeMessage));
			//waitForElementToBeVisible(getLocator(uiObjParam.borrowerSignUpPage_emailTextBox));
			//waitForElementToBeClickable(getLocator(uiObjParam.borrowerSignUpPage_emailTextBox));
			//waitForElementToBeVisible(getLocator(uiObjParam.borrowerSignUpPage_signUpButton));
			waitForElementToBeClickable(getLocator(uiObjParam.borrowerSignUpPage_signUpButton));
			logger.info("=========== SignUpPage is loaded============");
		} catch (Exception e) {
			throw new Exception("SignUpPage could not be loaded within time");
		}
	}

	public void signUp() throws Exception {

		// insertText(driver, getLocator(uiObjParam.borrowerSignUpPage_emailTextBox),
		// portalParam.borrowerUsername);
		insertText(driver, getLocator(uiObjParam.borrowerSignUpPage_passwordTextBox),
				StringEncrypter.createNewEncrypter().decrypt(PortalParam.lenderPassword));
		insertText(driver, getLocator(uiObjParam.borrowerSignUpPage_confirmPasswordTextBox),
				StringEncrypter.createNewEncrypter().decrypt(PortalParam.lenderPassword));
		clickButton(driver, getLocator(uiObjParam.borrowerSignUpPage_signUpButton), "Sign Up");
		Thread.sleep(30000);
	}
	
	public void directSignup() throws Exception
	{
		        insertText(driver, getLocator(uiObjParam.borrowerSignUpPage_emailTextBox),
				                   portalParam.borrowerUsername);
				insertText(driver, getLocator(uiObjParam.borrowerSignUpPage_passwordTextBox),
						StringEncrypter.createNewEncrypter().decrypt(PortalParam.lenderPassword));
				insertText(driver, getLocator(uiObjParam.borrowerSignUpPage_confirmPasswordTextBox),
						StringEncrypter.createNewEncrypter().decrypt(PortalParam.lenderPassword));
				clickButton(driver, getLocator(uiObjParam.borrowerSignUpPage_signUpButton), "Sign Up");
				Thread.sleep(30000);
	}
}
