package com.candy.secondskill.controller;

import com.candy.secondskill.domain.User;
import com.candy.secondskill.result.Result;
import com.candy.secondskill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private UserService userService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","liuhui");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> doGet(){
        User user = userService.getById(2);
        return Result.success(user);
    }

    @RequestMapping("db/tx")
    @ResponseBody
    public Result<Boolean> doTx(){
       boolean b =  userService.tx();
       return Result.success(b);
    }
}


