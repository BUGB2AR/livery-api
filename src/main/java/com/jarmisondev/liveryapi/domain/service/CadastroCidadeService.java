package com.jarmisondev.liveryapi.domain.service;

import com.jarmisondev.liveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.jarmisondev.liveryapi.domain.model.Cidade;
import com.jarmisondev.liveryapi.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade>listar() {
        return cidadeRepository.findAll();
    }

    public Cidade buscar(Long cidadeId) {
        Cidade cidade = cidadeRepository.findById(cidadeId).get();
        return cidade;
    }

    public Cidade salvar(Cidade cidade) {

        Long cidadeEstadoId = cidade.getEstado().getId();
        Cidade cidades = cidadeRepository.findById(cidadeEstadoId).get();

        if (cidades == null){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de estado com código %d",cidadeEstadoId));
        }

        cidades.setEstado(cidades.getEstado());
        return cidadeRepository.save(cidade);
    }

    public void remover(Cidade cidade) {
        try {
            cidadeRepository.delete(cidade);
        }catch(EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException("Não existe um cadastro de cidade atual.");
        }
    }

}
