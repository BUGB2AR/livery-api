package com.jarmisondev.liveryapi.infrastructure.repository;

import com.jarmisondev.liveryapi.domain.model.Restaurante;
import com.jarmisondev.liveryapi.domain.repository.RestauranteRepository;
import com.jarmisondev.liveryapi.domain.repository.RestauranteRepositoryQueries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static com.jarmisondev.liveryapi.infrastructure.repository.spec.RestaurantesSpecs.comFreteGratis;
import static com.jarmisondev.liveryapi.infrastructure.repository.spec.RestaurantesSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    @Lazy
    private RestauranteRepository repository;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
        Root<Restaurante> root = criteria.from(Restaurante.class);

        var predicates = new ArrayList<Predicate>();

        if (nome != null && !nome.isEmpty()) {
            predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
        }

        if (taxaFreteInicial != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        }

        if (taxaFreteFinal != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        }

        criteria.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Restaurante> query = entityManager.createQuery(criteria);

        return query.getResultList();
    }

	@Override
	public List<Restaurante> findComFreteGratis(String nome) {
		return repository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
	}
}
