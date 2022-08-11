package com.emit.vehicle.repository.specification.parameters;

public enum OperationParameter {
    EQUALS_TO,
    GREATER_THAN,
    LOWER_THAN;

    public String getValue(){
        switch (this){
            case EQUALS_TO:
                return ":";
            case GREATER_THAN:
                return ">";
            case LOWER_THAN:
                return "<";
            default:
                throw new RuntimeException("The required field does not exists in "+this.getClass()+"");

        }
    };
}
