package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "place")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private int id;

    @Column(name = "place_name", nullable = false)
    private String name;

    @Column(name = "place_address", nullable = false)
    private String address;

    @Column(name = "place_description", nullable = false)
    private String description;

    @Column(name = "rating")
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    @ToString.Exclude // Исключаем из toString
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_category_id", nullable = false)
    @ToString.Exclude // Исключаем из toString
    private PlaceCategory category;
}