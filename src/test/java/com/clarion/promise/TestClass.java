package com.clarion.promise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	WebDriver driver;
	LoginPage loginPage;
	PromisePage promisePage;
    @BeforeMethod
	public void SetUpForBeforeClass() {
		System.setProperty("webdriver.chrome.driver",ResourceHelper.getResourcePath("\\Drivers\\chromedriver.exe"));
		driver = new ChromeDriver();
		driver.navigate().to("http://182.74.238.209/clarion_promise_qa/index.php");
		WaitHelper.WaitHelperInompicitWait(20);
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		promisePage= new PromisePage(driver);
	}

	@Test
	public void TC1() {
	loginPage.loginPageLoginButton();
	Assert.assertEquals("Invalid Username/password", loginPage.loginPageValidationForInvalidUser());
	}

	@Test
	public void TC2() {
		loginPage.loginPageUserName("sanjeetk@clariontechnologies.co.in");
		loginPage.loginPagePassword("clarion");
		loginPage.loginPageLoginButton();
		Assert.assertEquals("Promises Log", driver.getTitle());
	}

	@Test
	public void TC3() {
		loginPage.loginPageUserName("sanjeetk@clariontechnologies.co.in");
		loginPage.loginPagePassword("clarion");
		loginPage.loginPageLoginButton();
		promisePage.PromisePagePromiseLink();
		promisePage.PromisePagePromiseFrom("Sonali test");
		promisePage.PromisePagePromise("I have made my promise here");
		promisePage.PromisePageLogPromiseButton();
	}
	
	@Test
	public void TC4() {
		String PromiseText="I have made my promise here";
		loginPage.loginPageUserName("sanjeetk@clariontechnologies.co.in");
		loginPage.loginPagePassword("clarion");
		loginPage.loginPageLoginButton();
		promisePage.PromisePagePromiseLink();
		promisePage.PromisePagePromiseFrom("Sonali test");
		promisePage.PromisePagePromise(PromiseText);
		promisePage.PromisePageLogPromiseButton();
		promisePage.PromisePageSelectPromisor("Sonali test");
		promisePage.PromisePageStartDate("09-04-2020");
		promisePage.PromisePageEndDate("09-04-2020");
		promisePage.PromisePageSearchPromise();
		promisePage.PromisePageVerifyPromiseText();
		Assert.assertEquals(PromiseText, promisePage.PromisePageVerifyPromiseText());
	}
	
	@Test
	public void TC5() {
		loginPage.loginPageUserName("sanjeetk@clariontechnologies.co.in");
		loginPage.loginPagePassword("clarion");
		loginPage.loginPageLoginButton();
		promisePage.PromisePagePromiseLink();
		promisePage.PromisePageLogout();
	}

	@AfterMethod
	public void cleanUp() {
	  driver.quit();;	
	}
}
