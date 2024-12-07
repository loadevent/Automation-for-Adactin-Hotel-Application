package org.loadevent.pages;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utils.BasePage;

import java.io.File;
import java.io.IOException;

public class NewRegistration extends BasePage {
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='re_password']");
    private final By txtFullname = By.xpath("//input[@id='full_name']");
    private final By txtEmail = By.xpath("//input[@id='email_add']");
    private final By chkTerms = By.xpath("//input[@id='tnc_box']");
    private final By btnRegister = By.xpath("//input[@id='Submit']");
    private final By btnReset = By.xpath("//input[@id='Reset']");
    private final By imgCaptcha = By.cssSelector("#captcha");
    private final By textCaptcha = By.xpath("#//input[@id='captcha-form']");

    public NewRegistration(WebDriver driver) {
        super(driver);
    }
    public NewRegistration setUsername(String username){
        driver.findElement(this.txtUsername).sendKeys(username);
        return this;
    }
    public NewRegistration setPassword(String password){
        driver.findElement(this.txtPassword).sendKeys(password);
        driver.findElement(this.txtConfirmPassword).sendKeys(password);
        return this;
    }
    public NewRegistration setFullname(String fullname){
        driver.findElement(this.txtFullname).sendKeys(fullname);
        return this;
    }
    public NewRegistration setEmail(String email){
        driver.findElement(this.txtEmail).sendKeys(email);
        return this;
    }
    public NewRegistration clickTerms(){
        driver.findElement(this.chkTerms).click();
        return this;
    }
    public ConfirmRegistration clickRegister(){
        driver.findElement(btnRegister).click();
        return new ConfirmRegistration(driver);
    }

    public NewRegistration typeCaptcha() throws IOException, Exception {
        WebElement captchaElement = driver.findElement(imgCaptcha);
        File src = captchaElement.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/captchaImages/captcha.png";
        FileHandler.copy(src,new File(path));

        Thread.sleep(2000);

        ITesseract image = new Tesseract();

        String captchaString = image.doOCR(new File(path));

        driver.findElement(textCaptcha).sendKeys(captchaString);

        return this;

    }
}
