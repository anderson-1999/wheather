package com.example.weather.service;

import com.example.weather.converter.ClimaConverter;
import com.example.weather.converter.ClimaMapper;
import com.example.weather.entity.CidadeEntity;
import com.example.weather.entity.ClimaEntity;
import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.reponse.ClimaResponseDTO;
import com.example.weather.repository.ClimaRepository;
import com.example.weather.request.ClimaRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class ClimaService {

    private final ClimaRepository climaRepository;
    private final ClimaConverter climaConverter;
    private final ClimaMapper climaMapper;


    public ClimaEntity salvaClima(ClimaEntity climaEntity) {
        return climaRepository.save(climaEntity);
    }

    public ClimaResponseDTO gravarClima(ClimaRequestDTO climaRequestDTO) {
        try {
            notNull(climaRequestDTO, "Os dados do usuário são obrigatórios");
            ClimaEntity climaEntity = salvaClima(climaConverter.paraClimaEntity(climaRequestDTO));

            return climaMapper.paraClimaResponseDTO(climaEntity);
        } catch (Exception e) {
            e.getMessage();
            throw new NullPointerException("Erro ao gravar dados do clima");
        }
    }


    public ClimaResponseDTO buscaDadosClima(String id) {
        try {
            Optional<ClimaEntity> entity = climaRepository.findById(id);
            notNull(entity, "clima não encontrado");

            return climaMapper.paraClimaResponseDTO(entity.get());
        } catch (Exception e) {
            e.getMessage();
            throw new NullPointerException("Erro ao buscar dados do clima");
        }
    }

    public List<ClimaResponseDTO> buscarTodosClimas(){
        List<ClimaEntity> cidades = climaRepository.findAll();

        return cidades.stream().map(climaMapper::paraClimaResponseDTO).toList();

    }

    @Transactional
    public void deletaDadosClima(String id) {
        Optional<ClimaEntity> entity = climaRepository.findById(id);
        climaRepository.deleteById(id);

    }


}