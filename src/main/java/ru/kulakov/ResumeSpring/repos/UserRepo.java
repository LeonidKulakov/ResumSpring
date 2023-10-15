package ru.kulakov.ResumeSpring.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kulakov.ResumeSpring.entity.UserEntity;

import java.util.Optional;


public interface UserRepo extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

}
