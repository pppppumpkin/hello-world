package com.qunar.fresh.service;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.qunar.fresh.dao.EmployeeInfoDao;
import com.qunar.fresh.enums.SexEnum;
import com.qunar.fresh.enums.WorkPlaceEnum;
import com.qunar.fresh.model.EmployeeInfo;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-6-15.
 */
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoServiceImpl.class);

    @Resource
    private EmployeeInfoDao employeeInfoDao;

    @Override
    public boolean insertEmployeeInfo(EmployeeInfo employeeInfo) {
        if (Objects.equal(employeeInfoDao.selectEmployeeInfoByEmployeeId(employeeInfo.getEmployeeId()), null)
                && Objects.equal(employeeInfoDao.selectEmployeeInfoByQtalkId(employeeInfo.getQtalkId()), null)) {
            employeeInfoDao.insertEmployeeInfo(employeeInfo);
            return true;
        }
        return false;
    }

    @Override
    public boolean batchInsertEmployeeInfos(List<EmployeeInfo> employeeInfoList) {
        if (CollectionUtils.isEmpty(employeeInfoList)) {
            return false;
        }
        employeeInfoDao.batchInsertEmployeeInfos(employeeInfoList);
        return true;
    }

    @Override
    public EmployeeInfo queryEmployeeInfoByEmployeeId(Integer employeeId) {
        return employeeInfoDao.selectEmployeeInfoByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeInfo> queryEmployeeInfoByCondition(List<WorkPlaceEnum> workPlaceEnumList,
                                                           List<SexEnum> sexEnumList, Integer employeeId) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("workPlaceEnumList", workPlaceEnumList);
        params.put("sexEnumList", sexEnumList);
        params.put("employeeId", employeeId);
        return employeeInfoDao.selectEmployeeInfoByCondition(params);
    }

    @Override
    public boolean updatePhoneNumberByEmployeeId(Integer employeeId, String phoneNumber) {
        if (!Objects.equal(employeeInfoDao.selectEmployeeInfoByEmployeeId(employeeId), null)) {
            employeeInfoDao.updatePhoneNumberByEmployeeId(employeeId, phoneNumber);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteInactiveEmployeeInfo() {
        int result = employeeInfoDao.deleteInactiveEmployeeInfo();
//        if (result == 0) {
//            return false;
//        }
        return true;
    }

    @Override
    public List<EmployeeInfo> queryEmployeeInfoByWorkPlace(List<WorkPlaceEnum> workPlaceEnumList, int start, int size) {
        Preconditions.checkArgument(start >= 0 && size > 0);
        return employeeInfoDao.selectEmployeeInfoByWorkPlace(workPlaceEnumList, new RowBounds(start, size));
    }
}
