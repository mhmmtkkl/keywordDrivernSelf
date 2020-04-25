package utilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    WebDriver driver;

    GetProperties getProperties = new GetProperties();

    public WebDriver getDriver(){

        if(getProperties.getData("browser").equalsIgnoreCase("Chrome")){
            ChromeDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }

        return driver;
    }




}
