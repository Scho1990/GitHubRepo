package com.qa.zoopla.testcases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zoopla.pages.MMTSearchFlightPage;
import com.qa.zoopla.testbase.TestBase;

public class MMTSearchFlightPageTest extends TestBase {

	MMTSearchFlightPage mmtSearchFlightPage;
	

	public MMTSearchFlightPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		mmtSearchFlightPage = new MMTSearchFlightPage();
	}

	@Test(priority = 1)
	public void verifyUserFlightSearch() throws InterruptedException {
		mmtSearchFlightPage.clickOnFlights();
		//mmtSearchFlightPage.selectRoundTrip();
		mmtSearchFlightPage.clickDepartureFlightPlace();
		mmtSearchFlightPage.clickArrivalFlightPlace();
	}

	@Test(priority = 2)
	public void loginTest() {
		
	}

	// @AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
