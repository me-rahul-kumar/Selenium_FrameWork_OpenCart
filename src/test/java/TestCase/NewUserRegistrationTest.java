package TestCase;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.Register_Account;
import pageobjects.Registrationsucesspage;
import resources.Base;

public class NewUserRegistrationTest extends Base {

	public NewUserRegistrationTest() {
		super();
		
	}
	public WebDriver driver;
	public HomePage homepage;
	public Register_Account registeraccount;
	public Registrationsucesspage registersuccesspage;
	
	@BeforeTest
	public void openApplication() throws IOException {
		driver = intializeBrowser();
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		registeraccount = new Register_Account(driver);
		registersuccesspage = new Registrationsucesspage(driver);
	}

	// new user registration with new input
	@Test
	public void newRegistrationWithNewEmail() throws IOException {

		homepage.myaccount().click();
		homepage.register().click();

		// verifying register bread-crumb

		Assert.assertTrue(registeraccount.registerbreadcrumb().getText().equalsIgnoreCase("Register"));

		registeraccount.registerbreadcrumb().getText().equalsIgnoreCase("Register");
		registeraccount.firstName().sendKeys("Rahul");
		registeraccount.lastName().sendKeys("Kumar");
		registeraccount.email().sendKeys("rahul115@gmail.com");
		registeraccount.phone().sendKeys("12345678");
		registeraccount.password().sendKeys("12345");
		registeraccount.confirmpassword().sendKeys("12345");
		registeraccount.agreeCheckbox().click();
		registeraccount.continuebutton().click();
		
		Assert.assertTrue(registersuccesspage.sucessbreadcrumb().isDisplayed());
		Assert.assertTrue(registersuccesspage.successmessage().isDisplayed());
	}

	// registration of the new user with the duplicate email which are already in use
	@Test
	public void register_with_duplicate_email() {
		
		homepage.myaccount().click();
		homepage.register().click();

		// verifying register bread-crumb

		Assert.assertTrue(registeraccount.registerbreadcrumb().getText().equalsIgnoreCase("Register"));

		registeraccount.registerbreadcrumb().getText().equalsIgnoreCase("Register");
		registeraccount.firstName().sendKeys("Rahul");
		registeraccount.lastName().sendKeys("Kumar");
		registeraccount.email().sendKeys("rahul115@gmail.com");
		registeraccount.phone().sendKeys("12345678");
		registeraccount.password().sendKeys("12345");
		registeraccount.confirmpassword().sendKeys("12345");
		registeraccount.agreeCheckbox().click();
		registeraccount.continuebutton().click();

		Assert.assertTrue(
				registeraccount.alertmessage().getText().contains("Warning: E-Mail Address is already registered!"));
		
		Assert.assertTrue(registeraccount.alertmessage().isDisplayed());
	}

	@AfterTest
	public void closure() {
	driver.close();
	}
}
