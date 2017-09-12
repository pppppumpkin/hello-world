package com.qunar.fresh.model;

import com.qunar.fresh.enums.SexEnum;
import com.qunar.fresh.enums.WorkPlaceEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by liyingsong on 16-6-14.
 */
public class EmployeeInfo {
    private int id;
    private Integer employeeId;
    private String qtalkId;
    private String employeeName;
    private String phoneNumber;
    private WorkPlaceEnum workPlaceEnum;
    private SexEnum sexEnum;
    private boolean state;

    public String getQtalkId() {
        return qtalkId;
    }

    public void setQtalkId(String qtalkId) {
        this.qtalkId = qtalkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNum) {
        this.phoneNumber = phoneNum;
    }

    public WorkPlaceEnum getWorkPlaceEnum() {
        return workPlaceEnum;
    }

    public void setWorkPlaceEnum(WorkPlaceEnum workPlaceEnum) {
        this.workPlaceEnum = workPlaceEnum;
    }

    public SexEnum getSexEnum() {
        return sexEnum;
    }

    public void setSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
