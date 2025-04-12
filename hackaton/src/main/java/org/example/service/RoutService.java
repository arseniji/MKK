package org.example.service;

import org.example.models.Place;
import org.example.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RoutService {
    private final PlaceRepository placeRepository;

    public RoutService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> generateRoute(Integer cityId, String routeType) {
        // Определяем количество мест
        int minPlaces = routeType.equalsIgnoreCase("short") ? 1 : 4;
        int maxPlaces = routeType.equalsIgnoreCase("short") ? 2 : 5;
        int count = new Random().nextInt(maxPlaces - minPlaces + 1) + minPlaces;

        // Получаем случайные места без учета ранее показанных
        return placeRepository.findRandomPlaces(cityId, count);
    }
}