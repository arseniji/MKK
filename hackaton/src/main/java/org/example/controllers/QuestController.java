package org.example.controllers;

import org.example.models.Quest;
import org.example.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping("/random-quests")
    public String showRandomQuests(Model model) {
        List<Quest> randomQuests = questService.getRandomQuests();
        model.addAttribute("quests", randomQuests);
        return "random-quests";
    }
}