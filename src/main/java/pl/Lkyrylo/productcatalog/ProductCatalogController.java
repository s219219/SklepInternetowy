package pl.jkanclerz.productcatalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductCatalogController {

    ProductCatalog productCatalog;

    public ProductCatalogController(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @GetMapping("/api/products")
    List<ProductData> availableProducts() {
        return productCatalog.allPublishedProducts();
    }
}
