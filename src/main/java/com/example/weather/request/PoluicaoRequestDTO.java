package com.example.weather.request;

import com.example.weather.entity.CidadeEntity;

public record PoluicaoRequestDTO(
        String id,
        CidadeEntity idCidade,
        double co2
) {
}
