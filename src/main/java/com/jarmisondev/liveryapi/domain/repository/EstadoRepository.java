package com.jarmisondev.liveryapi.domain.repository;

import com.jarmisondev.liveryapi.domain.model.Estado;
import java.util.List;

public interface EstadoRepository {
    List<Estado> todos();
    void remover(Estado estado);
    Estado porId(Long id);
    Estado adicionar(Estado estado);

}
