package com.example.weather.repository;

import com.example.weather.entity.PoluicaoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PoluicaoRepository extends MongoRepository<PoluicaoEntity, String> {
}
