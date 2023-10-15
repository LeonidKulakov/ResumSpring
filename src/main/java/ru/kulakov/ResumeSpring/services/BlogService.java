package ru.kulakov.ResumeSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kulakov.ResumeSpring.entity.BlogEntity;
import ru.kulakov.ResumeSpring.exception.UserNotFoundException;
import ru.kulakov.ResumeSpring.repos.BlogRepo;
import ru.kulakov.ResumeSpring.repos.UserRepo;

@Service
public class BlogService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BlogRepo blogRepo;

    public BlogEntity addBlog(String login, BlogEntity blog)  {
        try {
            blog.setUser(
                    userRepo
                            .findByUsername(login)
                            .orElseThrow(()-> new UserNotFoundException("Пользователь не найден"))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return blogRepo.save(blog);
    }

    public Iterable<BlogEntity> getAllBlogForUsername(String Username)  {
        try {
            return blogRepo.findAllByUserId(
                    userRepo
                    .findByUsername(Username)
                            .orElseThrow(()-> new UserNotFoundException("Пользователь не найден")).getId()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
