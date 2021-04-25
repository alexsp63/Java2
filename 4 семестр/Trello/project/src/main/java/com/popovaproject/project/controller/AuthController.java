package com.popovaproject.project.controller;

import com.popovaproject.project.entity.User;
import com.popovaproject.project.repository.UserRepository;
import com.popovaproject.project.security.JWTTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, JWTTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        try {
            String login = request.getLogin();
            String password = request.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
            User user = userRepository.findByLogin(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Такого пользователя не существует"));
            String token = jwtTokenProvider.createToken(login, user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("login", login);
            response.put("password", password);
            response.put("firstName", user.getFirstName());
            response.put("lastName", user.getLastName());
            response.put("role", user.getRole().name());
            response.put("status", user.getStatus().name());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK); //всё равно токена не возвращается
        }
    }
}
