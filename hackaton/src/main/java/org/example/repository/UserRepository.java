package org.example.repository;

import org.example.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String name);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}