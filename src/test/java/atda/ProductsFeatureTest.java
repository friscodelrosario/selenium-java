package atda;

import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.assertTrue;

public class ProductsFeatureTest extends BaseTest {
    @Test
    public void shouldAddItemToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isLoaded());

        productsPage.Inventory.addRandomItemToCart();
        assertTrue("We added a single item to the cart and expected the cart to have 1 item",
                productsPage.ShoppingCart.hasItems(1));
    }
}
