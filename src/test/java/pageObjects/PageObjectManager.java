package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public HomePage homePage;
	public OffersPage offersPage;
	public VegetablePage vegetablePage;
	public WebDriver driver;
	public CheckoutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage getHomePage() {
		homePage=new HomePage(driver);
		return homePage;
	}
	
	public OffersPage getOffersPage() {
		offersPage=new OffersPage(driver);
		return offersPage;
	}
	
	public VegetablePage getVegetablePage() {
		vegetablePage=new VegetablePage(driver);
		return vegetablePage;
	}
	
	public CheckoutPage getCheckoutPage() {
		checkOutPage=new CheckoutPage(driver);
		return checkOutPage;
	}
}
