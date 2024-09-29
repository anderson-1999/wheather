package com.example.weather.request;

public record CidadeRequestDTO(
        String nomeCidade,
        String barrio,
        Long latitude,
        Long longitude
) {
}
