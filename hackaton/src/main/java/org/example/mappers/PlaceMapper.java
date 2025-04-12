package org.example.mappers;

import org.example.dto.PlaceDTO;
import org.example.models.Place;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {
    public PlaceDTO toDto(Place place) {
        PlaceDTO dto = new PlaceDTO();
        dto.setId(place.getId());
        dto.setName(place.getName());
        dto.setAddress(place.getAddress());
        dto.setDescription(place.getDescription());
        dto.setRating(place.getRating());
        dto.setCategoryName(place.getCategory().getName());
        dto.setCityName(place.getCity().getName());
        return dto;
    }
}