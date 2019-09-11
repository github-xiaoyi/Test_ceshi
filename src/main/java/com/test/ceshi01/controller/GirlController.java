package com.test.ceshi01.controller;

import com.test.ceshi01.entity.Girl;
import com.test.ceshi01.entity.Result;
import com.test.ceshi01.pository.GirlPository;
import com.test.ceshi01.service.GirlService;
import com.test.ceshi01.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlPository girlPository;

    @Autowired
    private GirlService girlService;

    //查询全部数据
    @RequestMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlPository.findAll();
    }

    //添加数据
    @PostMapping(value = "/add")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //return null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setName(girl.getName());
        girl.setAge(girl.getAge());
        return ResultUtil.success(0,girlPository.save(girl));
    }

    //查询单条数据
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlPository.findById(id).get();
    }

    //更新数据
    @PutMapping(value = "/update/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        return girlPository.save(girl);
    }

    //删除数据
    @DeleteMapping(value = "/delete/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlPository.deleteById(id);
    }

    //按年龄查询
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlPository.findByAge(age);
    }

    //插入2条数据
    @PostMapping(value = "/girls/two")
    public void addGirlTwo(){
        girlService.insertGirlTwo();
    }


    //获取girl信息，并对年龄判断
    @RequestMapping(value = "/gril/getage/{id}")
    public void getGrilAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getGrileAge(id);
    }

}
