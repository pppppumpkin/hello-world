package com.qunar.fresh;

import com.google.common.collect.Lists;
import com.qunar.fresh.enums.SexEnum;
import com.qunar.fresh.enums.WorkPlaceEnum;
import com.qunar.fresh.model.EmployeeInfo;
import com.qunar.fresh.model.EmployeeInfoBuilder;
import com.qunar.fresh.service.EmployeeInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyingsong on 16-6-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class EmployeeInfoServiceTest {
    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoServiceTest.class);

    @Resource
    private EmployeeInfoService employeeInfoService;

    @Test
    public void testInsertEmployeeInfo() {
        logger.info("testInsertEmployeeInfo");
        EmployeeInfo employeeInfo = EmployeeInfoBuilder.anEmployeeInfo().withEmployeeId(1003)
                .withQtalkId("yinmeng.wang").withEmployeeName("beauty").withPhoneNumber("23333")
                .withWorkPlaceEnum(WorkPlaceEnum.BEIJING).withSexEnum(SexEnum.FEMALE).withState(false).build();
        boolean result = employeeInfoService.insertEmployeeInfo(employeeInfo);
        Assert.assertTrue(result);
        employeeInfo = EmployeeInfoBuilder.anEmployeeInfo().withEmployeeId(1004)
                .withQtalkId("yinmeng.wang").withEmployeeName("beauty1").withPhoneNumber("23456789")
                .withWorkPlaceEnum(WorkPlaceEnum.BEIJING).withSexEnum(SexEnum.FEMALE).withState(false).build();
        result = employeeInfoService.insertEmployeeInfo(employeeInfo);
        Assert.assertFalse(result);
    }

    @Test
    public void testBatchInsertEmployeeInfos() {
        logger.info("testBatchInsertEmployeeInfos");
        List<EmployeeInfo> employeeInfoList = Lists.newArrayList();
        for (int i=0; i<10; i++) {
            EmployeeInfo employeeInfo = EmployeeInfoBuilder.anEmployeeInfo().withEmployeeId(2000+i)
                    .withQtalkId("batch."+i).withEmployeeName("batch"+i).withPhoneNumber("1300000000"+i)
                    .withWorkPlaceEnum(i%3==0?WorkPlaceEnum.BEIJING:i%3==1?WorkPlaceEnum.SHANGHAI:WorkPlaceEnum.DALIAN)
                    .withSexEnum(i%3==0?SexEnum.FEMALE:i%3==1?SexEnum.MALE:SexEnum.SECRET).withState(true).build();
            employeeInfoList.add(employeeInfo);
        }
        employeeInfoService.batchInsertEmployeeInfos(employeeInfoList);
    }

    @Test
    public void testQueryEmployeeInfoByEmployeeId() {
        logger.info("testQueryEmployeeInfoByEmployeeId");
        EmployeeInfo employeeInfo = employeeInfoService.queryEmployeeInfoByEmployeeId(2001);
        Assert.assertNotNull(employeeInfo);
    }

    @Test
    public void testQueryEmployeeInfoByCondition() {
        logger.info("testQueryEmployeeInfoByCondition");
        List<EmployeeInfo> employeeInfoList = employeeInfoService.queryEmployeeInfoByCondition(
                Lists.newArrayList(WorkPlaceEnum.DALIAN), null, null);
//                null, null, 2001);
        logger.info("result = {}", employeeInfoList);
    }

    @Test
    public void testUpdatePhoneNumberByEmployeeId() {
        logger.info("testUpdatePhoneNumberByEmployeeId");
        boolean result = employeeInfoService.updatePhoneNumberByEmployeeId(2000, "12345678901");
        Assert.assertTrue(result);
    }

    @Test
    public void testDeleteInactiveEmployeeInfo() {
        logger.info("testDeleteInactiveEmployeeInfo");
        boolean result = employeeInfoService.deleteInactiveEmployeeInfo();
        Assert.assertTrue(result);
    }

    @Test
    public void testQueryEmployeeInfoByWorkPlace() {
        logger.info("testQueryEmployeeInfoByWorkPlace");
        List<WorkPlaceEnum> workPlaceEnumList = Lists.newArrayList(WorkPlaceEnum.BEIJING, WorkPlaceEnum.SHANGHAI);
        List<EmployeeInfo> employeeInfoList = employeeInfoService.queryEmployeeInfoByWorkPlace(workPlaceEnumList, 1, 3);
        Assert.assertNotNull(employeeInfoList);
        logger.info("emplyeeInfoList.size = {}", employeeInfoList.size());
        for (EmployeeInfo employeeInfo : employeeInfoList) {
            logger.info("{}", employeeInfo);
        }
    }

}
