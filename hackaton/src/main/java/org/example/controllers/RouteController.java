package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.PlaceDTO;
import org.example.mappers.PlaceMapper;
import org.example.models.Place;
import org.example.service.RoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {
    private final RoutService routeService;
    private final PlaceMapper placeMapper;

    @GetMapping("/generate")
    public ResponseEntity<?> generateRoute(
            @RequestParam Integer cityId,
            @RequestParam String routeType) {

        try {
            List<Place> places = routeService.generateRoute(cityId, routeType);
            List<PlaceDTO> dtos = places.stream()
                    .map(placeMapper::toDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}