package com.qa.zoopla.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.zoopla.utils.TestUtil;

public class TestBase {

	protected static WebDriver driver;
	public static Properties prop;
	static String log4jConfPath = System.getProperty("user.dir") + "\\resources\\log4j.properties";
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	// Constructor to invoke the config.Properties file
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\greatergiving\\configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Browser Initialization method
	public static void initializeBrowser() {
		PropertyConfigurator.configure(log4jConfPath);
		log.info("----Browser Opening----");
		String browserName = (prop.getProperty("BROWSER")).toLowerCase();
		if (browserName.equalsIgnoreCase("chrome")) {
			log.info("Browser Selected for Execution---- " + browserName);
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			log.info("Browser Selected for Execution---- " + browserName);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.info("Navigating to URL---- " + prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));
	}

}
