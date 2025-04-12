package org.example.dto;

import lombok.Data;

@Data
public class PlaceDTO {
    private Integer id;
    private String name;
    private String address;
    private String description;
    private Double rating;
    private String categoryName;
    private String cityName;
}
