package com.test.ceshi01.service;

import com.test.ceshi01.entity.Girl;
import com.test.ceshi01.entity.Result;
import com.test.ceshi01.enums.Resultenum;
import com.test.ceshi01.exception.GirlException;
import com.test.ceshi01.pository.GirlPository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * girl业务层处理
 */

@Service(value = "girlservice")
public class GirlService {
    @Resource
    private GirlPository girlPository;

    //事务，必须同时执行成功（有一个执行失败，另一个执行执行成功自动回滚）
    // 实体类id 必须为@GeneratedValue(strategy=GenerationType.AUTO)数据库由事务管理
    @Transactional
    public void insertGirlTwo(){
        Girl girlA = new Girl();
        girlA.setName("one");
        girlA.setAge(31);
        girlPository.save(girlA);

        Girl girlB = new Girl();
        girlB.setName("two");
        girlB.setAge(32);
        //int a=1/0;
        girlPository.save(girlB);
    }

    //对获取的girl年龄进行业务判断
    public void getGrileAge(Integer id) throws Exception{
        Girl girl = girlPository.findById(id).get();
        int age = girl.getAge();
        if(age < 10){
            //age小于10，提示"你还在上小学吧"，code=100
            //此处Exception只能捕获message信息，不能捕获到code，所以需要创建自己的捕获异常类
            throw new GirlException(Resultenum.PRIMARY_SCHOOL);
        }else if (age >10 && age<16){
            //age大于10小于16，提示"你可能在上初中"，code=101
            throw  new GirlException(Resultenum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个Girl的信息
     * @param id
     * @return
     */
    public Girl getGirgById(Integer id){
        return girlPository.findById(id).get();
    }

}
