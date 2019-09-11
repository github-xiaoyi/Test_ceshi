package com.test.ceshi01.pository;

import com.test.ceshi01.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 实现数据管理，继承springboot的jpa
 */
public interface GirlPository extends JpaRepository<Girl,Integer> {
    //按年龄查询
    public List<Girl> findByAge(Integer age);

}
