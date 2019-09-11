package com.test.ceshi01.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Girl对象实体类
 */

@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)//@GeneratedValue主键由事务管理
    //@GeneratedValue(strategy= GenerationType.IDENTITY)//主键由数据库管理
    private Integer id;

    @NotEmpty(message = "姓名不能为空！")
    @Column(length = 50)
    private String name;

    @Min(value = 18,message = "年龄不能小于18！")
    @NotNull(message = "年龄不能为空！")
    @Column(length = 20)
    private Integer age;

    public Girl() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
