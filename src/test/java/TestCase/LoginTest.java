package TestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.Loginpage;
import pageobjects.MyAccountPage;
import resources.Base;

public class LoginTest extends Base {


	public LoginTest()
	{
		super();
	}
	
	public WebDriver driver;
	public HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver=intializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void logintestwithvalidcredentials() throws IOException
	{
		
		homepage=new HomePage(driver);
		homepage.myaccount().click();
		homepage.loginbutton().click();

		Loginpage loginpage=new Loginpage(driver);
		
	

		loginpage.emailinput().sendKeys("rahul114@gmail.com");
		loginpage.passwordinput().sendKeys("12346"); //right password 12345
		loginpage.loginbutton().click();

		MyAccountPage myaccount=new MyAccountPage(driver);

		Assert.assertTrue(myaccount.accountbreadcrumb().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("My Account"));
	}
	

	@AfterMethod
	public void closure()
	{
		driver.quit();
	}

}
