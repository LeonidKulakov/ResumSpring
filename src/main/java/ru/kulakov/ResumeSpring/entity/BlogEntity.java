package ru.kulakov.ResumeSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntity {
    @Id
    private Long id;

    private String photo;
    @Column(length = 8000)
    private String blogText;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;
}
