package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ShoppingCartTest {

    @Test
    @DisplayName("Should assert two shopping cart with 5 dove soaps with same unit price and same total cart price")
    void shouldAddFiveDoveSoapProductsToACart() {
        //Arrange
        int fiveQuantity = 5;
        Product doveSoap = getDoveSoapProductWithTax();
        ShoppingCart actualCart = new ShoppingCart();

        int expectedFiveQuantity = 5;
        ShoppingCart expectedShoppingCartWithFiveDove =
                getExpectedShoppingCartWithGivenQuantityAndProduct(expectedFiveQuantity);
        BigDecimal expectedTotalCartPrice = new BigDecimal("224.95");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);

        //Assert
        /* verifies cart has 5 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(actualCart, is(expectedShoppingCartWithFiveDove));
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    @Test
    @DisplayName("Should assert two shopping cart with 8 dove soaps with same unit price and same total cart price")
    void shouldAddFiveAndEightDoveProductsToACart() {
        //Arrange
        int fiveQuantity = 5;
        int threeQuantity = 3;
        Product doveSoap = getDoveSoapProductWithTax();
        ShoppingCart actualCart = new ShoppingCart();

        int expectedEightQuantity = 8;
        ShoppingCart expectedShoppingCartWithFiveDove =
                getExpectedShoppingCartWithGivenQuantityAndProduct(expectedEightQuantity);
        BigDecimal expectedTotalCartPrice = new BigDecimal("359.92");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);
        actualCart.addProduct(doveSoap, threeQuantity);

        //Assert
        /* verifies cart has 8 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(actualCart, is(expectedShoppingCartWithFiveDove));
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    @Test
    @DisplayName("Should assert two shopping cart with 2 dove soaps and 2 axe deo")
    void shouldAddTwoDoveSoapsAndTwoAxeDeoProductsToACart() {
        //Arrange
        Product dove = getDoveSoapProductWithTax();
        Product axe = getAxeDeoProductWithTax();
        int twoDoveQuantity = 2;
        int twoAxeQuantity = 2;
        ShoppingCart cartWithTwoDoveAndTwoAxe = new ShoppingCart();

        ShoppingCart expectedCartWithTwoDoveAndTwoAxe = getExpectedCartWithTwoDovesAndTwoAxe();
        BigDecimal expectedTotalCartPrice = new BigDecimal("314.96");
        BigDecimal expectedTotalCartTax = new BigDecimal("35.00");

        //Action
        cartWithTwoDoveAndTwoAxe.addProduct(dove, twoDoveQuantity);
        cartWithTwoDoveAndTwoAxe.addProduct(axe, twoAxeQuantity);

        //Assert
        /* verifies cart has 8 dove soaps with unit price 39.99 each by using equals and hashcode contract*/
        assertThat(cartWithTwoDoveAndTwoAxe, is(expectedCartWithTwoDoveAndTwoAxe));
        assertThat(cartWithTwoDoveAndTwoAxe.getTotalPrice(), is(expectedTotalCartPrice));
        assertThat(cartWithTwoDoveAndTwoAxe.getTotalTaxOnCart(), is(expectedTotalCartTax));
    }

    @Test
    @DisplayName("Should check equality of two equal carts")
    void shouldTestEquals() {
        //Arrange
        int fiveQuantity = 5;
        Product doveSoap = getDoveSoapProductWithTax();
        ShoppingCart actualCart = new ShoppingCart();

        int expectedFiveQuantity = 5;
        ShoppingCart expectedShoppingCartWithFiveDove =
                getExpectedShoppingCartWithGivenQuantityAndProduct(expectedFiveQuantity);

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);

        //Assert
        assertThat(actualCart.equals(expectedShoppingCartWithFiveDove), is(true));
    }

    @Test
    @DisplayName("Should check total price of a cart")
    void shouldGetTotalPrice() {
        //Arrange
        int fiveQuantity = 5;
        Product doveSoap = getDoveSoapProductWithTax();
        ShoppingCart actualCart = new ShoppingCart();

        BigDecimal expectedTotalCartPrice = new BigDecimal("224.95");

        //Action
        actualCart.addProduct(doveSoap, fiveQuantity);

        //Assert
        assertThat(actualCart.getTotalPrice(), is(expectedTotalCartPrice));
    }

    private ShoppingCart getExpectedCartWithTwoDovesAndTwoAxe() {
        int expectedTwoDoveQuantity = 2;
        ShoppingCart expectedCartWithTwoDove =
                getExpectedShoppingCartWithGivenQuantityAndProduct(expectedTwoDoveQuantity);

        int expectedTwoAxeQuantity = 2;
        Product expectedAxe = getAxeDeoProductWithTax();
        ShoppingCart expectedCartWithTwoDoveAndTwoAxe = expectedCartWithTwoDove;
        expectedCartWithTwoDove.addProduct(expectedAxe, expectedTwoAxeQuantity);

        return expectedCartWithTwoDoveAndTwoAxe;
    }

    private ShoppingCart getExpectedShoppingCartWithGivenQuantityAndProduct(int productQuantity) {
        Tax expectedSalesTax = getTax();
        Product product = getDoveSoapProduct(expectedSalesTax);

        ShoppingCart expectedShoppingCartWithFiveDove = new ShoppingCart();
        expectedShoppingCartWithFiveDove.addProduct(product, productQuantity);

        return expectedShoppingCartWithFiveDove;
    }

    private Product getDoveSoapProductWithTax() {
        BigDecimal salesTaxPercentage = new BigDecimal(TAX_PERCENTAGE);
        Tax salesTax = new Tax(SALES, salesTaxPercentage);

        return getDoveSoapProduct(salesTax);
    }

    private Product getAxeDeoProductWithTax() {
        BigDecimal salesTaxPercentage = new BigDecimal(TAX_PERCENTAGE);
        Tax salesTax = new Tax(SALES, salesTaxPercentage);

        return getAxeDeoProduct(salesTax);
    }

    private Product getAxeDeoProduct(Tax tax) {
        String axeUnitPrice = "99.99";
        BigDecimal axePrice = new BigDecimal(axeUnitPrice);
        Price anotherPrice = new Price(axePrice, tax);

        return new Product("Axe Deo", anotherPrice, DEO);
    }

    private Product getDoveSoapProduct(Tax tax) {
        String doveUnitPrice = "39.99";
        BigDecimal dovePrice = new BigDecimal(doveUnitPrice);
        Price price = new Price(dovePrice, tax);

        return new Product("Dove Soap", price, SOAP);
    }

    private Tax getTax() {
        String percentage = TAX_PERCENTAGE;
        BigDecimal taxPercentage = new BigDecimal(percentage);
        return new Tax(SALES, taxPercentage);
    }
}
