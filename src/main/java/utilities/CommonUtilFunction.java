package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CommonUtilFunction {

	public static String takescreenshot(String testname, WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testname + ".png";
		FileUtils.copyFile(SourceFile, new File(destinationFilePath));
		return destinationFilePath;
	}
	
	
	public static String getTimeStamp()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   String timestamp = dtf.format(now);
		   return timestamp;
	}
}
