package pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

//import pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class ReposPerWeekPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ReposPerWeekPage.class);
	 //WebDriver driver = Hooks.driver;
	WebDriverWait wait  ;
	//****************Place required to change when xpath or property changes
	@FindBy(how= How.XPATH, using="//h3[text()='repositories updated per week']")
	public static WebElement Lbl_PageTitle;

	public static void ValidateRepoPerWeekPage(String Text)
	{
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);

	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	