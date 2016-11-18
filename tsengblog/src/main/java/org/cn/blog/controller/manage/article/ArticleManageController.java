package org.cn.blog.controller.manage.article;

import org.cn.blog.entity.Articletype;
import org.cn.blog.service.ArticleService;
import org.cn.blog.service.ArticleTypeService;
import org.cn.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
@Controller
@PreAuthorize("hasRole('admin')")
public class ArticleManageController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articletype")
    public String index(){
        return "articletype";
    }

    @GetMapping("/articleManage")
    public String articleManage() {
        return "articleManage";
    }

    @GetMapping("/articletype/ajaxCheckName")
    public void ajaxCheckName(@RequestParam("name") String name, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        int count = articleTypeService.selectArticleTypeCount(name);
        if (count == 0) {
            printWriter.print(true);
        } else {
            printWriter.print(false);
        }
    }

    @PostMapping("/articletype/add")
    public ModelAndView add(Articletype articletype){
        ModelAndView modelAndView = new ModelAndView();
        if (StringUtils.isNotBrank(articletype.getName())) {
            articleTypeService.insert(articletype);
            modelAndView.setViewName("redirect:/articletype");
        } else {
            modelAndView.addObject("title", "error");
            modelAndView.addObject("context", "");
            modelAndView.setViewName("redirect:/message");
        }
        return modelAndView;
    }

    @PostMapping("/articletype/update")
    public ModelAndView updateArticleType(Articletype articletype) {
        ModelAndView modelAndView = new ModelAndView("redirect:/articletype");
        System.out.println(articletype);
        articleTypeService.updateById(articletype);
        return modelAndView;
    }

    @GetMapping("/articleManage/vilock")
    public void articleVilock(@RequestParam("id") Integer id) {
        this.articleService.updateRecommend(id);
    }

    @GetMapping("/articletype/delete")
    public ModelAndView delete(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id > 0) {
            articleTypeService.deleteById(id);
            modelAndView.setViewName("redirect:/articletype");
        } else {
            modelAndView.addObject("title", "error");
            modelAndView.addObject("context", "");
            modelAndView.setViewName("redirect:/message");
        }
        return modelAndView;
    }

}
