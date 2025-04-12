package org.example.controllers;

import org.example.dto.RegistrationDto;
import org.example.models.MyUser;
import org.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "UserPart/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new RegistrationDto());
        return "UserPart/register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegistrationDto registrationDto, Model model) {
        try {

            model.addAttribute("registrationSuccess", true); // Успешная регистрация
            return "redirect:/personal"; // Перенаправляем на страницу index
        } catch (Exception e) {
            // Обработка ошибок (например, email уже существует)
            model.addAttribute("registrationError", "Ошибка при регистрации: " + e.getMessage());
            return "UserPart/register"; // Возвращаемся на страницу регистрации с сообщением об ошибке
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

    @GetMapping("/gelen")
    public String gelen() {
        return "city/gelen";
    }

    @GetMapping("/anapa")
    public String anapa() {
        return "city/anapa";
    }
}