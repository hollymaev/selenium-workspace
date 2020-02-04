package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	private static final By searchBox        = By.id("edit-search");
	private static final By searchBtn        = By.id("edit-submit");

	
	public HomePage(WebDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, 15);
	}
	
	public void string() {
		System.out.println("hi");
	}
	
	public void searchFor(String title) {
		WebElement query = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		query.sendKeys(title);
		
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		search.click();
	}
	

	
}
	
