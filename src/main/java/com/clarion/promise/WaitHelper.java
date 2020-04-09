package com.clarion.promise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WaitHelper {
	
private static WebDriver driver;


	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public static void WaitHelperInompicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

}
