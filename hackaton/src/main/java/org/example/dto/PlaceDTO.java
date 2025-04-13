package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class PlaceDTO {
    private Integer id;
    private String name;
    private String address;
    private String description;
    private Double rating;
    private String categoryName;
    private String cityName;
}
