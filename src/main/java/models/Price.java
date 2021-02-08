package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private final BigDecimal unitPrice;
    private final Tax tax;

    public Price(BigDecimal unitPrice, Tax tax) {
        this.unitPrice = unitPrice;
        this.tax = tax;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
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
}
