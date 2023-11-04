package com.jarmisondev.liveryapi.infrastructure.repository;

import com.jarmisondev.liveryapi.domain.model.FormaPagamento;
import com.jarmisondev.liveryapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FormaPagamento> todos() {
        return entityManager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Override
    public void remover(FormaPagamento formaPagamento) {
        if (formaPagamento.getId() != null){
            entityManager.remove(formaPagamento);
        }else{
            System.out.println("Forma de pagamento não existe ou ja foi removida!!");
        }
    }

    @Override
    @Transactional
    public FormaPagamento adicionar(FormaPagamento formaPagamento) {
        return entityManager.merge(formaPagamento);
    }

    @Override
    @Transactional
    public FormaPagamento porId(Long id) {
        return entityManager.find(FormaPagamento.class,id);
    }
}
