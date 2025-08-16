package com.example.weather.controller;

import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.request.CidadeRequestDTO;
import com.example.weather.service.CidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidade", produces = {"application/json"})
@Tag(name = "Cidades")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<CidadeResponseDTO> gravarDadosCidade(@RequestBody CidadeRequestDTO cidadeRequestDTO){
        return ResponseEntity.ok(cidadeService.gravarCidade(cidadeRequestDTO));
    }

    @GetMapping("/id")
    public ResponseEntity<CidadeResponseDTO> buscaCidadePorId(@RequestParam("Id") String id) {
        return ResponseEntity.ok(cidadeService.buscaDadosCidade(id));
    }

    @GetMapping
    public ResponseEntity<List<CidadeResponseDTO>> buscaTodasCidades() {
        return ResponseEntity.ok(cidadeService.buscarTodasCidades());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletaDadosCidade(@PathVariable ("id") String id) {
        cidadeService.deletaDadosCidade(id);
        return ResponseEntity.accepted().build();
    }
}
