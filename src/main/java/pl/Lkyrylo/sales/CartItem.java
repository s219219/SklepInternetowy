package pl.jkanclerz.sales;

import java.math.BigDecimal;

public class CartItem {
    private final String productId;
    private final String name;
    private final BigDecimal price;

    public CartItem(String productId, String name, BigDecimal price) {

        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public static CartItem of(String productId, String name, BigDecimal price) {
        return new CartItem(productId, name, price);
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
