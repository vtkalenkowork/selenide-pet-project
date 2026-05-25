package tests.shop;

import base.BaseTest;
import core.testdata.TestData;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class CartTests extends BaseTest {
    String username = TestData.EMAIL;
    String password = TestData.PASSWORD;
    String product = TestData.ZARA_COAT_3;

    @Test
    public void shouldAddProductToCart() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password).isOnPage().addProductToCart(product).goToCart();
    }

    @Test
    public void shouldAddAndRemoveProduct() {
        new LoginPage()
                .login(username, password)
                .isOnPage()
                .addProductToCart(product)
                .goToCart()
                .isOnCartPage()
                .verifyProductIsAdded(product)
                .removeRequiredProduct(product);
    }
}
