package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }
}
