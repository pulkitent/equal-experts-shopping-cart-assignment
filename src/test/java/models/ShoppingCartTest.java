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
    private int fiveQuantity;
    private String doveProductName;
    private String doveUnitPrice;
    private BigDecimal dovePrice;
    private Product doveSoap;
    private ShoppingCart actualCart;
    private ShoppingCart expectedShoppingCartWithFiveDove;

    @BeforeEach
    void setup() {
        fiveQuantity = 5;
        doveProductName = "Dove Soap";
        doveUnitPrice = "39.99";

        dovePrice = new BigDecimal(doveUnitPrice);
        doveSoap = new Product(doveProductName, dovePrice, SOAP);
        actualCart = new ShoppingCart();

        expectedShoppingCartWithFiveDove = getShoppingCart(doveProductName, fiveQuantity, doveUnitPrice);
    }

    @AfterEach
    void tearDown() {
        fiveQuantity = 0;
        doveProductName = null;
        doveUnitPrice = null;

        dovePrice = null;
        doveSoap = null;
        actualCart = null;

        expectedShoppingCartWithFiveDove = null;
    }

    @Test
    @DisplayName("Should assert two shopping cart with 5 dove soaps with same unit price and same total cart price")
    void shouldAddFiveDoveSoapProductsToACart() {
        //Arrange
        BigDecimal expectedTotalCartPrice = new BigDecimal("199.95");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);

        // Assert
        /* verifies cart has 5 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(actualCart, is(expectedShoppingCartWithFiveDove));
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    @Test
    @DisplayName("Should assert two shopping cart with 8 dove soaps with same unit price and same total cart price")
    void shouldAddFiveAndEightDoveProductsToACart() {
        //Arrange
        int threeQuantity = 3;
        expectedShoppingCartWithFiveDove.addProduct(doveSoap, threeQuantity);
        ShoppingCart expectedShoppingCartWithEightDove = expectedShoppingCartWithFiveDove;
        BigDecimal expectedTotalCartPrice = new BigDecimal("319.92");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);
        actualCart.addProduct(doveSoap, threeQuantity);

        // Assert
        /* verifies cart has 8 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(actualCart, is(expectedShoppingCartWithEightDove));
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    @Test
    @DisplayName("Should check equality of two equal carts")
    void shouldTestEquals() {
        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);

        //Assert
        assertThat(actualCart.equals(expectedShoppingCartWithFiveDove), is(true));
    }

    @Test
    @DisplayName("Should check total price of a cart")
    void shouldGetTotalPrice() {
        //Arrange
        BigDecimal expectedTotalCartPrice = new BigDecimal("199.95");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);

        //Assert
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    private ShoppingCart getShoppingCart(String name, int quantity, String unitPrice) {

        // Create a cart with given name, quantity and unit-price of soap
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(name, new BigDecimal(unitPrice), SOAP);
        shoppingCart.addProduct(product, quantity);

        return shoppingCart;
    }
}
