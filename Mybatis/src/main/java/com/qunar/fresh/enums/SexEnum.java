package com.qunar.fresh.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by liyingsong on 16-6-14.
 */
public enum SexEnum {
    FEMALE(0, "女"), MALE(1, "男"), SECRET(2, "保密");

    private int id;
    private String name;
    private static final Map<Integer, SexEnum> map = Maps.newHashMapWithExpectedSize(3);

    static {
        for (SexEnum sexEnum : values()) {
            map.put(sexEnum.getId(), sexEnum);
        }
    }

    private SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int code() {
        return this.getId();
    }

    public static SexEnum codeOf(int id) {
        return map.get(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
