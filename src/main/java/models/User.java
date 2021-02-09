package models;

import java.util.Objects;

public class User {
    private final ShoppingCart cart;

    public User(ShoppingCart cart) {
        this.cart = cart;
    }

    public void addProductToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return cart.equals(user.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart);
    }
}
