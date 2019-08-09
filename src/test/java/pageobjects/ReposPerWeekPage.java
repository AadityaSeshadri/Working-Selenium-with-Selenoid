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
	public class ReposPerWeekPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ReposPerWeekPage.class);
	 //WebDriver driver = Hooks.driver;
	 static WebDriverWait wait  = Hooks.wait;
	//****************Place required to change when xpath or property changes
	@FindBy(how= How.XPATH, using="//*[text()='repositories updated per week']")
	public static WebElement Lbl_PageTitle;

	public static void ValidatePageNavigation(WebDriverWait wait,WebDriver driver,String Text)
	{

		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='repositories updated per week']")));
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();


	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	