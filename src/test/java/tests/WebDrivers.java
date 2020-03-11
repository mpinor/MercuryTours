package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDrivers {
    public static WebDriver driver;

    public void setDriver(String url){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public WebDriver getDriver(){
        return driver;
    }

    public void closeDriver(){
        driver.quit();
    }
}
