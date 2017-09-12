package com.qunar.fresh;

import com.google.common.collect.Lists;
import com.qunar.fresh.model.DiffResultModel;
import com.qunar.fresh.model.DiffResultModelBuilder;
import com.qunar.fresh.service.FileDiffService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liyingsong on 16-6-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class FileDiffServiceTest {
    private static Logger logger = LoggerFactory.getLogger(FileDiffServiceTest.class);

    @Resource
    FileDiffService fileDiffService;

    @Test
    public void testUddFileDiffResult() {
        DiffResultModel resultModel = DiffResultModelBuilder.aDiffResultModel().withUserName("lynn")
                .withSourceFile("a").withTargetFile("b").withResultFile("-a+b").build();
        boolean result = fileDiffService.addDiffResultModel(resultModel);
        Assert.assertTrue(result);
    }

    @Test
    public void testShowDiffResultModelForPage() {
        List<DiffResultModel> resultModelList = Lists.newArrayList();
        resultModelList = fileDiffService.showDiffResultModelForPage(1, 1);
        for (DiffResultModel diffResultModel : resultModelList) {

            logger.info("{}", diffResultModel);
        }
    }

    @Test
    public void testShowDiffResultModel() {
        List<DiffResultModel> diffResultModelList = Lists.newArrayList();
        diffResultModelList = fileDiffService.showDiffResultModel();
        logger.info("size = {}" + diffResultModelList.size());
        for (DiffResultModel diffResultModel : diffResultModelList) {
            logger.info("{}", diffResultModel);
        }
    }

    @Test
    public void testDeleteDiffResultModel() {
        boolean result = fileDiffService.deleteDiffResultModel(1, "");
        Assert.assertFalse(result);
    }
}
