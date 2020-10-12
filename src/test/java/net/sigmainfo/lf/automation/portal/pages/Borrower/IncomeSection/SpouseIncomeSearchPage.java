package net.sigmainfo.lf.automation.portal.pages.Borrower.IncomeSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.removeSpecialChar;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.waitForPageToLoad;
import static org.testng.Assert.assertTrue;

/**
 * Created by shaishav.s on 08-05-2018.
 */
public class SpouseIncomeSearchPage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(SpouseIncomeSearchPage.class);
    WebDriverWait wait = new WebDriverWait(driver,240);

    public SpouseIncomeSearchPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            Thread.sleep(7000);
            logger.info("=========== SpouseIncomeSearchPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("SpouseIncomeSearchPage could not be loaded within time");
        }
    }
    public SpouseIncomeSearchPage(){}
}
