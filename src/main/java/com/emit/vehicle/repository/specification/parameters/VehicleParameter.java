package com.emit.vehicle.repository.specification.parameters;

public enum VehicleParameter {
    VEHICLE_ID_FIELD,
    VEHICLE_BRAND_FIELD,
    VEHICLE_TYPE_FIELD,
    VEHICLE_HP_FIELD,
    VEHICLE_TS_FIELD,
    VEHICLE_IMG_FIELD,
    VEHICLE_MODEL_FIELD;

    public String getValue(){
        switch (this){
            case VEHICLE_ID_FIELD:
                return "id_vehicle";
            case VEHICLE_BRAND_FIELD:
                return "brand";
            case VEHICLE_TYPE_FIELD:
                return "type";
            case VEHICLE_HP_FIELD:
                return "horsepower";
            case VEHICLE_TS_FIELD:
                return "top_speed";
            case VEHICLE_IMG_FIELD:
                return "img";
            case VEHICLE_MODEL_FIELD:
                return "model";
            default:
                throw new RuntimeException("The required field does not exists in "+this.getClass()+"");
        }
    }
}
