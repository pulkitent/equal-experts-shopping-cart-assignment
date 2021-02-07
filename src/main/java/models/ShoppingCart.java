package models;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {
    private final List<Product> products;
    private BigDecimal totalPrice;

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

    private void calculateTotalPrice() {
        for (Product product : products) {
            BigDecimal unitPrice = product.getUnitPrice();
            totalPrice = totalPrice.add(unitPrice);
        }
    }
}
