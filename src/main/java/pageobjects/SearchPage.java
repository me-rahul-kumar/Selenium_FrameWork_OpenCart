package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class SearchPage extends Base {

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Search']")
	public WebElement searhpagebreadcrumb;

	public WebElement searhpagebreadcrumb() {
		return searhpagebreadcrumb;
	}

	public boolean isSearchBreadcrumbDisplayed() {
		return searhpagebreadcrumb.isDisplayed();
	}

	public String getPagetile() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//img[@title='iPhone']")
	public WebElement searchProduct;

	public WebElement searchProduct() {
		return searchProduct;
	}

	public boolean isSearchProductDisplayed() {
		return searchProduct.isDisplayed();
	}

	@FindBy(xpath = "//h2[normalize-space()='Products meeting the search criteria']")
	public WebElement searchtitle;

	public WebElement searchTitle() {
		return searchtitle;
	}

	public boolean isSearchTitleDisplayed() {
		return searchProduct.isDisplayed();
	}

	@FindBy(xpath = "//div[@class='button-group']//button[1]")
	public WebElement addtoCartButton;

	public WebElement addtoCartbutton() {
		return addtoCartButton;
	}

	public boolean addtoCart() {
		addtoCartButton.click();
		return true;
	}

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement addtocartSucessmessage;

	public boolean isaddedtoCart() {
		addtocartSucessmessage.getText().contains("Success: You have added iPhone to your");
		return true;
	}

	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	public static WebElement shopingCartlink;

	public WebElement shopingCartAnchorLink() {
		return shopingCartlink;
	}

	public boolean gotoShoppingCart() throws InterruptedException {
		boolean flag=false;
	
		
		//doubt
		try 
		{
			//new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(shopingCartlink));
			 
			Thread.sleep(3000);
			shopingCartlink.click();
			flag=true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return flag;
		
	}

}
	
	
	
	
	
	