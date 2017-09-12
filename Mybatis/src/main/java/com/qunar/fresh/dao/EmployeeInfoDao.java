package com.qunar.fresh.dao;

import com.qunar.fresh.enums.SexEnum;
import com.qunar.fresh.enums.WorkPlaceEnum;
import com.qunar.fresh.model.EmployeeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-6-14.
 * 1、保存新入职的员工信息
 * 2、批量保存新入职的员工信息
 * 3、通过[员工编号] 查询员工信息
 * 4、根据组合查询条件：工作地点、性别、员工工号、查询员工信息（动态sql的使用)
 * 5、更新指定[员工工号]的[电话号码]
 * 6、删除已经离职的员工
 * 7、通过工作地点列表，分页查询员工信息
 */
public interface EmployeeInfoDao {

    int insertEmployeeInfo(EmployeeInfo employeeInfo);

    void batchInsertEmployeeInfos(List<EmployeeInfo> employeeInfoList);

    EmployeeInfo selectEmployeeInfoByEmployeeId(Integer employeeId);

    EmployeeInfo selectEmployeeInfoByQtalkId(String qtalkId);

    List<EmployeeInfo> selectEmployeeInfoByCondition(Map<String, Object> params);

    int updatePhoneNumberByEmployeeId(@Param("employeeId")Integer employeeId, @Param("phoneNumber")String phoneNumber);

    int deleteInactiveEmployeeInfo();

    List<EmployeeInfo> selectEmployeeInfoByWorkPlace(@Param("workPlaceEnumList") List<WorkPlaceEnum> workPlaceEnumList,
                       RowBounds rowBounds);
}
