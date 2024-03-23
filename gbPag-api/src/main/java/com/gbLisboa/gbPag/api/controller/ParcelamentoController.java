package com.gbLisboa.gbPag.api.controller;

import com.gbLisboa.gbPag.domain.exception.NegocioException;
import com.gbLisboa.gbPag.domain.model.Parcelamento;
import com.gbLisboa.gbPag.domain.repository.ParcelamentoRepository;
import com.gbLisboa.gbPag.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {

    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoService parcelamentoService;

    @GetMapping
    public List<Parcelamento> listar(){
        return parcelamentoRepository.findAll();
    }
    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<Parcelamento> buscar(@PathVariable Long parcelamentoId){
        return parcelamentoRepository.findById(parcelamentoId)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento){
        return parcelamentoService.cadastrar(parcelamento);
    }
}
