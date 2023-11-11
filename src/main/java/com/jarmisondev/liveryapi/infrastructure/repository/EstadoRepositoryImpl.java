package com.jarmisondev.liveryapi.infrastructure.repository;

import com.jarmisondev.liveryapi.domain.model.Estado;
import com.jarmisondev.liveryapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estado> todos() {
        return entityManager.createQuery("from Estado",Estado.class).getResultList();
    }

    @Override
    @Transactional
    public Estado adicionar(Estado estado) {
        return entityManager.merge(estado);
    }

    @Override
    public Estado porId(Long id) {
        return entityManager.find(Estado.class,id);
    }

    @Override
    @Transactional
    public void remover(Estado estado) {
        if (estado.getId() != null){
            entityManager.remove(estado);
        }else{
            System.out.println("Estado não existe ou foi removida!!!!");
        }
    }
}
