package pl.jkanclerz.productcatalog;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalog {
    ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<ProductData> allPublishedProducts() {
        return productStorage.allPublishedProducts();
    }

    public String addProduct(String productKey, String name) {
        ProductData newProduct = new ProductData(productKey, name);
        productStorage.save(newProduct);

        return productKey;
    }

    public void assignImage(String productId, String imagePath) {
        ProductData loaded = productStorage.load(productId);
        loaded.setImage(imagePath);
        productStorage.save(loaded);
    }

    public ProductData getDetails(String productId) {
        return productStorage.load(productId);
    }

    public void publish(String productId) {
            ProductData loaded = productStorage.load(productId);

            if (loaded.getImage() == null) {
                throw new CantPublishProductException();
            }

            if (loaded.price() == null) {
                throw new CantPublishProductException();
            }

            loaded.setPublished(true);
            productStorage.save(loaded);
    }

    public void assignPrice(String productId, BigDecimal price) {
        ProductData loaded = productStorage.load(productId);
        loaded.setPrice(price);
        productStorage.save(loaded);
    }
}
