package pl.jkanclerz.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
    private Sales sales;

    public SalesController(Sales sales) {
        this.sales = sales;
    }

    @GetMapping("/api/sales/current-offer")
    Offer getCurrentOffer() {
        return sales.getCurrentOffer("kuba");
    }
}
