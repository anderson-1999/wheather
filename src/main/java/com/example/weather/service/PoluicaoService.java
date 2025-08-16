package com.example.weather.service;

import com.example.weather.entity.PoluicaoEntity;
import com.example.weather.reponse.PoluicaoResponseDTO;
import com.example.weather.repository.PoluicaoRepository;
import com.example.weather.request.PoluicaoRequestDTO;
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
public class PoluicaoService {

    @Autowired
    private PoluicaoRepository poluicaoRepository;

    public PoluicaoResponseDTO gravarPoluicao(PoluicaoRequestDTO poluicaoRequestDTO) {
        try {
            notNull(poluicaoRequestDTO, "Os dados de poluicao são obrigatórios");
            PoluicaoEntity novaPoluicao = new PoluicaoEntity();
            BeanUtils.copyProperties(poluicaoRequestDTO, novaPoluicao);

            PoluicaoEntity poluicaoSalvo = poluicaoRepository.save(novaPoluicao);
            return new PoluicaoResponseDTO(poluicaoSalvo);
        } catch (Exception e) {
            throw new NullPointerException("Erro ao gravar dados da poluição");
        }
    }


    public PoluicaoResponseDTO buscaDadosPoluicao(String id) {
        try {
            Optional<PoluicaoEntity> entity = poluicaoRepository.findById(id);

            if (entity.isPresent()){
                return new PoluicaoResponseDTO(entity.get());
            } else {
                throw new RuntimeException("Dados da poluição não existe!");
            }

        } catch (Exception e) {
            throw new NullPointerException("Erro ao buscar dados de Poluição");
        }
    }

    public List<PoluicaoResponseDTO> buscarTodasPoluicoes(){
        return poluicaoRepository
                .findAll()
                .stream()
                .map(PoluicaoResponseDTO::new)
                .toList();

    }

    @Transactional
    public void deletaDadosPoluicao(String id) {
        Optional<PoluicaoEntity> entity = poluicaoRepository.findById(id);
        if (entity.isPresent()){
            poluicaoRepository.deleteById(id);
        }  else {
            throw new RuntimeException("Dados da poluição não existe!");
        }

    }


}