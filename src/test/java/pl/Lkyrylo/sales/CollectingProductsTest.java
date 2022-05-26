package pl.jkanclerz.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CollectingProductsTest {

    public static final BigDecimal EXAMPLE_PRICE = BigDecimal.valueOf(10.10);

    public List<ProductDetails> products;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
    }

    @Test
    void initialOfferIsBlank() {
        //Arrange / Given
        String customerId = thereIsCustomer("Kuba");
        Sales sales = thereIsSalesModule();

        //Act / When
        Offer offer = sales.getCurrentOffer(customerId);

        //Assert / Then
        assertEquals(BigDecimal.ZERO, offer.getTotal());
        assertEquals(0, offer.getItemsCount());
    }

    @Test
    void itAllowsToGrabSomeProduct() {
        //Arrange / Given
        String customerId = thereIsCustomer("Kuba");
        String productId = thereIsProduct("lego-set-1", EXAMPLE_PRICE);
        Sales sales = thereIsSalesModule();

        //Act / When
        sales.addToCart(customerId, productId);
        Offer offer = sales.getCurrentOffer(customerId);

        //Assert / Then
        assertEquals(EXAMPLE_PRICE, offer.getTotal());
        assertEquals(1, offer.getItemsCount());
    }

    private String thereIsProduct(String id, BigDecimal price) {
        products.add(new ProductDetails(id, id, price));
        return id;
    }

    private Sales thereIsSalesModule() {
        return new Sales(
                new AvailableProducts(products),
                new CartStorage()
        );
    }

    private String thereIsCustomer(String id) {
        return id;
    }
}
