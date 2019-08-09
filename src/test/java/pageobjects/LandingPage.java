package pageobjects;
//import helpers.Log;

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
	@FindBy(how=How.ID, using="total-repos-2017")
	public static WebElement Lbl_TotalRepos2017;
	@FindBy(how=How.ID, using="total-updates-2017")
	public static WebElement Lbl_TotalUpdates2017;
	@FindBy(how=How.ID, using="total-events-2017")
	public static WebElement Lbl_TotalEvents2017;
	@FindBy(how=How.ID, using="total-groups-2017")
	public static WebElement Lbl_TotalGroups2017;


	@FindBy(how=How.ID, using="total-repos-2016")
	public static WebElement Lbl_TotalRepos2016;
	@FindBy(how=How.ID, using="total-repos-2015")
	public static WebElement Lbl_TotalRepos2015;

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
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	