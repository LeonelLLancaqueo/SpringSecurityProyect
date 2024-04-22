package web.SpringSecurityProyect.service;



import org.springframework.stereotype.Service;

import web.SpringSecurityProyect.controllers.AuthResponse;
import web.SpringSecurityProyect.controllers.LoginRequest;
import web.SpringSecurityProyect.controllers.RegisterRequest;

@Service
public interface IAuthService {
    
    public AuthResponse saveUsuario(RegisterRequest request );

    public AuthResponse verificarUsuario(LoginRequest request);


}
