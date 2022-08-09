package login;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.JsonReader;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTestByUsingJsonProvider extends BaseTests {
    @DataProvider(name = "Account")
    public Object[][] passJsonData() throws IOException, ParseException {
        return JsonReader.getJsonLoginData("src/test/resources/json/AccountData.json", "Account", 2);
    }

    @Test(dataProvider = "Account")
    public void testLogin(String userName, String password) {
        loginPage.login(userName, password);
        SecureAreaPage secureAreaPage = loginPage.clickToLogin();
        assertTrue(secureAreaPage.getCurrentUrl().contains("dashboard"), "Login Failed!");
    }
}
