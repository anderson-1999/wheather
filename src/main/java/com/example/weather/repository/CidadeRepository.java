package com.example.weather.repository;

import com.example.weather.entity.CidadeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CidadeRepository extends MongoRepository<CidadeEntity, String> {

}
