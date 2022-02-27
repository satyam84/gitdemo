package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.VegetablePage;
import utils.TestContextSetup;

public class VegetablePageStepDefinations {

	public String productHomepagePrice;
	public String productHomeTitle;
	public TestContextSetup testContextSetup;
	public VegetablePage vegetablePage;


	public VegetablePageStepDefinations(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		//this.vegetablePage=testContextSetup.pageObjectManager.getVegetablePage();
	}
	
	//public VegetablePage vegetablePage=new VegetablePage(testContextSetup.driver);
	
	// fruits and vegetable sections page
	@When("^Searches for (.+)$")
	public void searches_for(String string) {
		vegetablePage=testContextSetup.pageObjectManager.getVegetablePage();
		testContextSetup.genericUtils.implicitWait(10);
		vegetablePage.searchProduct(string);
		testContextSetup.genericUtils.implicitWait(10);
		vegetablePage.clickOnSearchBtn();
	}

	@Then("The user should get the price of the product")
	public void the_user_should_get_the_price_of_the_product() {
		vegetablePage=testContextSetup.pageObjectManager.getVegetablePage();
		testContextSetup.genericUtils.implicitWait(10);
		testContextSetup.productHomepagePrice = vegetablePage.getPrice();
		testContextSetup.productHomeTitle = vegetablePage.getProductName().split("\n")[1].trim();
		System.out.println("The product is " + testContextSetup.productHomeTitle + " and its price is " + testContextSetup.productHomepagePrice);
	}

	@When("The user searches navigates to offers page")
	public void the_user_searches_navigates_to_offers_page() {
		vegetablePage=testContextSetup.pageObjectManager.getVegetablePage();
		testContextSetup.genericUtils.implicitWait(10);
		vegetablePage.clickOnOffersPageLink();
	}
}
