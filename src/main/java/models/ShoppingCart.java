package models;

import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static models.Constants.PRECISION;
import static models.Constants.ZERO;

public class ShoppingCart {
    private final List<ShoppingCartItem> shoppingCartItems;
    private BigDecimal totalPrice;
    private BigDecimal totalTaxAmount;

    public ShoppingCart() {
        this.shoppingCartItems = new LinkedList<>();
        this.totalPrice = new BigDecimal(ZERO);
    }

    public void addProduct(Product product, int quantity) {
        for (ShoppingCartItem item : shoppingCartItems) {
            if (item.isSameProduct(product)) {
                item.increaseQuantityBy(quantity);
                calculateTotalPrice();
                return;
            }
        }

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product, quantity);
        shoppingCartItems.add(shoppingCartItem);

        calculateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public BigDecimal getTotalTaxOnCart() {
        return this.totalTaxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return shoppingCartItems.equals(that.shoppingCartItems) && totalPrice.equals(that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartItems, totalPrice);
    }

    private void calculateTotalPrice() {
        //Reset cart total value & total tax every time to calculate total value from start
        this.totalPrice = new BigDecimal(ZERO);
        this.totalTaxAmount = new BigDecimal(ZERO);

        for (ShoppingCartItem item : shoppingCartItems) {
            this.totalTaxAmount = totalTaxAmount.add(item.getTaxAmountOnItem());

            BigDecimal priceWithTax = item.getItemPriceWithTax();
            totalPrice = totalPrice.add(priceWithTax);
        }

        this.totalTaxAmount = roundOffUptoTwoDecimalPlaces(this.totalTaxAmount);
        this.totalPrice = roundOffUptoTwoDecimalPlaces(totalPrice);
    }

    private BigDecimal roundOffUptoTwoDecimalPlaces(BigDecimal amount) {
        return amount.setScale(PRECISION, ROUND_HALF_UP);
    }
}
