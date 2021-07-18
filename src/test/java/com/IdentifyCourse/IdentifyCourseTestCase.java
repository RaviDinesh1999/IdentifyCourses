package com.IdentifyCourse;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class IdentifyCourseTestCase {
	static WebDriver driver = null;
	
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

	
	@Test(priority=2,groups = { "Regression" })
	public static void execution() throws InterruptedException {
		
		String parentwindow=driver.getWindowHandle();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//Type coursename nd click
		PageObjectModel.getCoursename().sendKeys("Web development");
		PageObjectModel.getCoursenameclick().click();
		//select language as english
		PageObjectModel.getLang().click();
		PageObjectModel.getLangclick().click();
		
		//select level as beginner
		PageObjectModel.getLevel().click();
		PageObjectModel.getLevelclick().click();
		
		//select learning
		PageObjectModel.getLearning().click();
		PageObjectModel.getLearningclick().click();
//		Thread.sleep(1000);
		
		
		//course names
		String firstcoursename=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")).getText();
		System.out.println("FirstName is:"+firstcoursename);
	    //Thread.sleep(1000);
	    String secondcoursename=driver.findElement(By.xpath("//html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")).getText();
		System.out.println("secondName is:"+secondcoursename);
		//Thread.sleep(1000);
		
		//reviews
		String firstreview=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[1]/div[2]/div/div/div/div/div/ul/li[1]/div/div/div/div/div/div[2]/div[4]/div[1]/div[1]/div/span[1]")).getText();
		//Thread.sleep(1000);
		String secondreview=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[1]/div[2]/div/div/div/div/div/ul/li[2]/div/div/div/div/div/div[2]/div[4]/div[1]/div[1]/div/span[1]")).getText();
		System.out.println("FirstReview is:"+firstreview+" "+"SecondReview is"+secondreview);
		
		
		//get first course duration
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")).click();
		Set<String> fcourse=driver.getWindowHandles();
		for(String i:fcourse)
		{
			if(!i.contentEquals(parentwindow))
			{
				driver.switchTo().window(i);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				Thread.sleep(3000);
				String value1=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[5]/div[2]")).getText();
				System.out.println("Firstcoursenamehours"+value1);
				driver.close();

			}
			
			
			 driver.switchTo().window(parentwindow);
		}
		
		
		//get second course duration
		driver.findElement(By.xpath("//html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")).click();
		Set<String> scourse=driver.getWindowHandles();
		for(String i:scourse)
		{
			if(!i.contentEquals(parentwindow))
			{
				driver.switchTo().window(i);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				Thread.sleep(3000);
				String value1=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div/div[6]/div[2]")).getText();
				System.out.println("secondcoursenamehours"+value1);
				driver.close();

			}
			
			 driver.switchTo().window(parentwindow);
		
		}
		
		}

	}

