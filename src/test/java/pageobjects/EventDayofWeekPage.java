package pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Reusable_Functions;

//import pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class EventDayofWeekPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EventDayofWeekPage.class);
	 //WebDriver driver = Hooks.driver;
	WebDriverWait wait  ;

	@FindBy(how= How.XPATH, using="//*[text()='events by day of week']")
	public static WebElement Lbl_PageTitle;

	public static void ValidatePageNavigation(WebDriver driver,String Text)
	{
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();

	}
    //****************Place required to change when xpath or property changes

}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	