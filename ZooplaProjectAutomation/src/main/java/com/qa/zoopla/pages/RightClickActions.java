package com.qa.zoopla.pages;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickActions {

	WebDriver driver;

	@Test
	public void rightClickAction() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		try {

			BufferedImage image = new Robot()
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

			ImageIO.write(image, "png", new File(System.getProperty("user.dir")+"\\screenshot"+System.currentTimeMillis()+".png"));

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}
