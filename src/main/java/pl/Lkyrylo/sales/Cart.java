package pl.jkanclerz.sales;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void add(CartItem cartItem) {
        items.add(cartItem);
    }

    public List<CartItem> getItems() {
        return items;
    }
}
