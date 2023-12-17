package com.jarmisondev.liveryapi.domain.service;

import com.jarmisondev.liveryapi.domain.exception.EntidadeEmUsoException;
import com.jarmisondev.liveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.jarmisondev.liveryapi.domain.model.Estado;
import com.jarmisondev.liveryapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    public List<Estado> todas() {
        return estadoRepository.findAll();
    }

    public Estado buscarPor(Long estadoId) {
        Estado estado = estadoRepository.findById(estadoId).get();
        return estado;
    }

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void excluir(Estado estado) {
        try {
            estadoRepository.delete(estado);
        }

        catch(EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException("Não existe um cadastro de estado atual.");

        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException("Estado atual não pode ser removido, pois está em uso");
        }
    }
}
