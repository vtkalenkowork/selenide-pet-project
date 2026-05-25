package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.testdata.TestData;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class DashboardPage {
    private SelenideElement headerTitle = $("nav h3");
    private SelenideElement cartButton = $("button[routerlink*='/dashboard/cart']");
    private ElementsCollection productCards = $$("div.card-body");
    private static final String HEADER = TestData.HEADER;

    public DashboardPage isOnPage() {
        webdriver().shouldHave(urlContaining("dashboard"));
        headerTitle.shouldHave(text(HEADER));
        return this;
    }

    public DashboardPage addProductToCart(String product) {
        SelenideElement requiredProduct = productCards
                .findBy(text(product));
        requiredProduct
                .$("button:last-of-type")
                .shouldBe(visible)
                .click();
        return this;
    }

    public CartPage goToCart() {
        cartButton.shouldBe(visible, clickable).click();
        return new CartPage();
    }

}
