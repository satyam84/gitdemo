package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestContextSetup;

public class CheckoutPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public static String checkoutPageProductTitle;
	public TestContextSetup testConetxtSetup;
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By checkoutPageProduct1=By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[2]");
	By checkoutBtn1 = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/section[1]/div[3]/div[2]/div[1]/div[6]/div[1]/div[1]/button[1]/p[1]");
	By emptyCartBtn = By.cssSelector("a[class='uiv2-empty-basket'] p");
	By confirmationBox=By.cssSelector(".uiv2-popup-alert");
	By okBtn = By.cssSelector("#alert_ok");
	
	public String getProductTitle() {
		WebElement checkoutPageProduct = driver.findElement(checkoutPageProduct1);
		checkoutPageProductTitle = checkoutPageProduct.getText().trim().split("-")[0];
		return checkoutPageProductTitle;
	}
	
	public boolean checkOutBtnEnabled() {
		WebElement checkoutBtn = driver.findElement(checkoutBtn1);
		return checkoutBtn.isEnabled();
	}
	
	public boolean checkEmptyCartBtn() {
		WebElement emptyCart = driver.findElement(emptyCartBtn);
		return emptyCart.isEnabled();
	}
	
	/*public boolean isProductName() {
		
	}*/
	
	public void emptyCart() {
		WebElement emptyCart = driver.findElement(emptyCartBtn);
		emptyCart.click();

		// waiting for confirmation popup for emptying the cart
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".uiv2-popup-alert")));
		WebElement okBtn = driver.findElement(By.cssSelector("#alert_ok"));
		okBtn.click();
	}
}
