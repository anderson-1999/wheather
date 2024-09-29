package com.example.weather.repository;

import com.example.weather.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
    UserDetails findByLogin(String login);
}
