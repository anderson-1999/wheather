package com.example.weather.reponse;

import com.example.weather.entity.CidadeEntity;

public record CidadeResponseDTO(
        String id,
        String nomeCidade,
        String barrio,
        String estado,
        String cep
) {

    public CidadeResponseDTO(CidadeEntity novaCidade){
        this(
                novaCidade.getId(),
                novaCidade.getNomeCidade(),
                novaCidade.getBarrio(),
                novaCidade.getEstado(),
                novaCidade.getCep()
        );
    }

}
