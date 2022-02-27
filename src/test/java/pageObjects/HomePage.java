package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public String productTitle1;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By searchByCategory = By.cssSelector(".dropdown-toggle.meganav-shop");
	By fruitsVegies = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/mega-nav-template[1]/div[1]/ul[1]/li[1]/a[1]");
	By chatBot = By.xpath("/html/body/div[5]/div/div/div/div[2]");
	By closeChatbot = By.xpath("/html/body/div[5]/div/div/div/div[1]/a[1]/i");
	By closeChatbotConfirmationBox = By.xpath("//html/body/div[5]/div/div/div/div[2]/div[4]");
	By yesBtn = By.xpath("/html/body/div[5]/div/div/div/div[2]/div[4]/button[2]");

	// login
	By loginLink = By.cssSelector(".list-unstyled.list-inline.login-section");
	By loginPopup = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
	By loginWithEmail = By.cssSelector("button[class='btn btn-default']");
	By emailTextField = By.cssSelector("#otpEmail");
	By continueBttn = By.cssSelector(".btn.btn-default.login-btn");

	By verify_email = By.cssSelector("div[class='col-md-9']");
	By verifyBttn = By.cssSelector(".btn.btn-default.btn-lg.login-btn.fixed-btn");
	By closeLoginPopup = By.cssSelector("div[class='col-md-9']");

	By searchBoxx = By.cssSelector("#input");
	By suggestionDropDown = By.xpath("//ul[@class='search-item-suggesion']");
	By product = By.cssSelector("li:nth-child(1) div:nth-child(1) div:nth-child(2) a:nth-child(1) p:nth-child(1)");
	By productName = By.xpath(
			"/html/body/div[1]/div[1]/div[9]/div/div[3]/search-products-template/div[1]/div[1]/div/div/div/div/ul/li[1]/div/div[2]/a/p[2]");
	By addquantity = By.xpath(
			"/html/body/div[1]/div[1]/div[9]/div/div[3]/search-products-template/div[1]/div[1]/div/div/div/div/ul/li[1]/div/div[7]/div/input");
	By addToCart = By.xpath(
			"/html/body/div[1]/div[1]/div[9]/div/div[3]/search-products-template/div[1]/div[1]/div/div/div/div/ul/li[1]/div/div[8]/button/span[1]");
	By header = By.cssSelector("div[class='container top-header'] div div[class='col-md-12 pad-0']");
	By basket = By.cssSelector(".btn.btn-default.basket-btn-drop.hidden-xs.hidden-sm");
	By proceedToCheckoutBox = By.xpath("//ul[@class='cart-dropdown hidden-xs hidden-sm']");
	By proceedToCheckoutBtn = By.cssSelector("button[type='button'][qa='viewBasketMB']");

	public void clickfruitsVegies() {
		driver.findElement(fruitsVegies).click();
	}

	public void moveToDialogBox() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(searchByCategory)).build().perform();
	}

	public void closeChatBox() {
		// if chatbot appears close it
		try {
			// wait for chatbot to appear
			if (driver.findElement(chatBot).isDisplayed()) {// wait = new WebDriverWait(driver, Duration.ofSeconds(5));
															// wait.until(ExpectedConditions.visibilityOf(driver.findElement(chatBot)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				WebElement closeChatBtn = driver.findElement(closeChatbot);
				closeChatBtn.click();
				// wait for confirmation box to appear
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(closeChatbotConfirmationBox)));
				WebElement yes = driver.findElement(yesBtn);
				yes.click();
			}

		} catch (Exception e) {
			System.out.println("There is no such chatbot present");
		}
	}

	public void loginLinkClick() {
		driver.findElement(loginLink).click();
	}

	public void wait_for_login_popup_to_appear() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopup));
	}

	public void click_On_Login_with_email_btn() {
		WebElement email = driver.findElement(loginWithEmail);
		email.click();
	}

	public void enterEmail(String email) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(emailTextField));
		WebElement emailTextBox = driver.findElement(emailTextField);
		emailTextBox.sendKeys(email);
	}

	public void clickOnContiueBtn() {
		WebElement continueBtn = driver.findElement(continueBttn);
		continueBtn.click();
	}

	public void wait_For_Verify_Email_Header() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='col-md-9']")));
	}

	public void wait_for_otp_and_click_on_verifyOtp_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(verifyBttn));
		WebElement verifyBtn = driver.findElement(verifyBttn);
		verifyBtn.click();
	}

	public void search_for_product() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loginPopup));
		wait.until(ExpectedConditions.elementToBeClickable(searchBoxx));
		WebElement searchBox = driver.findElement(searchBoxx);
		searchBox.sendKeys("tom");
		Thread.sleep(1000);
		searchBox.sendKeys("a");
		Thread.sleep(1000);
		searchBox.sendKeys("t");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// waiting for suggestion dropdown to appear
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(suggestionDropDown)));
	}

	public void click_on_header() {
		WebElement headerr = driver.findElement(header);
		headerr.click();
	}

	public String getProductTitle() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(product)));
		WebElement product = driver.findElement(productName);
		productTitle1 = product.getText().trim().split("-")[0];
		return productTitle1;
	}

	public void add_some_product_to_the_basket(int num) {
		WebElement addQuantity = driver.findElement(addquantity);
		addQuantity.clear();
		addQuantity.sendKeys(Integer.toString(num));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(addToCart);
		addBtn.click();
	}

	public void mouseHover_on_the_basket() {
		WebElement basket1 = driver.findElement(basket);
		Actions act = new Actions(driver);
		act.moveToElement(basket1).build().perform();
	}

	public void proceedToCheckout() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// waiting for proceed to checkout menu to appear
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceedToCheckoutBox)));
		WebElement proceedToCheckOut = driver.findElement(proceedToCheckoutBtn);
		proceedToCheckOut.click();
	}

	public void clear_SearchBox() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(searchBoxx));
		WebElement searchBox = driver.findElement(searchBoxx);
		searchBox.clear();

	}
}
