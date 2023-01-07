package com.emit.vehicle.repository.specification;

import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteria {
    private String key;
    private OperationParameter operation;
    private Object value;
    private boolean orPredicate;

    public boolean isOrPredicate(){
        return orPredicate;
    }

    public SearchCriteria(final String key, final OperationParameter operation, final Object value){
        super();
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchCriteria(final String orPredicate, final String key, final OperationParameter operation, final Object value){
        super();
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.orPredicate = orPredicate != null && orPredicate.equals(OperationParameter.OR_PREDICATE_FLAG);
    }
}
