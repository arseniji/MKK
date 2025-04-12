package org.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "place_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_category_id")
    private Integer id;

    @Column(name = "place_category_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Place> places;

    @OneToMany(mappedBy = "placeCategory", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Quest> quests;
}