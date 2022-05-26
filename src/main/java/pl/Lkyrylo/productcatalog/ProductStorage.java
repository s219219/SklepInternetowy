package pl.jkanclerz.productcatalog;

import java.util.List;

public interface ProductStorage {
    List<ProductData> allPublishedProducts();

    void save(ProductData newProduct);

    ProductData load(String productId);
}
