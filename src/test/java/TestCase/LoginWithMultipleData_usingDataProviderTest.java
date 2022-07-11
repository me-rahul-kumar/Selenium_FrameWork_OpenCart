package TestCase;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.Loginpage;
import pageobjects.MyAccountPage;
import resources.Base;
import resources.Login_DataProvider;

public class LoginWithMultipleData_usingDataProviderTest extends Base {

	public WebDriver driver;
	public Logger log;
	public String credentialtype;

	
	public LoginWithMultipleData_usingDataProviderTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		log = LogManager.getLogger(LoginWithMultipleData_usingDataProviderTest.class.getName());
		driver = intializeBrowser();
		log.debug("Browder got lauched");
		driver.get(prop.getProperty("url"));
		log.debug("Landed to Home Page");
	}
	
	//login test with valid and one invalid input at the last test
	
	
	@Test(dataProviderClass = Login_DataProvider.class, dataProvider = "logindatprovider")
	public void loginTest(String email, String password, String credentialtype, String expedctedresult) {

		HomePage homepage = new HomePage(driver);

		homepage.myaccount().click();
		log.debug("Click on  my account dropdown menu");
		homepage.loginbutton().click();
		log.debug("Click on login");

		Loginpage loginpage = new Loginpage(driver);
		Assert.assertTrue(loginpage.loginbreadcrumb().isDisplayed());
		log.debug("Landed to login page");
		loginpage.emailinput().sendKeys(email);
		loginpage.passwordinput().sendKeys(password);
		loginpage.loginbutton().click();
		log.debug("Click on login button");

		MyAccountPage myaccount = new MyAccountPage(driver);

		Assert.assertTrue(myaccount.accountbreadcrumb().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("Account"));

		log.info("Sucessfully login");

		String actualresult = null;

		try {
			if (myaccount.accountbreadcrumb().isDisplayed()) {
				actualresult = "Pass";
			}
		} catch (Exception e) {
			actualresult = "Fail";
		}

		Assert.assertEquals(expedctedresult, actualresult);
	}
	
	public void loginwithKeyboardKeyPress()
	{
		//tabs and enter
	}
	
	public void loginSessionStatusAfterWindowBack()
	{
		
	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}

}
