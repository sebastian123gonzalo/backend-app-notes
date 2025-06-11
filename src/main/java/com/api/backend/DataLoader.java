package com.api.backend;

import com.api.backend.login.domain.model.User;
import com.api.backend.login.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear un usuario por defecto
        if (userRepository.findByUsername("sebastian123paredes").isEmpty()) {
            User user = new User();
            user.setUsername("sebastian123paredes");
            user.setPassword("123456");
            userRepository.save(user);
        }
    }
}
