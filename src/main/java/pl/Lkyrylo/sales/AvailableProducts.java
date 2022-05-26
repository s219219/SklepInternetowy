package pl.jkanclerz.sales;

import java.util.List;
import java.util.Optional;

public class AvailableProducts {
    private List<ProductDetails> products;

    public AvailableProducts(List<ProductDetails> products) {

        this.products = products;
    }

    public Optional<ProductDetails> getById(String productId) {
        return products.stream()
                .filter(productDetails -> productDetails.getId().equals(productId))
                .findFirst();
    }
}
