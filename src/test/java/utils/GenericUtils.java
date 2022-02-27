package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	/*public void quitBrowser() {
		driver.quit();
	}*/
	
	public void navigateBack() {
		driver.navigate().back();
	}
}
