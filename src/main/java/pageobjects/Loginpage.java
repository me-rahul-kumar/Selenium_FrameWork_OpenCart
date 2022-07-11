package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;

	public Loginpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailinput;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordinput;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbutton;

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Login']")
	private WebElement loginbreadcrumb;
	
	@FindBy(xpath = "//a[text()='Your Store']")
	private WebElement opencartlogo;

	public WebElement emailinput()
	{
		return emailinput;
	}

	public WebElement passwordinput()
	{
		return passwordinput;
	}
	public WebElement loginbutton()
	{
		return loginbutton;
	}
	public WebElement loginbreadcrumb()
	{
		return loginbreadcrumb;

	}
	public WebElement opencarlogo()
	{
		return opencartlogo;
	}
	
	public MyAccountPage clickonlogin()
	{
		loginbutton.click();
		return new MyAccountPage(driver);	
	}
	
	public boolean verifyOpenCartlogo()
	{
		boolean staus = opencartlogo.isDisplayed();
		return staus;
	}
	
	public boolean islogolinkenable() 
	{
		boolean status = opencartlogo.isEnabled();
		return status;
	}
	public boolean isLoginBreadcrumbDisplayed()
	{
		boolean status = loginbreadcrumb.isDisplayed();
		return status;
	}
	
	public void loginformLoginPage(String email, String password)
	{
		emailinput.sendKeys(email);
		passwordinput.sendKeys(password);
		loginbutton.click();
	}
	
	
}


