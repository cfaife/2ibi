package com.twoibi.utils;

/**
 * @author Clerio Alfredo Faife
 */

public enum OrderKey {
    NO_ORDER,BY_NAME, BY_CAPITAL ,BY_REGION,  BY_SUBREGION ,BY_AREA;

    public static OrderKey parse(String orderKey){
        orderKey = orderKey.toUpperCase();
        switch (orderKey){
            case "NAME":
                return BY_NAME;
            case "CAPITAL":
                return BY_CAPITAL;
            case "REGION":
                return BY_REGION;
            case "SUBREGION":
                return BY_SUBREGION;
            case "AREA":
                return BY_AREA;

            default: return NO_ORDER;


        }
    }
}
