package org.cn.blog.controller.json;

import org.cn.blog.entity.Articletype;
import org.cn.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/2.
 */
@RestController
public class ArticleTypeJsonController {
    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/article/articletypeList")
    public List<Articletype> articletypeList(){
        List<Articletype> list = articleTypeService.selectArticletypeList();
        return list;
    }

    @GetMapping("/articletype/ajaxSelect")
    public Articletype selectArticleTypeById(@RequestParam("id") Integer id) {
        Articletype articletype = articleTypeService.selectArticleTypeById(id);
        return articletype;
    }
}
