package com.jarmisondev.liveryapi.domain.service;

import com.jarmisondev.liveryapi.domain.exception.EntidadeEmUsoException;
import com.jarmisondev.liveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.model.Restaurante;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import com.jarmisondev.liveryapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Restaurante> todos() {
        return restauranteRepository.todos();
    }

    public Restaurante buscarPor(Long restauranteId) {
        return restauranteRepository.porId(restauranteId);
    }

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.porId(cozinhaId);

        if (cozinha == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d",cozinhaId));
        }

        restaurante.setCozinha(cozinha);
        return restauranteRepository.adicionar(restaurante);
    }

    public void remover(Restaurante restaurante) {
        try {
            restauranteRepository.remover(restaurante);

        }catch(EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Não existe um cadastro de restaurante atual.");

        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Restauante atual não pode ser removida, pois está em uso");
        }
    }
}
