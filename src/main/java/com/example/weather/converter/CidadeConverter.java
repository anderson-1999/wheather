package com.example.weather.converter;


import com.example.weather.entity.CidadeEntity;
import com.example.weather.request.CidadeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CidadeConverter {



    public CidadeEntity paraCidadeEntity(CidadeRequestDTO cidadeDTO) {
        return CidadeEntity.builder()
                .id(UUID.randomUUID().toString())
                .nomeCidade(cidadeDTO.nomeCidade())
                .barrio(cidadeDTO.barrio())
                .latitude(cidadeDTO.latitude())
                .longitude(cidadeDTO.longitude())
                .build();

    }

}