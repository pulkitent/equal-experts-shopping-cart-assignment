package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String name;
    private final BigDecimal unitPrice;
    private final ProductType type;

    public Product(String name, BigDecimal unitPrice, ProductType type) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name)
                && unitPrice.equals(product.unitPrice)
                && type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice, type);
    }

    BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
