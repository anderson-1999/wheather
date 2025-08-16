package com.example.weather.service;

import com.example.weather.entity.UsuarioEntity;
import com.example.weather.reponse.UsuarioResposeDTO;
import com.example.weather.repository.UsuarioRepository;
import com.example.weather.request.RegisterRequestDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails usuarioEntity = usuarioRepository.findByLogin(username);

        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }

        return usuarioEntity;
    }

    public UsuarioResposeDTO salvarUsuario(RegisterRequestDTO usuarioDTO){

        String senhaCriptografada = new
                BCryptPasswordEncoder().encode(usuarioDTO.senha());

        UsuarioEntity usuario = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhaCriptografada);

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResposeDTO(usuarioSalvo);

    }

}