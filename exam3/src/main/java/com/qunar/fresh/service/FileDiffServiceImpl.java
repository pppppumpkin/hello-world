package com.qunar.fresh.service;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.qunar.fresh.dao.FileDiffDao;
import com.qunar.fresh.model.DiffResultModel;
import com.qunar.fresh.model.DiffResultModelBuilder;
import com.qunar.fresh.model.FileModel;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by liyingsong on 16-6-17.
 */
@Service
public class FileDiffServiceImpl implements FileDiffService {
    private static Logger logger = LoggerFactory.getLogger(FileDiffServiceImpl.class);

    @Resource
    FileDiffDao fileDiffDao;

    @Override
    public boolean addDiffResultModel(DiffResultModel resultModel) {
        int result = fileDiffDao.insertDiffResultModel(resultModel);
        if (!Objects.equal(result, null)) {
            return true;
        }
        return false;
    }

    @Override
    public List<DiffResultModel> showDiffResultModelForPage(int start, int size) {
        return fileDiffDao.selectDiffResultModelForPageOrderByDiffTime(new RowBounds(start, size));
    }

    @Override
    public List<DiffResultModel> showDiffResultModel() {
        return fileDiffDao.selectDiffResultModelOrderByDiffTime();
    }

    @Override
    public boolean deleteDiffResultModel(int id, String username) {
        //只能删除自己的对比记录
        if (Objects.equal(fileDiffDao.selectDiffResultModelById(id).getUserName(), username)) {
            fileDiffDao.deleteDiffResultModelById(id);
            return true;
        }
        return false;
    }

    @Override
    public void diffFiles(FileModel sourceFile, FileModel targetFile, String userName) {
        Map<String, String> sourceContent = sourceFile.getContent();
        Map<String, String> targetContent = targetFile.getContent();
        StringBuilder builder = new StringBuilder();
        Set<String> keySet = Sets.newConcurrentHashSet(sourceContent.keySet());
        keySet.addAll(targetContent.keySet());
        String sourceValue = null;
        String targetValue = null;
        for (String key : keySet) {
            sourceValue = sourceContent.get(key);
            targetValue = targetContent.get(key);
            if (Objects.equal(sourceValue, null)) {
                builder.append("+" + targetValue + ";");
            } else if (Objects.equal(targetValue, null)) {
                builder.append("-" + sourceValue + ";");
            } else if (!Objects.equal(sourceValue, targetValue)) {
                builder.append("-" + sourceValue + ";");
                builder.append("+" + targetValue + ";");
            }
        }
        String resultFileContent = builder.toString();
        DiffResultModel diffResultModel = DiffResultModelBuilder.aDiffResultModel().withUserName(userName)
                .withSourceFile(sourceFile.toString()).withTargetFile(targetFile.toString())
                .withResultFile(resultFileContent).build();
        addDiffResultModel(diffResultModel);
    }


}
