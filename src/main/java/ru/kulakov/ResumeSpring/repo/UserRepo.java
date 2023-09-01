package ru.kulakov.ResumeSpring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kulakov.ResumeSpring.entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername (String username);
}
