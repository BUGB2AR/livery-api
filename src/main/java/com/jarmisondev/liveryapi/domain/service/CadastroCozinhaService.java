package com.jarmisondev.liveryapi.domain.service;

import com.jarmisondev.liveryapi.domain.exception.EntidadeEmUsoException;
import com.jarmisondev.liveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Cozinha> todas() {
        return cozinhaRepository.todas();
    }

    public Cozinha buscarPor(Long cozinhaId) {
        return cozinhaRepository.porId(cozinhaId);
    }

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.adicionar(cozinha);
    }

    public void excluir(Cozinha cozinha) {
        try {
            cozinhaRepository.remover(cozinha);

        }catch(EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException("Não existe um cadastro de cozinha atual.");

        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException("Cozinha atual não pode ser removida, pois está em uso");
        }
    }
}
