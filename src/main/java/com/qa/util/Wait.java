package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.driverfactory.DriverFactory;

public class Wait {
	 static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
	public static void imWait() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
    public static void exwait_for_GroupPage() {
    	
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='min-w-0 text-truncate']")));
    }
    public static void exwait_for_IndividualPage() {
   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Date of Birth']")));
   	////span[@class='min-w-0 text-truncate' and contains(text(),Individuals)]
    }
}
