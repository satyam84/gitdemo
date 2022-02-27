package StepDefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class CheckoutPageSteps {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public String productTitle;
	public String checkoutPageProductTitle;
	public TestContextSetup testContextsetup;
	public CheckoutPage checkOutPage;
	public HomePage homePage;
	
	public CheckoutPageSteps(TestContextSetup testContextsetup) {
		this.testContextsetup=testContextsetup;
		homePage=testContextsetup.pageObjectManager.getHomePage();
		checkOutPage=testContextsetup.pageObjectManager.getCheckoutPage();
	}
	
	

	@Then("The user should proceed to checkout")
	public void the_user_should_proceed_to_checkout() throws InterruptedException {

		
		//homePage=TestContextSetup.pageObjectManager.getHomePage();
		
		// check if the checkoutPageProductTitle is same as productTitle
		if (checkOutPage.getProductTitle().equalsIgnoreCase(testContextsetup.productTitle1)) {
			System.out.println("The product is valid.");
		}

		
		System.out.println("Is checkout button enabled: " + checkOutPage.checkOutBtnEnabled());
		
		System.out.println("Is empty cart button is enabled: " + checkOutPage.checkEmptyCartBtn());
		checkOutPage.emptyCart();

		
		
		//go back
		//testContextsetup.driver.navigate().back();
		testContextsetup.genericUtils.navigateBack();
		
		//erase the searchbox
		testContextsetup.genericUtils.implicitWait(20);
		homePage.clear_SearchBox();
		
		//close browser
		//testContextsetup.driver.quit();

	}

}
