package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {
    private SelenideElement confirmationPageTitle = $("h1.hero-primary");
    private SelenideElement orderInfo = $("td.box");

    public ConfirmationPage isOnConfirmationPage() {
        confirmationPageTitle.shouldBe(visible).shouldHave(text("Thankyou for the order."));
        return this;
    }

    public String getOrderId() {
        return orderInfo.$("label:not([routerlink*='myorders'])").shouldBe(visible).getText().replace("|", "").trim();
    }

    public OrdersPage goToOrdersFromConfirmation() {
        orderInfo.$("label[routerlink *= myorders]").shouldBe(visible).click();
        return new OrdersPage();
    }
}
