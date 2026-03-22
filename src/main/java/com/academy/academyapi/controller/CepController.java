package com.academy.academyapi.controller;

import com.academy.academyapi.domain.dto.cep.CepResponse;
import com.academy.academyapi.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
@RequiredArgsConstructor
public class CepController {

    private final CepService service;

    @GetMapping("/{cep}")
    public CepResponse buscarCpf (@PathVariable String cep ) {
        return service.buscarPorCep(cep);
    }
}