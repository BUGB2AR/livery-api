package com.jarmisondev.liveryapi.infrastructure.repository;

import com.jarmisondev.liveryapi.domain.model.Estado;
import com.jarmisondev.liveryapi.domain.repository.EstadoRepository;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Component;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Estado> todos() {
        return entityManager.createQuery("from estado",Estado.class).getResultList();
    }

    @Override
    @Transactional
    public void remover(Estado estado) {
        if (estado.getId() != null){
            entityManager.remove(estado);
        }else{
            System.out.println("Estado remido ou não existe cadastrado!!!");
        }
    }

    @Override
    public Estado porId(Long id) {
       return entityManager.find(Estado.class,id);
    }

    @Override
    @Transactional
    public Estado adicionar(Estado estado) {
        return entityManager.merge(estado);
    }
}
