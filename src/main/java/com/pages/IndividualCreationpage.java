package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.driverfactory.DriverFactory;
import com.qa.util.Wait;

public class IndividualCreationpage {
	private WebDriver driver;

	// 1. By Locators: OR
	private By individual_submenu = By.xpath("//a[normalize-space()='Individuals']");
	private By individual_submenu_in_CreatePage = By.xpath("//a[@role='menuitem'][normalize-space()='Individuals']");
	private By individual_newbutton = By.xpath("//div[@class='d-none d-xl-inline-flex gap-1']//button[@type='button'][normalize-space()='New']");
	private By Familyname = By.xpath("//input[@id='family_name_0']");
	private By Givenname = By.xpath("//input[@id='given_name_0']");
	private By Savebutton = By.xpath("//button[@aria-label='Save manually']");
	private By Createnewbutton = By.xpath("//div[@class='d-none d-xl-inline-flex gap-1']//button[@type='button'][normalize-space()='New']");
	private By Searchbar = By.xpath("//input[@placeholder='Search...']");
	private By Searchrecord = By.xpath("//td[@name='name']");
	public String familyname1;
	public String givenname1;
	public static String firstrecord_name;
	
	public IndividualCreationpage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:
	public void userClickonindividual_submenu() {
		imWait();
		driver.findElement(individual_submenu).click();
	}
	
	public String getIndividualpagetitle() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getTitle();
	}
	public void userClickOnNewButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(individual_newbutton).click();
	}
	public void userEnterFamilyname(String family_name) {
		imWait();
		driver.findElement(Familyname).sendKeys(family_name);
		familyname1 = family_name;
	}
	public void userEnterGivename(String given_name) {
		imWait();
		driver.findElement(Givenname).sendKeys(given_name);
		givenname1 = given_name;
	}
	public void userClicksOnSaveButton() {
		imWait();
		driver.findElement(Savebutton).click();
	}
	public void userClickOnCreateNewButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Createnewbutton).click();
	}
	public void userClickOnIndividual_submenu_in_CreatePage() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(individual_submenu_in_CreatePage).click();
	}
	public void UserClicksOnSearchbar() {
		//exwait_for_Searchbar();
		WebElement serachbox = driver.findElement(Searchbar);
		serachbox.click();
	}
	public void UsersearchesIndividualName(String combined_name) {
		System.out.println("IndividualName is :"+combined_name);
		driver.findElement(Searchbar).sendKeys(combined_name+ Keys.ENTER);
		//String IndividualName = familyname1+", "+givenname1;
		//System.out.println("IndividualName is :"+IndividualName);
		//driver.findElement(Searchbar).sendKeys(IndividualName+ Keys.ENTER);
	}
	
	public void UserClearsFamilynameandGivenname() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Familyname).clear();
		driver.findElement(Givenname).clear();
	}
	public void Get_individual_records() throws InterruptedException {
		Thread.sleep(3000);
		WebElement firstrecord = driver.findElement(Searchrecord);
		firstrecord_name = firstrecord.getText();
		 System.out.println("First record name is:"+firstrecord_name);
		
	}
	//Wait
		 static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
			public static void imWait() {
				DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
			}
		    public static void exwait_for_GroupPage() {
		    	
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='min-w-0 text-truncate']")));
		    }
		    public static void exwait_for_IndividualPage() {
		   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Date of Birth']")));
		    }
		    public static void exwait_for_Searchbar() {
			   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Searchbar")));
			    }
		    public static void exwait_for_Searchrecord() {
			   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Searchrecord")));
			    }
		    
	

	
}
