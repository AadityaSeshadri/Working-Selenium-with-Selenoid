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
	public class RepoPerProgramingLanguagePage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(RepoPerProgramingLanguagePage.class);
	 //WebDriver driver = Hooks.driver;
	WebDriverWait wait  ;

	@FindBy(how= How.XPATH, using="//*[text()='repositories per programming languages']")
	public static WebElement Lbl_PageTitle;
	@FindBy(how= How.ID, using="select-language")
	public static WebElement List_SelectLanguage;

	public static void ValidatePageNavigation(WebDriver driver,String Text)
	{
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		driver.navigate().back();

	}

    public static void CheckRepositoryPageLanguagesCount(WebDriver driver, Integer Count) {
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(List_SelectLanguage.isDisplayed());
		List<WebElement> options = List_SelectLanguage.findElements(By.tagName("li"));
		Assert.assertSame(Count,options.size());
    }

	public static void ValidateLanguageWithIndex(WebDriver driver,String Index, String LanguageName) {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@id='select-language']/li["+Index+"]")).getText().contains(LanguageName));

	}

	//****************Place required to change when xpath or property changes
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	