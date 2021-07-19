package com.IdentifyCourse;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LanguageLearningTestCase  {

	public static WebDriver driver = null;
	  
	@BeforeClass(groups = { "Regression" })
	  public void beforeClass() throws Exception {
	   

		DriverSetup dri = new DriverSetup();
		driver = dri.setupDriver();
	  }
	 
	@AfterClass(groups = { "Regression" })
	  public void afterClass() {
	   driver.quit();
	  }

	  @Test(priority=1,groups = { "Regression" })
		public void openWebSite() 
		{
			String baseUrl = "https://www.coursera.org/";
			driver.get(baseUrl);
		}  

	@Test(priority=2,groups= {"Smoke"})
	public void secondCourse() 
	{
		PageObjectModel.searchBar().sendKeys("Language Learning" + Keys.ENTER);
	}
	
	@Test(priority = 3,groups= {"Smoke"})
	public void selectLanguage2() {
		// Extract all the language with its total count
	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		PageObjectModel.languageBtn().click();
		PageObjectModel.showAllButton().click();
		
		String all=PageObjectModel.allTextLang().getText();
		System.out.println(all);
		
		PageObjectModel.closeBtn().click();		
		
	}

	@Test(priority = 4,groups= {"Smoke"})
	public void selectLevel2() {
		PageObjectModel.levelsBtn().click();
		List<WebElement> allLevels=PageObjectModel.allLevels();
		int size=allLevels.size()-1;
		int c=0;
		for(WebElement E:allLevels) {
			c++;
			if(c<=size)
			System.out.println(E.getText());
			else 
				break;	
		}		
	}
}