package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.ProductType.SOAP;
import static models.TaxType.SALES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class UserTest {

    private int fiveQuantity;
    private Product doveSoap;
    private ShoppingCart actualCart;
    private User user;
    private ShoppingCart expectedShoppingCartWithFiveDove;
    private Price price;

    @BeforeEach
    void setup() {
        // Arrange
        fiveQuantity = 5;
        String doveProductName = "Dove Soap";
        String doveUnitPrice = "39.99";

        BigDecimal salesTaxPercentage = new BigDecimal("12.5");

        Tax salesTax = new Tax(SALES, salesTaxPercentage);
        BigDecimal unitPrice = new BigDecimal("39.99");

        price = new Price(unitPrice, salesTax);

        doveSoap = new Product(doveProductName, price, SOAP);
        actualCart = new ShoppingCart();
        user = new User(actualCart);

        expectedShoppingCartWithFiveDove = getExpectedCart(doveProductName, fiveQuantity, doveUnitPrice);
    }

    @BeforeEach
    void tearDown() {
        fiveQuantity = 0;
        doveSoap = null;
        actualCart = null;
        user = null;
        expectedShoppingCartWithFiveDove = null;
    }

    @Test
    @DisplayName("Should assert two shopping cart with 5 dove soaps with same unit price and same total price")
    void shouldAddFiveDoveSoapsToCartByUser() {
        //Arrange
        BigDecimal expectedTotalCartPrice = new BigDecimal("199.95");

        // Action
        user.addProductToCart(doveSoap, fiveQuantity);

        // Assert
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
        /* verifies cart has 5 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(actualCart, is(expectedShoppingCartWithFiveDove));
    }

    @Test
    @DisplayName("Should assert two shopping cart with 8 dove soaps and same unit price and same total price")
    void shouldAddFiveAndThreeDoveSoapsToCartByUser() {
        // Arrange
        int threeQuantity = 3;
        BigDecimal expectedTotalCartPrice = new BigDecimal("319.92");
        expectedShoppingCartWithFiveDove.addProduct(doveSoap, threeQuantity);
        ShoppingCart expectedShoppingCartWithEightDove = expectedShoppingCartWithFiveDove;

        // Action
        user.addProductToCart(doveSoap, fiveQuantity);
        user.addProductToCart(doveSoap, threeQuantity);

        // Assert
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
        /* verifies cart has 8 dove soaps with unit price 39.99 each by using equals and hashcode contract */
        assertThat(actualCart, is(expectedShoppingCartWithEightDove));
    }

    private ShoppingCart getExpectedCart(String name, int quantity, String unitPrice) {

        // Create a cart with given name, quantity and unit-price of soap
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(name, price, SOAP);
        shoppingCart.addProduct(product, quantity);

        return shoppingCart;
    }
}
