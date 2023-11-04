package com.jarmisondev.liveryapi.infrastructure.repository;

import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Cozinha> todas(){
        return entityManager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }
    @Override
    @Transactional
    public Cozinha adicionar(Cozinha cozinha){
        return entityManager.merge(cozinha);
    }
    @Override
    public Cozinha porId(Long id){
        return entityManager.find(Cozinha.class,id);
    }
    @Override
    @Transactional
    public void remover(Cozinha cozinha){
        cozinha = porId(cozinha.getId());
        if (cozinha != null){
            entityManager.remove(cozinha);
        }else{
            System.out.println("A cozinha ja foi excluida ou não existe");
        }
    }
}
