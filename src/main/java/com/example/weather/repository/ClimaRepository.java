package com.example.weather.repository;

import com.example.weather.entity.ClimaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClimaRepository extends MongoRepository<ClimaEntity, String> {
}