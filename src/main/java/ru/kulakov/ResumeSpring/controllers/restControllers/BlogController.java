package ru.kulakov.ResumeSpring.controllers.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kulakov.ResumeSpring.entity.BlogEntity;
import ru.kulakov.ResumeSpring.models.BlogModel;
import ru.kulakov.ResumeSpring.services.BlogService;

@RestController
@RequestMapping("/resum/{login}/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/resum/{login}/add_blog")
    public ResponseEntity addBlog(@PathVariable String username, @RequestBody BlogEntity blog) {
        try {
            blogService.addBlog(username, blog);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Не удалось добавить блог");
        }
    }
    @PostMapping("/resum/{login}/delete_blog")
    public ResponseEntity deleteBlog(@PathVariable String username, @RequestBody BlogModel blogModel){
        try {
            blogService.deleteBlog(username, blogModel);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Не удалось удалить блог");
        }
    }


}
