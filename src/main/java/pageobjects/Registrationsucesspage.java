package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registrationsucesspage {

	WebDriver driver;

	public Registrationsucesspage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//ul[@class='breadcrumb']//a[text()='Success']") private WebElement sucessbreadcrumb;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']") private WebElement sucessmessage;

	public WebElement sucessbreadcrumb()
	{
		return sucessbreadcrumb;

	}
	public WebElement successmessage()
	{
		return sucessmessage;
	}
}
