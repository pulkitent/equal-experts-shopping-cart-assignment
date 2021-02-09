package models;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class ShoppingCart {
    private final List<Product> products;
    private BigDecimal totalPrice;
    private BigDecimal totalTaxAmount;

    private static final Integer PRECISION = 2;

    public ShoppingCart() {
        this.products = new LinkedList<>();
        this.totalPrice = new BigDecimal("0");
    }

    public void addProduct(Product product, int quantity) {
        for (int index = 0; index < quantity; index++) {
            products.add(product);
        }
        calculateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return products.equals(that.products) && totalPrice.equals(that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPrice);
    }

    public BigDecimal getTotalTaxOnCart() {
        return this.totalTaxAmount;
    }

    private void calculateTotalPrice() {
        //Reset cart total value & total tax every time to calculate total value from start
        this.totalPrice = new BigDecimal("0.0");
        this.totalTaxAmount = new BigDecimal("0.0");

        for (Product product : products) {
            this.totalTaxAmount = totalTaxAmount.add(product.getTaxAmountOnProduct());
            BigDecimal priceWithTax = product.getProductPriceWithTax();
            totalPrice = totalPrice.add(priceWithTax);
        }

        this.totalTaxAmount = roundOffUptoTwoDecimalPlaces(this.totalTaxAmount);
        this.totalPrice = roundOffUptoTwoDecimalPlaces(totalPrice);
    }

    private BigDecimal roundOffUptoTwoDecimalPlaces(BigDecimal amount) {
        return amount.setScale(PRECISION, ROUND_HALF_UP);
    }
}
