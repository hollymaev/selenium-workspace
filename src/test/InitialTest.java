package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import page.HomePage;
import page.SearchResultsPage;

public class InitialTest extends BaseTest{
	
	@Test(dataProvider = "multiQuery")
	public void canSearchByQuery(String query) {
		open();
		
		new HomePage(driver).searchFor(query);
		
		assertTrue(new SearchResultsPage(driver).match(query), "Results do not match Query");
	}
	
	@Test(dataProvider = "multiQuery")
	public void canFilterByFormat(String query) {
		open();
		
		new HomePage(driver).searchFor(query);
		
		SearchResultsPage srp = new SearchResultsPage(driver);
		
		srp.match(query);
		
		srp.filterByComicBook();
		
		assertTrue(srp.isFiltered(), "Results have not been filtered");
		
		
		
	}

}