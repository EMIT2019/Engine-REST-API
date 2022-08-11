package com.emit.vehicle.repository.specification.parameters;

public enum TypeParameter {
    TYPE_NAME_FIELD,
    TYPE_ID_FIELD;

    public String getValue(){
        switch(this){
            case TYPE_NAME_FIELD:
                return "type";
            case TYPE_ID_FIELD:
                return "id_type";
            default:
                throw  new RuntimeException("The required field does not exists in "+this.getClass()+"");
        }
    }
}
