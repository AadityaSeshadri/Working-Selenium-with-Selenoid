package pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Reusable_Functions;


	public class EventPerWeekofMonthPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EventPerWeekofMonthPage.class);
	 //WebDriver driver = Hooks.driver;
	WebDriverWait wait  ;

	@FindBy(how= How.XPATH, using="//*[text()='events per week of month']")
	public static WebElement Lbl_PageTitle;

	public static void ValidatePageNavigation(WebDriver driver,String Text)
	{
		log.info("Class ------ EventPerWeekofMonthPage       Function -------ValidatePageNavigation");
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();

	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	