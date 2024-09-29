package com.example.weather.converter;

import com.example.weather.entity.CidadeEntity;
import com.example.weather.entity.ClimaEntity;
import com.example.weather.entity.PoluicaoEntity;
import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.reponse.ClimaResponseDTO;
import com.example.weather.reponse.PoluicaoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PoluicaoMapper {

    @Mapping(target = "id", source = "poluicao.id")
    @Mapping(target = "idCidade", source = "poluicao.idCidade")
    @Mapping(target = "co2", source = "poluicao.co2")
    PoluicaoResponseDTO paraPoluicaoResponseDTO(PoluicaoEntity poluicao);

    PoluicaoResponseDTO paraCidadeResponseDTO(CidadeEntity cidadeEntity);
}
