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
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomePage.class);
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
			Assert.assertEquals(Elements.get(i).getText(),list.get(i));
		}

	}

	public static void check_Landing_Page_YearlyReport(WebDriver driver, String Year, String OpenSourceRepoCount, String CountofCommits, String CountofEvents, String CountofGroups)
	{
		String Xpath_Total_OpenSource_Repos = "total-repos-";
		String Xpath_Total_Updates = "total-updates-";
		String Xpath_Total_Events = "total-events-";
		String Xpath_total_Groups = "total-groups-";

		Assert.assertEquals(driver.findElement(By.id(Xpath_Total_OpenSource_Repos+Year)).getText(),OpenSourceRepoCount);
		Assert.assertEquals(driver.findElement(By.id(Xpath_Total_Updates+Year)).getText(),CountofCommits);
		Assert.assertEquals(driver.findElement(By.id(Xpath_Total_Events+Year)).getText(),CountofEvents);
		Assert.assertEquals(driver.findElement(By.id(Xpath_total_Groups+Year)).getText(),CountofGroups);

	}

	public static void check_Landing_Page_ListNavigations(WebDriver driver, String s, String s1) {
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	