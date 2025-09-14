// src/main/java/com/saas/controller/AuthController.java
package com.saas.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.saas.dto.LoginRequest;
import com.saas.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
// ... outras importações
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha())
            );

            // Carrega o UserDetails após a autenticação bem-sucedida
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

            // Gera o token JWT
            String jwt = jwtService.generateToken(userDetails);

            // Retorna o token no corpo da resposta
            return ResponseEntity.ok(jwt);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }
    }
}