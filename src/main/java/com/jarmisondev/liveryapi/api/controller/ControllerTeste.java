package com.jarmisondev.liveryapi.api.controller;

import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.model.Restaurante;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import com.jarmisondev.liveryapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequestMapping("/teste")
@RestController
public class ControllerTeste {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/unica-por-nome")
    public Optional<Cozinha> listarCozinhasPorNome(@RequestParam String nome){
        return cozinhaRepository.findByNome(nome);
    }

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(String nome) {
        return cozinhaRepository.findTodasByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
        return restauranteRepository.findByTaxaFreteBetween(taxaFreteInicial,taxaFreteFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorNome(String nome, Long cozinha){
        return restauranteRepository.findByNomeContainingAndCozinhaId(nome,cozinha);
    }
}
