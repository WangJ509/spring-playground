package com.example.springplayground.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class CustomQueryRepoImpl<T> implements CustomQueryRepo<T> {

    final EntityManager entityManager;

    @Override
    public <S extends T> List<S> findByDataTimeBetween(Example<S> example, Date start, Date end) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<S> query = builder.createQuery(example.getProbeType());

        Root<S> root = query.from(example.getProbeType());
        Predicate examplePredicate = QueryByExamplePredicateBuilder.getPredicate(root, builder, example);
        Predicate datePredicate = builder.between(root.get("dataTime"), start, end);

        if (examplePredicate != null) {
            query.where(builder.and(examplePredicate, datePredicate));
        } else {
            query.where(datePredicate);
        }

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

}
