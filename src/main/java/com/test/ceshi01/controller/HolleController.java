package com.test.ceshi01.controller;

import com.test.ceshi01.properties.GirlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HolleController {

    private final static Logger logger= LoggerFactory.getLogger(HolleController.class);

    @Autowired
    private GirlProperties girlProperties;

      /*
    @Value("${name}")
    private  String name;

    @Value("${age}")
    private Integer age;

    @Value("${allInformation}")
    private String allInformation;
    */
     //输出配置文件中Girl的属性信息
    @RequestMapping(value = "/showgirl")
     public String  showGirl(){
        logger.info("showGirl");
         return ("Girl_name:" + girlProperties.getName() + "," + "Girl_age:" + girlProperties.getAge());
     }

    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        logger.info("say");
        return "id:" + id;
    }

    //@RequestMapping(value = "/say1",method = RequestMethod.GET)
    @GetMapping(value = "/say1")
    public String say1(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id:" + id;
    }

}
