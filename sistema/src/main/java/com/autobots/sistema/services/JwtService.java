package com.autobots.sistema.services;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private Key getSignINKey(String secret){
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(String username, Long expiration, String secret){
        Date now = new Date(System.currentTimeMillis());
        Date time = new Date(System.currentTimeMillis() + expiration);

        return Jwts.builder().setSubject(username).setExpiration(time).setIssuedAt(now)
        .signWith(this.getSignINKey(secret), SignatureAlgorithm.HS256).compact();
    }

    private Claims extractClaims(String jwtToken, String secret){
        return Jwts.parserBuilder().setSigningKey(getSignINKey(secret)).build().parseClaimsJws(jwtToken).getBody();
    }
    
}
