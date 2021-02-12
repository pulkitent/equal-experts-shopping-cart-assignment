package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.Constants.SALES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TaxTest {

    @Test
    @DisplayName("Should test get percentage of tax")
    void shouldTesGetTaxPercentage() {
        // Arrange
        BigDecimal taxPercentage = new BigDecimal("12.5");
        Tax tax = new Tax(SALES, taxPercentage);
        BigDecimal expectedTaxPercentage = new BigDecimal("12.5");

        // Assert
        assertThat(tax.getTaxPercentage(), is(expectedTaxPercentage));
    }

    @Test
    @DisplayName("Should test equality of two tax")
    void shouldTestEquals() {
        // Arrange
        BigDecimal taxPercentage = new BigDecimal("12.5");
        Tax tax = new Tax(SALES, taxPercentage);
        Tax expectedTest = new Tax(SALES, taxPercentage);

        // Assert
        assertThat(tax, is(expectedTest));
    }
}
