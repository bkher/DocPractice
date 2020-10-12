package net.sigmainfo.lf.automation.common;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

/**
 * Created by : Rengarajan.m on 07-12-2017. Test class : JavaScriptsError.java
 * Description : This class used for Capturing Console error
 */
public class ConsoleError {
	
	public org.slf4j.Logger logger = LoggerFactory.getLogger(ConsoleError.class);
	public static AbstractTests ABtests = new AbstractTests();

	public void ConsoleError(String testcase) throws IOException {

		LogEntries logEntries = ABtests.driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries.getAll() ) {
			String Message = new Date(entry.getTimestamp()) + " "
					+ entry.getLevel() + " " + entry.getMessage();
			String FilePath = "./ConsoleErrors/" + testcase +".txt";
			WriteFile writefile = new WriteFile(FilePath, true);
			writefile.writeToFile(Message);
			
		}
		
	}

}
