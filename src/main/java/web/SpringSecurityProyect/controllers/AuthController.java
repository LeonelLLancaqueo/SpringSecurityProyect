package web.SpringSecurityProyect.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import web.SpringSecurityProyect.service.AuthService;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
  
    private final AuthService authService;

    


    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.saveUsuario(request));
    }
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse>  login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.verificarUsuario(request));
    }

    
}
