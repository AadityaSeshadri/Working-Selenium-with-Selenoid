package pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Reusable_Functions;

	public class EventDurationPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EventDurationPage.class);
	WebDriverWait wait  ;

	@FindBy(how= How.XPATH, using="//*[text()='events by duration']")
	public static WebElement Lbl_PageTitle;

	public static void ValidatePageNavigation(WebDriver driver,String Text)
	{
		log.info("Class ------ EventDurationPage       Function -------ValidatePageNavigation");
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();

	}
    //****************Place required to change when xpath or property changes

}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	