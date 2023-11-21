package com.jarmisondev.liveryapi.api.controller;

import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RequestMapping("/teste")
public class ControllerTeste {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> listarCozinhasPorNome(@RequestParam String nome){
        return cozinhaRepository.consultarPorNome(nome);
    }

}
