package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
	@Test
	public void testHdfc() throws InterruptedException {
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		//driver.findElement(By.linkText("Products")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")).click();
		/*when u try above code you will get below error
		 * org.openqa.selenium.ElementNotVisibleException: element not interactable
		 */
		Actions act=new Actions(driver);
		WebElement e1=driver.findElement(By.xpath("//a[@href='/personal/products']"));
		act.moveToElement(e1).perform();
		Thread.sleep(5000);
		WebElement e2=driver.findElement(By.xpath("//a[@href='/personal/products/cards']"));
		act.moveToElement(e2).perform();
		Thread.sleep(5000);
		WebElement e3=driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']"));
		act.moveToElement(e3).click().perform();
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("credit_cards"));
	}

}
