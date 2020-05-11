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
 */
public class FieldSpecification<T, V> implements Specification<T> {

    private final String field;

    private final V value;

    public FieldSpecification(String field, V value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.get(field), value);
    }

    public String getField() {
        return field;
    }

    public V getValue() {
        return value;
    }

}
