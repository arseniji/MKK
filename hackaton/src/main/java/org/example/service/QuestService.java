package org.example.service;

import org.example.models.Quest;
import org.example.repository.QuestsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private final QuestsRepository questRepository;

    public QuestService(QuestsRepository questRepository) {
        this.questRepository = questRepository;
    }

    public List<Quest> getRandomQuests() {
        return questRepository.findRandomQuests();
    }
}