package pl.jkanclerz.productcatalog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapProductStorage implements ProductStorage {
    Map<String, ProductData> products;

    public MapProductStorage() {
        this.products = new HashMap<>();
    }

    @Override
    public List<ProductData> allPublishedProducts() {
        return products.values()
                .stream()
                .filter(productData -> productData.getPublished())
                .collect(Collectors.toList());
    }

    @Override
    public void save(ProductData newProduct) {
        products.put(
                newProduct.getId(),
                newProduct);
    }

    @Override
    public ProductData load(String productId) {
        return products.get(productId);
    }
}
