package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Account{

	WebDriver driver;

	public Register_Account(WebDriver dirver) {

		this.driver = dirver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstname;
	@FindBy(css = "input#input-lastname")
	private WebElement lastname;
	@FindBy(css = "input#input-email")
	private WebElement email;
	@FindBy(css = "input#input-telephone")
	private WebElement phone;
	@FindBy(id = "input-password")
	private WebElement password;
	@FindBy(id = "input-confirm")
	private WebElement confirmpassword;
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreecheckbox;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebutton;
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Register']")
	private WebElement registerbredcrumb;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") 
	private WebElement alertmessage;

	public WebElement firstName() {
		return firstname;
	}

	public WebElement lastName() {
		return lastname;
	}

	public WebElement email() {
		return email;
	}

	public WebElement phone() {
		return phone;

	}

	public WebElement password() {
		return password;

	}

	public WebElement confirmpassword() {
		return confirmpassword;

	}

	public WebElement agreeCheckbox() {
		return agreecheckbox;
	}

	public WebElement continuebutton() {
		return continuebutton;

	}
	public WebElement registerbreadcrumb()
	{
		return registerbredcrumb;

	}
	
	public WebElement alertmessage()
	{
		return alertmessage;
		
	}

}
