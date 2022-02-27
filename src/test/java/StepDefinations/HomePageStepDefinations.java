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
import pageObjects.HomePage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class HomePageStepDefinations {

	public WebDriver driver;
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public HomePage homePage;
	
	public HomePageStepDefinations(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		homePage=testContextSetup.pageObjectManager.getHomePage();
	}
	
	
	@Given("The user is on Bigbasket homePage")
	public void the_user_is_on_bigbasket_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on bigbasket homepage")
	public void the_user_is_on_bigbasket_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}



	@When("The user search navigates to fruits and vegetable section")
	public void the_user_search_navigates_to_fruits_and_vegetable_section() {
		testContextSetup.genericUtils.implicitWait(10);
		
		
		
		homePage.moveToDialogBox();
		testContextSetup.genericUtils.implicitWait(10);
		homePage.clickfruitsVegies();
	}
	
	@Then("User has to log in")
	public void user_has_to_log_in() {

		// if chatbot appears close it
		
		
		homePage.closeChatBox();

		testContextSetup.genericUtils.implicitWait(20);
		
		homePage.loginLinkClick();
		
		homePage.click_On_Login_with_email_btn();
		
		homePage.enterEmail("vemiya1005@naluzotan.com");
		
		testContextSetup.genericUtils.implicitWait(20);
		
		homePage.clickOnContiueBtn();
		
		homePage.wait_For_Verify_Email_Header();
		
		homePage.wait_for_otp_and_click_on_verifyOtp_button();
		
		

	}

	@When("User searches for the product")
	public void user_searches_for_the_product() throws InterruptedException {
		
		//homePage.closeChatBox();
		homePage.search_for_product();
		homePage.closeChatBox();
		
		
	}

	@And("Adds some quantity of the product to the basket")
	public void adds_some_quantity_of_the_product_to_the_basket() throws InterruptedException {
		
		homePage.add_some_product_to_the_basket(4);
		
		// if chatbot appears close it
		homePage.closeChatBox();
		
		Thread.sleep(1000);
		
		homePage.click_on_header();
		
	}

	@Then("The product is added to the basket")
	public void the_product_is_added_to_the_basket() {
		testContextSetup.genericUtils.implicitWait(20);
		
		homePage.mouseHover_on_the_basket();
		
		homePage.proceedToCheckout();

	}
}
