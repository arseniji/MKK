package org.example.mappers;

import lombok.Data;
import org.example.dto.PlaceDTO;
import org.example.models.Place;
import org.springframework.stereotype.Component;

@Component
@Data
public class PlaceMapper {
    public PlaceDTO toDto(Place place) {
        PlaceDTO dto = new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getAddress(),
                place.getDescription(),
                place.getRating(),
                place.getCategory().getName(),
                place.getCity().getName()
        );
        return dto;
    }
}