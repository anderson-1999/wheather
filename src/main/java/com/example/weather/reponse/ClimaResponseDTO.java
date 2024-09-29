package com.example.weather.reponse;

import com.example.weather.entity.CidadeEntity;

public record ClimaResponseDTO(
        String id,
        CidadeEntity idCidade,
        double temperatura,
        double humidade
) {
}
