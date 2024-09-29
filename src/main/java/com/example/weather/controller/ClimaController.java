package com.example.weather.controller;

import com.example.weather.reponse.CidadeResponseDTO;
import com.example.weather.reponse.ClimaResponseDTO;
import com.example.weather.request.ClimaRequestDTO;
import com.example.weather.service.ClimaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clima", produces = {"application/json"})
@Tag(name = "Clima")
@RequiredArgsConstructor
public class ClimaController {

    private final ClimaService climaService;

    @PostMapping
    public ResponseEntity<ClimaResponseDTO> gravarDadosClima(@RequestBody ClimaRequestDTO climaRequestDTO){
        return ResponseEntity.ok(climaService.gravarClima(climaRequestDTO));
    }

    @GetMapping("/id")
    public ResponseEntity<ClimaResponseDTO> buscaClimaPorId(@RequestParam("Id") String id) {
        return ResponseEntity.ok(climaService.buscaDadosClima(id));
    }

    @GetMapping
    public ResponseEntity<List<ClimaResponseDTO>> buscaTodosClimas() {
        return ResponseEntity.ok(climaService.buscarTodosClimas());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaDadosClima(@RequestParam ("id") String id) {
        climaService.deletaDadosClima(id);
        return ResponseEntity.accepted().build();
    }
}

