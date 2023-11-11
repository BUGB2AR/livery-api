package com.jarmisondev.liveryapi.infrastructure.repository;

import com.jarmisondev.liveryapi.domain.model.Permissao;
import com.jarmisondev.liveryapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Permissao> todos() {
        return entityManager.createQuery("from Permissao",Permissao.class).getResultList();
    }

    @Override
    @Transactional
    public Permissao adicionar(Permissao permissao) {
        return entityManager.merge(permissao);
    }

    @Override
    @Transactional
    public void remover(Permissao permissao) {
        if (permissao.getId() != null){
            entityManager.remove(permissao);
        }else{
            System.out.println("Permissão removida ou inexistente");
        }
    }

    @Override
    public Permissao porId(Long id) {
        return entityManager.find(Permissao.class,id);
    }
}
