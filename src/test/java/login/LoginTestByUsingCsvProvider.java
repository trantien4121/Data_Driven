package login;

import base.BaseTests;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SecureAreaPage;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTestByUsingCsvProvider extends BaseTests{
    @DataProvider(name = "Account")
    public Object[][] passCsvData() throws IOException, CsvException {
        return CsvReader.getCsvData("src/test/resources/params/AccountData.csv", 2);
    }

    @Test(dataProvider = "Account")
    public void testLogin(String userName,String password){
        loginPage.login(userName, password);
        SecureAreaPage secureAreaPage = loginPage.clickToLogin();
        assertTrue(secureAreaPage.getCurrentUrl().contains("dashboard"), "Login Failed!");
    }

}
