package models;

import java.math.BigDecimal;

public class Tax {
    private final TaxType type;
    private final BigDecimal taxPercentage;

    public Tax(TaxType type, BigDecimal taxPercentage) {
        this.type = type;
        this.taxPercentage = taxPercentage;
    }
}
