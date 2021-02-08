package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String name;
    private final Price price;
    private final ProductType type;

    public Product(String name, Price price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name)
                && price.equals(product.price)
                && type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type);
    }

    BigDecimal getUnitPrice() {
        return price.getUnitPrice();
    }
}
