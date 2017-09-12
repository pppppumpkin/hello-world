package com.qunar.fresh.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by liyingsong on 16-6-15.
 */
public enum WorkPlaceEnum {
    UNKNOWN(0, "未知"), BEIJING(1, "北京"), DALIAN(2, "大连"), SHANGHAI(3, "上海");

    private int id;
    private String address;
    private static final Map<Integer, WorkPlaceEnum> map = Maps.newHashMapWithExpectedSize(3);

    static{
        for (WorkPlaceEnum workPlaceEnum : values()) {
            map.put(workPlaceEnum.getId(), workPlaceEnum);
        }
    }

    WorkPlaceEnum(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public int code() {
        return this.getId();
    }

    public static WorkPlaceEnum codeOf(int id) {
        return map.get(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
