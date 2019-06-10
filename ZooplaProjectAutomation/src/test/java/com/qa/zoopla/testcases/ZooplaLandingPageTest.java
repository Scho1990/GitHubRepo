package com.qa.zoopla.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zoopla.pages.SalePage;
import com.qa.zoopla.pages.ZooplaLandingPage;
import com.qa.zoopla.testbase.TestBase;

public class ZooplaLandingPageTest extends TestBase {

	ZooplaLandingPage zooplaLandingPage;
	SalePage salePage;

	public ZooplaLandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		zooplaLandingPage = new ZooplaLandingPage();
		salePage = new SalePage();
	}

	@Test(priority =1)
	public void verifyUserNavigatedToSalePagePostSearchLocation() {
		salePage = zooplaLandingPage.enterInputLocationInSearchField("London");
		zooplaLandingPage.clickOnSearchButton();
		Assert.assertTrue(salePage.isSalePageTitlePresent(), "User is not navigated to Sale Page");
	}
	
	@Test(priority =2)
	public void loginTest() {
		salePage = zooplaLandingPage.enterInputLocationInSearchField("London");
		zooplaLandingPage.clickOnSearchButton();
		salePage.validateProductPriceSortingDescendingFunctionality();
	}

	// @AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
