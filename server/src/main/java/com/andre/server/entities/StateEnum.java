package com.andre.server.entities;

public enum StateEnum {

    ACTIVE(1, "Active"),
    DISCONTINUED(0, "Discontinued");

    Integer id;
    String valStr;

    private StateEnum(Integer id, String valStr) {
        this.id = id;
        this.valStr = valStr;
    }

    public Integer getId() {
        return id;
    }

    public String getValStr() {
        return valStr;
    }

    public static StateEnum getEnumFromId(Integer id) {
        for(StateEnum e : values()) {
            if(e.id.equals(id))
                return e;
        }
        return null;
    }

}