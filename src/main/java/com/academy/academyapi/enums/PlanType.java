package com.academy.academyapi.enums;

import lombok.Getter;

@Getter
public enum PlanType {

    DAILY(1, "DIÁRIO"),
    MONTHLY(2, "MENSAL"),
    ANNUAL(3, "ANUAL");

    private final int value;
    private final String description;

    PlanType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static PlanType fromValue(int value){
        for (PlanType type : PlanType.values()){
            if (type.getValue() == value){
                return type;
            }
        }
        throw new RuntimeException("Unknown value: "+ value);
    }
}
