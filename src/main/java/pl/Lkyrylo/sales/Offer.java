package pl.jkanclerz.sales;

import java.math.BigDecimal;

public class Offer {
    private final BigDecimal total;
    private final int itemsCount;

    public Offer(BigDecimal total, int itemsCount) {

        this.total = total;
        this.itemsCount = itemsCount;
    }

    public static Offer empty() {
        return new Offer(BigDecimal.ZERO, 0);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public int getItemsCount() {
        return itemsCount;
    }
}
