package com.jarmisondev.liveryapi.api.controller;

import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping
    public List<Cozinha> listar(){
        return cozinhaRepository.todas();
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity buscar(@PathVariable Long cozinhaId){
        Cozinha cozinha = cozinhaRepository.porId(cozinhaId);

        if (cozinha != null){
            return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
