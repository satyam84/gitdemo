package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OffersPage {

	public WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	By offerProduct = By
			.cssSelector("carousel-product-widget:nth-child(4) section:nth-child(1) div:nth-child(1) h2:nth-child(1)");
	By dropDown = By.xpath(
			"/html/body/div[1]/div[2]/carousel-product-widget[3]/section/div[2]/div/div[1]/div/div[2]/div/div/product-template-in-container/div[1]/div[4]/div[2]/div/span/button/i");
	By price = By.cssSelector("span[class='ng-scope open'] li:nth-child(2) a:nth-child(1) span:nth-child(3)");
	By discountProductTitle = By.xpath(
			"/html/body/div[1]/div[2]/carousel-product-widget[3]/section/div[2]/div/div[1]/div/div[2]/div/div/product-template-in-container/div[1]/div[4]/div[1]/a");
	By discountPrice=By.xpath(
			"//carousel-product-widget[3]//section[1]//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//product-template-in-container[1]//div[1]//div[4]//div[3]//div[1]//div[1]//h4[1]//span[2]");
	
	public void scrollToProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(offerProduct));
	}
	
	public void clickOnDropDown() {
		driver.findElement(dropDown).click();
	}
	
	public void clickOnPrice() {
		driver.findElement(price).click();
	}
	
	public String getDiscountProductTitle() {
		return driver.findElement(discountProductTitle).getText();
	}
	
	public String getDiscountPrice() {
		return driver.findElement(discountPrice).getText();
	}
	
	
}
