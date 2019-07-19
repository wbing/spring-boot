package com.wenbing.demo.typehandler;

public enum GenderEnum {
    female(0,"女士"),male(1,"先生");
    private final int value;
    private final String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    GenderEnum(int value, String name){
        this.value=value;
        this.name=name;
    }
    public static GenderEnum getEnum(int value){
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if(value==genderEnum.getValue()){
                return genderEnum;
            }
        }
        return null;
    }
    public String toString(){
        return String.valueOf(this.value);
    }
}
