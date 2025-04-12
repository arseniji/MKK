package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.models.Place;
import org.example.repository.PlaceRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RoutService {
    private final PlaceRepository placeRepository;
    private final Random random = new Random();

    public List<Place> generateRoute(Integer cityId, String routeType) {
        List<Place> allPlaces = placeRepository.findByCityId(cityId);

        if (allPlaces.isEmpty()) {
            throw new IllegalArgumentException("No places found for city with id: " + cityId);
        }

        int placesCount;
        if ("long".equalsIgnoreCase(routeType)) {
            placesCount = Math.min(5, allPlaces.size());
        } else {
            placesCount = Math.min(2, allPlaces.size());
        }

        // Сначала берем топовые места по рейтингу
        List<Place> topRated = placeRepository.findTopRatedByCityId(
                cityId,
                PageRequest.of(0, placesCount)
        );

        // Если топовых мест недостаточно, добавляем случайные
        if (topRated.size() < placesCount) {
            List<Place> remainingPlaces = new ArrayList<>(allPlaces);
            remainingPlaces.removeAll(topRated);

            int needed = placesCount - topRated.size();
            Collections.shuffle(remainingPlaces);

            topRated.addAll(remainingPlaces.subList(0, Math.min(needed, remainingPlaces.size())));
        }

        return topRated;
    }
}