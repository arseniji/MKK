package org.example;

import org.example.models.MyUser;
import org.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("jddjdjdd");
    }
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByName("admin").isEmpty()) {
                MyUser admin = new MyUser();
                admin.setName("admin"); // Исправлено на setName
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRoles("ROLE_ADMIN"); // Исправлено на setRoles
                admin.setEmail("admin@example.com");
                userRepository.save(admin);
                System.out.println("Создан тестовый пользователь: admin / admin123");
            }
        };
    }


}