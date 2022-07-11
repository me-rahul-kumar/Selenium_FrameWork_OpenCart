package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class ShoppingCart extends Base {

	public ShoppingCart() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[contains(text(),'Shopping Cart')]")
	public static WebElement shoppingcartBreadcrumb;
	
	
	
	
	public boolean isshoppincartBreadcrumbdispayed()
	{
		boolean status=shoppingcartBreadcrumb.isDisplayed();
		return status;
	}
	
	
	

}
