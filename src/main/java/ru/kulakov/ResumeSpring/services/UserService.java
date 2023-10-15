package ru.kulakov.ResumeSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kulakov.ResumeSpring.entity.UserEntity;
import ru.kulakov.ResumeSpring.exception.UserNotFoundException;
import ru.kulakov.ResumeSpring.repos.RoleRepo;
import ru.kulakov.ResumeSpring.repos.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    public Optional<UserEntity> findByUsername(String username){
        return userRepo.findByUsername(username);
    }
    public UserEntity registration(UserEntity user) throws Exception {
        //todo сделать ошибку
        if (userRepo.findByUsername(user.getUsername()).isPresent()) throw new Exception("Такой пользователь уже есть");
        user.setRoles(List.of(
                //todo сделать ошибку
                roleRepo.findByName("USER_ROLE").orElseThrow()
        ));
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        try {
            UserEntity user = findByUsername(username)
                    .orElseThrow(() -> new UserNotFoundException("Такой пользователь не существует"));
            return new User(
                    user.getUsername(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .toList()

            );
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
