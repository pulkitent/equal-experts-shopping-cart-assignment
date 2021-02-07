package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.ProductType.SOAP;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class UserTest {
    @Test
    @DisplayName("Should assert two shopping cart with 5 dove soaps and same unit price")
    void shouldAddProductToCartByUser() {
        // Arrange
        int quantity = 5;
        String productName = "Dove Soap";
        String unitPrice = "39.99";

        BigDecimal price = new BigDecimal(unitPrice);
        Product doveSoap = new Product(productName, price, SOAP);
        ShoppingCart cart = new ShoppingCart();
        User user = new User(cart);

        ShoppingCart expectedShoppingCart = getExpectedCart(productName, quantity, unitPrice);
        BigDecimal expectedTotalCartPrice = new BigDecimal("199.95");

        // Action
        user.addProductToCart(doveSoap, quantity);

        // Assert
        assertThat(cart.getTotalPrice(), is(expectedTotalCartPrice));
        /* verifies cart has 5 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(cart, is(expectedShoppingCart));
    }

    private ShoppingCart getExpectedCart(String name, int quantity, String unitPrice) {

        // Create a cart with given name, quantity and unit-price of soap
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(name, new BigDecimal(unitPrice), SOAP);
        shoppingCart.addProduct(product, quantity);

        return shoppingCart;
    }
}
