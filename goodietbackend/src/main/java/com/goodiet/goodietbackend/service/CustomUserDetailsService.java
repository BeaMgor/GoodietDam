package com.goodiet.goodietbackend.service;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.goodiet.goodietbackend.domain.Usuario;
import com.goodiet.goodietbackend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findUsuarioByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario " + username + " no encontrado.");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
    }
    
    
}