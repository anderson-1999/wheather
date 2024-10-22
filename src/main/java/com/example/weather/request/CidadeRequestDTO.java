package com.example.weather.request;

public record CidadeRequestDTO(
        String nomeCidade,
        String barrio,
        String estado,
        String cep
) {
}
