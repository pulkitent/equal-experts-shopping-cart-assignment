import models.Product;
import models.ShoppingCart;
import models.User;

import java.math.BigDecimal;

import static models.ProductType.SOAP;

public class ApplicationStartup {
    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("39.99");
        Product dove = new Product("Dove Soap", price, SOAP);
        int quantity = 5;

        ShoppingCart cart = new ShoppingCart();
        User user = new User(cart);

        user.addProductToCart(dove, quantity);
    }
}
