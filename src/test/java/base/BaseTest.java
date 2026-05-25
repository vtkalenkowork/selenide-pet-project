package base;

import com.codeborne.selenide.Configuration;
import core.config.ConfigManager;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    @BeforeEach
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = ConfigManager.getBaseUrl();
        Configuration.timeout = 10000;

        open("/");

        clearBrowserCookies();
        clearBrowserLocalStorage();

        open("/");

        getWebDriver().manage().window().maximize();
    }
}
