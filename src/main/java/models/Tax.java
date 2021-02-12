package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Tax {
    private final String type;
    private final BigDecimal taxPercentage;

    public Tax(String type, BigDecimal taxPercentage) {
        this.type = type;
        this.taxPercentage = taxPercentage;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return type.equals(tax.type) && taxPercentage.equals(tax.taxPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, taxPercentage);
    }
}
