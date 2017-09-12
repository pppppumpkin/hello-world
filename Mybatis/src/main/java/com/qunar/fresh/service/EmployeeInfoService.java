package com.qunar.fresh.service;

import com.qunar.fresh.enums.WorkPlaceEnum;
import com.qunar.fresh.model.EmployeeInfo;
import com.qunar.fresh.enums.SexEnum;

import java.util.List;

/**
 * Created by liyingsong on 16-6-15.
 * 1、保存新入职的员工信息
 * 2、批量保存新入职的员工信息
 * 3、通过[员工编号] 查询员工信息
 * 4、根据组合查询条件：工作地点、性别、员工工号、查询员工信息（动态sql的使用)
 * 5、更新指定[员工工号]的[电话号码]
 * 6、删除已经离职的员工
 * 7、通过工作地点列表，分页查询员工信息
 */
public interface EmployeeInfoService {

    boolean insertEmployeeInfo(EmployeeInfo employeeInfo);

    boolean batchInsertEmployeeInfos(List<EmployeeInfo> employeeInfoList);

    EmployeeInfo queryEmployeeInfoByEmployeeId(Integer employeeId);

    List<EmployeeInfo> queryEmployeeInfoByCondition(List<WorkPlaceEnum> workPlaceEnumList,
                                                    List<SexEnum> sexEnumList, Integer employeeId);

    boolean updatePhoneNumberByEmployeeId(Integer employeeId, String phoneNumber);

    boolean deleteInactiveEmployeeInfo();

    List<EmployeeInfo> queryEmployeeInfoByWorkPlace(List<WorkPlaceEnum> workPlaceEnumList, int start, int size);
}
