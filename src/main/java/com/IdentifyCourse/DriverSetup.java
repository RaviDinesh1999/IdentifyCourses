package com.IdentifyCourse;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	static WebDriver driver;

	public WebDriver setupDriver() throws MalformedURLException {
		
		
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\elcot\\eclipse-workspace\\MiniProject-SNMC\\Drivers\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			//opt.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			driver = new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		return driver;
	}

}
