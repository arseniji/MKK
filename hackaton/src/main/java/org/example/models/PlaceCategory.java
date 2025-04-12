package org.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "place_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_category_id")
    private Long id;
    @Column(name = "place_category_name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude // Исключаем из toString
    private List<Place> places = new ArrayList<>();
}