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
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();

	}

    public static void CheckRepositoryPageLanguagesCount(WebDriver driver, Integer Count) {
		Reusable_Functions.waitForPageLoaded(driver);
		//Assert.assertTrue(List_ActiveUserGroups.isDisplayed());
		//WebElement rootElement = driver.findElement(By.xpath("//div[@class='graph']"));

		List<WebElement> options = driver.findElements(By.xpath("//div[@class='graph']//div[@class='bar']"));
		Assert.assertSame(Count, options.size());
    }
    //****************Place required to change when xpath or property changes
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	