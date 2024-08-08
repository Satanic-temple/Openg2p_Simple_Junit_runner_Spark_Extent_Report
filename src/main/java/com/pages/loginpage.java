package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.driverfactory.DriverFactory;
import com.qa.util.Wait;

public class loginpage {
	private WebDriver driver;

	// 1. By Locators: OR
	private By emailId = By.id("login");
	private By password = By.xpath("//input[@id='password']");
	private By signInButton = By.xpath("//button[contains(text(),'Log in')]"); 
	private By LoginError = By.xpath("//p[@role='alert']");
	private By group_submenuBy = By.xpath("//a[normalize-space()='Groups']");
	
	// 2. Constructor of the page class:
	public loginpage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		imWait();
		return driver.getTitle();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
		
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
		imWait();
	}
	
	public IndividualCreationpage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new IndividualCreationpage(driver);
	
	}
	public String getErrormessage() {
		return driver.findElement(LoginError).getText();
		
	}
	public String getHomePageTitle() {
		return driver.getTitle();
}
	public void ClickonGroup_submenu() {
		imWait();
		driver.findElement(group_submenuBy).click();
	}
	//Wait
	 static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
		public static void imWait() {
			DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		}
	    public static void exwait_for_GroupPage() {
	    	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='min-w-0 text-truncate']")));
	    }
	    public static void exwait_for_IndividualPage() {
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Date of Birth']")));
	   	////span[@class='min-w-0 text-truncate' and contains(text(),Individuals)]
	    }
	
}
