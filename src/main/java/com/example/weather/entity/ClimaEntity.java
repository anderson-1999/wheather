package com.example.weather.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "clima_entity")
public class ClimaEntity {

    @Id
    private String id;
    private CidadeEntity idCidade;
    private double temperatura;
    private double humidade;
}


