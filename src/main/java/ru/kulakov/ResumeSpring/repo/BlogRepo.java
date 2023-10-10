package ru.kulakov.ResumeSpring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kulakov.ResumeSpring.entity.BlogEntity;

@Repository
public interface BlogRepo extends CrudRepository<BlogEntity, Long> {

    Iterable<BlogEntity> findAllByUserId(Long userId);
}
