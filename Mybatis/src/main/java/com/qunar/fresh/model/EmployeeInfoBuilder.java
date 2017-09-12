package com.qunar.fresh.model;

import com.qunar.fresh.enums.SexEnum;
import com.qunar.fresh.enums.WorkPlaceEnum;

/**
 * Created by liyingsong on 16-6-15.
 */
public final class EmployeeInfoBuilder {
    private int id;
    private Integer employeeId;
    private String qtalkId;
    private String employeeName;
    private String phoneNumber;
    private WorkPlaceEnum workPlaceEnum;
    private SexEnum sexEnum;
    private boolean state;

    private EmployeeInfoBuilder() {
    }

    public static EmployeeInfoBuilder anEmployeeInfo() {
        return new EmployeeInfoBuilder();
    }

    public EmployeeInfoBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public EmployeeInfoBuilder withEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeInfoBuilder withQtalkId(String qtalkId) {
        this.qtalkId = qtalkId;
        return this;
    }

    public EmployeeInfoBuilder withEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public EmployeeInfoBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeeInfoBuilder withWorkPlaceEnum(WorkPlaceEnum workPlaceEnum) {
        this.workPlaceEnum = workPlaceEnum;
        return this;
    }

    public EmployeeInfoBuilder withSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
        return this;
    }

    public EmployeeInfoBuilder withState(boolean state) {
        this.state = state;
        return this;
    }

    public EmployeeInfo build() {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setId(id);
        employeeInfo.setEmployeeId(employeeId);
        employeeInfo.setQtalkId(qtalkId);
        employeeInfo.setEmployeeName(employeeName);
        employeeInfo.setPhoneNumber(phoneNumber);
        employeeInfo.setWorkPlaceEnum(workPlaceEnum);
        employeeInfo.setSexEnum(sexEnum);
        employeeInfo.setState(state);
        return employeeInfo;
    }
}
