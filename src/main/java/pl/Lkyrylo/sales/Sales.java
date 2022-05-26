package pl.jkanclerz.sales;

import java.math.BigDecimal;

public class Sales {
    private AvailableProducts productsList;
    private CartStorage cartStorage;

    public Sales(AvailableProducts productsList, CartStorage cartStorage) {
        this.productsList = productsList;
        this.cartStorage = cartStorage;
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = cartStorage.getForCustomer(customerId)
                .orElse(Cart.empty());

        BigDecimal total = cart.getItems()
                .stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        return new Offer(total, cart.getItems().size());
    }

    public void addToCart(String customerId, String productId) {
        ProductDetails product = productsList.getById(productId)
                        .orElseThrow(ProductDoesNotExistsException::new);

        Cart cart = cartStorage.getForCustomer(customerId)
                .orElse(Cart.empty());

        cart.add(CartItem.of(productId, product.getName(), product.getPrice()));

        cartStorage.save(customerId, cart);
    }
}
