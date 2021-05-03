package com.github.pawelsli.recipeswebapplication.security;

import com.github.pawelsli.recipeswebapplication.security.UserDetailsImpl;
import com.github.pawelsli.recipeswebapplication.entity.User;
import com.github.pawelsli.recipeswebapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with mail: " + email));
        return UserDetailsImpl.build(user);
    }

    public UserDetails loadUserByNick(String nick) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(nick)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with nick: " + nick));
        return UserDetailsImpl.build(user);
    }

}
