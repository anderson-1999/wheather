package com.example.weather.controller;

import com.example.weather.entity.UsuarioEntity;
import com.example.weather.reponse.AuthResponseDTO;
import com.example.weather.repository.UsuarioRepository;
import com.example.weather.request.AuthenticationRequestDTO;
import com.example.weather.request.RegisterRequestDTO;
import com.example.weather.utils.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth", produces = {"application/json"})
@Tag(name = "Autenticão do Usuario")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO){

        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationRequestDTO.login(), authenticationRequestDTO.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.ok(new AuthResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO){

        if (this.usuarioRepository.findByLogin(registerRequestDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encriptedPassword = new BCryptPasswordEncoder().encode(registerRequestDTO.senha());

        UsuarioEntity newUsuario =
                new UsuarioEntity(
                        registerRequestDTO.login(),
                        encriptedPassword,
                        registerRequestDTO.role()
                );

        this.usuarioRepository.save(newUsuario);

        return ResponseEntity.ok().build();
    }
}
