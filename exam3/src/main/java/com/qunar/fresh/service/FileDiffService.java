package com.qunar.fresh.service;

import com.qunar.fresh.model.DiffResultModel;
import com.qunar.fresh.model.FileModel;

import java.util.List;

/**
 * Created by liyingsong on 16-6-17.
 */
public interface FileDiffService {

    boolean addDiffResultModel(DiffResultModel resultModel);

    List<DiffResultModel> showDiffResultModelForPage(int start, int size);

    List<DiffResultModel> showDiffResultModel();

    boolean deleteDiffResultModel(int id, String username);

    public void diffFiles(FileModel sourceFile, FileModel targetFile, String userName);
}
