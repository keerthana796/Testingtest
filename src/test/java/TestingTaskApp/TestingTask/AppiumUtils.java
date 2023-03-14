package TestingTaskApp.TestingTask;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils extends BaseClass {

	
	public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") +"//reports//index.html"+".png";
		FileUtils.copyFile(source, new File (destination));
		return destination;
	}
}
