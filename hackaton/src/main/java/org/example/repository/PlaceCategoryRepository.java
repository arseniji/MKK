package org.example.repository;
import org.example.models.PlaceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceCategoryRepository extends JpaRepository<PlaceCategory, Long> {
}