package com.example.weather.reponse;

import com.example.weather.entity.CidadeEntity;
import com.example.weather.entity.ClimaEntity;

public record ClimaResponseDTO(
        String id,
        CidadeEntity idCidade,
        double temperatura,
        double humidade
) {

    public ClimaResponseDTO(ClimaEntity novoClima){
        this(
                novoClima.getId(),
                novoClima.getIdCidade(),
                novoClima.getTemperatura(),
                novoClima.getHumidade()
        );
    }

}
