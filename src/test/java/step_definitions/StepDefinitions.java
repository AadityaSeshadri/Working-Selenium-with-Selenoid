package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.*;

import java.util.List;

public class StepDefinitions {
    public WebDriver driver;
    public Scenario scenario;

    public StepDefinitions()
    {
    	driver = Hooks.driver;
    	scenario = Hooks.scenario;
        PageFactory.initElements(driver, ActiveReposPage.class);
        PageFactory.initElements(driver, ActiveUserGroupsPage.class);
        PageFactory.initElements(driver, ActivitiesPerProgrammingPage.class);
        PageFactory.initElements(driver, EventDayofWeekPage.class);
        PageFactory.initElements(driver, EventDurationPage.class);
        PageFactory.initElements(driver, EventLocationPage.class);
        PageFactory.initElements(driver, EventPerWeekofMonthPage.class);
        PageFactory.initElements(driver, EventTimeOfDayPage.class);
        PageFactory.initElements(driver, LandingPage.class);
        PageFactory.initElements(driver, RepoPerProgramingLanguagePage.class);
        PageFactory.initElements(driver, ReposPerWeekPage.class);

    }

    @Given("^User Navigates to Landing Page$")
    public void User_Navigates_Landing_Page(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        LandingPage.Navigate_LandingPage(driver,list.get(0),list.get(1));


    }
  
    @Then("^Validate Number of elements under list graph$")
    public void Validates_ElementCount(DataTable table) throws Throwable {
        List<Integer> list = table.asList(int.class);
        LandingPage.check_Landing_Page_ListCount(driver,list.get(0));

    }

    @And("^Validate element Names under list graph$")
    public void Validates_ElementText(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        LandingPage.check_Landing_Page_ListElement(driver,list);

    }

    @And("^Validate Yearly Report$")
    public void Validates_YearlyReport(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        LandingPage.check_Landing_Page_YearlyReport(driver,list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));

    }

    @And("^Validate Navigations When Links from List Graph clicked$")
    public void Validates_LiksNavigations(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        LandingPage.Navigate_listItems(driver,list.get(0));
        switch (list.get(0))
        {
            case("repos per week"): ReposPerWeekPage.ValidateRepoPerWeekPage(list.get(1));

        }


        driver.navigate().back();

    }
}