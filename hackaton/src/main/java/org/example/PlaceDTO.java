package org.example;

import lombok.Data;

@Data
public class PlaceDTO {
    private int id;
    private String name;
    private String address;
    private String description;
    private Double rating;
    private Integer cityId;
    private Long categoryId;
}