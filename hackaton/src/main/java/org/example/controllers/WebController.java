package org.example.controllers;

import org.example.dto.RegistrationDto;
import org.example.models.MyUser;
import org.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "UserPart/login";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {;
        return "UserPart/registr";
    }

    @GetMapping("/magazine")
    public String magazine() {
        return "UserPart/magazine";
    }


    @GetMapping("/accaunt")
    public String acc(){
        return "UserPart/accaunt";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegistrationDto registrationDto, Model model) {
        try {

            model.addAttribute("registrationSuccess", true); // Успешная регистрация
            return  "UserPart/accaunt"; // Перенаправляем на страницу index
        } catch (Exception e) {
            // Обработка ошибок (например, email уже существует)
            model.addAttribute("registrationError", "Ошибка при регистрации: " + e.getMessage());
            return "UserPart/registr"; // Возвращаемся на страницу регистрации с сообщением об ошибке
        }
    }

    @GetMapping("/history")
    public String history() {
        return "types_of_kurort/history";
    }

    @GetMapping("/sea")
    public String sea() {
        return "types_of_kurort/sea";
    }

    @GetMapping("/sport")
    public String sport() {
        return "types_of_kurort/sport";
    }

    @GetMapping("/nature")
    public String nature() {
        return "types_of_kurort/nature";
    }

    @GetMapping("/personal")
    public String personal(){
        return "UserPart/personal";
    }

    @GetMapping("/sochi")
    public String sochi() {
        return "city/sochi";
    }

    @GetMapping("/park")
    public String park() {
        return "city/park";
    }

    @GetMapping("/gelemd")
    public String gelen() {
        return "city/gelemd";
    }

    @GetMapping("/anapa")
    public String anapa() {
        return "city/anapa";
    }

    @GetMapping("/sochi_history")
    public String sochi_history() {
        return "more_history/sochi_history";
    }

    @GetMapping("/gelen_history")
    public String gelen_history() {
        return "more_history/gelen_history";
    }

    @GetMapping("/anapa_history")
    public String anapa_history() {
        return "more_history/anapa_history";
    }

    @GetMapping("/sochi_nature")
    public String sochi_nature() {
        return "more_nature/sochi_nature";
    }

    @GetMapping("/gelen_nature")
    public String gelen_nature() {
        return "more_nature/gelen_nature";
    }

    @GetMapping("/anapa_nature")
    public String anapa_nature() {
        return "more_nature/anapa_nature";
    }

    @GetMapping("/sochi_sea")
    public String sochi_sea() {
        return "more_sea/sochi_sea";
    }

    @GetMapping("/gelen_sea")
    public String gelen_sea() {
        return "more_sea/gelen_sea";
    }

    @GetMapping("/anapa_sea")
    public String anapa_sea() {
        return "more_sea/anapa_sea";
    }

    @GetMapping("/sochi_sport")
    public String sochi_sport() {
        return "more_sport/sochi_sport";
    }

    @GetMapping("/gelen_sport")
    public String gelen_sport() {
        return "more_sport/gelen_sport";
    }

    @GetMapping("/anapa_sport")
    public String anapa_sport() {
        return "more_sport/anapa_sport";
    }
}