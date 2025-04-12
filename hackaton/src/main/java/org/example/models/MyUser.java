package org.example.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
@Data
@Entity
@Table(name = "users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String password;
    private String email;
    private String roles;
    private  int coins;
}