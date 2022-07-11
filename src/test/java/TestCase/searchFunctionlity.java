package TestCase;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import resources.Base;

public class searchFunctionlity extends Base {

	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;
	public Logger logger;

	public searchFunctionlity() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		driver = intializeBrowser();
		driver.get(prop.getProperty("url"));
		searchpage = new SearchPage();
		homepage = new HomePage(driver);
		logger = LogManager.getLogger(searchFunctionlity.class.getName());
	}

	@Test
	public void searchfunctionality() {
		String searchkey = prop.getProperty("searchkey");
		homepage.searchbox().sendKeys(searchkey);
		logger.debug("Search for: " + searchkey);
		homepage.searchbutton().click();
		String pagetitle = searchpage.getPagetile();

		boolean status = false;
		if (pagetitle.contains("Search")) {
			status = true;
		} else {
			status = false;
		}
		Assert.assertTrue("Page title matched", status);

		boolean breadcrumbvisibility = false;

		if (searchpage.isSearchBreadcrumbDisplayed()) {
			breadcrumbvisibility = true;
		} else {
			breadcrumbvisibility = false;
		}
		Assert.assertTrue(breadcrumbvisibility);

		Assert.assertTrue(searchpage.isSearchProductDisplayed());
		
		Assert.assertTrue(searchpage.isSearchTitleDisplayed());
	}

	@AfterMethod
	public void tearDoen() {
		driver.quit();
	}

}
