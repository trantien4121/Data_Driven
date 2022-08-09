package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SecureAreaPage {
    private WebDriver driver;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage(){
        return driver.findElement(By.id("spanMessage")).getText();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
