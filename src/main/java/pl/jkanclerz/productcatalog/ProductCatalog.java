package pl.jkanclerz.productcatalog;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductCatalog {
    Map<String, ProductData> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    public List<ProductData> allPublishedProducts() {
        return products.values()
                .stream()
                .filter(productData -> productData.getPublished())
                .collect(Collectors.toList());
    }

    public String addProduct(String productKey, String name) {
        ProductData newProduct = new ProductData(productKey, name);
        products.put(productKey, newProduct);
        return productKey;
    }

    public void assignImage(String productId, String imagePath) {
        ProductData loaded = getDetails(productId);
        loaded.setImage(imagePath);
    }

    public ProductData getDetails(String productId) {
        return products.get(productId);
    }

    public void publish(String productId) {
        ProductData loaded = getDetails(productId);

        if (loaded.getImage() == null) {
            throw new CantPublishProductException();
        }

        if (loaded.price() == null) {
            throw new CantPublishProductException();
        }

        loaded.setPublished(true);
    }

    public void assignPrice(String productId, BigDecimal price) {
        ProductData loaded = getDetails(productId);
        loaded.setPrice(price);
    }
}
