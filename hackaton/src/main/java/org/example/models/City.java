package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "city_name", nullable = false)
    private String name;

    @Column(name = "city_description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Place> places;
}