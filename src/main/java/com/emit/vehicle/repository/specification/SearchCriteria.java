package com.emit.vehicle.repository.specification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;

    public SearchCriteria(String key, String operation, Object value){
        this.key = key;
        this.operation = operation;
        this.value = value;
    }
}