package com.IdentifyCourse.Grid;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import com.IdentifyCourse.PageObjectModel;

public class LanguageLearningGridDemo {
	public static WebDriver driver;
	String nodeUrl;

	@BeforeClass(groups = { "Regression" })
	public void beforeClass() throws Exception {
		nodeUrl = "http://192.168.43.52:4444/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(nodeUrl), capability);
	}

	@AfterClass(groups = { "Regression" })
	public void afterClass() {
		driver.quit();
	}

	@Test(priority = 1, groups = { "Regression" })
	public void openWebSite() {
		String baseUrl = "https://www.coursera.org/";
		driver.get(baseUrl);
	}

	@Test(priority = 2, groups = { "Smoke" })
	public void secondCourse() {
		PageObjectModel.searchBar().sendKeys("Language Learning" + Keys.ENTER);
	}

	@Test(priority = 3, groups = { "Smoke" })
	public void selectLanguage2() {
		// Extract all the language with its total count

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		PageObjectModel.languageBtn().click();
		PageObjectModel.showAllButton().click();

		String all = PageObjectModel.allTextLang().getText();
		System.out.println(all);

		PageObjectModel.closeBtn().click();

	}

	@Test(priority = 4, groups = { "Smoke" })
	public void selectLevel2() {
		PageObjectModel.levelsBtn().click();
		List<WebElement> allLevels = PageObjectModel.allLevels();
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
}
