package com.example.weather.reponse;

import com.example.weather.entity.CidadeEntity;
import com.example.weather.entity.PoluicaoEntity;

public record PoluicaoResponseDTO(
        String id,
        CidadeEntity idCidade,
        double co2
) {

    public PoluicaoResponseDTO(PoluicaoEntity novaPoluicao){
        this(
                novaPoluicao.getId(),
                novaPoluicao.getIdCidade(),
                novaPoluicao.getCo2()
        );
    }

}
