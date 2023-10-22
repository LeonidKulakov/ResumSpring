package ru.kulakov.ResumeSpring.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddBlogModel {

    private File photo;
    private String nameBlog;
    private String shortTextBlog;
    private String textBlog;

}
