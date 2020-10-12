package net.sigmainfo.lf.automation.common;

import net.sigmainfo.lf.automation.portal.constant.PortalParam;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

import static net.sigmainfo.lf.automation.common.AbstractTests.getDriver;

/**
 * Created by           : Shaishav.s on 18-04-2018.
 * Test class           : CaptureScreenshot.java
 * Description          : Captures a screenshot and saves it whenever portal testcases fail
 * Includes             : 1. CaptureScreenshot implementation
 */
public class CaptureScreenshot extends TestListenerAdapter {

    @Autowired
    static
    PortalParam portalParam;

    private Logger logger = LoggerFactory.getLogger(CaptureScreenshot.class);

    WebDriver driver;
    private static String fileSeperator = System.getProperty("file.separator");

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getName() + " test has failed *****");

        driver = getDriver();

        String testClassName = getTestClassName(result.getInstanceName()).trim();

        String testMethodName = result.getName().toString().trim();
        String screenShotName = testMethodName + ".png";

        if (driver != null) {
            String imagePath = portalParam.custom_report_location + takeScreenShot(driver, screenShotName, testClassName);
            System.out.println("Screenshot saved @ " + imagePath);
        }
    }

    public static String takeScreenShot(WebDriver driver,
                                        String screenShotName, String testName) {
        try {
            /*File file = new File("Screenshots" + fileSeperator + "Results");
            if (!file.exists()) {
                System.out.println("File created " + file);
                file.mkdir();
            }*/

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File(portalParam.custom_report_location, screenShotName);
            FileUtils.copyFile(screenshotFile, targetFile);

            return screenShotName;
        } catch (Exception e) {
            System.out.println("An exception occured while taking screenshot " + e.getCause());
            return null;
        }
    }

    public String getTestClassName(String testName) {
        String[] reqTestClassname = testName.split("\\.");
        int i = reqTestClassname.length - 1;
        System.out.println("Test Scenario Executed : " + reqTestClassname[i]);
        return reqTestClassname[i];
    }

    /*@Override
    public void onTestSuccess(ITestResult result) {

        logger.info("ITestResult=SUCCESS");
    }*/


}




