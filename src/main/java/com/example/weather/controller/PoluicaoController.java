package com.example.weather.controller;

import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.reponse.PoluicaoResponseDTO;
import com.example.weather.request.PoluicaoRequestDTO;
import com.example.weather.service.PoluicaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/poluicao", produces = {"application/json"})
@Tag(name = "Poluição")
@RequiredArgsConstructor
public class PoluicaoController {

    private final PoluicaoService poluicaoService;

    @PostMapping
    public ResponseEntity<PoluicaoResponseDTO> gravarDadosPoluicao(@RequestBody PoluicaoRequestDTO poluicaoRequestDTO){
        return ResponseEntity.ok(poluicaoService.gravarPoluicao(poluicaoRequestDTO));
    }

    @GetMapping("/id")
    public ResponseEntity<PoluicaoResponseDTO> buscaPoluicaoPorId(@RequestParam("Id") String id) {
        return ResponseEntity.ok(poluicaoService.buscaDadosPoluicao(id));
    }

    @GetMapping
    public ResponseEntity<List<PoluicaoResponseDTO>> buscaTodasPoluicoes() {
        return ResponseEntity.ok(poluicaoService.buscarTodasPoluicoes());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaDadosPoluicao(@RequestParam ("id") String id) {
        poluicaoService.deletaDadosPoluicao(id);
        return ResponseEntity.accepted().build();
    }
}

