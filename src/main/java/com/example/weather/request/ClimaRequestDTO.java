package com.example.weather.request;

import com.example.weather.entity.CidadeEntity;

public record ClimaRequestDTO(
        String id,
        CidadeEntity idCidade,
        double temperatura,
        double humidade
) {
}
