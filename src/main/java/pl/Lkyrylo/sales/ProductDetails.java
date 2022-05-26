package pl.jkanclerz.sales;

import java.math.BigDecimal;

public class ProductDetails {

    private String id;
    String name;
    BigDecimal price;

    public ProductDetails(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
