package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;

import java.util.List;

public class StepDefinitions {
    public WebDriver driver;
    public Scenario scenario;
    public WebDriverWait wait;

    public StepDefinitions()
    {
    	driver = Hooks.driver;
    	scenario = Hooks.scenario;
    	wait = Hooks.wait;
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
        LandingPage.check_Landing_Page_YearlyReport(driver,list.get(5),list.get(6),list.get(7),list.get(8),list.get(9));
        LandingPage.check_Landing_Page_YearlyReport(driver,list.get(10),list.get(11),list.get(12),list.get(13),list.get(14));

    }

    @And("^Validate Navigations When Links from List Graph clicked$")
    public void Validates_LiksNavigations(DataTable table) throws Throwable {
        int i;
        int j = 1;
        List<String> list = table.asList(String.class);
        for (i = 0; i <= list.size() - 2; i += 2)
        {
            System.out.println("Value of I insode i loop ++++++++++++" + i + "+++++++++"+ list.get(i));
            LandingPage.Navigate_listItems(driver, list.get(i));
            while (j <= list.size() - 1)
            {
                System.out.println("Value of J insode i loop ++++++++++++" + j + "+++++++++"+ list.get(j));
                switch (list.get(j)) {
                    case ("repositories updated per week"):
                        ReposPerWeekPage.ValidatePageNavigation(wait, driver, list.get(j));
                        break;
                    case ("events per week"):
                        EventsPerWeekPage.ValidatePageNavigation(wait, driver, list.get(j));
                        break;
                    case ("update activities per programming languages"):
                        ActivitiesPerProgrammingPage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("active user groups with > 5 events"):
                        ActiveUserGroupsPage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("active repos with > 10 updates"):
                        ActiveReposPage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("repositories per programming languages"):
                        RepoPerProgramingLanguagePage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("events by day of week"):
                        EventDayofWeekPage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("events per week of month"):
                        EventPerWeekofMonthPage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("events by duration"):
                        EventDurationPage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("events by time of day"):
                        EventTimeOfDayPage.ValidatePageNavigation(driver, list.get(j));
                        break;
                    case ("popular event locations"):
                        EventLocationPage.ValidatePageNavigation(driver, list.get(j));
                        break;

                }
                j+=2;
                break;
            }

        }
    }
}