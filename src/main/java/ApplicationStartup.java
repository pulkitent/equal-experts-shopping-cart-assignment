import models.*;

import java.math.BigDecimal;

import static models.ProductType.SOAP;
import static models.TaxType.SALES;

public class ApplicationStartup {
    public static void main(String[] args) {
        BigDecimal salesPercentage = new BigDecimal("12.5");

        Tax salesTax = new Tax(SALES, salesPercentage);
        BigDecimal unitPrice = new BigDecimal("39.99");

        Price price = new Price(unitPrice, salesTax);
        Product dove = new Product("Dove Soap", price, SOAP);

        int fiveQuantity = 5;
        int threeQuantity = 3;

        ShoppingCart cart = new ShoppingCart();
        User user = new User(cart);

        user.addProductToCart(dove, fiveQuantity);
        user.addProductToCart(dove, threeQuantity);
    }
}
