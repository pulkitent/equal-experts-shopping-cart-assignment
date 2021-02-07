package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static models.ProductType.SOAP;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ProductTest {
    private String productName;
    private BigDecimal unitPrice;
    private Product actualProduct;
    private Product expectedProduct;

    @BeforeEach
    void setup() {
        productName = "Dove Soap";
        unitPrice = new BigDecimal("35.5");
        actualProduct = new Product(productName, unitPrice, SOAP);
        expectedProduct = new Product(productName, unitPrice, SOAP);
    }

    @AfterEach
    void tearDown() {
        productName = null;
        unitPrice = null;
        actualProduct = null;
        expectedProduct = null;
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
        BigDecimal expectedUnitPrice = new BigDecimal("35.5");

        //Assert
        assertThat(actualProduct.getUnitPrice(), is(expectedUnitPrice));
    }
}
