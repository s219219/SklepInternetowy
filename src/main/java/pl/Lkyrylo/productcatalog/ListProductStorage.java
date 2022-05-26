package pl.jkanclerz.productcatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListProductStorage implements ProductStorage {
    List<ProductData> products;

    public ListProductStorage() {
        this.products = new ArrayList<>();
    }
    @Override
    public void save(ProductData newProduct) {
        products.add(newProduct);
    }

    @Override
    public ProductData load(String productId) {
        return products.stream()
                .filter(productData -> productData.getId().equals(productId))
                .findFirst()
                .get();
    }

    @Override
    public List<ProductData> allPublishedProducts() {
        return products.stream()
                .filter(productData -> productData.getPublished())
                .collect(Collectors.toList());
    }
}
