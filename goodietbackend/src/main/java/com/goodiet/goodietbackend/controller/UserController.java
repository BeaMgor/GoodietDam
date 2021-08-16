package com.goodiet.goodietbackend.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goodiet.goodietbackend.domain.ApiResponse;
import com.goodiet.goodietbackend.domain.Usuario;
import com.goodiet.goodietbackend.payloads.AuthenticationRequest;
import com.goodiet.goodietbackend.payloads.AuthenticationResponse;
import com.goodiet.goodietbackend.repository.UserRepository;
import com.goodiet.goodietbackend.security.LoginRequest;
import com.goodiet.goodietbackend.security.RegisterRequest;
import com.goodiet.goodietbackend.service.CustomUserDetailsService;
import com.goodiet.goodietbackend.utils.JwtUtil;

@RequestMapping("/api/")
@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtUtil jwtUtil;
    
    @Autowired
    UserRepository userRepository;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());

        final String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {


        if(userRepository.findUsuarioByUsername(registerRequest.getUsername()) != null) {
            return new ResponseEntity(new ApiResponse(false, "El nombre de usuario ya existe."),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Usuario usuario = new Usuario();
        usuario.setUsername(registerRequest.getUsername());
        usuario.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(usuario);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario registrado correctamente."));
    }
    
    @GetMapping("/checkUser")
    public String checkUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return  currentPrincipalName;
    }
    
    @GetMapping("/users/{username}")
    public Usuario findOne(@PathVariable String username) {
        return userRepository.findByUsername(username);
        }
    
    
}
