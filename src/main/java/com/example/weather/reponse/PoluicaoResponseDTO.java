package com.example.weather.reponse;

import com.example.weather.entity.CidadeEntity;

public record PoluicaoResponseDTO(
        String id,
        CidadeEntity idCidade,
        double co2
) {
}
