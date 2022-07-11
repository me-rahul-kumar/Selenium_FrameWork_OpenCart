package TestCase;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.Loginpage;
import pageobjects.MyAccountPage;
import pageobjects.SearchPage;
import pageobjects.ShoppingCart;
import resources.Base;

public class Add_To_Cart extends Base {

	public Add_To_Cart() {
		super();

	}
	WebDriver driver;
	public Actions action;
	SearchPage searchpage=null;

	@BeforeTest
	public void setup() throws IOException {

		driver=intializeBrowser();
		driver.get(prop.getProperty("url"));
		action=new Actions(driver);	
	}
	@Test
	public void addToCart() throws InterruptedException {

		HomePage homepage=new HomePage(driver);
		homepage.loginfromHomePgae();
		
		Loginpage loginpage=new Loginpage(driver);
		loginpage.loginformLoginPage(prop.getProperty("email"), prop.getProperty("password"));
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean loginstatus = myacc.isUserloggedin();
		
			Assert.assertTrue(loginstatus);
			System.out.println("User logged in sucessfully");
			
			myacc.searchtextbox().sendKeys(prop.getProperty("searchProductKey"));
			action.sendKeys(Keys.ENTER).click().build().perform();
			
			searchpage=new SearchPage();
			
			//validation the breadcrumb 
			Assert.assertTrue(searchpage.isSearchBreadcrumbDisplayed());
			
			searchpage.addtoCart();
			searchpage.isaddedtoCart();
			
			searchpage.gotoShoppingCart();
			System.out.println(searchpage.gotoShoppingCart());
			
			ShoppingCart scart=new ShoppingCart();
			scart.isshoppincartBreadcrumbdispayed();
		
	}
	

	public void tearDown() {
		
		driver.close();

	}

}
