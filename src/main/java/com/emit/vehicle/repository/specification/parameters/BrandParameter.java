package com.emit.vehicle.repository.specification.parameters;

public enum BrandParameter {
    BRAND_NAME_FIELD,
    BRAND_IMG_FIELD,
    BRAND_ID_FIELD;

    public String getValue(){
        switch (this){
            case BRAND_NAME_FIELD:
                return "brand_name";
            case BRAND_IMG_FIELD:
                return "img";
            case BRAND_ID_FIELD:
                return "id_brand";
            default:
                throw new RuntimeException("The required field does not exists in "+this.getClass()+"");
        }
    }
}
