package models;

import java.math.BigDecimal;
import java.util.Objects;

public class ShoppingCartItem {
    private final Product product;
    private Integer quantity;

    public ShoppingCartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return product.equals(that.product) && quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    BigDecimal getItemPriceWithTax() {
        BigDecimal quantityInDecimal = new BigDecimal(this.quantity);

        BigDecimal totalPriceWithTaxForAItem = this.product
                .getProductPriceWithTax()
                .multiply(quantityInDecimal);

        return totalPriceWithTaxForAItem;
    }

    BigDecimal getTaxAmountOnItem() {
        BigDecimal quantityInDecimal = new BigDecimal(this.quantity);
        return this.product.getTaxAmountOnProduct().multiply(quantityInDecimal);
    }

    boolean isSameProduct(Product product) {
        return this.product.equals(product);
    }

    void increaseQuantityBy(Integer quantity) {
        this.quantity = this.quantity + quantity;
    }
}
