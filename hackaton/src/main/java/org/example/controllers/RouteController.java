package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.models.Place;
import org.example.service.RoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {
    private final RoutService routeService;

    @GetMapping("/generate")
    public ResponseEntity<List<Place>> generateRoute(
            @RequestParam Integer cityId,
            @RequestParam String routeType
    ) {
        if (!isValidRouteType(routeType)) {
            return ResponseEntity.badRequest().build();
        }

        List<Place> route = routeService.generateRoute(cityId, routeType);
        return ResponseEntity.ok(route);
    }

    private boolean isValidRouteType(String routeType) {
        return routeType.equalsIgnoreCase("short") || routeType.equalsIgnoreCase("long");
    }
}