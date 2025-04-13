package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Bool;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "place")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Integer id;

    @Column(name = "place_name", nullable = false)
    private String name;

    @Column(name = "place_address", nullable = false)
    private String address;

    @Column(name = "place_description", nullable = false)
    private String description;

    @Column(name = "rating")
    private Double rating;
    public Double getRating() {
        if (this.rating != null) {
            return Math.round(this.rating * 10.0) / 10.0;
        }
        return null;
    }
    @Column(name = "time_length", nullable = false, columnDefinition = "default boolean false")
    private Boolean time_length;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnore
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_category_id", nullable = false)
    @JsonIgnore
    private PlaceCategory category;
}