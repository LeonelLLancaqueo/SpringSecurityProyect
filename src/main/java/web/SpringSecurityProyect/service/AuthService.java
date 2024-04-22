package web.SpringSecurityProyect.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.SpringSecurityProyect.controllers.AuthResponse;
import web.SpringSecurityProyect.controllers.LoginRequest;
import web.SpringSecurityProyect.controllers.RegisterRequest;
import web.SpringSecurityProyect.models.User;
import web.SpringSecurityProyect.repository.IUserRepository;





@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    
    private final IUserRepository userRepository;
   
    
    private final JwtService jwtService;

    
    private final PasswordEncoder passwordEncoder;
    


    @Override
    public AuthResponse saveUsuario(RegisterRequest request ) {
        
        User user= User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
        
        userRepository.save(user);

        return new AuthResponse(jwtService.getToken(user)) ;
    }


    @Override
    public AuthResponse verificarUsuario(LoginRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarUsuario'");
    }

    /* 
    public Optional<User> verificarUsuario(String usuario, String contraseña) {
        
        //encriptamos la contraseña antes de consultar a la db
        return usuarioRepository.verificarUsuario(usuario, contraseña);
    }
    */
    




}
