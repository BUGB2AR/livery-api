package com.jarmisondev.liveryapi.infrastructure.repository;

import com.jarmisondev.liveryapi.domain.model.Cidade;
import com.jarmisondev.liveryapi.domain.repository.CidadeRepository;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    private EntityManager entityManager;
    @Override
    public List<Cidade> todos() {
        return entityManager.createQuery("from cidade",Cidade.class).getResultList();
    }

    @Override
    public Cidade adicionar(Cidade cidade) {
        return entityManager.merge(cidade);
    }

    @Override
    public Cidade porId(Long id) {
        return entityManager.find(Cidade.class,id);
    }

    @Override
    public void remover(Cidade cidade) {
        if (cidade.getId() != null){
            entityManager.remove(cidade);
        }else{
            System.out.println("Cidade não existe ou foi removida!!!!");
        }
    }
}
