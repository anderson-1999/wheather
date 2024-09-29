package com.example.weather.converter;


import com.example.weather.entity.CidadeEntity;
import com.example.weather.entity.PoluicaoEntity;
import com.example.weather.request.CidadeRequestDTO;
import com.example.weather.request.PoluicaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PoluicaoConverter {



    public PoluicaoEntity paraPoluicaoEntity(PoluicaoRequestDTO poluicaoDTO) {
        return PoluicaoEntity.builder()
                .id(UUID.randomUUID().toString())
                .idCidade(poluicaoDTO.idCidade())
                .co2(poluicaoDTO.co2())
                .build();

    }

}