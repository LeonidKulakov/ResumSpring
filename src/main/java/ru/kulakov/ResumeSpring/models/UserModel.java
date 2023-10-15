package ru.kulakov.ResumeSpring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

    private String login;
    private String password;
}
