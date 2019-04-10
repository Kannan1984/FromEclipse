package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NewTest2 {
  @Test
  public void f() {
	  WebDriver driver=DriverUtility.getDriver("chrome");
	  driver.manage().window().maximize();
	  driver.get("http://demowebshop.tricentis.com/");
	  driver.findElement(By.linkText("Contact us")).click();
  }
}
