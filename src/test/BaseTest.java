package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {
	
	WebDriver driver;
    WebDriverWait wait;
	
	private static final String URL = "https://www.vpl.ca";
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/hollymae/selenium/drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name = "singleQuery")
	public String singleQuery() {
		return "philosophy";
	}
	
    @DataProvider(name = "multiQuery")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "Dinosaurs" }, { "The Big Bang Theory" } };
    }
	
	public void open() {
		driver.get(URL);
	}
}
