package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterField(By id, String value){
        driver.findElement(id).sendKeys(value);
    }

    public void clickButton(By id){
        driver.findElement(id).click();
    }

    public void login(String userName, String password){
        enterField(By.id("txtUsername"), userName);
        enterField(By.id("txtPassword"), password);

    }

    public SecureAreaPage clickToLogin(){
        clickButton(By.id("btnLogin"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return new SecureAreaPage(driver);
    }
}
