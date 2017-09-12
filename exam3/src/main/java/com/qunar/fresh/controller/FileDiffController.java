package com.qunar.fresh.controller;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.qunar.fresh.model.DiffResultModel;
import com.qunar.fresh.service.FileDiffService;
import com.qunar.fresh.util.MyConverter;
import javafx.scene.control.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-6-17.
 */
@Controller
@RequestMapping("/file")
public class FileDiffController {
    private static Logger logger = LoggerFactory.getLogger(FileDiffController.class);

    @Resource
    FileDiffService fileDiffService;

    @RequestMapping("/diff")
    public String showFileDiffResult(HttpServletRequest request, int page, Map<String, Object> model) {
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
            }
        }
        List<DiffResultModel> diffResultModelList = fileDiffService.showDiffResultModelForPage((page-1)*5, 5);
        int size = fileDiffService.showDiffResultModel().size();
        logger.info("{}", size);
        model.put("diffResultModelList", diffResultModelList);
        request.setAttribute("page", page);
        request.setAttribute("size", size);
        request.setAttribute("username", username);
        return "file_diff";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFiles(HttpServletRequest request, @RequestParam("source")MultipartFile source,
                              @RequestParam("target")MultipartFile target ) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        if (Objects.equal(username, null)) {
            return "redirect:/user/login";
        }
        if (!source.isEmpty()&&!target.isEmpty()&&!Objects.equal(username, null)) {
            String sourceFileOriginalFilename = source.getOriginalFilename();
            String targetFileOriginalFilename = target.getOriginalFilename();
            InputStream sourceFileInputStream = source.getInputStream();
            InputStream targetFileInputStream = target.getInputStream();
            fileDiffService.diffFiles(MyConverter.inputStreamToFileModel(sourceFileInputStream, sourceFileOriginalFilename),
                    MyConverter.inputStreamToFileModel(targetFileInputStream, targetFileOriginalFilename), username);
        }
        return "redirect:diff?page=1";
    }

    @RequestMapping("/delete")
    public String deleteFileDiffResult(int id, String username) {
        fileDiffService.deleteDiffResultModel(id, username);
        return "redirect:diff?page=1";
    }
}
