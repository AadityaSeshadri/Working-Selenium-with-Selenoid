package pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Reusable_Functions;

import java.util.ArrayList;
import java.util.List;

//import pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class ActiveUserGroupsPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ActiveUserGroupsPage.class);
	 //WebDriver driver = Hooks.driver;
	WebDriverWait wait  ;

	@FindBy(how= How.XPATH, using="//*[text()='active user groups with > 5 events']")
	public static WebElement Lbl_PageTitle;
	@FindBy(how= How.ID, using="events-per-group")
	public static WebElement List_ActiveUserGroups;
	@FindBy(how= How.XPATH, using="//div[@id='events-per-group']//div[@class='bar']")
	public static WebElement List_ActiveUserGroupsNames;


	public static void ValidatePageNavigation(WebDriver driver,String Text)
	{
		log.info("Class ------ ActiveUserGroupsPage       Function -------ValidatePageNavigation");
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();

	}

    public static void CheckRepositoryPageLanguagesCount(WebDriver driver,WebDriverWait wait, Integer Count) {
		log.info("Class ------ ActiveUserGroupsPage       Function -------CheckRepositoryPageLanguagesCount");
		Reusable_Functions.waitForPageLoaded(driver);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='graph']"))));
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='graph']//div[@class='bar']"));
		Assert.assertSame(Count, options.size());
    }

	public static void ValidateGroupInfo(WebDriverWait wait, WebDriver driver, String Index,String GroupName, String NumberofActiveUsers)
	{
		log.info("Class ------ ActiveUserGroupsPage       Function -------ValidateGroupInfo");
		Assert.assertEquals(GroupName,driver.findElement(By.xpath("//div[@class='graph']/div[@class='bar']["+Index+"]/div[@class='graph-label']/a")).getText());
		Assert.assertEquals(NumberofActiveUsers,driver.findElement(By.xpath("//div[@class='graph']/div[@class='bar']["+Index+"]/div[@class='graph-bar']")).getText());
	}

	public static void ClickGroupName(WebDriver driver, WebDriverWait wait, String GroupName) {
		log.info("Class ------ ActiveUserGroupsPage       Function -------ClickGroupName");
		driver.findElement(By.xpath("//a[contains(text(),'"+GroupName+"')]")).click();
	}

	public static void ValidateNavigationtoMeetup(WebDriver driver, WebDriverWait wait, String MeetupGroupName) {
		log.info("Class ------ ActiveUserGroupsPage       Function -------ValidateNavigationtoMeetup");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='groupHomeHeader-groupNameLink']"))));

	}
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	