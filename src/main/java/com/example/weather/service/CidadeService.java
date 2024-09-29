package com.example.weather.service;

import com.example.weather.converter.CidadeConverter;
import com.example.weather.converter.CidadeMapper;
import com.example.weather.entity.CidadeEntity;
import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.repository.CidadeRepository;
import com.example.weather.request.CidadeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;
    private final CidadeConverter cidadeConverter;
    private final CidadeMapper cidadeMapper;


    public CidadeEntity salvaCidade(CidadeEntity cidadeEntity) {
        return cidadeRepository.save(cidadeEntity);
    }

    public CidadeResponseDTO gravarCidade(CidadeRequestDTO cidadeRequestDTO) {
        try {
            notNull(cidadeRequestDTO, "Os dados da cidade são obrigatórios");
            CidadeEntity cidadeEntity = salvaCidade(cidadeConverter.paraCidadeEntity(cidadeRequestDTO));

            return cidadeMapper.paraCidadeResponseDTO(cidadeEntity);
        } catch (Exception e) {
            e.getMessage();
            throw new NullPointerException("Erro ao gravar dados da cidade");
        }
    }


    public CidadeResponseDTO buscaDadosCidade(String id) {
        try {
            Optional<CidadeEntity> entity = cidadeRepository.findById(id);
            notNull(entity, "Usuário não encontrado");

            return cidadeMapper.paraCidadeResponseDTO(entity.get());
        } catch (Exception e) {
            e.getMessage();
            throw new NullPointerException("Erro ao buscar dados de usuário");
        }
    }

    public List<CidadeResponseDTO> buscarTodasCidades(){
        List<CidadeEntity> cidades = cidadeRepository.findAll();

        return cidades.stream().map(cidadeMapper::paraCidadeResponseDTO).toList();

    }

    @Transactional
    public void deletaDadosCidade(String id) {
        Optional<CidadeEntity> entity = cidadeRepository.findById(id);
        cidadeRepository.deleteById(id);

    }


}