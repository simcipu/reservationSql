/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author simonecipullo
 * @param <T>
 * @param <E>
 */
public class InSpecification<T, E> implements Specification<T> {

    private final String field;

    private final E[] collection;

    @SuppressWarnings("unchecked")
    public InSpecification(String field, E... collection) {
        this.field = field;
        this.collection = collection;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return root.get(field).in(collection);
    }

    public String getField() {
        return field;
    }

    public E[] getCollection() {
        return collection;
    }

}
