package com.example.weather.converter;

import com.example.weather.entity.ClimaEntity;
import com.example.weather.reponse.ClimaResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClimaMapper {

    @Mapping(target = "id", source = "clima.id")
    @Mapping(target = "idCidade", source = "clima.idCidade")
    @Mapping(target = "temperatura", source = "clima.temperatura")
    @Mapping(target = "humidade", source = "clima.humidade")
    ClimaResponseDTO paraClimaResponseDTO(ClimaEntity clima);

}
