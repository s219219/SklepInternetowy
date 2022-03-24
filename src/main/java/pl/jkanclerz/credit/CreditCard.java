package pl.jkanclerz.credit;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditLimit;

    public void assignLimit(BigDecimal initialLimit) {

        creditLimit = initialLimit;
    }

    public BigDecimal getBalance() {
        return creditLimit;
    }

    public void withdraw(BigDecimal valueOf) {

    }
}
