package com.kg.ws.web;

import com.kg.ws.domain.security.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by quanquan on 2017/6/21.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", new Msg("测试标题", "shadoubushuole", "只有管理员可见"));
        return "home";
    }
}
