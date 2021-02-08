package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private final BigDecimal unitPrice;
    private final Tax tax;

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    public Price(BigDecimal unitPrice, Tax tax) {
        this.unitPrice = unitPrice;
        this.tax = tax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return unitPrice.equals(price.unitPrice) && tax.equals(price.tax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, tax);
    }

    BigDecimal getPriceWithTax() {
        BigDecimal taxPercentage = tax.getTaxPercentage();
        BigDecimal taxAmount = unitPrice.multiply(taxPercentage).divide(HUNDRED);

        return unitPrice.add(taxAmount);
    }

    BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
