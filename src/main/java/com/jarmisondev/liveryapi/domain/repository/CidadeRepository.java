package com.jarmisondev.liveryapi.domain.repository;

import com.jarmisondev.liveryapi.domain.model.Cidade;
import java.util.List;

public interface CidadeRepository {
    List<Cidade> todos();
    Cidade adicionar(Cidade cidade);
    Cidade porId(Long id);
    void remover(Cidade cidade);

}
