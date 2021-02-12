package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.Constants.SALES;
import static models.Constants.TAX_PERCENTAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PriceTest {
    private BigDecimal salesPercentage;
    private Tax salesTax;
    private BigDecimal unitPrice;
    private Price price;

    @BeforeEach
    void setup() {

        salesPercentage = new BigDecimal(TAX_PERCENTAGE);
        salesTax = new Tax(SALES, salesPercentage);
        unitPrice = new BigDecimal("100.00");
        price = new Price(unitPrice, salesTax);
    }

    @AfterEach
    void tearDown() {
        salesPercentage = null;
        salesTax = null;
        unitPrice = null;
        price = null;
    }

    @Test
    @DisplayName("Should test equality of two price objects")
    void shouldTestEquals() {
        // Arrange
        Price expectedPrice = new Price(unitPrice, salesTax);

        // Assert
        assertThat(price.equals(expectedPrice), is(true));
    }

    @Test
    @DisplayName("Should test get price of product with tax amount")
    void shouldTestGetPriceWithTax() {
        // Arrange
        BigDecimal expectedPrice = new BigDecimal("112.50");

        // Assert
        assertThat(price.getPriceWithTax(), is(expectedPrice));
    }
}
