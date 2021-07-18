package com.IdentifyCourse;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class FormFillingTestCase {
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
	public void enterprise() 
	{
		//driver.findElement(By.xpath("//*[@id=\"enterprise-link\"]")).click();
		PageObjectModel.enterprise().click();
		Actions action = new Actions(driver);
		WebElement ProductHover = PageObjectModel.products();
		action.moveToElement(ProductHover);
		action.build().perform();
		PageObjectModel.forcampus().click();
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		WebElement element1=PageObjectModel.transform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element1);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test(priority=3,groups= {"Smoke"})
	public void formfilling()
	{
		PageObjectModel.firstName().sendKeys("Anu");
		PageObjectModel.lastName().sendKeys("Pallavi");
		Select function = new Select(PageObjectModel.jobFunction());
		function.selectByVisibleText("Dean");
		PageObjectModel.jobTitle().sendKeys("Placement Dean");
		PageObjectModel.mail().sendKeys("anupallavi123gmuil.com");
		PageObjectModel.Phone().sendKeys("9876543210");
		PageObjectModel.Company().sendKeys("ABCD");
		Select ins_type = new Select(PageObjectModel.institutionType());
		ins_type.selectByVisibleText("Government");
		Select dis=new Select(PageObjectModel.primaryDiscipline());
		dis.selectByVisibleText("Business");
		Select country=new Select(PageObjectModel.Country());
		country.selectByVisibleText("India");
		PageObjectModel.help().sendKeys("NA");
		PageObjectModel.submitButton().click();
		System.out.println(PageObjectModel.email().getText());
	}
}
