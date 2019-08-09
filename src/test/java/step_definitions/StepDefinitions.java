package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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
        LandingPage.ValidateLinksNavigation(table,driver,wait);
    }

    @When("^User Enters below value on Search Edit Box$")
    public void UserEntersValueInSearchBox(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        LandingPage.EnterSearchValue(driver,list.get(0));

    }

    @Then("^System should show below Options from list graph$")
    public void system_should_show_below_Options_from_list_graph(DataTable arg1) throws Throwable {
        int i;
        int j = 1;
        String xpath;
        List<String> list = arg1.asList(String.class);
        for (i = 0; i <= list.size() - 2; i += 2)
        {
            System.out.println("Value of I insode i loop ++++++++++++" + i + "+++++++++"+ list.get(i));
             xpath = LandingPage.FormXpathforSearchCriteria(list.get(i));
            System.out.println("**************Value of Xpath in Step Def" + xpath);
            while (j <= list.size() - 1)
            {
                System.out.println("&&&&&&&&&&&&&&&&&&&&&Value of J "+ list.get(j));
                if(list.get(j).equals("Yes"))
                {
                    Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
                }
                else
                {
                    Assert.assertTrue(!driver.findElement(By.xpath(xpath)).isDisplayed());
                }
                j+=2;
                break;

            }

        }
    }

    @When("^User Clicks Social Media Links on Footer and Validate Connectivity to External Social Media$")
    public void User_Clicks_Link_on_Footer() throws Throwable {
        //List<String> list = table.asList(String.class);
        LandingPage.ValidateSocialMediaConnectivityInFooter(driver,wait);

    }




}