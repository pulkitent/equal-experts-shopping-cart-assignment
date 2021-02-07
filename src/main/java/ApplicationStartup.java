import models.Product;
import models.ShoppingCart;
import models.User;

import java.math.BigDecimal;

import static models.ProductType.SOAP;

public class ApplicationStartup {
    public static void main(String[] args) {
        BigDecimal unitPrice = new BigDecimal("39.99");
        Product dove = new Product("Dove Soap", unitPrice, SOAP);
        int fiveQuantity = 5;
        int threeQuantity = 3;

        ShoppingCart cart = new ShoppingCart();
        User user = new User(cart);

        user.addProductToCart(dove, fiveQuantity);
        user.addProductToCart(dove, threeQuantity);
    }
}
