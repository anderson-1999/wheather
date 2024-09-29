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
    @Mapping(target = "latitude", source = "cidade.latitude")
    @Mapping(target = "longitude", source = "cidade.longitude")
    CidadeResponseDTO paraCidadeResponseDTO(CidadeEntity cidade);

}
