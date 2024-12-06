package org.loadevent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class HomePage extends BasePage {
    private final By txtUsername = By.cssSelector("#username");
    private final By txtPassword = By.cssSelector("#password");
    private final By btnLogin = By.xpath("//input[@id='login']");
    private final By linkRegister = By.xpath("//a[normalize-space()='New User Register Here']");
    public final String URL = "https://adactinhotelapp.com/";
    public HomePage(WebDriver driver){super(driver);}

    public void enterCredentials(String username, String password){
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
    }

    public SearchHotel clickLogin(){
        driver.findElement(btnLogin).click();
        return new SearchHotel(driver);
    }
}
