package com.test.ceshi01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","hello world!你好！");
        return "index";
    }

    @RequestMapping(value = "/index1")
    public ModelAndView index1(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("msg","helloworld!nihao");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
