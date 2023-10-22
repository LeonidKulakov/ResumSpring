package ru.kulakov.ResumeSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kulakov.ResumeSpring.entity.BlogEntity;
import ru.kulakov.ResumeSpring.exception.BlogNotFoundException;
import ru.kulakov.ResumeSpring.exception.UserNotFoundException;
import ru.kulakov.ResumeSpring.models.DeleteBlogModel;
import ru.kulakov.ResumeSpring.repos.BlogRepo;
import ru.kulakov.ResumeSpring.repos.UserRepo;

@Service
public class BlogService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BlogRepo blogRepo;

    public BlogEntity addBlog(String login, BlogEntity blog) {
        try {
            blog.setUser(
                    userRepo
                            .findByUsername(login)
                            .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return blogRepo.save(blog);
    }

    public Iterable<BlogEntity> getAllBlogForUsername(String Username) {
        try {
            return blogRepo.findAllByUserId(
                    userRepo
                            .findByUsername(Username)
                            .orElseThrow(() -> new UserNotFoundException("Пользователь не найден")).getId()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBlog(String username, DeleteBlogModel blogModel) throws UserNotFoundException, BlogNotFoundException {
        blogRepo.delete(blogRepo
                .findByNameBlogAndUserId(
                        blogModel.getNameBlog(),
                        userRepo.findByUsername(username)
                                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"))
                                .getId()
                ).orElseThrow(() -> new BlogNotFoundException("Блог не найден")));
    }
}
