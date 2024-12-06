package utils;

import org.loadevent.pages.HomePage;
import org.loadevent.pages.SearchHotel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected static WebDriver driver;
    protected HomePage homePage;
    protected SearchHotel searchHotelPage;

    public void init() throws Exception {
        driver = initializeDriver("chrome","https://adactinhotelapp.com/");
        homePage = new HomePage(driver);
    }
    public WebDriver initializeDriver(String browser, String url) throws Exception {
        if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else {
            throw new Exception("Browser Not Found");
        }

        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    public void tearDown(){driver.quit();}
}
