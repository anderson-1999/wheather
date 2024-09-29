package com.example.weather.utils.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.weather.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret")
    private String secret;

    public String generateToken(UsuarioEntity usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("open-api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(genarationExpiretionDate())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException("error ao gerar token", e);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();


        } catch (JWTVerificationException e){
            //throw new RuntimeException("Usuario inválid0", e);
            return "";
        }
    }


    private Instant genarationExpiretionDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
