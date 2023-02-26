package com.kruger.challenge.security;

import com.kruger.challenge.model.Rol;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class TokenUtils {
    private final static String SECRET_APP = "PrQ@LKZ%z$b@deuHMkmEU";

    private static final long EXPIRATION_APP =  600000000L;


    public static String generateToken(String username, String email, Set<Rol> roles){
        Date expire = new Date(new Date().getTime() + EXPIRATION_APP);

        Map<String, Object> claims = new HashMap<>();

        ArrayList<GrantedAuthority> authsList = new ArrayList<>(roles.size());
        for (Rol role : roles) {
            authsList.add(new SimpleGrantedAuthority(role.getName()));
        }
        claims.put("username", username);
        claims.put("rol", authsList);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expire)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_APP.getBytes())
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_APP.getBytes()).parseClaimsJws(token).getBody();
            ArrayList permitions = (ArrayList) claims.get("rol");
            HashMap<String, String> value = (HashMap<String, String>) permitions.get(0);
            ArrayList<GrantedAuthority> authsList = new ArrayList<>();
            authsList.add(new SimpleGrantedAuthority(value.get("authority")));
            return new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authsList);

        }catch (Exception e){
            return null;
        }
    }
}
