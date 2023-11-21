package com.jarmisondev.liveryapi.domain.repository;

import com.jarmisondev.liveryapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List <Cozinha> consultarPorNome(String nome);
    List<Cozinha> todas();
    Cozinha porId(Long id);
    Cozinha adicionar(Cozinha cozinha);
    void remover(Cozinha cozinha);

}
