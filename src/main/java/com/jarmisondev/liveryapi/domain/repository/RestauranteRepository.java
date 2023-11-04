package com.jarmisondev.liveryapi.domain.repository;

import com.jarmisondev.liveryapi.domain.model.Restaurante;
import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> todos();
    Restaurante adicionar(Restaurante restaurante);
    void remover(Restaurante restaurante);
    Restaurante porId(Long id);
}
