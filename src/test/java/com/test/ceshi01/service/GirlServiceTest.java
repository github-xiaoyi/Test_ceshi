package com.test.ceshi01.service;

import com.test.ceshi01.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void getGirgById() throws Exception{
        Girl girl = girlService.getGirgById(16);
        Assert.assertEquals(new Integer(19),girl.getAge());
        Assert.assertEquals("张三",girl.getName());
    }
}