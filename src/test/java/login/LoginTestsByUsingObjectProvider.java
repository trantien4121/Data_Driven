package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTestsByUsingObjectProvider extends BaseTests {

    @DataProvider(name = "provideLogInData")
    public Object [] [] logInData ()
    {
        Object [] [] data = new Object [4] [2];

        data [0] [0] = "";    data [0] [1] = "admin123";
        data [1] [0] = "Admin";      data [1] [1] = "";
        data [2] [0] = "Admin";      data [2] [1] = "admin";
        data [3] [0] = "Admin";      data [3] [1] = "admin123";
        return data;
    }
    @Test(dataProvider = "provideLogInData")
    public void testLogin(String userName, String password){
        loginPage.login(userName, password);
        SecureAreaPage secureAreaPage = loginPage.clickToLogin();
        assertTrue(secureAreaPage.getCurrentUrl().contains("dashboard"), "Login Failed!");
    }
}
