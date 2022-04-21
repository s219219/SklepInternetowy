package pl.jkanclerz.productcatalog;

import java.math.BigDecimal;

public class ProductData {
    private final String id;
    private final String title;
    private String imagePath;
    private BigDecimal price;
    private boolean online;

    public ProductData(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getImage() {
        return imagePath;
    }

    public void setImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public BigDecimal price() {
        return price;
    }

    public void setPublished(boolean online) {

        this.online = online;
    }

    public boolean getPublished() {
        return online;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
