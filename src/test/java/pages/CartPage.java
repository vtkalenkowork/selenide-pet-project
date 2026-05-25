package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CartPage {

    private ElementsCollection productCards = $$("div.infoWrap");
    private SelenideElement headerTitle = $("div[class *= heading] h1");
    private String headerText = "My Cart";

    public CartPage isOnCartPage() {
        webdriver().shouldHave(urlContaining("cart"));
        headerTitle.shouldBe(visible).shouldHave(text(headerText));
        return this;
    }

    public CartPage verifyProductIsAdded(String product){
        productCards.findBy(text(product)).shouldBe(visible);
        return new CartPage();
    }

    public CartPage removeRequiredProduct(String product) {
        SelenideElement requiredProductCard = productCards.findBy(text(product));

        requiredProductCard.$("button[class *= btn-danger]").shouldBe(visible).click();
        requiredProductCard.shouldNot(exist);
        return this;
    }

    public CheckoutPage goToCheckout(){
        $$("button").findBy(text("Checkout")).shouldBe(visible).click();
        return new CheckoutPage();
    }

}
