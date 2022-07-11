package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Account']")
	private WebElement accountbreadcrumb;

	public WebElement accountbreadcrumb()
	{
		return accountbreadcrumb;
	}
	
	public boolean isUserloggedin()
	{
		accountbreadcrumb.isDisplayed();
		boolean loginstatus = driver.getTitle().contains("My Account");
		return loginstatus;
	}
	@FindBy(xpath = "//input[@name='search']") 
	private WebElement searchtextbox;
	
	public WebElement searchtextbox()
	{
		return searchtextbox;
	}
	
}
