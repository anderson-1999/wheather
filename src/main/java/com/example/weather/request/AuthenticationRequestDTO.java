package com.example.weather.request;

public record AuthenticationRequestDTO(
        String login,
        String senha
) {
}
