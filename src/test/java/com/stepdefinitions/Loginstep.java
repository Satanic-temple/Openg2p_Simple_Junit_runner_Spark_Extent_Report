package com.stepdefinitions;

import org.junit.Assert;

import com.pages.loginpage;
import com.qa.driverfactory.DriverFactory;
import com.qa.util.Wait;

import io.cucumber.java.en.*;

public class Loginstep {
	private static String title;
	private static String Hometitle;
	private loginpage loginpage = new loginpage(DriverFactory.getDriver());
	private static String Errormsg;
	
	//LOG IN PAGE URL IS MENTIONED HERE
	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
		.get("https://pbms.qa1.openg2p.org/web/login");
	}

	@When("User gets page title")
	public void user_gets_page_title() {
		title = loginpage.getLoginPageTitle();
		System.out.println("Login Page title is: " + title);
	}

	@Then("Login page title should be {string}")
	public void Login_page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	  
	}
	@Then("Homepage title should be {string}")
	public void Home_page_title_should_be(String expectedTitleName) {
		loginpage.imWait();
		Assert.assertTrue(Hometitle.contains(expectedTitleName));
	  
	}

	@When("User enters Email {string}")
	public void user_enters_email(String username) {
		loginpage.enterUserName(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		loginpage.enterPassword(password);
	   	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	   loginpage.clickOnLogin();
	}

	@Then("User gets Homepage title")
	public void User_gets_Homepage_title() {
		loginpage.ClickonGroup_submenu();
		Wait.exwait_for_GroupPage();
		Hometitle = loginpage.getHomePageTitle();
		System.out.println("Home Page title is: " + Hometitle);
	}

	@Then("user gets Error message")
	public void user_gets_error_message() {
	loginpage.imWait();
	   Errormsg = loginpage.getErrormessage();
	}

	@Then("Error message should be {string}")
	public void error_message_should_be(String string) {
	  Assert.assertTrue(Errormsg.contains(Errormsg));
	}

}
