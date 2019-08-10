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

    @When("^User Clicks on Suggestion Link$")
    public void user_Clicks_on_Suggestion_Link() throws Throwable {
        LandingPage.ClickSuggestionLink(driver);
    }

    @Then("^User Navigated to Twitter Page of We Build SG$")
    public void user_Navigated_to_Twitter_Page_of_We_Build_SG() throws Throwable {
        LandingPage.ValidateTwitterNavigation(driver);
    }

    @When("^User Clicks on Pull Request Link$")
    public void user_Clicks_on_Pull_Request_Link() throws Throwable {
        LandingPage.PullRequestLink(driver);
    }

    @Then("^User Navigated to Github Page of We Build SG$")
    public void user_Navigated_to_Github_Page_of_We_Build_SG() throws Throwable {
        LandingPage.ValidateGithubNavigation(driver);
    }

    @When("^Navigate to ActiveUser Page$")
    public void NavigateToActiveUserPage() throws Throwable {
        LandingPage.NavigatetoActiveUserPage(driver);
    }

    @When("^Navigate to Repositories Page$")
    public void NavigateToRepositoryPage() throws Throwable {
        LandingPage.NavigatetoRepositoryPage(driver);
    }

    @When("^Navigate to EventLocation Page$")
    public void NavigateToEventLocation() throws Throwable {
        LandingPage.NavigatetoEventLocationPage(driver);
    }



    @Then("^Validate Expected Number of Available Languages$")
    public void Validates_CountofLanguages(DataTable table) throws Throwable {
        List<Integer> list = table.asList(int.class);
        RepoPerProgramingLanguagePage.CheckRepositoryPageLanguagesCount(driver,list.get(0));

    }
    @And("^Validate Languages Names and Repositories Under Each Language$")
    public void ValidateLanguageNames(DataTable table) throws Throwable {
        int i;
        List<String> list = table.asList(String.class);
        System.out.println("|||||||||||||||List Size||||||||"+list.size());
       for (i=0;i==(list.size());i+=3)
       {
           RepoPerProgramingLanguagePage.ValidateLanguageWithIndex(wait,driver,list.get(i),list.get(i+1),list.get(i+2));
       }
    }
    @Then("^Select below Programming Language$")
    public void SelectProgrammingLanguage(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        RepoPerProgramingLanguagePage.SelectProgrammingLanguage(driver,list.get(0));
    }
    @And("^Click Repo of the selected programming language$")
    public void ClickRepo(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        RepoPerProgramingLanguagePage.ClickRepo(driver,list.get(0));
    }
    @Then("^Should we navigated to GitHub Page of Repo$")
    public void NavigatedtoGithub(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        RepoPerProgramingLanguagePage.VaidateGithubLink(driver,list.get(0));
    }

    @Then("^Validate Total Count of Active User Group$")
    public void Validates_CountofActiveUserGroups(DataTable table) throws Throwable {
        List<Integer> list = table.asList(int.class);
        ActiveUserGroupsPage.CheckRepositoryPageLanguagesCount(driver,wait,list.get(0));

    }
    @And("^Validate Group Name Count of Users and Last Updated DateTime$")
    public void ValidateGroupInfo(DataTable table) throws Throwable {
        int i;
        List<String> list = table.asList(String.class);
        System.out.println("|||||||||||||||List Size||||||||"+list.size());
        //System.out.println("-------------------Before For Loop-------------");
        for (i=0;i<=(list.size()-1);i+=4)
        {
            //System.out.println("-------------------Inside For Loop-------------");
            ActiveUserGroupsPage.ValidateGroupInfo(wait,driver,list.get(i),list.get(i+1),list.get(i+2));
        }
    }
    @When("^Clicked on Group Name$")
    public void ClickGroupName(DataTable table) throws Throwable {
        List<String > list = table.asList(String.class);
        ActiveUserGroupsPage.ClickGroupName(driver,wait,list.get(0));

    }
    @Then("^Navigated to Meetup Website$")
    public void NavigatedtoMeetup(DataTable table) throws Throwable {
        List<String > list = table.asList(String.class);
        ActiveUserGroupsPage.ValidateNavigationtoMeetup(driver,wait,list.get(0));

    }

    @When("^Validate Popular Event Location Map$")
    public void ValidatePopularEventLocation() throws Throwable {
        EventLocationPage.ValidateMapExistence(driver,wait);
    }

    @And("^Validate Map Script Details$")
    public void ValidateMapDetails(DataTable table) throws Throwable {
        List<String > list = table.asList(String.class);
        EventLocationPage.ValidateMapDetails(driver,wait,list.get(0));
    }
}