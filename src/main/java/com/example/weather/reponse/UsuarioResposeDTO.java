package com.example.weather.reponse;

import com.example.weather.entity.UsuarioEntity;
import com.example.weather.utils.UserRole;

public record UsuarioResposeDTO(
        String id,
        String login,
        UserRole role
) {

    public UsuarioResposeDTO(UsuarioEntity novoUsuario){
        this(
                novoUsuario.getId(),
                novoUsuario.getUsername(),
                novoUsuario.getRole()
        );
    }

}
