package ru.kulakov.ResumeSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kulakov.ResumeSpring.entity.UserEntity;
import ru.kulakov.ResumeSpring.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws Exception {
        if (userRepo.findByUsername(user.getUsername()) != null) throw new Exception("Такой пользователь уже есть");
        return userRepo.save(user);
    }
}
