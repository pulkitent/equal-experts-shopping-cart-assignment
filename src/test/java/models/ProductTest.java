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

class ProductTest {
    private String productName;
    private BigDecimal unitPrice;
    private BigDecimal salesPercentage;
    private Tax salesTax;
    private Price price;
    private Product actualProduct;
    private Product expectedProduct;

    @BeforeEach
    void setup() {
        salesPercentage = new BigDecimal("12.5");

        salesTax = new Tax(SALES, salesPercentage);
        unitPrice = new BigDecimal("39.99");

        price = new Price(unitPrice, salesTax);
        productName = "Dove Soap";

        actualProduct = new Product(productName, price, SOAP);
        expectedProduct = new Product(productName, price, SOAP);
    }

    @AfterEach
    void tearDown() {
        productName = null;
        unitPrice = null;
        actualProduct = null;
        expectedProduct = null;
        salesPercentage = null;
        salesTax = null;
        price = null;
    }

    @Test
    @DisplayName("Should check equality of two equal products")
    void shouldTestEquals() {
        //Assert
        assertThat(actualProduct.equals(expectedProduct), is(true));
    }

    @Test
    @DisplayName("Should check getUnitPrice of a product")
    void shouldGetUnitPrice() {
        //Arrange
        BigDecimal expectedUnitPrice = new BigDecimal("39.99");

        //Assert
        assertThat(actualProduct.getUnitPrice(), is(expectedUnitPrice));
    }
}
