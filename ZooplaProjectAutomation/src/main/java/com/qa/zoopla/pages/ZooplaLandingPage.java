package com.qa.zoopla.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.zoopla.testbase.TestBase;

public class ZooplaLandingPage extends TestBase {

	// Page Factory -Object Repository
	@FindBy(id = "search-input-location")
	private WebElement searchInputLocation;
	
	@FindBy(xpath = "//*[@id='ui-id-12']/a/em")
	private WebElement searchSuggestions;

	@FindBy(id = "search-submit")
	private WebElement searchButton;
	
	@FindBy(id="forsale_price_min")
	private WebElement minPrice;
	
	public static final Logger log = Logger.getLogger(ZooplaLandingPage.class.getName());

	// Initialization
	public ZooplaLandingPage() {
		PageFactory.initElements(driver, this);
	}

	public SalePage enterInputLocationInSearchField(String inputText) {
		searchInputLocation.clear();
		searchInputLocation.sendKeys(inputText);
		return new SalePage();
	}
	
	public void clickOnSearchButton() {
		minPrice.click();
		searchButton.click();
	}

}
