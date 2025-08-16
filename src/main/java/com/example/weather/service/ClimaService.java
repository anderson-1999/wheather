package com.example.weather.service;


import com.example.weather.entity.ClimaEntity;
import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.reponse.ClimaResponseDTO;
import com.example.weather.repository.ClimaRepository;
import com.example.weather.request.ClimaRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class ClimaService {

    @Autowired
    private ClimaRepository climaRepository;

    public ClimaResponseDTO gravarClima(ClimaRequestDTO climaRequestDTO) {
        try {
            notNull(climaRequestDTO, "Os dados do clima são obrigatórios");
            ClimaEntity novoClima  = new ClimaEntity();
            BeanUtils.copyProperties(climaRequestDTO, novoClima);

            ClimaEntity climaSalvo = climaRepository.save(novoClima);
            return new ClimaResponseDTO(climaSalvo);

        } catch (Exception e) {
            throw new NullPointerException("Erro ao gravar dados do clima");
        }
    }


    public ClimaResponseDTO buscaDadosClima(String id) {
        try {
            Optional<ClimaEntity> entity = climaRepository.findById(id);

            if (entity.isPresent()){
                return new ClimaResponseDTO(entity.get());
            } else {
                throw new RuntimeException("Clima não existe!");
            }
        } catch (Exception e) {
            throw new NullPointerException("Erro ao buscar dados do clima");
        }
    }

    public List<ClimaResponseDTO> buscarTodosClimas(){

        return climaRepository
                .findAll()
                .stream()
                .map(ClimaResponseDTO::new)
                .toList();

    }

    @Transactional
    public void deletaDadosClima(String id) {
        Optional<ClimaEntity> entity = climaRepository.findById(id);
        climaRepository.deleteById(id);

        if (entity.isPresent()){
            climaRepository.delete(entity.get());
        } else {
            throw new RuntimeException("Clima não encontrado!");
        }

    }

    public ClimaResponseDTO atualizar(ClimaEntity climaEntity){
        Optional<ClimaEntity> entity =
                climaRepository.findById(climaEntity.getId());

        if (entity.isPresent()){
            ClimaEntity entitySalvo = climaRepository.save(climaEntity);
            return new ClimaResponseDTO(entitySalvo);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }


}