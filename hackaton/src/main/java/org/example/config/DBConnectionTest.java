package org.example.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBConnectionTest implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DBConnectionTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        try {
            // Пример: выбрать название первого города (если есть столбец `name`)
            String cityName = jdbcTemplate.queryForObject(
                    "SELECT place_name FROM place where city_id=1 LIMIT 1",
                    String.class
            );
            System.out.println("✅ Подключено к БД. Первый город: " + cityName);
        } catch (Exception e) {
            System.err.println("❌ Ошибка при запросе к БД: " + e.getMessage());
        }
    }
}