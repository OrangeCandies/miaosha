package com.candy.secondskill.controller;

import com.candy.secondskill.domain.MiaoShaUser;
import com.candy.secondskill.redis.RedisServer;
import com.candy.secondskill.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisServer redisService;

    @RequestMapping("/to_list")
    public String list(Model model, MiaoShaUser user) {
        model.addAttribute("user", user);
        return "goods_list";
    }

}