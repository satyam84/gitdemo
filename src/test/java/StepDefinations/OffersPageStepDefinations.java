package StepDefinations;

import java.time.Duration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OffersPage;
import pageObjects.VegetablePage;
import utils.TestContextSetup;

public class OffersPageStepDefinations {
	
	
	public String discountPriceStr;
	public String productDiscountTitle;
	public TestContextSetup testContextSetup;
	public OffersPage offersPage;
	

	public OffersPageStepDefinations(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		//this.offersPage=testContextSetup.pageObjectManager.getOffersPage();
	}
	
	@When("if product is available on the offers page")
	public void if_product_is_available_on_the_offers_page() {
		offersPage=testContextSetup.pageObjectManager.getOffersPage();
		testContextSetup.genericUtils.implicitWait(10);
		offersPage.scrollToProduct();
		System.out.println("-----------------------------------------------------");

	}

	@Then("The user should get the price of the product on offers page")
	public void the_user_should_get_the_price_of_the_product_on_offers_page() {
		offersPage=testContextSetup.pageObjectManager.getOffersPage();
		//testContextSetup.genericUtils.implicitWait(10);
		//offersPage.clickOnDropDown();
		testContextSetup.genericUtils.implicitWait(10);
		//offersPage.clickOnPrice();
		testContextSetup.genericUtils.implicitWait(10);
		productDiscountTitle =offersPage.getDiscountProductTitle().trim();
		discountPriceStr = offersPage.getDiscountPrice();
		System.out.println("The product is " + productDiscountTitle + " discount price is " + discountPriceStr);
		System.out.println("-----------------------------------------------------");

	}

	@And("The product name and price on offers page should be same as seen on homepage")
	public void the_product_name_and_price_on_offers_page_should_be_same_as_seen_on_homepage() {
		// product name and price validation
		
		if ((productDiscountTitle.equalsIgnoreCase(testContextSetup.productHomeTitle))
				&& (discountPriceStr.equalsIgnoreCase(testContextSetup.productHomepagePrice))) {
			System.out.println("The product is same as seen earlier in the HomePage.");
		} else {
			System.out.println("The product is not same as seen earlier in the HomePage.");
		}
		System.out.println("-----------------------------------------------------");
		// Assert.assertEquals(discountPriceStr, productHomepagePrice);

		//testContextSetup.genericUtils.quitBrowser();
	}
}
