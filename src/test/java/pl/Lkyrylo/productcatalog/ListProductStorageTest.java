package pl.jkanclerz.productcatalog;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListProductStorageTest {

    @Test
    void itStoreAndLoadMyProduct() {
        ProductStorage productStorage = thereIsListProductStorage();
        ProductData product = thereIsExampleProduct();

        productStorage.save(product);
        ProductData loaded = productStorage.load(product.getId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getTitle(), loaded.getTitle());
    }

    @Test
    void itGivesAllPublishedProducts() {
        //Arrange
        ProductStorage productStorage = thereIsListProductStorage();
        ProductData product = thereIsPublishedProduct();
        //Act
        productStorage.save(product);
        List<ProductData> published = productStorage.allPublishedProducts();
        //Assert
        assertEquals(1, published.size());
    }

    private ProductData thereIsPublishedProduct() {
        ProductData example = thereIsExampleProduct();
        example.setPublished(true);
        return example;
    }

    private ProductData thereIsExampleProduct() {
        return new ProductData("example-one", "Example product");
    }
    private ProductStorage thereIsListProductStorage() {
        return new ListProductStorage();
    }
}
