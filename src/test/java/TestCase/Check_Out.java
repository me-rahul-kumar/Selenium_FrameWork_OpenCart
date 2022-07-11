package TestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import resources.Base;

public class Check_Out extends Base {
	
	WebDriver diver;
	public void setup() throws IOException
	{
		driver=intializeBrowser();
		prop.getProperty(browserName);
	}
	public void checkOut()
	{
		
	}
	
	public void tearDown()
	{
		
	}

}
