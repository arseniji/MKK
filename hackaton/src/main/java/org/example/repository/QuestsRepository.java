package org.example.repository;

import org.example.models.Quest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestsRepository extends JpaRepository<Quest, Long> {
    @Query(value = "SELECT * FROM quests ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Quest> findRandomQuests();
}