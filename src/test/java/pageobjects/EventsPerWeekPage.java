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
import step_definitions.Hooks;

//import pageobjects.Log;;
//public class HomePage extends BaseClass{
public class EventsPerWeekPage {
	final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ReposPerWeekPage.class);
	//WebDriver driver = Hooks.driver;
	static WebDriverWait wait  = Hooks.wait;
	//****************Place required to change when xpath or property changes
	@FindBy(how= How.ID, using="events-per-week")
	public static WebElement Lbl_Event_PageTitle;

	public static void ValidatePageNavigation(WebDriverWait wait,WebDriver driver,String Text)
	{

		wait.until(ExpectedConditions.elementToBeClickable(By.id("events-per-week")));
		System.out.println("^^^^^^^^^^^^^Check whether element Displayed"+ Lbl_Event_PageTitle.isDisplayed());
		Assert.assertEquals(Lbl_Event_PageTitle.getText(),Text);
		driver.navigate().back();


	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	