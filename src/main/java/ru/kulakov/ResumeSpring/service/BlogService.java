package ru.kulakov.ResumeSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kulakov.ResumeSpring.entity.BlogEntity;
import ru.kulakov.ResumeSpring.repo.BlogRepo;
import ru.kulakov.ResumeSpring.repo.UserRepo;

@Service
public class BlogService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BlogRepo blogRepo;

    public BlogEntity addBlog(String login, BlogEntity blog){
        blog.setUser(userRepo.findByUsername(login));
        return blogRepo.save(blog);
    }

    public Iterable<BlogEntity> getAllBlogForUsername(String Username){
        Long userId = userRepo.findByUsername(Username).getId();
        return blogRepo.findAllByUserId(userId);
    }
}
