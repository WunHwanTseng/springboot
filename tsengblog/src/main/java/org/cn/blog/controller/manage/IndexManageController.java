package org.cn.blog.controller.manage;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
@Controller
@PreAuthorize("hasRole('admin')")
public class IndexManageController {

    @GetMapping("/indexManage")
    public String index(){
        return "indexManage";
    }

}
