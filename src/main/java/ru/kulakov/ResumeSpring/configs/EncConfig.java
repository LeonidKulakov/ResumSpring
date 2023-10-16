package ru.kulakov.ResumeSpring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Вынужденное создание бина вне SecurityConfig, иначе при инъекции в UserService сваливаюсь в рекурсию
 * */
@Configuration
public class EncConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
