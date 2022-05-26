package pl.jkanclerz.productcatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {

    @Test
    void itAllowsToListAvailableProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        List<ProductData> products = catalog.allPublishedProducts();
        //Asserting
        assertEquals(0, products.size());
    }

    @Test
    void itAllowsToAddDraftProductToCatalog() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego-block", "Lego blocks");

        List<ProductData> products = catalog.allPublishedProducts();
        assertEquals(0, products.size());
    }

    @Test
    void itAllowsToAddMedia() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego-block", "Lego blocks");

        catalog.assignImage(productId, "image://someNiceImage");

        ProductData loadedProduct = catalog.getDetails(productId);
        assertEquals("image://someNiceImage", loadedProduct.getImage());
    }

    @Test
    void productCantBePublishedWithoutPrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego-block", "Lego blocks");

        assertThrows(CantPublishProductException.class, () -> {
            catalog.publish(productId);
        });
    }

    @Test
    void itAllowsTOAssignPriceToProduct() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego-block", "Lego blocks");

        catalog.assignPrice(productId, BigDecimal.valueOf(10.10));
        ProductData loadedProduct = catalog.getDetails(productId);
        assertEquals(BigDecimal.valueOf(10.10), loadedProduct.price());
    }

    @Test
    void itAllowsPublishingFullfilledProductHAPPYPATH() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego-block", "Lego blocks");

        catalog.assignPrice(productId, BigDecimal.valueOf(10.10));
        catalog.assignImage(productId, "image://someNiceImage");
        catalog.publish(productId);
        List<ProductData> products = catalog.allPublishedProducts();

        assertEquals(1, products.size());
    }


    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(new MapProductStorage());
    }
}
