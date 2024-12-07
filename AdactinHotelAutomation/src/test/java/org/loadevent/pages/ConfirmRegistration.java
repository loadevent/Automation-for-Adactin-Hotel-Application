package org.loadevent.pages;

import TestCases.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class ConfirmRegistration extends BasePage {
    private final By linkLogin = By.cssSelector("a[href='index.php']");
    public ConfirmRegistration(WebDriver driver) {
        super(driver);
    }

    public HomePage clickLogin(){
        driver.findElement(linkLogin).click();
        return new HomePage(driver);
    }
}
