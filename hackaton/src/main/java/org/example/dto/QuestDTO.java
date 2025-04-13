package org.example.dto;
public class QuestDTO {
    private int id;
    private String description;

    public QuestDTO(int id, String description) {
        this.id = id;
        this.description = description;
    }
    // Геттеры и сеттеры
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}