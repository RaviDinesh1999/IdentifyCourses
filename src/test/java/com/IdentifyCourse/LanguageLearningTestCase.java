package com.IdentifyCourse;


import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LanguageLearningTestCase {

	private WebDriver driver;
	
	
	@Test
	  public void openMyBlog() {
		String baseUrl = "https://www.coursera.org/";
		driver.get(baseUrl);

		driver.findElement(By.xpath("//*[contains(@placeholder,'W')]")).sendKeys("Language Learning" + Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@class,'Select-pl') and contains(text(),'La')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Show All')]")).click();

		String all = driver.findElement(By.xpath("//div[@class='filters-modal-content horizontal-box']")).getText();
		System.out.println(all);

		driver.findElement(By.xpath("//a[@class='nostyle']")).click();

		driver.findElement(By.xpath("//div[@id='react-select-3--value']")).click();
		List<WebElement> allLevels = driver.findElements(By.xpath("//div[@id='react-select-3--list']/div"));
		int size = allLevels.size() - 1;
		int c = 0;
		for (WebElement E : allLevels) {
			c++;
			if (c <= size)
				System.out.println(E.getText());
			else
				break;
		}
	}
	  
	  @BeforeClass
	  public void beforeClass() {
	   
		  System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\elcot\\eclipse-workspace\\MiniProject-SNMC\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	   
	  }
	 
	  @AfterClass
	  public void afterClass() {
	   driver.quit();
	  }

//	@BeforeSuite(groups = { "Regression" })
//	@Test(priority=1,groups= {"Smoke"})
//	public void openBrowser() throws Exception {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\elcot\\eclipse-workspace\\MiniProject-SNMC\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		String baseUrl = "https://www.coursera.org/";
//		driver.get(baseUrl);
//
//		driver.findElement(By.xpath("//*[contains(@placeholder,'W')]")).sendKeys("Language Learning" + Keys.ENTER);
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[contains(@class,'Select-pl') and contains(text(),'La')]")).click();
//		driver.findElement(By.xpath("//*[contains(text(),'Show All')]")).click();
//
//		String all = driver.findElement(By.xpath("//div[@class='filters-modal-content horizontal-box']")).getText();
//		System.out.println(all);
//
//		driver.findElement(By.xpath("//a[@class='nostyle']")).click();
//
//		driver.findElement(By.xpath("//div[@id='react-select-3--value']")).click();
//		List<WebElement> allLevels = driver.findElements(By.xpath("//div[@id='react-select-3--list']/div"));
//		int size = allLevels.size() - 1;
//		int c = 0;
//		for (WebElement E : allLevels) {
//			c++;
//			if (c <= size)
//				System.out.println(E.getText());
//			else
//				break;
//		}
//
//		driver.quit();
//	}

//	@Test(priority=1,groups= {"Smoke"})
//	public void secondCourse() 
//	{
////		PageObjectModel.searchBar().sendKeys("Language Learning" + Keys.ENTER);
//		driver.findElement(By.xpath("//*[contains(@placeholder,'W')]")).sendKeys("Language Learning" + Keys.ENTER);
//	}
//	
//	@Test(priority = 2, groups = { "Smoke" })
//	public void selectLanguage2() {
//		// Extract all the language with its total count
//	
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		PageObjectModel.languageBtn().click();
////		PageObjectModel.showAllButton().click();
////		
////		String all=PageObjectModel.allTextLang().getText();
////		System.out.println(all);
////		
////		PageObjectModel.closeBtn().click();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[contains(@class,'Select-pl') and contains(text(),'La')]")).click();
//		driver.findElement(By.xpath("//*[contains(text(),'Show All')]")).click();
//		
//		String all=driver.findElement(By.xpath("//div[@class='filters-modal-content horizontal-box']")).getText();
//		System.out.println(all);
//		
//		driver.findElement(By.xpath("//a[@class='nostyle']")).click();
//		
//		
//	}
//
//	@Test(priority = 3, groups = { "Smoke" })
//	public void selectLevel2() {
////		PageObjectModel.levelsBtn().click();
////		List<WebElement> allLevels=PageObjectModel.allLevels();
////		int size=allLevels.size()-1;
////		int c=0;
////		for(WebElement E:allLevels) {
////			c++;
////			if(c<=size)
////			System.out.println(E.getText());
////			else 
////				break;	
////		}
//		
//		driver.findElement(By.xpath("//div[@id='react-select-3--value']")).click();
//		List<WebElement> allLevels=driver.findElements(By.xpath("//div[@id='react-select-3--list']/div"));
//		int size=allLevels.size()-1;
//		int c=0;
//		for(WebElement E:allLevels) {
//			c++;
//			if(c<=size)
//			System.out.println(E.getText());
//			else 
//				break;	
//		}
//		
//	}
//	
//	
//	@AfterSuite(groups = { "Regression" })
//	public void closeBrowser() {
//	driver.quit();
//  }
}
