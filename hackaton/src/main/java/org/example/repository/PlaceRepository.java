package org.example.repository;
import org.example.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.domain.Pageable; // Исправленный импорт
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    @Query(value = """
    SELECT * FROM place 
    WHERE city_id = :cityId 
    ORDER BY RANDOM()
    LIMIT :limit
    """, nativeQuery = true)
    List<Place> findRandomPlaces(
            @Param("cityId") Integer cityId,
            @Param("limit") int limit);
    List<Place> findByCategoryId(Integer categoryId);
}