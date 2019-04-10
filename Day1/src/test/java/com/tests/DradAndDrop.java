package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DradAndDrop {
	@Test
	public void testPriceChecker() throws InterruptedException {
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		      
		WebElement from=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement to=driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		      
		Actions act1=new Actions(driver);
		//act1.clickAndHold(from).release(to).perform();
		act1.dragAndDrop(from, to).perform();
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.textToBe(By.id("ctl00_ContentPlaceholder1_Label1"),"$"));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), 
				"Drop a package here to check price"));
		     
		String text=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println("Price is:"+text);
		      
	 
		     
	}

}
