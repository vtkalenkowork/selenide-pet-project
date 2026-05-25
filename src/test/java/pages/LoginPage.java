package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement emailInput = $("input#userEmail");
    private SelenideElement passwordInput = $("input#userPassword");
    private SelenideElement loginButton = $("input#login");

    public DashboardPage login(String username, String password){
        emailInput.shouldBe(visible).setValue(username);
        passwordInput.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
        return new DashboardPage();
    }
}
