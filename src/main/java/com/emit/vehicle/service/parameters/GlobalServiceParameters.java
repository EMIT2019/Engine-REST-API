package com.emit.vehicle.service.parameters;

public enum GlobalServiceParameters {
    SMALL_RECORDS_AMOUNT,
    MEDIUM_RECORDS_AMOUNT,
    HUGE_RECORDS_AMOUNT;

    public Integer getValue(){
        switch (this){
            case SMALL_RECORDS_AMOUNT:
                return 10;
            case MEDIUM_RECORDS_AMOUNT:
                return 15;
            case HUGE_RECORDS_AMOUNT:
                return 30;
            default:
                return 0;
        }
    }
}
