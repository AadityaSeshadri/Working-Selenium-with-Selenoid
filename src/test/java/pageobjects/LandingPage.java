package pageobjects;
//import helpers.Log;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Reusable_Functions;

import java.util.List;

//import pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class LandingPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LandingPage.class);
	 //WebDriver driver = Hooks.driver;
	WebDriverWait wait  ;
	//****************Place required to change when xpath or property changes
	@FindBy(how=How.ID, using="search")
	public static WebElement Lnk_Home;
	@FindBy(how=How.XPATH, using="//ul[@class='list-graph']")
	public static WebElement Lst_Graph;
	@FindBy(how=How.ID, using="search")
	public static WebElement Txt_Search;
	@FindBy(how=How.XPATH, using="//a[text()='suggestions']")
	public static WebElement Lnk_Search;
	@FindBy(how=How.XPATH, using="//a[text()='report bugs / send pull requests']")
	public static WebElement Lnk_PullRequests;
	@FindBy(how=How.XPATH, using="//p[text()='repositories per programming language']")
	public static WebElement Lnk_RepositoryPerProgrammingLanguage;
	@FindBy(how=How.XPATH, using="//p[text()='active user groups']")
	public static WebElement Lnk_ActiveUser;
	@FindBy(how=How.XPATH, using="//p[text()='event locations']")
	public static WebElement Lnk_EventLocation;
	//****************Place required to change when xpath or property changes


	public static void Navigate_LandingPage(WebDriver driver,String URL,String PageTitle)
	{
		//Hooks.driver.get(URL);
		Reusable_Functions.waitForPageLoaded(driver);
		Reusable_Functions.Navigate(driver,URL);
		Reusable_Functions.ValidatePageTitle(driver,PageTitle);



	}
	
	public static void check_Landing_Page_ListCount(WebDriver driver,int Count)
	{
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(Lnk_Home.isDisplayed());
		List<WebElement> options = Lst_Graph.findElements(By.tagName("li"));
		Assert.assertEquals(Count,options.size());

	}

	//div[@id='repos-per-week' and @class='graph']
	public static void check_Landing_Page_ListElement(WebDriver driver, List list) {

		List<WebElement> Elements = Lst_Graph.findElements(By.tagName("li"));
		for(int i=0;i<Elements.size();i++)
		{
			Assert.assertTrue(Elements.get(i).isDisplayed());
			Assert.assertEquals(Elements.get(i).getText(),list.get(i));
		}

	}

	public static void check_Landing_Page_YearlyReport(WebDriver driver, String Year, String OpenSourceRepoCount, String CountofCommits, String CountofEvents, String CountofGroups)
	{
		String Xpath_Total_OpenSource_Repos = "total-repos-";
		String Xpath_Total_Updates = "total-updates-";
		String Xpath_Total_Events = "total-events-";
		String Xpath_total_Groups = "total-groups-";

		Assert.assertEquals(OpenSourceRepoCount,driver.findElement(By.id(Xpath_Total_OpenSource_Repos+Year)).getText());
		Assert.assertEquals(CountofCommits,driver.findElement(By.id(Xpath_Total_Updates+Year)).getText());
		Assert.assertEquals(CountofEvents,driver.findElement(By.id(Xpath_Total_Events+Year)).getText());
		Assert.assertEquals(CountofGroups,driver.findElement(By.id(Xpath_total_Groups+Year)).getText());

	}



	public static void Navigate_listItems(WebDriver driver,String ListItem) {
		String Formedxpath = "";
		switch (ListItem)
		{
			case("repos per week"):  Formedxpath = "//p[text()='repos per week']";break;
			case("events per week"): Formedxpath = "//p[text()='events per week']";break;
			case("activities per programming languages"): Formedxpath = "//p[text()='activities per programming languages']";break;
			case("active user groups"): Formedxpath = "//p[text()='active user groups']";break;
			case("active repositories"): Formedxpath = "//p[text()='active repositories']";break;
			case("repositories per programming language"): Formedxpath = "//p[text()='repositories per programming language']";break;
			case("event day of week"): Formedxpath = "//p[text()='event day of week']";break;
			case("event per week of month"): Formedxpath = "//p[text()='event per week of month']";break;
			case("event duration"): Formedxpath = "//p[text()='event duration']";break;
			case("event time of day"): Formedxpath = "//p[text()='event time of day']";break;
			case("event locations"): Formedxpath = "//p[text()='event locations']";break;

		}

			driver.findElement(By.xpath(Formedxpath)).click();
			//Reusable_Functions.waitForPageLoaded(driver);


	}

	public static void EnterSearchValue(WebDriver driver,String searchtext)
	{
		Reusable_Functions.EnterTextBox(Txt_Search,searchtext);
	}

	public static String FormXpathforSearchCriteria(String ListItem) {
		String Formedxpath="";
		System.out.println("***************Value of List Item **********"+ ListItem);
		switch (ListItem)
		{
			case("repos per week"):  Formedxpath = "//*[@class='graph-name' and text()='repos per week']";break;
			case("events per week"): Formedxpath = "//*[@class='graph-name' and text()='events per week']";break;
			case("activities per programming languages"): Formedxpath = "//*[@class='graph-name' and text()='activities per programming languages']";break;
			case("active user groups"): Formedxpath = "//*[@class='graph-name' and text()='active user groups']";break;
			case("active repositories"): Formedxpath = "//*[@class='graph-name' and text()='active repositories']";break;
			case("repositories per programming language"): Formedxpath = "//*[@class='graph-name' and text()='repositories per programming language']";break;
			case("event day of week"): Formedxpath = "//*[@class='graph-name' and text()='event day of week']";break;
			case("event per week of month"): Formedxpath = "//*[@class='graph-name' and text()='event per week of month']";break;
			case("event duration"): Formedxpath = "//*[@class='graph-name' and text()='event duration']";break;
			case("event time of day"): Formedxpath = "//*[@class='graph-name' and text()='event time of day']";break;
			case("event locations"): Formedxpath = "//*[@class='graph-name' and text()='event locations']";break;

		}
		return Formedxpath;
	}

	public static void ValidateLinksNavigation(DataTable table,WebDriver driver,WebDriverWait wait) {
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

	public static void ValidateSocialMediaConnectivityInFooter(WebDriver driver, WebDriverWait wait)
	{
		driver.findElement(By.className("footer-twitter")).click();
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(driver.getTitle().contains("We Build SG (@webuildsg) | Twitter"));
		driver.navigate().back();
		Reusable_Functions.waitForPageLoaded(driver);


		driver.findElement(By.className("footer-facebook")).click();
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(driver.getTitle().contains("We Build SG - Home | Facebook"));
		driver.navigate().back();
		Reusable_Functions.waitForPageLoaded(driver);


		driver.findElement(By.className("footer-github")).click();
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(driver.getTitle().contains("GitHub"));
		driver.navigate().back();
		Reusable_Functions.waitForPageLoaded(driver);


		driver.findElement(By.className("footer-rss")).click();
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(driver.getTitle().contains("We Build SG LIVE - powered by FeedBurner"));
		driver.navigate().back();
		Reusable_Functions.waitForPageLoaded(driver);


		driver.findElement(By.className("footer-itunes")).click();
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(driver.getTitle().contains("We Build SG LIVE on Apple Podcasts"));
		driver.navigate().back();
		Reusable_Functions.waitForPageLoaded(driver);

		//We Build SG (@webuildsg) | Twitter
		//We Build SG - Home | Facebook
		//We Build SG ? GitHub
		//We Build SG LIVE - powered by FeedBurner
		//?We Build SG LIVE on Apple Podcasts
	}


	public static void ClickSuggestionLink(WebDriver driver) {
		Lnk_Search.click();
		Reusable_Functions.waitForPageLoaded(driver);

	}

	public static void PullRequestLink(WebDriver driver) {
		Lnk_PullRequests.click();
		Reusable_Functions.waitForPageLoaded(driver);
	}

	public static void ValidateTwitterNavigation(WebDriver driver) {
		Assert.assertTrue(driver.getTitle().contains("We Build SG (@webuildsg) | Twitter"));
		driver.navigate().back();
		Reusable_Functions.waitForPageLoaded(driver);
	}

	public static void ValidateGithubNavigation(WebDriver driver) {
		Assert.assertTrue(driver.getTitle().contains("GitHub"));
		driver.navigate().back();
		Reusable_Functions.waitForPageLoaded(driver);
	}

	public static void NavigatetoRepositoryPage(WebDriver driver) {
		Lnk_RepositoryPerProgrammingLanguage.click();
		Reusable_Functions.waitForPageLoaded(driver);
	}

	public static void NavigatetoActiveUserPage(WebDriver driver) {
		Lnk_ActiveUser.click();
		Reusable_Functions.waitForPageLoaded(driver);

	}

	public static void NavigatetoEventLocationPage(WebDriver driver) {
		Lnk_EventLocation.click();
		Reusable_Functions.waitForPageLoaded(driver);

	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	