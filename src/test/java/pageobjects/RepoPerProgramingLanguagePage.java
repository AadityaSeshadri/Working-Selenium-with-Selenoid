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

import java.util.List;

import static org.junit.Assert.assertEquals;

//import pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class RepoPerProgramingLanguagePage
{
	final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(RepoPerProgramingLanguagePage.class);
	//WebDriver driver = Hooks.driver;
	WebDriverWait wait;

	@FindBy(how = How.XPATH, using = "//*[text()='repositories per programming languages']")
	public static WebElement Lbl_PageTitle;
	@FindBy(how = How.ID, using = "select-language")
	public static WebElement List_SelectLanguage;
	@FindBy(how = How.XPATH, using = "//div[@id='repos-per-programming-language']")
	public static WebElement List_ReposPerProgrammingLanguage;

	public static void ValidatePageNavigation(WebDriver driver, String Text) {
		Reusable_Functions.waitForPageLoaded(driver);
		assertEquals(Lbl_PageTitle.getText(), Text);
		driver.navigate().back();

	}

	public static void CheckRepositoryPageLanguagesCount(WebDriver driver, Integer Count) {
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(List_SelectLanguage.isDisplayed());
		List<WebElement> options = List_SelectLanguage.findElements(By.tagName("li"));
		Assert.assertSame(Count, options.size());
	}

	public static void ValidateLanguageWithIndex(WebDriverWait wait, WebDriver driver, String Index, String LanguageName, String RepoCount) {
		if (Integer.parseInt(RepoCount) != 0) {
			Assert.assertTrue(driver.findElement(By.xpath("//ul[@id='select-language']/li[" + Index + "]")).getText().contains(LanguageName));

			driver.findElement(By.xpath("//ul[@id='select-language']/li[" + Index + "]/label")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='repos-per-programming-language']"))));
			Assert.assertSame(Integer.parseInt(RepoCount), List_ReposPerProgrammingLanguage.findElements(By.tagName("p")).size());
			System.out.println("{{{{{{{{Validation done for Xpath ------------>" + "//ul[@id='select-language']/li[" + Index + "]");
		}


	}

	public static void SelectProgrammingLanguage(WebDriver driver, String SelectedProgramingLanguage) {
		String xpath;
		xpath = "//label[@id='language-" + SelectedProgramingLanguage.toLowerCase() + "']";
		System.out.println("Formed xpath++++++++++++"+ xpath);
		driver.findElement(By.xpath(xpath)).click();

	}


	public static void ClickRepo(WebDriver driver, String Repo) {
		String xpath;
		xpath = "//div[@id='repos-per-programming-language']//a[text()='"+Repo+"']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		}
		catch (Exception e)
		{
			log.error("Given Repo is not under Programming Language");
		}


	}

	public static void VaidateGithubLink(WebDriver driver,String RepoTitle) {
		String xpath;
		Reusable_Functions.waitForPageLoaded(driver);
		xpath = "//a[text()='"+RepoTitle+"']";
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());

	}
}



		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	