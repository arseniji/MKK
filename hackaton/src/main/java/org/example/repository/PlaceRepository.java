package org.example.repository;

import org.example.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    List<Place> findByCityId(Integer cityId);

    @Query("SELECT p FROM Place p WHERE p.city.id = :cityId ORDER BY p.rating DESC")
    List<Place> findTopRatedByCityId(@Param("cityId") Integer cityId, Pageable pageable);
}