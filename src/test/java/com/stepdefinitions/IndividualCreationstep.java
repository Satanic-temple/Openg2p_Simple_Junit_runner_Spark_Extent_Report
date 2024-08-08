package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;

import com.pages.IndividualCreationpage;
import com.pages.loginpage;
import com.qa.driverfactory.DriverFactory;
import com.qa.util.Wait;

import dev.failsafe.Call;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class IndividualCreationstep {
	private static String title;
	public static String combined_name;
	public String familyname;
	public String givenname;
	private loginpage loginpage = new loginpage(DriverFactory.getDriver());
	private IndividualCreationpage individualCreationpage;
	
@Given("user has already logged in to application")
public void user_has_already_logged_in_to_application(DataTable credTable) {
	
	List<Map<String, String>> credList = credTable.asMaps();
	String userName = credList.get(0).get("username");
	String password = credList.get(0).get("password");
	DriverFactory.getDriver().get("https://pbms.qa1.openg2p.org/web/login");
	individualCreationpage = loginpage.doLogin(userName, password);
}

@Given("User is on Individual list view page")
public void user_is_on_individual_list_view_page() {
	individualCreationpage.userClickonindividual_submenu();
}

@Then("User gets Individual page title")
public void user_gets_individual_page_title() throws InterruptedException {
	IndividualCreationpage.exwait_for_IndividualPage();
	//ex wait untill DOB field appears
   title = individualCreationpage.getIndividualpagetitle();
   System.out.println("individualCreationpage Page title is: " + title);
}

@Then("Individual page title should be {string}")
public void individual_page_title_should_be(String Expectedtitle) {
Assert.assertTrue(title.contains(Expectedtitle));
}

@When("User clicks on New button")
public void user_clicks_on_new_button() throws InterruptedException {
	individualCreationpage.userClickOnNewButton();
}

@Then("User gets Individual Creation page title")
public void user_gets_individual_creation_page_title() throws InterruptedException {
individualCreationpage.userClickOnIndividual_submenu_in_CreatePage();
String individualCreationpage_title =  individualCreationpage.getIndividualpagetitle();
System.out.println("individual Creation page title is: "+ individualCreationpage_title);
}

@Then("Individual Creation page title should be {string}")
public void individual_creation_page_title_should_be(String Expectedpagetitle) {
	Assert.assertTrue(title.contains(Expectedpagetitle));
}

@When("User enters Follwong Individual names")
public void user_enters_follwong_individual_names(DataTable nameTable) throws InterruptedException {
	List<Map<String, String>> names = nameTable.asMaps(String.class, String.class);
    for (Map<String, String> name : names) {
       familyname = name.get("family_name");
       givenname = name.get("given_name");
       combined_name = familyname+", "+givenname;
       System.out.println("combined_name is: "+combined_name);
        // Create a method to enter names
        individualCreationpage.userEnterFamilyname(familyname);
        individualCreationpage.userEnterGivename(givenname);
        individualCreationpage.userClicksOnSaveButton();
        individualCreationpage.userClickOnCreateNewButton();
        // calling a method to clear both txt boxes
        individualCreationpage.UserClearsFamilynameandGivenname();

    }
    System.out.println("combined_name out of for loop is: "+combined_name);
}

@When("User Clicks on save button")
public void user_clicks_on_save_button() {
   }

@When("User enters search keyword press Enter")
public void user_enters_search_keyword_press_enter() throws InterruptedException {
	individualCreationpage.UserClicksOnSearchbar();
	//IndividualCreationpage icg = new IndividualCreationpage(null);
	//individualCreationpage.UsersearchesIndividualName(icg.familyname1,icg.givenname1);
	//individualCreationpage.UsersearchesIndividualName(combined_name);
	individualCreationpage.UsersearchesIndividualName(combined_name);
}

@Then("User gets Individual records")
public void user_gets_individual_records() throws InterruptedException {
//Call a method which gets the text of first matching record
	// use get text and store this string in a public static variable 
	individualCreationpage.Get_individual_records();
}

@Then("Individual name should be {string}")
public void individual_name_should_be(String Expectedname) {
	//user assert to test get text from last method matches with combined_name
	//Assert.assertTrue(Expectedname.contains(combined_name));
	Assert.assertTrue("Strings are not equal ignoring case", Expectedname.equalsIgnoreCase(combined_name));
}

	
	
}
