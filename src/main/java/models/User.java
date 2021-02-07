package models;

public class User {
    private final ShoppingCart cart;

    public User(ShoppingCart cart) {
        this.cart = cart;
    }

    public void addProductToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }
}
