package com.example.weather.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "cidade_entity")
public class CidadeEntity {

    @Id
    private String id;
    private String nomeCidade;
    private String barrio;
    private String estado;
    private String cep;
}


