package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.ProductType.SOAP;
import static models.TaxType.SALES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ShoppingCartTest {
    private int fiveQuantity;
    private String doveProductName;
    private Product doveSoap;
    private Price price;
    private ShoppingCart actualCart;
    private ShoppingCart expectedShoppingCartWithFiveDove;

    @BeforeEach
    void setup() {
        fiveQuantity = 5;
        doveProductName = "Dove Soap";

        BigDecimal salesTaxPercentage = new BigDecimal("12.5");

        Tax salesTax = new Tax(SALES, salesTaxPercentage);
        BigDecimal unitPrice = new BigDecimal("39.99");

        price = new Price(unitPrice, salesTax);

        doveSoap = new Product(doveProductName, price, SOAP);
        actualCart = new ShoppingCart();

        //Create cart with 5 dove soaps
        expectedShoppingCartWithFiveDove = getShoppingCart(doveProductName, fiveQuantity, price);
    }

    @AfterEach
    void tearDown() {
        price = null;
        fiveQuantity = 0;
        doveProductName = null;
        doveSoap = null;
        price = null;
        actualCart = null;
        expectedShoppingCartWithFiveDove = null;
    }

    @Test
    @DisplayName("Should assert two shopping cart with 5 dove soaps with same unit price and same total cart price")
    void shouldAddFiveDoveSoapProductsToACart() {
        //Arrange
        BigDecimal expectedTotalCartPrice = new BigDecimal("224.95");

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
        BigDecimal expectedTotalCartPrice = new BigDecimal("359.92");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);
        actualCart.addProduct(doveSoap, threeQuantity);

        // Assert
        /* verifies cart has 8 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(actualCart, is(expectedShoppingCartWithEightDove));
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    @Test
    @DisplayName("Should assert two shopping cart with 2 dove soaps and 2 axe deo")
    void shouldAddTwoDoveSoapsAndTwoAxeDeoProductsToACart() {
        //Arrange
        ShoppingCart cartWithTwoDoveAndTwoAxe = new ShoppingCart();

        int twoDoveQuantity = 2;
        String percentage = "12.5";
        BigDecimal taxPercentage = new BigDecimal(percentage);
        Tax tax = new Tax(SALES, taxPercentage);

        String doveUnitPrice = "39.99";
        BigDecimal dovePrice = new BigDecimal(doveUnitPrice);
        Price price = new Price(dovePrice, tax);
        Product dove = new Product("Dove Soap", price, SOAP);

        int twoAxeQuantity = 2;
        String axeUnitPrice = "99.99";
        BigDecimal axePrice = new BigDecimal(axeUnitPrice);
        Price anotherPrice = new Price(axePrice, tax);
        Product axe = new Product("Axe Deo", anotherPrice, SOAP);


        ShoppingCart expectedCartWithTwoDoveAndTwoAxe = new ShoppingCart();

        String expectedPercentage = "12.5";
        BigDecimal expectedTaxPercentage = new BigDecimal(expectedPercentage);
        Tax expectedTax = new Tax(SALES, expectedTaxPercentage);

        int expectedTwoDoveQuantity = 2;

        String expectedDoveUnitPrice = "39.99";
        BigDecimal expectedDovePrice = new BigDecimal(expectedDoveUnitPrice);
        Price expectedDovePriceObj = new Price(expectedDovePrice, expectedTax);
        Product expectedDove = new Product("Dove Soap", expectedDovePriceObj, SOAP);

        expectedCartWithTwoDoveAndTwoAxe.addProduct(expectedDove, expectedTwoDoveQuantity);

        int expectedTwoAxeQuantity = 2;

        String expectedAxeUnitPrice = "99.99";
        BigDecimal expectedAxePrice = new BigDecimal(expectedAxeUnitPrice);
        Price expectedAxePriceObj = new Price(expectedAxePrice, expectedTax);
        Product expectedAxe = new Product("Axe Deo", expectedAxePriceObj, SOAP);

        expectedCartWithTwoDoveAndTwoAxe.addProduct(expectedAxe, expectedTwoAxeQuantity);

        //Action
        cartWithTwoDoveAndTwoAxe.addProduct(dove, twoDoveQuantity);
        cartWithTwoDoveAndTwoAxe.addProduct(axe, twoAxeQuantity);

        // Assert
        /* verifies cart has 8 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(cartWithTwoDoveAndTwoAxe, is(expectedCartWithTwoDoveAndTwoAxe));
        BigDecimal expectedTotalCartPrice = new BigDecimal("314.96");
        assertThat(cartWithTwoDoveAndTwoAxe.getTotalPrice(), is(expectedTotalCartPrice));
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
        BigDecimal expectedTotalCartPrice = new BigDecimal("224.95");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);

        //Assert
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    private ShoppingCart getShoppingCart(String name, int quantity, Price price) {

        // Create a cart with given name, quantity and unit-price of soap
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(name, price, SOAP);
        shoppingCart.addProduct(product, quantity);

        return shoppingCart;
    }
}
