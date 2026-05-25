package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class OrdersPage {
    private ElementsCollection orders = $$("tbody tr th");

    public void verifyOrderExists(String orderId){
        orders.findBy(text(orderId)).shouldBe(visible);
    }
}
