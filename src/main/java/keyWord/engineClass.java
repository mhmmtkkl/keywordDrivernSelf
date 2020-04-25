package keyWord;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.GetProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class engineClass {



    /*

    Element Finder method will get all the element values from the excel

          those element values are String I am changing the Strings to WebELement

     */

    private final String elementExcelPath = "C:\\Users\\JuNiOr\\IdeaProjects\\KeyWordDriverSelfCreates\\src\\main\\java\\elements\\AllElements.xlsx";

    public WebDriver driver;

    Driver dObject = new Driver();

    GetProperties getProperties = new GetProperties();

    public WebElement elementFinder(String elementName , String sheetName){

        FileInputStream input =null;
        Workbook book = null;
        Sheet sheet =null;

        String locatorType = null;

        String locatorValue = null;

        try {
            input = new FileInputStream(elementExcelPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(input);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        sheet= book.getSheet(sheetName);

        // this part is getting the data from excel like locator type and locator value
        for(int i = 0 ; i<sheet.getLastRowNum() ; i++){

            String elementNameInTheExcel = sheet.getRow(i+1).getCell(0).toString().trim();

            if(elementNameInTheExcel.equals(elementName)){
                locatorType = sheet.getRow(i+1).getCell(1).toString().trim();
                locatorValue = sheet.getRow(i+1).getCell(2).toString().trim();
            }
        }

        WebElement result =null;

//        this part is changing the String locator value and String locator type to Webelement
        switch (locatorType){
            case "xpath":
                result = driver.findElement(By.xpath(locatorValue));
                break;
            case "id":
                result = driver.findElement(By.id(locatorValue));
                break;
            case "cssSelector":
                result = driver.findElement(By.cssSelector(locatorValue));
            default:
                break;
        }
        return result;
    }

    public void sendKeysFunctionality(String elementName , String elementValue , String sheetName){

        WebElement sendingElement = elementFinder(elementName , sheetName);
        sendingElement.sendKeys(elementValue);

    }

    public void clickFunctionality(String elementName ,String sheetName){

        WebElement clickElement = elementFinder(elementName , sheetName);

        clickElement.click();


    }



    public void browserActions(String actionName){


        switch (actionName){

            case "Open":
                driver = dObject.getDriver();
                driver.get(getProperties.getData("url"));
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              break;

            case "Quit":
                driver.quit();

        }


    }


}
