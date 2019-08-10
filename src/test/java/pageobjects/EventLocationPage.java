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

	public class EventLocationPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EventLocationPage.class);
	WebDriverWait wait  ;

	@FindBy(how= How.XPATH, using="//*[text()='popular event locations']")
	public static WebElement Lbl_PageTitle;
	@FindBy(how= How.XPATH, using="//div[@class='map']")
	public static WebElement Map_Locations;

	public static void ValidatePageNavigation(WebDriver driver,String Text)
	{
		log.info("Class ------ EventLocationPage       Function -------ValidatePageNavigation");
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();

	}

	public static void ValidateMapExistence(WebDriver driver,WebDriverWait wait) {
		log.info("Class ------ EventLocationPage       Function -------ValidateMapExistence");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='map']"))));
		Assert.assertTrue(Map_Locations.isDisplayed());

	}

    public static void ValidateMapDetails(WebDriver driver, WebDriverWait wait,String source) {
		log.info("Class ------ EventLocationPage       Function -------ValidateMapDetails");
	    Assert.assertEquals(source,driver.findElement(By.xpath("//div[@class='map']/script")).getAttribute("src"));
    }


}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	