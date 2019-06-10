package com.qa.zoopla.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zoopla.testbase.TestBase;

public class MMTSearchFlightPage extends TestBase {

	// Page Factory -Object Repository
	@FindBy(xpath = "//span[text()='Flights']")
	private WebElement flightsIcon;

	@FindBy(xpath = "//li[contains(text(),'Round Trip')]")
	private WebElement radioButtonRoundTrip;

	@FindBy(xpath = "//span[contains(text(),'From')]")
	private WebElement flightFrom;

	@FindBy(xpath = "//span[contains(text(),'To')]")
	private WebElement flightTo;

	@FindBy(xpath = "//div[contains(text(),'DEL')]")
	private WebElement flightFromPlace;

	@FindBy(xpath = "//div[contains(text(),'BLR')]")
	private WebElement flightToPlace;

	@FindBy(xpath = "//span[contains(text(),'DEPARTURE')]")
	private WebElement departureDate;

	@FindBy(xpath = "//div[@class='DayPicker-Day DayPicker-Day--selected']//p[contains(text(),'18')]")
	private WebElement departureDateSelection;

	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	private WebElement next;
	

	public static final Logger log = Logger.getLogger(MMTSearchFlightPage.class.getName());

	// Initialization
	public MMTSearchFlightPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnFlights() {
		if (!flightsIcon.isSelected()) {
			flightsIcon.click();
		}

	}

	public void selectRoundTrip() {
		radioButtonRoundTrip.click();
	}

	public void clickDepartureFlightPlace() {
		flightFrom.click();
		flightFromPlace.click();
	}

	public String selectDate(String dateInput) throws InterruptedException {
		
		dateInput = "06/27/2019";
		@SuppressWarnings("deprecation")
		Date d = new Date(dateInput);
		SimpleDateFormat dt = new SimpleDateFormat("MMM/dd/yyyy");
		String date = dt.format(d);
		System.out.println("date format :: " + date);
		String[] split = date.split("/");
		System.out.println(split[0] + " " + split[1] + " " + split[2]);
	    String month = split[0];
		String day = split[1];
		String year = split[2];
		String firstXpath="//div[contains(@aria-label ,'";
		String lastXpath ="')]";
		while(true) {
			
			try {
				
				driver.findElement(By.xpath(firstXpath + month + " " + day + " " + year + lastXpath)).isDisplayed();
				driver.findElement(By.xpath(firstXpath + month + " " + day + " " + year + lastXpath)).click();
				break;
				
			}
			
			catch(Exception e) {
				 next.click();
			}
			
		}
		return month + " " + day + " " + year;
		
	}

	public void clickArrivalFlightPlace() throws InterruptedException {
		flightTo.click();
		flightToPlace.click();
		departureDate.click();
		Thread.sleep(2000);
		selectDate("04/28/2019");
	}

}
