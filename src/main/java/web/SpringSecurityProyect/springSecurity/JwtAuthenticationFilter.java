package web.SpringSecurityProyect.springSecurity;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    //Esta clase se encarga de realizar la cadena de filtros antes de que la peticion llegue a las clases controllers 
    //verifica si el usuario esta tiene el token para poder acceder a las rutas manejadas por el controller

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            //Este metodo obtiene el token del request y si no lo tiene manda la peticion al filterChain para verificacion
            
            final String token= getTokenFromRequest(request);
            
            if(token == null){
                filterChain.doFilter(request, response);
                return ;
            }

            filterChain.doFilter(request, response);

                
        }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
        
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("bearer ")){
            return authHeader.substring(7);
        }else{
            return null;
        }
    }

}
