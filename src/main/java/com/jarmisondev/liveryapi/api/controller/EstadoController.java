package com.jarmisondev.liveryapi.api.controller;


import com.jarmisondev.liveryapi.domain.exception.EntidadeEmUsoException;
import com.jarmisondev.liveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.jarmisondev.liveryapi.domain.model.Estado;
import com.jarmisondev.liveryapi.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private CadastroEstadoService cadastroEstado;

    @GetMapping
    public List<Estado> listar() {
        return cadastroEstado.todas();
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscarCidade(@PathVariable Long estadoId) {
        Estado estadoAtual = cadastroEstado.buscarPor(estadoId);

        if (estadoAtual != null){
            return ResponseEntity.ok().body(estadoAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> adicionar(@RequestBody Estado estado) {
        try {
            estado = cadastroEstado.salvar(estado);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(cadastroEstado.salvar(estado));

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<?> atualizar(@RequestBody Estado estado, @PathVariable Long estadoId) {
        Estado estadoAtual = cadastroEstado.buscarPor(estadoId);
        try {
            if (estadoAtual != null){
                BeanUtils.copyProperties(estado,estadoAtual,"id");
                estadoAtual = cadastroEstado.salvar(estadoAtual);

                return ResponseEntity.ok().body(estadoAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?> remover(@PathVariable Long estadoId) {
        try {
            Estado estado = cadastroEstado.buscarPor(estadoId);
            cadastroEstado.excluir(estado);

            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException exception) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
