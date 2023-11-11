package com.jarmisondev.liveryapi.api.controller;

import com.jarmisondev.liveryapi.domain.exception.EntidadeEmUsoException;
import com.jarmisondev.liveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.jarmisondev.liveryapi.domain.model.Cidade;
import com.jarmisondev.liveryapi.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CadastroCidadeService cadastroCidade;

    @GetMapping
    public List<Cidade> listar(){
        return cadastroCidade.listar();
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscarCidade(@PathVariable Long cidadeId){
        Cidade cidadeAtual = cadastroCidade.buscar(cidadeId);

        if (cidadeAtual != null){
            return ResponseEntity.ok().body(cidadeAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade){
        try {
            cidade = cadastroCidade.salvar(cidade);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(cadastroCidade.salvar(cidade));

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> atualizar(@RequestBody Cidade cidade, @PathVariable Long cidadeId){
        try {
            Cidade cidadeAtual = cadastroCidade.buscar(cidadeId);

            if (cidadeAtual != null){
                BeanUtils.copyProperties(cidade,cidadeAtual,"id");
                cidadeAtual = cadastroCidade.salvar(cidadeAtual);

                return ResponseEntity.ok().body(cidadeAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<?> remover(@PathVariable Long cidadeId){
        try {
            Cidade cidade = cadastroCidade.buscar(cidadeId);
            cadastroCidade.remover(cidade);

            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
