package com.qa.zoopla.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickAction {

	WebDriver driver;

	@Test
	public void rightClickAction() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		WebElement locator = driver.findElement(By.linkText("Gmail"));

		Actions action = new Actions(driver);

		action.contextClick(locator).build().perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		String parentWindowID = driver.getWindowHandle();
		
		System.out.println(parentWindowID);

		Set<String> handler = driver.getWindowHandles();
		
		System.out.println("Total window : "+handler.size());
		
		System.out.println("Window Name : " +handler);

		Iterator<String> itr = handler.iterator();

		while (itr.hasNext()) {
			
			String childWindowID = itr.next();

			if (!parentWindowID.equals(childWindowID)) {

				driver.switchTo().window(childWindowID);

				driver.close();

			}
		}
		driver.switchTo().window(parentWindowID);

	}

}
