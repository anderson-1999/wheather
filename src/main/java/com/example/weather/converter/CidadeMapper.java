package com.example.weather.converter;

import com.example.weather.entity.CidadeEntity;
import com.example.weather.reponse.CidadeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    @Mapping(target = "id", source = "cidade.id")
    @Mapping(target = "nomeCidade", source = "cidade.nomeCidade")
    @Mapping(target = "barrio", source = "cidade.barrio")
    @Mapping(target = "estado", source = "cidade.estado")
    @Mapping(target = "cep", source = "cidade.cep")
    CidadeResponseDTO paraCidadeResponseDTO(CidadeEntity cidade);

}
