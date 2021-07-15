package com.IdentifyCourse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectModel extends DriverSetup{
	
//	private static WebDriver driver=null;
	
	private static WebElement element=null;
	private static List<WebElement> elements=null;
	
	static By searchBar=By.xpath("//*[contains(@placeholder,'W')]");
	static By languageBtn=By.xpath("//*[contains(@class,'Select-pl') and contains(text(),'La')]");
	static By showAllButton=By.xpath("//*[contains(text(),'Show All')]");
	static By allTextLang=By.xpath("//div[@class='filters-modal-content horizontal-box']");
	static By closeBtn=By.xpath("//a[@class='nostyle']");
	static By levelsBtn=By.xpath("//div[@id='react-select-3--value']");
	static By allLevels=By.xpath("//div[@id='react-select-3--list']/div");
	public static WebElement searchBar() {
		element=driver.findElement(searchBar);
		return element;
	}
	public static WebElement languageBtn() {
		element=driver.findElement(languageBtn);
		return element;
	}
	public static WebElement showAllButton() {
		element=driver.findElement(showAllButton);
		return element;
	}
	public static WebElement allTextLang() {
		element=driver.findElement(allTextLang);
		return element;
	}
	public static WebElement closeBtn() {
		element=driver.findElement(closeBtn);
		return element;
	}
	public static WebElement levelsBtn() {
		element=driver.findElement(levelsBtn);
		return element;
	}
	public static List<WebElement> allLevels() {
		elements=driver.findElements(allLevels);
		return elements;
	}
}

