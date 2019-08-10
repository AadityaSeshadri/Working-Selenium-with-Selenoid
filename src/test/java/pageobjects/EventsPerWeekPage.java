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

public class EventsPerWeekPage {
	final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ReposPerWeekPage.class);
	static WebDriverWait wait  = Hooks.wait;
	@FindBy(how= How.ID, using="events-per-week")
	public static WebElement Lbl_Event_PageTitle;

	public static void ValidatePageNavigation(WebDriverWait wait,WebDriver driver,String Text)
	{
		log.info("Class ------ EventsPerWeekPage       Function -------ValidatePageNavigation");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("events-per-week")));
		Assert.assertEquals(Lbl_Event_PageTitle.getText(),Text);
		driver.navigate().back();


	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	