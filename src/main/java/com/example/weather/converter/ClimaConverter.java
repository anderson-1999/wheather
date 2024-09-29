package com.example.weather.converter;


import com.example.weather.entity.CidadeEntity;
import com.example.weather.entity.ClimaEntity;
import com.example.weather.request.CidadeRequestDTO;
import com.example.weather.request.ClimaRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClimaConverter {



    public ClimaEntity paraClimaEntity(ClimaRequestDTO climaDTO) {
        return ClimaEntity.builder()
                .id(UUID.randomUUID().toString())
                .idCidade(climaDTO.idCidade())
                .temperatura(climaDTO.temperatura())
                .humidade(climaDTO.humidade())
                .build();

    }

}