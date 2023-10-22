package ru.kulakov.ResumeSpring.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kulakov.ResumeSpring.entity.BlogEntity;

import java.util.Optional;

@Repository
public interface BlogRepo extends CrudRepository<BlogEntity, Long> {

    Iterable<BlogEntity> findAllByUserId(Long userId);

    Optional<BlogEntity> findByNameBlogAndUserId(String nameBlog, Long userId);

}
