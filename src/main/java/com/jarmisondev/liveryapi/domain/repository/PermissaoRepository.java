package com.jarmisondev.liveryapi.domain.repository;

import com.jarmisondev.liveryapi.domain.model.Permissao;
import java.util.List;

public interface PermissaoRepository {
    List<Permissao> todos();
    Permissao adicionar(Permissao permissao);
    void remover(Permissao permissao);
    Permissao porId(Long id);
}
