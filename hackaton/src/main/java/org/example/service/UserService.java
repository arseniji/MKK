package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.RegistrationDto;
import org.example.models.MyUser;
import org.example.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(RegistrationDto registrationDto) {
        // Проверка существования пользователя
        if (userRepository.existsByName(registrationDto.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        // Проверка email
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("Пользователь с таким email уже зарегистрирован");
        }

        // Создание нового пользователя
        MyUser user = new MyUser();
        user.setName(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setEmail(registrationDto.getEmail());
        user.setRoles("ROLE_USER"); // Роль по умолчанию

        // Сохранение пользователя
        userRepository.save(user);
    }
}