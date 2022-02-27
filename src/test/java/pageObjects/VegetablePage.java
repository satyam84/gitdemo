package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VegetablePage {
	
public WebDriver driver;
	
	public VegetablePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By searchBox=By.cssSelector("#input");
	By search = By.cssSelector(".icon.svg-header.svg-search.svg-search-dim.hidden-sm.hidden-xs");
	By HomepagePrice=By.cssSelector(
			"body > div:nth-child(1) > div:nth-child(12) > product-deck:nth-child(1) > section:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > product-template:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(2) > span:nth-child(2)");
	By productname=By.cssSelector(
			"body > div:nth-child(1) > div:nth-child(12) > product-deck:nth-child(1) > section:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > product-template:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1)");
	By offersPageLink=By.cssSelector("a[class='bb-offers-link'] span");
	
	public void searchProduct(String text) {
		driver.findElement(searchBox).sendKeys(text);
	}
	
	public void clickOnSearchBtn() {
		driver.findElement(search).click();
	}
	
	public String getPrice() {
		return driver.findElement(HomepagePrice).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productname).getText();
	}
	
	public void clickOnOffersPageLink() {
		driver.findElement(offersPageLink).click();
	}
}
