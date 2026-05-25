package tests.shop;

import base.BaseTest;
import core.testdata.TestData;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    String username = TestData.EMAIL;
    String password = TestData.PASSWORD;

    @Test
    public void shouldLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password).isOnPage();
    }
}
