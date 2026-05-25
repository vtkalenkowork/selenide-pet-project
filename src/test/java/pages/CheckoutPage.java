package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPage {
    private SelenideElement shippingAddress = $("div.user__address input");
    private ElementsCollection suggestions = $$("section.ta-results button");
    private SelenideElement paymentInfoSection = $("div.payment__info");
    private SelenideElement submitOrderButton = $("a.action__submit");

    public CheckoutPage isOnCheckoutPage() {
        paymentInfoSection.shouldBe(visible);
        return this;
    }

    public CheckoutPage selectCountry(String address) {
        shippingAddress.shouldBe(visible).setValue(address);
        suggestions.findBy(text(address)).shouldBe(visible).click();
        return this;
    }

    public ConfirmationPage submitOrder() {
        submitOrderButton.shouldBe(visible).click();
        return new ConfirmationPage();
    }
}
