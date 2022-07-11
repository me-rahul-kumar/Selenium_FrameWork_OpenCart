package TestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class Check_Out extends Base {
	
	WebDriver diver;
	public Check_Out() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		driver=intializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void checkOut()
	{
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}

}
