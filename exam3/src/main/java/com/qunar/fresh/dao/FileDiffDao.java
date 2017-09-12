package com.qunar.fresh.dao;

import com.qunar.fresh.model.DiffResultModel;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by liyingsong on 16-6-17.
 */
public interface FileDiffDao {

    /**
     * 存储对比记录
     * @param resultModel
     * @return id
     */
    int insertDiffResultModel(DiffResultModel resultModel);

    /**
     * 分页搜索历史对比记录
     * @return
     */
    List<DiffResultModel> selectDiffResultModelForPageOrderByDiffTime(RowBounds rowBounds);

    /**
     * 搜索历史对比记录
     * @return
     */
    List<DiffResultModel> selectDiffResultModelOrderByDiffTime();

    /**
     * 根据id搜索对比记录
     * @param id
     * @return
     */
    DiffResultModel selectDiffResultModelById(int id);

    /**
     * 根据编号删除历史对比记录
     * @param id
     * @return
     */
    int deleteDiffResultModelById(int id);
}
