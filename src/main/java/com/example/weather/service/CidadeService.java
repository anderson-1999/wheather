package com.example.weather.service;

import com.example.weather.entity.CidadeEntity;
import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.repository.CidadeRepository;
import com.example.weather.request.CidadeRequestDTO;
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
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeResponseDTO gravarCidade(CidadeRequestDTO cidadeRequestDTO) {
        try {
            notNull(cidadeRequestDTO, "Os dados da cidade são obrigatórios");
            CidadeEntity novoCidade = new CidadeEntity();
            BeanUtils.copyProperties(cidadeRequestDTO, novoCidade);

            CidadeEntity cidadeSalvo = cidadeRepository.save(novoCidade);
            return new CidadeResponseDTO(cidadeSalvo);

        } catch (Exception e) {
            throw new NullPointerException("Erro ao gravar dados da cidade/n" + e.getMessage());
        }
    }


    public CidadeResponseDTO buscaDadosCidade(String id) {
        try {
            Optional<CidadeEntity> entity = cidadeRepository.findById(id);

            if (entity.isPresent()) {
                return new CidadeResponseDTO(entity.get());
            }else {
                throw new RuntimeException("Cidade não existe!");
            }
        } catch (Exception e) {
            throw new NullPointerException("Erro ao buscar dados da cidade" + e.getMessage());
        }
    }

    public List<CidadeResponseDTO> buscarTodasCidades(){

        return cidadeRepository
                .findAll()
                .stream()
                .map(CidadeResponseDTO::new)
                .toList();
    }

    @Transactional
    public void deletaDadosCidade(String id) {

        Optional<CidadeEntity> entity = cidadeRepository.findById(id);

        if(entity.isPresent()){
            cidadeRepository.delete(entity.get());
        } else {
            throw new NullPointerException("cidade Não foi encontrada");
        }

    }


}