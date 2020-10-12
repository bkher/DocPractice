package net.sigmainfo.lf.automation.portal.pages.Borrower.AssetsSection;

import net.sigmainfo.lf.automation.common.AbstractTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.*;
import static net.sigmainfo.lf.automation.portal.function.PortalFuncUtils.getLocator;
import static org.testng.Assert.assertTrue;

/**
 * Created by Shaishav.s on 25-04-2018.
 */
public class AssetSummaryPage extends AbstractTests {
    private Logger logger = LoggerFactory.getLogger(AssetSummaryPage.class);
    WebDriverWait wait = new WebDriverWait(driver,180);

    public AssetSummaryPage(WebDriver driver) throws Exception {
        try {
            this.driver = driver;
            waitForPageToLoad(driver);
            logger.info("=========== AssetSummaryPage is loaded============");
        }catch (Exception e)
        {
            throw new Exception("AssetSummaryPage could not be loaded within time");
        }
    }
    public AssetSummaryPage(){} 
}
