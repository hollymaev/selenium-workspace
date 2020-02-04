package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

public class SearchResultsPage {

	WebDriver driver;
	WebDriverWait wait;
	
	private static final By pageTitle   = By.cssSelector("h1[data-test-id='searchTitle']");
	
	private static final By results     = By.cssSelector("li[data-test-id='searchResultItem']");
	private static final By resultTitle = By.className("title-content");
	
	private static final By checkboxButton = By.cssSelector("button[aria-labelledby='label_FORMAT-BOOKS-COMIC_BK']");
	private static final By formatIndicator = By.cssSelector("span[data-test-id='format-indicator']");
	
	public SearchResultsPage(WebDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
	}

	
	public boolean match(String string) {
		
		boolean bool = false;
		
		for(int i = 0; i < resultList(); i++) {
			
			if(title().equalsIgnoreCase(string)) {
				bool = true;
			} else {
				bool = false;
			}
			
		}
		
		return bool;
	}
	
	private String title() {
		WebElement resultContent = wait.until(ExpectedConditions.visibilityOfElementLocated(resultTitle));
		return resultContent.getText();
	}
	
	private int resultList() {
		List<WebElement> resultList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(results));
		return resultList.size();
		
	}
	
	private String indicator() {
		WebElement resultIndicator = wait.until(ExpectedConditions.visibilityOfElementLocated(formatIndicator));
		return resultIndicator.getText();
	}
	
	public boolean isFiltered() {
		boolean result = false;
		for(int i = 0; i < resultList(); i++) {
			if(indicator().equalsIgnoreCase("Comic Book")) {
				result = true;
			} else {
				result = false;
			}
		}
		
		return result;
	}
	
	public void filterByComicBook() {
		try {
		WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(checkboxButton));
		filter.click();
		wait.until(ExpectedConditions.attributeToBe(checkboxButton, "aria-checked", "true"));
		} catch(TimeoutException e) {
			throw new SkipException("Query does not have any comic books available");
			
		}
		
	}
	
}
