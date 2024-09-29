package com.example.weather.reponse;

public record CidadeResponseDTO(
        String id,
        String nomeCidade,
        String barrio,
        Long latitude,
        Long longitude
) {
}
