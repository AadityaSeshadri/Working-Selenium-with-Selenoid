package step_definitions;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reusable_Functions {
    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Reusable_Functions.class);
    public static HashMap<String, String> hashMap = new HashMap<String, String>();
    public static void Take_Screenshot(WebDriver driver, Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
    public static void Set_PreRequisites(Scenario scenario) throws IOException {
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+scenario.getName()));
        PropertyConfigurator.configure("log4j.properties");


    }


   /* public static void getData(String ScenarioName) throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testData/SampleData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFWorkbook test = new XSSFWorkbook();

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;


        //System.out.println("AAA+++++++++++++++" + sheet.getRow(0).getCell(0).getStringCellValue());
        int row_count = sheet.getLastRowNum();
       // System.out.println("row_Count" + row_count);

        for (int i = 0; i < row_count; i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().contentEquals(ScenarioName)) {
                for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
                    hashMap.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());

                }
            }
            //System.out.println("*******************");
        }


    }
    */
    public static void AddStepLogToReport(String message)
    {
        com.cucumber.listener.Reporter.addStepLog(message);
    }

    public static void AddScenarioLogToReport(String message)
    {
        com.cucumber.listener.Reporter.addScenarioLog(message);
    }

    public static  void ClearTextBox(WebElement element)
    {
        element.clear();
       log.info("Function----ClearTextBox----Element----------"+ element.getAttribute("innerText") + "Value is cleared");
    }

    public static  void EnterTextBox(WebElement element,String Text)
    {
        element.sendKeys(Text);
        log.info("Function ----EnterTextBox----Element----------"+ element.getAttribute("innerText")  + "Value entered as-------"+ Text);
    }

    public static void ButtonClick(WebElement element) {
        element.click();
        //log.info("Element----------"+ element.getAttribute("value")  + "Button Clicked");
    }


	public static void Navigate(WebDriver driver, String uRL) {
       driver.get(uRL);
       driver.manage().window().maximize() ;
        log.info("Function ----Navigate----Navigated to Page and Maximized");

    }
    
 
	public static void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);


        log.info("Function ----waitForPageLoaded----Synchronized untill Page Loaded");

	}

    public static void ValidatePageTitle(WebDriver driver, String pageTitle) {
        //System.out.println("Title of Page --------"+ driver.getTitle());
        driver.getTitle().contains(pageTitle);
        log.info("Function ----ValidatePageTitle----Page Title is Validated");


    }
}
