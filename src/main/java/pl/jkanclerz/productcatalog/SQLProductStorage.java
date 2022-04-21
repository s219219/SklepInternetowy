package pl.jkanclerz.productcatalog;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SQLProductStorage implements ProductStorage {
    private JdbcTemplate jdbcTemplate;

    public SQLProductStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductData> allPublishedProducts() {
        //SQL select * from products where published = 1;
        return null;
    }

    @Override
    public void save(ProductData newProduct) {
        //insert into products values (id, name) (?,?)
    }

    @Override
    public ProductData load(String productId) {
        //SQL select * from products where id = ?
        return null;
    }
}
