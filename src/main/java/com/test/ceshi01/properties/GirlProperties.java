package com.test.ceshi01.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *实现配置文件中girl信息的管理，通过创建类并绑定属性处理
 * 调用时，@Autowired 类变量
 */

@Component  //标注类有spring管理
@ConfigurationProperties(prefix = "girl") //绑定属性，给类的变量绑定属性
public class GirlProperties {
    private String name;
    private Integer age;

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
}
