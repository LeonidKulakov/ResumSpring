package ru.kulakov.ResumeSpring.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kulakov.ResumeSpring.entity.RoleEntity;

import java.util.Optional;

public interface RoleRepo extends CrudRepository<RoleEntity, Long> {


    Optional<RoleEntity> findByName(String name);
}
