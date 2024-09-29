package com.example.weather.service;

import com.example.weather.converter.PoluicaoConverter;
import com.example.weather.converter.PoluicaoMapper;
import com.example.weather.entity.CidadeEntity;
import com.example.weather.entity.PoluicaoEntity;
import com.example.weather.reponse.PoluicaoResponseDTO;
import com.example.weather.repository.PoluicaoRepository;
import com.example.weather.request.PoluicaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class PoluicaoService {

    private final PoluicaoRepository poluicaoRepository;
    private final PoluicaoConverter poluicaoConverter;
    private final PoluicaoMapper poluicaoMapper;


    public PoluicaoEntity salvaPoluicao(PoluicaoEntity poluicaoEntity) {
        return poluicaoRepository.save(poluicaoEntity);
    }

    public PoluicaoResponseDTO gravarPoluicao(PoluicaoRequestDTO poluicaoRequestDTO) {
        try {
            notNull(poluicaoRequestDTO, "Os dados de poluicao são obrigatórios");
            PoluicaoEntity poluicaoEntity = salvaPoluicao(poluicaoConverter.paraPoluicaoEntity(poluicaoRequestDTO));

            return poluicaoMapper.paraPoluicaoResponseDTO(poluicaoEntity);
        } catch (Exception e) {
            e.getMessage();
            throw new NullPointerException("Erro ao gravar dados da poluição");
        }
    }


    public PoluicaoResponseDTO buscaDadosPoluicao(String id) {
        try {
            Optional<PoluicaoEntity> entity = poluicaoRepository.findById(id);
            notNull(entity, "Poluição não encontrado");

            return poluicaoMapper.paraPoluicaoResponseDTO(entity.get());
        } catch (Exception e) {
            e.getMessage();
            throw new NullPointerException("Erro ao buscar dados de Poluição");
        }
    }

    public List<PoluicaoResponseDTO> buscarTodasPoluicoes(){
        List<PoluicaoEntity> poluicoes = poluicaoRepository.findAll();

        return poluicoes.stream().map(poluicaoMapper::paraPoluicaoResponseDTO).toList();

    }

    @Transactional
    public void deletaDadosPoluicao(String id) {
        Optional<PoluicaoEntity> entity = poluicaoRepository.findById(id);
        poluicaoRepository.deleteById(id);

    }


}