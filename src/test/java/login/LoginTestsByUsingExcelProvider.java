package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SecureAreaPage;
import utils.ExcelReader;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTestsByUsingExcelProvider extends BaseTests {
    @DataProvider(name = "Account")
    public Object[][] passExcelData() throws IOException{
        return ExcelReader.getExcelData("src/test/resources/params/AccountData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "Account")
    public void testLogin(String userName, String password){
        loginPage.login(userName, password);
        SecureAreaPage secureAreaPage = loginPage.clickToLogin();
//        assertTrue(secureAreaPage.getCurrentUrl().contains("dashboard"), "Login Failed!");
        System.out.println(secureAreaPage.getCurrentUrl());
    }
}
