package com.tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ClearTripKeyBoardActionDemo {
	@Test
	public void testKeyBoardAction() throws InterruptedException {
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		WebElement from=driver.findElement(By.id("FromTag"));
		WebElement to=driver.findElement(By.id("ToTag"));
		Thread.sleep(5000);
		Set<String> w=driver.getWindowHandles();
		System.out.println("No of window"+w.size());
		/*from.sendKeys("h");
		from.sendKeys("y");
		from.sendKeys("d");*/
		Actions act1=new Actions(driver);
		act1.keyDown(from,Keys.SHIFT).perform();
		//act1.keyDown(Keys.SHIFT).perform();
		act1.sendKeys("h").perform();
		Thread.sleep(3000);
		act1.sendKeys("y").perform();
		Thread.sleep(3000);
		act1.sendKeys("d").perform();
		Thread.sleep(5000);
		act1.sendKeys(Keys.ENTER).perform();
		
		Actions act2=new Actions(driver);
		act2.sendKeys(to,"b").perform();
		Thread.sleep(5000);
		act2.sendKeys("a").perform();
		Thread.sleep(5000);
		act2.sendKeys("n").perform();
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("ui-id-2"), By.className("list")));
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		List<WebElement> list=ul.findElements(By.tagName("li"));
		//Assert.assertEquals(list.size(),10);
		for(WebElement e:list) {
			if(e.getText().contains("BLR")) {
				e.click();
				break;
			}
		}
	}

}
