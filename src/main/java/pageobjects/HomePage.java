package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class HomePage extends Base {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myaccount;

	@FindBy(linkText = "Register")
	private WebElement register;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Your Store']") 
	private WebElement logo;

	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchbox ;
	
	@FindBy (xpath="//i[@class='fa fa-search']") 
	private WebElement searchbutton;
	
	public WebElement searchbutton()
	{
		return searchbutton;
	}
	public WebElement searchbox()
	{
		return searchbox;
	}
	
	public WebElement myaccount() {
		return myaccount;
	}

	public WebElement register() {
		return register;
	}
	public WebElement loginbutton()
	{
		return loginbutton;
	}
	public WebElement logo()
	{
		return logo;
	}
	
	public boolean islogoDisplayed()
	{
		return logo.isDisplayed();
	}
	
	public void loginfromHomePgae()
	{
		myaccount.click();
		loginbutton.click();
	}
	
	
	

}
