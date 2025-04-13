package org.example.controllers;

import org.example.dto.PlaceDTO;
import org.example.dto.QuestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class PlaceAndQuestController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlaceAndQuestController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/{cityName}/cityPlaces")
    public String getCityPlaces(@PathVariable String cityName, Model model) {
        // Декодируем русские символы в URL
        String decodedCityName = java.net.URLDecoder.decode(cityName, StandardCharsets.UTF_8);

        // Получаем ID города
        Integer cityId = jdbcTemplate.queryForObject(
                "SELECT city_id FROM city WHERE city_name = ?",
                Integer.class,
                decodedCityName
        );

        if (cityId == null) {
            return "redirect:/";
        }

        // Выбираем мероприятия
        List<PlaceDTO> activities = getPlacesByCategory(cityId, Arrays.asList(
                "Исторические места", "Природные достопримечательности",
                "Развлечения", "Музеи", "Парки", "Горные объекты", "Водопады",
                "Архитектура", "Спортивные объекты"
        ), 2);

        // Выбираем места для еды
        List<PlaceDTO> foodPlaces = getPlacesByCategory(cityId, Collections.singletonList("Еда"), 1);

        // Выбираем отели
        List<PlaceDTO> hotels = getPlacesByCategory(cityId, Collections.singletonList("Отели"), 1);

        // Получаем квесты для каждого места
        Map<Integer, QuestDTO> placeQuests = new HashMap<>();

        // Для мероприятий
        activities.forEach(place -> {
            QuestDTO quest = getQuestForPlace(place.getCategoryName());
            if (quest != null) {
                placeQuests.put(place.getId(), quest);
            }
        });

        // Для мест еды
        foodPlaces.forEach(place -> {
            QuestDTO quest = getQuestForPlace(place.getCategoryName());
            if (quest != null) {
                placeQuests.put(place.getId(), quest);
            }
        });

        // Для отелей
        hotels.forEach(place -> {
            QuestDTO quest = getQuestForPlace(place.getCategoryName());
            if (quest != null) {
                placeQuests.put(place.getId(), quest);
            }
        });

        model.addAttribute("cityName", decodedCityName);
        model.addAttribute("activities", activities);
        model.addAttribute("foodPlaces", foodPlaces);
        model.addAttribute("hotels", hotels);
        model.addAttribute("placeQuests", placeQuests);

        return "cityPlaces";
    }

    private List<PlaceDTO> getPlacesByCategory(Integer cityId, List<String> categories, int limit) {
        String inSql = String.join(",", Collections.nCopies(categories.size(), "?"));

        List<Object> params = new ArrayList<>();
        params.add(cityId);
        params.addAll(categories);
        params.add(limit);

        return jdbcTemplate.query(
                "SELECT " +
                        "p.place_id as id, " +
                        "p.place_name as name, " +
                        "p.place_address as address, " +
                        "p.place_description as description, " +
                        "p.rating as rating, " +
                        "pc.place_category_name as category_name, " +
                        "c.city_name as city_name " +
                        "FROM place p " +
                        "JOIN place_category pc ON p.place_category_id = pc.place_category_id " +
                        "JOIN city c ON p.city_id = c.city_id " +
                        "WHERE p.city_id = ? AND pc.place_category_name IN (" + inSql + ") " +
                        "ORDER BY RANDOM() LIMIT ?",
                (rs, rowNum) -> new PlaceDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("description"),
                        rs.getDouble("rating"),
                        rs.getString("category_name"),
                        rs.getString("city_name")
                ),
                params.toArray()
        );
    }

    private QuestDTO getQuestForPlace(String categoryName) {
        // Получаем ID категории места
        Integer categoryId = jdbcTemplate.queryForObject(
                "SELECT place_category_id FROM place_category WHERE place_category_name = ?",
                Integer.class,
                categoryName
        );

        if (categoryId == null) {
            return null;
        }

        // Получаем случайный квест для этой категории
        List<QuestDTO> quests = jdbcTemplate.query(
                "SELECT quest_id, quest_description FROM quest WHERE place_category_id = ? ORDER BY RANDOM() LIMIT 1",
                (rs, rowNum) -> new QuestDTO(
                        rs.getInt("quest_id"),
                        rs.getString("quest_description")
                ),
                categoryId
        );

        return quests.isEmpty() ? null : quests.get(0);
    }
}