package com.clarion.promise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PromisePage {

	private WebDriver driver;
	
    @FindBy(xpath="//table/tbody/tr[2]/td/ul/li[1]/a[contains(text(),'Log Promise')]") WebElement logPromise;
	
	@FindBy(xpath="//select[@name='cboEmp']") WebElement promiseFrom;
	
	@FindBy(id="txtPromise") WebElement promiseText;
	
	@FindBy(xpath="//input[@value='Log Promise']") WebElement logPromiseButton;

	@FindBy(xpath="//select[@id='cboEmp']") WebElement selectPromisor;
	
	@FindBy(xpath="//input[@name='txtStartDate']") WebElement startDate;
	@FindBy(xpath="//input[@name='txtEndDate']") WebElement endDate;
	
	@FindBy(xpath="//input[@value='Search']") WebElement search;
	
	@FindBy(xpath="//a[@href='../logout.php']") WebElement logout;
	
	@FindBy(xpath="//td[contains(text(),'I have made my promise here')]") WebElement verifyPromiseText;

	
	public PromisePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void PromisePagePromiseLink() {
		logPromise.click();;
	}
	
	public void PromisePagePromiseFrom(String VisibleText) {
		Select s= new Select(promiseFrom);
		s.selectByVisibleText(VisibleText);
	}
	
	public void PromisePagePromise(String s) {
		promiseText.sendKeys(s);
	}
	
	public void PromisePageLogPromiseButton() {
		logPromiseButton.click();
	}
	
	public void PromisePageSelectPromisor(String VisibleText) {
		Select s= new Select(promiseFrom);
		s.selectByVisibleText(VisibleText);
	}
	
	public void PromisePageSearchPromise() {
		search.click();
	}
	
	public void PromisePageLogout() {
		logout.click();
	}
	
	public void PromisePageStartDate(String todayDate) {
		startDate.sendKeys(todayDate);
	}
	
	public void PromisePageEndDate(String date) {
		endDate.sendKeys(date);
	}
	
	public String PromisePageVerifyPromiseText() {
		String text = verifyPromiseText.getText();
		return text;
	}
}
