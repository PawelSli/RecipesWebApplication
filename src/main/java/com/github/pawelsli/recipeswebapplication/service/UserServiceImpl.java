package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.Role;
import com.github.pawelsli.recipeswebapplication.entity.User;
import com.github.pawelsli.recipeswebapplication.repository.UserRepository;
import com.github.pawelsli.recipeswebapplication.service.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User createUser(UserRegisterDTO registerDTO) {

        System.out.println(registerDTO.getSurname());
        System.out.println(registerDTO.getPhone());
        System.out.println(registerDTO.getPassword());
        System.out.println(registerDTO.getName());
        System.out.println(registerDTO.getEmail());

        User user=new User(
                registerDTO.getName(),
                registerDTO.getSurname(),
                registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()),
                Arrays.asList(new Role("ROLE_USER")),
                LocalDateTime.now(),
                registerDTO.getPhone(),
                null);



        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User
                (user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection <Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
