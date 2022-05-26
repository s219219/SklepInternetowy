package pl.jkanclerz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class SqlPlaygroundTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void simpleSqlQuery() {
        String date = jdbcTemplate.queryForObject(
                "Select now()",
                String.class
        );
    }
}
