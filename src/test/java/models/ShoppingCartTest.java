package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.ProductType.SOAP;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ShoppingCartTest {
    private int quantity;
    private String productName;
    private String unitPrice;
    private BigDecimal price;
    private Product doveSoap;
    private ShoppingCart cart;
    private ShoppingCart expectedShoppingCart;
    private BigDecimal expectedTotalCartPrice;

    @BeforeEach
    void setup() {
        quantity = 5;
        productName = "Dove Soap";
        unitPrice = "39.99";

        price = new BigDecimal(unitPrice);
        doveSoap = new Product(productName, price, SOAP);
        cart = new ShoppingCart();
        cart.addProduct(doveSoap, quantity);

        expectedShoppingCart = getShoppingCart(productName, quantity, unitPrice);
        expectedTotalCartPrice = new BigDecimal("199.95");
    }

    @AfterEach
    void tearDown() {
        quantity = 0;
        productName = null;
        unitPrice = null;

        price = null;
        doveSoap = null;
        cart = null;

        expectedShoppingCart = null;
        expectedTotalCartPrice = null;
    }

    @Test
    @DisplayName("Should assert two shopping cart with 5 dove soaps and same unit price")
    void shouldAddProductToCart() {
        // Assert
        /* verifies cart has 5 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(cart, is(expectedShoppingCart));
        assertThat(cart.getTotalPrice(), is(expectedTotalCartPrice));

    }

    @Test
    @DisplayName("Should check equality of two equal carts")
    void shouldTestEquals() {
        //Assert
        assertThat(cart.equals(expectedShoppingCart), is(true));
    }

    @Test
    @DisplayName("Should check total price of a cart")
    void shouldGetTotalPrice() {
        //Assert
        assertThat(cart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    private ShoppingCart getShoppingCart(String name, int quantity, String unitPrice) {

        // Create a cart with given name, quantity and unit-price of soap
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(name, new BigDecimal(unitPrice), SOAP);
        shoppingCart.addProduct(product, quantity);

        return shoppingCart;
    }
}
