package com.automationpractice.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.automationpractice.utility.Utility;

public class SetUps {
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("openedURL")
	public void setupBeforeMethod(String url) throws IOException {
		
			System.out.println("url = " + url);
			
			if(Utility.fetchPropertyValue("browserName").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(Utility.fetchPropertyValue("browserName").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(url);
	}

	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		driver.quit();
	}

}
