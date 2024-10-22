package com.example.weather.reponse;

public record CidadeResponseDTO(
        String id,
        String nomeCidade,
        String barrio,
        String estado,
        String cep
) {
}
