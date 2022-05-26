package pl.jkanclerz.productcatalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SqlProductStorageTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void createStructure() {
        jdbcTemplate.execute("DROP TABLE products IF EXISTS");
        jdbcTemplate.execute("Create table products ("+
                "`id` varchar(100) NOT NULL, " +
                "`name` varchar(100) NOT NULL, " +
                "`price` DECIMAL(12,2), " +
                "PRIMARY KEY(`id`)"+
                ");");
    }

    @Test
    void itStoreAndLoadMyProduct() {
        ProductStorage productStorage = thereIsSQLProductStorage();
        ProductData product = thereIsExampleProduct();

        productStorage.save(product);
        ProductData loaded = productStorage.load(product.getId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getTitle(), loaded.getTitle());
    }

    @Test
    void itGivesAllPublishedProducts() {
        //Arrange
        ProductStorage productStorage = thereIsSQLProductStorage();
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
    private ProductStorage thereIsSQLProductStorage() {
        return new SQLProductStorage(jdbcTemplate);
    }
}
