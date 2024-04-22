package web.SpringSecurityProyect.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;




@Service
public class JwtService {

    private static final String SECRET_KEY="WFWEF45D4DSDC4WD54fDSCWC47EWEC841CRCDS6184SD";

    public String getToken (UserDetails user){
        return getToken(new HashMap<>(), user);
    }

    
    private String getToken(Map<String, Object> extraCleim, UserDetails user) {
        return Jwts
            .builder()
            .claims(extraCleim)
            .subject(user.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis()+60*60*24 ))
            .signWith(getKey())
            .compact();
    }

    private Key getKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);        
    }   

}
