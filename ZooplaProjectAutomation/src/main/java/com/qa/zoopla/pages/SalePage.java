package com.qa.zoopla.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zoopla.testbase.TestBase;

public class SalePage extends TestBase {
	// Page Factory -Object Repository

	@FindBy(xpath = "//*[@id='content']/div/h1")
	private WebElement salePageTitle;
	
	@FindBy(xpath = "//*[starts-with(@id,'listing_5104')]/div/div[2]/a")
	private List<WebElement> priceList;

	// Initialization
	public SalePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isSalePageTitlePresent() {
		return salePageTitle.isDisplayed();
	}
	
	public String validateProductPriceSortingDescendingFunctionality() {
		String result = "Fail";
		int sizeOfList = priceList.size();
		long originalArrayPrice[] = new long[sizeOfList];
		long tempArrayPrice[] = new long[sizeOfList]; 
		for (int a = 0; a < sizeOfList; a++) {
			tempArrayPrice[a] =Long.parseLong(priceList.get(a).getText().replaceAll("[,]", "").trim());
			System.out.println("temp Array before sorting ::: " + tempArrayPrice[a]);
		}

		for (int a = 0; a < sizeOfList; a++) {
			originalArrayPrice[a] = Long.parseLong(priceList.get(a).getText().replaceAll("([,])", "").trim());
			System.out.println("original Array before sorting ::: " + originalArrayPrice[a]);
		}
		// Sorting original array in descending order
		for (int i = 0; i < sizeOfList; i++) {
			for (int j = i + 1; j < sizeOfList; j++) {
				if (originalArrayPrice[i] < originalArrayPrice[j]) {
					long temp = originalArrayPrice[i];
					originalArrayPrice[i] = originalArrayPrice[j];
					originalArrayPrice[j] = temp;
				}
			}
		}
		// Comparing arrays
		if (Arrays.equals(originalArrayPrice, tempArrayPrice)) {
			result = "Pass";
		} else {
			result = "Fail";
		}
		return result;
	}

}
