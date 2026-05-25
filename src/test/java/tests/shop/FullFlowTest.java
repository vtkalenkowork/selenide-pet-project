package tests.shop;

import base.BaseTest;
import core.testdata.TestData;
import org.junit.jupiter.api.Test;
import pages.ConfirmationPage;
import pages.LoginPage;

public class FullFlowTest extends BaseTest {
    String username = TestData.EMAIL;
    String password = TestData.PASSWORD;
    String product = TestData.ZARA_COAT_3;

    @Test
    public void shouldSubmitOrder() {
        String orderId = new LoginPage()
                .login(username, password)
                .isOnPage()
                .addProductToCart(product)
                .goToCart()
                .isOnCartPage()
                .verifyProductIsAdded(product)
                .goToCheckout()
                .isOnCheckoutPage()
                .selectCountry("Ukr")
                .submitOrder()
                .isOnConfirmationPage()
                .getOrderId();

        new ConfirmationPage()
                .goToOrdersFromConfirmation()
                .verifyOrderExists(orderId);
    }
}
